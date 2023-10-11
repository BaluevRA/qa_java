import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestLionSex {
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private Feline feline;

    private final String sex;
    private final boolean expected;

    public TestLionSex(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters( name = "{index}: sex={0}, hasMane={1}")
    public static Object[][] getHasMane() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
                {"", false}
        };
    }

    @Test
    public void shouldBeMane() {
        try {
            Lion lion = new Lion(sex, feline);
            boolean actual = lion.doesHaveMane();
            assertEquals(expected, actual);
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), "Используйте допустимые значения пола животного - самец или самка");
        }
    }
}

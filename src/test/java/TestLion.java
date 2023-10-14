import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestLion {

    @Mock
    private Feline feline;

    @Test
    public void checkGetKittens() throws Exception {
        Lion lion = new Lion("Самка", feline);

        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();

        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, feline.getKittens());
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void checkGetKittensNegative() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertNotEquals(3, feline.getKittens());
        Assert.assertNotEquals(3, lion.getKittens());
    }

    @Test
    public void checkLionEatMeat() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> food = List.of("Животные", "Птицы", "Рыба");

        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();

        Mockito.when(feline.eatMeat()).thenReturn(food);
        Assert.assertEquals(food, feline.eatMeat());
        Assert.assertEquals(food, lion.getFood());
    }

    @Test
    public void checkLionEatMeatNegative() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        List<String>  noFood = List.of("Неизвестный вид животного, используйте значение Травоядное или Хищник");

        Mockito.when(feline.eatMeat()).thenReturn(noFood);
        Assert.assertNotEquals(food, feline.eatMeat());
        Assert.assertNotEquals(food, lion.getFood());
    }
}


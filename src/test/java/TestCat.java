import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {

    @Mock
    private Feline feline;

    @Test
    public void checkCatEatMeat() throws Exception{
        Cat cat = new Cat(feline);
        List<String> food = List.of("Животные", "Птицы", "Рыба");

        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();

        Mockito.when(feline.eatMeat()).thenReturn(food);
        Assert.assertEquals(food, feline.eatMeat());
        Assert.assertEquals(food, cat.getFood());
    }

    @Test
    public void checkCatEatMeatNegative() throws Exception {
        Cat cat = new Cat(feline);
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        List<String>  noFood = List.of("Неизвестный вид животного, используйте значение Травоядное или Хищник");

        Mockito.when(feline.eatMeat()).thenReturn(noFood);
        Assert.assertNotEquals(food, feline.eatMeat());
        Assert.assertNotEquals(food, cat.getFood());
    }

    @Test
    public void checkSound() {
        Cat cat = new Cat(feline);

        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void checkSoundNegative() {
        Cat cat = new Cat(feline);

        Assert.assertNotEquals("Гав", cat.getSound());
    }
}

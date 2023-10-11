import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Random;

public class TestFeline {

    @Test
    public void checkEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> food = List.of("Животные", "Птицы", "Рыба");

        Assert.assertEquals(food, feline.eatMeat());
    }

    @Test
    public void checkEatMeatNegative() throws Exception {
        Feline feline = new Feline();
        List<String> food = List.of();

        Assert.assertNotEquals(food, feline.eatMeat());
    }

    @Test
    public void checkGetFamily() {
        Feline feline = new Feline();

        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void checkGetFamilyNegative() {
        Feline feline = new Feline();

        Assert.assertNotEquals("", feline.getFamily());
    }

    @Test
    public void checkGetKittens() {
        Feline feline = new Feline();

        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void checkGetKittensNegative() {
        Feline feline = new Feline();

        Assert.assertNotEquals(3, feline.getKittens());
    }

    @Test
    public void checkGetKittensCount() {
        Feline feline = new Feline();
        Random rand = new Random();
        int count = rand.nextInt(100);

        Assert.assertEquals(count, feline.getKittens(count));
    }
}

package bun;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunParameterizedTest {

    private String name;
    private float price;

    public BunParameterizedTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}: {1}")
    public static Object[][] getBuns() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988.025f},
                {"Краторная булка N-200i", 1255},
                {"Неподъемная", 0.001f},
                {"Огромная", -988}
        };
    }

    @Test
    public void checkBuns() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
        Assert.assertEquals(price, bun.getPrice(),0);
    }
}

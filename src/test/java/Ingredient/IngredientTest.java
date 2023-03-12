package Ingredient;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private final String EXPECTED_NAME = "test";
    private final float EXPECTED_PRICE = 3.34F;
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, EXPECTED_NAME, EXPECTED_PRICE);
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals("Цена неправильная", EXPECTED_PRICE, ingredient.getPrice(), 0);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Название не совпадает", EXPECTED_NAME, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        Assert.assertEquals("Название не совпадает", IngredientType.SAUCE, ingredient.getType());
    }
}
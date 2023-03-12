package Burger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    public Bun bun;
    Burger burger = new Burger();
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Spicy-x", 300);
    Ingredient ingredientTwo = new Ingredient(IngredientType.FILLING, "Отбивная", 450);

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(1, 0);
        System.out.println(burger.ingredients.size());
        assertEquals("FILLING", burger.ingredients.get(0).getType().toString());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }


    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTwo);
        Mockito.when(bun.getPrice()).thenReturn(125F);
        assertEquals(1000, burger.getPrice(), 0.1);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTwo);
        Mockito.when(bun.getName()).thenReturn("bun");
        assertTrue(burger.getReceipt().contains("750,000000"));
    }
}

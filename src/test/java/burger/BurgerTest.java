package burger;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    private final Burger burger = new Burger();
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredientSecond;
    @Mock
    Database database;
    private final List<Bun> buns = List.of(new Bun("grey bun", 100.50F));

    private final String bunName = "grey bun";
    @Before
    public void setDefaultBun() {
        Mockito.when(database.availableBuns()).thenReturn(buns);
    }

    @Test
    public void checkSetBuns() {
        burger.setBuns(database.availableBuns().get(0));
        assertEquals(bunName, burger.bun.getName());
    }

    @Test
    public void checkGetPrice() {
        Mockito.when(ingredient.getPrice()).thenReturn(125.5F);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(250F);
        burger.setBuns(database.availableBuns().get(0));
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
        float expectedBurgerPrice = 576.5F;
        assertEquals("Некорректная цена бургера с двумя добавленными ингредиентами", expectedBurgerPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.setBuns(bun);
        String expectedReceipt = burger.getReceipt();
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}

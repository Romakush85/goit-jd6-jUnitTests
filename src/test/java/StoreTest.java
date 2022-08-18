import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    @Test
    void testCalculateProductPriceWorksOkWithDiscountProduct() {
        //given
        Character productName = 'A';
        Long quantityToBuy = 5L;

        //when
        Double actualValue = Store.calculateProductPrice(productName, quantityToBuy);
        Double expectedValue = 5.5D;
        //then
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testCalculateProductPriceWorksOkWithNonDiscountProduct() {
        //given
        Character productName = 'B';
        Long quantityToBuy = 2L;

        //when
        Double actualValue = Store.calculateProductPrice(productName, quantityToBuy);
        Double expectedValue = 8.5D;
        //then
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testGetTotalPriceWorksOk() {
        //given
        String actualOrder = "ABDB A CA";
                //when
        Double actualValue = Store.getOrderPrice(actualOrder);
        Double expectedValue = 13.25D;
        //then
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testGetTotalPriceReturnsZeroForUnvalidOrder() {
        //given
        String actualOrder = "ABD43B A CA";
        //when
        Double actualValue = Store.getOrderPrice(actualOrder);
        Double expectedValue = 0D;
        //then
        assertEquals(expectedValue, actualValue);
    }
}
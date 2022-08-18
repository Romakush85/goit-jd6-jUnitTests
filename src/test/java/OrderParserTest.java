import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderParserTest {

    @Test
    void testIsOrderValidShouldReturnFalseForEmptyOrders() {
        //given
        String currentValue = "";
        //when
        boolean actualValue = OrderParser.isOrderValid(currentValue);
        //then
        assertFalse(actualValue);
    }

    @Test
    void testIsOrderValidShouldThrowsNPEForNull() {
        //given
        String currentValue = null;
        //when then
        assertThrows(NullPointerException.class, () -> OrderParser.isOrderValid(currentValue));
    }


    @Test
    void testIsOrderValidShouldReturnFalseForAbsentProducts() {
        //given
        String currentValue = " A BD eC";
        //when
        boolean actualValue = OrderParser.isOrderValid(currentValue);
        //then
        assertFalse(actualValue);
    }

    @Test
    void testIsOrderValidShouldReturnTrueForValidOrder() {
        //given
        String currentValue = " A BD C";
        //when
        boolean actualValue = OrderParser.isOrderValid(currentValue);
        //then
        assertTrue(actualValue);
    }

    @Test
    void testParseOrderReturnsValidMap() {
        //given
        String currentOrder = " CA BCD CB";
        //when
        Map<Character, Long> actualMap = OrderParser.parseOrder(currentOrder);
        Map<Character, Long> expectedMap = new HashMap<>();
        expectedMap.put('C', 3L);
        expectedMap.put('A', 1L);
        expectedMap.put('B', 2L);
        expectedMap.put('D', 1L);
        //then
        assertEquals(expectedMap, actualMap);
    }

    @Test
    void testParseOrderReturnsEmptyMapForUnvalidOrder() {
        //given
        String currentOrder = " CA BcD CB";
        //when
        Map<Character, Long> actualMap = OrderParser.parseOrder(currentOrder);
        Map<Character, Long> expectedMap = new HashMap<>();
        //then
        assertEquals(expectedMap, actualMap);
    }

}
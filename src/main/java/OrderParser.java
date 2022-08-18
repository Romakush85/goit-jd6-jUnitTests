import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;


public class OrderParser {

    static boolean isOrderValid(String order) {
        if(Objects.isNull(order)) {
            throw new NullPointerException("The order is null");
        }
        if (order.isEmpty() || order.isBlank()) {
            System.out.println("The order string is empty, pls enter the valid order");
            return false;
        }
        List<Character> prodNamesList = Product.getProductList().stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        List<Character> orderList = Arrays.stream(ArrayUtils.toObject(order.toCharArray()))
                .filter(c -> c != ' ')
                .collect(Collectors.toList());

        for (Character prodOrderName : orderList) {
            if (!prodNamesList.contains(prodOrderName)) {
                System.out.println("There are no  product <" + prodOrderName + "> in product list, pls enter a valid order");
                return false;
            }
        }
            return true;
    }

    static Map<Character, Long> parseOrder(String order) {
        if (isOrderValid(order)) {
            return Arrays.stream(ArrayUtils.toObject(order.toCharArray()))
                    .filter(c -> c != ' ')
                    .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        }

        return new HashMap<>();
    }
}

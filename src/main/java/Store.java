import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Store {

    public static Double getOrderPrice(String order) {
        Double totalPrice = 0D;
        Map<Character, Long> orderMap = OrderParser.parseOrder(order);
        for (Map.Entry<Character, Long> product : orderMap.entrySet()) {
            Double productPrice = calculateProductPrice(product.getKey(), product.getValue());
            totalPrice += productPrice;
        }
        return totalPrice;
    }

    static Double calculateProductPrice(Character productName, Long quantityToBuy) {
        Double productPrice = 0D;
        for (Product product : Product.getProductList()) {
            if(productName.equals(product.getName())) {
                if(Objects.isNull(product.getDiscountPrice())) {
                    productPrice = product.getPrice() * quantityToBuy;
                } else {
                    productPrice = Math.floor(quantityToBuy / product.getDiscountQuantity()) * product.getDiscountPrice() +
                            (quantityToBuy % product.getDiscountQuantity()) * product.getPrice();
                }
            }
        }
        return productPrice;
    }


}

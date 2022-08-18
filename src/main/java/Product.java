import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {
    private Character name;
    private Double price;
    private Integer discountQuantity;
    private Double discountPrice;

    private static List<Product> productList = new ArrayList<>();

    private static Product productA = new Product('A', 1.25D, 3, 3.0D);
    private static Product productB = new Product('B', 4.25D);
    private static Product productC = new Product('C', 1.0D, 6, 5.0D);
    private static Product productD = new Product('D', 0.75D);


    public static List<Product> getProductList() {
        return productList;
    }

    private boolean isPresent(Character name) {
        return productList.stream()
                .map(product -> product.getName())
                .anyMatch(n -> n.equals(name));
    }

    public Product(Character name, Double price) {
        if (!isPresent(name)) {
            this.name = name;
            this.price = price;
            productList.add(this);
        } else {
            System.out.println("The product with name " + name + " already exists.");
        }
    }

    public Product(char name, Double price, Integer discountQuantity, Double discountPrice) {
        if (!isPresent(name)) {
            this.name = name;
            this.price = price;
            this.discountQuantity = discountQuantity;
            this.discountPrice = discountPrice;
            productList.add(this);
        } else {
            System.out.println("The product with name " + name + " already exists.");
        }
    }

    public Character getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDiscountQuantity() {
        return discountQuantity;
    }

    public void setDiscountQuantity(Integer discountQuantity) {
        this.discountQuantity = discountQuantity;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name == product.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("price", price)
                .append("discountQuantity", discountQuantity)
                .append("discountPrice", discountPrice)
                .toString();
    }
}

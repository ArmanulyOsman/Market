import java.util.List;

public class Basket {
    private List<Integer> productsId;

    public Basket(List<Integer> productsId) {
        this.productsId = productsId;
    }

    public List<Integer> getProductsId() {
        return productsId;
    }

    public void setProductsId(List<Integer> productsId) {
        this.productsId = productsId;
    }
}

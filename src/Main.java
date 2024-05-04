import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Samsung s23", 400000, 4.8));
        products.add(new Product(2, "Iphone 15", 300000, 4.5));
        products.add(new Product(3, "Poco x3", 700000, 5.0));
        products.add(new Product(4, "HP pavillion", 400000, 4.8));
        products.add(new Product(5, "Macbook air", 300000, 4.5));
        products.add(new Product(6, "Asus tuf", 700000, 5.0));

        List<Integer> phones = new ArrayList<>();
        phones.add(1);
        phones.add(2);
        phones.add(3);

        List<Integer> laptops = new ArrayList<>();
        laptops.add(1);
        laptops.add(2);
        laptops.add(3);

        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Phones", phones));
        categories.add(new Category("Laptops", laptops));

        List<Integer> productsToBasket = new ArrayList<>(); // ИД продуктов
        productsToBasket.add(4); // В корзине товары с id 4, 2
        productsToBasket.add(2);
        Basket basket = new Basket(productsToBasket);

        List<User> users = new ArrayList<>();
        users.add(new User("User1", "Password1", basket));
        Scanner scanner = new Scanner(System.in);
        System.out.println("1: All products");
        System.out.println("2: Add user");
        System.out.println("3: Add product to basket");
        System.out.println("4: Products in basket");
        System.out.println("5: All categories");
        System.out.println("6: Products in category");
        int choice = scanner.nextInt();
        while (true){
            switch (choice){
                case 1:
                    for (Product product : products) {
                        System.out.println(product.toString());
                    }
                    break;
                case 2:
                    System.out.println("User name: ");
                    String name = scanner.nextLine();
                    System.out.println("User password: ");
                    String password = scanner.nextLine();

                    users.stream()
                            .filter(user -> user.getLogin().equals(name))
                            .findFirst()
                            .ifPresent(user -> System.out.println("Successfully authenticated"));
                    break;
                case 3:
                    System.out.println("Product id: ");
                    int id = scanner.nextInt();
                    productsToBasket.add(id);
                    System.out.println("Product added to basket");
                    break;
                case 4:
                    System.out.println(productsToBasket);
                    for (Integer i : productsToBasket) {
                        System.out.println(products.get(i - 1));
                    }
                    break;
                case 5:
                    System.out.println("All categorires: ");
                    for (Category category : categories) {
                        System.out.println(category);
                    }
                    break;
                case 6:
                    System.out.println("Category id: ");
                    int categoryId = scanner.nextInt();
                    for (Integer i : categories.get(categoryId - 1).getProducts()) {
                        System.out.println(products.get(i).toString());
                    }
                    break;
                default:
                    return;
            }
            choice= scanner.nextInt();
        }
    }
}
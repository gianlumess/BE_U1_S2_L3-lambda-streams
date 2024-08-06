import entities.Customer;
import entities.Order;
import entities.Product;
import enums.CategoryProduct;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static enums.CategoryProduct.*;

public class Main {
    public static void main(String[] args) {
        //CREO DEI CUSTOMERS
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Aldo", 1));
        customers.add(new Customer("Giovanni", 2));
        customers.add(new Customer("Giacomo", 3));

        //CREO DEI PRODOTTI
        List<Product> prodotti = new ArrayList<>();
        prodotti.add(new Product("Lord of The Rings", CategoryProduct.Books, 150));
        prodotti.add(new Product("Harry Potter e la pietra filosofale", CategoryProduct.Books, 12));
        prodotti.add(new Product("Passeggino", Baby, 120));
        prodotti.add(new Product("skateboard", Boys, 80));

        //CREO ORDINI
        List<Order> orders = new ArrayList<>();
        Order aldoOrder = new Order(customers.get(0));
        Order giovanniOrder = new Order(customers.get(1));
        Order giacomoOrder = new Order(customers.get(2));

        Product lordBook = prodotti.get(0);
        Product harryBook = prodotti.get(1);
        Product passeggino = prodotti.get(2);
        Product skate = prodotti.get(3);

        aldoOrder.addProduct(lordBook);
        aldoOrder.addProduct(harryBook);
        giovanniOrder.addProduct(harryBook);
        giovanniOrder.addProduct(skate);
        giacomoOrder.addProduct(passeggino);
        giacomoOrder.addProduct(lordBook);

        orders.add(aldoOrder);
        orders.add(giovanniOrder);
        orders.add(giacomoOrder);


        System.out.println("LISTA ORDINI: ");
        orders.forEach(System.out::println);


        //OTTENGO UNA LISTA DI PRODOTTI CHE APPARTENGONO ALLA CATEGORIA BOOKS ED HANNO UN PREZZO > 100
        System.out.println("*******************ESERCIZIO 1********************");
        System.out.println("OTTENGO UNA LISTA DI PRODOTTI CHE APPARTENGONO ALLA CATEGORIA BOOKS ED HANNO UN PREZZO > 100");
        List<Product> priceOver100Books = prodotti.stream().filter(element -> element.getCategory().equals(Books) && element.getPrice() > 100).toList();
        priceOver100Books.forEach(System.out::println);

        System.out.println("*******************ESERCIZIO 2********************");
        System.out.println("OTTENERE UNA LISTA DI ORDINI CON PRODOTTI CHE APPARTENGONO ALLA CATEGORIA 'BABY'");

        List<Order> babyOrders = orders.stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals(Baby))).toList();
        babyOrders.forEach(System.out::println);

        System.out.println("*******************ESERCIZIO 3********************");
        System.out.println("OTTENERE UNA LISTA DI PRODOTTI CHE APPARTENGONO ALLA CATEGORIA 'BOYS' ED APPLICARE UN 10% DI SCONTO AL LORO PREZZO");

        List<Product> boys10Discount = prodotti.stream().filter(product -> product.getCategory().equals(Boys)).map(product -> {
            product.setPrice(product.getPrice() * 0.90);
            return product;
        }).toList();

        boys10Discount.forEach(System.out::println);


        System.out.println("*******************ESERCIZIO 4********************");
        System.out.println("OTTENERE UNA LISTA DI PRODOTTI ORDINATI DA CLIENTI DI TIER 2 ");

        List<Order> tier2AndDates = orders.stream().filter(order -> order.getCustomer().getTier() == 2 && order.getOrderDate().isBefore(LocalDate.parse("2024-10-06")) && order.getOrderDate().isAfter(LocalDate.parse("2024-08-01"))).toList();
        List<Product> products2TierCustomers = new ArrayList<>();

        for (Order order : tier2AndDates) {
            products2TierCustomers.addAll(order.getProducts());
        }

        products2TierCustomers.forEach(System.out::println);
    }
}
import entities.Customer;
import entities.Order;
import entities.Product;
import enums.CategoryProduct;

import java.util.ArrayList;
import java.util.List;

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
        prodotti.add(new Product("Passeggino", CategoryProduct.Baby, 120));

        //CREO ORDINI
        List<Order> orders = new ArrayList<>();
        Order aldoOrder = new Order(customers.get(0));
        Order giovanniOrder = new Order(customers.get(1));
        Order giacomoOrder = new Order(customers.get(2));

        Product lordBook = prodotti.get(0);
        Product harryBook = prodotti.get(1);
        Product passeggino = prodotti.get(2);

        aldoOrder.addProduct(lordBook);
        aldoOrder.addProduct(harryBook);
        giovanniOrder.addProduct(harryBook);
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
        List<Product> priceOver100Books = prodotti.stream().filter(element -> element.getCategory().equals("Books") && element.getPrice() > 100).toList();
        priceOver100Books.forEach(System.out::println);

        System.out.println("*******************ESERCIZIO 2********************");
        System.out.println("OTTENERE UNA LISTA DI ORDINI CON PRODOTTI CHE APPARTENGONO ALLA CATEGORIA 'BABY'");


    }
}
import entities.Customer;
import entities.Product;

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
        prodotti.add(new Product("Lord of The Rings", "Books", 150));
        prodotti.add(new Product("Harry Potter e la pietra filosofale", "Books", 12));
        prodotti.add(new Product("Passeggino", "Baby", 120));


        //OTTENGO UNA LISTA DI PRODOTTI CHE APPARTENGONO ALLA CATEGORIA BOOKS ED HANNO UN PREZZO > 100

        List<Product> priceOver100Books = prodotti.stream().filter(element -> element.getCategory().equals("Books") && element.getPrice() > 100).toList();
        priceOver100Books.forEach(System.out::println);
    }
}
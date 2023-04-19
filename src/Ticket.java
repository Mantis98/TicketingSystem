import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Ticket {
    HashMap<String, Integer> city = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> purchasedTickets = new ArrayList<>();
    double price;
    int quantity;

    public Ticket() {
        city.put("Lodz", 12);
        city.put("Warsaw", 20);
        city.put("Gdansk", 15);
        city.put("Cracow", 30);


    }

    public void menu() {
        System.out.println("**************************");
        System.out.println("**   Ticketing system   **");
        System.out.println("**************************");
        System.out.println("** 1. Show destinations **");
        System.out.println("** 2. Buy Tickets       **");
        System.out.println("** 3. View your tickets **");
        System.out.println("** 4. Exit              **");
        System.out.println("**************************");
    }

    public void displayCities() {
        for (String i : city.keySet()) {
            System.out.print(i + ",\t");
            System.out.println("price: " + city.get(i) + " PLN.");
        }
    }

    public void buyTicket() {
        System.out.println("Where do you want to go?");
        String s = scanner.next();
        for (String i : city.keySet()) {
            if (s.equals(i)) {
                howMany();
                purchasedTickets.add(i);
                price = price + city.get(i) * quantity;
                System.out.println("Ticket purchased.");
            }
        }

    }

    public void purchasedTickets() {
        System.out.println(purchasedTickets + " x " + quantity);
        System.out.println("Price of your tickets: " + price + " PLN.");
    }

    public void howMany() {
        System.out.println("How many tickets you want to buy?");
        int q = scanner.nextInt();
        quantity = quantity + q;

    }

}

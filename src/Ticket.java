import java.util.HashMap;
import java.util.Scanner;

public class Ticket {
    Scanner scanner = new Scanner(System.in);
    HashMap<String, Integer> purchasedTickets = new HashMap<>();
    HashMap<String, Integer> cities = new HashMap<>();
    double price;
    int quantity;


    Ticket() {

        final Cities lodz = Cities.LODZ;
        final Cities warsaw = Cities.WARSAW;
        final Cities cracow = Cities.CRACOW;
        final Cities gdansk = Cities.GDANSK;

        cities.put(lodz.name(), 12);
        cities.put(warsaw.name(), 20);
        cities.put(gdansk.name(), 15);
        cities.put(cracow.name(), 30);

    }

    void menu() {
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
        for (String i : cities.keySet()) {
            System.out.print(i + ",\t");
            System.out.println("price: " + cities.get(i) + " PLN.");
        }
    }

    public void buyTicket() {
        System.out.println("Where do you want to go?");
        String s = scanner.next();
        boolean d = discount();
        for (String i : cities.keySet()) {
            if (s.equals(i.toLowerCase())) {
                howMany();
                if (!d) {
                    purchasedTickets.put(i, quantity);
                    price = price + cities.get(i) * quantity;
                } else if (d) {
                    purchasedTickets.put(i, quantity);
                    price = (price + cities.get(i) * quantity) * 0.8;
                }
            }
            quantity = 0;
        }

    }


    public void showPurchasedTickets() {
        if (price > 0) {
            for (String j : purchasedTickets.keySet()) {
                System.out.println(j + " quantity: " + purchasedTickets.get(j));
            }
            System.out.println("Price of your tickets: " + price + " PLN.");
        } else
            System.out.println("Your order is empty.");
    }


    private void howMany() {
        System.out.println("How many tickets you want to buy?");
        int q = scanner.nextInt();
        if (q != 0) {
            quantity = quantity + q;
            System.out.println("Ticket purchased.");
        } else
            System.out.println("You have to choose quantity.");

    }

    private boolean discount() {
        System.out.println("Do you have discount? y/n?");
        String dis = scanner.next();
        if (dis.equals("y")) {
            return true;
        } else
            return false;
    }

}
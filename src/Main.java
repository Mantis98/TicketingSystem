import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Ticket{
    public static void main(String[] args) {
        Scanner choice = new Scanner(System.in);
        Ticket t = new Ticket();


        while (true) {
            t.menu();
            try {
                switch (choice.nextInt()) {
                    case 1:
                        t.displayCities();
                        break;
                    case 2:
                        t.buyTicket();
                        break;
                    case 3:
                        t.showPurchasedTickets();
                        break;
                    case 4:
                        System.out.println("See you next time.");
                        System.exit(0);
                    default:
                        System.out.println("Incorrect number.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect type of data.");
                break;
            }
        }


    }


}



package MovieTicketBooking;
import java.util.*;
public class MovieTicketBooking {
	


	    boolean[][] seats = new boolean[5][5];

	    Scanner sc = new Scanner(System.in);

	    public void showAvailableSeats() {

	        System.out.println("Available Tickets");

	        for (int i = 0; i < seats.length; i++) {

	            for (int j = 0; j < seats[i].length; j++) {

	                if (seats[i][j] == false) {
	                    System.out.print("A ");
	                } else {
	                    System.out.print("B ");
	                }
	            }

	            System.out.println();
	        }
	    }

	    public void bookTicket() {

	        System.out.println("Enter the row 1-5:");
	        int row = sc.nextInt();

	        System.out.println("Enter the seat 1-5:");
	        int seat = sc.nextInt();

	        if (seats[row - 1][seat - 1] == false) {

	            seats[row - 1][seat - 1] = true;

	            System.out.println("Ticket booked successfully!");

	        } else {

	            System.out.println("Seat is already booked.");
	        }
	    }

	    public void cancelTicket() {

	        System.out.println("Enter Row Number:");
	        int row = sc.nextInt();

	        System.out.println("Enter the Seat:");
	        int seat = sc.nextInt();

	        if (seats[row - 1][seat - 1] == true) {

	            seats[row - 1][seat - 1] = false;

	            System.out.println("Seat was successfully canceled.");

	        } else {

	            System.out.println("Seat was not booked.");
	        }
	    }

	    public void discountCoupon() {

	        System.out.println("Enter Ticket Price:");
	        double price = sc.nextDouble();

	        System.out.println("Enter Coupon Code:");
	        String coupon = sc.next();

	        if (coupon.equals("MOVIE10")) {

	            double discount = price * 10 / 100;
	            double finalPrice = price - discount;

	            System.out.println("Discount: " + discount);
	            System.out.println("Final Price: " + finalPrice);

	        } else {

	            System.out.println("Invalid Coupon");
	            System.out.println("Final Price: " + price);
	        }
	    }

	    public void weekendPricing() {

	        System.out.println("Enter Ticket Price:");
	        double price = sc.nextDouble();

	        System.out.println("Is today weekend? (yes/no)");
	        String day = sc.next();

	        if (day.equalsIgnoreCase("yes")) {

	            double finalPrice = price + 50;

	            System.out.println("Weekend Price: " + finalPrice);

	        } else {

	            System.out.println("Normal Price: " + price);
	        }
	    }

	    public void movieRating() {

	        System.out.println("Enter Movie Rating (1-5):");
	        int rating = sc.nextInt();

	        if (rating >= 1 && rating <= 5) {

	            System.out.println(
	                    "Thank you for rating the movie: " + rating + "/5"
	            );

	        } else {

	            System.out.println(
	                    "Invalid rating. Please enter between 1 and 5."
	            );
	        }
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        MovieTicketBooking obj = new  MovieTicketBooking();

	        while (true) {

	            System.out.println("\n===== Movie Ticket Booking System =====");
	            System.out.println("1. Show Available Seats");
	            System.out.println("2. Book Ticket");
	            System.out.println("3. Cancel Ticket");
	            System.out.println("4. Discount Coupon");
	            System.out.println("5. Weekend Pricing");
	            System.out.println("6. Movie Rating");
	            System.out.println("7. Exit");

	            System.out.println("Enter your choice:");
	            int choice = sc.nextInt();

	            switch (choice) {

	                case 1:
	                    obj.showAvailableSeats();
	                    break;

	                case 2:
	                    obj.bookTicket();
	                    break;

	                case 3:
	                    obj.cancelTicket();
	                    break;

	                case 4:
	                    obj.discountCoupon();
	                    break;

	                case 5:
	                    obj.weekendPricing();
	                    break;

	                case 6:
	                    obj.movieRating();
	                    break;

	                case 7:
	                    System.out.println("Thank you!");
	                    return;

	                default:
	                    System.out.println("Invalid choice");
	            }
	        }
	    }
	}



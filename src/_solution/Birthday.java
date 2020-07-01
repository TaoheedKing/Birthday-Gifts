/**
* @fileName :Birthday.java
**/
package _solution;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 * @author Taoheed King Class: CMSC203 Program: Birthday Instructor: Professor
 *         Gringory Grinberg Description: (I calculate the Wind Chill based on
 *         the temp and wind speed entered by the user) Due: 07/05/2020 I pledge
 *         that I have completed the programming assignment independently. I
 *         have not copied the code from a student or any source. I have not
 *         given my code to any student. Print your Name here: Taoheed King
 */
public class Birthday {
	public static void main(String[] args) {
		//new ArrayList<>();
		String option = null;
		String name = "";
		int age = 0;
		String toyName = "";
		double orderTotal = 0.00;
		String card;
		String balloon;
		double tempCost = 0.00;
		ArrayList<String> toysBought = new ArrayList<>();

		// Keeps track of how many add on items bought
		int numOfCards = 0;
		int numOfBalloons = 0;

		/**
		 * created a toy object
		 */
		Toy toy = new Toy(toyName, age);

		/**
		 * Program begins
		 */

		// Display parameters for user
		JOptionPane.showMessageDialog(null,
				"Age Range:" + "\nplushie: 0 to 2 years" + "\nbook: 4 to 7 years" + "\nblocks: 3 to 5 years");
		// Ask user their name
		name = JOptionPane.showInputDialog("What is your name?");
		/**
		 * Repeats the entire program except for name if user decides to buy more items
		 */
		do {
			while (true) {

				// Enter the child age
				String temp = JOptionPane.showInputDialog("Enter the Child Age:");
				age = Integer.parseInt(temp);
				toyName = JOptionPane.showInputDialog("Enter the toy name:");
				/**
				 * If the user enters anything other than the toy names, it asks for them to
				 * re-enter a toy choice loop exits when they enter the correct input
				 */
				while (!(toyName.equalsIgnoreCase("plushie") || toyName.equalsIgnoreCase("book")
						|| toyName.equalsIgnoreCase("blocks"))) {
					toyName = JOptionPane.showInputDialog("Re-enter the toy name:");
				}

				// Once they enter the toy name, it is added to cart
				toy.setToy(toyName);
				toy.setAge(age);
				toy.setCost(toyName);
				/**
				 * if the age is inappropriate, they have a choice to cancel the toy or continue
				 */
				if (!(toy.ageOK())) {
					temp = JOptionPane.showInputDialog("Age is inappropriate. Do you want to cancel? (yes/no)");
					if (temp.equalsIgnoreCase("no")) {
						break;

					}
				} else {
					break;
				}
			}
			
			// Displays the cost of the toy on the receipt
			tempCost = toy.getCost();
			System.out.println("Toy cost: " + toy.getCost());

			/**
			 * If the age entered is not okay, it prompts for user to re-enter age exits
			 * loop when age is appropriate
			 */

			toysBought.add(toyName);

			// Add a card
			card = JOptionPane.showInputDialog("You want to add card? yes or no");
			/**
			 * If they say yes, it adds card to cart, and adds it to total number of cards
			 */
			if (card.equals("yes")) {
				numOfCards += 1;
				toy.addCard(card);
				// Adds a card and prints new total
				System.out.println("Added a card: " + toy.getCost());
			}

			// Add a balloon
			balloon = JOptionPane.showInputDialog("You want to add balloon? yes or no");
			/**
			 * Adds a balloon to cart and to the number of balloons bought
			 */
			if (balloon.equals("yes")) {
				numOfBalloons += 1;
				toy.addBalloon(balloon);
				// Displays cost after adding balloon
				System.out.println("Added a balloon: " + toy.getCost());
			}

			// Stores cost
			tempCost = toy.getCost();
			orderTotal += tempCost;
			// Ask if they want to buy more or check out
			option = JOptionPane.showInputDialog("Do you want to purchase More? yes or no:");
			if (option.equalsIgnoreCase("no")) {
				

				// ORDER TOTAL BEGINS HERE
				int orderId = 10000 + new Random().nextInt(90000);
				System.out.println("---------------------------------------------------------");
				System.out.println("Order Name : " + name);
				System.out.println("---------------------------------------------------------");
				System.out.println("Order Number : " + orderId);

				// Receipt starts here
				System.out.println("------------------------------ Your Order ------------------------------");

				/**
				 * If user decides to select a card and or balloon or neither, it prints the
				 * appropriate receipt for them Also prints the total amount of items bought
				 */
				if (card.equalsIgnoreCase("yes") && balloon.equalsIgnoreCase("yes")) {
					System.out.println("Order Add Ons: " + numOfCards + " " + " card(s)" + " and " + numOfBalloons
							+ " balloon(s).");
					System.out.println("Order Toys: ");
					/**
					 * loop to print out toys bought
					 */
					for (int i = 0; i < toysBought.size(); i++) {
						System.out.println(toysBought.get(i));
					}
				} else if (card.equalsIgnoreCase("yes")) {
					System.out.println("Order Add On: " + numOfCards + " card(s).");
					System.out.println("---------------------------------------------------------");
					System.out.println("Order items: ");
					/**
					 * loop to print out toys bought
					 */
					for (int i = 0; i < toysBought.size(); i++) {
						System.out.println(toysBought.get(i));
					}
				} else if (balloon.equalsIgnoreCase("yes")) {
					System.out.println("Order Add On: " + numOfBalloons + " balloon(s).");
					System.out.println("---------------------------------------------------------");
					System.out.println("Order items: ");
					/**
					 * loop to print out toys bought
					 */
					for (int i = 0; i < toysBought.size(); i++) {
						System.out.println(toysBought.get(i));
					}
				} else {
					System.out.println("Ordered items: ");
					/**
					 * loop to print out toys bought
					 */
					for (int i = 0; i < toysBought.size(); i++) {
						System.out.println(toysBought.get(i));
					}
					System.out.println("---------------------------------------------------------");
				}

				NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
				//System.out.println("US: " + );
				// Formats the order total into double
				System.out.print("Order total: " + defaultFormat.format(orderTotal));
				System.out.println("\n---------------------------------------------------------");
				System.out.println("Programmer: Taoheed King");
			} else {
				/**
				 * Seperates the previous order from the new one if user decides to add more
				 * items
				 */
				System.out.println("---------------------------------------------------------");
				System.out.println("Another Order: ");
				//tempCost = orderTotal;
			}
			
			//System.out.println("tempCost = " + tempCost);
			//System.out.println("orderTotal = " + orderTotal);
		} while (!option.equalsIgnoreCase("no"));

	}
}

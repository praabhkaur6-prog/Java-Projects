/**
 * 
 * @author Prabhjot Kaur
 * CS 212 - Project 3
 * File: Date212Main.java
 * Date: 1 December 2025
 * Date212Main
 *
 * This is the driver class for Project 3. It creates and displays the
 * Date212GUI window that will show the unsorted and sorted date lists.
 */
public class Date212Main {
   /** The GUI object used for displaying dates. */
   static Date212GUI date212GUI;

   /**
     * The main method that starts the program by creating
     * the Date212GUI window.
     * @param args Command line arguments (not used).
     */
   public static void main(String[] args) {
      date212GUI = new Date212GUI("My Date212 GUI", 600,300);
   }
}

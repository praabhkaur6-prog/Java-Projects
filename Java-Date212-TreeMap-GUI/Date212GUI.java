/**
 * 
 * @author prabhjot kaur
 * Date212GUI
 *
 * This class creates a GUI window with two text areas: one for
 * displaying unsorted Date212 objects and one for displaying
 * sorted Date212 objects. A File menu allows the user to open a file
 * and quit the application.
 */

import javax.swing.*;
import java.awt.*;
public class Date212GUI extends JFrame {

   /** Text area showing dates in the order they appear in the file. */
   JTextArea unsorted;

   /** Text area showing dates in sorted order. */
   JTextArea sorted;
   
   /**
     * Constructs the GUI window containing two text areas and a File menu.
     * @param title The title of the GUI window.
     * @param height The height of the GUI window. 
     * @param width The width of the GUI window.
     */
   public Date212GUI(String title, int height, int width) {
      setTitle(title);
      setSize(height, width);  
		setLocation  (400,200);
      createFileMenu();
	   setDefaultCloseOperation(EXIT_ON_CLOSE);

      unsorted = new JTextArea();
      sorted   = new JTextArea();

      setLayout(new GridLayout(1, 2));
      unsorted.setEditable(false);
      sorted.setEditable(false);
      
      add(new JScrollPane(unsorted));
      add(new JScrollPane(sorted));
		
      setVisible(true);
   } //SSNGUI

   /**
     * Creates the File menu with Open and Quit options,
     * and attaches the appropriate listeners.
     */

   private void createFileMenu( ) {
      JMenuItem item;
      JMenuBar menuBar = new JMenuBar();
      JMenu fileMenu = new JMenu("File");

      FileMenuHandler fmh  = new FileMenuHandler(this);

      item = new JMenuItem("Open");    //Open...
      item.addActionListener( fmh );
      fileMenu.add( item );

      fileMenu.addSeparator();           //add a horizontal separator line
    
      item = new JMenuItem("Quit");       //Quit
      item.addActionListener( fmh );
      fileMenu.add( item );

      setJMenuBar(menuBar);
      menuBar.add(fileMenu);
    
   } //createMenu

} //SSNGUI

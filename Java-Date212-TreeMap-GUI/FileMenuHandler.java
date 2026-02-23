/**
 *  @author: Prabhjot Kaur
 * CS 212 - Project 3
 * File: FileMenuHandler.java
 * Date: 1 December 2025
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Comparator;
//add tree maps
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

/*
 * Handles actions for the File menu in the Date212 GUI.
 * Supports opening a file containing Date212 strings and quitting the program.
 * When a file is opened, this class reads all dates, displays them unsorted,
 * and displays the sorted dates using a TreeMap.
 */
public class FileMenuHandler implements ActionListener {
   JFrame jframe;
   /**
     * Constructor for FileMenuHandler.
     *
     * @param jf the JFrame associated with this menu handler
     */
   public FileMenuHandler (JFrame jf) {
      jframe = jf;
   }
   /**
     * Responds to menu item selections for "Open" and "Quit".
     *
     * @param event the event triggered by clicking a menu item
     */
   public void actionPerformed(ActionEvent event) {
      String  menuName;
      menuName = event.getActionCommand();
      if (menuName.equals("Open"))
         openFile( );
      else if (menuName.equals("Quit"))
         System.exit(0);
   } //actionPerformed

   /**
     * Opens a file chooser allowing the user to select a file.
     * If a valid file is selected, readSource is called.
     */
    private void openFile( ) {
       JFileChooser chooser;
       int status;
       chooser = new JFileChooser( );
       status = chooser.showOpenDialog(null);
       if (status == JFileChooser.APPROVE_OPTION) 
          readSource(chooser.getSelectedFile());
       else 
          JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    } //openFile
  
  
  
    /**
     * Reads a selected file, extracts comma-separated Date212 strings,
     * validates them, prints unsorted dates on the left side,
     * and prints sorted dates on the right side using a TreeMap.
     *
     * @param chosenFile the file selected by the user
     */
	//In Module 2 We need to adjust this to take in dates from date212.txt
	//NEXT IMPORTANT STEP.
    private void readSource(File chosenFile) {
        JTextArea unsorted = ((Date212GUI) jframe).unsorted;
        JTextArea sorted = ((Date212GUI) jframe).sorted;

        // Use FULL path (fixes file not found)
        TextFileInput inFile = new TextFileInput(chosenFile.getPath());

        // Prepare GUI components

        // Clear existing text areas before loading new data
        unsorted.setText("");
        sorted.setText("");


        TreeMap<Date212, Void> date212Tree = new TreeMap<>(new Date212Comparator());

        String data = inFile.readLine();

        while (data != null) {

            // Split line by commas (file contains multiple dates per line)
            String[] dates = data.split(",");

            for (String dateString : dates) {

                dateString = dateString.trim();
                if (dateString.length() == 0) continue;

                try {
                    Date212 newDate = new Date212(dateString);

                    date212Tree.put(newDate, null);
                    unsorted.append(dateString + "\n");
                }
                catch (IllegalDate212Exception e) {
                    System.out.println("Invalid date: " + dateString + " — " + e.getMessage());
                }
            }
            data = inFile.readLine();
        }

        // Output sorted dates
        for (Map.Entry<Date212, Void> entry : date212Tree.entrySet()) {
           sorted.append(entry.getKey().toString() + "\n");
        }

        jframe.setVisible(true);
    }
}
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;

public class Date212GUI extends JFrame {

    public Date212GUI(String string) {
        // Set up the frame
        setTitle("Project 2 Date212 Lists");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2)); // one row, two columns

        // Text areas for unsorted and sorted dates
        JTextArea unsortedArea = new JTextArea();
        JTextArea sortedArea = new JTextArea();

        unsortedArea.setEditable(false); // user cannot type here
        sortedArea.setEditable(false);
        
        //add scrollbars
        add(new JScrollPane(unsortedArea));
        add(new JScrollPane(sortedArea));

        // Create unsorted and sorted linked lists
        UnsortedDate212List unsortedList = new UnsortedDate212List();
        SortedDate212List sortedList = new SortedDate212List();

        String fileName = "project2.txt"; // input file name
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");

                // Read each date on line
                while (st.hasMoreTokens()) {
                    String token = st.nextToken().trim();
                    if (!token.isEmpty()) {
                        //Add to unsorted list
                        Date212 date = new Date212(token);
                        unsortedList.add(date);

                        //Add to sorted list
                        Date212 dateCopy = new Date212(token);
                        sortedList.add(dateCopy);
                    }
                }
            }

            reader.close();

            // Display unsorted list (raw date strings)
            Date212Node node = unsortedList.first.next; // skip head node
            while (node != null) {
                unsortedArea.append(node.data.getOriginal() + "\n");
                node = node.next;
            }

            // Display sorted list (formatted)
            node = sortedList.first.next;
            while (node != null) {
                sortedArea.append(node.data.toString() + "\n");
                node = node.next;
            }

        } catch (IOException e) {
            // show error message
            unsortedArea.setText("Error reading file: " + e.getMessage());
        }

       setVisible(true);// Show the GUI
   }
}


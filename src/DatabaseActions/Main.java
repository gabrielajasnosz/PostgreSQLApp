package DatabaseActions;

import DatabaseActions.Client;
import DatabaseActions.ClientTableModel;

import static DatabaseActions.Client.*;
import static DatabaseActions.Charter.*;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;


public class Main {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://195.150.230.210:5434/";
    static final String USER = "2020_jasnosz_gabriela";
    static final String PASS = "32000";


    public static void returnTable(List<Client> clientsList, String title) {
        SwingUtilities.invokeLater(() -> {
            ClientTableModel model = new ClientTableModel(clientsList);
            JTable table = new JTable(model);

            JFrame frame = new JFrame();
            frame.add(new JScrollPane(table));
            frame.setLocation(0, 0);

            frame.setTitle(title);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

        });

    }


    public static void main(String[] args) {
        List<Client> clientsList = null;
        try {
            clientsList = getClients();
            returnTable(clientsList, "Clients List before update:");

            System.out.println("Modified Email is: " + updateEmail("user78@gmail.com", 1));
            clientsList = getClients();
            returnTable(clientsList, "Clients List after update: ");

            Charter newCharter = new Charter(166, 11, "[2023-08-21,2023-08-25]", 1);
            System.out.println("Insert status: " + addCharter(newCharter));


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

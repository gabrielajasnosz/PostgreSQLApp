package DatabaseActions;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
// import com.sun.rowset.*;

import static DatabaseActions.Main.JDBC_DRIVER;
import static DatabaseActions.Main.DB_URL;
import static DatabaseActions.Main.USER;
import static DatabaseActions.Main.PASS;

public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String pesel;
    private String login;
    private String password;
    private int address_id;
    Connection connection = null;


    public Client() {
    }

    public Client(int id_klienta, String imie, String nazwisko, String telefon, String email,String pesel,String login,String haslo,int id_adresu) {
        this.id = id_klienta;
        this.firstName = imie;
        this.lastName = nazwisko;
        this.phoneNumber = telefon;
        this.email = email;
        this.pesel =pesel;
        this.login = login;
        this.password = haslo;
        this.address_id=id_adresu;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public static List<Client> getClients() throws SQLException {

        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement stmt = null;
        ResultSet results = null;
        List<Client> clientsList = new ArrayList<>();

        try {
            Class.forName(JDBC_DRIVER);
            String query = "SELECT * FROM marina.klient";
            Statement statement = connection.createStatement();
            results = statement.executeQuery(query);


            while (results.next()) {
                Client row = new Client(results.getInt("id_klienta"), results.getString("imie"),results.getString("nazwisko"), results.getString("telefon"), results.getString("email"), results.getString("pesel"),results.getString("login"),results.getString("haslo"),results.getInt("id_adresu"));
                clientsList.add(row);
            }

        } catch (SQLException e) {
            System.err.println("Error SQL. Exception: " + e);
        } catch (Exception e) {
            System.err.println("Error. Exception: " + e);
        } finally {
            try {
                if (results != null && !results.isClosed()) {
                    results.close();
                }
                if (stmt != null && !stmt.isClosed()) {
                    stmt.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.setAutoCommit(true);
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error. Closing rs & stmt & connection. Exception: " + e);
            }
        }
        return clientsList;
    }
}

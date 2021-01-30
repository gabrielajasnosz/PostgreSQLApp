package DatabaseActions;

import java.sql.*;

import static DatabaseActions.Main.*;
import static DatabaseActions.Main.PASS;

public class Charter {


    @Override
    public String toString() {
        return "Charter{" +
                "yacht_id=" + yacht_id +
                ", client_id=" + client_id +
                ", charter_daterange='" + charter_daterange + '\'' +
                ", status_id=" + status_id +
                '}';
    }

    int yacht_id;
    int client_id;
    String charter_daterange;
    int status_id;


    public Charter(int yacht_id, int client_id, String charter_daterange, int status_id) {
        this.yacht_id = yacht_id;
        this.client_id = client_id;
        this.charter_daterange = charter_daterange;
        this.status_id = status_id;
    }


    public int getYacht_id() {
        return yacht_id;
    }

    public void setYacht_id(int yacht_id) {
        this.yacht_id = yacht_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getCharter_daterange() {
        return charter_daterange;
    }

    public void setCharter_daterange(String charter_daterange) {
        this.charter_daterange = charter_daterange;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }


    public static boolean addCharter_Yacht(Charter charter) {

        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            String sql = "INSERT INTO marina.czarter_jacht(id_jachtu,id_klienta,okres_czarteru,id_statusu_czarteru_jachtu) " +
                    "VALUES(?,?,?::daterange,?);";
            pstmt = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.FETCH_FORWARD);
            pstmt.clearParameters();
            pstmt.setInt(1, charter.getYacht_id());
            pstmt.setInt(2, charter.getClient_id());
            pstmt.setString(3, charter.getCharter_daterange());
            pstmt.setInt(4, charter.getStatus_id());


            pstmt.executeUpdate();
            connection.commit();


        } catch (SQLException e) {
            System.err.println("Error SQL. Exception: " + e);
            return false;
        } catch (Exception e) {
            System.err.println("Error. Exception: " + e);
            return false;
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error. Closing rs & stmt & connection. Exception: " + e);
                return false;
            }
        }
        return true;
    }

    public static boolean addCharter(Charter charter) {

        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            String sql = "INSERT INTO marina.czarter(id_klienta,okres_czarteru) " +
                    "VALUES(?,?::daterange);";
            pstmt = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.FETCH_FORWARD);
            pstmt.clearParameters();
            pstmt.setInt(1, charter.getClient_id());
            pstmt.setString(2, charter.getCharter_daterange());


            pstmt.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            System.err.println("Error SQL. Exception: " + e);
            return false;
        } catch (Exception e) {
            System.err.println("Error. Exception: " + e);
            return false;
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed()) {
                    pstmt.close();
                }
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                    addCharter_Yacht(charter);
                }
            } catch (Exception e) {
                System.out.println("Error. Closing rs & stmt & connection. Exception: " + e);
                return false;
            }
        }
        return true;
    }




}

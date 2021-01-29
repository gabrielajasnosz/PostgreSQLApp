package DatabaseActions;

import DatabaseActions.Client;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClientTableModel extends AbstractTableModel
{
    private final List<Client> clientList;

    private final String[] columnNames = new String[] {
            "ID", "Imię", "Nazwisko", "Telefon", "Email", "Pesel", "Login","Haslo","id_adresu"
    };

    private final Class[] columnClass = new Class[] {
            Integer.class, String.class, String.class, String.class, String.class, String.class, String.class,String.class,Integer.class
    };

    public ClientTableModel(List<Client> employeeList)
    {
        this.clientList = employeeList;
    }

    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    @Override
    public int getRowCount()
    {
        return clientList.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Client row = clientList.get(rowIndex);
        if(0 == columnIndex) {
            return row.getId();
        }
        else if(1 == columnIndex) {
            return row.getFirstName();
        }
        else if(2 == columnIndex) {
            return row.getLastName();
        }
        else if(3 == columnIndex) {
            return row.getPhoneNumber();
        }
        else if(4 == columnIndex) {
            return row.getEmail();
        }
        else if(5 == columnIndex) {
            return row.getPesel();
        }
        else if(6 == columnIndex) {
            return row.getLogin();
        }
        else if(7 == columnIndex) {
            return row.getPassword();
        }
        else if(8 == columnIndex) {
            return row.getAddress_id();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        Client row = clientList.get(rowIndex);
        if(0 == columnIndex) {
            row.setId((Integer) aValue);
        }
        else if(1 == columnIndex) {
            row.setFirstName((String) aValue);
        }
        else if(2 == columnIndex) {
            row.setLastName((String) aValue);
        }
        else if(3 == columnIndex) {
            row.setPhoneNumber((String) aValue);
        }
        else if(4 == columnIndex) {
            row.setEmail((String) aValue);
        }
        else if(5 == columnIndex) {
            row.setPesel((String) aValue);
        }
        else if(6 == columnIndex) {
            row.setLogin((String) aValue);
        }
        else if(7 == columnIndex) {
            row.setPassword((String) aValue);
        }
        else if(8 == columnIndex) {
            row.setAddress_id((Integer) aValue);
        }
    }

}

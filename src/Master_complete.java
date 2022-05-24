import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Master_complete extends JFrame {

    JFrame frameMaster_complete;
    JTable datatable;
    JButton completed;
    JScrollPane jscrlp;
    int number = 0;

    public Master_complete() throws SQLException {
        frameMaster_complete = new JFrame();
        frameMaster_complete.setTitle("Чек лист мастера СНГиСН");
        frameMaster_complete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMaster_complete.setSize(1024, 768);
        frameMaster_complete.setLocationRelativeTo(null);
        frameMaster_complete.setResizable(false);
        frameMaster_complete.setLayout(null);

        completed = new JButton("Завершить");
        completed.setBounds(500, 20, 100, 50);
        completed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String[] query = {null};
                Date curdate = new Date();
                SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
                number = (int)datatable.getValueAt(datatable.getSelectedRow(),0);
                query[0] = "UPDATE tasks SET date_end = '" + formatForDateNow.format(curdate) + "', completed = 1 WHERE id = " + number + ";";
                System.out.println(query[0]);
                DBConnection.exequery(query[0]);
                System.out.println(number);
                frameMaster_complete.setVisible(false);
                try {
                    new Master_complete();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        frameMaster_complete.add(completed);
        list_task();
        frameMaster_complete.add(jscrlp);
        frameMaster_complete.setVisible(true);
    }

    public JScrollPane list_task() throws SQLException {
        Vector columnsHeader = new Vector();
        columnsHeader.add("Номер");
        columnsHeader.add("Объект");
        columnsHeader.add("Мастер");
        columnsHeader.add("Слесарь1");
        columnsHeader.add("Слесарь2");
        columnsHeader.add("Дата выдачи");
        columnsHeader.add("Дата завершения");
        columnsHeader.add("Завершен");

        Vector result = new Vector();
        int e1;
        String e2, e3, e4, e5, e6, e7, e8;

        ResultSet ress = DBConnection.getdatabase("SELECT id, object, master, locksmith_one, locksmith_two, date_start, date_end, completed FROM `tasks` ORDER BY completed;");
        while (ress.next()) {
            Vector element = new Vector();
            e1 = ress.getInt("id");
            e2 = ress.getString("object");
            e3 = ress.getString("master");
            e4 = ress.getString("locksmith_one");
            e5 = ress.getString("locksmith_two");
            e6 = ress.getString("date_start");
            e7 = ress.getString("date_end");
            e8 = ress.getString("completed");
            element.add(e1);
            element.add(e2);
            element.add(e3);
            element.add(e4);
            element.add(e5);
            element.add(e6);
            element.add(e7);
            element.add(e8);
            result.add(element);
        }

        datatable = new JTable(result, columnsHeader);

        jscrlp = new JScrollPane(datatable);
        jscrlp.setBounds(40, 100, 900, 600);

        return jscrlp;
    }

}

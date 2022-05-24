import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Worker extends JFrame {

    JFrame frameWorker;
    JTable datatable;
    JButton begin;
    JScrollPane jscrlp;
    int number = 0;

    public Worker() throws SQLException {
        frameWorker = new JFrame();
        frameWorker.setTitle("Чек лист рабочего СНГиСН");
        frameWorker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameWorker.setSize(1024, 768);
        frameWorker.setLocationRelativeTo(null);
        frameWorker.setResizable(false);
        frameWorker.setLayout(null);

        begin = new JButton("Начать");
        begin.setBounds(500, 20, 100, 50);
        begin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                number = (int)datatable.getValueAt(datatable.getSelectedRow(),0);
                System.out.println(number);
                frameWorker.setVisible(false);
                new Worker_task(number);
            }
        });

        frameWorker.add(begin);
        list_task();
        frameWorker.add(jscrlp);
        frameWorker.setVisible(true);

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

        ResultSet ress = DBConnection.getdatabase("SELECT id, object, master, locksmith_one, locksmith_two, date_start, date_end, completed FROM `tasks` WHERE completed = 0;");
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

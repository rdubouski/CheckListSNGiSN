import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Worker_task extends JFrame {

    JFrame frameWorker_task;
    JButton next;
    JLabel ltext;
    JTextPane text;
    JComboBox check;
    JLabel lnote;
    JTextPane note;
    int i = 1;

    public Worker_task(int number) {
        frameWorker_task = new JFrame();
        frameWorker_task.setTitle("Чек лист рабочего СНГиСН");
        frameWorker_task.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameWorker_task.setSize(850, 400);
        frameWorker_task.setLocationRelativeTo(null);
        frameWorker_task.setResizable(false);
        frameWorker_task.setLayout(null);

        ltext = new JLabel();
        ltext.setBounds(10, 30, 100, 20);
        ltext.setText("Вопрос");

        text = new JTextPane();
        text.setBounds(10, 80, 300, 200);
        text.setText("Перед открытием двери убедиться в отсутствии открытого огня, посторонних людей в радиусе 10 метров от ГРП, ШРП.");

        String[] items = new String[2];
        items[0] = "нет";
        items[1] = "да";
        check = new JComboBox(items);
        check.setBounds(350, 150, 100, 30);

        lnote = new JLabel();
        lnote.setBounds(500, 30, 100, 20);
        lnote.setText("Примечание");

        note = new JTextPane();
        note.setBounds(500, 80, 300, 200);
        note.setText("");

        Date curdate = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        ResultSet res;
        res = DBConnection.getdatabase("SELECT name FROM questions;");
        try {
            res.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        final String[] query = {null};

        next = new JButton("Дальше");
        next.setBounds(350, 20, 100, 50);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i <= 18) {
                    query[0] = "UPDATE tasks SET q" + i + " = '" + check.getSelectedItem() + "', note" + i + " = '" + note.getText() + "' WHERE id = " + number + ";";
                    System.out.println(query[0]);
                    DBConnection.exequery(query[0]);
                    i++;
                    check.setSelectedIndex(0);
                    note.setText("");
                    if (i != 19) {
                        try {
                            res.next();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            text.setText(res.getString("name"));
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Готово",
                                "Чек лист СНГиСН",
                                JOptionPane.INFORMATION_MESSAGE);
                        frameWorker_task.dispose();
                        System.exit(0);
                    }
                }
            }
        });

        frameWorker_task.add(ltext);
        frameWorker_task.add(lnote);
        frameWorker_task.add(text);
        frameWorker_task.add(check);
        frameWorker_task.add(note);
        frameWorker_task.add(next);
        frameWorker_task.setVisible(true);
    }
}

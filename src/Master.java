import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Master extends JFrame {

    JFrame frameMaster;
    JTextField date;
    JLabel ldate;
    JComboBox object;
    JLabel lobject;
    JComboBox equipment;
    JLabel lequipment;
    JComboBox team;
    JLabel lteam;
    JComboBox teamMaster;
    JLabel lteamMaster;
    JButton save;
    JButton cancel;

    public Master() throws SQLException {
        frameMaster = new JFrame();
        frameMaster.setTitle("Чек лист мастера СНГиСН");
        frameMaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMaster.setSize(640, 320);
        frameMaster.setLocationRelativeTo(null);
        frameMaster.setResizable(false);
        frameMaster.setLayout(null);

        Date curdate = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");

        ldate = new JLabel();
        ldate.setBounds(50, 30, 100, 20);
        ldate.setText("Дата");
        date = new JTextField();
        date.setBounds(50, 50, 100, 30);
        date.setText(formatForDateNow.format(curdate));

        lobject = new JLabel();
        lobject.setBounds(200, 30, 100, 20);
        lobject.setText("Объект");
        ResultSet res;
        res = DBConnection.getdatabase("SELECT name FROM objects;");
        String[] itemsobjects = new String[4];
        int i = 0;
        while (res.next()) {
            itemsobjects[i] = res.getString("name");
            i++;
        }
        object = new JComboBox(itemsobjects);
        object.setBounds(200, 50, 100, 30);

        lequipment = new JLabel();
        lequipment.setBounds(350, 30, 150, 20);
        lequipment.setText("Оборудование");
        String[] itemsequipment = {
                "Газоиндикатор",
                "Газоанализатор"
        };
        equipment = new JComboBox(itemsequipment);
        equipment.setBounds(350, 50, 150, 30);

        lteamMaster = new JLabel();
        lteamMaster.setBounds(50, 80, 100, 20);
        lteamMaster.setText("Мастер");
        res = DBConnection.getdatabase("SELECT id_position, fio FROM login;");
        String[] itemsteamMaster = new String[2];
        i = 0;
        while (res.next()) {
            if (res.getInt("id_position") == 1) {
                itemsteamMaster[i] = res.getString("fio");
                i++;
            }
        }

        teamMaster = new JComboBox(itemsteamMaster);
        teamMaster.setBounds(50, 100, 100, 30);

        lteam = new JLabel();
        lteam.setBounds(200, 80, 100, 20);
        lteam.setText("Бригада");
        res = DBConnection.getdatabase("SELECT id_position, fio FROM login;");
        String[] itemsteam = new String[2];
        i = 0;
        while (res.next()) {
            if (res.getInt("id_position") == 2) {
                itemsteam[i] = res.getString("fio");
                i++;
            }
        }
        team = new JComboBox(itemsteam);
        team.setBounds(200, 100, 100, 30);

        final String[] query = {null};
        save = new JButton("Создать");
        save.setBounds(50, 200, 100, 50);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                query[0] = "INSERT INTO tasks (object, master, locksmith_one, date_start) VALUE ('" + object.getSelectedItem() + "', '" + teamMaster.getSelectedItem() + "', '" + team.getSelectedItem() + "', '" + date.getText() + "');";
                System.out.println(query[0]);
                DBConnection.exequery(query[0]);
                JOptionPane.showMessageDialog(null,
                        "Сохранено",
                        "Чек лист СНГиСН",
                        JOptionPane.INFORMATION_MESSAGE);
                frameMaster.setVisible(false);
                new Master_menu();
            }
        });

        cancel = new JButton("Отмена");
        cancel.setBounds(200, 200, 100, 50);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMaster.setVisible(false);
                new Master_menu();
            }
        });

        frameMaster.add(ldate);
        frameMaster.add(lobject);
        frameMaster.add(lequipment);
        frameMaster.add(lteam);
        frameMaster.add(lteamMaster);
        frameMaster.add(date);
        frameMaster.add(object);
        frameMaster.add(equipment);
        frameMaster.add(teamMaster);
        frameMaster.add(team);
        frameMaster.add(save);
        frameMaster.add(cancel);
        frameMaster.setVisible(true);
    }

}

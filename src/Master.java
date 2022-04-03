import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Master extends JFrame {

    JFrame frameMaster;
    JTextField date;
    JLabel ldate;
    JComboBox object;
    JLabel lobject;
    JComboBox equipment;
    JLabel lequipment;
    JList team;
    JLabel lteam;
    JComboBox teamMaster;
    JLabel lteamMaster;
    JCheckBox result;
    JButton save;
    JButton cancel;

    public Master() {
        frameMaster = new JFrame();
        frameMaster.setTitle("Чек лист мастера СНГиСН");
        frameMaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMaster.setSize(640, 320);
        frameMaster.setLocationRelativeTo(null);
        frameMaster.setResizable(false);
        frameMaster.setLayout(null);

        ldate = new JLabel();
        ldate.setBounds(50, 30, 100, 20);
        ldate.setText("Дата");
        date = new JTextField();
        date.setBounds(50, 50, 100, 30);

        lobject = new JLabel();
        lobject.setBounds(200, 30, 100, 20);
        lobject.setText("Объект");
        String[] itemsobjects = {
                "ШРП 1",
                "ШРП 2",
                "ШРП 3",
                "ГРП 1",
                "ГРП 2",
                "ГРП 3"
        };
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
        String[] itemsteamMaster = {
                "Клыбик С.И.",
                "Лахт И.И."
        };
        teamMaster = new JComboBox(itemsteamMaster);
        teamMaster.setBounds(50, 100, 100, 30);

        lteam = new JLabel();
        lteam.setBounds(200, 80, 100, 20);
        lteam.setText("Бригада");
        String[] itemsteam = {
                "Святненко",
                "Шук",
                "Батов"
        };
        team = new JList(itemsteam);
        team.setBounds(200, 100, 100, 100);

        result = new JCheckBox("Выполнено");
        result.setBounds(300, 100, 100, 20);

        save = new JButton("Сохранить");
        save.setBounds(50, 200, 100, 50);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Сохранено",
                        "Чек лист СНГиСН",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        cancel = new JButton("Отмена");
        cancel.setBounds(200, 200, 100, 50);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMaster.setVisible(false);
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
        frameMaster.add(result);
        frameMaster.add(save);
        frameMaster.add(cancel);
        frameMaster.setVisible(true);
    }

}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Master_menu extends JFrame{
    JFrame frameMaster_menu;
    JButton create;
    JButton completed;

    public Master_menu() {
        frameMaster_menu = new JFrame();
        frameMaster_menu.setTitle("Чек лист мастера СНГиСН");
        frameMaster_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMaster_menu.setSize(150, 200);
        frameMaster_menu.setLocationRelativeTo(null);
        frameMaster_menu.setResizable(false);
        frameMaster_menu.setLayout(null);

        create = new JButton("Создать");
        create.setBounds(10, 10, 100, 50);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMaster_menu.setVisible(false);
                try {
                    new Master();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        completed = new JButton("Завершить");
        completed.setBounds(10, 80, 100, 50);
        completed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameMaster_menu.dispose();
                System.exit(0);
            }
        });

        frameMaster_menu.add(create);
        frameMaster_menu.add(completed);
        frameMaster_menu.setVisible(true);
    }
}

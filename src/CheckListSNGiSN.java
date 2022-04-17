import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CheckListSNGiSN {
    public static void main(String[] args) {

        String userName,password,url,driver;
        Connection con;
        Statement st;

        userName="base_user";
        password="base_pass";
        url="jdbc:mariadb://192.168.100.2:3306/check_list_sngisn";
        driver="org.mariadb.jdbc.Driver";
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url, userName, password);
            st=con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT name, address FROM objects;");
            while (resultSet.next()) {
                String val1 = resultSet.getString(1); // by column index
                String val2 = resultSet.getString(2); // by column index
                System.out.println(val1 + "   " + val2);
                // ... use val1 and val2 ...
            }
            System.out.println("Connection is successful");
        } catch (Exception e) {
            e.printStackTrace();
        }






        JFrame mainFrame;
        JButton buttonMaster;
        JButton buttonWorker;

        mainFrame = new JFrame();
        mainFrame.setTitle("Чек лист СНГиСН");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 200);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);

        buttonMaster = new JButton("Мастер");
        buttonMaster.setBounds(50, 50, 100, 50);
        buttonMaster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                new Master();
            }
        });
        buttonWorker = new JButton("Рабочий");
        buttonWorker.setBounds(200, 50, 100, 50);
        buttonWorker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "В разработке!",
                        "Чек лист СНГиСН",
                        JOptionPane.INFORMATION_MESSAGE);
                //mainFrame.setVisible(false);
                //new Worker();
            }
        });

        mainFrame.add(buttonMaster);
        mainFrame.add(buttonWorker);
        mainFrame.setVisible(true);
    }
}

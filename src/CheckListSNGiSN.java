import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CheckListSNGiSN {
    public static void main(String[] args) throws SQLException {
        new Master_menu();
        /*final ResultSet[] res = {null};
        final String[] slogin = {null};
        final String[] spass = {null};

        JFrame mainFrame;
        JButton ok;
        JButton cancel;
        JTextField login;
        JPasswordField pass;
        JLabel llogin;
        JLabel lpass;


        mainFrame = new JFrame();
        mainFrame.setTitle("Чек лист СНГиСН");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(200, 250);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);

        llogin = new JLabel();
        llogin.setBounds(10, 25, 100, 20);
        llogin.setText("Логин");

        login = new JTextField();
        login.setBounds(10, 50, 170, 20);

        lpass = new JLabel();
        lpass.setBounds(10, 75, 100, 20);
        lpass.setText("Пароль");

        pass = new JPasswordField();
        pass.setBounds(10, 100, 170, 20);

        ok = new JButton("OK");
        ok.setBounds(10, 150, 80, 20);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String e1, e2, e3;
                boolean chek = false;

                slogin[0] = login.getText();
                spass[0] = String.copyValueOf(pass.getPassword());
                System.out.println(slogin[0] + "  " + spass[0]);
                res[0] = DBConnection.getdatabase("SELECT id_position, login, password FROM login;");
                while (true) {
                    try {
                        if (!res[0].next()) break;
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        e1 = res[0].getString("id_position");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        e2 = res[0].getString("login");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        e3 = res[0].getString("password");
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    if (e2.equals(slogin[0]) && e3.equals(spass[0])) {
                        mainFrame.setVisible(false);
                        System.out.println(e1);
                        if (e1.equals("1")) {
                            new Master_menu();
                        } else new Worker();
                        chek = true;
                    }
                }
                if (!chek) {
                    System.out.println("wrong password");
                }
            }
        });
        cancel = new JButton("Cancel");
        cancel.setBounds(100, 150, 80, 20);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                System.exit(0);
            }
        });

        mainFrame.add(llogin);
        mainFrame.add(login);
        mainFrame.add(lpass);
        mainFrame.add(pass);
        mainFrame.add(ok);
        mainFrame.add(cancel);
        mainFrame.setVisible(true);*/
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckListSNGiSN {
    public static void main(String[] args) {

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

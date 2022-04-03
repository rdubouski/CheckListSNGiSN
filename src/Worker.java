import javax.swing.*;

public class Worker extends JFrame {

    JFrame frameWorker;

    public Worker() {
        frameWorker = new JFrame();
        frameWorker.setTitle("Чек лист рабочего СНГиСН");
        frameWorker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameWorker.setSize(1280, 1024);
        frameWorker.setResizable(false);
        frameWorker.setLayout(null);

        frameWorker.setVisible(true);

    }

}

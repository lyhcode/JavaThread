package ex07;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        JFrame demo = new JFrame();
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JButton button1 = new JButton("Start");
        final JButton button2 = new JButton("Hello");
        final JLabel label = new JLabel("");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Start");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i <= 10; i++) {
                            try {
                                Thread.sleep(1000);
                                label.setText(String.valueOf(i));
                                System.out.println(i);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello");
            }
        });

        JPanel panel = new JPanel();
        panel.add(BorderLayout.EAST, button1);
        panel.add(BorderLayout.WEST, button2);

        demo.getContentPane().add(BorderLayout.SOUTH, panel);
        demo.getContentPane().add(BorderLayout.NORTH, label);

        demo.setSize(320, 240);
        demo.setVisible(true);
    }
}

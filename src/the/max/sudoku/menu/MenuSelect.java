package the.max.sudoku.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuSelect {

    private JFrame frame;

    public MenuSelect() {
        initialize();
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Sudoku");
        frame.setBounds(650, 250, 400, 408);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        JLabel fields = new JLabel("Varianta (1 = lehka, 2 = tezka)");
        fields.setFont(new Font("Dialog", Font.BOLD, 12));
        fields.setBounds(40, 138, 200, 20);
        frame.getContentPane().add(fields);

        JTextField fieldsText = new JTextField("1");
        fields.setLabelFor(fieldsText);
        fieldsText.setBounds(180, 188, 100, 20);
        fieldsText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent event) {
                try {
                    Integer.parseInt(event.getKeyChar() + "");
                    if (fieldsText.equals("1") || fieldsText.equals("2")) {

                    } else {
                        event.consume();
                    }
                } catch (NumberFormatException e) {
                    event.consume();
                }
            }
        });
        frame.getContentPane().add(fieldsText);

        JButton button = new JButton("Začít hru");
        button.setFont(new Font("Dialog", Font.BOLD, 18));
        button.setBounds(215, 228, 120, 35);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fieldsText.getText().length() == 0) {
                    return;
                }
                try {
                    new MenuPlay(Integer.parseInt(fields.getText()));
                    frame.dispose();
                } catch (NumberFormatException ex) {

                }
            }
        });
        frame.getContentPane().add(button);
    }
}

package the.max.sudoku.menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuPlay {

    private Frame frame;

    private int size = 600, fie = 9;

    private ArrayList<Field> fields = new ArrayList<Field>();

    public MenuPlay() {
        initialize();
        frame.setVisible(true);
    }
    private void initialize() {
        frame = new Frame();
        frame.setTitle("Sudoku");
        frame.setBounds(new Rectangle(size, size));
        frame.setSize(new Dimension(size + 2, size + 25));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int x = 0; x < fie; x++) {
            for (int y = 0; y < fie; y++) {
                int rectX = x * (size/fie),
                        rectY = y * (size/fie),
                        width = size/fie,
                        height = size/fie;
                fields.add(new Field(rectX, rectY, rectX + width, rectY + height));
                if (x == fie-1)
                    System.out.println((rectX + width) + "");
            }
        }

        Panel panel = new Panel();

        panel.setLayout(null);

        for (Field field : fields) {
            field.draw();
            panel.add(field.textField);
        }

        frame.getContentPane().add(panel);

    }
    public class Frame extends JFrame {

    }

    public class Panel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Field field : fields) {
                g.drawRect(field.startX, field.startY, field.endX - field.startX, field.endY - field.startY);
            }
        }

    }

    public class Field {

        private int startX, startY, endX, endY;

        private int number = -1;

        private JTextField textField;

        public Field(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        public void draw() {
            int x = startX + 4, y = startY + 4, width = endX - startX - 6, height = endY - startY - 6;
            textField = new JTextField(" ");
            textField.setBounds(x, y, width, height);
        }

        public void setNumber(int n) {
            number = n;
            textField.setText("" + n);
        }

        public void setDefaultNumber(int n) {
            number = n;
            textField.setText("" + n);
            textField.setEditable(false);
        }

    }

}

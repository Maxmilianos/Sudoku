package the.max.sudoku.menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MenuPlay {

    private Frame frame;

    private int size = 600, fie = 9;

    private ArrayList<Field> fields = new ArrayList<Field>();

    public MenuPlay(int diff) {
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
                fields.add(new Field(x, y, rectX, rectY, rectX + width, rectY + height));
            }
        }

        Panel panel = new Panel();

        panel.setLayout(null);

        for (Field field : fields) {
            field.draw();
            panel.add(field.textField);
        }

        frame.getContentPane().add(panel);

        for (int i = 1; i <= 9; i++) {
            for (Field field : fields) {
                if (field.textField.isEditable() && checkField(field, i)) {
                    field.setDefaultNumber(i);
                }
            }
        }
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

    public Field getField(int x, int y) {
        for (Field field : fields) {
            if (field.x == x && field.y == y) {
                return field;
            }
        }
        return null;
    }

    public class Field {

        private int x, y;

        private int startX, startY, endX, endY;

        private int number = -1;

        private JTextField textField;

        public Field(int x, int y, int startX, int startY, int endX, int endY) {
            this.x = x;
            this.y = y;
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        public void draw() {
            int x = startX + 4, y = startY + 4, width = endX - startX - 6, height = endY - startY - 6;
            textField = new JTextField(" ");
            textField.setFont(new Font("Dialog", Font.BOLD, 25));
            textField.setBounds(x, y, width, height);
            textField.setHorizontalAlignment(JTextField.CENTER);
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

    public boolean checkField(Field field, int number) {
        int x = field.x, y = field.y;

        for (int i = 0; i < 9; i++) {
            Field f = getField(i, y);
            if (f != null) {
                if (f.number == number) {
                    return false;
                }
            } else {
                System.out.println("Haha y null " + x + " - " + y + " - " + i);
            }
        }

        for (int i = 0; i < 9; i++) {
            Field f = getField(x, i);
            if (f != null) {
                if (f.number == number) {
                    return false;
                }
            } else {
                System.out.println("Haha x null " + x + " - " + y + " - " + i);
            }
        }

        int defX, defY;

        if (x < 3)
            defX = 0;
        else if (x < 6)
            defX = 3;
        else
            defX = 6;

        if (y < 3)
            defY = 0;
        else if (y < 6)
            defY = 3;
        else
            defY = 6;

        for (int newX = defX; newX < defX + 3; newX++) {
            for (int newY = defY; newY < defY + 3; newY++) {
                Field f = getField(newX, newY);
                if (f != null) {
                    if (f.number == number)
                        return false;
                } else {
                    System.out.println("Haha def null " + x + " - " + y + " - " + defX + " - " + defY);
                }
            }
        }

        return true;
    }

    public class Id {

        public int x, y;

        public Id(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}

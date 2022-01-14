package the.max.sudoku;

import the.max.sudoku.menu.MenuPlay;
import the.max.sudoku.menu.MenuSelect;

import java.awt.*;

public class Sudoku {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MenuSelect();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

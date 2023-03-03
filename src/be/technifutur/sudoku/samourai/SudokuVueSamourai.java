package be.technifutur.sudoku.samourai;

import be.technifutur.sudoku.SudokuModel;
import be.technifutur.sudoku.SudokuVue;
import be.technifutur.sudoku.sudoku9x9.SudokuModel9x9;

public class SudokuVueSamourai implements SudokuVue {
    private SudokuModelSamourai model;
    private static String format = """
                  1 2 3   4 5 6   7 8 9         13 14 15 16 17 18 19 20 21
                +-------+-------+-------+       +-------+-------+-------+
              1 | . . . | . . . | . . . |       | . . . | . . . | . . . |
              2 | . . . | . . . | . . . |       | . . . | . . . | . . . |
              3 | . . . | . . . | . . . |       | . . . | . . . | . . . |
                +-------+-------+-------+       +-------+-------+-------+
              4 | . . . | . . . | . . . |       | . . . | . . . | . . . |
              5 | . . . | . . . | . . . |       | . . . | . . . | . . . |
              6 | . . . | . . . | . . . |       | . . . | . . . | . . . |
                +-------+-------+-------+-------+-------+-------+-------+
              7 | . . . | . . . | . . . | . . . | . . . | . . . | . . . |
              8 | . . . | . . . | . . . | . . . | . . . | . . . | . . . |
              9 | . . . | . . . | . . . | . . . | . . . | . . . | . . . |
                +-------+-------+-------+-------+-------+-------+-------+
             10                 | . . . | . . . | . . . |
             11                 | . . . | . . . | . . . |
             12                 | . . . | . . . | . . . |
                +-------+-------+-------+-------+-------+-------+-------+
             13 | . . . | . . . | . . . | . . . | . . . | . . . | . . . |
             14 | . . . | . . . | . . . | . . . | . . . | . . . | . . . |
             15 | . . . | . . . | . . . | . . . | . . . | . . . | . . . |
                +-------+-------+-------+-------+-------+-------+-------+
             16 | . . . | . . . | . . . |       | . . . | . . . | . . . |
             17 | . . . | . . . | . . . |       | . . . | . . . | . . . |
             18 | . . . | . . . | . . . |       | . . . | . . . | . . . |
                +-------+-------+-------+       +-------+-------+-------+
             19 | . . . | . . . | . . . |       | . . . | . . . | . . . |
             20 | . . . | . . . | . . . |       | . . . | . . . | . . . |
             21 | . . . | . . . | . . . |       | . . . | . . . | . . . |
                +-------+-------+-------+       +-------+-------+-------+""".replace(".", "%s");

    public SudokuVueSamourai(SudokuModelSamourai model) {
        this.model = model;
    }
    @Override
    public String getScreen() {
        Character[] val = new Character[model.cellCount()];
        int pos = 0;
        for (int i = 0; i < model.getMaxLine(); i++) {
            for (int j = 0; j < model.getMaxColumn(); j++) {
                if(model.isPositionValid(i,j)) {
                    if (model.isEmpty(i, j)){
                        val[pos] = '.';
                    }else{
                        val[pos] = model.getValue(i, j);
                    }
                    pos++;
                }
            }
        }
        return String.format(format, val);
    }

    @Override
    public SudokuModel getModel() {
        return this.model;
    }
}

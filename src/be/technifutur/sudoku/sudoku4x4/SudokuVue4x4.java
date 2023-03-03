package be.technifutur.sudoku.sudoku4x4;

import be.technifutur.sudoku.SudokuModel;
import be.technifutur.sudoku.SudokuVue;

public class SudokuVue4x4 implements SudokuVue {

    private SudokuModel4x4 model;
    private static String format = """
              1 2   3 4
            +-----+-----+
          1 | . . | . . |
          2 | . . | . . |
            +-----+-----+
          3 | . . | . . |
          4 | . . | . . |
            +-----+-----+
            """.replace(".", "%s");

    public SudokuVue4x4(SudokuModel4x4 model) {
        this.model = model;
    }

    @Override
    public String getScreen() {
        Character[] val = new Character[model.cellCount()];
        int pos = 0;

        for (int i = 0; i < model.getMaxLine(); i++) {
            for (int j = 0; j < model.getMaxColumn(); j++) {
                if (model.isEmpty(i, j)){
                    val[pos] = '.';
                }else{
                    val[pos] = model.getValue(i, j);
                }
                pos++;

            }
        }
        return String.format(format, val);
    }

    @Override
    public SudokuModel getModel() {
        return this.model;
    }
}

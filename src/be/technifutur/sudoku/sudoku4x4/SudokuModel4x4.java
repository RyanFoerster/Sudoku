package be.technifutur.sudoku.sudoku4x4;

import be.technifutur.sudoku.SudokuModel;

public class SudokuModel4x4 implements SudokuModel {
    private final char[][] tab;

    public SudokuModel4x4() {
        this.tab = new char[getMaxLine()][getMaxColumn()];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                tab[i][j] = EMPTY;
            }
        }
    }

    @Override
    public int cellCount() {
        return getMaxLine() * getMaxColumn();
    }

    @Override
    public char getValue(int line, int col) {
        return this.tab[line][col];
    }

    @Override
    public void setValue(int line, int col, char value) {
        this.tab[line][col] = value;
    }

    @Override
    public int getMaxLine() {
        return 4;
    }

    @Override
    public int getMaxColumn() {
        return 4;
    }

    @Override
    public Boolean isPositionValid(int line, int col) {
        boolean isValid = false;
        try {
            if (line - 1 < getMaxLine() && line - 1 >= 0 && col - 1 >= 0 && col - 1 < getMaxColumn()) {
                isValid = true;
            }
        }catch (ArrayIndexOutOfBoundsException e){
            isValid = false;
        }
        return isValid;
    }

    @Override
    public Boolean isValueValid(char value) {
        if((int) value <= 9){
            return true;
        }
        return false;
    }
}

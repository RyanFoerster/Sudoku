package be.technifutur.sudoku.sudoku9x9;

import be.technifutur.sudoku.SudokuModel;

public class SudokuModel9x9 implements SudokuModel {
    private final char[][] tab;

    public SudokuModel9x9() {
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
        return tab[line][col];
    }

    @Override
    public void setValue(int line, int col, char value) {
        tab[line][col] = value;
    }

    @Override
    public int getMaxLine() {
        return 9;
    }

    @Override
    public int getMaxColumn() {
        return 9;
    }

    @Override
    public Boolean isPositionValid(int line, int col) {
        boolean isValid = false;
        try {
            if (line <= getMaxLine() && col <= getMaxColumn()) {
                isValid = true;
            }
        } catch (ArrayIndexOutOfBoundsException e){
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

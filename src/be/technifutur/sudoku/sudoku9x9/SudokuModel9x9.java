package be.technifutur.sudoku.sudoku9x9;

import be.technifutur.sudoku.SudokuModel;

public class SudokuModel9x9 implements SudokuModel {
    private final char[][] tab;

    public SudokuModel9x9() {
        this.tab = new char[getMaxLine()][getMaxColumn()];
        initTab();
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
        // regarde si la valeur est acceptable
        char[] tmp = {'1','2','3','4','5','6','7','8','9'};
        boolean isValid = false;
        int i = 0;
        while (!isValid && i < tmp.length){
            if (tmp[i] == value) isValid = true;
            i++;
        }
        return isValid;
    }

    public Boolean isEmpty(int line, int col){
        return this.tab[line][col] == EMPTY;
    }

    public void clearCell(int line, int col){
        tab[line][col] = EMPTY;
    }

    public void initTab(){
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                this.tab[i][j] = EMPTY;
            }
        }
    }
}

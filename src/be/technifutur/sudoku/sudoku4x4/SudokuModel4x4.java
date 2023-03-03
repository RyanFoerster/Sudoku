package be.technifutur.sudoku.sudoku4x4;

import be.technifutur.sudoku.SudokuModel;

public class SudokuModel4x4 implements SudokuModel {
    private final char[][] tab;

    public SudokuModel4x4() {
        this.tab = new char[getMaxLine()][getMaxColumn()];
        initTab();
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
    public Boolean isPositionValid(int lineNumber, int columnNumber) {
        // regarde si la valeur peut etre posé à cette position
        boolean isValid = true;
        if ((lineNumber >= tab.length || lineNumber <= 0)
                && (columnNumber >= tab.length|| columnNumber <= 0))
        {
            isValid = false;
        }
        return isValid;
    }

    @Override
    public Boolean isValueValid(char value) {
        // regarde si la valeur est acceptable
        char[] tmp = {'1','2','3','4'};
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

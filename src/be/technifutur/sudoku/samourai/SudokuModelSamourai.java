package be.technifutur.sudoku.samourai;

import be.technifutur.sudoku.SudokuModel;
import be.technifutur.sudoku.sudoku9x9.SudokuModel9x9;

public class SudokuModelSamourai implements SudokuModel {
    private final char[][] tab;
    private SudokuModel9x9 s9x9 = new SudokuModel9x9();

    public SudokuModelSamourai() {
        this.tab = new char[getMaxLine()][getMaxColumn()];
        initTab();
    }

    @Override
    public int cellCount() {
        return (getMaxColumn() * getMaxLine()) - (9 * 8);
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
        return 21;
    }

    @Override
    public int getMaxColumn() {
        return 21;
    }

    @Override
    public Boolean isPositionValid(int line, int col) {
        if ((line >= 0 && col >= 0 && line < 9 && col < 9) ||
                (line >= 0 && col >= 12 && line < 9 && col < 9+12) ||
                (line >= 6 && col >= 6 && line < 9+6 && col < 9+6) ||
                (line >= 12 && col >= 0 && line < 9+12 && col < 9) ||
                (line >= 12 && col >= 12 && line < 9+12 && col < 9+12)){
            return true;
        }
        return false;
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
                if((i > 8 && i < 12) || (j > 8 && j < 12)) {
                    this.tab[i][j] = 'o';
                }else{
                    this.tab[i][j] = EMPTY;
                }
            }
        }
    }
}

package be.technifutur.sudoku;

public interface SudokuModel {

    int cellCount();

    char getValue(int line, int col);

    void setValue(int line, int col, char value);

    int getMaxLine();

    int getMaxColumn();

    Boolean isPositionValid(int line, int col);

    Boolean isValueValid(char Value);
}
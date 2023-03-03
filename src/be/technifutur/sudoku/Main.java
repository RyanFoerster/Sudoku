package be.technifutur.sudoku;

import be.technifutur.sudoku.samourai.SudokuFactorySamourai;
import be.technifutur.sudoku.sudoku4x4.SudokuFactory4x4;
import be.technifutur.sudoku.sudoku9x9.SudokuFactory9x9;

public class Main {
    public static void main(String[] args) {
        ModelFactory s4x4 = new SudokuFactory4x4();
        ModelFactory s9x9 = new SudokuFactory9x9();
        ModelFactory samourai = new SudokuFactorySamourai();

        SudokuController controller = new SudokuController(s9x9);

        controller.start("ressource\\sudoku9x9.txt");

    }
}


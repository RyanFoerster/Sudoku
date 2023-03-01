package be.technifutur.sudoku;

import be.technifutur.sudoku.sudoku4x4.SudokuModel4x4;
import be.technifutur.sudoku.sudoku9x9.SudokuModel9x9;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SudokuModel s4x4 = new SudokuModel4x4();
        SudokuModel s9x9 = new SudokuModel9x9();

        System.out.println("\n-------------------Sudoku 4x4-------------------------");
        afficherTab(s4x4);
        System.out.println("\n------------------------------------------------------");
        for (int i = 0; i < s4x4.getMaxLine(); i++) {
            for (int j = 0; j < s4x4.getMaxColumn(); j++) {
                s4x4.setValue(i,j,'5');
            }
        }

        afficherTab(s4x4);
        System.out.println("\n------------------------------------------------------");

        System.out.println("\n-------------------Sudoku 9x9-------------------------");
        afficherTab(s9x9);
        System.out.println("\n------------------------------------------------------");
        for (int i = 0; i < s9x9.getMaxLine(); i++) {
            for (int j = 0; j < s9x9.getMaxColumn(); j++) {
                s9x9.setValue(i,j,'5');
            }
        }

        afficherTab(s9x9);
        System.out.println("\n------------------------------------------------------");

        System.out.println(s4x4.isPositionValid(4, 4));
        System.out.println(s4x4.isPositionValid(1, 1));
        System.out.println(s9x9.isPositionValid(9, 9));
        System.out.println(s9x9.isPositionValid(1, 1));

    }
    public static void afficherTab(SudokuModel s){
        for (int i = 0; i < s.getMaxLine(); i++) {
            for (int j = 0; j < s.getMaxColumn() ; j++) {
                if(j == s.getMaxColumn() - 1){
                    System.out.printf("%s : %-10s %n", i, s.getValue(i, j));
                }else{
                    System.out.printf("%s : %-10s", i, s.getValue(i, j));
                }
            }
        }
    }
}


package be.technifutur.sudoku;

import be.technifutur.sudoku.samourai.SudokuFactorySamourai;
import be.technifutur.sudoku.samourai.SudokuModelSamourai;
import be.technifutur.sudoku.samourai.SudokuVueSamourai;
import be.technifutur.sudoku.sudoku4x4.SudokuFactory4x4;
import be.technifutur.sudoku.sudoku4x4.SudokuModel4x4;
import be.technifutur.sudoku.sudoku4x4.SudokuVue4x4;
import be.technifutur.sudoku.sudoku9x9.SudokuFactory9x9;
import be.technifutur.sudoku.sudoku9x9.SudokuModel9x9;
import be.technifutur.sudoku.sudoku9x9.SudokuVue9x9;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ModelFactory s4x4 = new SudokuFactory4x4();
        SudokuVue4x4 vue = new SudokuVue4x4((SudokuModel4x4) s4x4.getModel("ressource\\sudoku4x4.txt"));

        ModelFactory s9x9 = new SudokuFactory9x9();
        SudokuVue9x9 vue9x9 = new SudokuVue9x9((SudokuModel9x9) s9x9.getModel("ressource\\sudoku9x9.txt"));

        ModelFactory samourai = new SudokuFactorySamourai();
        SudokuVueSamourai vueSamourai = new SudokuVueSamourai((SudokuModelSamourai) samourai.getModel("ressource\\sudokuSamourai.txt"));

        System.out.println("\n-------------------Sudoku 4x4-------------------------");
        System.out.println(vue.getScreen());
        System.out.println("\n------------------------------------------------------");

        System.out.println("\n-------------------Sudoku 9x9-------------------------");
        System.out.println(vue9x9.getScreen());
        System.out.println("\n------------------------------------------------------");

        System.out.println("\n-------------------Sudoku Samourai--------------------");
        System.out.println(vueSamourai.getScreen());
        System.out.println("\n------------------------------------------------------");

    }
    public static void afficherTab(SudokuModel s){

    }
}


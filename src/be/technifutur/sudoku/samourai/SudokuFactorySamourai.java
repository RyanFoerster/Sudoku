package be.technifutur.sudoku.samourai;

import be.technifutur.sudoku.ModelFactory;
import be.technifutur.sudoku.SudokuModel;
import be.technifutur.sudoku.SudokuVue;
import be.technifutur.sudoku.sudoku4x4.SudokuModel4x4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuFactorySamourai implements ModelFactory {

    @Override
    public SudokuModel getModel(String fileName){
        File file = new File(fileName);
        SudokuModelSamourai samourai = new SudokuModelSamourai();
        int cpt = 0;

        try(Scanner sc = new Scanner(file)){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                for (int i = 0; i < samourai.getMaxLine(); i++) {
                    samourai.setValue(cpt, i,line.charAt(i));
                }
                cpt++;
            }
        }catch (FileNotFoundException e){
            System.out.println("Le fichier n'existe pas !");
        }
        return samourai;
    }

    @Override
    public SudokuVue getVue(String fileName) {
        SudokuVueSamourai vueSamourai = new SudokuVueSamourai((SudokuModelSamourai) this.getModel("ressource\\sudokuSamourai.txt"));

        System.out.println("\n-------------------Sudoku Samourai--------------------");
        System.out.println(vueSamourai.getScreen());
        System.out.println("\n------------------------------------------------------");

        return vueSamourai;
    }
}

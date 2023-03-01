package be.technifutur.sudoku.sudoku9x9;

import be.technifutur.sudoku.ModelFactory;
import be.technifutur.sudoku.SudokuModel;
import be.technifutur.sudoku.sudoku4x4.SudokuModel4x4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuFactory9x9 implements ModelFactory {
    @Override
    public SudokuModel getModel(String fileName) {
        File file = new File(fileName);
        SudokuModel9x9 s9x9 = new SudokuModel9x9();
        int cpt = 0;

        try(Scanner sc = new Scanner(file)){
            while(sc.hasNextLine()){
                String line =sc.nextLine();
                for (int i = 0; i < s9x9.getMaxLine(); i++) {
                    s9x9.setValue(cpt, i,line.charAt(i));
                }
                cpt++;
            }
        }catch (FileNotFoundException e){
            System.out.println("Le fichier n'existe pas !");
        }
        return s9x9;
    }
}

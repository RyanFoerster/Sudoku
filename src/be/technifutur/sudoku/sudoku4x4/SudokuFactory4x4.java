package be.technifutur.sudoku.sudoku4x4;

import be.technifutur.sudoku.ModelFactory;
import be.technifutur.sudoku.SudokuModel;
import be.technifutur.sudoku.SudokuVue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuFactory4x4 implements ModelFactory {


    @Override
    public SudokuModel getModel(String fileName) {
        File file = new File(fileName);
        SudokuModel4x4 s4x4 = new SudokuModel4x4();
        int cpt = 0;

        try(Scanner sc = new Scanner(file)){
            while(sc.hasNextLine()){
                String line =sc.nextLine();
                for (int i = 0; i < s4x4.getMaxLine(); i++) {
                    s4x4.setValue(cpt, i,line.charAt(i));
                }
                cpt++;
            }
        }catch (FileNotFoundException e){
            System.out.println("Le fichier n'existe pas !");
        }
        return s4x4;
    }

    @Override
    public SudokuVue getVue(String fileName) {
        SudokuVue4x4 vue = new SudokuVue4x4((SudokuModel4x4) this.getModel(fileName));

        System.out.println("\n-------------------Sudoku 4x4-------------------------");
        System.out.println(vue.getScreen());
        System.out.println("\n------------------------------------------------------");

        return vue;
    }
}

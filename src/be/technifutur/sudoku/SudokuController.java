package be.technifutur.sudoku;

import java.util.Scanner;

public class SudokuController {
    private ModelFactory factory;
    Scanner sc = new Scanner(System.in);
    String userInput = "";

    public SudokuController(ModelFactory model){
        if(model == null){
            System.out.println("Erreur");
        }else{
            this.factory = model;
        }
    }

    public void start(String fileName){
        SudokuVue vue = this.factory.getVue(fileName);
        String[] splitter;
        int line;
        int col;
        char valeur;

        System.out.println("Saisir votre ligne.col.valeur");
        userInput = sc.nextLine();

        while(!userInput.equalsIgnoreCase("q")){
            splitter = userInput.split("\\.");
            line = Integer.parseInt(splitter[0]);
            col = Integer.parseInt(splitter[1]);
            valeur = splitter[2].charAt(0);

            vue.getModel().setValue(line - 1, col - 1,valeur);
            System.out.println(vue.getScreen());

            System.out.println("Saisir votre ligne.col.valeur");
            userInput = sc.nextLine();

        }
    }
}

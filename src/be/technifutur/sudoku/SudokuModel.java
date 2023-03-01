package be.technifutur.sudoku;

public interface SudokuModel {

    char EMPTY = 'E';
    /**
     * Retourne le nombre de cellule valide du sudoku
     * @return le nombre de cellule
     */
    int cellCount();

    /**
     * Retourne le nombre de valeur possible dans un char
     * @param line
     * @param col
     * @return le nombre de valeur possible dans un char
     */
    char getValue(int line, int col);

    /**
     *
     * @param line
     * @param col
     * @param value
     */
    void setValue(int line, int col, char value);

    /**
     * Retourne le nombre maximum de ligne
     * @return le nombre max de ligne
     */
    int getMaxLine();

    /**
     * Retourne le nombre maximum de colomne
     * @return la nombre max de colomne
     */
    int getMaxColumn();

    /**
     * Retourne un booléen pour savoir si la position est valide
     * @param line
     * @param col
     * @return un bolléen
     */
    Boolean isPositionValid(int line, int col);

    /**
     * Retourne un booléen pour savoir si la valeur est valide
     * @param value
     * @return un booléen
     */
    Boolean isValueValid(char value);
}
package bv.Client.Model;

/**
 * Pos class represents a Pos in a 2D grid.
 * 
 * The grid consists of 7 rows and 7 columns with indices ranging from 0 to 6.
 */

public class Pos {
    /** The column of the Pos in the grid */
    private int col;
    /** The row of the Pos in the grid */
    private int row;

    /**
     * Constructs a new Pos object with the given column and row values.
     * 
     * @param x The column of the Pos in the grid.
     * @param y The row of the Pos in the grid.
     */
    public Pos(int x, int y) {
        this.col = x;
        this.row = y;
    }

    /**
     * Returns the column of the Pos.
     * 
     * @return The column of the Pos.
     */
    public int getColumn() {
        return col;
    }

    /**
     * Returns the row of the Pos.
     * 
     * @return The row of the Pos.
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns a string representation of the Pos in the format "column;row".
     * 
     * @return A string representation of the Pos.
     */
    public String toString() {
        return getColumn() + ";" + getRow();
    }

    /**
     * Converts the given index to a Pos object.
     * 
     * @param index The index to be converted.
     * @return The Pos object that corresponds to the given index.
     */
    public static Pos convertToCoordinate(int index) {
        int count = 0;
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
                if (x != 0 && y != 0 && x != 6 && y != 6)
                    continue;
                if (count == index)
                    return new Pos(x, y);
                count++;
            }
        }
        return new Pos(-1, -1); // there is something wrong with index
    }

    /**
     * Converts the given Pos object to an index.
     * 
     * @param coord The Pos object to be converted.
     * @return The index that corresponds to the given Pos object.
     */
    public static int convertToIndex(Pos coord) {
        int x = coord.getColumn();
        int y = coord.getRow();
        int index = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (i != 0 && i != 6 && j != 0 && j != 6)
                    continue;
                if (j == x && i == y) {
                    return index;
                }
                index++;
            }
        }
        return -1;

    }
}

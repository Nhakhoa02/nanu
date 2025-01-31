package bv.Client.utils;

import java.io.File;
import java.util.ArrayList;

import bv.Client.Model.Lids;
import bv.Client.Model.GameState;

/**
 * InitialGame is a utility class that generates data for a theme in a game.
 * 
 * It has two method, one is generateDataForFolder(), which generates an array
 * of images from a given folder. The data in the array can then be used to
 * generate game Lids cards.
 *
 * The other method, generateDisc(), generates a list of Lids cards using the
 * image and value data generated in the generateDataForFolder() method.
 */

public class InitialGame {
    public static String[] Images;
    public static String[] Values = new String[24];

    public static void generateDataForFolder() {
        String theme = GameState.gameLogic.theme; // Get theme dynamically
        String folderPath = "src/main/resources/bv/assets/Theme/" + theme;
        File directory = new File(folderPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(".png") || name.endsWith(".jpg"));
            
            if (files != null && files.length > 0) {
                Images = new String[files.length];
                Values = new String[files.length];

                for (int i = 0; i < files.length; i++) {
                    Images[i] = files[i].getName(); // Store file name
                    Values[i] = formatFileName(files[i].getName()); // Processed name
                }
            }
        } else {
            System.out.println("Folder not found: " + folderPath);
        }
    }

    private static String formatFileName(String fileName) {
        // Remove file extension (.png, .jpg)
        String nameWithoutExtension = fileName.replaceAll("\\.[^.]*$", "");

        // Insert spaces before uppercase letters
        String formattedName = nameWithoutExtension.replaceAll("(?<!^)(?=[A-Z])", " ");

        return formattedName;
    }

    public static void generateDisc(ArrayList<Lids> discArray) {
        generateDataForFolder();
        for (int i = 0; i < Values.length; i++) {
            discArray.add(new Lids(Images[i], Values[i]));
        }
    }

}

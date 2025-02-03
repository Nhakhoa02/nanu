package bv.Client.utils;

import java.io.IOException;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.Enumeration;

import bv.Client.Model.Lids;
import bv.Client.Model.GameState;

public class InitialGame {
    public static String[] Images;
    public static String[] Values;

    public static void generateDataForFolder() {
        String theme = GameState.gameLogic.theme; // Get theme dynamically
        String folderPath = "/bv/assets/Theme/" + theme;

        List<String> imageList = new ArrayList<>();
        List<String> valueList = new ArrayList<>();

        try {
            URL resource = InitialGame.class.getResource(folderPath);
            if (resource == null) {
                System.out.println("Folder not found: " + folderPath);
                return;
            }

            if (resource.getProtocol().equals("jar")) {
                // Load images inside JAR
                String jarPath = resource.getPath().substring(5, resource.getPath().indexOf("!"));
                try (JarFile jarFile = new JarFile(jarPath)) {
                    Enumeration<JarEntry> entries = jarFile.entries();
                    while (entries.hasMoreElements()) {
                        JarEntry entry = entries.nextElement();
                        if (entry.getName().startsWith(folderPath.substring(1)) &&
                            (entry.getName().endsWith(".png") || entry.getName().endsWith(".jpg"))) {
                            
                            String fileName = entry.getName().substring(entry.getName().lastIndexOf("/") + 1);
                            imageList.add(fileName); // Store file name only
                            valueList.add(formatFileName(fileName));
                        }
                    }
                }
            } else {
                // Load images when running from IDE
                File directory = new File(resource.toURI());
                File[] files = directory.listFiles((dir, name) -> name.endsWith(".png") || name.endsWith(".jpg"));

                if (files != null) {
                    for (File file : files) {
                        imageList.add(file.getName());
                        valueList.add(formatFileName(file.getName()));
                    }
                }
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        // Convert lists to arrays
        Images = imageList.toArray(new String[0]);
        Values = valueList.toArray(new String[0]);
    }

    private static String formatFileName(String fileName) {
        return fileName.replaceAll("\\.[^.]*$", "").replaceAll("(?<!^)(?=[A-Z])", " ");
    }

    public static void generateDisc(ArrayList<Lids> discArray) {
        generateDataForFolder();
        for (int i = 0; i < Images.length; i++) {
            discArray.add(new Lids(Images[i], Values[i]));
        }
    }
}

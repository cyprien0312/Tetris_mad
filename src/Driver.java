package src;

import ch.aplu.jgamegrid.Actor;
import src.game.TetrisEasy;
import src.game.TetrisHard;
import src.game.TetrisMedian;
import src.utility.PropertiesLoader;

import java.awt.*;
import java.util.Arrays;
import java.util.Properties;

public class Driver {
    public static final String DEFAULT_PROPERTIES_PATH = "properties/test2.properties";

    /**
     * Starting point
     * @param args the command line arguments
     */

    private static Tetris game;
    public static void main(String args[]) {
        String propertiesPath = DEFAULT_PROPERTIES_PATH;
        System.out.println("Arrays.asList(args) = " + Arrays.asList(args));
        if (args.length > 0) {
            propertiesPath = args[0];
        }
        final Properties properties = PropertiesLoader.loadPropertiesFile(propertiesPath);
        assert properties != null;
        boolean isLoggingTest = Boolean.parseBoolean(properties.getProperty("logTest", "false"));
        TetrisGameCallback gameCallback = new TetrisGameCallback(isLoggingTest);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                String difficulty = properties.getProperty("difficulty", "madness");
                switch (difficulty) {
                    case "easy" -> game = new TetrisEasy(gameCallback, properties);
                    case "medium" -> game = new TetrisMedian(gameCallback, properties);
                    default -> game = new TetrisHard(gameCallback, properties);
                }
                game.setVisible(true);
            }
        });
    }
}


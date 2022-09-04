package src.utility;

import src.Tetris;
import src.blocks.*;

import java.util.Random;

public class RandomBlock {
    /*if (blockPreview != null)
            blockPreview.removeSelf();

    // If the game is in auto test mode, then the block will be moved according to the blockActions
    String currentBlockMove = "";
        if (blockActions.length > blockActionIndex) {
        currentBlockMove = blockActions[blockActionIndex];
    }*/
    private static final String[] shapes = new String[]{ "I", "J", "L", "O", "S", "T", "Z",  "P", "Q", "Plus"};
    private static final int pivot = 7;


    public static Block[] getRandomBlocks(Tetris.GameDifficulty diff, Random rad, Tetris tetris){
        // return two blocks, one for scoring, one for preview
        Block[] blocks = new Block[2];

        int i = -1;
        String name = null;
        if (diff == Tetris.GameDifficulty.EASY){
            i = rad.nextInt(pivot);
        }
        else {
            i = rad.nextInt(shapes.length);
        }
        name = shapes[i];
        blocks[0] = getBlock(name, tetris);
        blocks[1] = getBlock(name, tetris);
        return blocks;
    }

    private static Block getBlock(String name, Tetris tetris) {

        return switch (name) {
            case "J" -> new J(tetris);
            case "L" -> new L(tetris);
            case "O" -> new O(tetris);
            case "S" -> new S(tetris);
            case "T" -> new T(tetris);
            case "Z" -> new Z(tetris);
            case "P" -> new P(tetris);
            case "Q" -> new Q(tetris);
            case "Plus" -> new Plus(tetris);
            default -> new I(tetris);
        };
    }
}

package src.blocks;

import ch.aplu.jgamegrid.Location;
import src.Tetris;
import src.TetroBlock;


public class P extends Block {

    public static final int blockId = 6;
    public static final String blockName = "P";
    public static final int size = 5;

    public P(Tetris tetris) {
        super(blockId, blockName, size, tetris);
    }

    @Override
    public void setLocation() {
        var r = createLoc(size);
        r[0][0] = new Location(new Location(0, 0));
        r[1][0] = new Location(new Location(1, 0));
        r[2][0] = new Location(new Location(1, 1));
        r[3][0] = new Location(new Location(0, 1));
        r[4][0] = new Location(new Location(0, 2));
        // rotId 1
        r[0][1] = new Location(new Location(0, 0));
        r[1][1] = new Location(new Location(-1, 0));
        r[2][1] = new Location(new Location(1, 0));
        r[3][1] = new Location(new Location(0, 1));
        r[4][1] = new Location(new Location(1, 1));
        // rotId 2
        r[0][2] = new Location(new Location(0, 1));
        r[1][2] = new Location(new Location(0, 2));
        r[2][2] = new Location(new Location(1, 0));
        r[3][2] = new Location(new Location(1, 1));
        r[4][2] = new Location(new Location(1, 2));
        // rotId 3
        r[0][3] = new Location(new Location(0, 1));
        r[1][3] = new Location(new Location(1, 1));
        r[2][3] = new Location(new Location(0, 2));
        r[3][3] = new Location(new Location(1, 2));
        r[4][3] = new Location(new Location(2, 2));

        for (int i = 0; i < r.length; i++) {
            blocks.add(new TetroBlock(blockId, r[i]));
        }
    }
}

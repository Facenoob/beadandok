///Adam,polnik.adam@inf.u-szeged.hu

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import game.engine.utils.Utils;
import game.oth.OthelloAction;
import game.oth.OthelloGame;
import game.oth.OthelloPlayer;
import game.oth.players.GreedyPlayer;

public class Agent extends OthelloPlayer {
    private ArrayList<OthelloAction> actions = new ArrayList<OthelloAction>();

    public Agent(int color, int[][] board, Random random) {
        super(color, board, random);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                actions.add(new OthelloAction(i, j));
            }
        }
    }

    @Override
    public OthelloAction getAction(OthelloAction prevAction, long[] remainingTimes) {
        if (prevAction != null) {
            OthelloGame.setAction(board, prevAction.i, prevAction.j, 1 - color);
        }

        int maxScore = -1000000;
        OthelloAction maxaction = null;

        for (OthelloAction c : actions) {
            if (OthelloGame.isValid(board, c.i, c.j, color)) {
                maxaction = c;
            }
        }
        int myscore = 0;
        int enemyscore = 0;
        for (OthelloAction a : actions) {
            int[][] copyBoard = Utils.copy(board);
            if (OthelloGame.isValid(board, a.i, a.j, color)) {
                OthelloGame.setAction(copyBoard, a.i, a.j, color);
                OthelloAction action = null;
                int flipped = -1;
                for (OthelloAction b : actions) {
                    if (OthelloGame.isValid(copyBoard, b.i, b.j, 1 - color)) {
                        int f = OthelloGame.setAction(Utils.copy(copyBoard), b.i, b.j, 1 - color);
                        if (flipped < f) {
                            flipped = f;
                            action = b;
                        }
                    }
                }
                if (action == null) {
                    break;
                }
                OthelloGame.setAction(copyBoard, action.i, action.j, 1 - color);
                for(OthelloAction b: actions){
                    if (!OthelloGame.isValid(copyBoard,b.i,b.j,color)) continue;
                    int[][] bordcopy=Utils.copy(copyBoard);
                    OthelloGame.setAction(bordcopy, b.i,b.j,color);
                    myscore = 0;
                    enemyscore = 0;
                    for (int i = 0; i < bordcopy.length; i++) {
                        for (int j = 0; j < bordcopy[i].length; j++) {
                            if (bordcopy[i][j] == color) {
                                myscore++;
                            } else if (bordcopy[i][j] == 1-color) {
                                enemyscore++;
                            }
                        }
                    }
                    if (maxScore < myscore - enemyscore) {
                        maxScore = myscore - enemyscore;
                        maxaction = a;
                    }
                }

            }
        }
        OthelloGame.setAction(board,maxaction.i,maxaction.j,color);
        return maxaction;
    }
}





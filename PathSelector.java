import javafx.scene.input.MouseButton;

import java.awt.*;
import java.awt.event.*;

public class PathSelector{

    private final byte Black = 24; //Black's value of "red" is 24, we use red to check if the tile is black!
    private final byte wait_time = 53; //milliseconds
    private final int[] path_one = {427, 420};
    private final int[] path_two = {525, 420};
    private final int[] path_three = {619, 420};
    private final int[] path_four = {704, 420};
    int[][] paths = {path_one, path_two, path_three, path_four};
    Robot robot = new Robot();

    public PathSelector() throws AWTException, InterruptedException{
        //gets recursion started
        solveStep();
    }

    public void moveToPath(int path) throws InterruptedException, AWTException{

        robot.mouseMove(paths[path][0], paths[path][1]);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(wait_time);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(wait_time);
        solveStep();
    }

    public void solveStep() throws AWTException, InterruptedException {

        for (byte i = 0; 3 >= i; i++) {
            Color booleanBlackWhite = robot.getPixelColor(paths[i][0], paths[i][1]);
            if (Black == booleanBlackWhite.getRed()) {
                moveToPath(i);
                break;
            }
        }
    }
    public static void main(String args[]) throws AWTException, InterruptedException{
        new PathSelector();
    }


}

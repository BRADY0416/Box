package view.game;

import controller.GameController;
import model.Direction;
import model.MapMatrix;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * It is the subclass of ListenerPanel, so that it should implement those four methods: do move left, up, down ,right.
 * The class contains a grids, which is the corresponding GUI view of the matrix variable in MapMatrix.
 */
public class GamePanel extends ListenerPanel {

    private GridComponent[][] grids;
    private MapMatrix model;
    private GameController controller;
    private JLabel stepLabel;
    private int steps;
    private final int GRID_SIZE = 50;

    private Hero hero;


    public GamePanel(MapMatrix model) {
        this.setVisible(true);
        this.setFocusable(true);
        this.setLayout(null);
        this.setSize(model.getWidth() * GRID_SIZE + 4, model.getHeight() * GRID_SIZE + 4);
        this.model = model;
        this.grids = new GridComponent[model.getHeight()][model.getWidth()];
        initialGame();

    }

    public void initialGame() {
        this.steps = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                //Units digit maps to id attribute in GridComponent. (The no change value)
                grids[i][j] = new GridComponent(i, j, model.getId(i, j) % 10, this.GRID_SIZE);
                grids[i][j].setLocation(j * GRID_SIZE + 2, i * GRID_SIZE + 2);
                //Ten digit maps to Box or Hero in corresponding location in the GridComponent. (Changed value)
                switch (model.getId(i, j) / 10) {
                    case 1:
                        grids[i][j].setBoxInGrid(new Box(GRID_SIZE - 10, GRID_SIZE - 10));
                        break;
                    case 2:
                        this.hero = new Hero(GRID_SIZE - 16, GRID_SIZE - 16, i, j);
                        grids[i][j].setHeroInGrid(hero);
                        break;
                }
                this.add(grids[i][j]);
            }
        }
        this.repaint();
    }

    @Override
    public void doMoveRight() {
        System.out.println("Click VK_RIGHT");
        if (controller.doMove(hero.getRow(), hero.getCol(), Direction.RIGHT)) {
            this.afterMove();
            if(controller.ifFinish()) {
                //print finish
            }
        }
    }

    @Override
    public void doMoveLeft() {
        System.out.println("Click VK_LEFT");
        if(controller.doMove(hero.getRow(), hero.getCol(), Direction.LEFT)){
            this.afterMove();
            if(controller.ifFinish()) {
                //print finish
            }
        }
    }

    @Override
    public void doMoveUp() {
        System.out.println("Click VK_Up");
       if( controller.doMove(hero.getRow(), hero.getCol(), Direction.UP)){
           this.afterMove();
           if(controller.ifFinish()) {
               //print finish
           }
       }
    }

    @Override
    public void doMoveDown() {
        System.out.println("Click VK_DOWN");
        if(controller.doMove(hero.getRow(), hero.getCol(), Direction.DOWN)){
            this.afterMove();
            if(controller.ifFinish()) {
                //print finish
            }
        }
    }

    public void afterMove() {
        this.steps++;
        this.stepLabel.setText(String.format("Step: %d", this.steps));
    }

    public void setStepLabel(JLabel stepLabel) {
        this.stepLabel = stepLabel;
    }



    public void setController(GameController controller) {
        this.controller = controller;
    }

    public GridComponent getGridComponent(int row, int col) {
        return grids[row][col];
    }
}

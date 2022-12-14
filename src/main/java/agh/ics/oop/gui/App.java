package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.*;

public class App extends Application {
    // rozmiary kolumn i wierszy
    final int width = 25;
    final int height = 25;
    private final AWorldMap map = new GrassField(10);
    private IEngine engine;
    @Override
    public void init() {
        List<String> rawParameters = getParameters().getRaw();
        MoveDirection[] directions = OptionsParser.parse(rawParameters.toArray(String[]::new));
        // zmienilam na liste zeby moc dodawac zwierzatka po inicjalizacji
        List<Vector2d> animalStartingPositions = new ArrayList<>();
        animalStartingPositions.add(new Vector2d(-1, 2));
        animalStartingPositions.add(new Vector2d(3, -4));
        engine = new SimulationEngine(directions, map, animalStartingPositions);
    }
    @Override
    public void start (Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);

        mapLayout(grid);
        placeElements(grid);

        Scene scene = new Scene(grid, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("World");
        primaryStage.show();
        engine.run();
    }
    private void mapLayout(GridPane grid) {
        int numOfColumns = map.getUpperBound().getX() - map.getLowerBound().getX();
        int numOfRows = map.getUpperBound().getY() - map.getLowerBound().getY();

        grid.getColumnConstraints().add(new ColumnConstraints(width));
        grid.getRowConstraints().add(new RowConstraints(height));
        grid.add(createLabel("y\\x"),0,0);

        for (int i = 0; i < numOfColumns + 1; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(width));
            grid.add(createLabel(Integer.toString(map.getLowerBound().getX() + i)),i+1,0);
        }
        for (int i = 0; i < numOfRows + 1; i++) {
            grid.getRowConstraints().add(new RowConstraints(height));
            grid.add(createLabel(Integer.toString(map.getUpperBound().getY() - i)),0,i+1);
        }
    }
    private void placeElements(GridPane grid){
        for (Vector2d position: map.getElements().keySet()) {
            grid.add(createLabel(map.getElements().get(position).toString()),
                    -map.getLowerBound().getX() + 1 + position.getX(),
                    map.getUpperBound().getY() + 1 - position.getY());
        }
    }
    private Label createLabel(String text){
        Label label = new Label(text);
        GridPane.setHalignment(label, HPos.CENTER);
        return label;
    }
}

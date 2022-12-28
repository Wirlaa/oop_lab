package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.*;

public class AppOld extends Application implements ISimulationChangeObserver {
    // rozmiary pol
    static final int WIDTH = 45;
    static final int HEIGHT = 45;
    private AWorldMap map;
    private IEngine engine;
    private Stage stage;
    private final Map<String, Image> images = new HashMap<>();

    @Override
    public void init() {
        //List<String> rawParameters = getParameters().getRaw();
        //MoveDirection[] directions = OptionsParser.parse(rawParameters.toArray(String[]::new));
        // zmienilam na liste zeby moc dodawac zwierzatka po inicjalizacji
        List<Vector2d> animalStartingPositions = new ArrayList<>();
        animalStartingPositions.add(new Vector2d(-1, 2));
        animalStartingPositions.add(new Vector2d(3, 4));
        map = new GrassField(10);
        engine = new SimulationEngine(map,animalStartingPositions);
        engine.addObserver(this);
        //engine = new SimulationEngine(this, directions, map, animalStartingPositions);
    } //r l f l f f f l b f b f b f r r f b f b f b f f
    @Override
    public void start (Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("World");
        Button startButton = new Button("start");
        TextField text = new TextField();
        text.setFocusTraversable(false);
        text.setPromptText("Enter a valid move directions: f, b, r, l");
        text.setPrefColumnCount(30);
        HBox field = new HBox(text, startButton);
        stage.setScene(new Scene(field,400,25));
        stage.show();
        startButton.setOnAction(event -> {
            engine.setDirections(OptionsParser.parse(text.getText().split(" ")));
            Thread engineThread = new Thread(engine);
            engineThread.start();
        });
    }
    private void mapLayout(GridPane grid) {
        int numOfColumns = map.getUpperBound().getX() - map.getLowerBound().getX();
        int numOfRows = map.getUpperBound().getY() - map.getLowerBound().getY();

        grid.getColumnConstraints().add(new ColumnConstraints(WIDTH));
        grid.getRowConstraints().add(new RowConstraints(HEIGHT));
        grid.add(createLabel("y\\x"),0,0);

        for (int i = 0; i < numOfColumns + 1; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(WIDTH));
            grid.add(createLabel(Integer.toString(map.getLowerBound().getX() + i)),i+1,0);
        }
        for (int i = 0; i < numOfRows + 1; i++) {
            grid.getRowConstraints().add(new RowConstraints(HEIGHT));
            grid.add(createLabel(Integer.toString(map.getUpperBound().getY() - i)),0,i+1);
        }
    }
    private void placeElements(GridPane grid){
        //tworze nowe guielementy, ale za to wykorzystuje te same obrazki, nie wiem czy o to chodzilo w laborce :P
        for (Vector2d position: map.getElements().keySet()) {
            IMapElement element = map.objectAt(position);
            grid.add(new GuiElementBox(element, getImage(element)).getField(),
                    -map.getLowerBound().getX() + 1 + position.getX(),
                    map.getUpperBound().getY() + 1 - position.getY());
        }
    }
    private Image getImage(IMapElement element) {
        if (images.containsKey(element.getImageName())) {
            return images.get(element.getImageName());
        }
        else {
            try (FileInputStream file = new FileInputStream(element.getImageName()))
            {
                Image image = new Image(file);
                images.put(element.getImageName(), image);
                return image;
            }
            catch (IOException exception) {
                exception.printStackTrace();
                return null;
            }
        }
    }
    private Label createLabel(String text){
        Label label = new Label(text);
        GridPane.setHalignment(label, HPos.CENTER);
        return label;
    }

    @Override
    public void simulationChanged() {
        Platform.runLater(() -> {
            GridPane grid = new GridPane();
            grid.setGridLinesVisible(true);
            mapLayout(grid);
            placeElements(grid);
            stage.setScene(new Scene(grid));
            stage.show();
        });
    }
}

package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class GuiElementBox {
    private final VBox field;
    public GuiElementBox (IMapElement element, Image image) {
        int width = 30;
        int height = 30;
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        String name;
        if (element instanceof Animal) {
            name = element.getPosition().toString();
        }
        else {
            name = "Grass";
        }
        this.field = new VBox(imageView, new Label(name));
        this.field.setAlignment(Pos.CENTER);
    }

    public VBox getField() {
        return field;
    }
}

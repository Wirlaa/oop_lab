package agh.ics.oop;
import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void main(String[] args) {
        try {
            Application.launch(App.class, args);
            /*
            AWorldMap map = new RectangularMap(5,10);//new GrassField(10);
            MoveDirection[] directions = OptionsParser.parse(args);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            */
        } catch (IllegalArgumentException exception) {
            //"oraz zakończeniu działania programu" - i tak jest to ostatnia metoda w main, wiec program sam konczy dzialanie
            exception.printStackTrace();
        }
    }
}

// rozne stare komentarze ktore chce zostawic :)

// out.println(String.join(", ", directions)); fajny sposob na laczenie napisow

// stale to static final, nie tylko final, opisywane capslockiem np
// public static final Vector2d LOWER_BOUND = new Vector2d(0,0);

/*
    pytanie 10:
    moze trzymac liste wszystkich utworzonych obiektow i metode sprawdzajacą, czy pole na ktore przechodzimy nie jest zajete
    albo trzymac mape typu bool, ktora jest automatycznie aktualizowana i od razu zwraca czy miejsce jest wolne
    albo hashmape ktora robi to wszystko bardziej efektywnie :D
*/

// istnieje assertSame do sprawdzania adresow
// given when then

// istnieje optional ktore radzi sobie z nullami zamiast orElse

// kazda kolekcje mozna zamienic na streamy
// map, filter, reduce

// record gdy wszystkie pola sa final, ale przez to sa tez prywatne

// javowy random: Random generator = new Random()

// mapa get i put
// przegladanie mapy? .entrySet() .values() .keySet()

// https://refactoring.guru/design-patterns/observer

// nieskonczonosc to Integer.MAX_VALUE

// interface extends interface

// klasy anonimowe
// skladnia new IPositionChangeObserver() {metoda;}

// wyrażenie lambda - klasa anonimowa z jedna metoda dziedziczaca po interface

// skladnia (argumenty) -> metoda;

// System.exit(0), dla javafx Platform.exit()
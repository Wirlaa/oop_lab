package agh.ics.oop;
import agh.ics.oop.gui.App;
import agh.ics.oop.gui.AppOld;
import javafx.application.Application;


public class World {
    public static void main(String[] args) {
        try {
            //Application.launch(AppOld.class, args);
            Application.launch(App.class, args);
        } catch (IllegalArgumentException exception) {
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

// hashmap get i put
// przegladanie hashmapy .entrySet() .values() .keySet()

// https://refactoring.guru/design-patterns/observer

// nieskonczonosc to Integer.MAX_VALUE

// interface extends interface

// klasy anonimowe
// skladnia new IPositionChangeObserver() {metoda;}

// wyrażenie lambda - klasa anonimowa z jedna metoda dziedziczaca po interface

// skladnia (argumenty) -> metoda;

// System.exit(0), dla javafx Platform.exit()

// wyjatki raczej rzadko stosowac, kiedy trzeba sie bronic przed programista a nie uzytkownikiem

// throws nie trzeba przy unchecked

// stare getLower/UpperBound
// return elements.keySet().stream().reduce(Vector2d::lowerLeft).orElse(null);
// return elements.keySet().stream().reduce(Vector2d::upperRight).orElse(null);

// gdzie trzymac deklaracje wlasnych wyjatkow?
// czy lepiej unchecked zrobic throws jednak?
// kiedy uzywac stream a kiedy streamof?
// czy w laborce 8 chodziło o to, żeby reusować image i na ich podstawie robic nowe guielementy,
// czy trzymac gdzies informacje o guielementach zebych ich nie powtarzac?
// czy dobrym rozwiazaniem na pozbycie sie instanceof jest zrobienie funkcji getinstance ktora zwraca informacje o tym jakiego typu jest obiekt?
/* try (FileInputStream file = new FileInputStream(element.getImageName()))
            {
                Image image = new Image(file);
                images.put(element.getImageName(), image);
                return image;
            }
            catch (IOException exception) {
                exception.printStackTrace();
                return null;
            }
 */

// jaka jest konwencja na rozdzielanie kodu w gui? czy np trzymanie elementu grid w jednej klasie jest dobrym pomyslem?
// czy jest szansa na zrobienie jakiegos ogolnego intefejsu obserwera, ktory mialby jedna metode objectChanged,
// ale ktora przyjmowalaby argumenty roznego typu?
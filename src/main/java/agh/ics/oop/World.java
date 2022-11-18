package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        MoveDirection[] directions = OptionsParser.parse(args);
        //IWorldMap map = new RectangularMap(10, 5);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
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
*/

// istnieje assertSame do sprawdzania adresow
// given when then

// istnieje optional ktore radzi sobie z nullami zamiast orElse

// kazda kolekcje mozna zamienic na streamy
// map, filter, reduce

// record gdy wszystkie pola sa final, ale przez to sa tez prywatne

/*
    komentarz do objectAt przed przeczytamiem instrukcji do labow do konca :D
    imo entity to duzo lepsza nazwa niz mapelement
    nie podoba mi sie, ze nie dzialam na ogolnym obiekcie, ale pewnie jak przestaniemy korzystac z list to sie problem rozwiaze
    chcialam zamiast tego rozwiazania zrobic liste list obiektow, ale natrafilam na problem z typecastowaniem
    pewnie daloby sie to tak zrobic gdyby animal i grass dziedziczyly z jakiejs abstrakcyjnego klasy entity i mialy taka sama funkcje getPosition()
    a moze zle zrozumialam polecenie i objectAt ma nadal zwracac tylko zwierzeta
 */

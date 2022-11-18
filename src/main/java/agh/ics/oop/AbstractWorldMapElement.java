package agh.ics.oop;

// czemu nazwa to nagle WorldMapElement jak interface mial byc MapElement?
// jako ze mamy bardzo malo funkcjonalnosci to na razie wystarczylaby sama klasa abstrakcyjna, albo (chyba) interfejs z polami
public abstract class AbstractWorldMapElement implements IMapElement {
    protected Vector2d position;
    public Vector2d getPosition() { return position; }
}

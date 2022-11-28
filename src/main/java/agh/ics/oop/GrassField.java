package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap {
    public GrassField (int size) {
        List<Vector2d> positions = shuffleGrid(size);
        // czy da sie bez fora?
        for (int i = 0; i < size; i++) {
            elements.put(positions.get(i), new Grass(positions.get(i)));
        }
    }
    @Override
    public Vector2d getLowerBound() {
        return elements.keySet().stream().reduce(Vector2d::lowerLeft).orElse(null);
    }
    @Override
    public Vector2d getUpperBound() {
        return elements.keySet().stream().reduce(Vector2d::upperRight).orElse(null);
    }

    // "Nowe kępki trawy powinny pojawiać się losowo w obszarze z punktu 1"
    // Czy trzymac gdzies size jednak? albo pamietac liste uzywana do losowania?
    // i czy da sie ładniej ją wygenerować bez dwoch forow?
    private List<Vector2d> shuffleGrid(int size) {
        List<Vector2d> positionsGrid = new ArrayList<>();
        for (int i = 0; i < Math.sqrt(size*10); i++) {
            for (int j = 0; j < Math.sqrt(size*10); j++) {
                positionsGrid.add(new Vector2d(i,j));
            }
        }
        Collections.shuffle(positionsGrid);
        return positionsGrid;
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        if (objectAt(newPosition) instanceof Grass) {
            elements.remove(oldPosition, objectAt(oldPosition));
            List<Vector2d> positions = shuffleGrid(Math.max(getUpperBound().getX() - getLowerBound().getX(),getUpperBound().getY() - getLowerBound().getY()));
            elements.put(positions.get(0), new Grass(positions.get(0)));
        }
        super.positionChanged(oldPosition,newPosition);
    }
    // czy da się uniknac uzywania instanceof?
    public boolean canMoveTo (Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }
}

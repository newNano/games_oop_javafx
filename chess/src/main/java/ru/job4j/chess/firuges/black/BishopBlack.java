package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = (int) (Math.abs(dest.getX() - this.position.getX()));
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() > this.position.getX() ? 1 : -1;
        int deltaY = dest.getY() > this.position.getY() ? 1 : -1;
        for (int i = 0; i < size; i++) {
            steps[i] = Cell.findBy(this.position.getX() + deltaX * (i + 1), this.position.getY() + deltaY * (i + 1));
        }
        return steps;
    }

    public boolean isDiagonal(Cell dest) {
        int dx = (int) Math.abs(dest.getX() - this.position.getX());
        int dy = (int) Math.abs(dest.getY() - this.position.getY());
        if(dx != dy) {
            return false;
        }
        return true;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

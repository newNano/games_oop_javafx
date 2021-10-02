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
            int countSteps = i + 1;
            steps[i] = Cell.findBy(this.position.getX() + deltaX * countSteps,
                    this.position.getY() + deltaY * countSteps);
        }
        return steps;
    }

    public boolean isDiagonal(Cell dest) {
        return Math.abs(dest.getX() - this.position.getX())
                == Math.abs(dest.getY() - this.position.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

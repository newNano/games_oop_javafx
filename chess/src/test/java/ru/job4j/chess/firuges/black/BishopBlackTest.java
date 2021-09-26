package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        Figure figure = new BishopBlack(Cell.A1);
        Cell place = figure.position();
        assertThat(Cell.A1, is(place));
    }

    @Test
    public void way() {
        Figure figure = new BishopBlack(Cell.C1);
        Cell[] steps = figure.way(Cell.G5);
        Cell[] controlSteps = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(controlSteps, steps);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void isNotDiagonal() {
        Figure figure = new BishopBlack(Cell.C1);
        Cell[] steps = figure.way(Cell.F7);
    }

    @Test
    public void copy() {
        Figure figure = new BishopBlack(Cell.A1);
        figure = figure.copy(Cell.A2);
        assertThat(figure.position(), is(Cell.A2));
    }
}
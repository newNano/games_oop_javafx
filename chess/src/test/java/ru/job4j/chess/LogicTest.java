package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.BishopWhite;

public class LogicTest {
    @Test
    public void whenCorrectMove() throws FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenImpossibleMoveException()
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H5);
    }

    @Test (expected = OccupiedCellException.class)
    public void whenOccupiedCellException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException  {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopWhite(Cell.G5));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test (expected = FigureNotFoundException.class)
    public void whenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException  {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.D2, Cell.H6);
    }
}
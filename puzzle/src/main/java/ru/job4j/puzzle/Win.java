package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(checkDiagonal(i, j, board) && (checkHorizontal(i, board) || checkVertical(j, board))){
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }

    public static boolean checkDiagonal(int y, int x, int[][] array){
        if((y == x || (y + x) == array.length) && array[y][x] == 1){
            return true;
        }
        return false;
    }

    public static boolean checkHorizontal(int x, int[][] array){
        for (int i = 0; i < array.length; i++) {
            if(array[x][i] != 1){
                return false;
            }
        }
        return true;
    }

    public static boolean checkVertical(int y, int[][] array){
        for (int i = 0; i < array.length; i++) {
            if(array[i][y] != 1){
                return false;
            }
        }
        return true;
    }
}

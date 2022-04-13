package com.mumz.test.leet;

public class GameofLife {

    public void gameOfLife(int[][] board) {
        final int maxRow = board.length;
        final int maxColumn = board[0].length;
        int[][] output = new int[maxRow][maxColumn];
        for (int row = 0; row < maxRow; row++) {
            for (int column = 0; column < maxColumn; column++) {
                int cellValue = board[row][column];
                if (liveCellHasLessThanTwoLiveNeighbours(row, column, cellValue, board))
                    output[row][column] = 0;
                if (liveCellHasTwoOrThreeLiveNeighbours(row, column, cellValue, board))
                    output[row][column] = 1;
                if (liveCellHasMoreThanThreeLiveNeighbours(row, column, cellValue, board))
                    output[row][column] = 0;
                if (deadCellHasExactlyThreeLiveNeighbours(row, column, cellValue, board))
                    output[row][column] = 1;
            }
        }
        for (int row = 0; row < maxRow; row++)
            System.arraycopy(output[row], 0, board[row], 0, maxColumn);
    }

    private boolean liveCellHasLessThanTwoLiveNeighbours(
            int row,
            int column,
            int cellValue,
            int[][] board
    ) {
        if (cellValue == 0) return false;
        int totalValue = countLiveNeighbours(row, column, board);
        return totalValue < 2;
    }

    private boolean liveCellHasTwoOrThreeLiveNeighbours(
            int row,
            int column,
            int cellValue,
            int[][] board
    ) {
        if (cellValue == 0) return false;
        int totalValue = countLiveNeighbours(row, column, board);
        return totalValue >= 2 && totalValue <= 3;
    }

    private boolean liveCellHasMoreThanThreeLiveNeighbours(
            int row,
            int column,
            int cellValue,
            int[][] board
    ) {
        if (cellValue == 0) return false;
        int totalValue = countLiveNeighbours(row, column, board);
        return totalValue > 3;
    }

    private boolean deadCellHasExactlyThreeLiveNeighbours(
            int row,
            int column,
            int cellValue,
            int[][] board
    ) {
        if (cellValue == 1) return false;
        int totalValue = countLiveNeighbours(row, column, board);
        return totalValue == 3;
    }

    private int countLiveNeighbours(
            int row,
            int column,
            int[][] board
    ) {
        return
                leftValue(row, column, board) +
                rightValue(row, column, board) +
                topValue(row, column, board) +
                bottomValue(row, column, board) +
                leftUpperDiagonalValue(row, column, board) +
                rightUpperDiagonalValue(row, column, board) +
                leftBottomDiagonalValue(row, column, board) +
                rightBottomDiagonalValue(row, column, board);
    }

    private int leftValue(
            int row,
            int column,
            int[][] board
    ) {
        if (column == 0) return 0;
        else return board[row][column - 1];
    }

    private int rightValue(
            int row,
            int column,
            int[][] board
    ) {
        if (column == board[0].length - 1) return 0;
        else return board[row][column + 1];
    }

    private int topValue(
            int row,
            int column,
            int[][] board
    ) {
        if (row == 0) return 0;
        else return board[row - 1][column];
    }

    private int bottomValue(
            int row,
            int column,
            int[][] board
    ) {
        if (row == board.length - 1) return 0;
        else return board[row + 1][column];
    }

    private int leftUpperDiagonalValue(
            int row,
            int column,
            int[][] board
    ) {
        if (column == 0 || row == 0) return 0;
        else return board[row - 1][column - 1];
    }

    private int rightUpperDiagonalValue(
            int row,
            int column,
            int[][] board
    ) {
        if (column == board[0].length - 1 || row == 0) return 0;
        else return board[row - 1][column + 1];
    }

    private int leftBottomDiagonalValue(
            int row,
            int column,
            int[][] board
    ) {
        if (column == 0 || row == board.length - 1) return 0;
        else return board[row + 1][column - 1];
    }

    private int rightBottomDiagonalValue(
            int row,
            int column,
            int[][] board
    ) {
        if (column == board[0].length - 1 || row == board.length - 1) return 0;
        else return board[row + 1][column + 1];
    }

    public static void main(String[] args) {
        new GameofLife().gameOfLife(new int[][]{
                                            {0, 1, 0},
                                            {0, 0, 1},
                                            {1, 1, 1},
                                            {0, 0, 0}
                                    }
        );
    }
}

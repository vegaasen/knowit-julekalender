package com.vegaasen.fun.julekalender.knowit.y2014.luke;

/**
 * 3rd of december :-)
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public final class DecThird {

    private static final int MOVES = 10;
    private static final int MAX_Y = 9, MAX_X = 9;
    private static final Cell[][] BOARD = new Cell[MAX_Y][MAX_X];
    private static final Horse HORSE = new Horse();
    public static final int ZERO = 0;

    public static void main(String... args) {
        final DecThird luke = new DecThird();
        luke.doIt(MOVES, BOARD, HORSE);
    }

    private void initializeBoard(final Cell[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    private void doIt(final int moves, final Cell[][] board, final Horse horse) {
        initializeBoard(board);
        int c = 0;
        while (c++ <= moves) {
            horse.moveToBestPosition(board);
            drawIt(board, horse);
        }
    }

    private void drawIt(final Cell[][] board, final Horse horse) {
        final StringBuilder drawable = new StringBuilder();
        for (final Cell[] aBoard : board) {
            for (int j = 0; j < MAX_Y; j++) {
                drawable.append(aBoard[j].black ? "*" : " ").append("|");
            }
            drawable.append("\n");
        }
        System.out.println(drawable.toString());
    }

    private class Cell {

        private boolean black = false;

    }

    private static class Horse {

        private int currentXPos, currentYPos;

        /**
         * Moves the Horse to the best position available :-)
         * Best case: Always use the lowest numbers (calculate it)
         *
         * @return _
         */
        public boolean moveToBestPosition(final Cell[][] board) {
            return moveLeftUp(board) || moveRightUp(board) || moveLeftDown(board) || moveRightDown(board);
        }

        private boolean moveLeftUp(final Cell[][] board) {
            return move(board, currentXPos - 2, currentYPos - 1);
        }

        private boolean moveLeftDown(final Cell[][] board) {
            return move(board, currentXPos + 2, currentYPos - 1);
        }

        private boolean moveRightDown(final Cell[][] board) {
            return move(board, currentXPos + 2, currentYPos + 1);
        }

        private boolean moveRightUp(final Cell[][] board) {
            return move(board, currentXPos - 2, currentYPos + 1);
        }

        private boolean move(final Cell[][] board, final int wantedXPos, final int wantedYPos) {
            if (wantedYPos <= ZERO || wantedXPos <= ZERO) {
                return false;
            }
            if (wantedYPos >= MAX_Y && wantedXPos >= MAX_X) {
                return false;
            }
            if (!isWantedPositionValid(board, wantedXPos, wantedYPos)) {
                return false;
            }
            setCurrentYPos(wantedYPos);
            setCurrentXPos(wantedXPos);
            System.out.println(
                    String.format(
                            "Moved the horse to x:{%s}, y{%s}, from x:{%s}, y{%s}",
                            currentXPos, currentYPos, wantedXPos, wantedYPos
                    ));
            return true;
        }

        private boolean isWantedPositionValid(final Cell[][] board, final int candidateXPos, final int candidateYPos) {
            System.out.println(String.format("Trying to verify x:{%s} and y:{%s}", candidateXPos, candidateYPos));
            return board[candidateYPos][candidateXPos].black && board[currentYPos][currentXPos].black;
        }

        public void setCurrentXPos(int currentXPos) {
            this.currentXPos = currentXPos;
        }

        public void setCurrentYPos(int currentYPos) {
            this.currentYPos = currentYPos;
        }
    }

}

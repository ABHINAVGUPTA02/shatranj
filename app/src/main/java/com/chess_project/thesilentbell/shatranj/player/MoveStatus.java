package com.chess_project.thesilentbell.shatranj.player;

public enum MoveStatus {
    DONE{
        @Override
        boolean isDone() {
            return true;
        }
    };
    abstract boolean isDone();
}

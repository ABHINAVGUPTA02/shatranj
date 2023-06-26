package com.chess_project.thesilentbell.shatranj;

public enum Alliance {
    WHITE{
        @Override
        public int getDirection(){
            return -1;
        }

        @Override
        public boolean isWhite(){
            return true;
        }

        @Override
        public boolean isBlack() {
            return false;
        }
    },
    BLACK{
        @Override
        public int getDirection(){
            return 1;
        }

        @Override
        public boolean isWhite(){
            return false;
        }

        @Override
        public boolean isBlack() {
            return true;
        }
    };
    abstract public int getDirection();
    public abstract boolean isWhite();
    public abstract boolean isBlack();
}

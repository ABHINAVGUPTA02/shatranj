package com.chess_project.thesilentbell.shatranj;

public enum Alliance {
    WHITE{
        @Override
        public int getDirection(){
            return -1;
        }
    },
    BLACK{
        @Override
        public int getDirection(){
            return 1;
        }
    };
    abstract public int getDirection();
}

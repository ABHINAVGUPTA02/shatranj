package com.chess_project.thesilentbell.shatranj.board;

import com.chess_project.thesilentbell.shatranj.piece.Piece;

import static com.chess_project.thesilentbell.shatranj.board.Board.*;
public abstract class Move {
    final Board board;
    final Piece movedPiece;
    final int destinationCoordinate;

    private Move(final Board board,final Piece movedPiece,final int destinationCoordinate) {
        this.board = board;
        this.movedPiece = movedPiece;
        this.destinationCoordinate = destinationCoordinate;
    }

    public int getDestinationCoordinate(){
        return this.destinationCoordinate;
    }

    public Piece getMovedPiece(){
        return this.movedPiece;
    }

    public abstract Board execute();

    public static final class MajorMove extends Move{

        public MajorMove(final Board board,final Piece piece,final int destinationCoordinate) {
            super(board, piece, destinationCoordinate);
        }

        @Override
        public Board execute() {
            final Builder builder = new Builder();

            for(final Piece piece: this.board.getCurrentPlayer().getActivePieces()){
                //TODO hashcode and equals for pieces
                if(!this.movedPiece.equals(piece)){
                    builder.setPiece(piece);
                }
            }

            for(final Piece piece: this.board.getCurrentPlayer().getOpponent().getActivePieces()){
                builder.setPiece(piece);
            }
            //move the moved piece
            builder.setPiece(this.movedPiece.movedPiece(this));
            builder.setMoveMaker(this.board.getCurrentPlayer().getOpponent().getAlliance());
            return builder.build();
        }
    }

    public static final class AttackMove extends Move{

        final Piece attackedPiece;

        public AttackMove(final Board board,final Piece piece,final int destinationCoordinate,final Piece attackedPiece) {
            super(board, piece, destinationCoordinate);
            this.attackedPiece = attackedPiece;
        }

        @Override
        public Board execute() {
            return null;
        }
    }

}

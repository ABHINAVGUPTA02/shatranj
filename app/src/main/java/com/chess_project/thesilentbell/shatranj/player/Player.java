package com.chess_project.thesilentbell.shatranj.player;

import com.chess_project.thesilentbell.shatranj.board.Board;
import com.chess_project.thesilentbell.shatranj.board.Move;
import com.chess_project.thesilentbell.shatranj.piece.King;
import com.chess_project.thesilentbell.shatranj.piece.Piece;

import java.util.Collection;

public abstract class Player {
    protected final Board board;
    protected final King playerKing;
    protected final Collection<Move> legalMoves;


    public Player(Board board, Collection<Move> legalMoves, Collection<Move> opponentMoves) {
        this.board = board;
        this.legalMoves = legalMoves;
        this.playerKing = establishKing();
    }

    private King establishKing(){
        for(final Piece piece: getActivePieces()){
            if(piece.getPieceType().isKing()){
                return (King) piece;
            }
        }

        throw new RuntimeException("Should not reach here! Not a Valid Board");
    }

    public abstract Collection<Piece> getActivePieces();

}

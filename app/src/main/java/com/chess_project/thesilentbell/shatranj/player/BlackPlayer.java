package com.chess_project.thesilentbell.shatranj.player;

import com.chess_project.thesilentbell.shatranj.board.Board;
import com.chess_project.thesilentbell.shatranj.board.Move;
import com.chess_project.thesilentbell.shatranj.piece.Piece;

import java.util.Collection;

public class BlackPlayer extends Player{
    public BlackPlayer(Board board, Collection<Move> whiteStandardLegalMoves, Collection<Move> blackStandardLegalMoves) {
        super(board,blackStandardLegalMoves,whiteStandardLegalMoves);
    }

    @Override
    public Collection<Piece> getActivePieces() {
        return this.board.getBlackPieces();
    }
}

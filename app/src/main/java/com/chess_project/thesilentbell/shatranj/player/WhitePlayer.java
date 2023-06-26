package com.chess_project.thesilentbell.shatranj.player;

import com.chess_project.thesilentbell.shatranj.Alliance;
import com.chess_project.thesilentbell.shatranj.board.Board;
import com.chess_project.thesilentbell.shatranj.board.Move;
import com.chess_project.thesilentbell.shatranj.piece.Piece;

import java.util.Collection;

public class WhitePlayer extends Player{
    public WhitePlayer(Board board, Collection<Move> whiteStandardLegalMoves, Collection<Move> blackStandardLegalMoves) {
        super(board,whiteStandardLegalMoves,blackStandardLegalMoves);
    }
    @Override
    public Collection<Piece> getActivePieces() {
        return this.board.getWhitePieces();
    }

    @Override
    public Alliance getAlliance() {
        return Alliance.WHITE;
    }

    @Override
    public Player getOpponent() {
        return this.board.blackPlayer();
    }
}

package com.chess_project.thesilentbell.shatranj.player;

import com.chess_project.thesilentbell.shatranj.Alliance;
import com.chess_project.thesilentbell.shatranj.board.Board;
import com.chess_project.thesilentbell.shatranj.board.Move;
import com.chess_project.thesilentbell.shatranj.board.Tile;
import com.chess_project.thesilentbell.shatranj.piece.Piece;
import com.chess_project.thesilentbell.shatranj.piece.Rook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BlackPlayer extends Player{
    public BlackPlayer(final Board board, final Collection<Move> whiteStandardLegalMoves, final Collection<Move> blackStandardLegalMoves) {
        super(board,blackStandardLegalMoves,whiteStandardLegalMoves);
    }

    @Override
    public Collection<Piece> getActivePieces() {
        return this.board.getBlackPieces();
    }

    @Override
    public Alliance getAlliance() {
        return Alliance.BLACK;
    }

    @Override
    public Player getOpponent() {
        return this.board.whitePlayer();
    }

    @Override
    public Collection<Move> calculatingKingCastles(final Collection<Move> playerLegals, final Collection<Move> opponentLegals) {
        final List<Move> kingCastles = new ArrayList<>();

        if(this.playerKing.isFirstMove() && (!this.isInCheck())){
            //Black king side castle
            if(!(this.board.getTile(5).isTileOccupied()) && !(this.board.getTile(6).isTileOccupied())){
                final Tile rookTile = this.board.getTile(7);
                if(rookTile.isTileOccupied() && rookTile.getPiece().isFirstMove()){
                    if(Player.calculateAttacksOnTile(5,opponentLegals).isEmpty() &&
                            Player.calculateAttacksOnTile(6,opponentLegals).isEmpty() &&
                            rookTile.getPiece().getPieceType().isRook()){
                        //TODO add a CASTLE MOVE!
                        kingCastles.add(new Move.kingSideCastleMove(this.board,
                                                                    this.playerKing,
                                                    6,
                                                                    (Rook) rookTile.getPiece() ,
                                                                    rookTile.getTileCoordinate(),
                                                    5));
                    }
                }
            }

            if(!this.board.getTile(1).isTileOccupied() &&
                    !this.board.getTile(2).isTileOccupied() &&
                    !this.board.getTile(3).isTileOccupied()){
                final Tile rookTile = this.board.getTile(0);
                if(rookTile.isTileOccupied() && rookTile.getPiece().isFirstMove()){
                    //TODO add castle move
                    kingCastles.add(new Move.queenSideCastleMove(this.board,
                                                                this.playerKing,
                                                2,
                                                                (Rook) rookTile.getPiece() ,
                                                                rookTile.getTileCoordinate(),
                                                3));
                }
            }
        }

        return Collections.unmodifiableList(kingCastles);
    }
}

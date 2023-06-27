package com.chess_project.thesilentbell.shatranj.player;

import static com.chess_project.thesilentbell.shatranj.board.Move.*;

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

public class WhitePlayer extends Player{
    public WhitePlayer(final Board board, final Collection<Move> whiteStandardLegalMoves, final Collection<Move> blackStandardLegalMoves) {
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

    @Override
    public Collection<Move> calculatingKingCastles(final Collection<Move> playerLegals, final Collection<Move> opponentLegals) {
        final List<Move> kingCastles = new ArrayList<>();

        if(this.playerKing.isFirstMove() && (!this.isInCheck())){
            //White king side castle
            if(!(this.board.getTile(61).isTileOccupied()) && !(this.board.getTile(62).isTileOccupied())){
                final Tile rookTile = this.board.getTile(63);
                if(rookTile.isTileOccupied() && rookTile.getPiece().isFirstMove()){
                    if(Player.calculateAttacksOnTile(61,opponentLegals).isEmpty() &&
                       Player.calculateAttacksOnTile(62,opponentLegals).isEmpty() &&
                       rookTile.getPiece().getPieceType().isRook()){
                        //TODO add a CASTLE MOVE!
                        kingCastles.add(new kingSideCastleMove(this.board,
                                                                    this.playerKing,
                                                    62,
                                                                    (Rook) rookTile.getPiece() ,
                                                                    rookTile.getTileCoordinate(),
                                                    61));
                    }
                }
            }

            if(!this.board.getTile(59).isTileOccupied() &&
               !this.board.getTile(58).isTileOccupied() &&
               !this.board.getTile(57).isTileOccupied()){
                final Tile rookTile = this.board.getTile(56);
                if(rookTile.isTileOccupied() && rookTile.getPiece().isFirstMove()){
                    //TODO add castle move
                    kingCastles.add(new queenSideCastleMove(this.board,
                                                            this.playerKing,
                                            58,
                                                            (Rook) rookTile.getPiece(),
                                                            rookTile.getTileCoordinate(),
                                            59));
                }
            }
        }

        return Collections.unmodifiableList(kingCastles);
    }
}

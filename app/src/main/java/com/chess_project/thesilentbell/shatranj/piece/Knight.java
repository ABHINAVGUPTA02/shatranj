package com.chess_project.thesilentbell.shatranj.piece;

import com.chess_project.thesilentbell.shatranj.Alliance;
import com.chess_project.thesilentbell.shatranj.board.Board;
import com.chess_project.thesilentbell.shatranj.board.Move;
import com.chess_project.thesilentbell.shatranj.board.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knight extends Piece{

    private final static int[] CANDIDATE_MOVE_COORDINATES = {-17,-15,-10,-6,6,10,15,17};

    public Knight(int piecePosition, Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public List<Move> calculateLegalMoves(Board board) {
        int candidateDestinationCoordinate;
        final List<Move> LegalMoves = new ArrayList<>();

        for(final int currentCandidate: CANDIDATE_MOVE_COORDINATES){
            candidateDestinationCoordinate = this.piecePosition + currentCandidate;

            if(true /*isValidCoordinate*/){
                final Tile candinateDestinationTile =  board.getTile(candidateDestinationCoordinate);
                if(!candinateDestinationTile.isTileOccupied()){
                    LegalMoves.add(new Move());
                }else{
                    final Piece pieceAtDestination = candinateDestinationTile.getPiece();
                    final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();

                    if(this.pieceAlliance != pieceAlliance){
                        LegalMoves.add(new Move());
                    }
                }
            }
        }

        return Collections.unmodifiableList(LegalMoves);
    }
}

package com.chess_project.thesilentbell.shatranj.piece;

import com.chess_project.thesilentbell.shatranj.Alliance;
import com.chess_project.thesilentbell.shatranj.board.Board;
import com.chess_project.thesilentbell.shatranj.board.BoardUtils;
import com.chess_project.thesilentbell.shatranj.board.Move;
import static com.chess_project.thesilentbell.shatranj.board.Move.*;
import com.chess_project.thesilentbell.shatranj.board.Tile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Bishop extends Piece{

    private final static int[] CANDIDATE_MOVE_VECTOR_COORDINATES = {-9,-7,7,9};

    public Bishop(int piecePosition, Alliance pieceAlliance) {
        super(PieceType.BISHOP,piecePosition, pieceAlliance);
    }

    @Override
    public Bishop movedPiece(final Move move) {
        return new Bishop(move.getDestinationCoordinate(),move.getMovedPiece().getPieceAlliance());
    }

    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {

        final List<Move> LegalMoves = new ArrayList<>();

        for (final int candidateCoordinateOffset : CANDIDATE_MOVE_VECTOR_COORDINATES) {
            int candidateDestinationCoordinate = this.piecePosition;
            while (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {

                if(isFirstColumnExclusion(candidateDestinationCoordinate,candidateCoordinateOffset) || isEightColumnExclusion(candidateDestinationCoordinate,candidateCoordinateOffset)) {
                    break;
                }
                candidateDestinationCoordinate += candidateCoordinateOffset;

                if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                    final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
                    if (!candidateDestinationTile.isTileOccupied()) {
                        LegalMoves.add(new MajorMove(board, this, candidateDestinationCoordinate));
                    } else {
                        final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                        final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();

                        if (this.pieceAlliance != pieceAlliance) {
                            LegalMoves.add(new AttackMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
                        }
                        break;
                    }
                }
            }
        }
        return Collections.unmodifiableList(LegalMoves);
    }

    @Override
    public String toString(){
        return PieceType.BISHOP.toString();
    }

    private static boolean isFirstColumnExclusion(final int currentPosition,final int candidateOffset){
        return BoardUtils.FIRST_COLUMN[currentPosition] && ((candidateOffset == -9) || (candidateOffset == 7));
    }

    private static boolean isEightColumnExclusion(final int currentPosition,final int candidateOffset){
        return BoardUtils.EIGHTH_COLUMN[currentPosition] && ((candidateOffset == 9) || (candidateOffset == -7));
    }
}

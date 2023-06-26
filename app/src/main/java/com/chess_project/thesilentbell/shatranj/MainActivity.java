package com.chess_project.thesilentbell.shatranj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.chess_project.thesilentbell.shatranj.board.Board;

public class MainActivity extends AppCompatActivity {
    private TextView boardTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boardTextView = findViewById(R.id.boardTextView);
        Board board = Board.createStandardBoard();
        displayBoard(board);
    }

    private void displayBoard(Board board) {
        String boardString = board.toString();
        boardTextView.setText(boardString);
    }
}
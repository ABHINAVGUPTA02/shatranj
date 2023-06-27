package com.chess_project.thesilentbell.shatranj;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class ChessView extends View {

    private static final int NUM_ROWS = 8;
    private static final int NUM_COLS = 8;
    private static final float CELL_SIZE = 130f;

    private Paint darkSquarePaint;
    private Paint lightSquarePaint;

    private float boardWidth;
    private float boardHeight;
    private float offsetX;
    private float offsetY;

    public ChessView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        darkSquarePaint = new Paint();
        darkSquarePaint.setColor(Color.DKGRAY);
        darkSquarePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        lightSquarePaint = new Paint();
        lightSquarePaint.setColor(Color.LTGRAY);
        lightSquarePaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);

        // Calculate the board dimensions and offset based on the view size
        boardWidth = NUM_COLS * CELL_SIZE;
        boardHeight = NUM_ROWS * CELL_SIZE;

        offsetX = (width - boardWidth) / 2f;
        offsetY = (height - boardHeight) / 2f;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw the chessboard
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                float left = offsetX + col * CELL_SIZE;
                float top = offsetY + row * CELL_SIZE;
                float right = left + CELL_SIZE;
                float bottom = top + CELL_SIZE;

                // Alternate between dark and light squares
                Paint squarePaint = (row + col) % 2 == 0 ? lightSquarePaint : darkSquarePaint;
                canvas.drawRect(left, top, right, bottom, squarePaint);
            }
        }
    }
}

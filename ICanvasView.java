package com.hfad.rgbcircles;

public interface ICanvasView {
    void drawCircle (SimpleCircle circle);

    void redraw();

    void showMessage(String text);
}

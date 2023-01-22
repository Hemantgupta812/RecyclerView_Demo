package com.example.fontrecyclerview;

import android.graphics.Typeface;

public interface FontDataAccessInterface {
    int getFontsCount();
    Typeface getFontAtPosition(int position);
    int getSelectedFontPosition();
    String getFontNameAtPosition(int position);
}

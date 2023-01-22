package com.example.fontrecyclerview;

import android.graphics.Bitmap;

public interface FontSelectorViewInterface {
    void notifyFontSelectionChangedAtPosition(int position);
    void setTextItemBitmap(Bitmap text);
}

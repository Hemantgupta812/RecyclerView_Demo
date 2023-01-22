package com.example.fontrecyclerview;

public class FontDataModel {
    int id;
    String fontName;
    boolean selected;

    public FontDataModel() {
    }

    public FontDataModel(int id, String fontName, boolean selected) {
        this.id = id;
        this.fontName = fontName;
        this.selected = selected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }


}

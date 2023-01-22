package com.example.fontrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FontSelectorViewListener,FontDataAccessInterface{
    //create LinearLayout
    LinearLayout linearLayout;
    FontSelectorViewInterface fontSelectorViewInterface;
    String[] fontsList;
    ArrayList<FontDataModel> fontList = new ArrayList<>();
    int selectedPosition = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=findViewById(R.id.linearlayout);

        // prepare font data
        String folderName = "fonts";
        try {
            fontsList = getAssets().list(folderName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //create the object of FontSelectorView
         fontSelectorViewInterface=new FontSelectorView(this,this,this);
        //add view
        linearLayout.addView((View) fontSelectorViewInterface);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.indianflag);

        fontSelectorViewInterface.setTextItemBitmap(bitmap);


    }


    @Override
    public void onFontViewClicked(int position) {
        fontSelectorViewInterface.notifyFontSelectionChangedAtPosition(selectedPosition);
        this.selectedPosition =position;
        fontSelectorViewInterface.notifyFontSelectionChangedAtPosition(selectedPosition);
    }

    @Override
    public int getFontsCount() {
        return fontsList.length;
    }

    @Override
    public Typeface getFontAtPosition(int position) {
        return Typeface.createFromAsset(getAssets(),"fonts/"+fontsList[position]);
    }

    @Override
    public int getSelectedFontPosition() {
        return selectedPosition;
    }

    @Override
    public String getFontNameAtPosition(int position) {
        return fontsList[position];
    }
}
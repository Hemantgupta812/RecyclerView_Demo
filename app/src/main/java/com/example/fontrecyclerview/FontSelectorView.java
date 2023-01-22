package com.example.fontrecyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FontSelectorView extends LinearLayout implements FontSelectorViewInterface {
    RecyclerView recyclerView;
    ImageView imageView;
    FontSelectorAdapter fontSelectorAdapter;
    public FontSelectorView(Context context) {
        super(context);
        init( context,null,null);
    }

    public FontSelectorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init( context,null,null);
    }

    public FontSelectorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init( context,null,null);
    }

    public FontSelectorView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init( context,null,null);
    }

    public FontSelectorView(Context context, FontSelectorViewListener fontSelectorViewListener,FontDataAccessInterface fontDataAccessInterface) {
        super(context);
        init(context,fontSelectorViewListener,fontDataAccessInterface);

    }

    private void init( Context context,FontSelectorViewListener fontSelectorViewListener,FontDataAccessInterface fontDataAccessInterface) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        layoutInflater.inflate(R.layout.font_selector_view, this);
        recyclerView = findViewById(R.id.recyclerview);
        imageView=findViewById(R.id.imageview);

        //Create the adapter class
        if ( fontSelectorViewListener != null && fontDataAccessInterface != null) {
            fontSelectorAdapter = new FontSelectorAdapter(context, fontSelectorViewListener, fontDataAccessInterface);
            //set the adapter in recyclerview
            recyclerView.setAdapter(fontSelectorAdapter);
            //Set LayoutManager
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            //set layout manager with recyclerview
            recyclerView.setLayoutManager(linearLayoutManager);
        }

    }

    @Override
    public void notifyFontSelectionChangedAtPosition(int position) {
        fontSelectorAdapter.notifyItemChanged(position);

    }

    @Override
    public void setTextItemBitmap(Bitmap text) {
        imageView.setImageBitmap(text);
    }
}

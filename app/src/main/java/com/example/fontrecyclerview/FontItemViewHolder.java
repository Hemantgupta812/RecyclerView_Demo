package com.example.fontrecyclerview;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;

public class FontItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public final ImageView fontRightIconView;
    public final TextView fontTextView;
    WeakReference<FontSelectorViewListener> fontSelectorViewListenerWeakReference;
    WeakReference<FontDataAccessInterface> fontDataAccessInterfaceWeakReference;
    int position = -1;

    public FontItemViewHolder(@NonNull View itemView, FontSelectorViewListener fontSelectorViewListener, FontDataAccessInterface fontDataAccessInterface) {
        super(itemView);
        fontRightIconView = itemView.findViewById(R.id.right_click_icon);
        fontTextView = itemView.findViewById(R.id.font_text);
        fontSelectorViewListenerWeakReference = new WeakReference<>(fontSelectorViewListener);
        fontDataAccessInterfaceWeakReference = new WeakReference<>(fontDataAccessInterface);

        itemView.setOnClickListener(this);
    }

    public void onBindDataInView(int position) {
        this.position = position;
        if (fontDataAccessInterfaceWeakReference != null && fontDataAccessInterfaceWeakReference.get() != null) {
            Typeface typeface = fontDataAccessInterfaceWeakReference.get().getFontAtPosition(position);
            fontTextView.setTypeface(typeface);
            fontTextView.setText(fontDataAccessInterfaceWeakReference.get().getFontNameAtPosition(position));
            int selectedFontPosition = fontDataAccessInterfaceWeakReference.get().getSelectedFontPosition();
            if (selectedFontPosition == position) {
                fontRightIconView.setVisibility(View.VISIBLE);
            } else {
                fontRightIconView.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (fontSelectorViewListenerWeakReference != null && fontSelectorViewListenerWeakReference.get() != null && position != -1) {
            fontSelectorViewListenerWeakReference.get().onFontViewClicked(position);
        }
    }
}

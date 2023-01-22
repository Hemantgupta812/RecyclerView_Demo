package com.example.fontrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;

public class FontSelectorAdapter extends RecyclerView.Adapter<FontItemViewHolder> {
    LayoutInflater layoutInflater;
    WeakReference<Context>contextWeakReference;

    WeakReference<FontSelectorViewListener> fontSelectorViewListenerWeakReference;
    WeakReference<FontDataAccessInterface>fontDataAccessInterfaceWeakReference;

    public FontSelectorAdapter(Context context, FontSelectorViewListener fontSelectorViewListener, FontDataAccessInterface fontDataAccessInterface) {
        layoutInflater=LayoutInflater.from(context);
        contextWeakReference=new WeakReference<>(context);
        fontSelectorViewListenerWeakReference=new WeakReference<>(fontSelectorViewListener);
        fontDataAccessInterfaceWeakReference= new WeakReference<>(fontDataAccessInterface);
    }

    @NonNull
    @Override
    public FontItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.font_item_view,parent,false);
        if (fontSelectorViewListenerWeakReference!=null&&fontSelectorViewListenerWeakReference.get()!=null&&fontDataAccessInterfaceWeakReference!=null&&fontDataAccessInterfaceWeakReference.get()!=null){
           return  new FontItemViewHolder(itemView,fontSelectorViewListenerWeakReference.get(),fontDataAccessInterfaceWeakReference.get());
        }else
        {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull FontItemViewHolder holder, int position) {
//        FontDataModel fontDataModel =fontList.get(position);
        if (contextWeakReference!=null&&contextWeakReference.get()!=null) {
            holder.onBindDataInView(position);
        }

    }

    @Override
    public int getItemCount() {
        if (fontDataAccessInterfaceWeakReference != null && fontDataAccessInterfaceWeakReference.get() != null) {
            return fontDataAccessInterfaceWeakReference.get().getFontsCount();
        }else{
            return 0;
        }
    }
}

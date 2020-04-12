package com.brewhog.android.retrofit_java.adapters;

import android.os.Build;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.brewhog.android.retrofit_java.pojo.Anekdot;
import com.brewhog.android.retrofit_java.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnekdotHolder extends RecyclerView.ViewHolder {
    private TextView post;
    private TextView site;

    public AnekdotHolder(@NonNull View itemView) {
        super(itemView);
        post = itemView.findViewById(R.id.post_text);
        site = itemView.findViewById(R.id.site_text);
    }

    public void bind(Anekdot anekdot){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            post.setText(Html.fromHtml(anekdot.getElementPureHtml(),Html.FROM_HTML_MODE_LEGACY));
        }else {
            post.setText(Html.fromHtml(anekdot.getElementPureHtml()));
        }
        site.setText(anekdot.getSite());
    }
}

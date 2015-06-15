package net.hosain.voat.service;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import net.hosain.voat.R;
import net.hosain.voat.VoatApp;

import javax.inject.Inject;

public class ImageService {
    @Inject
    Picasso picasso;

    public ImageService() {
        VoatApp.component.inject(this);
    }

    public void loadThumbnail(String url, ImageView view) {
        picasso.load(url).placeholder(R.drawable.goat).into(view);
    }
}

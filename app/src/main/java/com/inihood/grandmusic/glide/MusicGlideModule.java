package com.inihood.grandmusic.glide;

import android.content.Context;

import java.io.InputStream;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.module.GlideModule;
import com.inihood.grandmusic.glide.artistimage.ArtistImage;
import com.inihood.grandmusic.glide.artistimage.ArtistImageLoader;
import com.inihood.grandmusic.glide.audiocover.AudioFileCover;
import com.inihood.grandmusic.glide.audiocover.AudioFileCoverLoader;

public class MusicGlideModule implements GlideModule {

  	@Override
  	public void applyOptions(Context context, GlideBuilder builder) {
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        glide.register(AudioFileCover.class, InputStream.class, new AudioFileCoverLoader.Factory());
        glide.register(ArtistImage.class, InputStream.class, new ArtistImageLoader.Factory());
    }
}

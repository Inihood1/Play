package com.inihood.grandmusic.util;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LastFMUtil {
    public enum ImageSize {
        SMALL, MEDIUM, LARGE, EXTRALARGE, MEGA, UNKNOWN
    }

    private static String getLargestImageUrl(Map<ImageSize, String> imageUrls) {
        if (imageUrls.containsKey(ImageSize.MEGA)) {
            return imageUrls.get(ImageSize.MEGA);
        }
        if (imageUrls.containsKey(ImageSize.EXTRALARGE)) {
            return imageUrls.get(ImageSize.EXTRALARGE);
        }
        if (imageUrls.containsKey(ImageSize.LARGE)) {
            return imageUrls.get(ImageSize.LARGE);
        }
        if (imageUrls.containsKey(ImageSize.MEDIUM)) {
            return imageUrls.get(ImageSize.MEDIUM);
        }
        if (imageUrls.containsKey(ImageSize.SMALL)) {
            return imageUrls.get(ImageSize.SMALL);
        }
        if (imageUrls.containsKey(ImageSize.UNKNOWN)) {
            return imageUrls.get(ImageSize.UNKNOWN);
        }
        return null;
    }
}

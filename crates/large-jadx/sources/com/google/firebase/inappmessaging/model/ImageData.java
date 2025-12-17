package com.google.firebase.inappmessaging.model;

import android.graphics.Bitmap;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class ImageData {

    private final Bitmap bitmapData;
    private final String imageUrl;

    public static class Builder {

        private Bitmap bitmapData;
        private String imageUrl;
        public com.google.firebase.inappmessaging.model.ImageData build() {
            if (TextUtils.isEmpty(this.imageUrl)) {
            } else {
                ImageData imageData = new ImageData(this.imageUrl, this.bitmapData);
                return imageData;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ImageData model must have an imageUrl");
            throw illegalArgumentException;
        }

        public com.google.firebase.inappmessaging.model.ImageData.Builder setBitmapData(Bitmap bitmap) {
            this.bitmapData = bitmap;
            return this;
        }

        public com.google.firebase.inappmessaging.model.ImageData.Builder setImageUrl(String string) {
            if (!TextUtils.isEmpty(string)) {
                this.imageUrl = string;
            }
            return this;
        }
    }
    public ImageData(String string, Bitmap bitmap2) {
        super();
        this.imageUrl = string;
        this.bitmapData = bitmap2;
    }

    public static com.google.firebase.inappmessaging.model.ImageData.Builder builder() {
        ImageData.Builder builder = new ImageData.Builder();
        return builder;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (object == this) {
            return i;
        }
        final int i3 = 0;
        if (object instanceof ImageData == null) {
            return i3;
        }
        if (hashCode() != (ImageData)object.hashCode()) {
            return i3;
        }
        if (this.imageUrl.equals(object.imageUrl)) {
            return i;
        }
        return i3;
    }

    public Bitmap getBitmapData() {
        return this.bitmapData;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int hashCode() {
        int i;
        Bitmap bitmapData = this.bitmapData;
        if (bitmapData != null) {
            i = bitmapData.hashCode();
        } else {
            i = 0;
        }
        return i2 += i;
    }
}

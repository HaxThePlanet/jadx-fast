package com.vimeo.networking.model.playback.embed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class EmbedHtml implements Serializable {

    private static final long serialVersionUID = 3752755790501317766L;
    @SerializedName("height")
    private int mHeight;
    @SerializedName("html")
    private String mHtml;
    @SerializedName("width")
    private int mWidth;
    @Override // java.io.Serializable
    public int getHeight() {
        return this.mHeight;
    }

    @Override // java.io.Serializable
    public String getHtml() {
        return this.mHtml;
    }

    @Override // java.io.Serializable
    public int getWidth() {
        return this.mWidth;
    }
}

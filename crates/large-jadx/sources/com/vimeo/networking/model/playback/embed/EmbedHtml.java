package com.vimeo.networking.model.playback.embed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: EmbedHtml.java */
/* loaded from: classes2.dex */
public class EmbedHtml implements Serializable {

    private static final long serialVersionUID = 3752755790501317766L;
    @SerializedName("height")
    private int mHeight;
    @SerializedName("html")
    private String mHtml;
    @SerializedName("width")
    private int mWidth;
    public int getHeight() {
        return this.mHeight;
    }

    public String getHtml() {
        return this.mHtml;
    }

    public int getWidth() {
        return this.mWidth;
    }
}

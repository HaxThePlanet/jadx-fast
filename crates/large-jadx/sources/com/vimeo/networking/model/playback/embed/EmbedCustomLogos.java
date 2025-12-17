package com.vimeo.networking.model.playback.embed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class EmbedCustomLogos implements Serializable {

    private static final long serialVersionUID = -8919686101651093878L;
    @SerializedName("active")
    private boolean mActive;
    @SerializedName("link")
    private String mLink;
    @SerializedName("sticky")
    private boolean mSticky;
    @Override // java.io.Serializable
    public String getLink() {
        return this.mLink;
    }

    @Override // java.io.Serializable
    public boolean isActive() {
        return this.mActive;
    }

    @Override // java.io.Serializable
    public boolean isSticky() {
        return this.mSticky;
    }

    @Override // java.io.Serializable
    public void setActive(boolean z) {
        this.mActive = z;
    }

    @Override // java.io.Serializable
    public void setLink(String string) {
        this.mLink = string;
    }

    @Override // java.io.Serializable
    public void setSticky(boolean z) {
        this.mSticky = z;
    }
}

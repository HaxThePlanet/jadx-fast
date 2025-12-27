package com.vimeo.networking.model.playback.embed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: EmbedCustomLogos.java */
/* loaded from: classes2.dex */
public class EmbedCustomLogos implements Serializable {

    private static final long serialVersionUID = -8919686101651093878L;
    @SerializedName("active")
    private boolean mActive;
    @SerializedName("link")
    private String mLink;
    @SerializedName("sticky")
    private boolean mSticky;
    public String getLink() {
        return this.mLink;
    }

    public boolean isActive() {
        return this.mActive;
    }

    public boolean isSticky() {
        return this.mSticky;
    }

    public void setActive(boolean z) {
        this.mActive = z;
    }

    public void setLink(String str) {
        this.mLink = str;
    }

    public void setSticky(boolean z) {
        this.mSticky = z;
    }
}

package com.vimeo.networking.model.playback.embed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: EmbedButtons.java */
/* loaded from: classes2.dex */
public class EmbedButtons implements Serializable {

    private static final long serialVersionUID = 6724361702326756097L;
    @SerializedName("embed")
    private boolean mEmbed;
    @SerializedName("fullscreen")
    private boolean mFullscreen;
    @SerializedName("hd")
    private boolean mHd;
    @SerializedName("like")
    private boolean mLike;
    @SerializedName("scaling")
    private boolean mScaling;
    @SerializedName("share")
    private boolean mShare;
    @SerializedName("watchlater")
    private boolean mWatchLater;
    public boolean isEmbed() {
        return this.mEmbed;
    }

    public boolean isFullscreen() {
        return this.mFullscreen;
    }

    public boolean isHd() {
        return this.mHd;
    }

    public boolean isLike() {
        return this.mLike;
    }

    public boolean isScaling() {
        return this.mScaling;
    }

    public boolean isShare() {
        return this.mShare;
    }

    public boolean isWatchLater() {
        return this.mWatchLater;
    }

    public void setEmbed(boolean z) {
        this.mEmbed = z;
    }

    public void setFullscreen(boolean z) {
        this.mFullscreen = z;
    }

    public void setHd(boolean z) {
        this.mHd = z;
    }

    public void setLike(boolean z) {
        this.mLike = z;
    }

    public void setScaling(boolean z) {
        this.mScaling = z;
    }

    public void setShare(boolean z) {
        this.mShare = z;
    }

    public void setWatchLater(boolean z) {
        this.mWatchLater = z;
    }
}

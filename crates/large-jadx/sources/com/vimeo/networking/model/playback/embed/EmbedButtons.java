package com.vimeo.networking.model.playback.embed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

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
    @Override // java.io.Serializable
    public boolean isEmbed() {
        return this.mEmbed;
    }

    @Override // java.io.Serializable
    public boolean isFullscreen() {
        return this.mFullscreen;
    }

    @Override // java.io.Serializable
    public boolean isHd() {
        return this.mHd;
    }

    @Override // java.io.Serializable
    public boolean isLike() {
        return this.mLike;
    }

    @Override // java.io.Serializable
    public boolean isScaling() {
        return this.mScaling;
    }

    @Override // java.io.Serializable
    public boolean isShare() {
        return this.mShare;
    }

    @Override // java.io.Serializable
    public boolean isWatchLater() {
        return this.mWatchLater;
    }

    @Override // java.io.Serializable
    public void setEmbed(boolean z) {
        this.mEmbed = z;
    }

    @Override // java.io.Serializable
    public void setFullscreen(boolean z) {
        this.mFullscreen = z;
    }

    @Override // java.io.Serializable
    public void setHd(boolean z) {
        this.mHd = z;
    }

    @Override // java.io.Serializable
    public void setLike(boolean z) {
        this.mLike = z;
    }

    @Override // java.io.Serializable
    public void setScaling(boolean z) {
        this.mScaling = z;
    }

    @Override // java.io.Serializable
    public void setShare(boolean z) {
        this.mShare = z;
    }

    @Override // java.io.Serializable
    public void setWatchLater(boolean z) {
        this.mWatchLater = z;
    }
}

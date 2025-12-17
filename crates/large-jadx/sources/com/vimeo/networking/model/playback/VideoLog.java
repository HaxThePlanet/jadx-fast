package com.vimeo.networking.model.playback;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class VideoLog implements Serializable {

    private static final long serialVersionUID = -4646869969374079276L;
    public String mExitLink;
    public String mLikePressLink;
    public String mLoadLink;
    public String mPlayLink;
    public String mWatchLaterPressLink;
    private static boolean isStringEmpty(String string) {
        int obj0;
        if (string != null) {
            if (string.trim().isEmpty()) {
                obj0 = 1;
            } else {
                obj0 = 0;
            }
        } else {
        }
        return obj0;
    }

    @Override // java.io.Serializable
    public String getExitLoggingUrl() {
        return this.mExitLink;
    }

    @Override // java.io.Serializable
    public String getLikeLoggingUrl() {
        return this.mLikePressLink;
    }

    @Override // java.io.Serializable
    public String getLoadLoggingUrl() {
        return this.mLoadLink;
    }

    @Override // java.io.Serializable
    public String getPlayLoggingUrl() {
        return this.mPlayLink;
    }

    @Override // java.io.Serializable
    public String getWatchLaterLoggingUrl() {
        return this.mWatchLaterPressLink;
    }

    @Override // java.io.Serializable
    public boolean isExitLinkEmpty() {
        return VideoLog.isStringEmpty(this.mExitLink);
    }

    @Override // java.io.Serializable
    public boolean isLikeEmpty() {
        return VideoLog.isStringEmpty(this.mLikePressLink);
    }

    @Override // java.io.Serializable
    public boolean isLoadEmpty() {
        return VideoLog.isStringEmpty(this.mLoadLink);
    }

    @Override // java.io.Serializable
    public boolean isPlayEmpty() {
        return VideoLog.isStringEmpty(this.mPlayLink);
    }

    @Override // java.io.Serializable
    public boolean isWatchLaterEmpty() {
        return VideoLog.isStringEmpty(this.mWatchLaterPressLink);
    }
}

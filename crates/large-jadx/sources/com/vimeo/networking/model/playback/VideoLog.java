package com.vimeo.networking.model.playback;

import java.io.Serializable;

/* compiled from: VideoLog.java */
/* loaded from: classes2.dex */
public class VideoLog implements Serializable {

    private static final long serialVersionUID = -4646869969374079276L;
    public String mExitLink;
    public String mLikePressLink;
    public String mLoadLink;
    public String mPlayLink;
    public String mWatchLaterPressLink;
    private static boolean isStringEmpty(String str) {
        boolean z = false;
        if (str != null) {
            if (str.trim().isEmpty()) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z;
    }

    public String getExitLoggingUrl() {
        return this.mExitLink;
    }

    public String getLikeLoggingUrl() {
        return this.mLikePressLink;
    }

    public String getLoadLoggingUrl() {
        return this.mLoadLink;
    }

    public String getPlayLoggingUrl() {
        return this.mPlayLink;
    }

    public String getWatchLaterLoggingUrl() {
        return this.mWatchLaterPressLink;
    }

    public boolean isExitLinkEmpty() {
        return VideoLog.isStringEmpty(this.mExitLink);
    }

    public boolean isLikeEmpty() {
        return VideoLog.isStringEmpty(this.mLikePressLink);
    }

    public boolean isLoadEmpty() {
        return VideoLog.isStringEmpty(this.mLoadLink);
    }

    public boolean isPlayEmpty() {
        return VideoLog.isStringEmpty(this.mPlayLink);
    }

    public boolean isWatchLaterEmpty() {
        return VideoLog.isStringEmpty(this.mWatchLaterPressLink);
    }
}

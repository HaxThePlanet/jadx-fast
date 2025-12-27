package com.vimeo.networking.model.playback;

import com.google.gson.annotations.SerializedName;
import com.vimeo.networking.model.VideoFile;
import com.vimeo.networking.model.playback.embed.Embed;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Play.java */
/* loaded from: classes2.dex */
public class Play implements Serializable {

    private static final long serialVersionUID = -7429617944240759711L;
    public VideoFile mDash;
    public Drm mDrm;
    public Embed mEmbed;
    public VideoFile mHls;
    public PlayProgress mProgress;
    public ArrayList<VideoFile> mProgressive;
    public Play.Status mStatus;

    public enum Status {

        PLAYABLE,
        PURCHASE_REQUIRED,
        RESTRICTED,
        UNAVAILABLE;

        private String string;
        @Override // java.lang.Enum
        public String toString() {
            return this.string;
        }
    }
    private VideoLog getVideoLogForFile(VideoFile videoFile) {
        com.vimeo.networking.model.playback.VideoLog log = null;
        if (videoFile != null) {
            log = videoFile.getLog();
        } else {
            int i = 0;
        }
        return log;
    }

    public VideoFile getDashVideoFile() {
        return this.mDash;
    }

    public Drm getDrm() {
        return this.mDrm;
    }

    public Embed getEmbed() {
        return this.mEmbed;
    }

    public int getFileCount() {
        int i = 0;
        int r0 = getHlsVideoFile() != null ? 1 : 0;
        if (this.getDashVideoFile() != null) {
            i = i + 1;
        }
        if (getProgressiveVideoFiles() != null) {
            i = i + getProgressiveVideoFiles().size();
        }
        if (this.mDrm != null && this.mDrm.getWidevine() != null) {
            i = i + 1;
        }
        if (this.mDrm != null && this.mDrm.getPlayReady() != null) {
            i = i + 1;
        }
        return i;
    }

    public VideoFile getHlsVideoFile() {
        return this.mHls;
    }

    public String getLikeLoggingUrl() {
        com.vimeo.networking.model.playback.VideoLog log;
        if (this.mDrm != null && this.mDrm.getWidevine() != null && this.mDrm.getWidevine().getLog() != null && !this.mDrm.getWidevine().getLog().isLikeEmpty()) {
            return this.mDrm.getWidevine().getLog().getLikeLoggingUrl();
        }
        if (this.mDrm != null && this.mDrm.getPlayReady() != null && this.mDrm.getPlayReady().getLog() != null && !this.mDrm.getPlayReady().getLog().isLikeEmpty()) {
            return this.mDrm.getPlayReady().getLog().getLikeLoggingUrl();
        }
        if (getHlsVideoFile() != null && this.getHlsVideoFile().getLog() != null && !this.getHlsVideoFile().getLog().isLikeEmpty()) {
            return getHlsVideoFile().getLog().getLikeLoggingUrl();
        }
        if (getDashVideoFile() != null && this.getDashVideoFile().getLog() != null && !this.getDashVideoFile().getLog().isLikeEmpty()) {
            return getDashVideoFile().getLog().getLikeLoggingUrl();
        }
        if (getProgressiveVideoFiles() != null) {
            Iterator it = getProgressiveVideoFiles().iterator();
            while (it.hasNext()) {
                Object item = it.next();
                if (item.getLog() != null) {
                }
            }
        }
        return null;
    }

    public String getLoadLoggingUrl() {
        com.vimeo.networking.model.playback.VideoLog log;
        if (this.mDrm != null && this.mDrm.getWidevine() != null && this.mDrm.getWidevine().getLog() != null && !this.mDrm.getWidevine().getLog().isLoadEmpty()) {
            return this.mDrm.getWidevine().getLog().getLoadLoggingUrl();
        }
        if (this.mDrm != null && this.mDrm.getPlayReady() != null && this.mDrm.getPlayReady().getLog() != null && !this.mDrm.getPlayReady().getLog().isLoadEmpty()) {
            return this.mDrm.getPlayReady().getLog().getLoadLoggingUrl();
        }
        if (getHlsVideoFile() != null && this.getHlsVideoFile().getLog() != null && !this.getHlsVideoFile().getLog().isLoadEmpty()) {
            return getHlsVideoFile().getLog().getLoadLoggingUrl();
        }
        if (getDashVideoFile() != null && this.getDashVideoFile().getLog() != null && !this.getDashVideoFile().getLog().isLoadEmpty()) {
            return getDashVideoFile().getLog().getLoadLoggingUrl();
        }
        if (getProgressiveVideoFiles() != null) {
            Iterator it = getProgressiveVideoFiles().iterator();
            while (it.hasNext()) {
                Object item = it.next();
                if (item.getLog() != null) {
                }
            }
        }
        return null;
    }

    public PlayProgress getProgress() {
        return this.mProgress;
    }

    public ArrayList<VideoFile> getProgressiveVideoFiles() {
        return this.mProgressive;
    }

    public Play.Status getStatus() {
        return this.mStatus;
    }

    public String getWatchLaterLoggingUrl() {
        com.vimeo.networking.model.playback.VideoLog log;
        if (this.mDrm != null && this.mDrm.getWidevine() != null && this.mDrm.getWidevine().getLog() != null && !this.mDrm.getWidevine().getLog().isWatchLaterEmpty()) {
            return this.mDrm.getWidevine().getLog().getWatchLaterLoggingUrl();
        }
        if (this.mDrm != null && this.mDrm.getPlayReady() != null && this.mDrm.getPlayReady().getLog() != null && !this.mDrm.getPlayReady().getLog().isWatchLaterEmpty()) {
            return this.mDrm.getPlayReady().getLog().getWatchLaterLoggingUrl();
        }
        if (getHlsVideoFile() != null && this.getHlsVideoFile().getLog() != null && !this.getHlsVideoFile().getLog().isWatchLaterEmpty()) {
            return getHlsVideoFile().getLog().getWatchLaterLoggingUrl();
        }
        if (getDashVideoFile() != null && this.getDashVideoFile().getLog() != null && !this.getDashVideoFile().getLog().isWatchLaterEmpty()) {
            return getDashVideoFile().getLog().getWatchLaterLoggingUrl();
        }
        if (getProgressiveVideoFiles() != null) {
            Iterator it = getProgressiveVideoFiles().iterator();
            while (it.hasNext()) {
                Object item = it.next();
                if (item.getLog() != null) {
                }
            }
        }
        return null;
    }

    public void setEmbed(Embed embed) {
        this.mEmbed = embed;
    }

    public void setProgress(PlayProgress playProgress) {
        this.mProgress = playProgress;
    }
}

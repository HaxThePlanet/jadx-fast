package com.vimeo.networking.model.playback;

import com.google.gson.annotations.SerializedName;
import com.vimeo.networking.model.VideoFile;
import com.vimeo.networking.model.playback.embed.Embed;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class Play implements Serializable {

    private static final long serialVersionUID = -7429617944240759711L;
    public VideoFile mDash;
    public com.vimeo.networking.model.playback.Drm mDrm;
    public Embed mEmbed;
    public VideoFile mHls;
    public com.vimeo.networking.model.playback.PlayProgress mProgress;
    public ArrayList<VideoFile> mProgressive;
    public com.vimeo.networking.model.playback.Play.Status mStatus;

    public static enum Status {

        UNAVAILABLE("unavailable"),
        PLAYABLE("playable"),
        PURCHASE_REQUIRED("purchase_required"),
        RESTRICTED("restricted");

        private String string;
        @Override // java.lang.Enum
        public String toString() {
            return this.string;
        }
    }
    private com.vimeo.networking.model.playback.VideoLog getVideoLogForFile(VideoFile videoFile) {
        com.vimeo.networking.model.playback.VideoLog obj1;
        if (videoFile != null) {
            obj1 = videoFile.getLog();
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    @Override // java.io.Serializable
    public VideoFile getDashVideoFile() {
        return this.mDash;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.playback.Drm getDrm() {
        return this.mDrm;
    }

    @Override // java.io.Serializable
    public Embed getEmbed() {
        return this.mEmbed;
    }

    @Override // java.io.Serializable
    public int getFileCount() {
        int i;
        ArrayList progressiveVideoFiles;
        Object mDrm;
        Object playReady;
        i = getHlsVideoFile() != null ? 1 : 0;
        if (getDashVideoFile() != null) {
            i++;
        }
        if (getProgressiveVideoFiles() != null) {
            i += progressiveVideoFiles;
        }
        mDrm = this.mDrm;
        if (mDrm != null && mDrm.getWidevine() != null) {
            if (mDrm.getWidevine() != null) {
                i++;
            }
        }
        playReady = this.mDrm;
        if (playReady != null && playReady.getPlayReady() != null) {
            if (playReady.getPlayReady() != null) {
                i++;
            }
        }
        return i;
    }

    @Override // java.io.Serializable
    public VideoFile getHlsVideoFile() {
        return this.mHls;
    }

    @Override // java.io.Serializable
    public String getLikeLoggingUrl() {
        com.vimeo.networking.model.playback.Drm likeEmpty;
        com.vimeo.networking.model.playback.Drm playReady;
        VideoFile hlsVideoFile;
        VideoFile dashVideoFile;
        Object progressiveVideoFiles;
        boolean next;
        com.vimeo.networking.model.playback.VideoLog likeEmpty2;
        likeEmpty = this.mDrm;
        if (likeEmpty != null && likeEmpty.getWidevine() != null && this.mDrm.getWidevine().getLog() != null && !this.mDrm.getWidevine().getLog().isLikeEmpty()) {
            if (likeEmpty.getWidevine() != null) {
                if (this.mDrm.getWidevine().getLog() != null) {
                    if (!this.mDrm.getWidevine().getLog().isLikeEmpty()) {
                        return this.mDrm.getWidevine().getLog().getLikeLoggingUrl();
                    }
                }
            }
        }
        playReady = this.mDrm;
        if (playReady != null && playReady.getPlayReady() != null && this.mDrm.getPlayReady().getLog() != null && !this.mDrm.getPlayReady().getLog().isLikeEmpty()) {
            if (playReady.getPlayReady() != null) {
                if (this.mDrm.getPlayReady().getLog() != null) {
                    if (!this.mDrm.getPlayReady().getLog().isLikeEmpty()) {
                        return this.mDrm.getPlayReady().getLog().getLikeLoggingUrl();
                    }
                }
            }
        }
        if (getHlsVideoFile() != null && getHlsVideoFile().getLog() != null && getHlsVideoFile().getLog().isLikeEmpty() == null) {
            if (getHlsVideoFile().getLog() != null) {
                if (getHlsVideoFile().getLog().isLikeEmpty() == null) {
                    return getHlsVideoFile().getLog().getLikeLoggingUrl();
                }
            }
        }
        if (getDashVideoFile() != null && getDashVideoFile().getLog() != null && getDashVideoFile().getLog().isLikeEmpty() == null) {
            if (getDashVideoFile().getLog() != null) {
                if (getDashVideoFile().getLog().isLikeEmpty() == null) {
                    return getDashVideoFile().getLog().getLikeLoggingUrl();
                }
            }
        }
        if (getProgressiveVideoFiles() != null) {
            progressiveVideoFiles = getProgressiveVideoFiles().iterator();
            for (VideoFile next : progressiveVideoFiles) {
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public String getLoadLoggingUrl() {
        com.vimeo.networking.model.playback.Drm loadEmpty2;
        com.vimeo.networking.model.playback.Drm playReady;
        VideoFile hlsVideoFile;
        VideoFile dashVideoFile;
        Object progressiveVideoFiles;
        boolean next;
        com.vimeo.networking.model.playback.VideoLog loadEmpty;
        loadEmpty2 = this.mDrm;
        if (loadEmpty2 != null && loadEmpty2.getWidevine() != null && this.mDrm.getWidevine().getLog() != null && !this.mDrm.getWidevine().getLog().isLoadEmpty()) {
            if (loadEmpty2.getWidevine() != null) {
                if (this.mDrm.getWidevine().getLog() != null) {
                    if (!this.mDrm.getWidevine().getLog().isLoadEmpty()) {
                        return this.mDrm.getWidevine().getLog().getLoadLoggingUrl();
                    }
                }
            }
        }
        playReady = this.mDrm;
        if (playReady != null && playReady.getPlayReady() != null && this.mDrm.getPlayReady().getLog() != null && !this.mDrm.getPlayReady().getLog().isLoadEmpty()) {
            if (playReady.getPlayReady() != null) {
                if (this.mDrm.getPlayReady().getLog() != null) {
                    if (!this.mDrm.getPlayReady().getLog().isLoadEmpty()) {
                        return this.mDrm.getPlayReady().getLog().getLoadLoggingUrl();
                    }
                }
            }
        }
        if (getHlsVideoFile() != null && getHlsVideoFile().getLog() != null && getHlsVideoFile().getLog().isLoadEmpty() == null) {
            if (getHlsVideoFile().getLog() != null) {
                if (getHlsVideoFile().getLog().isLoadEmpty() == null) {
                    return getHlsVideoFile().getLog().getLoadLoggingUrl();
                }
            }
        }
        if (getDashVideoFile() != null && getDashVideoFile().getLog() != null && getDashVideoFile().getLog().isLoadEmpty() == null) {
            if (getDashVideoFile().getLog() != null) {
                if (getDashVideoFile().getLog().isLoadEmpty() == null) {
                    return getDashVideoFile().getLog().getLoadLoggingUrl();
                }
            }
        }
        if (getProgressiveVideoFiles() != null) {
            progressiveVideoFiles = getProgressiveVideoFiles().iterator();
            for (VideoFile next : progressiveVideoFiles) {
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.playback.PlayProgress getProgress() {
        return this.mProgress;
    }

    public ArrayList<VideoFile> getProgressiveVideoFiles() {
        return this.mProgressive;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.playback.Play.Status getStatus() {
        return this.mStatus;
    }

    @Override // java.io.Serializable
    public String getWatchLaterLoggingUrl() {
        com.vimeo.networking.model.playback.Drm watchLaterEmpty;
        com.vimeo.networking.model.playback.Drm watchLaterEmpty3;
        VideoFile watchLaterEmpty5;
        VideoFile watchLaterEmpty4;
        Object progressiveVideoFiles;
        boolean next;
        com.vimeo.networking.model.playback.VideoLog watchLaterEmpty2;
        watchLaterEmpty = this.mDrm;
        if (watchLaterEmpty != null && watchLaterEmpty.getWidevine() != null && this.mDrm.getWidevine().getLog() != null && !this.mDrm.getWidevine().getLog().isWatchLaterEmpty()) {
            if (watchLaterEmpty.getWidevine() != null) {
                if (this.mDrm.getWidevine().getLog() != null) {
                    if (!this.mDrm.getWidevine().getLog().isWatchLaterEmpty()) {
                        return this.mDrm.getWidevine().getLog().getWatchLaterLoggingUrl();
                    }
                }
            }
        }
        watchLaterEmpty3 = this.mDrm;
        if (watchLaterEmpty3 != null && watchLaterEmpty3.getPlayReady() != null && this.mDrm.getPlayReady().getLog() != null && !this.mDrm.getPlayReady().getLog().isWatchLaterEmpty()) {
            if (watchLaterEmpty3.getPlayReady() != null) {
                if (this.mDrm.getPlayReady().getLog() != null) {
                    if (!this.mDrm.getPlayReady().getLog().isWatchLaterEmpty()) {
                        return this.mDrm.getPlayReady().getLog().getWatchLaterLoggingUrl();
                    }
                }
            }
        }
        if (getHlsVideoFile() != null && getHlsVideoFile().getLog() != null && getHlsVideoFile().getLog().isWatchLaterEmpty() == null) {
            if (getHlsVideoFile().getLog() != null) {
                if (getHlsVideoFile().getLog().isWatchLaterEmpty() == null) {
                    return getHlsVideoFile().getLog().getWatchLaterLoggingUrl();
                }
            }
        }
        if (getDashVideoFile() != null && getDashVideoFile().getLog() != null && getDashVideoFile().getLog().isWatchLaterEmpty() == null) {
            if (getDashVideoFile().getLog() != null) {
                if (getDashVideoFile().getLog().isWatchLaterEmpty() == null) {
                    return getDashVideoFile().getLog().getWatchLaterLoggingUrl();
                }
            }
        }
        if (getProgressiveVideoFiles() != null) {
            progressiveVideoFiles = getProgressiveVideoFiles().iterator();
            for (VideoFile next : progressiveVideoFiles) {
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public void setEmbed(Embed embed) {
        this.mEmbed = embed;
    }

    @Override // java.io.Serializable
    public void setProgress(com.vimeo.networking.model.playback.PlayProgress playProgress) {
        this.mProgress = playProgress;
    }
}

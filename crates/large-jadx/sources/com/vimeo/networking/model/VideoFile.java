package com.vimeo.networking.model;

import com.google.gson.annotations.SerializedName;
import com.vimeo.networking.model.playback.VideoLog;
import java.io.Serializable;
import java.util.Date;

/* compiled from: VideoFile.java */
/* loaded from: classes2.dex */
public class VideoFile implements Serializable {

    private static final long serialVersionUID = -5256416394912086020L;
    public Date createdTime;
    @Deprecated
    public Date expires;
    public double fps;
    @Deprecated
    public int height;
    public String licenseLink;
    @Deprecated
    public String link;
    public Date linkExpirationTime;
    public VideoLog log;
    @Deprecated
    public String md5;
    @Deprecated
    public VideoFile.VideoQuality quality;
    @Deprecated
    public long size;
    public String token;
    public VideoFile.MimeType type;
    @Deprecated
    public int width;

    public enum MimeType {

        MP4,
        NONE,
        VP6,
        WEBM;

        private String string;
        @Override // java.lang.Enum
        public String toString() {
            return this.string;
        }
    }

    @Deprecated
    public enum VideoQuality {

        HD,
        HLS,
        MOBILE,
        NONE,
        SD;

        private String string;
        @Override // java.lang.Enum
        public String toString() {
            return this.string;
        }
    }
    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        String link;
        boolean equals;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object != null) {
            z2 = object instanceof VideoFile;
            if (object instanceof VideoFile) {
                if (getLink() != null && object.getLink() != null) {
                    if (!(getLink().equals(object.getLink()))) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    public Date getCreatedTime() {
        return this.createdTime;
    }

    public double getFps() {
        return this.fps;
    }

    public int getHeight() {
        return this.height;
    }

    public String getLicenseLink() {
        return this.licenseLink;
    }

    public String getLink() {
        return this.link;
    }

    public Date getLinkExpirationTime() {
        return this.linkExpirationTime;
    }

    public VideoLog getLog() {
        return this.log;
    }

    public String getMd5() {
        return this.md5;
    }

    @Deprecated
    public VideoFile.VideoQuality getQuality() {
        com.vimeo.networking.model.VideoFile.VideoQuality quality2;
        if (this.quality == null) {
            quality2 = VideoFile.VideoQuality.NONE;
        }
        return quality2;
    }

    public long getSize() {
        return this.size;
    }

    public String getToken() {
        return this.token;
    }

    public VideoFile.MimeType getType() {
        com.vimeo.networking.model.VideoFile.MimeType type2;
        if (this.type == null) {
            type2 = VideoFile.MimeType.NONE;
        }
        return type2;
    }

    public int getWidth() {
        return this.width;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        if (getLink() != null) {
            i = getLink().hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    public boolean isExpired() {
        boolean z = true;
        Date date;
        if (this.expires != null || this.linkExpirationTime != null) {
            if (this.expires != null) {
                if (this.expires.before(new Date()) || this.linkExpirationTime != null) {
                    int i = 1;
                } else {
                    int r0 = this.linkExpirationTime.before(new Date()) ? 1 : 0;
                }
            }
        }
        return (this.linkExpirationTime.before(new Date()) ? 1 : 0);
    }

    public boolean isVP6() {
        boolean z = true;
        int r0 = getType() == VideoFile.MimeType.VP6 ? 1 : 0;
        return (getType() == VideoFile.MimeType.VP6 ? 1 : 0);
    }
}

package com.vimeo.networking.model;

import com.google.gson.annotations.SerializedName;
import com.vimeo.networking.model.playback.VideoLog;
import java.io.Serializable;
import java.util.Date;

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
    public com.vimeo.networking.model.VideoFile.VideoQuality quality;
    @Deprecated
    public long size;
    public String token;
    public com.vimeo.networking.model.VideoFile.MimeType type;
    @Deprecated
    public int width;

    public static enum MimeType {

        NONE("None"),
        MP4("video/mp4"),
        WEBM("video/webm"),
        VP6("vp6/x-video");

        private String string;
        @Override // java.lang.Enum
        public String toString() {
            return this.string;
        }
    }

    @Deprecated
    public static enum VideoQuality {

        NONE("N/A"),
        HLS("hls"),
        HD("hd"),
        SD("sd"),
        MOBILE("mobile");

        private String string;
        @Override // java.lang.Enum
        public String toString() {
            return this.string;
        }
    }
    @Override // java.io.Serializable
    public boolean equals(Object object) {
        int i;
        String link;
        boolean z;
        boolean obj4;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (object instanceof VideoFile == null) {
            } else {
                if (getLink() != null && (VideoFile)object.getLink() != null && getLink().equals(object.getLink())) {
                    if (object.getLink() != null) {
                        if (getLink().equals(object.getLink())) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // java.io.Serializable
    public Date getCreatedTime() {
        return this.createdTime;
    }

    @Override // java.io.Serializable
    public double getFps() {
        return this.fps;
    }

    @Override // java.io.Serializable
    public int getHeight() {
        return this.height;
    }

    @Override // java.io.Serializable
    public String getLicenseLink() {
        return this.licenseLink;
    }

    @Override // java.io.Serializable
    public String getLink() {
        return this.link;
    }

    @Override // java.io.Serializable
    public Date getLinkExpirationTime() {
        return this.linkExpirationTime;
    }

    @Override // java.io.Serializable
    public VideoLog getLog() {
        return this.log;
    }

    @Override // java.io.Serializable
    public String getMd5() {
        return this.md5;
    }

    @Deprecated
    public com.vimeo.networking.model.VideoFile.VideoQuality getQuality() {
        com.vimeo.networking.model.VideoFile.VideoQuality nONE;
        if (this.quality == null) {
            nONE = VideoFile.VideoQuality.NONE;
        }
        return nONE;
    }

    @Override // java.io.Serializable
    public long getSize() {
        return this.size;
    }

    @Override // java.io.Serializable
    public String getToken() {
        return this.token;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.VideoFile.MimeType getType() {
        com.vimeo.networking.model.VideoFile.MimeType nONE;
        if (this.type == null) {
            nONE = VideoFile.MimeType.NONE;
        }
        return nONE;
    }

    @Override // java.io.Serializable
    public int getWidth() {
        return this.width;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        int i;
        if (getLink() != null) {
            i = getLink().hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // java.io.Serializable
    public boolean isExpired() {
        boolean linkExpirationTime2;
        int i;
        Date linkExpirationTime;
        linkExpirationTime2 = this.expires;
        if (linkExpirationTime2 == null) {
            if (this.linkExpirationTime != null) {
                if (linkExpirationTime2 != null) {
                    linkExpirationTime = new Date();
                    if (!linkExpirationTime2.before(linkExpirationTime)) {
                        linkExpirationTime2 = this.linkExpirationTime;
                        linkExpirationTime = new Date();
                        if (linkExpirationTime2 != null && linkExpirationTime2.before(linkExpirationTime)) {
                            linkExpirationTime = new Date();
                            i = linkExpirationTime2.before(linkExpirationTime) ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // java.io.Serializable
    public boolean isVP6() {
        int i;
        i = getType() == VideoFile.MimeType.VP6 ? 1 : 0;
        return i;
    }
}

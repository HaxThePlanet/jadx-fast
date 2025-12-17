package com.vimeo.networking.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes2.dex */
public class FeedItem implements Serializable {

    private static final long serialVersionUID = -8744477085158366576L;
    public com.vimeo.networking.model.Category category;
    public com.vimeo.networking.model.Channel channel;
    public com.vimeo.networking.model.Video clip;
    public com.vimeo.networking.model.Group group;
    public com.vimeo.networking.model.Metadata metadata;
    public com.vimeo.networking.model.Tag tag;
    public Date time;
    public String type;
    public String uri;
    public com.vimeo.networking.model.User user;

    public static enum AttributionType {

        UPLOAD,
        LIKE,
        CATEGORY,
        CHANNEL,
        GROUP,
        TAG,
        CREDIT,
        SHARE,
        NONE;
    }
    @Override // java.io.Serializable
    public boolean equals(Object object) {
        int i;
        Object resourceKey;
        Class class2;
        Object class;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                resourceKey = this.clip;
                if (resourceKey != null && object.clip != null && resourceKey.getResourceKey() != null && object.clip.getResourceKey() != null && this.clip.getResourceKey().equals(object.clip.getResourceKey())) {
                    if (object.clip != null) {
                        if (resourceKey.getResourceKey() != null) {
                            if (object.clip.getResourceKey() != null) {
                                if (this.clip.getResourceKey().equals(object.clip.getResourceKey())) {
                                } else {
                                    i = i2;
                                }
                            } else {
                            }
                        } else {
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
    public com.vimeo.networking.model.FeedItem.AttributionType getType() {
        String equalsIgnoreCase;
        String str;
        equalsIgnoreCase = this.type;
        if (equalsIgnoreCase != null && equalsIgnoreCase.equalsIgnoreCase("category")) {
            if (equalsIgnoreCase.equalsIgnoreCase("category")) {
                return FeedItem.AttributionType.CATEGORY;
            }
            if (this.type.equalsIgnoreCase("channel")) {
                return FeedItem.AttributionType.CHANNEL;
            }
            if (this.type.equalsIgnoreCase("like")) {
                return FeedItem.AttributionType.LIKE;
            }
            if (this.type.equalsIgnoreCase("upload")) {
                return FeedItem.AttributionType.UPLOAD;
            }
            if (this.type.equalsIgnoreCase("tag")) {
                return FeedItem.AttributionType.TAG;
            }
            if (this.type.equalsIgnoreCase("group")) {
                return FeedItem.AttributionType.GROUP;
            }
            if (this.type.equalsIgnoreCase("appearance")) {
                return FeedItem.AttributionType.CREDIT;
            }
            if (this.type.equalsIgnoreCase("share")) {
                return FeedItem.AttributionType.SHARE;
            }
        }
        return FeedItem.AttributionType.NONE;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        int i;
        if (this.clip.getResourceKey() != null) {
            i = this.clip.getResourceKey().hashCode();
        } else {
            i = 0;
        }
        return i;
    }
}

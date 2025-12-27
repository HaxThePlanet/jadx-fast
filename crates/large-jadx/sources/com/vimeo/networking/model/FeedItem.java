package com.vimeo.networking.model;

import java.io.Serializable;
import java.util.Date;

/* compiled from: FeedItem.java */
/* loaded from: classes2.dex */
public class FeedItem implements Serializable {

    private static final long serialVersionUID = -8744477085158366576L;
    public Category category;
    public Channel channel;
    public Video clip;
    public Group group;
    public Metadata metadata;
    public Tag tag;
    public Date time;
    public String type;
    public String uri;
    public User user;

    public enum AttributionType {

        CATEGORY,
        CHANNEL,
        CREDIT,
        GROUP,
        LIKE,
        NONE,
        SHARE,
        TAG,
        UPLOAD;
    }
    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        com.vimeo.networking.model.Video clip2;
        Class cls2;
        boolean equals;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object != null) {
            if (getClass() == object.getClass()) {
                if (this.clip != null && object.clip != null && this.clip.getResourceKey() != null) {
                    if (object.clip.getResourceKey() != null) {
                        if (!(this.clip.getResourceKey().equals(object.clip.getResourceKey()))) {
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    public FeedItem.AttributionType getType() {
        if (this.type != null) {
            if (this.type.equalsIgnoreCase("category")) {
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
            str = "share";
            if (this.type.equalsIgnoreCase(str)) {
                return FeedItem.AttributionType.SHARE;
            }
        }
        return FeedItem.AttributionType.NONE;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        if (this.clip.getResourceKey() != null) {
            i = this.clip.getResourceKey().hashCode();
        } else {
            i = 0;
        }
        return i;
    }
}

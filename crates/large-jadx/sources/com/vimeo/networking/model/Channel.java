package com.vimeo.networking.model;

import java.io.Serializable;
import java.util.Date;

/* compiled from: Channel.java */
/* loaded from: classes2.dex */
public class Channel implements Serializable {

    private static final long serialVersionUID = 3190410523525111858L;
    public Date createdTime;
    public String description;
    public PictureCollection header;
    public String link;
    public Metadata metadata;
    public Date modifiedTime;
    public String name;
    public PictureCollection pictures;
    public Privacy privacy;
    public String uri;
    public User user;
    public boolean canFollow() {
        boolean z = true;
        int r0 = getFollowInteraction() != null ? 1 : 0;
        return (getFollowInteraction() != null ? 1 : 0);
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean equals = false;
        if (this == object) {
            return true;
        }
        int i = 0;
        if (object != null) {
            if (getClass() == object.getClass()) {
                if (this.uri != null && object.uri != null) {
                    equals = this.uri.equals(object.uri);
                }
            }
        }
        return equals;
    }

    public Interaction getFollowInteraction() {
        if (this.metadata != null && metadata2.interactions != null && interactions2.follow != null) {
            return interactions2.follow;
        }
        return null;
    }

    public int getFollowerCount() {
        if (getUsersConnection() != null) {
            return getUsersConnection().total;
        }
        return 0;
    }

    public Connection getUsersConnection() {
        if (this.metadata != null && metadata2.connections != null && connections2.users != null) {
            return connections2.users;
        }
        return null;
    }

    public int getVideoCount() {
        if (getVideosConnection() != null) {
            return getVideosConnection().total;
        }
        return 0;
    }

    public Connection getVideosConnection() {
        if (this.metadata != null && metadata2.connections != null && connections2.videos != null) {
            return connections2.videos;
        }
        return null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        if (this.uri != null) {
            i = this.uri.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    public boolean isFollowing() {
        if (getFollowInteraction() != null) {
            return this.metadata.interactions.follow.added;
        }
        return false;
    }
}

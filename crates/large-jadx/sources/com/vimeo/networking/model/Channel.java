package com.vimeo.networking.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes2.dex */
public class Channel implements Serializable {

    private static final long serialVersionUID = 3190410523525111858L;
    public Date createdTime;
    public String description;
    public com.vimeo.networking.model.PictureCollection header;
    public String link;
    public com.vimeo.networking.model.Metadata metadata;
    public Date modifiedTime;
    public String name;
    public com.vimeo.networking.model.PictureCollection pictures;
    public com.vimeo.networking.model.Privacy privacy;
    public String uri;
    public com.vimeo.networking.model.User user;
    @Override // java.io.Serializable
    public boolean canFollow() {
        int i;
        i = getFollowInteraction() != null ? 1 : 0;
        return i;
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        int equals;
        Object class2;
        Class class;
        Object obj4;
        if (this == object) {
            return 1;
        }
        equals = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                class2 = this.uri;
                obj4 = object.uri;
                if (class2 != null && obj4 != null) {
                    obj4 = object.uri;
                    if (obj4 != null) {
                        equals = class2.equals(obj4);
                    }
                }
            }
        }
        return equals;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Interaction getFollowInteraction() {
        Object interactions;
        interactions = this.metadata;
        interactions = interactions.interactions;
        interactions = interactions.follow;
        if (interactions != null && interactions != null && interactions != null) {
            interactions = interactions.interactions;
            if (interactions != null) {
                interactions = interactions.follow;
                if (interactions != null) {
                    return interactions;
                }
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public int getFollowerCount() {
        if (getUsersConnection() != null) {
            return usersConnection2.total;
        }
        return 0;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Connection getUsersConnection() {
        Object connections;
        connections = this.metadata;
        connections = connections.connections;
        connections = connections.users;
        if (connections != null && connections != null && connections != null) {
            connections = connections.connections;
            if (connections != null) {
                connections = connections.users;
                if (connections != null) {
                    return connections;
                }
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public int getVideoCount() {
        if (getVideosConnection() != null) {
            return videosConnection2.total;
        }
        return 0;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Connection getVideosConnection() {
        Object connections;
        connections = this.metadata;
        connections = connections.connections;
        connections = connections.videos;
        if (connections != null && connections != null && connections != null) {
            connections = connections.connections;
            if (connections != null) {
                connections = connections.videos;
                if (connections != null) {
                    return connections;
                }
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        int i;
        String uri = this.uri;
        if (uri != null) {
            i = uri.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // java.io.Serializable
    public boolean isFollowing() {
        if (getFollowInteraction() != null) {
            return follow.added;
        }
        return 0;
    }
}

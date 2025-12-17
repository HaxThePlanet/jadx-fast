package com.vimeo.networking.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes2.dex */
public class Comment implements Serializable {

    private static final long serialVersionUID = -7716027694845877155L;
    public Date createdOn;
    public com.vimeo.networking.model.Metadata metadata;
    public String text;
    public com.vimeo.networking.model.Comment.CommentType type;
    public String uri;
    public com.vimeo.networking.model.User user;

    public static enum CommentType {

        VIDEO;
    }
    @Override // java.io.Serializable
    public boolean canReply() {
        Object connections;
        connections = this.metadata;
        connections = connections.connections;
        connections = connections.replies;
        connections = connections.options;
        if (connections != null && connections != null && connections != null && connections != null) {
            connections = connections.connections;
            if (connections != null) {
                connections = connections.replies;
                if (connections != null) {
                    connections = connections.options;
                    if (connections != null) {
                        return connections.contains("POST");
                    }
                }
            }
        }
        return 0;
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        int equals;
        Object class;
        Class class2;
        Object obj4;
        if (this == object) {
            return 1;
        }
        equals = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                class = this.uri;
                obj4 = object.uri;
                if (class != null && obj4 != null) {
                    obj4 = object.uri;
                    if (obj4 != null) {
                        equals = class.equals(obj4);
                    }
                }
            }
        }
        return equals;
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
    public int replyCount() {
        Object connections;
        connections = this.metadata;
        connections = connections.connections;
        connections = connections.replies;
        if (connections != null && connections != null && connections != null) {
            connections = connections.connections;
            if (connections != null) {
                connections = connections.replies;
                if (connections != null) {
                    return connections.total;
                }
            }
        }
        return 0;
    }
}

package com.vimeo.networking.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/* compiled from: Comment.java */
/* loaded from: classes2.dex */
public class Comment implements Serializable {

    private static final long serialVersionUID = -7716027694845877155L;
    public Date createdOn;
    public Metadata metadata;
    public String text;
    public Comment.CommentType type;
    public String uri;
    public User user;

    public enum CommentType {

        VIDEO;
    }
    public boolean canReply() {
        if (this.metadata != null && metadata2.connections != null && connections2.replies != null && replies2.options != null) {
            return replies2.options.contains("POST");
        }
        return false;
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

    public int replyCount() {
        if (this.metadata != null && metadata2.connections != null && connections2.replies != null) {
            return replies2.total;
        }
        return 0;
    }
}

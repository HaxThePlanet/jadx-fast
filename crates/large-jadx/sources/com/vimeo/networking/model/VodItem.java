package com.vimeo.networking.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;

/* compiled from: VodItem.java */
/* loaded from: classes2.dex */
public class VodItem implements Serializable {

    private static final String S_FILM = "film";
    private static final String S_SERIES = "series";
    private static final long serialVersionUID = 8360150766347816073L;
    public String mDescription;
    public Video mFilm;
    public String mLink;
    public Metadata mMetadata;
    public String mName;
    public PictureCollection mPictures;
    public VodItem.Publish mPublish;
    public Video mTrailer;
    public VodItem.VodType mType;
    public User mUser;

    public static class Publish implements Serializable {

        private static final long serialVersionUID = -994389241935894370L;
        public Date mTime;
        public Date getTime() {
            return this.mTime;
        }
    }

    public enum VodType {

        FILM,
        SERIES;

        private final String mType;
        @Override // java.lang.Enum
        public String toString() {
            return this.mType;
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
            z2 = object instanceof VodItem;
            if (object instanceof VodItem) {
                if (this.mLink != null && object.getLink() != null) {
                    if (!(this.mLink.equals(object.getLink()))) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    public ConnectionCollection getConnections() {
        com.vimeo.networking.model.ConnectionCollection connections2 = null;
        com.vimeo.networking.model.ConnectionCollection r0 = this.mMetadata != null ? mMetadata2.connections : 0;
        return (this.mMetadata != null ? mMetadata2.connections : 0);
    }

    public String getDescription() {
        return this.mDescription;
    }

    public Video getFilm() {
        return this.mFilm;
    }

    public InteractionCollection getInteractions() {
        com.vimeo.networking.model.InteractionCollection interactions2 = null;
        com.vimeo.networking.model.InteractionCollection r0 = this.mMetadata != null ? mMetadata2.interactions : 0;
        return (this.mMetadata != null ? mMetadata2.interactions : 0);
    }

    public String getLink() {
        return this.mLink;
    }

    public Metadata getMetadata() {
        return this.mMetadata;
    }

    public String getName() {
        return this.mName;
    }

    public PictureCollection getPictures() {
        return this.mPictures;
    }

    public VodItem.Publish getPublish() {
        return this.mPublish;
    }

    public Video getTrailer() {
        return this.mTrailer;
    }

    public VodItem.VodType getType() {
        return this.mType;
    }

    public User getUser() {
        return this.mUser;
    }

    public String getVideosUri() {
        if (this.mMetadata != null && mMetadata2.connections != null && connections2.videos != null) {
            return videos2.uri;
        }
        return null;
    }

    public int getViewableVideoCount() {
        if (this.mMetadata != null && mMetadata2.connections != null && connections2.videos != null) {
            return videos2.viewableTotal;
        }
        return 0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        if (this.mLink != null) {
            i = this.mLink.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setFilm(Video video) {
        this.mFilm = video;
    }

    public void setMetadata(Metadata metadata) {
        this.mMetadata = metadata;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setPictures(PictureCollection list) {
        this.mPictures = list;
    }

    public void setPublish(VodItem.Publish publish) {
        this.mPublish = publish;
    }

    public void setTrailer(Video video) {
        this.mTrailer = video;
    }

    public void setType(VodItem.VodType vodType) {
        this.mType = vodType;
    }

    public void setUser(User user) {
        this.mUser = user;
    }
}

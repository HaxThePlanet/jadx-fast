package com.vimeo.networking.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;

/* loaded from: classes2.dex */
public class VodItem implements Serializable {

    private static final String S_FILM = "film";
    private static final String S_SERIES = "series";
    private static final long serialVersionUID = 8360150766347816073L;
    public String mDescription;
    public com.vimeo.networking.model.Video mFilm;
    public String mLink;
    public com.vimeo.networking.model.Metadata mMetadata;
    public String mName;
    public com.vimeo.networking.model.PictureCollection mPictures;
    public com.vimeo.networking.model.VodItem.Publish mPublish;
    public com.vimeo.networking.model.Video mTrailer;
    public com.vimeo.networking.model.VodItem.VodType mType;
    public com.vimeo.networking.model.User mUser;

    public static class Publish implements Serializable {

        private static final long serialVersionUID = -994389241935894370L;
        public Date mTime;
        @Override // java.io.Serializable
        public Date getTime() {
            return this.mTime;
        }
    }

    public static enum VodType {

        FILM("film"),
        SERIES("series");

        private final String mType;
        @Override // java.lang.Enum
        public String toString() {
            return this.mType;
        }
    }
    @Override // java.io.Serializable
    public boolean equals(Object object) {
        int i;
        String mLink;
        boolean z;
        boolean obj4;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (!object instanceof VodItem) {
            } else {
                if (this.mLink != null && (VodItem)object.getLink() != null && this.mLink.equals(object.getLink())) {
                    if (object.getLink() != null) {
                        if (this.mLink.equals(object.getLink())) {
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
    public com.vimeo.networking.model.ConnectionCollection getConnections() {
        com.vimeo.networking.model.ConnectionCollection connections;
        com.vimeo.networking.model.Metadata mMetadata = this.mMetadata;
        connections = mMetadata != null ? mMetadata.connections : 0;
        return connections;
    }

    @Override // java.io.Serializable
    public String getDescription() {
        return this.mDescription;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Video getFilm() {
        return this.mFilm;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.InteractionCollection getInteractions() {
        com.vimeo.networking.model.InteractionCollection interactions;
        com.vimeo.networking.model.Metadata mMetadata = this.mMetadata;
        interactions = mMetadata != null ? mMetadata.interactions : 0;
        return interactions;
    }

    @Override // java.io.Serializable
    public String getLink() {
        return this.mLink;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Metadata getMetadata() {
        return this.mMetadata;
    }

    @Override // java.io.Serializable
    public String getName() {
        return this.mName;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.PictureCollection getPictures() {
        return this.mPictures;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.VodItem.Publish getPublish() {
        return this.mPublish;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Video getTrailer() {
        return this.mTrailer;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.VodItem.VodType getType() {
        return this.mType;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.User getUser() {
        return this.mUser;
    }

    @Override // java.io.Serializable
    public String getVideosUri() {
        Object mMetadata;
        mMetadata = this.mMetadata;
        mMetadata = mMetadata.connections;
        mMetadata = mMetadata.videos;
        if (mMetadata != null && mMetadata != null && mMetadata != null) {
            mMetadata = mMetadata.connections;
            if (mMetadata != null) {
                mMetadata = mMetadata.videos;
                if (mMetadata != null) {
                    return mMetadata.uri;
                }
            }
        }
        return null;
    }

    @Override // java.io.Serializable
    public int getViewableVideoCount() {
        Object mMetadata;
        mMetadata = this.mMetadata;
        mMetadata = mMetadata.connections;
        mMetadata = mMetadata.videos;
        if (mMetadata != null && mMetadata != null && mMetadata != null) {
            mMetadata = mMetadata.connections;
            if (mMetadata != null) {
                mMetadata = mMetadata.videos;
                if (mMetadata != null) {
                    return mMetadata.viewableTotal;
                }
            }
        }
        return 0;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        int i;
        String mLink = this.mLink;
        if (mLink != null) {
            i = mLink.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // java.io.Serializable
    public void setDescription(String string) {
        this.mDescription = string;
    }

    @Override // java.io.Serializable
    public void setFilm(com.vimeo.networking.model.Video video) {
        this.mFilm = video;
    }

    @Override // java.io.Serializable
    public void setMetadata(com.vimeo.networking.model.Metadata metadata) {
        this.mMetadata = metadata;
    }

    @Override // java.io.Serializable
    public void setName(String string) {
        this.mName = string;
    }

    @Override // java.io.Serializable
    public void setPictures(com.vimeo.networking.model.PictureCollection pictureCollection) {
        this.mPictures = pictureCollection;
    }

    @Override // java.io.Serializable
    public void setPublish(com.vimeo.networking.model.VodItem.Publish vodItem$Publish) {
        this.mPublish = publish;
    }

    @Override // java.io.Serializable
    public void setTrailer(com.vimeo.networking.model.Video video) {
        this.mTrailer = video;
    }

    @Override // java.io.Serializable
    public void setType(com.vimeo.networking.model.VodItem.VodType vodItem$VodType) {
        this.mType = vodType;
    }

    @Override // java.io.Serializable
    public void setUser(com.vimeo.networking.model.User user) {
        this.mUser = user;
    }
}

package com.vimeo.networking.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class Recommendation implements Serializable {

    static final String TYPE_CHANNEL = "channel";
    static final String TYPE_USER = "user";
    private static final long serialVersionUID = -1451431453348153582L;
    public com.vimeo.networking.model.Category mCategory;
    public com.vimeo.networking.model.Channel mChannel;
    public String mDescription;
    public String mRecommendationType;
    public String mResourceKey;
    public com.vimeo.networking.model.User mUser;

    public static enum RecommendationType {

        NONE,
        CHANNEL,
        USER;
    }
    @Override // java.io.Serializable
    public com.vimeo.networking.model.Category getCategory() {
        return this.mCategory;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Channel getChannel() {
        return this.mChannel;
    }

    @Override // java.io.Serializable
    public String getDescription() {
        return this.mDescription;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.Recommendation.RecommendationType getRecommendationType() {
        if ("channel".equals(this.mRecommendationType)) {
            return Recommendation.RecommendationType.CHANNEL;
        }
        if ("user".equals(this.mRecommendationType)) {
            return Recommendation.RecommendationType.USER;
        }
        return Recommendation.RecommendationType.NONE;
    }

    @Override // java.io.Serializable
    public String getResourceKey() {
        return this.mResourceKey;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.User getUser() {
        return this.mUser;
    }
}

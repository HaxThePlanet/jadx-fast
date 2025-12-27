package com.vimeo.networking.model;

import java.io.Serializable;

/* compiled from: Recommendation.java */
/* loaded from: classes2.dex */
public class Recommendation implements Serializable {

    static final String TYPE_CHANNEL = "channel";
    static final String TYPE_USER = "user";
    private static final long serialVersionUID = -1451431453348153582L;
    public Category mCategory;
    public Channel mChannel;
    public String mDescription;
    public String mRecommendationType;
    public String mResourceKey;
    public User mUser;

    public enum RecommendationType {

        CHANNEL,
        NONE,
        USER;
    }
    public Category getCategory() {
        return this.mCategory;
    }

    public Channel getChannel() {
        return this.mChannel;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public Recommendation.RecommendationType getRecommendationType() {
        if ("channel".equals(this.mRecommendationType)) {
            return Recommendation.RecommendationType.CHANNEL;
        }
        if ("user".equals(this.mRecommendationType)) {
            return Recommendation.RecommendationType.USER;
        }
        return Recommendation.RecommendationType.NONE;
    }

    public String getResourceKey() {
        return this.mResourceKey;
    }

    public User getUser() {
        return this.mUser;
    }
}

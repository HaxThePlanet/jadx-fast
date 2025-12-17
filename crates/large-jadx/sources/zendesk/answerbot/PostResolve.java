package zendesk.answerbot;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
final class PostResolve {

    @SerializedName("article_id")
    private final long articleId;
    @SerializedName("deflection_id")
    private final long deflectionId;
    @SerializedName("interaction_access_token")
    private final String interactionAccessToken;
    @SerializedName("resolution_channel_id")
    private final long resolutionChannelId;
    PostResolve(long l, long l2, long l3, String string4) {
        super();
        this.deflectionId = l;
        this.articleId = l3;
        this.resolutionChannelId = obj5;
        this.interactionAccessToken = obj7;
    }

    public boolean equals(Object object) {
        boolean equals;
        Class<zendesk.answerbot.PostResolve> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (PostResolve.class != object.getClass()) {
            } else {
                if (Long.compare(deflectionId, deflectionId2) != 0) {
                    return i;
                }
                if (Long.compare(articleId, articleId2) != 0) {
                    return i;
                }
                if (Long.compare(resolutionChannelId, resolutionChannelId2) != 0) {
                    return i;
                }
                String interactionAccessToken = this.interactionAccessToken;
                final String obj7 = object.interactionAccessToken;
                if (interactionAccessToken != null) {
                    equals = interactionAccessToken.equals(obj7);
                } else {
                    if (obj7 == null) {
                    } else {
                        equals = i;
                    }
                }
            }
            return equals;
        }
        return i;
    }

    public int hashCode() {
        int i;
        long deflectionId = this.deflectionId;
        final int i14 = 32;
        long articleId = this.articleId;
        long resolutionChannelId = this.resolutionChannelId;
        String interactionAccessToken = this.interactionAccessToken;
        if (interactionAccessToken != null) {
            i = interactionAccessToken.hashCode();
        } else {
            i = 0;
        }
        return i8 += i;
    }
}

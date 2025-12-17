package zendesk.answerbot;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes3.dex */
public final class DeflectionResponse {

    @SerializedName("deflection")
    private final zendesk.answerbot.Deflection deflection;
    @SerializedName("deflection_articles")
    private final List<zendesk.answerbot.DeflectionArticle> deflectionArticles;
    @SerializedName("interaction_access_token")
    private final String interactionAccessToken;
    @SerializedName("model_meta")
    private final zendesk.answerbot.DeflectionMeta meta;
    public boolean equals(Object object) {
        int equals;
        boolean interactionAccessToken2;
        boolean equals2;
        zendesk.answerbot.Deflection deflection;
        Class<zendesk.answerbot.DeflectionResponse> obj;
        Object interactionAccessToken;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (DeflectionResponse.class != object.getClass()) {
            } else {
                String interactionAccessToken3 = this.interactionAccessToken;
                if (interactionAccessToken3 != null) {
                    if (!interactionAccessToken3.equals(object.interactionAccessToken)) {
                        return i;
                    }
                } else {
                    if (object.interactionAccessToken != null) {
                    }
                }
                zendesk.answerbot.DeflectionMeta meta = this.meta;
                if (meta != null) {
                    if (!meta.equals(object.meta)) {
                        return i;
                    }
                } else {
                    if (object.meta != null) {
                    }
                }
                zendesk.answerbot.Deflection deflection2 = this.deflection;
                if (deflection2 != null) {
                    if (!deflection2.equals(object.deflection)) {
                        return i;
                    }
                } else {
                    if (object.deflection != null) {
                    }
                }
                List deflectionArticles = this.deflectionArticles;
                final List obj5 = object.deflectionArticles;
                if (deflectionArticles != null) {
                    equals = deflectionArticles.equals(obj5);
                } else {
                    if (obj5 == null) {
                    } else {
                        equals = i;
                    }
                }
            }
            return equals;
        }
        return i;
    }

    public zendesk.answerbot.Deflection getDeflection() {
        return this.deflection;
    }

    public List<zendesk.answerbot.DeflectionArticle> getDeflectionArticles() {
        return this.deflectionArticles;
    }

    public String getInteractionAccessToken() {
        return this.interactionAccessToken;
    }

    public int hashCode() {
        int i4;
        int i2;
        int i;
        int i3;
        String interactionAccessToken = this.interactionAccessToken;
        i2 = 0;
        if (interactionAccessToken != null) {
            i4 = interactionAccessToken.hashCode();
        } else {
            i4 = i2;
        }
        zendesk.answerbot.DeflectionMeta meta = this.meta;
        if (meta != null) {
            i = meta.hashCode();
        } else {
            i = i2;
        }
        zendesk.answerbot.Deflection deflection = this.deflection;
        if (deflection != null) {
            i3 = deflection.hashCode();
        } else {
            i3 = i2;
        }
        List deflectionArticles = this.deflectionArticles;
        if (deflectionArticles != null) {
            i2 = deflectionArticles.hashCode();
        }
        return i9 += i2;
    }
}

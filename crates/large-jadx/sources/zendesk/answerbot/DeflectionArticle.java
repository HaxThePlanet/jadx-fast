package zendesk.answerbot;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes3.dex */
public final class DeflectionArticle {

    @SerializedName("article_id")
    private final long articleId;
    @SerializedName("brand_id")
    private final long brandId;
    @SerializedName("html_url")
    private final String htmlUrl;
    @SerializedName("id")
    private final long id;
    @SerializedName("label_names")
    private final List<String> labelNames;
    @SerializedName("locale")
    private final String locale;
    @SerializedName("score")
    private final double score;
    @SerializedName("snippet")
    private final String snippet;
    @SerializedName("title")
    private final String title;
    @SerializedName("url")
    private final String url;
    public boolean equals(Object object) {
        int equals;
        boolean equals2;
        String snippet;
        boolean htmlUrl;
        String equals3;
        boolean labelNames2;
        Class<zendesk.answerbot.DeflectionArticle> obj;
        Object labelNames;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            labelNames = object.getClass();
            if (DeflectionArticle.class != labelNames) {
            } else {
                if (Long.compare(l, l2) != 0) {
                    return i;
                }
                if (Long.compare(articleId, articleId2) != 0) {
                    return i;
                }
                if (Long.compare(brandId, brandId2) != 0) {
                    return i;
                }
                if (Double.compare(object.score, labelNames) != 0) {
                    return i;
                }
                String title = this.title;
                if (title != null) {
                    if (!title.equals(object.title)) {
                        return i;
                    }
                } else {
                    if (object.title != null) {
                    }
                }
                String snippet2 = this.snippet;
                if (snippet2 != null) {
                    if (!snippet2.equals(object.snippet)) {
                        return i;
                    }
                } else {
                    if (object.snippet != null) {
                    }
                }
                String htmlUrl2 = this.htmlUrl;
                if (htmlUrl2 != null) {
                    if (!htmlUrl2.equals(object.htmlUrl)) {
                        return i;
                    }
                } else {
                    if (object.htmlUrl != null) {
                    }
                }
                String url = this.url;
                if (url != null) {
                    if (!url.equals(object.url)) {
                        return i;
                    }
                } else {
                    if (object.url != null) {
                    }
                }
                List labelNames3 = this.labelNames;
                if (labelNames3 != null) {
                    if (!labelNames3.equals(object.labelNames)) {
                        return i;
                    }
                } else {
                    if (object.labelNames != null) {
                    }
                }
                String locale = this.locale;
                final String obj7 = object.locale;
                if (locale != null) {
                    equals = locale.equals(obj7);
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

    public long getArticleId() {
        return this.articleId;
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i2;
        int i5;
        int i6;
        int i;
        int i4;
        int i3;
        long l = this.id;
        final int i32 = 32;
        String title = this.title;
        i3 = 0;
        if (title != null) {
            i2 = title.hashCode();
        } else {
            i2 = i3;
        }
        String snippet = this.snippet;
        if (snippet != null) {
            i5 = snippet.hashCode();
        } else {
            i5 = i3;
        }
        String htmlUrl = this.htmlUrl;
        if (htmlUrl != null) {
            i6 = htmlUrl.hashCode();
        } else {
            i6 = i3;
        }
        String url = this.url;
        if (url != null) {
            i = url.hashCode();
        } else {
            i = i3;
        }
        List labelNames = this.labelNames;
        if (labelNames != null) {
            i4 = labelNames.hashCode();
        } else {
            i4 = i3;
        }
        long articleId = this.articleId;
        long brandId = this.brandId;
        brandId ^= i37;
        String locale = this.locale;
        if (locale != null) {
            i3 = locale.hashCode();
        }
        long doubleToLongBits = Double.doubleToLongBits(this.score);
        return i25 += i31;
    }
}

package zendesk.support;

import java.util.Locale;

/* loaded from: classes3.dex */
public class SuggestedArticleSearch {

    private Long categoryId;
    private String labelNames;
    private Locale locale;
    private String query;
    private Long sectionId;
    SuggestedArticleSearch(zendesk.support.SuggestedArticleSearch.1 suggestedArticleSearch$1) {
        super();
    }

    static String access$102(zendesk.support.SuggestedArticleSearch suggestedArticleSearch, String string2) {
        suggestedArticleSearch.query = string2;
        return string2;
    }

    static Locale access$202(zendesk.support.SuggestedArticleSearch suggestedArticleSearch, Locale locale2) {
        suggestedArticleSearch.locale = locale2;
        return locale2;
    }

    static String access$302(zendesk.support.SuggestedArticleSearch suggestedArticleSearch, String string2) {
        suggestedArticleSearch.labelNames = string2;
        return string2;
    }

    static Long access$402(zendesk.support.SuggestedArticleSearch suggestedArticleSearch, Long long2) {
        suggestedArticleSearch.categoryId = long2;
        return long2;
    }

    static Long access$502(zendesk.support.SuggestedArticleSearch suggestedArticleSearch, Long long2) {
        suggestedArticleSearch.sectionId = long2;
        return long2;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public String getLabelNames() {
        return this.labelNames;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getQuery() {
        return this.query;
    }

    public Long getSectionId() {
        return this.sectionId;
    }
}

package zendesk.support;

import java.util.Locale;

/* loaded from: classes3.dex */
public class ListArticleQuery {

    private String include;
    private String labelNames;
    private Locale locale;
    private Integer page;
    private Integer resultsPerPage;
    private zendesk.support.SortBy sortBy;
    private zendesk.support.SortOrder sortOrder;
    public String getInclude() {
        return this.include;
    }

    public String getLabelNames() {
        return this.labelNames;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public Integer getPage() {
        return this.page;
    }

    public Integer getResultsPerPage() {
        return this.resultsPerPage;
    }

    public zendesk.support.SortBy getSortBy() {
        return this.sortBy;
    }

    public zendesk.support.SortOrder getSortOrder() {
        return this.sortOrder;
    }

    public void setInclude(String string) {
        this.include = string;
    }

    public void setLabelNames(String string) {
        this.labelNames = string;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void setPage(Integer integer) {
        this.page = integer;
    }

    public void setResultsPerPage(Integer integer) {
        this.resultsPerPage = integer;
    }

    public void setSortBy(zendesk.support.SortBy sortBy) {
        this.sortBy = sortBy;
    }

    public void setSortOrder(zendesk.support.SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }
}

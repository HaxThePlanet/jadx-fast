package zendesk.support;

import f.g.e.a;
import f.g.e.g;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class HelpCenterSearch implements Serializable, java.lang.Cloneable {

    private String categoryIds;
    private String include;
    private String labelNames;
    private Locale locale;
    private Integer page;
    private Integer perPage;
    private String query;
    private String sectionIds;

    public static class Builder {

        private String categoryIds;
        private String[] include;
        private String[] labelNames;
        private Locale locale;
        private Integer page;
        private Integer perPage;
        private String query;
        private String sectionIds;
        public zendesk.support.HelpCenterSearch build() {
            HelpCenterSearch helpCenterSearch = new HelpCenterSearch(0);
            HelpCenterSearch.access$102(helpCenterSearch, this.query);
            HelpCenterSearch.access$202(helpCenterSearch, this.locale);
            HelpCenterSearch.access$302(helpCenterSearch, g.h(this.include));
            HelpCenterSearch.access$402(helpCenterSearch, g.h(this.labelNames));
            HelpCenterSearch.access$502(helpCenterSearch, this.categoryIds);
            HelpCenterSearch.access$602(helpCenterSearch, this.sectionIds);
            HelpCenterSearch.access$702(helpCenterSearch, this.page);
            HelpCenterSearch.access$802(helpCenterSearch, this.perPage);
            return helpCenterSearch;
        }

        public zendesk.support.HelpCenterSearch.Builder forLocale(Locale locale) {
            this.locale = locale;
            return this;
        }

        public zendesk.support.HelpCenterSearch.Builder page(Integer integer) {
            this.page = integer;
            return this;
        }

        public zendesk.support.HelpCenterSearch.Builder perPage(Integer integer) {
            this.perPage = integer;
            return this;
        }

        public zendesk.support.HelpCenterSearch.Builder withCategoryId(Long long) {
            long longValue;
            String obj3;
            if (long != null) {
                this.categoryIds = Long.toString(long.longValue());
            }
            return this;
        }

        public zendesk.support.HelpCenterSearch.Builder withCategoryIds(List<Long> list) {
            this.categoryIds = g.i(a.c(list));
            return this;
        }

        public zendesk.support.HelpCenterSearch.Builder withIncludes(String... stringArr) {
            this.include = stringArr;
            return this;
        }

        public zendesk.support.HelpCenterSearch.Builder withLabelNames(String... stringArr) {
            this.labelNames = stringArr;
            return this;
        }

        public zendesk.support.HelpCenterSearch.Builder withQuery(String string) {
            this.query = string;
            return this;
        }

        public zendesk.support.HelpCenterSearch.Builder withSectionId(Long long) {
            long longValue;
            String obj3;
            if (long != null) {
                this.sectionIds = Long.toString(long.longValue());
            }
            return this;
        }

        public zendesk.support.HelpCenterSearch.Builder withSectionIds(List<Long> list) {
            this.sectionIds = g.i(a.c(list));
            return this;
        }
    }
    HelpCenterSearch(zendesk.support.HelpCenterSearch.1 helpCenterSearch$1) {
        super();
    }

    static String access$102(zendesk.support.HelpCenterSearch helpCenterSearch, String string2) {
        helpCenterSearch.query = string2;
        return string2;
    }

    static Locale access$202(zendesk.support.HelpCenterSearch helpCenterSearch, Locale locale2) {
        helpCenterSearch.locale = locale2;
        return locale2;
    }

    static String access$302(zendesk.support.HelpCenterSearch helpCenterSearch, String string2) {
        helpCenterSearch.include = string2;
        return string2;
    }

    static String access$402(zendesk.support.HelpCenterSearch helpCenterSearch, String string2) {
        helpCenterSearch.labelNames = string2;
        return string2;
    }

    static String access$502(zendesk.support.HelpCenterSearch helpCenterSearch, String string2) {
        helpCenterSearch.categoryIds = string2;
        return string2;
    }

    static String access$602(zendesk.support.HelpCenterSearch helpCenterSearch, String string2) {
        helpCenterSearch.sectionIds = string2;
        return string2;
    }

    static Integer access$702(zendesk.support.HelpCenterSearch helpCenterSearch, Integer integer2) {
        helpCenterSearch.page = integer2;
        return integer2;
    }

    static Integer access$802(zendesk.support.HelpCenterSearch helpCenterSearch, Integer integer2) {
        helpCenterSearch.perPage = integer2;
        return integer2;
    }

    @Override // java.io.Serializable
    public String getCategoryIds() {
        return this.categoryIds;
    }

    @Override // java.io.Serializable
    public String getInclude() {
        return this.include;
    }

    @Override // java.io.Serializable
    public String getLabelNames() {
        return this.labelNames;
    }

    @Override // java.io.Serializable
    public Locale getLocale() {
        return this.locale;
    }

    @Override // java.io.Serializable
    public Integer getPage() {
        return this.page;
    }

    @Override // java.io.Serializable
    public Integer getPerPage() {
        return this.perPage;
    }

    @Override // java.io.Serializable
    public String getQuery() {
        return this.query;
    }

    @Override // java.io.Serializable
    public String getSectionIds() {
        return this.sectionIds;
    }

    @Override // java.io.Serializable
    public zendesk.support.HelpCenterSearch withQuery(String string) {
        zendesk.support.HelpCenterSearch helpCenterSearch;
        Object clone;
        String obj3;
        helpCenterSearch = new HelpCenterSearch();
        clone.query = string;
        return clone;
    }
}

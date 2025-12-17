package zendesk.support;

import f.g.e.g;
import java.util.List;

/* loaded from: classes3.dex */
public class HelpRequest {

    private static final int DEFAULT_ARTICLES_PER_SECTION = 5;
    private static final String INCLUDE_ALL = "categories,sections";
    private static final String INCLUDE_CATEGORIES = "categories";
    private static final String INCLUDE_SECTIONS = "sections";
    private static final String LOG_TAG = "HelpRequest";
    private int articlesPerPageLimit;
    private String categoryIds;
    private String includes;
    private String[] labelNames;
    private String sectionIds;

    public static class Builder {

        private int articlesPerSectionLimit = 5;
        private String categoryIds;
        private String includes;
        private String[] labelNames;
        private String sectionIds;
        public Builder() {
            super();
            final int i = 5;
        }

        static String access$000(zendesk.support.HelpRequest.Builder helpRequest$Builder) {
            return builder.categoryIds;
        }

        static String access$100(zendesk.support.HelpRequest.Builder helpRequest$Builder) {
            return builder.sectionIds;
        }

        static String access$200(zendesk.support.HelpRequest.Builder helpRequest$Builder) {
            return builder.includes;
        }

        static int access$300(zendesk.support.HelpRequest.Builder helpRequest$Builder) {
            return builder.articlesPerSectionLimit;
        }

        static String[] access$400(zendesk.support.HelpRequest.Builder helpRequest$Builder) {
            return builder.labelNames;
        }

        public zendesk.support.HelpRequest build() {
            HelpRequest helpRequest = new HelpRequest(this, 0);
            return helpRequest;
        }

        public zendesk.support.HelpRequest.Builder includeCategories() {
            String equals;
            String str;
            if (g.e(this.includes)) {
                this.includes = "categories";
            } else {
                if (this.includes.equals("sections")) {
                    this.includes = "categories,sections";
                }
            }
            return this;
        }

        public zendesk.support.HelpRequest.Builder includeSections() {
            String equals;
            String str;
            if (g.e(this.includes)) {
                this.includes = "sections";
            } else {
                if (this.includes.equals("categories")) {
                    this.includes = "categories,sections";
                }
            }
            return this;
        }

        public zendesk.support.HelpRequest.Builder withArticlesPerSectionLimit(int i) {
            this.articlesPerSectionLimit = i;
            return this;
        }

        public zendesk.support.HelpRequest.Builder withCategoryIds(List<Long> list) {
            this.categoryIds = g.i(list);
            return this;
        }

        public zendesk.support.HelpRequest.Builder withLabelNames(String... stringArr) {
            this.labelNames = stringArr;
            return this;
        }

        public zendesk.support.HelpRequest.Builder withSectionIds(List<Long> list) {
            this.sectionIds = g.i(list);
            return this;
        }
    }
    private HelpRequest(zendesk.support.HelpRequest.Builder helpRequest$Builder) {
        super();
        this.categoryIds = HelpRequest.Builder.access$000(builder);
        this.sectionIds = HelpRequest.Builder.access$100(builder);
        this.includes = HelpRequest.Builder.access$200(builder);
        this.articlesPerPageLimit = HelpRequest.Builder.access$300(builder);
        this.labelNames = HelpRequest.Builder.access$400(builder);
    }

    HelpRequest(zendesk.support.HelpRequest.Builder helpRequest$Builder, zendesk.support.HelpRequest.1 helpRequest$12) {
        super(builder);
    }

    public int getArticlesPerPageLimit() {
        return this.articlesPerPageLimit;
    }

    public String getCategoryIds() {
        return this.categoryIds;
    }

    public String getIncludes() {
        return this.includes;
    }

    public String[] getLabelNames() {
        return this.labelNames;
    }

    public String getSectionIds() {
        return this.sectionIds;
    }
}

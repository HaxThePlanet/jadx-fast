package zendesk.support.guide;

import android.content.Context;
import android.content.Intent;
import f.g.e.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import o.a.a;
import o.a.b;
import zendesk.messaging.Engine;
import zendesk.messaging.EngineListRegistry;
import zendesk.support.Article;

/* loaded from: classes3.dex */
public class ArticleConfiguration implements a {

    static final int ARTICLE_ID = 1;
    static final int ARTICLE_MODEL = 2;
    static final int UNKNOWN = -1;
    private final zendesk.support.guide.ArticleViewModel article;
    private final long articleId;
    private final int configurationState;
    private final List<a> configurations;
    private final boolean contactUsVisible;
    private final String engineRegistryId;

    public static class Builder {

        private zendesk.support.guide.ArticleViewModel article;
        private long articleId;
        private int configurationState;
        private List<a> configurations;
        private boolean contactUsVisible = true;
        private List<Engine> engines;
        public Builder() {
            super();
            int i = 1;
            this.configurations = Collections.emptyList();
            this.engines = Collections.emptyList();
            this.configurationState = -1;
        }

        public Builder(long l) {
            super();
            this.configurations = Collections.emptyList();
            this.engines = Collections.emptyList();
            this.articleId = l;
            this.configurationState = 1;
        }

        public Builder(Article article) {
            super();
            int i = 1;
            this.configurations = Collections.emptyList();
            this.engines = Collections.emptyList();
            ArticleViewModel articleViewModel = new ArticleViewModel(article);
            this.article = articleViewModel;
            this.configurationState = 2;
        }

        static int access$000(zendesk.support.guide.ArticleConfiguration.Builder articleConfiguration$Builder) {
            return builder.configurationState;
        }

        static zendesk.support.guide.ArticleViewModel access$100(zendesk.support.guide.ArticleConfiguration.Builder articleConfiguration$Builder) {
            return builder.article;
        }

        static long access$200(zendesk.support.guide.ArticleConfiguration.Builder articleConfiguration$Builder) {
            return builder.articleId;
        }

        static boolean access$300(zendesk.support.guide.ArticleConfiguration.Builder articleConfiguration$Builder) {
            return builder.contactUsVisible;
        }

        static List access$400(zendesk.support.guide.ArticleConfiguration.Builder articleConfiguration$Builder) {
            return builder.configurations;
        }

        private void setConfigurations(List<a> list) {
            boolean iNSTANCE;
            Class<zendesk.support.guide.ArticleConfiguration> obj;
            Object obj3;
            this.configurations = list;
            obj3 = b.h().e(list, ArticleConfiguration.class);
            if (a.i(list) && (ArticleConfiguration)obj3 != null) {
                this.configurations = list;
                obj3 = b.h().e(list, ArticleConfiguration.class);
                if ((ArticleConfiguration)(ArticleConfiguration)obj3 != null) {
                    this.contactUsVisible = (ArticleConfiguration)(ArticleConfiguration)obj3.isContactUsButtonVisible();
                    this.engines = EngineListRegistry.INSTANCE.retrieveEngineList(ArticleConfiguration.access$500(obj3));
                }
            }
        }

        public a config() {
            ArticleConfiguration articleConfiguration = new ArticleConfiguration(this, EngineListRegistry.INSTANCE.register(this.engines), 0);
            return articleConfiguration;
        }

        public Intent intent(Context context, List<a> list2) {
            setConfigurations(list2);
            Intent intent = new Intent(context, ViewArticleActivity.class);
            b.h().c(intent, config());
            return intent;
        }

        public Intent intent(Context context, a... a2Arr2) {
            return intent(context, Arrays.asList(a2Arr2));
        }

        public void show(Context context, List<a> list2) {
            context.startActivity(intent(context, list2));
        }

        public void show(Context context, a... a2Arr2) {
            context.startActivity(intent(context, a2Arr2));
        }

        public zendesk.support.guide.ArticleConfiguration.Builder withContactUsButtonVisible(boolean z) {
            this.contactUsVisible = z;
            return this;
        }

        public zendesk.support.guide.ArticleConfiguration.Builder withEngines(List<Engine> list) {
            this.engines = list;
            return this;
        }

        public zendesk.support.guide.ArticleConfiguration.Builder withEngines(Engine... engineArr) {
            return withEngines(Arrays.asList(engineArr));
        }
    }
    private ArticleConfiguration(zendesk.support.guide.ArticleConfiguration.Builder articleConfiguration$Builder, String string2) {
        super();
        this.configurationState = ArticleConfiguration.Builder.access$000(builder);
        this.article = ArticleConfiguration.Builder.access$100(builder);
        this.articleId = ArticleConfiguration.Builder.access$200(builder);
        this.contactUsVisible = ArticleConfiguration.Builder.access$300(builder);
        this.configurations = ArticleConfiguration.Builder.access$400(builder);
        this.engineRegistryId = string2;
    }

    ArticleConfiguration(zendesk.support.guide.ArticleConfiguration.Builder articleConfiguration$Builder, String string2, zendesk.support.guide.ArticleConfiguration.1 articleConfiguration$13) {
        super(builder, string2);
    }

    static String access$500(zendesk.support.guide.ArticleConfiguration articleConfiguration) {
        return articleConfiguration.engineRegistryId;
    }

    @Override // o.a.a
    zendesk.support.guide.ArticleViewModel getArticle() {
        return this.article;
    }

    @Override // o.a.a
    long getArticleId() {
        return this.articleId;
    }

    @Override // o.a.a
    int getConfigurationState() {
        return this.configurationState;
    }

    public List<a> getConfigurations() {
        return b.h().a(this.configurations, this);
    }

    public List<Engine> getEngines() {
        return EngineListRegistry.INSTANCE.retrieveEngineList(this.engineRegistryId);
    }

    @Override // o.a.a
    public boolean isContactUsButtonVisible() {
        return this.contactUsVisible;
    }
}

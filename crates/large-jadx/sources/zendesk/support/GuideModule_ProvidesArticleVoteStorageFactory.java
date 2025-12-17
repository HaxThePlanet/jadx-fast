package zendesk.support;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class GuideModule_ProvidesArticleVoteStorageFactory implements b<zendesk.support.ArticleVoteStorage> {

    private final zendesk.support.GuideModule module;
    public GuideModule_ProvidesArticleVoteStorageFactory(zendesk.support.GuideModule guideModule) {
        super();
        this.module = guideModule;
    }

    public static zendesk.support.GuideModule_ProvidesArticleVoteStorageFactory create(zendesk.support.GuideModule guideModule) {
        GuideModule_ProvidesArticleVoteStorageFactory guideModule_ProvidesArticleVoteStorageFactory = new GuideModule_ProvidesArticleVoteStorageFactory(guideModule);
        return guideModule_ProvidesArticleVoteStorageFactory;
    }

    public static zendesk.support.ArticleVoteStorage providesArticleVoteStorage(zendesk.support.GuideModule guideModule) {
        final zendesk.support.ArticleVoteStorage obj1 = guideModule.providesArticleVoteStorage();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ArticleVoteStorage)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.ArticleVoteStorage get() {
        return GuideModule_ProvidesArticleVoteStorageFactory.providesArticleVoteStorage(this.module);
    }
}

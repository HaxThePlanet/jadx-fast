package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.SessionStorage;

/* loaded from: classes3.dex */
public final class GuideProviderModule_ProvideArticleVoteStorageFactory implements b<zendesk.support.ArticleVoteStorage> {

    private final a<SessionStorage> baseStorageProvider;
    public GuideProviderModule_ProvideArticleVoteStorageFactory(a<SessionStorage> a) {
        super();
        this.baseStorageProvider = a;
    }

    public static zendesk.support.GuideProviderModule_ProvideArticleVoteStorageFactory create(a<SessionStorage> a) {
        GuideProviderModule_ProvideArticleVoteStorageFactory guideProviderModule_ProvideArticleVoteStorageFactory = new GuideProviderModule_ProvideArticleVoteStorageFactory(a);
        return guideProviderModule_ProvideArticleVoteStorageFactory;
    }

    public static zendesk.support.ArticleVoteStorage provideArticleVoteStorage(SessionStorage sessionStorage) {
        final zendesk.support.ArticleVoteStorage obj1 = GuideProviderModule.provideArticleVoteStorage(sessionStorage);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ArticleVoteStorage)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.ArticleVoteStorage get() {
        return GuideProviderModule_ProvideArticleVoteStorageFactory.provideArticleVoteStorage((SessionStorage)this.baseStorageProvider.get());
    }
}

package zendesk.answerbot;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.messaging.components.Timer.Factory;

/* loaded from: classes3.dex */
public final class AnswerBotArticleModule_GetViewModelFactory implements b<zendesk.answerbot.AnswerBotArticleViewModel> {

    private final a<zendesk.answerbot.AnswerBotProvider> answerBotProvider;
    private final a<zendesk.answerbot.ArticleViewModel> articleViewModelProvider;
    private final zendesk.answerbot.AnswerBotArticleModule module;
    private final a<Timer.Factory> timerFactoryProvider;
    private final a<zendesk.answerbot.ArticleUrlIdentifier> urlIdentifierProvider;
    public AnswerBotArticleModule_GetViewModelFactory(zendesk.answerbot.AnswerBotArticleModule answerBotArticleModule, a<zendesk.answerbot.AnswerBotProvider> a2, a<zendesk.answerbot.ArticleViewModel> a3, a<Timer.Factory> a4, a<zendesk.answerbot.ArticleUrlIdentifier> a5) {
        super();
        this.module = answerBotArticleModule;
        this.answerBotProvider = a2;
        this.articleViewModelProvider = a3;
        this.timerFactoryProvider = a4;
        this.urlIdentifierProvider = a5;
    }

    public static zendesk.answerbot.AnswerBotArticleModule_GetViewModelFactory create(zendesk.answerbot.AnswerBotArticleModule answerBotArticleModule, a<zendesk.answerbot.AnswerBotProvider> a2, a<zendesk.answerbot.ArticleViewModel> a3, a<Timer.Factory> a4, a<zendesk.answerbot.ArticleUrlIdentifier> a5) {
        super(answerBotArticleModule, a2, a3, a4, a5);
        return answerBotArticleModule_GetViewModelFactory;
    }

    public static zendesk.answerbot.AnswerBotArticleViewModel getViewModel(zendesk.answerbot.AnswerBotArticleModule answerBotArticleModule, zendesk.answerbot.AnswerBotProvider answerBotProvider2, Object object3, Timer.Factory timer$Factory4, Object object5) {
        final zendesk.answerbot.AnswerBotArticleViewModel obj0 = answerBotArticleModule.getViewModel(answerBotProvider2, (ArticleViewModel)object3, factory4, (ArticleUrlIdentifier)object5);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (AnswerBotArticleViewModel)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.answerbot.AnswerBotArticleViewModel get() {
        return AnswerBotArticleModule_GetViewModelFactory.getViewModel(this.module, (AnswerBotProvider)this.answerBotProvider.get(), this.articleViewModelProvider.get(), (Timer.Factory)this.timerFactoryProvider.get(), this.urlIdentifierProvider.get());
    }
}

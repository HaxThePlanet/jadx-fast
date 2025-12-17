package zendesk.answerbot;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class AnswerBotArticleModule_ArticleViewModelFactory implements b<zendesk.answerbot.ArticleViewModel> {

    private final zendesk.answerbot.AnswerBotArticleModule module;
    public AnswerBotArticleModule_ArticleViewModelFactory(zendesk.answerbot.AnswerBotArticleModule answerBotArticleModule) {
        super();
        this.module = answerBotArticleModule;
    }

    public static zendesk.answerbot.ArticleViewModel articleViewModel(zendesk.answerbot.AnswerBotArticleModule answerBotArticleModule) {
        final zendesk.answerbot.ArticleViewModel obj1 = answerBotArticleModule.articleViewModel();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ArticleViewModel)obj1;
    }

    public static zendesk.answerbot.AnswerBotArticleModule_ArticleViewModelFactory create(zendesk.answerbot.AnswerBotArticleModule answerBotArticleModule) {
        AnswerBotArticleModule_ArticleViewModelFactory answerBotArticleModule_ArticleViewModelFactory = new AnswerBotArticleModule_ArticleViewModelFactory(answerBotArticleModule);
        return answerBotArticleModule_ArticleViewModelFactory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.answerbot.ArticleViewModel get() {
        return AnswerBotArticleModule_ArticleViewModelFactory.articleViewModel(this.module);
    }
}

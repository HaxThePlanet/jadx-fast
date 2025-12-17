package zendesk.answerbot;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.ApplicationConfiguration;

/* loaded from: classes3.dex */
public final class AnswerBotArticleModule_GetArticleUrlIdentifierFactory implements b<zendesk.answerbot.ArticleUrlIdentifier> {

    private final a<ApplicationConfiguration> configProvider;
    private final zendesk.answerbot.AnswerBotArticleModule module;
    public AnswerBotArticleModule_GetArticleUrlIdentifierFactory(zendesk.answerbot.AnswerBotArticleModule answerBotArticleModule, a<ApplicationConfiguration> a2) {
        super();
        this.module = answerBotArticleModule;
        this.configProvider = a2;
    }

    public static zendesk.answerbot.AnswerBotArticleModule_GetArticleUrlIdentifierFactory create(zendesk.answerbot.AnswerBotArticleModule answerBotArticleModule, a<ApplicationConfiguration> a2) {
        AnswerBotArticleModule_GetArticleUrlIdentifierFactory answerBotArticleModule_GetArticleUrlIdentifierFactory = new AnswerBotArticleModule_GetArticleUrlIdentifierFactory(answerBotArticleModule, a2);
        return answerBotArticleModule_GetArticleUrlIdentifierFactory;
    }

    public static zendesk.answerbot.ArticleUrlIdentifier getArticleUrlIdentifier(zendesk.answerbot.AnswerBotArticleModule answerBotArticleModule, ApplicationConfiguration applicationConfiguration2) {
        final zendesk.answerbot.ArticleUrlIdentifier obj0 = answerBotArticleModule.getArticleUrlIdentifier(applicationConfiguration2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (ArticleUrlIdentifier)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.answerbot.ArticleUrlIdentifier get() {
        return AnswerBotArticleModule_GetArticleUrlIdentifierFactory.getArticleUrlIdentifier(this.module, (ApplicationConfiguration)this.configProvider.get());
    }
}

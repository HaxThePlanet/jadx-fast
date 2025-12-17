package zendesk.answerbot;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.ApplicationConfiguration;
import zendesk.core.RestServiceProvider;

/* loaded from: classes3.dex */
public final class AnswerBotArticleModule_GetWebViewClientFactory implements b<zendesk.answerbot.ZendeskWebViewClient> {

    private final a<ApplicationConfiguration> applicationConfigurationProvider;
    private final zendesk.answerbot.AnswerBotArticleModule module;
    private final a<RestServiceProvider> restServiceProvider;
    public AnswerBotArticleModule_GetWebViewClientFactory(zendesk.answerbot.AnswerBotArticleModule answerBotArticleModule, a<ApplicationConfiguration> a2, a<RestServiceProvider> a3) {
        super();
        this.module = answerBotArticleModule;
        this.applicationConfigurationProvider = a2;
        this.restServiceProvider = a3;
    }

    public static zendesk.answerbot.AnswerBotArticleModule_GetWebViewClientFactory create(zendesk.answerbot.AnswerBotArticleModule answerBotArticleModule, a<ApplicationConfiguration> a2, a<RestServiceProvider> a3) {
        AnswerBotArticleModule_GetWebViewClientFactory answerBotArticleModule_GetWebViewClientFactory = new AnswerBotArticleModule_GetWebViewClientFactory(answerBotArticleModule, a2, a3);
        return answerBotArticleModule_GetWebViewClientFactory;
    }

    public static zendesk.answerbot.ZendeskWebViewClient getWebViewClient(zendesk.answerbot.AnswerBotArticleModule answerBotArticleModule, ApplicationConfiguration applicationConfiguration2, RestServiceProvider restServiceProvider3) {
        final zendesk.answerbot.ZendeskWebViewClient obj0 = answerBotArticleModule.getWebViewClient(applicationConfiguration2, restServiceProvider3);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (ZendeskWebViewClient)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.answerbot.ZendeskWebViewClient get() {
        return AnswerBotArticleModule_GetWebViewClientFactory.getWebViewClient(this.module, (ApplicationConfiguration)this.applicationConfigurationProvider.get(), (RestServiceProvider)this.restServiceProvider.get());
    }
}

package zendesk.answerbot;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.RestServiceProvider;

/* loaded from: classes3.dex */
public final class AnswerBotProvidersModule_GetAnswerBotServiceFactory implements b<zendesk.answerbot.AnswerBotService> {

    private final zendesk.answerbot.AnswerBotProvidersModule module;
    private final a<RestServiceProvider> restServiceProvider;
    public AnswerBotProvidersModule_GetAnswerBotServiceFactory(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, a<RestServiceProvider> a2) {
        super();
        this.module = answerBotProvidersModule;
        this.restServiceProvider = a2;
    }

    public static zendesk.answerbot.AnswerBotProvidersModule_GetAnswerBotServiceFactory create(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, a<RestServiceProvider> a2) {
        AnswerBotProvidersModule_GetAnswerBotServiceFactory answerBotProvidersModule_GetAnswerBotServiceFactory = new AnswerBotProvidersModule_GetAnswerBotServiceFactory(answerBotProvidersModule, a2);
        return answerBotProvidersModule_GetAnswerBotServiceFactory;
    }

    public static zendesk.answerbot.AnswerBotService getAnswerBotService(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, RestServiceProvider restServiceProvider2) {
        final zendesk.answerbot.AnswerBotService obj0 = answerBotProvidersModule.getAnswerBotService(restServiceProvider2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (AnswerBotService)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.answerbot.AnswerBotService get() {
        return AnswerBotProvidersModule_GetAnswerBotServiceFactory.getAnswerBotService(this.module, (RestServiceProvider)this.restServiceProvider.get());
    }
}

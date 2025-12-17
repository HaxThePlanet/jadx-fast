package zendesk.answerbot;

import g.b.b;
import g.b.d;
import zendesk.support.HelpCenterProvider;

/* loaded from: classes3.dex */
public final class AnswerBotProvidersModule_GetHelpCenterProviderFactory implements b<HelpCenterProvider> {

    private final zendesk.answerbot.AnswerBotProvidersModule module;
    public AnswerBotProvidersModule_GetHelpCenterProviderFactory(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule) {
        super();
        this.module = answerBotProvidersModule;
    }

    public static zendesk.answerbot.AnswerBotProvidersModule_GetHelpCenterProviderFactory create(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule) {
        AnswerBotProvidersModule_GetHelpCenterProviderFactory answerBotProvidersModule_GetHelpCenterProviderFactory = new AnswerBotProvidersModule_GetHelpCenterProviderFactory(answerBotProvidersModule);
        return answerBotProvidersModule_GetHelpCenterProviderFactory;
    }

    public static HelpCenterProvider getHelpCenterProvider(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule) {
        final HelpCenterProvider obj1 = answerBotProvidersModule.getHelpCenterProvider();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (HelpCenterProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public HelpCenterProvider get() {
        return AnswerBotProvidersModule_GetHelpCenterProviderFactory.getHelpCenterProvider(this.module);
    }
}

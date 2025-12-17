package zendesk.answerbot;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class AnswerBotProvidersModule_GetAnswerBotShadowFactory implements b<zendesk.answerbot.AnswerBotModule> {

    private final a<zendesk.answerbot.AnswerBotProvider> answerBotProvider;
    private final zendesk.answerbot.AnswerBotProvidersModule module;
    private final a<zendesk.answerbot.AnswerBotSettingsProvider> settingsProvider;
    public AnswerBotProvidersModule_GetAnswerBotShadowFactory(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, a<zendesk.answerbot.AnswerBotProvider> a2, a<zendesk.answerbot.AnswerBotSettingsProvider> a3) {
        super();
        this.module = answerBotProvidersModule;
        this.answerBotProvider = a2;
        this.settingsProvider = a3;
    }

    public static zendesk.answerbot.AnswerBotProvidersModule_GetAnswerBotShadowFactory create(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, a<zendesk.answerbot.AnswerBotProvider> a2, a<zendesk.answerbot.AnswerBotSettingsProvider> a3) {
        AnswerBotProvidersModule_GetAnswerBotShadowFactory answerBotProvidersModule_GetAnswerBotShadowFactory = new AnswerBotProvidersModule_GetAnswerBotShadowFactory(answerBotProvidersModule, a2, a3);
        return answerBotProvidersModule_GetAnswerBotShadowFactory;
    }

    public static zendesk.answerbot.AnswerBotModule getAnswerBotShadow(zendesk.answerbot.AnswerBotProvidersModule answerBotProvidersModule, zendesk.answerbot.AnswerBotProvider answerBotProvider2, Object object3) {
        final zendesk.answerbot.AnswerBotModule obj0 = answerBotProvidersModule.getAnswerBotShadow(answerBotProvider2, (AnswerBotSettingsProvider)object3);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (AnswerBotModule)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.answerbot.AnswerBotModule get() {
        return AnswerBotProvidersModule_GetAnswerBotShadowFactory.getAnswerBotShadow(this.module, (AnswerBotProvider)this.answerBotProvider.get(), this.settingsProvider.get());
    }
}

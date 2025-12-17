package zendesk.answerbot;

import android.content.res.Resources;
import g.b.b;
import g.b.d;
import j.a.a;
import o.a.b;
import zendesk.messaging.components.Timer.Factory;

/* loaded from: classes3.dex */
public final class AnswerBotConversationModule_GetAnswerBotModelFactory implements b<zendesk.answerbot.AnswerBotModel> {

    private final a<zendesk.answerbot.AnswerBotProvider> answerBotProvider;
    private final a<zendesk.answerbot.AnswerBotSettingsProvider> answerBotSettingsProvider;
    private final a<b> configurationHelperProvider;
    private final a<zendesk.answerbot.AnswerBotConversationManager> conversationManagerProvider;
    private final zendesk.answerbot.AnswerBotConversationModule module;
    private final a<Resources> resourcesProvider;
    private final a<Timer.Factory> timerFactoryProvider;
    public AnswerBotConversationModule_GetAnswerBotModelFactory(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, a<zendesk.answerbot.AnswerBotProvider> a2, a<zendesk.answerbot.AnswerBotSettingsProvider> a3, a<Timer.Factory> a4, a<Resources> a5, a<zendesk.answerbot.AnswerBotConversationManager> a6, a<b> a7) {
        super();
        this.module = answerBotConversationModule;
        this.answerBotProvider = a2;
        this.answerBotSettingsProvider = a3;
        this.timerFactoryProvider = a4;
        this.resourcesProvider = a5;
        this.conversationManagerProvider = a6;
        this.configurationHelperProvider = a7;
    }

    public static zendesk.answerbot.AnswerBotConversationModule_GetAnswerBotModelFactory create(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, a<zendesk.answerbot.AnswerBotProvider> a2, a<zendesk.answerbot.AnswerBotSettingsProvider> a3, a<Timer.Factory> a4, a<Resources> a5, a<zendesk.answerbot.AnswerBotConversationManager> a6, a<b> a7) {
        super(answerBotConversationModule, a2, a3, a4, a5, a6, a7);
        return answerBotConversationModule_GetAnswerBotModelFactory;
    }

    public static zendesk.answerbot.AnswerBotModel getAnswerBotModel(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, zendesk.answerbot.AnswerBotProvider answerBotProvider2, Object object3, Timer.Factory timer$Factory4, Resources resources5, Object object6, b b7) {
        final zendesk.answerbot.AnswerBotModel obj7 = answerBotConversationModule.getAnswerBotModel(answerBotProvider2, (AnswerBotSettingsProvider)object3, factory4, resources5, (AnswerBotConversationManager)object6, b7);
        d.c(obj7, "Cannot return null from a non-@Nullable @Provides method");
        return (AnswerBotModel)obj7;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.answerbot.AnswerBotModel get() {
        return AnswerBotConversationModule_GetAnswerBotModelFactory.getAnswerBotModel(this.module, (AnswerBotProvider)this.answerBotProvider.get(), this.answerBotSettingsProvider.get(), (Timer.Factory)this.timerFactoryProvider.get(), (Resources)this.resourcesProvider.get(), this.conversationManagerProvider.get(), (b)this.configurationHelperProvider.get());
    }
}

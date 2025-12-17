package zendesk.answerbot;

import android.content.Context;
import g.b.b;
import j.a.a;
import o.a.b;
import zendesk.messaging.Update;
import zendesk.messaging.components.CompositeActionListener;
import zendesk.messaging.components.bot.BotMessageDispatcher.ConversationState;

/* loaded from: classes3.dex */
public final class AnswerBotEngine_Factory implements b<zendesk.answerbot.AnswerBotEngine> {

    private final a<zendesk.answerbot.AnswerBotCellFactory> answerBotCellFactoryProvider;
    private final a<zendesk.answerbot.AnswerBotModel> answerBotModelProvider;
    private final a<b> configurationHelperProvider;
    private final a<Context> contextProvider;
    private final a<CompositeActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>>> stateActionListenerProvider;
    private final a<CompositeActionListener<Update>> updateActionListenerProvider;
    public AnswerBotEngine_Factory(a<Context> a, a<zendesk.answerbot.AnswerBotModel> a2, a<zendesk.answerbot.AnswerBotCellFactory> a3, a<CompositeActionListener<Update>> a4, a<CompositeActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>>> a5, a<b> a6) {
        super();
        this.contextProvider = a;
        this.answerBotModelProvider = a2;
        this.answerBotCellFactoryProvider = a3;
        this.updateActionListenerProvider = a4;
        this.stateActionListenerProvider = a5;
        this.configurationHelperProvider = a6;
    }

    public static zendesk.answerbot.AnswerBotEngine_Factory create(a<Context> a, a<zendesk.answerbot.AnswerBotModel> a2, a<zendesk.answerbot.AnswerBotCellFactory> a3, a<CompositeActionListener<Update>> a4, a<CompositeActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>>> a5, a<b> a6) {
        super(a, a2, a3, a4, a5, a6);
        return answerBotEngine_Factory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.answerbot.AnswerBotEngine get() {
        super((Context)this.contextProvider.get(), (AnswerBotModel)this.answerBotModelProvider.get(), (AnswerBotCellFactory)this.answerBotCellFactoryProvider.get(), (CompositeActionListener)this.updateActionListenerProvider.get(), (CompositeActionListener)this.stateActionListenerProvider.get(), (b)this.configurationHelperProvider.get());
        return answerBotEngine2;
    }
}

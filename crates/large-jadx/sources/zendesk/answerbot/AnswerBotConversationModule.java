package zendesk.answerbot;

import android.content.Context;
import android.content.res.Resources;
import com.squareup.picasso.t;
import com.squareup.picasso.t.b;
import java.util.concurrent.atomic.AtomicBoolean;
import o.a.b;
import zendesk.messaging.Update;
import zendesk.messaging.components.ActionListener;
import zendesk.messaging.components.CompositeActionListener;
import zendesk.messaging.components.DateProvider;
import zendesk.messaging.components.Timer.Factory;
import zendesk.messaging.components.bot.BotMessageDispatcher;
import zendesk.messaging.components.bot.BotMessageDispatcher.ConversationState;
import zendesk.messaging.components.bot.BotMessageDispatcher.MessageIdentifier;

/* loaded from: classes3.dex */
class AnswerBotConversationModule {
    static Resources getResources(Context context) {
        return context.getResources();
    }

    b configurationHelper() {
        b bVar = new b();
        return bVar;
    }

    zendesk.answerbot.AnswerBotCellFactory getAnswerBotCellFactory() {
        AnswerBotCellFactory answerBotCellFactory = new AnswerBotCellFactory();
        return answerBotCellFactory;
    }

    zendesk.answerbot.AnswerBotModel getAnswerBotModel(zendesk.answerbot.AnswerBotProvider answerBotProvider, zendesk.answerbot.AnswerBotSettingsProvider answerBotSettingsProvider2, Timer.Factory timer$Factory3, Resources resources4, zendesk.answerbot.AnswerBotConversationManager answerBotConversationManager5, b b6) {
        int i = 0;
        AtomicBoolean atomicBoolean = new AtomicBoolean(i);
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(i);
        super(answerBotProvider, answerBotSettingsProvider2, factory3, resources4, atomicBoolean, atomicBoolean2, answerBotConversationManager5, b6);
        return answerBotModel2;
    }

    t getPicasso(Context context) {
        t.b bVar = new t.b(context);
        return bVar.a();
    }

    BotMessageDispatcher<zendesk.answerbot.AnswerBotInteraction> provideBotMessageDispatcher(BotMessageDispatcher.MessageIdentifier<zendesk.answerbot.AnswerBotInteraction> botMessageDispatcher$MessageIdentifier, ActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>> actionListener2, ActionListener<Update> actionListener3, Timer.Factory timer$Factory4) {
        BotMessageDispatcher botMessageDispatcher = new BotMessageDispatcher(messageIdentifier, actionListener2, actionListener3, factory4);
        return botMessageDispatcher;
    }

    zendesk.answerbot.AnswerBotConversationManager provideConversationManager(BotMessageDispatcher<zendesk.answerbot.AnswerBotInteraction> botMessageDispatcher, DateProvider dateProvider2) {
        AnswerBotConversationManager answerBotConversationManager = new AnswerBotConversationManager(botMessageDispatcher, dateProvider2);
        return answerBotConversationManager;
    }

    DateProvider provideDateProvider() {
        DateProvider dateProvider = new DateProvider();
        return dateProvider;
    }

    BotMessageDispatcher.MessageIdentifier<zendesk.answerbot.AnswerBotInteraction> provideInteractionIdentifier() {
        AnswerBotConversationModule.1 anon = new AnswerBotConversationModule.1(this);
        return anon;
    }

    ActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>> provideStateActionListener(CompositeActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>> compositeActionListener) {
        AnswerBotConversationModule.2 anon = new AnswerBotConversationModule.2(this, compositeActionListener);
        return anon;
    }

    CompositeActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>> provideStateCompositeActionListener() {
        return CompositeActionListener.create();
    }

    ActionListener<Update> provideUpdateActionListener(CompositeActionListener<Update> compositeActionListener) {
        AnswerBotConversationModule.3 anon = new AnswerBotConversationModule.3(this, compositeActionListener);
        return anon;
    }

    CompositeActionListener<Update> provideUpdateCompositeActionListener() {
        return CompositeActionListener.create();
    }
}

package zendesk.support;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import o.a.b;
import zendesk.core.AuthenticationProvider;
import zendesk.core.Zendesk;
import zendesk.messaging.MessagingItem;
import zendesk.messaging.Update;
import zendesk.messaging.components.ActionListener;
import zendesk.messaging.components.CompositeActionListener;
import zendesk.messaging.components.Timer.Factory;
import zendesk.messaging.components.bot.BotMessageDispatcher;
import zendesk.messaging.components.bot.BotMessageDispatcher.ConversationState;
import zendesk.messaging.components.bot.BotMessageDispatcher.MessageIdentifier;

/* loaded from: classes3.dex */
class SupportEngineModule {
    BotMessageDispatcher<MessagingItem> botMessageDispatcher(BotMessageDispatcher.MessageIdentifier<MessagingItem> botMessageDispatcher$MessageIdentifier, ActionListener<BotMessageDispatcher.ConversationState<MessagingItem>> actionListener2, ActionListener<Update> actionListener3, Timer.Factory timer$Factory4) {
        BotMessageDispatcher botMessageDispatcher = new BotMessageDispatcher(messageIdentifier, actionListener2, actionListener3, factory4);
        return botMessageDispatcher;
    }

    b configurationHelper() {
        b bVar = new b();
        return bVar;
    }

    zendesk.support.EmailValidator emailValidator() {
        EmailValidator emailValidator = new EmailValidator();
        return emailValidator;
    }

    BotMessageDispatcher.MessageIdentifier<MessagingItem> interactionIdentifier() {
        SupportEngineModule.3 anon = new SupportEngineModule.3(this);
        return anon;
    }

    Handler provideHandler() {
        Handler handler = new Handler(Looper.getMainLooper());
        return handler;
    }

    zendesk.support.RequestCreator requestCreator(zendesk.support.RequestProvider requestProvider, zendesk.support.UploadProvider uploadProvider2) {
        RequestCreator requestCreator = new RequestCreator(requestProvider, uploadProvider2);
        return requestCreator;
    }

    ActionListener<BotMessageDispatcher.ConversationState<MessagingItem>> stateActionListener(CompositeActionListener<BotMessageDispatcher.ConversationState<MessagingItem>> compositeActionListener) {
        SupportEngineModule.1 anon = new SupportEngineModule.1(this, compositeActionListener);
        return anon;
    }

    CompositeActionListener<BotMessageDispatcher.ConversationState<MessagingItem>> stateCompositeActionListener() {
        return CompositeActionListener.create();
    }

    zendesk.support.SupportEngine supportEngine(Context context, zendesk.support.SupportEngineModel supportEngineModel2, CompositeActionListener<BotMessageDispatcher.ConversationState<MessagingItem>> compositeActionListener3, CompositeActionListener<Update> compositeActionListener4) {
        SupportEngine supportEngine = new SupportEngine(context, supportEngineModel2, compositeActionListener3, compositeActionListener4);
        return supportEngine;
    }

    zendesk.support.SupportEngineModel supportEngineModel(zendesk.support.SupportSettingsProvider supportSettingsProvider, zendesk.support.RequestCreator requestCreator2, AuthenticationProvider authenticationProvider3, b b4, zendesk.support.EmailValidator emailValidator5, BotMessageDispatcher<MessagingItem> botMessageDispatcher6) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        super(supportSettingsProvider, requestCreator2, Zendesk.INSTANCE, authenticationProvider3, emailValidator5, b4, atomicBoolean, botMessageDispatcher6);
        return supportEngineModel2;
    }

    Timer.Factory timerFactory(Handler handler) {
        Timer.Factory factory = new Timer.Factory(handler);
        return factory;
    }

    ActionListener<Update> updateActionListener(CompositeActionListener<Update> compositeActionListener) {
        SupportEngineModule.2 anon = new SupportEngineModule.2(this, compositeActionListener);
        return anon;
    }

    CompositeActionListener<Update> updateViewObserver() {
        return CompositeActionListener.create();
    }
}

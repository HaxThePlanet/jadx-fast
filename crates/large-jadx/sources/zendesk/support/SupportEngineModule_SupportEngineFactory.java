package zendesk.support;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.messaging.MessagingItem;
import zendesk.messaging.Update;
import zendesk.messaging.components.CompositeActionListener;
import zendesk.messaging.components.bot.BotMessageDispatcher.ConversationState;

/* loaded from: classes3.dex */
public final class SupportEngineModule_SupportEngineFactory implements b<zendesk.support.SupportEngine> {

    private final a<Context> contextProvider;
    private final zendesk.support.SupportEngineModule module;
    private final a<CompositeActionListener<BotMessageDispatcher.ConversationState<MessagingItem>>> stateViewObserverProvider;
    private final a<zendesk.support.SupportEngineModel> supportEngineModelProvider;
    private final a<CompositeActionListener<Update>> updateViewObserverProvider;
    public SupportEngineModule_SupportEngineFactory(zendesk.support.SupportEngineModule supportEngineModule, a<Context> a2, a<zendesk.support.SupportEngineModel> a3, a<CompositeActionListener<BotMessageDispatcher.ConversationState<MessagingItem>>> a4, a<CompositeActionListener<Update>> a5) {
        super();
        this.module = supportEngineModule;
        this.contextProvider = a2;
        this.supportEngineModelProvider = a3;
        this.stateViewObserverProvider = a4;
        this.updateViewObserverProvider = a5;
    }

    public static zendesk.support.SupportEngineModule_SupportEngineFactory create(zendesk.support.SupportEngineModule supportEngineModule, a<Context> a2, a<zendesk.support.SupportEngineModel> a3, a<CompositeActionListener<BotMessageDispatcher.ConversationState<MessagingItem>>> a4, a<CompositeActionListener<Update>> a5) {
        super(supportEngineModule, a2, a3, a4, a5);
        return supportEngineModule_SupportEngineFactory;
    }

    public static zendesk.support.SupportEngine supportEngine(zendesk.support.SupportEngineModule supportEngineModule, Context context2, Object object3, CompositeActionListener<BotMessageDispatcher.ConversationState<MessagingItem>> compositeActionListener4, CompositeActionListener<Update> compositeActionListener5) {
        final zendesk.support.SupportEngine obj0 = supportEngineModule.supportEngine(context2, (SupportEngineModel)object3, compositeActionListener4, compositeActionListener5);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (SupportEngine)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.SupportEngine get() {
        return SupportEngineModule_SupportEngineFactory.supportEngine(this.module, (Context)this.contextProvider.get(), this.supportEngineModelProvider.get(), (CompositeActionListener)this.stateViewObserverProvider.get(), (CompositeActionListener)this.updateViewObserverProvider.get());
    }
}

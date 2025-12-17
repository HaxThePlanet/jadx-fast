package zendesk.support;

import android.animation.ValueAnimator;
import android.content.Context;
import f.g.d.j;
import zendesk.core.Zendesk;
import zendesk.messaging.AgentDetails;
import zendesk.messaging.Engine;
import zendesk.messaging.Engine.TransferOptionDescription;
import zendesk.messaging.Event;
import zendesk.messaging.Event.MessageSubmitted;
import zendesk.messaging.MessagingApi;
import zendesk.messaging.MessagingItem;
import zendesk.messaging.ObservableEngine;
import zendesk.messaging.Update;
import zendesk.messaging.Update.State.ApplyMessagingItems;
import zendesk.messaging.Update.State.HideTyping;
import zendesk.messaging.Update.State.ShowTyping;
import zendesk.messaging.components.ActionListener;
import zendesk.messaging.components.CompositeActionListener;
import zendesk.messaging.components.bot.BotMessageDispatcher.ConversationState;

/* loaded from: classes3.dex */
public class SupportEngine extends ObservableEngine {

    private static final String SUPPORT_ENGINE_ID = "SUPPORT";
    private final Context context;
    private final Engine.TransferOptionDescription description;
    private final CompositeActionListener<BotMessageDispatcher.ConversationState<MessagingItem>> stateViewObserver;
    private final zendesk.support.SupportEngineModel supportModel;
    private final CompositeActionListener<Update> updateViewObserver;
    SupportEngine(Context context, zendesk.support.SupportEngineModel supportEngineModel2, CompositeActionListener<BotMessageDispatcher.ConversationState<MessagingItem>> compositeActionListener3, CompositeActionListener<Update> compositeActionListener4) {
        super();
        this.context = context;
        this.supportModel = supportEngineModel2;
        this.stateViewObserver = compositeActionListener3;
        this.updateViewObserver = compositeActionListener4;
        Engine.TransferOptionDescription obj2 = new Engine.TransferOptionDescription("SUPPORT", context.getString(j.R));
        this.description = obj2;
    }

    public static Engine engine() {
        SupportEngineModule supportEngineModule2 = new SupportEngineModule();
        return DaggerSupportEngineComponent.builder().coreModule(Zendesk.INSTANCE.coreModule()).supportModule(iNSTANCE.supportModule).supportEngineModule(supportEngineModule2).build().supportEngine();
    }

    private void setupViewObserver(AgentDetails agentDetails) {
        SupportEngine.1 anon2 = new SupportEngine.1(this, agentDetails);
        this.stateViewObserver.addListener(anon2);
        SupportEngine.2 anon = new SupportEngine.2(this);
        this.updateViewObserver.addListener(anon);
    }

    @Override // zendesk.messaging.ObservableEngine
    public String getId() {
        return "SUPPORT";
    }

    @Override // zendesk.messaging.ObservableEngine
    public Engine.TransferOptionDescription getTransferOptionDescription() {
        return this.description;
    }

    @Override // zendesk.messaging.ObservableEngine
    public void onEvent(Event event) {
        String supportModel;
        int str;
        int i;
        Object obj4;
        supportModel.hashCode();
        i = -1;
        switch (supportModel) {
            case "response_option_clicked":
                i = 0;
                break;
            case "action_option_clicked":
                i = 1;
                break;
            case "message_submitted":
                i = 2;
                break;
            default:
        }
        switch (i) {
            case 0:
                this.supportModel.retryClicked();
                break;
            case 1:
                this.supportModel.actionItemClicked();
                break;
            case 2:
                this.supportModel.textEntered((Event.MessageSubmitted)event.getTextInput());
                break;
            default:
        }
    }

    @Override // zendesk.messaging.ObservableEngine
    public void start(MessagingApi messagingApi) {
        setupViewObserver(messagingApi.getBotAgentDetails());
        this.supportModel.start(this.context, messagingApi);
    }

    @Override // zendesk.messaging.ObservableEngine
    public void stop() {
        this.stateViewObserver.clearListeners();
        this.updateViewObserver.clearListeners();
    }
}

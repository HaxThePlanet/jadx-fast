package zendesk.support;

import android.content.Context;
import com.zendesk.service.a;
import com.zendesk.service.f;
import f.g.c.a;
import f.g.d.j;
import f.g.e.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import o.a.a;
import o.a.b;
import zendesk.core.AnonymousIdentity;
import zendesk.core.AnonymousIdentity.Builder;
import zendesk.core.AuthenticationProvider;
import zendesk.core.Zendesk;
import zendesk.messaging.AgentDetails;
import zendesk.messaging.ConversationLog;
import zendesk.messaging.MessagingApi;
import zendesk.messaging.MessagingItem;
import zendesk.messaging.MessagingItem.Action;
import zendesk.messaging.MessagingItem.ActionResponse;
import zendesk.messaging.MessagingItem.Option;
import zendesk.messaging.MessagingItem.OptionsResponse;
import zendesk.messaging.MessagingItem.Query.Status;
import zendesk.messaging.MessagingItem.TextQuery;
import zendesk.messaging.MessagingItem.TextResponse;
import zendesk.messaging.Update.Action.Navigation;
import zendesk.messaging.Update.State.UpdateInputFieldState;
import zendesk.messaging.components.bot.BotMessageDispatcher;
import zendesk.support.request.RequestConfiguration;
import zendesk.support.request.RequestConfiguration.Builder;
import zendesk.support.requestlist.RequestListActivity;
import zendesk.support.requestlist.RequestListConfiguration.Builder;

/* loaded from: classes3.dex */
class SupportEngineModel {

    private static final String LOG_TAG = "SupportEngine";
    private static final String REQUEST_LIST_ACTION_ID = "REQUEST_LIST_ACTION_ID";
    private static final String RETRY_BUTTON_ID = "zs_engine_retry_request_creation";
    private AgentDetails agentDetails;
    private final AuthenticationProvider authenticationProvider;
    private final b configHelper;
    private List<a> configurations;
    private Context context;
    private final AtomicBoolean conversationStarted;
    private final zendesk.support.EmailValidator emailValidator;
    private String message;
    private BotMessageDispatcher<MessagingItem> messageDispatcher;
    private final zendesk.support.RequestCreator requestCreator;
    private final zendesk.support.SupportSettingsProvider settingsProvider;
    private zendesk.support.SupportEngineModel.State state;
    private final Zendesk zendesk;

    private static enum State {

        AWAITING_MESSAGE,
        AWAITING_EMAIL,
        COMPLETE;
    }
    SupportEngineModel(zendesk.support.SupportSettingsProvider supportSettingsProvider, zendesk.support.RequestCreator requestCreator2, Zendesk zendesk3, AuthenticationProvider authenticationProvider4, zendesk.support.EmailValidator emailValidator5, b b6, AtomicBoolean atomicBoolean7, BotMessageDispatcher<MessagingItem> botMessageDispatcher8) {
        super();
        final String str = "";
        AgentDetails agentDetails = new AgentDetails(str, str, 0);
        this.agentDetails = agentDetails;
        this.settingsProvider = supportSettingsProvider;
        this.requestCreator = requestCreator2;
        this.zendesk = zendesk3;
        this.authenticationProvider = authenticationProvider4;
        this.emailValidator = emailValidator5;
        this.configHelper = b6;
        this.conversationStarted = atomicBoolean7;
        this.messageDispatcher = botMessageDispatcher8;
    }

    static boolean access$000(zendesk.support.SupportEngineModel supportEngineModel, zendesk.support.SupportSdkSettings supportSdkSettings2) {
        return supportEngineModel.userNeedsToAddEmailAddress(supportSdkSettings2);
    }

    static zendesk.support.SupportEngineModel.State access$102(zendesk.support.SupportEngineModel supportEngineModel, zendesk.support.SupportEngineModel.State supportEngineModel$State2) {
        supportEngineModel.state = state2;
        return state2;
    }

    static void access$200(zendesk.support.SupportEngineModel supportEngineModel) {
        supportEngineModel.promptForEmail();
    }

    static void access$300(zendesk.support.SupportEngineModel supportEngineModel, String string2) {
        supportEngineModel.createRequest(string2);
    }

    static void access$400(zendesk.support.SupportEngineModel supportEngineModel) {
        supportEngineModel.showRequestCreatedConfirmationMessage();
    }

    static void access$500(zendesk.support.SupportEngineModel supportEngineModel) {
        supportEngineModel.showRequestCreatedErrorMessage();
    }

    static void access$600(zendesk.support.SupportEngineModel supportEngineModel) {
        supportEngineModel.addConversationsEnabledConfirmation();
    }

    static void access$700(zendesk.support.SupportEngineModel supportEngineModel) {
        supportEngineModel.addConversationsDisabledConfirmation();
    }

    private void addConversationsDisabledConfirmation() {
        zendesk.core.Identity identity;
        boolean messageDispatcher;
        MessagingItem.TextResponse textResponse;
        Date date;
        String str;
        AgentDetails agentDetails;
        identity = this.authenticationProvider.getIdentity();
        if (identity instanceof AnonymousIdentity && g.c((AnonymousIdentity)identity.getEmail())) {
            if (g.c((AnonymousIdentity)identity.getEmail())) {
                date = new Date();
                textResponse = new MessagingItem.TextResponse(date, SupportEngineModel.newId(), this.agentDetails, this.context.getString(j.D));
                this.messageDispatcher.addMessageWithTypingIndicator(textResponse, new Update[0]);
            }
        }
    }

    private void addConversationsEnabledConfirmation() {
        MessagingItem.Action action = new MessagingItem.Action("REQUEST_LIST_ACTION_ID", this.context.getString(j.E));
        Date date = new Date();
        super(date, SupportEngineModel.newId(), this.agentDetails, this.context.getString(j.C), Collections.singletonList(action));
        this.messageDispatcher.addMessageWithTypingIndicator(actionResponse, new Update[0]);
    }

    private void createRequest(String string) {
        this.messageDispatcher.dispatchUpdate(Update.State.UpdateInputFieldState.updateInputFieldEnabled(false));
        SupportEngineModel.2 anon = new SupportEngineModel.2(this);
        this.requestCreator.createRequest(string, getRequestConfiguration(), anon);
    }

    private void displayUserTextInput(String string) {
        Date date = new Date();
        MessagingItem.TextQuery textQuery = new MessagingItem.TextQuery(date, SupportEngineModel.newId(), MessagingItem.Query.Status.DELIVERED, string);
        this.messageDispatcher.addMessage(textQuery);
    }

    private RequestConfiguration getRequestConfiguration() {
        a config;
        if ((RequestConfiguration)this.configHelper.e(this.configurations, RequestConfiguration.class) == null) {
            RequestConfiguration.Builder builder = new RequestConfiguration.Builder();
            config = builder.config();
        }
        return config;
    }

    private static String newId() {
        return UUID.randomUUID().toString();
    }

    private void processUserRequestMessage(String string) {
        this.message = string;
        SupportEngineModel.1 anon = new SupportEngineModel.1(this, string);
        this.settingsProvider.getSettings(anon);
    }

    private void promptForEmail() {
        Date date = new Date();
        MessagingItem.TextResponse textResponse = new MessagingItem.TextResponse(date, SupportEngineModel.newId(), this.agentDetails, this.context.getString(j.G));
        zendesk.messaging.Update[] arr = new Update[1];
        this.messageDispatcher.addMessageWithTypingIndicator(textResponse, Update.State.UpdateInputFieldState.updateHint(this.context.getString(j.F)));
    }

    private void showGreeting(boolean z) {
        int textResponse;
        zendesk.messaging.Update[] arr;
        String str;
        AgentDetails agentDetails;
        String string;
        int i;
        Object obj7;
        if (z) {
            displayUserTextInput(this.context.getString(j.R));
        } else {
            Date date = new Date();
            textResponse = new MessagingItem.TextResponse(date, SupportEngineModel.newId(), this.agentDetails, this.context.getString(j.z));
            this.messageDispatcher.addMessageWithTypingIndicator(textResponse, new Update[0]);
        }
    }

    private void showInvalidEmailMessage() {
        Date date = new Date();
        MessagingItem.TextResponse textResponse = new MessagingItem.TextResponse(date, SupportEngineModel.newId(), this.agentDetails, this.context.getString(j.H));
        this.messageDispatcher.addMessageWithTypingIndicator(textResponse, new Update[0]);
    }

    private void showRequestCreatedConfirmationMessage() {
        SupportEngineModel.3 anon = new SupportEngineModel.3(this);
        this.settingsProvider.getSettings(anon);
    }

    private void showRequestCreatedErrorMessage() {
        ArrayList arrayList = new ArrayList(2);
        Date date = new Date();
        MessagingItem.TextResponse textResponse = new MessagingItem.TextResponse(date, SupportEngineModel.newId(), this.agentDetails, this.context.getString(j.B));
        arrayList.add(textResponse);
        MessagingItem.Option option = new MessagingItem.Option(SupportEngineModel.newId(), this.context.getString(j.A));
        Date date2 = new Date();
        MessagingItem.OptionsResponse optionsResponse = new MessagingItem.OptionsResponse(date2, "zs_engine_retry_request_creation", Collections.singletonList(option));
        arrayList.add(optionsResponse);
        this.messageDispatcher.addMessagesWithTypingIndicator(arrayList, new Update[0]);
    }

    private void updateIdentityAndCreateRequest(String string, String string2) {
        Object identity;
        boolean builder;
        Object obj3;
        identity = this.authenticationProvider.getIdentity();
        if (identity instanceof AnonymousIdentity) {
            builder = new AnonymousIdentity.Builder();
            this.zendesk.setIdentity(builder.withNameIdentifier((AnonymousIdentity)identity.getName()).withEmailIdentifier(string).build());
            createRequest(string2);
        }
    }

    private boolean userNeedsToAddEmailAddress(zendesk.support.SupportSdkSettings supportSdkSettings) {
        int obj2;
        zendesk.core.Identity identity = this.authenticationProvider.getIdentity();
        if (!supportSdkSettings.isConversationsEnabled() && identity instanceof AnonymousIdentity && g.e((AnonymousIdentity)identity.getEmail())) {
            if (identity instanceof AnonymousIdentity) {
                obj2 = g.e((AnonymousIdentity)identity.getEmail()) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    void actionItemClicked() {
        Update.Action.Navigation navigation = new Update.Action.Navigation(RequestListActivity.builder().intent(this.context, this.configurations));
        this.messageDispatcher.dispatchUpdate(navigation);
    }

    void retryClicked() {
        Date date = new Date();
        MessagingItem.TextQuery textQuery = new MessagingItem.TextQuery(date, SupportEngineModel.newId(), MessagingItem.Query.Status.DELIVERED, this.context.getString(j.A));
        this.messageDispatcher.replaceMessage("zs_engine_retry_request_creation", textQuery);
        createRequest(this.message);
    }

    void start(Context context, MessagingApi messagingApi2) {
        Object obj2;
        this.context = context;
        this.configurations = messagingApi2.getConfigurations();
        this.agentDetails = messagingApi2.getBotAgentDetails();
        if (this.conversationStarted.get()) {
        }
        this.conversationStarted.set(true);
        obj2 = messagingApi2.getConversationLog().getLog();
        this.message = obj2;
        obj2 = g.c(obj2);
        showGreeting(obj2);
        if (obj2 != null) {
            processUserRequestMessage(this.message);
        } else {
            this.state = SupportEngineModel.State.AWAITING_MESSAGE;
        }
    }

    void textEntered(String string) {
        zendesk.support.SupportEngineModel.State validEmail;
        zendesk.support.SupportEngineModel.State cOMPLETE;
        validEmail = this.state;
        if (validEmail != null && validEmail != SupportEngineModel.State.COMPLETE) {
            if (validEmail != SupportEngineModel.State.COMPLETE) {
                displayUserTextInput(string);
                validEmail = SupportEngineModel.4.$SwitchMap$zendesk$support$SupportEngineModel$State[this.state.ordinal()];
                if (validEmail != 1) {
                    if (validEmail != 2) {
                    } else {
                        if (this.emailValidator.isValidEmail(string)) {
                            updateIdentityAndCreateRequest(string, this.message);
                        } else {
                            showInvalidEmailMessage();
                        }
                    }
                } else {
                    processUserRequestMessage(string);
                }
            }
        }
    }
}

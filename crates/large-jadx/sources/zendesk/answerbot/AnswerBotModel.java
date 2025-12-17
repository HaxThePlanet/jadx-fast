package zendesk.answerbot;

import android.content.Intent;
import android.content.res.Resources;
import com.zendesk.service.a;
import com.zendesk.service.f;
import f.g.c.a;
import f.g.e.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import o.a.b;
import zendesk.messaging.Event.ResponseOptionClicked;
import zendesk.messaging.MessagingItem;
import zendesk.messaging.MessagingItem.Option;
import zendesk.messaging.MessagingItem.Query;
import zendesk.messaging.Update.State.UpdateInputFieldState;
import zendesk.messaging.components.Timer;
import zendesk.messaging.components.Timer.Factory;

/* loaded from: classes3.dex */
class AnswerBotModel {

    private static final f<Void> NO_OP_CALLBACK;
    private final zendesk.answerbot.AnswerBotProvider answerBotProvider;
    private final b configurationHelper;
    private final zendesk.answerbot.AnswerBotConversationManager conversation;
    private final AtomicBoolean conversationStarted;
    private Map<String, zendesk.answerbot.FormResponseEventHandler> formHandlers;
    private zendesk.answerbot.AnswerBotModel.Responses previousResponse;
    private final Resources resources;
    private Timer screenOpenedTimer;
    private final zendesk.answerbot.AnswerBotSettingsProvider settingsProvider;
    private final Timer.Factory timerFactory;
    private final AtomicBoolean transferOptionsAvailable;
    private Timer userTypedTimer;

    private static enum Responses {

        GREETING,
        ARTICLE_HELPFUL_QUESTION,
        ARTICLE_NOT_HELPFUL,
        ARTICLE_HELPFUL,
        ARTICLE_LIST,
        NO_ARTICLES,
        FAILED_QUERY,
        NONE;
    }
    static {
        AnswerBotModel.6 anon = new AnswerBotModel.6();
        AnswerBotModel.NO_OP_CALLBACK = anon;
    }

    AnswerBotModel(zendesk.answerbot.AnswerBotProvider answerBotProvider, zendesk.answerbot.AnswerBotSettingsProvider answerBotSettingsProvider2, Timer.Factory timer$Factory3, Resources resources4, AtomicBoolean atomicBoolean5, AtomicBoolean atomicBoolean6, zendesk.answerbot.AnswerBotConversationManager answerBotConversationManager7, b b8) {
        super();
        HashMap hashMap = new HashMap();
        this.formHandlers = hashMap;
        this.previousResponse = AnswerBotModel.Responses.NONE;
        this.answerBotProvider = answerBotProvider;
        this.settingsProvider = answerBotSettingsProvider2;
        this.timerFactory = factory3;
        this.resources = resources4;
        this.conversationStarted = atomicBoolean5;
        this.transferOptionsAvailable = atomicBoolean6;
        this.conversation = answerBotConversationManager7;
        this.configurationHelper = b8;
        setupUserInputTimerPrompts();
    }

    static void access$000(zendesk.answerbot.AnswerBotModel answerBotModel) {
        answerBotModel.showGreetings();
    }

    static zendesk.answerbot.AnswerBotConversationManager access$100(zendesk.answerbot.AnswerBotModel answerBotModel) {
        return answerBotModel.conversation;
    }

    static void access$1000(zendesk.answerbot.AnswerBotModel answerBotModel, long l2, long l3, String string4) {
        answerBotModel.showWasArticleRelevantResponse(l2, l3, string4);
    }

    static void access$1100(zendesk.answerbot.AnswerBotModel answerBotModel, long l2, long l3, String string4, zendesk.answerbot.RejectionReason rejectionReason5) {
        answerBotModel.markArticleUnhelpful(l2, l3, string4, rejectionReason5);
    }

    static void access$1200(zendesk.answerbot.AnswerBotModel answerBotModel) {
        answerBotModel.showNotHelpfulResponse();
    }

    static Timer access$1300(zendesk.answerbot.AnswerBotModel answerBotModel) {
        return answerBotModel.userTypedTimer;
    }

    static AtomicBoolean access$200(zendesk.answerbot.AnswerBotModel answerBotModel) {
        return answerBotModel.transferOptionsAvailable;
    }

    static Timer access$300(zendesk.answerbot.AnswerBotModel answerBotModel) {
        return answerBotModel.screenOpenedTimer;
    }

    static void access$400(zendesk.answerbot.AnswerBotModel answerBotModel) {
        answerBotModel.showDisabledResponse();
    }

    static zendesk.answerbot.AnswerBotModel.Responses access$502(zendesk.answerbot.AnswerBotModel answerBotModel, zendesk.answerbot.AnswerBotModel.Responses answerBotModel$Responses2) {
        answerBotModel.previousResponse = responses2;
        return responses2;
    }

    static Resources access$600(zendesk.answerbot.AnswerBotModel answerBotModel) {
        return answerBotModel.resources;
    }

    static void access$700(zendesk.answerbot.AnswerBotModel answerBotModel, int i2) {
        answerBotModel.showTransferOptions(i2);
    }

    static void access$800(zendesk.answerbot.AnswerBotModel answerBotModel, long l2, long l3, String string4) {
        answerBotModel.markArticleHelpful(l2, l3, string4);
    }

    static void access$900(zendesk.answerbot.AnswerBotModel answerBotModel) {
        answerBotModel.showHelpfulResponse();
    }

    private void ensureNoResponseOptions() {
        boolean conversation;
        int i;
        if (lastInteraction instanceof AnswerBotInteraction.ResponseOption) {
            this.conversation.removeLastInteractions(2);
        }
    }

    private void handleArticleResult(zendesk.answerbot.AnswerBotArticleConfiguration answerBotArticleConfiguration) {
        int i;
        long deflectionId2;
        long articleId2;
        String interactionAccessToken;
        int i2;
        long deflectionId;
        long articleId;
        String interactionAccessToken2;
        int obj14;
        int i3 = AnswerBotModel.7.$SwitchMap$zendesk$answerbot$AnswerBotArticleResult[answerBotArticleConfiguration.getResult().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3 && i3 != 4) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                        } else {
                            showHelpfulResponse();
                        }
                    } else {
                        showNotHelpfulResponse();
                    }
                } else {
                }
            } else {
                this.showWasArticleRelevantResponse(answerBotArticleConfiguration.getDeflectionId(), obj3, answerBotArticleConfiguration.getArticleId());
            }
        } else {
            this.showWasArticleHelpfulResponse(answerBotArticleConfiguration.getDeflectionId(), obj9, answerBotArticleConfiguration.getArticleId());
        }
    }

    private void markArticleHelpful(long l, long l2, String string3) {
        this.answerBotProvider.resolveWithArticle(l, obj2, string3, obj4);
    }

    private void markArticleUnhelpful(long l, long l2, String string3, zendesk.answerbot.RejectionReason rejectionReason4) {
        this.answerBotProvider.rejectWithArticle(l, obj2, string3, obj4, obj13);
    }

    private void setupUserInputTimerPrompts() {
        AnswerBotModel.5 anon = new AnswerBotModel.5(this);
        this.screenOpenedTimer = this.timerFactory.create(anon, this.resources.getInteger(R.integer.zs_answerbot_screen_opened_inactivity_timeout));
        this.userTypedTimer = this.timerFactory.create(anon, this.resources.getInteger(R.integer.zs_answerbot_user_typed_inactivity_timeout));
    }

    private void showDisabledResponse() {
        boolean zab_cell_text_answerbot_disabled_header;
        this.conversation.addTextReply(this.resources.getString(R.string.zab_cell_text_answerbot_disabled_response));
        if (this.transferOptionsAvailable.get()) {
            showTransferOptions(R.string.zab_cell_text_answerbot_disabled_header);
        }
    }

    private void showGreetings() {
        int i;
        String str;
        zendesk.answerbot.AnswerBotConversationManager conversation;
        this.previousResponse = AnswerBotModel.Responses.GREETING;
        String[] stringArray = this.resources.getStringArray(R.array.zab_cells_greeting_text);
        i = 0;
        while (i < stringArray.length) {
            this.conversation.addTextReply(stringArray[i]);
            i++;
        }
    }

    private void showHelpfulResponse() {
        zendesk.answerbot.AnswerBotModel.Responses aRTICLE_HELPFUL = AnswerBotModel.Responses.ARTICLE_HELPFUL;
        if (this.previousResponse == aRTICLE_HELPFUL) {
        }
        ensureNoResponseOptions();
        this.previousResponse = aRTICLE_HELPFUL;
        this.conversation.addTextReply(this.resources.getString(R.string.zab_cell_text_acknowledgement_did_help));
        this.conversation.addTextReply(this.resources.getString(R.string.zab_cell_text_did_help_ask_again));
    }

    private void showNotHelpfulResponse() {
        int zab_cell_text_contact_options_header;
        String string;
        int zab_cell_text_acknowledgement_did_not_help;
        zendesk.answerbot.AnswerBotModel.Responses aRTICLE_NOT_HELPFUL = AnswerBotModel.Responses.ARTICLE_NOT_HELPFUL;
        if (this.previousResponse == aRTICLE_NOT_HELPFUL) {
        }
        ensureNoResponseOptions();
        this.previousResponse = aRTICLE_NOT_HELPFUL;
        this.conversation.addTextReply(this.resources.getString(R.string.zab_cell_text_acknowledgement_did_not_help));
        if (this.transferOptionsAvailable.get()) {
            showTransferOptions(R.string.zab_cell_text_contact_options_header);
        } else {
            this.conversation.addTextReply(this.resources.getString(R.string.zab_cell_text_prompt_another_question_no_transfer_options));
        }
    }

    private void showResponseOptions(int i, zendesk.answerbot.FormResponseEventHandler formResponseEventHandler2) {
        boolean formHandlers;
        Object obj3;
        ensureNoResponseOptions();
        this.previousResponse = AnswerBotModel.Responses.ARTICLE_HELPFUL_QUESTION;
        obj3 = this.conversation.addResponseOptions(this.resources.getString(i), Arrays.asList(this.resources.getStringArray(R.array.zab_article_helpful_response_options)));
        if (a.i(obj3)) {
            this.formHandlers.put((String)obj3.get(size--), formResponseEventHandler2);
        }
    }

    private void showTransferOptions(int i) {
        this.conversation.addTransferOptions(this.resources.getString(i));
    }

    private void showWasArticleHelpfulResponse(long l, long l2, String string3) {
        super(this, l, obj3, string3, obj5, obj13);
        this.previousResponse = AnswerBotModel.Responses.ARTICLE_HELPFUL_QUESTION;
        showResponseOptions(R.string.zab_cell_text_question_did_article_help_with_question, anon2);
    }

    private void showWasArticleRelevantResponse(long l, long l2, String string3) {
        super(this, l, obj3, string3, obj5, obj13);
        this.previousResponse = AnswerBotModel.Responses.ARTICLE_HELPFUL_QUESTION;
        showResponseOptions(R.string.zab_cell_text_help_followup_question, anon2);
    }

    zendesk.answerbot.AnswerBotInteraction getInteractionById(String string) {
        return this.conversation.getInteractionById(string);
    }

    void handleDeleteQueryEvent(MessagingItem.Query messagingItem$Query) {
        zendesk.answerbot.AnswerBotConversationManager conversation;
        Object obj2;
        obj2 = getInteractionById(query.getId());
        if (obj2 != null) {
            this.conversation.removeInteraction(obj2.getId());
        }
    }

    void handleRetryQueryEvent(MessagingItem.Query messagingItem$Query) {
        zendesk.answerbot.AnswerBotConversationManager conversation;
        String str;
        Object obj3;
        obj3 = getInteractionById(query.getId());
        if (obj3 != null) {
            this.conversation.removeInteraction(obj3.getId());
            sendQuery((AnswerBotInteraction.TextQuery)obj3.getText());
        }
    }

    void onArticleResult(int i, int i2, Intent intent3) {
        int i3;
        String str;
        int obj3;
        int obj4;
        Class<zendesk.answerbot.AnswerBotArticleConfiguration> obj5;
        if (i == 999) {
            i3 = 0;
            str = "AnswerBotModel";
            if (i2 == -1) {
                obj3 = this.configurationHelper.f(intent3.getExtras(), AnswerBotArticleConfiguration.class);
                if ((AnswerBotArticleConfiguration)obj3 == null) {
                    a.k(str, "No configuration found, ignoring #onActivityResult(...)", new Object[i3]);
                } else {
                    handleArticleResult((AnswerBotArticleConfiguration)obj3);
                }
            } else {
                a.b(str, "result code != RESULT_OK", new Object[i3]);
            }
        }
    }

    void onResponseOptionSelection(Event.ResponseOptionClicked event$ResponseOptionClicked) {
        Object remove = this.formHandlers.remove(responseOptionClicked.getOptionsResponse().getId());
        if ((FormResponseEventHandler)remove != null) {
            (FormResponseEventHandler)remove.handle(responseOptionClicked);
        }
    }

    void onTypingStarted() {
        Timer screenOpenedTimer;
        screenOpenedTimer = this.screenOpenedTimer;
        if (screenOpenedTimer != null) {
            screenOpenedTimer.disable();
            this.userTypedTimer.start();
        }
    }

    void sendQuery(String string) {
        this.userTypedTimer.disable();
        this.screenOpenedTimer.disable();
        AnswerBotModel.2 anon = new AnswerBotModel.2(this, this.conversation.addPendingMessage(string), string);
        this.answerBotProvider.getDeflectionForQuery(string, anon);
    }

    void startConversation(boolean z) {
        if (this.conversationStarted.get()) {
            this.conversation.reloadConversation();
        }
        this.transferOptionsAvailable.set(z);
        this.conversation.dispatchUpdate(Update.State.UpdateInputFieldState.updateInputFieldEnabled(false));
        AnswerBotModel.1 anon = new AnswerBotModel.1(this);
        this.settingsProvider.getSettings(anon);
        this.conversationStarted.set(true);
    }
}

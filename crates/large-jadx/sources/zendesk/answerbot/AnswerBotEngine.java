package zendesk.answerbot;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import f.g.c.a;
import f.g.e.a;
import java.util.Iterator;
import java.util.List;
import o.a.b;
import zendesk.core.Zendesk;
import zendesk.messaging.AgentDetails;
import zendesk.messaging.Engine.TransferOptionDescription;
import zendesk.messaging.Event;
import zendesk.messaging.Event.ActivityResult;
import zendesk.messaging.Event.ArticleSuggestionClicked;
import zendesk.messaging.Event.MessageDeleted;
import zendesk.messaging.Event.MessageResent;
import zendesk.messaging.Event.MessageSubmitted;
import zendesk.messaging.MessagingApi;
import zendesk.messaging.MessagingItem.ArticlesResponse.ArticleSuggestion;
import zendesk.messaging.ObservableEngine;
import zendesk.messaging.Update;
import zendesk.messaging.Update.Action.Navigation;
import zendesk.messaging.Update.State.ApplyMessagingItems;
import zendesk.messaging.Update.State.HideTyping;
import zendesk.messaging.Update.State.ShowTyping;
import zendesk.messaging.Update.State.UpdateInputFieldState;
import zendesk.messaging.components.ActionListener;
import zendesk.messaging.components.CompositeActionListener;
import zendesk.messaging.components.bot.BotMessageDispatcher.ConversationState;

/* loaded from: classes3.dex */
public class AnswerBotEngine extends ObservableEngine {

    private final zendesk.answerbot.AnswerBotCellFactory answerBotCellFactory;
    private final zendesk.answerbot.AnswerBotModel answerBotModel;
    private final b configurationHelper;
    private final Context context;
    private final CompositeActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>> stateActionListener;
    private final CompositeActionListener<Update> updateActionListener;
    AnswerBotEngine(Context context, zendesk.answerbot.AnswerBotModel answerBotModel2, zendesk.answerbot.AnswerBotCellFactory answerBotCellFactory3, CompositeActionListener<Update> compositeActionListener4, CompositeActionListener<BotMessageDispatcher.ConversationState<zendesk.answerbot.AnswerBotInteraction>> compositeActionListener5, b b6) {
        super();
        this.context = context;
        this.answerBotModel = answerBotModel2;
        this.answerBotCellFactory = answerBotCellFactory3;
        this.updateActionListener = compositeActionListener4;
        this.stateActionListener = compositeActionListener5;
        this.configurationHelper = b6;
    }

    static zendesk.answerbot.AnswerBotCellFactory access$000(zendesk.answerbot.AnswerBotEngine answerBotEngine) {
        return answerBotEngine.answerBotCellFactory;
    }

    public static zendesk.answerbot.AnswerBotEngine engine() {
        return AnswerBotComponentProvider.INSTANCE.provideAnswerBot(Zendesk.INSTANCE, AnswerBot.INSTANCE);
    }

    private void handleArticleSuggestionEvent(Event.ArticleSuggestionClicked event$ArticleSuggestionClicked) {
        Object interactionById;
        int i2;
        boolean i;
        Class<zendesk.answerbot.AnswerBotArticleActivity> obj;
        Object next;
        int cmp;
        long articleId;
        Object obj9;
        obj9 = articleSuggestionClicked.getArticleSuggestion();
        interactionById = this.answerBotModel.getInteractionById(obj9.getArticleInteractionId());
        if (interactionById instanceof AnswerBotInteraction.ArticlesReply) {
            zendesk.answerbot.DeflectionResponse deflectionResponse = (AnswerBotInteraction.ArticlesReply)interactionById.getDeflectionResponse();
            i2 = 0;
            Iterator iterator = deflectionResponse.getDeflectionArticles().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (Long.compare(articleId2, articleId) == 0) {
                    break;
                } else {
                }
            }
            if (i2 == 0) {
                a.b("AnswerBotEngine", "Selected Article Suggestion not found, can not open.", new Object[0]);
            }
            Bundle bundle = new Bundle();
            this.configurationHelper.b(bundle, AnswerBotArticleActivity.builder(deflectionResponse, i2).config());
            obj9 = new Intent(this.context, AnswerBotArticleActivity.class);
            obj9.putExtras(bundle);
            interactionById = new Update.Action.Navigation(obj9, 999);
            notifyObservers(interactionById);
        }
    }

    @Override // zendesk.messaging.ObservableEngine
    public String getId() {
        return "ANSWER_BOT";
    }

    @Override // zendesk.messaging.ObservableEngine
    public Engine.TransferOptionDescription getTransferOptionDescription() {
        return null;
    }

    @Override // zendesk.messaging.ObservableEngine
    public void onEvent(Event event) {
        boolean answerBotModel;
        String requestCode;
        int resultCode;
        Object obj4;
        answerBotModel.hashCode();
        resultCode = -1;
        switch (answerBotModel) {
            case "article_suggestion_clicked":
                resultCode = 0;
                break;
            case "response_option_clicked":
                resultCode = 1;
                break;
            case "message_deleted":
                resultCode = 2;
                break;
            case "message_submitted":
                resultCode = 3;
                break;
            case "message_resent":
                resultCode = 4;
                break;
            case "typing_started":
                resultCode = 5;
                break;
            case "activity_result_received":
                resultCode = 6;
                break;
            default:
        }
        switch (resultCode) {
            case 0:
                handleArticleSuggestionEvent((Event.ArticleSuggestionClicked)event);
                break;
            case 1:
                this.answerBotModel.onResponseOptionSelection((Event.ResponseOptionClicked)event);
                break;
            case 2:
                this.answerBotModel.handleDeleteQueryEvent((Event.MessageDeleted)event.getMessage());
                break;
            case 3:
                this.answerBotModel.sendQuery((Event.MessageSubmitted)event.getTextInput());
                break;
            case 4:
                this.answerBotModel.handleRetryQueryEvent((Event.MessageResent)event.getQuery());
                break;
            case 5:
                this.answerBotModel.onTypingStarted();
                break;
            case 6:
                this.answerBotModel.onArticleResult((Event.ActivityResult)event.getRequestCode(), event.getResultCode(), event.getData());
                break;
            default:
        }
    }

    @Override // zendesk.messaging.ObservableEngine
    public void start(MessagingApi messagingApi) {
        AnswerBotEngine.1 anon2 = new AnswerBotEngine.1(this, messagingApi.getBotAgentDetails(), messagingApi);
        this.stateActionListener.addListener(anon2);
        AnswerBotEngine.2 anon = new AnswerBotEngine.2(this);
        this.updateActionListener.addListener(anon);
        notifyObservers(Update.State.UpdateInputFieldState.updateHint(this.context.getString(R.string.zab_hint_type_your_question)));
        this.answerBotModel.startConversation(a.i(messagingApi.getTransferOptionDescriptions()));
    }

    @Override // zendesk.messaging.ObservableEngine
    public void stop() {
        this.updateActionListener.clearListeners();
        this.stateActionListener.clearListeners();
    }
}

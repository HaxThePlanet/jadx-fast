package zendesk.answerbot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import zendesk.messaging.MessagingItem.Query.Status;
import zendesk.messaging.Update;
import zendesk.messaging.components.DateProvider;
import zendesk.messaging.components.bot.BotMessageDispatcher;

/* loaded from: classes3.dex */
final class AnswerBotConversationManager {

    private final BotMessageDispatcher<zendesk.answerbot.AnswerBotInteraction> botMessageDispatcher;
    private final DateProvider dateProvider;
    public AnswerBotConversationManager(BotMessageDispatcher<zendesk.answerbot.AnswerBotInteraction> botMessageDispatcher, DateProvider dateProvider2) {
        super();
        this.botMessageDispatcher = botMessageDispatcher;
        this.dateProvider = dateProvider2;
    }

    private static String newId() {
        return UUID.randomUUID().toString();
    }

    String addArticles(zendesk.answerbot.DeflectionResponse deflectionResponse) {
        final String id = AnswerBotConversationManager.newId();
        AnswerBotInteraction.ArticlesReply articlesReply = new AnswerBotInteraction.ArticlesReply(id, this.dateProvider.now(), deflectionResponse);
        this.botMessageDispatcher.addMessageWithTypingIndicator(articlesReply, new Update[0]);
        return id;
    }

    String addPendingMessage(String string) {
        final String id = AnswerBotConversationManager.newId();
        AnswerBotInteraction.TextQuery textQuery = new AnswerBotInteraction.TextQuery(id, this.dateProvider.now(), string, MessagingItem.Query.Status.PENDING);
        this.botMessageDispatcher.addMessage(textQuery);
        return id;
    }

    List<String> addResponseOptions(String string, List<String> list2) {
        int i = 2;
        ArrayList arrayList = new ArrayList(i);
        ArrayList arrayList2 = new ArrayList(i);
        String id = AnswerBotConversationManager.newId();
        final String id2 = AnswerBotConversationManager.newId();
        arrayList2.add(id);
        arrayList2.add(id2);
        AnswerBotInteraction.TextReply textReply = new AnswerBotInteraction.TextReply(id, this.dateProvider.now(), string);
        arrayList.add(textReply);
        AnswerBotInteraction.ResponseOption obj7 = new AnswerBotInteraction.ResponseOption(id2, list2, this.dateProvider.now());
        arrayList.add(obj7);
        this.botMessageDispatcher.addMessagesWithTypingIndicator(arrayList, new Update[0]);
        return arrayList2;
    }

    String addTextReply(String string) {
        final String id = AnswerBotConversationManager.newId();
        AnswerBotInteraction.TextReply textReply = new AnswerBotInteraction.TextReply(id, this.dateProvider.now(), string);
        this.botMessageDispatcher.addMessageWithTypingIndicator(textReply, new Update[0]);
        return id;
    }

    String addTransferOptions(String string) {
        final String id = AnswerBotConversationManager.newId();
        AnswerBotInteraction.TransferOptions transferOptions = new AnswerBotInteraction.TransferOptions(id, this.dateProvider.now(), string);
        this.botMessageDispatcher.addMessageWithTypingIndicator(transferOptions, new Update[0]);
        return id;
    }

    void dispatchUpdate(Update update) {
        this.botMessageDispatcher.dispatchUpdate(update);
    }

    zendesk.answerbot.AnswerBotInteraction getInteractionById(String string) {
        return (AnswerBotInteraction)this.botMessageDispatcher.getMessageById(string);
    }

    zendesk.answerbot.AnswerBotInteraction getLastInteraction() {
        return (AnswerBotInteraction)this.botMessageDispatcher.getLastMessage();
    }

    void reloadConversation() {
        this.botMessageDispatcher.dispatchState();
    }

    void removeInteraction(String string) {
        this.botMessageDispatcher.removeMessage(string);
    }

    void removeLastInteractions(int i) {
        this.botMessageDispatcher.removeLastMessages(i);
    }

    String replaceWithDeliveredTextQuery(String string, String string2) {
        AnswerBotInteraction.TextQuery textQuery = new AnswerBotInteraction.TextQuery(string, this.dateProvider.now(), string2, MessagingItem.Query.Status.DELIVERED);
        this.botMessageDispatcher.replaceMessage(string, textQuery);
        return string;
    }

    String replaceWithFailedQuery(String string, String string2) {
        AnswerBotInteraction.TextQuery textQuery = new AnswerBotInteraction.TextQuery(string, this.dateProvider.now(), string2, MessagingItem.Query.Status.FAILED);
        this.botMessageDispatcher.replaceMessage(string, textQuery);
        return string;
    }
}

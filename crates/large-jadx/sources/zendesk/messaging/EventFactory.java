package zendesk.messaging;

import android.content.Intent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import zendesk.messaging.components.DateProvider;

/* loaded from: classes3.dex */
public class EventFactory {

    private final DateProvider dateProvider;
    public EventFactory(DateProvider dateProvider) {
        super();
        this.dateProvider = dateProvider;
    }

    public zendesk.messaging.Event actionOptionClick(zendesk.messaging.MessagingItem.Action messagingItem$Action) {
        Event.ActionOptionClicked actionOptionClicked = new Event.ActionOptionClicked(action, this.dateProvider.now());
        return actionOptionClicked;
    }

    public zendesk.messaging.Event articleSuggestionClick(zendesk.messaging.MessagingItem.ArticlesResponse.ArticleSuggestion messagingItem$ArticlesResponse$ArticleSuggestion) {
        Event.ArticleSuggestionClicked articleSuggestionClicked = new Event.ArticleSuggestionClicked(articleSuggestion, this.dateProvider.now());
        return articleSuggestionClicked;
    }

    public zendesk.messaging.Event copyQueryClick(zendesk.messaging.MessagingItem.Query messagingItem$Query) {
        Event.CopyQueryClick copyQueryClick = new Event.CopyQueryClick(query, this.dateProvider.now());
        return copyQueryClick;
    }

    public zendesk.messaging.Event deleteQueryClick(zendesk.messaging.MessagingItem.Query messagingItem$Query) {
        Event.MessageDeleted messageDeleted = new Event.MessageDeleted(query, this.dateProvider.now());
        return messageDeleted;
    }

    public zendesk.messaging.Event formOptionClick(zendesk.messaging.MessagingItem.OptionsResponse messagingItem$OptionsResponse, zendesk.messaging.MessagingItem.Option messagingItem$Option2) {
        Event.ResponseOptionClicked responseOptionClicked = new Event.ResponseOptionClicked(optionsResponse, option2, this.dateProvider.now());
        return responseOptionClicked;
    }

    zendesk.messaging.Event menuItemClicked(int i) {
        Event.MenuItemClicked menuItemClicked = new Event.MenuItemClicked(this.dateProvider.now(), i);
        return menuItemClicked;
    }

    zendesk.messaging.Event onActivityResult(int i, int i2, Intent intent3) {
        Event.ActivityResult activityResult = new Event.ActivityResult(i, i2, intent3, this.dateProvider.now());
        return activityResult;
    }

    public zendesk.messaging.Event reconnectButtonClick() {
        Event.ReconnectButtonClicked reconnectButtonClicked = new Event.ReconnectButtonClicked(this.dateProvider.now());
        return reconnectButtonClicked;
    }

    public zendesk.messaging.Event retryQueryClick(zendesk.messaging.MessagingItem.Query messagingItem$Query) {
        Event.MessageResent messageResent = new Event.MessageResent(query, this.dateProvider.now());
        return messageResent;
    }

    public zendesk.messaging.Event retrySendAttachmentClick(zendesk.messaging.MessagingItem.FileQuery messagingItem$FileQuery) {
        Event.RetrySendAttachmentClick retrySendAttachmentClick = new Event.RetrySendAttachmentClick(fileQuery, this.dateProvider.now());
        return retrySendAttachmentClick;
    }

    public zendesk.messaging.Event sendAttachment(List<File> list) {
        ArrayList arrayList = new ArrayList(list);
        Event.FileSelected fileSelected = new Event.FileSelected(arrayList, this.dateProvider.now());
        return fileSelected;
    }

    public zendesk.messaging.Event textInput(String string) {
        Event.MessageSubmitted messageSubmitted = new Event.MessageSubmitted(string, this.dateProvider.now());
        return messageSubmitted;
    }

    public zendesk.messaging.Event transferOptionClick(zendesk.messaging.Engine.TransferOptionDescription engine$TransferOptionDescription) {
        Event.EngineSelection engineSelection = new Event.EngineSelection(transferOptionDescription, this.dateProvider.now());
        return engineSelection;
    }

    public zendesk.messaging.Event typingStart() {
        Event.TypingStarted typingStarted = new Event.TypingStarted(this.dateProvider.now());
        return typingStarted;
    }

    public zendesk.messaging.Event typingStop() {
        Event.TypingStopped typingStopped = new Event.TypingStopped(this.dateProvider.now());
        return typingStopped;
    }
}

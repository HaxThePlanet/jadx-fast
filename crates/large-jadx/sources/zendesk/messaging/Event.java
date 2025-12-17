package zendesk.messaging;

import android.content.Intent;
import java.io.File;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class Event implements zendesk.messaging.MessagingEvent {

    private final Date timestamp;
    private final String type;

    public static class ActionOptionClicked extends zendesk.messaging.Event {
        public ActionOptionClicked(zendesk.messaging.MessagingItem.Action messagingItem$Action, Date date2) {
            super("action_option_clicked", date2);
        }
    }

    public static class ActivityResult extends zendesk.messaging.Event {

        private final Intent data;
        private final int requestCode;
        private final int resultCode;
        public ActivityResult(int i, int i2, Intent intent3, Date date4) {
            super("activity_result_received", date4);
            this.requestCode = i;
            this.resultCode = i2;
            this.data = intent3;
        }

        @Override // zendesk.messaging.Event
        public Intent getData() {
            return this.data;
        }

        @Override // zendesk.messaging.Event
        public int getRequestCode() {
            return this.requestCode;
        }

        @Override // zendesk.messaging.Event
        public int getResultCode() {
            return this.resultCode;
        }
    }

    public static class ArticleSuggestionClicked extends zendesk.messaging.Event {

        private final zendesk.messaging.MessagingItem.ArticlesResponse.ArticleSuggestion articleSuggestion;
        public ArticleSuggestionClicked(zendesk.messaging.MessagingItem.ArticlesResponse.ArticleSuggestion messagingItem$ArticlesResponse$ArticleSuggestion, Date date2) {
            super("article_suggestion_clicked", date2);
            this.articleSuggestion = articleSuggestion;
        }

        @Override // zendesk.messaging.Event
        public zendesk.messaging.MessagingItem.ArticlesResponse.ArticleSuggestion getArticleSuggestion() {
            return this.articleSuggestion;
        }
    }

    public static class CopyQueryClick extends zendesk.messaging.Event {
        public CopyQueryClick(zendesk.messaging.MessagingItem.Query messagingItem$Query, Date date2) {
            super("message_copied", date2);
        }
    }

    public static class DialogItemClicked extends zendesk.messaging.Event {
        private DialogItemClicked(Date date, zendesk.messaging.DialogContent.Config dialogContent$Config2, boolean z3, String string4, zendesk.messaging.DialogContent.Config dialogContent$Config5) {
            super("dialog_item_clicked", date);
        }

        DialogItemClicked(Date date, zendesk.messaging.DialogContent.Config dialogContent$Config2, boolean z3, String string4, zendesk.messaging.DialogContent.Config dialogContent$Config5, zendesk.messaging.Event.1 event$16) {
            super(date, config2, z3, string4, config5);
        }
    }

    public static class EngineSelection extends zendesk.messaging.Event {

        private final zendesk.messaging.Engine.TransferOptionDescription selectedEngine;
        public EngineSelection(zendesk.messaging.Engine.TransferOptionDescription engine$TransferOptionDescription, Date date2) {
            super("transfer_option_clicked", date2);
            this.selectedEngine = transferOptionDescription;
        }

        @Override // zendesk.messaging.Event
        public zendesk.messaging.Engine.TransferOptionDescription getSelectedEngine() {
            return this.selectedEngine;
        }
    }

    public static class FileSelected extends zendesk.messaging.Event {

        private final List<File> attachments;
        public FileSelected(List<File> list, Date date2) {
            super("file_selected", date2);
            this.attachments = list;
        }
    }

    public static class MenuItemClicked extends zendesk.messaging.Event {
        public MenuItemClicked(Date date, int i2) {
            super("menu_item_clicked", date);
        }
    }

    public static class MessageDeleted extends zendesk.messaging.Event {

        private final zendesk.messaging.MessagingItem.Query message;
        public MessageDeleted(zendesk.messaging.MessagingItem.Query messagingItem$Query, Date date2) {
            super("message_deleted", date2);
            this.message = query;
        }

        @Override // zendesk.messaging.Event
        public zendesk.messaging.MessagingItem.Query getMessage() {
            return this.message;
        }
    }

    public static class MessageResent extends zendesk.messaging.Event {

        private final zendesk.messaging.MessagingItem.Query query;
        public MessageResent(zendesk.messaging.MessagingItem.Query messagingItem$Query, Date date2) {
            super("message_resent", date2);
            this.query = query;
        }

        @Override // zendesk.messaging.Event
        public zendesk.messaging.MessagingItem.Query getQuery() {
            return this.query;
        }
    }

    public static class MessageSubmitted extends zendesk.messaging.Event {

        private final String textInput;
        public MessageSubmitted(String string, Date date2) {
            super("message_submitted", date2);
            this.textInput = string;
        }

        @Override // zendesk.messaging.Event
        public String getTextInput() {
            return this.textInput;
        }
    }

    public static class ReconnectButtonClicked extends zendesk.messaging.Event {
        public ReconnectButtonClicked(Date date) {
            super("reconnect_button_clicked", date);
        }
    }

    public static class ResponseOptionClicked extends zendesk.messaging.Event {

        private final zendesk.messaging.MessagingItem.Option clickedOption;
        private final zendesk.messaging.MessagingItem.OptionsResponse optionsResponse;
        public ResponseOptionClicked(zendesk.messaging.MessagingItem.OptionsResponse messagingItem$OptionsResponse, zendesk.messaging.MessagingItem.Option messagingItem$Option2, Date date3) {
            super("response_option_clicked", date3);
            this.optionsResponse = optionsResponse;
            this.clickedOption = option2;
        }

        @Override // zendesk.messaging.Event
        public zendesk.messaging.MessagingItem.Option getClickedOption() {
            return this.clickedOption;
        }

        @Override // zendesk.messaging.Event
        public zendesk.messaging.MessagingItem.OptionsResponse getOptionsResponse() {
            return this.optionsResponse;
        }
    }

    public static class RetrySendAttachmentClick extends zendesk.messaging.Event {
        public RetrySendAttachmentClick(zendesk.messaging.MessagingItem.FileQuery messagingItem$FileQuery, Date date2) {
            super("retry_send_attachment_clicked", date2);
        }
    }

    public static class TypingStarted extends zendesk.messaging.Event {
        public TypingStarted(Date date) {
            super("typing_started", date);
        }
    }

    public static class TypingStopped extends zendesk.messaging.Event {
        public TypingStopped(Date date) {
            super("typing_stopped", date);
        }
    }
    public Event(String string, Date date2) {
        super();
        this.type = string;
        this.timestamp = date2;
    }

    @Override // zendesk.messaging.MessagingEvent
    public Date getTimestamp() {
        return this.timestamp;
    }

    @Override // zendesk.messaging.MessagingEvent
    public String getType() {
        return this.type;
    }
}

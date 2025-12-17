package zendesk.messaging;

import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class MessagingItem implements zendesk.messaging.MessagingEvent {

    private final String id;
    private final Date timestamp;

    public static class Action {

        private final String displayName;
        public Action(String string, String string2) {
            super();
            this.displayName = string2;
        }

        public String getDisplayName() {
            return this.displayName;
        }
    }

    public static class Option {

        private final String id;
        private final String text;
        public Option(String string, String string2) {
            super();
            this.id = string;
            this.text = string2;
        }

        public boolean equals(Object object) {
            Class<zendesk.messaging.MessagingItem.Option> obj;
            Class class;
            if (this == object) {
                return 1;
            }
            int i = 0;
            if (object != null) {
                if (MessagingItem.Option.class != object.getClass()) {
                } else {
                    if (!this.id.equals(object.id)) {
                        return i;
                    }
                }
                return this.text.equals(object.text);
            }
            return i;
        }

        public String getId() {
            return this.id;
        }

        public String getText() {
            return this.text;
        }

        public int hashCode() {
            return i2 += i4;
        }
    }

    public static class OptionsResponse extends zendesk.messaging.MessagingItem {

        private final List<zendesk.messaging.MessagingItem.Option> options;
        public OptionsResponse(Date date, String string2, List<zendesk.messaging.MessagingItem.Option> list3) {
            super(date, string2);
            this.options = list3;
        }

        public List<zendesk.messaging.MessagingItem.Option> getOptions() {
            return this.options;
        }
    }

    public static abstract class Query extends zendesk.messaging.MessagingItem {

        private final zendesk.messaging.MessagingItem.Query.Status status;
        Query(Date date, String string2, zendesk.messaging.MessagingItem.Query.Status messagingItem$Query$Status3) {
            super(date, string2);
            this.status = status3;
        }

        @Override // zendesk.messaging.MessagingItem
        public zendesk.messaging.MessagingItem.Query.Status getStatus() {
            return this.status;
        }
    }

    public static abstract class Response extends zendesk.messaging.MessagingItem {

        private final zendesk.messaging.AgentDetails agentDetails;
        public Response(Date date, String string2, zendesk.messaging.AgentDetails agentDetails3) {
            super(date, string2);
            this.agentDetails = agentDetails3;
        }

        @Override // zendesk.messaging.MessagingItem
        public zendesk.messaging.AgentDetails getAgentDetails() {
            return this.agentDetails;
        }
    }

    public static class SystemMessage extends zendesk.messaging.MessagingItem {

        private final String systemMessage;
        @Override // zendesk.messaging.MessagingItem
        public String getSystemMessage() {
            return this.systemMessage;
        }
    }

    public static class ActionResponse extends zendesk.messaging.MessagingItem.Response {

        private List<zendesk.messaging.MessagingItem.Action> actions;
        private final String message;
        public ActionResponse(Date date, String string2, zendesk.messaging.AgentDetails agentDetails3, String string4, List<zendesk.messaging.MessagingItem.Action> list5) {
            super(date, string2, agentDetails3);
            this.message = string4;
            this.actions = list5;
        }

        public List<zendesk.messaging.MessagingItem.Action> getActions() {
            return this.actions;
        }

        @Override // zendesk.messaging.MessagingItem$Response
        public String getMessage() {
            return this.message;
        }
    }

    public static class ArticlesResponse extends zendesk.messaging.MessagingItem.Response {

        private final List<zendesk.messaging.MessagingItem.ArticlesResponse.ArticleSuggestion> articleSuggestions;
        public ArticlesResponse(Date date, String string2, zendesk.messaging.AgentDetails agentDetails3, List<zendesk.messaging.MessagingItem.ArticlesResponse.ArticleSuggestion> list4) {
            super(date, string2, agentDetails3);
            this.articleSuggestions = list4;
        }

        public List<zendesk.messaging.MessagingItem.ArticlesResponse.ArticleSuggestion> getArticleSuggestions() {
            return this.articleSuggestions;
        }
    }

    public static class FileQuery extends zendesk.messaging.MessagingItem.Query {

        private final zendesk.messaging.Attachment attachment;
        private final zendesk.messaging.MessagingItem.FileQuery.FailureReason failureReason;
        @Override // zendesk.messaging.MessagingItem$Query
        public zendesk.messaging.Attachment getAttachment() {
            return this.attachment;
        }

        @Override // zendesk.messaging.MessagingItem$Query
        public zendesk.messaging.MessagingItem.FileQuery.FailureReason getFailureReason() {
            return this.failureReason;
        }

        @Deprecated
        public String getRemotePath() {
            return this.attachment.getUrl();
        }
    }

    public static class FileResponse extends zendesk.messaging.MessagingItem.Response {

        private final zendesk.messaging.Attachment attachment;
        @Override // zendesk.messaging.MessagingItem$Response
        public zendesk.messaging.Attachment getAttachment() {
            return this.attachment;
        }

        @Deprecated
        public String getRemotePath() {
            return this.attachment.getUrl();
        }
    }

    public static class TextQuery extends zendesk.messaging.MessagingItem.Query {

        private final String message;
        public TextQuery(Date date, String string2, zendesk.messaging.MessagingItem.Query.Status messagingItem$Query$Status3, String string4) {
            super(date, string2, status3);
            this.message = string4;
        }

        @Override // zendesk.messaging.MessagingItem$Query
        public String getMessage() {
            return this.message;
        }
    }

    public static class TextResponse extends zendesk.messaging.MessagingItem.Response {

        private final String message;
        public TextResponse(Date date, String string2, zendesk.messaging.AgentDetails agentDetails3, String string4) {
            super(date, string2, agentDetails3);
            this.message = string4;
        }

        @Override // zendesk.messaging.MessagingItem$Response
        public String getMessage() {
            return this.message;
        }
    }

    public static class TransferResponse extends zendesk.messaging.MessagingItem.Response {

        private final boolean enabled;
        private final List<zendesk.messaging.Engine.TransferOptionDescription> engineOptions;
        private final String message;
        public TransferResponse(Date date, String string2, zendesk.messaging.AgentDetails agentDetails3, String string4, List<zendesk.messaging.Engine.TransferOptionDescription> list5) {
            super(date, string2, agentDetails3, string4, list5, 1);
        }

        public TransferResponse(Date date, String string2, zendesk.messaging.AgentDetails agentDetails3, String string4, List<zendesk.messaging.Engine.TransferOptionDescription> list5, boolean z6) {
            super(date, string2, agentDetails3);
            this.message = string4;
            this.engineOptions = list5;
            this.enabled = z6;
        }

        public List<zendesk.messaging.Engine.TransferOptionDescription> getEngineOptions() {
            return this.engineOptions;
        }

        @Override // zendesk.messaging.MessagingItem$Response
        public String getMessage() {
            return this.message;
        }

        @Override // zendesk.messaging.MessagingItem$Response
        public boolean isEnabled() {
            return this.enabled;
        }
    }

    public static class ImageQuery extends zendesk.messaging.MessagingItem.FileQuery {
    }

    public static class ImageResponse extends zendesk.messaging.MessagingItem.FileResponse {
    }
    MessagingItem(Date date, String string2) {
        super();
        this.timestamp = date;
        this.id = string2;
    }

    @Override // zendesk.messaging.MessagingEvent
    public String getId() {
        return this.id;
    }

    @Override // zendesk.messaging.MessagingEvent
    public Date getTimestamp() {
        return this.timestamp;
    }
}

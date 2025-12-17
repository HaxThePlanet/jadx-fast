package zendesk.answerbot;

import java.util.Date;
import java.util.List;
import zendesk.messaging.MessagingItem.Query.Status;

/* loaded from: classes3.dex */
interface AnswerBotInteraction {

    public interface Handler {
        public abstract void handle(zendesk.answerbot.AnswerBotInteraction.ArticlesReply answerBotInteraction$ArticlesReply);

        public abstract void handle(zendesk.answerbot.AnswerBotInteraction.ResponseOption answerBotInteraction$ResponseOption);

        public abstract void handle(zendesk.answerbot.AnswerBotInteraction.TextQuery answerBotInteraction$TextQuery);

        public abstract void handle(zendesk.answerbot.AnswerBotInteraction.TextReply answerBotInteraction$TextReply);

        public abstract void handle(zendesk.answerbot.AnswerBotInteraction.TransferOptions answerBotInteraction$TransferOptions);
    }

    public static class ArticlesReply implements zendesk.answerbot.AnswerBotInteraction {

        private final Date date;
        private final zendesk.answerbot.DeflectionResponse deflectionResponse;
        private final String id;
        ArticlesReply(String string, Date date2, zendesk.answerbot.DeflectionResponse deflectionResponse3) {
            super();
            this.id = string;
            this.date = date2;
            this.deflectionResponse = deflectionResponse3;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public Date getDate() {
            return this.date;
        }

        List<zendesk.answerbot.DeflectionArticle> getDeflectionArticles() {
            return this.deflectionResponse.getDeflectionArticles();
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public zendesk.answerbot.DeflectionResponse getDeflectionResponse() {
            return this.deflectionResponse;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public String getId() {
            return this.id;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public void handle(zendesk.answerbot.AnswerBotInteraction.Handler answerBotInteraction$Handler) {
            handler.handle(this);
        }
    }

    public static class ResponseOption implements zendesk.answerbot.AnswerBotInteraction {

        private final Date date;
        private final String id;
        private final List<String> options;
        ResponseOption(String string, List<String> list2, Date date3) {
            super();
            this.id = string;
            this.options = list2;
            this.date = date3;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public Date getDate() {
            return this.date;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public String getId() {
            return this.id;
        }

        public List<String> getOptions() {
            return this.options;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public void handle(zendesk.answerbot.AnswerBotInteraction.Handler answerBotInteraction$Handler) {
            handler.handle(this);
        }
    }

    public static class TextQuery implements zendesk.answerbot.AnswerBotInteraction {

        private final Date date;
        private final String id;
        private final MessagingItem.Query.Status queryStatus;
        private final String text;
        TextQuery(String string, Date date2, String string3, MessagingItem.Query.Status messagingItem$Query$Status4) {
            super();
            this.id = string;
            this.date = date2;
            this.text = string3;
            this.queryStatus = status4;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public Date getDate() {
            return this.date;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public String getId() {
            return this.id;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public MessagingItem.Query.Status getQueryStatus() {
            return this.queryStatus;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public String getText() {
            return this.text;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public void handle(zendesk.answerbot.AnswerBotInteraction.Handler answerBotInteraction$Handler) {
            handler.handle(this);
        }
    }

    public static class TextReply implements zendesk.answerbot.AnswerBotInteraction {

        private final Date date;
        private final String id;
        private final String text;
        public TextReply(String string, Date date2, String string3) {
            super();
            this.id = string;
            this.date = date2;
            this.text = string3;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public Date getDate() {
            return this.date;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public String getId() {
            return this.id;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public String getText() {
            return this.text;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public void handle(zendesk.answerbot.AnswerBotInteraction.Handler answerBotInteraction$Handler) {
            handler.handle(this);
        }
    }

    public static class TransferOptions implements zendesk.answerbot.AnswerBotInteraction {

        private final Date date;
        private final String header;
        private final String id;
        TransferOptions(String string, Date date2, String string3) {
            super();
            this.id = string;
            this.date = date2;
            this.header = string3;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public Date getDate() {
            return this.date;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public String getHeader() {
            return this.header;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public String getId() {
            return this.id;
        }

        @Override // zendesk.answerbot.AnswerBotInteraction
        public void handle(zendesk.answerbot.AnswerBotInteraction.Handler answerBotInteraction$Handler) {
            handler.handle(this);
        }
    }
    public abstract String getId();

    public abstract void handle(zendesk.answerbot.AnswerBotInteraction.Handler answerBotInteraction$Handler);
}

package zendesk.answerbot;

import android.content.Intent;
import java.util.ArrayList;
import java.util.List;
import o.a.a;
import o.a.c;

/* loaded from: classes3.dex */
class AnswerBotArticleConfiguration implements a {

    private final long articleId;
    private final String articleTitle;
    private final List<a> configurations;
    private final long deflectionId;
    private final String interactionAccessToken;
    private final zendesk.answerbot.AnswerBotArticleResult result;

    static class Builder {

        private long articleId;
        private String articleTitle;
        private List<a> configurations;
        private long deflectionId;
        private String interactionAccessToken;
        private zendesk.answerbot.AnswerBotArticleResult result;
        public Builder(long l, String string2, long l3, String string4) {
            super();
            this.articleId = l;
            this.articleTitle = l3;
            this.deflectionId = string4;
            this.interactionAccessToken = obj6;
            this.result = AnswerBotArticleResult.NOT_SET;
            ArrayList obj1 = new ArrayList();
            this.configurations = obj1;
        }

        Builder(zendesk.answerbot.AnswerBotArticleConfiguration answerBotArticleConfiguration) {
            super();
            this.articleId = AnswerBotArticleConfiguration.access$600(answerBotArticleConfiguration);
            this.articleTitle = AnswerBotArticleConfiguration.access$700(answerBotArticleConfiguration);
            this.deflectionId = AnswerBotArticleConfiguration.access$800(answerBotArticleConfiguration);
            this.interactionAccessToken = AnswerBotArticleConfiguration.access$900(answerBotArticleConfiguration);
            this.result = AnswerBotArticleConfiguration.access$1000(answerBotArticleConfiguration);
            this.configurations = AnswerBotArticleConfiguration.access$1100(answerBotArticleConfiguration);
        }

        static long access$000(zendesk.answerbot.AnswerBotArticleConfiguration.Builder answerBotArticleConfiguration$Builder) {
            return builder.articleId;
        }

        static String access$100(zendesk.answerbot.AnswerBotArticleConfiguration.Builder answerBotArticleConfiguration$Builder) {
            return builder.articleTitle;
        }

        static long access$200(zendesk.answerbot.AnswerBotArticleConfiguration.Builder answerBotArticleConfiguration$Builder) {
            return builder.deflectionId;
        }

        static String access$300(zendesk.answerbot.AnswerBotArticleConfiguration.Builder answerBotArticleConfiguration$Builder) {
            return builder.interactionAccessToken;
        }

        static zendesk.answerbot.AnswerBotArticleResult access$400(zendesk.answerbot.AnswerBotArticleConfiguration.Builder answerBotArticleConfiguration$Builder) {
            return builder.result;
        }

        static List access$500(zendesk.answerbot.AnswerBotArticleConfiguration.Builder answerBotArticleConfiguration$Builder) {
            return builder.configurations;
        }

        public a config() {
            AnswerBotArticleConfiguration answerBotArticleConfiguration = new AnswerBotArticleConfiguration(this, 0);
            return answerBotArticleConfiguration;
        }

        Intent resultIntent(zendesk.answerbot.AnswerBotArticleResult answerBotArticleResult) {
            this.result = answerBotArticleResult;
            Intent intent = new Intent();
            c.c(intent, config());
            return intent;
        }
    }
    private AnswerBotArticleConfiguration(zendesk.answerbot.AnswerBotArticleConfiguration.Builder answerBotArticleConfiguration$Builder) {
        super();
        this.articleId = AnswerBotArticleConfiguration.Builder.access$000(builder);
        this.articleTitle = AnswerBotArticleConfiguration.Builder.access$100(builder);
        this.deflectionId = AnswerBotArticleConfiguration.Builder.access$200(builder);
        this.interactionAccessToken = AnswerBotArticleConfiguration.Builder.access$300(builder);
        this.result = AnswerBotArticleConfiguration.Builder.access$400(builder);
        this.configurations = AnswerBotArticleConfiguration.Builder.access$500(builder);
    }

    AnswerBotArticleConfiguration(zendesk.answerbot.AnswerBotArticleConfiguration.Builder answerBotArticleConfiguration$Builder, zendesk.answerbot.AnswerBotArticleConfiguration.1 answerBotArticleConfiguration$12) {
        super(builder);
    }

    static zendesk.answerbot.AnswerBotArticleResult access$1000(zendesk.answerbot.AnswerBotArticleConfiguration answerBotArticleConfiguration) {
        return answerBotArticleConfiguration.result;
    }

    static List access$1100(zendesk.answerbot.AnswerBotArticleConfiguration answerBotArticleConfiguration) {
        return answerBotArticleConfiguration.configurations;
    }

    static long access$600(zendesk.answerbot.AnswerBotArticleConfiguration answerBotArticleConfiguration) {
        return answerBotArticleConfiguration.articleId;
    }

    static String access$700(zendesk.answerbot.AnswerBotArticleConfiguration answerBotArticleConfiguration) {
        return answerBotArticleConfiguration.articleTitle;
    }

    static long access$800(zendesk.answerbot.AnswerBotArticleConfiguration answerBotArticleConfiguration) {
        return answerBotArticleConfiguration.deflectionId;
    }

    static String access$900(zendesk.answerbot.AnswerBotArticleConfiguration answerBotArticleConfiguration) {
        return answerBotArticleConfiguration.interactionAccessToken;
    }

    @Override // o.a.a
    long getArticleId() {
        return this.articleId;
    }

    @Override // o.a.a
    String getArticleTitle() {
        return this.articleTitle;
    }

    public List<a> getConfigurations() {
        return this.configurations;
    }

    @Override // o.a.a
    long getDeflectionId() {
        return this.deflectionId;
    }

    @Override // o.a.a
    String getInteractionAccessToken() {
        return this.interactionAccessToken;
    }

    @Override // o.a.a
    zendesk.answerbot.AnswerBotArticleResult getResult() {
        return this.result;
    }
}

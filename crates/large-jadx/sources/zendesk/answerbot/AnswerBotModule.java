package zendesk.answerbot;

/* loaded from: classes3.dex */
class AnswerBotModule {

    private final zendesk.answerbot.AnswerBotProvider answerBotProvider;
    private final zendesk.answerbot.AnswerBotSettingsProvider answerBotSettingsProvider;
    AnswerBotModule(zendesk.answerbot.AnswerBotProvider answerBotProvider, zendesk.answerbot.AnswerBotSettingsProvider answerBotSettingsProvider2) {
        super();
        this.answerBotSettingsProvider = answerBotSettingsProvider2;
        this.answerBotProvider = answerBotProvider;
    }

    public zendesk.answerbot.AnswerBotProvider answerBotProvider() {
        return this.answerBotProvider;
    }

    zendesk.answerbot.AnswerBotSettingsProvider answerBotSettingsProvider() {
        return this.answerBotSettingsProvider;
    }
}

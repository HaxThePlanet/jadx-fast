package zendesk.answerbot;

import f.g.c.a;
import zendesk.core.Zendesk;
import zendesk.support.Guide;

/* loaded from: classes3.dex */
enum AnswerBotComponentProvider {

    INSTANCE;

    private zendesk.answerbot.TimerModule timerModule;
    @Override // java.lang.Enum
    void initForTesting(zendesk.answerbot.TimerModule timerModule) {
        this.timerModule = timerModule;
    }

    @Override // java.lang.Enum
    zendesk.answerbot.AnswerBotEngine provideAnswerBot(Zendesk zendesk, zendesk.answerbot.AnswerBot answerBot2) {
        zendesk.core.CoreModule obj4 = zendesk.coreModule();
        int i = 0;
        final int i2 = 0;
        final String str = "AnswerBotComponentProvider";
        if (obj4 == null) {
            a.e(str, "Cannot create Answer Bot Engine without initializing Zendesk. Call Zendesk.INSTANCE.init(...)", new Object[i2]);
            return i;
        }
        zendesk.answerbot.AnswerBotModule obj5 = answerBot2.getAnswerBotModule();
        if (obj5 == null) {
            a.e(str, "Cannot create Answer Bot Engine without initializing Answer Bot. Call AnswerBot.INSTANCE.init(...)", new Object[i2]);
            return i;
        }
        zendesk.answerbot.DaggerAnswerBotConversationComponent.Builder builder = DaggerAnswerBotConversationComponent.builder();
        builder.coreModule(obj4);
        builder.answerBotModule(obj5);
        builder.timerModule(this.timerModule);
        return builder.build().answerBot();
    }

    @Override // java.lang.Enum
    zendesk.answerbot.AnswerBotArticleComponent provideArticleComponent(zendesk.answerbot.AnswerBotArticleConfiguration answerBotArticleConfiguration) {
        final zendesk.answerbot.DaggerAnswerBotArticleComponent.Builder builder = DaggerAnswerBotArticleComponent.builder();
        builder.coreModule(Zendesk.INSTANCE.coreModule());
        builder.answerBotModule(AnswerBot.INSTANCE.getAnswerBotModule());
        builder.timerModule(this.timerModule);
        AnswerBotArticleModule answerBotArticleModule = new AnswerBotArticleModule(answerBotArticleConfiguration, Guide.INSTANCE.provider());
        builder.answerBotArticleModule(answerBotArticleModule);
        return builder.build();
    }
}

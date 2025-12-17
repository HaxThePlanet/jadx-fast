package zendesk.answerbot;

import g.a;
import zendesk.messaging.components.Timer.Factory;

/* loaded from: classes3.dex */
public final class AnswerBotArticleActivity_MembersInjector implements a<zendesk.answerbot.AnswerBotArticleActivity> {
    public static void injectTimerFactory(zendesk.answerbot.AnswerBotArticleActivity answerBotArticleActivity, Timer.Factory timer$Factory2) {
        answerBotArticleActivity.timerFactory = factory2;
    }

    public static void injectViewModel(zendesk.answerbot.AnswerBotArticleActivity answerBotArticleActivity, Object object2) {
        answerBotArticleActivity.viewModel = (AnswerBotArticleViewModel)object2;
    }

    public static void injectZendeskWebViewClient(zendesk.answerbot.AnswerBotArticleActivity answerBotArticleActivity, Object object2) {
        answerBotArticleActivity.zendeskWebViewClient = (ZendeskWebViewClient)object2;
    }
}

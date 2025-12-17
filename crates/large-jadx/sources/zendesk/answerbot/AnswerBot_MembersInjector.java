package zendesk.answerbot;

import g.a;

/* loaded from: classes3.dex */
public final class AnswerBot_MembersInjector implements a<zendesk.answerbot.AnswerBot> {
    public static void injectAnswerBotModule(zendesk.answerbot.AnswerBot answerBot, Object object2) {
        answerBot.answerBotModule = (AnswerBotModule)object2;
    }
}

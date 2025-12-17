package zendesk.answerbot;

import com.zendesk.service.f;

/* loaded from: classes3.dex */
public interface AnswerBotProvider {
    public abstract void getDeflectionForQuery(String string, f<zendesk.answerbot.DeflectionResponse> f2);

    public abstract void rejectWithArticle(long l, long l2, String string3, zendesk.answerbot.RejectionReason rejectionReason4, f<Void> f5);

    public abstract void resolveWithArticle(long l, long l2, String string3, f<Void> f4);
}

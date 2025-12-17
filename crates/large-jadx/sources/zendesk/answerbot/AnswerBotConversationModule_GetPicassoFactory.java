package zendesk.answerbot;

import android.content.Context;
import com.squareup.picasso.t;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class AnswerBotConversationModule_GetPicassoFactory implements b<t> {

    private final a<Context> contextProvider;
    private final zendesk.answerbot.AnswerBotConversationModule module;
    public AnswerBotConversationModule_GetPicassoFactory(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, a<Context> a2) {
        super();
        this.module = answerBotConversationModule;
        this.contextProvider = a2;
    }

    public static zendesk.answerbot.AnswerBotConversationModule_GetPicassoFactory create(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, a<Context> a2) {
        AnswerBotConversationModule_GetPicassoFactory answerBotConversationModule_GetPicassoFactory = new AnswerBotConversationModule_GetPicassoFactory(answerBotConversationModule, a2);
        return answerBotConversationModule_GetPicassoFactory;
    }

    public static t getPicasso(zendesk.answerbot.AnswerBotConversationModule answerBotConversationModule, Context context2) {
        final t obj0 = answerBotConversationModule.getPicasso(context2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (t)obj0;
    }

    @Override // g.b.b
    public t get() {
        return AnswerBotConversationModule_GetPicassoFactory.getPicasso(this.module, (Context)this.contextProvider.get());
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}

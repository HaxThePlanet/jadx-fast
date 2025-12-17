package zendesk.answerbot;

import android.content.Context;
import android.content.res.Resources;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class AnswerBotConversationModule_GetResourcesFactory implements b<Resources> {

    private final a<Context> contextProvider;
    public AnswerBotConversationModule_GetResourcesFactory(a<Context> a) {
        super();
        this.contextProvider = a;
    }

    public static zendesk.answerbot.AnswerBotConversationModule_GetResourcesFactory create(a<Context> a) {
        AnswerBotConversationModule_GetResourcesFactory answerBotConversationModule_GetResourcesFactory = new AnswerBotConversationModule_GetResourcesFactory(a);
        return answerBotConversationModule_GetResourcesFactory;
    }

    public static Resources getResources(Context context) {
        final Resources obj1 = AnswerBotConversationModule.getResources(context);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (Resources)obj1;
    }

    @Override // g.b.b
    public Resources get() {
        return AnswerBotConversationModule_GetResourcesFactory.getResources((Context)this.contextProvider.get());
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}

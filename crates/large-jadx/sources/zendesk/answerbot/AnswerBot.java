package zendesk.answerbot;

import f.g.c.a;
import f.g.e.f;
import zendesk.core.CoreModule;
import zendesk.core.Zendesk;
import zendesk.support.Guide;
import zendesk.support.Support;

/* loaded from: classes3.dex */
public enum AnswerBot {

    INSTANCE;

    zendesk.answerbot.AnswerBotModule answerBotModule;
    private CoreModule coreModule;
    private boolean initialized = false;
    @Override // java.lang.Enum
    zendesk.answerbot.AnswerBotModule getAnswerBotModule() {
        Object answerBotModule;
        int coreModule;
        coreModule = 0;
        int i = 0;
        final String str3 = "AnswerBot";
        if (!isInitialized()) {
            a.e(str3, "Answer Bot SDK needs to be initialized first. Call AnswerBot.INSTANCE.init(...)", new Object[i]);
            return coreModule;
        }
        if (Zendesk.INSTANCE.getIdentity() == null) {
            a.e(str3, "Cannot use Answer Bot SDK without providing an identity. Call Zendesk.INSTANCE.setIdentity(...)", new Object[i]);
            return coreModule;
        }
        if (this.answerBotModule == null) {
            zendesk.answerbot.DaggerAnswerBotProvidersComponent.Builder builder = DaggerAnswerBotProvidersComponent.builder();
            builder.coreModule(this.coreModule);
            builder.build().inject(this);
        }
        return this.answerBotModule;
    }

    @Override // java.lang.Enum
    public void init(Zendesk zendesk, Guide guide2) {
        Object[] arr = new Object[2];
        final int i2 = 0;
        arr[i2] = zendesk;
        final int i3 = 1;
        arr[i3] = guide2;
        final String str = "AnswerBot";
        if (!f.a(arr)) {
            a.e(str, "Answer Bot cannot be initialised with null params", new Object[i2]);
        }
        if (!zendesk.isInitialized()) {
            a.e(str, "Cannot use Answer Bot SDK without initializing Zendesk. Call Zendesk.INSTANCE.init(...)", new Object[i2]);
        }
        if (!guide2.isInitialized()) {
            a.e(str, "Cannot use Answer Bot SDK without initializing Guide. Call Guide.INSTANCE.init(...)", new Object[i2]);
        }
        this.coreModule = zendesk.coreModule();
        this.initialized = i3;
    }

    @Deprecated
    public void init(Zendesk zendesk, Support support2) {
        init(zendesk, Guide.INSTANCE);
    }

    @Override // java.lang.Enum
    boolean isInitialized() {
        return this.initialized;
    }

    @Override // java.lang.Enum
    public zendesk.answerbot.AnswerBotProvider provider() {
        zendesk.answerbot.AnswerBotProvider answerBotProvider;
        zendesk.answerbot.AnswerBotModule answerBotModule = getAnswerBotModule();
        if (answerBotModule != null) {
            answerBotProvider = answerBotModule.answerBotProvider();
        } else {
            answerBotProvider = 0;
        }
        return answerBotProvider;
    }

    @Override // java.lang.Enum
    void reset() {
        final int i = 0;
        this.coreModule = i;
        this.initialized = false;
        this.answerBotModule = i;
    }
}

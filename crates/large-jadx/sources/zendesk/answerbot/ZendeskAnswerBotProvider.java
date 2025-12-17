package zendesk.answerbot;

import com.zendesk.service.a;
import com.zendesk.service.b;
import com.zendesk.service.d;
import com.zendesk.service.f;
import f.g.c.a;
import java.util.Collections;
import retrofit2.Call;
import zendesk.support.HelpCenterProvider;

/* loaded from: classes3.dex */
final class ZendeskAnswerBotProvider implements zendesk.answerbot.AnswerBotProvider {

    private static final f NO_OP_CALLBACK;
    private final zendesk.answerbot.AnswerBotService answerBotService;
    private final HelpCenterProvider helpCenterProvider;
    private final String interactionReference;
    private final zendesk.answerbot.LocaleProvider localeProvider;
    private final zendesk.answerbot.AnswerBotSettingsProvider settingsProvider;
    static {
        ZendeskAnswerBotProvider.5 anon = new ZendeskAnswerBotProvider.5();
        ZendeskAnswerBotProvider.NO_OP_CALLBACK = anon;
    }

    ZendeskAnswerBotProvider(zendesk.answerbot.AnswerBotService answerBotService, zendesk.answerbot.LocaleProvider localeProvider2, String string3, HelpCenterProvider helpCenterProvider4, zendesk.answerbot.AnswerBotSettingsProvider answerBotSettingsProvider5) {
        super();
        this.answerBotService = answerBotService;
        this.localeProvider = localeProvider2;
        this.interactionReference = string3;
        this.helpCenterProvider = helpCenterProvider4;
        this.settingsProvider = answerBotSettingsProvider5;
    }

    static void access$000(zendesk.answerbot.ZendeskAnswerBotProvider zendeskAnswerBotProvider, String string2, String string3, f f4) {
        zendeskAnswerBotProvider.getDeflectionForQuery(string2, string3, f4);
    }

    static zendesk.answerbot.LocaleProvider access$100(zendesk.answerbot.ZendeskAnswerBotProvider zendeskAnswerBotProvider) {
        return zendeskAnswerBotProvider.localeProvider;
    }

    static zendesk.answerbot.AnswerBotService access$200(zendesk.answerbot.ZendeskAnswerBotProvider zendeskAnswerBotProvider) {
        return zendeskAnswerBotProvider.answerBotService;
    }

    static f access$300() {
        return ZendeskAnswerBotProvider.NO_OP_CALLBACK;
    }

    static HelpCenterProvider access$400(zendesk.answerbot.ZendeskAnswerBotProvider zendeskAnswerBotProvider) {
        return zendeskAnswerBotProvider.helpCenterProvider;
    }

    private <T> void checkSettings(f<T> f, Runnable runnable2) {
        ZendeskAnswerBotProvider.4 anon = new ZendeskAnswerBotProvider.4(this, runnable2, f);
        this.settingsProvider.getSettings(anon);
    }

    private void getDeflectionForQuery(String string, String string2, f<zendesk.answerbot.DeflectionResponse> f3) {
        super(65, 65, string, string2, Collections.emptyList(), this.interactionReference, 3);
        d obj11 = new d(f3);
        this.answerBotService.interaction(deflectionRequest).enqueue(obj11);
    }

    public void getDeflectionForQuery(String string, f<zendesk.answerbot.DeflectionResponse> f2) {
        ZendeskAnswerBotProvider.1 anon = new ZendeskAnswerBotProvider.1(this, string, f2);
        checkSettings(f2, anon);
    }

    public void rejectWithArticle(long l, long l2, String string3, zendesk.answerbot.RejectionReason rejectionReason4, f<Void> f5) {
        super(this, l, obj3, string3, obj5, obj16, f5, obj17);
        zendesk.answerbot.ZendeskAnswerBotProvider zendeskAnswerBotProvider = this;
        checkSettings(obj17, anon2);
    }

    public void resolveWithArticle(long l, long l2, String string3, f<Void> f4) {
        super(this, l, obj3, string3, obj5, obj14, obj15);
        checkSettings(obj15, anon2);
    }
}

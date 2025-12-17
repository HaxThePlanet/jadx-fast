package zendesk.answerbot;

import com.zendesk.service.a;
import com.zendesk.service.f;
import zendesk.core.SettingsPack;
import zendesk.core.SettingsProvider;

/* loaded from: classes3.dex */
class ZendeskAnswerBotSettingsProvider implements zendesk.answerbot.AnswerBotSettingsProvider {

    private final SettingsProvider settingsProvider;
    ZendeskAnswerBotSettingsProvider(SettingsProvider settingsProvider) {
        super();
        this.settingsProvider = settingsProvider;
    }

    public void getSettings(f<zendesk.answerbot.AnswerBotSettings> f) {
        ZendeskAnswerBotSettingsProvider.1 anon = new ZendeskAnswerBotSettingsProvider.1(this, f);
        this.settingsProvider.getSettingsForSdk("answer_bot", AnswerBotSettings.class, anon);
    }
}

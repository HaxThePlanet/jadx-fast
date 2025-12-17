package zendesk.answerbot;

import zendesk.core.Settings;

/* loaded from: classes3.dex */
public final class AnswerBotSettings implements Settings {

    static final String ANSWER_BOT_SETTINGS_KEY = "answer_bot";
    private final boolean enabled;
    AnswerBotSettings(boolean z) {
        super();
        this.enabled = z;
    }

    @Override // zendesk.core.Settings
    public boolean isEnabled() {
        return this.enabled;
    }
}

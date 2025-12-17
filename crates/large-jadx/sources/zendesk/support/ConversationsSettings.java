package zendesk.support;

/* loaded from: classes3.dex */
class ConversationsSettings {

    private static zendesk.support.ConversationsSettings DEFAULT;
    private boolean enabled;
    static {
        ConversationsSettings conversationsSettings = new ConversationsSettings(0);
        ConversationsSettings.DEFAULT = conversationsSettings;
    }

    ConversationsSettings(boolean z) {
        super();
        this.enabled = z;
    }

    static zendesk.support.ConversationsSettings defaultSettings() {
        return ConversationsSettings.DEFAULT;
    }

    boolean isEnabled() {
        return this.enabled;
    }
}

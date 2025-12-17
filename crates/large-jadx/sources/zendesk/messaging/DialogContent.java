package zendesk.messaging;

/* loaded from: classes3.dex */
public class DialogContent {

    private final zendesk.messaging.DialogContent.Config config;
    private final String message;
    private final zendesk.messaging.DialogContent.Config previousConfig;
    private final String title;

    public static enum Config {

        TRANSCRIPT_PROMPT,
        TRANSCRIPT_EMAIL;
    }
    public zendesk.messaging.DialogContent.Config getConfig() {
        return this.config;
    }

    public String getMessage() {
        return this.message;
    }

    public String getTitle() {
        return this.title;
    }

    public zendesk.messaging.DialogContent.Config previousConfig() {
        return this.previousConfig;
    }
}

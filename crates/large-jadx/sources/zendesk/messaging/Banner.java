package zendesk.messaging;

/* loaded from: classes3.dex */
public class Banner {

    private final String label;
    private final zendesk.messaging.Banner.Position position;

    static enum Position {

        BOTTOM;
    }
    public String getLabel() {
        return this.label;
    }

    public zendesk.messaging.Banner.Position getPosition() {
        return this.position;
    }
}

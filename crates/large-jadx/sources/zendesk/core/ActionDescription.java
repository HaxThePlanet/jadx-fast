package zendesk.core;

/* loaded from: classes3.dex */
public final class ActionDescription {

    private final int icon;
    private final String localizedAccessibilityLabel;
    private final String localizedLabel;
    public ActionDescription(String string, String string2, int i3) {
        super();
        this.localizedLabel = string;
        this.localizedAccessibilityLabel = string2;
        this.icon = i3;
    }

    public int getIcon() {
        return this.icon;
    }

    public String getLocalizedAccessibilityLabel() {
        return this.localizedAccessibilityLabel;
    }

    public String getLocalizedLabel() {
        return this.localizedLabel;
    }
}

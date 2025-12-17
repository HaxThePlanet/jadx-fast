package zendesk.core;

/* loaded from: classes3.dex */
public class SettingsPack<E extends zendesk.core.Settings>  {

    private zendesk.core.CoreSettings coreSettings;
    private E settings;
    SettingsPack(zendesk.core.CoreSettings coreSettings, E e2) {
        super();
        this.coreSettings = coreSettings;
        this.settings = e2;
    }

    public zendesk.core.CoreSettings getCoreSettings() {
        return this.coreSettings;
    }

    public E getSettings() {
        return this.settings;
    }
}

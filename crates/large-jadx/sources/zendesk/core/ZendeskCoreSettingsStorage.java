package zendesk.core;

import f.g.c.a;
import java.util.Date;

/* loaded from: classes3.dex */
class ZendeskCoreSettingsStorage implements zendesk.core.CoreSettingsStorage {

    static final String BLIPS_KEY = "blips";
    static final String CORE_KEY = "core";
    static final zendesk.core.BlipsSettings DEFAULT_BLIPS_SETTINGS = null;
    static final zendesk.core.CoreSettings DEFAULT_CORE_SETTINGS = null;
    private static final String LOG_TAG = "ZendeskCoreSettingsStorage";
    private final zendesk.core.SettingsStorage settingsStorage;
    static {
        Date date = new Date(0, obj3);
        CoreSettings coreSettings = new CoreSettings(date, 0);
        ZendeskCoreSettingsStorage.DEFAULT_CORE_SETTINGS = coreSettings;
        BlipsPermissions blipsPermissions = new BlipsPermissions();
        BlipsSettings blipsSettings = new BlipsSettings(blipsPermissions);
        ZendeskCoreSettingsStorage.DEFAULT_BLIPS_SETTINGS = blipsSettings;
    }

    ZendeskCoreSettingsStorage(zendesk.core.SettingsStorage settingsStorage) {
        super();
        this.settingsStorage = settingsStorage;
    }

    @Override // zendesk.core.CoreSettingsStorage
    public zendesk.core.BlipsSettings getBlipsSettings() {
        Object settings = this.settingsStorage.getSettings("blips", BlipsSettings.class);
        if ((BlipsSettings)settings != null) {
            return (BlipsSettings)settings;
        }
        a.b("ZendeskCoreSettingsStorage", "Unable to load blips settings, returning defaults.", new Object[0]);
        return ZendeskCoreSettingsStorage.DEFAULT_BLIPS_SETTINGS;
    }

    @Override // zendesk.core.CoreSettingsStorage
    public zendesk.core.CoreSettings getCoreSettings() {
        Object settings = this.settingsStorage.getSettings("core", CoreSettings.class);
        if ((CoreSettings)settings != null) {
            return (CoreSettings)settings;
        }
        a.b("ZendeskCoreSettingsStorage", "Unable to load Core SDK Settings, returning default settings.", new Object[0]);
        return ZendeskCoreSettingsStorage.DEFAULT_CORE_SETTINGS;
    }
}

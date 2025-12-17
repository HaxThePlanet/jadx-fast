package zendesk.support;

import com.zendesk.service.a;
import com.zendesk.service.f;
import f.g.c.a;
import java.util.Locale;
import zendesk.core.SettingsPack;
import zendesk.core.SettingsProvider;
import zendesk.core.ZendeskLocaleConverter;

/* loaded from: classes3.dex */
class ZendeskHelpCenterSettingsProvider implements zendesk.support.HelpCenterSettingsProvider {

    private static final String HELP_CENTER_KEY = "help_center";
    private static final String LOG_TAG = "HelpCenterSettingsProvider";
    private final Locale deviceLocale;
    private final ZendeskLocaleConverter localeConverter;
    private final SettingsProvider sdkSettingsProvider;
    ZendeskHelpCenterSettingsProvider(SettingsProvider settingsProvider, ZendeskLocaleConverter zendeskLocaleConverter2, Locale locale3) {
        super();
        this.sdkSettingsProvider = settingsProvider;
        this.localeConverter = zendeskLocaleConverter2;
        this.deviceLocale = locale3;
    }

    static void access$000(zendesk.support.ZendeskHelpCenterSettingsProvider zendeskHelpCenterSettingsProvider, zendesk.support.HelpCenterSettings helpCenterSettings2) {
        zendeskHelpCenterSettingsProvider.logIfLocaleNotAvailable(helpCenterSettings2);
    }

    private void logIfLocaleNotAvailable(zendesk.support.HelpCenterSettings helpCenterSettings) {
        String locale;
        String helpCenterLocaleString;
        int i2;
        int i;
        String obj5;
        helpCenterLocaleString = this.localeConverter.toHelpCenterLocaleString(this.deviceLocale);
        i2 = 1;
        if (helpCenterSettings != null && helpCenterSettings.getLocale() != null && equals ^= i2 != 0) {
            if (helpCenterSettings.getLocale() != null) {
                helpCenterLocaleString = this.localeConverter.toHelpCenterLocaleString(this.deviceLocale);
                i2 = 1;
                if (equals ^= i2 != 0) {
                    locale = new Object[2];
                    locale[i2] = Boolean.valueOf(helpCenterSettings.isEnabled());
                    a.k("HelpCenterSettingsProvider", "No support for %s, Help Center is %s in your application settings", locale);
                }
            }
        }
    }

    public void getSettings(f<zendesk.support.HelpCenterSettings> f) {
        ZendeskHelpCenterSettingsProvider.1 anon = new ZendeskHelpCenterSettingsProvider.1(this, f);
        this.sdkSettingsProvider.getSettingsForSdk("help_center", HelpCenterSettings.class, anon);
    }
}

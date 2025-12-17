package zendesk.support;

import com.zendesk.service.a;
import com.zendesk.service.f;
import f.g.c.a;
import java.util.Locale;
import zendesk.core.SettingsPack;
import zendesk.core.SettingsProvider;
import zendesk.core.ZendeskLocaleConverter;

/* loaded from: classes3.dex */
class ZendeskSupportSettingsProvider implements zendesk.support.SupportSettingsProvider {

    private static final String HELP_CENTER_KEY = "help_center";
    private static final String LOG_TAG = "ZendeskSettingsProvider";
    static final String SUPPORT_KEY = "support";
    private final Locale deviceLocale;
    private final ZendeskLocaleConverter localeConverter;
    private final SettingsProvider sdkSettingsProvider;

    class LoadSupportSettings extends f<SettingsPack<zendesk.support.SupportSettings>> {

        private final f<zendesk.support.SupportSdkSettings> callback;
        final zendesk.support.ZendeskSupportSettingsProvider this$0;
        LoadSupportSettings(zendesk.support.ZendeskSupportSettingsProvider zendeskSupportSettingsProvider, f f2) {
            this.this$0 = zendeskSupportSettingsProvider;
            super();
            this.callback = f2;
        }

        static void access$100(zendesk.support.ZendeskSupportSettingsProvider.LoadSupportSettings zendeskSupportSettingsProvider$LoadSupportSettings, zendesk.support.HelpCenterSettings helpCenterSettings2) {
            loadSupportSettings.logIfLocaleNotAvailable(helpCenterSettings2);
        }

        private void logIfLocaleNotAvailable(zendesk.support.HelpCenterSettings helpCenterSettings) {
            String locale;
            String helpCenterLocaleString;
            int i2;
            int i;
            String obj5;
            helpCenterLocaleString = ZendeskSupportSettingsProvider.access$300(this.this$0).toHelpCenterLocaleString(ZendeskSupportSettingsProvider.access$200(this.this$0));
            i2 = 1;
            if (helpCenterSettings != null && helpCenterSettings.getLocale() != null && equals ^= i2 != 0) {
                if (helpCenterSettings.getLocale() != null) {
                    helpCenterLocaleString = ZendeskSupportSettingsProvider.access$300(this.this$0).toHelpCenterLocaleString(ZendeskSupportSettingsProvider.access$200(this.this$0));
                    i2 = 1;
                    if (equals ^= i2 != 0) {
                        locale = new Object[2];
                        locale[i2] = Boolean.valueOf(helpCenterSettings.isEnabled());
                        a.k("ZendeskSettingsProvider", "No support for %s, Help Center is %s in your application settings", locale);
                    }
                }
            }
        }

        @Override // com.zendesk.service.f
        public void onError(a a) {
            f callback;
            zendesk.support.HelpCenterSettings defaultSettings;
            int i;
            Object obj4;
            if (this.callback != null) {
                a.b("ZendeskSettingsProvider", "Returning default Support Settings.", new Object[0]);
                obj4 = new SupportSdkSettings(SupportSettings.defaultSettings(), HelpCenterSettings.defaultSettings(), 0);
                this.callback.onSuccess(obj4);
            }
        }

        @Override // com.zendesk.service.f
        public void onSuccess(Object object) {
            onSuccess((SettingsPack)object);
        }

        public void onSuccess(SettingsPack<zendesk.support.SupportSettings> settingsPack) {
            ZendeskSupportSettingsProvider.LoadSupportSettings.LoadHelpCenterSettings loadHelpCenterSettings = new ZendeskSupportSettingsProvider.LoadSupportSettings.LoadHelpCenterSettings(this, this.callback, settingsPack);
            ZendeskSupportSettingsProvider.access$000(this.this$0).getSettingsForSdk("help_center", HelpCenterSettings.class, loadHelpCenterSettings);
        }
    }
    ZendeskSupportSettingsProvider(SettingsProvider settingsProvider, ZendeskLocaleConverter zendeskLocaleConverter2, Locale locale3) {
        super();
        this.sdkSettingsProvider = settingsProvider;
        this.localeConverter = zendeskLocaleConverter2;
        this.deviceLocale = locale3;
    }

    static SettingsProvider access$000(zendesk.support.ZendeskSupportSettingsProvider zendeskSupportSettingsProvider) {
        return zendeskSupportSettingsProvider.sdkSettingsProvider;
    }

    static Locale access$200(zendesk.support.ZendeskSupportSettingsProvider zendeskSupportSettingsProvider) {
        return zendeskSupportSettingsProvider.deviceLocale;
    }

    static ZendeskLocaleConverter access$300(zendesk.support.ZendeskSupportSettingsProvider zendeskSupportSettingsProvider) {
        return zendeskSupportSettingsProvider.localeConverter;
    }

    public void getSettings(f<zendesk.support.SupportSdkSettings> f) {
        ZendeskSupportSettingsProvider.LoadSupportSettings loadSupportSettings = new ZendeskSupportSettingsProvider.LoadSupportSettings(this, f);
        this.sdkSettingsProvider.getSettingsForSdk("support", SupportSettings.class, loadSupportSettings);
    }
}

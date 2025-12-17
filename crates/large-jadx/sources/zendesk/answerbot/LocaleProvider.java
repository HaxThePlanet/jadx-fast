package zendesk.answerbot;

import com.zendesk.service.a;
import com.zendesk.service.b;
import com.zendesk.service.f;
import zendesk.core.SettingsPack;
import zendesk.core.SettingsProvider;
import zendesk.core.ZendeskLocaleConverter;
import zendesk.support.Guide;
import zendesk.support.HelpCenterSettings;

/* loaded from: classes3.dex */
final class LocaleProvider {

    private final Guide guide;
    private final ZendeskLocaleConverter localeConverter;
    private final SettingsProvider settingsProvider;
    LocaleProvider(Guide guide, SettingsProvider settingsProvider2, ZendeskLocaleConverter zendeskLocaleConverter3) {
        super();
        this.guide = guide;
        this.settingsProvider = settingsProvider2;
        this.localeConverter = zendeskLocaleConverter3;
    }

    void getLocale(f<String> f) {
        java.util.Locale helpCenterLocaleOverride = this.guide.getHelpCenterLocaleOverride();
        if (helpCenterLocaleOverride != null) {
            f.onSuccess(this.localeConverter.toHelpCenterLocaleString(helpCenterLocaleOverride));
        }
        LocaleProvider.1 anon = new LocaleProvider.1(this, f);
        this.settingsProvider.getSettingsForSdk("help_center", HelpCenterSettings.class, anon);
    }
}

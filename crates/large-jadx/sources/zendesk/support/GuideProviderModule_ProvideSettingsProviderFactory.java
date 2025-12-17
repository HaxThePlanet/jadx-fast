package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import java.util.Locale;
import zendesk.core.SettingsProvider;
import zendesk.core.ZendeskLocaleConverter;

/* loaded from: classes3.dex */
public final class GuideProviderModule_ProvideSettingsProviderFactory implements b<zendesk.support.HelpCenterSettingsProvider> {

    private final a<ZendeskLocaleConverter> localeConverterProvider;
    private final a<Locale> localeProvider;
    private final zendesk.support.GuideProviderModule module;
    private final a<SettingsProvider> sdkSettingsProvider;
    public GuideProviderModule_ProvideSettingsProviderFactory(zendesk.support.GuideProviderModule guideProviderModule, a<SettingsProvider> a2, a<ZendeskLocaleConverter> a3, a<Locale> a4) {
        super();
        this.module = guideProviderModule;
        this.sdkSettingsProvider = a2;
        this.localeConverterProvider = a3;
        this.localeProvider = a4;
    }

    public static zendesk.support.GuideProviderModule_ProvideSettingsProviderFactory create(zendesk.support.GuideProviderModule guideProviderModule, a<SettingsProvider> a2, a<ZendeskLocaleConverter> a3, a<Locale> a4) {
        GuideProviderModule_ProvideSettingsProviderFactory guideProviderModule_ProvideSettingsProviderFactory = new GuideProviderModule_ProvideSettingsProviderFactory(guideProviderModule, a2, a3, a4);
        return guideProviderModule_ProvideSettingsProviderFactory;
    }

    public static zendesk.support.HelpCenterSettingsProvider provideSettingsProvider(zendesk.support.GuideProviderModule guideProviderModule, SettingsProvider settingsProvider2, ZendeskLocaleConverter zendeskLocaleConverter3, Locale locale4) {
        final zendesk.support.HelpCenterSettingsProvider obj0 = guideProviderModule.provideSettingsProvider(settingsProvider2, zendeskLocaleConverter3, locale4);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (HelpCenterSettingsProvider)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.HelpCenterSettingsProvider get() {
        return GuideProviderModule_ProvideSettingsProviderFactory.provideSettingsProvider(this.module, (SettingsProvider)this.sdkSettingsProvider.get(), (ZendeskLocaleConverter)this.localeConverterProvider.get(), (Locale)this.localeProvider.get());
    }
}

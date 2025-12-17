package zendesk.support;

import g.b.b;
import g.b.d;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class GuideProviderModule_ProvideDeviceLocaleFactory implements b<Locale> {

    private final zendesk.support.GuideProviderModule module;
    public GuideProviderModule_ProvideDeviceLocaleFactory(zendesk.support.GuideProviderModule guideProviderModule) {
        super();
        this.module = guideProviderModule;
    }

    public static zendesk.support.GuideProviderModule_ProvideDeviceLocaleFactory create(zendesk.support.GuideProviderModule guideProviderModule) {
        GuideProviderModule_ProvideDeviceLocaleFactory guideProviderModule_ProvideDeviceLocaleFactory = new GuideProviderModule_ProvideDeviceLocaleFactory(guideProviderModule);
        return guideProviderModule_ProvideDeviceLocaleFactory;
    }

    public static Locale provideDeviceLocale(zendesk.support.GuideProviderModule guideProviderModule) {
        final Locale obj1 = guideProviderModule.provideDeviceLocale();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (Locale)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public Locale get() {
        return GuideProviderModule_ProvideDeviceLocaleFactory.provideDeviceLocale(this.module);
    }
}

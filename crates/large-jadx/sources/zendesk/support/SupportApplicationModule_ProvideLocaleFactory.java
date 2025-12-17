package zendesk.support;

import g.b.b;
import g.b.d;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class SupportApplicationModule_ProvideLocaleFactory implements b<Locale> {

    private final zendesk.support.SupportApplicationModule module;
    public SupportApplicationModule_ProvideLocaleFactory(zendesk.support.SupportApplicationModule supportApplicationModule) {
        super();
        this.module = supportApplicationModule;
    }

    public static zendesk.support.SupportApplicationModule_ProvideLocaleFactory create(zendesk.support.SupportApplicationModule supportApplicationModule) {
        SupportApplicationModule_ProvideLocaleFactory supportApplicationModule_ProvideLocaleFactory = new SupportApplicationModule_ProvideLocaleFactory(supportApplicationModule);
        return supportApplicationModule_ProvideLocaleFactory;
    }

    public static Locale provideLocale(zendesk.support.SupportApplicationModule supportApplicationModule) {
        final Locale obj1 = supportApplicationModule.provideLocale();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (Locale)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public Locale get() {
        return SupportApplicationModule_ProvideLocaleFactory.provideLocale(this.module);
    }
}

package zendesk.core;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class ZendeskApplicationModule_ProvideZendeskLocaleConverterFactory implements b<zendesk.core.ZendeskLocaleConverter> {

    private final zendesk.core.ZendeskApplicationModule module;
    public ZendeskApplicationModule_ProvideZendeskLocaleConverterFactory(zendesk.core.ZendeskApplicationModule zendeskApplicationModule) {
        super();
        this.module = zendeskApplicationModule;
    }

    public static zendesk.core.ZendeskApplicationModule_ProvideZendeskLocaleConverterFactory create(zendesk.core.ZendeskApplicationModule zendeskApplicationModule) {
        ZendeskApplicationModule_ProvideZendeskLocaleConverterFactory zendeskApplicationModule_ProvideZendeskLocaleConverterFactory = new ZendeskApplicationModule_ProvideZendeskLocaleConverterFactory(zendeskApplicationModule);
        return zendeskApplicationModule_ProvideZendeskLocaleConverterFactory;
    }

    public static zendesk.core.ZendeskLocaleConverter provideZendeskLocaleConverter(zendesk.core.ZendeskApplicationModule zendeskApplicationModule) {
        final zendesk.core.ZendeskLocaleConverter obj1 = zendeskApplicationModule.provideZendeskLocaleConverter();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ZendeskLocaleConverter)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.ZendeskLocaleConverter get() {
        return ZendeskApplicationModule_ProvideZendeskLocaleConverterFactory.provideZendeskLocaleConverter(this.module);
    }
}

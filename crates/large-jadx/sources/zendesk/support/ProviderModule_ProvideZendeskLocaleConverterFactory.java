package zendesk.support;

import g.b.b;
import g.b.d;
import zendesk.core.ZendeskLocaleConverter;

/* loaded from: classes3.dex */
public final class ProviderModule_ProvideZendeskLocaleConverterFactory implements b<ZendeskLocaleConverter> {

    private final zendesk.support.ProviderModule module;
    public ProviderModule_ProvideZendeskLocaleConverterFactory(zendesk.support.ProviderModule providerModule) {
        super();
        this.module = providerModule;
    }

    public static zendesk.support.ProviderModule_ProvideZendeskLocaleConverterFactory create(zendesk.support.ProviderModule providerModule) {
        ProviderModule_ProvideZendeskLocaleConverterFactory providerModule_ProvideZendeskLocaleConverterFactory = new ProviderModule_ProvideZendeskLocaleConverterFactory(providerModule);
        return providerModule_ProvideZendeskLocaleConverterFactory;
    }

    public static ZendeskLocaleConverter provideZendeskLocaleConverter(zendesk.support.ProviderModule providerModule) {
        final ZendeskLocaleConverter obj1 = providerModule.provideZendeskLocaleConverter();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ZendeskLocaleConverter)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public ZendeskLocaleConverter get() {
        return ProviderModule_ProvideZendeskLocaleConverterFactory.provideZendeskLocaleConverter(this.module);
    }
}

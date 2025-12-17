package zendesk.support;

import g.b.b;
import g.b.d;
import zendesk.core.ZendeskLocaleConverter;

/* loaded from: classes3.dex */
public final class GuideProviderModule_ProvideZendeskLocaleConverterFactory implements b<ZendeskLocaleConverter> {

    private static final zendesk.support.GuideProviderModule_ProvideZendeskLocaleConverterFactory INSTANCE;
    static {
        GuideProviderModule_ProvideZendeskLocaleConverterFactory guideProviderModule_ProvideZendeskLocaleConverterFactory = new GuideProviderModule_ProvideZendeskLocaleConverterFactory();
        GuideProviderModule_ProvideZendeskLocaleConverterFactory.INSTANCE = guideProviderModule_ProvideZendeskLocaleConverterFactory;
    }

    public static zendesk.support.GuideProviderModule_ProvideZendeskLocaleConverterFactory create() {
        return GuideProviderModule_ProvideZendeskLocaleConverterFactory.INSTANCE;
    }

    public static ZendeskLocaleConverter provideZendeskLocaleConverter() {
        final ZendeskLocaleConverter provideZendeskLocaleConverter = GuideProviderModule.provideZendeskLocaleConverter();
        d.c(provideZendeskLocaleConverter, "Cannot return null from a non-@Nullable @Provides method");
        return (ZendeskLocaleConverter)provideZendeskLocaleConverter;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public ZendeskLocaleConverter get() {
        return GuideProviderModule_ProvideZendeskLocaleConverterFactory.provideZendeskLocaleConverter();
    }
}

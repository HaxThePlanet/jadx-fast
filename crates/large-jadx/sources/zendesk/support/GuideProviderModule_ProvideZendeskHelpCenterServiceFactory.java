package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.ZendeskLocaleConverter;

/* loaded from: classes3.dex */
public final class GuideProviderModule_ProvideZendeskHelpCenterServiceFactory implements b<zendesk.support.ZendeskHelpCenterService> {

    private final a<zendesk.support.HelpCenterService> helpCenterServiceProvider;
    private final a<ZendeskLocaleConverter> localeConverterProvider;
    public GuideProviderModule_ProvideZendeskHelpCenterServiceFactory(a<zendesk.support.HelpCenterService> a, a<ZendeskLocaleConverter> a2) {
        super();
        this.helpCenterServiceProvider = a;
        this.localeConverterProvider = a2;
    }

    public static zendesk.support.GuideProviderModule_ProvideZendeskHelpCenterServiceFactory create(a<zendesk.support.HelpCenterService> a, a<ZendeskLocaleConverter> a2) {
        GuideProviderModule_ProvideZendeskHelpCenterServiceFactory guideProviderModule_ProvideZendeskHelpCenterServiceFactory = new GuideProviderModule_ProvideZendeskHelpCenterServiceFactory(a, a2);
        return guideProviderModule_ProvideZendeskHelpCenterServiceFactory;
    }

    public static zendesk.support.ZendeskHelpCenterService provideZendeskHelpCenterService(Object object, ZendeskLocaleConverter zendeskLocaleConverter2) {
        final zendesk.support.ZendeskHelpCenterService obj0 = GuideProviderModule.provideZendeskHelpCenterService((HelpCenterService)object, zendeskLocaleConverter2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (ZendeskHelpCenterService)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.ZendeskHelpCenterService get() {
        return GuideProviderModule_ProvideZendeskHelpCenterServiceFactory.provideZendeskHelpCenterService(this.helpCenterServiceProvider.get(), (ZendeskLocaleConverter)this.localeConverterProvider.get());
    }
}

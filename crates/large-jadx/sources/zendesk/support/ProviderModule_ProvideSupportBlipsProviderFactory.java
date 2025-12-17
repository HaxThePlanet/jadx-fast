package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;
import zendesk.core.BlipsProvider;

/* loaded from: classes3.dex */
public final class ProviderModule_ProvideSupportBlipsProviderFactory implements b<zendesk.support.SupportBlipsProvider> {

    private final a<BlipsProvider> blipsProvider;
    private final zendesk.support.ProviderModule module;
    public ProviderModule_ProvideSupportBlipsProviderFactory(zendesk.support.ProviderModule providerModule, a<BlipsProvider> a2) {
        super();
        this.module = providerModule;
        this.blipsProvider = a2;
    }

    public static zendesk.support.ProviderModule_ProvideSupportBlipsProviderFactory create(zendesk.support.ProviderModule providerModule, a<BlipsProvider> a2) {
        ProviderModule_ProvideSupportBlipsProviderFactory providerModule_ProvideSupportBlipsProviderFactory = new ProviderModule_ProvideSupportBlipsProviderFactory(providerModule, a2);
        return providerModule_ProvideSupportBlipsProviderFactory;
    }

    public static zendesk.support.SupportBlipsProvider provideSupportBlipsProvider(zendesk.support.ProviderModule providerModule, BlipsProvider blipsProvider2) {
        final zendesk.support.SupportBlipsProvider obj0 = providerModule.provideSupportBlipsProvider(blipsProvider2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (SupportBlipsProvider)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.SupportBlipsProvider get() {
        return ProviderModule_ProvideSupportBlipsProviderFactory.provideSupportBlipsProvider(this.module, (BlipsProvider)this.blipsProvider.get());
    }
}

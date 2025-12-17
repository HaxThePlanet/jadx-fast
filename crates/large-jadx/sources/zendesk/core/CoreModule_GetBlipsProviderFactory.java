package zendesk.core;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class CoreModule_GetBlipsProviderFactory implements b<zendesk.core.BlipsProvider> {

    private final zendesk.core.CoreModule module;
    public CoreModule_GetBlipsProviderFactory(zendesk.core.CoreModule coreModule) {
        super();
        this.module = coreModule;
    }

    public static zendesk.core.CoreModule_GetBlipsProviderFactory create(zendesk.core.CoreModule coreModule) {
        CoreModule_GetBlipsProviderFactory coreModule_GetBlipsProviderFactory = new CoreModule_GetBlipsProviderFactory(coreModule);
        return coreModule_GetBlipsProviderFactory;
    }

    public static zendesk.core.BlipsProvider getBlipsProvider(zendesk.core.CoreModule coreModule) {
        final zendesk.core.BlipsProvider obj1 = coreModule.getBlipsProvider();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (BlipsProvider)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.BlipsProvider get() {
        return CoreModule_GetBlipsProviderFactory.getBlipsProvider(this.module);
    }
}

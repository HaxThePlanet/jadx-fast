package zendesk.support;

import g.b.b;
import g.b.d;
import o.a.b;

/* loaded from: classes3.dex */
public final class SupportEngineModule_ConfigurationHelperFactory implements b<b> {

    private final zendesk.support.SupportEngineModule module;
    public SupportEngineModule_ConfigurationHelperFactory(zendesk.support.SupportEngineModule supportEngineModule) {
        super();
        this.module = supportEngineModule;
    }

    public static b configurationHelper(zendesk.support.SupportEngineModule supportEngineModule) {
        final b obj1 = supportEngineModule.configurationHelper();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (b)obj1;
    }

    public static zendesk.support.SupportEngineModule_ConfigurationHelperFactory create(zendesk.support.SupportEngineModule supportEngineModule) {
        SupportEngineModule_ConfigurationHelperFactory supportEngineModule_ConfigurationHelperFactory = new SupportEngineModule_ConfigurationHelperFactory(supportEngineModule);
        return supportEngineModule_ConfigurationHelperFactory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public b get() {
        return SupportEngineModule_ConfigurationHelperFactory.configurationHelper(this.module);
    }
}

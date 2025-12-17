package zendesk.support;

import g.b.b;
import g.b.d;
import o.a.b;

/* loaded from: classes3.dex */
public final class SupportSdkModule_ConfigurationHelperFactory implements b<b> {

    private final zendesk.support.SupportSdkModule module;
    public SupportSdkModule_ConfigurationHelperFactory(zendesk.support.SupportSdkModule supportSdkModule) {
        super();
        this.module = supportSdkModule;
    }

    public static b configurationHelper(zendesk.support.SupportSdkModule supportSdkModule) {
        final b obj1 = supportSdkModule.configurationHelper();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (b)obj1;
    }

    public static zendesk.support.SupportSdkModule_ConfigurationHelperFactory create(zendesk.support.SupportSdkModule supportSdkModule) {
        SupportSdkModule_ConfigurationHelperFactory supportSdkModule_ConfigurationHelperFactory = new SupportSdkModule_ConfigurationHelperFactory(supportSdkModule);
        return supportSdkModule_ConfigurationHelperFactory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public b get() {
        return SupportSdkModule_ConfigurationHelperFactory.configurationHelper(this.module);
    }
}

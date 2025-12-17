package zendesk.support.guide;

import g.b.b;
import g.b.d;
import o.a.b;

/* loaded from: classes3.dex */
public final class GuideSdkModule_ConfigurationHelperFactory implements b<b> {

    private final zendesk.support.guide.GuideSdkModule module;
    public GuideSdkModule_ConfigurationHelperFactory(zendesk.support.guide.GuideSdkModule guideSdkModule) {
        super();
        this.module = guideSdkModule;
    }

    public static b configurationHelper(zendesk.support.guide.GuideSdkModule guideSdkModule) {
        final b obj1 = guideSdkModule.configurationHelper();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (b)obj1;
    }

    public static zendesk.support.guide.GuideSdkModule_ConfigurationHelperFactory create(zendesk.support.guide.GuideSdkModule guideSdkModule) {
        GuideSdkModule_ConfigurationHelperFactory guideSdkModule_ConfigurationHelperFactory = new GuideSdkModule_ConfigurationHelperFactory(guideSdkModule);
        return guideSdkModule_ConfigurationHelperFactory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public b get() {
        return GuideSdkModule_ConfigurationHelperFactory.configurationHelper(this.module);
    }
}

package zendesk.support;

import com.google.gson.Gson;
import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class SupportSdkModule_ProvidesFactory implements b<Gson> {

    private final zendesk.support.SupportSdkModule module;
    public SupportSdkModule_ProvidesFactory(zendesk.support.SupportSdkModule supportSdkModule) {
        super();
        this.module = supportSdkModule;
    }

    public static zendesk.support.SupportSdkModule_ProvidesFactory create(zendesk.support.SupportSdkModule supportSdkModule) {
        SupportSdkModule_ProvidesFactory supportSdkModule_ProvidesFactory = new SupportSdkModule_ProvidesFactory(supportSdkModule);
        return supportSdkModule_ProvidesFactory;
    }

    public static Gson provides(zendesk.support.SupportSdkModule supportSdkModule) {
        final Gson obj1 = supportSdkModule.provides();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (Gson)obj1;
    }

    @Override // g.b.b
    public Gson get() {
        return SupportSdkModule_ProvidesFactory.provides(this.module);
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}

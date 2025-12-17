package zendesk.support;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class SupportApplicationModule_ProvideMetadataFactory implements b<zendesk.support.SupportSdkMetadata> {

    private final a<Context> contextProvider;
    private final zendesk.support.SupportApplicationModule module;
    public SupportApplicationModule_ProvideMetadataFactory(zendesk.support.SupportApplicationModule supportApplicationModule, a<Context> a2) {
        super();
        this.module = supportApplicationModule;
        this.contextProvider = a2;
    }

    public static zendesk.support.SupportApplicationModule_ProvideMetadataFactory create(zendesk.support.SupportApplicationModule supportApplicationModule, a<Context> a2) {
        SupportApplicationModule_ProvideMetadataFactory supportApplicationModule_ProvideMetadataFactory = new SupportApplicationModule_ProvideMetadataFactory(supportApplicationModule, a2);
        return supportApplicationModule_ProvideMetadataFactory;
    }

    public static zendesk.support.SupportSdkMetadata provideMetadata(zendesk.support.SupportApplicationModule supportApplicationModule, Context context2) {
        final zendesk.support.SupportSdkMetadata obj0 = supportApplicationModule.provideMetadata(context2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (SupportSdkMetadata)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.SupportSdkMetadata get() {
        return SupportApplicationModule_ProvideMetadataFactory.provideMetadata(this.module, (Context)this.contextProvider.get());
    }
}

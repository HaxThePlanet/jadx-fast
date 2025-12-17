package zendesk.support;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class SupportEngineModule_RequestCreatorFactory implements b<zendesk.support.RequestCreator> {

    private final zendesk.support.SupportEngineModule module;
    private final a<zendesk.support.RequestProvider> requestProvider;
    private final a<zendesk.support.UploadProvider> uploadProvider;
    public SupportEngineModule_RequestCreatorFactory(zendesk.support.SupportEngineModule supportEngineModule, a<zendesk.support.RequestProvider> a2, a<zendesk.support.UploadProvider> a3) {
        super();
        this.module = supportEngineModule;
        this.requestProvider = a2;
        this.uploadProvider = a3;
    }

    public static zendesk.support.SupportEngineModule_RequestCreatorFactory create(zendesk.support.SupportEngineModule supportEngineModule, a<zendesk.support.RequestProvider> a2, a<zendesk.support.UploadProvider> a3) {
        SupportEngineModule_RequestCreatorFactory supportEngineModule_RequestCreatorFactory = new SupportEngineModule_RequestCreatorFactory(supportEngineModule, a2, a3);
        return supportEngineModule_RequestCreatorFactory;
    }

    public static zendesk.support.RequestCreator requestCreator(zendesk.support.SupportEngineModule supportEngineModule, zendesk.support.RequestProvider requestProvider2, zendesk.support.UploadProvider uploadProvider3) {
        final zendesk.support.RequestCreator obj0 = supportEngineModule.requestCreator(requestProvider2, uploadProvider3);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (RequestCreator)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.RequestCreator get() {
        return SupportEngineModule_RequestCreatorFactory.requestCreator(this.module, (RequestProvider)this.requestProvider.get(), (UploadProvider)this.uploadProvider.get());
    }
}

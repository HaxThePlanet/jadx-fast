package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskApplicationModule_ProvideBase64SerializerFactory implements b<zendesk.core.Serializer> {

    private final a<zendesk.core.Serializer> gsonSerializerProvider;
    private final zendesk.core.ZendeskApplicationModule module;
    public ZendeskApplicationModule_ProvideBase64SerializerFactory(zendesk.core.ZendeskApplicationModule zendeskApplicationModule, a<zendesk.core.Serializer> a2) {
        super();
        this.module = zendeskApplicationModule;
        this.gsonSerializerProvider = a2;
    }

    public static zendesk.core.ZendeskApplicationModule_ProvideBase64SerializerFactory create(zendesk.core.ZendeskApplicationModule zendeskApplicationModule, a<zendesk.core.Serializer> a2) {
        ZendeskApplicationModule_ProvideBase64SerializerFactory zendeskApplicationModule_ProvideBase64SerializerFactory = new ZendeskApplicationModule_ProvideBase64SerializerFactory(zendeskApplicationModule, a2);
        return zendeskApplicationModule_ProvideBase64SerializerFactory;
    }

    public static zendesk.core.Serializer provideBase64Serializer(zendesk.core.ZendeskApplicationModule zendeskApplicationModule, Object object2) {
        final zendesk.core.Serializer obj0 = zendeskApplicationModule.provideBase64Serializer((Serializer)object2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (Serializer)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.Serializer get() {
        return ZendeskApplicationModule_ProvideBase64SerializerFactory.provideBase64Serializer(this.module, this.gsonSerializerProvider.get());
    }
}

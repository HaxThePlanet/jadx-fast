package zendesk.core;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvidePushDeviceIdStorageFactory implements b<zendesk.core.PushDeviceIdStorage> {

    private final a<zendesk.core.BaseStorage> additionalSdkStorageProvider;
    public ZendeskStorageModule_ProvidePushDeviceIdStorageFactory(a<zendesk.core.BaseStorage> a) {
        super();
        this.additionalSdkStorageProvider = a;
    }

    public static zendesk.core.ZendeskStorageModule_ProvidePushDeviceIdStorageFactory create(a<zendesk.core.BaseStorage> a) {
        ZendeskStorageModule_ProvidePushDeviceIdStorageFactory zendeskStorageModule_ProvidePushDeviceIdStorageFactory = new ZendeskStorageModule_ProvidePushDeviceIdStorageFactory(a);
        return zendeskStorageModule_ProvidePushDeviceIdStorageFactory;
    }

    public static zendesk.core.PushDeviceIdStorage providePushDeviceIdStorage(zendesk.core.BaseStorage baseStorage) {
        final zendesk.core.PushDeviceIdStorage obj1 = ZendeskStorageModule.providePushDeviceIdStorage(baseStorage);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (PushDeviceIdStorage)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.PushDeviceIdStorage get() {
        return ZendeskStorageModule_ProvidePushDeviceIdStorageFactory.providePushDeviceIdStorage((BaseStorage)this.additionalSdkStorageProvider.get());
    }
}

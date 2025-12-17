package zendesk.support;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class StorageModule_ProvideRequestMigratorFactory implements b<zendesk.support.RequestMigrator> {

    private final a<Context> contextProvider;
    private final zendesk.support.StorageModule module;
    public StorageModule_ProvideRequestMigratorFactory(zendesk.support.StorageModule storageModule, a<Context> a2) {
        super();
        this.module = storageModule;
        this.contextProvider = a2;
    }

    public static zendesk.support.StorageModule_ProvideRequestMigratorFactory create(zendesk.support.StorageModule storageModule, a<Context> a2) {
        StorageModule_ProvideRequestMigratorFactory storageModule_ProvideRequestMigratorFactory = new StorageModule_ProvideRequestMigratorFactory(storageModule, a2);
        return storageModule_ProvideRequestMigratorFactory;
    }

    public static zendesk.support.RequestMigrator provideRequestMigrator(zendesk.support.StorageModule storageModule, Context context2) {
        final zendesk.support.RequestMigrator obj0 = storageModule.provideRequestMigrator(context2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (RequestMigrator)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.RequestMigrator get() {
        return StorageModule_ProvideRequestMigratorFactory.provideRequestMigrator(this.module, (Context)this.contextProvider.get());
    }
}

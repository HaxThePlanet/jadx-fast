package zendesk.core;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;
import java.io.File;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvidesCacheDirFactory implements b<File> {

    private final a<Context> contextProvider;
    public ZendeskStorageModule_ProvidesCacheDirFactory(a<Context> a) {
        super();
        this.contextProvider = a;
    }

    public static zendesk.core.ZendeskStorageModule_ProvidesCacheDirFactory create(a<Context> a) {
        ZendeskStorageModule_ProvidesCacheDirFactory zendeskStorageModule_ProvidesCacheDirFactory = new ZendeskStorageModule_ProvidesCacheDirFactory(a);
        return zendeskStorageModule_ProvidesCacheDirFactory;
    }

    public static File providesCacheDir(Context context) {
        final File obj1 = ZendeskStorageModule.providesCacheDir(context);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (File)obj1;
    }

    @Override // g.b.b
    public File get() {
        return ZendeskStorageModule_ProvidesCacheDirFactory.providesCacheDir((Context)this.contextProvider.get());
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}

package zendesk.core;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;
import java.io.File;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvidesDataDirFactory implements b<File> {

    private final a<Context> contextProvider;
    public ZendeskStorageModule_ProvidesDataDirFactory(a<Context> a) {
        super();
        this.contextProvider = a;
    }

    public static zendesk.core.ZendeskStorageModule_ProvidesDataDirFactory create(a<Context> a) {
        ZendeskStorageModule_ProvidesDataDirFactory zendeskStorageModule_ProvidesDataDirFactory = new ZendeskStorageModule_ProvidesDataDirFactory(a);
        return zendeskStorageModule_ProvidesDataDirFactory;
    }

    public static File providesDataDir(Context context) {
        final File obj1 = ZendeskStorageModule.providesDataDir(context);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (File)obj1;
    }

    @Override // g.b.b
    public File get() {
        return ZendeskStorageModule_ProvidesDataDirFactory.providesDataDir((Context)this.contextProvider.get());
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}

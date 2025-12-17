package zendesk.core;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;
import java.io.File;

/* loaded from: classes3.dex */
public final class ZendeskStorageModule_ProvidesBelvedereDirFactory implements b<File> {

    private final a<Context> contextProvider;
    public ZendeskStorageModule_ProvidesBelvedereDirFactory(a<Context> a) {
        super();
        this.contextProvider = a;
    }

    public static zendesk.core.ZendeskStorageModule_ProvidesBelvedereDirFactory create(a<Context> a) {
        ZendeskStorageModule_ProvidesBelvedereDirFactory zendeskStorageModule_ProvidesBelvedereDirFactory = new ZendeskStorageModule_ProvidesBelvedereDirFactory(a);
        return zendeskStorageModule_ProvidesBelvedereDirFactory;
    }

    public static File providesBelvedereDir(Context context) {
        final File obj1 = ZendeskStorageModule.providesBelvedereDir(context);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (File)obj1;
    }

    @Override // g.b.b
    public File get() {
        return ZendeskStorageModule_ProvidesBelvedereDirFactory.providesBelvedereDir((Context)this.contextProvider.get());
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}

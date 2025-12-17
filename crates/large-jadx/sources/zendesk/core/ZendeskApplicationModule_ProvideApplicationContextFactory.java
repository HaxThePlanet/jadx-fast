package zendesk.core;

import android.content.Context;
import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class ZendeskApplicationModule_ProvideApplicationContextFactory implements b<Context> {

    private final zendesk.core.ZendeskApplicationModule module;
    public ZendeskApplicationModule_ProvideApplicationContextFactory(zendesk.core.ZendeskApplicationModule zendeskApplicationModule) {
        super();
        this.module = zendeskApplicationModule;
    }

    public static zendesk.core.ZendeskApplicationModule_ProvideApplicationContextFactory create(zendesk.core.ZendeskApplicationModule zendeskApplicationModule) {
        ZendeskApplicationModule_ProvideApplicationContextFactory zendeskApplicationModule_ProvideApplicationContextFactory = new ZendeskApplicationModule_ProvideApplicationContextFactory(zendeskApplicationModule);
        return zendeskApplicationModule_ProvideApplicationContextFactory;
    }

    public static Context provideApplicationContext(zendesk.core.ZendeskApplicationModule zendeskApplicationModule) {
        final Context obj1 = zendeskApplicationModule.provideApplicationContext();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (Context)obj1;
    }

    @Override // g.b.b
    public Context get() {
        return ZendeskApplicationModule_ProvideApplicationContextFactory.provideApplicationContext(this.module);
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}

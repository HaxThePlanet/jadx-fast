package zendesk.core;

import android.content.Context;
import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class CoreModule_GetApplicationContextFactory implements b<Context> {

    private final zendesk.core.CoreModule module;
    public CoreModule_GetApplicationContextFactory(zendesk.core.CoreModule coreModule) {
        super();
        this.module = coreModule;
    }

    public static zendesk.core.CoreModule_GetApplicationContextFactory create(zendesk.core.CoreModule coreModule) {
        CoreModule_GetApplicationContextFactory coreModule_GetApplicationContextFactory = new CoreModule_GetApplicationContextFactory(coreModule);
        return coreModule_GetApplicationContextFactory;
    }

    public static Context getApplicationContext(zendesk.core.CoreModule coreModule) {
        final Context obj1 = coreModule.getApplicationContext();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (Context)obj1;
    }

    @Override // g.b.b
    public Context get() {
        return CoreModule_GetApplicationContextFactory.getApplicationContext(this.module);
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}

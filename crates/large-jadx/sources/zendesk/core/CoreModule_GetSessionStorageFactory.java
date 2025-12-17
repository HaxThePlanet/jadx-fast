package zendesk.core;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class CoreModule_GetSessionStorageFactory implements b<zendesk.core.SessionStorage> {

    private final zendesk.core.CoreModule module;
    public CoreModule_GetSessionStorageFactory(zendesk.core.CoreModule coreModule) {
        super();
        this.module = coreModule;
    }

    public static zendesk.core.CoreModule_GetSessionStorageFactory create(zendesk.core.CoreModule coreModule) {
        CoreModule_GetSessionStorageFactory coreModule_GetSessionStorageFactory = new CoreModule_GetSessionStorageFactory(coreModule);
        return coreModule_GetSessionStorageFactory;
    }

    public static zendesk.core.SessionStorage getSessionStorage(zendesk.core.CoreModule coreModule) {
        final zendesk.core.SessionStorage obj1 = coreModule.getSessionStorage();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (SessionStorage)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.SessionStorage get() {
        return CoreModule_GetSessionStorageFactory.getSessionStorage(this.module);
    }
}

package zendesk.core;

import com.google.gson.Gson;
import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class ZendeskApplicationModule_ProvideGsonFactory implements b<Gson> {

    private static final zendesk.core.ZendeskApplicationModule_ProvideGsonFactory INSTANCE;
    static {
        ZendeskApplicationModule_ProvideGsonFactory zendeskApplicationModule_ProvideGsonFactory = new ZendeskApplicationModule_ProvideGsonFactory();
        ZendeskApplicationModule_ProvideGsonFactory.INSTANCE = zendeskApplicationModule_ProvideGsonFactory;
    }

    public static zendesk.core.ZendeskApplicationModule_ProvideGsonFactory create() {
        return ZendeskApplicationModule_ProvideGsonFactory.INSTANCE;
    }

    public static Gson provideGson() {
        final Gson provideGson = ZendeskApplicationModule.provideGson();
        d.c(provideGson, "Cannot return null from a non-@Nullable @Provides method");
        return (Gson)provideGson;
    }

    @Override // g.b.b
    public Gson get() {
        return ZendeskApplicationModule_ProvideGsonFactory.provideGson();
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }
}

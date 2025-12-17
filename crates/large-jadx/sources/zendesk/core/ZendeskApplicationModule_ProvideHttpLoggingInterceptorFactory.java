package zendesk.core;

import g.b.b;
import g.b.d;
import okhttp3.logging.HttpLoggingInterceptor;

/* loaded from: classes3.dex */
public final class ZendeskApplicationModule_ProvideHttpLoggingInterceptorFactory implements b<HttpLoggingInterceptor> {

    private static final zendesk.core.ZendeskApplicationModule_ProvideHttpLoggingInterceptorFactory INSTANCE;
    static {
        ZendeskApplicationModule_ProvideHttpLoggingInterceptorFactory zendeskApplicationModule_ProvideHttpLoggingInterceptorFactory = new ZendeskApplicationModule_ProvideHttpLoggingInterceptorFactory();
        ZendeskApplicationModule_ProvideHttpLoggingInterceptorFactory.INSTANCE = zendeskApplicationModule_ProvideHttpLoggingInterceptorFactory;
    }

    public static zendesk.core.ZendeskApplicationModule_ProvideHttpLoggingInterceptorFactory create() {
        return ZendeskApplicationModule_ProvideHttpLoggingInterceptorFactory.INSTANCE;
    }

    public static HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        final HttpLoggingInterceptor provideHttpLoggingInterceptor = ZendeskApplicationModule.provideHttpLoggingInterceptor();
        d.c(provideHttpLoggingInterceptor, "Cannot return null from a non-@Nullable @Provides method");
        return (HttpLoggingInterceptor)provideHttpLoggingInterceptor;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public HttpLoggingInterceptor get() {
        return ZendeskApplicationModule_ProvideHttpLoggingInterceptorFactory.provideHttpLoggingInterceptor();
    }
}

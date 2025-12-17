package zendesk.core;

import android.content.Context;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class ZendeskNetworkModule_ProvideAcceptLanguageHeaderInterceptorFactory implements b<zendesk.core.AcceptLanguageHeaderInterceptor> {

    private final a<Context> contextProvider;
    public ZendeskNetworkModule_ProvideAcceptLanguageHeaderInterceptorFactory(a<Context> a) {
        super();
        this.contextProvider = a;
    }

    public static zendesk.core.ZendeskNetworkModule_ProvideAcceptLanguageHeaderInterceptorFactory create(a<Context> a) {
        ZendeskNetworkModule_ProvideAcceptLanguageHeaderInterceptorFactory zendeskNetworkModule_ProvideAcceptLanguageHeaderInterceptorFactory = new ZendeskNetworkModule_ProvideAcceptLanguageHeaderInterceptorFactory(a);
        return zendeskNetworkModule_ProvideAcceptLanguageHeaderInterceptorFactory;
    }

    public static zendesk.core.AcceptLanguageHeaderInterceptor provideAcceptLanguageHeaderInterceptor(Context context) {
        final zendesk.core.AcceptLanguageHeaderInterceptor obj1 = ZendeskNetworkModule.provideAcceptLanguageHeaderInterceptor(context);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (AcceptLanguageHeaderInterceptor)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.core.AcceptLanguageHeaderInterceptor get() {
        return ZendeskNetworkModule_ProvideAcceptLanguageHeaderInterceptorFactory.provideAcceptLanguageHeaderInterceptor((Context)this.contextProvider.get());
    }
}

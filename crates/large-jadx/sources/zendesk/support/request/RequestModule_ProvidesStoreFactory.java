package zendesk.support.request;

import g.b.b;
import g.b.d;
import j.a.a;
import java.util.List;
import o.b.n;
import o.b.q;

/* loaded from: classes3.dex */
public final class RequestModule_ProvidesStoreFactory implements b<q> {

    private final a<zendesk.support.request.AsyncMiddleware> asyncMiddlewareProvider;
    private final a<List<n>> reducersProvider;
    public RequestModule_ProvidesStoreFactory(a<List<n>> a, a<zendesk.support.request.AsyncMiddleware> a2) {
        super();
        this.reducersProvider = a;
        this.asyncMiddlewareProvider = a2;
    }

    public static zendesk.support.request.RequestModule_ProvidesStoreFactory create(a<List<n>> a, a<zendesk.support.request.AsyncMiddleware> a2) {
        RequestModule_ProvidesStoreFactory requestModule_ProvidesStoreFactory = new RequestModule_ProvidesStoreFactory(a, a2);
        return requestModule_ProvidesStoreFactory;
    }

    public static q providesStore(List<n> list, Object object2) {
        final q obj0 = RequestModule.providesStore(list, (AsyncMiddleware)object2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (q)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public q get() {
        return RequestModule_ProvidesStoreFactory.providesStore((List)this.reducersProvider.get(), this.asyncMiddlewareProvider.get());
    }
}

package zendesk.support.request;

import g.b.b;
import g.b.d;
import j.a.a;
import o.b.f;
import o.b.q;

/* loaded from: classes3.dex */
public final class RequestModule_ProvidesDispatcherFactory implements b<f> {

    private final a<q> storeProvider;
    public RequestModule_ProvidesDispatcherFactory(a<q> a) {
        super();
        this.storeProvider = a;
    }

    public static zendesk.support.request.RequestModule_ProvidesDispatcherFactory create(a<q> a) {
        RequestModule_ProvidesDispatcherFactory requestModule_ProvidesDispatcherFactory = new RequestModule_ProvidesDispatcherFactory(a);
        return requestModule_ProvidesDispatcherFactory;
    }

    public static f providesDispatcher(q q) {
        final f obj1 = RequestModule.providesDispatcher(q);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (f)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public f get() {
        return RequestModule_ProvidesDispatcherFactory.providesDispatcher((q)this.storeProvider.get());
    }
}

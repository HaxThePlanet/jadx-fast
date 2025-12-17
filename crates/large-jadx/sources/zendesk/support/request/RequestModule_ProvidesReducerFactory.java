package zendesk.support.request;

import g.b.b;
import g.b.d;
import java.util.List;
import o.b.n;

/* loaded from: classes3.dex */
public final class RequestModule_ProvidesReducerFactory implements b<List<n>> {

    private static final zendesk.support.request.RequestModule_ProvidesReducerFactory INSTANCE;
    static {
        RequestModule_ProvidesReducerFactory requestModule_ProvidesReducerFactory = new RequestModule_ProvidesReducerFactory();
        RequestModule_ProvidesReducerFactory.INSTANCE = requestModule_ProvidesReducerFactory;
    }

    public static zendesk.support.request.RequestModule_ProvidesReducerFactory create() {
        return RequestModule_ProvidesReducerFactory.INSTANCE;
    }

    public static List<n> providesReducer() {
        final List providesReducer = RequestModule.providesReducer();
        d.c(providesReducer, "Cannot return null from a non-@Nullable @Provides method");
        return (List)providesReducer;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    public List<n> get() {
        return RequestModule_ProvidesReducerFactory.providesReducer();
    }
}

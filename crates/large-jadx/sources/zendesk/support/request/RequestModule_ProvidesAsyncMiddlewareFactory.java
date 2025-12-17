package zendesk.support.request;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class RequestModule_ProvidesAsyncMiddlewareFactory implements b<zendesk.support.request.AsyncMiddleware> {

    private static final zendesk.support.request.RequestModule_ProvidesAsyncMiddlewareFactory INSTANCE;
    static {
        RequestModule_ProvidesAsyncMiddlewareFactory requestModule_ProvidesAsyncMiddlewareFactory = new RequestModule_ProvidesAsyncMiddlewareFactory();
        RequestModule_ProvidesAsyncMiddlewareFactory.INSTANCE = requestModule_ProvidesAsyncMiddlewareFactory;
    }

    public static zendesk.support.request.RequestModule_ProvidesAsyncMiddlewareFactory create() {
        return RequestModule_ProvidesAsyncMiddlewareFactory.INSTANCE;
    }

    public static zendesk.support.request.AsyncMiddleware providesAsyncMiddleware() {
        final zendesk.support.request.AsyncMiddleware providesAsyncMiddleware = RequestModule.providesAsyncMiddleware();
        d.c(providesAsyncMiddleware, "Cannot return null from a non-@Nullable @Provides method");
        return (AsyncMiddleware)providesAsyncMiddleware;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.request.AsyncMiddleware get() {
        return RequestModule_ProvidesAsyncMiddlewareFactory.providesAsyncMiddleware();
    }
}

package zendesk.support.requestlist;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class RequestListModule_RefreshHandlerFactory implements b<zendesk.support.requestlist.RequestListSyncHandler> {

    private final a<zendesk.support.requestlist.RequestListPresenter> presenterProvider;
    public RequestListModule_RefreshHandlerFactory(a<zendesk.support.requestlist.RequestListPresenter> a) {
        super();
        this.presenterProvider = a;
    }

    public static zendesk.support.requestlist.RequestListModule_RefreshHandlerFactory create(a<zendesk.support.requestlist.RequestListPresenter> a) {
        RequestListModule_RefreshHandlerFactory requestListModule_RefreshHandlerFactory = new RequestListModule_RefreshHandlerFactory(a);
        return requestListModule_RefreshHandlerFactory;
    }

    public static zendesk.support.requestlist.RequestListSyncHandler refreshHandler(Object object) {
        final zendesk.support.requestlist.RequestListSyncHandler obj1 = RequestListModule.refreshHandler((RequestListPresenter)object);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (RequestListSyncHandler)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.requestlist.RequestListSyncHandler get() {
        return RequestListModule_RefreshHandlerFactory.refreshHandler(this.presenterProvider.get());
    }
}

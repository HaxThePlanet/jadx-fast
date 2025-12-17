package zendesk.support.requestlist;

import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class RequestListModule_PresenterFactory implements b<zendesk.support.requestlist.RequestListPresenter> {

    private final a<zendesk.support.requestlist.RequestListModel> modelProvider;
    private final zendesk.support.requestlist.RequestListModule module;
    public RequestListModule_PresenterFactory(zendesk.support.requestlist.RequestListModule requestListModule, a<zendesk.support.requestlist.RequestListModel> a2) {
        super();
        this.module = requestListModule;
        this.modelProvider = a2;
    }

    public static zendesk.support.requestlist.RequestListModule_PresenterFactory create(zendesk.support.requestlist.RequestListModule requestListModule, a<zendesk.support.requestlist.RequestListModel> a2) {
        RequestListModule_PresenterFactory requestListModule_PresenterFactory = new RequestListModule_PresenterFactory(requestListModule, a2);
        return requestListModule_PresenterFactory;
    }

    public static zendesk.support.requestlist.RequestListPresenter presenter(zendesk.support.requestlist.RequestListModule requestListModule, Object object2) {
        final zendesk.support.requestlist.RequestListPresenter obj0 = requestListModule.presenter((RequestListModel)object2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (RequestListPresenter)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.requestlist.RequestListPresenter get() {
        return RequestListModule_PresenterFactory.presenter(this.module, this.modelProvider.get());
    }
}

package zendesk.support.requestlist;

import com.squareup.picasso.t;
import g.b.b;
import g.b.d;
import j.a.a;

/* loaded from: classes3.dex */
public final class RequestListViewModule_ViewFactory implements b<zendesk.support.requestlist.RequestListView> {

    private final zendesk.support.requestlist.RequestListViewModule module;
    private final a<t> picassoProvider;
    public RequestListViewModule_ViewFactory(zendesk.support.requestlist.RequestListViewModule requestListViewModule, a<t> a2) {
        super();
        this.module = requestListViewModule;
        this.picassoProvider = a2;
    }

    public static zendesk.support.requestlist.RequestListViewModule_ViewFactory create(zendesk.support.requestlist.RequestListViewModule requestListViewModule, a<t> a2) {
        RequestListViewModule_ViewFactory requestListViewModule_ViewFactory = new RequestListViewModule_ViewFactory(requestListViewModule, a2);
        return requestListViewModule_ViewFactory;
    }

    public static zendesk.support.requestlist.RequestListView view(zendesk.support.requestlist.RequestListViewModule requestListViewModule, t t2) {
        final zendesk.support.requestlist.RequestListView obj0 = requestListViewModule.view(t2);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (RequestListView)obj0;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.requestlist.RequestListView get() {
        return RequestListViewModule_ViewFactory.view(this.module, (t)this.picassoProvider.get());
    }
}

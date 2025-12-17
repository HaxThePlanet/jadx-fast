package zendesk.support.request;

import com.squareup.picasso.t;
import g.a;
import j.a.a;
import o.b.q;

/* loaded from: classes3.dex */
public final class RequestViewConversationsEnabled_MembersInjector implements a<zendesk.support.request.RequestViewConversationsEnabled> {

    private final a<zendesk.support.request.ActionFactory> afProvider;
    private final a<zendesk.support.request.CellFactory> cellFactoryProvider;
    private final a<t> picassoProvider;
    private final a<q> storeProvider;
    public RequestViewConversationsEnabled_MembersInjector(a<q> a, a<zendesk.support.request.ActionFactory> a2, a<zendesk.support.request.CellFactory> a3, a<t> a4) {
        super();
        this.storeProvider = a;
        this.afProvider = a2;
        this.cellFactoryProvider = a3;
        this.picassoProvider = a4;
    }

    public static a<zendesk.support.request.RequestViewConversationsEnabled> create(a<q> a, a<zendesk.support.request.ActionFactory> a2, a<zendesk.support.request.CellFactory> a3, a<t> a4) {
        RequestViewConversationsEnabled_MembersInjector requestViewConversationsEnabled_MembersInjector = new RequestViewConversationsEnabled_MembersInjector(a, a2, a3, a4);
        return requestViewConversationsEnabled_MembersInjector;
    }

    public static void injectAf(zendesk.support.request.RequestViewConversationsEnabled requestViewConversationsEnabled, Object object2) {
        requestViewConversationsEnabled.af = (ActionFactory)object2;
    }

    public static void injectCellFactory(zendesk.support.request.RequestViewConversationsEnabled requestViewConversationsEnabled, Object object2) {
        requestViewConversationsEnabled.cellFactory = (CellFactory)object2;
    }

    public static void injectPicasso(zendesk.support.request.RequestViewConversationsEnabled requestViewConversationsEnabled, t t2) {
        requestViewConversationsEnabled.picasso = t2;
    }

    public static void injectStore(zendesk.support.request.RequestViewConversationsEnabled requestViewConversationsEnabled, q q2) {
        requestViewConversationsEnabled.store = q2;
    }

    @Override // g.a
    public void injectMembers(Object object) {
        injectMembers((RequestViewConversationsEnabled)object);
    }

    @Override // g.a
    public void injectMembers(zendesk.support.request.RequestViewConversationsEnabled requestViewConversationsEnabled) {
        RequestViewConversationsEnabled_MembersInjector.injectStore(requestViewConversationsEnabled, (q)this.storeProvider.get());
        RequestViewConversationsEnabled_MembersInjector.injectAf(requestViewConversationsEnabled, this.afProvider.get());
        RequestViewConversationsEnabled_MembersInjector.injectCellFactory(requestViewConversationsEnabled, this.cellFactoryProvider.get());
        RequestViewConversationsEnabled_MembersInjector.injectPicasso(requestViewConversationsEnabled, (t)this.picassoProvider.get());
    }
}

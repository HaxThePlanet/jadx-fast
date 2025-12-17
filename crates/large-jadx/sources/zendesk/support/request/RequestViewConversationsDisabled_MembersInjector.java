package zendesk.support.request;

import com.squareup.picasso.t;
import g.a;
import j.a.a;
import o.b.q;

/* loaded from: classes3.dex */
public final class RequestViewConversationsDisabled_MembersInjector implements a<zendesk.support.request.RequestViewConversationsDisabled> {

    private final a<zendesk.support.request.ActionFactory> afProvider;
    private final a<t> picassoProvider;
    private final a<q> storeProvider;
    public RequestViewConversationsDisabled_MembersInjector(a<q> a, a<zendesk.support.request.ActionFactory> a2, a<t> a3) {
        super();
        this.storeProvider = a;
        this.afProvider = a2;
        this.picassoProvider = a3;
    }

    public static a<zendesk.support.request.RequestViewConversationsDisabled> create(a<q> a, a<zendesk.support.request.ActionFactory> a2, a<t> a3) {
        RequestViewConversationsDisabled_MembersInjector requestViewConversationsDisabled_MembersInjector = new RequestViewConversationsDisabled_MembersInjector(a, a2, a3);
        return requestViewConversationsDisabled_MembersInjector;
    }

    public static void injectAf(zendesk.support.request.RequestViewConversationsDisabled requestViewConversationsDisabled, Object object2) {
        requestViewConversationsDisabled.af = (ActionFactory)object2;
    }

    public static void injectPicasso(zendesk.support.request.RequestViewConversationsDisabled requestViewConversationsDisabled, t t2) {
        requestViewConversationsDisabled.picasso = t2;
    }

    public static void injectStore(zendesk.support.request.RequestViewConversationsDisabled requestViewConversationsDisabled, q q2) {
        requestViewConversationsDisabled.store = q2;
    }

    @Override // g.a
    public void injectMembers(Object object) {
        injectMembers((RequestViewConversationsDisabled)object);
    }

    @Override // g.a
    public void injectMembers(zendesk.support.request.RequestViewConversationsDisabled requestViewConversationsDisabled) {
        RequestViewConversationsDisabled_MembersInjector.injectStore(requestViewConversationsDisabled, (q)this.storeProvider.get());
        RequestViewConversationsDisabled_MembersInjector.injectAf(requestViewConversationsDisabled, this.afProvider.get());
        RequestViewConversationsDisabled_MembersInjector.injectPicasso(requestViewConversationsDisabled, (t)this.picassoProvider.get());
    }
}

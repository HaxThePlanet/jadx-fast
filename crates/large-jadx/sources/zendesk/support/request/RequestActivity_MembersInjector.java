package zendesk.support.request;

import com.squareup.picasso.t;
import g.a;
import j.a.a;
import o.b.q;
import zendesk.core.ActionHandlerRegistry;

/* loaded from: classes3.dex */
public final class RequestActivity_MembersInjector implements a<zendesk.support.request.RequestActivity> {

    private final a<ActionHandlerRegistry> actionHandlerRegistryProvider;
    private final a<zendesk.support.request.ActionFactory> afProvider;
    private final a<zendesk.support.request.HeadlessComponentListener> headlessComponentListenerProvider;
    private final a<t> picassoProvider;
    private final a<q> storeProvider;
    public RequestActivity_MembersInjector(a<q> a, a<zendesk.support.request.ActionFactory> a2, a<zendesk.support.request.HeadlessComponentListener> a3, a<t> a4, a<ActionHandlerRegistry> a5) {
        super();
        this.storeProvider = a;
        this.afProvider = a2;
        this.headlessComponentListenerProvider = a3;
        this.picassoProvider = a4;
        this.actionHandlerRegistryProvider = a5;
    }

    public static a<zendesk.support.request.RequestActivity> create(a<q> a, a<zendesk.support.request.ActionFactory> a2, a<zendesk.support.request.HeadlessComponentListener> a3, a<t> a4, a<ActionHandlerRegistry> a5) {
        super(a, a2, a3, a4, a5);
        return requestActivity_MembersInjector;
    }

    public static void injectActionHandlerRegistry(zendesk.support.request.RequestActivity requestActivity, ActionHandlerRegistry actionHandlerRegistry2) {
        requestActivity.actionHandlerRegistry = actionHandlerRegistry2;
    }

    public static void injectAf(zendesk.support.request.RequestActivity requestActivity, Object object2) {
        requestActivity.af = (ActionFactory)object2;
    }

    public static void injectHeadlessComponentListener(zendesk.support.request.RequestActivity requestActivity, Object object2) {
        requestActivity.headlessComponentListener = (HeadlessComponentListener)object2;
    }

    public static void injectPicasso(zendesk.support.request.RequestActivity requestActivity, t t2) {
        requestActivity.picasso = t2;
    }

    public static void injectStore(zendesk.support.request.RequestActivity requestActivity, q q2) {
        requestActivity.store = q2;
    }

    @Override // g.a
    public void injectMembers(Object object) {
        injectMembers((RequestActivity)object);
    }

    @Override // g.a
    public void injectMembers(zendesk.support.request.RequestActivity requestActivity) {
        RequestActivity_MembersInjector.injectStore(requestActivity, (q)this.storeProvider.get());
        RequestActivity_MembersInjector.injectAf(requestActivity, this.afProvider.get());
        RequestActivity_MembersInjector.injectHeadlessComponentListener(requestActivity, this.headlessComponentListenerProvider.get());
        RequestActivity_MembersInjector.injectPicasso(requestActivity, (t)this.picassoProvider.get());
        RequestActivity_MembersInjector.injectActionHandlerRegistry(requestActivity, (ActionHandlerRegistry)this.actionHandlerRegistryProvider.get());
    }
}

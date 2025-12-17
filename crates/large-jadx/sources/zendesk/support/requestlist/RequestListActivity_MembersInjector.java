package zendesk.support.requestlist;

import g.a;
import j.a.a;
import zendesk.core.ActionHandlerRegistry;

/* loaded from: classes3.dex */
public final class RequestListActivity_MembersInjector implements a<zendesk.support.requestlist.RequestListActivity> {

    private final a<ActionHandlerRegistry> actionHandlerRegistryProvider;
    private final a<zendesk.support.requestlist.RequestListModel> modelProvider;
    private final a<zendesk.support.requestlist.RequestListPresenter> presenterProvider;
    private final a<zendesk.support.requestlist.RequestListSyncHandler> syncHandlerProvider;
    private final a<zendesk.support.requestlist.RequestListView> viewProvider;
    public RequestListActivity_MembersInjector(a<zendesk.support.requestlist.RequestListPresenter> a, a<zendesk.support.requestlist.RequestListView> a2, a<zendesk.support.requestlist.RequestListModel> a3, a<ActionHandlerRegistry> a4, a<zendesk.support.requestlist.RequestListSyncHandler> a5) {
        super();
        this.presenterProvider = a;
        this.viewProvider = a2;
        this.modelProvider = a3;
        this.actionHandlerRegistryProvider = a4;
        this.syncHandlerProvider = a5;
    }

    public static a<zendesk.support.requestlist.RequestListActivity> create(a<zendesk.support.requestlist.RequestListPresenter> a, a<zendesk.support.requestlist.RequestListView> a2, a<zendesk.support.requestlist.RequestListModel> a3, a<ActionHandlerRegistry> a4, a<zendesk.support.requestlist.RequestListSyncHandler> a5) {
        super(a, a2, a3, a4, a5);
        return requestListActivity_MembersInjector;
    }

    public static void injectActionHandlerRegistry(zendesk.support.requestlist.RequestListActivity requestListActivity, ActionHandlerRegistry actionHandlerRegistry2) {
        requestListActivity.actionHandlerRegistry = actionHandlerRegistry2;
    }

    public static void injectModel(zendesk.support.requestlist.RequestListActivity requestListActivity, Object object2) {
        requestListActivity.model = (RequestListModel)object2;
    }

    public static void injectPresenter(zendesk.support.requestlist.RequestListActivity requestListActivity, Object object2) {
        requestListActivity.presenter = (RequestListPresenter)object2;
    }

    public static void injectSyncHandler(zendesk.support.requestlist.RequestListActivity requestListActivity, Object object2) {
        requestListActivity.syncHandler = (RequestListSyncHandler)object2;
    }

    public static void injectView(zendesk.support.requestlist.RequestListActivity requestListActivity, Object object2) {
        requestListActivity.view = (RequestListView)object2;
    }

    @Override // g.a
    public void injectMembers(Object object) {
        injectMembers((RequestListActivity)object);
    }

    @Override // g.a
    public void injectMembers(zendesk.support.requestlist.RequestListActivity requestListActivity) {
        RequestListActivity_MembersInjector.injectPresenter(requestListActivity, this.presenterProvider.get());
        RequestListActivity_MembersInjector.injectView(requestListActivity, this.viewProvider.get());
        RequestListActivity_MembersInjector.injectModel(requestListActivity, this.modelProvider.get());
        RequestListActivity_MembersInjector.injectActionHandlerRegistry(requestListActivity, (ActionHandlerRegistry)this.actionHandlerRegistryProvider.get());
        RequestListActivity_MembersInjector.injectSyncHandler(requestListActivity, this.syncHandlerProvider.get());
    }
}

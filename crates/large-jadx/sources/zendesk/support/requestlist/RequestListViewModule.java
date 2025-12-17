package zendesk.support.requestlist;

import com.squareup.picasso.t;

/* loaded from: classes3.dex */
public class RequestListViewModule {

    private final zendesk.support.requestlist.RequestListActivity activity;
    private final zendesk.support.requestlist.RequestListConfiguration config;
    public RequestListViewModule(zendesk.support.requestlist.RequestListActivity requestListActivity, zendesk.support.requestlist.RequestListConfiguration requestListConfiguration2) {
        super();
        this.activity = requestListActivity;
        this.config = requestListConfiguration2;
    }

    zendesk.support.requestlist.RequestListView view(t t) {
        RequestListView requestListView = new RequestListView(this.activity, this.config, t);
        return requestListView;
    }
}

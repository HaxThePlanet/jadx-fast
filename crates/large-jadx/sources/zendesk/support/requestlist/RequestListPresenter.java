package zendesk.support.requestlist;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import com.zendesk.service.a;
import com.zendesk.service.e;
import com.zendesk.service.f;
import java.util.List;
import zendesk.support.SupportSdkSettings;
import zendesk.support.request.RequestActivity;

/* loaded from: classes3.dex */
class RequestListPresenter {

    private final zendesk.support.requestlist.CancelableCompositeCallback callbacks;
    private final zendesk.support.requestlist.RequestListModel model;
    private zendesk.support.requestlist.RequestListView view;

    private interface SettingsCallback {
        public abstract void onSettings(SupportSdkSettings supportSdkSettings);
    }
    public RequestListPresenter(zendesk.support.requestlist.RequestListModel requestListModel) {
        super();
        CancelableCompositeCallback cancelableCompositeCallback = new CancelableCompositeCallback();
        this.callbacks = cancelableCompositeCallback;
        this.model = requestListModel;
    }

    static zendesk.support.requestlist.RequestListView access$000(zendesk.support.requestlist.RequestListPresenter requestListPresenter) {
        return requestListPresenter.view;
    }

    static void access$100(zendesk.support.requestlist.RequestListPresenter requestListPresenter, zendesk.support.requestlist.RequestListView requestListView2, boolean z3, String string4) {
        requestListPresenter.setupLogoView(requestListView2, z3, string4);
    }

    static zendesk.support.requestlist.RequestListModel access$200(zendesk.support.requestlist.RequestListPresenter requestListPresenter) {
        return requestListPresenter.model;
    }

    private void fetchSettingsFromNetwork(zendesk.support.requestlist.RequestListPresenter.SettingsCallback requestListPresenter$SettingsCallback) {
        RequestListPresenter.4 anon = new RequestListPresenter.4(this, settingsCallback);
        final e obj3 = e.a(anon);
        this.callbacks.add(obj3);
        this.view.setLoading(true);
        this.model.loadSettings(obj3);
    }

    private void loadSettings(zendesk.support.requestlist.RequestListPresenter.SettingsCallback requestListPresenter$SettingsCallback) {
        SupportSdkSettings cachedSettings = this.model.getCachedSettings();
        if (cachedSettings == null) {
            fetchSettingsFromNetwork(settingsCallback);
        } else {
            settingsCallback.onSettings(cachedSettings);
        }
    }

    private void setupCreateTicketClickListener() {
        RequestListPresenter.9 anon = new RequestListPresenter.9(this);
        this.view.setCreateRequestListener(anon);
    }

    private void setupErrorClickListener() {
        RequestListPresenter.6 anon = new RequestListPresenter.6(this);
        this.view.setRetryClickListener(anon);
    }

    private void setupItemClickListener() {
        RequestListPresenter.7 anon = new RequestListPresenter.7(this);
        this.view.setItemClickListener(anon);
    }

    private void setupLogoView(zendesk.support.requestlist.RequestListView requestListView, boolean z2, String string3) {
        RequestListPresenter.10 anon = new RequestListPresenter.10(this, requestListView, string3);
        requestListView.setLogoClickListener(z2, anon);
    }

    private void setupNavigationClickListener() {
        RequestListPresenter.5 anon = new RequestListPresenter.5(this);
        this.view.setBackClickListener(anon);
    }

    private void setupPullToRefreshListener() {
        RequestListPresenter.8 anon = new RequestListPresenter.8(this);
        this.view.setSwipeRefreshListener(anon);
    }

    void loadItems(boolean z, SupportSdkSettings supportSdkSettings2) {
        RequestListPresenter.3 anon = new RequestListPresenter.3(this);
        this.callbacks.add(e.a(anon));
        this.view.setLoading(true);
        this.model.loadItems(z, supportSdkSettings2, anon);
    }

    void onCreate(boolean z, zendesk.support.requestlist.RequestListView requestListView2) {
        this.view = requestListView2;
        setupItemClickListener();
        setupPullToRefreshListener();
        setupNavigationClickListener();
        setupErrorClickListener();
        setupCreateTicketClickListener();
        RequestListPresenter.1 obj2 = new RequestListPresenter.1(this, z);
        loadSettings(obj2);
    }

    void onDestroy(boolean z) {
        zendesk.support.requestlist.RequestListModel obj1;
        if (z == null) {
            this.model.cleanup();
        }
        this.view = 0;
        this.callbacks.cancel();
    }

    void refresh() {
        RequestListPresenter.2 anon = new RequestListPresenter.2(this);
        loadSettings(anon);
    }

    void showError(a a) {
        int i;
        zendesk.support.requestlist.RequestListView obj2;
        obj2 = this.view;
        if (obj2 != null) {
            obj2.setLoading(false);
            this.view.showErrorMessage();
        }
    }

    void showRequestList(List<zendesk.support.requestlist.RequestListItem> list) {
        zendesk.support.requestlist.RequestListView view;
        Object obj2;
        view = this.view;
        if (view != null) {
            view.showRequestList(list);
            this.view.setLoading(false);
        }
    }
}

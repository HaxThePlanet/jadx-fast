package zendesk.support.requestlist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import androidx.appcompat.app.d;
import androidx.fragment.app.e;
import f.g.c.a;
import f.g.d.k;
import o.a.c;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;
import zendesk.support.SdkDependencyProvider;

/* loaded from: classes3.dex */
public class RequestListActivity extends d {

    static final String LOG_TAG = "RequestListActivity";
    ActionHandlerRegistry actionHandlerRegistry;
    zendesk.support.requestlist.RequestListModel model;
    zendesk.support.requestlist.RequestListPresenter presenter;
    zendesk.support.requestlist.RequestListSyncHandler syncHandler;
    zendesk.support.requestlist.RequestListView view;
    public static zendesk.support.requestlist.RequestListConfiguration.Builder builder() {
        RequestListConfiguration.Builder builder = new RequestListConfiguration.Builder();
        return builder;
    }

    public static void refresh(Context context, ActionHandlerRegistry actionHandlerRegistry2) {
        String str;
        final ActionHandler obj2 = actionHandlerRegistry2.handlerByAction("request_list_refresh");
        if (obj2 != null) {
            obj2.handle(0, context);
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        getTheme().applyStyle(k.a, true);
        SdkDependencyProvider iNSTANCE = SdkDependencyProvider.INSTANCE;
        final String str3 = "RequestListActivity";
        final int i3 = 0;
        if (!iNSTANCE.isInitialized()) {
            a.e(str3, "Zendesk is not initialized or no identity was set. Make sure Zendesk.INSTANCE.init(...), Zendesk.INSTANCE.setIdentity(...), Support.INSTANCE.init(...) was called ", new Object[i3]);
            finish();
        }
        o.a.a aVar = c.e(getIntent().getExtras(), RequestListConfiguration.class);
        if ((RequestListConfiguration)aVar == null) {
            a.e(str3, "No configuration found. Please use RequestListActivity.builder()", new Object[i3]);
            finish();
        }
        iNSTANCE.provideRequestListComponent(this, (RequestListConfiguration)aVar).inject(this);
        setContentView(this.view);
        if (bundle == null) {
        } else {
            i = i3;
        }
        this.presenter.onCreate(i, this.view);
        this.actionHandlerRegistry.add(this.syncHandler);
    }

    @Override // androidx.appcompat.app.d
    protected void onDestroy() {
        zendesk.support.requestlist.RequestListSyncHandler changingConfigurations;
        super.onDestroy();
        ActionHandlerRegistry actionHandlerRegistry = this.actionHandlerRegistry;
        if (actionHandlerRegistry != null) {
            actionHandlerRegistry.remove(this.syncHandler);
        }
        zendesk.support.requestlist.RequestListPresenter presenter = this.presenter;
        if (presenter != null) {
            presenter.onDestroy(isChangingConfigurations());
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onPause() {
        super.onPause();
        this.syncHandler.setRunning(false);
    }

    @Override // androidx.appcompat.app.d
    protected void onResume() {
        super.onResume();
        this.syncHandler.setRunning(true);
    }

    @Override // androidx.appcompat.app.d
    protected void onStart() {
        super.onStart();
        this.view.onStart();
    }

    @Override // androidx.appcompat.app.d
    protected void onStop() {
        super.onStop();
        this.view.onStop();
    }
}

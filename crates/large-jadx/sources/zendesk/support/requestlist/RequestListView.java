package zendesk.support.requestlist;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.i;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.t;
import d.u.d;
import d.u.l;
import d.u.q;
import f.g.c.a;
import f.g.d.a;
import f.g.d.c;
import f.g.d.f;
import f.g.d.h;
import f.g.d.j;
import f.g.e.a;
import f.g.e.g;
import java.util.List;
import zendesk.support.UiUtils;
import zendesk.support.request.RequestConfiguration.Builder;
import zendesk.support.request.ViewAlmostRealProgressBar;

/* loaded from: classes3.dex */
class RequestListView extends FrameLayout {

    private static final String IS_SHOWING_SNACKBAR_KEY = "is_showing_snackbar";
    private static final String REQUEST_LIST_VIEW_SUPERSTATE_KEY = "request_list_view_superstate";
    private final d activity;
    private final zendesk.support.requestlist.RequestListAdapter adapter;
    private final zendesk.support.requestlist.RequestListConfiguration config;
    private final FloatingActionButton createTicketFab;
    private final l emptyScene;
    private final d fade;
    private boolean isLoading = false;
    private boolean isStopped = true;
    private zendesk.support.requestlist.RequestListView.OnItemClick itemClickListener = null;
    private final l listScene;
    private final View listSceneView;
    private final View logoImage;
    private final View logoImageEmpty;
    private final ViewAlmostRealProgressBar progressBar;
    private final RecyclerView recyclerView;
    private View.OnClickListener retryClickListener = null;
    private final ViewGroup rootLayout;
    private final ViewGroup sceneRoot;
    private zendesk.support.requestlist.RequestListView.SceneState sceneState;
    Snackbar snackbar;
    private final View startConversationButton;
    private final SwipeRefreshLayout swipeRefreshLayout;
    private final SwipeRefreshLayout swipeRefreshLayoutEmpty;
    private final Toolbar toolbar;

    interface OnItemClick {
        public abstract void onClick(zendesk.support.requestlist.RequestListItem requestListItem);
    }

    private static enum SceneState {

        LIST,
        EMPTY,
        NONE;
    }
    public RequestListView(d d, zendesk.support.requestlist.RequestListConfiguration requestListConfiguration2, t t3) {
        int obj8;
        int obj9;
        super(d);
        this.sceneState = RequestListView.SceneState.NONE;
        int i = 0;
        int i2 = 0;
        final int i3 = 1;
        d dVar = new d();
        this.fade = dVar;
        this.activity = d;
        this.config = requestListConfiguration2;
        setId(f.p0);
        FrameLayout.inflate(d, h.b, this);
        obj9 = findViewById(f.l0);
        this.sceneRoot = (ViewGroup)obj9;
        LayoutInflater from = LayoutInflater.from(d);
        View inflate2 = from.inflate(h.c, obj9, i2);
        this.listSceneView = inflate2;
        View inflate = from.inflate(h.d, obj9, i2);
        l lVar = new l(obj9, inflate2);
        this.listScene = lVar;
        l lVar2 = new l(obj9, inflate);
        this.emptyScene = lVar2;
        this.progressBar = (ViewAlmostRealProgressBar)findViewById(f.j0);
        this.toolbar = (Toolbar)findViewById(f.o0);
        this.rootLayout = (ViewGroup)findViewById(f.b0);
        obj9 = findViewById(f.c0);
        this.createTicketFab = (FloatingActionButton)obj9;
        this.logoImage = inflate2.findViewById(f.q0);
        View viewById4 = inflate2.findViewById(f.k0);
        this.recyclerView = (RecyclerView)viewById4;
        View viewById2 = inflate2.findViewById(f.m0);
        this.swipeRefreshLayout = (SwipeRefreshLayout)viewById2;
        this.startConversationButton = inflate.findViewById(f.d0);
        View viewById6 = inflate.findViewById(f.n0);
        this.swipeRefreshLayoutEmpty = (SwipeRefreshLayout)viewById6;
        this.logoImageEmpty = inflate.findViewById(f.r0);
        RequestListView.1 anon = new RequestListView.1(this);
        RequestListAdapter requestListAdapter = new RequestListAdapter(anon, t3);
        this.adapter = requestListAdapter;
        viewById4.setAdapter(requestListAdapter);
        viewById4.setNestedScrollingEnabled(i2);
        viewById4.setHasFixedSize(i3);
        LinearLayoutManager obj10 = new LinearLayoutManager(d, i3, i2);
        viewById4.setLayoutManager(obj10);
        obj10 = new i(d, i3);
        viewById4.h(obj10);
        obj8 = new g();
        viewById4.setItemAnimator(obj8);
        obj9.l();
        if (Build.VERSION.SDK_INT >= 21) {
            obj8 = findViewById(f.a0);
            (ViewGroup)obj8.getParent().removeView(obj8);
        }
        obj8 = UiUtils.themeAttributeToColor(a.a, getContext(), c.u);
        obj9 = new int[i3];
        obj9[i2] = obj8;
        viewById2.setColorSchemeColors(obj9);
        obj9 = new int[i3];
        obj9[i2] = obj8;
        viewById6.setColorSchemeColors(obj9);
    }

    static zendesk.support.requestlist.RequestListView.OnItemClick access$000(zendesk.support.requestlist.RequestListView requestListView) {
        return requestListView.itemClickListener;
    }

    private void dismissSnackbar() {
        Snackbar snackbar = this.snackbar;
        if (snackbar != null) {
            snackbar.u();
        }
        this.snackbar = 0;
    }

    private boolean isShowingSnackBar() {
        Snackbar snackbar;
        int i;
        snackbar = this.snackbar;
        if (snackbar != null && snackbar.J()) {
            i = snackbar.J() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.widget.FrameLayout
    public void announceAccessibility(int i) {
        announceForAccessibility(getResources().getString(i));
    }

    @Override // android.widget.FrameLayout
    public void finish() {
        boolean finishing;
        if (!this.activity.isFinishing()) {
            this.activity.finish();
        }
    }

    @Override // android.widget.FrameLayout
    public void finish(String string) {
        boolean arr;
        String str;
        if (g.c(string)) {
            a.b("RequestListActivity", string, new Object[0]);
        }
        finish();
    }

    @Override // android.widget.FrameLayout
    public void onRestoreInstanceState(Parcelable parcelable) {
        boolean boolean;
        String str;
        Object obj3;
        obj3 = parcelable.getParcelable("request_list_view_superstate");
        if (parcelable instanceof Bundle != null && (Bundle)parcelable.getBoolean("is_showing_snackbar")) {
            obj3 = parcelable.getParcelable("request_list_view_superstate");
            if ((Bundle)parcelable.getBoolean("is_showing_snackbar")) {
                showErrorMessage();
            }
        }
        super.onRestoreInstanceState(obj3);
    }

    @Override // android.widget.FrameLayout
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("request_list_view_superstate", super.onSaveInstanceState());
        bundle.putBoolean("is_showing_snackbar", isShowingSnackBar());
        return bundle;
    }

    @Override // android.widget.FrameLayout
    public void onStart() {
        this.isStopped = false;
    }

    @Override // android.widget.FrameLayout
    public void onStop() {
        this.isStopped = true;
        dismissSnackbar();
    }

    @Override // android.widget.FrameLayout
    public void setBackClickListener(View.OnClickListener view$OnClickListener) {
        this.toolbar.setNavigationOnClickListener(onClickListener);
    }

    @Override // android.widget.FrameLayout
    public void setCreateRequestListener(View.OnClickListener view$OnClickListener) {
        this.createTicketFab.setOnClickListener(onClickListener);
        this.startConversationButton.setOnClickListener(onClickListener);
    }

    @Override // android.widget.FrameLayout
    public void setItemClickListener(zendesk.support.requestlist.RequestListView.OnItemClick requestListView$OnItemClick) {
        this.itemClickListener = onItemClick;
    }

    @Override // android.widget.FrameLayout
    public void setLoading(boolean z) {
        boolean swipeRefreshLayoutEmpty;
        boolean z2;
        List dONT_STOP_MOVING;
        dismissSnackbar();
        if (this.isLoading != z) {
            if (z) {
                if (!this.swipeRefreshLayout.h() && !this.swipeRefreshLayoutEmpty.h()) {
                    if (!this.swipeRefreshLayoutEmpty.h()) {
                        announceAccessibility(j.V);
                        this.progressBar.start(ViewAlmostRealProgressBar.DONT_STOP_MOVING);
                    }
                }
            } else {
                if (!this.swipeRefreshLayout.h()) {
                    if (this.swipeRefreshLayoutEmpty.h()) {
                        dONT_STOP_MOVING = 0;
                        this.swipeRefreshLayout.setRefreshing(dONT_STOP_MOVING);
                        this.swipeRefreshLayoutEmpty.setRefreshing(dONT_STOP_MOVING);
                    } else {
                        this.progressBar.stop(300);
                    }
                } else {
                }
            }
        }
        this.isLoading = z;
    }

    @Override // android.widget.FrameLayout
    public void setLogoClickListener(boolean z, View.OnClickListener view$OnClickListener2) {
        int obj2;
        int obj3;
        if (z) {
            obj2 = 0;
        } else {
            obj2 = 4;
            obj3 = 0;
        }
        this.logoImage.setVisibility(obj2);
        this.logoImageEmpty.setVisibility(obj2);
        this.logoImage.setOnClickListener(obj3);
        this.logoImageEmpty.setOnClickListener(obj3);
    }

    @Override // android.widget.FrameLayout
    public void setRetryClickListener(View.OnClickListener view$OnClickListener) {
        this.retryClickListener = onClickListener;
    }

    @Override // android.widget.FrameLayout
    public void setSwipeRefreshListener(SwipeRefreshLayout.j swipeRefreshLayout$j) {
        this.swipeRefreshLayout.setOnRefreshListener(j);
        this.swipeRefreshLayoutEmpty.setOnRefreshListener(j);
    }

    @Override // android.widget.FrameLayout
    public void showErrorMessage() {
        boolean showingSnackBar;
        int i;
        View.OnClickListener retryClickListener;
        if (!this.isStopped && !isShowingSnackBar()) {
            if (!isShowingSnackBar()) {
                announceAccessibility(j.S);
                showingSnackBar = Snackbar.d0(this.rootLayout, j.l, -2);
                showingSnackBar.g0(j.y, this.retryClickListener);
                this.snackbar = showingSnackBar;
                showingSnackBar.T();
            }
        }
    }

    public void showRequestList(List<zendesk.support.requestlist.RequestListItem> list) {
        zendesk.support.requestlist.RequestListView.SceneState eMPTY;
        int fade;
        FloatingActionButton obj4;
        dismissSnackbar();
        fade = 300;
        this.progressBar.stop(fade);
        if (a.g(list)) {
            eMPTY = RequestListView.SceneState.EMPTY;
            if (this.sceneState != eMPTY) {
                this.createTicketFab.l();
                q.e(this.emptyScene, this.fade);
                announceAccessibility(j.U);
                this.sceneState = eMPTY;
            }
        } else {
            this.adapter.swapRequests(list);
            this.progressBar.stop(fade);
            eMPTY = RequestListView.SceneState.LIST;
            if (this.sceneState != eMPTY) {
                if (this.config.isContactUsButtonVisible()) {
                    this.createTicketFab.t();
                } else {
                    this.createTicketFab.l();
                }
                if (this.listSceneView.getParent() == null) {
                    q.e(this.listScene, this.fade);
                }
                announceAccessibility(j.T);
                this.sceneState = eMPTY;
            }
        }
    }

    @Override // android.widget.FrameLayout
    public void startReferrerPage(String string) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(string));
        this.activity.startActivity(intent);
    }

    @Override // android.widget.FrameLayout
    public void startRequestActivity(RequestConfiguration.Builder requestConfiguration$Builder) {
        builder.show(this.activity, this.config.getConfigurations());
    }
}

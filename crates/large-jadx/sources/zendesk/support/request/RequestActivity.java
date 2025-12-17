package zendesk.support.request;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.c.a;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.f;
import androidx.fragment.app.e;
import com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior;
import com.google.gson.JsonElement;
import com.squareup.picasso.t;
import f.g.c.a;
import f.g.d.f;
import f.g.d.h;
import f.g.d.j;
import f.g.d.k;
import java.util.Map;
import o.a.c;
import o.b.d;
import o.b.f;
import o.b.j;
import o.b.o;
import o.b.q;
import o.b.t;
import zendesk.belvedere.b;
import zendesk.core.ActionDescription;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;
import zendesk.support.SdkDependencyProvider;
import zendesk.support.SupportSdkComponent;

/* loaded from: classes3.dex */
public class RequestActivity extends d {

    static final boolean DEBUG = false;
    static final String LOG_TAG = "RequestActivity";
    private static final String SAVED_STATE = "saved_state";
    private zendesk.support.request.RequestAccessibilityHerald accessibilityHerald;
    ActionHandlerRegistry actionHandlerRegistry;
    zendesk.support.request.ActionFactory af;
    zendesk.support.request.HeadlessComponentListener headlessComponentListener;
    t picasso;
    private zendesk.support.request.RequestActivity.RefreshRequestActionHandler refreshActionHandler;
    private zendesk.support.request.RequestComponent requestComponent;
    private zendesk.support.request.ComponentRequestRouter requestRouter;
    q store;
    private t subscription;

    private final class RefreshRequestActionHandler implements ActionHandler {

        private final String requestId;
        final zendesk.support.request.RequestActivity this$0;
        RefreshRequestActionHandler(zendesk.support.request.RequestActivity requestActivity, String string2) {
            this.this$0 = requestActivity;
            super();
            this.requestId = string2;
        }

        @Override // zendesk.core.ActionHandler
        public boolean canHandle(String string) {
            boolean requestId;
            boolean obj2;
            if (string.contains("request_conversation_refresh") && string.contains(this.requestId)) {
                obj2 = string.contains(this.requestId) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // zendesk.core.ActionHandler
        public ActionDescription getActionDescription() {
            return null;
        }

        @Override // zendesk.core.ActionHandler
        public int getPriority() {
            return 0;
        }

        public void handle(Map<String, Object> map, Context context2) {
            zendesk.support.request.RequestActivity obj1 = this.this$0;
            obj1.store.c(obj1.af.updateCommentsAsync());
        }

        public void updateSettings(Map<String, JsonElement> map) {
        }
    }

    static class MoveUpWithSnackbarBehaviour extends AppBarLayout.ScrollingViewBehavior {
        @Override // com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            int obj1;
            if (!super.layoutDependsOn(coordinatorLayout, view2, view3)) {
                if (view3 instanceof Snackbar.SnackbarLayout) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
            return obj1;
        }

        @Override // com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view2, View view3) {
            boolean paddingTop;
            int paddingRight;
            boolean obj3;
            View obj5;
            obj3 = super.onDependentViewChanged(coordinatorLayout, view2, view3);
            if (view3 instanceof Snackbar.SnackbarLayout) {
                view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), view2.getPaddingRight(), (int)obj3);
                obj3 = 1;
            }
            return obj3;
        }
    }
    static void access$001(zendesk.support.request.RequestActivity requestActivity) {
        super.onBackPressed();
    }

    private t bindComponents(boolean z) {
        zendesk.support.request.ComponentToolbar bindToolbar = bindToolbar();
        this.requestRouter = ComponentRequestRouter.create(this, z, this.requestComponent);
        this.accessibilityHerald = RequestAccessibilityHerald.create(this);
        t[] arr = new t[4];
        return d.d(this.store.e(bindToolbar.getToolbarSelector(), bindToolbar), this.store.e(this.requestRouter.getSelector(), this.requestRouter), this.store.e(ComponentError.getSelector(), ComponentError.create(this, this.store, this.af)), this.store.d(this.accessibilityHerald));
    }

    private zendesk.support.request.ComponentToolbar bindToolbar() {
        int viewById;
        int i;
        View viewById2 = findViewById(f.k);
        setSupportActionBar((Toolbar)viewById2);
        RequestActivity.3 anon = new RequestActivity.3(this);
        viewById2.setNavigationOnClickListener(anon);
        if (Build.VERSION.SDK_INT >= 21) {
            findViewById(f.c).setVisibility(8);
        }
        ComponentToolbar componentToolbar = new ComponentToolbar(this.picasso, viewById2, (ViewAlmostRealProgressBar)findViewById(f.h));
        return componentToolbar;
    }

    public static zendesk.support.request.RequestConfiguration.Builder builder() {
        RequestConfiguration.Builder builder = new RequestConfiguration.Builder();
        return builder;
    }

    private void initViews() {
        RequestActivity.MoveUpWithSnackbarBehaviour moveUpWithSnackbarBehaviour = new RequestActivity.MoveUpWithSnackbarBehaviour();
        (CoordinatorLayout.f)findViewById(f.j).getLayoutParams().o(moveUpWithSnackbarBehaviour);
    }

    private boolean initializeStoreAndDependencies(Bundle bundle, zendesk.support.request.RequestConfiguration requestConfiguration2) {
        int obj1;
        boolean obj2;
        if (!injectDependencies(requestConfiguration2)) {
            obj1 = restoreState(bundle);
            if (obj1 != null) {
                this.store.b(obj1);
                obj1 = 0;
            } else {
                obj1 = 1;
            }
        } else {
        }
        return obj1;
    }

    private boolean injectDependencies(zendesk.support.request.RequestConfiguration requestConfiguration) {
        int i;
        zendesk.support.request.RequestComponent requestComponent;
        zendesk.support.request.RequestModule requestModule;
        Object obj4;
        Object data = HeadlessFragment.getData(getSupportFragmentManager());
        this.requestComponent = (RequestComponent)data;
        if (data == null) {
            i = 0;
            requestModule = new RequestModule(requestConfiguration);
            this.requestComponent = SdkDependencyProvider.INSTANCE.provideSupportSdkComponent().plus(requestModule);
            HeadlessFragment.install(getSupportFragmentManager(), this.requestComponent);
        } else {
            i = 1;
        }
        this.requestComponent.inject(this);
        return i;
    }

    private o restoreState(Bundle bundle) {
        String str;
        boolean key;
        int obj3;
        str = "saved_state";
        if (bundle != null && bundle.containsKey(str)) {
            str = "saved_state";
            if (bundle.containsKey(str)) {
                obj3 = bundle.getSerializable(str);
            } else {
                obj3 = 0;
            }
        } else {
        }
        return obj3;
    }

    @Override // androidx.appcompat.app.d
    public void onBackPressed() {
        zendesk.support.request.RequestView negativeButton;
        int i;
        zendesk.support.request.RequestActivity.1 anon;
        negativeButton = this.requestRouter.getCurrentScreen();
        if (negativeButton != null && negativeButton.hasUnsavedInput()) {
            if (negativeButton.hasUnsavedInput()) {
                c.a aVar = new c.a(this);
                aVar.m(j.h);
                aVar.e(j.e);
                RequestActivity.2 anon2 = new RequestActivity.2(this);
                anon = new RequestActivity.1(this);
                aVar.setPositiveButton(j.g, anon2).setNegativeButton(j.f, anon).o();
            } else {
                super.onBackPressed();
            }
        } else {
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        Object store;
        Object refreshRequestActionHandler;
        Object requestId;
        super.onCreate(bundle);
        getTheme().applyStyle(k.a, true);
        setContentView(h.a);
        b.b(this);
        initViews();
        int i3 = 0;
        String str3 = "RequestActivity";
        if (!SdkDependencyProvider.INSTANCE.isInitialized()) {
            a.e(str3, "Zendesk is not initialized or no identity was set. Make sure Zendesk.INSTANCE.init(...), Zendesk.INSTANCE.setIdentity(...), Support.INSTANCE.init(...) was called ", new Object[i3]);
            finish();
        }
        store = c.e(getIntent().getExtras(), RequestConfiguration.class);
        if ((RequestConfiguration)store == null) {
            a.e(str3, "No configuration found. Please use RequestActivity.builder()", new Object[i3]);
            finish();
        }
        refreshRequestActionHandler = new RequestActivity.RefreshRequestActionHandler(this, (RequestConfiguration)store.getRequestId());
        this.refreshActionHandler = refreshRequestActionHandler;
        boolean obj5 = initializeStoreAndDependencies(bundle, store);
        if (obj5 != null) {
            this.headlessComponentListener.startListening(this.store);
            this.store.c(this.af.installStartConfigAsync(store));
            this.store.c(this.af.loadSettingsAsync());
        }
        this.subscription = bindComponents(obj5);
    }

    @Override // androidx.appcompat.app.d
    public boolean onCreateOptionsMenu(Menu menu) {
        android.view.MenuInflater menuInflater;
        Menu obj3;
        zendesk.support.request.RequestView currentScreen = this.requestRouter.getCurrentScreen();
        if (currentScreen != null && currentScreen.inflateMenu(getMenuInflater(), menu)) {
            obj3 = currentScreen.inflateMenu(getMenuInflater(), menu) ? 1 : 0;
        } else {
        }
        return obj3;
    }

    @Override // androidx.appcompat.app.d
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        zendesk.support.request.RequestView currentScreen = this.requestRouter.getCurrentScreen();
        if (currentScreen != null) {
            return currentScreen.onOptionsItemClicked(menuItem);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.appcompat.app.d
    protected void onPause() {
        o.b.a refreshActionHandler;
        super.onPause();
        q store = this.store;
        if (store != null) {
            store.c(this.af.androidOnPause());
        }
        t subscription = this.subscription;
        if (subscription != null) {
            subscription.c();
        }
        ActionHandlerRegistry actionHandlerRegistry = this.actionHandlerRegistry;
        if (actionHandlerRegistry != null) {
            actionHandlerRegistry.remove(this.refreshActionHandler);
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onResume() {
        super.onResume();
        this.store.c(this.af.androidOnResume());
        this.subscription.b();
        this.subscription.a();
        this.actionHandlerRegistry.add(this.refreshActionHandler);
    }

    @Override // androidx.appcompat.app.d
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("saved_state", this.store.getState());
        super.onSaveInstanceState(bundle);
    }
}

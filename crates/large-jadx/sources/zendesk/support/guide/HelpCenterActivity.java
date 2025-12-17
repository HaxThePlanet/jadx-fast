package zendesk.support.guide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.a;
import androidx.appcompat.app.d;
import androidx.appcompat.app.f;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SearchView.l;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.fragment.app.n.o;
import androidx.fragment.app.w;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import f.g.b.a.e;
import f.g.b.a.f;
import f.g.b.a.g;
import f.g.b.a.h;
import f.g.b.a.i;
import f.g.c.a;
import f.g.e.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o.a.b;
import zendesk.core.ActionDescription;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.NetworkInfoProvider;
import zendesk.core.RetryAction;
import zendesk.messaging.Engine;
import zendesk.messaging.MessagingActivity;
import zendesk.messaging.MessagingConfiguration.Builder;
import zendesk.support.HelpCenterProvider;
import zendesk.support.HelpCenterSettingsProvider;
import zendesk.support.SearchArticle;

/* loaded from: classes3.dex */
public class HelpCenterActivity extends d implements zendesk.support.guide.HelpCenterMvp.View {

    static final String LOG_TAG = "HelpCenterActivity";
    ActionHandlerRegistry actionHandlerRegistry;
    b configurationHelper;
    private FloatingActionButton contactUsButton;
    private MenuItem conversationsMenuItem;
    private List<Engine> engines;
    private Snackbar errorSnackbar;
    private zendesk.support.guide.HelpCenterConfiguration helpCenterConfiguration;
    HelpCenterProvider helpCenterProvider;
    private View loadingView;
    NetworkInfoProvider networkInfoProvider;
    private zendesk.support.guide.HelpCenterMvp.Presenter presenter;
    private MenuItem searchViewMenuItem;
    HelpCenterSettingsProvider settingsProvider;
    private zendesk.support.guide.HelpCenterActivity.SnackbarStatus snackbarStatus;

    private static enum SnackbarStatus {

        NO_CONNECTION,
        NONE,
        CONTENT_ERROR;
    }
    public HelpCenterActivity() {
        super();
        this.snackbarStatus = HelpCenterActivity.SnackbarStatus.NONE;
    }

    static Fragment access$000(zendesk.support.guide.HelpCenterActivity helpCenterActivity) {
        return helpCenterActivity.getCurrentFragment();
    }

    static zendesk.support.guide.HelpCenterMvp.Presenter access$100(zendesk.support.guide.HelpCenterActivity helpCenterActivity) {
        return helpCenterActivity.presenter;
    }

    static Snackbar access$200(zendesk.support.guide.HelpCenterActivity helpCenterActivity) {
        return helpCenterActivity.errorSnackbar;
    }

    static zendesk.support.guide.HelpCenterActivity.SnackbarStatus access$302(zendesk.support.guide.HelpCenterActivity helpCenterActivity, zendesk.support.guide.HelpCenterActivity.SnackbarStatus helpCenterActivity$SnackbarStatus2) {
        helpCenterActivity.snackbarStatus = snackbarStatus2;
        return snackbarStatus2;
    }

    private void addFragment(Fragment fragment) {
        w wVar = getSupportFragmentManager().n();
        wVar.b(e.g, fragment, fragment.getClass().getSimpleName());
        wVar.g();
    }

    private void addOnBackStackChangedListener() {
        HelpCenterActivity.2 anon = new HelpCenterActivity.2(this);
        getSupportFragmentManager().i(anon);
    }

    public static zendesk.support.guide.HelpCenterConfiguration.Builder builder() {
        HelpCenterConfiguration.Builder builder = new HelpCenterConfiguration.Builder();
        return builder;
    }

    private Fragment getCurrentFragment() {
        return getSupportFragmentManager().j0(e.g);
    }

    private zendesk.support.guide.HelpSearchFragment getSearchFragment() {
        if (currentFragment instanceof HelpSearchFragment != null) {
            a.b("HelpCenterActivity", "showSearchResults: current fragment is a HelpSearchFragment", new Object[0]);
            return (HelpSearchFragment)getCurrentFragment();
        }
        zendesk.support.guide.HelpSearchFragment instance = HelpSearchFragment.newInstance(this.helpCenterConfiguration, this.helpCenterProvider);
        w wVar = getSupportFragmentManager().n();
        wVar.o(e.g, instance);
        wVar.f(0);
        wVar.g();
        return instance;
    }

    private a initToolbar() {
        int viewById;
        int i;
        if (Build.VERSION.SDK_INT >= 21) {
            findViewById(e.p).setVisibility(8);
        }
        setSupportActionBar((Toolbar)findViewById(e.q));
        return getSupportActionBar();
    }

    private boolean noFragmentAdded() {
        int i;
        i = getCurrentFragment() == null ? 1 : 0;
        return i;
    }

    private void showCreateRequest(Map<String, Object> map) {
        String localizedLabel;
        String str2;
        Object[] arr;
        String str;
        ActionHandler handlerByAction = this.actionHandlerRegistry.handlerByAction("action_contact_option");
        if (handlerByAction != null) {
            ActionDescription actionDescription = handlerByAction.getActionDescription();
            if (actionDescription != null) {
                localizedLabel = actionDescription.getLocalizedLabel();
            } else {
                localizedLabel = handlerByAction.getClass().getSimpleName();
            }
            arr = new Object[1];
            a.b("HelpCenterActivity", "No Deflection ActionHandler Available, opening %s", localizedLabel);
            handlerByAction.handle(map, this);
        }
    }

    @Override // androidx.appcompat.app.d
    public void announceContentLoaded() {
        this.contactUsButton.announceForAccessibility(getString(h.l));
    }

    @Override // androidx.appcompat.app.d
    public void clearSearchResults() {
        boolean currentFragment;
        if (currentFragment2 instanceof HelpSearchFragment != null) {
            (HelpSearchFragment)getCurrentFragment().clearResults();
        }
    }

    @Override // androidx.appcompat.app.d
    public void dismissError() {
        Snackbar errorSnackbar = this.errorSnackbar;
        if (errorSnackbar != null) {
            errorSnackbar.u();
        }
        this.snackbarStatus = HelpCenterActivity.SnackbarStatus.NONE;
    }

    @Override // androidx.appcompat.app.d
    public void exitActivity() {
        finish();
    }

    @Override // androidx.appcompat.app.d
    public Context getContext() {
        return getApplicationContext();
    }

    @Override // androidx.appcompat.app.d
    public void hideLoadingState() {
        this.loadingView.setVisibility(8);
    }

    @Override // androidx.appcompat.app.d
    public boolean isShowingHelp() {
        return currentFragment instanceof HelpCenterFragment;
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        int str;
        int obj6;
        super.onCreate(bundle);
        String str2 = "HelpCenterActivity";
        int i = 1;
        int i2 = 0;
        if (Build.VERSION.SDK_INT < 21 && !f.q()) {
            if (!f.q()) {
                a.b(str2, "Setting AppCompatDelegate.setCompatVectorFromResourcesEnabled() to true", new Object[i2]);
                f.C(i);
            }
        }
        obj6 = getTheme();
        obj6.applyStyle(i.a, i);
        obj6.applyStyle(i.b, i2);
        setContentView(f.a);
        obj6 = GuideSdkDependencyProvider.INSTANCE;
        if (!obj6.isInitialized()) {
            a.e(str2, "Zendesk is not initialized or no identity was set. Make sure Zendesk.INSTANCE.init(...), Zendesk.INSTANCE.setIdentity(...), Guide.INSTANCE.init(...) was called ", new Object[i2]);
            finish();
        }
        obj6.provideGuideSdkComponent().inject(this);
        obj6 = this.configurationHelper.f(getIntent().getExtras(), HelpCenterConfiguration.class);
        this.helpCenterConfiguration = (HelpCenterConfiguration)obj6;
        if (obj6 == null) {
            a.e(str2, "No configuration found. Please use HelpCenterActivity.builder()", new Object[i2]);
            finish();
        }
        this.engines = obj6.getEngines();
        initToolbar().s(i);
        this.loadingView = findViewById(e.m);
        obj6 = findViewById(e.d);
        this.contactUsButton = (FloatingActionButton)obj6;
        HelpCenterActivity.1 anon = new HelpCenterActivity.1(this);
        obj6.setOnClickListener(anon);
        HelpCenterModel helpCenterModel = new HelpCenterModel(this.helpCenterProvider, this.settingsProvider);
        obj6 = new HelpCenterPresenter(this, helpCenterModel, this.networkInfoProvider, this.actionHandlerRegistry);
        this.presenter = obj6;
        obj6.init(this.helpCenterConfiguration, this.engines);
        addOnBackStackChangedListener();
    }

    @Override // androidx.appcompat.app.d
    public boolean onCreateOptionsMenu(Menu menu) {
        int anon;
        int i;
        boolean obj3;
        getMenuInflater().inflate(g.a, menu);
        this.conversationsMenuItem = menu.findItem(e.h);
        obj3 = menu.findItem(e.i);
        this.searchViewMenuItem = obj3;
        if (obj3 != null && !this.networkInfoProvider.isNetworkAvailable()) {
            if (!this.networkInfoProvider.isNetworkAvailable()) {
                this.searchViewMenuItem.setEnabled(false);
            }
            obj3 = this.searchViewMenuItem.getActionView();
            obj3.setImeOptions(imeOptions |= i);
            anon = new HelpCenterActivity.3(this);
            obj3.setOnQueryTextListener(anon);
        }
        return 1;
    }

    @Override // androidx.appcompat.app.d
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int obj3 = menuItem.getItemId();
        final int i = 1;
        if (obj3 == 16908332) {
            onBackPressed();
            return i;
        }
        if (obj3 == e.h) {
            showRequestList();
            return i;
        }
        return 0;
    }

    @Override // androidx.appcompat.app.d
    protected void onPause() {
        super.onPause();
        final zendesk.support.guide.HelpCenterMvp.Presenter presenter = this.presenter;
        if (presenter != null) {
            presenter.onPause();
        }
    }

    @Override // androidx.appcompat.app.d
    public boolean onPrepareOptionsMenu(Menu menu) {
        zendesk.support.guide.HelpCenterMvp.Presenter showSearchMenuItem;
        zendesk.support.guide.HelpCenterMvp.Presenter conversationsMenuItem2;
        MenuItem searchViewMenuItem;
        int i;
        MenuItem conversationsMenuItem;
        boolean showConversationsMenuItem;
        showSearchMenuItem = this.presenter;
        searchViewMenuItem = this.searchViewMenuItem;
        if (showSearchMenuItem != null && searchViewMenuItem != null) {
            searchViewMenuItem = this.searchViewMenuItem;
            if (searchViewMenuItem != null) {
                searchViewMenuItem.setVisible(showSearchMenuItem.shouldShowSearchMenuItem());
            }
        }
        if (this.presenter != null && this.conversationsMenuItem != null) {
            if (this.conversationsMenuItem != null) {
                i = 0;
                conversationsMenuItem2 = this.actionHandlerRegistry.handlerByAction("action_conversation_list") != null ? searchViewMenuItem : i;
                if (this.presenter.shouldShowConversationsMenuItem() && conversationsMenuItem2 != 0) {
                    if (conversationsMenuItem2 != 0) {
                    } else {
                        searchViewMenuItem = i;
                    }
                } else {
                }
                this.conversationsMenuItem.setVisible(searchViewMenuItem);
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.appcompat.app.d
    protected void onResume() {
        super.onResume();
        final zendesk.support.guide.HelpCenterMvp.Presenter presenter = this.presenter;
        if (presenter != null) {
            presenter.onResume(this);
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onStart() {
        Object snackbarStatus;
        super.onStart();
        snackbarStatus = this.errorSnackbar;
        if (this.snackbarStatus != HelpCenterActivity.SnackbarStatus.NONE && snackbarStatus != null) {
            snackbarStatus = this.errorSnackbar;
            if (snackbarStatus != null) {
                snackbarStatus.T();
            }
        }
    }

    @Override // androidx.appcompat.app.d
    public void setSearchEnabled(boolean z) {
        this.searchViewMenuItem.setEnabled(z);
    }

    @Override // androidx.appcompat.app.d
    public void showContactUsButton() {
        this.contactUsButton.setVisibility(0);
    }

    @Override // androidx.appcompat.app.d
    public void showContactZendesk() {
        Object hashMap;
        List configurations;
        hashMap = new HashMap();
        this.configurationHelper.d(hashMap, this.helpCenterConfiguration);
        if (a.i(this.engines)) {
            hashMap = MessagingActivity.builder();
            hashMap.withEngines(this.engines);
            hashMap.show(this, this.helpCenterConfiguration.getConfigurations());
        } else {
            showCreateRequest(hashMap);
        }
    }

    @Override // androidx.appcompat.app.d
    public void showHelp(zendesk.support.guide.HelpCenterConfiguration helpCenterConfiguration) {
        zendesk.support.guide.HelpCenterMvp.Presenter noFragmentAdded;
        zendesk.support.guide.HelpCenterFragment obj2;
        if (noFragmentAdded()) {
            obj2 = HelpCenterFragment.newInstance(helpCenterConfiguration);
            obj2.setPresenter(this.presenter);
            addFragment(obj2);
        } else {
            if (obj2 instanceof HelpCenterFragment != null) {
                (HelpCenterFragment)getCurrentFragment().setPresenter(this.presenter);
            }
        }
        invalidateOptionsMenu();
    }

    @Override // androidx.appcompat.app.d
    public void showLoadArticleErrorWithRetry(zendesk.support.guide.HelpCenterMvp.ErrorType helpCenterMvp$ErrorType, RetryAction retryAction2) {
        int stringBuilder;
        zendesk.support.guide.HelpCenterActivity.SnackbarStatus snackbarStatus;
        String str2;
        Object nONE;
        int str;
        int i;
        String obj5;
        stringBuilder = 0;
        str2 = "HelpCenterActivity";
        if (errorType == null) {
            a.k(str2, "ErrorType was null, falling back to 'retry' as label", new Object[stringBuilder]);
            obj5 = getString(h.w);
        } else {
            str = HelpCenterActivity.5.$SwitchMap$zendesk$support$guide$HelpCenterMvp$ErrorType[errorType.ordinal()];
            if (str != 1) {
                if (str != 2) {
                    if (str != 3) {
                        a.k(str2, "Unknown or unhandled error type, falling back to error type name as label", new Object[stringBuilder]);
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(getString(h.d));
                        stringBuilder.append(" ");
                        stringBuilder.append(errorType.name());
                        obj5 = stringBuilder.toString();
                    } else {
                        obj5 = getString(h.b);
                    }
                } else {
                    obj5 = getString(h.g);
                }
            } else {
                obj5 = getString(h.c);
            }
        }
        if (this.snackbarStatus == HelpCenterActivity.SnackbarStatus.NONE) {
            obj5 = Snackbar.e0(this.contactUsButton, obj5, -2);
            this.errorSnackbar = obj5;
            nONE = new HelpCenterActivity.4(this, retryAction2);
            obj5.g0(h.w, nONE);
            this.errorSnackbar.T();
            this.snackbarStatus = HelpCenterActivity.SnackbarStatus.CONTENT_ERROR;
        }
    }

    @Override // androidx.appcompat.app.d
    public void showLoadingState() {
        Fragment currentFragment;
        Fragment currentFragment2;
        currentFragment = getCurrentFragment();
        if (currentFragment != null && currentFragment.isVisible()) {
            if (currentFragment.isVisible()) {
                currentFragment = getSupportFragmentManager().n();
                currentFragment.m(getCurrentFragment());
                currentFragment.g();
            }
        }
        this.loadingView.setVisibility(0);
    }

    @Override // androidx.appcompat.app.d
    public void showNoConnectionError() {
        Object snackbarStatus;
        int i;
        int i2;
        final zendesk.support.guide.HelpCenterActivity.SnackbarStatus nO_CONNECTION = HelpCenterActivity.SnackbarStatus.NO_CONNECTION;
        if (this.snackbarStatus != nO_CONNECTION) {
            snackbarStatus = Snackbar.d0(this.contactUsButton, h.k, -2);
            this.errorSnackbar = snackbarStatus;
            snackbarStatus.T();
            this.snackbarStatus = nO_CONNECTION;
        }
    }

    @Override // androidx.appcompat.app.d
    public void showRequestList() {
        Object hashMap;
        b configurationHelper;
        zendesk.support.guide.HelpCenterConfiguration helpCenterConfiguration;
        ActionHandler handlerByAction = this.actionHandlerRegistry.handlerByAction("action_conversation_list");
        if (handlerByAction != null) {
            hashMap = new HashMap();
            this.configurationHelper.d(hashMap, this.helpCenterConfiguration);
            handlerByAction.handle(hashMap, this);
        }
    }

    public void showSearchResults(List<SearchArticle> list, String string2) {
        getSearchFragment().updateResults(list, string2);
    }
}

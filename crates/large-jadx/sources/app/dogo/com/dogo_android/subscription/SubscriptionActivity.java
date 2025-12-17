package app.dogo.com.dogo_android.subscription;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.d;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.util.t;
import app.dogo.com.dogo_android.util.t.a;
import app.dogo.com.dogo_android.y.j;
import f.c.a.f.a.d.a;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.y.p;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0008\u0010\u0011\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u000e2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\u00088BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000b\u0010\u000c\u001a\u0004\u0008\t\u0010\n¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/subscription/SubscriptionActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "screenKey", "Lapp/dogo/com/dogo_android/subscription/SubscriptionScreenKey;", "getScreenKey", "()Lapp/dogo/com/dogo_android/subscription/SubscriptionScreenKey;", "viewModel", "Lapp/dogo/com/dogo_android/subscription/LegacySubscriptionSharedViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/subscription/LegacySubscriptionSharedViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SubscriptionActivity extends d {

    private final h viewModel$delegate;
    static {
    }

    public SubscriptionActivity() {
        super();
        final int i = 0;
        SubscriptionActivity.special$$inlined.viewModel.default.1 anon = new SubscriptionActivity.special$$inlined.viewModel.default.1(this, i, i);
        this.viewModel$delegate = j.a(m.SYNCHRONIZED, anon);
    }

    private final app.dogo.com.dogo_android.subscription.LegacySubscriptionSharedViewModel getViewModel() {
        return (LegacySubscriptionSharedViewModel)this.viewModel$delegate.getValue();
    }

    public static void i(app.dogo.com.dogo_android.subscription.SubscriptionActivity subscriptionActivity) {
        SubscriptionActivity.onCreate$lambda-0(subscriptionActivity);
    }

    private static final void onCreate$lambda-0(app.dogo.com.dogo_android.subscription.SubscriptionActivity subscriptionActivity) {
        Object tag;
        int statusBarColor;
        int intValue2;
        int i;
        j jVar;
        Window intValue;
        Window window;
        int intValue3;
        int obj6;
        n.f(subscriptionActivity, "this$0");
        java.util.List list = subscriptionActivity.getSupportFragmentManager().v0();
        n.e(list, "supportFragmentManager.fragments");
        tag = p.l0(list);
        if ((Fragment)tag == null) {
            i = statusBarColor;
        } else {
            i = k1.b((Fragment)tag);
        }
        if (tag == null) {
        } else {
            jVar = k1.b(tag);
            if (jVar == null) {
            } else {
                statusBarColor = jVar.getStatusBarColor();
            }
        }
        final int i4 = 67108864;
        if (statusBarColor == 0) {
            subscriptionActivity.getWindow().clearFlags(i4);
        } else {
            if (statusBarColor.intValue() != 2131100375) {
            } else {
                subscriptionActivity.getWindow().addFlags(i4);
            }
        }
        if (statusBarColor != 0 && statusBarColor.intValue() != 0) {
            if (statusBarColor.intValue() != 0) {
                subscriptionActivity.getWindow().setStatusBarColor(subscriptionActivity.getColor(statusBarColor.intValue()));
            } else {
                subscriptionActivity.getWindow().setStatusBarColor(subscriptionActivity.getColor(2131100379));
            }
        } else {
        }
        if (!tag instanceof t) {
            obj6 = "Fragment not defined";
            if (i == 0) {
            } else {
                tag = i.getTag();
                if (tag == null) {
                } else {
                    obj6 = tag;
                }
            }
            a.f(n.o("Fragment attached ", obj6), new Object[0]);
        }
    }

    @Override // androidx.appcompat.app.d
    public void _$_clearFindViewByIdCache() {
    }

    @Override // androidx.appcompat.app.d
    protected void attachBaseContext(Context context) {
        n.f(context, "newBase");
        t.a companion = t.Companion;
        final Context obj4 = companion.b(context, n2.b(App.Companion.l().W()));
        super.attachBaseContext(obj4);
        android.content.res.Resources resources = getResources();
        n.e(resources, "resources");
        companion.c(resources, obj4);
        a.b(this);
    }

    @Override // androidx.appcompat.app.d
    public final app.dogo.com.dogo_android.subscription.SubscriptionScreenKey getScreenKey() {
        return (SubscriptionScreenKey)g1.l(this);
    }

    @Override // androidx.appcompat.app.d
    public void onBackPressed() {
        setResult(-1, getIntent());
        finish();
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558434);
        findViewById(2131362866).setVisibility(8);
        g1.n(this, getViewModel().getSubscriptionAppScreen(getScreenKey().getViewSource(), "", getScreenKey().getPreloadedOffer()));
        j jVar = new j(this);
        getSupportFragmentManager().i(jVar);
    }
}

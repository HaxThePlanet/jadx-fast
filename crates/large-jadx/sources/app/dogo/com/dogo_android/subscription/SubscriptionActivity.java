package app.dogo.com.dogo_android.subscription;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.d;
import androidx.fragment.app.e;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.util.t;
import app.dogo.com.dogo_android.util.t.a;
import kotlin.Metadata;
import kotlin.h;
import kotlin.m;
import kotlin.y.p;

/* compiled from: SubscriptionActivity.kt */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0008\u0010\u0011\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\u000e2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\u00088BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000b\u0010\u000c\u001a\u0004\u0008\t\u0010\n¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/subscription/SubscriptionActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "screenKey", "Lapp/dogo/com/dogo_android/subscription/SubscriptionScreenKey;", "getScreenKey", "()Lapp/dogo/com/dogo_android/subscription/SubscriptionScreenKey;", "viewModel", "Lapp/dogo/com/dogo_android/subscription/LegacySubscriptionSharedViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/subscription/LegacySubscriptionSharedViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SubscriptionActivity extends d {

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final h viewModel;
    public SubscriptionActivity() {
        super();
        final m.a.c.j.a aVar = null;
        this.viewModel = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new SubscriptionActivity.special$$inlined.viewModel.default.AnonymousClass1(this, aVar, aVar));
    }

    private final LegacySubscriptionSharedViewModel getViewModel() {
        return (LegacySubscriptionSharedViewModel)this.viewModel.getValue();
    }

    private static final void onCreate$lambda_0(SubscriptionActivity subscriptionActivity) {
        int i = 0;
        Window window;
        int value2;
        String tag;
        n.f(subscriptionActivity, "this$0");
        java.util.List list = subscriptionActivity.getSupportFragmentManager().v0();
        n.e(list, "supportFragmentManager.fragments");
        Object obj = p.l0(list);
        i = 0;
        if (obj == null) {
        } else {
            app.dogo.com.dogo_android.y.j jVar2 = app.dogo.com.dogo_android.util.extensionfunction.k1.b(obj);
        }
        if (obj != null) {
            app.dogo.com.dogo_android.y.j jVar = app.dogo.com.dogo_android.util.extensionfunction.k1.b(obj);
            if (jVar != null) {
                Integer statusBarColor = jVar.getStatusBarColor();
            }
        }
        final int i5 = 67108864;
        if ("supportFragmentManager.fragments" == 0) {
            subscriptionActivity.getWindow().clearFlags(i5);
        } else {
            if (i.intValue() == R.color.transparent) {
                subscriptionActivity.getWindow().addFlags(i5);
            }
        }
        if ("supportFragmentManager.fragments" == 0 || "supportFragmentManager.fragments".intValue() == 0) {
            subscriptionActivity.getWindow().setStatusBarColor(subscriptionActivity.getColor(2131100379));
        } else {
            subscriptionActivity.getWindow().setStatusBarColor(subscriptionActivity.getColor(i.intValue()));
        }
        z = obj instanceof t;
        if (!(obj instanceof t) && i == 0) {
            a.f(n.o("Fragment attached ", tag), new Object[0]);
        }
    }

    @Override // androidx.appcompat.app.d
    protected void attachBaseContext(Context context) {
        n.f(context, "newBase");
        t.a iNSTANCE2 = MyContextWrapper.INSTANCE;
        final Context resources2 = iNSTANCE2.updateResources(context, LocaleService.getLanguageFromLocaleString(App.INSTANCE.l().W()));
        super.attachBaseContext(resources2);
        android.content.res.Resources resources = getResources();
        n.e(resources, "resources");
        iNSTANCE2.updateResourcesUpTo25Api(resources, resources2);
        a.b(this);
    }

    @Override // androidx.appcompat.app.d
    public final SubscriptionScreenKey getScreenKey() {
        return (SubscriptionScreenKey)app.dogo.com.dogo_android.util.extensionfunction.g1.l(this);
    }

    @Override // androidx.appcompat.app.d
    public void onBackPressed() {
        setResult(-1, getIntent());
        finish();
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(2131558434);
        findViewById(2131362866).setVisibility(8);
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(this, getViewModel().getSubscriptionAppScreen(getScreenKey().getViewSource(), "", getScreenKey().getPreloadedOffer()));
        getSupportFragmentManager().i(new j(this));
    }


    /* renamed from: i, reason: from kotlin metadata */
    public static /* synthetic */ void attachBaseContext(SubscriptionActivity newBase) {
        SubscriptionActivity.onCreate$lambda_0(newBase);
    }

    @Override // androidx.appcompat.app.d
    public void _$_clearFindViewByIdCache() {
    }
}

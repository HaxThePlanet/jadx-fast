package app.dogo.com.dogo_android.welcome_v2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.d;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.q;
import app.dogo.com.dogo_android.k.k;
import app.dogo.com.dogo_android.k.k.a;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.subscription.SubscriptionScreenKey;
import app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsScreen;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.p1;
import app.dogo.com.dogo_android.util.m0.a;
import app.dogo.com.dogo_android.util.t;
import app.dogo.com.dogo_android.util.t.a;
import app.dogo.com.dogo_android.welcome_v2.w0.j;
import app.dogo.com.dogo_android.y.j;
import f.c.a.f.a.d.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.k0.l;
import kotlin.m;
import kotlin.w;
import kotlin.y.p;
import m.a.b.a.d.a.b;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010\u0012\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0012\u0010\u0016\u001a\u00020\u000c2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0018\u0010\u001a\u001a\u00020\u000c2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001d\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001e\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u001f\u001a\u00020\u000c2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/ActivityWelcomeScreenV2Binding;", "sharedViewModel", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "goToEntryCommentFragmentAndRemoveStreamExtra", "intent", "Landroid/content/Intent;", "navigateDeeplinkIfDetected", "appScreens", "", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "openDeeplinkDestination", "linkType", "Lapp/dogo/com/dogo_android/enums/LinkTypes;", "parseDestinationFromLaunchIntent", "saveCodeAndStay", "tryToLoginAndParseDeeplinkDestination", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class OnboardingActivity extends d {

    private final h a;
    private q b;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[k.CHALLENGE_SHARE.ordinal()] = 1;
            iArr[k.UNKNOWN.ordinal()] = 2;
            OnboardingActivity.a.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<app.dogo.com.dogo_android.welcome_v2.p0> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.welcome_v2.p0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(p0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<w> {

        final Intent $intent;
        final k $linkType;
        final app.dogo.com.dogo_android.welcome_v2.OnboardingActivity this$0;
        c(app.dogo.com.dogo_android.welcome_v2.OnboardingActivity onboardingActivity, k k2, Intent intent3) {
            this.this$0 = onboardingActivity;
            this.$linkType = k2;
            this.$intent = intent3;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            OnboardingActivity.i(this.this$0, this.$linkType, this.$intent);
        }
    }
    static {
    }

    public OnboardingActivity() {
        super();
        final int i = 0;
        OnboardingActivity.b bVar = new OnboardingActivity.b(this, i, i);
        this.a = j.a(m.SYNCHRONIZED, bVar);
    }

    public static final void i(app.dogo.com.dogo_android.welcome_v2.OnboardingActivity onboardingActivity, k k2, Intent intent3) {
        onboardingActivity.t(k2, intent3);
    }

    private final app.dogo.com.dogo_android.welcome_v2.p0 j() {
        return (p0)this.a.getValue();
    }

    private final void k(Intent intent) {
        String obj4;
        String str = "android.intent.extra.STREAM";
        android.os.Parcelable parcelableExtra = intent.getParcelableExtra(str);
        intent.removeExtra(str);
        if ((Uri)parcelableExtra == null) {
            obj4 = 0;
        } else {
            obj4 = (Uri)parcelableExtra.getQueryParameter("entryId");
        }
        if (obj4 == null) {
        }
        String queryParameter = parcelableExtra.getQueryParameter("challengeId");
        if (queryParameter == null) {
        }
        String queryParameter2 = parcelableExtra.getQueryParameter("linkType");
        if (queryParameter2 == null) {
        }
        j jVar = new j(obj4, queryParameter, queryParameter2);
        g1.n(this, jVar);
    }

    public static void l(app.dogo.com.dogo_android.welcome_v2.OnboardingActivity onboardingActivity, y y2) {
        OnboardingActivity.p(onboardingActivity, y2);
    }

    public static void m(app.dogo.com.dogo_android.welcome_v2.OnboardingActivity onboardingActivity, y y2) {
        OnboardingActivity.o(onboardingActivity, y2);
    }

    private final void n(List<? extends j> list) {
        boolean i4;
        SubscriptionScreenKey subscriptionScreenKey;
        String str;
        int i2;
        int i3;
        int i;
        int i5;
        Object obj8;
        obj8 = p.Z(list);
        if (obj8 instanceof SubscriptionBenefitsScreen) {
            if (z ^= 1 != 0) {
                j().v(obj8.getCoupon());
            } else {
                super("onboarding", 0, 0, 6, 0);
                startActivity(obj8.buildIntent(this));
            }
        }
    }

    private static final void o(app.dogo.com.dogo_android.welcome_v2.OnboardingActivity onboardingActivity, y y2) {
        boolean finishing;
        String str;
        Object obj3;
        n.f(onboardingActivity, "this$0");
        if (y2 instanceof y.c && !onboardingActivity.isFinishing()) {
            if (!onboardingActivity.isFinishing()) {
                finishing = onboardingActivity.getIntent();
                n.e(finishing, "intent");
                onboardingActivity.q((k)(y.c)y2.a(), finishing);
            }
        }
    }

    private static final void p(app.dogo.com.dogo_android.welcome_v2.OnboardingActivity onboardingActivity, y y2) {
        Object str2;
        String str;
        int i3;
        int i;
        int i4;
        int i2;
        boolean obj7;
        n.f(onboardingActivity, "this$0");
        if (y2 instanceof y.c && !onboardingActivity.isFinishing()) {
            if (!onboardingActivity.isFinishing()) {
                super("onboarding", 0, 0, 6, 0);
                onboardingActivity.startActivity(obj7.buildIntent(onboardingActivity));
            }
        }
    }

    private final void q(k k, Intent intent2) {
        android.os.Parcelable parcelableExtra;
        List list;
        int queryParameter;
        int queryParameter2;
        String obj5;
        Object obj6;
        obj5 = OnboardingActivity.a.a[k.ordinal()];
        if (obj5 != 1) {
            if (obj5 != 2) {
                a.c("openDeeplinkDestination failed", new Object[0]);
            } else {
                obj5 = "android.intent.extra.STREAM";
                parcelableExtra = intent2.getParcelableExtra(obj5);
                list = 0;
                if ((Uri)parcelableExtra == null) {
                    queryParameter = list;
                } else {
                    queryParameter = (Uri)parcelableExtra.getQueryParameter("linkType");
                }
                if (parcelableExtra == null) {
                    queryParameter2 = list;
                } else {
                    queryParameter2 = parcelableExtra.getQueryParameter("partner");
                }
                if (queryParameter != 0 && queryParameter2 != 0) {
                    if (queryParameter2 != 0) {
                        s(intent2);
                        intent2.removeExtra(obj5);
                    }
                }
                if (parcelableExtra == null) {
                } else {
                    list = p1.a(parcelableExtra);
                }
                if (list == null) {
                    list = p.g();
                }
                n(list);
            }
        } else {
            if (!j().x()) {
                k(intent2);
            }
        }
    }

    private final void r(Intent intent) {
        android.os.Parcelable parcelableExtra;
        String queryParameter2;
        String queryParameter;
        parcelableExtra = intent.getParcelableExtra("android.intent.extra.STREAM");
        if ((Uri)parcelableExtra == null) {
            queryParameter = queryParameter2;
        } else {
            queryParameter = (Uri)parcelableExtra.getQueryParameter("linkType");
        }
        if (parcelableExtra == null) {
        } else {
            queryParameter2 = parcelableExtra.getQueryParameter("utm_campaign");
        }
        if (queryParameter == null) {
            queryParameter = queryParameter2;
        }
        k kVar = k.Companion.a(queryParameter);
        if (parcelableExtra != null) {
            if (j().q()) {
                q(kVar, intent);
            } else {
                t(kVar, intent);
            }
        }
    }

    private final void s(Intent intent) {
        final android.os.Parcelable obj2 = intent.getParcelableExtra("android.intent.extra.STREAM");
        if ((Uri)obj2 == null) {
        }
        j().u((Uri)obj2);
    }

    private final void t(k k, Intent intent2) {
        boolean cVar;
        Object obj3;
        if (j().p()) {
            j().t(k);
        } else {
            cVar = new OnboardingActivity.c(this, k, intent2);
            f1.h0(this, cVar);
        }
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
    protected void onCreate(Bundle bundle) {
        int obj3;
        super.onCreate(bundle);
        obj3 = getWindow();
        obj3.clearFlags(67108864);
        obj3.addFlags(Integer.MIN_VALUE);
        obj3.getDecorView().setSystemUiVisibility(1024);
        obj3.setStatusBarColor(0);
        obj3 = f.g(this, 2131558436);
        n.e(obj3, "setContentView(this, R.layout.activity_welcome_screen_v2)");
        this.b = (q)obj3;
        int i4 = 0;
        String str3 = "binding";
        if (obj3 == null) {
        } else {
            obj3.M(this);
            obj3 = this.b;
            if (obj3 == null) {
            } else {
                obj3.T(j());
                overridePendingTransition(17432576, 17432577);
                f fVar = new f(this);
                j().n().observe(this, fVar);
                e eVar = new e(this);
                j().o().observe(this, eVar);
                if (getSupportFragmentManager().p0() == 0) {
                    obj3 = new r0();
                    g1.o(this, obj3);
                }
                obj3 = getIntent();
                n.e(obj3, "intent");
                r(obj3);
            }
            n.w(str3);
            throw i4;
        }
        n.w(str3);
        throw i4;
    }

    @Override // androidx.appcompat.app.d
    protected void onNewIntent(Intent intent) {
        n.f(intent, "intent");
        super.onNewIntent(intent);
        r(intent);
    }
}

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
import app.dogo.com.dogo_android.util.t;
import app.dogo.com.dogo_android.util.t.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.h;
import kotlin.k0.l;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.b;

/* compiled from: OnboardingActivity.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010\u0012\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0012\u0010\u0016\u001a\u00020\u000c2\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0018\u0010\u001a\u001a\u00020\u000c2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001d\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001e\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u001f\u001a\u00020\u000c2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/ActivityWelcomeScreenV2Binding;", "sharedViewModel", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "goToEntryCommentFragmentAndRemoveStreamExtra", "intent", "Landroid/content/Intent;", "navigateDeeplinkIfDetected", "appScreens", "", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "openDeeplinkDestination", "linkType", "Lapp/dogo/com/dogo_android/enums/LinkTypes;", "parseDestinationFromLaunchIntent", "saveCodeAndStay", "tryToLoginAndParseDeeplinkDestination", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class OnboardingActivity extends d {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private q b;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[LinkTypes.values().length];
            iArr[LinkTypes.CHALLENGE_SHARE.ordinal()] = 1;
            iArr[LinkTypes.UNKNOWN.ordinal()] = 2;
            kotlinx.coroutines.OnboardingActivity.a.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.d0.d.p implements kotlin.d0.c.a<p0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final p0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(OnboardingSharedViewModel.class), this.$parameters);
        }

        public b(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements kotlin.d0.c.a<w> {

        final /* synthetic */ Intent $intent;
        final /* synthetic */ k $linkType;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            OnboardingActivity.this.t(this.$linkType, this.$intent);
        }

        c(k kVar, Intent intent) {
            this.$linkType = kVar;
            this.$intent = intent;
            super(0);
        }
    }
    public OnboardingActivity() {
        super();
        final m.a.c.j.a aVar = null;
        this.binding = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.OnboardingActivity.b(this, aVar, aVar));
    }

    public static final /* synthetic */ void i(OnboardingActivity onboardingActivity, k kVar, Intent intent) {
        onboardingActivity.t(kVar, intent);
    }

    private final p0 j() {
        return (OnboardingSharedViewModel)this.binding.getValue();
    }

    /* renamed from: k, reason: from kotlin metadata */
    private final void attachBaseContext(Intent newBase) {
        String queryParameter = null;
        String str = "android.intent.extra.STREAM";
        android.os.Parcelable parcelableExtra = newBase.getParcelableExtra(str);
        newBase.removeExtra(str);
        if (parcelableExtra == null) {
            int i = 0;
        } else {
            queryParameter = parcelableExtra.getQueryParameter("entryId");
        }
        if (queryParameter == null) {
            return;
        }
        String queryParameter2 = parcelableExtra.getQueryParameter("challengeId");
        if (queryParameter2 == null) {
            return;
        }
        String queryParameter3 = parcelableExtra.getQueryParameter("linkType");
        if (queryParameter3 == null) {
            return;
        }
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(this, new OnboardingChallengeEntryScreen(queryParameter, queryParameter2, queryParameter3));
    }

    /* renamed from: n, reason: from kotlin metadata */
    private final void goToEntryCommentFragmentAndRemoveStreamExtra(List<? extends app.dogo.com.dogo_android.y.j> intent) {
        Object obj = p.Z(intent);
        z = obj instanceof SubscriptionBenefitsScreen;
        if (obj instanceof SubscriptionBenefitsScreen) {
            if (!l.z(obj.getCoupon()) != 0) {
                j().v(obj.getCoupon());
            } else {
                app.dogo.com.dogo_android.repository.domain.SubscriptionOffer subscriptionOffer = null;
                String str2 = null;
                int i = 6;
                kotlin.d0.d.g gVar = null;
                str = "onboarding";
                SubscriptionScreenKey intent2 = new SubscriptionScreenKey(str, subscriptionOffer, str2, i, gVar);
                startActivity(intent2.buildIntent(this));
            }
        }
    }

    private static final void o(OnboardingActivity onboardingActivity, y yVar) {
        n.f(onboardingActivity, "this$0");
        finishing = yVar instanceof LoadResult_Success;
        if (yVar instanceof oadResult_Success && !onboardingActivity.isFinishing()) {
            Intent intent = onboardingActivity.getIntent();
            str = "intent";
            n.e(intent, str);
            onboardingActivity.q((LinkTypes)yVar.component1(), intent);
        }
    }

    private static final void p(OnboardingActivity onboardingActivity, y yVar) {
        str = "this$0";
        n.f(onboardingActivity, str);
        finishing = yVar instanceof LoadResult_Success;
        if (yVar instanceof oadResult_Success && !onboardingActivity.isFinishing()) {
            app.dogo.com.dogo_android.repository.domain.SubscriptionOffer subscriptionOffer = null;
            String str3 = null;
            int i = 6;
            kotlin.d0.d.g gVar = null;
            str2 = "onboarding";
            SubscriptionScreenKey yVar22 = new SubscriptionScreenKey(str2, subscriptionOffer, str3, i, gVar);
            onboardingActivity.startActivity(yVar22.buildIntent(onboardingActivity));
        }
    }

    private final void q(k kVar, Intent intent) {
        List emptyProgramSaveInfo = null;
        int i;
        int i4 = kotlinx.coroutines.OnboardingActivity.a.a[kVar.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                str2 = "openDeeplinkDestination failed";
                a.c(str2, new Object[0]);
            } else {
                str = "android.intent.extra.STREAM";
                android.os.Parcelable parcelableExtra = intent.getParcelableExtra(str);
                i = 0;
                if (parcelableExtra == null) {
                } else {
                    String queryParameter = parcelableExtra.getQueryParameter("linkType");
                }
                if (parcelableExtra == null) {
                } else {
                    String queryParameter2 = parcelableExtra.getQueryParameter("partner");
                }
                if (i != 0 && i != 0) {
                    onCreate(intent);
                    intent.removeExtra("android.intent.extra.STREAM");
                }
                if (parcelableExtra != null) {
                    emptyProgramSaveInfo = app.dogo.com.dogo_android.util.extensionfunction.p1.getEmptyProgramSaveInfo(parcelableExtra);
                }
                if (emptyProgramSaveInfo == null) {
                    emptyProgramSaveInfo = p.g();
                }
                goToEntryCommentFragmentAndRemoveStreamExtra(emptyProgramSaveInfo);
            }
        } else {
            if (!j().x()) {
                attachBaseContext(intent);
            }
        }
    }

    /* renamed from: r, reason: from kotlin metadata */
    private final void navigateDeeplinkIfDetected(Intent appScreens) {
        String queryParameter = null;
        android.os.Parcelable parcelableExtra = appScreens.getParcelableExtra("android.intent.extra.STREAM");
        if (parcelableExtra == null) {
        } else {
            queryParameter = parcelableExtra.getQueryParameter("linkType");
        }
        if (parcelableExtra != null) {
            queryParameter = parcelableExtra.getQueryParameter("utm_campaign");
        }
        if (queryParameter == null) {
        }
        k typeFromString = LinkTypes.INSTANCE.parseTypeFromString(queryParameter);
        if (parcelableExtra != null) {
            if (j().q()) {
                q(typeFromString, appScreens);
            } else {
                t(typeFromString, appScreens);
            }
        }
    }

    /* renamed from: s, reason: from kotlin metadata */
    private final void onCreate(Intent savedInstanceState) {
        final android.os.Parcelable parcelableExtra = savedInstanceState.getParcelableExtra("android.intent.extra.STREAM");
        if (parcelableExtra == null) {
            return;
        }
        j().u(parcelableExtra);
    }

    private final void t(k kVar, Intent intent) {
        if (j().p()) {
            j().saveCodeAndStay(kVar);
        } else {
            app.dogo.com.dogo_android.util.extensionfunction.f1.h0(this, new kotlinx.coroutines.OnboardingActivity.c(this, kVar, intent));
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
    protected void onCreate(Bundle bundle) throws e {
        super.onCreate(bundle);
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(1024);
        window.setStatusBarColor(0);
        ViewDataBinding viewDataBinding = f.g(this, 2131558436);
        n.e(viewDataBinding, "setContentView(this, R.layout.activity_welcome_screen_v2)");
        this.b = viewDataBinding;
        int i5 = 0;
        String str3 = "binding";
        if (viewDataBinding == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i5;
        } else {
            viewDataBinding.M(this);
            if (this.b == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i5;
            } else {
                this.b.T(j());
                overridePendingTransition(17432576, 17432577);
                j().isConnectedToInternet().observe(this, new kotlinx.coroutines.f(this));
                j().o().observe(this, new kotlinx.coroutines.e(this));
                if (getSupportFragmentManager().p0() == 0) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.o(this, new OnboardingStartScreen());
                }
                Intent intent = getIntent();
                n.e(intent, "intent");
                navigateDeeplinkIfDetected(intent);
                return;
            }
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onNewIntent(Intent intent) {
        n.f(intent, "intent");
        super.onNewIntent(intent);
        navigateDeeplinkIfDetected(intent);
    }


    /* renamed from: l, reason: from kotlin metadata */
    public static /* synthetic */ void openDeeplinkDestination(OnboardingActivity linkType, y intent) {
        kotlinx.coroutines.OnboardingActivity.p(linkType, intent);
    }

    /* renamed from: m, reason: from kotlin metadata */
    public static /* synthetic */ void tryToLoginAndParseDeeplinkDestination(OnboardingActivity linkType, y intent) {
        kotlinx.coroutines.OnboardingActivity.o(linkType, intent);
    }
}

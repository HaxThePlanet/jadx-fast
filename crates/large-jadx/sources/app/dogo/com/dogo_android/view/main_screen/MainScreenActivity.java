package app.dogo.com.dogo_android.view.main_screen;

import android.app.Activity;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.ComponentCallbacks;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.g.q;
import app.dogo.com.dogo_android.k.k.a;
import app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation;
import app.dogo.com.dogo_android.repository.domain.SubscriptionOffer;
import app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.subscription.SubscriptionScreenKey;
import app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsScreen;
import app.dogo.com.dogo_android.t.d0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.i1;
import app.dogo.com.dogo_android.util.h0.p1;
import app.dogo.com.dogo_android.util.u.b;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p2;
import app.dogo.com.dogo_android.w.u2;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.c;
import com.google.android.play.core.review.ReviewInfo;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.u;
import m.a.b.a.d.a.b;
import zendesk.support.request.RequestActivity;
import zendesk.support.request.RequestConfiguration.Builder;

/* compiled from: MainScreenActivity.kt */
@Metadata(d1 = "\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u000f\u0018\u0000 a2\u00020\u0001:\u0001aB\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010(\u001a\u00020)H\u0002J\u0008\u0010*\u001a\u00020)H\u0002J\u000e\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0004J\u0010\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020/H\u0002J\u001a\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00082\u0008\u00103\u001a\u0004\u0018\u000104H\u0016J\u0008\u00105\u001a\u00020)H\u0016J\u0008\u00106\u001a\u00020\u0004H\u0016J\u0008\u00107\u001a\u00020\u0004H\u0016J\u0008\u00108\u001a\u000209H\u0016J\u0008\u0010:\u001a\u00020;H\u0016J\u0008\u0010<\u001a\u00020)H\u0016J\u0010\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020?H\u0002J\u0016\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020;J\u0010\u0010D\u001a\u00020)2\u0006\u0010.\u001a\u00020/H\u0002J\u0016\u0010E\u001a\u00020)2\u000c\u0010F\u001a\u0008\u0012\u0004\u0012\u00020H0GH\u0002J\"\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u00042\u0008\u0010L\u001a\u0004\u0018\u00010/H\u0014J\u0012\u0010M\u001a\u00020)2\u0008\u0010N\u001a\u0004\u0018\u000104H\u0014J\u0008\u0010O\u001a\u00020)H\u0016J\u001a\u0010P\u001a\u00020?2\u0006\u0010Q\u001a\u00020\u00042\u0008\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u0010\u0010T\u001a\u00020)2\u0006\u0010.\u001a\u00020/H\u0014J\u0008\u0010U\u001a\u00020)H\u0014J\u0010\u0010V\u001a\u00020)2\u0006\u0010W\u001a\u000204H\u0016J\u0010\u0010X\u001a\u00020)2\u0006\u0010Y\u001a\u00020\u0004H\u0016J\u001e\u0010Z\u001a\u0008\u0012\u0004\u0012\u00020H0G2\u0006\u0010.\u001a\u00020/2\u0006\u0010[\u001a\u00020?H\u0002J\u0006\u0010\\\u001a\u00020?J\u0010\u0010\\\u001a\u00020)2\u0008\u0010]\u001a\u0004\u0018\u00010HJ\u0008\u0010^\u001a\u00020)H\u0016J\u0010\u0010_\u001a\u00020)2\u0008\u0010]\u001a\u0004\u0018\u00010HJ\u0006\u0010`\u001a\u00020?R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0018\u0010\u0013\u001a\u0004\u0008\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u001d\u0010\u0013\u001a\u0004\u0008\u001b\u0010\u001cR\u001e\u0010\u001e\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010 0\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008'\u0010\u0013\u001a\u0004\u0008%\u0010&¨\u0006b", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/MainScreenActivity;", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "()V", "actionBarHeight", "", "binding", "Lapp/dogo/com/dogo_android/databinding/ActivityMainBinding;", "defaultFragmentTag", "Lapp/dogo/com/dogo_android/enums/FragmentTags;", "getDefaultFragmentTag", "()Lapp/dogo/com/dogo_android/enums/FragmentTags;", "mOnNavigationItemSelectedListener", "Lcom/google/android/material/bottomnavigation/BottomNavigationView$OnNavigationItemSelectedListener;", "navBarHeight", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "soundPlayerWithPreference", "Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;", "getSoundPlayerWithPreference", "()Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;", "soundPlayerWithPreference$delegate", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "getTracker", "()Lapp/dogo/com/dogo_android/tracking/Tracker;", "tracker$delegate", "viewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "getViewModelClass", "()Ljava/lang/Class;", "vm", "Lapp/dogo/com/dogo_android/viewmodel/main_screen/MainScreenViewModel;", "getVm", "()Lapp/dogo/com/dogo_android/viewmodel/main_screen/MainScreenViewModel;", "vm$delegate", "alterBottomNavigationFromRemote", "", "bottomNavigationSetup", "changeNavigationMenuItem", "number", "changeToWelcomeChallengeAndEntryCreation", "intent", "Landroid/content/Intent;", "createAndLoadViewFragment", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseNavFragment;", "tag", "bundle", "Landroid/os/Bundle;", "emergencyExit", "getNavBarVisibility", "getNavSize", "getTag", "Lapp/dogo/com/dogo_android/enums/NavigatorTags;", "getTrackingTag", "", "hideNavigation", "launchDelayedScreensIfNeeded", "isDogPremium", "", "launchReviewFlow", "info", "Lcom/google/android/play/core/review/ReviewInfo;", "source", "launchSubscription", "navigateDeeplink", "appScreens", "", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "onActivityResult", "requestCode", "resultCode", "data", "onCreate", "savedInstanceState", "onEmptyBackStack", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onNewIntent", "onResume", "onSaveInstanceState", "outState", "onTrimMemory", "level", "parseDestinationFromLaunchIntent", "updatedIntentFlag", "showLibrary", "destination", "showNavigation", "showProfile", "userHasTiktokInstalled", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class MainScreenActivity extends app.dogo.com.dogo_android.util.e0.a0 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final MainScreenActivity.a INSTANCE = new MainScreenActivity$a(0);
    /* renamed from: L, reason: from kotlin metadata */
    private final kotlin.h actionBarHeight;
    /* renamed from: M, reason: from kotlin metadata */
    private app.dogo.com.dogo_android.h.m binding;
    private final kotlin.h N;
    /* renamed from: O, reason: from kotlin metadata */
    private final kotlin.h mOnNavigationItemSelectedListener;
    /* renamed from: P, reason: from kotlin metadata */
    private final kotlin.h navBarHeight;
    private int Q;
    private final BottomNavigationView.c R = new a();

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/MainScreenActivity$Companion;", "", "()V", "INTENT_DOG_PREMIUM_KEY", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[LinkTypes.values().length];
            iArr[LinkTypes.ENTRY_COMMENT.ordinal()] = 1;
            iArr[LinkTypes.CHALLENGE_SHARE.ordinal()] = 2;
            iArr[LinkTypes.NEW_PHOTO_UPLOAD_READY.ordinal()] = 3;
            iArr[LinkTypes.CHALLENGE_START.ordinal()] = 4;
            iArr[LinkTypes.INTERACTION_REMINDER.ordinal()] = 5;
            iArr[LinkTypes.RECAP_NOTIFICATION.ordinal()] = 6;
            iArr[LinkTypes.CHALLENGE_WELCOME.ordinal()] = 7;
            iArr[LinkTypes.SPECIAL_OFFER_NOTIFICATION.ordinal()] = 8;
            iArr[LinkTypes.UNKNOWN.ordinal()] = 9;
            MainScreenActivity.b.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/view/main_screen/MainScreenActivity$onCreate$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends androidx.activity.d {

        final /* synthetic */ MainScreenActivity c;
        c() {
            this.c = mainScreenActivity;
            super(true);
        }

        @Override // androidx.activity.d
        /* renamed from: b, reason: from kotlin metadata */
        public void handleOnBackPressed() {
            app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(this.c);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<kotlin.w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            MainScreenActivity.this.R0().w();
        }

        d() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends kotlin.d0.d.p implements kotlin.d0.c.a<kotlin.w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            MainScreenActivity.this.finish();
        }

        e() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "", "org/koin/android/ext/android/ComponentCallbackExtKt$inject$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class f extends kotlin.d0.d.p implements kotlin.d0.c.a<o3> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ ComponentCallbacks $this_inject;
        @Override // kotlin.d0.d.p
        public final o3 invoke() {
            return a.a(this.$this_inject).c(c0.b(Tracker.class), this.$qualifier, this.$parameters);
        }

        public f(ComponentCallbacks componentCallbacks, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_inject = componentCallbacks;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "", "org/koin/android/ext/android/ComponentCallbackExtKt$inject$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class g extends kotlin.d0.d.p implements kotlin.d0.c.a<app.dogo.com.dogo_android.util.j> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ ComponentCallbacks $this_inject;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.util.j invoke() {
            return a.a(this.$this_inject).c(c0.b(ClickerSoundPlayerWithPreference.class), this.$qualifier, this.$parameters);
        }

        public g(ComponentCallbacks componentCallbacks, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_inject = componentCallbacks;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class h extends kotlin.d0.d.p implements kotlin.d0.c.a<app.dogo.com.dogo_android.a0.g.e> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.a0.g.e invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(MainScreenViewModel.class), this.$parameters);
        }

        public h(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class i extends kotlin.d0.d.p implements kotlin.d0.c.a<app.dogo.com.dogo_android.view.dailytraining.l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.view.dailytraining.l invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public i(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    public MainScreenActivity() {
        super();
        kotlin.m sYNCHRONIZED2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final m.a.c.j.a aVar2 = null;
        this.actionBarHeight = j.a(sYNCHRONIZED2, new MainScreenActivity.f(this, aVar2, aVar2));
        this.N = j.a(sYNCHRONIZED2, new MainScreenActivity.h(this, aVar2, aVar2));
        this.mOnNavigationItemSelectedListener = j.a(sYNCHRONIZED2, new MainScreenActivity.i(this, aVar2, aVar2));
        this.navBarHeight = j.a(sYNCHRONIZED2, new MainScreenActivity.g(this, aVar2, aVar2));
        app.dogo.com.dogo_android.view.main_screen.a aVar = new a(this);
    }

    /* renamed from: M0, reason: from kotlin metadata */
    public static final /* synthetic */ app.dogo.com.dogo_android.view.dailytraining.l changeNavigationMenuItem(MainScreenActivity number) {
        return number.R0();
    }

    /* renamed from: N0, reason: from kotlin metadata */
    private final void alterBottomNavigationFromRemote() {
        if (U0().K()) {
            int i = 2131362861;
            (BottomNavigationView)findViewById(2131362866).getMenu().removeItem(i);
        }
    }

    private final void O0() {
        View viewById = findViewById(2131362866);
        alterBottomNavigationFromRemote();
        viewById.setOnNavigationItemSelectedListener(this.R);
        int i2 = 0;
        viewById.measure(i2, i2);
        viewById.getMeasuredHeight();
    }

    /* renamed from: Q0, reason: from kotlin metadata */
    private final void changeToWelcomeChallengeAndEntryCreation(Intent intent) {
        String queryParameter;
        android.os.Parcelable parcelableExtra = intent.getParcelableExtra("android.intent.extra.STREAM");
        Uri uri = null;
        if (parcelableExtra == null) {
            int i = uri;
        } else {
            str = "extra";
            queryParameter = parcelableExtra.getQueryParameter(str);
        }
        if (queryParameter == null) {
            showDogSelectDialog(SpecialChallenges.WELCOME_CHALLENGE.getId(), queryParameter, uri);
        } else {
            Uri currentDog = U0().updateCurrentDog(queryParameter);
            if (U0().trackAndOpenDiscountDeeplink(currentDog)) {
                showDogSelectDialog(SpecialChallenges.WELCOME_CHALLENGE.getId(), queryParameter, currentDog);
            } else {
                showDogSelectDialog(SpecialChallenges.WELCOME_CHALLENGE.getId(), queryParameter, uri);
            }
        }
    }

    private final app.dogo.com.dogo_android.view.dailytraining.l R0() {
        return (SessionViewModel)this.mOnNavigationItemSelectedListener.getValue();
    }

    private final app.dogo.com.dogo_android.util.j S0() {
        return (ClickerSoundPlayerWithPreference)this.navBarHeight.getValue();
    }

    private final o3 T0() {
        return (Tracker)this.actionBarHeight.getValue();
    }

    private final app.dogo.com.dogo_android.a0.g.e U0() {
        return (MainScreenViewModel)this.N.getValue();
    }

    /* renamed from: c1, reason: from kotlin metadata */
    private final void launchSubscription(boolean intent) {
        if (U0().I()) {
            str = "main_screen";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(this, new NewsletterBenefitsScreen(str));
        } else {
            if (intent == null) {
                int i = 1;
                Object obj = null;
                MainScreenViewModel.i(U0(), null, i, obj);
            }
        }
    }

    /* renamed from: e1, reason: from kotlin metadata */
    private final void navigateDeeplink(Intent appScreens) {
        final android.os.Parcelable parcelableExtra = appScreens.getParcelableExtra("android.intent.extra.STREAM");
        if (parcelableExtra == null) {
            return;
        }
        U0().checkImageSize(parcelableExtra);
    }

    private static final boolean f1(MainScreenActivity mainScreenActivity, MenuItem menuItem) {
        n.f(mainScreenActivity, "this$0");
        n.f(menuItem, "item");
        boolean z = true;
        switch (menuItem.getItemId()) {
            case 2131362861:
                app.dogo.com.dogo_android.k.i cHALLENGE_HOME_FRAGMENT2 = FragmentTags.CHALLENGE_HOME_FRAGMENT;
                mainScreenActivity.dismissDialog(FragmentTags.CHALLENGE_HOME_FRAGMENT);
                return true;
            case 2131362862:
                return mainScreenActivity.p1();
            case 2131362863:
                app.dogo.com.dogo_android.util.extensionfunction.g1.b(mainScreenActivity, new DashboardScreen());
                return true;
            case 2131362864:
                DogPreviewScreen menuItem22 = new DogPreviewScreen(false, null, null, 7, null);
                app.dogo.com.dogo_android.util.extensionfunction.g1.b(mainScreenActivity, menuItem22);
                return true;
            case 2131362865:
                app.dogo.com.dogo_android.util.extensionfunction.g1.b(mainScreenActivity, new SettingsScreen());
                return true;
            default:
                return false;
        }
        mainScreenActivity.showVideoPlaybackFullscreenFragment(new u.b(FragmentMessageAction.MESSAGE_ACTION_BACK_TO_TOP, new Bundle()));
    }

    /* renamed from: g1, reason: from kotlin metadata */
    private final void onCreate(List<? extends app.dogo.com.dogo_android.y.j> savedInstanceState) {
        int i2 = 1;
        i = savedInstanceState.isEmpty() ^ i2;
        if (savedInstanceState.isEmpty() ^ i2) {
            Object obj2 = p.X(savedInstanceState);
            if (obj2 instanceof SharableDialogScreen) {
                T0().logEvent(E_General.m.withParameters(u.a(new EP_URL(), obj2.createFragment())));
                app.dogo.com.dogo_android.util.extensionfunction.g1.c0(this, obj2.createFragment());
            } else {
                z = obj2 instanceof LibraryScreen;
                if (obj2 instanceof ibraryScreen) {
                    onTrimMemory((AppScreen)p.l0(savedInstanceState));
                } else {
                    z = obj2 instanceof ZendeskMessageScreen;
                    if (obj2 instanceof ZendeskMessageScreen) {
                        T0().logScreenView(this, obj2.createTrackingParameters());
                        RequestActivity.builder().withRequestId(obj2.component1()).show(this, new a[0]);
                    } else {
                        z = obj2 instanceof MobileInboxScreen;
                        if (obj2 instanceof MobileInboxScreen) {
                            if (U0().y()) {
                                T0().logScreenView(this, obj2.createTrackingParameters());
                                app.dogo.com.dogo_android.util.extensionfunction.g1.showLoginForZendeskPopUp(this);
                            }
                        } else {
                            z = obj2 instanceof DogLogCalendarScreen;
                            String str6 = "";
                            if (obj2 instanceof DogLogCalendarScreen) {
                                app.dogo.com.dogo_android.util.extensionfunction.g1.n(this, new DogLogCalendarScreen("notification", str6));
                            } else {
                                z = obj2 instanceof ZendeskKnowledgeScreen;
                                if (obj2 instanceof ZendeskKnowledgeScreen) {
                                    app.dogo.com.dogo_android.util.extensionfunction.g1.q(this, obj2);
                                } else {
                                    if (obj2 instanceof ZendeskContactUsScreen) {
                                        T0().logScreenView(this, obj2.createTrackingParameters());
                                        boolean z2 = false;
                                        boolean z3 = false;
                                        int i3 = 6;
                                        Object obj = null;
                                        SessionViewModel.t(R0(), obj2.component1(), z2, z3, i3, obj);
                                    } else {
                                        z = obj2 instanceof SubscriptionBenefitsScreen;
                                        if (obj2 instanceof SubscriptionBenefitsScreen) {
                                            if (l.z(obj2.getCoupon()) ^ i2 != 0) {
                                                U0().fetchAndSaveDiscountData(obj2.getCoupon());
                                            } else {
                                                SubscriptionScreenKey savedInstanceState2 = new SubscriptionScreenKey("onboarding", null, null, 6, null);
                                                startActivity(savedInstanceState2.buildIntent(this));
                                            }
                                        } else {
                                            z = obj2 instanceof PottyProgramReminderScreen;
                                            app.dogo.com.dogo_android.repository.domain.PottyRemindersItem pottyRemindersItem = null;
                                            if (obj2 instanceof PottyProgramReminderScreen) {
                                                app.dogo.com.dogo_android.util.extensionfunction.g1.n(this, new PottyProgramReminderScreen(pottyRemindersItem, i2, pottyRemindersItem));
                                            } else {
                                                String str5 = "deeplink";
                                                if (obj2 instanceof DogLogEditScreen) {
                                                    app.dogo.com.dogo_android.util.extensionfunction.g1.n(this, new DogLogCalendarScreen(str5, str6));
                                                    String str = null;
                                                    String str2 = null;
                                                    int i4 = 30;
                                                    g gVar = null;
                                                    DogLogEditScreen savedInstanceState3 = new DogLogEditScreen("deeplink", null, null, str, str2, i4, gVar);
                                                    app.dogo.com.dogo_android.util.extensionfunction.g1.n(this, savedInstanceState3);
                                                } else {
                                                    if (obj2 instanceof DogPreviewFullscreenScreen) {
                                                        showLibrary((AppScreen)p.l0(savedInstanceState));
                                                    } else {
                                                        if (obj2 instanceof TrainingReminderWithTimeScreen) {
                                                            int i = 2;
                                                            app.dogo.com.dogo_android.util.extensionfunction.g1.n(this, new TrainingReminderWithTimeScreen(str5, pottyRemindersItem, i, pottyRemindersItem));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static final void h1(MainScreenActivity mainScreenActivity, SubscriptionOffer subscriptionOffer) {
        n.f(mainScreenActivity, "this$0");
        if (!mainScreenActivity.getSupportFragmentManager().N0() && mainScreenActivity.I()) {
            String str2 = null;
            int i = 2;
            Object obj = null;
            str = "app_start";
            Navigator.F0(mainScreenActivity, str, str2, subscriptionOffer, i, obj);
        }
    }

    private static final void i1(MainScreenActivity mainScreenActivity, y yVar) {
        n.f(mainScreenActivity, "this$0");
        z = yVar instanceof LoadResult_Success;
        if (yVar instanceof oadResult_Success) {
            if (!mainScreenActivity.isFinishing()) {
                boolean z2 = false;
                app.dogo.com.dogo_android.repository.domain.ProfilePreview profilePreview = null;
                int i = 12;
                Object obj = null;
                str = "app_start";
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(mainScreenActivity, SessionViewModel.H(mainScreenActivity.R0(), str, app.dogo.com.dogo_android.util.extensionfunction.g1.shouldLoadImage(mainScreenActivity), z2, profilePreview, i, obj));
            }
        } else {
            z = yVar instanceof LoadResult_Error;
            if (yVar instanceof oadResult_Error) {
                z = yVar.component1().getCause() instanceof CouponExceptions_AlreadyPremium;
                if (yVar.component1().getCause() instanceof CouponExceptions_AlreadyPremium) {
                    app.dogo.com.dogo_android.util.extensionfunction.f1.showCloseDogInviteDialog(mainScreenActivity);
                } else {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.i0(mainScreenActivity, BindingAdapters.a.i(yVar.component1(), mainScreenActivity));
                }
            }
        }
    }

    private static final void k1(MainScreenActivity mainScreenActivity, ZendeskConfigurationInfo zendeskConfigurationInfo) {
        n.f(mainScreenActivity, "this$0");
        n.e(zendeskConfigurationInfo, "it");
        app.dogo.com.dogo_android.util.extensionfunction.g1.o0(mainScreenActivity, zendeskConfigurationInfo);
    }

    private static final void l1(MainScreenActivity mainScreenActivity, y yVar) {
        n.f(mainScreenActivity, "this$0");
        z = yVar instanceof LoadResult_Error;
        if (yVar instanceof oadResult_Error) {
            app.dogo.com.dogo_android.util.extensionfunction.f1.showNecessaryPermissionMissingDialog(mainScreenActivity, BindingAdapters.a.i(new Exception(yVar.component1()), mainScreenActivity), new MainScreenActivity.d(mainScreenActivity));
        }
    }

    private static final void m1(MainScreenActivity mainScreenActivity, InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        n.f(mainScreenActivity, "this$0");
        n.f(inAppMessage, "inAppMessage");
        n.f(firebaseInAppMessagingDisplayCallbacks, "firebaseInAppMessagingDisplayCallbacks");
        app.dogo.com.dogo_android.util.extensionfunction.g1.r(mainScreenActivity, inAppMessage, firebaseInAppMessagingDisplayCallbacks);
    }

    private final List<app.dogo.com.dogo_android.y.j> n1(Intent intent, boolean z) {
        android.os.Parcelable parcelableExtra = intent.getParcelableExtra("android.intent.extra.STREAM");
        queryParameter = "dog_invite_data";
        android.os.Parcelable parcelableExtra2 = intent.getParcelableExtra(queryParameter);
        if (parcelableExtra != null) {
            String queryParameter = parcelableExtra.getQueryParameter("linkType");
            if (!R0().P()) {
                R0().i0();
                app.dogo.com.dogo_android.util.extensionfunction.g1.b(this, new DashboardScreen());
            }
            int i2 = 2;
            switch (MainScreenActivity.b.a[LinkTypes.INSTANCE.parseTypeFromString(queryParameter).ordinal()]) {
                case 1: /* ordinal */
                    dismissDialog(FragmentTags.CHALLENGE_HOME_FRAGMENT);
                    onSaveInstanceState(i2);
                    k0(parcelableExtra.getQueryParameter("extra"), parcelableExtra.getQueryParameter("commentId"));
                    break;
                case 2: /* ordinal */
                    setTitle(intent);
                    break;
                case 3: /* ordinal */
                    setLoadingState(intent);
                    onSaveInstanceState(i2);
                    break;
                case 4: /* ordinal */
                    dismissDialog(FragmentTags.CHALLENGE_NOTIFICATION_CENTER_FRAGMENT);
                    break;
                case 5: /* ordinal */
                    changeToWelcomeChallengeAndEntryCreation(intent);
                    onSaveInstanceState(i2);
                    break;
                case 6: /* ordinal */
                    app.dogo.com.dogo_android.repository.domain.ProfilePreview profilePreview = null;
                    int i3 = 12;
                    Object obj = null;
                    app.dogo.com.dogo_android.util.extensionfunction.g1.n(this, SessionViewModel.H(this.R0(), "main_screen", app.dogo.com.dogo_android.util.extensionfunction.g1.shouldLoadImage(this), false, null, 12, null));
                    break;
                case 7: /* ordinal */
                    navigateDeeplink(intent);
                    List emptyProgramSaveInfo = app.dogo.com.dogo_android.util.extensionfunction.p1.getEmptyProgramSaveInfo(parcelableExtra);
                    this.U0().getDogAvatar(app.dogo.com.dogo_android.util.extensionfunction.p1.shouldSwitchDog(parcelableExtra));
                    return emptyProgramSaveInfo;
                default:
            }
        } else {
            if (parcelableExtra2 != null) {
                intent.removeExtra(queryParameter);
                app.dogo.com.dogo_android.util.extensionfunction.f1.V(this, parcelableExtra2.getDogName(), parcelableExtra2.getUserName(), parcelableExtra2.getDogAvatar());
                app.dogo.com.dogo_android.util.extensionfunction.g1.b(this, new DashboardScreen());
                onSaveInstanceState(0);
            }
        }
        return p.g();
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public int C() {
        return findViewById(2131362866).getVisibility();
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public int D() {
        return this.Q;
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public void F() {
        View viewById = findViewById(2131362866);
        if (viewById != null) {
            int i = 8;
            viewById.setVisibility(i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    /* renamed from: P0, reason: from kotlin metadata */
    public final void onSaveInstanceState(int outState) {
        (BottomNavigationView)findViewById(2131362866).getMenu().getItem(outState).setChecked(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public void Y() {
        app.dogo.com.dogo_android.util.extensionfunction.f1.S(this, 2131886134, 2131886133, new MainScreenActivity.e(this));
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public final void d1(ReviewInfo reviewInfo, String str) {
        n.f(reviewInfo, "info");
        n.f(str, "source");
        R0().a0(this, reviewInfo, str);
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    /* renamed from: o1, reason: from kotlin metadata */
    public final void onTrimMemory(app.dogo.com.dogo_android.y.j level) {
        onSaveInstanceState(1);
        app.dogo.com.dogo_android.util.extensionfunction.g1.b(this, new LibraryScreen(level));
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    protected void onActivityResult(int i, int i2, Intent intent) {
        int i6 = 0;
        super.onActivityResult(i, i2, intent);
        int i3 = 7001;
        if (i == 7001 && i2 == -1 && intent == null) {
            i6 = 0;
            ZendeskConfigurationInfo i22 = i6;
            if (i22 != null) {
                boolean z3 = true;
                boolean z4 = false;
                boolean z5 = false;
                int i5 = 222;
                Object obj2 = null;
                app.dogo.com.dogo_android.util.extensionfunction.g1.o0(this, ZendeskConfigurationInfo.copy$default(i22, R0().K(), null, null, null, false, z3, z4, z5, i5, obj2));
            } else {
                List list = null;
                boolean z = false;
                boolean z2 = false;
                int i4 = 7;
                Object obj = null;
                SessionViewModel.t(R0(), list, z, z2, i4, obj);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    protected void onCreate(Bundle bundle) throws b {
        String str2;
        super.onCreate(bundle);
        ViewDataBinding viewDataBinding = f.g(this, 2131558434);
        n.e(viewDataBinding, "setContentView(this, R.layout.activity_main)");
        this.binding = viewDataBinding;
        int i3 = 0;
        str2 = "binding";
        if (viewDataBinding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i3;
        } else {
            viewDataBinding.M(this);
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i3;
            } else {
                this.binding.T(R0());
                if (this.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i3;
                } else {
                    this.binding.U(U0());
                    O0();
                    setVolumeControlStream(3);
                    getOnBackPressedDispatcher().b(this, new MainScreenActivity_onCreate_1(this));
                    boolean z = false;
                    if (bundle == null) {
                        R0().l0();
                        app.dogo.com.dogo_android.util.extensionfunction.g1.b(this, new DashboardScreen());
                        Intent intent2 = getIntent();
                        n.e(intent2, "intent");
                        List list = n1(intent2, z);
                        if (!list.isEmpty()) {
                            str2 = "android.intent.extra.STREAM";
                            if (getIntent().getParcelableExtra(str2) == null) {
                                str = "intent_dog_premium_key";
                                launchSubscription(getIntent().getBooleanExtra(str, z));
                            } else {
                                onCreate(list);
                            }
                        }
                    } else {
                        str = "user_cache_bundle";
                        Bundle bundle2 = bundle.getBundle(str);
                        if (bundle2 != null) {
                            R0().v(bundle2);
                        }
                    }
                    U0().r().observe(this, new g(this));
                    U0().s().observe(this, new b(this));
                    R0().E().observe(this, e.a);
                    j.s().q().D(z);
                    R0().getOnZendeskOpen().observe(this, new c(this));
                    R0().B().observe(this, new d(this));
                    return;
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int i2;
        boolean onKeyDown = true;
        Object systemService = getSystemService("audio");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        int i3 = 3;
        i2 = 0;
        i2 = 1;
        int r0 = systemService.getStreamVolume(i3) == systemService.getStreamMaxVolume(i3) ? i2 : 0;
        if (i == 24) {
        }
        if (i2 == 0 || "null cannot be cast to non-null type android.media.AudioManager" == 0) {
            onKeyDown = super.onKeyDown(i, keyEvent);
        } else {
            S0().performClickerVibration(this);
            wVar = w.a;
        }
        return onKeyDown;
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    protected void onNewIntent(Intent intent) {
        n.f(intent, "intent");
        super.onNewIntent(intent);
        onCreate(n1(intent, false));
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    protected void onResume() {
        super.onResume();
        FirebaseInAppMessaging.getInstance().setMessageDisplayComponent(new f(this));
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public void onSaveInstanceState(Bundle bundle) {
        n.f(bundle, "outState");
        bundle.putBundle("user_cache_bundle", R0().C());
        super.onSaveInstanceState(bundle);
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public void onTrimMemory(int i) {
        int i2 = 0;
        super.onTrimMemory(i);
        Object[] arr = new Object[1];
        app.dogo.com.dogo_android.w.i3 firstOpenPropertiesSaved = App.INSTANCE.r().isFirstOpenPropertiesSaved();
        if (firstOpenPropertiesSaved == null) {
            i2 = 0;
        } else {
            String str2 = firstOpenPropertiesSaved.a();
        }
        a.c("Low memory on %s", new Object[] { i2 });
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public void p0() {
        View viewById = findViewById(2131362866);
        if (viewById != null) {
            int i = 0;
            viewById.setVisibility(i);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public final boolean p1() {
        final int i2 = 1;
        onSaveInstanceState(i2);
        final Bundle bundle = null;
        if (!app.dogo.com.dogo_android.util.extensionfunction.i1.g(this)) {
            if (U0().A()) {
                int i = 2;
                if (r1()) {
                    if (U0().J()) {
                        U0().G();
                        Navigator.l(this, DialogTags.TIKTOK_INVITE_DIALOG, bundle, i, bundle);
                    } else {
                        if (U0().H()) {
                            U0().F();
                            Navigator.l(this, DialogTags.INSTAGRAM_INVITE_DIALOG, bundle, i, bundle);
                        }
                    }
                }
            }
        }
        app.dogo.com.dogo_android.util.extensionfunction.g1.b(this, new LibraryScreen(bundle, i2, bundle));
        return true;
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public app.dogo.com.dogo_android.util.e0.w q(app.dogo.com.dogo_android.k.i iVar, Bundle bundle) {
        n.f(iVar, "tag");
        p0();
        final app.dogo.com.dogo_android.util.e0.w wVar = super.q(iVar, bundle);
        n.d(wVar);
        return wVar;
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    /* renamed from: q1, reason: from kotlin metadata */
    public final void showLibrary(app.dogo.com.dogo_android.y.j destination) {
        onSaveInstanceState(3);
        DogPreviewScreen dogPreviewScreen = new DogPreviewScreen(false, null, destination, 3, null);
        app.dogo.com.dogo_android.util.extensionfunction.g1.b(this, dogPreviewScreen);
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public final boolean r1() {
        int i = 0;
        boolean z = false;
        PackageManager packageManager = getPackageManager();
        if (packageManager == null) {
            i = 0;
        } else {
            str = "com.zhiliaoapp.musically";
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        }
        int r0 = i != 0 ? 1 : 0;
        return (i != 0 ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public void u() {
        showToast(2131886123);
        onBackPressed();
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public app.dogo.com.dogo_android.k.i z() {
        return FragmentTags.PLACEHOLDER;
    }

    /* renamed from: V0, reason: from kotlin metadata */
    public static /* synthetic */ boolean createAndLoadViewFragment(MainScreenActivity tag, MenuItem bundle) {
        return MainScreenActivity.f1(tag, bundle);
    }

    /* renamed from: W0, reason: from kotlin metadata */
    public static /* synthetic */ void launchReviewFlow(MainScreenActivity info, y source) {
        MainScreenActivity.i1(info, source);
    }

    /* renamed from: X0, reason: from kotlin metadata */
    public static /* synthetic */ void onKeyDown(MainScreenActivity keyCode, ZendeskConfigurationInfo event) {
        MainScreenActivity.k1(keyCode, event);
    }

    /* renamed from: Y0, reason: from kotlin metadata */
    public static /* synthetic */ void parseDestinationFromLaunchIntent(MainScreenActivity intent, y updatedIntentFlag) {
        MainScreenActivity.l1(intent, updatedIntentFlag);
    }

    /* renamed from: Z0, reason: from kotlin metadata */
    public static /* synthetic */ void launchDelayedScreensIfNeeded(y isDogPremium) {
        MainScreenActivity.onNewIntent(isDogPremium);
    }

    /* renamed from: a1, reason: from kotlin metadata */
    public static /* synthetic */ void onActivityResult(MainScreenActivity requestCode, InAppMessage resultCode, FirebaseInAppMessagingDisplayCallbacks data) {
        MainScreenActivity.m1(requestCode, resultCode, data);
    }

    public static /* synthetic */ void b1(MainScreenActivity mainScreenActivity, SubscriptionOffer subscriptionOffer) {
        MainScreenActivity.h1(mainScreenActivity, subscriptionOffer);
    }

    /* renamed from: j1, reason: from kotlin metadata */
    private static final void onNewIntent(y intent) {
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public Class<? extends r> E() {
        return BaseViewModel.class;
    }
}

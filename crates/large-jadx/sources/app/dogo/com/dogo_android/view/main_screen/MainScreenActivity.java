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
import androidx.activity.d;
import androidx.appcompat.app.d;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.a0.g.e;
import app.dogo.com.dogo_android.g.q;
import app.dogo.com.dogo_android.h.m;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.k.h;
import app.dogo.com.dogo_android.k.i;
import app.dogo.com.dogo_android.k.k;
import app.dogo.com.dogo_android.k.k.a;
import app.dogo.com.dogo_android.k.o;
import app.dogo.com.dogo_android.n.i;
import app.dogo.com.dogo_android.o.d;
import app.dogo.com.dogo_android.q.p.f0;
import app.dogo.com.dogo_android.r.n;
import app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation;
import app.dogo.com.dogo_android.repository.domain.SubscriptionOffer;
import app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.subscription.SubscriptionScreenKey;
import app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsScreen;
import app.dogo.com.dogo_android.t.d0;
import app.dogo.com.dogo_android.t.i0.a;
import app.dogo.com.dogo_android.t.i0.c;
import app.dogo.com.dogo_android.u.n.p.i;
import app.dogo.com.dogo_android.u.n.p.l.h;
import app.dogo.com.dogo_android.u.n.q.k;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.w;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.i1;
import app.dogo.com.dogo_android.util.h0.p1;
import app.dogo.com.dogo_android.util.j;
import app.dogo.com.dogo_android.util.m0.a;
import app.dogo.com.dogo_android.util.u.b;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.view.o;
import app.dogo.com.dogo_android.w.a0;
import app.dogo.com.dogo_android.w.m;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.p2;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.y.j;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.c;
import com.google.android.play.core.review.ReviewInfo;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.iterable.iterableapi.f0;
import com.iterable.iterableapi.j;
import f.c.a.e.y.e;
import f.d.a.a;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.k0.l;
import kotlin.m;
import kotlin.u;
import kotlin.w;
import kotlin.y.p;
import m.a.a.b.a.a;
import m.a.b.a.d.a.b;
import m.a.c.j.a;
import m.a.c.l.a;
import n.a.a;
import zendesk.support.request.RequestActivity;
import zendesk.support.request.RequestConfiguration.Builder;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u000f\u0018\u0000 a2\u00020\u0001:\u0001aB\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010(\u001a\u00020)H\u0002J\u0008\u0010*\u001a\u00020)H\u0002J\u000e\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0004J\u0010\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020/H\u0002J\u001a\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00082\u0008\u00103\u001a\u0004\u0018\u000104H\u0016J\u0008\u00105\u001a\u00020)H\u0016J\u0008\u00106\u001a\u00020\u0004H\u0016J\u0008\u00107\u001a\u00020\u0004H\u0016J\u0008\u00108\u001a\u000209H\u0016J\u0008\u0010:\u001a\u00020;H\u0016J\u0008\u0010<\u001a\u00020)H\u0016J\u0010\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020?H\u0002J\u0016\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020;J\u0010\u0010D\u001a\u00020)2\u0006\u0010.\u001a\u00020/H\u0002J\u0016\u0010E\u001a\u00020)2\u000c\u0010F\u001a\u0008\u0012\u0004\u0012\u00020H0GH\u0002J\"\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u00042\u0008\u0010L\u001a\u0004\u0018\u00010/H\u0014J\u0012\u0010M\u001a\u00020)2\u0008\u0010N\u001a\u0004\u0018\u000104H\u0014J\u0008\u0010O\u001a\u00020)H\u0016J\u001a\u0010P\u001a\u00020?2\u0006\u0010Q\u001a\u00020\u00042\u0008\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u0010\u0010T\u001a\u00020)2\u0006\u0010.\u001a\u00020/H\u0014J\u0008\u0010U\u001a\u00020)H\u0014J\u0010\u0010V\u001a\u00020)2\u0006\u0010W\u001a\u000204H\u0016J\u0010\u0010X\u001a\u00020)2\u0006\u0010Y\u001a\u00020\u0004H\u0016J\u001e\u0010Z\u001a\u0008\u0012\u0004\u0012\u00020H0G2\u0006\u0010.\u001a\u00020/2\u0006\u0010[\u001a\u00020?H\u0002J\u0006\u0010\\\u001a\u00020?J\u0010\u0010\\\u001a\u00020)2\u0008\u0010]\u001a\u0004\u0018\u00010HJ\u0008\u0010^\u001a\u00020)H\u0016J\u0010\u0010_\u001a\u00020)2\u0008\u0010]\u001a\u0004\u0018\u00010HJ\u0006\u0010`\u001a\u00020?R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0018\u0010\u0013\u001a\u0004\u0008\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u001d\u0010\u0013\u001a\u0004\u0008\u001b\u0010\u001cR\u001e\u0010\u001e\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010 0\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008'\u0010\u0013\u001a\u0004\u0008%\u0010&¨\u0006b", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/MainScreenActivity;", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "()V", "actionBarHeight", "", "binding", "Lapp/dogo/com/dogo_android/databinding/ActivityMainBinding;", "defaultFragmentTag", "Lapp/dogo/com/dogo_android/enums/FragmentTags;", "getDefaultFragmentTag", "()Lapp/dogo/com/dogo_android/enums/FragmentTags;", "mOnNavigationItemSelectedListener", "Lcom/google/android/material/bottomnavigation/BottomNavigationView$OnNavigationItemSelectedListener;", "navBarHeight", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "soundPlayerWithPreference", "Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;", "getSoundPlayerWithPreference", "()Lapp/dogo/com/dogo_android/util/ClickerSoundPlayerWithPreference;", "soundPlayerWithPreference$delegate", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "getTracker", "()Lapp/dogo/com/dogo_android/tracking/Tracker;", "tracker$delegate", "viewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "getViewModelClass", "()Ljava/lang/Class;", "vm", "Lapp/dogo/com/dogo_android/viewmodel/main_screen/MainScreenViewModel;", "getVm", "()Lapp/dogo/com/dogo_android/viewmodel/main_screen/MainScreenViewModel;", "vm$delegate", "alterBottomNavigationFromRemote", "", "bottomNavigationSetup", "changeNavigationMenuItem", "number", "changeToWelcomeChallengeAndEntryCreation", "intent", "Landroid/content/Intent;", "createAndLoadViewFragment", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseNavFragment;", "tag", "bundle", "Landroid/os/Bundle;", "emergencyExit", "getNavBarVisibility", "getNavSize", "getTag", "Lapp/dogo/com/dogo_android/enums/NavigatorTags;", "getTrackingTag", "", "hideNavigation", "launchDelayedScreensIfNeeded", "isDogPremium", "", "launchReviewFlow", "info", "Lcom/google/android/play/core/review/ReviewInfo;", "source", "launchSubscription", "navigateDeeplink", "appScreens", "", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "onActivityResult", "requestCode", "resultCode", "data", "onCreate", "savedInstanceState", "onEmptyBackStack", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onNewIntent", "onResume", "onSaveInstanceState", "outState", "onTrimMemory", "level", "parseDestinationFromLaunchIntent", "updatedIntentFlag", "showLibrary", "destination", "showNavigation", "showProfile", "userHasTiktokInstalled", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MainScreenActivity extends a0 {

    public static final app.dogo.com.dogo_android.view.main_screen.MainScreenActivity.a Companion;
    private final h L;
    private m M;
    private final h N;
    private final h O;
    private final h P;
    private int Q;
    private final BottomNavigationView.c R;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/MainScreenActivity$Companion;", "", "()V", "INTENT_DOG_PREMIUM_KEY", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[k.ENTRY_COMMENT.ordinal()] = 1;
            iArr[k.CHALLENGE_SHARE.ordinal()] = 2;
            iArr[k.NEW_PHOTO_UPLOAD_READY.ordinal()] = 3;
            iArr[k.CHALLENGE_START.ordinal()] = 4;
            iArr[k.INTERACTION_REMINDER.ordinal()] = 5;
            iArr[k.RECAP_NOTIFICATION.ordinal()] = 6;
            iArr[k.CHALLENGE_WELCOME.ordinal()] = 7;
            iArr[k.SPECIAL_OFFER_NOTIFICATION.ordinal()] = 8;
            iArr[k.UNKNOWN.ordinal()] = 9;
            MainScreenActivity.b.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/view/main_screen/MainScreenActivity$onCreate$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends d {

        final app.dogo.com.dogo_android.view.main_screen.MainScreenActivity c;
        c(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity) {
            this.c = mainScreenActivity;
            super(1);
        }

        @Override // androidx.activity.d
        public void b() {
            g1.O(this.c);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<w> {

        final app.dogo.com.dogo_android.view.main_screen.MainScreenActivity this$0;
        d(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity) {
            this.this$0 = mainScreenActivity;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            MainScreenActivity.M0(this.this$0).w();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<w> {

        final app.dogo.com.dogo_android.view.main_screen.MainScreenActivity this$0;
        e(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity) {
            this.this$0 = mainScreenActivity;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            this.this$0.finish();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "", "org/koin/android/ext/android/ComponentCallbackExtKt$inject$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class f extends p implements a<o3> {

        final a $parameters;
        final a $qualifier;
        final ComponentCallbacks $this_inject;
        public f(ComponentCallbacks componentCallbacks, a a2, a a3) {
            this.$this_inject = componentCallbacks;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final o3 invoke() {
            return a.a(this.$this_inject).c(c0.b(o3.class), this.$qualifier, this.$parameters);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "", "org/koin/android/ext/android/ComponentCallbackExtKt$inject$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class g extends p implements a<j> {

        final a $parameters;
        final a $qualifier;
        final ComponentCallbacks $this_inject;
        public g(ComponentCallbacks componentCallbacks, a a2, a a3) {
            this.$this_inject = componentCallbacks;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final j invoke() {
            return a.a(this.$this_inject).c(c0.b(j.class), this.$qualifier, this.$parameters);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class h extends p implements a<e> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public h(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final e invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(e.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class i extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public i(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final l invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(l.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
        MainScreenActivity.a aVar = new MainScreenActivity.a(0);
        MainScreenActivity.Companion = aVar;
    }

    public MainScreenActivity() {
        super();
        m sYNCHRONIZED = m.SYNCHRONIZED;
        final int i = 0;
        MainScreenActivity.f fVar = new MainScreenActivity.f(this, i, i);
        this.L = j.a(sYNCHRONIZED, fVar);
        MainScreenActivity.h hVar3 = new MainScreenActivity.h(this, i, i);
        this.N = j.a(sYNCHRONIZED, hVar3);
        MainScreenActivity.i iVar = new MainScreenActivity.i(this, i, i);
        this.O = j.a(sYNCHRONIZED, iVar);
        MainScreenActivity.g gVar = new MainScreenActivity.g(this, i, i);
        this.P = j.a(sYNCHRONIZED, gVar);
        a aVar = new a(this);
        this.R = aVar;
    }

    public static final l M0(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity) {
        return mainScreenActivity.R0();
    }

    private final void N0() {
        boolean menu;
        int i;
        if (U0().K()) {
            (BottomNavigationView)findViewById(2131362866).getMenu().removeItem(2131362861);
        }
    }

    private final void O0() {
        View viewById = findViewById(2131362866);
        N0();
        (BottomNavigationView)viewById.setOnNavigationItemSelectedListener(this.R);
        int i2 = 0;
        viewById.measure(i2, i2);
        viewById.getMeasuredHeight();
    }

    private final void Q0(Intent intent) {
        int i;
        String str;
        Object obj;
        boolean z;
        String obj4;
        obj4 = intent.getParcelableExtra("android.intent.extra.STREAM");
        i = 0;
        if ((Uri)obj4 == null) {
            obj4 = i;
        } else {
            obj4 = (Uri)obj4.getQueryParameter("extra");
        }
        if (obj4 != null) {
            obj = U0().t(obj4);
            if (U0().k(obj)) {
                i0(o.WELCOME_CHALLENGE.getId(), obj4, obj);
            } else {
                i0(o.WELCOME_CHALLENGE.getId(), obj4, i);
            }
        } else {
            i0(o.WELCOME_CHALLENGE.getId(), obj4, i);
        }
    }

    private final l R0() {
        return (l)this.O.getValue();
    }

    private final j S0() {
        return (j)this.P.getValue();
    }

    private final o3 T0() {
        return (o3)this.L.getValue();
    }

    private final e U0() {
        return (e)this.N.getValue();
    }

    public static boolean V0(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity, MenuItem menuItem2) {
        return MainScreenActivity.f1(mainScreenActivity, menuItem2);
    }

    public static void W0(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity, y y2) {
        MainScreenActivity.i1(mainScreenActivity, y2);
    }

    public static void X0(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity, ZendeskConfigurationInfo zendeskConfigurationInfo2) {
        MainScreenActivity.k1(mainScreenActivity, zendeskConfigurationInfo2);
    }

    public static void Y0(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity, y y2) {
        MainScreenActivity.l1(mainScreenActivity, y2);
    }

    public static void Z0(y y) {
        MainScreenActivity.j1(y);
    }

    public static void a1(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks3) {
        MainScreenActivity.m1(mainScreenActivity, inAppMessage2, firebaseInAppMessagingDisplayCallbacks3);
    }

    public static void b1(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity, SubscriptionOffer subscriptionOffer2) {
        MainScreenActivity.h1(mainScreenActivity, subscriptionOffer2);
    }

    private final void c1(boolean z) {
        String str;
        int i;
        int i2;
        Object obj5;
        if (U0().I()) {
            obj5 = new d("main_screen");
            g1.n(this, obj5);
        } else {
            if (z == null) {
                e.i(U0(), 0, obj1, 1);
            }
        }
    }

    private final void e1(Intent intent) {
        final android.os.Parcelable obj2 = intent.getParcelableExtra("android.intent.extra.STREAM");
        if ((Uri)obj2 == null) {
        }
        U0().L((Uri)obj2);
    }

    private static final boolean f1(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity, MenuItem menuItem2) {
        Enum cHALLENGE_HOME_FRAGMENT;
        Bundle bundle;
        Object obj8;
        n.f(mainScreenActivity, "this$0");
        n.f(menuItem2, "item");
        int i = 1;
        switch (obj8) {
            case 2131362861:
                cHALLENGE_HOME_FRAGMENT = i.CHALLENGE_HOME_FRAGMENT;
                mainScreenActivity.G0(cHALLENGE_HOME_FRAGMENT);
                return i;
            case 2131362862:
                return mainScreenActivity.p1();
            case 2131362863:
                obj8 = new q();
                g1.b(mainScreenActivity, obj8);
                return i;
            case 2131362864:
                super(0, 0, 0, 7, 0);
                g1.b(mainScreenActivity, obj8);
                return i;
            case 2131362865:
                obj8 = new d0();
                g1.b(mainScreenActivity, obj8);
                return i;
            default:
                return 0;
        }
        bundle = new Bundle();
        obj8 = new u.b(h.MESSAGE_ACTION_BACK_TO_TOP, bundle);
        mainScreenActivity.v(obj8);
    }

    private final void g1(List<? extends j> list) {
        int trackingParameters2;
        int trackingParameters;
        boolean str2;
        List str3;
        int i;
        int str;
        int i3;
        int i4;
        int i5;
        int i6;
        int i2;
        int i7;
        List obj13;
        trackingParameters = 1;
        if (empty ^= trackingParameters != 0) {
            trackingParameters2 = p.X(list);
            if (trackingParameters2 instanceof o) {
                p2 p2Var = new p2();
                T0().d(a0.m.d(u.a(p2Var, (o)(j)trackingParameters2.a())));
                g1.c0(this, trackingParameters2.a());
            } else {
                if (trackingParameters2 instanceof i) {
                    o1((j)p.l0(list));
                } else {
                    if (trackingParameters2 instanceof c) {
                        T0().g(this, trackingParameters2.createTrackingParameters());
                        RequestActivity.builder().withRequestId((c)trackingParameters2.a()).show(this, new a[0]);
                    } else {
                        if (trackingParameters2 instanceof b) {
                            if (U0().y()) {
                                T0().g(this, trackingParameters2.createTrackingParameters());
                                g1.p(this);
                            }
                        } else {
                            str3 = "";
                            if (trackingParameters2 instanceof i) {
                                obj13 = new i("notification", str3);
                                g1.n(this, obj13);
                            } else {
                                if (trackingParameters2 instanceof b) {
                                    g1.q(this, trackingParameters2);
                                } else {
                                    if (trackingParameters2 instanceof a) {
                                        T0().g(this, trackingParameters2.createTrackingParameters());
                                        l.t(R0(), (a)trackingParameters2.a(), false, false, 6, 0);
                                    } else {
                                        if (trackingParameters2 instanceof SubscriptionBenefitsScreen) {
                                            if (obj13 ^= trackingParameters != 0) {
                                                U0().M(trackingParameters2.getCoupon());
                                            } else {
                                                super("onboarding", 0, 0, 6, 0);
                                                startActivity(obj13.buildIntent(this));
                                            }
                                        } else {
                                            i = 0;
                                            if (trackingParameters2 instanceof k) {
                                                obj13 = new k(i, trackingParameters, i);
                                                g1.n(this, obj13);
                                            } else {
                                                str2 = "deeplink";
                                                if (trackingParameters2 instanceof h) {
                                                    obj13 = new i(str2, str3);
                                                    g1.n(this, obj13);
                                                    super("deeplink", 0, 0, 0, 0, 30, 0);
                                                    g1.n(this, obj13);
                                                } else {
                                                    if (trackingParameters2 instanceof y) {
                                                        q1((j)p.l0(list));
                                                    } else {
                                                        if (trackingParameters2 instanceof n) {
                                                            obj13 = new n(str2, i, 2, i);
                                                            g1.n(this, obj13);
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

    private static final void h1(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity, SubscriptionOffer subscriptionOffer2) {
        boolean z;
        Object obj;
        String str;
        int i;
        SubscriptionOffer subscriptionOffer;
        int i3;
        int i2;
        n.f(mainScreenActivity, "this$0");
        if (!mainScreenActivity.getSupportFragmentManager().N0() && mainScreenActivity.I()) {
            if (mainScreenActivity.I()) {
                a0.F0(mainScreenActivity, "app_start", 0, subscriptionOffer2, 2, 0);
            }
        }
    }

    private static final void i1(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity, y y2) {
        boolean z;
        String str;
        String str2;
        int i4;
        int i3;
        int i;
        int i2;
        Object obj8;
        n.f(mainScreenActivity, "this$0");
        if (y2 instanceof y.c) {
            if (!mainScreenActivity.isFinishing()) {
                g1.n(mainScreenActivity, l.H(mainScreenActivity.R0(), "app_start", g1.i(mainScreenActivity), false, 0, 12, 0));
            }
        } else {
            if (y2 instanceof y.a) {
                if (cause instanceof CouponExceptions.AlreadyPremium) {
                    f1.I(mainScreenActivity);
                } else {
                    g1.i0(mainScreenActivity, n.a.i(y2.a(), mainScreenActivity));
                }
            }
        }
    }

    private static final void j1(y y) {
    }

    private static final void k1(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity, ZendeskConfigurationInfo zendeskConfigurationInfo2) {
        n.f(mainScreenActivity, "this$0");
        n.e(zendeskConfigurationInfo2, "it");
        g1.o0(mainScreenActivity, zendeskConfigurationInfo2);
    }

    private static final void l1(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity, y y2) {
        boolean dVar;
        Exception exception;
        Object obj3;
        n.f(mainScreenActivity, "this$0");
        if (y2 instanceof y.a) {
            exception = new Exception((y.a)y2.a());
            dVar = new MainScreenActivity.d(mainScreenActivity);
            f1.C0(mainScreenActivity, n.a.i(exception, mainScreenActivity), dVar);
        }
    }

    private static final void m1(app.dogo.com.dogo_android.view.main_screen.MainScreenActivity mainScreenActivity, InAppMessage inAppMessage2, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks3) {
        n.f(mainScreenActivity, "this$0");
        n.f(inAppMessage2, "inAppMessage");
        n.f(firebaseInAppMessagingDisplayCallbacks3, "firebaseInAppMessagingDisplayCallbacks");
        g1.r(mainScreenActivity, inAppMessage2, firebaseInAppMessagingDisplayCallbacks3);
    }

    private final List<j> n1(Intent intent, boolean z2) {
        Object parcelableExtra2;
        float f;
        Object queryParameter2;
        int parcelableExtra;
        String queryParameter;
        boolean qVar;
        int i3;
        int i4;
        int i;
        int i2;
        boolean obj9;
        boolean obj10;
        parcelableExtra2 = intent.getParcelableExtra("android.intent.extra.STREAM");
        queryParameter2 = "dog_invite_data";
        parcelableExtra = intent.getParcelableExtra(queryParameter2);
        if ((Uri)parcelableExtra2 != null) {
            queryParameter2 = (Uri)parcelableExtra2.getQueryParameter("linkType");
            if (!R0().P()) {
                R0().i0();
                qVar = new q();
                g1.b(this, qVar);
            }
            i3 = 2;
            switch (parcelableExtra) {
                case 1:
                    G0(i.CHALLENGE_HOME_FRAGMENT);
                    P0(i3);
                    k0(parcelableExtra2.getQueryParameter("extra"), parcelableExtra2.getQueryParameter("commentId"));
                    break;
                case 2:
                    p(intent);
                    break;
                case 3:
                    o(intent);
                    P0(i3);
                    break;
                case 4:
                    G0(i.CHALLENGE_NOTIFICATION_CENTER_FRAGMENT);
                    break;
                case 5:
                    Q0(intent);
                    P0(i3);
                    break;
                case 6:
                    g1.n(this, l.H(R0(), "main_screen", g1.i(this), false, 0, 12, 0));
                    break;
                case 7:
                    e1(intent);
                    obj9 = p1.a(parcelableExtra2);
                    U0().N(p1.b(parcelableExtra2));
                    return obj9;
                default:
            }
        } else {
            if ((DogOwnerInvitation)parcelableExtra != null) {
                intent.removeExtra(queryParameter2);
                f1.V(this, (DogOwnerInvitation)parcelableExtra.getDogName(), parcelableExtra.getUserName(), parcelableExtra.getDogAvatar());
                obj9 = new q();
                g1.b(this, obj9);
                P0(0);
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

    public Class<? extends r> E() {
        return r.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public void F() {
        int i;
        View viewById = findViewById(2131362866);
        if ((BottomNavigationView)viewById != null) {
            (BottomNavigationView)viewById.setVisibility(8);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public final void P0(int i) {
        (BottomNavigationView)findViewById(2131362866).getMenu().getItem(i).setChecked(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public void Y() {
        MainScreenActivity.e eVar = new MainScreenActivity.e(this);
        f1.S(this, 2131886134, 2131886133, eVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public final void d1(ReviewInfo reviewInfo, String string2) {
        n.f(reviewInfo, "info");
        n.f(string2, "source");
        R0().a0(this, reviewInfo, string2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public final void o1(j j) {
        P0(1);
        i iVar = new i(j);
        g1.b(this, iVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    protected void onActivityResult(int i, int i2, Intent intent3) {
        int i12;
        int i13;
        int i4;
        int i8;
        int i3;
        int i10;
        int i9;
        int i5;
        int i11;
        int i6;
        int i7;
        int obj12;
        super.onActivityResult(i, i2, intent3);
        if (i == 7001 && i2 == -1) {
            if (i2 == -1) {
                if (intent3 == null) {
                    obj12 = 0;
                } else {
                    obj12 = intent3.getParcelableExtra("zendesk_info_configuration");
                }
                i12 = obj12;
                if (i12 != 0) {
                    g1.o0(this, ZendeskConfigurationInfo.copy$default(i12, R0().K(), 0, 0, 0, false, true, false, false, 222, 0));
                } else {
                    l.t(R0(), 0, false, false, 7, 0);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    protected void onCreate(Bundle bundle) {
        Object parcelableExtra;
        String str;
        Bundle obj5;
        super.onCreate(bundle);
        ViewDataBinding view = f.g(this, 2131558434);
        n.e(view, "setContentView(this, R.layout.activity_main)");
        this.M = (m)view;
        int i4 = 0;
        str = "binding";
        if (view == null) {
        } else {
            view.M(this);
            m mVar = this.M;
            if (mVar == null) {
            } else {
                mVar.T(R0());
                m mVar2 = this.M;
                if (mVar2 == null) {
                } else {
                    mVar2.U(U0());
                    O0();
                    setVolumeControlStream(3);
                    MainScreenActivity.c cVar2 = new MainScreenActivity.c(this);
                    getOnBackPressedDispatcher().b(this, cVar2);
                    int i3 = 0;
                    if (bundle == null) {
                        R0().l0();
                        obj5 = new q();
                        g1.b(this, obj5);
                        obj5 = getIntent();
                        n.e(obj5, "intent");
                        obj5 = n1(obj5, i3);
                        if (!obj5.isEmpty()) {
                            if (getIntent().getParcelableExtra("android.intent.extra.STREAM") == null) {
                                c1(getIntent().getBooleanExtra("intent_dog_premium_key", i3));
                            } else {
                                g1(obj5);
                            }
                        } else {
                        }
                    } else {
                        obj5 = bundle.getBundle("user_cache_bundle");
                        if (obj5 != null) {
                            R0().v(obj5);
                        }
                    }
                    g gVar = new g(this);
                    U0().r().observe(this, gVar);
                    b bVar = new b(this);
                    U0().s().observe(this, bVar);
                    R0().E().observe(this, e.a);
                    j.s().q().D(i3);
                    c cVar = new c(this);
                    R0().getOnZendeskOpen().observe(this, cVar);
                    d dVar = new d(this);
                    R0().B().observe(this, dVar);
                }
                n.w(str);
                throw i4;
            }
            n.w(str);
            throw i4;
        }
        n.w(str);
        throw i4;
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public boolean onKeyDown(int i, KeyEvent keyEvent2) {
        int i3;
        int i2;
        int onKeyDown;
        w obj5;
        Object systemService = getSystemService("audio");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        int i4 = 3;
        onKeyDown = 1;
        i3 = (AudioManager)systemService.getStreamVolume(i4) == systemService.getStreamMaxVolume(i4) ? onKeyDown : i2;
        if (i == 24) {
            i2 = onKeyDown;
        }
        if (i3 != 0 && i2 != 0) {
            if (i2 != 0) {
                S0().c(this);
                obj5 = w.a;
            } else {
                onKeyDown = super.onKeyDown(i, keyEvent2);
            }
        } else {
        }
        return onKeyDown;
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    protected void onNewIntent(Intent intent) {
        n.f(intent, "intent");
        super.onNewIntent(intent);
        g1(n1(intent, false));
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    protected void onResume() {
        super.onResume();
        f fVar = new f(this);
        FirebaseInAppMessaging.getInstance().setMessageDisplayComponent(fVar);
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public void onSaveInstanceState(Bundle bundle) {
        n.f(bundle, "outState");
        bundle.putBundle("user_cache_bundle", R0().C());
        super.onSaveInstanceState(bundle);
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public void onTrimMemory(int i) {
        int i2;
        super.onTrimMemory(i);
        Object[] obj3 = new Object[1];
        app.dogo.com.dogo_android.w.i3 i3Var = App.Companion.r().a();
        if (i3Var == null) {
            i2 = 0;
        } else {
            i2 = i3Var.a();
        }
        a.c("Low memory on %s", i2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public void p0() {
        int i;
        View viewById = findViewById(2131362866);
        if ((BottomNavigationView)viewById != null) {
            (BottomNavigationView)viewById.setVisibility(0);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public final boolean p1() {
        boolean tIKTOK_INVITE_DIALOG;
        boolean z;
        int i;
        final int i2 = 1;
        P0(i2);
        final int i3 = 0;
        if (!i1.g(this) && U0().A()) {
            if (U0().A()) {
                i = 2;
                if (r1() && U0().J()) {
                    if (U0().J()) {
                        U0().G();
                        a0.l(this, c.TIKTOK_INVITE_DIALOG, i3, i, i3);
                    } else {
                        if (U0().H()) {
                            U0().F();
                            a0.l(this, c.INSTAGRAM_INVITE_DIALOG, i3, i, i3);
                        }
                    }
                } else {
                }
            }
        }
        i iVar = new i(i3, i2, i3);
        g1.b(this, iVar);
        return i2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public w q(i i, Bundle bundle2) {
        n.f(i, "tag");
        p0();
        final w obj2 = super.q(i, bundle2);
        n.d(obj2);
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public final void q1(j j) {
        P0(3);
        super(0, 0, j, 3, 0);
        g1.b(this, f0Var);
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public final boolean r1() {
        int launchIntentForPackage;
        int i;
        String str;
        PackageManager packageManager = getPackageManager();
        if (packageManager == null) {
            launchIntentForPackage = 0;
        } else {
            launchIntentForPackage = packageManager.getLaunchIntentForPackage("com.zhiliaoapp.musically");
        }
        i = launchIntentForPackage != 0 ? 1 : 0;
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public void u() {
        t0(2131886123);
        onBackPressed();
    }

    @Override // app.dogo.com.dogo_android.util.e0.a0
    public i z() {
        return i.PLACEHOLDER;
    }
}

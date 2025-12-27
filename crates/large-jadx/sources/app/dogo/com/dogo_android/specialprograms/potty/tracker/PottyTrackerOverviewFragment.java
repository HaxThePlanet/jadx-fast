package app.dogo.com.dogo_android.u.n.r;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.activity.d;
import androidx.activity.e;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.h.ef;
import app.dogo.com.dogo_android.u.n.p.i;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.w.i3;
import kotlin.Metadata;
import kotlin.d0.c.q;
import kotlin.d0.d.c0;
import kotlin.d0.d.k;
import kotlin.d0.d.n;
import kotlin.j;
import kotlin.m;
import kotlin.w;

/* compiled from: PottyTrackerOverviewFragment.kt */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0011\u001a\u00020\u0012H\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0002J\u0008\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0008\u0010\u0019\u001a\u00020\u0012H\u0002J\u0008\u0010\u001a\u001a\u00020\u0012H\u0016J\u0008\u0010\u001b\u001a\u00020\u0012H\u0016J\u0008\u0010\u001c\u001a\u00020\u0012H\u0002J\u0012\u0010\u001d\u001a\u00020\u00122\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\u000c\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0010\u0010\u000b\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/tracker/PottyTrackerOverviewFragment;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentPottyTrackerOverviewBinding;", "Lapp/dogo/com/dogo_android/specialprograms/potty/tracker/PottyTrackerOverviewScreen;", "Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;", "()V", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/potty/tracker/PottyTrackerOverviewViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/potty/tracker/PottyTrackerOverviewViewModel;", "viewModel$delegate", "goToLogScreen", "", "isFirstPage", "", "isLastPage", "onAttach", "context", "Landroid/content/Context;", "onBack", "onItemClicked", "onLastItemSwiped", "onNextPressed", "onPageChange", "screen", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final class PottyTrackerOverviewFragment extends app.dogo.com.dogo_android.util.m0.b<ef, g> implements app.dogo.com.dogo_android.util.l0.b {

    private final kotlin.h v;
    private final kotlin.h w;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.l<d, w> {
        @Override // kotlin.d0.d.p
        public final void a(d dVar) {
            n.f(dVar, "$this$addCallback");
            f.this.N1();
        }

        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends kotlin.d0.d.p implements kotlin.d0.c.a<app.dogo.com.dogo_android.view.dailytraining.l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.view.dailytraining.l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public c(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<h> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final h invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(PottyTrackerOverviewViewModel.class), this.$parameters);
        }

        public d(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends k implements q<LayoutInflater, ViewGroup, Boolean, ef> {

        public static final f.a a = new f$a();
        @Override // kotlin.d0.d.k
        public final ef l(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
            n.f(layoutInflater, "p0");
            return ef.T(layoutInflater, viewGroup, z);
        }


        a() {
            super(3, ef.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentPottyTrackerOverviewBinding;", 0);
        }
    }
    public f() {
        super(app.dogo.com.dogo_android.specialprograms.potty.tracker.f.a.a);
        final m.a.c.j.a aVar2 = null;
        this.v = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.specialprograms.potty.tracker.f.d(this, aVar2, aVar2));
        this.w = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.specialprograms.potty.tracker.f.c(this, aVar2, aVar2));
    }

    /* renamed from: G1, reason: from kotlin metadata */
    public static final /* synthetic */ void onAttach(f context) {
        context.N1();
    }

    /* renamed from: I1, reason: from kotlin metadata */
    private final void goToLogScreen() {
        i dogLogCalendarScreen;
        String fragmentReturnTag;
        String str;
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            str = "tracker_overview";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new DogLogCalendarScreen(str, (PottyTrackerOverviewScreen)C1().getFragmentReturnTag()));
        }
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 != null) {
            Long l = null;
            app.dogo.com.dogo_android.k.e eVar = null;
            String str2 = null;
            String str3 = null;
            int i = 30;
            kotlin.d0.d.g gVar = null;
            fragmentReturnTag = "tracker_overview";
            DogLogEditScreen dogLogEditScreen = new DogLogEditScreen(fragmentReturnTag, l, eVar, str2, str3, i, gVar);
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity2, dogLogEditScreen);
        }
    }

    private final boolean J1() {
        boolean z = true;
        int r0 = (ef)B1().P.getCurrentItem() == 0 ? 1 : 0;
        return ((ef)B1().P.getCurrentItem() == 0 ? 1 : 0);
    }

    private final boolean K1() {
        boolean z = true;
        int r0 = (ef)B1().P.getCurrentItem() == p.i(H1().h()) ? 1 : 0;
        return ((ef)B1().P.getCurrentItem() == p.i(H1().h()) ? 1 : 0);
    }

    private final void N1() {
        if (!J1()) {
            str = "binding.pottyTrackerViewPager";
            n.e(viewPager2, str);
            app.dogo.com.dogo_android.util.extensionfunction.j1.logEvent(viewPager2);
        } else {
            androidx.fragment.app.e activity = getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
            }
        }
    }

    private final void O1() {
        if (K1()) {
            goToLogScreen();
        } else {
            str = "binding.pottyTrackerViewPager";
            n.e(viewPager2, str);
            app.dogo.com.dogo_android.util.extensionfunction.j1.linkWithCredentialSingle(viewPager2);
        }
    }

    private static final void P1(f fVar, View view) {
        n.f(fVar, "this$0");
        fVar.N1();
    }

    private static final void Q1(f fVar, View view) {
        n.f(fVar, "this$0");
        fVar.O1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public h H1() {
        return (PottyTrackerOverviewViewModel)this.v.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void f() {
        O1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public app.dogo.com.dogo_android.view.dailytraining.l getSharedViewModel() {
        return (SessionViewModel)this.w.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onAttach(Context context) {
        androidx.fragment.app.e activity = null;
        n.f(context, "context");
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.F();
        }
        super.onAttach(context);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, new app.dogo.com.dogo_android.specialprograms.potty.tracker.f.b(this), 2, null);
        (ef)B1().R.setNavigationOnClickListener(new app.dogo.com.dogo_android.specialprograms.potty.tracker.c(this));
        (ef)B1().O.setOnClickListener(new app.dogo.com.dogo_android.specialprograms.potty.tracker.b(this));
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void p() {
        goToLogScreen();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    /* renamed from: s1, reason: from kotlin metadata */
    public void onPageChange(i3 screen) {
        if (K1()) {
            int i = 2131886823;
            (ef)B1().O.setText(i);
        } else {
            i = 2131886689;
            (ef)B1().O.setText(i);
        }
    }


    /* renamed from: L1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(f view, View savedInstanceState) {
        PottyTrackerOverviewFragment.Q1(view, savedInstanceState);
    }

    public static /* synthetic */ void M1(f fVar, View view) {
        PottyTrackerOverviewFragment.P1(fVar, view);
    }
}

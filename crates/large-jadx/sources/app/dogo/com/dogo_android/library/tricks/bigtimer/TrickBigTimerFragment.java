package app.dogo.com.dogo_android.n.m.s;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.activity.ComponentActivity;
import androidx.activity.d;
import androidx.activity.e;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.wd;
import app.dogo.com.dogo_android.n.m.t.f;
import app.dogo.com.dogo_android.n.m.u.i;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.c.q;
import kotlin.d0.d.c0;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.m;
import kotlin.w;

/* compiled from: TrickBigTimerFragment.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J\u0008\u0010\u0012\u001a\u00020\u0011H\u0002J\u0008\u0010\u0013\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\u0011H\u0016J\u0008\u0010\u0018\u001a\u00020\u0011H\u0016J\u001a\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0008\u0010\u001e\u001a\u00020\u0011H\u0002J\u0008\u0010\u001f\u001a\u00020\u0011H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\u000b\u001a\u00020\u000c8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\n\u001a\u0004\u0008\r\u0010\u000e¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/bigtimer/TrickBigTimerFragment;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentLibraryTrickBigTimerBinding;", "Lapp/dogo/com/dogo_android/library/tricks/bigtimer/TrickBigTimerScreen;", "()V", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/library/tricks/bigtimer/TrickBigTimerViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/library/tricks/bigtimer/TrickBigTimerViewModel;", "viewModel$delegate", "goToDescriptionScreen", "", "goToNextScreen", "goToRateScreen", "onAttach", "context", "Landroid/content/Context;", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showExitTrainingDialog", "trackTrainingFinish", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final class TrickBigTimerFragment extends app.dogo.com.dogo_android.util.m0.b<wd, h> {

    private final h v;
    private final h w;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.l<d, w> {
        @Override // kotlin.d0.d.p
        public final void a(d dVar) {
            n.f(dVar, "$this$addCallback");
            g.this.X1();
        }

        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            androidx.fragment.app.e activity = g.this.getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
            }
        }

        c() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements kotlin.d0.c.a<app.dogo.com.dogo_android.view.dailytraining.l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.view.dailytraining.l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public d(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class e extends p implements kotlin.d0.c.a<i> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final i invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(TrickBigTimerViewModel.class), this.$parameters);
        }

        public e(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            TrickItem currentTrick;
            final Object obj = this;
            if ((TrickBigTimerScreen)obj.this$0.C1().createFragment().getCurrentTrick() == null) {
                String str = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                boolean z = false;
                int i = 0;
                java.util.List list = null;
                java.util.List list2 = null;
                long l = 0L;
                int i2 = 0;
                java.util.List list3 = null;
                app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory trickCategory = null;
                boolean z2 = false;
                app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData vimeoData = null;
                boolean z3 = false;
                String str5 = null;
                java.util.List list4 = null;
                String str6 = null;
                int i3 = 0;
                int i4 = 0;
                kotlin.d0.d.g gVar = 1048575;
                int i5 = 0;
                currentTrick = new TrickItem(str, str2, str3, str4, z, i, list, list2, l, z4, i2, list3, trickCategory, z2, vimeoData, z3, str5, list4, str6, i3, i4, gVar, i5);
            }
            Object[] arr = new Object[2];
            return org.koin.core.parameter.b.b(new Object[] { currentTrick, (TrickBigTimerScreen)obj.this$0.C1().createFragment().c() });
        }

        f() {
            super(0);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends kotlin.d0.d.k implements q<LayoutInflater, ViewGroup, Boolean, wd> {

        public static final g.a a = new g$a();
        @Override // kotlin.d0.d.k
        public final wd l(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
            n.f(layoutInflater, "p0");
            return wd.T(layoutInflater, viewGroup, z);
        }


        a() {
            super(3, wd.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentLibraryTrickBigTimerBinding;", 0);
        }
    }
    public g() {
        super(app.dogo.com.dogo_android.library.tricks.bigtimer.g.a.a);
        final m.a.c.j.a aVar2 = null;
        this.v = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.library.tricks.bigtimer.g.e(this, aVar2, new app.dogo.com.dogo_android.library.tricks.bigtimer.g.f(this)));
        this.w = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.library.tricks.bigtimer.g.d(this, aVar2, aVar2));
    }

    /* renamed from: G1, reason: from kotlin metadata */
    public static final /* synthetic */ void onAttach(g context) {
        context.X1();
    }

    /* renamed from: I1, reason: from kotlin metadata */
    private final void goToDescriptionScreen() {
        Object value;
        Object value2;
        H1().x();
        Long num = Long.valueOf(0L);
        if (H1().p().isVariation()) {
            androidx.fragment.app.e activity = getActivity();
            if (activity != null) {
                value2 = H1().j().getValue();
                if (value2 != null) {
                }
                VariationTipsScreen variationTipsScreen = new VariationTipsScreen(H1().p(), value2.longValue(), str, (TrickBigTimerScreen)C1().getSource());
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, variationTipsScreen);
            }
        } else {
            activity = getActivity();
            if (activity != null) {
                value = H1().j().getValue();
                if (value != null) {
                }
                PausedTrickDetailsScreen pausedTrickDetailsScreen = new PausedTrickDetailsScreen((TrickBigTimerScreen)C1().createFragment(), (TrickBigTimerScreen)C1().getSource(), value.longValue(), obj);
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, pausedTrickDetailsScreen);
            }
        }
    }

    private final void J1() {
        K1();
    }

    private final void K1() {
        Y1();
        H1().h();
        final app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile = getSharedViewModel().I();
    }

    private static final void R1(g gVar, View view) {
        n.f(gVar, "this$0");
        final androidx.fragment.app.e activity = gVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void S1(g gVar, View view) {
        n.f(gVar, "this$0");
        gVar.J1();
    }

    private static final void T1(g gVar, View view) {
        n.f(gVar, "this$0");
        gVar.goToDescriptionScreen();
    }

    private static final void U1(g gVar, View view) {
        n.f(gVar, "this$0");
        TrickItem currentTrick = (TrickBigTimerScreen)gVar.C1().createFragment().getCurrentTrick();
        if (currentTrick != null) {
            String id = currentTrick.getId();
            if (id != null) {
                gVar.H1().trackGoodExamplesClicked("library");
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(gVar.getActivity(), new ProgramTrainingGoodExampleScreen(id, (TrickBigTimerScreen)gVar.C1().getTag()));
            }
        }
    }

    private static final void V1(g gVar, long j) {
        n.f(gVar, "this$0");
        final androidx.fragment.app.e requireActivity = gVar.requireActivity();
        n.e(requireActivity, "requireActivity()");
        app.dogo.com.dogo_android.util.extensionfunction.g1.q(requireActivity, new ZendeskKnowledgeScreen(j, r3));
    }

    private static final void W1(g gVar, Boolean boolean) {
        n.f(gVar, "this$0");
        n.e(boolean, "shouldVibrate");
        if (boolean.booleanValue()) {
            app.dogo.com.dogo_android.util.extensionfunction.k1.j(gVar);
        }
    }

    private final void X1() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.f1.buildPermissionDescriptionList(activity, new app.dogo.com.dogo_android.library.tricks.bigtimer.g.c(this));
        }
    }

    private final void Y1() {
        if (n.b(H1().n().getValue(), Boolean.TRUE)) {
            H1().v();
        } else {
            H1().u();
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public i H1() {
        return (TrickBigTimerViewModel)this.v.getValue();
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
    public void onPause() {
        super.onPause();
        H1().s();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onResume() {
        super.onResume();
        H1().t();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onViewCreated(View view, Bundle bundle) {
        str = "view";
        n.f(view, str);
        super.onViewCreated(view, bundle);
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = activity.getOnBackPressedDispatcher();
            if (onBackPressedDispatcher != null) {
                boolean z = false;
                int i = 2;
                Object obj = null;
                e.b(onBackPressedDispatcher, getViewLifecycleOwner(), z, new app.dogo.com.dogo_android.library.tricks.bigtimer.g.b(this), i, obj);
            }
        }
        (wd)B1().a0.setNavigationOnClickListener(new app.dogo.com.dogo_android.library.tricks.bigtimer.b(this));
        (wd)B1().U.setOnClickListener(new app.dogo.com.dogo_android.library.tricks.bigtimer.c(this));
        (wd)B1().T.setOnClickListener(new app.dogo.com.dogo_android.library.tricks.bigtimer.e(this));
        (wd)B1().V.setOnClickListener(new app.dogo.com.dogo_android.library.tricks.bigtimer.d(this));
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(viewLifecycleOwner2, str2);
        H1().l().observe(viewLifecycleOwner2, new app.dogo.com.dogo_android.library.tricks.bigtimer.f(this));
        androidx.lifecycle.q viewLifecycleOwner3 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner3, str2);
        H1().m().observe(viewLifecycleOwner3, new app.dogo.com.dogo_android.library.tricks.bigtimer.a(this));
    }


    /* renamed from: L1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(g view, Boolean savedInstanceState) {
        TrickBigTimerFragment.W1(view, savedInstanceState);
    }

    public static /* synthetic */ void M1(g gVar, View view) {
        TrickBigTimerFragment.R1(gVar, view);
    }

    public static /* synthetic */ void N1(g gVar, View view) {
        TrickBigTimerFragment.S1(gVar, view);
    }

    public static /* synthetic */ void O1(g gVar, View view) {
        TrickBigTimerFragment.U1(gVar, view);
    }

    public static /* synthetic */ void P1(g gVar, View view) {
        TrickBigTimerFragment.T1(gVar, view);
    }

    public static /* synthetic */ void Q1(g gVar, long j) {
        TrickBigTimerFragment.V1(gVar, j);
    }
}

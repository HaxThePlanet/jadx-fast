package app.dogo.com.dogo_android.n.m.u;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.h.yd;
import app.dogo.com.dogo_android.n.m.t.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.n1;
import app.dogo.com.dogo_android.z.c;
import com.google.android.material.button.MaterialButton;
import com.skydoves.balloon.Balloon;
import kotlin.Metadata;
import kotlin.d0.c.q;
import kotlin.d0.d.c0;
import kotlin.d0.d.p;
import kotlin.j;
import kotlin.m;
import kotlin.w;

/* compiled from: TrickDetailsFragment.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0008\u0010\u0015\u001a\u00020\u0012H\u0002J\u0008\u0010\u0016\u001a\u00020\u0012H\u0002J\u0008\u0010\u0017\u001a\u00020\u0012H\u0002J\u0008\u0010\u0018\u001a\u00020\u0012H\u0002J\u0008\u0010\u0019\u001a\u00020\u0012H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0008\u0010\u001d\u001a\u00020\u0012H\u0016J\u0008\u0010\u001e\u001a\u00020\u0012H\u0016J\u0008\u0010\u001f\u001a\u00020\u0012H\u0016J\u0008\u0010 \u001a\u00020\u0012H\u0016J\u0008\u0010!\u001a\u00020\u0012H\u0016J\u001a\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0008\u0010'\u001a\u00020\u0012H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\u000c\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0010\u0010\u000b\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsFragment;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentLibraryTrickDetailsBinding;", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsScreen;", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapterCallback;", "()V", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsViewModel;", "viewModel$delegate", "enableScreen", "", "state", "", "goBack", "goToBigTimer", "goToNextScreen", "goToRateScreen", "highlightClicker", "onAttach", "context", "Landroid/content/Context;", "onDestroyView", "onNormalCardClick", "onNotFirstPageSelected", "onStart", "onStop", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "removeClickerHighlight", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final class TrickDetailsFragment extends app.dogo.com.dogo_android.util.m0.b<yd, m> implements k {

    private final kotlin.h v;
    private final kotlin.h w;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[TrickDetailsViewModel_TrainingFlowType.values().length];
            iArr[TrickDetailsViewModel_TrainingFlowType.TIMED.ordinal()] = 1;
            iArr[TrickDetailsViewModel_TrainingFlowType.RATED.ordinal()] = 2;
            iArr[TrickDetailsViewModel_TrainingFlowType.PAUSED.ordinal()] = 3;
            app.dogo.com.dogo_android.library.tricks.trickdetails.l.b.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.l<View, w> {
        @Override // kotlin.d0.d.p
        public final void a(View view) {
            n.f(view, "it");
            l.this.N1();
        }

        c() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            l.this.a2();
        }

        d() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            l.this.J1().C();
        }

        e() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            androidx.fragment.app.e activity = l.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }

        f() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class g extends p implements kotlin.d0.c.a<app.dogo.com.dogo_android.view.dailytraining.l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.view.dailytraining.l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public g(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class h extends p implements kotlin.d0.c.a<n> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final n invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(TrickDetailsViewModel.class), this.$parameters);
        }

        public h(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            TrickItem currentTrick;
            final Object obj = this;
            if ((TrickDetailsScreen)obj.this$0.C1().b().getCurrentTrick() == null) {
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
            Object[] arr = new Object[3];
            return org.koin.core.parameter.b.b(new Object[] { currentTrick, (TrickDetailsScreen)obj.this$0.C1().b().c(), (TrickDetailsScreen)obj.this$0.C1().createFragment() });
        }

        i() {
            super(0);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends kotlin.d0.d.k implements q<LayoutInflater, ViewGroup, Boolean, yd> {

        public static final l.a a = new l$a();
        @Override // kotlin.d0.d.k
        public final yd l(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
            n.f(layoutInflater, "p0");
            return yd.T(layoutInflater, viewGroup, z);
        }


        a() {
            super(3, yd.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentLibraryTrickDetailsBinding;", 0);
        }
    }
    public l() {
        super(app.dogo.com.dogo_android.library.tricks.trickdetails.l.a.a);
        final m.a.c.j.a aVar2 = null;
        this.v = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.library.tricks.trickdetails.l.h(this, aVar2, new app.dogo.com.dogo_android.library.tricks.trickdetails.l.i(this)));
        this.w = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.library.tricks.trickdetails.l.g(this, aVar2, aVar2));
    }

    /* renamed from: G1, reason: from kotlin metadata */
    public static final /* synthetic */ void enableScreen(l state) {
        state.N1();
    }

    /* renamed from: H1, reason: from kotlin metadata */
    public static final /* synthetic */ void onAttach(l context) {
        context.a2();
    }

    private final void I1(boolean z) {
        int i = 0;
        Window window = null;
        int i2 = 8;
        if ((yd)B1().Q.isEnabled() == z) {
            return;
        }
        (yd)B1().Q.setEnabled(z);
        int r1 = z ? 8 : 0;
        (yd)B1().e0.setVisibility((z ? 8 : 0));
        i = 0;
        if (z) {
            androidx.fragment.app.e activity = getActivity();
            if (activity != null) {
                Window window2 = activity.getWindow();
            }
            if (i != 0) {
                i2 = 2131100379;
                i.setStatusBarColor(a.d(requireContext(), i2));
            }
        } else {
            androidx.fragment.app.e activity2 = getActivity();
            if (activity2 != null) {
                window = activity2.getWindow();
            }
            if (window != null) {
                i2 = 2131100333;
                window.setStatusBarColor(a.d(requireContext(), i2));
            }
        }
    }

    /* renamed from: K1, reason: from kotlin metadata */
    private final void goBack() {
        J1().K();
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            str = "program";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new TrickBigTimerScreen((TrickDetailsScreen)C1().b(), (TrickDetailsScreen)C1().getTag(), (TrickDetailsScreen)C1().getFragmentParentReturnTag(), str));
        }
    }

    private final void L1() {
        int i = 0;
        VideoTrickDetailsAdapter r0 = (yd)B1().d0.getAdapter() instanceof VideoTrickDetailsAdapter ? (VideoTrickDetailsAdapter)this.B1().d0.getAdapter() : 0;
        if (i != 0) {
            i.m();
        }
        int i3 = app.dogo.com.dogo_android.library.tricks.trickdetails.l.b.a[J1().t().ordinal()];
        int i2 = 1;
        if (i3 == 1) {
            goBack();
        } else {
            i2 = 2;
            if (i3 == 2) {
                M1();
            } else {
                i2 = 3;
                if (i3 == 3) {
                    goBack();
                }
            }
        }
    }

    private final void M1() {
        J1().H();
        final app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile = getSharedViewModel().I();
    }

    private final void N1() {
        I1(false);
        (yd)B1().Q.setOutlineProvider(null);
        (yd)B1().Q.setElevation(1000f);
    }

    private static final void U1(l lVar, View view) {
        n.f(lVar, "this$0");
        final androidx.fragment.app.e activity = lVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void V1(l lVar, Boolean boolean) {
        str2 = "this$0";
        n.f(lVar, str2);
        final androidx.fragment.app.e activity = lVar.getActivity();
        if (activity != null) {
            str = "trick_details";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, new ClickerIntroductionScreen(str));
        }
    }

    private static final void W1(l lVar, View view) {
        n.f(lVar, "this$0");
        TrickItem currentTrick = (TrickDetailsScreen)lVar.C1().b().getCurrentTrick();
        if (currentTrick != null) {
            String id = currentTrick.getId();
            if (id != null) {
                lVar.J1().I("library");
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(lVar.getActivity(), new ProgramTrainingGoodExampleScreen(id, (TrickDetailsScreen)lVar.C1().getTag()));
            }
        }
    }

    private static final void X1(l lVar, long j) {
        n.f(lVar, "this$0");
        final androidx.fragment.app.e requireActivity = lVar.requireActivity();
        n.e(requireActivity, "requireActivity()");
        app.dogo.com.dogo_android.util.extensionfunction.g1.q(requireActivity, new ZendeskKnowledgeScreen(j, r3));
    }

    private static final void Y1(l lVar, View view) {
        n.f(lVar, "this$0");
        lVar.L1();
    }

    private static final void Z1(l lVar, Throwable th) {
        n.f(lVar, "this$0");
        Context requireContext = lVar.requireContext();
        n.e(requireContext, "requireContext()");
        app.dogo.com.dogo_android.util.extensionfunction.f1.m0(lVar, BindingAdapters.a.i(new Exception(th), requireContext), new app.dogo.com.dogo_android.library.tricks.trickdetails.l.e(lVar), new app.dogo.com.dogo_android.library.tricks.trickdetails.l.f(lVar));
    }

    private final void a2() {
        I1(true);
        (yd)B1().Q.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        (yd)B1().Q.setElevation(0.0f);
    }

    private final void goBack() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public n J1() {
        return (TrickDetailsViewModel)this.v.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void M() {
        if (J1().G()) {
            J1().E();
            boolean z2 = false;
            J1().D(z2);
        }
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
    public void onDestroyView() {
        androidx.recyclerview.widget.RecyclerView.h adapter;
        final androidx.recyclerview.widget.RecyclerView.h hVar = null;
        VideoTrickDetailsAdapter r0 = (yd)B1().d0.getAdapter() instanceof VideoTrickDetailsAdapter ? (VideoTrickDetailsAdapter)this.B1().d0.getAdapter() : hVar;
        if (adapter != null) {
            adapter.m();
        }
        (yd)B1().d0.setAdapter(hVar);
        super.onDestroyView();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onStart() {
        androidx.recyclerview.widget.RecyclerView.h adapter = null;
        super.onStart();
        VideoTrickDetailsAdapter r0 = (yd)B1().d0.getAdapter() instanceof VideoTrickDetailsAdapter ? (VideoTrickDetailsAdapter)this.B1().d0.getAdapter() : 0;
        if (adapter != null) {
            adapter.q();
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onStop() {
        androidx.recyclerview.widget.RecyclerView.h adapter = null;
        super.onStop();
        VideoTrickDetailsAdapter r0 = (yd)B1().d0.getAdapter() instanceof VideoTrickDetailsAdapter ? (VideoTrickDetailsAdapter)this.B1().d0.getAdapter() : 0;
        if (adapter != null) {
            adapter.r();
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        (yd)B1().V(this);
        (yd)B1().b0.setNavigationOnClickListener(new app.dogo.com.dogo_android.library.tricks.trickdetails.g(this));
        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(viewLifecycleOwner, str2);
        J1().n().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.library.tricks.trickdetails.d(this));
        (yd)B1().T.setOnClickListener(new app.dogo.com.dogo_android.library.tricks.trickdetails.c(this));
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, str2);
        J1().o().observe(viewLifecycleOwner2, new app.dogo.com.dogo_android.library.tricks.trickdetails.f(this));
        (yd)B1().S.setOnClickListener(new app.dogo.com.dogo_android.library.tricks.trickdetails.e(this));
        if (J1().F()) {
            n.e(space, "binding.clickerPlaceholderView");
            Balloon balloon = app.dogo.com.dogo_android.util.extensionfunction.n1.h(this, space, J1());
            balloon.r0(new app.dogo.com.dogo_android.library.tricks.trickdetails.l.c(this));
            balloon.p0(new app.dogo.com.dogo_android.library.tricks.trickdetails.l.d(this));
        } else {
            J1().e();
        }
        androidx.lifecycle.q viewLifecycleOwner3 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner3, str2);
        J1().v().observe(viewLifecycleOwner3, new app.dogo.com.dogo_android.library.tricks.trickdetails.b(this));
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void t0() {
        n.e(viewPager2, "binding.trickDetailsViewPager");
        app.dogo.com.dogo_android.util.extensionfunction.j1.linkWithCredentialSingle(viewPager2);
    }


    /* renamed from: O1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(l view, Throwable savedInstanceState) {
        TrickDetailsFragment.Z1(view, savedInstanceState);
    }

    public static /* synthetic */ void P1(l lVar, View view) {
        TrickDetailsFragment.W1(lVar, view);
    }

    public static /* synthetic */ void Q1(l lVar, Boolean boolean) {
        TrickDetailsFragment.V1(lVar, boolean);
    }

    public static /* synthetic */ void R1(l lVar, View view) {
        TrickDetailsFragment.Y1(lVar, view);
    }

    public static /* synthetic */ void S1(l lVar, long j) {
        TrickDetailsFragment.X1(lVar, j);
    }

    public static /* synthetic */ void T1(l lVar, View view) {
        TrickDetailsFragment.U1(lVar, view);
    }
}

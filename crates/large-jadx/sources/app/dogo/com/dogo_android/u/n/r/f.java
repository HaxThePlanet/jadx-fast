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
import app.dogo.com.dogo_android.u.n.p.l.h;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.l0.b;
import app.dogo.com.dogo_android.util.m0.b;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.w.i3;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.c.q;
import kotlin.d0.d.c0;
import kotlin.d0.d.k;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import kotlin.y.p;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0011\u001a\u00020\u0012H\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0002J\u0008\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0008\u0010\u0019\u001a\u00020\u0012H\u0002J\u0008\u0010\u001a\u001a\u00020\u0012H\u0016J\u0008\u0010\u001b\u001a\u00020\u0012H\u0016J\u0008\u0010\u001c\u001a\u00020\u0012H\u0002J\u0012\u0010\u001d\u001a\u00020\u00122\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\u000c\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0010\u0010\u000b\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/tracker/PottyTrackerOverviewFragment;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentPottyTrackerOverviewBinding;", "Lapp/dogo/com/dogo_android/specialprograms/potty/tracker/PottyTrackerOverviewScreen;", "Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;", "()V", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/potty/tracker/PottyTrackerOverviewViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/potty/tracker/PottyTrackerOverviewViewModel;", "viewModel$delegate", "goToLogScreen", "", "isFirstPage", "", "isLastPage", "onAttach", "context", "Landroid/content/Context;", "onBack", "onItemClicked", "onLastItemSwiped", "onNextPressed", "onPageChange", "screen", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends b<ef, app.dogo.com.dogo_android.u.n.r.g> implements b {

    private final h v;
    private final h w;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<d, w> {

        final app.dogo.com.dogo_android.u.n.r.f this$0;
        b(app.dogo.com.dogo_android.u.n.r.f f) {
            this.this$0 = f;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(d d) {
            n.f(d, "$this$addCallback");
            f.G1(this.this$0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((d)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public c(Fragment fragment, a a2, a a3) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(l.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements a<app.dogo.com.dogo_android.u.n.r.h> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.u.n.r.h invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(h.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends k implements q<LayoutInflater, ViewGroup, Boolean, ef> {

        public static final app.dogo.com.dogo_android.u.n.r.f.a a;
        static {
            f.a aVar = new f.a();
            f.a.a = aVar;
        }

        a() {
            super(3, ef.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentPottyTrackerOverviewBinding;", 0);
        }

        @Override // kotlin.d0.d.k
        public Object invoke(Object object, Object object2, Object object3) {
            return l((LayoutInflater)object, (ViewGroup)object2, (Boolean)object3.booleanValue());
        }

        @Override // kotlin.d0.d.k
        public final ef l(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
            n.f(layoutInflater, "p0");
            return ef.T(layoutInflater, viewGroup2, z3);
        }
    }
    static {
    }

    public f() {
        super(f.a.a);
        final int i = 0;
        f.d dVar = new f.d(this, i, i);
        this.v = j.a(m.SYNCHRONIZED, dVar);
        f.c cVar = new f.c(this, i, i);
        this.w = j.a(m.NONE, cVar);
    }

    public static final void G1(app.dogo.com.dogo_android.u.n.r.f f) {
        f.N1();
    }

    private final void I1() {
        i iVar;
        String fragmentReturnTag;
        String str;
        int i;
        int i2;
        int i5;
        int i4;
        int i3;
        h hVar;
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            iVar = new i("tracker_overview", (g)C1().getFragmentReturnTag());
            g1.n(activity, iVar);
        }
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 == null) {
        } else {
            super("tracker_overview", 0, 0, 0, 0, 30, 0);
            g1.n(activity2, hVar);
        }
    }

    private final boolean J1() {
        int i;
        i = view.P.getCurrentItem() == 0 ? 1 : 0;
        return i;
    }

    private final boolean K1() {
        int i;
        i = view.P.getCurrentItem() == p.i(H1().h()) ? 1 : 0;
        return i;
    }

    public static void L1(app.dogo.com.dogo_android.u.n.r.f f, View view2) {
        f.Q1(f, view2);
    }

    public static void M1(app.dogo.com.dogo_android.u.n.r.f f, View view2) {
        f.P1(f, view2);
    }

    private final void N1() {
        Object activity;
        String str;
        if (J1()) {
            activity = getActivity();
            if (activity == null) {
            } else {
                g1.O(activity);
            }
        } else {
            activity = view.P;
            n.e(activity, "binding.pottyTrackerViewPager");
            j1.H0(activity);
        }
    }

    private final void O1() {
        boolean z;
        String str;
        if (K1()) {
            I1();
        } else {
            z = view.P;
            n.e(z, "binding.pottyTrackerViewPager");
            j1.G0(z);
        }
    }

    private static final void P1(app.dogo.com.dogo_android.u.n.r.f f, View view2) {
        n.f(f, "this$0");
        f.N1();
    }

    private static final void Q1(app.dogo.com.dogo_android.u.n.r.f f, View view2) {
        n.f(f, "this$0");
        f.O1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public s D1() {
        return getSharedViewModel();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public s E1() {
        return H1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public app.dogo.com.dogo_android.u.n.r.h H1() {
        return (h)this.v.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void f() {
        O1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public l getSharedViewModel() {
        return (l)this.w.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onAttach(Context context) {
        androidx.fragment.app.e activity;
        n.f(context, "context");
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.F();
        }
        super.onAttach(context);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        f.b bVar = new f.b(this);
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, bVar, 2, 0);
        c obj8 = new c(this);
        obj7.R.setNavigationOnClickListener(obj8);
        obj8 = new b(this);
        obj7.O.setOnClickListener(obj8);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void p() {
        I1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void s1(i3 i3) {
        int i;
        com.google.android.material.button.MaterialButton obj2;
        if (K1()) {
            obj2.O.setText(2131886823);
        } else {
            obj2.O.setText(2131886689);
        }
    }
}

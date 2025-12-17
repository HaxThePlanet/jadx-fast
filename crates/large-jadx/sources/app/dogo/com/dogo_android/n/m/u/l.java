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
import androidx.core.content.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.h.yd;
import app.dogo.com.dogo_android.n.m.n;
import app.dogo.com.dogo_android.n.m.s.h;
import app.dogo.com.dogo_android.n.m.t.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.t.i0.b;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.n1;
import app.dogo.com.dogo_android.util.m0.b;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.d0.k;
import app.dogo.com.dogo_android.z.c;
import com.google.android.material.button.MaterialButton;
import com.skydoves.balloon.Balloon;
import f.d.a.a;
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
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0008\u0010\u0015\u001a\u00020\u0012H\u0002J\u0008\u0010\u0016\u001a\u00020\u0012H\u0002J\u0008\u0010\u0017\u001a\u00020\u0012H\u0002J\u0008\u0010\u0018\u001a\u00020\u0012H\u0002J\u0008\u0010\u0019\u001a\u00020\u0012H\u0002J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0008\u0010\u001d\u001a\u00020\u0012H\u0016J\u0008\u0010\u001e\u001a\u00020\u0012H\u0016J\u0008\u0010\u001f\u001a\u00020\u0012H\u0016J\u0008\u0010 \u001a\u00020\u0012H\u0016J\u0008\u0010!\u001a\u00020\u0012H\u0016J\u001a\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0008\u0010'\u001a\u00020\u0012H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\u000c\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0010\u0010\u000b\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsFragment;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentLibraryTrickDetailsBinding;", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsScreen;", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsAdapterCallback;", "()V", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/library/tricks/trickdetails/TrickDetailsViewModel;", "viewModel$delegate", "enableScreen", "", "state", "", "goBack", "goToBigTimer", "goToNextScreen", "goToRateScreen", "highlightClicker", "onAttach", "context", "Landroid/content/Context;", "onDestroyView", "onNormalCardClick", "onNotFirstPageSelected", "onStart", "onStop", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "removeClickerHighlight", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l extends b<yd, app.dogo.com.dogo_android.n.m.u.m> implements app.dogo.com.dogo_android.n.m.u.k {

    private final h v;
    private final h w;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class b {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[n.a.TIMED.ordinal()] = 1;
            iArr[n.a.RATED.ordinal()] = 2;
            iArr[n.a.PAUSED.ordinal()] = 3;
            l.b.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<View, w> {

        final app.dogo.com.dogo_android.n.m.u.l this$0;
        c(app.dogo.com.dogo_android.n.m.u.l l) {
            this.this$0 = l;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(View view) {
            n.f(view, "it");
            l.G1(this.this$0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((View)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<w> {

        final app.dogo.com.dogo_android.n.m.u.l this$0;
        d(app.dogo.com.dogo_android.n.m.u.l l) {
            this.this$0 = l;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            l.H1(this.this$0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<w> {

        final app.dogo.com.dogo_android.n.m.u.l this$0;
        e(app.dogo.com.dogo_android.n.m.u.l l) {
            this.this$0 = l;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            this.this$0.J1().C();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements a<w> {

        final app.dogo.com.dogo_android.n.m.u.l this$0;
        f(app.dogo.com.dogo_android.n.m.u.l l) {
            this.this$0 = l;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            androidx.fragment.app.e activity = this.this$0.getActivity();
            if (activity == null) {
            } else {
                activity.onBackPressed();
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class g extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public g(Fragment fragment, a a2, a a3) {
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
    public static final class h extends p implements a<app.dogo.com.dogo_android.n.m.u.n> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public h(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.n.m.u.n invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(n.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends p implements a<a> {

        final app.dogo.com.dogo_android.n.m.u.l this$0;
        i(app.dogo.com.dogo_android.n.m.u.l l) {
            this.this$0 = l;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            TrickItem trickItem2;
            TrickItem trickItem;
            int i;
            int i7;
            int i11;
            int i3;
            int i2;
            int i14;
            int i9;
            int i12;
            int i4;
            int i17;
            int i10;
            int i19;
            int i22;
            int i20;
            int i6;
            int i21;
            int i13;
            int i5;
            int i15;
            int i8;
            int i18;
            int i16;
            final Object obj = this;
            if ((m)obj.this$0.C1().b().a() == null) {
                super(0, 0, 0, 0, 0, 0, 0, 0, 0, obj12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1048575, 0);
            }
            Object[] arr = new Object[3];
            return b.b(trickItem2, (m)obj.this$0.C1().b().c(), (m)obj.this$0.C1().a());
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends k implements q<LayoutInflater, ViewGroup, Boolean, yd> {

        public static final app.dogo.com.dogo_android.n.m.u.l.a a;
        static {
            l.a aVar = new l.a();
            l.a.a = aVar;
        }

        a() {
            super(3, yd.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentLibraryTrickDetailsBinding;", 0);
        }

        @Override // kotlin.d0.d.k
        public Object invoke(Object object, Object object2, Object object3) {
            return l((LayoutInflater)object, (ViewGroup)object2, (Boolean)object3.booleanValue());
        }

        @Override // kotlin.d0.d.k
        public final yd l(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
            n.f(layoutInflater, "p0");
            return yd.T(layoutInflater, viewGroup2, z3);
        }
    }
    static {
    }

    public l() {
        super(l.a.a);
        l.i iVar = new l.i(this);
        final int i = 0;
        l.h hVar3 = new l.h(this, i, iVar);
        this.v = j.a(m.SYNCHRONIZED, hVar3);
        l.g gVar = new l.g(this, i, i);
        this.w = j.a(m.NONE, gVar);
    }

    public static final void G1(app.dogo.com.dogo_android.n.m.u.l l) {
        l.N1();
    }

    public static final void H1(app.dogo.com.dogo_android.n.m.u.l l) {
        l.a2();
    }

    private final void I1(boolean z) {
        int window;
        int i;
        int obj3;
        if (view.Q.isEnabled() == z) {
        }
        view2.Q.setEnabled(z);
        i = z ? 8 : 0;
        view3.e0.setVisibility(i);
        window = 0;
        if (z) {
            obj3 = getActivity();
            if (obj3 == null) {
            } else {
                window = obj3.getWindow();
            }
            if (window == null) {
            } else {
                window.setStatusBarColor(a.d(requireContext(), 2131100379));
            }
        } else {
            obj3 = getActivity();
            if (obj3 == null) {
            } else {
                window = obj3.getWindow();
            }
            if (window == null) {
            } else {
                window.setStatusBarColor(a.d(requireContext(), 2131100333));
            }
        }
    }

    private final void K1() {
        h hVar;
        n nVar;
        String tag;
        String fragmentParentReturnTag;
        String str;
        J1().K();
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            hVar = new h((m)C1().b(), (m)C1().getTag(), (m)C1().getFragmentParentReturnTag(), "program");
            g1.n(activity, hVar);
        }
    }

    private final void L1() {
        int adapter;
        int i;
        if (adapter instanceof o) {
        } else {
            adapter = 0;
        }
        if (adapter == null) {
        } else {
            adapter.m();
        }
        int i2 = l.b.a[J1().t().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                } else {
                    goBack();
                }
            } else {
                M1();
            }
        } else {
            K1();
        }
    }

    private final void M1() {
        Object activity;
        Object sharedViewModel;
        f fVar;
        n nVar;
        int i;
        String str;
        String tag;
        String fragmentParentReturnTag;
        J1().H();
        final app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile = getSharedViewModel().I();
        if ((m)C1().b().a() != null && dogProfile != null) {
            if (dogProfile != null) {
                activity = getActivity();
                if (activity == null) {
                } else {
                    super((m)C1().b(), dogProfile, 0, obj6, "library", (m)C1().getTag(), (m)C1().getFragmentParentReturnTag());
                    g1.n(activity, sharedViewModel);
                }
            }
        }
    }

    private final void N1() {
        I1(false);
        view.Q.setOutlineProvider(0);
        view2.Q.setElevation(1148846080);
    }

    public static void O1(app.dogo.com.dogo_android.n.m.u.l l, Throwable throwable2) {
        l.Z1(l, throwable2);
    }

    public static void P1(app.dogo.com.dogo_android.n.m.u.l l, View view2) {
        l.W1(l, view2);
    }

    public static void Q1(app.dogo.com.dogo_android.n.m.u.l l, Boolean boolean2) {
        l.V1(l, boolean2);
    }

    public static void R1(app.dogo.com.dogo_android.n.m.u.l l, View view2) {
        l.Y1(l, view2);
    }

    public static void S1(app.dogo.com.dogo_android.n.m.u.l l, long l2) {
        l.X1(l, l2);
    }

    public static void T1(app.dogo.com.dogo_android.n.m.u.l l, View view2) {
        l.U1(l, view2);
    }

    private static final void U1(app.dogo.com.dogo_android.n.m.u.l l, View view2) {
        n.f(l, "this$0");
        final androidx.fragment.app.e obj0 = l.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void V1(app.dogo.com.dogo_android.n.m.u.l l, Boolean boolean2) {
        String str;
        Object obj2;
        n.f(l, "this$0");
        final androidx.fragment.app.e obj1 = l.getActivity();
        if (obj1 == null) {
        } else {
            obj2 = new c("trick_details");
            g1.n(obj1, obj2);
        }
    }

    private static final void W1(app.dogo.com.dogo_android.n.m.u.l l, View view2) {
        androidx.fragment.app.e activity;
        k kVar;
        Object obj2;
        Object obj3;
        n.f(l, "this$0");
        obj3 = (m)l.C1().b().a();
        if (obj3 == null) {
        } else {
            obj3 = obj3.getId();
            if (obj3 == null) {
            } else {
                l.J1().I("library");
                kVar = new k(obj3, (m)l.C1().getTag());
                g1.n(l.getActivity(), kVar);
            }
        }
    }

    private static final void X1(app.dogo.com.dogo_android.n.m.u.l l, long l2) {
        n.f(l, "this$0");
        final androidx.fragment.app.e obj1 = l.requireActivity();
        n.e(obj1, "requireActivity()");
        b bVar = new b(l2, obj3);
        g1.q(obj1, bVar);
    }

    private static final void Y1(app.dogo.com.dogo_android.n.m.u.l l, View view2) {
        n.f(l, "this$0");
        l.L1();
    }

    private static final void Z1(app.dogo.com.dogo_android.n.m.u.l l, Throwable throwable2) {
        n.f(l, "this$0");
        Exception exception = new Exception(throwable2);
        Context obj4 = l.requireContext();
        n.e(obj4, "requireContext()");
        l.e eVar = new l.e(l);
        l.f fVar = new l.f(l);
        f1.m0(l, n.a.i(exception, obj4), eVar, fVar);
    }

    private final void a2() {
        I1(true);
        view.Q.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        view2.Q.setElevation(0);
    }

    private final void goBack() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            activity.onBackPressed();
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public s D1() {
        return getSharedViewModel();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public s E1() {
        return J1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public app.dogo.com.dogo_android.n.m.u.n J1() {
        return (n)this.v.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void M() {
        boolean z;
        int i;
        if (J1().G()) {
            J1().E();
            J1().D(false);
        }
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
    public void onDestroyView() {
        androidx.recyclerview.widget.RecyclerView.h adapter;
        final int i = 0;
        if (adapter instanceof o) {
        } else {
            adapter = i;
        }
        if (adapter == null) {
        } else {
            adapter.m();
        }
        view3.d0.setAdapter(i);
        super.onDestroyView();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onStart() {
        androidx.recyclerview.widget.RecyclerView.h adapter;
        super.onStart();
        if (adapter instanceof o) {
        } else {
            adapter = 0;
        }
        if (adapter == null) {
        } else {
            adapter.q();
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onStop() {
        androidx.recyclerview.widget.RecyclerView.h adapter;
        super.onStop();
        if (adapter instanceof o) {
        } else {
            adapter = 0;
        }
        if (adapter == null) {
        } else {
            adapter.r();
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onViewCreated(View view, Bundle bundle2) {
        Object obj3;
        Object obj4;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        (yd)B1().V(this);
        obj4 = new g(this);
        obj3.b0.setNavigationOnClickListener(obj4);
        obj4 = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(obj4, str2);
        d dVar = new d(this);
        J1().n().observe(obj4, dVar);
        obj4 = new c(this);
        obj3.T.setOnClickListener(obj4);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        f fVar = new f(this);
        J1().o().observe(obj4, fVar);
        obj4 = new e(this);
        obj3.S.setOnClickListener(obj4);
        if (J1().F()) {
            obj3 = obj3.R;
            n.e(obj3, "binding.clickerPlaceholderView");
            obj3 = n1.h(this, obj3, J1());
            obj4 = new l.c(this);
            obj3.r0(obj4);
            obj4 = new l.d(this);
            obj3.p0(obj4);
        } else {
            J1().e();
        }
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        b bVar = new b(this);
        J1().v().observe(obj4, bVar);
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void t0() {
        ViewPager2 view2 = view.d0;
        n.e(view2, "binding.trickDetailsViewPager");
        j1.G0(view2);
    }
}

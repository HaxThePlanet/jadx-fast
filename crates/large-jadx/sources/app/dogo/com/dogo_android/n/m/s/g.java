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
import app.dogo.com.dogo_android.n.m.n;
import app.dogo.com.dogo_android.n.m.t.f;
import app.dogo.com.dogo_android.n.m.u.i;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.t.i0.b;
import app.dogo.com.dogo_android.u.m.s;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.util.m0.b;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.d0.k;
import app.dogo.com.dogo_android.y.j;
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
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J\u0008\u0010\u0012\u001a\u00020\u0011H\u0002J\u0008\u0010\u0013\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0008\u0010\u0017\u001a\u00020\u0011H\u0016J\u0008\u0010\u0018\u001a\u00020\u0011H\u0016J\u001a\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0008\u0010\u001e\u001a\u00020\u0011H\u0002J\u0008\u0010\u001f\u001a\u00020\u0011H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\u000b\u001a\u00020\u000c8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\n\u001a\u0004\u0008\r\u0010\u000e¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/bigtimer/TrickBigTimerFragment;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentLibraryTrickBigTimerBinding;", "Lapp/dogo/com/dogo_android/library/tricks/bigtimer/TrickBigTimerScreen;", "()V", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/library/tricks/bigtimer/TrickBigTimerViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/library/tricks/bigtimer/TrickBigTimerViewModel;", "viewModel$delegate", "goToDescriptionScreen", "", "goToNextScreen", "goToRateScreen", "onAttach", "context", "Landroid/content/Context;", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "showExitTrainingDialog", "trackTrainingFinish", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g extends b<wd, app.dogo.com.dogo_android.n.m.s.h> {

    private final h v;
    private final h w;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<d, w> {

        final app.dogo.com.dogo_android.n.m.s.g this$0;
        b(app.dogo.com.dogo_android.n.m.s.g g) {
            this.this$0 = g;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(d d) {
            n.f(d, "$this$addCallback");
            g.G1(this.this$0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((d)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<w> {

        final app.dogo.com.dogo_android.n.m.s.g this$0;
        c(app.dogo.com.dogo_android.n.m.s.g g) {
            this.this$0 = g;
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
                g1.O(activity);
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public d(Fragment fragment, a a2, a a3) {
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
    public static final class e extends p implements a<app.dogo.com.dogo_android.n.m.s.i> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public e(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.n.m.s.i invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(i.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements a<a> {

        final app.dogo.com.dogo_android.n.m.s.g this$0;
        f(app.dogo.com.dogo_android.n.m.s.g g) {
            this.this$0 = g;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            TrickItem trickItem;
            TrickItem trickItem2;
            int i14;
            int i21;
            int i13;
            int i15;
            int i16;
            int i9;
            int i10;
            int i17;
            int i20;
            int i22;
            int i8;
            int i11;
            int i;
            int i18;
            int i7;
            int i2;
            int i19;
            int i3;
            int i12;
            int i6;
            int i4;
            int i5;
            final Object obj = this;
            if ((h)obj.this$0.C1().a().a() == null) {
                super(0, 0, 0, 0, 0, 0, 0, 0, 0, obj12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1048575, 0);
            }
            Object[] arr = new Object[2];
            return b.b(trickItem, (h)obj.this$0.C1().a().c());
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends k implements q<LayoutInflater, ViewGroup, Boolean, wd> {

        public static final app.dogo.com.dogo_android.n.m.s.g.a a;
        static {
            g.a aVar = new g.a();
            g.a.a = aVar;
        }

        a() {
            super(3, wd.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentLibraryTrickBigTimerBinding;", 0);
        }

        @Override // kotlin.d0.d.k
        public Object invoke(Object object, Object object2, Object object3) {
            return l((LayoutInflater)object, (ViewGroup)object2, (Boolean)object3.booleanValue());
        }

        @Override // kotlin.d0.d.k
        public final wd l(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
            n.f(layoutInflater, "p0");
            return wd.T(layoutInflater, viewGroup2, z3);
        }
    }
    static {
    }

    public g() {
        super(g.a.a);
        g.f fVar = new g.f(this);
        final int i = 0;
        g.e eVar = new g.e(this, i, fVar);
        this.v = j.a(m.SYNCHRONIZED, eVar);
        g.d dVar = new g.d(this, i, i);
        this.w = j.a(m.NONE, dVar);
    }

    public static final void G1(app.dogo.com.dogo_android.n.m.s.g g) {
        g.X1();
    }

    private final void I1() {
        androidx.fragment.app.e activity;
        Object valueOf;
        i iVar;
        Object nVar;
        String longValue2;
        long longValue;
        H1().x();
        valueOf = Long.valueOf(0);
        if (H1().p().isVariation()) {
            activity = getActivity();
            if (activity == null) {
            } else {
                Object value = H1().j().getValue();
                if ((Long)value == null) {
                } else {
                    valueOf = value;
                }
                iVar = new s(H1().p(), valueOf.longValue(), obj5, (h)C1().getSource());
                g1.n(activity, iVar);
            }
        } else {
            activity = getActivity();
            if (activity == null) {
            } else {
                Object value2 = H1().j().getValue();
                if ((Long)value2 == null) {
                } else {
                    valueOf = value2;
                }
                iVar = new i((h)C1().a(), (h)C1().getSource(), valueOf.longValue(), obj6);
                g1.n(activity, iVar);
            }
        }
    }

    private final void J1() {
        K1();
    }

    private final void K1() {
        Object activity;
        Object sharedViewModel;
        f fVar;
        n nVar;
        long l;
        String str;
        String tag;
        String fragmentParentReturnTag;
        Y1();
        H1().h();
        final app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile = getSharedViewModel().I();
        if ((h)C1().a().a() != null && dogProfile != null) {
            if (dogProfile != null) {
                activity = getActivity();
                if (activity == null) {
                } else {
                    super((h)C1().a(), dogProfile, H1().k(), obj6, "library", (h)C1().getTag(), (h)C1().getFragmentParentReturnTag());
                    g1.n(activity, sharedViewModel);
                }
            }
        }
    }

    public static void L1(app.dogo.com.dogo_android.n.m.s.g g, Boolean boolean2) {
        g.W1(g, boolean2);
    }

    public static void M1(app.dogo.com.dogo_android.n.m.s.g g, View view2) {
        g.R1(g, view2);
    }

    public static void N1(app.dogo.com.dogo_android.n.m.s.g g, View view2) {
        g.S1(g, view2);
    }

    public static void O1(app.dogo.com.dogo_android.n.m.s.g g, View view2) {
        g.U1(g, view2);
    }

    public static void P1(app.dogo.com.dogo_android.n.m.s.g g, View view2) {
        g.T1(g, view2);
    }

    public static void Q1(app.dogo.com.dogo_android.n.m.s.g g, long l2) {
        g.V1(g, l2);
    }

    private static final void R1(app.dogo.com.dogo_android.n.m.s.g g, View view2) {
        n.f(g, "this$0");
        final androidx.fragment.app.e obj0 = g.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void S1(app.dogo.com.dogo_android.n.m.s.g g, View view2) {
        n.f(g, "this$0");
        g.J1();
    }

    private static final void T1(app.dogo.com.dogo_android.n.m.s.g g, View view2) {
        n.f(g, "this$0");
        g.I1();
    }

    private static final void U1(app.dogo.com.dogo_android.n.m.s.g g, View view2) {
        androidx.fragment.app.e activity;
        k kVar;
        Object obj2;
        Object obj3;
        n.f(g, "this$0");
        obj3 = (h)g.C1().a().a();
        if (obj3 == null) {
        } else {
            obj3 = obj3.getId();
            if (obj3 == null) {
            } else {
                g.H1().w("library");
                kVar = new k(obj3, (h)g.C1().getTag());
                g1.n(g.getActivity(), kVar);
            }
        }
    }

    private static final void V1(app.dogo.com.dogo_android.n.m.s.g g, long l2) {
        n.f(g, "this$0");
        final androidx.fragment.app.e obj1 = g.requireActivity();
        n.e(obj1, "requireActivity()");
        b bVar = new b(l2, obj3);
        g1.q(obj1, bVar);
    }

    private static final void W1(app.dogo.com.dogo_android.n.m.s.g g, Boolean boolean2) {
        n.f(g, "this$0");
        n.e(boolean2, "shouldVibrate");
        if (boolean2.booleanValue()) {
            k1.j(g);
        }
    }

    private final void X1() {
        app.dogo.com.dogo_android.n.m.s.g.c cVar;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            cVar = new g.c(this);
            f1.F0(activity, cVar);
        }
    }

    private final void Y1() {
        app.dogo.com.dogo_android.n.m.s.i iVar;
        if (n.b(H1().n().getValue(), Boolean.TRUE)) {
            H1().v();
        } else {
            H1().u();
        }
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
    public app.dogo.com.dogo_android.n.m.s.i H1() {
        return (i)this.v.getValue();
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
    public void onViewCreated(View view, Bundle bundle2) {
        Object onBackPressedDispatcher;
        androidx.lifecycle.q viewLifecycleOwner;
        int i2;
        app.dogo.com.dogo_android.n.m.s.g.b bVar;
        int i3;
        int i;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        androidx.fragment.app.e obj7 = getActivity();
        if (obj7 == null) {
        } else {
            onBackPressedDispatcher = obj7.getOnBackPressedDispatcher();
            if (onBackPressedDispatcher == null) {
            } else {
                bVar = new g.b(this);
                e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, bVar, 2, 0);
            }
        }
        b obj8 = new b(this);
        obj7.a0.setNavigationOnClickListener(obj8);
        obj8 = new c(this);
        obj7.U.setOnClickListener(obj8);
        obj8 = new e(this);
        obj7.T.setOnClickListener(obj8);
        obj8 = new d(this);
        obj7.V.setOnClickListener(obj8);
        obj8 = getViewLifecycleOwner();
        String str = "viewLifecycleOwner";
        n.e(obj8, str);
        f fVar = new f(this);
        H1().l().observe(obj8, fVar);
        obj8 = getViewLifecycleOwner();
        n.e(obj8, str);
        a aVar = new a(this);
        H1().m().observe(obj8, aVar);
    }
}

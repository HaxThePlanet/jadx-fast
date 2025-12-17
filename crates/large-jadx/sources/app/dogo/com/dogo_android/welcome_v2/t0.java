package app.dogo.com.dogo_android.welcome_v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.d;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.h.ye;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.k1;
import com.yuyakaido.android.cardstackview.CardStackView;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0008\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0008\u0010 \u001a\u0004\u0018\u00010!2\u0008\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0008\u0010$\u001a\u00020\u0015H\u0002J\u001a\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u001d2\u0008\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0008\u0010'\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$AnswerSelectCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentOnboardingSurveyBinding;", "screenKey", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyScreen;", "viewModel", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getCardAdapter", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter;", "getTopCardIndex", "", "onBack", "", "onCardAnswerSelect", "questionId", "", "answerId", "isLastCard", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSkip", "onViewCreated", "view", "trackSurveySkipQuestion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class t0 extends Fragment implements app.dogo.com.dogo_android.welcome_v2.c0.a {

    private final h a;
    private ye b;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/welcome_v2/OnboardingSurveyFragment$onViewCreated$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends d {

        final app.dogo.com.dogo_android.welcome_v2.t0 c;
        b(app.dogo.com.dogo_android.welcome_v2.t0 t0) {
            this.c = t0;
            super(1);
        }

        @Override // androidx.activity.d
        public void b() {
            Object stack;
            if (t0.D1(this.c) != 0) {
                ye yeVar = t0.B1(this.c);
                if (yeVar == null) {
                } else {
                    yeVar.P.H1();
                }
                n.w("binding");
                throw 0;
            }
            this.c.O1();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements a<w> {

        final app.dogo.com.dogo_android.welcome_v2.t0 this$0;
        a(app.dogo.com.dogo_android.welcome_v2.t0 t0) {
            this.this$0 = t0;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            int i3;
            int i2;
            int i;
            t0.F1(this.this$0);
            t0.E1(this.this$0).n();
            androidx.fragment.app.e activity = this.this$0.getActivity();
            if (activity == null) {
            } else {
                g1.u0(activity, false, 1, 0);
            }
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<w> {

        final app.dogo.com.dogo_android.welcome_v2.t0 this$0;
        c(app.dogo.com.dogo_android.welcome_v2.t0 t0) {
            this.this$0 = t0;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            t0.E1(this.this$0).l();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements a<app.dogo.com.dogo_android.welcome_v2.v0> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.welcome_v2.v0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(v0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<a> {

        final app.dogo.com.dogo_android.welcome_v2.t0 this$0;
        e(app.dogo.com.dogo_android.welcome_v2.t0 t0) {
            this.this$0 = t0;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[2];
            return b.b(t0.C1(this.this$0).a(), t0.C1(this.this$0).b());
        }
    }
    static {
    }

    public t0() {
        super();
        t0.e eVar = new t0.e(this);
        t0.d dVar = new t0.d(this, 0, eVar);
        this.a = j.a(m.SYNCHRONIZED, dVar);
    }

    public static final ye B1(app.dogo.com.dogo_android.welcome_v2.t0 t0) {
        return t0.b;
    }

    public static final app.dogo.com.dogo_android.welcome_v2.u0 C1(app.dogo.com.dogo_android.welcome_v2.t0 t0) {
        return t0.H1();
    }

    public static final int D1(app.dogo.com.dogo_android.welcome_v2.t0 t0) {
        return t0.I1();
    }

    public static final app.dogo.com.dogo_android.welcome_v2.v0 E1(app.dogo.com.dogo_android.welcome_v2.t0 t0) {
        return t0.J1();
    }

    public static final void F1(app.dogo.com.dogo_android.welcome_v2.t0 t0) {
        t0.U1();
    }

    private final app.dogo.com.dogo_android.welcome_v2.c0 G1() {
        int i;
        ye yeVar = this.b;
        if (yeVar == null) {
        } else {
            androidx.recyclerview.widget.RecyclerView.h adapter = yeVar.P.getAdapter();
            if (adapter instanceof c0) {
                i = adapter;
            }
            return i;
        }
        n.w("binding");
        throw 0;
    }

    private final app.dogo.com.dogo_android.welcome_v2.u0 H1() {
        return (u0)k1.a(this);
    }

    private final int I1() {
        ye yeVar = this.b;
        if (yeVar == null) {
        } else {
            CardStackView stack = yeVar.P;
            n.e(stack, "binding.cardStackView");
            return j1.K(stack);
        }
        n.w("binding");
        throw 0;
    }

    private final app.dogo.com.dogo_android.welcome_v2.v0 J1() {
        return (v0)this.a.getValue();
    }

    public static void K1(app.dogo.com.dogo_android.welcome_v2.t0 t0, y y2) {
        t0.T1(t0, y2);
    }

    public static void L1(app.dogo.com.dogo_android.welcome_v2.t0 t0, View view2) {
        t0.P1(t0, view2);
    }

    public static void M1(app.dogo.com.dogo_android.welcome_v2.t0 t0, Boolean boolean2) {
        t0.S1(t0, boolean2);
    }

    public static void N1(app.dogo.com.dogo_android.welcome_v2.t0 t0, View view2) {
        t0.Q1(t0, view2);
    }

    private static final void P1(app.dogo.com.dogo_android.welcome_v2.t0 t0, View view2) {
        n.f(t0, "this$0");
        final androidx.fragment.app.e obj0 = t0.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void Q1(app.dogo.com.dogo_android.welcome_v2.t0 t0, View view2) {
        n.f(t0, "this$0");
        t0.R1();
    }

    private final void R1() {
        t0.a aVar = new t0.a(this);
        f1.A0(this, 2131887327, aVar);
    }

    private static final void S1(app.dogo.com.dogo_android.welcome_v2.t0 t0, Boolean boolean2) {
        app.dogo.com.dogo_android.welcome_v2.m0 m0Var;
        Object obj1;
        n.f(t0, "this$0");
        androidx.fragment.app.e obj2 = t0.getActivity();
        if (obj2 == null) {
        } else {
            m0Var = new m0(t0.J1().i());
            g1.o(obj2, m0Var);
        }
    }

    private static final void T1(app.dogo.com.dogo_android.welcome_v2.t0 t0, y y2) {
        boolean cVar;
        Exception i;
        int obj3;
        n.f(t0, "this$0");
        if (y2 instanceof y.a) {
        } else {
            obj3 = i;
        }
        if (obj3 == null) {
        } else {
            i = obj3.a();
        }
        if (i instanceof UnknownHostException != null) {
            obj3 = t0.getActivity();
            if (obj3 == null) {
            } else {
                cVar = new t0.c(t0);
                f1.h0(obj3, cVar);
            }
        }
    }

    private final void U1() {
        String arr;
        Object str;
        int i;
        app.dogo.com.dogo_android.welcome_v2.c0 c0Var = G1();
        if (c0Var != null) {
            J1().p(c0Var.p(I1()));
        } else {
            a.c("CardStackView adapter is null", new Object[0]);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void O1() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            g1.O(activity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void P0(String string, String string2, boolean z3) {
        n.f(string, "questionId");
        n.f(string2, "answerId");
        J1().m(string, string2, z3);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        ye obj2 = ye.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.b = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.M(getViewLifecycleOwner());
            obj2 = this.b;
            if (obj2 == null) {
            } else {
                obj2.W(J1());
                obj2 = this.b;
                if (obj2 == null) {
                } else {
                    obj2.V(this);
                    obj2 = this.b;
                    if (obj2 == null) {
                    } else {
                        z zVar = new z(this);
                        obj2.O.setOnClickListener(zVar);
                        obj2 = this.b;
                        if (obj2 == null) {
                        } else {
                            b0 b0Var = new b0(this);
                            obj2.P.setOnClickListener(b0Var);
                            obj2 = this.b;
                            if (obj2 == null) {
                            } else {
                                return obj2.w();
                            }
                            n.w(obj4);
                            throw obj3;
                        }
                        n.w(obj4);
                        throw obj3;
                    }
                    n.w(obj4);
                    throw obj3;
                }
                n.w(obj4);
                throw obj3;
            }
            n.w(obj4);
            throw obj3;
        }
        n.w(obj4);
        throw obj3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        t0.b bVar = new t0.b(this);
        requireActivity().getOnBackPressedDispatcher().b(getViewLifecycleOwner(), bVar);
        androidx.lifecycle.q obj3 = getViewLifecycleOwner();
        n.e(obj3, "viewLifecycleOwner");
        a0 a0Var = new a0(this);
        J1().j().observe(obj3, a0Var);
        y yVar = new y(this);
        J1().getResult().observe(getViewLifecycleOwner(), yVar);
    }
}

package app.dogo.com.dogo_android.g.g0;

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
import app.dogo.com.dogo_android.h.ya;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.welcome_v2.c0.a;
import app.dogo.com.dogo_android.welcome_v2.v0;
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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0008\u0010!\u001a\u00020\u0013H\u0002J\u001a\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u001a2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/dashboard/survey/DashboardSurveyFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$AnswerSelectCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDashboardSurveyBinding;", "screenKey", "Lapp/dogo/com/dogo_android/dashboard/survey/DashboardSurveyScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/dashboard/survey/DashboardSurveyScreen;", "viewModel", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getTopCardIndex", "", "onCardAnswerSelect", "", "questionId", "", "answerId", "isLastCard", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onNext", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends Fragment implements c0.a {

    private final h a;
    private ya b;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/dashboard/survey/DashboardSurveyFragment$onViewCreated$2", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends d {

        final app.dogo.com.dogo_android.g.g0.i c;
        a(app.dogo.com.dogo_android.g.g0.i i) {
            this.c = i;
            super(1);
        }

        @Override // androidx.activity.d
        public void b() {
            Object activity;
            if (i.D1(this.c) != 0) {
                ya yaVar = i.B1(this.c);
                if (yaVar == null) {
                } else {
                    yaVar.P.H1();
                }
                n.w("binding");
                throw 0;
            }
            activity = this.c.getActivity();
            if (activity == null) {
            } else {
                g1.O(activity);
            }
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.g.g0.i this$0;
        b(app.dogo.com.dogo_android.g.g0.i i) {
            this.this$0 = i;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            i.E1(this.this$0).l();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements a<v0> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public c(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final v0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(v0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<a> {

        final app.dogo.com.dogo_android.g.g0.i this$0;
        d(app.dogo.com.dogo_android.g.g0.i i) {
            this.this$0 = i;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[2];
            return b.b(i.C1(this.this$0).a(), i.C1(this.this$0).b());
        }
    }
    static {
    }

    public i() {
        super();
        i.d dVar = new i.d(this);
        i.c cVar = new i.c(this, 0, dVar);
        this.a = j.a(m.SYNCHRONIZED, cVar);
    }

    public static final ya B1(app.dogo.com.dogo_android.g.g0.i i) {
        return i.b;
    }

    public static final app.dogo.com.dogo_android.g.g0.j C1(app.dogo.com.dogo_android.g.g0.i i) {
        return i.F1();
    }

    public static final int D1(app.dogo.com.dogo_android.g.g0.i i) {
        return i.G1();
    }

    public static final v0 E1(app.dogo.com.dogo_android.g.g0.i i) {
        return i.H1();
    }

    private final app.dogo.com.dogo_android.g.g0.j F1() {
        return (j)k1.a(this);
    }

    private final int G1() {
        ya yaVar = this.b;
        if (yaVar == null) {
        } else {
            CardStackView stack = yaVar.P;
            n.e(stack, "binding.cardStackView");
            return j1.K(stack);
        }
        n.w("binding");
        throw 0;
    }

    private final v0 H1() {
        return (v0)this.a.getValue();
    }

    public static void I1(app.dogo.com.dogo_android.g.g0.i i, y y2) {
        i.O1(i, y2);
    }

    public static void J1(app.dogo.com.dogo_android.g.g0.i i, View view2) {
        i.M1(i, view2);
    }

    public static void K1(app.dogo.com.dogo_android.g.g0.i i, Boolean boolean2) {
        i.N1(i, boolean2);
    }

    private final void L1() {
        g gVar = new g(H1().i(), (j)k1.a(this).getFragmentReturnTag());
        g1.n(getActivity(), gVar);
    }

    private static final void M1(app.dogo.com.dogo_android.g.g0.i i, View view2) {
        n.f(i, "this$0");
        final androidx.fragment.app.e obj0 = i.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void N1(app.dogo.com.dogo_android.g.g0.i i, Boolean boolean2) {
        n.f(i, "this$0");
        i.L1();
    }

    private static final void O1(app.dogo.com.dogo_android.g.g0.i i, y y2) {
        boolean bVar;
        Exception i2;
        int obj3;
        n.f(i, "this$0");
        if (y2 instanceof y.a) {
        } else {
            obj3 = i2;
        }
        if (obj3 == null) {
        } else {
            i2 = obj3.a();
        }
        if (i2 instanceof UnknownHostException != null) {
            obj3 = i.getActivity();
            if (obj3 == null) {
            } else {
                bVar = new i.b(i);
                f1.h0(obj3, bVar);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void P0(String string, String string2, boolean z3) {
        n.f(string, "questionId");
        n.f(string2, "answerId");
        H1().m(string, string2, z3);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        ya obj2 = ya.T(layoutInflater, viewGroup2, false);
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
                obj2.W(H1());
                obj2 = this.b;
                if (obj2 == null) {
                } else {
                    obj2.V(this);
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        int obj4;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        ya obj3 = this.b;
        if (obj3 == null) {
        } else {
            d dVar = new d(this);
            obj3.O.setOnClickListener(dVar);
            i.a aVar = new i.a(this);
            requireActivity().getOnBackPressedDispatcher().b(getViewLifecycleOwner(), aVar);
            androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
            n.e(viewLifecycleOwner2, "viewLifecycleOwner");
            e eVar = new e(this);
            H1().j().observe(viewLifecycleOwner2, eVar);
            c cVar = new c(this);
            H1().getResult().observe(getViewLifecycleOwner(), cVar);
            obj3 = getActivity();
            if (obj3 instanceof a0) {
                obj4 = obj3;
            }
            if (obj4 == null) {
            } else {
                obj4.F();
            }
        }
        n.w("binding");
        throw 0;
    }
}

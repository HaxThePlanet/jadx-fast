package app.dogo.com.dogo_android.u.n.p.l;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.mc;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import f.d.a.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.c.p;
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
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J \u0010\u001c\u001a\u00020\u00112\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\u0008\u0012\u0004\u0012\u00020\u001f` H\u0016J\u001a\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00152\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0008\u0010#\u001a\u00020\u0011H\u0002J\u0008\u0010$\u001a\u00020\u0011H\u0002J\u0008\u0010%\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogEditFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogTypeListAdapter$Callback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogLogEditBinding;", "screenKey", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogEditScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogEditScreen;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogEditViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogEditViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onTagSelected", "types", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "onViewCreated", "view", "scrollToButton", "showDatePicker", "showTimePicker", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g extends Fragment implements app.dogo.com.dogo_android.u.n.p.l.j.a {

    private mc a;
    private final h b;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Long, w> {

        final app.dogo.com.dogo_android.u.n.p.l.g this$0;
        a(app.dogo.com.dogo_android.u.n.p.l.g g) {
            this.this$0 = g;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(long l) {
            g.C1(this.this$0).z(l);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((Number)object.longValue());
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "hours", "", "minutes"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements p<Integer, Integer, w> {

        final app.dogo.com.dogo_android.u.n.p.l.g this$0;
        b(app.dogo.com.dogo_android.u.n.p.l.g g) {
            this.this$0 = g;
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final void a(int i, int i2) {
            g.C1(this.this$0).B(i, i2);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            a((Number)object.intValue(), (Number)object2.intValue());
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements a<app.dogo.com.dogo_android.u.n.p.l.i> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public c(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.u.n.p.l.i invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(i.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<a> {

        final app.dogo.com.dogo_android.u.n.p.l.g this$0;
        d(app.dogo.com.dogo_android.u.n.p.l.g g) {
            this.this$0 = g;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[3];
            return b.b(g.B1(this.this$0).a(), g.B1(this.this$0).c(), g.B1(this.this$0).b());
        }
    }
    static {
    }

    public g() {
        super();
        g.d dVar = new g.d(this);
        g.c cVar = new g.c(this, 0, dVar);
        this.b = j.a(m.SYNCHRONIZED, cVar);
    }

    public static final app.dogo.com.dogo_android.u.n.p.l.h B1(app.dogo.com.dogo_android.u.n.p.l.g g) {
        return g.D1();
    }

    public static final app.dogo.com.dogo_android.u.n.p.l.i C1(app.dogo.com.dogo_android.u.n.p.l.g g) {
        return g.E1();
    }

    private final app.dogo.com.dogo_android.u.n.p.l.h D1() {
        return (h)k1.a(this);
    }

    private final app.dogo.com.dogo_android.u.n.p.l.i E1() {
        return (i)this.b.getValue();
    }

    public static void F1(app.dogo.com.dogo_android.u.n.p.l.g g, Boolean boolean2) {
        g.L1(g, boolean2);
    }

    public static void G1(app.dogo.com.dogo_android.u.n.p.l.g g, View view2) {
        g.M1(g, view2);
    }

    public static void H1(app.dogo.com.dogo_android.u.n.p.l.g g, Boolean boolean2) {
        g.K1(g, boolean2);
    }

    public static void I1(app.dogo.com.dogo_android.u.n.p.l.g g, View view2) {
        g.N1(g, view2);
    }

    public static void J1(app.dogo.com.dogo_android.u.n.p.l.g g, View view2) {
        g.O1(g, view2);
    }

    private static final void K1(app.dogo.com.dogo_android.u.n.p.l.g g, Boolean boolean2) {
        n.f(g, "this$0");
        final androidx.fragment.app.e obj0 = g.getActivity();
        if (obj0 == null) {
        } else {
            g1.O(obj0);
        }
    }

    private static final void L1(app.dogo.com.dogo_android.u.n.p.l.g g, Boolean boolean2) {
        n.f(g, "this$0");
        n.e(boolean2, "isTagSelected");
        if (boolean2.booleanValue()) {
            g.P1();
        }
    }

    private static final void M1(app.dogo.com.dogo_android.u.n.p.l.g g, View view2) {
        n.f(g, "this$0");
        final androidx.fragment.app.e obj0 = g.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void N1(app.dogo.com.dogo_android.u.n.p.l.g g, View view2) {
        n.f(g, "this$0");
        g.Q1();
    }

    private static final void O1(app.dogo.com.dogo_android.u.n.p.l.g g, View view2) {
        n.f(g, "this$0");
        g.R1();
    }

    private final void P1() {
        mc mcVar = this.a;
        final int i = 0;
        final String str = "binding";
        if (mcVar == null) {
        } else {
            if (mcVar == null) {
            } else {
                mcVar.S.smoothScrollTo(0, mcVar.R.getBottom());
            }
            n.w(str);
            throw i;
        }
        n.w(str);
        throw i;
    }

    private final void Q1() {
        Object value;
        app.dogo.com.dogo_android.u.n.p.l.g.a aVar;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            aVar = new g.a(this);
            g1.V(activity, (Long)E1().l().getValue(), aVar);
        }
    }

    private final void R1() {
        int intValue2;
        Object valueOf2;
        int intValue;
        app.dogo.com.dogo_android.u.n.p.l.g.b bVar;
        Object valueOf;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            int i = 0;
            if ((Integer)E1().p().getValue() == null) {
                valueOf2 = Integer.valueOf(i);
            }
            if ((Integer)E1().q().getValue() == null) {
                valueOf = Integer.valueOf(i);
            }
            bVar = new g.b(this);
            g1.l0(activity, valueOf2.intValue(), valueOf.intValue(), bVar);
        }
    }

    public void C0(ArrayList<String> arrayList) {
        n.f(arrayList, "types");
        E1().A(arrayList);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        androidx.fragment.app.e obj2;
        n.f(context, "context");
        super.onAttach(context);
        if (obj2 instanceof a0) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            obj2.F();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        mc obj2 = mc.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(E1());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.V(this);
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.M(getViewLifecycleOwner());
                    obj2 = this.a;
                    if (obj2 == null) {
                    } else {
                        obj2 = obj2.w();
                        n.e(obj2, "binding.root");
                        return obj2;
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
        androidx.lifecycle.q obj4 = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(obj4, str2);
        c cVar = new c(this);
        E1().o().observe(obj4, cVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        a aVar = new a(this);
        E1().t().observe(obj4, aVar);
        mc obj3 = this.a;
        obj4 = 0;
        String str3 = "binding";
        if (obj3 == null) {
        } else {
            b bVar = new b(this);
            obj3.X.setNavigationOnClickListener(bVar);
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                d dVar = new d(this);
                obj3.P.setOnClickListener(dVar);
                obj3 = this.a;
                if (obj3 == null) {
                } else {
                    obj4 = new e(this);
                    obj3.U.setOnClickListener(obj4);
                }
                n.w(str3);
                throw obj4;
            }
            n.w(str3);
            throw obj4;
        }
        n.w(str3);
        throw obj4;
    }
}

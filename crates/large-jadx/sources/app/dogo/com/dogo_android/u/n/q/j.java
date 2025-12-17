package app.dogo.com.dogo_android.u.n.q;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.h.cf;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import f.d.a.a;
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
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000f\u001a\u00020\u0010H\u0002J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00122\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/PottyProgramReminderFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentPottyReminderScreenBinding;", "screenKey", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/PottyProgramReminderScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/PottyProgramReminderScreen;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/PottyProgramReminderViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/PottyProgramReminderViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "callReminderErrorDialog", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j extends Fragment {

    private cf a;
    private final h b;

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "hours", "", "minutes"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements p<Integer, Integer, w> {

        final app.dogo.com.dogo_android.u.n.q.j this$0;
        a(app.dogo.com.dogo_android.u.n.q.j j) {
            this.this$0 = j;
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final void a(int i, int i2) {
            j.C1(this.this$0).q().postValue(Integer.valueOf(i));
            j.C1(this.this$0).r().postValue(Integer.valueOf(i2));
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            a((Number)object.intValue(), (Number)object2.intValue());
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "hours", "", "minutes"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements p<Integer, Integer, w> {

        final app.dogo.com.dogo_android.u.n.q.j this$0;
        b(app.dogo.com.dogo_android.u.n.q.j j) {
            this.this$0 = j;
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final void a(int i, int i2) {
            j.C1(this.this$0).x().postValue(Integer.valueOf(i));
            j.C1(this.this$0).y().postValue(Integer.valueOf(i2));
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            a((Number)object.intValue(), (Number)object2.intValue());
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<Long, w> {

        final app.dogo.com.dogo_android.u.n.q.j this$0;
        c(app.dogo.com.dogo_android.u.n.q.j j) {
            this.this$0 = j;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(long l) {
            j.C1(this.this$0).u().postValue(Long.valueOf(l));
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((Number)object.longValue());
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements a<app.dogo.com.dogo_android.u.n.q.l> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.u.n.q.l invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(l.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<a> {

        final app.dogo.com.dogo_android.u.n.q.j this$0;
        e(app.dogo.com.dogo_android.u.n.q.j j) {
            this.this$0 = j;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b(j.B1(this.this$0).a());
        }
    }
    static {
    }

    public j() {
        super();
        j.e eVar = new j.e(this);
        j.d dVar = new j.d(this, 0, eVar);
        this.b = j.a(m.SYNCHRONIZED, dVar);
    }

    public static final app.dogo.com.dogo_android.u.n.q.k B1(app.dogo.com.dogo_android.u.n.q.j j) {
        return j.E1();
    }

    public static final app.dogo.com.dogo_android.u.n.q.l C1(app.dogo.com.dogo_android.u.n.q.j j) {
        return j.F1();
    }

    private final void D1() {
        int i;
        int i2;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            f1.E0(activity, 2131886972, 2131886971);
        }
    }

    private final app.dogo.com.dogo_android.u.n.q.k E1() {
        return (k)k1.a(this);
    }

    private final app.dogo.com.dogo_android.u.n.q.l F1() {
        return (l)this.b.getValue();
    }

    public static void G1(app.dogo.com.dogo_android.u.n.q.j j, Boolean boolean2) {
        j.R1(j, boolean2);
    }

    public static void H1(app.dogo.com.dogo_android.u.n.q.j j, Boolean boolean2) {
        j.T1(j, boolean2);
    }

    public static void I1(app.dogo.com.dogo_android.u.n.q.j j, View view2) {
        j.O1(j, view2);
    }

    public static void J1(app.dogo.com.dogo_android.u.n.q.j j, View view2) {
        j.P1(j, view2);
    }

    public static void K1(app.dogo.com.dogo_android.u.n.q.j j, View view2) {
        j.Q1(j, view2);
    }

    public static void L1(app.dogo.com.dogo_android.u.n.q.j j, View view2) {
        j.S1(j, view2);
    }

    public static void M1(app.dogo.com.dogo_android.u.n.q.j j, View view2) {
        j.N1(j, view2);
    }

    private static final void N1(app.dogo.com.dogo_android.u.n.q.j j, View view2) {
        Object obj0;
        app.dogo.com.dogo_android.u.n.q.l obj1;
        n.f(j, "this$0");
        if (j.F1().m()) {
            j.F1().C();
            j.F1().B();
        } else {
            obj0 = j.getActivity();
            if (obj0 == null) {
            } else {
                g1.g0(obj0, 2131887194);
            }
        }
    }

    private static final void O1(app.dogo.com.dogo_android.u.n.q.j j, View view2) {
        int intValue;
        Object valueOf2;
        int intValue2;
        app.dogo.com.dogo_android.u.n.q.j.a aVar;
        Object valueOf;
        n.f(j, "this$0");
        androidx.fragment.app.e obj4 = j.getActivity();
        if (obj4 == null) {
        } else {
            int i = 0;
            if ((Integer)j.F1().q().getValue() == null) {
                valueOf2 = Integer.valueOf(i);
            }
            if ((Integer)j.F1().r().getValue() == null) {
                valueOf = Integer.valueOf(i);
            }
            aVar = new j.a(j);
            g1.l0(obj4, valueOf2.intValue(), valueOf.intValue(), aVar);
        }
    }

    private static final void P1(app.dogo.com.dogo_android.u.n.q.j j, View view2) {
        int intValue;
        Object valueOf2;
        int intValue2;
        app.dogo.com.dogo_android.u.n.q.j.b bVar;
        Object valueOf;
        n.f(j, "this$0");
        androidx.fragment.app.e obj4 = j.getActivity();
        if (obj4 == null) {
        } else {
            int i = 0;
            if ((Integer)j.F1().x().getValue() == null) {
                valueOf2 = Integer.valueOf(i);
            }
            if ((Integer)j.F1().y().getValue() == null) {
                valueOf = Integer.valueOf(i);
            }
            bVar = new j.b(j);
            g1.l0(obj4, valueOf2.intValue(), valueOf.intValue(), bVar);
        }
    }

    private static final void Q1(app.dogo.com.dogo_android.u.n.q.j j, View view2) {
        java.util.List list;
        app.dogo.com.dogo_android.u.n.q.j.c cVar;
        n.f(j, "this$0");
        androidx.fragment.app.e obj3 = j.getActivity();
        if (obj3 == null) {
        } else {
            cVar = new j.c(j);
            g1.a0(obj3, j.F1().t(), cVar);
        }
    }

    private static final void R1(app.dogo.com.dogo_android.u.n.q.j j, Boolean boolean2) {
        n.f(j, "this$0");
        j.D1();
    }

    private static final void S1(app.dogo.com.dogo_android.u.n.q.j j, View view2) {
        n.f(j, "this$0");
        final androidx.fragment.app.e obj0 = j.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void T1(app.dogo.com.dogo_android.u.n.q.j j, Boolean boolean2) {
        n.f(j, "this$0");
        final androidx.fragment.app.e obj0 = j.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        cf obj2 = cf.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.V(F1());
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        androidx.fragment.app.e obj5;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        int i = 0;
        if (obj5 instanceof a0) {
        } else {
            obj5 = i;
        }
        if (obj5 == null) {
        } else {
            obj5.F();
        }
        obj5 = this.a;
        String obj6 = "binding";
        if (obj5 == null) {
        } else {
            g gVar = new g(this);
            obj5.T.setOnClickListener(gVar);
            obj5 = this.a;
            if (obj5 == null) {
            } else {
                c cVar = new c(this);
                obj5.Q.setOnClickListener(cVar);
                obj5 = this.a;
                if (obj5 == null) {
                } else {
                    d dVar = new d(this);
                    obj5.R.setOnClickListener(dVar);
                    obj5 = this.a;
                    if (obj5 == null) {
                    } else {
                        e eVar = new e(this);
                        obj5.S.setOnClickListener(eVar);
                        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
                        final String str2 = "viewLifecycleOwner";
                        n.e(viewLifecycleOwner, str2);
                        a aVar = new a(this);
                        F1().w().observe(viewLifecycleOwner, aVar);
                        obj5 = this.a;
                        if (obj5 == null) {
                        } else {
                            obj6 = new f(this);
                            obj5.b0.setNavigationOnClickListener(obj6);
                            obj6 = getViewLifecycleOwner();
                            n.e(obj6, str2);
                            b bVar = new b(this);
                            F1().s().observe(obj6, bVar);
                        }
                        n.w(obj6);
                        throw i;
                    }
                    n.w(obj6);
                    throw i;
                }
                n.w(obj6);
                throw i;
            }
            n.w(obj6);
            throw i;
        }
        n.w(obj6);
        throw i;
    }
}

package app.dogo.com.dogo_android.y.a0;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.wf;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.y.b0.d;
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
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0008\u0010\u0014\u001a\u00020\u0011H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00162\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramQuestionBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionScreen;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCorrectItemSelected", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onIncorrectItemSelected", "item", "", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends Fragment implements app.dogo.com.dogo_android.y.a0.e.c {

    private wf a;
    private final h b;

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements a<w> {

        final app.dogo.com.dogo_android.y.a0.f this$0;
        a(app.dogo.com.dogo_android.y.a0.f f) {
            this.this$0 = f;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            f.C1(this.this$0).o();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.y.a0.f this$0;
        b(app.dogo.com.dogo_android.y.a0.f f) {
            this.this$0 = f;
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

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements a<app.dogo.com.dogo_android.y.a0.h> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public c(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.y.a0.h invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(h.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<a> {

        final app.dogo.com.dogo_android.y.a0.f this$0;
        d(app.dogo.com.dogo_android.y.a0.f f) {
            this.this$0 = f;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[2];
            return b.b(f.B1(this.this$0).b(), f.B1(this.this$0).c());
        }
    }
    static {
    }

    public f() {
        super();
        f.d dVar = new f.d(this);
        f.c cVar = new f.c(this, 0, dVar);
        this.b = j.a(m.SYNCHRONIZED, cVar);
    }

    public static final app.dogo.com.dogo_android.y.a0.g B1(app.dogo.com.dogo_android.y.a0.f f) {
        return f.D1();
    }

    public static final app.dogo.com.dogo_android.y.a0.h C1(app.dogo.com.dogo_android.y.a0.f f) {
        return f.E1();
    }

    private final app.dogo.com.dogo_android.y.a0.g D1() {
        return (g)k1.a(this);
    }

    private final app.dogo.com.dogo_android.y.a0.h E1() {
        return (h)this.b.getValue();
    }

    public static void F1(app.dogo.com.dogo_android.y.a0.f f, y y2) {
        f.K1(f, y2);
    }

    public static void G1(app.dogo.com.dogo_android.y.a0.f f, View view2) {
        f.I1(f, view2);
    }

    public static void H1(app.dogo.com.dogo_android.y.a0.f f, Boolean boolean2) {
        f.J1(f, boolean2);
    }

    private static final void I1(app.dogo.com.dogo_android.y.a0.f f, View view2) {
        n.f(f, "this$0");
        final androidx.fragment.app.e obj0 = f.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void J1(app.dogo.com.dogo_android.y.a0.f f, Boolean boolean2) {
        d dVar2;
        app.dogo.com.dogo_android.repository.domain.ProgramQuestion programQuestion;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo;
        String fragmentReturnTag;
        boolean z;
        app.dogo.com.dogo_android.repository.domain.TrainingSession trainingSession;
        d dVar;
        Object obj7;
        n.f(f, "this$0");
        androidx.fragment.app.e obj8 = f.getActivity();
        if (obj8 == null) {
        } else {
            super(f.D1().b(), f.D1().c(), f.D1().getFragmentReturnTag(), f.D1().a(), f.D1().d());
            g1.n(obj8, dVar);
        }
    }

    private static final void K1(app.dogo.com.dogo_android.y.a0.f f, y y2) {
        boolean aVar;
        app.dogo.com.dogo_android.y.a0.f.b bVar;
        String str;
        Object obj4;
        n.f(f, "this$0");
        if (y2 instanceof y.a) {
            a.d((y.a)y2.a());
            Exception exception = new Exception(y2.a());
            obj4 = f.requireContext();
            n.e(obj4, "requireContext()");
            aVar = new f.a(f);
            bVar = new f.b(f);
            f1.m0(f, n.a.i(exception, obj4), aVar, bVar);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void V() {
        E1().p();
        E1().o();
    }

    @Override // androidx.fragment.app.Fragment
    public void c1(String string) {
        n.f(string, "item");
        E1().q(string);
    }

    @Override // androidx.fragment.app.Fragment
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        wf obj2 = wf.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.M(getViewLifecycleOwner());
            obj2 = this.a;
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
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        wf obj3 = this.a;
        if (obj3 == null) {
        } else {
            c obj4 = new c(this);
            obj3.O.setNavigationOnClickListener(obj4);
            obj4 = getViewLifecycleOwner();
            String str2 = "viewLifecycleOwner";
            n.e(obj4, str2);
            d dVar = new d(this);
            E1().k().observe(obj4, dVar);
            obj4 = getViewLifecycleOwner();
            n.e(obj4, str2);
            b bVar = new b(this);
            E1().n().observe(obj4, bVar);
        }
        n.w("binding");
        throw 0;
    }
}

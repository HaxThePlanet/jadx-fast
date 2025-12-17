package app.dogo.com.dogo_android.i;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.cb;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010!\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\"H\u0016J\u0008\u0010#\u001a\u00020\u0011H\u0016J\u001e\u0010$\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00160&H\u0016J\u0018\u0010'\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u001a\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u001a2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006,", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureEnablerFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDebugFeatureEnablerDialogBinding;", "screenKey", "Lapp/dogo/com/dogo_android/debug/DebugFeatureEnablerScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/debug/DebugFeatureEnablerScreen;", "viewModel", "Lapp/dogo/com/dogo_android/debug/DebugFeatureEnablerViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/debug/DebugFeatureEnablerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onBooleanUpdate", "key", "", "value", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDoubleUpdate", "", "onInvalidValue", "onJsonArrayTap", "selectionList", "", "onLongUpdate", "", "onStringUpdate", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j0 extends Fragment implements app.dogo.com.dogo_android.i.n0.b {

    private final h a;
    private cb b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.i.l0> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.i.l0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(l0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public j0() {
        super();
        final int i = 0;
        j0.a aVar = new j0.a(this, i, i);
        this.a = j.a(m.SYNCHRONIZED, aVar);
    }

    private final app.dogo.com.dogo_android.i.l0 B1() {
        return (l0)this.a.getValue();
    }

    public static void C1(app.dogo.com.dogo_android.i.j0 j0, View view2) {
        j0.F1(j0, view2);
    }

    public static void D1(app.dogo.com.dogo_android.i.j0 j0, String string2) {
        j0.E1(j0, string2);
    }

    private static final void E1(app.dogo.com.dogo_android.i.j0 j0, String string2) {
        n.f(j0, "this$0");
        j0.B1().m();
    }

    private static final void F1(app.dogo.com.dogo_android.i.j0 j0, View view2) {
        n.f(j0, "this$0");
        j0.requireActivity().getSupportFragmentManager().Z0();
    }

    @Override // androidx.fragment.app.Fragment
    public void I() {
        Toast.makeText(getContext(), "invalid value", 1).show();
    }

    @Override // androidx.fragment.app.Fragment
    public void K0(String string, String string2) {
        n.f(string, "key");
        n.f(string2, "value");
        B1().l(string, string2);
    }

    @Override // androidx.fragment.app.Fragment
    public void S(String string, double d2) {
        n.f(string, "key");
        B1().l(string, Double.valueOf(d2));
    }

    public void d1(String string, List<String> list2) {
        int i;
        app.dogo.com.dogo_android.i.r0 r0Var;
        androidx.fragment.app.d obj4;
        n.f(string, "key");
        n.f(list2, "selectionList");
        e activity = getActivity();
        if (activity == null) {
            obj4 = i;
        } else {
            r0Var = new r0(string, list2);
            obj4 = g1.X(activity, r0Var);
        }
        if (obj4 instanceof p0) {
            i = obj4;
        }
        if (i == 0) {
        } else {
            obj4 = new x(this);
            i.C1(obj4);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        e activity;
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
        cb obj2 = cb.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.b = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(B1());
            obj2 = this.b;
            if (obj2 == null) {
            } else {
                obj2.V(this);
                obj2 = this.b;
                if (obj2 == null) {
                } else {
                    obj2.M(getViewLifecycleOwner());
                    obj2 = this.b;
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
        cb obj2 = this.b;
        if (obj2 == null) {
        } else {
            w obj3 = new w(this);
            obj2.O.setNavigationOnClickListener(obj3);
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void r1(String string, boolean z2) {
        n.f(string, "key");
        B1().l(string, Boolean.valueOf(z2));
    }

    @Override // androidx.fragment.app.Fragment
    public void v0(String string, long l2) {
        n.f(string, "key");
        B1().l(string, Long.valueOf(l2));
    }
}

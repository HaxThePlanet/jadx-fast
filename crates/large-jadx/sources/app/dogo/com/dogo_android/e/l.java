package app.dogo.com.dogo_android.e;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.u8;
import app.dogo.com.dogo_android.util.h0.f1;
import com.google.android.material.snackbar.Snackbar;
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
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00112\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/clicker/ClickerSelectDialog;", "Landroidx/fragment/app/DialogFragment;", "Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogClickerSelectBinding;", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/DialogClickerSelectBinding;", "setBinding", "(Lapp/dogo/com/dogo_android/databinding/DialogClickerSelectBinding;)V", "viewModel", "Lapp/dogo/com/dogo_android/clicker/ClickerSelectViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/clicker/ClickerSelectViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSelected", "", "position", "", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l extends d implements app.dogo.com.dogo_android.e.k.a {

    private final h a;
    public u8 b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.e.n> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.e.n invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(n.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public l() {
        super();
        final int i = 0;
        l.a aVar = new l.a(this, i, i);
        this.a = j.a(m.SYNCHRONIZED, aVar);
    }

    private final app.dogo.com.dogo_android.e.n C1() {
        return (n)this.a.getValue();
    }

    public static void D1(app.dogo.com.dogo_android.e.l l, Boolean boolean2) {
        l.F1(l, boolean2);
    }

    public static void E1(app.dogo.com.dogo_android.e.l l, Integer integer2) {
        l.G1(l, integer2);
    }

    private static final void F1(app.dogo.com.dogo_android.e.l l, Boolean boolean2) {
        n.f(l, "this$0");
        l.dismiss();
    }

    private static final void G1(app.dogo.com.dogo_android.e.l l, Integer integer2) {
        n.f(l, "this$0");
        n.e(integer2, "it");
        Snackbar.d0(l.B1().w(), integer2.intValue(), 0).T();
    }

    @Override // androidx.fragment.app.d
    public final u8 B1() {
        u8 u8Var = this.b;
        if (u8Var == null) {
        } else {
            return u8Var;
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.d
    public final void H1(u8 u8) {
        n.f(u8, "<set-?>");
        this.b = u8;
    }

    @Override // androidx.fragment.app.d
    public void l(int i) {
        C1().n(i);
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        Object obj1;
        n.f(layoutInflater, "inflater");
        obj1 = u8.T(layoutInflater, viewGroup2, false);
        n.e(obj1, "inflate(inflater, container, false)");
        H1(obj1);
        obj1 = getDialog();
        if (obj1 == null) {
        } else {
            obj1 = obj1.getWindow();
            if (obj1 == null) {
            } else {
                f1.H(obj1);
            }
        }
        B1().W(C1());
        B1().V(this);
        obj1 = B1().w();
        n.e(obj1, "binding.root");
        return obj1;
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        e eVar = new e(this);
        C1().k().observe(getViewLifecycleOwner(), eVar);
        f fVar = new f(this);
        C1().l().observe(getViewLifecycleOwner(), fVar);
    }
}

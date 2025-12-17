package app.dogo.com.dogo_android.view;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.a0.e;
import app.dogo.com.dogo_android.h.s9;
import app.dogo.com.dogo_android.util.h0.k1;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000c2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/view/SharePromptDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogSharePromptBinding;", "viewModel", "Lapp/dogo/com/dogo_android/viewmodel/SharePromptViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/viewmodel/SharePromptViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class p extends d {

    private final h a;
    private s9 b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<e> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final e invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(e.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<a> {

        final app.dogo.com.dogo_android.view.p this$0;
        b(app.dogo.com.dogo_android.view.p p) {
            this.this$0 = p;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b((q)k1.a(this.this$0).getSource());
        }
    }
    static {
    }

    public p() {
        super();
        p.b bVar = new p.b(this);
        p.a aVar = new p.a(this, 0, bVar);
        this.a = j.a(m.SYNCHRONIZED, aVar);
    }

    private final e B1() {
        return (e)this.a.getValue();
    }

    public static void C1(app.dogo.com.dogo_android.view.p p, Boolean boolean2) {
        p.F1(p, boolean2);
    }

    public static void D1(app.dogo.com.dogo_android.view.p p, Intent intent2) {
        p.E1(p, intent2);
    }

    private static final void E1(app.dogo.com.dogo_android.view.p p, Intent intent2) {
        n.f(p, "this$0");
        p.startActivity(Intent.createChooser(intent2, p.getResources().getString(2131887312)));
        p.dismissAllowingStateLoss();
    }

    private static final void F1(app.dogo.com.dogo_android.view.p p, Boolean boolean2) {
        n.f(p, "this$0");
        p.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        int i;
        Object obj5;
        n.f(layoutInflater, "inflater");
        obj5 = getDialog();
        if (obj5 == null) {
        } else {
            obj5 = obj5.getWindow();
            if (obj5 == null) {
            } else {
                obj5.setBackgroundDrawableResource(2131230940);
            }
        }
        obj5 = 0;
        s9 obj3 = s9.T(layoutInflater, viewGroup2, obj5);
        n.e(obj3, "inflate(inflater, container, false)");
        this.b = obj3;
        int obj4 = 0;
        String str = "binding";
        if (obj3 == null) {
        } else {
            obj3.V(B1());
            obj3 = getDialog();
            if (obj3 == null) {
            } else {
                obj3.setCanceledOnTouchOutside(obj5);
            }
            obj3 = this.b;
            if (obj3 == null) {
            } else {
                return obj3.w();
            }
            n.w(str);
            throw obj4;
        }
        n.w(str);
        throw obj4;
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        androidx.lifecycle.q obj4 = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(obj4, str2);
        f fVar = new f(this);
        B1().j().observe(obj4, fVar);
        obj4 = getViewLifecycleOwner();
        n.e(obj4, str2);
        e eVar = new e(this);
        B1().i().observe(obj4, eVar);
    }
}

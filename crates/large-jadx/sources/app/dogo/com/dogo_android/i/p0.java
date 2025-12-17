package app.dogo.com.dogo_android.i;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.k9;
import app.dogo.com.dogo_android.util.h0.k1;
import com.google.android.material.datepicker.k;
import java.util.Iterator;
import java.util.LinkedHashSet;
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
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0014\u001a\u00020\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0008\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0016J\u001a\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u001a2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/debug/JsonArrayEditDialog;", "Landroidx/fragment/app/DialogFragment;", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogJsonArrayEditBinding;", "onSaveListener", "Ljava/util/LinkedHashSet;", "Lcom/google/android/material/datepicker/MaterialPickerOnPositiveButtonClickListener;", "", "screenKey", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/debug/JsonArrayEditScreen;", "viewModel", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/debug/JsonArrayEditViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addOnSaveButtonClickListener", "", "listener", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "", "onItemTap", "item", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditItem;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class p0 extends d implements app.dogo.com.dogo_android.i.o0.a {

    private final h a;
    private k9 b;
    private final LinkedHashSet<k<String>> c;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.i.s0> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.i.s0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(s0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<a> {

        final app.dogo.com.dogo_android.i.p0 this$0;
        b(app.dogo.com.dogo_android.i.p0 p0) {
            this.this$0 = p0;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[2];
            return b.b(p0.B1(this.this$0).a(), p0.B1(this.this$0).b());
        }
    }
    static {
    }

    public p0() {
        super();
        p0.b bVar = new p0.b(this);
        p0.a aVar = new p0.a(this, 0, bVar);
        this.a = j.a(m.SYNCHRONIZED, aVar);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.c = linkedHashSet;
    }

    public static final app.dogo.com.dogo_android.i.r0 B1(app.dogo.com.dogo_android.i.p0 p0) {
        return p0.D1();
    }

    private final app.dogo.com.dogo_android.i.r0 D1() {
        return (r0)k1.a(this);
    }

    private final app.dogo.com.dogo_android.i.s0 E1() {
        return (s0)this.a.getValue();
    }

    public static void F1(app.dogo.com.dogo_android.i.p0 p0, View view2) {
        p0.G1(p0, view2);
    }

    private static final void G1(app.dogo.com.dogo_android.i.p0 p0, View view2) {
        Object next;
        String str;
        n.f(p0, "this$0");
        p0.E1().i();
        Iterator obj3 = p0.c.iterator();
        for (k next : obj3) {
            next.a(p0.D1().a());
        }
        p0.dismiss();
    }

    public final boolean C1(k<String> k) {
        n.f(k, "listener");
        return this.c.add(k);
    }

    @Override // androidx.fragment.app.d
    public void D(app.dogo.com.dogo_android.i.q0 q0) {
        n.f(q0, "item");
        E1().j(q0);
    }

    @Override // androidx.fragment.app.d
    public int getTheme() {
        return 2131952268;
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        k9 obj2 = k9.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.b = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(E1());
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

    @Override // androidx.fragment.app.d
    public void onDestroy() {
        super.onDestroy();
        this.c.clear();
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        k9 obj2 = this.b;
        if (obj2 == null) {
        } else {
            e0 obj3 = new e0(this);
            obj2.P.setOnClickListener(obj3);
        }
        n.w("binding");
        throw 0;
    }
}

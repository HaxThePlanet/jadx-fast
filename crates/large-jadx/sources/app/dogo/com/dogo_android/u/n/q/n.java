package app.dogo.com.dogo_android.u.n.q;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.g9;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.y.j;
import com.google.android.material.datepicker.k;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
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
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0014\u001a\u00020\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0008\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\tH\u0016J\u001a\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u00182\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalDialog;", "Landroidx/fragment/app/DialogFragment;", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogIntervalSelectBinding;", "onDoneListeners", "Ljava/util/LinkedHashSet;", "Lcom/google/android/material/datepicker/MaterialPickerOnPositiveButtonClickListener;", "", "screenKey", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalScreen;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addOnDoneButtonClickListener", "", "listener", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "", "onIntervalSelected", "selection", "onViewCreated", "view", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n extends d implements app.dogo.com.dogo_android.u.n.q.m.a {

    public static final app.dogo.com.dogo_android.u.n.q.n.a Companion;
    private g9 a;
    private final h b;
    private final LinkedHashSet<k<Long>> c;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalDialog$Companion;", "", "()V", "newInstance", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalDialog;", "screen", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalScreen;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.u.n.q.n a(app.dogo.com.dogo_android.u.n.q.o o) {
            n.f(o, "screen");
            return (n)o.newFragment();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<app.dogo.com.dogo_android.u.n.q.p> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.u.n.q.p invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(p.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<a> {

        final app.dogo.com.dogo_android.u.n.q.n this$0;
        c(app.dogo.com.dogo_android.u.n.q.n n) {
            this.this$0 = n;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b(n.B1(this.this$0).a());
        }
    }
    static {
        n.a aVar = new n.a(0);
        n.Companion = aVar;
    }

    public n() {
        super();
        n.c cVar = new n.c(this);
        n.b bVar = new n.b(this, 0, cVar);
        this.b = j.a(m.SYNCHRONIZED, bVar);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.c = linkedHashSet;
    }

    public static final app.dogo.com.dogo_android.u.n.q.o B1(app.dogo.com.dogo_android.u.n.q.n n) {
        return n.D1();
    }

    private final app.dogo.com.dogo_android.u.n.q.o D1() {
        return (o)k1.a(this);
    }

    private final app.dogo.com.dogo_android.u.n.q.p E1() {
        return (p)this.b.getValue();
    }

    public static void F1(app.dogo.com.dogo_android.u.n.q.n n, View view2) {
        n.G1(n, view2);
    }

    private static final void G1(app.dogo.com.dogo_android.u.n.q.n n, View view2) {
        n.f(n, "this$0");
        n.dismiss();
    }

    public final boolean C1(k<Long> k) {
        n.f(k, "listener");
        return this.c.add(k);
    }

    @Override // androidx.fragment.app.d
    public void L(long l) {
        Object next;
        Long valueOf;
        Iterator iterator = this.c.iterator();
        for (k next : iterator) {
            next.a(Long.valueOf(l));
        }
        dismiss();
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        Object obj4;
        n.f(layoutInflater, "inflater");
        obj4 = getDialog();
        if (obj4 == null) {
        } else {
            obj4 = obj4.getWindow();
            if (obj4 == null) {
            } else {
                f1.H(obj4);
            }
        }
        g9 obj2 = g9.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(E1());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.M(getViewLifecycleOwner());
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.V(this);
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

    @Override // androidx.fragment.app.d
    public void onDestroy() {
        super.onDestroy();
        this.c.clear();
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        g9 obj2 = this.a;
        if (obj2 == null) {
        } else {
            i obj3 = new i(this);
            obj2.O.setOnClickListener(obj3);
        }
        n.w("binding");
        throw 0;
    }
}

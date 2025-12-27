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
import com.google.android.material.datepicker.k;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.m;

/* compiled from: ReminderIntervalDialog.kt */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0014\u001a\u00020\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0008\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\tH\u0016J\u001a\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u00182\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalDialog;", "Landroidx/fragment/app/DialogFragment;", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogIntervalSelectBinding;", "onDoneListeners", "Ljava/util/LinkedHashSet;", "Lcom/google/android/material/datepicker/MaterialPickerOnPositiveButtonClickListener;", "", "screenKey", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalScreen;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addOnDoneButtonClickListener", "", "listener", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "", "onIntervalSelected", "selection", "onViewCreated", "view", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n, reason: from kotlin metadata */
public final class ReminderIntervalDialog extends d implements m.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final n.a INSTANCE = new n$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private g9 binding;
    /* renamed from: b, reason: from kotlin metadata */
    private final h onDoneListeners;
    private final LinkedHashSet<k<Long>> c = new LinkedHashSet<>();

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalDialog$Companion;", "", "()V", "newInstance", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalDialog;", "screen", "Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalScreen;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public final n newInstance(o screen) {
            n.f(screen, "screen");
            return (ReminderIntervalDialog)screen.newFragment();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<p> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final p invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ReminderIntervalViewModel.class), this.$parameters);
        }

        public b(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { n.this.onDestroy().createFragment() });
        }

        c() {
            super(0);
        }
    }

    public n() {
        super();
        this.onDoneListeners = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.specialprograms.potty.reminders.n.b(this, null, new app.dogo.com.dogo_android.specialprograms.potty.reminders.n.c(this)));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ o addOnDoneButtonClickListener(n listener) {
        return listener.onDestroy();
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final o onDestroy() {
        return (ReminderIntervalScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final p E1() {
        return (ReminderIntervalViewModel)this.onDoneListeners.getValue();
    }

    private static final void G1(n nVar, View view) {
        n.f(nVar, "this$0");
        nVar.dismiss();
    }

    @Override // androidx.fragment.app.d
    /* renamed from: C1, reason: from kotlin metadata */
    public final boolean onIntervalSelected(k<Long> selection) {
        n.f(selection, "listener");
        return this.c.add(selection);
    }

    @Override // androidx.fragment.app.d
    public void L(long j) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            (k)it.next().a(Long.valueOf(j));
        }
        dismiss();
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            android.view.Window window = dialog.getWindow();
            if (window != null) {
                app.dogo.com.dogo_android.util.extensionfunction.f1.callZendeskDialog(window);
            }
        }
        g9 g9Var = g9.T(inflater, container, false);
        n.e(g9Var, "inflate(inflater, container, false)");
        this.binding = g9Var;
        int i = 0;
        String str4 = "binding";
        if (g9Var == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            g9Var.W(E1());
            if (this.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.M(getViewLifecycleOwner());
                if (this.binding == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.binding.V(this);
                    if (this.binding == null) {
                        n.w(str4);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        View view = this.binding.w();
                        n.e(view, "binding.root");
                        return view;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.d
    public void onDestroy() {
        super.onDestroy();
        this.c.clear();
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.O.setOnClickListener(new app.dogo.com.dogo_android.specialprograms.potty.reminders.i(this));
            return;
        }
    }

    /* renamed from: F1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(n view, View savedInstanceState) {
        ReminderIntervalDialog.G1(view, savedInstanceState);
    }
}

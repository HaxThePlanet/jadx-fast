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
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* compiled from: JsonArrayEditDialog.kt */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0014\u001a\u00020\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0008\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0016J\u001a\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u001a2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\t0\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/debug/JsonArrayEditDialog;", "Landroidx/fragment/app/DialogFragment;", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogJsonArrayEditBinding;", "onSaveListener", "Ljava/util/LinkedHashSet;", "Lcom/google/android/material/datepicker/MaterialPickerOnPositiveButtonClickListener;", "", "screenKey", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/debug/JsonArrayEditScreen;", "viewModel", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/debug/JsonArrayEditViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addOnSaveButtonClickListener", "", "listener", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "", "onItemTap", "item", "Lapp/dogo/com/dogo_android/debug/JsonArrayEditItem;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: p0, reason: from kotlin metadata */
public final class JsonArrayEditDialog extends d implements o0.a {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    /* renamed from: b, reason: from kotlin metadata */
    private k9 onSaveListener;
    private final LinkedHashSet<k<String>> c = new LinkedHashSet<>();

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<s0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final s0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(JsonArrayEditViewModel.class), this.$parameters);
        }

        public a(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[2];
            return org.koin.core.parameter.b.b(new Object[] { p0.this.getTheme().createFragment(), p0.this.getTheme().b() });
        }

        b() {
            super(0);
        }
    }
    public p0() {
        super();
        this.binding = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.debug.p0.a(this, null, new app.dogo.com.dogo_android.debug.p0.b(this)));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ r0 addOnSaveButtonClickListener(p0 listener) {
        return listener.getTheme();
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final r0 getTheme() {
        return (JsonArrayEditScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final s0 E1() {
        return (JsonArrayEditViewModel)this.binding.getValue();
    }

    private static final void G1(p0 p0Var, View view) {
        n.f(p0Var, "this$0");
        p0Var.E1().i();
        Iterator it = p0Var.c.iterator();
        while (it.hasNext()) {
            (k)it.next().a(p0Var.getTheme().createFragment());
        }
        p0Var.dismiss();
    }

    @Override // androidx.fragment.app.d
    /* renamed from: C1, reason: from kotlin metadata */
    public final boolean onItemTap(k<String> item) {
        n.f(item, "listener");
        return this.c.add(item);
    }

    @Override // androidx.fragment.app.d
    public void D(q0 q0Var) {
        n.f(q0Var, "item");
        E1().updateSelectedItem(q0Var);
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        k9 k9Var = k9.T(inflater, container, false);
        n.e(k9Var, "inflate(inflater, container, false)");
        this.onSaveListener = k9Var;
        int i = 0;
        String str4 = "binding";
        if (k9Var == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            k9Var.W(E1());
            if (this.onSaveListener == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.onSaveListener.V(this);
                if (this.onSaveListener == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.onSaveListener.M(getViewLifecycleOwner());
                    if (this.onSaveListener == null) {
                        n.w(str4);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        View view = this.onSaveListener.w();
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
        if (this.onSaveListener == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            onSaveListener2.P.setOnClickListener(new app.dogo.com.dogo_android.debug.e0(this));
            return;
        }
    }


    /* renamed from: F1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(p0 view, View savedInstanceState) {
        JsonArrayEditDialog.G1(view, savedInstanceState);
    }

    @Override // androidx.fragment.app.d
    public int getTheme() {
        return R.style.RoundedCornersDialog;
    }
}

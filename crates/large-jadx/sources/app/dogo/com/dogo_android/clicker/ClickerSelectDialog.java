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
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;

/* compiled from: ClickerSelectDialog.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00112\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/clicker/ClickerSelectDialog;", "Landroidx/fragment/app/DialogFragment;", "Lapp/dogo/com/dogo_android/clicker/ClickerSelectAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogClickerSelectBinding;", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/DialogClickerSelectBinding;", "setBinding", "(Lapp/dogo/com/dogo_android/databinding/DialogClickerSelectBinding;)V", "viewModel", "Lapp/dogo/com/dogo_android/clicker/ClickerSelectViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/clicker/ClickerSelectViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSelected", "", "position", "", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final class ClickerSelectDialog extends d implements k.a {

    private final h a;
    public u8 b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<n> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final n invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ClickerSelectViewModel.class), this.$parameters);
        }

        public a(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public l() {
        super();
        final m.a.c.j.a aVar2 = null;
        this.a = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.clicker.l.a(this, aVar2, aVar2));
    }

    private final n C1() {
        return (ClickerSelectViewModel)this.a.getValue();
    }

    private static final void F1(l lVar, Boolean boolean) {
        n.f(lVar, "this$0");
        lVar.dismiss();
    }

    private static final void G1(l lVar, Integer integer) {
        n.f(lVar, "this$0");
        n.e(integer, "it");
        Snackbar.d0(lVar.B1().w(), integer.intValue(), 0).T();
    }

    @Override // androidx.fragment.app.d
    public final u8 B1() {
        if (this.b == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.b;
        }
    }

    @Override // androidx.fragment.app.d
    /* renamed from: H1, reason: from kotlin metadata */
    public final void onSelected(u8 position) {
        n.f(position, "<set-?>");
        this.b = position;
    }

    @Override // androidx.fragment.app.d
    public void l(int i) {
        C1().soundChoice(i);
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        u8 u8Var = u8.T(inflater, container, false);
        n.e(u8Var, "inflate(inflater, container, false)");
        onSelected(u8Var);
        Dialog dialog = getDialog();
        if (dialog != null) {
            android.view.Window window = dialog.getWindow();
            if (window != null) {
                app.dogo.com.dogo_android.util.extensionfunction.f1.callZendeskDialog(window);
            }
        }
        B1().W(C1());
        B1().V(this);
        View view = B1().w();
        n.e(view, "binding.root");
        return view;
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        C1().k().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.clicker.e(this));
        C1().l().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.clicker.f(this));
    }


    /* renamed from: D1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(l view, Boolean savedInstanceState) {
        ClickerSelectDialog.F1(view, savedInstanceState);
    }

    public static /* synthetic */ void E1(l lVar, Integer integer) {
        ClickerSelectDialog.G1(lVar, integer);
    }
}

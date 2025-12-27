package app.dogo.com.dogo_android.t.h0;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.m9;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* compiled from: LanguageSelectDialog.kt */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00112\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0008\u0010\u001f\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/settings/language/LanguageSelectDialog;", "Landroidx/fragment/app/DialogFragment;", "Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogLanguageSelectBinding;", "screenKey", "Lapp/dogo/com/dogo_android/settings/language/LanguageSelectScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/settings/language/LanguageSelectScreen;", "viewModel", "Lapp/dogo/com/dogo_android/settings/language/LanguageSelectViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/settings/language/LanguageSelectViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "", "onLanguageSelected", "language", "", "onViewCreated", "view", "setupObserver", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class LanguageSelectDialog extends d implements i.a {

    /* renamed from: a, reason: from kotlin metadata */
    private m9 binding;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final l invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(LanguageSelectViewModel.class), this.$parameters);
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
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { Boolean.valueOf(j.this.onDestroy().a()) });
        }

        b() {
            super(0);
        }
    }
    public j() {
        super();
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.settings.language.j.a(this, null, new app.dogo.com.dogo_android.settings.language.j.b(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ k onLanguageSelected(j language) {
        return language.onDestroy();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    private final k onDestroy() {
        return (LanguageSelectScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final l D1() {
        return (LanguageSelectViewModel)this.b.getValue();
    }

    private static final void G1(j jVar, View view) {
        n.f(jVar, "this$0");
        jVar.D1().detachListener();
    }

    private final void H1() {
        D1().s().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.settings.language.b(this));
    }

    private static final void I1(j jVar, y yVar) {
        com.google.android.play.core.splitinstall.d component1;
        boolean z;
        androidx.fragment.app.e requireActivity = null;
        int i = 0;
        int i2 = 0;
        com.google.android.play.core.splitinstall.a aVar;
        n.f(jVar, "this$0");
        if (yVar instanceof LoadResult_Error) {
            jVar.D1().o();
            z = yVar.component1() instanceof ConnectException;
            if (yVar.component1() instanceof ConnectException) {
                androidx.fragment.app.e activity = jVar.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, 2131886953);
                }
            } else {
                activity = jVar.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, 2131886123);
                }
            }
            a.d(yVar.component1());
        } else {
            boolean z3 = yVar instanceof LoadResult_Success;
            if (z3) {
                jVar.D1().o();
                i2 = 0;
                yVar = z3 ? (oadResult_Success)yVar : 0;
                if (i2 != 0) {
                }
                if (i2 instanceof LanguageConfirmCommandItem) {
                    i2 = 10100;
                    jVar.D1().t().a(i2.component1(), jVar.requireActivity(), i2);
                } else {
                    if (i2 instanceof LanguageSelectedCommandItem) {
                        if (i2.component1().length() > 0) {
                            i = 1;
                        }
                        if (i != 0) {
                            App.INSTANCE.y(i2.component1());
                        }
                    }
                }
                jVar.dismiss();
            } else {
                a.a("Unsupported command", new Object[0]);
            }
        }
    }

    @Override // androidx.fragment.app.d
    public void P(String str) {
        n.f(str, "language");
        D1().C(str);
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
        m9 m9Var = m9.T(inflater, container, false);
        n.e(m9Var, "inflate(inflater, container, false)");
        this.binding = m9Var;
        int i = 0;
        String str4 = "binding";
        if (m9Var == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            m9Var.W(D1());
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
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            activity.recreate();
        }
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
            binding2.P.setOnClickListener(new app.dogo.com.dogo_android.settings.language.c(this));
            H1();
            return;
        }
    }


    /* renamed from: E1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(j view, y savedInstanceState) {
        LanguageSelectDialog.I1(view, savedInstanceState);
    }

    public static /* synthetic */ void F1(j jVar, View view) {
        LanguageSelectDialog.G1(jVar, view);
    }
}

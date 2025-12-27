package app.dogo.com.dogo_android.u.n.p.m;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.w8;
import app.dogo.com.dogo_android.repository.domain.DogLog;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.j;
import kotlin.m;

/* compiled from: DogLogSelectDialog.kt */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectDialog;", "Landroidx/fragment/app/DialogFragment;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter$DogLogSelectCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogDogLogSelectBinding;", "screenKey", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectScreen;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "", "dogLog", "Lapp/dogo/com/dogo_android/repository/domain/DogLog;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class DogLogSelectDialog extends d implements b.a {

    /* renamed from: a, reason: from kotlin metadata */
    private w8 binding;
    private final kotlin.h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<e> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final e invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DogLogSelectViewModel.class), this.$parameters);
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
            return org.koin.core.parameter.b.b(new Object[] { c.this.getTheme().createFragment() });
        }

        b() {
            super(0);
        }
    }
    public c() {
        super();
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.specialprograms.potty.calendar.logselect.c.a(this, null, new app.dogo.com.dogo_android.specialprograms.potty.calendar.logselect.c.b(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ d onItemClick(c dogLog) {
        return dogLog.getTheme();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    private final d getTheme() {
        return (DogLogSelectScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final e D1() {
        return (DogLogSelectViewModel)this.b.getValue();
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
        w8 w8Var = w8.T(inflater, container, false);
        n.e(w8Var, "inflate(inflater, container, false)");
        this.binding = w8Var;
        int i = 0;
        String str4 = "binding";
        if (w8Var == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            w8Var.W(D1());
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
                    this.binding.M(getViewLifecycleOwner());
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
    public void s0(DogLog dogLog) {
        n.f(dogLog, "dogLog");
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            String str2 = null;
            int i = 16;
            kotlin.d0.d.g gVar = null;
            str = "calendar";
            DogLogEditScreen dogLog2 = new DogLogEditScreen(str, Long.valueOf(dogLog.getEventTimeMs()), dogLog.getType(), dogLog.getLogId(), str2, i, gVar);
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, dogLog2);
        }
        dismissAllowingStateLoss();
    }


    @Override // androidx.fragment.app.d
    public int getTheme() {
        return R.style.DogParentsDialog;
    }
}

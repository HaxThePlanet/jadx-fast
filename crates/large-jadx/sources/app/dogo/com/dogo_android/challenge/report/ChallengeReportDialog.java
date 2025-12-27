package app.dogo.com.dogo_android.d.e;

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
import app.dogo.com.dogo_android.h.q8;
import app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo;
import app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo.ReportType;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import com.google.android.material.datepicker.k;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* compiled from: ChallengeReportDialog.kt */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u001c\u001a\u00020\u001d2\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bJ$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0008\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0008\u0010'\u001a\u00020(H\u0016J\u001a\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020 2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0015\u0010\u0016\u001a\u0004\u0008\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u001b\u0010\u0016\u001a\u0004\u0008\u0019\u0010\u001a¨\u0006+", d2 = {"Lapp/dogo/com/dogo_android/challenge/report/ChallengeReportDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogChallengeReportBinding;", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/DialogChallengeReportBinding;", "setBinding", "(Lapp/dogo/com/dogo_android/databinding/DialogChallengeReportBinding;)V", "onReportListeners", "Ljava/util/LinkedHashSet;", "Lcom/google/android/material/datepicker/MaterialPickerOnPositiveButtonClickListener;", "", "screenKey", "Lapp/dogo/com/dogo_android/challenge/report/ChallengeReportScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/challenge/report/ChallengeReportScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/challenge/report/ChallengeReportViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/challenge/report/ChallengeReportViewModel;", "viewModel$delegate", "addOnReportButtonClickListener", "", "listener", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class ChallengeReportDialog extends d {

    private final h a;
    /* renamed from: b, reason: from kotlin metadata */
    private final h onReportListeners;
    public q8 c;
    private final LinkedHashSet<k<String>> v = new LinkedHashSet<>();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[ChallengeReportInfo_ReportType.values().length];
            iArr[ChallengeReportInfo_ReportType.COMMENT.ordinal()] = 1;
            iArr[ChallengeReportInfo_ReportType.ENTRY.ordinal()] = 2;
            app.dogo.com.dogo_android.challenge.report.c.a.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public b(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements kotlin.d0.c.a<e> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final e invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ChallengeReportViewModel.class), this.$parameters);
        }

        public c(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { c.this.onDestroy().createFragment() });
        }

        d() {
            super(0);
        }
    }
    public c() {
        super();
        final m.a.c.j.a aVar = null;
        this.a = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.challenge.report.c.c(this, aVar, new app.dogo.com.dogo_android.challenge.report.c.d(this)));
        this.onReportListeners = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.challenge.report.c.b(this, aVar, aVar));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ d addOnReportButtonClickListener(c listener) {
        return listener.onDestroy();
    }

    /* renamed from: E1, reason: from kotlin metadata */
    private final d onDestroy() {
        return (ChallengeReportScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private static final void I1(c cVar, View view) throws NoWhenBranchMatchedException {
        int i = 2131886280;
        String commentId;
        int i2 = 2;
        n.f(cVar, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.k1.c(cVar);
        cVar.F1().saveReport();
        androidx.fragment.app.e activity = cVar.getActivity();
        if (activity != null) {
            i = 2131886280;
            app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, i);
        }
        Iterator it = cVar.v.iterator();
        while (it.hasNext()) {
            int i3 = app.dogo.com.dogo_android.challenge.report.c.a.a[cVar.onDestroy().createFragment().getReportType().ordinal()];
            i2 = 1;
            if (i3 != 1) {
                i2 = 2;
            }
        }
        cVar.dismiss();
    }

    private static final void J1(c cVar, View view) {
        n.f(cVar, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.k1.c(cVar);
        cVar.dismiss();
    }

    @Override // androidx.fragment.app.d
    public final boolean C1(k<String> kVar) {
        n.f(kVar, "listener");
        return this.v.add(kVar);
    }

    @Override // androidx.fragment.app.d
    public final q8 D1() {
        if (this.c == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return this.c;
        }
    }

    @Override // androidx.fragment.app.d
    public final e F1() {
        return (ChallengeReportViewModel)this.a.getValue();
    }

    @Override // androidx.fragment.app.d
    public final void K1(q8 q8Var) {
        n.f(q8Var, "<set-?>");
        this.c = q8Var;
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            android.view.Window window = dialog2.getWindow();
            if (window != null) {
                app.dogo.com.dogo_android.util.extensionfunction.f1.callZendeskDialog(window);
            }
        }
        boolean z = false;
        q8 q8Var = q8.T(inflater, container, z);
        n.e(q8Var, "inflate(inflater, container, false)");
        K1(q8Var);
        D1().V(F1());
        D1().M(getViewLifecycleOwner());
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(z);
        }
        View view = D1().w();
        n.e(view, "binding.root");
        return view;
    }

    @Override // androidx.fragment.app.d
    public void onDestroy() {
        super.onDestroy();
        this.v.clear();
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        D1().Q.setOnClickListener(new app.dogo.com.dogo_android.challenge.report.a(this));
        D1().O.setOnClickListener(new app.dogo.com.dogo_android.challenge.report.b(this));
    }


    /* renamed from: G1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(c view, View savedInstanceState) {
        ChallengeReportDialog.I1(view, savedInstanceState);
    }

    public static /* synthetic */ void H1(c cVar, View view) {
        ChallengeReportDialog.J1(cVar, view);
    }
}

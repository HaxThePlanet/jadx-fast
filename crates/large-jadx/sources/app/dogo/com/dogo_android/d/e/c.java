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
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u001c\u001a\u00020\u001d2\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bJ$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0008\u0010#\u001a\u0004\u0018\u00010$2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0008\u0010'\u001a\u00020(H\u0016J\u001a\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020 2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0015\u0010\u0016\u001a\u0004\u0008\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u001b\u0010\u0016\u001a\u0004\u0008\u0019\u0010\u001a¨\u0006+", d2 = {"Lapp/dogo/com/dogo_android/challenge/report/ChallengeReportDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogChallengeReportBinding;", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/DialogChallengeReportBinding;", "setBinding", "(Lapp/dogo/com/dogo_android/databinding/DialogChallengeReportBinding;)V", "onReportListeners", "Ljava/util/LinkedHashSet;", "Lcom/google/android/material/datepicker/MaterialPickerOnPositiveButtonClickListener;", "", "screenKey", "Lapp/dogo/com/dogo_android/challenge/report/ChallengeReportScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/challenge/report/ChallengeReportScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/challenge/report/ChallengeReportViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/challenge/report/ChallengeReportViewModel;", "viewModel$delegate", "addOnReportButtonClickListener", "", "listener", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends d {

    private final h a;
    private final h b;
    public q8 c;
    private final LinkedHashSet<k<String>> v;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[ChallengeReportInfo.ReportType.COMMENT.ordinal()] = 1;
            iArr[ChallengeReportInfo.ReportType.ENTRY.ordinal()] = 2;
            c.a.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public b(Fragment fragment, a a2, a a3) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(l.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements a<app.dogo.com.dogo_android.d.e.e> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public c(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.d.e.e invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(e.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<a> {

        final app.dogo.com.dogo_android.d.e.c this$0;
        d(app.dogo.com.dogo_android.d.e.c c) {
            this.this$0 = c;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b(c.B1(this.this$0).a());
        }
    }
    static {
    }

    public c() {
        super();
        c.d dVar = new c.d(this);
        final int i = 0;
        c.c cVar = new c.c(this, i, dVar);
        this.a = j.a(m.SYNCHRONIZED, cVar);
        c.b bVar = new c.b(this, i, i);
        this.b = j.a(m.NONE, bVar);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.v = linkedHashSet;
    }

    public static final app.dogo.com.dogo_android.d.e.d B1(app.dogo.com.dogo_android.d.e.c c) {
        return c.E1();
    }

    private final app.dogo.com.dogo_android.d.e.d E1() {
        return (d)k1.a(this);
    }

    public static void G1(app.dogo.com.dogo_android.d.e.c c, View view2) {
        c.I1(c, view2);
    }

    public static void H1(app.dogo.com.dogo_android.d.e.c c, View view2) {
        c.J1(c, view2);
    }

    private static final void I1(app.dogo.com.dogo_android.d.e.c c, View view2) {
        int next;
        String commentId;
        int i;
        n.f(c, "this$0");
        k1.c(c);
        c.F1().h();
        androidx.fragment.app.e obj4 = c.getActivity();
        if (obj4 == null) {
        } else {
            g1.g0(obj4, 2131886280);
        }
        obj4 = c.v.iterator();
        for (k next : obj4) {
            int i2 = c.a.a[c.E1().a().getReportType().ordinal()];
            commentId = c.E1().a().getCommentId();
            next.a(commentId);
            commentId = c.E1().a().getEntryId();
        }
        c.dismiss();
    }

    private static final void J1(app.dogo.com.dogo_android.d.e.c c, View view2) {
        n.f(c, "this$0");
        k1.c(c);
        c.dismiss();
    }

    public final boolean C1(k<String> k) {
        n.f(k, "listener");
        return this.v.add(k);
    }

    @Override // androidx.fragment.app.d
    public final q8 D1() {
        q8 q8Var = this.c;
        if (q8Var == null) {
        } else {
            return q8Var;
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.d
    public final app.dogo.com.dogo_android.d.e.e F1() {
        return (e)this.a.getValue();
    }

    @Override // androidx.fragment.app.d
    public final void K1(q8 q8) {
        n.f(q8, "<set-?>");
        this.c = q8;
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        Object obj3;
        n.f(layoutInflater, "inflater");
        obj3 = getDialog();
        if (obj3 == null) {
        } else {
            obj3 = obj3.getWindow();
            if (obj3 == null) {
            } else {
                f1.H(obj3);
            }
        }
        obj3 = 0;
        q8 obj1 = q8.T(layoutInflater, viewGroup2, obj3);
        n.e(obj1, "inflate(inflater, container, false)");
        K1(obj1);
        D1().V(F1());
        D1().M(getViewLifecycleOwner());
        obj1 = getDialog();
        if (obj1 == null) {
        } else {
            obj1.setCanceledOnTouchOutside(obj3);
        }
        obj1 = D1().w();
        n.e(obj1, "binding.root");
        return obj1;
    }

    @Override // androidx.fragment.app.d
    public void onDestroy() {
        super.onDestroy();
        this.v.clear();
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        a obj3 = new a(this);
        obj2.Q.setOnClickListener(obj3);
        obj3 = new b(this);
        obj2.O.setOnClickListener(obj3);
    }
}

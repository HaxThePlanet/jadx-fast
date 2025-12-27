package app.dogo.com.dogo_android.inappmessaging;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.od;
import app.dogo.com.dogo_android.service.q2.a;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;

/* compiled from: InAppOneTenFragmentDialog.kt */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/inappmessaging/InAppOneTenFragmentDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentInnAppOneTenBinding;", "viewModel", "Lapp/dogo/com/dogo_android/inappmessaging/InAppOneTenViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/inappmessaging/InAppOneTenViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final class InAppOneTenFragmentDialog extends d {

    /* renamed from: a, reason: from kotlin metadata */
    private od binding;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<n> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final n invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(InAppOneTenViewModel.class), this.$parameters);
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
            app.dogo.com.dogo_android.y.j jVar = app.dogo.com.dogo_android.util.extensionfunction.k1.a(l.this);
            Object[] arr = new Object[3];
            return org.koin.core.parameter.b.b(new Object[] { jVar.c(), jVar.b(), jVar.createFragment() });
        }

        b() {
            super(0);
        }
    }
    public l() {
        super();
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new l.a(this, null, new l.b(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    private final n getTheme() {
        return (InAppOneTenViewModel)this.b.getValue();
    }

    private static final void E1(l lVar, View view) {
        n.f(lVar, "this$0");
        lVar.dismiss();
    }

    private static final void F1(l lVar, View view) throws android.content.res.Resources.NotFoundException {
        int i = 1;
        int i2 = 2131886767;
        int i4 = 10;
        boolean z;
        n.f(lVar, "this$0");
        if (lVar.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            int rating = binding2.S.getRating();
            i = 1;
            i = 0;
            int r2 = i;
            if (i != 0) {
                androidx.fragment.app.e requireActivity = lVar.requireActivity();
                n.e(requireActivity, "requireActivity()");
                app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(requireActivity, new InAppFeedbackScreen(rating, (InAppOneTenScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(lVar).c(), (InAppOneTenScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(lVar).b(), (InAppOneTenScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(lVar).createFragment()));
                lVar.dismiss();
            } else {
                i4 = 6;
                if (6 > rating || rating > 10) {
                }
                if (i != 0) {
                    lVar.getTheme().update(rating);
                    i2 = 2131886767;
                    Toast.makeText(lVar.requireActivity().getApplicationContext(), i2, i).show();
                    if (lVar.getTheme().i()) {
                        androidx.fragment.app.e activity = lVar.getActivity();
                        if (activity != null) {
                            app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(activity, new RatePromptV2Screen(RateItService_RateSource.USER_SCORE_RATE.getTag()));
                        }
                    }
                    lVar.dismiss();
                }
            }
            return;
        }
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        od odVar = od.T(inflater, container, false);
        n.e(odVar, "inflate(inflater, container, false)");
        this.binding = odVar;
        int i = 0;
        String str3 = "binding";
        if (odVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            odVar.V(getTheme());
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.M(getViewLifecycleOwner());
                if (this.binding == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    return this.binding.w();
                }
            }
        }
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle) throws g {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        int i = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.R.setOnClickListener(new h(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.T.setOnClickListener(new g(this));
                return;
            }
        }
    }


    /* renamed from: C1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(l view, View savedInstanceState) {
        InAppOneTenFragmentDialog.F1(view, savedInstanceState);
    }

    public static /* synthetic */ void D1(l lVar, View view) {
        InAppOneTenFragmentDialog.E1(lVar, view);
    }

    @Override // androidx.fragment.app.d
    public int getTheme() {
        return R.style.RoundedCornersDialog;
    }
}

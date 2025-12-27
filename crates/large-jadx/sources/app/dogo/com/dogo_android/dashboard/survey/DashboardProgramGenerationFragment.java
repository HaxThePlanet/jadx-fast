package app.dogo.com.dogo_android.g.g0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.d;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.y;
import app.dogo.com.dogo_android.h.wa;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y.a;
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
import kotlin.w;

/* compiled from: DashboardProgramGenerationFragment.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/dashboard/survey/DashboardProgramGenerationFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDashboardProgramGenerationBinding;", "screenKey", "Lapp/dogo/com/dogo_android/dashboard/survey/DashboardProgramGenerationScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/dashboard/survey/DashboardProgramGenerationScreen;", "viewModel", "Lapp/dogo/com/dogo_android/dashboard/survey/DashboardProgramGenerationViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/dashboard/survey/DashboardProgramGenerationViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final class DashboardProgramGenerationFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private wa b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a<T> implements y<T> {

        final /* synthetic */ f a;
        public final void onChanged(T t) {
            Exception component1 = null;
            int i;
            z = t instanceof LoadResult_Error;
            t = t instanceof oadResult_Error ? (oadResult_Error)t : 0;
            if (i != 0) {
                component1 = i.component1();
            }
            z2 = component1 instanceof UnknownHostException;
            if (component1 instanceof UnknownHostException) {
                androidx.fragment.app.e activity = this.a.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.f1.h0(activity, new app.dogo.com.dogo_android.dashboard.survey.f.c(this.a));
                }
            }
        }

        public a() {
            this.a = fVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/dashboard/survey/DashboardProgramGenerationFragment$onViewCreated$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends d {
        b() {
            super(true);
        }

        @Override // androidx.activity.d
        /* renamed from: b, reason: from kotlin metadata */
        public void handleOnBackPressed() {
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            f.this.C1().n();
        }

        c() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements kotlin.d0.c.a<h> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final h invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DashboardProgramGenerationViewModel.class), this.$parameters);
        }

        public d(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { (DashboardProgramGenerationScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(f.this).createFragment() });
        }

        e() {
            super(0);
        }
    }
    public f() {
        super();
        this.binding = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.dashboard.survey.f.d(this, null, new app.dogo.com.dogo_android.dashboard.survey.f.e(this)));
    }

    public static final /* synthetic */ h B1(f fVar) {
        return fVar.C1();
    }

    private final h C1() {
        return (DashboardProgramGenerationViewModel)this.binding.getValue();
    }

    private static final void E1(f fVar, Boolean boolean) {
        n.f(fVar, "this$0");
        final androidx.fragment.app.e activity = fVar.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        wa waVar = wa.T(inflater, container, false);
        n.e(waVar, "inflate(inflater, container, false)");
        this.b = waVar;
        int i = 0;
        String str3 = "binding";
        if (waVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            waVar.V(C1());
            if (this.b == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.b.M(getViewLifecycleOwner());
                if (this.b == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    return this.b.w();
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        androidx.fragment.app.e activity = null;
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        view = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.F();
        }
        requireActivity().getOnBackPressedDispatcher().b(getViewLifecycleOwner(), new DashboardProgramGenerationFragment_onViewCreated_1());
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(viewLifecycleOwner2, str2);
        C1().i().observe(viewLifecycleOwner2, new app.dogo.com.dogo_android.dashboard.survey.a(this));
        androidx.lifecycle.q viewLifecycleOwner3 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner3, str2);
        C1().getResult().observe(viewLifecycleOwner3, new app.dogo.com.dogo_android.dashboard.survey.f.a(this));
    }


    /* renamed from: D1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(f view, Boolean savedInstanceState) {
        DashboardProgramGenerationFragment.E1(view, savedInstanceState);
    }
}

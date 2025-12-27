package app.dogo.com.dogo_android.y.e0;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.d;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.eg;
import app.dogo.com.dogo_android.n.m.n.b;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.s.k;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.h;

/* compiled from: ProgramTrickTryFragment.kt */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000cR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0013\u0010\u000e\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/tricktry/ProgramTrickTryFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramTrickTryBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/tricktry/ProgramTrickTryScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/tricktry/ProgramTrickTryScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/tricktry/ProgramTrickTryViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/tricktry/ProgramTrickTryViewModel;", "viewModel$delegate", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class ProgramTrickTryFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private eg binding;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/trainingprogram/tricktry/ProgramTrickTryFragment$onCreateView$3", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends d {
        a() {
            super(true);
        }

        @Override // androidx.activity.d
        /* renamed from: b, reason: from kotlin metadata */
        public void handleOnBackPressed() {
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.d0.d.p implements kotlin.d0.c.a<l> {

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
    public static final class c extends kotlin.d0.d.p implements kotlin.d0.c.a<e> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final e invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ProgramTrickTryViewModel.class), this.$parameters);
        }

        public c(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[2];
            return org.koin.core.parameter.b.b(new Object[] { p.X(c.this.C1().b().getTrainingTricksList()), c.this.C1().createFragment() });
        }

        d() {
            super(0);
        }
    }
    public c() {
        super();
        final m.a.c.j.a aVar = null;
        this.b = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.trainingprogram.tricktry.c.b(this, aVar, aVar));
        this.c = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.trainingprogram.tricktry.c.c(this, aVar, new app.dogo.com.dogo_android.trainingprogram.tricktry.c.d(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ d onAttach(c context) {
        return context.C1();
    }

    private final d C1() {
        return (ProgramTrickTryScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final e D1() {
        return (ProgramTrickTryViewModel)this.c.getValue();
    }

    private static final void G1(c cVar, View view) {
        n.f(cVar, "this$0");
        cVar.D1().j();
        ProgramLessonScreen cVar2 = new ProgramLessonScreen(cVar.C1().createFragment().getLessonId(), cVar.C1().createFragment().getProgramId(), cVar.C1().getFragmentParentReturnTag(), false, false);
        app.dogo.com.dogo_android.util.extensionfunction.g1.f(cVar.getActivity(), cVar.C1().getFragmentReturnTag(), cVar2, false, 4, null);
    }

    private static final void H1(c cVar, View view) {
        n.f(cVar, "this$0");
        cVar.D1().i();
        TrickDetailsPlan_ProgramPlan trickDetailsPlan_ProgramPlan = new TrickDetailsPlan_ProgramPlan(cVar.C1().b().getTrainingTricksList(), cVar.C1().createFragment(), 0, false, true, 12, null);
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(cVar.getActivity(), new TrickDetailsScreen(trickDetailsPlan_ProgramPlan, cVar.C1().getTag(), cVar.C1().getFragmentParentReturnTag(), "trick_try"));
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        androidx.fragment.app.e activity = null;
        n.f(context, "context");
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.F();
        }
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        eg egVar = eg.T(inflater, container, false);
        n.e(egVar, "inflate(inflater, container, false)");
        this.binding = egVar;
        int i = 0;
        String str3 = "binding";
        if (egVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            egVar.M(getViewLifecycleOwner());
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.V(D1());
                if (this.binding == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    binding22.Q.setOnClickListener(new app.dogo.com.dogo_android.trainingprogram.tricktry.b(this));
                    if (this.binding == null) {
                        n.w(str3);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        binding23.P.setOnClickListener(new app.dogo.com.dogo_android.trainingprogram.tricktry.a(this));
                        requireActivity().getOnBackPressedDispatcher().b(getViewLifecycleOwner(), new ProgramTrickTryFragment_onCreateView_3());
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
        }
    }


    public static /* synthetic */ void E1(c cVar, View view) {
        ProgramTrickTryFragment.H1(cVar, view);
    }

    public static /* synthetic */ void F1(c cVar, View view) {
        ProgramTrickTryFragment.G1(cVar, view);
    }
}

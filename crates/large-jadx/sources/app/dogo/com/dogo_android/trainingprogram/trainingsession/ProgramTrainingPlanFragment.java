package app.dogo.com.dogo_android.y.d0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.cg;
import app.dogo.com.dogo_android.n.m.n.b;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;

/* compiled from: ProgramTrainingPlanFragment.kt */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0008\u0010!\u001a\u00020\u001eH\u0016J\u001a\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00162\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0014\u0010$\u001a\u00020\u001e2\n\u0008\u0002\u0010%\u001a\u0004\u0018\u00010 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanTrickAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramTrainingPlanBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanViewModel;", "viewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemSelected", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "onResume", "onViewCreated", "view", "startTraining", "selectedTrick", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final class ProgramTrainingPlanFragment extends Fragment implements n.a {

    /* renamed from: a, reason: from kotlin metadata */
    private cg binding;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public a(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<o> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final o invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ProgramTrainingPlanViewModel.class), this.$parameters);
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
            Object[] arr = new Object[2];
            return org.koin.core.parameter.b.b(new Object[] { l.this.onResume().b(), l.this.onResume().createFragment() });
        }

        c() {
            super(0);
        }
    }
    public l() {
        super();
        final m.a.c.j.a aVar2 = null;
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.trainingprogram.trainingsession.l.b(this, aVar2, new app.dogo.com.dogo_android.trainingprogram.trainingsession.l.c(this)));
        this.c = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.trainingprogram.trainingsession.l.a(this, aVar2, aVar2));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ m onItemSelected(l item) {
        return item.onResume();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    private final m onResume() {
        return (ProgramTrainingPlanScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final o D1() {
        return (ProgramTrainingPlanViewModel)this.b.getValue();
    }

    private static final void G1(l lVar, View view) {
        n.f(lVar, "this$0");
        lVar.requireActivity().onBackPressed();
    }

    private static final void H1(l lVar, View view) {
        n.f(lVar, "this$0");
        lVar.getSharedViewModel().d0(lVar.onResume().b());
        TrickItem trickItem = null;
        ProgramTrainingPlanFragment.J1(lVar, trickItem, 1, trickItem);
    }

    /* renamed from: I1, reason: from kotlin metadata */
    private final void startTraining(TrickItem selectedTrick) {
        TrickDetailsPlan_ProgramPlan trickDetailsPlan_ProgramPlan = new TrickDetailsPlan_ProgramPlan(app.dogo.com.dogo_android.util.extensionfunction.j1.forPair(onResume().b().getTrainingTricksList(), selectedTrick), onResume().createFragment(), 0, false, false, 24, null);
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new TrickDetailsScreen(trickDetailsPlan_ProgramPlan, onResume().getFragmentParentReturnTag(), onResume().getFragmentParentReturnTag(), "lesson"));
    }

    static /* synthetic */ void J1(l lVar, TrickItem trickItem, int i, Object object) {
        if (i & 1 != 0) {
            i = 0;
        }
        lVar.startTraining(trickItem);
    }

    private final l getSharedViewModel() {
        return (SessionViewModel)this.c.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void R(TrickItem trickItem) {
        n.f(trickItem, "item");
        getSharedViewModel().d0(onResume().b());
        startTraining(trickItem);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        cg cgVar = cg.T(inflater, container, false);
        n.e(cgVar, "inflate(inflater, container, false)");
        this.binding = cgVar;
        int i = 0;
        String str3 = "binding";
        if (cgVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            cgVar.M(getViewLifecycleOwner());
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.X(D1());
                if (this.binding == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.binding.W(getSharedViewModel());
                    if (this.binding == null) {
                        n.w(str3);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        this.binding.V(this);
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

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        androidx.fragment.app.e activity = null;
        super.onResume();
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.F();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws d {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        getSharedViewModel().d0(onResume().b());
        int i = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.P.setNavigationOnClickListener(new app.dogo.com.dogo_android.trainingprogram.trainingsession.e(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.O.setOnClickListener(new app.dogo.com.dogo_android.trainingprogram.trainingsession.d(this));
                return;
            }
        }
    }


    /* renamed from: E1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(l view, View savedInstanceState) {
        ProgramTrainingPlanFragment.H1(view, savedInstanceState);
    }

    public static /* synthetic */ void F1(l lVar, View view) {
        ProgramTrainingPlanFragment.G1(lVar, view);
    }
}

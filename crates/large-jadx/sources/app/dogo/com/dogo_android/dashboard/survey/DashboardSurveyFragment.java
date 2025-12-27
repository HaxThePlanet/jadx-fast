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
import app.dogo.com.dogo_android.h.ql;
import app.dogo.com.dogo_android.h.ya;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.welcome_v2.c0.a;
import app.dogo.com.dogo_android.welcome_v2.v0;
import com.yuyakaido.android.cardstackview.CardStackView;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;

/* compiled from: DashboardSurveyFragment.kt */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0008\u0010!\u001a\u00020\u0013H\u0002J\u001a\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u001a2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/dashboard/survey/DashboardSurveyFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$AnswerSelectCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDashboardSurveyBinding;", "screenKey", "Lapp/dogo/com/dogo_android/dashboard/survey/DashboardSurveyScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/dashboard/survey/DashboardSurveyScreen;", "viewModel", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getTopCardIndex", "", "onCardAnswerSelect", "", "questionId", "", "answerId", "isLastCard", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onNext", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class DashboardSurveyFragment extends Fragment implements c0.a {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private ya b;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/dashboard/survey/DashboardSurveyFragment$onViewCreated$2", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends d {

        final /* synthetic */ i c;
        a() {
            this.c = iVar;
            super(true);
        }

        @Override // androidx.activity.d
        /* renamed from: b, reason: from kotlin metadata */
        public void handleOnBackPressed() {
            if (this.c.G1() != 0) {
                ya yaVar = this.c.b;
                if (yaVar == null) {
                    n.w("binding");
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) 0;
                } else {
                    yaVar.P.H1();
                    return;
                }
            }
            androidx.fragment.app.e activity = this.c.getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
            }
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            i.this.H1().l();
        }

        b() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements kotlin.d0.c.a<v0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final v0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(OnboardingSurveyViewModel.class), this.$parameters);
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
            Object[] arr = new Object[2];
            return org.koin.core.parameter.b.b(new Object[] { i.this.getTopCardIndex().createFragment(), i.this.getTopCardIndex().b() });
        }

        d() {
            super(0);
        }
    }
    public i() {
        super();
        this.binding = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.dashboard.survey.i.c(this, null, new app.dogo.com.dogo_android.dashboard.survey.i.d(this)));
    }

    public static final /* synthetic */ ya B1(i iVar) {
        return iVar.b;
    }

    public static final /* synthetic */ j C1(i iVar) {
        return iVar.getTopCardIndex();
    }

    public static final /* synthetic */ int D1(i iVar) {
        return iVar.G1();
    }

    public static final /* synthetic */ v0 E1(i iVar) {
        return iVar.H1();
    }

    /* renamed from: F1, reason: from kotlin metadata */
    private final j getTopCardIndex() {
        return (DashboardSurveyScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final int G1() {
        if (this.b == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            n.e(yaVar.P, "binding.cardStackView");
            return app.dogo.com.dogo_android.util.extensionfunction.j1.setupTrickListForIntermediateTraining(yaVar.P);
        }
    }

    private final v0 H1() {
        return (OnboardingSurveyViewModel)this.binding.getValue();
    }

    private final void L1() {
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new DashboardProgramGenerationScreen(H1().i(), (DashboardSurveyScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this).getFragmentReturnTag()));
    }

    private static final void M1(i iVar, View view) {
        n.f(iVar, "this$0");
        final androidx.fragment.app.e activity = iVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void N1(i iVar, Boolean boolean) {
        n.f(iVar, "this$0");
        iVar.L1();
    }

    private static final void O1(i iVar, y yVar) {
        Exception component1 = null;
        int i;
        n.f(iVar, "this$0");
        z = yVar instanceof LoadResult_Error;
        yVar = yVar instanceof oadResult_Error ? (oadResult_Error)yVar : 0;
        if (i != 0) {
            component1 = i.component1();
        }
        z2 = component1 instanceof UnknownHostException;
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: P0, reason: from kotlin metadata */
    public void onCardAnswerSelect(String questionId, String answerId, boolean isLastCard) {
        n.f(questionId, "questionId");
        n.f(answerId, "answerId");
        H1().saveAnswerAndGoNextIfLast(questionId, answerId, isLastCard);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        ya yaVar = ya.T(inflater, container, false);
        n.e(yaVar, "inflate(inflater, container, false)");
        this.b = yaVar;
        int i = 0;
        String str3 = "binding";
        if (yaVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            yaVar.M(getViewLifecycleOwner());
            if (this.b == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.b.W(H1());
                if (this.b == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.b.V(this);
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
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        int i = 0;
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        i = 0;
        if (this.b == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            yaVar.S.O.setOnClickListener(new app.dogo.com.dogo_android.dashboard.survey.d(this));
            requireActivity().getOnBackPressedDispatcher().b(getViewLifecycleOwner(), new DashboardSurveyFragment_onViewCreated_2(this));
            androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
            n.e(viewLifecycleOwner2, "viewLifecycleOwner");
            H1().j().observe(viewLifecycleOwner2, new app.dogo.com.dogo_android.dashboard.survey.e(this));
            H1().getResult().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.dashboard.survey.c(this));
            androidx.fragment.app.e view2 = getActivity();
            if (view2 instanceof Navigator) {
            }
            if (i != 0) {
                i.F();
            }
            return;
        }
    }


    /* renamed from: I1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(i view, y savedInstanceState) {
        DashboardSurveyFragment.O1(view, savedInstanceState);
    }

    public static /* synthetic */ void J1(i iVar, View view) {
        DashboardSurveyFragment.M1(iVar, view);
    }

    public static /* synthetic */ void K1(i iVar, Boolean boolean) {
        DashboardSurveyFragment.N1(iVar, boolean);
    }
}

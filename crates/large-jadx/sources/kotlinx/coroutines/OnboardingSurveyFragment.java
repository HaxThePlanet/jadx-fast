package app.dogo.com.dogo_android.welcome_v2;

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
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.h.ql;
import app.dogo.com.dogo_android.h.ye;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.k1;
import com.yuyakaido.android.cardstackview.CardStackView;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;

/* compiled from: OnboardingSurveyFragment.kt */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0008\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0008\u0010 \u001a\u0004\u0018\u00010!2\u0008\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0008\u0010$\u001a\u00020\u0015H\u0002J\u001a\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u001d2\u0008\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0008\u0010'\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$AnswerSelectCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentOnboardingSurveyBinding;", "screenKey", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyScreen;", "viewModel", "Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/welcome_v2/OnboardingSurveyViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getCardAdapter", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter;", "getTopCardIndex", "", "onBack", "", "onCardAnswerSelect", "questionId", "", "answerId", "isLastCard", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSkip", "onViewCreated", "view", "trackSurveySkipQuestion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: t0, reason: from kotlin metadata */
public final class OnboardingSurveyFragment extends Fragment implements c0.a {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private ye b;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/welcome_v2/OnboardingSurveyFragment$onViewCreated$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends d {

        final /* synthetic */ t0 c;
        b() {
            this.c = t0Var;
            super(true);
        }

        @Override // androidx.activity.d
        /* renamed from: b, reason: from kotlin metadata */
        public void handleOnBackPressed() {
            if (this.c.I1() != 0) {
                ye yeVar = this.c.b;
                if (yeVar == null) {
                    n.w("binding");
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) 0;
                } else {
                    yeVar.P.H1();
                    return;
                }
            }
            this.c.O1();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            t0.this.U1();
            t0.this.J1().n();
            androidx.fragment.app.e activity = t0.this.getActivity();
            if (activity != null) {
                boolean z = false;
                int i = 1;
                Object obj = null;
                app.dogo.com.dogo_android.util.extensionfunction.g1.u0(activity, z, i, obj);
            }
        }

        a() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            t0.this.J1().l();
        }

        c() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements kotlin.d0.c.a<v0> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final v0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(OnboardingSurveyViewModel.class), this.$parameters);
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
            Object[] arr = new Object[2];
            return org.koin.core.parameter.b.b(new Object[] { t0.this.H1().createFragment(), t0.this.H1().b() });
        }

        e() {
            super(0);
        }
    }
    public t0() {
        super();
        this.binding = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.t0.d(this, null, new kotlinx.coroutines.t0.e(this)));
    }

    public static final /* synthetic */ ye B1(t0 t0Var) {
        return t0Var.b;
    }

    public static final /* synthetic */ u0 C1(t0 t0Var) {
        return t0Var.H1();
    }

    public static final /* synthetic */ int D1(t0 t0Var) {
        return t0Var.I1();
    }

    public static final /* synthetic */ v0 E1(t0 t0Var) {
        return t0Var.J1();
    }

    public static final /* synthetic */ void F1(t0 t0Var) {
        t0Var.U1();
    }

    /* renamed from: G1, reason: from kotlin metadata */
    private final c0 getCardAdapter() {
        int i = 0;
        i = 0;
        if (this.b == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            androidx.recyclerview.widget.RecyclerView.h adapter = yeVar.P.getAdapter();
            if (adapter instanceof CardStackAdapter) {
            }
            return i;
        }
    }

    private final u0 H1() {
        return (OnboardingSurveyScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final int I1() {
        if (this.b == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            n.e(yeVar.P, "binding.cardStackView");
            return app.dogo.com.dogo_android.util.extensionfunction.j1.setupTrickListForIntermediateTraining(yeVar.P);
        }
    }

    private final v0 J1() {
        return (OnboardingSurveyViewModel)this.binding.getValue();
    }

    private static final void P1(t0 t0Var, View view) {
        n.f(t0Var, "this$0");
        final androidx.fragment.app.e activity = t0Var.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void Q1(t0 t0Var, View view) {
        n.f(t0Var, "this$0");
        t0Var.R1();
    }

    private final void R1() {
        app.dogo.com.dogo_android.util.extensionfunction.f1.showDialogWithYes(this, 2131887327, new kotlinx.coroutines.t0.a(this));
    }

    private static final void S1(t0 t0Var, Boolean boolean) {
        n.f(t0Var, "this$0");
        androidx.fragment.app.e activity = t0Var.getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.o(activity, new OnboardingProgramGenerationScreen(t0Var.J1().i()));
        }
    }

    private static final void T1(t0 t0Var, y yVar) {
        Exception component1 = null;
        int i;
        n.f(t0Var, "this$0");
        z = yVar instanceof LoadResult_Error;
        yVar = yVar instanceof oadResult_Error ? (oadResult_Error)yVar : 0;
        if (i != 0) {
            component1 = i.component1();
        }
        z2 = component1 instanceof UnknownHostException;
    }

    private final void U1() {
        app.dogo.com.dogo_android.welcome_v2.c0 cardAdapter = getCardAdapter();
        if (cardAdapter != null) {
            J1().p(cardAdapter.p(I1()));
        } else {
            a.c("CardStackView adapter is null", new Object[0]);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void O1() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: P0, reason: from kotlin metadata */
    public void onCardAnswerSelect(String questionId, String answerId, boolean isLastCard) {
        n.f(questionId, "questionId");
        n.f(answerId, "answerId");
        J1().saveAnswerAndGoNextIfLast(questionId, answerId, isLastCard);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        ye yeVar = ye.T(inflater, container, false);
        n.e(yeVar, "inflate(inflater, container, false)");
        this.b = yeVar;
        int i = 0;
        String str3 = "binding";
        if (yeVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            yeVar.M(getViewLifecycleOwner());
            if (this.b == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.b.W(J1());
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
                        yeVar4.S.O.setOnClickListener(new kotlinx.coroutines.z(this));
                        if (this.b == null) {
                            n.w(str3);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i;
                        } else {
                            yeVar5.S.P.setOnClickListener(new kotlinx.coroutines.b0(this));
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
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        requireActivity().getOnBackPressedDispatcher().b(getViewLifecycleOwner(), new OnboardingSurveyFragment_onViewCreated_1(this));
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, "viewLifecycleOwner");
        J1().j().observe(viewLifecycleOwner2, new kotlinx.coroutines.a0(this));
        J1().getResult().observe(getViewLifecycleOwner(), new kotlinx.coroutines.y(this));
    }


    /* renamed from: K1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(t0 view, y savedInstanceState) {
        OnboardingSurveyFragment.T1(view, savedInstanceState);
    }

    public static /* synthetic */ void L1(t0 t0Var, View view) {
        OnboardingSurveyFragment.P1(t0Var, view);
    }

    public static /* synthetic */ void M1(t0 t0Var, Boolean boolean) {
        OnboardingSurveyFragment.S1(t0Var, boolean);
    }

    public static /* synthetic */ void N1(t0 t0Var, View view) {
        OnboardingSurveyFragment.Q1(t0Var, view);
    }
}

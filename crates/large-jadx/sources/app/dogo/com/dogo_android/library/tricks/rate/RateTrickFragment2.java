package app.dogo.com.dogo_android.n.m.t;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.h.gg;
import app.dogo.com.dogo_android.h.om;
import app.dogo.com.dogo_android.n.m.n.b;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;
import app.dogo.com.dogo_android.u.m.w;
import app.dogo.com.dogo_android.util.customview.TrickRatingBar;
import app.dogo.com.dogo_android.util.customview.TrickRatingBar.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.g;
import app.dogo.com.dogo_android.util.g.a;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.y.r.d;
import app.dogo.com.dogo_android.y.u.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.q;
import kotlin.d0.d.c0;
import kotlin.h;

/* compiled from: RateTrickFragment2.kt */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0016\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!H\u0002J\u0016\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\u000b\u001a\u00020\u000c8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\n\u001a\u0004\u0008\r\u0010\u000e¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickFragment2;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentRateTrickV2Binding;", "Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickScreen2;", "()V", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickViewModel2;", "getViewModel", "()Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickViewModel2;", "viewModel$delegate", "continueProgramTrainingFlow", "", "continueTrickFlow", "rateResults", "Lapp/dogo/com/dogo_android/library/tricks/rate/RateTrickViewModel2$RateResults;", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupProgramScreenChain", "", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "session", "Lapp/dogo/com/dogo_android/library/tricks/TrickDetailsPlan$ProgramPlan;", "setupTimeMetricsScreenChain", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class RateTrickFragment2 extends app.dogo.com.dogo_android.util.m0.b<gg, f> {

    private final h v;
    private final h w;

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/library/tricks/rate/RateTrickFragment2$onViewCreated$4", "Lapp/dogo/com/dogo_android/util/customview/TrickRatingBar$OnClickEventListener;", "onRatingClick", "", "newRating", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b implements TrickRatingBar.a {

        final /* synthetic */ e a;
        b() {
            this.a = eVar;
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public void onRatingClick(int newRating) {
            this.a.I1().v().postValue(Integer.valueOf(newRating));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends kotlin.d0.d.p implements kotlin.d0.c.a<l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public c(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<g> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final g invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(RateTrickViewModel2.class), this.$parameters);
        }

        public d(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends kotlin.d0.d.p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[4];
            String str = "trick_details";
            return org.koin.core.parameter.b.b(new Object[] { (RateTrickScreen2)e.this.C1().b(), (RateTrickScreen2)e.this.C1().createFragment(), str, Long.valueOf((RateTrickScreen2)e.this.C1().c()) });
        }

        e() {
            super(0);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends kotlin.d0.d.k implements q<LayoutInflater, ViewGroup, Boolean, gg> {

        public static final e.a a = new e$a();
        @Override // kotlin.d0.d.k
        public final gg l(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
            n.f(layoutInflater, "p0");
            return gg.T(layoutInflater, viewGroup, z);
        }


        a() {
            super(3, gg.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentRateTrickV2Binding;", 0);
        }
    }
    public e() {
        super(app.dogo.com.dogo_android.library.tricks.rate.e.a.a);
        final m.a.c.j.a aVar2 = null;
        this.v = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.library.tricks.rate.e.c(this, aVar2, aVar2));
        this.w = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.library.tricks.rate.e.d(this, aVar2, new app.dogo.com.dogo_android.library.tricks.rate.e.e(this)));
    }

    /* renamed from: G1, reason: from kotlin metadata */
    private final void continueProgramTrainingFlow() {
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new TrickDetailsScreen((RateTrickScreen2)C1().b().d(), (RateTrickScreen2)C1().getFragmentParentReturnTag(), (RateTrickScreen2)C1().getFragmentParentReturnTag(), "lesson"));
    }

    /* renamed from: H1, reason: from kotlin metadata */
    private final void continueTrickFlow(g.a rateResults) {
        String tag;
        int i;
        app.dogo.com.dogo_android.n.m.n nVar = (RateTrickScreen2)C1().b();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(setupProgramScreenChain(rateResults));
        z = nVar instanceof TrickDetailsPlan_ProgramPlan;
        if (nVar instanceof TrickDetailsPlan_ProgramPlan) {
            arrayList.addAll(onAttach(nVar));
        }
        boolean z3 = false;
        i = 1;
        if (n.b((RateTrickScreen2)C1().getFragmentParentReturnTag(), S.dogEditName.a())) {
            rateResults = I1().I() ? i : z3;
        }
        if (i != 0) {
            arrayList.add(new TrainingReminderScreen((RateTrickScreen2)C1().getTag(), (RateTrickScreen2)C1().getFragmentParentReturnTag()));
        }
        if (arrayList.size() > i) {
            androidx.fragment.app.e activity = getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity, (AppScreen)p.X(ChainableAppScreen.INSTANCE.setupChain(arrayList)));
            }
        } else {
            if (arrayList.size() == i) {
                androidx.fragment.app.e activity2 = getActivity();
                if (activity2 != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity2, (AppScreen)p.X(arrayList));
                }
            } else {
                androidx.fragment.app.e activity3 = getActivity();
                if (activity3 != null) {
                    i = 2;
                    app.dogo.com.dogo_android.util.extensionfunction.g1.replace(activity3, (RateTrickScreen2)C1().getFragmentParentReturnTag(), z3, i, null);
                }
            }
        }
    }

    private static final void M1(e eVar, View view) {
        n.f(eVar, "this$0");
        final androidx.fragment.app.e activity = eVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void N1(e eVar, Long long) {
        str = "this$0";
        n.f(eVar, str);
        final androidx.fragment.app.e activity = eVar.getActivity();
        if (activity != null) {
            n.e(long, "articleId");
            app.dogo.com.dogo_android.util.extensionfunction.g1.q(activity, new ZendeskKnowledgeScreen(long.longValue(), r2));
        }
    }

    private static final void O1(e eVar, g.a aVar) {
        n.f(eVar, "this$0");
        if ((RateTrickScreen2)eVar.C1().b().b() != null) {
            eVar.continueProgramTrainingFlow();
        } else {
            n.e(aVar, "it");
            eVar.continueTrickFlow(aVar);
        }
    }

    /* renamed from: P1, reason: from kotlin metadata */
    private final List<app.dogo.com.dogo_android.y.j> onAttach(n.b context) {
        Object value;
        app.dogo.com.dogo_android.repository.domain.TrickItem trickItem;
        ProgramSaveInfo programSaveInfo;
        boolean z3;
        String programId;
        e programLessonExamUnlockedScreen = null;
        String fragmentParentReturnTag;
        String fragmentParentReturnTag2;
        final ArrayList arrayList = new ArrayList();
        if (I1().J(context.h().getProgramId())) {
            app.dogo.com.dogo_android.repository.domain.TrickItem component1 = context.component1();
            if (component1 != null) {
                fragmentParentReturnTag2 = "variations_unlocked";
                arrayList.add(new VariationsUnlockedScreen(fragmentParentReturnTag2, component1, context.c(), (RateTrickScreen2)C1().getFragmentParentReturnTag()));
            }
        } else {
            if (getSharedViewModel().m0()) {
                if (getSharedViewModel().n0()) {
                    getSharedViewModel().h0();
                    int i = 0;
                    LoadResult_Success r1 = getSharedViewModel().getResult().getValue() instanceof LoadResult_Success ? (oadResult_Success)this.getSharedViewModel().getResult().getValue() : i;
                    r1 = i;
                    if (trickItem != null) {
                        d firstExamUnlockedScreen = new FirstExamUnlockedScreen(trickItem, context.h(), (RateTrickScreen2)C1().createFragment(), (RateTrickScreen2)C1().getFragmentParentReturnTag());
                    } else {
                        a.d(new IllegalStateException("No exam found in session object"));
                    }
                } else {
                    programLessonExamUnlockedScreen = new ProgramLessonExamUnlockedScreen(context.h(), getSharedViewModel().L(), (RateTrickScreen2)C1().getFragmentParentReturnTag());
                }
                if (programLessonExamUnlockedScreen != null) {
                    arrayList.add(programLessonExamUnlockedScreen);
                }
            }
        }
        if (context.g()) {
            boolean z4 = false;
            boolean z5 = false;
            ProgramLessonScreen context2 = new ProgramLessonScreen(context.h().getLessonId(), context.h().getProgramId(), (RateTrickScreen2)C1().getFragmentParentReturnTag(), z4, z5);
            arrayList.add(context2);
        }
        return arrayList;
    }

    /* renamed from: Q1, reason: from kotlin metadata */
    private final List<app.dogo.com.dogo_android.y.j> setupProgramScreenChain(g.a session) {
        String source;
        int i = 0;
        String fragmentParentReturnTag;
        boolean todayGoalAchieved;
        int i2;
        String fragmentParentReturnTag2;
        app.dogo.com.dogo_android.x.d.c trainingMetricsStreakCompletedScreen = null;
        String str;
        TrainingTimeMetrics trainingTimeMetrics;
        final ArrayList arrayList = new ArrayList();
        z = session instanceof RateTrickViewModel2_RateResults_TimeMetrics;
        if (session instanceof RateTrickViewModel2_RateResults_TimeMetrics) {
            i = 1;
            if (!getSharedViewModel().Q()) {
                if (!(session.b().isTodayGoalAchieved())) {
                    i = 0;
                }
            }
            DogProfile dogProfile = getSharedViewModel().I();
            if (dogProfile == null) {
            } else {
                String name = dogProfile.getName();
            }
            if (i2 == 0) {
                str = "getString(R.string.reminder_daily_training_your_dog)";
                n.e(getString(2131887192), str);
            }
            if (i != 0) {
                trainingMetricsStreakCompletedScreen = new TrainingMetricsStreakCompletedScreen(session.b(), fragmentParentReturnTag2, (RateTrickScreen2)C1().getSource(), (RateTrickScreen2)C1().getFragmentParentReturnTag());
            } else {
                if (session.b().isTodayGoalAchieved() ^ i) {
                    Object value = I1().v().getValue();
                    n.d(value);
                    app.dogo.com.dogo_android.x.b.c goalNotAchievedScreen = new GoalNotAchievedScreen((RateTrickScreen2)C1().getSource(), p.b(value), session.b(), (RateTrickScreen2)C1().getFragmentParentReturnTag());
                }
            }
            if (trainingMetricsStreakCompletedScreen != null) {
                arrayList.add(trainingMetricsStreakCompletedScreen);
            }
        }
        return arrayList;
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public g I1() {
        return (RateTrickViewModel2)this.w.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public l getSharedViewModel() {
        return (SessionViewModel)this.v.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onAttach(Context context) {
        androidx.fragment.app.e activity = null;
        n.f(context, "context");
        super.onAttach(context);
        context = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.F();
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        (gg)B1().Q.S.setNavigationOnClickListener(new app.dogo.com.dogo_android.library.tricks.rate.c(this));
        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
        String str2 = "viewLifecycleOwner";
        n.e(viewLifecycleOwner, str2);
        I1().x().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.library.tricks.rate.a(this));
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, str2);
        I1().t().observe(viewLifecycleOwner2, new app.dogo.com.dogo_android.library.tricks.rate.b(this));
        (gg)B1().Q.U.setOnClickEventListener(new RateTrickFragment2_onViewCreated_4(this));
        (gg)B1().Q.U.setInitialRating(I1().u());
    }


    /* renamed from: J1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(e view, Long savedInstanceState) {
        RateTrickFragment2.N1(view, savedInstanceState);
    }

    public static /* synthetic */ void K1(e eVar, g.a aVar) {
        RateTrickFragment2.O1(eVar, aVar);
    }

    public static /* synthetic */ void L1(e eVar, View view) {
        RateTrickFragment2.M1(eVar, view);
    }
}

package app.dogo.com.dogo_android.f.l;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.d;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.wn;
import app.dogo.com.dogo_android.h.yg;
import app.dogo.com.dogo_android.h.yn;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;
import app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.util.h0.n1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import com.google.android.material.button.MaterialButton;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.g;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;

/* compiled from: DailyWorkoutFragment.kt */
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0008\u0010\u001d\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0002J\u0008\u0010$\u001a\u00020\u001bH\u0002J\u0008\u0010%\u001a\u00020\u001bH\u0002J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0016J$\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0008\u0010-\u001a\u0004\u0018\u00010.2\u0008\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0008\u00101\u001a\u00020\u001bH\u0016J\u0008\u00102\u001a\u00020\u001bH\u0016J\u001a\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020*2\u0008\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0008\u00105\u001a\u00020\u001bH\u0002J\u0008\u00106\u001a\u00020\u001bH\u0002J\u0008\u00107\u001a\u00020\u001bH\u0002J\u0008\u00108\u001a\u00020\u001bH\u0002J\u0008\u00109\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0019\u0010\u0013\u001a\u0004\u0008\u0017\u0010\u0018¨\u0006:", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutAdapter$OnSessionFinished;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentTodaysWorkoutBinding;", "clickerToolTip", "Lcom/skydoves/balloon/Balloon;", "holdBackgroundDim", "", "screenKey", "Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "trickToolTip", "viewModel", "Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutViewModel;", "viewModel$delegate", "enableScreen", "", "state", "finished", "goToNextTrainingStreakScreen", "trainingTimeMetrics", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "goToNextWorkoutScreen", "workoutStreakInfo", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutStreakInfo;", "highlightClicker", "highlightViewpager", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onViewCreated", "view", "removeClickerHighlight", "removeViewpagerHighlight", "showExitDialog", "showFirstPopUp", "showSecondPopUp", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class DailyWorkoutFragment extends Fragment implements i.b {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    /* renamed from: b, reason: from kotlin metadata */
    private final h clickerToolTip;
    /* renamed from: c, reason: from kotlin metadata */
    private yg holdBackgroundDim;
    private boolean v;
    private Balloon w;
    /* renamed from: x, reason: from kotlin metadata */
    private Balloon trickToolTip;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutFragment$onViewCreated$2", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends d {

        final /* synthetic */ j c;
        a() {
            this.c = jVar;
            super(true);
        }

        @Override // androidx.activity.d
        /* renamed from: b, reason: from kotlin metadata */
        public void handleOnBackPressed() {
            int i;
            Balloon goToNextWorkoutScreen = this.c.trickToolTip;
            i = 0;
            i = 1;
            int r0 = goToNextWorkoutScreen == null ? 0 : i;
            if (this.c == 0) {
                Balloon enableScreen = this.c.w;
                if (enableScreen != null) {
                    if (enableScreen.l0()) {
                    }
                }
                if (i == 0) {
                    this.c.c2();
                } else {
                    Balloon goToNextWorkoutScreen2 = this.c.w;
                    if (goToNextWorkoutScreen2 != null) {
                        goToNextWorkoutScreen2.J();
                    }
                }
            } else {
                goToNextWorkoutScreen2 = this.c.trickToolTip;
                if (goToNextWorkoutScreen2 != null) {
                    goToNextWorkoutScreen2.J();
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            j.this.L1().x();
        }

        b() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            androidx.fragment.app.e activity = j.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }

        c() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            androidx.fragment.app.e activity = j.this.getActivity();
            if (activity != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
            }
        }

        d() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            j.this.w = 0;
            j.this.a2();
        }

        e() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            j.this.w = 0;
            j.this.b2();
        }

        f() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class g extends p implements kotlin.d0.c.a<l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public g(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class h extends p implements kotlin.d0.c.a<l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final l invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DailyWorkoutViewModel.class), this.$parameters);
        }

        public h(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { j.this.finished().a() });
        }

        i() {
            super(0);
        }
    }
    public j() {
        super();
        final m.a.c.j.a aVar = null;
        this.binding = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.dailyworkout.session.j.g(this, aVar, aVar));
        this.clickerToolTip = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.dailyworkout.session.j.h(this, aVar, new app.dogo.com.dogo_android.dailyworkout.session.j.i(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ Balloon enableScreen(j state) {
        return state.w;
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static final /* synthetic */ k goToNextTrainingStreakScreen(j trainingTimeMetrics) {
        return trainingTimeMetrics.finished();
    }

    /* renamed from: D1, reason: from kotlin metadata */
    public static final /* synthetic */ Balloon goToNextWorkoutScreen(j workoutStreakInfo) {
        return workoutStreakInfo.trickToolTip;
    }

    /* renamed from: E1, reason: from kotlin metadata */
    public static final /* synthetic */ l onAttach(j context) {
        return context.L1();
    }

    public static final /* synthetic */ void F1(j jVar) {
        jVar.a2();
    }

    public static final /* synthetic */ void G1(j jVar) {
        jVar.b2();
    }

    /* renamed from: H1, reason: from kotlin metadata */
    public static final /* synthetic */ void onViewCreated(j view, Balloon savedInstanceState) {
        view.w = savedInstanceState;
    }

    public static final /* synthetic */ void I1(j jVar) {
        jVar.c2();
    }

    private final void J1(boolean z) {
        int i = 0;
        int i2 = 0;
        String str = "binding";
        i2 = 0;
        if (this.holdBackgroundDim == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i2;
        } else {
            return;
        }
    }

    /* renamed from: K1, reason: from kotlin metadata */
    private final k finished() {
        return (DailyWorkoutScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final l L1() {
        return (DailyWorkoutViewModel)this.clickerToolTip.getValue();
    }

    private final void M1(TrainingTimeMetrics trainingTimeMetrics) {
        int i = 1;
        boolean todayGoalAchieved;
        int i6 = 0;
        String string;
        i = 1;
        boolean z = false;
        if (trainingTimeMetrics.isTodayGoalAchieved()) {
            if (getSharedViewModel().Q()) {
                i = z;
            }
        }
        if (i != 0) {
            DogProfile dogProfile = getSharedViewModel().I();
            if (dogProfile != null) {
                String name = dogProfile.getName();
            }
            if (i6 == 0) {
                n.e(getString(2131887192), "getString(R.string.reminder_daily_training_your_dog)");
            }
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new TrainingMetricsStreakCompletedScreen(trainingTimeMetrics, string, "workout", finished().getFragmentParentReturnTag()));
        } else {
            if (trainingTimeMetrics.isTodayGoalAchieved() ^ i) {
                java.util.List list = null;
                int i2 = 2;
                kotlin.d0.d.g gVar = null;
                string = "workout";
                GoalNotAchievedScreen goalNotAchievedScreen = new GoalNotAchievedScreen(string, list, trainingTimeMetrics, finished().getFragmentParentReturnTag(), i2, gVar);
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), goalNotAchievedScreen);
            } else {
                app.dogo.com.dogo_android.util.extensionfunction.g1.replace(getActivity(), finished().getFragmentParentReturnTag(), z, 2, null);
            }
        }
    }

    private final void N1(WorkoutStreakInfo workoutStreakInfo) {
        if (L1().z(workoutStreakInfo)) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new DailyWorkoutCompletedScreen(workoutStreakInfo, finished().getFragmentParentReturnTag()));
        } else {
            Object obj = null;
            app.dogo.com.dogo_android.util.extensionfunction.g1.replace(getActivity(), finished().getFragmentParentReturnTag(), false, 2, obj);
        }
    }

    private final void O1() throws android.content.res.Resources.NotFoundException {
        J1(false);
        final String str = "binding";
        final ViewOutlineProvider viewOutlineProvider = null;
        if (this.holdBackgroundDim == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) viewOutlineProvider;
        } else {
            holdBackgroundDim2.P.setElevation(requireContext().getResources().getDimension(2131165629));
            if (this.holdBackgroundDim == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) viewOutlineProvider;
            } else {
                holdBackgroundDim22.P.setOutlineProvider(viewOutlineProvider);
                return;
            }
        }
    }

    private final void P1() throws android.content.res.Resources.NotFoundException {
        J1(false);
        final String str = "binding";
        final ViewOutlineProvider viewOutlineProvider = null;
        if (this.holdBackgroundDim == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) viewOutlineProvider;
        } else {
            final int i2 = 2131165629;
            holdBackgroundDim2.S.setElevation(requireContext().getResources().getDimension(i2));
            if (this.holdBackgroundDim == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) viewOutlineProvider;
            } else {
                holdBackgroundDim22.Q.setElevation(requireContext().getResources().getDimension(i2));
                if (this.holdBackgroundDim == null) {
                    n.w(str);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) viewOutlineProvider;
                } else {
                    holdBackgroundDim23.Q.setOutlineProvider(viewOutlineProvider);
                    if (this.holdBackgroundDim == null) {
                        n.w(str);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) viewOutlineProvider;
                    } else {
                        holdBackgroundDim24.S.setOutlineProvider(viewOutlineProvider);
                        return;
                    }
                }
            }
        }
    }

    private static final void X1(j jVar, View view) {
        n.f(jVar, "this$0");
        jVar.c2();
    }

    private static final void Y1(j jVar, y yVar) {
        str = "this$0";
        n.f(jVar, str);
        z = yVar instanceof LoadResult_Error;
        if (yVar instanceof oadResult_Error) {
            String string = jVar.getString(2131886439);
            n.e(string, "getString(R.string.daily_workout_no_internet_connection)");
            app.dogo.com.dogo_android.util.extensionfunction.f1.m0(jVar, string, new app.dogo.com.dogo_android.dailyworkout.session.j.b(jVar), new app.dogo.com.dogo_android.dailyworkout.session.j.c(jVar));
        }
    }

    private static final void Z1(j jVar, l.a aVar) {
        str = "this$0";
        n.f(jVar, str);
        if (aVar != null) {
            if (aVar instanceof DailyWorkoutViewModel_WorkoutResults_TrainingStreak) {
                jVar.M1(aVar.a());
            } else {
                if (aVar instanceof DailyWorkoutViewModel_WorkoutResults_WorkoutStreak) {
                    jVar.N1(aVar.a());
                }
            }
        }
    }

    private final void a2() {
        J1(true);
        int i2 = 0;
        final String str = "binding";
        if (this.holdBackgroundDim == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i2;
        } else {
            holdBackgroundDim2.P.setElevation(0.0f);
            if (this.holdBackgroundDim == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i2;
            } else {
                holdBackgroundDim22.P.setOutlineProvider(ViewOutlineProvider.BOUNDS);
                return;
            }
        }
    }

    private final void b2() {
        J1(true);
        int i2 = 0;
        final String str = "binding";
        if (this.holdBackgroundDim == null) {
            n.w(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i2;
        } else {
            float f = 0.0f;
            holdBackgroundDim2.S.setElevation(f);
            if (this.holdBackgroundDim == null) {
                n.w(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i2;
            } else {
                holdBackgroundDim22.Q.setElevation(0.0f);
                if (this.holdBackgroundDim == null) {
                    n.w(str);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i2;
                } else {
                    holdBackgroundDim23.S.setOutlineProvider(ViewOutlineProvider.BOUNDS);
                    if (this.holdBackgroundDim == null) {
                        n.w(str);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i2;
                    } else {
                        holdBackgroundDim24.Q.setOutlineProvider(ViewOutlineProvider.BOUNDS);
                        return;
                    }
                }
            }
        }
    }

    private final void c2() {
        final androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            Integer num = null;
            int i = 2131887546;
            int i2 = 1;
            Object obj = null;
            app.dogo.com.dogo_android.util.extensionfunction.f1.T(activity, num, i, new app.dogo.com.dogo_android.dailyworkout.session.j.d(this), i2, obj);
        }
    }

    private final void d2() {
        ViewGroup viewGroup = null;
        final boolean z = false;
        wn wnVar = wn.T(getLayoutInflater(), viewGroup, z);
        n.e(wnVar, "inflate(layoutInflater, null, false)");
        View view2 = wnVar.w();
        n.e(view2, "tooltipBinding.root");
        Balloon showCalendarIntroductionTooltip = app.dogo.com.dogo_android.util.extensionfunction.n1.showCalendarIntroductionTooltip(this, view2);
        this.w = showCalendarIntroductionTooltip;
        showCalendarIntroductionTooltip.y = new app.dogo.com.dogo_android.dailyworkout.session.d(this);
        showCalendarIntroductionTooltip.p0(new app.dogo.com.dogo_android.dailyworkout.session.j.e(this));
        wnVar.O.setOnClickListener(new app.dogo.com.dogo_android.dailyworkout.session.c(this, showCalendarIntroductionTooltip));
        if (this.holdBackgroundDim == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) viewGroup;
        } else {
            n.e(holdBackgroundDim2.R, "binding.dummy");
            g.b(holdBackgroundDim2.R, showCalendarIntroductionTooltip, z, (int)(TypedValue.applyDimension(1, 16f, getResources().getDisplayMetrics())));
            return;
        }
    }

    private static final void e2(j jVar, View view) {
        n.f(jVar, "this$0");
        n.f(view, "it");
        jVar.O1();
    }

    private static final void f2(j jVar, Balloon balloon, View view) {
        n.f(jVar, "this$0");
        n.f(balloon, "$balloon");
        jVar.v = true;
        balloon.J();
        jVar.g2();
    }

    private final void g2() {
        int i;
        ViewGroup viewGroup = null;
        final boolean z = false;
        yn ynVar = yn.T(getLayoutInflater(), viewGroup, z);
        n.e(ynVar, "inflate(layoutInflater, null, false)");
        View view = ynVar.w();
        n.e(view, "tooltipBinding.root");
        Balloon showClickerIntroductionTooltip = app.dogo.com.dogo_android.util.extensionfunction.n1.showClickerIntroductionTooltip(this, view);
        this.trickToolTip = showClickerIntroductionTooltip;
        showClickerIntroductionTooltip.y = new app.dogo.com.dogo_android.dailyworkout.session.b(this);
        showClickerIntroductionTooltip.p0(new app.dogo.com.dogo_android.dailyworkout.session.j.f(this));
        ynVar.O.setOnClickListener(new app.dogo.com.dogo_android.dailyworkout.session.h(showClickerIntroductionTooltip, this));
        int i2 = showClickerIntroductionTooltip.V();
        final String str4 = "binding";
        if (this.holdBackgroundDim == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) viewGroup;
        } else {
            if (this.holdBackgroundDim == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) viewGroup;
            } else {
                int i4 = this.holdBackgroundDim.w().getHeight() - holdBackgroundDim23.Q.getBottom();
                int r4 = this.holdBackgroundDim < i2 ? i4 - i2 : z;
                if (this.holdBackgroundDim == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) viewGroup;
                } else {
                    View childAt = holdBackgroundDim2.Q.getChildAt(z);
                    n.e(childAt, "binding.dailyWorkoutViewPager.getChildAt(0)");
                    g.a(childAt, showClickerIntroductionTooltip, 56, i);
                    return;
                }
            }
        }
    }

    private static final void h2(j jVar, View view) {
        n.f(jVar, "this$0");
        n.f(view, "it");
        jVar.P1();
        jVar.v = false;
    }

    private static final void i2(Balloon balloon, j jVar, View view) {
        n.f(balloon, "$balloon");
        n.f(jVar, "this$0");
        balloon.J();
        jVar.L1().y();
    }

    @Override // androidx.fragment.app.Fragment
    public final l getSharedViewModel() {
        return (SessionViewModel)this.binding.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void m1() {
        L1().v();
        if (!L1().t()) {
            if (L1().s()) {
                L1().x();
            } else {
                boolean z2 = false;
                int i = 2;
                Object obj = null;
                app.dogo.com.dogo_android.util.extensionfunction.g1.replace(getActivity(), finished().getFragmentParentReturnTag(), z2, i, obj);
            }
        }
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
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n.f(layoutInflater, "inflater");
        yg ygVar = yg.T(getLayoutInflater(), viewGroup, false);
        n.e(ygVar, "inflate(layoutInflater, container, false)");
        this.holdBackgroundDim = ygVar;
        int i = 0;
        String str4 = "binding";
        if (ygVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            ygVar.M(getViewLifecycleOwner());
            if (this.holdBackgroundDim == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.holdBackgroundDim.W(L1());
                if (this.holdBackgroundDim == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.holdBackgroundDim.V(this);
                    if (this.holdBackgroundDim == null) {
                        n.w(str4);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        View view = this.holdBackgroundDim.w();
                        n.e(view, "binding.root");
                        return view;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        L1().w();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        L1().isTrainingStreaksEnabled();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        if (this.holdBackgroundDim == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            holdBackgroundDim2.T.setNavigationOnClickListener(new app.dogo.com.dogo_android.dailyworkout.session.f(this));
            requireActivity().getOnBackPressedDispatcher().b(getViewLifecycleOwner(), new DailyWorkoutFragment_onViewCreated_2(this));
            if (L1().u()) {
                d2();
            }
            L1().q().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.dailyworkout.session.g(this));
            androidx.lifecycle.q viewLifecycleOwner3 = getViewLifecycleOwner();
            n.e(viewLifecycleOwner3, "viewLifecycleOwner");
            L1().p().observe(viewLifecycleOwner3, new app.dogo.com.dogo_android.dailyworkout.session.e(this));
            return;
        }
    }


    public static /* synthetic */ void Q1(j jVar, View view) {
        DailyWorkoutFragment.h2(jVar, view);
    }

    /* renamed from: R1, reason: from kotlin metadata */
    public static /* synthetic */ void onCreateView(j inflater, Balloon container, View savedInstanceState) {
        DailyWorkoutFragment.f2(inflater, container, savedInstanceState);
    }

    public static /* synthetic */ void S1(j jVar, View view) {
        DailyWorkoutFragment.e2(jVar, view);
    }

    public static /* synthetic */ void T1(j jVar, l.a aVar) {
        DailyWorkoutFragment.Z1(jVar, aVar);
    }

    public static /* synthetic */ void U1(j jVar, View view) {
        DailyWorkoutFragment.X1(jVar, view);
    }

    public static /* synthetic */ void V1(j jVar, y yVar) {
        DailyWorkoutFragment.Y1(jVar, yVar);
    }

    public static /* synthetic */ void W1(Balloon balloon, j jVar, View view) {
        DailyWorkoutFragment.i2(balloon, jVar, view);
    }
}

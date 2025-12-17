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
import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.f.o.c;
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
import app.dogo.com.dogo_android.x.b.c;
import app.dogo.com.dogo_android.x.d.c;
import com.google.android.material.button.MaterialButton;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.g;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0008\u0010\u001d\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0002J\u0008\u0010$\u001a\u00020\u001bH\u0002J\u0008\u0010%\u001a\u00020\u001bH\u0002J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0016J$\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0008\u0010-\u001a\u0004\u0018\u00010.2\u0008\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0008\u00101\u001a\u00020\u001bH\u0016J\u0008\u00102\u001a\u00020\u001bH\u0016J\u001a\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020*2\u0008\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0008\u00105\u001a\u00020\u001bH\u0002J\u0008\u00106\u001a\u00020\u001bH\u0002J\u0008\u00107\u001a\u00020\u001bH\u0002J\u0008\u00108\u001a\u00020\u001bH\u0002J\u0008\u00109\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0019\u0010\u0013\u001a\u0004\u0008\u0017\u0010\u0018¨\u0006:", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutAdapter$OnSessionFinished;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentTodaysWorkoutBinding;", "clickerToolTip", "Lcom/skydoves/balloon/Balloon;", "holdBackgroundDim", "", "screenKey", "Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "trickToolTip", "viewModel", "Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutViewModel;", "viewModel$delegate", "enableScreen", "", "state", "finished", "goToNextTrainingStreakScreen", "trainingTimeMetrics", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "goToNextWorkoutScreen", "workoutStreakInfo", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutStreakInfo;", "highlightClicker", "highlightViewpager", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onViewCreated", "view", "removeClickerHighlight", "removeViewpagerHighlight", "showExitDialog", "showFirstPopUp", "showSecondPopUp", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j extends Fragment implements app.dogo.com.dogo_android.f.l.i.b {

    private final h a;
    private final h b;
    private yg c;
    private boolean v;
    private Balloon w;
    private Balloon x;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/dailyworkout/session/DailyWorkoutFragment$onViewCreated$2", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends d {

        final app.dogo.com.dogo_android.f.l.j c;
        a(app.dogo.com.dogo_android.f.l.j j) {
            this.c = j;
            super(1);
        }

        @Override // androidx.activity.d
        public void b() {
            Balloon balloon;
            int i2;
            Object obj;
            Balloon balloon2;
            int i;
            balloon = j.D1(this.c);
            final int i3 = 1;
            if (balloon == null) {
                i2 = i;
            } else {
            }
            if (i2 != 0) {
                obj = j.D1(this.c);
                if (obj == null) {
                } else {
                    obj.J();
                }
            } else {
                balloon2 = j.B1(this.c);
                if (balloon2 == null) {
                } else {
                    if (balloon2.l0() == i3) {
                        i = i3;
                    }
                }
                if (i != 0) {
                    obj = j.B1(this.c);
                    if (obj == null) {
                    } else {
                        obj.J();
                    }
                } else {
                    j.I1(this.c);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.f.l.j this$0;
        b(app.dogo.com.dogo_android.f.l.j j) {
            this.this$0 = j;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            j.E1(this.this$0).x();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<w> {

        final app.dogo.com.dogo_android.f.l.j this$0;
        c(app.dogo.com.dogo_android.f.l.j j) {
            this.this$0 = j;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            androidx.fragment.app.e activity = this.this$0.getActivity();
            if (activity == null) {
            } else {
                activity.onBackPressed();
            }
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<w> {

        final app.dogo.com.dogo_android.f.l.j this$0;
        d(app.dogo.com.dogo_android.f.l.j j) {
            this.this$0 = j;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            androidx.fragment.app.e activity = this.this$0.getActivity();
            if (activity == null) {
            } else {
                g1.O(activity);
            }
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<w> {

        final app.dogo.com.dogo_android.f.l.j this$0;
        e(app.dogo.com.dogo_android.f.l.j j) {
            this.this$0 = j;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            j.H1(this.this$0, 0);
            j.F1(this.this$0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements a<w> {

        final app.dogo.com.dogo_android.f.l.j this$0;
        f(app.dogo.com.dogo_android.f.l.j j) {
            this.this$0 = j;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            j.H1(this.this$0, 0);
            j.G1(this.this$0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class g extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public g(Fragment fragment, a a2, a a3) {
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
    public static final class h extends p implements a<app.dogo.com.dogo_android.f.l.l> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public h(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.f.l.l invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(l.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends p implements a<a> {

        final app.dogo.com.dogo_android.f.l.j this$0;
        i(app.dogo.com.dogo_android.f.l.j j) {
            this.this$0 = j;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b(j.C1(this.this$0).a());
        }
    }
    static {
    }

    public j() {
        super();
        final int i = 0;
        j.g gVar = new j.g(this, i, i);
        this.a = j.a(m.NONE, gVar);
        j.i iVar = new j.i(this);
        j.h hVar3 = new j.h(this, i, iVar);
        this.b = j.a(m.SYNCHRONIZED, hVar3);
    }

    public static final Balloon B1(app.dogo.com.dogo_android.f.l.j j) {
        return j.w;
    }

    public static final app.dogo.com.dogo_android.f.l.k C1(app.dogo.com.dogo_android.f.l.j j) {
        return j.K1();
    }

    public static final Balloon D1(app.dogo.com.dogo_android.f.l.j j) {
        return j.x;
    }

    public static final app.dogo.com.dogo_android.f.l.l E1(app.dogo.com.dogo_android.f.l.j j) {
        return j.L1();
    }

    public static final void F1(app.dogo.com.dogo_android.f.l.j j) {
        j.a2();
    }

    public static final void G1(app.dogo.com.dogo_android.f.l.j j) {
        j.b2();
    }

    public static final void H1(app.dogo.com.dogo_android.f.l.j j, Balloon balloon2) {
        j.w = balloon2;
    }

    public static final void I1(app.dogo.com.dogo_android.f.l.j j) {
        j.c2();
    }

    private final void J1(boolean z) {
        boolean enabled;
        View view;
        int i;
        int window;
        androidx.fragment.app.e obj4;
        yg ygVar = this.c;
        String str = "binding";
        window = 0;
        if (ygVar == null) {
        } else {
            if (ygVar.P.isEnabled() != z) {
                if (z && this.v) {
                    if (this.v) {
                    } else {
                        yg ygVar2 = this.c;
                        if (ygVar2 == null) {
                        } else {
                            ygVar2.P.setEnabled(z);
                            yg ygVar3 = this.c;
                            if (ygVar3 == null) {
                            } else {
                                i = z ? 8 : 0;
                                ygVar3.U.setVisibility(i);
                                if (z) {
                                    obj4 = getActivity();
                                    if (obj4 == null) {
                                    } else {
                                        window = obj4.getWindow();
                                    }
                                    if (window == null) {
                                    } else {
                                        window.setStatusBarColor(a.d(requireContext(), 2131099720));
                                    }
                                } else {
                                    obj4 = getActivity();
                                    if (obj4 == null) {
                                    } else {
                                        window = obj4.getWindow();
                                    }
                                    if (window == null) {
                                    } else {
                                        window.setStatusBarColor(a.d(requireContext(), 2131100334));
                                    }
                                }
                            }
                            n.w(str);
                            throw window;
                        }
                    }
                } else {
                }
                n.w(str);
                throw window;
            }
        }
        n.w(str);
        throw window;
    }

    private final app.dogo.com.dogo_android.f.l.k K1() {
        return (k)k1.a(this);
    }

    private final app.dogo.com.dogo_android.f.l.l L1() {
        return (l)this.b.getValue();
    }

    private final void M1(TrainingTimeMetrics trainingTimeMetrics) {
        Object fragmentParentReturnTag3;
        Object str2;
        int i2;
        c cVar;
        boolean todayGoalAchieved;
        String string;
        int fragmentParentReturnTag;
        Object str;
        String fragmentParentReturnTag2;
        int i;
        int i3;
        c cVar2;
        Object obj10;
        fragmentParentReturnTag = 0;
        if (trainingTimeMetrics.isTodayGoalAchieved() && !getSharedViewModel().Q()) {
            if (!getSharedViewModel().Q()) {
            } else {
                i2 = fragmentParentReturnTag;
            }
        } else {
        }
        if (i2 != 0) {
            str2 = getSharedViewModel().I();
            if (str2 == null) {
            } else {
                string = str2.getName();
            }
            if (string == null) {
                n.e(getString(2131887192), "getString(R.string.reminder_daily_training_your_dog)");
            }
            cVar = new c(trainingTimeMetrics, string, "workout", K1().getFragmentParentReturnTag());
            g1.n(getActivity(), cVar);
        } else {
            if (todayGoalAchieved2 ^= i2 != 0) {
                super("workout", 0, trainingTimeMetrics, K1().getFragmentParentReturnTag(), 2, 0);
                g1.n(getActivity(), cVar2);
            } else {
                g1.d(getActivity(), K1().getFragmentParentReturnTag(), fragmentParentReturnTag, 2, 0);
            }
        }
    }

    private final void N1(WorkoutStreakInfo workoutStreakInfo) {
        Object fragmentParentReturnTag;
        c cVar;
        String fragmentParentReturnTag2;
        int i;
        Object obj5;
        if (L1().z(workoutStreakInfo)) {
            cVar = new c(workoutStreakInfo, K1().getFragmentParentReturnTag());
            g1.n(getActivity(), cVar);
        } else {
            g1.d(getActivity(), K1().getFragmentParentReturnTag(), false, 2, 0);
        }
    }

    private final void O1() {
        J1(false);
        yg ygVar = this.c;
        final String str = "binding";
        final int i2 = 0;
        if (ygVar == null) {
        } else {
            ygVar.P.setElevation(requireContext().getResources().getDimension(2131165629));
            yg ygVar2 = this.c;
            if (ygVar2 == null) {
            } else {
                ygVar2.P.setOutlineProvider(i2);
            }
            n.w(str);
            throw i2;
        }
        n.w(str);
        throw i2;
    }

    private final void P1() {
        J1(false);
        yg ygVar = this.c;
        final String str = "binding";
        final int i2 = 0;
        if (ygVar == null) {
        } else {
            final int i3 = 2131165629;
            ygVar.S.setElevation(requireContext().getResources().getDimension(i3));
            yg ygVar2 = this.c;
            if (ygVar2 == null) {
            } else {
                ygVar2.Q.setElevation(requireContext().getResources().getDimension(i3));
                yg ygVar3 = this.c;
                if (ygVar3 == null) {
                } else {
                    ygVar3.Q.setOutlineProvider(i2);
                    yg ygVar4 = this.c;
                    if (ygVar4 == null) {
                    } else {
                        ygVar4.S.setOutlineProvider(i2);
                    }
                    n.w(str);
                    throw i2;
                }
                n.w(str);
                throw i2;
            }
            n.w(str);
            throw i2;
        }
        n.w(str);
        throw i2;
    }

    public static void Q1(app.dogo.com.dogo_android.f.l.j j, View view2) {
        j.h2(j, view2);
    }

    public static void R1(app.dogo.com.dogo_android.f.l.j j, Balloon balloon2, View view3) {
        j.f2(j, balloon2, view3);
    }

    public static void S1(app.dogo.com.dogo_android.f.l.j j, View view2) {
        j.e2(j, view2);
    }

    public static void T1(app.dogo.com.dogo_android.f.l.j j, app.dogo.com.dogo_android.f.l.l.a l$a2) {
        j.Z1(j, a2);
    }

    public static void U1(app.dogo.com.dogo_android.f.l.j j, View view2) {
        j.X1(j, view2);
    }

    public static void V1(app.dogo.com.dogo_android.f.l.j j, y y2) {
        j.Y1(j, y2);
    }

    public static void W1(Balloon balloon, app.dogo.com.dogo_android.f.l.j j2, View view3) {
        j.i2(balloon, j2, view3);
    }

    private static final void X1(app.dogo.com.dogo_android.f.l.j j, View view2) {
        n.f(j, "this$0");
        j.c2();
    }

    private static final void Y1(app.dogo.com.dogo_android.f.l.j j, y y2) {
        Object bVar;
        app.dogo.com.dogo_android.f.l.j.c cVar;
        boolean obj3;
        n.f(j, "this$0");
        if (y2 instanceof y.a) {
            obj3 = j.getString(2131886439);
            n.e(obj3, "getString(R.string.daily_workout_no_internet_connection)");
            bVar = new j.b(j);
            cVar = new j.c(j);
            f1.m0(j, obj3, bVar, cVar);
        }
    }

    private static final void Z1(app.dogo.com.dogo_android.f.l.j j, app.dogo.com.dogo_android.f.l.l.a l$a2) {
        String str;
        Object obj2;
        n.f(j, "this$0");
        if (a2 == null) {
        } else {
            if (a2 instanceof l.a.a) {
                j.M1((l.a.a)a2.a());
            } else {
                if (a2 instanceof l.a.b) {
                    j.N1((l.a.b)a2.a());
                }
            }
        }
    }

    private final void a2() {
        J1(true);
        yg ygVar = this.c;
        int i2 = 0;
        final String str = "binding";
        if (ygVar == null) {
        } else {
            ygVar.P.setElevation(0);
            yg ygVar2 = this.c;
            if (ygVar2 == null) {
            } else {
                ygVar2.P.setOutlineProvider(ViewOutlineProvider.BOUNDS);
            }
            n.w(str);
            throw i2;
        }
        n.w(str);
        throw i2;
    }

    private final void b2() {
        J1(true);
        yg ygVar = this.c;
        int i2 = 0;
        final String str = "binding";
        if (ygVar == null) {
        } else {
            int i3 = 0;
            ygVar.S.setElevation(i3);
            yg ygVar2 = this.c;
            if (ygVar2 == null) {
            } else {
                ygVar2.Q.setElevation(i3);
                yg ygVar3 = this.c;
                if (ygVar3 == null) {
                } else {
                    ygVar3.S.setOutlineProvider(ViewOutlineProvider.BOUNDS);
                    yg ygVar4 = this.c;
                    if (ygVar4 == null) {
                    } else {
                        ygVar4.Q.setOutlineProvider(ViewOutlineProvider.BOUNDS);
                    }
                    n.w(str);
                    throw i2;
                }
                n.w(str);
                throw i2;
            }
            n.w(str);
            throw i2;
        }
        n.w(str);
        throw i2;
    }

    private final void c2() {
        int i;
        int i4;
        app.dogo.com.dogo_android.f.l.j.d dVar;
        int i3;
        int i2;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            dVar = new j.d(this);
            f1.T(activity, 0, 2131887546, dVar, 1, 0);
        }
    }

    private final void d2() {
        int i2 = 0;
        final int i3 = 0;
        wn wnVar = wn.T(getLayoutInflater(), i2, i3);
        n.e(wnVar, "inflate(layoutInflater, null, false)");
        View view2 = wnVar.w();
        n.e(view2, "tooltipBinding.root");
        Balloon balloon = n1.a(this, view2);
        this.w = balloon;
        d dVar = new d(this);
        balloon.y = dVar;
        j.e eVar = new j.e(this);
        balloon.p0(eVar);
        c cVar = new c(this, balloon);
        wnVar.O.setOnClickListener(cVar);
        yg ygVar = this.c;
        if (ygVar == null) {
        } else {
            View view = ygVar.R;
            n.e(view, "binding.dummy");
            g.b(view, balloon, i3, (int)dimension);
        }
        n.w("binding");
        throw i2;
    }

    private static final void e2(app.dogo.com.dogo_android.f.l.j j, View view2) {
        n.f(j, "this$0");
        n.f(view2, "it");
        j.O1();
    }

    private static final void f2(app.dogo.com.dogo_android.f.l.j j, Balloon balloon2, View view3) {
        n.f(j, "this$0");
        n.f(balloon2, "$balloon");
        j.v = true;
        balloon2.J();
        j.g2();
    }

    private final void g2() {
        int i;
        int i3 = 0;
        final int i5 = 0;
        yn ynVar = yn.T(getLayoutInflater(), i3, i5);
        n.e(ynVar, "inflate(layoutInflater, null, false)");
        View view2 = ynVar.w();
        n.e(view2, "tooltipBinding.root");
        Balloon balloon = n1.b(this, view2);
        this.x = balloon;
        b bVar = new b(this);
        balloon.y = bVar;
        j.f fVar = new j.f(this);
        balloon.p0(fVar);
        h hVar = new h(balloon, this);
        ynVar.O.setOnClickListener(hVar);
        int i2 = balloon.V();
        yg ygVar2 = this.c;
        final String str4 = "binding";
        if (ygVar2 == null) {
        } else {
            yg ygVar3 = this.c;
            if (ygVar3 == null) {
            } else {
                height -= bottom;
                i = i6 < i2 ? i6 - i2 : i5;
                yg ygVar = this.c;
                if (ygVar == null) {
                } else {
                    View childAt = ygVar.Q.getChildAt(i5);
                    n.e(childAt, "binding.dailyWorkoutViewPager.getChildAt(0)");
                    g.a(childAt, balloon, 56, i);
                }
                n.w(str4);
                throw i3;
            }
            n.w(str4);
            throw i3;
        }
        n.w(str4);
        throw i3;
    }

    private static final void h2(app.dogo.com.dogo_android.f.l.j j, View view2) {
        n.f(j, "this$0");
        n.f(view2, "it");
        j.P1();
        j.v = false;
    }

    private static final void i2(Balloon balloon, app.dogo.com.dogo_android.f.l.j j2, View view3) {
        n.f(balloon, "$balloon");
        n.f(j2, "this$0");
        balloon.J();
        j2.L1().y();
    }

    @Override // androidx.fragment.app.Fragment
    public final l getSharedViewModel() {
        return (l)this.a.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void m1() {
        Object activity;
        boolean z;
        String fragmentParentReturnTag;
        int i;
        int i2;
        int i3;
        L1().v();
        if (!L1().t()) {
            if (L1().s()) {
                L1().x();
            } else {
                g1.d(getActivity(), K1().getFragmentParentReturnTag(), false, 2, 0);
            }
        } else {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        androidx.fragment.app.e activity;
        n.f(context, "context");
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.F();
        }
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        yg obj2 = yg.T(getLayoutInflater(), viewGroup2, false);
        n.e(obj2, "inflate(layoutInflater, container, false)");
        this.c = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.M(getViewLifecycleOwner());
            obj2 = this.c;
            if (obj2 == null) {
            } else {
                obj2.W(L1());
                obj2 = this.c;
                if (obj2 == null) {
                } else {
                    obj2.V(this);
                    obj2 = this.c;
                    if (obj2 == null) {
                    } else {
                        obj2 = obj2.w();
                        n.e(obj2, "binding.root");
                        return obj2;
                    }
                    n.w(obj4);
                    throw obj3;
                }
                n.w(obj4);
                throw obj3;
            }
            n.w(obj4);
            throw obj3;
        }
        n.w(obj4);
        throw obj3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        L1().w();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        L1().A();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        yg obj2 = this.c;
        if (obj2 == null) {
        } else {
            f obj3 = new f(this);
            obj2.T.setNavigationOnClickListener(obj3);
            j.a aVar = new j.a(this);
            requireActivity().getOnBackPressedDispatcher().b(getViewLifecycleOwner(), aVar);
            if (L1().u()) {
                d2();
            }
            g gVar = new g(this);
            L1().q().observe(getViewLifecycleOwner(), gVar);
            obj3 = getViewLifecycleOwner();
            n.e(obj3, "viewLifecycleOwner");
            e eVar = new e(this);
            L1().p().observe(obj3, eVar);
        }
        n.w("binding");
        throw 0;
    }
}

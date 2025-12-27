package app.dogo.com.dogo_android.y.s;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.if;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.t2;
import app.dogo.com.dogo_android.y.b0.d;
import app.dogo.com.dogo_android.y.c0.e;
import app.dogo.com.dogo_android.y.t.c;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.w;
import m.a.b.a.d.a.b;

/* compiled from: ProgramLessonFragment.kt */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\"\u0010!\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020&H\u0016J\u0008\u0010*\u001a\u00020\"H\u0016J\u0018\u0010+\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010,\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020&H\u0016J\u001a\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u001a2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0008\u0010/\u001a\u00020\"H\u0002J\u0008\u00100\u001a\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lesson/ProgramLessonFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/LessonCardAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramLessonBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/ProgramLessonScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/lesson/ProgramLessonScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/lesson/ProgramLessonViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/lesson/ProgramLessonViewModel;", "viewModel$delegate", "isLessonNotPassed", "", "lessonStatus", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$ProgramLessonStatus;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFullProgramListSelected", "", "nextLessonId", "", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "onQuestionCardSelected", "lessonItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "onResume", "onTaskCardSelected", "onTrainingCardSelected", "onViewCreated", "view", "returnToParent", "setupNavigation", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class ProgramLessonFragment extends Fragment implements i.a {

    /* renamed from: a, reason: from kotlin metadata */
    private if binding;
    private final h b;
    private final h c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[ProgramQuestion_Type.values().length];
            iArr[ProgramQuestion_Type.ANSWERED.ordinal()] = 1;
            kotlinx.coroutines.j.a.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            j.this.D1().u();
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

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements kotlin.d0.c.a<app.dogo.com.dogo_android.view.dailytraining.l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.view.dailytraining.l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public d(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class e extends p implements kotlin.d0.c.a<l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final l invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ProgramLessonViewModel.class), this.$parameters);
        }

        public e(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public j() {
        super();
        final m.a.c.j.a aVar = null;
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.j.e(this, aVar, aVar));
        this.c = j.a(LazyThreadSafetyMode.NONE, new kotlinx.coroutines.j.d(this, aVar, aVar));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ l isLessonNotPassed(j lessonStatus) {
        return lessonStatus.D1();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    private final k onResume() {
        return (ProgramLessonScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final l D1() {
        return (ProgramLessonViewModel)this.b.getValue();
    }

    private final boolean E1(ProgramLessonItem.ProgramLessonStatus programLessonStatus) {
        ProgramLessonItem.ProgramLessonStatus sTARTED2;
        boolean z = false;
        if (programLessonStatus == ProgramLessonItem_ProgramLessonStatus.STARTED || programLessonStatus == ProgramLessonItem_ProgramLessonStatus.NOT_STARTED) {
            int i2 = 1;
        }
        return z;
    }

    private static final void J1(j jVar, View view) {
        n.f(jVar, "this$0");
        final androidx.fragment.app.e activity = jVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void K1(j jVar, y yVar) {
        n.f(jVar, "this$0");
        z = yVar instanceof LoadResult_Error;
        if (yVar instanceof oadResult_Error) {
            android.content.Context requireContext = jVar.requireContext();
            str = "requireContext()";
            n.e(requireContext, str);
            app.dogo.com.dogo_android.util.extensionfunction.f1.m0(jVar, BindingAdapters.a.i(new Exception(yVar.component1()), requireContext), new kotlinx.coroutines.j.b(jVar), new kotlinx.coroutines.j.c(jVar));
        }
    }

    private final void L1() {
        final boolean z2 = false;
        final Object obj = null;
        if (!l.z(onResume().getFragmentParentReturnTag()) == 0) {
            int i = 3;
            app.dogo.com.dogo_android.util.extensionfunction.g1.b(getActivity(), new ProgramListScreen(obj, z2, i, obj));
        } else {
            androidx.fragment.app.e activity = getActivity();
            if (activity != null) {
                i = 2;
                app.dogo.com.dogo_android.util.extensionfunction.g1.replace(activity, onResume().getFragmentParentReturnTag(), z2, i, obj);
            }
        }
    }

    private final void M1() {
        getSharedViewModel().E().observe(getViewLifecycleOwner(), new kotlinx.coroutines.e(this));
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, "viewLifecycleOwner");
        D1().t().observe(viewLifecycleOwner2, new kotlinx.coroutines.f(this));
    }

    private static final void N1(j jVar, y yVar) {
        n.f(jVar, "this$0");
        DogProfile dogProfile = jVar.getSharedViewModel().I();
        if (dogProfile != null) {
            if (jVar.D1().r(dogProfile.getId()) != null) {
                jVar.L1();
            } else {
                jVar.D1().refreshLesson(dogProfile.getId(), jVar.onResume().e(), jVar.onResume().f());
            }
        }
    }

    private static final void O1(j jVar, ProgramLessonItem programLessonItem) {
        n.f(jVar, "this$0");
        n.e(programLessonItem, "it");
        app.dogo.com.dogo_android.util.extensionfunction.g1.o(jVar.getActivity(), new ProgramLessonCompleteScreen(programLessonItem, jVar.onResume().getFragmentParentReturnTag(), jVar.onResume().component1(), jVar.onResume().d()));
    }

    private final app.dogo.com.dogo_android.view.dailytraining.l getSharedViewModel() {
        return (SessionViewModel)this.c.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void K(ProgramLessonItem programLessonItem, ProgramSaveInfo programSaveInfo) {
        n.f(programLessonItem, "lessonItem");
        n.f(programSaveInfo, "programSaveInfo");
        if (kotlinx.coroutines.j.a.a[programLessonItem.getQuestion().getType().ordinal()] == 1) {
            boolean z = false;
            app.dogo.com.dogo_android.repository.domain.TrainingSession trainingSession = null;
            int i = 24;
            kotlin.d0.d.g gVar = null;
            ProgramQuestionCorrectAnswerScreen programQuestionCorrectAnswerScreen = new ProgramQuestionCorrectAnswerScreen(programLessonItem.getQuestion(), programSaveInfo, onResume().getTag(), z, trainingSession, i, gVar);
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), programQuestionCorrectAnswerScreen);
        } else {
            z = false;
            trainingSession = null;
            i = 24;
            gVar = null;
            ProgramQuestionScreen programQuestionScreen = new ProgramQuestionScreen(programLessonItem.getQuestion(), programSaveInfo, onResume().getTag(), z, trainingSession, i, gVar);
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), programQuestionScreen);
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: b1, reason: from kotlin metadata */
    public void onCreateView(ProgramLessonItem.ProgramLessonStatus inflater, String container, ProgramSaveInfo savedInstanceState) {
        n.f(inflater, "lessonStatus");
        n.f(savedInstanceState, "programSaveInfo");
        D1().y(inflater);
        if (getSharedViewModel().I() != null) {
            if (E1(inflater)) {
                if (!D1().x()) {
                    boolean z = false;
                    int i = 1;
                    kotlin.d0.d.g gVar = null;
                    ProgramLessonsListScreen container2 = new ProgramLessonsListScreen(z, savedInstanceState.getProgramId(), onResume().component1(), onResume().d(), onResume().getFragmentParentReturnTag(), i, gVar);
                    app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), container2);
                } else {
                    App.INSTANCE.r().logEvent(E_TrainingProgram.c.withoutParameters());
                    androidx.fragment.app.e activity = getActivity();
                    if (activity != null) {
                        app.dogo.com.dogo_android.util.extensionfunction.f1.d0(activity, 2131887586);
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void h1(ProgramLessonItem programLessonItem, ProgramSaveInfo programSaveInfo) {
        n.f(programLessonItem, "lessonItem");
        n.f(programSaveInfo, "programSaveInfo");
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new ProgramTasksListScreen(programLessonItem.getTasks(), programSaveInfo));
    }

    @Override // androidx.fragment.app.Fragment
    public void n1(ProgramLessonItem programLessonItem, ProgramSaveInfo programSaveInfo) {
        n.f(programLessonItem, "lessonItem");
        n.f(programSaveInfo, "programSaveInfo");
        ProgramTrainingPlanScreen programTrainingPlanScreen = new ProgramTrainingPlanScreen(programLessonItem.getTrainingSession(), programSaveInfo, onResume().getTag(), false, 8, null);
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), programTrainingPlanScreen);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n.f(layoutInflater, "inflater");
        if ifVar = if.T(layoutInflater, viewGroup, false);
        n.e(ifVar, "inflate(inflater, container, false)");
        this.binding = ifVar;
        int i = 0;
        String str4 = "binding";
        if (ifVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            ifVar.W(getSharedViewModel());
            if (this.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.X(D1());
                if (this.binding == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.binding.V(this);
                    if (this.binding == null) {
                        n.w(str4);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        this.binding.M(getViewLifecycleOwner());
                        if (this.binding == null) {
                            n.w(str4);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i;
                        } else {
                            View view = this.binding.w();
                            n.e(view, "binding.root");
                            return view;
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
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.P.setNavigationOnClickListener(new kotlinx.coroutines.g(this));
            M1();
            D1().getResult().observe(getViewLifecycleOwner(), new kotlinx.coroutines.h(this));
            return;
        }
    }


    /* renamed from: F1, reason: from kotlin metadata */
    public static /* synthetic */ void onQuestionCardSelected(j lessonItem, y programSaveInfo) {
        ProgramLessonFragment.N1(lessonItem, programSaveInfo);
    }

    /* renamed from: G1, reason: from kotlin metadata */
    public static /* synthetic */ void onTaskCardSelected(j lessonItem, ProgramLessonItem programSaveInfo) {
        ProgramLessonFragment.O1(lessonItem, programSaveInfo);
    }

    /* renamed from: H1, reason: from kotlin metadata */
    public static /* synthetic */ void onTrainingCardSelected(j lessonItem, View programSaveInfo) {
        ProgramLessonFragment.J1(lessonItem, programSaveInfo);
    }

    /* renamed from: I1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(j view, y savedInstanceState) {
        ProgramLessonFragment.K1(view, savedInstanceState);
    }
}

package app.dogo.com.dogo_android.y.w;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.c.a;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.qf;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.Program;
import app.dogo.com.dogo_android.repository.domain.ProgramLesson;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.service.q2.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.n.i;
import app.dogo.com.dogo_android.y.o.w;
import app.dogo.com.dogo_android.y.s.k;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.f0;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.m;

/* compiled from: ProgramLessonsListFragment.kt */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'H\u0016J\u001a\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00182\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0008\u0010*\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006,", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramLessonsListBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListViewModel;", "viewModel$delegate", "listLoaded", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onExamItemPressed", "saveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "onItemSelected", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson;", "onLockedItemPressed", "activeLessonIndex", "", "onViewCreated", "view", "showLessonIntroduction", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m, reason: from kotlin metadata */
public final class ProgramLessonsListFragment extends Fragment implements l.b {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final m.a INSTANCE = new m$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private qf binding;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonslist/ProgramLessonsListFragment$Companion;", "", "()V", "LESSON_LIST_ITEM_NUMBER_FOR_POP_UP_SHOW", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<l> {

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
    public static final class c extends p implements kotlin.d0.c.a<o> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final o invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ProgramLessonsListViewModel.class), this.$parameters);
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
            Object[] arr = new Object[1];
            return org.koin.core.parameter.b.b(new Object[] { m.this.listLoaded().e() });
        }

        d() {
            super(0);
        }
    }

    public m() {
        super();
        final m.a.c.j.a aVar = null;
        this.b = j.a(LazyThreadSafetyMode.NONE, new kotlinx.coroutines.m.b(this, aVar, aVar));
        this.c = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.m.c(this, aVar, new kotlinx.coroutines.m.d(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ n onExamItemPressed(m saveInfo) {
        return saveInfo.listLoaded();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    private final n listLoaded() {
        return (ProgramLessonsListScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final o D1() {
        return (ProgramLessonsListViewModel)this.c.getValue();
    }

    private static final void J1(m mVar, DialogInterface dialogInterface, int i) {
        n.f(mVar, "this$0");
        mVar.D1().y();
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(mVar.getActivity(), SessionViewModel.H(mVar.getSharedViewModel(), "program_lesson_list", mVar.listLoaded().getTag(), false, null, 12, null));
    }

    private static final void K1(m mVar, View view) {
        n.f(mVar, "this$0");
        final androidx.fragment.app.e activity = mVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void L1(m mVar, View view) {
        n.f(mVar, "this$0");
        app.dogo.com.dogo_android.util.extensionfunction.g1.f(mVar.getActivity(), mVar.listLoaded().getFragmentParentReturnTag(), new ProgramListScreen(mVar.listLoaded().getFragmentParentReturnTag(), mVar.listLoaded().component1()), false, 4, null);
    }

    private static final void M1(m mVar, View view) {
        n.f(mVar, "this$0");
        if (mVar.getSharedViewModel().I() != null) {
            boolean z = false;
            app.dogo.com.dogo_android.repository.domain.ProfilePreview profilePreview = null;
            int i = 12;
            Object obj = null;
            str = "program_lesson_list";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(mVar.getActivity(), SessionViewModel.H(mVar.getSharedViewModel(), str, mVar.listLoaded().getTag(), z, profilePreview, i, obj));
        }
    }

    private static final void N1(m mVar, View view) {
        Object value = null;
        n.f(mVar, "this$0");
        DogProfile dogProfile = mVar.getSharedViewModel().I();
        if (dogProfile != null) {
            LoadResult_Success r0 = mVar.D1().getResult().getValue() instanceof LoadResult_Success ? (oadResult_Success)mVar.D1().getResult().getValue() : 0;
            if (value != null) {
                value = value.component1();
                if (value != null) {
                    String str3 = null;
                    int i = 8;
                    kotlin.d0.d.g gVar = null;
                    str2 = "program_lesson_list";
                    CertificateDetailScreen certificateDetailScreen = new CertificateDetailScreen(value.getExamSumamry(), app.dogo.com.dogo_android.util.extensionfunction.j1.w0(dogProfile.getName()), str2, str3, i, gVar);
                    app.dogo.com.dogo_android.util.extensionfunction.g1.n(mVar.getActivity(), certificateDetailScreen);
                }
            }
        }
    }

    private final void O1() {
        if (!D1().m()) {
            D1().s();
            D1().w();
            app.dogo.com.dogo_android.util.extensionfunction.k1.e(this, DialogTags.LESSON_INTRODUCTION_DIALOG, new Bundle());
        }
    }

    private final l getSharedViewModel() {
        return (SessionViewModel)this.b.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: W0, reason: from kotlin metadata */
    public void onItemSelected(int item) {
        D1().x();
        String string = getString(2131887589);
        n.e(string, "getString(R.string.training_program_lesson_locked_alert)");
        int i5 = 1;
        final Object[] arr = new Object[i5];
        arr[0] = Integer.valueOf(item);
        String formatted = String.format(string, Arrays.copyOf(arr, i5));
        n.e(formatted, "java.lang.String.format(format, *args)");
        new b(requireContext()).x(formatted).D(2131887097, new kotlinx.coroutines.h(this)).A(2131886691, null).o();
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: d0, reason: from kotlin metadata */
    public void onLockedItemPressed(ProgramLesson activeLessonIndex) {
        boolean lessonUnlocked;
        app.dogo.com.dogo_android.y.w.n listLoaded;
        k activeLessonIndex2;
        String lessonId;
        String programId;
        String fragmentParentReturnTag;
        boolean component1;
        boolean z2;
        n.f(activeLessonIndex, "item");
        if (getSharedViewModel().I() != null) {
            if (!listLoaded().f() || !activeLessonIndex.isPremiumLocked()) {
                if (activeLessonIndex.isLessonUnlocked()) {
                    int i = 2;
                    if (activeLessonIndex.getItemNumber() == 2 && this.D1().v()) {
                        D1().t();
                        androidx.fragment.app.e activity3 = getActivity();
                        if (activity3 != null) {
                            app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(activity3, new RatePromptV2Screen(RateItService_RateSource.LESSON_LIST_SECOND_ITEM.getTag()));
                        }
                    }
                    activeLessonIndex2 = new ProgramLessonScreen(activeLessonIndex.getProgramSaveInfo().getLessonId(), activeLessonIndex.getProgramSaveInfo().getProgramId(), listLoaded().getFragmentParentReturnTag(), listLoaded().component1(), listLoaded().d());
                    app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), activeLessonIndex2);
                }
                O1();
            } else {
                boolean z = false;
                app.dogo.com.dogo_android.repository.domain.ProfilePreview profilePreview = null;
                int i2 = 12;
                Object obj = null;
                str = "program_lesson_list";
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), SessionViewModel.H(getSharedViewModel(), str, listLoaded().getTag(), z, profilePreview, i2, obj));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void h() {
        D1().u(false);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n.f(layoutInflater, "inflater");
        qf qfVar = qf.T(layoutInflater, viewGroup, false);
        n.e(qfVar, "inflate(inflater, container, false)");
        this.binding = qfVar;
        int i2 = 0;
        String str4 = "binding";
        if (qfVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i2;
        } else {
            qfVar.M(getViewLifecycleOwner());
            if (this.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i2;
            } else {
                this.binding.X(D1());
                if (this.binding == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i2;
                } else {
                    this.binding.W(Boolean.valueOf(!listLoaded().d()));
                    if (this.binding == null) {
                        n.w(str4);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i2;
                    } else {
                        this.binding.V(this);
                        if (this.binding == null) {
                            n.w(str4);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i2;
                        } else {
                            return binding24.W;
                        }
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
        D1().r();
        String str2 = "binding";
        i = 0;
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.Y.setNavigationOnClickListener(new kotlinx.coroutines.g(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                binding22.P.setOnClickListener(new kotlinx.coroutines.f(this));
                if (this.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    binding23.Z.setOnClickListener(new kotlinx.coroutines.i(this));
                    if (this.binding == null) {
                        n.w(str2);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        binding24.O.w().setOnClickListener(new kotlinx.coroutines.j(this));
                        if (!D1().q()) {
                            androidx.fragment.app.e view2 = getActivity();
                            z = view2 instanceof Navigator;
                            if (view2 instanceof Navigator) {
                            }
                            if (i != 0) {
                                i.F();
                            }
                        } else {
                            view2 = getActivity();
                            z = view2 instanceof Navigator;
                            if (view2 instanceof Navigator) {
                            }
                            if (i != 0) {
                                i.p0();
                            }
                        }
                        return;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void z1(ProgramSaveInfo programSaveInfo) {
        n.f(programSaveInfo, "saveInfo");
        LessonExamListScreen lessonExamListScreen = new LessonExamListScreen(programSaveInfo, listLoaded().getTag(), "lesson", false, 8, null);
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), lessonExamListScreen);
    }

    /* renamed from: E1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(m view, View savedInstanceState) {
        ProgramLessonsListFragment.L1(view, savedInstanceState);
    }

    public static /* synthetic */ void F1(m mVar, View view) {
        ProgramLessonsListFragment.K1(mVar, view);
    }

    /* renamed from: G1, reason: from kotlin metadata */
    public static /* synthetic */ void onCreateView(m inflater, DialogInterface container, int savedInstanceState) {
        ProgramLessonsListFragment.J1(inflater, container, savedInstanceState);
    }

    public static /* synthetic */ void H1(m mVar, View view) {
        ProgramLessonsListFragment.M1(mVar, view);
    }

    public static /* synthetic */ void I1(m mVar, View view) {
        ProgramLessonsListFragment.N1(mVar, view);
    }
}

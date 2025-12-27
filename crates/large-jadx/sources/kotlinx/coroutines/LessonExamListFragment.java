package app.dogo.com.dogo_android.y.o;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.mf;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramExamList;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.n.i;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.m;
import kotlin.w;

/* compiled from: LessonExamListFragment.kt */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0015\u001a\u00020\u0016H\u0002J\u0008\u0010\u0017\u001a\u00020\u0016H\u0002J\u0008\u0010\u0018\u001a\u00020\u0016H\u0016J\"\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0008\u0010\u001f\u001a\u00020\u0016H\u0016J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010%2\u0008\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0018\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u0008\u00100\u001a\u00020\u0016H\u0016J\u0010\u00101\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J\u001a\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020!2\u0008\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u00104\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0002J\u0008\u00105\u001a\u00020\u0016H\u0002J\u0010\u00106\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u00067", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramLessonExamListBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamListViewModel;", "viewModel$delegate", "goBack", "", "goToCertificate", "listLoaded", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCertificatePressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onExamHistoryPressed", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "isDogPremium", "", "onLockedItemPressed", "onPremiumLockedExamPressed", "onRecordExamPressed", "onResume", "onShowExamVideoPressed", "onViewCreated", "view", "recordVideo", "setupObservers", "videoPlayback", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: v, reason: from kotlin metadata */
public final class LessonExamListFragment extends Fragment implements u.b {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private final h b;
    private mf c;

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            v.this.E1().z();
        }

        a() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            androidx.fragment.app.e activity = v.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }

        b() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements kotlin.d0.c.a<l> {

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
    public static final class d extends p implements kotlin.d0.c.a<x> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final x invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(LessonExamListViewModel.class), this.$parameters);
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
            return org.koin.core.parameter.b.b(new Object[] { v.this.goBack().d(), Boolean.valueOf(n.b(v.this.goBack().e(), "lesson_exam_unlocked")) });
        }

        e() {
            super(0);
        }
    }
    public v() {
        super();
        final m.a.c.j.a aVar = null;
        this.binding = j.a(LazyThreadSafetyMode.NONE, new kotlinx.coroutines.v.c(this, aVar, aVar));
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.v.d(this, aVar, new kotlinx.coroutines.v.e(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ w onLockedItemPressed(v item) {
        return item.goBack();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static final /* synthetic */ x onPremiumLockedExamPressed(v item) {
        return item.E1();
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final w goBack() {
        return (LessonExamListScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final x E1() {
        return (LessonExamListViewModel)this.b.getValue();
    }

    private final void F1() {
        final app.dogo.com.dogo_android.repository.domain.ProgramExamSummary programExamSummary = E1().r();
        if (programExamSummary != null) {
            DogProfile dogProfile = getSharedViewModel().I();
            if (dogProfile != null) {
                String str3 = null;
                int i = 8;
                kotlin.d0.d.g gVar = null;
                str2 = "lesson_exam_list";
                CertificateDetailScreen certificateDetailScreen = new CertificateDetailScreen(programExamSummary, app.dogo.com.dogo_android.util.extensionfunction.j1.w0(dogProfile.getName()), str2, str3, i, gVar);
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), certificateDetailScreen);
            }
        }
    }

    private static final void J1(v vVar, View view) {
        n.f(vVar, "this$0");
        vVar.goBack();
    }

    /* renamed from: K1, reason: from kotlin metadata */
    private final void onRecordExamPressed(ProgramExam item) {
        E1().A(item);
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.s0(activity, E1().p(item), item.getProgramSaveInfo());
        }
    }

    private final void L1() {
        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
        String str = "viewLifecycleOwner";
        n.e(viewLifecycleOwner, str);
        E1().q().observe(viewLifecycleOwner, new kotlinx.coroutines.p(this));
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, str);
        E1().s().observe(viewLifecycleOwner2, new kotlinx.coroutines.o(this));
    }

    private static final void M1(v vVar, ProgramExamList list) {
        n.f(vVar, "this$0");
        if (vVar.goBack().component1() && list.getProgramExamSummary() != null) {
            vVar.goBack().f(false);
            app.dogo.com.dogo_android.util.extensionfunction.g1.o(vVar.getActivity(), new ProgramExamsCompletedScreen(list.getProgramExamSummary(), list.getDogProfile().getName(), vVar.goBack().getTag()));
        }
    }

    private static final void N1(v vVar, Throwable th) {
        n.f(vVar, "this$0");
        n.e(th, "it");
        app.dogo.com.dogo_android.util.extensionfunction.f1.W(vVar, th, new kotlinx.coroutines.v.a(vVar), new kotlinx.coroutines.v.b(vVar));
    }

    /* renamed from: O1, reason: from kotlin metadata */
    private final void onShowExamVideoPressed(ProgramExam item) {
        androidx.fragment.app.e activity = null;
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.v0(E1().p(item));
        }
    }

    private final l getSharedViewModel() {
        return (SessionViewModel)this.binding.getValue();
    }

    private final void goBack() {
        requireActivity().onBackPressed();
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: E, reason: from kotlin metadata */
    public void recordVideo(ProgramExam item) {
        n.f(item, "item");
        E1().A(item);
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), SessionViewModel.H(getSharedViewModel(), "lesson_exam_list", goBack().getTag(), false, null, 12, null));
    }

    @Override // androidx.fragment.app.Fragment
    public void H0() {
        F1();
    }

    @Override // androidx.fragment.app.Fragment
    public void M0(ProgramExam programExam, boolean z) {
        n.f(programExam, "item");
        E1().E(programExam);
        E1().A(programExam);
        goBack().f(n.b(programExam.getHasNewUpdates(), Boolean.TRUE));
        LessonExamHistoryScreen lessonExamHistoryScreen = new LessonExamHistoryScreen(goBack().d(), programExam.getName(), programExam.getTrickId(), z, null, 16, null);
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), lessonExamHistoryScreen);
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: e1, reason: from kotlin metadata */
    public void videoPlayback(ProgramExam item) throws android.content.res.Resources.NotFoundException {
        n.f(item, "item");
        E1().F(item);
        Toast.makeText(getContext(), 2131886544, 0).show();
    }

    @Override // androidx.fragment.app.Fragment
    public void h() {
        E1().B(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void i(ProgramExam programExam) {
        int i = 1;
        n.f(programExam, "item");
        int r0 = programExam.getVideoUrl().length() > 0 ? 1 : 0;
        if (i != 0) {
            onShowExamVideoPressed(programExam);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void o0(ProgramExam programExam) {
        n.f(programExam, "item");
        E1().G(programExam);
        E1().A(programExam);
        if (!E1().w()) {
            E1().C();
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new PrepareForExamScreen(programExam, E1().p(programExam)));
        } else {
            onRecordExamPressed(programExam);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11102 && resultCode == -1) {
            E1().x();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        mf mfVar = mf.T(getLayoutInflater(), container, false);
        n.e(mfVar, "inflate(layoutInflater, container, false)");
        this.c = mfVar;
        int i = 0;
        String str4 = "binding";
        if (mfVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            mfVar.M(getViewLifecycleOwner());
            if (this.c == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.c.W(E1());
                if (this.c == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.c.V(this);
                    if (this.c == null) {
                        n.w(str4);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        View view = this.c.w();
                        n.e(view, "binding.root");
                        return view;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        E1().x();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        int i = 0;
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        i = 0;
        if (this.c == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            mfVar.Q.setNavigationOnClickListener(new kotlinx.coroutines.n(this));
            androidx.fragment.app.e view2 = getActivity();
            if (view2 instanceof Navigator) {
            }
            if (i != 0) {
                i.F();
            }
            L1();
            return;
        }
    }


    /* renamed from: G1, reason: from kotlin metadata */
    public static /* synthetic */ void onExamHistoryPressed(v item, View isDogPremium) {
        LessonExamListFragment.J1(item, isDogPremium);
    }

    /* renamed from: H1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(v view, Throwable savedInstanceState) {
        LessonExamListFragment.N1(view, savedInstanceState);
    }

    public static /* synthetic */ void I1(v vVar, ProgramExamList list) {
        LessonExamListFragment.M1(vVar, list);
    }
}

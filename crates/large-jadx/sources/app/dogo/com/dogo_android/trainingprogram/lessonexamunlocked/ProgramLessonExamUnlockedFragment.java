package app.dogo.com.dogo_android.y.u;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.d;
import androidx.activity.e;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.of;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.g;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.m;

/* compiled from: ProgramLessonExamUnlockedFragment.kt */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0008\u0010 \u001a\u0004\u0018\u00010!2\u0008\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u001d2\u0008\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0008\u0010&\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000cR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0013\u0010\u000e\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonexamunlocked/ProgramLessonExamUnlockedFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramLessonExamUnlockedBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/lessonexamunlocked/ProgramLessonExamUnlockedScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/lessonexamunlocked/ProgramLessonExamUnlockedScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/lessonexamunlocked/ProgramLessonExamUnlockedViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/lessonexamunlocked/ProgramLessonExamUnlockedViewModel;", "viewModel$delegate", "goToExamList", "", "goToNextScreen", "appScreen", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setUpExamsText", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class ProgramLessonExamUnlockedFragment extends Fragment {

    /* renamed from: a, reason: from kotlin metadata */
    private of binding;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n", d2 = {"<anonymous>", "", "Landroidx/activity/OnBackPressedCallback;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements kotlin.d0.c.l<d, kotlin.w> {
        @Override // kotlin.d0.d.p
        public final void a(d dVar) {
            n.f(dVar, "$this$addCallback");
            app.dogo.com.dogo_android.y.j jVar = d.this.goToExamList().b();
            if (jVar != null) {
                d.this.onAttach(jVar);
            } else {
                androidx.fragment.app.e activity = d.this.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.goToFragmentSmooth(activity);
                }
            }
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.l<TrickItem, java.lang.CharSequence> {

        public static final d.b a = new d$b();
        @Override // kotlin.d0.d.p
        public final java.lang.CharSequence a(TrickItem trickItem) {
            n.f(trickItem, "it");
            return trickItem.getName();
        }


        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends kotlin.d0.d.p implements kotlin.d0.c.a<app.dogo.com.dogo_android.view.dailytraining.l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.view.dailytraining.l invoke() {
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
    public static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<f> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final f invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ProgramLessonExamUnlockedViewModel.class), this.$parameters);
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
            Object[] arr = new Object[2];
            return org.koin.core.parameter.b.b(new Object[] { Boolean.valueOf(d.this.goToExamList().e()), d.this.goToExamList().f().getLessonId() });
        }

        e() {
            super(0);
        }
    }
    public d() {
        super();
        final m.a.c.j.a aVar = null;
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.trainingprogram.lessonexamunlocked.d.d(this, aVar, new app.dogo.com.dogo_android.trainingprogram.lessonexamunlocked.d.e(this)));
        this.c = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.trainingprogram.lessonexamunlocked.d.c(this, aVar, aVar));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ e goToNextScreen(d appScreen) {
        return appScreen.goToExamList();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static final /* synthetic */ void onViewCreated(d view, app.dogo.com.dogo_android.y.j savedInstanceState) {
        view.onAttach(savedInstanceState);
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final e goToExamList() {
        return (ProgramLessonExamUnlockedScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final f E1() {
        return (ProgramLessonExamUnlockedViewModel)this.b.getValue();
    }

    private final void F1() {
        String fragmentReturnTag = null;
        String fragmentReturnTag2;
        boolean z = false;
        int i = 4;
        Object obj = null;
        app.dogo.com.dogo_android.y.j jVar = goToExamList().b();
        if (jVar == null) {
            int i3 = 0;
        } else {
            fragmentReturnTag = jVar.getTag();
        }
        if (fragmentReturnTag == null) {
            fragmentReturnTag = goToExamList().getFragmentReturnTag();
        }
        if (jVar != null) {
            androidx.fragment.app.e activity = getActivity();
            if (activity != null) {
                z = false;
                i = 4;
                obj = null;
                app.dogo.com.dogo_android.util.extensionfunction.g1.f(activity, goToExamList().getFragmentReturnTag(), jVar, z, i, obj);
            }
        }
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 != null) {
            boolean z2 = false;
            int i2 = 8;
            kotlin.d0.d.g gVar = null;
            str = "lesson_exam_unlocked";
            LessonExamListScreen lessonExamListScreen = new LessonExamListScreen(goToExamList().f(), fragmentReturnTag, str, z2, i2, gVar);
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity2, lessonExamListScreen);
        }
    }

    /* renamed from: G1, reason: from kotlin metadata */
    private final void onAttach(app.dogo.com.dogo_android.y.j context) {
        if (goToExamList().a()) {
            androidx.fragment.app.e activity = getActivity();
            if (activity != null) {
                boolean z = false;
                int i = 4;
                Object obj = null;
                app.dogo.com.dogo_android.util.extensionfunction.g1.f(activity, goToExamList().getFragmentReturnTag(), context, z, i, obj);
            }
        } else {
            androidx.fragment.app.e activity2 = getActivity();
            if (activity2 != null) {
                app.dogo.com.dogo_android.util.extensionfunction.g1.n(activity2, context);
            }
        }
    }

    private static final void K1(d dVar, View view) {
        n.f(dVar, "this$0");
        dVar.E1().laterTrackButtonClick();
        final androidx.fragment.app.e activity = dVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void L1(d dVar, View view) {
        n.f(dVar, "this$0");
        dVar.E1().n();
        dVar.F1();
    }

    private static final void M1(d dVar, View view) {
        n.f(dVar, "this$0");
        dVar.E1().m();
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(dVar.getActivity(), SessionViewModel.H(dVar.getSharedViewModel(), "lesson_exam_unlocked", dVar.goToExamList().getTag(), false, null, 12, null));
    }

    private final void N1() throws android.content.res.Resources.NotFoundException {
        int i;
        String str;
        java.util.List exams;
        i = 0;
        LoadResult_Success r0 = getSharedViewModel().getResult().getValue() instanceof LoadResult_Success ? (oadResult_Success)this.getSharedViewModel().getResult().getValue() : i;
        int r3 = i;
        if (exams == null) {
        } else {
            int i2 = 0;
            java.lang.CharSequence charSequence = null;
            int i3 = 24;
            Object obj = null;
            str2 = "”, “";
            str3 = "“";
            str4 = "”";
            str = p.h0(exams, str2, str3, str4, i2, charSequence, app.dogo.com.dogo_android.trainingprogram.lessonexamunlocked.d.b.a, i3, obj);
        }
        Object[] arr = new Object[1];
        String string = getResources().getString(2131886532, new Object[] { str });
        n.e(string, "resources.getString(R.string.exam_is_unlocked, text)");
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            binding2.O.setText(string);
            return;
        }
    }

    private final app.dogo.com.dogo_android.view.dailytraining.l getSharedViewModel() {
        return (SessionViewModel)this.c.getValue();
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
        of ofVar = of.T(inflater, container, false);
        n.e(ofVar, "inflate(inflater, container, false)");
        this.binding = ofVar;
        int i = 0;
        String str3 = "binding";
        if (ofVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            ofVar.V(E1());
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.M(getViewLifecycleOwner());
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws a {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        n.e(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        e.b(onBackPressedDispatcher, getViewLifecycleOwner(), false, new app.dogo.com.dogo_android.trainingprogram.lessonexamunlocked.d.a(this), 2, null);
        N1();
        int i4 = 0;
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i4;
        } else {
            binding2.Q.setOnClickListener(new app.dogo.com.dogo_android.trainingprogram.lessonexamunlocked.b(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i4;
            } else {
                binding22.T.setOnClickListener(new app.dogo.com.dogo_android.trainingprogram.lessonexamunlocked.c(this));
                if (this.binding == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i4;
                } else {
                    binding23.S.setOnClickListener(new app.dogo.com.dogo_android.trainingprogram.lessonexamunlocked.a(this));
                    E1().j();
                    return;
                }
            }
        }
    }


    public static /* synthetic */ void H1(d dVar, View view) {
        ProgramLessonExamUnlockedFragment.M1(dVar, view);
    }

    public static /* synthetic */ void I1(d dVar, View view) {
        ProgramLessonExamUnlockedFragment.K1(dVar, view);
    }

    public static /* synthetic */ void J1(d dVar, View view) {
        ProgramLessonExamUnlockedFragment.L1(dVar, view);
    }
}

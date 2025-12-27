package app.dogo.com.dogo_android.y.z;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import androidx.lifecycle.r;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.h.uf;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.subscription.SubscriptionScreenKey;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import kotlin.Metadata;
import kotlin.b0.k.a.f;
import kotlin.d0.d.c0;
import kotlin.h;
import kotlin.m;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.x0;

/* compiled from: ProgramOverviewFragment.kt */
@Metadata(d1 = "\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0014\u001a\u00020\u0015H\u0082Pø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\"\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J$\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010%2\u0008\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0008\u0010(\u001a\u00020\u0015H\u0016J\u001a\u0010)\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0008\u0010*\u001a\u00020\u0015H\u0002J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-H\u0002J\u0018\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000cR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0013\u0010\u000e\u001a\u0004\u0008\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u00064", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramOverviewBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewViewModel;", "viewModel$delegate", "autoScrollFeaturesList", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFullViewVisible", "", "view", "Landroid/view/View;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "showLessonIntroduction", "startLessonFlow", "lessonId", "", "startQuestionFlow", "saveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class ProgramOverviewFragment extends Fragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final e.a INSTANCE = new e$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private uf binding;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/programoverview/ProgramOverviewFragment$Companion;", "", "()V", "DELAY_BETWEEN_SCROLL_MS", "", "DIRECTION_RIGHT", "", "SCROLL_DX", "SUBSCRIPTION_REQUEST_CODE", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.programoverview.ProgramOverviewFragment", f = "ProgramOverviewFragment.kt", l = 133, m = "autoScrollFeaturesList")
    static final class b extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        b(kotlin.b0.d<? super e.b> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return e.this.startLessonFlow(this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final l invoke() {
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
    public static final class e extends kotlin.d0.d.p implements kotlin.d0.c.a<g> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final g invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ProgramOverviewViewModel.class), this.$parameters);
        }

        public e(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends kotlin.d0.d.p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[2];
            return org.koin.core.parameter.b.b(new Object[] { e.this.autoScrollFeaturesList().d(), e.this.autoScrollFeaturesList().e() });
        }

        f() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.trainingprogram.programoverview.ProgramOverviewFragment$onViewCreated$1", f = "ProgramOverviewFragment.kt", l = 51, m = "invokeSuspend")
    static final class c extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, kotlin.b0.d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    return w.a;
                }
            }
            q.b(object);
            this.label = i;
            if (e.this.startLessonFlow(this) == obj) {
                return obj;
            }
        }

        c(kotlin.b0.d<? super e.c> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (kotlinx.coroutines.e.c)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new kotlinx.coroutines.e.c(e.this, dVar);
        }
    }

    public e() {
        super();
        final m.a.c.j.a aVar = null;
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.e.e(this, aVar, new kotlinx.coroutines.e.f(this)));
        this.c = j.a(LazyThreadSafetyMode.NONE, new kotlinx.coroutines.e.d(this, aVar, aVar));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ Object onViewCreated(e view, kotlin.b0.d savedInstanceState) {
        return view.startLessonFlow(savedInstanceState);
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static final /* synthetic */ f isFullViewVisible(e view) {
        return view.autoScrollFeaturesList();
    }

    /* renamed from: D1, reason: from kotlin metadata */
    private final Object startLessonFlow(kotlin.b0.d<? super w> lessonId) {
        Object lessonId2;
        int label2;
        int i = -2147483648;
        Object obj;
        int i2;
        long l;
        z = lessonId instanceof kotlinx.coroutines.e.b;
        if (lessonId instanceof kotlinx.coroutines.e.b) {
            lessonId2 = lessonId;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                lessonId2.label -= i;
            } else {
                app.dogo.com.dogo_android.y.z.e.b bVar = new kotlinx.coroutines.e.b(this, lessonId);
            }
        }
        Object obj2 = b.d();
        int i4 = 1;
        if (lessonId2.label != 0) {
            if (lessonId2.label != i4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(lessonId2.result);
                while (obj.binding != null) {
                    n.e(binding2.Z, "binding.programTricksList");
                }
                n.w("binding");
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            }
        }
        q.b(lessonId2.result);
        app.dogo.com.dogo_android.y.z.e lessonId3 = this;
    }

    /* renamed from: E1, reason: from kotlin metadata */
    /* suspend tailrec */ private final f autoScrollFeaturesList() {
        return (ProgramOverviewScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final g F1() {
        return (ProgramOverviewViewModel)this.b.getValue();
    }

    private static final void J1(e eVar, View view) {
        n.f(eVar, "this$0");
        eVar.F1().C();
        final androidx.fragment.app.e activity = eVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void K1(e eVar, y yVar) {
        boolean z;
        boolean programStarted;
        n.f(eVar, "this$0");
        z = yVar instanceof LoadResult_Success;
        if (yVar instanceof oadResult_Success) {
            if (eVar.F1().v()) {
                Object yVar22 = yVar;
                if (!(ProgramLessonItem)yVar22.component1().getProgramStarted()) {
                    eVar.O1((ProgramLessonItem)yVar22.component1().getProgramSaveInfo(), (ProgramLessonItem)yVar22.component1());
                } else {
                    eVar.N1((ProgramLessonItem)yVar.component1().getProgramSaveInfo().getLessonId());
                }
            }
        }
    }

    private static final void L1(e eVar) {
        String str;
        n.f(eVar, "this$0");
        final boolean z = true;
        int i = 0;
        final String str4 = "binding";
        if (!eVar.F1().p()) {
            if (eVar.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                str = "binding.certificatePreview";
                n.e(binding2.Q, str);
                if (eVar.isFullViewVisible(binding2.Q)) {
                    eVar.F1().y(z);
                }
            }
        }
        if (!eVar.F1().q()) {
            if (eVar.binding == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                str = "binding.dogSkillsList";
                n.e(binding22.U, str);
                if (eVar.isFullViewVisible(binding22.U)) {
                    eVar.F1().z(z);
                }
            }
        }
        if (!eVar.F1().u() && eVar.binding != null) {
            n.e(binding23.g0, "binding.userSkillsList");
            if (eVar.isFullViewVisible(binding23.g0)) {
                eVar.F1().B(z);
            }
        }
    }

    private final void M1() {
        if (!F1().r()) {
            F1().A();
            F1().D();
            app.dogo.com.dogo_android.util.extensionfunction.k1.e(this, DialogTags.LESSON_INTRODUCTION_DIALOG, new Bundle());
        }
    }

    private final void N1(String str) {
        ProgramLessonScreen programLessonScreen = new ProgramLessonScreen(str, autoScrollFeaturesList().d(), autoScrollFeaturesList().getFragmentParentReturnTag(), autoScrollFeaturesList().component1(), autoScrollFeaturesList().b());
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), programLessonScreen);
        M1();
    }

    private final void O1(ProgramSaveInfo programSaveInfo, ProgramLessonItem programLessonItem) {
        getSharedViewModel().d0(programLessonItem.getTrainingSession());
        ProgramLessonsListScreen programLessonsListScreen = new ProgramLessonsListScreen(false, programSaveInfo.getProgramId(), autoScrollFeaturesList().component1(), autoScrollFeaturesList().b(), autoScrollFeaturesList().getFragmentParentReturnTag());
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), programLessonsListScreen);
        ProgramQuestionScreen programQuestionScreen = new ProgramQuestionScreen(programLessonItem.getQuestion(), programSaveInfo, programLessonsListScreen.getTag(), true, programLessonItem.getTrainingSession());
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), programQuestionScreen);
    }

    private final l getSharedViewModel() {
        return (SessionViewModel)this.c.getValue();
    }

    private final boolean isFullViewVisible(View view) {
        Rect rect;
        boolean z = false;
        rect = new Rect();
        if (this.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.b0.getDrawingRect(rect);
            float f3 = view.getY();
            f = (float)view.getHeight() + f3;
            float f4 = (float)rect.top;
            if (rect.top < f3) {
                float f2 = (float)rect.bottom;
                view = rect.bottom > f ? 1 : 0;
            }
            return (rect.bottom > f ? 1 : 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String resultCode2;
        super.onActivityResult(requestCode, resultCode, data);
        int i = 1571571;
        if (requestCode == 1571571 && data == null) {
            N1(resultCode2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        uf ufVar = uf.T(inflater, container, false);
        n.e(ufVar, "inflate(inflater, container, false)");
        this.binding = ufVar;
        int i = 0;
        String str5 = "binding";
        if (ufVar == null) {
            n.w(str5);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            ufVar.W(F1());
            if (this.binding == null) {
                n.w(str5);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.V(autoScrollFeaturesList().c());
                if (this.binding == null) {
                    n.w(str5);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.binding.M(getViewLifecycleOwner());
                    if (this.binding == null) {
                        n.w(str5);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        n.e(binding23.a0, "binding.root");
                        return binding23.a0;
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
        kotlin.b0.d dVar = null;
        kotlinx.coroutines.internal.k.d(r.a(this), null, null, new kotlinx.coroutines.e.c(this, dVar), 3, null);
        String str2 = "binding";
        if (this.binding == null) {
            n.w(str2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) dVar;
        } else {
            binding2.S.setOnClickListener(new kotlinx.coroutines.c(this));
            androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
            n.e(viewLifecycleOwner, "viewLifecycleOwner");
            F1().s().observe(viewLifecycleOwner, new kotlinx.coroutines.a(this));
            if (this.binding == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) dVar;
            } else {
                binding22.b0.getViewTreeObserver().addOnScrollChangedListener(new kotlinx.coroutines.b(this));
                return;
            }
        }
    }

    /* renamed from: G1, reason: from kotlin metadata */
    public static /* synthetic */ void startQuestionFlow(e saveInfo, y item) {
        ProgramOverviewFragment.K1(saveInfo, item);
    }

    public static /* synthetic */ void H1(e eVar) {
        ProgramOverviewFragment.L1(eVar);
    }

    public static /* synthetic */ void I1(e eVar, View view) {
        ProgramOverviewFragment.J1(eVar, view);
    }
}

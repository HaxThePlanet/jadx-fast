package app.dogo.com.dogo_android.y.o;

import android.content.Intent;
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
import app.dogo.com.dogo_android.h.wc;
import app.dogo.com.dogo_android.repository.domain.ExamHistorySaveInfo;
import app.dogo.com.dogo_android.repository.domain.InAppFeedbackExtras;
import app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.y.x.d;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;

/* compiled from: LessonExamHistoryFragment.kt */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J\"\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0016J\u001a\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00192\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010'\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006)", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentExamHistoryBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryScreen;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "goBack", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onLeaveFeedbackPressed", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "onRetakeExamPressed", "onShowExamVideoPressed", "onViewCreated", "view", "recordVideo", "videoPlayback", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: r, reason: from kotlin metadata */
public final class LessonExamHistoryFragment extends Fragment implements q.a {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private wc b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<t> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final t invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(LessonExamHistoryViewModel.class), this.$parameters);
        }

        public a(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<m.a.c.i.a> {
        @Override // kotlin.d0.d.p
        public final m.a.c.i.a invoke() {
            Object[] arr = new Object[3];
            return org.koin.core.parameter.b.b(new Object[] { r.this.goBack().component1(), r.this.goBack().e(), r.this.goBack().d() });
        }

        b() {
            super(0);
        }
    }
    public r() {
        super();
        this.binding = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.r.a(this, null, new kotlinx.coroutines.r.b(this)));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ s onLeaveFeedbackPressed(r item) {
        return item.goBack();
    }

    /* renamed from: C1, reason: from kotlin metadata */
    private final s goBack() {
        return (LessonExamHistoryScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final t D1() {
        return (LessonExamHistoryViewModel)this.binding.getValue();
    }

    private static final void G1(r rVar, View view) {
        n.f(rVar, "this$0");
        rVar.goBack();
    }

    private static final void H1(r rVar, y yVar) {
        int i = 0;
        Exception yVar22;
        n.f(rVar, "this$0");
        i = 0;
        yVar = yVar instanceof LoadResult_Error ? (oadResult_Error)yVar : i;
        if (i == 0) {
        } else {
            yVar22 = i.component1();
        }
        if (yVar22 instanceof NoSuchElementException) {
        }
        if (i != 0) {
            boolean z = false;
            int i2 = 8;
            kotlin.d0.d.g gVar = null;
            LessonExamListScreen lessonExamListScreen = new LessonExamListScreen(rVar.goBack().component1(), rVar.goBack().getFragmentReturnTag(), rVar.goBack().getTag(), z, i2, gVar);
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(rVar.getActivity(), lessonExamListScreen);
        }
    }

    /* renamed from: I1, reason: from kotlin metadata */
    private final void onRetakeExamPressed(ProgramExam item) {
        D1().y(item.getTrickId());
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.s0(activity, D1().n(item), item.getProgramSaveInfo());
        }
    }

    /* renamed from: J1, reason: from kotlin metadata */
    private final void onShowExamVideoPressed(ProgramExam item) {
        androidx.fragment.app.e activity = null;
        Navigator r0 = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : 0;
        if (activity != null) {
            activity.v0(D1().n(item));
        }
    }

    private final void goBack() {
        requireActivity().onBackPressed();
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: i, reason: from kotlin metadata */
    public void recordVideo(ProgramExam item) {
        int i = 1;
        n.f(item, "item");
        int r0 = item.getVideoUrl().length() > 0 ? 1 : 0;
        if (i != 0) {
            onShowExamVideoPressed(item);
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: l1, reason: from kotlin metadata */
    public void videoPlayback(ProgramExam item) {
        n.f(item, "item");
        if (!D1().s()) {
            D1().w();
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new PrepareForExamScreen(item, D1().n(item)));
        } else {
            onRetakeExamPressed(item);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11102 && resultCode == -1) {
            D1().t();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        wc wcVar = wc.T(getLayoutInflater(), container, false);
        n.e(wcVar, "inflate(layoutInflater, container, false)");
        this.b = wcVar;
        int i = 0;
        String str4 = "binding";
        if (wcVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            wcVar.M(getViewLifecycleOwner());
            if (this.b == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.b.W(D1());
                if (this.b == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.b.V(this);
                    D1().t();
                    if (this.b == null) {
                        n.w(str4);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        View view = this.b.w();
                        n.e(view, "binding.root");
                        return view;
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
            wcVar.Q.setNavigationOnClickListener(new kotlinx.coroutines.e(this));
            androidx.fragment.app.e view2 = getActivity();
            if (view2 instanceof Navigator) {
            }
            if (i != 0) {
                i.F();
            }
            D1().getResult().observe(getViewLifecycleOwner(), new kotlinx.coroutines.f(this));
            return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void q1(ProgramExam programExam) {
        boolean z2 = true;
        ExamHistorySaveInfo examHistorySaveInfo = null;
        InAppFeedbackExtras inAppFeedbackExtras;
        String evaluatedByEmail;
        String trickId;
        n.f(programExam, "item");
        D1().x(programExam.getEvaluatedByName());
        evaluatedByEmail = programExam.getExamId();
        evaluatedByEmail = "";
        String r3 = evaluatedByEmail;
        evaluatedByEmail = programExam.getEvaluatedByEmail();
        String r5 = evaluatedByEmail;
        int r1 = programExam.getStatus() == ProgramExam_Status.APPROVED ? 1 : 0;
        inAppFeedbackExtras = new InAppFeedbackExtras(evaluatedByEmail, programExam.getTrickId(), evaluatedByEmail, this.D1().m(), Boolean.valueOf(this.goBack().f()), Boolean.valueOf((programExam.getStatus() == ProgramExam_Status.APPROVED ? 1 : 0)), programExam.getEvaluatedByEmail());
        if (programExam.getExamId() != null) {
            examHistorySaveInfo = new ExamHistorySaveInfo(programExam.getProgramSaveInfo().getDogId(), programExam.getProgramSaveInfo().getProgramId(), programExam.getTrickId(), programExam.getExamId());
        } else {
            int i = 0;
        }
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            trickId = getString(2131886515);
            n.e(trickId, "getString(R.string.exam_NPS_message_header)");
            evaluatedByEmail = getString(2131886514);
            n.e(evaluatedByEmail, "getString(R.string.exam_NPS_message_body)");
            str = "examFeedback01";
            str2 = "Exam feedback";
            app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(activity, new InAppOneTenScreen(new InAppMessageDataHolder(trickId, evaluatedByEmail, str, str2), inAppFeedbackExtras, examHistorySaveInfo));
        }
    }


    /* renamed from: E1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(r view, View savedInstanceState) {
        LessonExamHistoryFragment.G1(view, savedInstanceState);
    }

    public static /* synthetic */ void F1(r rVar, y yVar) {
        LessonExamHistoryFragment.H1(rVar, yVar);
    }
}

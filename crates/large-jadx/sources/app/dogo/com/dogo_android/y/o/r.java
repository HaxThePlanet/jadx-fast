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
import app.dogo.com.dogo_android.inappmessaging.m;
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
import app.dogo.com.dogo_android.y.j;
import app.dogo.com.dogo_android.y.x.d;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J\"\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0016J\u001a\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00192\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010'\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006)", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentExamHistoryBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryScreen;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/examlist/LessonExamHistoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "goBack", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onLeaveFeedbackPressed", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "onRetakeExamPressed", "onShowExamVideoPressed", "onViewCreated", "view", "recordVideo", "videoPlayback", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class r extends Fragment implements app.dogo.com.dogo_android.y.o.q.a {

    private final h a;
    private wc b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.y.o.t> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.y.o.t invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(t.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<a> {

        final app.dogo.com.dogo_android.y.o.r this$0;
        b(app.dogo.com.dogo_android.y.o.r r) {
            this.this$0 = r;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[3];
            return b.b(r.B1(this.this$0).c(), r.B1(this.this$0).e(), r.B1(this.this$0).d());
        }
    }
    static {
    }

    public r() {
        super();
        r.b bVar = new r.b(this);
        r.a aVar = new r.a(this, 0, bVar);
        this.a = j.a(m.SYNCHRONIZED, aVar);
    }

    public static final app.dogo.com.dogo_android.y.o.s B1(app.dogo.com.dogo_android.y.o.r r) {
        return r.C1();
    }

    private final app.dogo.com.dogo_android.y.o.s C1() {
        return (s)k1.a(this);
    }

    private final app.dogo.com.dogo_android.y.o.t D1() {
        return (t)this.a.getValue();
    }

    public static void E1(app.dogo.com.dogo_android.y.o.r r, View view2) {
        r.G1(r, view2);
    }

    public static void F1(app.dogo.com.dogo_android.y.o.r r, y y2) {
        r.H1(r, y2);
    }

    private static final void G1(app.dogo.com.dogo_android.y.o.r r, View view2) {
        n.f(r, "this$0");
        r.goBack();
    }

    private static final void H1(app.dogo.com.dogo_android.y.o.r r, y y2) {
        app.dogo.com.dogo_android.y.o.w wVar;
        int i3;
        String fragmentReturnTag;
        String tag;
        int i;
        int i4;
        int i2;
        app.dogo.com.dogo_android.y.o.w wVar2;
        Object obj8;
        int obj9;
        n.f(r, "this$0");
        i3 = 0;
        if (y2 instanceof y.a) {
        } else {
            obj9 = i3;
        }
        if (obj9 == null) {
            obj9 = i3;
        } else {
            obj9 = obj9.a();
        }
        if (obj9 instanceof NoSuchElementException != null) {
            i3 = obj9;
        }
        if (i3 == 0) {
        } else {
            super(r.C1().c(), r.C1().getFragmentReturnTag(), r.C1().getTag(), 0, 8, 0);
            g1.n(r.getActivity(), wVar2);
        }
    }

    private final void I1(ProgramExam programExam) {
        Object trickId;
        Object obj3;
        D1().y(programExam.getTrickId());
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            g1.s0(activity, D1().n(programExam), programExam.getProgramSaveInfo());
        }
    }

    private final void J1(ProgramExam programExam) {
        androidx.fragment.app.e activity;
        app.dogo.com.dogo_android.y.o.t tVar;
        Object obj3;
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.v0(D1().n(programExam));
        }
    }

    private final void goBack() {
        requireActivity().onBackPressed();
    }

    @Override // androidx.fragment.app.Fragment
    public void i(ProgramExam programExam) {
        int i;
        n.f(programExam, "item");
        i = programExam.getVideoUrl().length() > 0 ? 1 : 0;
        if (i != 0) {
            J1(programExam);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l1(ProgramExam programExam) {
        androidx.fragment.app.e activity;
        d dVar;
        app.dogo.com.dogo_android.model.Exam exam;
        n.f(programExam, "item");
        if (!D1().s()) {
            D1().w();
            dVar = new d(programExam, D1().n(programExam));
            g1.n(getActivity(), dVar);
        } else {
            I1(programExam);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent3) {
        int obj1;
        super.onActivityResult(i, i2, intent3);
        if (i == 11102 && i2 == -1) {
            if (i2 == -1) {
                D1().t();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        wc obj2 = wc.T(getLayoutInflater(), viewGroup2, false);
        n.e(obj2, "inflate(layoutInflater, container, false)");
        this.b = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.M(getViewLifecycleOwner());
            obj2 = this.b;
            if (obj2 == null) {
            } else {
                obj2.W(D1());
                obj2 = this.b;
                if (obj2 == null) {
                } else {
                    obj2.V(this);
                    D1().t();
                    obj2 = this.b;
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
    public void onViewCreated(View view, Bundle bundle2) {
        int obj3;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        wc obj2 = this.b;
        if (obj2 == null) {
        } else {
            e eVar = new e(this);
            obj2.Q.setNavigationOnClickListener(eVar);
            obj2 = getActivity();
            if (obj2 instanceof a0) {
                obj3 = obj2;
            }
            if (obj3 == null) {
            } else {
                obj3.F();
            }
            f fVar = new f(this);
            D1().getResult().observe(getViewLifecycleOwner(), fVar);
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void q1(ProgramExam programExam) {
        int i;
        int examHistorySaveInfo;
        Object dogId;
        String inAppMessageDataHolder;
        String trickId;
        String string;
        String str;
        Object valueOf;
        Object obj11;
        n.f(programExam, "item");
        D1().x(programExam.getEvaluatedByName());
        String examId = programExam.getExamId();
        String str3 = "";
        inAppMessageDataHolder = examId == null ? str3 : examId;
        String evaluatedByEmail = programExam.getEvaluatedByEmail();
        string = evaluatedByEmail == null ? str3 : evaluatedByEmail;
        i = programExam.getStatus() == ProgramExam.Status.APPROVED ? 1 : 0;
        super(inAppMessageDataHolder, programExam.getTrickId(), string, D1().m(), Boolean.valueOf(C1().f()), Boolean.valueOf(i), programExam.getEvaluatedByEmail());
        if (programExam.getExamId() != null) {
            examHistorySaveInfo = new ExamHistorySaveInfo(programExam.getProgramSaveInfo().getDogId(), programExam.getProgramSaveInfo().getProgramId(), programExam.getTrickId(), programExam.getExamId());
        } else {
            examHistorySaveInfo = 0;
        }
        obj11 = getActivity();
        if (obj11 == null) {
        } else {
            trickId = getString(2131886515);
            n.e(trickId, "getString(R.string.exam_NPS_message_header)");
            string = getString(2131886514);
            n.e(string, "getString(R.string.exam_NPS_message_body)");
            inAppMessageDataHolder = new InAppMessageDataHolder(trickId, string, "examFeedback01", "Exam feedback");
            dogId = new m(inAppMessageDataHolder, inAppFeedbackExtras, examHistorySaveInfo);
            g1.X(obj11, dogId);
        }
    }
}

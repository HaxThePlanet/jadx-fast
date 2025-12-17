package app.dogo.com.dogo_android.y.b0;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.yf;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.y.e0.d;
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
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00152\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/questioncorrectanswer/ProgramQuestionCorrectAnswerFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentProgramQuestionCorrectAnswerBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/questioncorrectanswer/ProgramQuestionCorrectAnswerScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/questioncorrectanswer/ProgramQuestionCorrectAnswerScreen;", "viewModel", "Lapp/dogo/com/dogo_android/trainingprogram/questioncorrectanswer/ProgramQuestionCorrectAnswerViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/trainingprogram/questioncorrectanswer/ProgramQuestionCorrectAnswerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "goToNext", "", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends Fragment {

    private yf a;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.y.b0.e> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.y.b0.e invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(e.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<a> {

        final app.dogo.com.dogo_android.y.b0.c this$0;
        b(app.dogo.com.dogo_android.y.b0.c c) {
            this.this$0 = c;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[2];
            return b.b(c.B1(this.this$0).b(), c.B1(this.this$0).c());
        }
    }
    static {
    }

    public c() {
        super();
        c.b bVar = new c.b(this);
        c.a aVar = new c.a(this, 0, bVar);
        this.b = j.a(m.SYNCHRONIZED, aVar);
    }

    public static final app.dogo.com.dogo_android.y.b0.d B1(app.dogo.com.dogo_android.y.b0.c c) {
        return c.C1();
    }

    private final app.dogo.com.dogo_android.y.b0.d C1() {
        return (d)k1.a(this);
    }

    private final app.dogo.com.dogo_android.y.b0.e D1() {
        return (e)this.b.getValue();
    }

    private final void E1() {
        androidx.fragment.app.e activity;
        d dVar;
        app.dogo.com.dogo_android.repository.domain.TrainingSession trainingSession;
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo programSaveInfo;
        String fragmentReturnTag2;
        String fragmentReturnTag;
        if (C1().a()) {
            trainingSession = C1().d();
            n.d(trainingSession);
            dVar = new d(trainingSession, C1().c(), C1().getFragmentReturnTag(), C1().getFragmentReturnTag());
            g1.n(getActivity(), dVar);
        } else {
            activity = getActivity();
            if (activity == null) {
            } else {
                activity.onBackPressed();
            }
        }
    }

    public static void F1(app.dogo.com.dogo_android.y.b0.c c, View view2) {
        c.I1(c, view2);
    }

    public static void G1(app.dogo.com.dogo_android.y.b0.c c, View view2) {
        c.H1(c, view2);
    }

    private static final void H1(app.dogo.com.dogo_android.y.b0.c c, View view2) {
        n.f(c, "this$0");
        c.D1().j();
        c.E1();
    }

    private static final void I1(app.dogo.com.dogo_android.y.b0.c c, View view2) {
        n.f(c, "this$0");
        c.E1();
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
        yf obj2 = yf.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.V(D1());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.M(getViewLifecycleOwner());
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    b bVar = new b(this);
                    obj2.P.setOnClickListener(bVar);
                    obj2 = this.a;
                    if (obj2 == null) {
                    } else {
                        return obj2.w();
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
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        yf obj2 = this.a;
        if (obj2 == null) {
        } else {
            a obj3 = new a(this);
            obj2.U.setNavigationOnClickListener(obj3);
        }
        n.w("binding");
        throw 0;
    }
}

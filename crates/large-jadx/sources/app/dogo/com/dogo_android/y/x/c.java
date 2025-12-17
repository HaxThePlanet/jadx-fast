package app.dogo.com.dogo_android.y.x;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.h.uc;
import app.dogo.com.dogo_android.model.Exam;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000e2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/prepareforexam/PrepareForExamFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentExamExplanationBinding;", "screenKey", "Lapp/dogo/com/dogo_android/trainingprogram/prepareforexam/PrepareForExamScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/trainingprogram/prepareforexam/PrepareForExamScreen;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "recordVideo", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "exam", "Lapp/dogo/com/dogo_android/model/Exam;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends Fragment {

    private uc a;
    private final app.dogo.com.dogo_android.y.x.d B1() {
        return (d)k1.a(this);
    }

    public static void C1(app.dogo.com.dogo_android.y.x.c c, View view2) {
        c.E1(c, view2);
    }

    public static void D1(app.dogo.com.dogo_android.y.x.c c, View view2) {
        c.F1(c, view2);
    }

    private static final void E1(app.dogo.com.dogo_android.y.x.c c, View view2) {
        n.f(c, "this$0");
        androidx.fragment.app.e obj2 = c.getActivity();
        if (obj2 == null) {
        } else {
            obj2.onBackPressed();
        }
        c.G1(c.B1().b(), c.B1().a());
    }

    private static final void F1(app.dogo.com.dogo_android.y.x.c c, View view2) {
        n.f(c, "this$0");
        final androidx.fragment.app.e obj0 = c.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private final void G1(ProgramExam programExam, Exam exam2) {
        app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo obj2;
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            g1.s0(activity, exam2, programExam.getProgramSaveInfo());
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
        int obj4 = 0;
        uc obj2 = uc.T(layoutInflater, viewGroup2, obj4);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        final String str = "binding";
        if (obj2 == null) {
        } else {
            obj2.O.setVisibility(obj4);
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                return obj2.w();
            }
            n.w(str);
            throw obj3;
        }
        n.w(str);
        throw obj3;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        uc obj3 = this.a;
        int obj4 = 0;
        String str2 = "binding";
        if (obj3 == null) {
        } else {
            obj3.M(getViewLifecycleOwner());
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                a aVar = new a(this);
                obj3.P.setOnClickListener(aVar);
                obj3 = this.a;
                if (obj3 == null) {
                } else {
                    obj4 = new b(this);
                    obj3.O.setOnClickListener(obj4);
                }
                n.w(str2);
                throw obj4;
            }
            n.w(str2);
            throw obj4;
        }
        n.w(str2);
        throw obj4;
    }
}

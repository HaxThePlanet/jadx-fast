package app.dogo.com.dogo_android.inappmessaging;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.od;
import app.dogo.com.dogo_android.service.q2.a;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.n;
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
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/inappmessaging/InAppOneTenFragmentDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentInnAppOneTenBinding;", "viewModel", "Lapp/dogo/com/dogo_android/inappmessaging/InAppOneTenViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/inappmessaging/InAppOneTenViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l extends d {

    private od a;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.inappmessaging.n> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.inappmessaging.n invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(n.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<a> {

        final app.dogo.com.dogo_android.inappmessaging.l this$0;
        b(app.dogo.com.dogo_android.inappmessaging.l l) {
            this.this$0 = l;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            app.dogo.com.dogo_android.y.j jVar = k1.a(this.this$0);
            Object[] arr = new Object[3];
            return b.b((m)jVar.c(), jVar.b(), jVar.a());
        }
    }
    static {
    }

    public l() {
        super();
        l.b bVar = new l.b(this);
        l.a aVar = new l.a(this, 0, bVar);
        this.b = j.a(m.SYNCHRONIZED, aVar);
    }

    private final app.dogo.com.dogo_android.inappmessaging.n B1() {
        return (n)this.b.getValue();
    }

    public static void C1(app.dogo.com.dogo_android.inappmessaging.l l, View view2) {
        l.F1(l, view2);
    }

    public static void D1(app.dogo.com.dogo_android.inappmessaging.l l, View view2) {
        l.E1(l, view2);
    }

    private static final void E1(app.dogo.com.dogo_android.inappmessaging.l l, View view2) {
        n.f(l, "this$0");
        l.dismiss();
    }

    private static final void F1(app.dogo.com.dogo_android.inappmessaging.l l, View view2) {
        androidx.fragment.app.e requireActivity;
        app.dogo.com.dogo_android.inappmessaging.j jVar;
        int i;
        int i2;
        app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder inAppMessageDataHolder;
        app.dogo.com.dogo_android.repository.domain.InAppFeedbackExtras inAppFeedbackExtras;
        app.dogo.com.dogo_android.repository.domain.ExamHistorySaveInfo examHistorySaveInfo;
        int obj6;
        n.f(l, "this$0");
        obj6 = l.a;
        if (obj6 == null) {
        } else {
            obj6 = obj6.S.getRating();
            requireActivity = 1;
            jVar = 0;
            if (requireActivity <= obj6 && obj6 <= 5) {
                i2 = obj6 <= 5 ? requireActivity : jVar;
            } else {
            }
            if (i2 != 0) {
                requireActivity = l.requireActivity();
                n.e(requireActivity, "requireActivity()");
                jVar = new j(obj6, (m)k1.a(l).c(), (m)k1.a(l).b(), (m)k1.a(l).a());
                g1.X(requireActivity, jVar);
                l.dismiss();
            } else {
                if (6 <= obj6 && obj6 <= 10) {
                    if (obj6 <= 10) {
                    } else {
                        requireActivity = jVar;
                    }
                } else {
                }
                l.B1().j(obj6);
                Toast.makeText(l.requireActivity().getApplicationContext(), 2131886767, jVar).show();
                if (requireActivity != null && l.B1().i()) {
                    l.B1().j(obj6);
                    Toast.makeText(l.requireActivity().getApplicationContext(), 2131886767, jVar).show();
                    if (l.B1().i()) {
                        obj6 = l.getActivity();
                        if (obj6 == null) {
                        } else {
                            requireActivity = new n(q2.a.USER_SCORE_RATE.getTag());
                            g1.X(obj6, requireActivity);
                        }
                    }
                    l.dismiss();
                }
            }
        }
        n.w("binding");
        throw 0;
    }

    @Override // androidx.fragment.app.d
    public int getTheme() {
        return 2131952268;
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        od obj2 = od.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.V(B1());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.M(getViewLifecycleOwner());
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

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        od obj3 = this.a;
        int obj4 = 0;
        String str2 = "binding";
        if (obj3 == null) {
        } else {
            h hVar = new h(this);
            obj3.R.setOnClickListener(hVar);
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                obj4 = new g(this);
                obj3.T.setOnClickListener(obj4);
            }
            n.w(str2);
            throw obj4;
        }
        n.w(str2);
        throw obj4;
    }
}

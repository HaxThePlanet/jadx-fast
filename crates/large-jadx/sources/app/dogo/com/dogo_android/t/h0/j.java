package app.dogo.com.dogo_android.t.h0;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.m9;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import com.google.android.play.core.splitinstall.a;
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
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00112\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0008\u0010\u001f\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/settings/language/LanguageSelectDialog;", "Landroidx/fragment/app/DialogFragment;", "Lapp/dogo/com/dogo_android/settings/language/LanguageSelectAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogLanguageSelectBinding;", "screenKey", "Lapp/dogo/com/dogo_android/settings/language/LanguageSelectScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/settings/language/LanguageSelectScreen;", "viewModel", "Lapp/dogo/com/dogo_android/settings/language/LanguageSelectViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/settings/language/LanguageSelectViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "", "onLanguageSelected", "language", "", "onViewCreated", "view", "setupObserver", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j extends d implements app.dogo.com.dogo_android.t.h0.i.a {

    private m9 a;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.t.h0.l> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.t.h0.l invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(l.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<a> {

        final app.dogo.com.dogo_android.t.h0.j this$0;
        b(app.dogo.com.dogo_android.t.h0.j j) {
            this.this$0 = j;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b(Boolean.valueOf(j.B1(this.this$0).a()));
        }
    }
    static {
    }

    public j() {
        super();
        j.b bVar = new j.b(this);
        j.a aVar = new j.a(this, 0, bVar);
        this.b = j.a(m.SYNCHRONIZED, aVar);
    }

    public static final app.dogo.com.dogo_android.t.h0.k B1(app.dogo.com.dogo_android.t.h0.j j) {
        return j.C1();
    }

    private final app.dogo.com.dogo_android.t.h0.k C1() {
        return (k)k1.a(this);
    }

    private final app.dogo.com.dogo_android.t.h0.l D1() {
        return (l)this.b.getValue();
    }

    public static void E1(app.dogo.com.dogo_android.t.h0.j j, y y2) {
        j.I1(j, y2);
    }

    public static void F1(app.dogo.com.dogo_android.t.h0.j j, View view2) {
        j.G1(j, view2);
    }

    private static final void G1(app.dogo.com.dogo_android.t.h0.j j, View view2) {
        n.f(j, "this$0");
        j.D1().D();
    }

    private final void H1() {
        b bVar = new b(this);
        D1().s().observe(getViewLifecycleOwner(), bVar);
    }

    private static final void I1(app.dogo.com.dogo_android.t.h0.j j, y y2) {
        com.google.android.play.core.splitinstall.d dVar;
        androidx.fragment.app.e requireActivity;
        int i;
        Object obj3;
        Object obj4;
        n.f(j, "this$0");
        if (y2 instanceof y.a) {
            j.D1().o();
            if (exc instanceof ConnectException != null) {
                obj3 = j.getActivity();
                if (obj3 == null) {
                } else {
                    g1.g0(obj3, 2131886953);
                }
            } else {
                obj3 = j.getActivity();
                if (obj3 == null) {
                } else {
                    g1.g0(obj3, 2131886123);
                }
            }
            a.d(y2.a());
        } else {
            dVar = y2 instanceof y.c;
            if (dVar) {
                j.D1().o();
                if (dVar) {
                } else {
                    obj4 = i;
                }
                if (obj4 == null) {
                } else {
                    i = obj4;
                }
                if (i instanceof h) {
                    j.D1().t().a((h)i.a(), j.requireActivity(), 10100);
                } else {
                    if (i instanceof m && (m)i.a().length() > 0) {
                        if ((m)i.a().length() > 0) {
                            requireActivity = 1;
                        }
                        if (requireActivity != null) {
                            App.Companion.y(i.a());
                        }
                    }
                }
                j.dismiss();
            } else {
                a.a("Unsupported command", new Object[0]);
            }
        }
    }

    @Override // androidx.fragment.app.d
    public void P(String string) {
        n.f(string, "language");
        D1().C(string);
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        Object obj4;
        n.f(layoutInflater, "inflater");
        obj4 = getDialog();
        if (obj4 == null) {
        } else {
            obj4 = obj4.getWindow();
            if (obj4 == null) {
            } else {
                f1.H(obj4);
            }
        }
        m9 obj2 = m9.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(D1());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.M(getViewLifecycleOwner());
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.V(this);
                    obj2 = this.a;
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

    @Override // androidx.fragment.app.d
    public void onDestroy() {
        super.onDestroy();
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            activity.recreate();
        }
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        m9 obj2 = this.a;
        if (obj2 == null) {
        } else {
            c obj3 = new c(this);
            obj2.P.setOnClickListener(obj3);
            H1();
        }
        n.w("binding");
        throw 0;
    }
}

package app.dogo.com.dogo_android.u.n.p.m;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.w8;
import app.dogo.com.dogo_android.repository.domain.DogLog;
import app.dogo.com.dogo_android.u.n.p.l.h;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
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
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectDialog;", "Landroidx/fragment/app/DialogFragment;", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectAdapter$DogLogSelectCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogDogLogSelectBinding;", "screenKey", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectScreen;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logselect/DogLogSelectViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "", "dogLog", "Lapp/dogo/com/dogo_android/repository/domain/DogLog;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends d implements app.dogo.com.dogo_android.u.n.p.m.b.a {

    private w8 a;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.u.n.p.m.e> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.u.n.p.m.e invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(e.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<a> {

        final app.dogo.com.dogo_android.u.n.p.m.c this$0;
        b(app.dogo.com.dogo_android.u.n.p.m.c c) {
            this.this$0 = c;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b(c.B1(this.this$0).a());
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

    public static final app.dogo.com.dogo_android.u.n.p.m.d B1(app.dogo.com.dogo_android.u.n.p.m.c c) {
        return c.C1();
    }

    private final app.dogo.com.dogo_android.u.n.p.m.d C1() {
        return (d)k1.a(this);
    }

    private final app.dogo.com.dogo_android.u.n.p.m.e D1() {
        return (e)this.b.getValue();
    }

    @Override // androidx.fragment.app.d
    public int getTheme() {
        return 2131951980;
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
        w8 obj2 = w8.T(layoutInflater, viewGroup2, false);
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
                obj2.V(this);
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.M(getViewLifecycleOwner());
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
    public void s0(DogLog dogLog) {
        h hVar;
        long str;
        Long valueOf;
        app.dogo.com.dogo_android.k.e type;
        String logId;
        int i;
        int i3;
        int i2;
        Object obj10;
        n.f(dogLog, "dogLog");
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            super("calendar", Long.valueOf(dogLog.getEventTimeMs()), dogLog.getType(), dogLog.getLogId(), 0, 16, 0);
            g1.n(activity, obj10);
        }
        dismissAllowingStateLoss();
    }
}

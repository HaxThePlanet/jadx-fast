package app.dogo.com.dogo_android.u.m;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.ih;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.m0.b;
import app.dogo.com.dogo_android.view.dailytraining.l;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.q;
import kotlin.d0.d.c0;
import kotlin.d0.d.k;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.i.a;
import m.a.c.i.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\u000b\u001a\u00020\u000c8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000f\u0010\n\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/VariationTipsFragment;", "Lapp/dogo/com/dogo_android/util/navigation/BaseFragment;", "Lapp/dogo/com/dogo_android/databinding/FragmentVariationTipsScreenBinding;", "Lapp/dogo/com/dogo_android/specialprograms/biting/VariationTipsScreen;", "()V", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/specialprograms/biting/VariationTipsViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/specialprograms/biting/VariationTipsViewModel;", "viewModel$delegate", "onAttach", "", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class r extends b<ih, app.dogo.com.dogo_android.u.m.s> {

    private final h v;
    private final h w;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public b(Fragment fragment, a a2, a a3) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(l.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements a<app.dogo.com.dogo_android.u.m.t> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public c(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.u.m.t invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(t.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<a> {

        final app.dogo.com.dogo_android.u.m.r this$0;
        d(app.dogo.com.dogo_android.u.m.r r) {
            this.this$0 = r;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[2];
            int i2 = 0;
            arr[i2] = (s)this.this$0.C1().b();
            arr[1] = Long.valueOf((s)this.this$0.C1().a());
            return b.b(arr);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    class a extends k implements q<LayoutInflater, ViewGroup, Boolean, ih> {

        public static final app.dogo.com.dogo_android.u.m.r.a a;
        static {
            r.a aVar = new r.a();
            r.a.a = aVar;
        }

        a() {
            super(3, ih.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lapp/dogo/com/dogo_android/databinding/FragmentVariationTipsScreenBinding;", 0);
        }

        @Override // kotlin.d0.d.k
        public Object invoke(Object object, Object object2, Object object3) {
            return l((LayoutInflater)object, (ViewGroup)object2, (Boolean)object3.booleanValue());
        }

        @Override // kotlin.d0.d.k
        public final ih l(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
            n.f(layoutInflater, "p0");
            return ih.T(layoutInflater, viewGroup2, z3);
        }
    }
    static {
    }

    public r() {
        super(r.a.a);
        final int i = 0;
        r.b bVar = new r.b(this, i, i);
        this.v = j.a(m.NONE, bVar);
        r.d dVar = new r.d(this);
        r.c cVar = new r.c(this, i, dVar);
        this.w = j.a(m.SYNCHRONIZED, cVar);
    }

    public static void H1(app.dogo.com.dogo_android.u.m.r r, View view2) {
        r.J1(r, view2);
    }

    public static void I1(app.dogo.com.dogo_android.u.m.r r, View view2) {
        r.K1(r, view2);
    }

    private static final void J1(app.dogo.com.dogo_android.u.m.r r, View view2) {
        n.f(r, "this$0");
        final androidx.fragment.app.e obj0 = r.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void K1(app.dogo.com.dogo_android.u.m.r r, View view2) {
        n.f(r, "this$0");
        final androidx.fragment.app.e obj0 = r.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public s D1() {
        return getSharedViewModel();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public s E1() {
        return G1();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public app.dogo.com.dogo_android.u.m.t G1() {
        return (t)this.w.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
    public l getSharedViewModel() {
        return (l)this.v.getValue();
    }

    @Override // app.dogo.com.dogo_android.util.m0.b
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

    @Override // app.dogo.com.dogo_android.util.m0.b
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        g obj3 = new g(this);
        obj2.S.setNavigationOnClickListener(obj3);
        obj3 = new h(this);
        obj2.R.setOnClickListener(obj3);
    }
}

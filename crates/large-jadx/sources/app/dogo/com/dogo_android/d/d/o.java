package app.dogo.com.dogo_android.d.d;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.cn;
import app.dogo.com.dogo_android.h.o8;
import app.dogo.com.dogo_android.k.j;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.w;
import app.dogo.com.dogo_android.util.e0.x;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.e0.z;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.k0.g;
import app.dogo.com.dogo_android.util.n0.e;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import com.google.android.gms.tasks.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import kotlin.y.p;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010 0\u001fH\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0008\u0010)\u001a\u00020*H\u0016J\u0008\u0010+\u001a\u00020*H\u0016J\u0008\u0010,\u001a\u00020*H\u0016J\u001a\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\"2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\u001bH\u0002J\u0008\u00101\u001a\u00020*H\u0002J\u0008\u00102\u001a\u00020*H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0015\u0010\u000e\u001a\u0004\u0008\u0013\u0010\u0014¨\u00063", d2 = {"Lapp/dogo/com/dogo_android/challenge/profile/ChallengeProfileDialog;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyFullScreenFragment;", "()V", "adapter", "Lapp/dogo/com/dogo_android/challenge/profile/ChallengeProfileListAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogChallengeProfileBinding;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "toolBarManager", "Lapp/dogo/com/dogo_android/util/interfaces/TopBarManager;", "vm", "Lapp/dogo/com/dogo_android/challenge/profile/ChallengeProfileDialogViewModel;", "getVm", "()Lapp/dogo/com/dogo_android/challenge/profile/ChallengeProfileDialogViewModel;", "vm$delegate", "getFragmentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "getScreenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getTitle", "", "getTopBarBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutTopBarBinding;", "getViewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "", "onResume", "onStop", "onViewCreated", "view", "reportUser", "toastMessage", "setupObservers", "setupRecyclerView", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class o extends x {

    private o8 A;
    private app.dogo.com.dogo_android.d.d.q B;
    private LinearLayoutManager C;
    private g D;
    private final h y;
    private final h z;

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements a<w> {

        final app.dogo.com.dogo_android.d.d.o this$0;
        a(app.dogo.com.dogo_android.d.d.o o) {
            this.this$0 = o;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            o.c2(this.this$0).Q();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.d.d.o this$0;
        b(app.dogo.com.dogo_android.d.d.o o) {
            this.this$0 = o;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            androidx.fragment.app.e activity = this.this$0.getActivity();
            if (activity == null) {
            } else {
                activity.onBackPressed();
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public c(Fragment fragment, a a2, a a3) {
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
    public static final class d extends p implements a<app.dogo.com.dogo_android.d.d.p> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public d(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.d.d.p invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(p.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0003H\u0016J\u0008\u0010\u0005\u001a\u00020\u0006H\u0016J\u0008\u0010\u0007\u001a\u00020\u0006H\u0016J\u0008\u0010\u0008\u001a\u00020\u0006H\u0016J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0008\u0010\u000b\u001a\u00020\nH\u0016J\u0008\u0010\u000c\u001a\u00020\nH\u0016¨\u0006\r", d2 = {"app/dogo/com/dogo_android/challenge/profile/ChallengeProfileDialog$toolBarManager$1", "Lapp/dogo/com/dogo_android/util/interfaces/TopBarManager;", "getActionName", "", "getTitle", "isBackVisible", "", "isBlockVisible", "isFlagVisible", "onAction", "", "onBack", "onBlockAction", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e extends g {

        final app.dogo.com.dogo_android.d.d.o a;
        e(app.dogo.com.dogo_android.d.d.o o) {
            this.a = o;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public String getActionName() {
            return " ";
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public String getTitle() {
            return this.a.I1();
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean isBackVisible() {
            return 1;
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean isBlockVisible() {
            return 1;
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean isFlagVisible() {
            return 1;
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public void onAction() {
            boolean activity;
            app.dogo.com.dogo_android.d.d.o.e.a aVar;
            app.dogo.com.dogo_android.d.d.o oVar;
            if (o.c2(this.a).D()) {
                activity = this.a.getActivity();
                if (activity == null) {
                } else {
                    aVar = new o.e.a(this.a);
                    f1.t0(activity, aVar);
                }
            }
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public void onBack() {
            a0 a0Var = this.a.G1();
            n.d(a0Var);
            a0Var.onBackPressed();
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public void onBlockAction() {
            boolean activity;
            app.dogo.com.dogo_android.d.d.o.e.b bVar;
            app.dogo.com.dogo_android.d.d.o oVar;
            if (o.c2(this.a).D()) {
                activity = this.a.getActivity();
                if (activity == null) {
                } else {
                    bVar = new o.e.b(this.a);
                    f1.r0(activity, bVar);
                }
            }
        }
    }
    static {
    }

    public o() {
        super();
        final int i = 0;
        o.c cVar = new o.c(this, i, i);
        this.y = j.a(m.NONE, cVar);
        o.d dVar = new o.d(this, i, i);
        this.z = j.a(m.SYNCHRONIZED, dVar);
        o.e eVar = new o.e(this);
        this.D = eVar;
    }

    public static final app.dogo.com.dogo_android.d.d.p c2(app.dogo.com.dogo_android.d.d.o o) {
        return o.e2();
    }

    public static final void d2(app.dogo.com.dogo_android.d.d.o o, String string2) {
        o.l2(string2);
    }

    private final app.dogo.com.dogo_android.d.d.p e2() {
        return (p)this.z.getValue();
    }

    public static void f2(app.dogo.com.dogo_android.d.d.o o, y y2) {
        o.o2(o, y2);
    }

    public static void g2(app.dogo.com.dogo_android.d.d.o o, List list2) {
        o.k2(o, list2);
    }

    private final l getSharedViewModel() {
        return (l)this.y.getValue();
    }

    public static void h2(app.dogo.com.dogo_android.d.d.o o, y y2) {
        o.j2(o, y2);
    }

    public static void i2(app.dogo.com.dogo_android.d.d.o o, Map map2) {
        o.n2(o, map2);
    }

    private static final void j2(app.dogo.com.dogo_android.d.d.o o, y y2) {
        boolean aVar;
        app.dogo.com.dogo_android.d.d.o.b bVar;
        String str;
        Object obj3;
        Object obj4;
        n.f(o, "this$0");
        if (y2 instanceof y.c) {
            o.e2().V((LiteDogProfile)(y.c)y2.a());
            o.setupRecyclerView();
            o.m2();
            o.x.notifyPropertyChanged(160);
            if (o.e2().F()) {
                aVar = new b(o);
                o.e2().s().addOnSuccessListener(aVar);
            } else {
                obj4 = o.B;
                if (obj4 == null) {
                } else {
                    obj4.g2(o.e2().x());
                }
            }
        } else {
            if (y2 instanceof y.a) {
                Exception exception = new Exception((y.a)y2.a());
                obj4 = o.requireContext();
                n.e(obj4, "requireContext()");
                aVar = new o.a(o);
                bVar = new o.b(o);
                f1.m0(o, n.a.i(exception, obj4), aVar, bVar);
            }
        }
    }

    private static final void k2(app.dogo.com.dogo_android.d.d.o o, List list2) {
        n.f(o, "this$0");
        final app.dogo.com.dogo_android.d.d.q obj1 = o.B;
        n.d(obj1);
        n.d(list2);
        obj1.Z(0, list2);
    }

    private final void l2(String string) {
        boolean obj2;
        e2().R();
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            g1.i0(activity, string);
        }
        if (!e2().C()) {
            obj2 = G1();
            if (obj2 == null) {
            } else {
                obj2.onBackPressed();
            }
        }
    }

    private final void m2() {
        d dVar = new d(this);
        e2().B().observe(getViewLifecycleOwner(), dVar);
        a aVar = new a(this);
        getSharedViewModel().E().observe(getViewLifecycleOwner(), aVar);
    }

    private static final void n2(app.dogo.com.dogo_android.d.d.o o, Map map2) {
        n.f(o, "this$0");
        n.f(map2, "userEntryIdsForChallenges");
        final app.dogo.com.dogo_android.d.d.q obj1 = o.B;
        n.d(obj1);
        HashMap hashMap = new HashMap(map2);
        obj1.B2(hashMap);
    }

    private static final void o2(app.dogo.com.dogo_android.d.d.o o, y y2) {
        Object obj1;
        int obj2;
        n.f(o, "this$0");
        n.e(y2, "it");
        if (obj2 instanceof DogProfile != null) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            obj1 = o.B;
            if (obj1 == null) {
            } else {
                obj1.notifyDataSetChanged();
            }
        }
    }

    private final void setupRecyclerView() {
        Object adapter;
        android.content.Context context;
        app.dogo.com.dogo_android.util.k0.f fVar;
        a0 a0Var;
        q qVar;
        o8 o8Var = this.A;
        if (o8Var == null) {
        } else {
            RecyclerView view = o8Var.O;
            n.e(view, "binding.list");
            if (view.getAdapter() == null) {
                a0Var = G1();
                n.d(a0Var);
                n.e(a0Var, "navigator!!");
                q qVar2 = new q(p.g(), F1(), a0Var, D1());
                this.B = qVar2;
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                this.C = linearLayoutManager;
                view.setAdapter(this.B);
                view.setLayoutManager(this.C);
            }
        }
        n.w("binding");
        throw 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public q D1() {
        return j.CHALLENGE_PROFILE_DETAILS_DIALOG_FRAGMENT;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public k3 H1() {
        return j3.L;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public String I1() {
        return e2().A();
    }

    public Class<? extends r> K1() {
        return r.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public cn b2() {
        return null;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        Object obj3;
        n.f(layoutInflater, "inflater");
        o8 obj2 = o8.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.A = obj2;
        obj2 = getArguments();
        if (obj2 == null) {
        } else {
            e2().S(obj2);
        }
        e2().u();
        obj2 = this.A;
        obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.P.U(this.D);
            obj2 = this.A;
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

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onPause() {
        super.onPause();
        e2().k();
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onResume() {
        boolean z;
        super.onResume();
        e2().i();
        if (e2().E()) {
            z = G1();
            if (z == null) {
            } else {
                z.onBackPressed();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onStop() {
        int i;
        super.onStop();
        LinearLayoutManager linearLayoutManager = this.C;
        if (linearLayoutManager == null) {
            i = 0;
        } else {
            i = linearLayoutManager.y2();
        }
        e2().T(i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        c cVar = new c(this);
        e2().y().observe(getViewLifecycleOwner(), cVar);
    }
}

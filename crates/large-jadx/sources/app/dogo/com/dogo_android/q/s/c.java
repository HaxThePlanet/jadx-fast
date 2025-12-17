package app.dogo.com.dogo_android.q.s;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
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
import androidx.lifecycle.y;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import app.dogo.com.dogo_android.h.y8;
import app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.f0.n;
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
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0008\u0010\u001e\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsDialog;", "Landroidx/fragment/app/DialogFragment;", "Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter$DogParentsCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogDogParentsBinding;", "screenKey", "Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsScreen;", "viewModel", "Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDelete", "", "dogParent", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "onResume", "sendInvite", "shortDynamicLink", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends d implements app.dogo.com.dogo_android.q.s.b.b {

    private final h a;
    private y8 b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a implements y<T> {

        final app.dogo.com.dogo_android.q.s.c a;
        public a(app.dogo.com.dogo_android.q.s.c c) {
            this.a = c;
            super();
        }

        public final void onChanged(T t) {
            n.e((String)t, "shortDynamicLink");
            c.B1(this.a, t);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class b implements y<T> {

        final app.dogo.com.dogo_android.q.s.c a;
        public b(app.dogo.com.dogo_android.q.s.c c) {
            this.a = c;
            super();
        }

        public final void onChanged(T t) {
            n nVar;
            Exception exception;
            String str;
            Object obj5;
            a.d((Throwable)t);
            androidx.fragment.app.e activity = this.a.getActivity();
            if (activity == null) {
            } else {
                exception = new Exception(t);
                obj5 = this.a.requireContext();
                n.e(obj5, "requireContext()");
                g1.i0(activity, n.a.i(exception, obj5));
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements a<app.dogo.com.dogo_android.q.s.f> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public c(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.q.s.f invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(f.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<a> {

        final app.dogo.com.dogo_android.q.s.c this$0;
        d(app.dogo.com.dogo_android.q.s.c c) {
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
            return b.b(this.this$0.C1().a());
        }
    }
    static {
    }

    public c() {
        super();
        c.d dVar = new c.d(this);
        c.c cVar = new c.c(this, 0, dVar);
        this.a = j.a(m.SYNCHRONIZED, cVar);
    }

    public static final void B1(app.dogo.com.dogo_android.q.s.c c, String string2) {
        c.G1(string2);
    }

    private final app.dogo.com.dogo_android.q.s.f D1() {
        return (f)this.a.getValue();
    }

    public static void E1(app.dogo.com.dogo_android.q.s.c c, View view2) {
        c.F1(c, view2);
    }

    private static final void F1(app.dogo.com.dogo_android.q.s.c c, View view2) {
        n.f(c, "this$0");
        c.dismiss();
    }

    private final void G1(String string) {
        Intent chooser;
        String string2;
        Object[] arr;
        StringBuilder stringBuilder = new StringBuilder();
        arr = new Object[1];
        stringBuilder.append(getResources().getString(2131886792, C1().a().getName()));
        stringBuilder.append(' ');
        stringBuilder.append(string);
        chooser = new Intent("android.intent.action.SEND");
        chooser.setType("text/plain");
        chooser.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
        androidx.fragment.app.e obj6 = getActivity();
        if (obj6 == null) {
        } else {
            obj6.startActivity(Intent.createChooser(chooser, getResources().getString(2131887124)));
        }
    }

    @Override // androidx.fragment.app.d
    public final app.dogo.com.dogo_android.q.s.d C1() {
        return (d)k1.a(this);
    }

    @Override // androidx.fragment.app.d
    public int getTheme() {
        return 2131951980;
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        Object obj6;
        n.f(layoutInflater, "inflater");
        obj6 = getDialog();
        if (obj6 == null) {
        } else {
            obj6 = obj6.getWindow();
            if (obj6 == null) {
            } else {
                f1.H(obj6);
            }
        }
        obj6 = 0;
        y8 obj4 = y8.T(layoutInflater, viewGroup2, obj6);
        n.e(obj4, "inflate(inflater, container, false)");
        this.b = obj4;
        int obj5 = 0;
        final String str = "binding";
        if (obj4 == null) {
        } else {
            obj4.W(D1());
            obj4 = this.b;
            if (obj4 == null) {
            } else {
                obj4.V(this);
                obj4 = this.b;
                if (obj4 == null) {
                } else {
                    obj4.M(getViewLifecycleOwner());
                    obj4 = this.b;
                    if (obj4 == null) {
                    } else {
                        obj4.R.setEnabled(obj6);
                        obj4 = this.b;
                        if (obj4 == null) {
                        } else {
                            obj6 = new a(this);
                            obj4.P.setOnClickListener(obj6);
                            obj6 = getViewLifecycleOwner();
                            String str2 = "viewLifecycleOwner";
                            n.e(obj6, str2);
                            c.a aVar = new c.a(this);
                            D1().m().observe(obj6, aVar);
                            obj6 = getViewLifecycleOwner();
                            n.e(obj6, str2);
                            c.b bVar = new c.b(this);
                            D1().k().observe(obj6, bVar);
                            obj4 = this.b;
                            if (obj4 == null) {
                            } else {
                                obj4 = obj4.w();
                                n.e(obj4, "binding.root");
                                return obj4;
                            }
                            n.w(str);
                            throw obj5;
                        }
                        n.w(str);
                        throw obj5;
                    }
                    n.w(str);
                    throw obj5;
                }
                n.w(str);
                throw obj5;
            }
            n.w(str);
            throw obj5;
        }
        n.w(str);
        throw obj5;
    }

    @Override // androidx.fragment.app.d
    public void onResume() {
        super.onResume();
        D1().n();
    }

    @Override // androidx.fragment.app.d
    public void t(DogParentUIState.DogParent dogParentUIState$DogParent) {
        n.f(dogParent, "dogParent");
        D1().i(dogParent.getId());
    }
}

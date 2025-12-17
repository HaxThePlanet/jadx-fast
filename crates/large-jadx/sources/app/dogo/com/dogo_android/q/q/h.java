package app.dogo.com.dogo_android.q.q;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.app.h;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.h.a9;
import app.dogo.com.dogo_android.k.i;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.dailytraining.l;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.b;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
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
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+H\u0016J\u0008\u0010,\u001a\u00020\u0018H\u0016J\u001a\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\"2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010/\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u00060", d2 = {"Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter$DogSelectCallback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogDogSelectBinding;", "screenKey", "Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectViewModel;", "viewModel$delegate", "getTheme", "", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAddDogClick", "userPremium", "", "onAddNewDogClick", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "dogId", "", "onResume", "onViewCreated", "view", "saveSelectionAndDismiss", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h extends b implements app.dogo.com.dogo_android.q.q.f.a {

    private a9 b;
    private final h c;
    private final h v;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public a(Fragment fragment, a a2, a a3) {
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
    public static final class b extends p implements a<app.dogo.com.dogo_android.q.q.j> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.q.q.j invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(j.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements a<a> {

        final app.dogo.com.dogo_android.q.q.h this$0;
        c(app.dogo.com.dogo_android.q.q.h h) {
            this.this$0 = h;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }

        @Override // kotlin.d0.d.p
        public final a invoke() {
            Object[] arr = new Object[1];
            return b.b(h.F1(this.this$0).getSource());
        }
    }
    static {
    }

    public h() {
        super();
        final int i = 0;
        h.a aVar = new h.a(this, i, i);
        this.c = j.a(m.NONE, aVar);
        h.c cVar = new h.c(this);
        h.b bVar = new h.b(this, i, cVar);
        this.v = j.a(m.SYNCHRONIZED, bVar);
    }

    public static final app.dogo.com.dogo_android.q.q.i F1(app.dogo.com.dogo_android.q.q.h h) {
        return h.G1();
    }

    private final app.dogo.com.dogo_android.q.q.i G1() {
        return (i)k1.a(this);
    }

    private final app.dogo.com.dogo_android.q.q.j H1() {
        return (j)this.v.getValue();
    }

    public static void I1(app.dogo.com.dogo_android.q.q.h h, String string2) {
        h.M1(h, string2);
    }

    public static void J1(app.dogo.com.dogo_android.q.q.h h, View view2) {
        h.N1(h, view2);
    }

    public static void K1(DialogInterface dialogInterface) {
        h.O1(dialogInterface);
    }

    private final void L1(boolean z) {
        int i5;
        int i6;
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        int obj8;
        H1().p();
        i5 = 0;
        if (z) {
            if (obj8 instanceof a0) {
            } else {
                obj8 = i5;
            }
            if (obj8 == null) {
            } else {
                obj8.x0(H1().k(), 11101, G1().b(), i5);
            }
        } else {
            obj8 = getActivity();
            if (obj8 instanceof a0) {
                i5 = obj8;
            }
            i6 = i5;
            if (i6 == 0) {
            } else {
                a0.F0(i6, "dog_profile", 0, 0, 6, 0);
            }
        }
    }

    private static final void M1(app.dogo.com.dogo_android.q.q.h h, String string2) {
        n.f(h, "this$0");
        n.e(string2, "dogId");
        h.P1(string2);
    }

    private static final void N1(app.dogo.com.dogo_android.q.q.h h, View view2) {
        n.f(h, "this$0");
        h.dismiss();
    }

    private static final void O1(DialogInterface dialogInterface) {
        Objects.requireNonNull(dialogInterface, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        View obj3 = (a)dialogInterface.findViewById(2131362302);
        n.d((FrameLayout)obj3);
        ViewParent parent = obj3.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout");
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.y(obj3);
        n.e(bottomSheetBehavior, "from<FrameLayout?>(bottomSheet)");
        bottomSheetBehavior.V(obj3.getHeight());
        (CoordinatorLayout)parent.getParent().requestLayout();
    }

    private final void P1(String string) {
        boolean z;
        e supportFragmentManager;
        String str;
        String tag;
        if (n.b(G1().a(), "challenge_image_dog_select_request")) {
            supportFragmentManager = getActivity();
            if (supportFragmentManager == null) {
                z = str;
            } else {
            }
            if (z instanceof g) {
                str = z;
            }
            if (str == null) {
            } else {
                str.U(string);
            }
        }
        getSharedViewModel().s(string, G1().getSource());
        dismiss();
    }

    private final l getSharedViewModel() {
        return (l)this.c.getValue();
    }

    @Override // com.google.android.material.bottomsheet.b
    public void J0(String string) {
        n.f(string, "dogId");
        H1().q();
        H1().n(string);
    }

    @Override // com.google.android.material.bottomsheet.b
    public void U0(boolean z) {
        L1(z);
    }

    @Override // com.google.android.material.bottomsheet.b
    public int getTheme() {
        return 2131951984;
    }

    @Override // com.google.android.material.bottomsheet.b
    public void onActivityResult(int i, int i2, Intent intent3) {
        int obj1;
        String obj2;
        super.onActivityResult(i, i2, intent3);
        if (intent3 == null) {
            obj2 = 0;
        } else {
            obj2 = intent3.getStringExtra("newDogId");
        }
        if (i == 11101 && obj2 != null && !isDetached()) {
            if (obj2 != null) {
                if (!isDetached()) {
                    P1(obj2);
                }
            }
        }
    }

    @Override // com.google.android.material.bottomsheet.b
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        a9 obj2 = a9.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.b = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(H1());
            obj2 = this.b;
            if (obj2 == null) {
            } else {
                obj2.V(this);
                obj2 = this.b;
                if (obj2 == null) {
                } else {
                    obj2.M(getViewLifecycleOwner());
                    obj2 = this.b;
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

    @Override // com.google.android.material.bottomsheet.b
    public void onResume() {
        super.onResume();
        H1().m();
    }

    @Override // com.google.android.material.bottomsheet.b
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        b bVar = new b(this);
        H1().i().observe(getViewLifecycleOwner(), bVar);
        a9 obj2 = this.b;
        if (obj2 == null) {
        } else {
            c obj3 = new c(this);
            obj2.P.setOnClickListener(obj3);
            obj2 = getDialog();
            n.d(obj2);
            obj2.setOnShowListener(d.a);
        }
        n.w("binding");
        throw 0;
    }
}

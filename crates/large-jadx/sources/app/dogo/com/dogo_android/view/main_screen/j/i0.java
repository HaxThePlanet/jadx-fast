package app.dogo.com.dogo_android.view.main_screen.j;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.a0.g.f.e0;
import app.dogo.com.dogo_android.h.cn;
import app.dogo.com.dogo_android.h.i8;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.k.h;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.u;
import app.dogo.com.dogo_android.util.exceptions.ExceptionForTaskChain;
import app.dogo.com.dogo_android.util.k0.g;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import com.google.android.gms.tasks.j;
import com.theartofdev.edmodo.cropper.CropImageView.b;
import com.theartofdev.edmodo.cropper.d;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.y.q0;
import m.a.b.a.d.a.b;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u001f\u001a\u00020\u0013H\u0002J\u0008\u0010 \u001a\u00020\u0016H\u0016J\"\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0008\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*H\u0016J$\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0008\u0010/\u001a\u0004\u0018\u0001002\u0008\u00101\u001a\u0004\u0018\u000102H\u0016J\u001c\u00103\u001a\u00020\"2\u0008\u00104\u001a\u0004\u0018\u00010\u000b2\u0008\u00105\u001a\u0004\u0018\u000102H\u0014J\u0012\u00106\u001a\u00020\"2\u0008\u00107\u001a\u0004\u0018\u000108H\u0002J\u0008\u00109\u001a\u00020\"H\u0016J\u0008\u0010:\u001a\u00020\"H\u0016J\u0008\u0010;\u001a\u00020<H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00160\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u001d\u0010\u001e\u001a\u0004\u0008\u001b\u0010\u001c¨\u0006=", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/challenge/ChallengeEntryCreationDialog;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseDialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogChallengeEntryCreationBinding;", "fragmentTag", "Lapp/dogo/com/dogo_android/enums/DialogTags;", "getFragmentTag", "()Lapp/dogo/com/dogo_android/enums/DialogTags;", "messagingFilters", "", "Lapp/dogo/com/dogo_android/enums/FragmentMessageAction;", "getMessagingFilters", "()Ljava/util/Set;", "screenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getScreenViewDescriptor", "()Lapp/dogo/com/dogo_android/tracking/Screen;", "topBarManager", "Lapp/dogo/com/dogo_android/util/interfaces/TopBarManager;", "viewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "getViewModelClass", "()Ljava/lang/Class;", "viewModelDi", "Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeEntryCreationViewModel;", "getViewModelDi", "()Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeEntryCreationViewModel;", "viewModelDi$delegate", "Lkotlin/Lazy;", "createTopBarManager", "getBaseViewModel", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDataReceived", "action", "message", "onPublishClick", "navigator", "Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "onStart", "onStop", "validatePublishRequest", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i0 extends u {

    private i8 w;
    private final h x;
    private g y;

    @Metadata(d1 = "\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0008\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0008\u0010\t\u001a\u00020\u0003H\u0016J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u0008\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u000f", d2 = {"app/dogo/com/dogo_android/view/main_screen/challenge/ChallengeEntryCreationDialog$createTopBarManager$1", "Lapp/dogo/com/dogo_android/util/interfaces/TopBarManager;", "getActionName", "", "getBackgroundColorRes", "", "view", "Landroid/view/View;", "getTextColorRes", "getTitle", "isBackVisible", "", "onAction", "", "onBack", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends g {

        final app.dogo.com.dogo_android.view.main_screen.j.i0 a;
        a(app.dogo.com.dogo_android.view.main_screen.j.i0 i0) {
            this.a = i0;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public String getActionName() {
            return this.a.getString(2131886312);
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public int getBackgroundColorRes(View view) {
            n.f(view, "view");
            return this.a.getResources().getColor(2131100378, 0);
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public int getTextColorRes(View view) {
            n.f(view, "view");
            return this.a.getResources().getColor(2131100379, 0);
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public String getTitle() {
            return "";
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean isBackVisible() {
            return 1;
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public void onAction() {
            final app.dogo.com.dogo_android.view.main_screen.j.i0 i0Var = this.a;
            i0.Y1(i0Var, i0Var.G1());
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public void onBack() {
            a0 a0Var = this.a.G1();
            n.d(a0Var);
            i0.X1(this.a).O(a0Var);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<e0> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final e0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(e0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public i0() {
        super();
        final int i = 0;
        i0.b bVar = new i0.b(this, i, i);
        this.x = j.a(m.SYNCHRONIZED, bVar);
    }

    public static final e0 X1(app.dogo.com.dogo_android.view.main_screen.j.i0 i0) {
        return i0.a2();
    }

    public static final void Y1(app.dogo.com.dogo_android.view.main_screen.j.i0 i0, a0 a02) {
        i0.f2(a02);
    }

    private final g Z1() {
        i0.a aVar = new i0.a(this);
        return aVar;
    }

    private final e0 a2() {
        return (e0)this.x.getValue();
    }

    public static void b2(a0 a0, app.dogo.com.dogo_android.view.main_screen.j.i0 i02, j j3) {
        i0.h2(a0, i02, j3);
    }

    public static void c2(a0 a0, Exception exception2) {
        i0.g2(a0, exception2);
    }

    public static void d2(app.dogo.com.dogo_android.view.main_screen.j.i0 i0, View view2) {
        i0.e2(i0, view2);
    }

    private static final void e2(app.dogo.com.dogo_android.view.main_screen.j.i0 i0, View view2) {
        n.f(i0, "this$0");
        i8 obj2 = i0.w;
        if (obj2 == null) {
        } else {
            obj2 = obj2.P;
            n.e(obj2, "binding.editText");
            i0.U1(obj2);
        }
        n.w("binding");
        throw 0;
    }

    private final void f2(a0 a0) {
        boolean onFailureListener;
        app.dogo.com.dogo_android.view.main_screen.j.h hVar;
        if (!i2()) {
        }
        if (a2().I()) {
            B1();
            i iVar = new i(a0);
            hVar = new h(a0, this);
            a2().Q().addOnFailureListener(iVar).addOnCompleteListener(hVar);
        }
    }

    private static final void g2(a0 a0, Exception exception2) {
        boolean i;
        Throwable obj3;
        a.d(exception2);
        final int i2 = 2131886123;
        if (exception2 instanceof ExceptionForTaskChain) {
            obj3 = (ExceptionForTaskChain)exception2.a();
            if (obj3 != 2) {
                if (obj3 != 4) {
                    if (a0 == null) {
                    } else {
                        a0.t0(i2);
                    }
                } else {
                    if (a0 == null) {
                    } else {
                        a0.t0(2131886307);
                    }
                }
            } else {
                if (a0 == null) {
                } else {
                    a0.t0(2131886305);
                }
            }
        } else {
            if (a0 == null) {
            } else {
                a0.t0(i2);
            }
        }
    }

    private static final void h2(a0 a0, app.dogo.com.dogo_android.view.main_screen.j.i0 i02, j j3) {
        n.f(i02, "this$0");
        if (a0 == null) {
        } else {
            a0.s();
        }
        i02.dismissAllowingStateLoss();
    }

    private final boolean i2() {
        String string;
        int i;
        Object[] arr;
        Integer valueOf;
        final int i6 = 0;
        if (!a2().G()) {
            V1(2131886953);
            return i6;
        }
        int i7 = 1;
        if (!a2().J()) {
            if (a2().D() == null) {
                V1(2131886262);
            } else {
                int[] iArr = a2().E();
                arr = new Object[2];
                arr[i6] = Integer.valueOf(iArr[i6]);
                arr[i7] = Integer.valueOf(iArr[i7]);
                W1(getString(2131886753, arr));
            }
            return i6;
        }
        if (a2().F()) {
            V1(2131886293);
            return i6;
        }
        if (!a2().K()) {
            V1(2131886693);
            return i6;
        }
        if (!a2().H()) {
            a0 a0Var = G1();
            n.d(a0Var);
            a2().T(a0Var);
            return i6;
        }
        return i7;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public r D1() {
        return a2();
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public c E1() {
        return c.CHALLENGE_ENTRY_CREATION;
    }

    protected Set<h> F1() {
        return q0.a(h.MESSAGE_ACTION_PUBLISH_ENTRY);
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public k3 H1() {
        return j3.N;
    }

    public Class<? extends r> J1() {
        return r.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    protected void S1(h h, Bundle bundle2) {
        Object obj1;
        if (h == h.MESSAGE_ACTION_PUBLISH_ENTRY) {
            f2(G1());
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public void onActivityResult(int i, int i2, Intent intent3) {
        int obj2;
        int obj3;
        Object obj4;
        super.onActivityResult(i, i2, intent3);
        obj2 = getActivity();
        if (i == 203 && i2 == -1 && obj2 instanceof a0) {
            if (i2 == -1) {
                obj2 = getActivity();
                if (obj2 instanceof a0) {
                    a2().a0(d.b(intent3).g());
                    T1((a0)obj2);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public void onCancel(DialogInterface dialogInterface) {
        n.f(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        a0 a0Var = G1();
        n.d(a0Var);
        a2().O(a0Var);
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        int i;
        boolean obj3;
        Object obj5;
        n.f(layoutInflater, "inflater");
        obj5 = getDialog();
        if (obj5 == null) {
        } else {
            obj5 = obj5.getWindow();
            if (obj5 == null) {
            } else {
                obj5.setBackgroundDrawableResource(2131230939);
            }
        }
        this.y = Z1();
        obj3 = i8.T(layoutInflater, viewGroup2, false);
        n.e(obj3, "inflate(inflater, container, false)");
        this.w = obj3;
        int obj4 = 0;
        obj5 = "binding";
        if (obj3 == null) {
        } else {
            obj3.W(a2());
            obj3 = this.w;
            if (obj3 == null) {
            } else {
                obj3.M(getViewLifecycleOwner());
                obj3 = this.w;
                if (obj3 == null) {
                } else {
                    obj3.V(G1());
                    obj3 = this.w;
                    if (obj3 == null) {
                    } else {
                        obj3.R.U(this.y);
                        obj3 = this.w;
                        if (obj3 == null) {
                        } else {
                            j jVar = new j(this);
                            obj3.O.setOnClickListener(jVar);
                            Bundle requireArguments = requireArguments();
                            n.e(requireArguments, "requireArguments()");
                            if (!a2().W(requireArguments)) {
                                obj3 = G1();
                                if (obj3 == null) {
                                } else {
                                    obj3.u();
                                }
                            }
                            obj3 = this.w;
                            if (obj3 == null) {
                            } else {
                                obj3 = obj3.w();
                                n.e(obj3, "binding.root");
                                return obj3;
                            }
                            n.w(obj5);
                            throw obj4;
                        }
                        n.w(obj5);
                        throw obj4;
                    }
                    n.w(obj5);
                    throw obj4;
                }
                n.w(obj5);
                throw obj4;
            }
            n.w(obj5);
            throw obj4;
        }
        n.w(obj5);
        throw obj4;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public void onStart() {
        Object challengeModel;
        super.onStart();
        if (a2().B() != null) {
            a2().w();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public void onStop() {
        super.onStop();
        a2().A();
    }
}

package app.dogo.com.dogo_android.view.main_screen.j;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.a0.g.f.d0;
import app.dogo.com.dogo_android.h.g8;
import app.dogo.com.dogo_android.h.o0;
import app.dogo.com.dogo_android.h.um;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.u;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.w.c1;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.o3;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0018\u001a\u00020\u000fH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0008\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0008\u0010%\u001a\u00020\u001aH\u0002J\u0008\u0010&\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001e\u0010\r\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u000f0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0014\u0010\u0015¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/challenge/ChallengeDetailsDialog;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseDialogFragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogChallengeDetailsBinding;", "fragmentTag", "Lapp/dogo/com/dogo_android/enums/DialogTags;", "getFragmentTag", "()Lapp/dogo/com/dogo_android/enums/DialogTags;", "screenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getScreenViewDescriptor", "()Lapp/dogo/com/dogo_android/tracking/Screen;", "viewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "getViewModelClass", "()Ljava/lang/Class;", "viewModelDi", "Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeDetailsViewModel;", "getViewModelDi", "()Lapp/dogo/com/dogo_android/viewmodel/main_screen/challenge/ChallengeDetailsViewModel;", "viewModelDi$delegate", "Lkotlin/Lazy;", "getBaseViewModel", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupFabHideTrigger", "setupScrollTrigger", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h0 extends u {

    public static final app.dogo.com.dogo_android.view.main_screen.j.h0.a Companion;
    private g8 w;
    private final h x;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/view/main_screen/challenge/ChallengeDetailsDialog$Companion;", "", "()V", "SCROLL_TO_BOTTOM", "", "SCROLL_TO_PRIZE", "SCROLL_TO_RULES", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<d0> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final d0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(d0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
        h0.a aVar = new h0.a(0);
        h0.Companion = aVar;
    }

    public h0() {
        super();
        final int i = 0;
        h0.b bVar = new h0.b(this, i, i);
        this.x = j.a(m.SYNCHRONIZED, bVar);
    }

    private final d0 X1() {
        return (d0)this.x.getValue();
    }

    public static void Y1(app.dogo.com.dogo_android.view.main_screen.j.h0 h0) {
        h0.g2(h0);
    }

    public static void Z1(app.dogo.com.dogo_android.view.main_screen.j.h0 h0, Integer integer2) {
        h0.n2(h0, integer2);
    }

    public static void a2(app.dogo.com.dogo_android.view.main_screen.j.h0 h0, View view2) {
        h0.f2(h0, view2);
    }

    public static void b2(app.dogo.com.dogo_android.view.main_screen.j.h0 h0, Boolean boolean2) {
        h0.j2(h0, boolean2);
    }

    public static void c2(app.dogo.com.dogo_android.view.main_screen.j.h0 h0) {
        h0.k2(h0);
    }

    public static void d2(app.dogo.com.dogo_android.view.main_screen.j.h0 h0, y y2) {
        h0.h2(h0, y2);
    }

    public static void e2(app.dogo.com.dogo_android.view.main_screen.j.h0 h0) {
        h0.l2(h0);
    }

    private static final void f2(app.dogo.com.dogo_android.view.main_screen.j.h0 h0, View view2) {
        n.f(h0, "this$0");
        h0.X1().a0();
        final a0 obj0 = h0.G1();
        n.d(obj0);
        obj0.r(c.CHALLENGE_DETAILS_DIALOG);
    }

    private static final void g2(app.dogo.com.dogo_android.view.main_screen.j.h0 h0) {
        n.f(h0, "this$0");
        h0.X1().z(h0.getArguments());
    }

    private static final void h2(app.dogo.com.dogo_android.view.main_screen.j.h0 h0, y y2) {
        Object obj1;
        boolean obj2;
        n.f(h0, "this$0");
        if (y2 instanceof y.c) {
            obj2 = h0.G1();
            if (obj2 == null) {
            } else {
                h0.X1().A(obj2);
            }
        }
    }

    private final void i2() {
        d dVar = new d(this);
        X1().G().observe(this, dVar);
    }

    private static final void j2(app.dogo.com.dogo_android.view.main_screen.j.h0 h0, Boolean boolean2) {
        String gVar;
        int i;
        String str;
        boolean booleanValue;
        int i2;
        app.dogo.com.dogo_android.view.main_screen.j.e eVar;
        Object obj7;
        boolean obj8;
        n.f(h0, "this$0");
        if (boolean2) {
            g8 g8Var = h0.w;
            i = 0;
            str = "binding";
            if (g8Var == null) {
            } else {
                gVar = g8Var.R.getVisibility() == 0 ? 1 : 0;
                i2 = 200;
                if (boolean2.booleanValue() && gVar == 0 && h0.X1().Q()) {
                    if (gVar == 0) {
                        if (h0.X1().Q()) {
                            h0.X1().e0();
                            g8 g8Var2 = h0.w;
                            if (g8Var2 == null) {
                            } else {
                                int i4 = 1065353216;
                                eVar = new e(h0);
                                g8Var2.R.animate().setDuration(i2).scaleX(i4).scaleY(i4).withStartAction(eVar).start();
                            }
                            n.w(str);
                            throw i;
                        }
                    }
                }
                if (!boolean2.booleanValue() && gVar != 0) {
                    if (gVar != 0) {
                        obj8 = h0.w;
                        if (obj8 == null) {
                        } else {
                            int i3 = 0;
                            gVar = new g(h0);
                            obj8.R.animate().setDuration(i2).scaleX(i3).scaleY(i3).withEndAction(gVar).start();
                        }
                        n.w(str);
                        throw i;
                    }
                }
            }
            n.w(str);
            throw i;
        }
    }

    private static final void k2(app.dogo.com.dogo_android.view.main_screen.j.h0 h0) {
        n.f(h0, "this$0");
        g8 obj1 = h0.w;
        if (obj1 == null) {
        } else {
            obj1.R.setVisibility(0);
        }
        n.w("binding");
        throw 0;
    }

    private static final void l2(app.dogo.com.dogo_android.view.main_screen.j.h0 h0) {
        n.f(h0, "this$0");
        g8 obj1 = h0.w;
        if (obj1 == null) {
        } else {
            obj1.R.setVisibility(8);
        }
        n.w("binding");
        throw 0;
    }

    private final void m2() {
        b bVar = new b(this);
        X1().N().observe(this, bVar);
    }

    private static final void n2(app.dogo.com.dogo_android.view.main_screen.j.h0 h0, Integer integer2) {
        int i;
        int intValue;
        int i2;
        int intValue2;
        int obj5;
        ScrollView obj6;
        n.f(h0, "this$0");
        int i3 = 0;
        final String str2 = "binding";
        if (integer2 == null) {
        } else {
            if (integer2.intValue() == 0) {
                obj6 = h0.w;
                if (obj6 == null) {
                } else {
                    obj6.W.fullScroll(130);
                    obj6 = h0.w;
                    if (obj6 == null) {
                    } else {
                        obj6.Q.clearAnimation();
                        obj6 = h0.w;
                        if (obj6 == null) {
                        } else {
                            obj5 = h0.w;
                            if (obj5 == null) {
                            } else {
                                obj5.Q.startAnimation(AnimationUtils.loadAnimation(obj6.Q.getContext(), 2130772025));
                            }
                            n.w(str2);
                            throw i3;
                        }
                        n.w(str2);
                        throw i3;
                    }
                    n.w(str2);
                    throw i3;
                }
                n.w(str2);
                throw i3;
            }
        }
        i2 = 0;
        if (integer2 == null) {
        } else {
            if (integer2.intValue() == 1) {
                obj5 = h0.w;
                if (obj5 == null) {
                } else {
                    if (obj5 == null) {
                    } else {
                        obj5.W.smoothScrollTo(i2, obj5.V.w().getTop());
                    }
                    n.w(str2);
                    throw i3;
                }
                n.w(str2);
                throw i3;
            }
        }
        if (integer2 == null) {
        } else {
            if (integer2.intValue() == 2) {
                obj5 = h0.w;
                if (obj5 == null) {
                } else {
                    if (obj5 == null) {
                    } else {
                        obj5.W.smoothScrollTo(i2, obj5.X.getTop());
                    }
                    n.w(str2);
                    throw i3;
                }
                n.w(str2);
                throw i3;
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public r D1() {
        return X1();
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public c E1() {
        return c.CHALLENGE_DETAILS_DIALOG;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public k3 H1() {
        return null;
    }

    public Class<? extends r> J1() {
        return r.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public void onCancel(DialogInterface dialogInterface) {
        Object cHALLENGE_DETAILS_DIALOG;
        n.f(dialogInterface, "dialog");
        super.onCancel(dialogInterface);
        X1().a0();
        a0 obj2 = G1();
        if (obj2 == null) {
        } else {
            obj2.r(c.CHALLENGE_DETAILS_DIALOG);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        Object requireActivity;
        app.dogo.com.dogo_android.w.i3 i3Var;
        c1 c1Var;
        String str;
        Object obj5;
        n.f(layoutInflater, "inflater");
        obj5 = g8.T(layoutInflater, viewGroup2, false);
        n.e(obj5, "inflate(inflater, container, false)");
        this.w = obj5;
        if (!X1().f0(getArguments())) {
            dismissAllowingStateLoss();
        }
        obj5 = this.w;
        int obj6 = 0;
        String obj7 = "binding";
        if (obj5 == null) {
        } else {
            obj5.M(getViewLifecycleOwner());
            obj5 = this.w;
            if (obj5 == null) {
            } else {
                obj5.W(X1());
                obj5 = this.w;
                if (obj5 == null) {
                } else {
                    obj5.Z.T(X1());
                    obj5 = this.w;
                    if (obj5 == null) {
                    } else {
                        obj5.V(G1());
                        obj5 = this.w;
                        if (obj5 == null) {
                        } else {
                            obj5.V.T(X1().M());
                            obj5 = this.w;
                            if (obj5 == null) {
                            } else {
                                obj5.T.T(X1().K());
                                obj5 = this.w;
                                if (obj5 == null) {
                                } else {
                                    obj5.U.T(X1().L());
                                    obj5 = this.w;
                                    if (obj5 == null) {
                                    } else {
                                        c cVar = new c(this);
                                        obj5.Y.setNavigationOnClickListener(cVar);
                                        m2();
                                        i2();
                                        obj5 = this.w;
                                        if (obj5 == null) {
                                        } else {
                                            requireActivity = new a(this);
                                            obj5.W.post(requireActivity);
                                            X1().B();
                                            if (X1().D() != null) {
                                                requireActivity = requireActivity();
                                                n.e(requireActivity, "requireActivity()");
                                                c1Var = new c1();
                                                this.c.g(requireActivity, j3.O.b(c1Var, X1().D()));
                                            }
                                            f fVar = new f(this);
                                            X1().J().observe(getViewLifecycleOwner(), fVar);
                                            obj5 = this.w;
                                            if (obj5 == null) {
                                            } else {
                                                obj5 = obj5.w();
                                                n.e(obj5, "binding.root");
                                                return obj5;
                                            }
                                            n.w(obj7);
                                            throw obj6;
                                        }
                                        n.w(obj7);
                                        throw obj6;
                                    }
                                    n.w(obj7);
                                    throw obj6;
                                }
                                n.w(obj7);
                                throw obj6;
                            }
                            n.w(obj7);
                            throw obj6;
                        }
                        n.w(obj7);
                        throw obj6;
                    }
                    n.w(obj7);
                    throw obj6;
                }
                n.w(obj7);
                throw obj6;
            }
            n.w(obj7);
            throw obj6;
        }
        n.w(obj7);
        throw obj6;
    }
}

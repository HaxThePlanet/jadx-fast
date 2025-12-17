package app.dogo.com.dogo_android.i;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.c.a;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.c.h;
import app.dogo.com.dogo_android.h.a7;
import app.dogo.com.dogo_android.h.ab;
import app.dogo.com.dogo_android.h.y6;
import app.dogo.com.dogo_android.inappmessaging.m;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.r.k;
import app.dogo.com.dogo_android.repository.domain.InAppMessageDataHolder;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay.StreakStatus;
import app.dogo.com.dogo_android.service.q2.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.view.n;
import app.dogo.com.dogo_android.x.b.c;
import app.dogo.com.dogo_android.x.d.c;
import app.dogo.com.dogo_android.y.b0.d;
import app.dogo.com.dogo_android.y.j;
import f.c.a.e.s.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import kotlin.w;
import kotlin.y.p;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J$\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0008\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00102\u0008\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0008\u0010%\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugDataFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDebugDataDialogBinding;", "screenKey", "Lapp/dogo/com/dogo_android/debug/DebugDataScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/debug/DebugDataScreen;", "viewModel", "Lapp/dogo/com/dogo_android/debug/DebugDataFragmentViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/debug/DebugDataFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "buildSimpleButtonView", "Landroid/view/View;", "buttonText", "", "labelText", "listener", "Landroid/view/View$OnClickListener;", "buildSimpleTextView", "text", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupUserInfoList", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g0 extends Fragment {

    private final h a;
    private ab b;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<String, w> {

        final app.dogo.com.dogo_android.i.g0 this$0;
        a(app.dogo.com.dogo_android.i.g0 g0) {
            this.this$0 = g0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(String string) {
            long long;
            n.f(string, "it");
            g0.B1(this.this$0).s(Long.parseLong(string), obj1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((String)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<String, w> {

        final app.dogo.com.dogo_android.i.g0 this$0;
        b(app.dogo.com.dogo_android.i.g0 g0) {
            this.this$0 = g0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(String string) {
            long long;
            n.f(string, "it");
            g0.B1(this.this$0).s(Long.parseLong(string), obj1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((String)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements a<app.dogo.com.dogo_android.i.h0> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public c(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.i.h0 invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(h0.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public g0() {
        super();
        final int i = 0;
        g0.c cVar = new g0.c(this, i, i);
        this.a = j.a(m.SYNCHRONIZED, cVar);
    }

    public static final app.dogo.com.dogo_android.i.h0 B1(app.dogo.com.dogo_android.i.g0 g0) {
        return g0.F1();
    }

    private final View C1(String string, String string2, View.OnClickListener view$OnClickListener3) {
        y6 y6Var = y6.T(getLayoutInflater());
        n.e(y6Var, "inflate(layoutInflater)");
        y6Var.O.setText(string);
        y6Var.P.setText(string2);
        y6Var.O.setOnClickListener(onClickListener3);
        View obj3 = y6Var.w();
        n.e(obj3, "binding.root");
        return obj3;
    }

    private final View D1(String string) {
        a7 a7Var = a7.T(getLayoutInflater());
        n.e(a7Var, "inflate(layoutInflater)");
        a7Var.O.setText(string);
        a7Var.O.setTextIsSelectable(true);
        View obj3 = a7Var.w();
        n.e(obj3, "binding.root");
        return obj3;
    }

    private final app.dogo.com.dogo_android.i.i0 E1() {
        return (i0)k1.a(this);
    }

    private final app.dogo.com.dogo_android.i.h0 F1() {
        return (h0)this.a.getValue();
    }

    public static void G1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.q2(g0, view2);
    }

    public static void H1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.f2(g0, view2);
    }

    public static void I1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.l2(g0, view2);
    }

    public static void J1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.i2(g0, view2);
    }

    public static void K1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.m2(g0, view2);
    }

    public static void L1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.x2(g0, view2);
    }

    public static void M1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.j2(g0, view2);
    }

    public static void N1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.h2(g0, view2);
    }

    public static void O1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.s2(g0, view2);
    }

    public static void P1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.y2(g0, view2);
    }

    public static void Q1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.o2(g0, view2);
    }

    public static void R1(app.dogo.com.dogo_android.i.g0 g0, EditText editText2, DialogInterface dialogInterface3, int i4) {
        g0.k2(g0, editText2, dialogInterface3, i4);
    }

    public static void S1(app.dogo.com.dogo_android.i.g0 g0, Boolean boolean2) {
        g0.c2(g0, boolean2);
    }

    public static void T1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.t2(g0, view2);
    }

    public static void U1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.v2(g0, view2);
    }

    public static void V1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.u2(g0, view2);
    }

    public static void W1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.w2(g0, view2);
    }

    public static void X1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.r2(g0, view2);
    }

    public static void Y1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.p2(g0, view2);
    }

    public static void Z1(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.g2(g0, view2);
    }

    public static void a2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.n2(g0, view2);
    }

    public static void b2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        g0.d2(g0, view2);
    }

    private static final void c2(app.dogo.com.dogo_android.i.g0 g0, Boolean boolean2) {
        n.f(g0, "this$0");
        g0.e2();
    }

    private static final void d2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        n.f(g0, "this$0");
        g0.requireActivity().getSupportFragmentManager().Z0();
    }

    private final void e2() {
        LinearLayout linearLayout;
        View str2;
        String str;
        String stringBuilder;
        ab abVar = this.b;
        final int i = 0;
        final String str3 = "binding";
        if (abVar == null) {
        } else {
            abVar.O.removeAllViews();
            ab abVar2 = this.b;
            if (abVar2 == null) {
            } else {
                s sVar = new s(this);
                stringBuilder = "";
                abVar2.O.addView(C1("Feature Enabler", stringBuilder, sVar));
                ab abVar3 = this.b;
                if (abVar3 == null) {
                } else {
                    i iVar = new i(this);
                    abVar3.O.addView(C1("Time metrics not achieved", stringBuilder, iVar));
                    ab abVar4 = this.b;
                    if (abVar4 == null) {
                    } else {
                        n nVar = new n(this);
                        abVar4.O.addView(C1("Force User-Premium", n.o("User premium is : ", Boolean.valueOf(F1().p())), nVar));
                        ab abVar5 = this.b;
                        if (abVar5 == null) {
                        } else {
                            p pVar = new p(this);
                            abVar5.O.addView(C1("Force User-dog-premium", n.o("User dog premium is : ", Boolean.valueOf(F1().o())), pVar));
                            ab abVar6 = this.b;
                            if (abVar6 == null) {
                            } else {
                                o oVar = new o(this);
                                abVar6.O.addView(C1("Force User-resubscribe", n.o("User resubscribe is : ", Boolean.valueOf(F1().q())), oVar));
                                ab abVar7 = this.b;
                                if (abVar7 == null) {
                                } else {
                                    q qVar = new q(this);
                                    abVar7.O.addView(C1("Toggle-Ambassador", n.o("Ambassador is : ", Boolean.valueOf(F1().n())), qVar));
                                    ab abVar8 = this.b;
                                    if (abVar8 == null) {
                                    } else {
                                        f fVar = new f(this);
                                        abVar8.O.addView(C1("CameraX", stringBuilder, fVar));
                                        ab abVar9 = this.b;
                                        if (abVar9 == null) {
                                        } else {
                                            j jVar = new j(this);
                                            abVar9.O.addView(C1("Lesson introduction", stringBuilder, jVar));
                                            ab abVar10 = this.b;
                                            if (abVar10 == null) {
                                            } else {
                                                b bVar = new b(this);
                                                abVar10.O.addView(C1("Start inAppFeedBack", stringBuilder, bVar));
                                                ab abVar11 = this.b;
                                                if (abVar11 == null) {
                                                } else {
                                                    t tVar = new t(this);
                                                    abVar11.O.addView(C1("In app review", stringBuilder, tVar));
                                                    ab abVar12 = this.b;
                                                    if (abVar12 == null) {
                                                    } else {
                                                        h hVar = new h(this);
                                                        abVar12.O.addView(C1("Restart App", stringBuilder, hVar));
                                                        ab abVar13 = this.b;
                                                        if (abVar13 == null) {
                                                        } else {
                                                            d dVar = new d(this);
                                                            abVar13.O.addView(C1("Reset used coupons", stringBuilder, dVar));
                                                            ab abVar14 = this.b;
                                                            if (abVar14 == null) {
                                                            } else {
                                                                g gVar = new g(this);
                                                                abVar14.O.addView(C1("Set first open source", stringBuilder, gVar));
                                                                ab abVar15 = this.b;
                                                                if (abVar15 == null) {
                                                                } else {
                                                                    c cVar = new c(this);
                                                                    abVar15.O.addView(C1("ClearDebugOverrides", stringBuilder, cVar));
                                                                    ab abVar16 = this.b;
                                                                    if (abVar16 == null) {
                                                                    } else {
                                                                        e eVar = new e(this);
                                                                        abVar16.O.addView(C1("Mock question explanation html", stringBuilder, eVar));
                                                                        ab abVar17 = this.b;
                                                                        if (abVar17 == null) {
                                                                        } else {
                                                                            u uVar = new u(this);
                                                                            abVar17.O.addView(C1("AddChristmasCoupon", stringBuilder, uVar));
                                                                            ab abVar18 = this.b;
                                                                            if (abVar18 == null) {
                                                                            } else {
                                                                                k kVar = new k(this);
                                                                                abVar18.O.addView(C1("AddNewYearsCoupon", stringBuilder, kVar));
                                                                                ab abVar19 = this.b;
                                                                                if (abVar19 == null) {
                                                                                } else {
                                                                                    a aVar = new a(this);
                                                                                    abVar19.O.addView(C1("NoTimeReminder", stringBuilder, aVar));
                                                                                    ab abVar20 = this.b;
                                                                                    if (abVar20 == null) {
                                                                                    } else {
                                                                                        r rVar = new r(this);
                                                                                        abVar20.O.addView(C1("TestStreakComplete", stringBuilder, rVar));
                                                                                        Iterator iterator = F1().m().entrySet().iterator();
                                                                                        for (Map.Entry next2 : iterator) {
                                                                                            ab abVar21 = this.b;
                                                                                            stringBuilder = new StringBuilder();
                                                                                            stringBuilder.append((String)next2.getKey());
                                                                                            stringBuilder.append(": ");
                                                                                            stringBuilder.append((String)next2.getValue());
                                                                                            abVar21.O.addView(D1(stringBuilder.toString()));
                                                                                        }
                                                                                    }
                                                                                    n.w(str3);
                                                                                    throw i;
                                                                                }
                                                                                n.w(str3);
                                                                                throw i;
                                                                            }
                                                                            n.w(str3);
                                                                            throw i;
                                                                        }
                                                                        n.w(str3);
                                                                        throw i;
                                                                    }
                                                                    n.w(str3);
                                                                    throw i;
                                                                }
                                                                n.w(str3);
                                                                throw i;
                                                            }
                                                            n.w(str3);
                                                            throw i;
                                                        }
                                                        n.w(str3);
                                                        throw i;
                                                    }
                                                    n.w(str3);
                                                    throw i;
                                                }
                                                n.w(str3);
                                                throw i;
                                            }
                                            n.w(str3);
                                            throw i;
                                        }
                                        n.w(str3);
                                        throw i;
                                    }
                                    n.w(str3);
                                    throw i;
                                }
                                n.w(str3);
                                throw i;
                            }
                            n.w(str3);
                            throw i;
                        }
                        n.w(str3);
                        throw i;
                    }
                    n.w(str3);
                    throw i;
                }
                n.w(str3);
                throw i;
            }
            n.w(str3);
            throw i;
        }
        n.w(str3);
        throw i;
    }

    private static final void f2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        m mVar;
        InAppMessageDataHolder inAppMessageDataHolder;
        int i2;
        int i3;
        int i4;
        int i;
        m mVar2;
        Object obj7;
        n.f(g0, "this$0");
        e obj8 = g0.getActivity();
        if (obj8 == null) {
        } else {
            String string = g0.getString(2131886762);
            n.e(string, "getString(R.string.in_app_rate_us_text)");
            obj7 = g0.getString(2131886759);
            n.e(obj7, "getString(R.string.in_app_nps_score_subheader)");
            inAppMessageDataHolder = new InAppMessageDataHolder(string, obj7, "1", "Name");
            super(inAppMessageDataHolder, 0, 0, 6, 0);
            g1.X(obj8, mVar2);
        }
    }

    private static final void g2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        n.f(g0, "this$0");
        final e obj1 = g0.requireActivity();
        n.e(obj1, "requireActivity()");
        n obj2 = new n(q2.a.UNDEFINED.getTag());
        g1.X(obj1, obj2);
    }

    private static final void h2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        n.f(g0, "this$0");
        g0.requireActivity().finish();
        Intent intent = new Intent(g0.requireContext(), SplashActivity.class);
        g0.requireActivity().startActivity(intent);
    }

    private static final void i2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        n.f(g0, "this$0");
        g0.F1().r();
    }

    private static final void j2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        n.f(g0, "this$0");
        EditText obj4 = new EditText(g0.requireContext());
        b bVar = new b(g0.requireContext(), 2131952089);
        l lVar = new l(g0, obj4);
        bVar.x("Set new open source").J(obj4).E("Ok", lVar).o();
    }

    private static final void k2(app.dogo.com.dogo_android.i.g0 g0, EditText editText2, DialogInterface dialogInterface3, int i4) {
        n.f(g0, "this$0");
        n.f(editText2, "$editText");
        g0.F1().t(editText2.getText().toString());
    }

    private static final void l2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        n.f(g0, "this$0");
        g0.F1().k();
    }

    private static final void m2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        n.f(g0, "this$0");
        String obj14 = "";
        ProgramSaveInfo programSaveInfo = new ProgramSaveInfo(obj14, obj14, obj14, obj14);
        final int i2 = 0;
        super(i2, "The question", "", "<h1>The heading title</h><br/><h2>Smaller heading title</h2><br/><p>Some text about the correct answer</p><br/><ul><li>first line</li><li>second line</li></ul><br/><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin quis maximus sem. Fusce est lorem, pulvinar vel dictum a, finibus at sapien. In in tortor ac risus sodales gravida at molestie neque porttitor ac. Vestibulum vitae lorem vel orci placerat viverra. Ut vehicula ex sed ipsum finibus, eu aliquam risus hendrerit.\nMorbi porta, orci non lobortis eleifend, felis tortor scelerisque neque, vitae tempus risus dui quis magna. Sed facilisis id elit non iaculis. Aenean eget commodo erat, sed faucibus odio. Nullam tortor nulla, lacinia non velit id, rutrum pulvinar nisl. Maecenas est nulla, rhoncus vitae eros vel, cursus pellentesque ipsum. Fusce quis lectus in est interdum cursus sed eu ex. Aliquam vitae gravida ipsum. Curabitur fringilla vestibulum dolor, id sollicitudin urna fringilla quis.\nProin leo urna, convallis egestas scelerisque eget, sagittis at est. Phasellus eleifend nisl sit amet augue tristique, vestibulum imperdiet magna. Praesent malesuada sodales ultrices. Morbi velit sem, sodales quis orci sed.</p>", p.b("The correct answer"), 0, 0, 65, 0);
        super(programQuestion, programSaveInfo, g0.E1().getTag(), 0, i2, 24, 0);
        g1.n(g0.requireActivity(), obj14);
    }

    private static final void n2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        app.dogo.com.dogo_android.i.g0.a aVar;
        Object obj1;
        n.f(g0, "this$0");
        e obj2 = g0.getActivity();
        if (obj2 == null) {
        } else {
            aVar = new g0.a(g0);
            f1.Z(obj2, "Enter coupon duration in milliseconds", aVar);
        }
    }

    private static final void o2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        app.dogo.com.dogo_android.i.g0.b bVar;
        Object obj1;
        n.f(g0, "this$0");
        e obj2 = g0.getActivity();
        if (obj2 == null) {
        } else {
            bVar = new g0.b(g0);
            f1.Z(obj2, "Enter coupon duration in milliseconds", bVar);
        }
    }

    private static final void p2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        n.f(g0, "this$0");
        k0 obj1 = new k0();
        g1.n(g0.getActivity(), obj1);
    }

    private static final void q2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        int i2;
        String str;
        int i;
        Object obj4;
        n.f(g0, "this$0");
        final e obj3 = g0.getActivity();
        if (obj3 == null) {
        } else {
            i = 0;
            obj4 = new k("", i, 2, i);
            g1.n(obj3, obj4);
        }
    }

    private static final void r2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        n.f(g0, "this$0");
        super(1, 544, 80, "2002-11-11", "", TrainingTimeMetrics.TrainingTimeDay.StreakStatus.ACTIVE);
        super(p.b(trainingTimeDay), 6, 0, 0, 0, 0, 60, 0);
        String str3 = "";
        c cVar = new c(trainingTimeMetrics, "Bobby", str3, str3);
        g1.n(g0.getActivity(), cVar);
    }

    private static final void s2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        n.f(g0, "this$0");
        super(1, 160, 180, "", "", TrainingTimeMetrics.TrainingTimeDay.StreakStatus.ACTIVE);
        super(p.b(trainingTimeDay), 0, 0, 0, 0, 0, 62, 0);
        c obj12 = new c("simple_trick_list", p.b(3), trainingTimeMetrics, "");
        g1.n(g0.getActivity(), obj12);
    }

    private static final void t2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        n.f(g0, "this$0");
        g0.F1().w();
    }

    private static final void u2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        n.f(g0, "this$0");
        g0.F1().v();
    }

    private static final void v2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        n.f(g0, "this$0");
        g0.F1().x();
    }

    private static final void w2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        n.f(g0, "this$0");
        g0.F1().u();
    }

    private static final void x2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        n.f(g0, "this$0");
        h obj1 = new h();
        g1.n(g0.getActivity(), obj1);
    }

    private static final void y2(app.dogo.com.dogo_android.i.g0 g0, View view2) {
        n.f(g0, "this$0");
        final int i = 0;
        k1.f(g0, c.LESSON_INTRODUCTION_DIALOG, i, 2, i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        e activity;
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
        ab obj2 = ab.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.b = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.V(F1());
            e2();
            obj2 = this.b;
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        m mVar = new m(this);
        F1().l().observe(getViewLifecycleOwner(), mVar);
        ab obj2 = this.b;
        if (obj2 == null) {
        } else {
            v obj3 = new v(this);
            obj2.P.setNavigationOnClickListener(obj3);
        }
        n.w("binding");
        throw 0;
    }
}

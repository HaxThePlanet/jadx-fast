package app.dogo.com.dogo_android.util.h0;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.h.sn;
import app.dogo.com.dogo_android.h.un;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.Balloon.a;
import com.skydoves.balloon.a;
import com.skydoves.balloon.c;
import com.skydoves.balloon.f;
import com.skydoves.balloon.g;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\t\u001a\u001a\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u000c¨\u0006\r", d2 = {"buildWorkoutClickerTooltip", "Lcom/skydoves/balloon/Balloon;", "Landroidx/fragment/app/Fragment;", "tooltipView", "Landroid/view/View;", "buildWorkoutTrickTooltip", "showCalendarIntroductionTooltip", "view", "callback", "Lapp/dogo/com/dogo_android/util/extensionfunction/CalendarToolTipCallbacks;", "showClickerIntroductionTooltip", "clicker", "Lapp/dogo/com/dogo_android/util/extensionfunction/TrickDetailsClickerToolTipCallbacks;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class n1 {
    public static final Balloon a(Fragment fragment, View view2) {
        n.f(fragment, "<this>");
        n.f(view2, "tooltipView");
        android.content.Context requireContext = fragment.requireContext();
        n.e(requireContext, "requireContext()");
        Balloon.a aVar = new Balloon.a(requireContext);
        aVar.q(view2);
        aVar.i(2131100336);
        aVar.j(f.FADE);
        aVar.k(1094713344);
        aVar.D(1065353216);
        int i4 = 44;
        aVar.s(i4);
        aVar.t(i4);
        aVar.o(260);
        int i6 = 0;
        aVar.m(i6);
        aVar.c(a.BOTTOM);
        aVar.e(c.ALIGN_ANCHOR);
        aVar.b(a.f(view2.getContext(), 2131231078));
        aVar.r(fragment.getViewLifecycleOwner());
        aVar.f(32);
        aVar.g(24);
        aVar.p(true);
        aVar.l(i6);
        return aVar.a();
    }

    public static final Balloon b(Fragment fragment, View view2) {
        n.f(fragment, "<this>");
        n.f(view2, "tooltipView");
        android.content.Context requireContext = fragment.requireContext();
        n.e(requireContext, "requireContext()");
        Balloon.a aVar = new Balloon.a(requireContext);
        aVar.q(view2);
        aVar.i(2131100336);
        aVar.j(f.FADE);
        aVar.k(1094713344);
        aVar.d(1051931443);
        aVar.D(1065353216);
        int i5 = 44;
        aVar.s(i5);
        aVar.t(i5);
        aVar.o(220);
        int i7 = 0;
        aVar.m(i7);
        aVar.e(c.ALIGN_ANCHOR);
        aVar.b(a.f(view2.getContext(), 2131231078));
        aVar.r(fragment.getViewLifecycleOwner());
        aVar.f(32);
        aVar.g(24);
        aVar.p(true);
        aVar.l(i7);
        return aVar.a();
    }

    public static void c(app.dogo.com.dogo_android.util.h0.h1 h1, Balloon balloon2, View view3) {
        n1.g(h1, balloon2, view3);
    }

    public static void d(app.dogo.com.dogo_android.util.h0.o1 o1, Balloon balloon2, View view3) {
        n1.i(o1, balloon2, view3);
    }

    public static void e(app.dogo.com.dogo_android.util.h0.o1 o1, Balloon balloon2, View view3) {
        n1.j(o1, balloon2, view3);
    }

    public static final Balloon f(Fragment fragment, View view2, app.dogo.com.dogo_android.util.h0.h1 h13) {
        n.f(fragment, "<this>");
        n.f(view2, "view");
        n.f(h13, "callback");
        final int i10 = 0;
        sn snVar = sn.T(LayoutInflater.from(fragment.getContext()), 0, i10);
        n.e(snVar, "inflate(LayoutInflater.from(context), null, false)");
        android.content.Context requireContext = fragment.requireContext();
        n.e(requireContext, "requireContext()");
        Balloon.a aVar = new Balloon.a(requireContext);
        View view = snVar.w();
        n.e(view, "tooltipBinding.root");
        aVar.q(view);
        aVar.i(2131100336);
        aVar.j(f.OVERSHOOT);
        aVar.k(1094713344);
        aVar.D(1065353216);
        int i5 = 44;
        aVar.s(i5);
        aVar.t(i5);
        aVar.m(i10);
        aVar.c(a.BOTTOM);
        aVar.e(c.ALIGN_BALLOON);
        aVar.b(a.f(fragment.requireContext(), 2131231078));
        aVar.r(fragment.getViewLifecycleOwner());
        aVar.f(32);
        aVar.g(24);
        aVar.l(i10);
        aVar.u(2131100375);
        int i9 = 1;
        aVar.p(i9);
        Balloon balloon = aVar.a();
        c1 c1Var = new c1(h13, balloon);
        snVar.O.setOnClickListener(c1Var);
        g.b(view2, balloon, i10, (int)obj5);
        return balloon;
    }

    private static final void g(app.dogo.com.dogo_android.util.h0.h1 h1, Balloon balloon2, View view3) {
        n.f(h1, "$callback");
        n.f(balloon2, "$this_apply");
        h1.d();
        h1.a();
        balloon2.J();
    }

    public static final Balloon h(Fragment fragment, View view2, app.dogo.com.dogo_android.util.h0.o1 o13) {
        n.f(fragment, "<this>");
        n.f(view2, "clicker");
        n.f(o13, "callback");
        final int i10 = 0;
        un unVar = un.T(LayoutInflater.from(fragment.getContext()), 0, i10);
        n.e(unVar, "inflate(LayoutInflater.from(context), null, false)");
        android.content.Context requireContext = fragment.requireContext();
        n.e(requireContext, "requireContext()");
        Balloon.a aVar = new Balloon.a(requireContext);
        View view3 = unVar.w();
        n.e(view3, "tooltipBinding.root");
        aVar.q(view3);
        aVar.i(2131100336);
        aVar.j(f.OVERSHOOT);
        aVar.k(1094713344);
        aVar.D(1065353216);
        int i5 = 44;
        aVar.s(i5);
        aVar.t(i5);
        aVar.m(i10);
        aVar.c(a.BOTTOM);
        aVar.e(c.ALIGN_BALLOON);
        aVar.b(a.f(fragment.requireContext(), 2131231078));
        aVar.r(fragment.getViewLifecycleOwner());
        aVar.f(32);
        aVar.g(24);
        aVar.l(i10);
        aVar.u(2131100375);
        int i9 = 1;
        aVar.p(i9);
        Balloon balloon = aVar.a();
        d1 d1Var = new d1(o13, balloon);
        unVar.O.setOnClickListener(d1Var);
        e1 e1Var = new e1(o13, balloon);
        unVar.P.setOnClickListener(e1Var);
        g.b(view2, balloon, i10, (int)obj6);
        return balloon;
    }

    private static final void i(app.dogo.com.dogo_android.util.h0.o1 o1, Balloon balloon2, View view3) {
        n.f(o1, "$callback");
        n.f(balloon2, "$this_apply");
        o1.b();
        o1.f();
        balloon2.J();
    }

    private static final void j(app.dogo.com.dogo_android.util.h0.o1 o1, Balloon balloon2, View view3) {
        n.f(o1, "$callback");
        n.f(balloon2, "$this_apply");
        o1.c();
        o1.g();
        o1.e();
        balloon2.J();
    }
}

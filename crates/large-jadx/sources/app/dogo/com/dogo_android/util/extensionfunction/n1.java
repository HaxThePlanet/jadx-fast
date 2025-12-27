package app.dogo.com.dogo_android.util.h0;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.h.sn;
import app.dogo.com.dogo_android.h.un;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.Balloon.a;
import com.skydoves.balloon.c;
import com.skydoves.balloon.f;
import com.skydoves.balloon.g;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: TooltipExtensions.kt */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\t\u001a\u001a\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u000c¨\u0006\r", d2 = {"buildWorkoutClickerTooltip", "Lcom/skydoves/balloon/Balloon;", "Landroidx/fragment/app/Fragment;", "tooltipView", "Landroid/view/View;", "buildWorkoutTrickTooltip", "showCalendarIntroductionTooltip", "view", "callback", "Lapp/dogo/com/dogo_android/util/extensionfunction/CalendarToolTipCallbacks;", "showClickerIntroductionTooltip", "clicker", "Lapp/dogo/com/dogo_android/util/extensionfunction/TrickDetailsClickerToolTipCallbacks;", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class n1 {
    /* renamed from: a, reason: from kotlin metadata */
    public static final Balloon showCalendarIntroductionTooltip(Fragment view, View callback) {
        n.f(view, "<this>");
        n.f(callback, "tooltipView");
        android.content.Context requireContext = view.requireContext();
        n.e(requireContext, "requireContext()");
        Balloon.a aVar = new Balloon.a(requireContext);
        aVar.q(callback);
        aVar.i(2131100336);
        aVar.j(f.FADE);
        aVar.k(12f);
        aVar.D(1f);
        int i4 = 44;
        aVar.s(i4);
        aVar.t(i4);
        aVar.o(260);
        boolean z = false;
        aVar.m(z);
        aVar.c(a.BOTTOM);
        aVar.e(c.ALIGN_ANCHOR);
        aVar.b(a.f(callback.getContext(), 2131231078));
        aVar.r(view.getViewLifecycleOwner());
        aVar.f(32);
        aVar.g(24);
        aVar.p(true);
        aVar.l(z);
        return aVar.a();
    }

    /* renamed from: b, reason: from kotlin metadata */
    public static final Balloon showClickerIntroductionTooltip(Fragment clicker, View callback) {
        n.f(clicker, "<this>");
        n.f(callback, "tooltipView");
        android.content.Context requireContext = clicker.requireContext();
        n.e(requireContext, "requireContext()");
        Balloon.a aVar = new Balloon.a(requireContext);
        aVar.q(callback);
        aVar.i(2131100336);
        aVar.j(f.FADE);
        aVar.k(12f);
        aVar.d(0.35f);
        aVar.D(1f);
        int i5 = 44;
        aVar.s(i5);
        aVar.t(i5);
        aVar.o(220);
        boolean z = false;
        aVar.m(z);
        aVar.e(c.ALIGN_ANCHOR);
        aVar.b(a.f(callback.getContext(), 2131231078));
        aVar.r(clicker.getViewLifecycleOwner());
        aVar.f(32);
        aVar.g(24);
        aVar.p(true);
        aVar.l(z);
        return aVar.a();
    }

    public static final Balloon f(Fragment fragment, View view, h1 h1Var) {
        n.f(fragment, "<this>");
        n.f(view, "view");
        n.f(h1Var, "callback");
        final boolean z2 = false;
        sn snVar = sn.T(LayoutInflater.from(fragment.getContext()), null, z2);
        n.e(snVar, "inflate(LayoutInflater.from(context), null, false)");
        android.content.Context requireContext = fragment.requireContext();
        n.e(requireContext, "requireContext()");
        Balloon.a aVar = new Balloon.a(requireContext);
        view = snVar.w();
        n.e(view, "tooltipBinding.root");
        aVar.q(view);
        aVar.i(2131100336);
        aVar.j(f.OVERSHOOT);
        aVar.k(12f);
        aVar.D(1f);
        int i5 = 44;
        aVar.s(i5);
        aVar.t(i5);
        aVar.m(z2);
        aVar.c(a.BOTTOM);
        aVar.e(c.ALIGN_BALLOON);
        aVar.b(a.f(fragment.requireContext(), 2131231078));
        aVar.r(fragment.getViewLifecycleOwner());
        aVar.f(32);
        aVar.g(24);
        aVar.l(z2);
        aVar.u(2131100375);
        boolean z = true;
        aVar.p(z);
        Balloon balloon = aVar.a();
        snVar.O.setOnClickListener(new app.dogo.com.dogo_android.util.extensionfunction.c1(h1Var, balloon));
        g.b(view, balloon, z2, (int)(TypedValue.applyDimension(z, 10f, fragment.getResources().getDisplayMetrics())));
        return balloon;
    }

    private static final void g(h1 h1Var, Balloon balloon, View view) {
        n.f(h1Var, "$callback");
        n.f(balloon, "$this_apply");
        h1Var.d();
        h1Var.setCalendarIntroductionAsCompleted();
        balloon.J();
    }

    public static final Balloon h(Fragment fragment, View view, o1 o1Var) {
        n.f(fragment, "<this>");
        n.f(view, "clicker");
        n.f(o1Var, "callback");
        final boolean z2 = false;
        un unVar = un.T(LayoutInflater.from(fragment.getContext()), null, z2);
        n.e(unVar, "inflate(LayoutInflater.from(context), null, false)");
        android.content.Context requireContext = fragment.requireContext();
        n.e(requireContext, "requireContext()");
        Balloon.a aVar = new Balloon.a(requireContext);
        view = unVar.w();
        n.e(view, "tooltipBinding.root");
        aVar.q(view);
        aVar.i(2131100336);
        aVar.j(f.OVERSHOOT);
        aVar.k(12f);
        aVar.D(1f);
        int i5 = 44;
        aVar.s(i5);
        aVar.t(i5);
        aVar.m(z2);
        aVar.c(a.BOTTOM);
        aVar.e(c.ALIGN_BALLOON);
        aVar.b(a.f(fragment.requireContext(), 2131231078));
        aVar.r(fragment.getViewLifecycleOwner());
        aVar.f(32);
        aVar.g(24);
        aVar.l(z2);
        aVar.u(2131100375);
        boolean z = true;
        aVar.p(z);
        Balloon balloon = aVar.a();
        unVar.O.setOnClickListener(new app.dogo.com.dogo_android.util.extensionfunction.d1(o1Var, balloon));
        unVar.P.setOnClickListener(new app.dogo.com.dogo_android.util.extensionfunction.e1(o1Var, balloon));
        g.b(view, balloon, z2, (int)(TypedValue.applyDimension(z, 60f, fragment.getResources().getDisplayMetrics())));
        return balloon;
    }

    private static final void i(o1 o1Var, Balloon balloon, View view) {
        n.f(o1Var, "$callback");
        n.f(balloon, "$this_apply");
        o1Var.b();
        o1Var.f();
        balloon.J();
    }

    private static final void j(o1 o1Var, Balloon balloon, View view) {
        n.f(o1Var, "$callback");
        n.f(balloon, "$this_apply");
        o1Var.c();
        o1Var.g();
        o1Var.e();
        balloon.J();
    }

    public static /* synthetic */ void c(h1 h1Var, Balloon balloon, View view) {
        app.dogo.com.dogo_android.util.extensionfunction.n1.g(h1Var, balloon, view);
    }

    public static /* synthetic */ void d(o1 o1Var, Balloon balloon, View view) {
        app.dogo.com.dogo_android.util.extensionfunction.n1.i(o1Var, balloon, view);
    }

    public static /* synthetic */ void e(o1 o1Var, Balloon balloon, View view) {
        app.dogo.com.dogo_android.util.extensionfunction.n1.j(o1Var, balloon, view);
    }
}

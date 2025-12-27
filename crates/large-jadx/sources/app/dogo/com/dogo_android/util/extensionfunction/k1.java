package app.dogo.com.dogo_android.util.h0;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.e;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.y.j;
import d.h.l.x;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.j0.h;
import kotlin.j0.i;
import nl.dionsegijn.konfetti.KonfettiView;

/* compiled from: FragmentExtentions.kt */
@Metadata(d1 = "\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0019\u0010\u0008\u001a\u0002H\t\"\u0008\u0008\u0000\u0010\t*\u00020\n*\u00020\u000b¢\u0006\u0002\u0010\u000c\u001a\u001b\u0010\r\u001a\u0004\u0018\u0001H\t\"\u0008\u0008\u0000\u0010\t*\u00020\n*\u00020\u000b¢\u0006\u0002\u0010\u000c\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u000b\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u000b\u001a\u001e\u0010\u0010\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u001a\u0012\u0010\u0015\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017\u001a\u0012\u0010\u0018\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a\u001a\n\u0010\u001b\u001a\u00020\u0001*\u00020\u000b¨\u0006\u001c", d2 = {"showSpecialProgramCertificateConfetti", "", "cardGroupView", "Landroid/view/ViewGroup;", "confettiView", "Lnl/dionsegijn/konfetti/KonfettiView;", "scrollView", "Landroidx/core/widget/NestedScrollView;", "getScreenKey", "T", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "getScreenKeyOrNull", "hideSoftKeyboard", "legacyOnBackGoToTag", "legacyShowDialog", "tag", "Lapp/dogo/com/dogo_android/enums/DialogTags;", "bundle", "Landroid/os/Bundle;", "showSoftKeyboard", "view", "Landroid/view/View;", "showZendeskTicketInboxScreen", "zendeskInfo", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "vibratePhone", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class k1 {

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "Landroidx/databinding/ViewDataBinding;", "it", "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<View, ViewDataBinding> {

        public static final k1.a a = new k1$a();
        @Override // kotlin.d0.d.p
        public final ViewDataBinding a(View view) {
            n.f(view, "it");
            return f.d(view);
        }


        a() {
            super(1);
        }
    }
    /* renamed from: a, reason: from kotlin metadata */
    public static final <T extends j> T showSoftKeyboard(Fragment view) {
        n.f(view, "<this>");
        final j jVar = app.dogo.com.dogo_android.util.extensionfunction.k1.b(view);
        n.d(jVar);
        return jVar;
    }

    /* renamed from: b, reason: from kotlin metadata */
    public static final <T extends j> T showZendeskTicketInboxScreen(Fragment zendeskInfo) {
        int i = 0;
        str = "<this>";
        n.f(zendeskInfo, str);
        Bundle arguments = zendeskInfo.getArguments();
        if (arguments == null) {
            i = 0;
        } else {
            str = "SCREEN_KEY";
            android.os.Parcelable parcelable = arguments.getParcelable(str);
        }
        return i;
    }

    public static final void c(Fragment fragment) {
        android.os.IBinder windowToken = null;
        n.f(fragment, "<this>");
        if (fragment.getContext() != null && fragment.getView() != null) {
            Context context2 = fragment.getContext();
            n.d(context2);
            Object systemService = context2.getSystemService("input_method");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            View view2 = fragment.getView();
            if (view2 == null) {
                int i2 = 0;
            } else {
                windowToken = view2.getWindowToken();
            }
            int i = 0;
            systemService.hideSoftInputFromWindow(windowToken, i);
        }
    }

    public static final void e(Fragment fragment, c cVar, Bundle bundle) {
        n.f(fragment, "<this>");
        n.f(cVar, "tag");
        app.dogo.com.dogo_android.util.e0.u uVar = a.a(cVar);
        if (uVar == null) {
            throw new RuntimeException("Dialog whit this tag was not found");
        } else {
            if (bundle != null) {
                uVar.setArguments(bundle);
                str = "style";
                if (bundle.containsKey(str)) {
                    uVar.setStyle(0, bundle.getInt(str));
                }
            }
            uVar.show(fragment.requireActivity().getSupportFragmentManager(), cVar.getTag());
            return;
        }
    }

    public static /* synthetic */ void f(Fragment fragment, c cVar, Bundle bundle, int i, Object object) {
        if (i & 2 != 0) {
            i = 0;
        }
        app.dogo.com.dogo_android.util.extensionfunction.k1.e(fragment, cVar, bundle);
    }

    /* renamed from: g, reason: from kotlin metadata */
    public static final void legacyShowDialog(Fragment tag, View bundle) {
        str = "<this>";
        n.f(tag, str);
        n.f(bundle, "view");
        if (bundle.requestFocus()) {
            Object systemService = bundle.getContext().getSystemService("input_method");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            int i = 2;
            systemService.toggleSoftInput(i, 0);
        }
    }

    public static final void h(ViewGroup viewGroup, KonfettiView konfettiView, NestedScrollView nestedScrollView) {
        n.f(viewGroup, "cardGroupView");
        n.f(konfettiView, "confettiView");
        n.f(nestedScrollView, "scrollView");
        try {
            viewGroup.postDelayed(new app.dogo.com.dogo_android.util.extensionfunction.b1(konfettiView, nestedScrollView, viewGroup), 200L);
        } catch (Exception e) {
            a.d(e);
        }
    }

    private static final void i(KonfettiView konfettiView, NestedScrollView nestedScrollView, ViewGroup viewGroup) {
        int i = 0;
        int konfettiView2;
        n.f(konfettiView, "$confettiView");
        n.f(nestedScrollView, "$scrollView");
        item = "$cardGroupView";
        n.f(viewGroup, item);
        app.dogo.com.dogo_android.util.extensionfunction.j1.a(konfettiView);
        Iterator it = i.v(x.b(viewGroup), app.dogo.com.dogo_android.util.extensionfunction.k1.a.a).iterator();
        i = 0;
        while (it.hasNext()) {
            String item = it.next();
            z = (ViewDataBinding)item instanceof sh;
        }
        konfettiView2 = 0;
        viewGroup = konfettiView2;
        nestedScrollView.H(konfettiView2, konfettiView2, 1000);
    }

    public static final void j(Fragment fragment) {
        Object systemService = null;
        str = "<this>";
        n.f(fragment, str);
        Context context = fragment.getContext();
        if (context == null) {
            int i4 = 0;
        } else {
            str = "vibrator";
            systemService = context.getSystemService(str);
        }
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        long[] lArr = new long[] {0, 250, 200, 250};
        final int i3 = -1;
        if (Build.VERSION.SDK_INT >= 26) {
            systemService.vibrate(VibrationEffect.createWaveform(lArr, i3));
        } else {
            systemService.vibrate(lArr, i3);
        }
    }

    /* renamed from: d, reason: from kotlin metadata */
    public static /* synthetic */ void showSpecialProgramCertificateConfetti(KonfettiView cardGroupView, NestedScrollView confettiView, ViewGroup scrollView) {
        app.dogo.com.dogo_android.util.extensionfunction.k1.i(cardGroupView, confettiView, scrollView);
    }
}

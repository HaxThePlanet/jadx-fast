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
import app.dogo.com.dogo_android.util.i0.a;
import d.h.l.x;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.j0.h;
import kotlin.j0.i;
import n.a.a;
import nl.dionsegijn.konfetti.KonfettiView;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0019\u0010\u0008\u001a\u0002H\t\"\u0008\u0008\u0000\u0010\t*\u00020\n*\u00020\u000b¢\u0006\u0002\u0010\u000c\u001a\u001b\u0010\r\u001a\u0004\u0018\u0001H\t\"\u0008\u0008\u0000\u0010\t*\u00020\n*\u00020\u000b¢\u0006\u0002\u0010\u000c\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u000b\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u000b\u001a\u001e\u0010\u0010\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u001a\u0012\u0010\u0015\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017\u001a\u0012\u0010\u0018\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a\u001a\n\u0010\u001b\u001a\u00020\u0001*\u00020\u000b¨\u0006\u001c", d2 = {"showSpecialProgramCertificateConfetti", "", "cardGroupView", "Landroid/view/ViewGroup;", "confettiView", "Lnl/dionsegijn/konfetti/KonfettiView;", "scrollView", "Landroidx/core/widget/NestedScrollView;", "getScreenKey", "T", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "getScreenKeyOrNull", "hideSoftKeyboard", "legacyOnBackGoToTag", "legacyShowDialog", "tag", "Lapp/dogo/com/dogo_android/enums/DialogTags;", "bundle", "Landroid/os/Bundle;", "showSoftKeyboard", "view", "Landroid/view/View;", "showZendeskTicketInboxScreen", "zendeskInfo", "Lapp/dogo/com/dogo_android/repository/domain/ZendeskConfigurationInfo;", "vibratePhone", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class k1 {

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "Landroidx/databinding/ViewDataBinding;", "it", "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<View, ViewDataBinding> {

        public static final app.dogo.com.dogo_android.util.h0.k1.a a;
        static {
            k1.a aVar = new k1.a();
            k1.a.a = aVar;
        }

        a() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final ViewDataBinding a(View view) {
            n.f(view, "it");
            return f.d(view);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((View)object);
        }
    }
    public static final <T extends app.dogo.com.dogo_android.y.j> T a(Fragment fragment) {
        n.f(fragment, "<this>");
        final app.dogo.com.dogo_android.y.j obj1 = k1.b(fragment);
        n.d(obj1);
        return obj1;
    }

    public static final <T extends app.dogo.com.dogo_android.y.j> T b(Fragment fragment) {
        String str;
        int obj1;
        n.f(fragment, "<this>");
        obj1 = fragment.getArguments();
        if (obj1 == null) {
            obj1 = 0;
        } else {
            obj1 = obj1.getParcelable("SCREEN_KEY");
        }
        return obj1;
    }

    public static final void c(Fragment fragment) {
        Object systemService;
        int i;
        int obj2;
        n.f(fragment, "<this>");
        if (fragment.getContext() != null && fragment.getView() != null) {
            if (fragment.getView() != null) {
                Context context = fragment.getContext();
                n.d(context);
                systemService = context.getSystemService("input_method");
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                obj2 = fragment.getView();
                if (obj2 == null) {
                    obj2 = 0;
                } else {
                    obj2 = obj2.getWindowToken();
                }
                (InputMethodManager)systemService.hideSoftInputFromWindow(obj2, 0);
            }
        }
    }

    public static void d(KonfettiView konfettiView, NestedScrollView nestedScrollView2, ViewGroup viewGroup3) {
        k1.i(konfettiView, nestedScrollView2, viewGroup3);
    }

    public static final void e(Fragment fragment, c c2, Bundle bundle3) {
        String str;
        boolean key;
        Bundle obj5;
        n.f(fragment, "<this>");
        n.f(c2, "tag");
        app.dogo.com.dogo_android.util.e0.u uVar = a.a(c2);
        if (uVar == null) {
        } else {
            uVar.setArguments(bundle3);
            str = "style";
            if (bundle3 != null && bundle3.containsKey(str)) {
                uVar.setArguments(bundle3);
                str = "style";
                if (bundle3.containsKey(str)) {
                    uVar.setStyle(0, bundle3.getInt(str));
                }
            }
            uVar.show(fragment.requireActivity().getSupportFragmentManager(), c2.getTag());
        }
        RuntimeException obj3 = new RuntimeException("Dialog whit this tag was not found");
        throw obj3;
    }

    public static void f(Fragment fragment, c c2, Bundle bundle3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        k1.e(fragment, c2, obj2);
    }

    public static final void g(Fragment fragment, View view2) {
        String str;
        boolean obj1;
        Object obj2;
        n.f(fragment, "<this>");
        n.f(view2, "view");
        if (view2.requestFocus()) {
            obj1 = view2.getContext().getSystemService("input_method");
            Objects.requireNonNull(obj1, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            (InputMethodManager)obj1.toggleSoftInput(2, 0);
        }
    }

    public static final void h(ViewGroup viewGroup, KonfettiView konfettiView2, NestedScrollView nestedScrollView3) {
        Object obj1;
        n.f(viewGroup, "cardGroupView");
        n.f(konfettiView2, "confettiView");
        n.f(nestedScrollView3, "scrollView");
        b1 b1Var = new b1(konfettiView2, nestedScrollView3, viewGroup);
        viewGroup.postDelayed(b1Var, 200);
    }

    private static final void i(KonfettiView konfettiView, NestedScrollView nestedScrollView2, ViewGroup viewGroup3) {
        String next;
        boolean z;
        int obj4;
        n.f(konfettiView, "$confettiView");
        n.f(nestedScrollView2, "$scrollView");
        n.f(viewGroup3, "$cardGroupView");
        j1.a(konfettiView);
        Iterator obj2 = i.v(x.b(viewGroup3), k1.a.a).iterator();
        obj4 = 0;
        while (obj2.hasNext()) {
            next = obj2.next();
            if (str3 instanceof sh) {
            }
            obj4 = next;
        }
        obj2 = 0;
        if ((ViewDataBinding)obj4 == 0) {
            obj4 = obj2;
        } else {
        }
        nestedScrollView2.H(obj2, obj4, 1000);
    }

    public static final void j(Fragment fragment) {
        String str;
        long[] lArr;
        int obj4;
        n.f(fragment, "<this>");
        obj4 = fragment.getContext();
        if (obj4 == null) {
            obj4 = 0;
        } else {
            obj4 = obj4.getSystemService("vibrator");
        }
        Objects.requireNonNull(obj4, "null cannot be cast to non-null type android.os.Vibrator");
        lArr = new long[4];
        lArr = new long[]{0L, 250L, 200L, 250L};
        final int i3 = -1;
        if (Build.VERSION.SDK_INT >= 26) {
            (Vibrator)obj4.vibrate(VibrationEffect.createWaveform(lArr, i3));
        } else {
            obj4.vibrate(lArr, i3);
        }
    }
}

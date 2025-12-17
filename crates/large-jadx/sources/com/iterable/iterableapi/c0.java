package com.iterable.iterableapi;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import d.h.f.a;

/* loaded from: classes2.dex */
public class c0 extends d implements com.iterable.iterableapi.b1.a {

    static com.iterable.iterableapi.c0 C;
    static com.iterable.iterableapi.w D;
    static com.iterable.iterableapi.e0 E;
    private double A;
    private String B;
    private com.iterable.iterableapi.a1 a;
    private boolean b = false;
    private OrientationEventListener c;
    private boolean v = false;
    private String w;
    private String x;
    private Rect y;
    private boolean z;

    class a extends Dialog {

        final com.iterable.iterableapi.c0 a;
        a(com.iterable.iterableapi.c0 c0, Context context2, int i3) {
            this.a = c0;
            super(context2, i3);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            this.a.Q1();
            c0.B1(this.a);
        }
    }

    class b implements DialogInterface.OnCancelListener {

        final com.iterable.iterableapi.c0 a;
        b(com.iterable.iterableapi.c0 c0) {
            this.a = c0;
            super();
        }

        @Override // android.content.DialogInterface$OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            int i;
            boolean obj2;
            obj2 = c0.D;
            if (c0.C1(this.a) && obj2 != null) {
                obj2 = c0.D;
                if (obj2 != null) {
                    obj2.a(0);
                }
            }
        }
    }

    class c extends OrientationEventListener {

        final com.iterable.iterableapi.c0 a;
        c(com.iterable.iterableapi.c0 c0, Context context2, int i3) {
            this.a = c0;
            super(context2, i3);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            com.iterable.iterableapi.c0.c.a aVar;
            int i2;
            boolean obj4;
            if (c0.D1(this.a)) {
                obj4 = new Handler();
                aVar = new c0.c.a(this);
                obj4.postDelayed(aVar, 1000);
            }
        }
    }

    class d implements Runnable {

        final com.iterable.iterableapi.c0 a;
        d(com.iterable.iterableapi.c0 c0) {
            this.a = c0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object context;
            if (this.a.getContext() != null && this.a.getDialog() != null && this.a.getDialog().getWindow() != null) {
                if (this.a.getDialog() != null) {
                    if (this.a.getDialog().getWindow() != null) {
                        c0.F1(this.a);
                        c0.G1(this.a);
                    }
                }
            }
        }
    }

    class e implements Runnable {

        final com.iterable.iterableapi.c0 a;
        e(com.iterable.iterableapi.c0 c0) {
            this.a = c0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object context;
            if (this.a.getContext() != null && this.a.getDialog() != null && this.a.getDialog().getWindow() != null) {
                if (this.a.getDialog() != null) {
                    if (this.a.getDialog().getWindow() != null) {
                        this.a.dismissAllowingStateLoss();
                    }
                }
            }
        }
    }

    class f implements Runnable {

        final Activity a;
        final float b;
        final com.iterable.iterableapi.c0 c;
        f(com.iterable.iterableapi.c0 c0, Activity activity2, float f3) {
            this.c = c0;
            this.a = activity2;
            this.b = f3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object layoutParams;
            Context context;
            Rect top;
            com.iterable.iterableapi.a1 a1Var;
            int i;
            float density;
            try {
                context = c0.C;
                if (this.c.getContext() != null && context != null && context.getDialog() != null && c0.C.getDialog().getWindow() != null && !c0.C.getDialog().isShowing()) {
                }
                context = c0.C;
                if (context != null) {
                }
                if (context.getDialog() != null) {
                }
                if (c0.C.getDialog().getWindow() != null) {
                }
                if (!c0.C.getDialog().isShowing()) {
                }
                this.a.getResources().getDisplayMetrics();
                top = c0.H1(c0.C);
                Display defaultDisplay = (WindowManager)this.c.getContext().getSystemService("window").getDefaultDisplay();
                Point point = new Point();
                if (Build.VERSION.SDK_INT >= 17) {
                } else {
                }
                defaultDisplay.getRealSize(point);
                defaultDisplay.getSize(point);
                if (top.bottom == 0 && top.top == 0) {
                } else {
                }
                if (top.top == 0) {
                } else {
                }
                c0.C.getDialog().getWindow().setLayout(point.x, point.y);
                a1Var = 1024;
                this.c.getDialog().getWindow().setFlags(a1Var, a1Var);
                layoutParams = new RelativeLayout.LayoutParams(displayMetrics.widthPixels, (int)i2);
                c0.E1(this.c).setLayoutParams(layoutParams);
                j0.d("IterableInAppFragmentHTMLNotification", "Exception while trying to resize an in-app message", th);
            }
        }
    }

    static class g {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            c0.g.a = iArr;
            iArr[c.TOP.ordinal()] = 1;
            c0.g.a[c.CENTER.ordinal()] = 2;
            c0.g.a[c.FULLSCREEN.ordinal()] = 3;
            c0.g.a[c.BOTTOM.ordinal()] = 4;
        }
    }
    public c0() {
        super();
        int i = 0;
        this.x = "";
        Rect rect = new Rect();
        this.y = rect;
        setStyle(2, g1.a);
    }

    static void B1(com.iterable.iterableapi.c0 c0) {
        c0.P1();
    }

    static boolean C1(com.iterable.iterableapi.c0 c0) {
        return c0.v;
    }

    static boolean D1(com.iterable.iterableapi.c0 c0) {
        return c0.b;
    }

    static com.iterable.iterableapi.a1 E1(com.iterable.iterableapi.c0 c0) {
        return c0.a;
    }

    static void F1(com.iterable.iterableapi.c0 c0) {
        c0.U1();
    }

    static void G1(com.iterable.iterableapi.c0 c0) {
        c0.T1();
    }

    static Rect H1(com.iterable.iterableapi.c0 c0) {
        return c0.y;
    }

    private void I1(Drawable drawable, Drawable drawable2) {
        Object dialog;
        Object obj3;
        Object obj4;
        if (drawable != null) {
            if (drawable2 == null) {
            } else {
                if (getDialog() != null && getDialog().getWindow() == null) {
                    if (getDialog().getWindow() == null) {
                    }
                    Drawable[] arr = new Drawable[2];
                    obj3 = 1;
                    arr[obj3] = drawable2;
                    obj4 = new TransitionDrawable(arr);
                    obj4.setCrossFadeEnabled(obj3);
                    getDialog().getWindow().setBackgroundDrawable(obj4);
                    obj4.startTransition(300);
                }
                j0.c("IterableInAppFragmentHTMLNotification", "Dialog or Window not present. Skipping background animation");
            }
        }
    }

    public static com.iterable.iterableapi.c0 J1(String string, boolean z2, com.iterable.iterableapi.w w3, com.iterable.iterableapi.e0 e04, String string5, Double double6, Rect rect7, boolean z8, com.iterable.iterableapi.g0.b g0$b9) {
        c0 c0Var = new c0();
        c0.C = c0Var;
        Bundle bundle = new Bundle();
        bundle.putString("HTML", string);
        bundle.putBoolean("CallbackOnCancel", z2);
        bundle.putString("MessageId", string5);
        bundle.putDouble("BackgroundAlpha", double6.doubleValue());
        bundle.putParcelable("InsetPadding", rect7);
        final String obj3 = "InAppBgColor";
        bundle.putString(obj3, b9.a);
        bundle.putDouble("InAppBgAlpha", b9.b);
        bundle.putBoolean("ShouldAnimate", z8);
        c0.D = w3;
        c0.E = e04;
        c0.C.setArguments(bundle);
        return c0.C;
    }

    private ColorDrawable K1() {
        String str = this.B;
        if (str == null) {
            j0.a("IterableInAppFragmentHTMLNotification", "Background Color does not exist. In App background animation will not be performed");
            return null;
        }
        ColorDrawable colorDrawable = new ColorDrawable(a.i(Color.parseColor(str), (int)i3));
        return colorDrawable;
    }

    public static com.iterable.iterableapi.c0 M1() {
        return c0.C;
    }

    private void O1() {
        ColorDrawable colorDrawable2 = new ColorDrawable(0);
        I1(K1(), colorDrawable2);
    }

    private void P1() {
        boolean animation;
        int i2;
        com.iterable.iterableapi.a1 a1Var2;
        com.iterable.iterableapi.a1 a1Var;
        int i;
        if (this.z) {
            int i3 = c0.g.a[L1(this.y).ordinal()];
            if (i3 != 1) {
                if (i3 != 2 && i3 != 3) {
                    if (i3 != 3) {
                        i2 = i3 != 4 ? e1.c : e1.a;
                    } else {
                        i2 = e1.c;
                    }
                } else {
                }
            } else {
                i2 = e1.f;
            }
            animation = AnimationUtils.loadAnimation(getContext(), i2);
            animation.setDuration(500);
            this.a.startAnimation(animation);
        }
        O1();
        c0.e eVar = new c0.e(this);
        final int i6 = 400;
        if (Build.VERSION.SDK_INT >= 16) {
            this.a.postOnAnimationDelayed(eVar, i6);
        } else {
            this.a.postDelayed(eVar, i6);
        }
    }

    private void R1() {
        com.iterable.iterableapi.a1 a1Var;
        com.iterable.iterableapi.c0.d dVar;
        try {
            this.a.setAlpha(0);
            dVar = new c0.d(this);
            this.a.postDelayed(dVar, 500);
            j0.c("IterableInAppFragmentHTMLNotification", "View not present. Failed to hide before resizing inapp");
        }
    }

    private void S1() {
        boolean z;
        com.iterable.iterableapi.g0 g0Var = j.p.q().k(this.x);
        if (g0Var == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Message with id ");
            stringBuilder.append(this.x);
            stringBuilder.append(" does not exist");
            j0.c("IterableInAppFragmentHTMLNotification", stringBuilder.toString());
        }
        if (g0Var.p() && !g0Var.n()) {
            if (!g0Var.n()) {
                j.p.q().y(g0Var);
            }
        }
    }

    private void T1() {
        boolean animation;
        int i3;
        int i2;
        int i;
        this.a.setAlpha(1065353216);
        this.a.setVisibility(0);
        if (this.z) {
            int i4 = c0.g.a[L1(this.y).ordinal()];
            if (i4 != 1) {
                if (i4 != 2 && i4 != 3) {
                    if (i4 != 3) {
                        i3 = i4 != 4 ? e1.b : e1.e;
                    } else {
                        i3 = e1.b;
                    }
                } else {
                }
            } else {
                i3 = e1.d;
            }
            animation = AnimationUtils.loadAnimation(getContext(), i3);
            animation.setDuration(500);
            this.a.startAnimation(animation);
        }
    }

    private void U1() {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        I1(colorDrawable, K1());
    }

    @Override // androidx.fragment.app.d
    com.iterable.iterableapi.c L1(Rect rect) {
        int bottom;
        Object obj3;
        final int top = rect.top;
        if (top == 0 && rect.bottom == 0) {
            if (rect.bottom == 0) {
                return c.FULLSCREEN;
            }
        }
        if (top == 0 && rect.bottom < 0) {
            if (rect.bottom < 0) {
                return c.TOP;
            }
        }
        if (top < 0 && rect.bottom == 0) {
            if (rect.bottom == 0) {
                return c.BOTTOM;
            }
        }
        return c.CENTER;
    }

    @Override // androidx.fragment.app.d
    int N1(Rect rect) {
        int bottom;
        int obj3;
        final int top = rect.top;
        if (top == 0 && rect.bottom < 0) {
            if (rect.bottom < 0) {
                obj3 = 48;
            } else {
                if (top < 0 && rect.bottom == 0) {
                    obj3 = rect.bottom == 0 ? 80 : 16;
                } else {
                }
            }
        } else {
        }
        return obj3;
    }

    @Override // androidx.fragment.app.d
    public void Q1() {
        final String str3 = "itbl://backButton";
        j.p.V(this.x, str3);
        j.p.Y(this.x, str3, y.BACK, c0.E);
        S1();
    }

    @Override // androidx.fragment.app.d
    public void X0(String string) {
        Object obj5;
        j.p.W(this.x, string, c0.E);
        j.p.Y(this.x, string, y.LINK, c0.E);
        com.iterable.iterableapi.w wVar = c0.D;
        if (wVar != null) {
            wVar.a(Uri.parse(string));
        }
        S1();
        P1();
    }

    @Override // androidx.fragment.app.d
    public void onCreate(Bundle bundle) {
        String str;
        int i;
        double double;
        Bundle obj5;
        super.onCreate(bundle);
        obj5 = getArguments();
        if (obj5 != null) {
            i = 0;
            this.w = obj5.getString("HTML", i);
            this.v = obj5.getBoolean("CallbackOnCancel", false);
            this.x = obj5.getString("MessageId");
            obj5.getDouble("BackgroundAlpha");
            this.y = (Rect)obj5.getParcelable("InsetPadding");
            this.A = obj5.getDouble("InAppBgAlpha");
            this.B = obj5.getString("InAppBgColor", i);
            this.z = obj5.getBoolean("ShouldAnimate");
        }
        c0.C = this;
    }

    @Override // androidx.fragment.app.d
    public Dialog onCreateDialog(Bundle bundle) {
        Object window;
        int tOP;
        c0.a obj3 = new c0.a(this, getActivity(), getTheme());
        c0.b bVar = new c0.b(this);
        obj3.setOnCancelListener(bVar);
        obj3.requestWindowFeature(1);
        if (L1(this.y) == c.FULLSCREEN) {
            tOP = 1024;
            obj3.getWindow().setFlags(tOP, tOP);
        } else {
            if (L1(this.y) != c.TOP) {
                tOP = 67108864;
                obj3.getWindow().setFlags(tOP, tOP);
            }
        }
        return obj3;
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        com.iterable.iterableapi.e0 i2;
        int i;
        Object obj3;
        com.iterable.iterableapi.c obj4;
        String obj5;
        i2 = 0;
        obj4 = new ColorDrawable(i2);
        getDialog().getWindow().setBackgroundDrawable(obj4);
        if (L1(this.y) == c.FULLSCREEN) {
            obj4 = 1024;
            getDialog().getWindow().setFlags(obj4, obj4);
        }
        obj3 = new a1(getContext());
        this.a = obj3;
        obj3.setId(f1.a);
        this.a.a(this, this.w);
        this.a.addJavascriptInterface(this, "ITBL");
        if (this.c == null) {
            obj3 = new c0.c(this, getContext(), 3);
            this.c = obj3;
        }
        this.c.enable();
        obj3 = new RelativeLayout(getContext());
        int i3 = -1;
        obj4 = new RelativeLayout.LayoutParams(i3, i3);
        obj3.setVerticalGravity(N1(this.y));
        obj3.addView(this.a, obj4);
        if (bundle3 != null) {
            if (!bundle3.getBoolean("InAppOpenTracked", i2)) {
                j.p.b0(this.x, c0.E);
            }
        } else {
        }
        R1();
        return obj3;
    }

    @Override // androidx.fragment.app.d
    public void onDestroy() {
        androidx.fragment.app.e changingConfigurations;
        super.onDestroy();
        if (getActivity() != null && getActivity().isChangingConfigurations()) {
            if (getActivity().isChangingConfigurations()) {
            }
        }
        int i = 0;
        c0.C = i;
        c0.D = i;
        c0.E = i;
    }

    @Override // androidx.fragment.app.d
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("InAppOpenTracked", true);
    }

    @Override // androidx.fragment.app.d
    public void onStop() {
        this.c.disable();
        super.onStop();
    }

    @JavascriptInterface
    public void resize(float f) {
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        }
        c0.f fVar = new c0.f(this, activity, f);
        activity.runOnUiThread(fVar);
    }

    @Override // androidx.fragment.app.d
    public void z0(boolean z) {
        this.b = z;
    }
}

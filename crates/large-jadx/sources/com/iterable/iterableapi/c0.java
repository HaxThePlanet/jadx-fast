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
import android.util.DisplayMetrics;
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

/* compiled from: IterableInAppFragmentHTMLNotification.java */
/* loaded from: classes2.dex */
public class c0 extends d implements b1.a {

    static c0 C;
    static w D;
    static e0 E;
    private double A;
    private String B;
    private a1 a;
    private boolean b = false;
    private OrientationEventListener c;
    private boolean v = false;
    private String w;
    private String x = "";
    private Rect y = new Rect();
    private boolean z;

    class a extends Dialog {

        final /* synthetic */ c0 a;
        a(Context context, int i) {
            this.a = c0Var;
            super(context, i);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            this.a.Q1();
            this.a.P1();
        }
    }

    class b implements DialogInterface.OnCancelListener {

        final /* synthetic */ c0 a;
        b() {
            this.a = c0Var;
            super();
        }

        @Override // android.content.DialogInterface$OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (this.a.v && c0.D != null) {
                Uri uri = null;
                c0.D.a(uri);
            }
        }
    }

    class c extends OrientationEventListener {

        final /* synthetic */ c0 a;
        c(Context context, int i) {
            this.a = c0Var;
            super(context, i);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            if (this.a.b) {
                long l = 1000L;
                new Handler().postDelayed(new c0.c.a(this), l);
            }
        }
    }

    class d implements Runnable {

        final /* synthetic */ c0 a;
        d() {
            this.a = c0Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.getContext() != null) {
                if (this.a.getDialog() != null) {
                    if (this.a.getDialog().getWindow() != null) {
                        this.a.U1();
                        this.a.T1();
                    }
                }
            }
        }
    }

    class e implements Runnable {

        final /* synthetic */ c0 a;
        e() {
            this.a = c0Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.getContext() != null) {
                if (this.a.getDialog() != null) {
                    if (this.a.getDialog().getWindow() != null) {
                        this.a.dismissAllowingStateLoss();
                    }
                }
            }
        }
    }

    class f implements Runnable {

        final /* synthetic */ Activity a;
        final /* synthetic */ float b;
        final /* synthetic */ c0 c;
        f(Activity activity, float f) {
            this.c = c0Var;
            this.a = activity;
            this.b = f;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.iterable.iterableapi.c0 c0Var2 = c0.C;
                this.a.getResources().getDisplayMetrics();
                Rect rect = c0.C.y;
                Display defaultDisplay = (WindowManager)this.c.getContext().getSystemService("window").getDefaultDisplay();
                Point point = new Point();
                if (Build.VERSION.SDK_INT >= 17) {
                    defaultDisplay.getRealSize(point);
                } else {
                    defaultDisplay.getSize(point);
                }
                c0.C.getDialog().getWindow().setLayout(point.x, point.y);
                int i2 = 1024;
                this.c.getDialog().getWindow().setFlags(i2, i2);
                i = (int)(this.b * this.c.getResources().getDisplayMetrics().density);
                this.c.a.setLayoutParams(new RelativeLayout.LayoutParams(this.c.getResources().getDisplayMetrics().widthPixels, i));
            } catch (java.lang.IllegalArgumentException iae) {
                j0.d("IterableInAppFragmentHTMLNotification", "Exception while trying to resize an in-app message", iae);
            }
        }
    }

    static class g {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[c.values().length];
            c0.g.a = iArr;
            try {
                iArr[c.TOP.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                c0.g.a[c.CENTER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                c0.g.a[c.FULLSCREEN.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                c0.g.a[c.BOTTOM.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    public c0() {
        super();
        Rect rect = new Rect();
        setStyle(2, g1.a);
    }

    static /* synthetic */ void B1(c0 c0Var) {
        c0Var.P1();
    }

    static /* synthetic */ boolean C1(c0 c0Var) {
        return c0Var.v;
    }

    static /* synthetic */ boolean D1(c0 c0Var) {
        return c0Var.b;
    }

    static /* synthetic */ a1 E1(c0 c0Var) {
        return c0Var.a;
    }

    static /* synthetic */ void F1(c0 c0Var) {
        c0Var.U1();
    }

    static /* synthetic */ void G1(c0 c0Var) {
        c0Var.T1();
    }

    static /* synthetic */ Rect H1(c0 c0Var) {
        return c0Var.y;
    }

    private void I1(Drawable drawable, Drawable drawable2) {
        Dialog dialog;
    }

    public static c0 J1(String str, boolean z, w wVar, e0 e0Var, String str2, Double double, Rect rect, boolean z2, g0.b bVar) {
        c0.C = new c0();
        Bundle bundle = new Bundle();
        bundle.putString("HTML", str);
        bundle.putBoolean("CallbackOnCancel", z);
        bundle.putString("MessageId", str2);
        bundle.putDouble("BackgroundAlpha", double.doubleValue());
        bundle.putParcelable("InsetPadding", rect);
        final String str9 = "InAppBgColor";
        bundle.putString(str9, bVar.a);
        bundle.putDouble("InAppBgAlpha", bVar.b);
        bundle.putBoolean("ShouldAnimate", z2);
        c0.D = wVar;
        c0.E = e0Var;
        c0.C.setArguments(bundle);
        return c0.C;
    }

    private ColorDrawable K1() {
        if (this.B == null) {
            j0.a("IterableInAppFragmentHTMLNotification", "Background Color does not exist. In App background animation will not be performed");
            return null;
        }
        try {
        } catch (java.lang.IllegalArgumentException unused) {
            StringBuilder stringBuilder = new StringBuilder();
            String str5 = "Background color could not be identified for input string \"";
            str5 = "\". Failed to load in-app background.";
            stringBuilder = this.B + this.B + this.B;
            j0.c(str3, stringBuilder);
            return obj;
        }
        return new ColorDrawable(a.i(Color.parseColor(this.B), (int)(this.A * 255d)));
    }

    public static c0 M1() {
        return c0.C;
    }

    private void O1() {
        I1(K1(), new ColorDrawable(0));
    }

    private void P1() throws android.content.res.Resources.NotFoundException {
        int i;
        int i2 = 2;
        if (this.z) {
            int i3 = c0.g.a[L1(this.y).ordinal()];
            i2 = 1;
            if (this.z == 1) {
                i = e1.f;
            } else {
                i2 = 2;
                if (this.y == 2 || this.y == 3) {
                    i = e1.c;
                } else {
                    i2 = 4;
                    int r0 = this.y != 4 ? e1.c : e1.a;
                }
            }
            r0 = AnimationUtils.loadAnimation(this.getContext(), (this.y != 4 ? e1.c : e1.a));
            r0.setDuration(500L);
            this.a.startAnimation(r0);
        }
        O1();
        com.iterable.iterableapi.c0.e eVar = new c0.e(this);
        final long l = 400L;
        if (Build.VERSION.SDK_INT >= 16) {
            this.a.postOnAnimationDelayed(eVar, l);
        } else {
            this.a.postDelayed(eVar, l);
        }
    }

    private void R1() {
        try {
            this.a.setAlpha(0.0f);
            this.a.postDelayed(new c0.d(this), 500L);
        } catch (java.lang.NullPointerException unused) {
            j0.c("IterableInAppFragmentHTMLNotification", "View not present. Failed to hide before resizing inapp");
        }
    }

    private void S1() {
        com.iterable.iterableapi.g0 g0Var = j.p.q().k(this.x);
        if (g0Var == null) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "Message with id ";
            String str5 = " does not exist";
            str = str3 + this.x + str5;
            j0.c("IterableInAppFragmentHTMLNotification", str);
            return;
        }
        if (g0Var.p() && !g0Var.n()) {
            j.p.q().y(g0Var);
        }
    }

    private void T1() throws android.content.res.Resources.NotFoundException {
        int i;
        int i3 = 2;
        this.a.setAlpha(1f);
        int i2 = 0;
        this.a.setVisibility(i2);
        if (this.z) {
            int i4 = c0.g.a[L1(this.y).ordinal()];
            i3 = 1;
            if (this.a == 1) {
                i = e1.d;
            } else {
                i3 = 2;
                if (this.a == 2 || this.a == 3) {
                    i = e1.b;
                } else {
                    i3 = 4;
                    int r0 = this.a != 4 ? e1.b : e1.e;
                }
            }
            r0 = AnimationUtils.loadAnimation(this.getContext(), (this.a != 4 ? e1.b : e1.e));
            r0.setDuration(500L);
            this.a.startAnimation(r0);
        }
    }

    private void U1() {
        I1(new ColorDrawable(0), K1());
    }

    @Override // androidx.fragment.app.d
    c L1(Rect rect) {
        int bottom2;
        if (rect.top == 0 && rect.bottom == 0) {
            return c.FULLSCREEN;
        }
        if (rect.top == 0 && rect.bottom < 0) {
            return c.TOP;
        }
        if (rect.top < 0 && rect.bottom == 0) {
            return c.BOTTOM;
        }
        return c.CENTER;
    }

    @Override // androidx.fragment.app.d
    int N1(Rect rect) {
        int bottom2;
        int i = 16;
        if (rect.top != 0 || rect.bottom >= 0) {
            rect = rect.top < 0 && rect.bottom == 0 ? 80 : 16;
        } else {
            rect = 48;
        }
        return (rect.top < 0 && rect.bottom == 0 ? 80 : 16);
    }

    @Override // androidx.fragment.app.d
    public void Q1() {
        final String str3 = "itbl://backButton";
        j.p.V(this.x, str3);
        j.p.Y(this.x, str3, y.BACK, c0.E);
        S1();
    }

    @Override // androidx.fragment.app.d
    public void X0(String str) {
        j.p.W(this.x, str, c0.E);
        j.p.Y(this.x, str, y.LINK, c0.E);
        com.iterable.iterableapi.w wVar = c0.D;
        if (c0.D != null) {
            c0.D.a(Uri.parse(str));
        }
        S1();
        P1();
    }

    @Override // androidx.fragment.app.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String str2 = null;
            this.w = arguments.getString("HTML", str2);
            this.v = arguments.getBoolean("CallbackOnCancel", false);
            this.x = arguments.getString("MessageId");
            arguments.getDouble("BackgroundAlpha");
            this.y = (Rect)arguments.getParcelable("InsetPadding");
            this.A = arguments.getDouble("InAppBgAlpha");
            this.B = arguments.getString("InAppBgColor", str2);
            str = "ShouldAnimate";
            this.z = arguments.getBoolean(str);
        }
        c0.C = this;
    }

    @Override // androidx.fragment.app.d
    public Dialog onCreateDialog(Bundle bundle) {
        final com.iterable.iterableapi.c0.a aVar = new c0.a(this, getActivity(), getTheme());
        aVar.setOnCancelListener(new c0.b(this));
        aVar.requestWindowFeature(1);
        if (L1(this.y) == c.FULLSCREEN) {
            int i = 1024;
            aVar.getWindow().setFlags(i, i);
        } else {
            if (L1(this.y) != c.TOP) {
                i = 67108864;
                aVar.getWindow().setFlags(i, i);
            }
        }
        return aVar;
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = 0;
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(i2));
        if (L1(this.y) == c.FULLSCREEN) {
            int i6 = 1024;
            getDialog().getWindow().setFlags(i6, i6);
        }
        com.iterable.iterableapi.a1 a1Var2 = new a1(getContext());
        this.a = a1Var2;
        a1Var2.setId(f1.a);
        this.a.a(this, this.w);
        str = "ITBL";
        this.a.addJavascriptInterface(this, str);
        if (this.c == null) {
            int i = 3;
            this.c = new c0.c(this, getContext(), i);
        }
        this.c.enable();
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        int i3 = -1;
        relativeLayout.setVerticalGravity(N1(this.y));
        relativeLayout.addView(this.a, new RelativeLayout.LayoutParams(i3, i3));
        if (bundle != null) {
            if (!bundle.getBoolean("InAppOpenTracked", false)) {
                j.p.b0(this.x, c0.E);
            }
        }
        R1();
        return relativeLayout;
    }

    @Override // androidx.fragment.app.d
    public void onDestroy() {
        super.onDestroy();
        if (getActivity() != null) {
            if (getActivity().isChangingConfigurations()) {
                return;
            }
        }
        com.iterable.iterableapi.c0 c0Var = null;
        c0.C = c0Var;
        c0.D = c0Var;
        c0.E = c0Var;
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
    @Override // androidx.fragment.app.d
    public void resize(float f) {
        final androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new c0.f(this, activity, f));
    }

    @Override // androidx.fragment.app.d
    public void z0(boolean z) {
        this.b = z;
    }
}

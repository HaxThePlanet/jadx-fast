package zendesk.belvedere;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zendesk.belvedere.b0.d;

/* loaded from: classes3.dex */
public class p extends FrameLayout {

    private final int a;
    private int b = -1;
    private int c = -1;
    private boolean v;
    private List<WeakReference<zendesk.belvedere.p.c>> w;
    private zendesk.belvedere.p.d x;
    private EditText y;

    static class a implements Runnable {

        final EditText a;
        a(EditText editText) {
            this.a = editText;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean systemService;
            Object str;
            int i;
            systemService = this.a.getContext().getSystemService("input_method");
            if (this.a.requestFocus() && (InputMethodManager)systemService != null) {
                systemService = this.a.getContext().getSystemService("input_method");
                if ((InputMethodManager)(InputMethodManager)systemService != null) {
                    (InputMethodManager)(InputMethodManager)systemService.showSoftInput(this.a, 1);
                }
            }
        }
    }

    private class b implements ViewTreeObserver.OnGlobalLayoutListener {

        private final Activity a;
        final zendesk.belvedere.p b;
        private b(zendesk.belvedere.p p, Activity activity2) {
            this.b = p;
            super();
            this.a = activity2;
        }

        b(zendesk.belvedere.p p, Activity activity2, zendesk.belvedere.p.a p$a3) {
            super(p, activity2);
        }

        @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onGlobalLayout() {
            zendesk.belvedere.p pVar;
            zendesk.belvedere.p pVar2;
            int i;
            int i2 = p.a(this.b, this.a);
            i = i2 > 0 ? 1 : 0;
            p.b(this.b, i);
            p.d(this.b, i2);
            if (i2 > 0 && p.c(this.b) != i2 && p.e(this.b) != null) {
                if (p.c(this.b) != i2) {
                    p.d(this.b, i2);
                    if (p.e(this.b) != null) {
                        p.e(this.b).a(i2);
                    }
                }
            }
            if (p.f(this.b) != null && i2 > 0) {
                if (i2 > 0) {
                    p.g(this.b);
                } else {
                    p.h(this.b);
                }
            } else {
            }
        }
    }

    public interface c {
        public abstract void onKeyboardDismissed();

        public abstract void onKeyboardVisible();
    }

    interface d {
        public abstract void a(int i);
    }
    private p(Activity activity) {
        super(activity);
        int i = -1;
        ArrayList arrayList = new ArrayList();
        this.w = arrayList;
        this.a = getStatusBarHeight();
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(d.b);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        setLayoutParams(layoutParams);
        EditText editText = new EditText(activity);
        this.y = editText;
        int i3 = 1;
        editText.setFocusable(i3);
        this.y.setFocusableInTouchMode(i3);
        this.y.setVisibility(0);
        this.y.setImeOptions(268435456);
        this.y.setInputType(16384);
        addView(this.y);
        p.b bVar = new p.b(this, activity, 0);
        activity.getWindow().getDecorView().findViewById(16908290).getViewTreeObserver().addOnGlobalLayoutListener(bVar);
    }

    static int a(zendesk.belvedere.p p, Activity activity2) {
        return p.j(activity2);
    }

    static boolean b(zendesk.belvedere.p p, boolean z2) {
        p.v = z2;
        return z2;
    }

    static int c(zendesk.belvedere.p p) {
        return p.c;
    }

    static int d(zendesk.belvedere.p p, int i2) {
        p.c = i2;
        return i2;
    }

    static zendesk.belvedere.p.d e(zendesk.belvedere.p p) {
        return p.x;
    }

    static List f(zendesk.belvedere.p p) {
        return p.w;
    }

    static void g(zendesk.belvedere.p p) {
        p.n();
    }

    private int getCachedInset() {
        int viewInset;
        if (this.b == -1) {
            this.b = getViewInset();
        }
        return this.b;
    }

    private int getStatusBarHeight() {
        int dimensionPixelSize;
        Object resources;
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            dimensionPixelSize = getResources().getDimensionPixelSize(identifier);
        } else {
            dimensionPixelSize = 0;
        }
        return dimensionPixelSize;
    }

    private int getViewInset() {
        int sDK_INT;
        int i;
        Field declaredField = View.class.getDeclaredField("mAttachInfo");
        i = 1;
        declaredField.setAccessible(i);
        sDK_INT = declaredField.get(this);
        if (Build.VERSION.SDK_INT >= 21 && sDK_INT != null) {
            declaredField = View.class.getDeclaredField("mAttachInfo");
            i = 1;
            declaredField.setAccessible(i);
            sDK_INT = declaredField.get(this);
            if (sDK_INT != null) {
                Field declaredField2 = sDK_INT.getClass().getDeclaredField("mStableInsets");
                declaredField2.setAccessible(i);
                return obj2.bottom;
            }
        }
        return 0;
    }

    private int getViewPortHeight() {
        return i -= cachedInset;
    }

    static void h(zendesk.belvedere.p p) {
        p.m();
    }

    private int j(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return obj3 -= i;
    }

    static void k(Activity activity) {
        Object systemService;
        String str;
        Object obj2;
        obj2 = activity.getCurrentFocus();
        systemService = obj2.getContext().getSystemService("input_method");
        if (obj2 != null && (InputMethodManager)systemService != null) {
            systemService = obj2.getContext().getSystemService("input_method");
            if ((InputMethodManager)(InputMethodManager)systemService != null) {
                (InputMethodManager)(InputMethodManager)systemService.hideSoftInputFromWindow(obj2.getWindowToken(), 0);
            }
        }
    }

    public static zendesk.belvedere.p l(Activity activity) {
        int i;
        boolean z;
        View decorView = activity.getWindow().getDecorView();
        i = 0;
        while (i < (ViewGroup)decorView.getChildCount()) {
            i++;
        }
        p pVar = new p(activity);
        decorView.addView(pVar);
        return pVar;
    }

    private void m() {
        Object next;
        Object obj;
        Iterator iterator = this.w.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((WeakReference)next.get() != null) {
            }
            (p.c)next.get().onKeyboardDismissed();
        }
    }

    private void n() {
        Object next;
        Object obj;
        Iterator iterator = this.w.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((WeakReference)next.get() != null) {
            }
            (p.c)next.get().onKeyboardVisible();
        }
    }

    static void o(EditText editText) {
        p.a aVar = new p.a(editText);
        editText.post(aVar);
    }

    @Override // android.widget.FrameLayout
    public EditText getInputTrap() {
        return this.y;
    }

    @Override // android.widget.FrameLayout
    public int getKeyboardHeight() {
        return this.c;
    }

    @Override // android.widget.FrameLayout
    public void i(zendesk.belvedere.p.c p$c) {
        WeakReference weakReference = new WeakReference(c);
        this.w.add(weakReference);
    }

    @Override // android.widget.FrameLayout
    void setKeyboardHeightListener(zendesk.belvedere.p.d p$d) {
        this.x = d;
    }
}

package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import d.a.d;
import d.a.f;
import d.a.g;
import d.a.i;

/* loaded from: classes.dex */
class x0 {

    private final Context a;
    private final View b;
    private final TextView c;
    private final WindowManager.LayoutParams d;
    private final Rect e;
    private final int[] f;
    private final int[] g;
    x0(Context context) {
        super();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.d = layoutParams;
        Rect rect = new Rect();
        this.e = rect;
        int i = 2;
        this.f = new int[i];
        this.g = new int[i];
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(g.s, 0);
        this.b = inflate;
        this.c = (TextView)inflate.findViewById(f.s);
        layoutParams.setTitle(x0.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        int obj5 = -2;
        layoutParams.width = obj5;
        layoutParams.height = obj5;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.a;
        layoutParams.flags = 24;
    }

    private void a(View view, int i2, int i3, boolean z4, WindowManager.LayoutParams windowManager$LayoutParams5) {
        int dimensionPixelOffset;
        int height;
        int i;
        Rect heightPixels;
        int dimensionPixelSize;
        Rect rect;
        int widthPixels;
        int obj9;
        int obj10;
        int obj11;
        layoutParams5.token = view.getApplicationWindowToken();
        dimensionPixelOffset = this.a.getResources().getDimensionPixelOffset(d.j);
        if (view.getWidth() >= dimensionPixelOffset) {
        } else {
            obj10 /= 2;
        }
        int i7 = 0;
        if (view.getHeight() >= dimensionPixelOffset) {
            dimensionPixelOffset = this.a.getResources().getDimensionPixelOffset(d.i);
            height = i3 + dimensionPixelOffset;
            i3 -= dimensionPixelOffset;
        } else {
            height = view.getHeight();
            obj11 = i7;
        }
        layoutParams5.gravity = 49;
        i = z4 ? d.l : d.k;
        int dimensionPixelOffset2 = this.a.getResources().getDimensionPixelOffset(i);
        View view2 = x0.b(view);
        if (view2 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
        }
        view2.getWindowVisibleDisplayFrame(this.e);
        heightPixels = this.e;
        if (heightPixels.left < 0 && heightPixels.top < 0) {
            if (heightPixels.top < 0) {
                Resources resources4 = this.a.getResources();
                int identifier = resources4.getIdentifier("status_bar_height", "dimen", "android");
                if (identifier != 0) {
                    dimensionPixelSize = resources4.getDimensionPixelSize(identifier);
                } else {
                    dimensionPixelSize = i7;
                }
                android.util.DisplayMetrics displayMetrics = resources4.getDisplayMetrics();
                this.e.set(i7, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        }
        view2.getLocationOnScreen(this.g);
        view.getLocationOnScreen(this.f);
        obj9 = this.f;
        int[] iArr3 = this.g;
        obj9[i7] = i12 -= i16;
        int i14 = 1;
        obj9[i14] = i17 -= i15;
        layoutParams5.x = obj9 -= obj10;
        obj9 = View.MeasureSpec.makeMeasureSpec(i7, i7);
        this.b.measure(obj9, obj9);
        obj9 = this.b.getMeasuredHeight();
        obj10 = this.f;
        i10 -= obj9;
        obj10 += dimensionPixelOffset2;
        if (z4) {
            if (i11 >= 0) {
                layoutParams5.y = i11;
            } else {
                layoutParams5.y = obj10;
            }
        } else {
            if (obj9 += obj10 <= this.e.height()) {
                layoutParams5.y = obj10;
            } else {
                layoutParams5.y = i11;
            }
        }
    }

    private static View b(View view) {
        android.view.ViewGroup.LayoutParams layoutParams;
        boolean z;
        Context obj3;
        final View rootView = view.getRootView();
        layoutParams = rootView.getLayoutParams();
        if (layoutParams instanceof WindowManager.LayoutParams && layoutParams.type == 2) {
            if (layoutParams.type == 2) {
                return rootView;
            }
        }
        obj3 = view.getContext();
        while (obj3 instanceof ContextWrapper) {
            obj3 = (ContextWrapper)obj3.getBaseContext();
        }
        return rootView;
    }

    void c() {
        if (!d()) {
        }
        (WindowManager)this.a.getSystemService("window").removeView(this.b);
    }

    boolean d() {
        int i;
        i = this.b.getParent() != null ? 1 : 0;
        return i;
    }

    void e(View view, int i2, int i3, boolean z4, java.lang.CharSequence charSequence5) {
        if (d()) {
            c();
        }
        this.c.setText(charSequence5);
        this.a(view, i2, i3, z4, this.d);
        (WindowManager)this.a.getSystemService("window").addView(this.b, this.d);
    }
}

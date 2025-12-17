package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.e.f;
import androidx.core.content.e.f.c;
import d.a.k.a.a;

/* loaded from: classes.dex */
public class t0 {

    private final Context a;
    private final TypedArray b;
    private TypedValue c;
    private t0(Context context, TypedArray typedArray2) {
        super();
        this.a = context;
        this.b = typedArray2;
    }

    public static androidx.appcompat.widget.t0 t(Context context, int i2, int[] i3Arr3) {
        t0 t0Var = new t0(context, context.obtainStyledAttributes(i2, i3Arr3));
        return t0Var;
    }

    public static androidx.appcompat.widget.t0 u(Context context, AttributeSet attributeSet2, int[] i3Arr3) {
        t0 t0Var = new t0(context, context.obtainStyledAttributes(attributeSet2, i3Arr3));
        return t0Var;
    }

    public static androidx.appcompat.widget.t0 v(Context context, AttributeSet attributeSet2, int[] i3Arr3, int i4, int i5) {
        t0 t0Var = new t0(context, context.obtainStyledAttributes(attributeSet2, i3Arr3, i4, i5));
        return t0Var;
    }

    public boolean a(int i, boolean z2) {
        return this.b.getBoolean(i, z2);
    }

    public int b(int i, int i2) {
        return this.b.getColor(i, i2);
    }

    public ColorStateList c(int i) {
        boolean resourceId;
        int i2;
        resourceId = this.b.getResourceId(i, 0);
        resourceId = a.c(this.a, resourceId);
        if (this.b.hasValue(i) && resourceId != 0 && resourceId != null) {
            resourceId = this.b.getResourceId(i, 0);
            if (resourceId != 0) {
                resourceId = a.c(this.a, resourceId);
                if (resourceId != null) {
                    return resourceId;
                }
            }
        }
        return this.b.getColorStateList(i);
    }

    public float d(int i, float f2) {
        return this.b.getDimension(i, f2);
    }

    public int e(int i, int i2) {
        return this.b.getDimensionPixelOffset(i, i2);
    }

    public int f(int i, int i2) {
        return this.b.getDimensionPixelSize(i, i2);
    }

    public Drawable g(int i) {
        boolean resourceId;
        int i2;
        resourceId = this.b.getResourceId(i, 0);
        if (this.b.hasValue(i) && resourceId != 0) {
            resourceId = this.b.getResourceId(i, 0);
            if (resourceId != 0) {
                return a.d(this.a, resourceId);
            }
        }
        return this.b.getDrawable(i);
    }

    public Drawable h(int i) {
        boolean value;
        int i2;
        int obj4;
        obj4 = this.b.getResourceId(i, 0);
        if (this.b.hasValue(i) && obj4 != null) {
            obj4 = this.b.getResourceId(i, 0);
            if (obj4 != null) {
                return i.b().d(this.a, obj4, true);
            }
        }
        return null;
    }

    public float i(int i, float f2) {
        return this.b.getFloat(i, f2);
    }

    public Typeface j(int i, int i2, f.c f$c3) {
        TypedValue typedValue;
        int obj3 = this.b.getResourceId(i, 0);
        if (obj3 == null) {
            return null;
        }
        if (this.c == null) {
            typedValue = new TypedValue();
            this.c = typedValue;
        }
        return f.h(this.a, obj3, this.c, i2, c3);
    }

    public int k(int i, int i2) {
        return this.b.getInt(i, i2);
    }

    public int l(int i, int i2) {
        return this.b.getInteger(i, i2);
    }

    public int m(int i, int i2) {
        return this.b.getLayoutDimension(i, i2);
    }

    public int n(int i, int i2) {
        return this.b.getResourceId(i, i2);
    }

    public String o(int i) {
        return this.b.getString(i);
    }

    public java.lang.CharSequence p(int i) {
        return this.b.getText(i);
    }

    public java.lang.CharSequence[] q(int i) {
        return this.b.getTextArray(i);
    }

    public TypedArray r() {
        return this.b;
    }

    public boolean s(int i) {
        return this.b.hasValue(i);
    }

    public void w() {
        this.b.recycle();
    }
}

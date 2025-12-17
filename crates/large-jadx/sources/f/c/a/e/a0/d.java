package f.c.a.e.a0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.e.f;
import androidx.core.content.e.f.c;
import f.c.a.e.l;

/* loaded from: classes2.dex */
public class d {

    public final ColorStateList a;
    public final String b;
    public final int c;
    public final int d;
    public final float e;
    public final float f;
    public final float g;
    public final boolean h;
    public final float i = 0f;
    private ColorStateList j;
    private float k;
    private final int l;
    private boolean m = false;
    private Typeface n;

    class a extends f.c {

        final f.c.a.e.a0.f a;
        final f.c.a.e.a0.d b;
        a(f.c.a.e.a0.d d, f.c.a.e.a0.f f2) {
            this.b = d;
            this.a = f2;
            super();
        }

        @Override // androidx.core.content.e.f$c
        public void d(int i) {
            d.c(this.b, true);
            this.a.a(i);
        }

        @Override // androidx.core.content.e.f$c
        public void e(Typeface typeface) {
            f.c.a.e.a0.d dVar = this.b;
            d.b(dVar, Typeface.create(typeface, dVar.c));
            d.c(this.b, true);
            this.a.b(d.a(this.b), false);
        }
    }

    class b extends f.c.a.e.a0.f {

        final TextPaint a;
        final f.c.a.e.a0.f b;
        final f.c.a.e.a0.d c;
        b(f.c.a.e.a0.d d, TextPaint textPaint2, f.c.a.e.a0.f f3) {
            this.c = d;
            this.a = textPaint2;
            this.b = f3;
            super();
        }

        @Override // f.c.a.e.a0.f
        public void a(int i) {
            this.b.a(i);
        }

        @Override // f.c.a.e.a0.f
        public void b(Typeface typeface, boolean z2) {
            this.c.p(this.a, typeface);
            this.b.b(typeface, z2);
        }
    }
    public d(Context context, int i2) {
        boolean value;
        Object obj6;
        float obj7;
        super();
        value = 0;
        TypedArray styledAttributes = context.obtainStyledAttributes(i2, l.V4);
        final int i12 = 0;
        l(styledAttributes.getDimension(l.W4, i12));
        k(c.a(context, styledAttributes, l.Z4));
        c.a(context, styledAttributes, l.a5);
        c.a(context, styledAttributes, l.b5);
        this.c = styledAttributes.getInt(l.Y4, value);
        this.d = styledAttributes.getInt(l.X4, 1);
        int i5 = c.e(styledAttributes, l.h5, l.g5);
        this.l = styledAttributes.getResourceId(i5, value);
        this.b = styledAttributes.getString(i5);
        styledAttributes.getBoolean(l.i5, value);
        this.a = c.a(context, styledAttributes, l.c5);
        this.e = styledAttributes.getFloat(l.d5, i12);
        this.f = styledAttributes.getFloat(l.e5, i12);
        this.g = styledAttributes.getFloat(l.f5, i12);
        styledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            obj6 = context.obtainStyledAttributes(i2, l.k3);
            obj7 = l.l3;
            this.h = obj6.hasValue(obj7);
            this.i = obj6.getFloat(obj7, i12);
            obj6.recycle();
        } else {
            this.h = value;
        }
    }

    static Typeface a(f.c.a.e.a0.d d) {
        return d.n;
    }

    static Typeface b(f.c.a.e.a0.d d, Typeface typeface2) {
        d.n = typeface2;
        return typeface2;
    }

    static boolean c(f.c.a.e.a0.d d, boolean z2) {
        d.m = z2;
        return z2;
    }

    private void d() {
        Object create;
        Typeface create2;
        Typeface sANS_SERIF;
        int i;
        int i2;
        create = this.b;
        if (this.n == null && create != null) {
            create = this.b;
            if (create != null) {
                this.n = Typeface.create(create, this.c);
            }
        }
        if (this.n == null) {
            int i3 = this.d;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        this.n = Typeface.DEFAULT;
                    } else {
                        this.n = Typeface.MONOSPACE;
                    }
                } else {
                    this.n = Typeface.SERIF;
                }
            } else {
                this.n = Typeface.SANS_SERIF;
            }
            this.n = Typeface.create(this.n, this.c);
        }
    }

    private boolean m(Context context) {
        int i;
        Typeface obj3;
        if (e.a()) {
            return 1;
        }
        int i2 = this.l;
        if (i2 != 0) {
            obj3 = f.c(context, i2);
        } else {
            obj3 = 0;
        }
        if (obj3 != null) {
        } else {
            i = 0;
        }
        return i;
    }

    public Typeface e() {
        d();
        return this.n;
    }

    public Typeface f(Context context) {
        boolean restricted;
        String str;
        Object obj3;
        if (this.m) {
            return this.n;
        }
        obj3 = f.g(context, this.l);
        this.n = obj3;
        if (!context.isRestricted() && obj3 != null) {
            obj3 = f.g(context, this.l);
            this.n = obj3;
            if (obj3 != null) {
                this.n = Typeface.create(obj3, this.c);
            }
        }
        d();
        this.m = true;
        return this.n;
    }

    public void g(Context context, TextPaint textPaint2, f.c.a.e.a0.f f3) {
        p(textPaint2, e());
        d.b bVar = new d.b(this, textPaint2, f3);
        h(context, bVar);
    }

    public void h(Context context, f.c.a.e.a0.f f2) {
        int i;
        f.c.a.e.a0.d.a aVar;
        Context obj5;
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        i = this.l;
        final int i2 = 1;
        if (i == 0) {
            this.m = i2;
        }
        if (this.m) {
            f2.b(this.n, i2);
        }
        aVar = new d.a(this, f2);
        f.i(context, i, aVar, 0);
    }

    public ColorStateList i() {
        return this.j;
    }

    public float j() {
        return this.k;
    }

    public void k(ColorStateList colorStateList) {
        this.j = colorStateList;
    }

    public void l(float f) {
        this.k = f;
    }

    public void n(Context context, TextPaint textPaint2, f.c.a.e.a0.f f3) {
        int defaultColor2;
        int colorForState;
        int[] drawableState;
        int defaultColor;
        int obj5;
        int[] obj7;
        o(context, textPaint2, f3);
        obj5 = this.j;
        if (obj5 != null) {
            obj5 = obj5.getColorForState(textPaint2.drawableState, obj5.getDefaultColor());
        } else {
            obj5 = -16777216;
        }
        textPaint2.setColor(obj5);
        ColorStateList list = this.a;
        if (list != null) {
            colorForState = list.getColorForState(textPaint2.drawableState, list.getDefaultColor());
        } else {
            colorForState = 0;
        }
        textPaint2.setShadowLayer(this.g, this.e, this.f, colorForState);
    }

    public void o(Context context, TextPaint textPaint2, f.c.a.e.a0.f f3) {
        Object obj2;
        if (m(context)) {
            p(textPaint2, f(context));
        } else {
            g(context, textPaint2, f3);
        }
    }

    public void p(TextPaint textPaint, Typeface typeface2) {
        int i;
        int obj3;
        textPaint.setTypeface(typeface2);
        obj3 &= i2;
        i = obj3 & 1 != 0 ? 1 : 0;
        textPaint.setFakeBoldText(i);
        obj3 = obj3 &= 2 != 0 ? -1098907648 : 0;
        textPaint.setTextSkewX(obj3);
        textPaint.setTextSize(this.k);
        if (Build.VERSION.SDK_INT >= 21 && this.h) {
            if (this.h) {
                textPaint.setLetterSpacing(this.i);
            }
        }
    }
}

package f.c.a.e.a0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.e.f;
import androidx.core.content.e.f.c;
import f.c.a.e.l;

/* compiled from: TextAppearance.java */
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

        final /* synthetic */ f a;
        final /* synthetic */ d b;
        a(f fVar) {
            this.b = dVar;
            this.a = fVar;
            super();
        }

        @Override // androidx.core.content.e.f$c
        public void d(int i) {
            this.b.m = 1;
            this.a.a(i);
        }

        @Override // androidx.core.content.e.f$c
        public void e(Typeface typeface) {
            this.b.n = Typeface.create(typeface, dVar.c);
            this.b.m = 1;
            this.a.b(this.b.n, false);
        }
    }

    class b extends f {

        final /* synthetic */ TextPaint a;
        final /* synthetic */ f b;
        final /* synthetic */ d c;
        b(TextPaint textPaint, f fVar) {
            this.c = dVar;
            this.a = textPaint;
            this.b = fVar;
            super();
        }

        @Override // f.c.a.e.a0.f
        public void a(int i) {
            this.b.a(i);
        }

        @Override // f.c.a.e.a0.f
        public void b(Typeface typeface, boolean z) {
            this.c.p(this.a, typeface);
            this.b.b(typeface, z);
        }
    }
    public d(Context context, int i) throws Resources.NotFoundException {
        super();
        i = 0;
        TypedArray styledAttributes2 = context.obtainStyledAttributes(i, l.V4);
        final float f = 0.0f;
        l(styledAttributes2.getDimension(l.W4, f));
        k(c.a(context, styledAttributes2, l.Z4));
        c.a(context, styledAttributes2, l.a5);
        c.a(context, styledAttributes2, l.b5);
        this.c = styledAttributes2.getInt(l.Y4, i);
        this.d = styledAttributes2.getInt(l.X4, 1);
        int i6 = c.e(styledAttributes2, l.h5, l.g5);
        this.l = styledAttributes2.getResourceId(i6, i);
        this.b = styledAttributes2.getString(i6);
        styledAttributes2.getBoolean(l.i5, false);
        this.a = c.a(context, styledAttributes2, l.c5);
        this.e = styledAttributes2.getFloat(l.d5, f);
        this.f = styledAttributes2.getFloat(l.e5, f);
        this.g = styledAttributes2.getFloat(l.f5, f);
        styledAttributes2.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray styledAttributes = context.obtainStyledAttributes(i, l.k3);
            int i15 = l.l3;
            this.h = styledAttributes.hasValue(i15);
            this.i = styledAttributes.getFloat(i15, 0.0f);
            styledAttributes.recycle();
        } else {
            this.h = false;
        }
    }

    static /* synthetic */ Typeface a(d dVar) {
        return dVar.n;
    }

    static /* synthetic */ Typeface b(d dVar, Typeface typeface) {
        dVar.n = typeface;
        return typeface;
    }

    static /* synthetic */ boolean c(d dVar, boolean z) {
        dVar.m = z;
        return z;
    }

    private void d() {
        int i;
        if (this.n == null && this.b != null) {
            this.n = Typeface.create(this.b, this.c);
        }
        if (this.n == null) {
            int i2 = 1;
            if (this.d == 1) {
                this.n = Typeface.SANS_SERIF;
            } else {
                i2 = 2;
                if (this.d == 2) {
                    this.n = Typeface.SERIF;
                } else {
                    i2 = 3;
                    if (this.d != 3) {
                        this.n = Typeface.DEFAULT;
                    } else {
                        this.n = Typeface.MONOSPACE;
                    }
                }
            }
            this.n = Typeface.create(this.n, this.c);
        }
    }

    private boolean m(Context context) {
        boolean z = false;
        Typeface typeface = null;
        z = true;
        if (e.a()) {
            return true;
        }
        if (this.l != 0) {
            typeface = f.c(context, this.l);
        } else {
            int i3 = 0;
        }
        if (typeface == null) {
            int i2 = 0;
        }
        return z;
    }

    public Typeface e() {
        d();
        return this.n;
    }

    public Typeface f(Context context) {
        if (this.m) {
            return this.n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typeface = f.g(context, this.l);
                this.n = typeface;
                this.n = Typeface.create(typeface, this.c);
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Error loading font ";
                stringBuilder = this.b + this.b;
                str = "TextAppearance";
                Log.d(this.b, stringBuilder, e);
            } catch (java.lang.UnsupportedOperationException | android.content.res.Resources.NotFoundException unused) {
                d();
                this.m = true;
                return this.n;
            }
        }
    }

    public void g(Context context, TextPaint textPaint, f fVar) {
        p(textPaint, e());
        h(context, new d.b(this, textPaint, fVar));
    }

    public void h(Context context, f fVar) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        final boolean z3 = true;
        if (this.l == 0) {
            this.m = z3;
        }
        if (this.m) {
            fVar.b(this.n, z3);
            return;
        }
        try {
            f.i(context, this.l, new d.a(this, fVar), null);
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Error loading font ";
            stringBuilder = this.b + this.b;
            str = "TextAppearance";
            Log.d(this.b, stringBuilder, e);
            this.m = z2;
            e = -3;
            fVar.a(e);
        } catch (android.content.res.Resources.NotFoundException unused) {
            this.m = z2;
            fVar.a(z2);
        }
    }

    public ColorStateList i() {
        return this.j;
    }

    public float j() {
        return this.k;
    }

    public void k(ColorStateList list) {
        this.j = list;
    }

    public void l(float f) {
        this.k = f;
    }

    public void n(Context context, TextPaint textPaint, f fVar) {
        int colorForState = 0;
        int colorForState2 = -16777216;
        o(context, textPaint, fVar);
        if (this.j != null) {
            colorForState2 = this.j.getColorForState(textPaint.drawableState, this.j.getDefaultColor());
        } else {
            colorForState2 = -16777216;
        }
        textPaint.setColor(colorForState2);
        if (this.a != null) {
            colorForState = this.a.getColorForState(textPaint.drawableState, this.a.getDefaultColor());
        } else {
            colorForState = 0;
        }
        textPaint.setShadowLayer(this.g, this.e, this.f, colorForState);
    }

    public void o(Context context, TextPaint textPaint, f fVar) {
        if (m(context)) {
            p(textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void p(TextPaint textPaint, Typeface typeface) {
        boolean z = false;
        int i = 0;
        textPaint.setTypeface(typeface);
        int i8 = ~typeface.getStyle() & this.c;
        int r0 = i8 & 1 != 0 ? 1 : 0;
        textPaint.setFakeBoldText((i8 & 1 != 0 ? 1 : 0));
        typeface = i8 & 2 != 0 ? -1098907648 : 0;
        textPaint.setTextSkewX((i8 & 2 != 0 ? -1098907648 : 0));
        textPaint.setTextSize((i8 & 2 != 0 ? -1098907648 : 0));
        if (Build.VERSION.SDK_INT >= 21 && this.h) {
            textPaint.setLetterSpacing(this.i);
        }
    }
}

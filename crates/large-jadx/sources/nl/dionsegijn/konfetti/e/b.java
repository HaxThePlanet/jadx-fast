package nl.dionsegijn.konfetti.e;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public interface b {

    public static final nl.dionsegijn.konfetti.e.b.c a;

    public static final class a implements nl.dionsegijn.konfetti.e.b {

        private static final RectF b;
        public static final nl.dionsegijn.konfetti.e.b.a c;
        static {
            b.a aVar = new b.a();
            b.a.c = aVar;
            RectF rectF = new RectF();
            b.a.b = rectF;
        }

        @Override // nl.dionsegijn.konfetti.e.b
        public void a(Canvas canvas, Paint paint2, float f3) {
            n.f(canvas, "canvas");
            n.f(paint2, "paint");
            RectF rectF = b.a.b;
            final int i = 0;
            rectF.set(i, i, f3, f3);
            canvas.drawOval(rectF, paint2);
        }
    }

    public static final class b implements nl.dionsegijn.konfetti.e.b {

        private final float b = 0f;
        private final Drawable c;
        private final boolean d;
        public b(Drawable drawable, boolean z2) {
            int obj3;
            n.f(drawable, "drawable");
            super();
            this.c = drawable;
            this.d = z2;
            int i = -1;
            if (drawable.getIntrinsicHeight() == i && drawable.getIntrinsicWidth() == i) {
                int obj2 = drawable.getIntrinsicWidth() == i ? 1065353216 : obj2;
            }
            if (drawable.getIntrinsicHeight() != i && drawable.getIntrinsicWidth() == i) {
                if (drawable.getIntrinsicWidth() != i) {
                    obj2 = obj3 / obj2;
                }
            }
            obj2 = 0;
        }

        public static nl.dionsegijn.konfetti.e.b.b c(nl.dionsegijn.konfetti.e.b.b b$b, Drawable drawable2, boolean z3, int i4, Object object5) {
            Drawable obj1;
            boolean obj2;
            if (i4 & 1 != 0) {
                obj1 = b.c;
            }
            if (i4 &= 2 != 0) {
                obj2 = b.d;
            }
            return b.b(obj1, obj2);
        }

        @Override // nl.dionsegijn.konfetti.e.b
        public void a(Canvas canvas, Paint paint2, float f3) {
            Drawable drawable;
            PorterDuff.Mode sRC_IN;
            int obj5;
            n.f(canvas, "canvas");
            n.f(paint2, "paint");
            if (this.d) {
                this.c.setColorFilter(paint2.getColor(), PorterDuff.Mode.SRC_IN);
            } else {
                this.c.setAlpha(paint2.getAlpha());
            }
            obj5 = (int)obj5;
            int i3 = (int)i2;
            this.c.setBounds(0, i3, (int)f3, obj5 += i3);
            this.c.draw(canvas);
        }

        @Override // nl.dionsegijn.konfetti.e.b
        public final nl.dionsegijn.konfetti.e.b.b b(Drawable drawable, boolean z2) {
            n.f(drawable, "drawable");
            b.b bVar = new b.b(drawable, z2);
            return bVar;
        }

        @Override // nl.dionsegijn.konfetti.e.b
        public final Drawable d() {
            return this.c;
        }

        @Override // nl.dionsegijn.konfetti.e.b
        public boolean equals(Object object) {
            boolean z;
            Drawable drawable;
            Object obj3;
            if (this != (b.b)object && object instanceof b.b && n.b(this.c, object.c) && this.d == object.d) {
                if (object instanceof b.b) {
                    if (n.b(this.c, object.c)) {
                        if (this.d == object.d) {
                        }
                    }
                }
                return 0;
            }
            return 1;
        }

        @Override // nl.dionsegijn.konfetti.e.b
        public int hashCode() {
            int i;
            boolean z;
            Drawable drawable = this.c;
            if (drawable != null) {
                i = drawable.hashCode();
            } else {
                i = 0;
            }
            if (this.d) {
                z = 1;
            }
            return i2 += z;
        }

        @Override // nl.dionsegijn.konfetti.e.b
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DrawableShape(drawable=");
            stringBuilder.append(this.c);
            stringBuilder.append(", tint=");
            stringBuilder.append(this.d);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    public static final class c implements nl.dionsegijn.konfetti.e.b {

        public static final nl.dionsegijn.konfetti.e.b.c b;
        static {
            b.c cVar = new b.c();
            b.c.b = cVar;
        }

        @Override // nl.dionsegijn.konfetti.e.b
        public void a(Canvas canvas, Paint paint2, float f3) {
            n.f(canvas, "canvas");
            n.f(paint2, "paint");
            canvas.drawRect(0, 0, f3, f3, paint2);
        }
    }
    static {
        b.a = b.c.b;
        nl.dionsegijn.konfetti.e.b.a aVar = b.a.c;
    }

    public abstract void a(Canvas canvas, Paint paint2, float f3);
}

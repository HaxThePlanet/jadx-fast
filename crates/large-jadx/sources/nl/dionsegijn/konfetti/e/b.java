package nl.dionsegijn.konfetti.e;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import kotlin.d0.d.n;

/* compiled from: Shape.kt */
/* loaded from: classes3.dex */
public interface b {

    public static final b.c a;

    public static final class a implements b {

        private static final RectF b = new RectF();
        public static final b.a c = new b$a();

        private a() {
            super();
        }

        public void a(Canvas canvas, Paint paint, float f) {
            n.f(canvas, "canvas");
            n.f(paint, "paint");
            RectF rectF = b.a.b;
            f = 0.0f;
            rectF.set(f, f, f, f);
            canvas.drawOval(rectF, paint);
        }
    }

    public static final class b implements b {

        private final float b = 0f;
        private final Drawable c;
        private final boolean d;
        public b(Drawable drawable, boolean z) {
            n.f(drawable, "drawable");
            super();
            this.c = drawable;
            this.d = z;
            int i = -1;
            int i3 = drawable.getIntrinsicHeight() == i && drawable.getIntrinsicWidth() == i ? 1065353216 : i3;
        }

        public void a(Canvas canvas, Paint paint, float f) {
            n.f(canvas, "canvas");
            n.f(paint, "paint");
            if (this.d) {
                this.c.setColorFilter(paint.getColor(), PorterDuff.Mode.SRC_IN);
            } else {
                this.c.setAlpha(paint.getAlpha());
            }
            float paint22 = this.b * f;
            int i = (int)(f - paint22) / 2f;
            this.c.setBounds(0, i, (int)f, (int)paint22 + i);
            this.c.draw(canvas);
        }

        public final Drawable d() {
            return this.c;
        }

        public static /* synthetic */ b.b c(b.b bVar, Drawable drawable, boolean z, int i, Object object) {
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            return bVar.b(drawable, z);
        }

        public final b.b b(Drawable drawable, boolean z) {
            n.f(drawable, "drawable");
            return new b.b(drawable, z);
        }

        @Override // java.lang.Object
        public boolean equals(Object object) {
            if (this != object) {
                z = object instanceof b.b;
                return false;
            }
            return true;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i = 0;
            boolean z = true;
            if (this.c != null) {
                i = this.c.hashCode();
            } else {
                i = 0;
            }
            if (this.d) {
                int i4 = 1;
            }
            return (i * 31) + z;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "DrawableShape(drawable=";
            String str3 = ", tint=";
            String str4 = ")";
            str = str2 + this.c + str3 + this.d + str4;
            return str;
        }
    }

    public static final class c implements b {

        public static final b.c b = new b$c();

        private c() {
            super();
        }

        public void a(Canvas canvas, Paint paint, float f) {
            n.f(canvas, "canvas");
            n.f(paint, "paint");
            canvas.drawRect(0.0f, 0.0f, f, f, paint);
        }
    }
    static {
        b.a = b.c.b;
    }

    void a(Canvas canvas, Paint paint, float f);
}

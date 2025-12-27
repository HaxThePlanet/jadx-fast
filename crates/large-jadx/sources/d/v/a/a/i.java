package d.v.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.core.content.e.b;
import androidx.core.content.e.f;
import d.h.f.c;
import d.h.f.c.b;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VectorDrawableCompat.java */
/* loaded from: classes.dex */
public class i extends h {

    static final PorterDuff.Mode B;
    private final Rect A = new Rect();
    private i.h b;
    private PorterDuffColorFilter c;
    private ColorFilter v;
    private boolean w;
    private boolean x = true;
    private final float[] y;
    private final Matrix z = new Matrix();

    static class a {
    }

    private static abstract class e {
        private e() {
            super();
        }

        /* synthetic */ e(i.a aVar) {
            this();
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    private static class g {

        private static final Matrix q = new Matrix();
        private final Path a = new Path();
        private final Path b = new Path();
        private final Matrix c = new Matrix();
        Paint d;
        Paint e;
        private PathMeasure f;
        private int g;
        final i.d h = new i$d();
        float i = 0f;
        float j = 0f;
        float k = 0f;
        float l = 0f;
        int m = 255;
        String n = null;
        Boolean o = null;
        final d.e.a<String, Object> p = new a<>();

        public g() {
            super();
            Matrix matrix = new Matrix();
            d.e.a aVar = new a();
            d.v.a.a.i.d dVar = new i.d();
            Path path = new Path();
            Path path2 = new Path();
        }

        private void c(i.d dVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            boolean z;
            Object obj2;
            Object obj;
            Canvas canvas32;
            int i42;
            int i52;
            ColorFilter colorFilter62;
            dVar.a.set(matrix);
            dVar.a.preConcat(dVar.j);
            canvas.save();
            i = 0;
            while (dVar.a < dVar.b.size()) {
                Matrix item = dVar.b.get(i);
                z = item instanceof i.d;
                i = i + 1;
            }
            canvas.restore();
        }

        private void d(i.d dVar, i.f fVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            PathMeasure pathMeasure;
            float length;
            PathMeasure pathMeasure3;
            float f;
            Path.FillType wINDING2;
            boolean z3 = false;
            Path.FillType eVEN_ODD2;
            int rounded;
            float f4 = 1132396544;
            float f22 = (float)i / this.k;
            float f28 = (float)i2 / this.l;
            this.c.set(dVar.a);
            this.c.postScale(f22, f28);
            float f18 = e(dVar.a);
            float f3 = 0.0f;
            if (f18 == 0.0f) {
                return;
            }
            fVar.d(this.a);
            this.b.reset();
            if (fVar.c()) {
                fVar = fVar.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                this.b.setFillType((fVar.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD));
                this.b.addPath(this.a, (fVar.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD));
                canvas.clipPath(this.b);
            } else {
                float f13 = 1f;
                boolean z2 = true;
                if (f7 == 0.0f) {
                    if (f12 != f13) {
                        if (this.f == null) {
                            this.f = new PathMeasure();
                        }
                        z3 = false;
                        this.f.setPath(this.a, z3);
                        length = this.f.getLength();
                        float f10 = (f7 + f11) % f13 * length;
                        f = (fVar.l + f11) % f13 * length;
                        this.a.reset();
                        if (this.c > fVar.l + f11) {
                            this.f.getSegment(f10, length, this.a, z2);
                            this.f.getSegment(0.0f, f, this.a, z2);
                        } else {
                            this.f.getSegment(f10, f, this.a, z2);
                        }
                        this.a.rLineTo(0.0f, 0.0f);
                    }
                }
                this.b.addPath(this.a, this.c);
                f4 = 255f;
                i = 255;
                Shader shader = null;
                if (fVar.h.l()) {
                    if (this.e == null) {
                        Paint paint2 = new Paint(z2);
                        this.e = paint2;
                        paint2.setStyle(Paint.Style.FILL);
                    }
                    if (fVar.h.h()) {
                        Shader shader3 = fVar.h.f();
                        shader3.setLocalMatrix(this.c);
                        this.e.setShader(shader3);
                        this.e.setAlpha(Math.round(fVar.j * f4));
                    } else {
                        this.e.setShader(shader);
                        this.e.setAlpha(i);
                        this.e.setColor(i.a(fVar.h.e(), fVar.j));
                    }
                    this.e.setColorFilter(colorFilter);
                    Path.FillType r5 = fVar.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    this.b.setFillType((fVar.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD));
                    canvas.drawPath(this.b, this.e);
                }
                if (fVar.f.l()) {
                    if (this.d == null) {
                        Paint paint = new Paint(z2);
                        this.d = paint;
                        paint.setStyle(Paint.Style.STROKE);
                    }
                    if (fVar.o != null) {
                        this.d.setStrokeJoin(fVar.o);
                    }
                    if (fVar.n != null) {
                        this.d.setStrokeCap(fVar.n);
                    }
                    this.d.setStrokeMiter(fVar.p);
                    if (fVar.f.h()) {
                        Shader shader2 = fVar.f.f();
                        shader2.setLocalMatrix(this.c);
                        this.d.setShader(shader2);
                        this.d.setAlpha(Math.round(fVar.i * f4));
                    } else {
                        this.d.setShader(shader);
                        this.d.setAlpha(i);
                        this.d.setColor(i.a(fVar.f.e(), fVar.i));
                    }
                    this.d.setColorFilter(colorFilter);
                    min = (Math.min(f22, f28)) * f18;
                    this.d.setStrokeWidth(fVar.g * min);
                    canvas.drawPath(this.b, this.d);
                }
            }
        }

        private float e(Matrix matrix) {
            float f = 0;
            float[] fArr = new float[] {0, 1065353216, 1065353216, 0};
            matrix.mapVectors(fArr);
            int i6 = 0;
            int i4 = 1;
            int i2 = 2;
            final int i5 = 3;
            float max = Math.max((float)(Math.hypot((double)fArr[i6], (double)fArr[i4])), (float)(Math.hypot((double)fArr[i2], (double)fArr[i5])));
            f = 0.0f;
            if (max > 0.0f) {
                f = (Math.abs(i.g.a(fArr[i6], fArr[i4], fArr[i2], fArr[i5]))) / max;
            }
            return f;
        }

        public void b(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            this.c(this.h, i.g.q, canvas, i, i2, colorFilter);
        }

        public boolean f() {
            if (this.o == null) {
                this.o = Boolean.valueOf(this.h.a());
            }
            return this.o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.h.b(iArr);
        }

        public float getAlpha() {
            return (float)getRootAlpha() / 255f;
        }

        public int getRootAlpha() {
            return this.m;
        }

        public void setAlpha(float f) {
            setRootAlpha((int)(f * 255f));
        }

        public void setRootAlpha(int i) {
            this.m = i;
        }

        public g(i.g gVar) {
            super();
            Matrix matrix = new Matrix();
            d.e.a aVar = new a();
            d.v.a.a.i.d dVar = new i.d(gVar.h, aVar);
            Path path = new Path(gVar.a);
            Path path2 = new Path(gVar.b);
            this.i = gVar.i;
            this.j = gVar.j;
            this.k = gVar.k;
            this.l = gVar.l;
            this.g = gVar.g;
            this.m = gVar.m;
            this.n = gVar.n;
            if (gVar.n != null) {
                aVar.put(gVar.n, this);
            }
            this.o = gVar.o;
        }

        private static float a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }
    }

    private static class h extends Drawable.ConstantState {

        int a;
        i.g b = new i$g();
        ColorStateList c = null;
        PorterDuff.Mode d;
        boolean e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;
        public h(i.h hVar) {
            Paint paint2;
            Paint paint3;
            super();
            this.d = i.B;
            if (hVar != null) {
                this.a = hVar.a;
                if (hVar.b.e != null) {
                    new i.g(hVar.b).e = new Paint(hVar.b.e);
                }
                if (hVar.b.d != null) {
                    this.b.d = new Paint(hVar.b.d);
                }
                this.c = hVar.c;
                this.d = hVar.d;
                this.e = hVar.e;
            }
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public boolean a(int i, int i2) {
            if (i == this.f.getWidth()) {
                if (i2 == this.f.getHeight()) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public boolean b() {
            if (!this.k) {
                if (this.g == this.c) {
                    if (this.h == this.d) {
                        if (this.j == this.e) {
                            if (this.i == this.b.getRootAlpha()) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public void c(int i, int i2) {
            if (this.f == null || !this.a(i, i2)) {
                this.f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                boolean z2 = true;
                this.k = z2;
            }
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f, null, rect, e(colorFilter));
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                Paint paint = new Paint();
                this.l = paint;
                boolean z = true;
                paint.setFilterBitmap(z);
            }
            this.l.setAlpha(this.b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public boolean f() {
            boolean z = true;
            int r0 = this.b.getRootAlpha() < 255 ? 1 : 0;
            return (this.b.getRootAlpha() < 255 ? 1 : 0);
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public boolean g() {
            return this.b.f();
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public boolean h(int[] iArr) {
            final boolean z2 = this.b.g(iArr);
            this.k |= z2;
            return z2;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public void i() {
            this.g = this.c;
            this.h = this.d;
            this.i = this.b.getRootAlpha();
            this.j = this.e;
            this.k = false;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public void j(int i, int i2) {
            this.f.eraseColor(0);
            this.b.b(new Canvas(this.f), i, i2, null);
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable() {
            return new i(this);
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }

        public h() {
            super();
            this.d = i.B;
            d.v.a.a.i.g gVar = new i.g();
        }
    }

    private static class i extends Drawable.ConstantState {

        private final Drawable.ConstantState a;
        public i(Drawable.ConstantState constantState) {
            super();
            this.a = constantState;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable() {
            final d.v.a.a.i iVar = new i();
            iVar.a = (VectorDrawable)this.a.newDrawable();
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources) {
            final d.v.a.a.i iVar = new i();
            iVar.a = (VectorDrawable)this.a.newDrawable(resources);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            final d.v.a.a.i iVar = new i();
            iVar.a = (VectorDrawable)this.a.newDrawable(resources, theme);
            return iVar;
        }
    }

    private static class d extends i.e {

        final Matrix a = new Matrix();
        final ArrayList<i.e> b = new ArrayList<>();
        float c = 0f;
        private float d = 0f;
        private float e = 0f;
        private float f = 1f;
        private float g = 1f;
        private float h = 0f;
        private float i = 0f;
        final Matrix j = new Matrix();
        int k;
        private int[] l;
        private String m = null;
        public d(i.d dVar, d.e.a<String, Object> aVar) {
            int i = 0;
            Matrix matrix;
            d.v.a.a.i.c cVar;
            int i2;
            d.v.a.a.i.d dVar2;
            super(null);
            Matrix matrix3 = new Matrix();
            ArrayList arrayList = new ArrayList();
            this.c = dVar.c;
            this.d = dVar.d;
            this.e = dVar.e;
            this.f = dVar.f;
            this.g = dVar.g;
            this.h = dVar.h;
            this.i = dVar.i;
            this.l = dVar.l;
            this.m = dVar.m;
            this.k = dVar.k;
            if (dVar.m != null) {
                aVar.put(dVar.m, this);
            }
            new Matrix().set(dVar.j);
            i = 0;
            while (dVar.j < dVar.b.size()) {
                Object item = dVar.b.get(i);
            }
        }

        private void d() {
            this.j.reset();
            this.j.postTranslate(-this.d, -this.e);
            this.j.postScale(this.f, this.g);
            float f8 = 0.0f;
            this.j.postRotate(this.c, f8, f8);
            this.j.postTranslate(this.h + this.d, this.i + this.e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.c = g.j(typedArray, xmlPullParser, "rotation", 5, this.c);
            this.d = typedArray.getFloat(1, this.d);
            this.e = typedArray.getFloat(2, this.e);
            this.f = g.j(typedArray, xmlPullParser, "scaleX", 3, this.f);
            this.g = g.j(typedArray, xmlPullParser, "scaleY", 4, this.g);
            this.h = g.j(typedArray, xmlPullParser, "translateX", 6, this.h);
            this.i = g.j(typedArray, xmlPullParser, "translateY", 7, this.i);
            final String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            d();
        }

        @Override // d.v.a.a.i$e
        public boolean a() {
            int i;
            i = 0;
            while (i < this.b.size()) {
                if ((i.e)this.b.get(i).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // d.v.a.a.i$e
        public boolean b(int[] iArr) {
            int i = 0;
            boolean z;
            i = 0;
            while (i < this.b.size()) {
                z = z | (i.e)this.b.get(i).b(iArr);
                i = i + 1;
            }
            return z;
        }

        @Override // d.v.a.a.i$e
        public void c(Resources resources, AttributeSet set, Resources.Theme theme, XmlPullParser xmlPullParser) {
            final TypedArray typedArray = g.s(resources, theme, set, a.b);
            e(typedArray, xmlPullParser);
            typedArray.recycle();
        }

        @Override // d.v.a.a.i$e
        public String getGroupName() {
            return this.m;
        }

        @Override // d.v.a.a.i$e
        public Matrix getLocalMatrix() {
            return this.j;
        }

        @Override // d.v.a.a.i$e
        public float getPivotX() {
            return this.d;
        }

        @Override // d.v.a.a.i$e
        public float getPivotY() {
            return this.e;
        }

        @Override // d.v.a.a.i$e
        public float getRotation() {
            return this.c;
        }

        @Override // d.v.a.a.i$e
        public float getScaleX() {
            return this.f;
        }

        @Override // d.v.a.a.i$e
        public float getScaleY() {
            return this.g;
        }

        @Override // d.v.a.a.i$e
        public float getTranslateX() {
            return this.h;
        }

        @Override // d.v.a.a.i$e
        public float getTranslateY() {
            return this.i;
        }

        @Override // d.v.a.a.i$e
        public void setPivotX(float f) {
            if (f != this.d) {
                this.d = f;
                d();
            }
        }

        @Override // d.v.a.a.i$e
        public void setPivotY(float f) {
            if (f != this.e) {
                this.e = f;
                d();
            }
        }

        @Override // d.v.a.a.i$e
        public void setRotation(float f) {
            if (f != this.c) {
                this.c = f;
                d();
            }
        }

        @Override // d.v.a.a.i$e
        public void setScaleX(float f) {
            if (f != this.f) {
                this.f = f;
                d();
            }
        }

        @Override // d.v.a.a.i$e
        public void setScaleY(float f) {
            if (f != this.g) {
                this.g = f;
                d();
            }
        }

        @Override // d.v.a.a.i$e
        public void setTranslateX(float f) {
            if (f != this.h) {
                this.h = f;
                d();
            }
        }

        @Override // d.v.a.a.i$e
        public void setTranslateY(float f) {
            if (f != this.i) {
                this.i = f;
                d();
            }
        }

        public d() {
            super(null);
            Matrix matrix = new Matrix();
            ArrayList arrayList = new ArrayList();
            Matrix matrix2 = new Matrix();
        }
    }

    private static abstract class f extends i.e {

        protected c.b[] a = null;
        String b;
        int c = 0;
        int d;
        public f() {
            super(null);
        }

        @Override // d.v.a.a.i$e
        public void d(Path path) {
            path.reset();
            if (this.a != null) {
                c.b.e(this.a, path);
            }
        }

        @Override // d.v.a.a.i$e
        public c.b[] getPathData() {
            return this.a;
        }

        @Override // d.v.a.a.i$e
        public String getPathName() {
            return this.b;
        }

        @Override // d.v.a.a.i$e
        public void setPathData(c.b[] bVarArr) {
            if (!c.b(this.a, bVarArr)) {
                this.a = c.f(bVarArr);
            } else {
                c.j(this.a, bVarArr);
            }
        }

        public f(i.f fVar) {
            super(null);
            this.b = fVar.b;
            this.d = fVar.d;
            this.a = c.f(fVar.a);
        }

        @Override // d.v.a.a.i$e
        public boolean c() {
            return false;
        }
    }

    private static class b extends i.f {
        b() {
            super();
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            final int i = 0;
            String string2 = typedArray.getString(i);
            if (string2 != null) {
                this.b = string2;
            }
            String string = typedArray.getString(1);
            if (string != null) {
                this.a = c.d(string);
            }
            this.c = g.k(typedArray, xmlPullParser, "fillType", 2, i);
        }

        @Override // d.v.a.a.i$f
        public void e(Resources resources, AttributeSet set, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (!g.r(xmlPullParser, "pathData")) {
                return;
            }
            final TypedArray typedArray = g.s(resources, theme, set, a.d);
            f(typedArray, xmlPullParser);
            typedArray.recycle();
        }

        b(i.b bVar) {
            super(bVar);
        }

        @Override // d.v.a.a.i$f
        public boolean c() {
            return true;
        }
    }

    private static class c extends i.f {

        private int[] e;
        b f;
        float g = 0f;
        b h;
        float i = 1f;
        float j = 1f;
        float k = 0f;
        float l = 1f;
        float m = 0f;
        Paint.Cap n;
        Paint.Join o;
        float p = 4f;
        c() {
            super();
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
        }

        private Paint.Cap e(int i, Paint.Cap cap) {
            if (i != 0 && i != 1) {
                if (i != 2) {
                    return cap;
                }
                return Paint.Cap.SQUARE;
            }
            return Paint.Cap.BUTT;
        }

        private Paint.Join f(int i, Paint.Join join) {
            if (i != 0 && i != 1) {
                if (i != 2) {
                    return join;
                }
                return Paint.Join.BEVEL;
            }
            return Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.e = null;
            if (!g.r(xmlPullParser, "pathData")) {
                return;
            }
            String string2 = typedArray.getString(0);
            if (string2 != null) {
                this.b = string2;
            }
            String string = typedArray.getString(2);
            if (string != null) {
                this.a = c.d(string);
            }
            final int i14 = 0;
            final Resources.Theme theme32 = theme;
            this.h = g.i(typedArray, xmlPullParser, theme32, "fillColor", 1, i14);
            this.j = g.j(typedArray, xmlPullParser, "fillAlpha", 12, this.j);
            int i11 = -1;
            this.n = e(g.k(typedArray, xmlPullParser, "strokeLineCap", 8, i11), this.n);
            this.o = f(g.k(typedArray, xmlPullParser, "strokeLineJoin", 9, i11), this.o);
            this.p = g.j(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
            this.f = g.i(typedArray, xmlPullParser, theme32, "strokeColor", 3, i14);
            this.i = g.j(typedArray, xmlPullParser, "strokeAlpha", 11, this.i);
            this.g = g.j(typedArray, xmlPullParser, "strokeWidth", 4, this.g);
            this.l = g.j(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
            this.m = g.j(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
            this.k = g.j(typedArray, xmlPullParser, "trimPathStart", 5, this.k);
            this.c = g.k(typedArray, xmlPullParser, "fillType", 13, this.c);
        }

        @Override // d.v.a.a.i$f
        public boolean a() {
            boolean z2 = false;
            if (!this.h.i()) {
                if (this.f.i()) {
                    int i2 = 1;
                } else {
                    int i = 0;
                }
            }
            return z2;
        }

        @Override // d.v.a.a.i$f
        public boolean b(int[] iArr) {
            return this.f.j(iArr) | this.h.j(iArr);
        }

        @Override // d.v.a.a.i$f
        public void g(Resources resources, AttributeSet set, Resources.Theme theme, XmlPullParser xmlPullParser) {
            final TypedArray typedArray = g.s(resources, theme, set, a.c);
            h(typedArray, xmlPullParser, theme);
            typedArray.recycle();
        }

        @Override // d.v.a.a.i$f
        float getFillAlpha() {
            return this.j;
        }

        @Override // d.v.a.a.i$f
        int getFillColor() {
            return this.h.e();
        }

        @Override // d.v.a.a.i$f
        float getStrokeAlpha() {
            return this.i;
        }

        @Override // d.v.a.a.i$f
        int getStrokeColor() {
            return this.f.e();
        }

        @Override // d.v.a.a.i$f
        float getStrokeWidth() {
            return this.g;
        }

        @Override // d.v.a.a.i$f
        float getTrimPathEnd() {
            return this.l;
        }

        @Override // d.v.a.a.i$f
        float getTrimPathOffset() {
            return this.m;
        }

        @Override // d.v.a.a.i$f
        float getTrimPathStart() {
            return this.k;
        }

        @Override // d.v.a.a.i$f
        void setFillAlpha(float f) {
            this.j = f;
        }

        @Override // d.v.a.a.i$f
        void setFillColor(int i) {
            this.h.k(i);
        }

        @Override // d.v.a.a.i$f
        void setStrokeAlpha(float f) {
            this.i = f;
        }

        @Override // d.v.a.a.i$f
        void setStrokeColor(int i) {
            this.f.k(i);
        }

        @Override // d.v.a.a.i$f
        void setStrokeWidth(float f) {
            this.g = f;
        }

        @Override // d.v.a.a.i$f
        void setTrimPathEnd(float f) {
            this.l = f;
        }

        @Override // d.v.a.a.i$f
        void setTrimPathOffset(float f) {
            this.m = f;
        }

        @Override // d.v.a.a.i$f
        void setTrimPathStart(float f) {
            this.k = f;
        }

        c(i.c cVar) {
            super(cVar);
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.e = cVar.e;
            this.f = cVar.f;
            this.g = cVar.g;
            this.i = cVar.i;
            this.h = cVar.h;
            this.c = cVar.c;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }
    }
    static {
        i.B = PorterDuff.Mode.SRC_IN;
    }

    i() {
        super();
        this.y = new float[9];
        Matrix matrix = new Matrix();
        Rect rect = new Rect();
        this.b = new i.h();
    }

    static int a(int i, float f) {
        return (i & 16777215) | (int)(float)Color.alpha(i) * f << 24;
    }

    public static i b(Resources resources, int i, Resources.Theme theme) throws android.content.res.Resources.NotFoundException {
        int i3 = 1;
        int next = 24;
        if (Build.VERSION.SDK_INT >= 24) {
            d.v.a.a.i iVar = new i();
            iVar.a = f.f(resources, i, theme);
            d.v.a.a.i.i iVar3 = new i.i(iVar.a.getConstantState());
            return iVar;
        }
        try {
            android.content.res.XmlResourceParser xml = resources.getXml(i);
            next = xml.next();
            i = 2;
            while (next != i) {
                i3 = 1;
                if (next != 1) {
                    next = xml.next();
                    i = 2;
                    while (next != i) {
                        i3 = 1;
                    }
                }
            }
            if (next != i) {
                throw new XmlPullParserException("No start tag found");
            } else {
                return i.c(resources, xml, Xml.asAttributeSet(xml), theme);
            }
        } catch (java.io.IOException ioException) {
            Log.e(str3, str, ioException);
        } catch (org.xmlpull.v1.XmlPullParserException xmlPullParser1) {
            Log.e(str3, str, xmlPullParser1);
        }
        xmlPullParser1 = null;
        return xmlPullParser1;
    }

    public static i c(Resources resources, XmlPullParser xmlPullParser, AttributeSet set, Resources.Theme theme) {
        final d.v.a.a.i iVar = new i();
        iVar.inflate(resources, xmlPullParser, set, theme);
        return iVar;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet set, Resources.Theme theme) throws XmlPullParserException, IOException {
        int eventType;
        int i;
        int depth;
        int i2;
        boolean equals;
        final ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.h);
        eventType = xmlPullParser.getEventType();
        i = 1;
        while (gVar.h != i) {
            i2 = 3;
        }
        if (i != 0) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        boolean z = false;
        int i2 = 0;
        int i = 17;
        if (Build.VERSION.SDK_INT >= 17) {
            i = 1;
            if (isAutoMirrored() && a.f(this) == i) {
            }
        }
        return z;
    }

    private static PorterDuff.Mode g(int i, PorterDuff.Mode mode) {
        if (i != 3 && i != 5) {
            if (i != 9) {
                switch (i) {
                    case 14:
                        return PorterDuff.Mode.MULTIPLY;
                    case 15:
                        return PorterDuff.Mode.SCREEN;
                    case 16:
                        return PorterDuff.Mode.ADD;
                    default:
                        return mode;
                }
            }
            return PorterDuff.Mode.SRC_ATOP;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        this.b.d = i.g(g.k(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = g.g(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateList != null) {
            this.b.c = colorStateList;
        }
        this.b.e = g.e(typedArray, xmlPullParser, "autoMirrored", 5, hVar.e);
        hVar.b.k = g.j(typedArray, xmlPullParser, "viewportWidth", 7, gVar.k);
        float f10 = g.j(typedArray, xmlPullParser, "viewportHeight", 8, gVar.l);
        hVar.b.l = f10;
        float f7 = 0.0f;
        if (gVar.k <= 0.0f) {
            StringBuilder stringBuilder4 = new StringBuilder();
            String positionDescription4 = typedArray.getPositionDescription();
            String str10 = "<vector> tag requires viewportWidth > 0";
            typedArray = positionDescription4 + str10;
            throw new XmlPullParserException(typedArray);
        } else {
            if (f10 <= 0.0f) {
                StringBuilder stringBuilder = new StringBuilder();
                String positionDescription = typedArray.getPositionDescription();
                String str7 = "<vector> tag requires viewportHeight > 0";
                typedArray = positionDescription + str7;
                throw new XmlPullParserException(typedArray);
            } else {
                hVar.b.i = typedArray.getDimension(3, gVar.i);
                float dimension2 = typedArray.getDimension(2, gVar.j);
                hVar.b.j = dimension2;
                if (gVar.i <= 0.0f) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String positionDescription2 = typedArray.getPositionDescription();
                    String str8 = "<vector> tag requires width > 0";
                    typedArray = positionDescription2 + str8;
                    throw new XmlPullParserException(typedArray);
                } else {
                    if (dimension2 <= 0.0f) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        String positionDescription3 = typedArray.getPositionDescription();
                        String str9 = "<vector> tag requires height > 0";
                        typedArray = positionDescription3 + str9;
                        throw new XmlPullParserException(typedArray);
                    } else {
                        hVar.b.setAlpha(g.j(typedArray, xmlPullParser, "alpha", 4, hVar.b.getAlpha()));
                        int i = 0;
                        String string = typedArray.getString(i);
                        if (string != null) {
                            hVar.b.n = string;
                            gVar.p.put(string, hVar.b);
                        }
                        return;
                    }
                }
            }
        }
    }

    @Override // d.v.a.a.h
    public boolean canApplyTheme() {
        if (this.a != null) {
            a.b(this.a);
        }
        return false;
    }

    @Override // d.v.a.a.h
    Object d(String str) {
        return this.b.b.p.get(str);
    }

    @Override // d.v.a.a.h
    public void draw(Canvas canvas) {
        ColorFilter colorFilter;
        int i;
        int cmp;
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        copyBounds(this.A);
        if (this.A.width() > 0) {
            if (this.A.height() > 0) {
                if (this.v == null) {
                }
                canvas.getMatrix(this.z);
                this.z.getValues(this.y);
                int i2 = 0;
                float abs2 = Math.abs(this.y[i2]);
                float abs3 = Math.abs(this.y[4]);
                float abs4 = Math.abs(this.y[1]);
                float abs = Math.abs(this.y[3]);
                float f = 0.0f;
                float f2 = 1f;
                if (abs4 == 0.0f) {
                    if (abs != 0.0f) {
                    }
                }
                int save = 2048;
                int min = Math.min(save, (int)(float)this.A.width() * i);
                int min2 = Math.min(save, (int)(float)this.A.height() * i);
            }
        }
    }

    @Override // d.v.a.a.h
    public int getAlpha() {
        if (this.a != null) {
            return a.d(this.a);
        }
        return this.b.b.getRootAlpha();
    }

    @Override // d.v.a.a.h
    public int getChangingConfigurations() {
        if (this.a != null) {
            return this.a.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.b.getChangingConfigurations();
    }

    @Override // d.v.a.a.h
    public ColorFilter getColorFilter() {
        if (this.a != null) {
            return a.e(this.a);
        }
        return this.v;
    }

    @Override // d.v.a.a.h
    public Drawable.ConstantState getConstantState() {
        if (this.a != null) {
            int i = 24;
            if (Build.VERSION.SDK_INT >= 24) {
                return new i.i(this.a.getConstantState());
            }
        }
        this.b.a = getChangingConfigurations();
        return this.b;
    }

    @Override // d.v.a.a.h
    public int getIntrinsicHeight() {
        if (this.a != null) {
            return this.a.getIntrinsicHeight();
        }
        return (int)this.b.b.j;
    }

    @Override // d.v.a.a.h
    public int getIntrinsicWidth() {
        if (this.a != null) {
            return this.a.getIntrinsicWidth();
        }
        return (int)this.b.b.i;
    }

    @Override // d.v.a.a.h
    public int getOpacity() {
        if (this.a != null) {
            return this.a.getOpacity();
        }
        return -3;
    }

    @Override // d.v.a.a.h
    void h(boolean z) {
        this.x = z;
    }

    @Override // d.v.a.a.h
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet set) throws IOException, XmlPullParserException {
        if (this.a != null) {
            this.a.inflate(resources, xmlPullParser, set);
            return;
        }
        inflate(resources, xmlPullParser, set, null);
    }

    @Override // d.v.a.a.h
    public void invalidateSelf() {
        if (this.a != null) {
            this.a.invalidateSelf();
            return;
        }
        super.invalidateSelf();
    }

    @Override // d.v.a.a.h
    public boolean isAutoMirrored() {
        if (this.a != null) {
            return a.h(this.a);
        }
        return this.b.e;
    }

    @Override // d.v.a.a.h
    public boolean isStateful() {
        boolean z = false;
        if (this.a != null) {
            return this.a.isStateful();
        }
        if (super.isStateful() || this.b != null) {
            int i2 = 1;
        } else {
            if (!this.b.g()) {
                if (this.b.c == null || !this.b.c.isStateful()) {
                    int i = 0;
                }
            }
        }
        return z;
    }

    @Override // d.v.a.a.h
    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList list, PorterDuff.Mode mode) {
        return null;
    }

    @Override // d.v.a.a.h
    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
            return this;
        }
        if (!this.w && mutate() == this) {
            this.b = new i.h(this.b);
            boolean z = true;
            this.w = z;
        }
        return this;
    }

    @Override // d.v.a.a.h
    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        }
    }

    @Override // d.v.a.a.h
    protected boolean onStateChange(int[] iArr) {
        int i = 0;
        boolean z3 = true;
        boolean z;
        if (this.a != null) {
            return this.a.setState(iArr);
        }
        i = 0;
        if (hVar.c != null && hVar.d != null) {
            this.c = j(this.c, hVar.c, hVar.d);
            invalidateSelf();
        }
        if (!this.b.g() || !this.b.h(iArr)) {
        } else {
            invalidateSelf();
        }
        return z3;
    }

    @Override // d.v.a.a.h
    public void scheduleSelf(Runnable runnable, long j) {
        if (this.a != null) {
            this.a.scheduleSelf(runnable, j);
            return;
        }
        super.scheduleSelf(runnable, j);
    }

    @Override // d.v.a.a.h
    public void setAlpha(int i) {
        if (this.a != null) {
            this.a.setAlpha(i);
            return;
        }
        if (this.b.b.getRootAlpha() != i) {
            this.b.b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // d.v.a.a.h
    public void setAutoMirrored(boolean z) {
        if (this.a != null) {
            a.j(this.a, z);
            return;
        }
        this.b.e = z;
    }

    @Override // d.v.a.a.h
    public void setTint(int i) {
        if (this.a != null) {
            a.n(this.a, i);
            return;
        }
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // d.v.a.a.h
    public void setTintList(ColorStateList list) {
        if (this.a != null) {
            a.o(this.a, list);
            return;
        }
        if (hVar.c != list) {
            this.b.c = list;
            this.c = j(this.c, list, hVar.d);
            invalidateSelf();
        }
    }

    @Override // d.v.a.a.h
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.a != null) {
            a.p(this.a, mode);
            return;
        }
        if (hVar.d != mode) {
            this.b.d = mode;
            this.c = j(this.c, hVar.c, mode);
            invalidateSelf();
        }
    }

    @Override // d.v.a.a.h
    public boolean setVisible(boolean z, boolean z2) {
        if (this.a != null) {
            return this.a.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // d.v.a.a.h
    public void unscheduleSelf(Runnable runnable) {
        if (this.a != null) {
            this.a.unscheduleSelf(runnable);
            return;
        }
        super.unscheduleSelf(runnable);
    }

    @Override // d.v.a.a.h
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
            return;
        }
        this.v = colorFilter;
        invalidateSelf();
    }

    @Override // d.v.a.a.h
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet set, Resources.Theme theme) {
        if (this.a != null) {
            a.g(this.a, resources, xmlPullParser, set, theme);
            return;
        }
        this.b.b = new i.g();
        TypedArray typedArray = g.s(resources, theme, set, a.a);
        i(typedArray, xmlPullParser, theme);
        typedArray.recycle();
        this.b.a = getChangingConfigurations();
        this.b.k = true;
        e(resources, xmlPullParser, set, theme);
        this.c = j(this.c, hVar.c, hVar.d);
    }

    i(i.h hVar) {
        super();
        this.y = new float[9];
        Matrix matrix = new Matrix();
        Rect rect = new Rect();
        this.b = hVar;
        this.c = j(this.c, hVar.c, hVar.d);
    }
}

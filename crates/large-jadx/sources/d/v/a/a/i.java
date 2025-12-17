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
import androidx.core.content.e.g;
import androidx.core.graphics.drawable.a;
import d.e.a;
import d.e.g;
import d.h.f.c;
import d.h.f.c.b;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class i extends d.v.a.a.h {

    static final PorterDuff.Mode B;
    private final Rect A;
    private d.v.a.a.i.h b;
    private PorterDuffColorFilter c;
    private ColorFilter v;
    private boolean w;
    private boolean x = true;
    private final float[] y;
    private final Matrix z;

    static class a {
    }

    private static abstract class e {
        e(d.v.a.a.i.a i$a) {
            super();
        }

        public boolean a() {
            return 0;
        }

        public boolean b(int[] iArr) {
            return 0;
        }
    }

    private static class g {

        private static final Matrix q;
        private final Path a;
        private final Path b;
        private final Matrix c;
        Paint d;
        Paint e;
        private PathMeasure f;
        private int g;
        final d.v.a.a.i.d h;
        float i = 0f;
        float j = 0f;
        float k = 0f;
        float l = 0f;
        int m = 255;
        String n = null;
        Boolean o = null;
        final a<String, Object> p;
        static {
            Matrix matrix = new Matrix();
            i.g.q = matrix;
        }

        public g() {
            super();
            Matrix matrix = new Matrix();
            this.c = matrix;
            int i = 0;
            int i2 = 255;
            int i3 = 0;
            a aVar = new a();
            this.p = aVar;
            i.d dVar = new i.d();
            this.h = dVar;
            Path path = new Path();
            this.a = path;
            Path path2 = new Path();
            this.b = path2;
        }

        public g(d.v.a.a.i.g i$g) {
            super();
            Matrix matrix = new Matrix();
            this.c = matrix;
            int i = 0;
            int i2 = 255;
            int i3 = 0;
            a aVar = new a();
            this.p = aVar;
            i.d dVar = new i.d(g.h, aVar);
            this.h = dVar;
            Path path = new Path(g.a);
            this.a = path;
            Path path2 = new Path(g.b);
            this.b = path2;
            this.i = g.i;
            this.j = g.j;
            this.k = g.k;
            this.l = g.l;
            this.g = g.g;
            this.m = g.m;
            this.n = g.n;
            String str2 = g.n;
            if (str2 != null) {
                aVar.put(str2, this);
            }
            this.o = g.o;
        }

        private static float a(float f, float f2, float f3, float f4) {
            return obj0 -= obj1;
        }

        private void c(d.v.a.a.i.d i$d, Matrix matrix2, Canvas canvas3, int i4, int i5, ColorFilter colorFilter6) {
            Matrix matrix4;
            boolean z;
            Object obj;
            Matrix matrix3;
            Matrix matrix;
            Canvas canvas;
            int i;
            int i2;
            ColorFilter colorFilter;
            int obj11;
            d.a.set(matrix2);
            d.a.preConcat(d.j);
            canvas3.save();
            obj11 = 0;
            while (obj11 < d.b.size()) {
                matrix4 = d.b.get(obj11);
                if (matrix4 instanceof i.d) {
                } else {
                }
                if (matrix4 instanceof i.f) {
                }
                obj11++;
                this.d(d, (i.f)(i.e)matrix4, canvas3, i4, i5, colorFilter6);
                this.c((i.d)matrix4, d.a, canvas3, i4, i5, colorFilter6);
            }
            canvas3.restore();
        }

        private void d(d.v.a.a.i.d i$d, d.v.a.a.i.f i$f2, Canvas canvas3, int i4, int i5, ColorFilter colorFilter6) {
            float f;
            boolean z;
            PathMeasure f4;
            int i;
            int length;
            PathMeasure pathMeasure;
            Object cmp;
            Paint paint2;
            Paint paint;
            int sTROKE;
            int eVEN_ODD;
            float f3;
            int i2;
            Path obj8;
            Path.FillType obj9;
            int obj11;
            Path obj12;
            obj11 /= f5;
            obj12 /= f6;
            obj8 = d.a;
            this.c.set(obj8);
            this.c.postScale(obj11, obj12);
            obj8 = e(obj8);
            obj11 = 0;
            if (Float.compare(obj8, obj11) == 0) {
            }
            f2.d(this.a);
            obj12 = this.a;
            this.b.reset();
            if (f2.c()) {
                obj9 = f2.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                this.b.setFillType(obj9);
                this.b.addPath(obj12, this.c);
                canvas3.clipPath(this.b);
            } else {
                f4 = f2.k;
                cmp = 1065353216;
                sTROKE = 1;
                if (Float.compare(f4, obj11) == 0) {
                    float f7 = f2.m;
                    if (Float.compare(f8, cmp) != 0 && this.f == null) {
                        f7 = f2.m;
                        if (this.f == null) {
                            pathMeasure = new PathMeasure();
                            this.f = pathMeasure;
                        }
                        this.f.setPath(this.a, false);
                        length = this.f.getLength();
                        i6 *= length;
                        i8 *= length;
                        obj12.reset();
                        if (Float.compare(f4, eVEN_ODD) > 0) {
                            this.f.getSegment(f4, length, obj12, sTROKE);
                            this.f.getSegment(obj11, eVEN_ODD, obj12, sTROKE);
                        } else {
                            this.f.getSegment(f4, eVEN_ODD, obj12, sTROKE);
                        }
                        obj12.rLineTo(obj11, obj11);
                    }
                } else {
                }
                this.b.addPath(obj12, this.c);
                obj12 = 1132396544;
                z = 255;
                i = 0;
                obj11 = f2.h;
                if (f2.h.l() && this.e == null) {
                    obj11 = f2.h;
                    if (this.e == null) {
                        paint = new Paint(sTROKE);
                        this.e = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    cmp = this.e;
                    if (obj11.h()) {
                        obj11 = obj11.f();
                        obj11.setLocalMatrix(this.c);
                        cmp.setShader(obj11);
                        cmp.setAlpha(Math.round(obj11 *= obj12));
                    } else {
                        cmp.setShader(i);
                        cmp.setAlpha(z);
                        cmp.setColor(i.a(obj11.e(), f2.j));
                    }
                    cmp.setColorFilter(colorFilter6);
                    eVEN_ODD = f2.c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    this.b.setFillType(eVEN_ODD);
                    canvas3.drawPath(this.b, cmp);
                }
                obj11 = f2.f;
                if (f2.f.l() && this.d == null) {
                    obj11 = f2.f;
                    if (this.d == null) {
                        paint2 = new Paint(sTROKE);
                        this.d = paint2;
                        paint2.setStyle(Paint.Style.STROKE);
                    }
                    cmp = this.d;
                    Paint.Join join = f2.o;
                    if (join != null) {
                        cmp.setStrokeJoin(join);
                    }
                    Paint.Cap cap = f2.n;
                    if (cap != null) {
                        cmp.setStrokeCap(cap);
                    }
                    cmp.setStrokeMiter(f2.p);
                    if (obj11.h()) {
                        obj11 = obj11.f();
                        obj11.setLocalMatrix(this.c);
                        cmp.setShader(obj11);
                        cmp.setAlpha(Math.round(obj11 *= obj12));
                    } else {
                        cmp.setShader(i);
                        cmp.setAlpha(z);
                        cmp.setColor(i.a(obj11.e(), f2.i));
                    }
                    cmp.setColorFilter(colorFilter6);
                    cmp.setStrokeWidth(obj8 *= f);
                    canvas3.drawPath(this.b, cmp);
                }
            }
        }

        private float e(Matrix matrix) {
            int i;
            float obj10;
            float[] fArr = new float[4];
            fArr = new int[]{0, 1065353216, 1065353216, 0};
            matrix.mapVectors(fArr);
            obj10 = 0;
            int i4 = 1;
            int i3 = 2;
            final int i5 = 3;
            float f2 = Math.max((float)hypot, (float)hypot2);
            if (Float.compare(f2, i) > 0) {
                i = obj10 / f2;
            }
            return i;
        }

        public void b(Canvas canvas, int i2, int i3, ColorFilter colorFilter4) {
            this.c(this.h, i.g.q, canvas, i2, i3, colorFilter4);
        }

        public boolean f() {
            Boolean valueOf;
            if (this.o == null) {
                this.o = Boolean.valueOf(this.h.a());
            }
            return this.o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.h.b(iArr);
        }

        public float getAlpha() {
            return f /= i2;
        }

        public int getRootAlpha() {
            return this.m;
        }

        public void setAlpha(float f) {
            setRootAlpha((int)obj2);
        }

        public void setRootAlpha(int i) {
            this.m = i;
        }
    }

    private static class h extends Drawable.ConstantState {

        int a;
        d.v.a.a.i.g b;
        ColorStateList c = null;
        PorterDuff.Mode d = null;
        boolean e;
        Bitmap f;
        ColorStateList g;
        PorterDuff.Mode h;
        int i;
        boolean j;
        boolean k;
        Paint l;
        public h() {
            super();
            int i = 0;
            PorterDuff.Mode mode = i.B;
            i.g gVar = new i.g();
            this.b = gVar;
        }

        public h(d.v.a.a.i.h i$h) {
            Object paint2;
            PorterDuff.Mode mode;
            Paint paint3;
            Paint paint;
            Object obj4;
            super();
            int i = 0;
            mode = i.B;
            this.a = h.a;
            i.g gVar = new i.g(h.b);
            this.b = gVar;
            if (h != null && gVar4.e != null) {
                this.a = h.a;
                gVar = new i.g(h.b);
                this.b = gVar;
                if (gVar4.e != null) {
                    paint3 = new Paint(gVar6.e);
                    gVar.e = paint3;
                }
                if (gVar2.d != null) {
                    paint3 = new Paint(gVar5.d);
                    paint2.d = paint3;
                }
                this.c = h.c;
                this.d = h.d;
                this.e = h.e;
            }
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public boolean a(int i, int i2) {
            int obj2;
            if (i == this.f.getWidth() && i2 == this.f.getHeight()) {
                if (i2 == this.f.getHeight()) {
                    return 1;
                }
            }
            return 0;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public boolean b() {
            boolean z;
            ColorStateList rootAlpha;
            if (!this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.getRootAlpha()) {
                if (this.g == this.c) {
                    if (this.h == this.d) {
                        if (this.j == this.e) {
                            if (this.i == this.b.getRootAlpha()) {
                                return 1;
                            }
                        }
                    }
                }
            }
            return 0;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public void c(int i, int i2) {
            boolean bitmap;
            int obj2;
            if (this.f != null) {
                if (!a(i, i2)) {
                    this.f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    this.k = true;
                }
            } else {
            }
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public void d(Canvas canvas, ColorFilter colorFilter2, Rect rect3) {
            canvas.drawBitmap(this.f, 0, rect3, e(colorFilter2));
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Paint e(ColorFilter colorFilter) {
            Paint paint;
            int i;
            if (!f() && colorFilter == null) {
                if (colorFilter == null) {
                    return null;
                }
            }
            if (this.l == null) {
                paint = new Paint();
                this.l = paint;
                paint.setFilterBitmap(true);
            }
            this.l.setAlpha(this.b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public boolean f() {
            int i;
            i = this.b.getRootAlpha() < 255 ? 1 : 0;
            return i;
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
            final boolean obj2 = this.b.g(iArr);
            this.k = z |= obj2;
            return obj2;
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
            Canvas canvas = new Canvas(this.f);
            this.b.b(canvas, i, i2, 0);
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable() {
            i iVar = new i(this);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources) {
            i obj1 = new i(this);
            return obj1;
        }
    }

    private static class i extends Drawable.ConstantState {

        private final Drawable.ConstantState a;
        public i(Drawable.ConstantState drawable$ConstantState) {
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
            i iVar = new i();
            iVar.a = (VectorDrawable)this.a.newDrawable();
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.a = (VectorDrawable)this.a.newDrawable(resources);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme resources$Theme2) {
            i iVar = new i();
            iVar.a = (VectorDrawable)this.a.newDrawable(resources, theme2);
            return iVar;
        }
    }

    private static class d extends d.v.a.a.i.e {

        final Matrix a;
        final ArrayList<d.v.a.a.i.e> b;
        float c;
        private float d;
        private float e;
        private float f;
        private float g;
        private float h;
        private float i;
        final Matrix j;
        int k;
        private int[] l;
        private String m;
        public d() {
            final int i = 0;
            super(i);
            Matrix matrix = new Matrix();
            this.a = matrix;
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            int i2 = 0;
            this.c = i2;
            this.d = i2;
            this.e = i2;
            final int i3 = 1065353216;
            this.f = i3;
            this.g = i3;
            this.h = i2;
            this.i = i2;
            Matrix matrix2 = new Matrix();
            this.j = matrix2;
            this.m = i;
        }

        public d(d.v.a.a.i.d i$d, a<String, Object> a2) {
            int i;
            Matrix matrix;
            int cVar;
            d.v.a.a.i.d dVar;
            int i2 = 0;
            super(i2);
            Matrix matrix3 = new Matrix();
            this.a = matrix3;
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            int i3 = 0;
            this.c = i3;
            this.d = i3;
            this.e = i3;
            int i4 = 1065353216;
            this.f = i4;
            this.g = i4;
            this.h = i3;
            this.i = i3;
            matrix = new Matrix();
            this.j = matrix;
            this.m = i2;
            this.c = d.c;
            this.d = d.d;
            this.e = d.e;
            this.f = d.f;
            this.g = d.g;
            this.h = d.h;
            this.i = d.i;
            this.l = d.l;
            String str = d.m;
            this.m = str;
            this.k = d.k;
            if (str != null) {
                a2.put(str, this);
            }
            matrix.set(d.j);
            ArrayList obj5 = d.b;
            i = 0;
            while (i < obj5.size()) {
                matrix = obj5.get(i);
                cVar = new i.b((i.b)matrix);
                this.b.add(cVar);
                matrix = cVar.b;
                if (matrix != null) {
                }
                i++;
                a2.put(matrix, cVar);
                cVar = new i.c((i.c)matrix);
                dVar = new i.d((i.d)matrix, a2);
                this.b.add(dVar);
            }
        }

        private void d() {
            this.j.reset();
            this.j.postTranslate(-f, -f5);
            this.j.postScale(this.f, this.g);
            int i4 = 0;
            this.j.postRotate(this.c, i4, i4);
            this.j.postTranslate(f4 += f7, f8 += f9);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser2) {
            this.l = 0;
            this.c = g.j(typedArray, xmlPullParser2, "rotation", 5, this.c);
            this.d = typedArray.getFloat(1, this.d);
            this.e = typedArray.getFloat(2, this.e);
            this.f = g.j(typedArray, xmlPullParser2, "scaleX", 3, this.f);
            this.g = g.j(typedArray, xmlPullParser2, "scaleY", 4, this.g);
            this.h = g.j(typedArray, xmlPullParser2, "translateX", 6, this.h);
            this.i = g.j(typedArray, xmlPullParser2, "translateY", 7, this.i);
            final String obj4 = typedArray.getString(0);
            if (obj4 != null) {
                this.m = obj4;
            }
            d();
        }

        @Override // d.v.a.a.i$e
        public boolean a() {
            int i;
            boolean z;
            int i2 = 0;
            i = i2;
            while (i < this.b.size()) {
                i++;
            }
            return i2;
        }

        @Override // d.v.a.a.i$e
        public boolean b(int[] iArr) {
            int i2;
            int i;
            boolean z;
            i = i2;
            while (i2 < this.b.size()) {
                i |= z;
                i2++;
            }
            return i;
        }

        @Override // d.v.a.a.i$e
        public void c(Resources resources, AttributeSet attributeSet2, Resources.Theme resources$Theme3, XmlPullParser xmlPullParser4) {
            final TypedArray obj2 = g.s(resources, theme3, attributeSet2, a.b);
            e(obj2, xmlPullParser4);
            obj2.recycle();
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
            if (Float.compare(f, f2) != 0) {
                this.d = f;
                d();
            }
        }

        @Override // d.v.a.a.i$e
        public void setPivotY(float f) {
            if (Float.compare(f, f2) != 0) {
                this.e = f;
                d();
            }
        }

        @Override // d.v.a.a.i$e
        public void setRotation(float f) {
            if (Float.compare(f, f2) != 0) {
                this.c = f;
                d();
            }
        }

        @Override // d.v.a.a.i$e
        public void setScaleX(float f) {
            if (Float.compare(f, f2) != 0) {
                this.f = f;
                d();
            }
        }

        @Override // d.v.a.a.i$e
        public void setScaleY(float f) {
            if (Float.compare(f, f2) != 0) {
                this.g = f;
                d();
            }
        }

        @Override // d.v.a.a.i$e
        public void setTranslateX(float f) {
            if (Float.compare(f, f2) != 0) {
                this.h = f;
                d();
            }
        }

        @Override // d.v.a.a.i$e
        public void setTranslateY(float f) {
            if (Float.compare(f, f2) != 0) {
                this.i = f;
                d();
            }
        }
    }

    private static abstract class f extends d.v.a.a.i.e {

        protected c.b[] a = null;
        String b;
        int c = 0;
        int d;
        public f() {
            super(0);
            int i2 = 0;
        }

        public f(d.v.a.a.i.f i$f) {
            super(0);
            int i2 = 0;
            this.b = f.b;
            this.d = f.d;
            this.a = c.f(f.a);
        }

        @Override // d.v.a.a.i$e
        public boolean c() {
            return 0;
        }

        @Override // d.v.a.a.i$e
        public void d(Path path) {
            path.reset();
            final c.b[] objArr = this.a;
            if (objArr != null) {
                c.b.e(objArr, path);
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
        public void setPathData(c.b[] c$bArr) {
            boolean z;
            c.b[] obj2;
            if (!c.b(this.a, bArr)) {
                this.a = c.f(bArr);
            } else {
                c.j(this.a, bArr);
            }
        }
    }

    private static class b extends d.v.a.a.i.f {
        b(d.v.a.a.i.b i$b) {
            super(b);
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser2) {
            String string;
            final int i = 0;
            String string2 = typedArray.getString(i);
            if (string2 != null) {
                this.b = string2;
            }
            string = typedArray.getString(1);
            if (string != null) {
                this.a = c.d(string);
            }
            this.c = g.k(typedArray, xmlPullParser2, "fillType", 2, i);
        }

        @Override // d.v.a.a.i$f
        public boolean c() {
            return 1;
        }

        @Override // d.v.a.a.i$f
        public void e(Resources resources, AttributeSet attributeSet2, Resources.Theme resources$Theme3, XmlPullParser xmlPullParser4) {
            if (!g.r(xmlPullParser4, "pathData")) {
            }
            final TypedArray obj2 = g.s(resources, theme3, attributeSet2, a.d);
            f(obj2, xmlPullParser4);
            obj2.recycle();
        }
    }

    private static class c extends d.v.a.a.i.f {

        private int[] e;
        b f;
        float g;
        b h;
        float i;
        float j;
        float k;
        float l;
        float m;
        Paint.Cap n;
        Paint.Join o;
        float p = 4f;
        c() {
            super();
            int i = 0;
            this.g = i;
            final int i3 = 1065353216;
            this.i = i3;
            this.j = i3;
            this.k = i;
            this.l = i3;
            this.m = i;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            int i2 = 1082130432;
        }

        c(d.v.a.a.i.c i$c) {
            super(c);
            int i = 0;
            this.g = i;
            final int i4 = 1065353216;
            this.i = i4;
            this.j = i4;
            this.k = i;
            this.l = i4;
            this.m = i;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            int i2 = 1082130432;
            this.e = c.e;
            this.f = c.f;
            this.g = c.g;
            this.i = c.i;
            this.h = c.h;
            this.c = c.c;
            this.j = c.j;
            this.k = c.k;
            this.l = c.l;
            this.m = c.m;
            this.n = c.n;
            this.o = c.o;
            this.p = c.p;
        }

        private Paint.Cap e(int i, Paint.Cap paint$Cap2) {
            if (i != 0 && i != 1 && i != 2) {
                if (i != 1) {
                    if (i != 2) {
                        return cap2;
                    }
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        private Paint.Join f(int i, Paint.Join paint$Join2) {
            if (i != 0 && i != 1 && i != 2) {
                if (i != 1) {
                    if (i != 2) {
                        return join2;
                    }
                    return Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser2, Resources.Theme resources$Theme3) {
            String string;
            this.e = 0;
            if (!g.r(xmlPullParser2, "pathData")) {
            }
            String string2 = typedArray.getString(0);
            if (string2 != null) {
                this.b = string2;
            }
            string = typedArray.getString(2);
            if (string != null) {
                this.a = c.d(string);
            }
            final int i14 = 0;
            final Resources.Theme theme = theme3;
            this.h = g.i(typedArray, xmlPullParser2, theme, "fillColor", 1, i14);
            this.j = g.j(typedArray, xmlPullParser2, "fillAlpha", 12, this.j);
            int i11 = -1;
            this.n = e(g.k(typedArray, xmlPullParser2, "strokeLineCap", 8, i11), this.n);
            this.o = f(g.k(typedArray, xmlPullParser2, "strokeLineJoin", 9, i11), this.o);
            this.p = g.j(typedArray, xmlPullParser2, "strokeMiterLimit", 10, this.p);
            this.f = g.i(typedArray, xmlPullParser2, theme, "strokeColor", 3, i14);
            this.i = g.j(typedArray, xmlPullParser2, "strokeAlpha", 11, this.i);
            this.g = g.j(typedArray, xmlPullParser2, "strokeWidth", 4, this.g);
            this.l = g.j(typedArray, xmlPullParser2, "trimPathEnd", 6, this.l);
            this.m = g.j(typedArray, xmlPullParser2, "trimPathOffset", 7, this.m);
            this.k = g.j(typedArray, xmlPullParser2, "trimPathStart", 5, this.k);
            this.c = g.k(typedArray, xmlPullParser2, "fillType", 13, this.c);
        }

        @Override // d.v.a.a.i$f
        public boolean a() {
            int i;
            boolean z;
            if (!this.h.i()) {
                if (this.f.i()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        @Override // d.v.a.a.i$f
        public boolean b(int[] iArr) {
            return obj3 |= z;
        }

        @Override // d.v.a.a.i$f
        public void g(Resources resources, AttributeSet attributeSet2, Resources.Theme resources$Theme3, XmlPullParser xmlPullParser4) {
            final TypedArray obj2 = g.s(resources, theme3, attributeSet2, a.c);
            h(obj2, xmlPullParser4, theme3);
            obj2.recycle();
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
    }
    static {
        i.B = PorterDuff.Mode.SRC_IN;
    }

    i() {
        super();
        int i = 1;
        this.y = new float[9];
        Matrix matrix = new Matrix();
        this.z = matrix;
        Rect rect = new Rect();
        this.A = rect;
        i.h hVar = new i.h();
        this.b = hVar;
    }

    i(d.v.a.a.i.h i$h) {
        super();
        int i = 1;
        this.y = new float[9];
        Matrix matrix = new Matrix();
        this.z = matrix;
        Rect rect = new Rect();
        this.A = rect;
        this.b = h;
        this.c = j(this.c, h.c, h.d);
    }

    static int a(int i, float f2) {
        return obj2 |= obj3;
    }

    public static d.v.a.a.i b(Resources resources, int i2, Resources.Theme resources$Theme3) {
        int next;
        int i;
        int i3;
        String str = "parser error";
        final String str2 = "VectorDrawableCompat";
        if (Build.VERSION.SDK_INT >= 24) {
            i iVar = new i();
            iVar.a = f.f(resources, i2, theme3);
            i.i obj6 = new i.i(iVar.a.getConstantState());
            return iVar;
        }
        android.content.res.XmlResourceParser obj7 = resources.getXml(i2);
        next = obj7.next();
        i = 2;
        while (next != i) {
            if (next != 1) {
            }
            next = obj7.next();
            i = 2;
        }
        if (next != i) {
        } else {
            return i.c(resources, obj7, Xml.asAttributeSet(obj7), theme3);
        }
        obj6 = new XmlPullParserException("No start tag found");
        throw obj6;
    }

    public static d.v.a.a.i c(Resources resources, XmlPullParser xmlPullParser2, AttributeSet attributeSet3, Resources.Theme resources$Theme4) {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser2, attributeSet3, theme4);
        return iVar;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser2, AttributeSet attributeSet3, Resources.Theme resources$Theme4) {
        int eventType;
        int i;
        Object pathName;
        int pathName2;
        Object pathName3;
        Object groupName;
        int groupName2;
        String str;
        final d.v.a.a.i.h hVar = this.b;
        final d.v.a.a.i.g gVar = hVar.b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.h);
        eventType = xmlPullParser2.getEventType();
        final int i6 = 1;
        i = i6;
        while (eventType != i6) {
            groupName2 = 3;
            if (xmlPullParser2.getDepth() < depth += i6) {
            } else {
            }
            str = "group";
            if (eventType == 2) {
            } else {
            }
            if (eventType == groupName2 && str.equals(xmlPullParser2.getName())) {
            }
            eventType = xmlPullParser2.next();
            if (str.equals(xmlPullParser2.getName())) {
            }
            arrayDeque.pop();
            String name2 = xmlPullParser2.getName();
            pathName2 = arrayDeque.peek();
            if ("path".equals(name2)) {
            } else {
            }
            if ("clip-path".equals(name2)) {
            } else {
            }
            i.d dVar2 = new i.d();
            dVar2.c(resources, attributeSet3, theme4, xmlPullParser2);
            pathName2.b.add(dVar2);
            arrayDeque.push(dVar2);
            if (str.equals(name2) && dVar2.getGroupName() != null) {
            }
            dVar2 = new i.d();
            dVar2.c(resources, attributeSet3, theme4, xmlPullParser2);
            pathName2.b.add(dVar2);
            arrayDeque.push(dVar2);
            if (dVar2.getGroupName() != null) {
            }
            hVar.a = i4 |= pathName2;
            gVar.p.put(dVar2.getGroupName(), dVar2);
            i.b bVar = new i.b();
            bVar.e(resources, attributeSet3, theme4, xmlPullParser2);
            pathName2.b.add(bVar);
            if (bVar.getPathName() != null) {
            }
            hVar.a = i3 |= pathName2;
            gVar.p.put(bVar.getPathName(), bVar);
            i.c cVar = new i.c();
            cVar.g(resources, attributeSet3, theme4, xmlPullParser2);
            pathName2.b.add(cVar);
            if (cVar.getPathName() != null) {
            }
            i = 0;
            hVar.a = i2 |= pathName2;
            gVar.p.put(cVar.getPathName(), cVar);
            if (eventType != groupName2) {
            }
        }
        if (i != 0) {
        } else {
        }
        XmlPullParserException obj11 = new XmlPullParserException("no path defined");
        throw obj11;
    }

    private boolean f() {
        int autoMirrored;
        int i;
        int i2;
        i = 0;
        i2 = 1;
        if (Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && a.f(this) == i2) {
            i2 = 1;
            if (isAutoMirrored()) {
                if (a.f(this) == i2) {
                    i = i2;
                }
            }
        }
        return i;
    }

    private static PorterDuff.Mode g(int i, PorterDuff.Mode porterDuff$Mode2) {
        if (i != 3 && i != 5 && i != 9) {
            if (i != 5) {
                if (i != 9) {
                    switch (i) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode2;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser2, Resources.Theme resources$Theme3) {
        int obj7;
        d.v.a.a.i.h hVar = this.b;
        final d.v.a.a.i.g gVar = hVar.b;
        hVar.d = i.g(g.k(typedArray, xmlPullParser2, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList obj8 = g.g(typedArray, xmlPullParser2, theme3, "tint", 1);
        if (obj8 != null) {
            hVar.c = obj8;
        }
        hVar.e = g.e(typedArray, xmlPullParser2, "autoMirrored", 5, hVar.e);
        gVar.k = g.j(typedArray, xmlPullParser2, "viewportWidth", 7, gVar.k);
        obj8 = g.j(typedArray, xmlPullParser2, "viewportHeight", 8, gVar.l);
        gVar.l = obj8;
        int i2 = 0;
        if (Float.compare(f3, i2) <= 0) {
        } else {
            if (Float.compare(obj8, i2) <= 0) {
            } else {
                gVar.i = typedArray.getDimension(3, gVar.i);
                obj8 = typedArray.getDimension(2, gVar.j);
                gVar.j = obj8;
                if (Float.compare(f6, i2) <= 0) {
                } else {
                    if (Float.compare(obj8, i2) <= 0) {
                    } else {
                        gVar.setAlpha(g.j(typedArray, xmlPullParser2, "alpha", 4, gVar.getAlpha()));
                        String obj6 = typedArray.getString(0);
                        if (obj6 != null) {
                            gVar.n = obj6;
                            gVar.p.put(obj6, gVar);
                        }
                    }
                    obj8 = new StringBuilder();
                    obj8.append(typedArray.getPositionDescription());
                    obj8.append("<vector> tag requires height > 0");
                    obj7 = new XmlPullParserException(obj8.toString());
                    throw obj7;
                }
                obj8 = new StringBuilder();
                obj8.append(typedArray.getPositionDescription());
                obj8.append("<vector> tag requires width > 0");
                obj7 = new XmlPullParserException(obj8.toString());
                throw obj7;
            }
            obj8 = new StringBuilder();
            obj8.append(typedArray.getPositionDescription());
            obj8.append("<vector> tag requires viewportHeight > 0");
            obj7 = new XmlPullParserException(obj8.toString());
            throw obj7;
        }
        obj8 = new StringBuilder();
        obj8.append(typedArray.getPositionDescription());
        obj8.append("<vector> tag requires viewportWidth > 0");
        obj7 = new XmlPullParserException(obj8.toString());
        throw obj7;
    }

    @Override // d.v.a.a.h
    public boolean canApplyTheme() {
        Drawable drawable = this.a;
        if (drawable != null) {
            a.b(drawable);
        }
        return 0;
    }

    @Override // d.v.a.a.h
    Object d(String string) {
        return gVar.p.get(string);
    }

    @Override // d.v.a.a.h
    public void draw(Canvas canvas) {
        Object height;
        int f3;
        int i5;
        boolean z2;
        int i;
        int f;
        int i2;
        int cmp;
        int save;
        boolean z;
        float f2;
        int i3;
        int i4;
        float f4;
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        copyBounds(this.A);
        if (this.A.width() > 0) {
            if (this.A.height() <= 0) {
            } else {
                if (this.v == null) {
                    height = this.c;
                }
                canvas.getMatrix(this.z);
                this.z.getValues(this.y);
                i = 0;
                f3 = Math.abs(this.y[i]);
                f = Math.abs(this.y[4]);
                i3 = 0;
                i4 = 1065353216;
                if (Float.compare(f8, i3) == 0) {
                    if (Float.compare(f2, i3) != 0) {
                        f = f3;
                    }
                } else {
                }
                save = 2048;
                i5 = Math.min(save, (int)i9);
                i2 = Math.min(save, (int)i10);
                if (i5 > 0) {
                    if (i2 <= 0) {
                    } else {
                        Rect rect6 = this.A;
                        canvas.translate((float)left, (float)top);
                        if (f()) {
                            canvas.translate((float)width2, i3);
                            canvas.scale(-1082130432, i4);
                        }
                        this.A.offsetTo(i, i);
                        this.b.c(i5, i2);
                        if (!this.x) {
                            this.b.j(i5, i2);
                        } else {
                            if (!this.b.b()) {
                                this.b.j(i5, i2);
                                this.b.i();
                            }
                        }
                        this.b.d(canvas, height, this.A);
                        canvas.restoreToCount(canvas.save());
                    }
                }
            }
        }
    }

    @Override // d.v.a.a.h
    public int getAlpha() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return a.d(drawable);
        }
        return hVar.b.getRootAlpha();
    }

    @Override // d.v.a.a.h
    public int getChangingConfigurations() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return changingConfigurations2 |= changingConfigurations3;
    }

    @Override // d.v.a.a.h
    public ColorFilter getColorFilter() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return a.e(drawable);
        }
        return this.v;
    }

    @Override // d.v.a.a.h
    public Drawable.ConstantState getConstantState() {
        Drawable sDK_INT;
        int i;
        if (this.a != null && Build.VERSION.SDK_INT >= 24) {
            if (Build.VERSION.SDK_INT >= 24) {
                i.i iVar = new i.i(this.a.getConstantState());
                return iVar;
            }
        }
        hVar.a = getChangingConfigurations();
        return this.b;
    }

    @Override // d.v.a.a.h
    public int getIntrinsicHeight() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int)f;
    }

    @Override // d.v.a.a.h
    public int getIntrinsicWidth() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int)f;
    }

    @Override // d.v.a.a.h
    public int getOpacity() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // d.v.a.a.h
    void h(boolean z) {
        this.x = z;
    }

    @Override // d.v.a.a.h
    public void inflate(Resources resources, XmlPullParser xmlPullParser2, AttributeSet attributeSet3) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser2, attributeSet3);
        }
        inflate(resources, xmlPullParser2, attributeSet3, 0);
    }

    @Override // d.v.a.a.h
    public void inflate(Resources resources, XmlPullParser xmlPullParser2, AttributeSet attributeSet3, Resources.Theme resources$Theme4) {
        Drawable drawable = this.a;
        if (drawable != null) {
            a.g(drawable, resources, xmlPullParser2, attributeSet3, theme4);
        }
        d.v.a.a.i.h hVar = this.b;
        i.g gVar = new i.g();
        hVar.b = gVar;
        TypedArray typedArray = g.s(resources, theme4, attributeSet3, a.a);
        i(typedArray, xmlPullParser2, theme4);
        typedArray.recycle();
        hVar.a = getChangingConfigurations();
        hVar.k = true;
        e(resources, xmlPullParser2, attributeSet3, theme4);
        this.c = j(this.c, hVar.c, hVar.d);
    }

    @Override // d.v.a.a.h
    public void invalidateSelf() {
        final Drawable drawable = this.a;
        if (drawable != null) {
            drawable.invalidateSelf();
        }
        super.invalidateSelf();
    }

    @Override // d.v.a.a.h
    public boolean isAutoMirrored() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return a.h(drawable);
        }
        return hVar.e;
    }

    @Override // d.v.a.a.h
    public boolean isStateful() {
        d.v.a.a.i.h stateful;
        int i;
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful()) {
            stateful = this.b;
            if (stateful != null) {
                if (!stateful.g()) {
                    stateful = hVar.c;
                    if (stateful != null && stateful.isStateful()) {
                        if (stateful.isStateful()) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // d.v.a.a.h
    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList2, PorterDuff.Mode porterDuff$Mode3) {
        if (colorStateList2 != null && mode3 == null) {
            if (mode3 == null) {
            }
            PorterDuffColorFilter obj3 = new PorterDuffColorFilter(colorStateList2.getColorForState(getState(), 0), mode3);
            return obj3;
        }
        return null;
    }

    @Override // d.v.a.a.h
    public Drawable mutate() {
        boolean mutate;
        d.v.a.a.i.h hVar;
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.w && super.mutate() == this) {
            if (super.mutate() == this) {
                i.h hVar2 = new i.h(this.b);
                this.b = hVar2;
                this.w = true;
            }
        }
        return this;
    }

    @Override // d.v.a.a.h
    protected void onBoundsChange(Rect rect) {
        final Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // d.v.a.a.h
    protected boolean onStateChange(int[] iArr) {
        int i2;
        int i;
        PorterDuff.Mode mode;
        boolean obj6;
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        i2 = 0;
        final d.v.a.a.i.h hVar = this.b;
        ColorStateList list = hVar.c;
        mode = hVar.d;
        if (list != null && mode != null) {
            mode = hVar.d;
            if (mode != null) {
                this.c = j(this.c, list, mode);
                invalidateSelf();
                i2 = i;
            }
        }
        if (hVar.g() && hVar.h(iArr)) {
            if (hVar.h(iArr)) {
                invalidateSelf();
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    @Override // d.v.a.a.h
    public void scheduleSelf(Runnable runnable, long l2) {
        final Drawable drawable = this.a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, l2);
        }
        super.scheduleSelf(runnable, l2);
    }

    @Override // d.v.a.a.h
    public void setAlpha(int i) {
        int rootAlpha;
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        if (hVar.b.getRootAlpha() != i) {
            hVar2.b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // d.v.a.a.h
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.a;
        if (drawable != null) {
            a.j(drawable, z);
        }
        hVar.e = z;
    }

    @Override // d.v.a.a.h
    public void setColorFilter(ColorFilter colorFilter) {
        final Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        this.v = colorFilter;
        invalidateSelf();
    }

    @Override // d.v.a.a.h
    public void setTint(int i) {
        final Drawable drawable = this.a;
        if (drawable != null) {
            a.n(drawable, i);
        }
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // d.v.a.a.h
    public void setTintList(ColorStateList colorStateList) {
        Object hVar;
        Object list;
        Object obj3;
        Drawable drawable = this.a;
        if (drawable != null) {
            a.o(drawable, colorStateList);
        }
        hVar = this.b;
        if (hVar.c != colorStateList) {
            hVar.c = colorStateList;
            this.c = j(this.c, colorStateList, hVar.d);
            invalidateSelf();
        }
    }

    @Override // d.v.a.a.h
    public void setTintMode(PorterDuff.Mode porterDuff$Mode) {
        Object hVar;
        Object mode2;
        Object obj3;
        Drawable drawable = this.a;
        if (drawable != null) {
            a.p(drawable, mode);
        }
        hVar = this.b;
        if (hVar.d != mode) {
            hVar.d = mode;
            this.c = j(this.c, hVar.c, mode);
            invalidateSelf();
        }
    }

    @Override // d.v.a.a.h
    public boolean setVisible(boolean z, boolean z2) {
        final Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // d.v.a.a.h
    public void unscheduleSelf(Runnable runnable) {
        final Drawable drawable = this.a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        }
        super.unscheduleSelf(runnable);
    }
}

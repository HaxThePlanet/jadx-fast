package d.v.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.core.content.e.g;
import d.h.f.c;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: PathInterpolatorCompat.java */
/* loaded from: classes.dex */
public class g implements Interpolator {

    private float[] a;
    private float[] b;
    public g(Context context, AttributeSet set, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), set, xmlPullParser);
    }

    private void a(float f, float f2, float f3, float f4) {
        final Path path = new Path();
        float f6 = 0.0f;
        path.moveTo(f6, f6);
        path.cubicTo(f, f2, f3, f4, 1f, 1f);
        b(path);
    }

    private void b(Path path) {
        boolean z = false;
        int i = 0;
        z = false;
        PathMeasure pathMeasure = new PathMeasure(path, z);
        float length = pathMeasure.getLength();
        int i6 = 1;
        int min = Math.min(3000, (int)(length / 0.002f) + i6);
        if (min <= 0) {
            StringBuilder stringBuilder3 = new StringBuilder();
            String str4 = "The Path has a invalid length ";
            path = str4 + length;
            throw new IllegalArgumentException(path);
        } else {
            this.a = new float[min];
            this.b = new float[min];
            float[] fArr6 = new float[2];
            while (z < min) {
                pathMeasure.getPosTan((z != 0 ? 1f : 0f) * length / (float)(min - 1), fArr6, null);
                this.a[z] = fArr6[z];
                this.b[z] = fArr6[i6];
                z = z + 1;
            }
            d = (double)Math.abs(this.a[z]);
            double d3 = 0.00001d;
            if (d > 0.00001d) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str5 = "The Path must start at (0,0) and end at (1,1) start: ";
                float f8 = this.a[z];
                String str6 = ",";
                float f3 = this.b[z];
                String str3 = " end:";
                min -= i6;
                float f4 = this.a[i5];
                float f5 = this.b[i5];
                r0 = str5 + f8 + str6 + f3 + str3 + f4 + str6 + f5;
                throw new IllegalArgumentException(r0);
            } else {
                d = (double)Math.abs(this.b[z]);
                if (d <= 0.00001d) {
                    int i9 = min - 1;
                    float f = 1f;
                    d2 = (double)(Math.abs(this.a[i9] - f));
                    if (d2 <= 0.00001d) {
                        d = (double)(Math.abs(this.b[i9] - f));
                        if (d <= 0.00001d) {
                            i = 0;
                            while (z < min) {
                                f = z + 1;
                                float f7 = fArr7[z];
                                if (f7 < this.b[i9] - f) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    String str2 = "The Path cannot loop back on itself, x :";
                                    r0 = str2 + f7;
                                    throw new IllegalArgumentException(r0);
                                }
                            }
                            if (pathMeasure.nextContour()) {
                                throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                            }
                        }
                    }
                }
            }
        }
    }

    private void c(float f, float f2) {
        final Path path = new Path();
        float f3 = 0.0f;
        path.moveTo(f3, f3);
        float f4 = 1f;
        path.quadTo(f, f2, f4, f4);
        b(path);
    }

    private void d(TypedArray typedArray, XmlPullParser xmlPullParser) throws InflateException {
        str = "pathData";
        if (g.r(xmlPullParser, str)) {
            int i = 4;
            String str3 = g.m(typedArray, xmlPullParser, str, i);
            Path path = c.e(str3);
            if (path == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str5 = "The path is null, which is created from ";
                typedArray = str5 + str3;
                throw new InflateException(typedArray);
            } else {
                b(path);
                return;
            }
        }
        String str4 = "controlX1";
        if (!g.r(xmlPullParser, str4)) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else {
            String str6 = "controlY1";
            if (!g.r(xmlPullParser, str6)) {
                throw new InflateException("pathInterpolator requires the controlY1 attribute");
            } else {
                float f2 = 0.0f;
                float f3 = g.j(typedArray, xmlPullParser, str4, 0, f2);
                float f4 = g.j(typedArray, xmlPullParser, str6, 1, f2);
                String str7 = "controlX2";
                boolean z5 = g.r(xmlPullParser, str7);
                str2 = "controlY2";
                if (z5 != g.r(xmlPullParser, str2)) {
                    throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
                } else {
                    if (!z5) {
                        c(f3, f4);
                    } else {
                        int i2 = 3;
                        a(f3, f4, g.j(typedArray, xmlPullParser, str7, 2, 0.0f), g.j(typedArray, xmlPullParser, str2, i2, 0.0f));
                    }
                }
            }
        }
    }

    public float getInterpolation(float f) {
        int i = 0;
        float f2 = 0.0f;
        if (f <= 0.0f) {
            return 0.0f;
        }
        float f6 = 1f;
        if (f >= f6) {
            return f6;
        }
        i = 0;
        int i2 = 1;
        i = this.a.length - i2;
        while (i - i > i2) {
            i = (i + i) / 2;
            float f11 = this.a[i];
        }
        float f10 = fArr3[i] - fArr3[i];
        if (f10 == 0.0f) {
            return this.b[i];
        }
        float f7 = fArr[i];
        return f7 + (f - fArr3[i]) / f10 * (fArr[i] - f7);
    }

    public g(Resources resources, Resources.Theme theme, AttributeSet set, XmlPullParser xmlPullParser) {
        super();
        final TypedArray typedArray = g.s(resources, theme, set, a.l);
        d(typedArray, xmlPullParser);
        typedArray.recycle();
    }
}

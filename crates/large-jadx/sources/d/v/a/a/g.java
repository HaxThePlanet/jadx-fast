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

/* loaded from: classes.dex */
public class g implements Interpolator {

    private float[] a;
    private float[] b;
    public g(Context context, AttributeSet attributeSet2, XmlPullParser xmlPullParser3) {
        super(context.getResources(), context.getTheme(), attributeSet2, xmlPullParser3);
    }

    public g(Resources resources, Resources.Theme resources$Theme2, AttributeSet attributeSet3, XmlPullParser xmlPullParser4) {
        super();
        final TypedArray obj2 = g.s(resources, theme2, attributeSet3, a.l);
        d(obj2, xmlPullParser4);
        obj2.recycle();
    }

    private void a(float f, float f2, float f3, float f4) {
        Path path2 = new Path();
        int i = 0;
        path2.moveTo(i, i);
        path2.cubicTo(f, f2, f3, f4, 1065353216, 1065353216);
        b(path2);
    }

    private void b(Path path) {
        int i2;
        int i3;
        double i;
        int i4;
        float[] fArr;
        float f;
        double d;
        int obj11;
        i2 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, i2);
        obj11 = pathMeasure.getLength();
        int i11 = 1;
        int i9 = Math.min(3000, i7 += i11);
        if (i9 <= 0) {
        } else {
            this.a = new float[i9];
            this.b = new float[i9];
            float[] fArr6 = new float[2];
            i4 = i2;
            while (i4 < i9) {
                pathMeasure.getPosTan(i15 /= f7, fArr6, 0);
                this.a[i4] = fArr6[i2];
                this.b[i4] = fArr6[i11];
                i4++;
            }
            long l = 4532020583610935537L;
            if (Double.compare(i, l) > 0) {
            } else {
                if (Double.compare(i, l) > 0) {
                } else {
                    i = i9 + -1;
                    i4 = 1065353216;
                    if (Double.compare(d, l) > 0) {
                    } else {
                        if (Double.compare(i, l) > 0) {
                        } else {
                            obj11 = 0;
                            i3 = i2;
                            while (i2 < i9) {
                                i = this.a;
                                int i12 = i[i3];
                                i[i2] = i12;
                                i2++;
                                obj11 = i12;
                                i3 = i4;
                            }
                            if (pathMeasure.nextContour()) {
                            } else {
                            }
                            obj11 = new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                            throw obj11;
                        }
                    }
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("The Path must start at (0,0) and end at (1,1) start: ");
            stringBuilder2.append(this.a[i2]);
            String str6 = ",";
            stringBuilder2.append(str6);
            stringBuilder2.append(this.b[i2]);
            stringBuilder2.append(" end:");
            i9 -= i11;
            stringBuilder2.append(this.a[i10]);
            stringBuilder2.append(str6);
            stringBuilder2.append(this.b[i10]);
            obj11 = new IllegalArgumentException(stringBuilder2.toString());
            throw obj11;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("The Path has a invalid length ");
        stringBuilder3.append(obj11);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder3.toString());
        throw illegalArgumentException;
    }

    private void c(float f, float f2) {
        Path path = new Path();
        int i = 0;
        path.moveTo(i, i);
        int i2 = 1065353216;
        path.quadTo(f, f2, i2, i2);
        b(path);
    }

    private void d(TypedArray typedArray, XmlPullParser xmlPullParser2) {
        String str;
        int i;
        float str3;
        int i2;
        int i3;
        String str2;
        boolean z;
        String obj8;
        Object obj9;
        str = "pathData";
        if (g.r(xmlPullParser2, str)) {
            obj8 = g.m(typedArray, xmlPullParser2, str, 4);
            obj9 = c.e(obj8);
            if (obj9 == null) {
            } else {
                b(obj9);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The path is null, which is created from ");
            stringBuilder.append(obj8);
            obj9 = new InflateException(stringBuilder.toString());
            throw obj9;
        }
        String str4 = "controlX1";
        if (!g.r(xmlPullParser2, str4)) {
        } else {
            String str6 = "controlY1";
            if (!g.r(xmlPullParser2, str6)) {
            } else {
                i2 = 0;
                str = g.j(typedArray, xmlPullParser2, str4, 0, i2);
                i = g.j(typedArray, xmlPullParser2, str6, 1, i2);
                str3 = "controlX2";
                i3 = g.r(xmlPullParser2, str3);
                str2 = "controlY2";
                if (i3 != g.r(xmlPullParser2, str2)) {
                } else {
                    if (!i3) {
                        c(str, i);
                    } else {
                        a(str, i, g.j(typedArray, xmlPullParser2, str3, 2, i2), g.j(typedArray, xmlPullParser2, str2, 3, i2));
                    }
                }
                obj8 = new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
                throw obj8;
            }
            obj8 = new InflateException("pathInterpolator requires the controlY1 attribute");
            throw obj8;
        }
        obj8 = new InflateException("pathInterpolator requires the controlX1 attribute");
        throw obj8;
    }

    @Override // android.view.animation.Interpolator
    public float getInterpolation(float f) {
        int i3;
        int i;
        int i2;
        int cmp;
        int i4 = 0;
        if (Float.compare(f, i4) <= 0) {
            return i4;
        }
        int i6 = 1065353216;
        if (Float.compare(f, i6) >= 0) {
            return i6;
        }
        i3 = 0;
        int i8 = 1;
        length -= i8;
        while (i - i3 > i8) {
            i10 /= 2;
            if (Float.compare(f, f6) < 0) {
            } else {
            }
            i3 = i2;
            i = i2;
        }
        float[] fArr3 = this.a;
        f5 -= f7;
        if (Float.compare(i11, i4) == 0) {
            return this.b[i3];
        }
        float[] fArr = this.b;
        float f4 = fArr[i3];
        return f4 += obj7;
    }
}

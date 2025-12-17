package androidx.core.content.e;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import d.h.d;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
final class d {

    static final class a {

        final int[] a;
        final float[] b;
        a(int i, int i2) {
            super();
            final int i3 = 2;
            final int[] iArr = new int[i3];
            iArr[0] = i;
            iArr[1] = i2;
            this.a = iArr;
            float[] obj4 = new float[i3];
            obj4 = new int[]{0, 1065353216};
            this.b = obj4;
        }

        a(int i, int i2, int i3) {
            super();
            final int i4 = 3;
            final int[] iArr = new int[i4];
            iArr[0] = i;
            iArr[1] = i2;
            iArr[2] = i3;
            this.a = iArr;
            float[] obj4 = new float[i4];
            obj4 = new int[]{0, 1056964608, 1065353216};
            this.b = obj4;
        }

        a(List<Integer> list, List<Float> list2) {
            int i;
            float[] fArr;
            float floatValue;
            super();
            final int size = list.size();
            this.a = new int[size];
            this.b = new float[size];
            i = 0;
            while (i < size) {
                this.a[i] = (Integer)list.get(i).intValue();
                this.b[i] = (Float)list2.get(i).floatValue();
                i++;
            }
        }
    }
    private static androidx.core.content.e.d.a a(androidx.core.content.e.d.a d$a, int i2, int i3, boolean z4, int i5) {
        if (a != null) {
            return a;
        }
        if (z4) {
            d.a obj0 = new d.a(i2, i5, i3);
            return obj0;
        }
        obj0 = new d.a(i2, i3);
        return obj0;
    }

    static Shader b(Resources resources, XmlPullParser xmlPullParser2, AttributeSet attributeSet3, Resources.Theme resources$Theme4) {
        XmlPullParser xmlPullParser = xmlPullParser2;
        String name = xmlPullParser2.getName();
        if (!name.equals("gradient")) {
        } else {
            TypedArray typedArray = g.s(resources, theme4, attributeSet3, d.x);
            int i18 = 0;
            float f10 = g.j(typedArray, xmlPullParser, "centerY", d.C, i18);
            int i19 = 0;
            int i15 = g.k(typedArray, xmlPullParser, "type", d.A, i19);
            String str14 = "centerColor";
            int i7 = g.k(typedArray, xmlPullParser, "tileMode", d.E, i19);
            float f12 = f8;
            float f3 = g.j(typedArray, xmlPullParser, "gradientRadius", d.D, 0);
            typedArray.recycle();
            androidx.core.content.e.d.a aVar2 = d.a(d.c(resources, xmlPullParser2, attributeSet3, theme4), g.f(typedArray, xmlPullParser, "startColor", d.y, i19), g.f(typedArray, xmlPullParser, "endColor", d.z, i19), g.r(xmlPullParser, str14), g.f(typedArray, xmlPullParser, str14, d.F, i19));
            if (i15 != 1 && i15 != 2) {
                if (i15 != 2) {
                    super(g.j(typedArray, xmlPullParser, "startX", d.G, i18), g.j(typedArray, xmlPullParser, "startY", d.H, i18), g.j(typedArray, xmlPullParser, "endX", d.I, i18), g.j(typedArray, xmlPullParser, "endY", d.J, i18), aVar2.a, aVar2.b, d.d(i7));
                    return linearGradient;
                }
                SweepGradient sweepGradient = new SweepGradient(f12, f10, aVar2.a, aVar2.b);
                return sweepGradient;
            }
            if (Float.compare(f3, i3) <= 0) {
            } else {
                super(f12, f10, f3, aVar2.a, aVar2.b, d.d(i7));
                return radialGradient;
            }
            XmlPullParserException xmlPullParserException = new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            throw xmlPullParserException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(xmlPullParser2.getPositionDescription());
        stringBuilder.append(": invalid gradient color tag ");
        stringBuilder.append(name);
        XmlPullParserException xmlPullParserException2 = new XmlPullParserException(stringBuilder.toString());
        throw xmlPullParserException2;
    }

    private static androidx.core.content.e.d.a c(Resources resources, XmlPullParser xmlPullParser2, AttributeSet attributeSet3, Resources.Theme resources$Theme4) {
        int valueOf;
        int depth;
        int float;
        int i;
        boolean value;
        final int i3 = 1;
        depth2 += i3;
        valueOf = 20;
        ArrayList arrayList = new ArrayList(valueOf);
        ArrayList arrayList2 = new ArrayList(valueOf);
        valueOf = xmlPullParser2.next();
        while (valueOf != i3) {
            depth = xmlPullParser2.getDepth();
            valueOf = xmlPullParser2.next();
            TypedArray typedArray = g.s(resources, theme4, attributeSet3, d.K);
            int i4 = d.L;
            i = d.M;
            typedArray.recycle();
            arrayList2.add(Integer.valueOf(typedArray.getColor(i4, 0)));
            arrayList.add(Float.valueOf(typedArray.getFloat(i, 0)));
        }
        if (arrayList2.size() > 0) {
            d.a obj9 = new d.a(arrayList2, arrayList);
            return obj9;
        }
        return null;
    }

    private static Shader.TileMode d(int i) {
        if (i != 1 && i != 2) {
            if (i != 2) {
                return Shader.TileMode.CLAMP;
            }
            return Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }
}

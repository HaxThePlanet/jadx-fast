package d.v.a.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.core.content.e.g;
import d.h.f.c;
import d.h.f.c.b;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: AnimatorInflaterCompat.java */
/* loaded from: classes.dex */
public class e {

    private static class a implements TypeEvaluator<c.b[]> {

        private c.b[] a;
        a() {
            super();
        }

        public c.b[] a(float f, c.b[] bVarArr, c.b[] bVarArr2) {
            int i = 0;
            if (!c.b(bVarArr, bVarArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            } else {
                if (!c.b(this.a, bVarArr)) {
                    this.a = c.f(bVarArr);
                }
                i = 0;
                while (this.a < bVarArr.length) {
                    this.a[i].d(bVarArr[i], bVarArr2[i], f);
                    i = i + 1;
                }
                return this.a;
            }
        }
    }
    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f) {
        return e.b(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    private static Animator b(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet set, AnimatorSet set2, int i, float f) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        AnimatorSet animatorSet;
        ValueAnimator valueAnimator;
        Resources resources22;
        Resources.Theme theme32;
        int depth = 1;
        Context context2;
        AttributeSet set52;
        boolean z;
        ValueAnimator valueAnimator2 = null;
        float f82;
        XmlPullParser xmlPullParser42;
        int i2;
        TypedArray typedArray;
        resources22 = resources;
        theme32 = theme;
        xmlPullParser42 = xmlPullParser;
        final Object set62 = set2;
        i = 0;
        int next = xmlPullParser.next();
        depth = 3;
        depth = 0;
        while (next == 3) {
            depth = 1;
        }
        if (set62 != null && i != 0) {
            Animator[] arr = new Animator[i.size()];
            Iterator it = i.iterator();
            while (it.hasNext()) {
                arr[depth] = (Animator)it.next();
            }
            if (i == 0) {
                set62.playTogether(arr);
            } else {
                set62.playSequentially(arr);
            }
        }
        return i;
    }

    private static Keyframe c(Keyframe keyframe, float f) {
        Keyframe _float;
        if (keyframe.getType() == Float.TYPE) {
            _float = Keyframe.ofFloat(f);
        } else {
            if (keyframe.getType() == Integer.TYPE) {
                _float = Keyframe.ofInt(f);
            } else {
                _float = Keyframe.ofObject(f);
            }
        }
        return _float;
    }

    private static void d(Keyframe[] keyframeArr, float f, int i, int i2) {
        f = (float)(i2 - i) + 2;
        while (i <= i2) {
            f3 = (keyframeArr[i - 1].getFraction()) + (f / f);
            keyframeArr[i].setFraction(f3);
            i = i + 1;
        }
    }

    private static PropertyValuesHolder e(TypedArray typedArray, int i, int i2, int i3, String str) throws InflateException {
        int type2;
        boolean z;
        PropertyValuesHolder typedArray2 = null;
        int color;
        float dimension;
        PropertyValuesHolder typedArray3;
        float dimension2;
        boolean z2;
        d.v.a.a.f fVar;
        int[] iArr;
        int color2;
        float[] fArr;
        float dimension3;
        int[] iArr2;
        float[] fArr2;
        TypedValue peekValue = typedArray.peekValue(i2);
        type2 = 1;
        type2 = 0;
        int r3 = type2;
        int r0 = type2 != null ? peekValue.type : type2;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        int r5 = type2;
        int r4 = type2 != null ? peekValue2.type : type2;
        type2 = 3;
        if (i == 4) {
            if (type2 == null || !e.h(type2)) {
                i = type2;
            }
        }
        int r6 = type2;
        final int i6 = 2;
        if (type2 == i6) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            c.b[] objArr = c.d(string);
            c.b[] objArr2 = c.d(string2);
            if (objArr != null || objArr2 != null) {
                if (objArr != null) {
                    d.v.a.a.e.a aVar = new e.a();
                    if (objArr2 != null) {
                        if (!c.b(objArr, objArr2)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            final String str2 = " Can't morph from ";
                            str = " to ";
                            typedArray = str2 + string + str + string2;
                            throw new InflateException(typedArray);
                        } else {
                            Object[] arr2 = new Object[i6];
                            typedArray2 = PropertyValuesHolder.ofObject(str, aVar, new Object[] { objArr, objArr2 });
                        }
                    }
                    Object[] arr = new Object[type2];
                    typedArray2 = PropertyValuesHolder.ofObject(str, aVar, new Object[] { objArr });
                } else {
                    if (objArr2 != null) {
                        Object[] arr3 = new Object[type2];
                        typedArray2 = PropertyValuesHolder.ofObject(str, new e.a(), new Object[] { objArr2 });
                    }
                }
            }
        } else {
            if (type2 == type2) {
                fVar = f.a();
            } else {
            }
            type2 = 5;
            float f = 0.0f;
            if (type2 != null) {
                if (type2 != null) {
                    if (type2 == type2) {
                        dimension3 = typedArray.getDimension(i2, 0.0f);
                    } else {
                        dimension3 = typedArray.getFloat(i2, 0.0f);
                    }
                    if (type2 != null) {
                        if (type2 == type2) {
                            dimension2 = typedArray.getDimension(i3, 0.0f);
                        } else {
                            dimension2 = typedArray.getFloat(i3, 0.0f);
                        }
                        fArr2 = new float[i6];
                        typedArray3 = PropertyValuesHolder.ofFloat(str, new float[] { dimension3, dimension2 });
                    } else {
                        float[] fArr3 = new float[type2];
                        typedArray3 = PropertyValuesHolder.ofFloat(str, new float[] { dimension3 });
                    }
                } else {
                    if (type2 == type2) {
                        dimension = typedArray.getDimension(i3, 0.0f);
                    } else {
                        dimension = typedArray.getFloat(i3, 0.0f);
                    }
                    fArr = new float[type2];
                    typedArray3 = PropertyValuesHolder.ofFloat(str, new float[] { dimension });
                }
            } else {
                if (type2 != null) {
                    if (type2 == type2) {
                        color2 = (int)(typedArray.getDimension(i2, 0.0f));
                    } else {
                        if (e.h(type2)) {
                            color2 = typedArray.getColor(i2, type2);
                        } else {
                            color2 = typedArray.getInt(i2, type2);
                        }
                    }
                    if (type2 != null) {
                        if (type2 == type2) {
                            color = (int)(typedArray.getDimension(i3, 0.0f));
                        } else {
                            if (e.h(type2)) {
                                color = typedArray.getColor(i3, type2);
                            } else {
                                color = typedArray.getInt(i3, type2);
                            }
                        }
                        iArr2 = new int[i6];
                        PropertyValuesHolder _int2 = PropertyValuesHolder.ofInt(str, new int[] { color2, color });
                    } else {
                        int[] iArr3 = new int[type2];
                        PropertyValuesHolder _int3 = PropertyValuesHolder.ofInt(str, new int[] { color2 });
                    }
                } else {
                    if (type2 != null) {
                        if (type2 == type2) {
                            color = (int)(typedArray.getDimension(i3, 0.0f));
                        } else {
                            if (e.h(type2)) {
                                color = typedArray.getColor(i3, type2);
                            } else {
                                color = typedArray.getInt(i3, type2);
                            }
                        }
                        iArr = new int[type2];
                        PropertyValuesHolder _int = PropertyValuesHolder.ofInt(str, new int[] { color });
                    }
                }
            }
            if (i != 0 && fVar != null) {
                i.setEvaluator(fVar);
            }
        }
        return typedArray2;
    }

    private static int f(TypedArray typedArray, int i, int i2) {
        int type2 = 1;
        boolean z;
        TypedValue peekValue2 = typedArray.peekValue(i);
        type2 = 1;
        type2 = 0;
        int r2 = peekValue2 != null ? 1 : type2;
        i = type2 != null ? peekValue2.type : type2;
        TypedValue peekValue = typedArray.peekValue(i2);
        if (peekValue == null) {
        }
        typedArray = type2 != null ? peekValue.type : type2;
        if (type2 == null || !e.h(type2)) {
            if (type2 != null && e.h(type2)) {
                type2 = 3;
            }
        }
        return type2;
    }

    private static int g(Resources resources, Resources.Theme theme, AttributeSet set, XmlPullParser xmlPullParser) {
        int set32 = 0;
        final TypedArray typedArray = g.s(resources, theme, set, a.j);
        set32 = 0;
        TypedValue typedValue = g.t(typedArray, xmlPullParser, "value", set32);
        xmlPullParser = typedValue != null ? 1 : set32;
        if (set32 != null) {
            if (e.h(typedValue.type)) {
                set32 = 3;
            }
        }
        typedArray.recycle();
        return set32;
    }

    public static Animator i(Context context, int i) throws Resources.NotFoundException {
        Animator animator;
        i = 24;
        if (Build.VERSION.SDK_INT >= 24) {
            animator = AnimatorInflater.loadAnimator(context, i);
        } else {
            animator = e.j(context, context.getResources(), context.getTheme(), i);
        }
        return animator;
    }

    public static Animator j(Context context, Resources resources, Resources.Theme theme, int i) {
        return e.k(context, resources, theme, i, 1f);
    }

    public static Animator k(Context context, Resources resources, Resources.Theme theme, int i, float f) {
        try {
            XmlResourceParser animation = resources.getAnimation(i);
        } catch (Throwable th) {
        }
        if (animation != null) {
            animation.close();
        }
        return e.a(context, resources, theme, animation, f);
    }

    private static ValueAnimator l(Context context, Resources resources, Resources.Theme theme, AttributeSet set, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) {
        TypedArray typedArray = g.s(resources, theme, set, a.g);
        final TypedArray typedArray2 = g.s(resources, theme, set, a.k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        e.q(valueAnimator, typedArray, typedArray2, f, xmlPullParser);
        final int i2 = 0;
        int i = g.l(typedArray, xmlPullParser, "interpolator", i2, i2);
        if (i > 0) {
            valueAnimator.setInterpolator(d.b(context, i));
        }
        typedArray.recycle();
        if (typedArray2 != null) {
            typedArray2.recycle();
        }
        return valueAnimator;
    }

    private static Keyframe m(Context context, Resources resources, Resources.Theme theme, AttributeSet set, int i, XmlPullParser xmlPullParser) {
        int set42;
        Keyframe _float = null;
        final TypedArray typedArray = g.s(resources, theme, set, a.j);
        set42 = 3;
        float f2 = g.j(typedArray, xmlPullParser, "fraction", set42, -1f);
        String str = "value";
        set42 = 0;
        final TypedValue typedValue = g.t(typedArray, xmlPullParser, str, set42);
        set42 = 1;
        int r4 = set42;
        if (i == 4) {
            if (set42 != null) {
                i = set42;
            }
        }
        if (set42 != null) {
            if (typedValue.type == 0) {
                _float = Keyframe.ofFloat(f2, g.j(typedArray, xmlPullParser, str, set42, 0.0f));
            } else {
                if (typedValue.type == set42 || typedValue.type == set42) {
                    _float = Keyframe.ofInt(f2, g.k(typedArray, xmlPullParser, str, set42, set42));
                } else {
                    int i3 = 0;
                }
            }
        } else {
            if (typedValue.type == 0) {
                _float = Keyframe.ofFloat(f2);
            } else {
                _float = Keyframe.ofInt(f2);
            }
        }
        int i7 = g.l(typedArray, xmlPullParser, "interpolator", set42, set42);
        if (i7 > 0) {
            _float.setInterpolator(d.b(context, i7));
        }
        typedArray.recycle();
        return _float;
    }

    private static ObjectAnimator n(Context context, Resources resources, Resources.Theme theme, AttributeSet set, float f, XmlPullParser xmlPullParser) {
        final ObjectAnimator objectAnimator = new ObjectAnimator();
        e.l(context, resources, theme, set, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder o(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int cmp;
        int resources22 = 0;
        Resources.Theme theme32;
        int cmp2;
        AttributeSet attributeSet;
        int i62;
        XmlPullParser xmlPullParser42;
        int size;
        float fraction2;
        resources22 = 0;
        int next = xmlPullParser.next();
        int i3 = 3;
        while (next != i3) {
        }
        if (resources22 != 0 && size > 0) {
            resources22 = 0;
            Object item = resources22.get(resources22);
            Object item2 = resources22.get(size - 1);
            float fraction = item2.getFraction();
            float f = 1f;
            float f2 = 0.0f;
            if (fraction < f) {
                if (fraction < 0.0f) {
                    item2.setFraction(f);
                } else {
                    resources22.add(resources22.size(), e.c(item2, f));
                    size = size + 1;
                }
            }
            fraction2 = item.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    item.setFraction(0.0f);
                } else {
                    resources22.add(resources22, e.c(item, 0.0f));
                    size = size + 1;
                }
            }
            Keyframe[] arr = new Keyframe[size];
            resources22.toArray(arr);
            while (resources22 < size) {
                Keyframe keyframe7 = arr[resources22];
                float fraction3 = keyframe7.getFraction();
                resources22 = resources22 + 1;
            }
            if (i62 == i3) {
                PropertyValuesHolder.ofKeyframe(str, arr).setEvaluator(f.a());
            }
        }
        return resources22;
    }

    private static PropertyValuesHolder[] p(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet set) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        int eventType;
        PropertyValuesHolder propertyValuesHolder;
        int i = 3;
        Resources resources22;
        int i3 = 2;
        XmlPullParser xmlPullParser42;
        String str;
        int i2;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        Resources.Theme theme32;
        AttributeSet set52;
        TypedArray typedArray;
        xmlPullParser42 = xmlPullParser;
        i4 = 0;
        eventType = xmlPullParser.getEventType();
        i5 = 0;
        i = 3;
        while (eventType != i) {
            i6 = 1;
        }
        if (i4 != 0) {
            eventType = i4.size();
            while (i5 < eventType) {
                new PropertyValuesHolder[eventType][i5] = (PropertyValuesHolder)i4.get(i5);
                i5 = i5 + 1;
            }
        }
        return i4;
    }

    private static void q(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        int i;
        final int i5 = 1;
        final int i12 = 0;
        final int i13 = 4;
        if (g.r(xmlPullParser, "valueFrom")) {
            if (g.r(xmlPullParser, "valueTo") && g.k(typedArray, xmlPullParser, "valueType", 7, i13) == i13) {
                i = e.f(typedArray, i2, i11);
                str = "";
                PropertyValuesHolder propertyValuesHolder = e.e(typedArray, i, i2, i11, str);
                if (propertyValuesHolder != null) {
                    PropertyValuesHolder[] arr = new PropertyValuesHolder[i5];
                    valueAnimator.setValues(new PropertyValuesHolder[] { propertyValuesHolder });
                }
            }
        }
        valueAnimator.setDuration((long)(g.k(typedArray, xmlPullParser, "duration", i5, 300)));
        valueAnimator.setStartDelay((long)(g.k(typedArray, xmlPullParser, "startOffset", 2, i12)));
        valueAnimator.setRepeatCount(g.k(typedArray, xmlPullParser, "repeatCount", 3, i12));
        valueAnimator.setRepeatMode(g.k(typedArray, xmlPullParser, "repeatMode", i13, i5));
        if (typedArray2 != null) {
            e.r(valueAnimator, typedArray2, i, f, xmlPullParser);
        }
    }

    private static void r(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) throws InflateException {
        String str5 = g.m(typedArray, xmlPullParser, "pathData", 1);
        if (str5 != null) {
            i = 2;
            String str = g.m(typedArray, xmlPullParser, "propertyXName", i);
            int i2 = 3;
            str2 = "propertyYName";
            String str3 = g.m(typedArray, xmlPullParser, str2, i2);
            if (i != i) {
                i = 4;
            }
            f = 0.5f;
            f2 = f * f;
            e.s(c.e(str5), valueAnimator, f2, str, str3);
        } else {
            valueAnimator.setPropertyName(g.m(typedArray, xmlPullParser, "propertyName", 0));
        }
    }

    private static void s(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        PropertyValuesHolder _float;
        int size;
        float[] fArr = null;
        boolean z;
        int i3;
        Path path2 = path;
        final Object objectAnimator22 = objectAnimator;
        String str42 = str;
        str52 = str2;
        z = false;
        PathMeasure pathMeasure = new PathMeasure(path2, z);
        final ArrayList arrayList = new ArrayList();
        f = 0.0f;
        arrayList.add(Float.valueOf(f));
        f = f + pathMeasure.getLength();
        arrayList.add(Float.valueOf(f));
        while (!pathMeasure.nextContour()) {
            f = f + pathMeasure.getLength();
            arrayList.add(Float.valueOf(f));
        }
        PathMeasure pathMeasure2 = new PathMeasure(path2, z);
        int i2 = 1;
        int min = Math.min(100, (int)(f / f) + i2);
        float[] fArr2 = new float[min];
        final float[] fArr3 = new float[min];
        size = 2;
        final float[] fArr4 = new float[size];
        fArr = null;
        while (z < min) {
            pathMeasure2.getPosTan(f - (Float)arrayList.get(i3).floatValue(), fArr4, fArr);
            fArr2[z] = fArr4[z];
            fArr3[z] = fArr4[1];
            f = f + (f / (float)(min - 1));
            i3 = i3 + 1;
        }
        if (str42 != null) {
            _float = PropertyValuesHolder.ofFloat(str42, fArr2);
        } else {
        }
        if (str52 != null) {
            PropertyValuesHolder _float2 = PropertyValuesHolder.ofFloat(str52, fArr3);
        }
        if (_float == null) {
            int i = 1;
            PropertyValuesHolder[] arr = new PropertyValuesHolder[i];
            arr[z] = fArr;
            objectAnimator22.setValues(arr);
        } else {
            i = 1;
            if (fArr == null) {
                PropertyValuesHolder[] arr2 = new PropertyValuesHolder[i];
                arr2[z] = _float;
                objectAnimator22.setValues(arr2);
            } else {
                PropertyValuesHolder[] arr3 = new PropertyValuesHolder[2];
                arr3[z] = _float;
                arr3[i] = fArr;
                objectAnimator22.setValues(arr3);
            }
        }
    }

    private static boolean h(int i) {
        int i2 = 28;
        boolean z = false;
        i2 = 28;
        i = i >= 28 && i <= 31 ? 1 : 0;
        return (i >= 28 && i <= 31 ? 1 : 0);
    }
}

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
import android.util.Xml;
import android.view.InflateException;
import androidx.core.content.e.g;
import d.h.f.c;
import d.h.f.c.b;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class e {

    private static class a implements TypeEvaluator<c.b[]> {

        private c.b[] a;
        @Override // android.animation.TypeEvaluator
        public c.b[] a(float f, c.b[] c$b2Arr2, c.b[] c$b3Arr3) {
            boolean z;
            int i;
            c.b bVar;
            c.b bVar2;
            c.b bVar3;
            if (!c.b(b2Arr2, b3Arr3)) {
            } else {
                if (!c.b(this.a, b2Arr2)) {
                    this.a = c.f(b2Arr2);
                }
                i = 0;
                for (Object bVar2 : b2Arr2) {
                    this.a[i].d(bVar2, b3Arr3[i], f);
                }
                return this.a;
            }
            IllegalArgumentException obj5 = new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            throw obj5;
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object object2, Object object3) {
            return a(f, (c.b[])object2, (c.b[])object3);
        }
    }
    private static Animator a(Context context, Resources resources2, Resources.Theme resources$Theme3, XmlPullParser xmlPullParser4, float f5) {
        return e.b(context, resources2, theme3, xmlPullParser4, Xml.asAttributeSet(xmlPullParser4), 0, 0, f5);
    }

    private static Animator b(Context context, Resources resources2, Resources.Theme resources$Theme3, XmlPullParser xmlPullParser4, AttributeSet attributeSet5, AnimatorSet animatorSet6, int i7, float f8) {
        int i;
        Resources next2;
        Resources.Theme iterator;
        Context next;
        AttributeSet set2;
        AttributeSet set;
        AnimatorSet set3;
        int i3;
        float f;
        int arrayList;
        int i2;
        AnimatorSet animatorSet;
        int i4;
        TypedArray typedArray;
        final Resources resources = resources2;
        final Resources.Theme theme = theme3;
        final XmlPullParser xmlPullParser2 = xmlPullParser4;
        final Object obj = animatorSet6;
        arrayList = i;
        next2 = xmlPullParser4.next();
        i2 = 0;
        while (next2 == 3) {
            iterator = 1;
            String name = xmlPullParser4.getName();
            next2 = e.p(context, resources, theme, xmlPullParser2, Xml.asAttributeSet(xmlPullParser4));
            if (next2 != null && i instanceof ValueAnimator) {
            }
            i2 = iterator;
            if (obj != null && i2 == 0 && arrayList == null) {
            }
            next2 = xmlPullParser4.next();
            i2 = 0;
            if (i2 == 0) {
            }
            if (arrayList == null) {
            }
            arrayList.add(i);
            arrayList = new ArrayList();
            if (i instanceof ValueAnimator) {
            }
            (ValueAnimator)i.setValues(next2);
            animatorSet = new AnimatorSet();
            TypedArray typedArray2 = g.s(resources, theme, attributeSet5, a.h);
            e.b(context, resources2, theme3, xmlPullParser4, attributeSet5, animatorSet, g.k(typedArray2, xmlPullParser2, "ordering", i2, i2), f8);
            typedArray2.recycle();
            next = context;
            i = animatorSet;
            i = e.l(context, resources2, theme3, attributeSet5, 0, f8, xmlPullParser4);
            next = context;
            i = e.n(context, resources2, theme3, attributeSet5, f8, xmlPullParser4);
        }
        if (obj != null && arrayList != null) {
            if (arrayList != null) {
                next2 = new Animator[arrayList.size()];
                iterator = arrayList.iterator();
                for (Animator next : iterator) {
                    next2[i2] = next;
                    i2 = set;
                }
                if (i7 == 0) {
                    obj.playTogether(next2);
                } else {
                    obj.playSequentially(next2);
                }
            }
        }
        return i;
    }

    private static Keyframe c(Keyframe keyframe, float f2) {
        Class tYPE;
        Keyframe obj2;
        if (keyframe.getType() == Float.TYPE) {
            obj2 = Keyframe.ofFloat(f2);
        } else {
            if (keyframe.getType() == Integer.TYPE) {
                obj2 = Keyframe.ofInt(f2);
            } else {
                obj2 = Keyframe.ofObject(f2);
            }
        }
        return obj2;
    }

    private static void d(Keyframe[] keyframeArr, float f2, int i3, int i4) {
        float f;
        int i;
        int obj4;
        while (obj4 <= i4) {
            keyframeArr[obj4].setFraction(fraction += obj3);
            obj4++;
        }
    }

    private static PropertyValuesHolder e(TypedArray typedArray, int i2, int i3, int i4, String string5) {
        int aVar;
        int i6;
        int type;
        int i8;
        int i;
        int i7;
        int object;
        int i5;
        PropertyValuesHolder obj11;
        boolean obj12;
        int obj13;
        int obj14;
        android.util.TypedValue peekValue = typedArray.peekValue(i3);
        final int i9 = 1;
        final int i10 = 0;
        i6 = peekValue != null ? i9 : i10;
        aVar = i6 != 0 ? peekValue.type : i10;
        android.util.TypedValue peekValue2 = typedArray.peekValue(i4);
        i8 = peekValue2 != null ? i9 : i10;
        type = i8 != 0 ? peekValue2.type : i10;
        i7 = 3;
        if (i2 == 4) {
            if (i6 != 0) {
                if (!e.h(aVar)) {
                    if (i8 != 0 && e.h(type)) {
                        obj12 = e.h(type) ? i7 : i10;
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
        i = obj12 == null ? i9 : i10;
        final int i12 = 2;
        if (obj12 == i12) {
            obj12 = typedArray.getString(i3);
            obj11 = typedArray.getString(i4);
            obj13 = c.d(obj12);
            obj14 = c.d(obj11);
            if (obj13 == null) {
                if (obj14 != null) {
                    if (obj13 != null) {
                        aVar = new e.a();
                        if (obj14 != null) {
                            if (!c.b(obj13, obj14)) {
                            } else {
                                obj11 = new Object[i12];
                                obj11[i10] = obj13;
                                obj11[i9] = obj14;
                                obj11 = PropertyValuesHolder.ofObject(string5, aVar, obj11);
                                object = obj11;
                            }
                            obj14 = new StringBuilder();
                            obj14.append(" Can't morph from ");
                            obj14.append(obj12);
                            obj14.append(" to ");
                            obj14.append(obj11);
                            obj13 = new InflateException(obj14.toString());
                            throw obj13;
                        }
                        obj11 = new Object[i9];
                        obj11[i10] = obj13;
                        obj11 = PropertyValuesHolder.ofObject(string5, aVar, obj11);
                    } else {
                        if (obj14 != null) {
                            obj11 = new e.a();
                            obj12 = new Object[i9];
                            obj12[i10] = obj14;
                            object = PropertyValuesHolder.ofObject(string5, obj11, obj12);
                        }
                    }
                }
            } else {
            }
        } else {
            if (obj12 == i7) {
                obj12 = f.a();
            } else {
                obj12 = object;
            }
            i7 = 5;
            i5 = 0;
            if (i != 0) {
                if (i6 != 0) {
                    if (aVar == i7) {
                        obj13 = typedArray.getDimension(i3, i5);
                    } else {
                        obj13 = typedArray.getFloat(i3, i5);
                    }
                    if (i8 != 0) {
                        if (type == i7) {
                            obj11 = typedArray.getDimension(i4, i5);
                        } else {
                            obj11 = typedArray.getFloat(i4, i5);
                        }
                        obj14 = new float[i12];
                        obj14[i10] = obj13;
                        obj14[i9] = obj11;
                        obj11 = PropertyValuesHolder.ofFloat(string5, obj14);
                    } else {
                        obj11 = new float[i9];
                        obj11[i10] = obj13;
                        obj11 = PropertyValuesHolder.ofFloat(string5, obj11);
                    }
                } else {
                    if (type == i7) {
                        obj11 = typedArray.getDimension(i4, i5);
                    } else {
                        obj11 = typedArray.getFloat(i4, i5);
                    }
                    obj13 = new float[i9];
                    obj13[i10] = obj11;
                    obj11 = PropertyValuesHolder.ofFloat(string5, obj13);
                }
                object = obj11;
            } else {
                if (i6 != 0) {
                    if (aVar == i7) {
                        obj13 = (int)obj13;
                    } else {
                        if (e.h(aVar)) {
                            obj13 = typedArray.getColor(i3, i10);
                        } else {
                            obj13 = typedArray.getInt(i3, i10);
                        }
                    }
                    if (i8 != 0) {
                        if (type == i7) {
                            obj11 = (int)obj11;
                        } else {
                            if (e.h(type)) {
                                obj11 = typedArray.getColor(i4, i10);
                            } else {
                                obj11 = typedArray.getInt(i4, i10);
                            }
                        }
                        obj14 = new int[i12];
                        obj14[i10] = obj13;
                        obj14[i9] = obj11;
                        object = PropertyValuesHolder.ofInt(string5, obj14);
                    } else {
                        obj11 = new int[i9];
                        obj11[i10] = obj13;
                        object = PropertyValuesHolder.ofInt(string5, obj11);
                    }
                } else {
                    if (i8 != 0) {
                        if (type == i7) {
                            obj11 = (int)obj11;
                        } else {
                            if (e.h(type)) {
                                obj11 = typedArray.getColor(i4, i10);
                            } else {
                                obj11 = typedArray.getInt(i4, i10);
                            }
                        }
                        obj13 = new int[i9];
                        obj13[i10] = obj11;
                        object = PropertyValuesHolder.ofInt(string5, obj13);
                    }
                }
            }
            if (object != null && obj12 != null) {
                if (obj12 != null) {
                    object.setEvaluator(obj12);
                }
            }
        }
        return object;
    }

    private static int f(TypedArray typedArray, int i2, int i3) {
        int i4;
        int i5;
        int i;
        int obj3;
        int obj4;
        obj4 = typedArray.peekValue(i2);
        i5 = 0;
        i = obj4 != null ? i4 : i5;
        obj4 = i != 0 ? obj4.type : i5;
        obj3 = typedArray.peekValue(i3);
        if (obj3 != null) {
        } else {
            i4 = i5;
        }
        obj3 = i4 != 0 ? obj3.type : i5;
        if (i != 0) {
            if (!e.h(obj4)) {
                if (i4 != 0 && e.h(obj3)) {
                    if (e.h(obj3)) {
                        i5 = 3;
                    }
                }
            } else {
            }
        } else {
        }
        return i5;
    }

    private static int g(Resources resources, Resources.Theme resources$Theme2, AttributeSet attributeSet3, XmlPullParser xmlPullParser4) {
        android.util.TypedValue obj2;
        int obj3;
        int obj4;
        final TypedArray obj1 = g.s(resources, theme2, attributeSet3, a.j);
        obj3 = 0;
        obj2 = g.t(obj1, xmlPullParser4, "value", obj3);
        obj4 = obj2 != null ? 1 : obj3;
        if (obj4 != null && e.h(obj2.type)) {
            if (e.h(obj2.type)) {
                obj3 = 3;
            }
        }
        obj1.recycle();
        return obj3;
    }

    private static boolean h(int i) {
        int i2;
        int obj1;
        if (i >= 28 && i <= 31) {
            obj1 = i <= 31 ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static Animator i(Context context, int i2) {
        int sDK_INT;
        int theme;
        Animator obj2;
        if (Build.VERSION.SDK_INT >= 24) {
            obj2 = AnimatorInflater.loadAnimator(context, i2);
        } else {
            obj2 = e.j(context, context.getResources(), context.getTheme(), i2);
        }
        return obj2;
    }

    public static Animator j(Context context, Resources resources2, Resources.Theme resources$Theme3, int i4) {
        return e.k(context, resources2, theme3, i4, 1065353216);
    }

    public static Animator k(Context context, Resources resources2, Resources.Theme resources$Theme3, int i4, float f5) {
        final String str = "Can't load animation resource ID #0x";
        int i = 0;
        XmlResourceParser animation = resources2.getAnimation(i4);
        if (animation != null) {
            animation.close();
        }
        return e.a(context, resources2, theme3, animation, f5);
    }

    private static ValueAnimator l(Context context, Resources resources2, Resources.Theme resources$Theme3, AttributeSet attributeSet4, ValueAnimator valueAnimator5, float f6, XmlPullParser xmlPullParser7) {
        Object obj2;
        ValueAnimator obj6;
        TypedArray typedArray = g.s(resources2, theme3, attributeSet4, a.g);
        final TypedArray obj3 = g.s(resources2, theme3, attributeSet4, a.k);
        if (valueAnimator5 == null) {
            obj6 = new ValueAnimator();
        }
        e.q(obj6, typedArray, obj3, f6, xmlPullParser7);
        final int obj5 = 0;
        int obj4 = g.l(typedArray, xmlPullParser7, "interpolator", obj5, obj5);
        if (obj4 > 0) {
            obj6.setInterpolator(d.b(context, obj4));
        }
        typedArray.recycle();
        if (obj3 != null) {
            obj3.recycle();
        }
        return obj6;
    }

    private static Keyframe m(Context context, Resources resources2, Resources.Theme resources$Theme3, AttributeSet attributeSet4, int i5, XmlPullParser xmlPullParser6) {
        int i;
        Object obj6;
        Keyframe obj8;
        float obj9;
        int obj10;
        final TypedArray obj7 = g.s(resources2, theme3, attributeSet4, a.j);
        obj9 = 3;
        obj8 = g.j(obj7, xmlPullParser6, "fraction", obj9, -1082130432);
        String str = "value";
        final int i3 = 0;
        final android.util.TypedValue typedValue = g.t(obj7, xmlPullParser6, str, i3);
        final int i4 = 1;
        i = typedValue != null ? i4 : i3;
        if (i5 == 4) {
            if (i != 0 && e.h(typedValue.type)) {
                obj10 = e.h(typedValue.type) ? obj9 : i3;
            } else {
            }
        }
        if (i != 0) {
            if (obj10 != null) {
                if (obj10 != i4 && obj10 != obj9) {
                    if (obj10 != obj9) {
                        obj8 = 0;
                    } else {
                        obj8 = Keyframe.ofInt(obj8, g.k(obj7, xmlPullParser6, str, i3, i3));
                    }
                } else {
                }
            } else {
                obj8 = Keyframe.ofFloat(obj8, g.j(obj7, xmlPullParser6, str, i3, 0));
            }
        } else {
            if (obj10 == null) {
                obj8 = Keyframe.ofFloat(obj8);
            } else {
                obj8 = Keyframe.ofInt(obj8);
            }
        }
        obj9 = g.l(obj7, xmlPullParser6, "interpolator", i4, i3);
        if (obj9 > 0) {
            obj8.setInterpolator(d.b(context, obj9));
        }
        obj7.recycle();
        return obj8;
    }

    private static ObjectAnimator n(Context context, Resources resources2, Resources.Theme resources$Theme3, AttributeSet attributeSet4, float f5, XmlPullParser xmlPullParser6) {
        ObjectAnimator objectAnimator2 = new ObjectAnimator();
        e.l(context, resources2, theme3, attributeSet4, objectAnimator2, f5, xmlPullParser6);
        return objectAnimator2;
    }

    private static PropertyValuesHolder o(Context context, Resources resources2, Resources.Theme resources$Theme3, XmlPullParser xmlPullParser4, String string5, int i6) {
        float fraction;
        int fraction2;
        int keyframe;
        int arrayList;
        boolean equals;
        int next;
        Object str;
        int cmp;
        AttributeSet attributeSet;
        int i;
        XmlPullParser xmlPullParser;
        int i2;
        int obj9;
        int obj10;
        Object obj11;
        Object obj12;
        int obj14;
        arrayList = keyframe;
        next = xmlPullParser4.next();
        int i7 = 3;
        while (next != i7) {
            if (next != 1) {
            }
            if (xmlPullParser4.getName().equals("keyframe") && obj14 == 4) {
            }
            next = xmlPullParser4.next();
            i7 = 3;
            if (obj14 == 4) {
            }
            equals = e.m(context, resources2, theme3, Xml.asAttributeSet(xmlPullParser4), obj14, xmlPullParser4);
            if (equals != null && arrayList == null) {
            }
            xmlPullParser4.next();
            if (arrayList == null) {
            }
            arrayList.add(equals);
            arrayList = new ArrayList();
            obj14 = e.g(resources2, theme3, Xml.asAttributeSet(xmlPullParser4), xmlPullParser4);
        }
        obj9 = arrayList.size();
        obj10 = 0;
        obj11 = arrayList.get(obj10);
        obj12 = arrayList.get(obj9 + -1);
        fraction = (Keyframe)obj12.getFraction();
        next = 1065353216;
        attributeSet = 0;
        if (arrayList != null && obj9 > 0 && Float.compare(fraction, next) < 0) {
            obj9 = arrayList.size();
            if (obj9 > 0) {
                obj10 = 0;
                obj11 = arrayList.get(obj10);
                obj12 = arrayList.get(obj9 + -1);
                fraction = (Keyframe)obj12.getFraction();
                next = 1065353216;
                attributeSet = 0;
                if (Float.compare(fraction, next) < 0) {
                    if (Float.compare(fraction, attributeSet) < 0) {
                        obj12.setFraction(next);
                    } else {
                        arrayList.add(arrayList.size(), e.c(obj12, next));
                        obj9++;
                    }
                }
                obj12 = (Keyframe)(Keyframe)obj11.getFraction();
                if (Float.compare(obj12, attributeSet) != 0) {
                    if (Float.compare(obj12, attributeSet) < 0) {
                        obj11.setFraction(attributeSet);
                    } else {
                        arrayList.add(obj10, e.c(obj11, attributeSet));
                        obj9++;
                    }
                }
                obj11 = new Keyframe[obj9];
                arrayList.toArray(obj11);
                while (obj10 < obj9) {
                    obj12 = obj11[obj10];
                    if (Float.compare(fraction3, attributeSet) < 0) {
                    }
                    obj10++;
                    if (obj10 == null) {
                    } else {
                    }
                    fraction2 = obj9 + -1;
                    if (obj10 == fraction2) {
                    } else {
                    }
                    obj12 = obj10 + 1;
                    arrayList = obj10;
                    while (obj12 < fraction2) {
                        if (Float.compare(fraction4, attributeSet) >= 0) {
                            break loop_29;
                        } else {
                        }
                        arrayList = obj12;
                        obj12 = i2;
                    }
                    e.d(obj11, obj12 -= fraction2, obj10, arrayList);
                    if (Float.compare(fraction4, attributeSet) >= 0) {
                    } else {
                    }
                    arrayList = obj12;
                    obj12 = i2;
                    obj12.setFraction(next);
                    obj12.setFraction(attributeSet);
                }
                if (obj14 == i7) {
                    PropertyValuesHolder.ofKeyframe(string5, obj11).setEvaluator(f.a());
                }
            }
        }
        return keyframe;
    }

    private static PropertyValuesHolder[] p(Context context, Resources resources2, Resources.Theme resources$Theme3, XmlPullParser xmlPullParser4, AttributeSet attributeSet5) {
        int eventType;
        int arrayList;
        int i2;
        XmlPullParser str3;
        String str;
        int i3;
        int arr;
        int i6;
        int i5;
        int i;
        Resources resources;
        Resources.Theme theme;
        AttributeSet set;
        TypedArray typedArray;
        String str2;
        int i4;
        final XmlPullParser xmlPullParser = xmlPullParser4;
        i6 = arr;
        eventType = xmlPullParser4.getEventType();
        arrayList = 3;
        while (eventType != arrayList) {
            i = 1;
            if (eventType != i) {
            }
            i2 = 2;
            if (eventType != i2) {
            } else {
            }
            if (xmlPullParser4.getName().equals("propertyValuesHolder")) {
            } else {
            }
            resources = resources2;
            theme = theme3;
            set = attributeSet5;
            xmlPullParser4.next();
            eventType = xmlPullParser4.getEventType();
            arrayList = 3;
            typedArray = g.s(resources2, theme3, attributeSet5, a.i);
            str2 = g.m(typedArray, xmlPullParser, "propertyName", arrayList);
            i3 = g.k(typedArray, xmlPullParser, "valueType", i2, 4);
            if (e.o(context, resources2, theme3, xmlPullParser4, str2, i3) == null) {
            }
            if (eventType != null && i6 == 0) {
            }
            typedArray.recycle();
            if (i6 == 0) {
            }
            i6.add(eventType);
            arrayList = new ArrayList();
            i6 = arrayList;
            eventType = e.e(typedArray, i3, 0, i, str2);
            xmlPullParser4.next();
        }
        if (i6 != 0) {
            eventType = i6.size();
            while (i5 < eventType) {
                new PropertyValuesHolder[eventType][i5] = (PropertyValuesHolder)i6.get(i5);
                i5++;
            }
        }
        return arr;
    }

    private static void q(ValueAnimator valueAnimator, TypedArray typedArray2, TypedArray typedArray3, float f4, XmlPullParser xmlPullParser5) {
        int i;
        boolean z;
        int arr;
        String str;
        final int i4 = 1;
        final int i11 = 0;
        final int i12 = 4;
        int i10 = 6;
        arr = 5;
        if (g.r(xmlPullParser5, "valueFrom") && g.r(xmlPullParser5, "valueTo") && g.k(typedArray2, xmlPullParser5, "valueType", 7, i12) == i12) {
            if (g.r(xmlPullParser5, "valueTo")) {
                i10 = 6;
                arr = 5;
                if (g.k(typedArray2, xmlPullParser5, "valueType", 7, i12) == i12) {
                    i = e.f(typedArray2, arr, i10);
                }
                z = e.e(typedArray2, i, arr, i10, "");
                if (z != null) {
                    arr = new PropertyValuesHolder[i4];
                    arr[i11] = z;
                    valueAnimator.setValues(arr);
                }
            }
        }
        valueAnimator.setDuration((long)i2);
        valueAnimator.setStartDelay((long)i3);
        valueAnimator.setRepeatCount(g.k(typedArray2, xmlPullParser5, "repeatCount", 3, i11));
        valueAnimator.setRepeatMode(g.k(typedArray2, xmlPullParser5, "repeatMode", i12, i4));
        if (typedArray3 != null) {
            e.r(valueAnimator, typedArray3, i, f4, xmlPullParser5);
        }
    }

    private static void r(ValueAnimator valueAnimator, TypedArray typedArray2, int i3, float f4, XmlPullParser xmlPullParser5) {
        String i2;
        int i;
        int i4;
        String str;
        Object obj6;
        int obj7;
        int obj8;
        Object obj9;
        String str3 = g.m(typedArray2, xmlPullParser5, "pathData", 1);
        if (str3 != null) {
            i = 2;
            i2 = g.m(typedArray2, xmlPullParser5, "propertyXName", i);
            obj9 = g.m(typedArray2, xmlPullParser5, "propertyYName", 3);
            if (i3 != i) {
                i = 4;
            }
            if (i2 == null) {
                if (obj9 == null) {
                } else {
                }
                obj7 = new StringBuilder();
                obj7.append(typedArray2.getPositionDescription());
                obj7.append(" propertyXName or propertyYName is needed for PathData");
                InflateException obj5 = new InflateException(obj7.toString());
                throw obj5;
            }
            e.s(c.e(str3), (ObjectAnimator)valueAnimator, f4 *= obj7, i2, obj9);
        } else {
            valueAnimator.setPropertyName(g.m(typedArray2, xmlPullParser5, "propertyName", 0));
        }
    }

    private static void s(Path path, ObjectAnimator objectAnimator2, float f3, String string4, String string5) {
        PropertyValuesHolder float;
        int arr;
        String arr2;
        int i2;
        int i3;
        boolean nextContour;
        int i4;
        int size;
        int float2;
        int i5;
        int i;
        float floatValue;
        Path path2 = path;
        final Object obj = objectAnimator2;
        String str = string4;
        arr2 = string5;
        final int i9 = 0;
        PathMeasure pathMeasure = new PathMeasure(path2, i9);
        ArrayList arrayList = new ArrayList();
        i2 = 0;
        arrayList.add(Float.valueOf(i2));
        i3 = i2;
        i3 += length;
        arrayList.add(Float.valueOf(i3));
        while (!pathMeasure.nextContour()) {
            i3 += length;
            arrayList.add(Float.valueOf(i3));
        }
        PathMeasure pathMeasure2 = new PathMeasure(path2, i9);
        int i7 = Math.min(100, i12 += i4);
        float[] fArr = new float[i7];
        final float[] fArr2 = new float[i7];
        final float[] fArr3 = new float[2];
        i = i5;
        float2 = 0;
        while (i5 < i7) {
            pathMeasure2.getPosTan(i2 - floatValue, fArr3, float2);
            fArr[i5] = fArr3[i9];
            fArr2[i5] = fArr3[1];
            int i16 = i + 1;
            if (i16 < arrayList.size() && Float.compare(i2, floatValue2) > 0) {
            }
            i5++;
            i4 = 1;
            float2 = 0;
            if (Float.compare(i2, floatValue2) > 0) {
            }
            pathMeasure2.nextContour();
            i = i16;
        }
        if (str != null) {
            float = PropertyValuesHolder.ofFloat(str, fArr);
        } else {
            float = float2;
        }
        if (arr2 != null) {
            float2 = PropertyValuesHolder.ofFloat(arr2, fArr2);
        }
        if (float == null) {
            float = new PropertyValuesHolder[1];
            float[i9] = float2;
            obj.setValues(float);
        } else {
            arr = 1;
            if (float2 == 0) {
                arr = new PropertyValuesHolder[arr];
                arr[i9] = float;
                obj.setValues(arr);
            } else {
                arr2 = new PropertyValuesHolder[2];
                arr2[i9] = float;
                arr2[arr] = float2;
                obj.setValues(arr2);
            }
        }
    }
}

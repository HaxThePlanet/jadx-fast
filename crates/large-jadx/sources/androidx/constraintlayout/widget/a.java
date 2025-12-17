package androidx.constraintlayout.widget;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import d.f.b.b.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class a {

    private boolean a = false;
    String b;
    private androidx.constraintlayout.widget.a.b c;
    private int d;
    private float e;
    private String f;
    boolean g;
    private int h;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            a.a.a = iArr;
            iArr[a.b.REFERENCE_TYPE.ordinal()] = 1;
            a.a.a[a.b.BOOLEAN_TYPE.ordinal()] = 2;
            a.a.a[a.b.STRING_TYPE.ordinal()] = 3;
            a.a.a[a.b.COLOR_TYPE.ordinal()] = 4;
            a.a.a[a.b.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            a.a.a[a.b.INT_TYPE.ordinal()] = 6;
            a.a.a[a.b.FLOAT_TYPE.ordinal()] = 7;
            a.a.a[a.b.DIMENSION_TYPE.ordinal()] = 8;
        }
    }

    public static enum b {

        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE;
    }
    public a(androidx.constraintlayout.widget.a a, Object object2) {
        super();
        int i = 0;
        this.b = a.b;
        this.c = a.c;
        f(object2);
    }

    public a(String string, androidx.constraintlayout.widget.a.b a$b2, Object object3, boolean z4) {
        super();
        final int i = 0;
        this.b = string;
        this.c = b2;
        this.a = z4;
        f(object3);
    }

    private static int a(int i) {
        obj1 += -255;
        return obj1 += 255;
    }

    public static HashMap<String, androidx.constraintlayout.widget.a> b(HashMap<String, androidx.constraintlayout.widget.a> hashMap, View view2) {
        Object next;
        Object obj;
        Object valueOf;
        androidx.constraintlayout.widget.a aVar;
        Class[] arr;
        HashMap hashMap2 = new HashMap();
        Iterator iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            obj = hashMap.get((String)next);
            if (next.equals("BackgroundColor")) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getMap");
            stringBuilder.append(next);
            int i = 0;
            aVar = new a((a)obj, view2.getClass().getMethod(stringBuilder.toString(), new Class[i]).invoke(view2, new Object[i]));
            hashMap2.put(next, aVar);
            aVar = new a(obj, Integer.valueOf((ColorDrawable)view2.getBackground().getColor()));
            hashMap2.put(next, aVar);
        }
        return hashMap2;
    }

    public static void c(Context context, XmlPullParser xmlPullParser2, HashMap<String, androidx.constraintlayout.widget.a> hashMap3) {
        int string;
        int valueOf;
        androidx.constraintlayout.widget.a.b cOLOR_DRAWABLE_TYPE;
        int bOOLEAN_TYPE;
        Integer valueOf2;
        int resourceId;
        int i2;
        int i;
        int displayMetrics;
        int upperCase;
        int i4;
        int i3;
        Integer num;
        androidx.constraintlayout.widget.a obj12;
        TypedArray obj13 = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser2), i.b4);
        final int i5 = 0;
        bOOLEAN_TYPE = valueOf;
        i = i2;
        while (i2 < obj13.getIndexCount()) {
            displayMetrics = obj13.getIndex(i2);
            i4 = 1;
            if (displayMetrics == i.c4) {
            } else {
            }
            if (displayMetrics == i.m4) {
            } else {
            }
            if (displayMetrics == i.d4) {
            } else {
            }
            if (displayMetrics == i.f4) {
            } else {
            }
            if (displayMetrics == i.e4) {
            } else {
            }
            i3 = 0;
            if (displayMetrics == i.j4) {
            } else {
            }
            if (displayMetrics == i.g4) {
            } else {
            }
            if (displayMetrics == i.h4) {
            } else {
            }
            i4 = -1;
            if (displayMetrics == i.i4) {
            } else {
            }
            if (displayMetrics == i.l4) {
            } else {
            }
            if (displayMetrics == i.k4) {
            }
            i2++;
            cOLOR_DRAWABLE_TYPE = a.b.REFERENCE_TYPE;
            if (obj13.getResourceId(displayMetrics, i4) == i4) {
            }
            valueOf2 = Integer.valueOf(resourceId);
            bOOLEAN_TYPE = cOLOR_DRAWABLE_TYPE;
            valueOf = num;
            resourceId = obj13.getInt(displayMetrics, i4);
            cOLOR_DRAWABLE_TYPE = a.b.STRING_TYPE;
            valueOf2 = obj13.getString(displayMetrics);
            cOLOR_DRAWABLE_TYPE = a.b.INT_TYPE;
            valueOf2 = Integer.valueOf(obj13.getInteger(displayMetrics, i4));
            cOLOR_DRAWABLE_TYPE = a.b.FLOAT_TYPE;
            valueOf2 = Float.valueOf(obj13.getFloat(displayMetrics, 2143289344));
            cOLOR_DRAWABLE_TYPE = a.b.DIMENSION_TYPE;
            valueOf2 = Float.valueOf(obj13.getDimension(displayMetrics, i3));
            cOLOR_DRAWABLE_TYPE = a.b.DIMENSION_TYPE;
            valueOf2 = Float.valueOf(TypedValue.applyDimension(i4, obj13.getDimension(displayMetrics, i3), context.getResources().getDisplayMetrics()));
            cOLOR_DRAWABLE_TYPE = a.b.COLOR_DRAWABLE_TYPE;
            valueOf2 = Integer.valueOf(obj13.getColor(displayMetrics, i5));
            cOLOR_DRAWABLE_TYPE = a.b.COLOR_TYPE;
            valueOf2 = Integer.valueOf(obj13.getColor(displayMetrics, i5));
            valueOf = Boolean.valueOf(obj13.getBoolean(displayMetrics, i5));
            bOOLEAN_TYPE = a.b.BOOLEAN_TYPE;
            string = obj13.getString(displayMetrics);
            i = i4;
            string = obj13.getString(displayMetrics);
            if (string != null && string.length() > 0) {
            }
            if (string.length() > 0) {
            }
            displayMetrics = new StringBuilder();
            displayMetrics.append(Character.toUpperCase(string.charAt(i5)));
            displayMetrics.append(string.substring(i4));
            string = displayMetrics.toString();
        }
        if (string != null && valueOf != 0) {
            if (valueOf != 0) {
                obj12 = new a(string, bOOLEAN_TYPE, valueOf, i);
                hashMap3.put(string, obj12);
            }
        }
        obj13.recycle();
    }

    public static void d(View view, HashMap<String, androidx.constraintlayout.widget.a> hashMap2) {
        Object string;
        Object valueOf;
        Object stringBuilder;
        String method;
        int i;
        Object[] arr;
        Class colorDrawable;
        final String str2 = "\" not found on ";
        final String str3 = " Custom Attribute \"";
        final String str4 = "TransitionLayout";
        final Class class = view.getClass();
        Iterator iterator = hashMap2.keySet().iterator();
        while (iterator.hasNext()) {
            string = iterator.next();
            valueOf = hashMap2.get((String)string);
            if (!valueOf.a) {
            } else {
            }
            stringBuilder = string;
            i = 0;
            arr = 1;
            Class[] arr6 = new Class[arr];
            arr6[i] = Float.TYPE;
            arr = new Object[arr];
            arr[i] = Float.valueOf(valueOf.e);
            class.getMethod(stringBuilder, arr6).invoke(view, arr);
            Class[] arr9 = new Class[arr];
            arr9[i] = Float.TYPE;
            arr = new Object[arr];
            arr[i] = Float.valueOf(valueOf.e);
            class.getMethod(stringBuilder, arr9).invoke(view, arr);
            Class[] arr4 = new Class[arr];
            arr4[i] = Integer.TYPE;
            arr = new Object[arr];
            arr[i] = Integer.valueOf(valueOf.d);
            class.getMethod(stringBuilder, arr4).invoke(view, arr);
            Class[] arr7 = new Class[arr];
            arr7[i] = Drawable.class;
            colorDrawable = new ColorDrawable();
            colorDrawable.setColor(valueOf.h);
            valueOf = new Object[arr];
            valueOf[i] = colorDrawable;
            class.getMethod(stringBuilder, arr7).invoke(view, valueOf);
            Class[] arr2 = new Class[arr];
            arr2[i] = Integer.TYPE;
            arr = new Object[arr];
            arr[i] = Integer.valueOf(valueOf.h);
            class.getMethod(stringBuilder, arr2).invoke(view, arr);
            Class[] arr5 = new Class[arr];
            arr5[i] = CharSequence.class;
            arr = new Object[arr];
            arr[i] = valueOf.f;
            class.getMethod(stringBuilder, arr5).invoke(view, arr);
            Class[] arr8 = new Class[arr];
            arr8[i] = Boolean.TYPE;
            arr = new Object[arr];
            arr[i] = Boolean.valueOf(valueOf.g);
            class.getMethod(stringBuilder, arr8).invoke(view, arr);
            Class[] arr3 = new Class[arr];
            arr3[i] = Integer.TYPE;
            arr = new Object[arr];
            arr[i] = Integer.valueOf(valueOf.d);
            class.getMethod(stringBuilder, arr3).invoke(view, arr);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("set");
            stringBuilder2.append(string);
            stringBuilder = stringBuilder2.toString();
        }
    }

    public void e(View view, float[] f2Arr2) {
        Object method;
        Class<byte> obj3;
        Object obj2;
        Object[] valueOf;
        Float colorDrawable;
        int cmp;
        long l;
        int i4;
        int i;
        int i2;
        Class<android.graphics.drawable.Drawable> obj;
        int i3;
        final Object obj4 = this;
        obj2 = view;
        final String str = "\"";
        final String str2 = " on View \"";
        final String str3 = "TransitionLayout";
        method = view.getClass();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set");
        stringBuilder.append(obj4.b);
        String string2 = stringBuilder.toString();
        cmp = 2;
        l = 4601859982876761367L;
        final int i51 = 1132396544;
        i = 1;
        i2 = 0;
        switch (valueOf) {
            case 2:
                int i23 = i;
                Class[] arr5 = new Class[i23];
                l = 0;
                arr5[l] = Boolean.TYPE;
                colorDrawable = new Object[i23];
                i = i23;
                i = l;
                colorDrawable[l] = Boolean.valueOf(i);
                method.getMethod(string2, arr5).invoke(obj2, colorDrawable);
                break;
            case 3:
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("unable to interpolate strings ");
                stringBuilder3.append(obj4.b);
                RuntimeException runtimeException = new RuntimeException(stringBuilder3.toString());
                throw runtimeException;
            case 4:
                Class[] arr6 = new Class[i];
                int i55 = 0;
                arr6[i55] = Integer.TYPE;
                i2 = f2Arr2[1];
                int i38 = f2Arr2[cmp];
                colorDrawable = new Object[1];
                method.getMethod(string2, arr6).invoke(obj2, Integer.valueOf(i12 |= i27));
                break;
            case 5:
                Class[] arr3 = new Class[i];
                obj = Drawable.class;
                arr3[i2] = obj;
                i2 = a.a((int)i57);
                colorDrawable = new ColorDrawable();
                colorDrawable.setColor(i20 |= i49);
                valueOf = new Object[1];
                method.getMethod(string2, arr3).invoke(obj2, colorDrawable);
                break;
            case 6:
                Class[] arr4 = new Class[i];
                arr4[i2] = Integer.TYPE;
                valueOf = new Object[i];
                valueOf[i2] = Integer.valueOf((int)i36);
                method.getMethod(string2, arr4).invoke(obj2, valueOf);
                break;
            case 7:
                Class[] arr = new Class[i];
                arr[i2] = Float.TYPE;
                valueOf = new Object[i];
                valueOf[i2] = Float.valueOf(f2Arr2[i2]);
                method.getMethod(string2, arr).invoke(obj2, valueOf);
                break;
            case 8:
                Class[] arr2 = new Class[i];
                arr2[i2] = Float.TYPE;
                valueOf = new Object[i];
                valueOf[i2] = Float.valueOf(f2Arr2[i2]);
                method.getMethod(string2, arr2).invoke(obj2, valueOf);
                break;
            default:
        }
    }

    public void f(Object object) {
        int obj3;
        switch (i2) {
            case 1:
                this.d = (Integer)object.intValue();
                break;
            case 2:
                this.g = (Boolean)object.booleanValue();
                break;
            case 3:
                this.f = (String)object;
                break;
            case 4:
                this.h = (Integer)object.intValue();
                break;
            case 5:
                this.e = (Float)object.floatValue();
                break;
            case 6:
                this.e = (Float)object.floatValue();
                break;
            default:
        }
    }
}

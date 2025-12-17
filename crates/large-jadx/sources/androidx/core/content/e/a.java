package androidx.core.content.e;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import d.h.a;
import d.h.d;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class a {

    private static final java.lang.ThreadLocal<TypedValue> a;
    static {
        ThreadLocal threadLocal = new ThreadLocal();
        a.a = threadLocal;
    }

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser2, Resources.Theme resources$Theme3) {
        int next;
        int i;
        int i2;
        next = xmlPullParser2.next();
        i = 2;
        while (next != i) {
            if (next != 1) {
            }
            next = xmlPullParser2.next();
            i = 2;
        }
        if (next != i) {
        } else {
            return a.b(resources, xmlPullParser2, Xml.asAttributeSet(xmlPullParser2), theme3);
        }
        XmlPullParserException obj4 = new XmlPullParserException("No start tag found");
        throw obj4;
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser2, AttributeSet attributeSet3, Resources.Theme resources$Theme4) {
        final String name = xmlPullParser2.getName();
        if (!name.equals("selector")) {
        } else {
            return a.e(resources, xmlPullParser2, attributeSet3, theme4);
        }
        StringBuilder obj4 = new StringBuilder();
        obj4.append(xmlPullParser2.getPositionDescription());
        obj4.append(": invalid color state list tag ");
        obj4.append(name);
        XmlPullParserException obj2 = new XmlPullParserException(obj4.toString());
        throw obj2;
    }

    private static TypedValue c() {
        Object typedValue;
        final java.lang.ThreadLocal threadLocal = a.a;
        if ((TypedValue)threadLocal.get() == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        return typedValue;
    }

    public static ColorStateList d(Resources resources, int i2, Resources.Theme resources$Theme3) {
        try {
            return a.a(resources, resources.getXml(i2), theme3);
            i2 = "CSLCompat";
            theme3 = "Failed to inflate ColorStateList.";
            Log.e(i2, theme3, resources);
            resources = null;
            return resources;
        }
    }

    private static ColorStateList e(Resources resources, XmlPullParser xmlPullParser2, AttributeSet attributeSet3, Resources.Theme resources$Theme4) {
        int i6;
        int i4;
        int[] iArr3;
        int[][] iArr;
        int i5;
        int equals;
        int defaultColor;
        int float;
        int i3;
        int[] iArr2;
        int i7;
        int i;
        boolean value;
        int i2;
        int attributeNameResource;
        boolean attributeBooleanValue;
        Resources resources2 = resources;
        AttributeSet set = attributeSet3;
        Resources.Theme theme = theme4;
        depth += i6;
        int i9 = 20;
        iArr = new int[i9];
        iArr3 = new int[i9];
        final int i10 = 0;
        i5 = i10;
        equals = xmlPullParser2.next();
        while (equals != i6) {
            defaultColor = xmlPullParser2.getDepth();
            if (defaultColor < i8) {
            } else {
            }
            if (equals == 2 && defaultColor <= i8) {
            }
            i6 = 1;
            equals = xmlPullParser2.next();
            if (defaultColor <= i8) {
            }
            if (!xmlPullParser2.getName().equals("item")) {
            } else {
            }
            TypedArray typedArray = a.h(resources2, theme, set, d.a);
            int i11 = d.b;
            i3 = -1;
            int resourceId = typedArray.getResourceId(i11, i3);
            if (resourceId != i3 && !a.f(resources2, resourceId)) {
            } else {
            }
            defaultColor = typedArray.getColor(i11, -65281);
            float = 1065353216;
            i7 = d.c;
            if (typedArray.hasValue(i7)) {
            } else {
            }
            i7 = d.d;
            if (typedArray.hasValue(i7)) {
            }
            typedArray.recycle();
            int attributeCount = attributeSet3.getAttributeCount();
            iArr2 = new int[attributeCount];
            i2 = i;
            while (i < attributeCount) {
                attributeNameResource = set.getAttributeNameResource(i);
                if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != a.a) {
                }
                i++;
                i6 = 1;
                if (attributeNameResource != 16843551) {
                }
                if (attributeNameResource != a.a) {
                }
                if (set.getAttributeBooleanValue(i, i10)) {
                } else {
                }
                attributeNameResource = -attributeNameResource;
                iArr2[i2] = attributeNameResource;
                i2 = i4;
            }
            iArr3 = e.a(iArr3, i5, a.g(defaultColor, float));
            iArr = i6;
            i5++;
            attributeNameResource = set.getAttributeNameResource(i);
            if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != a.a) {
            }
            i++;
            i6 = 1;
            if (attributeNameResource != 16843551) {
            }
            if (attributeNameResource != a.a) {
            }
            if (set.getAttributeBooleanValue(i, i10)) {
            } else {
            }
            attributeNameResource = -attributeNameResource;
            iArr2[i2] = attributeNameResource;
            i2 = i4;
            float = typedArray.getFloat(i7, float);
            float = typedArray.getFloat(i7, float);
            if (!a.f(resources2, resourceId)) {
            } else {
            }
            defaultColor = a.a(resources2, resources2.getXml(resourceId), theme).getDefaultColor();
            if (equals != 3) {
            }
        }
        int[] iArr4 = new int[i5];
        int[][] iArr5 = new int[i5];
        System.arraycopy(iArr3, i10, iArr4, i10, i5);
        System.arraycopy(iArr, i10, iArr5, i10, i5);
        ColorStateList colorStateList = new ColorStateList(iArr5, iArr4);
        return colorStateList;
    }

    private static boolean f(Resources resources, int i2) {
        int i;
        int obj3;
        final TypedValue typedValue = a.c();
        resources.getValue(i2, typedValue, true);
        final int obj2 = typedValue.type;
        if (obj2 >= 28 && obj2 <= 31) {
            if (obj2 <= 31) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static int g(int i, float f2) {
        return obj1 |= obj2;
    }

    private static TypedArray h(Resources resources, Resources.Theme resources$Theme2, AttributeSet attributeSet3, int[] i4Arr4) {
        TypedArray obj0;
        if (theme2 == null) {
            obj0 = resources.obtainAttributes(attributeSet3, i4Arr4);
        } else {
            obj0 = 0;
            obj0 = theme2.obtainStyledAttributes(attributeSet3, i4Arr4, obj0, obj0);
        }
        return obj0;
    }
}

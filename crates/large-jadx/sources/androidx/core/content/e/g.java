package androidx.core.content.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class g {
    public static int a(Context context, int i2, int i3) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        if (typedValue.resourceId != 0) {
            return i2;
        }
        return i3;
    }

    public static boolean b(TypedArray typedArray, int i2, int i3, boolean z4) {
        return typedArray.getBoolean(i2, typedArray.getBoolean(i3, z4));
    }

    public static Drawable c(TypedArray typedArray, int i2, int i3) {
        Drawable obj1;
        if (typedArray.getDrawable(i2) == null) {
            obj1 = typedArray.getDrawable(i3);
        }
        return obj1;
    }

    public static int d(TypedArray typedArray, int i2, int i3, int i4) {
        return typedArray.getInt(i2, typedArray.getInt(i3, i4));
    }

    public static boolean e(TypedArray typedArray, XmlPullParser xmlPullParser2, String string3, int i4, boolean z5) {
        if (!g.r(xmlPullParser2, string3)) {
            return z5;
        }
        return typedArray.getBoolean(i4, z5);
    }

    public static int f(TypedArray typedArray, XmlPullParser xmlPullParser2, String string3, int i4, int i5) {
        if (!g.r(xmlPullParser2, string3)) {
            return i5;
        }
        return typedArray.getColor(i4, i5);
    }

    public static ColorStateList g(TypedArray typedArray, XmlPullParser xmlPullParser2, Resources.Theme resources$Theme3, String string4, int i5) {
        int i;
        if (g.r(xmlPullParser2, string4)) {
            TypedValue obj2 = new TypedValue();
            typedArray.getValue(i5, obj2);
            int obj4 = obj2.type;
            if (obj4 == 2) {
            } else {
                if (obj4 >= 28 && obj4 <= 31) {
                    if (obj4 <= 31) {
                        return g.h(obj2);
                    }
                }
                return a.d(typedArray.getResources(), typedArray.getResourceId(i5, 0), theme3);
            }
            StringBuilder obj3 = new StringBuilder();
            obj3.append("Failed to resolve attribute at index ");
            obj3.append(i5);
            obj3.append(": ");
            obj3.append(obj2);
            UnsupportedOperationException obj1 = new UnsupportedOperationException(obj3.toString());
            throw obj1;
        }
        return null;
    }

    private static ColorStateList h(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static androidx.core.content.e.b i(TypedArray typedArray, XmlPullParser xmlPullParser2, Resources.Theme resources$Theme3, String string4, int i5, int i6) {
        int i;
        androidx.core.content.e.b obj1;
        boolean obj2;
        String obj4;
        obj2 = new TypedValue();
        typedArray.getValue(i5, obj2);
        obj4 = obj2.type;
        if (g.r(xmlPullParser2, string4) && obj4 >= 28 && obj4 <= 31) {
            obj2 = new TypedValue();
            typedArray.getValue(i5, obj2);
            obj4 = obj2.type;
            if (obj4 >= 28) {
                if (obj4 <= 31) {
                    return b.b(obj2.data);
                }
            }
            obj1 = b.g(typedArray.getResources(), typedArray.getResourceId(i5, 0), theme3);
            if (obj1 != null) {
                return obj1;
            }
        }
        return b.b(i6);
    }

    public static float j(TypedArray typedArray, XmlPullParser xmlPullParser2, String string3, int i4, float f5) {
        if (!g.r(xmlPullParser2, string3)) {
            return f5;
        }
        return typedArray.getFloat(i4, f5);
    }

    public static int k(TypedArray typedArray, XmlPullParser xmlPullParser2, String string3, int i4, int i5) {
        if (!g.r(xmlPullParser2, string3)) {
            return i5;
        }
        return typedArray.getInt(i4, i5);
    }

    public static int l(TypedArray typedArray, XmlPullParser xmlPullParser2, String string3, int i4, int i5) {
        if (!g.r(xmlPullParser2, string3)) {
            return i5;
        }
        return typedArray.getResourceId(i4, i5);
    }

    public static String m(TypedArray typedArray, XmlPullParser xmlPullParser2, String string3, int i4) {
        if (!g.r(xmlPullParser2, string3)) {
            return null;
        }
        return typedArray.getString(i4);
    }

    public static int n(TypedArray typedArray, int i2, int i3, int i4) {
        return typedArray.getResourceId(i2, typedArray.getResourceId(i3, i4));
    }

    public static String o(TypedArray typedArray, int i2, int i3) {
        String obj1;
        if (typedArray.getString(i2) == null) {
            obj1 = typedArray.getString(i3);
        }
        return obj1;
    }

    public static java.lang.CharSequence p(TypedArray typedArray, int i2, int i3) {
        java.lang.CharSequence obj1;
        if (typedArray.getText(i2) == null) {
            obj1 = typedArray.getText(i3);
        }
        return obj1;
    }

    public static java.lang.CharSequence[] q(TypedArray typedArray, int i2, int i3) {
        java.lang.CharSequence[] obj1;
        if (typedArray.getTextArray(i2) == null) {
            obj1 = typedArray.getTextArray(i3);
        }
        return obj1;
    }

    public static boolean r(XmlPullParser xmlPullParser, String string2) {
        int obj1;
        obj1 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", string2) != null ? 1 : 0;
        return obj1;
    }

    public static TypedArray s(Resources resources, Resources.Theme resources$Theme2, AttributeSet attributeSet3, int[] i4Arr4) {
        if (theme2 == null) {
            return resources.obtainAttributes(attributeSet3, i4Arr4);
        }
        int obj0 = 0;
        return theme2.obtainStyledAttributes(attributeSet3, i4Arr4, obj0, obj0);
    }

    public static TypedValue t(TypedArray typedArray, XmlPullParser xmlPullParser2, String string3, int i4) {
        if (!g.r(xmlPullParser2, string3)) {
            return null;
        }
        return typedArray.peekValue(i4);
    }
}

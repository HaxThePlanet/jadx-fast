package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class TypedArrayUtils {

    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";
    public static int getAttr(Context context, int attr, int fallbackAttr) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(attr, typedValue, true);
        if (typedValue.resourceId != 0) {
            return attr;
        }
        return fallbackAttr;
    }

    public static boolean getBoolean(TypedArray a, int index, int fallbackIndex, boolean defaultValue) {
        return a.getBoolean(index, a.getBoolean(fallbackIndex, defaultValue));
    }

    public static Drawable getDrawable(TypedArray a, int index, int fallbackIndex) {
        Drawable val;
        if (a.getDrawable(index) == null) {
            val = a.getDrawable(fallbackIndex);
        }
        return val;
    }

    public static int getInt(TypedArray a, int index, int fallbackIndex, int defaultValue) {
        return a.getInt(index, a.getInt(fallbackIndex, defaultValue));
    }

    public static boolean getNamedBoolean(TypedArray a, XmlPullParser parser, String attrName, int resId, boolean defaultValue) {
        if (!TypedArrayUtils.hasAttribute(parser, attrName)) {
            return defaultValue;
        }
        return a.getBoolean(resId, defaultValue);
    }

    public static int getNamedColor(TypedArray a, XmlPullParser parser, String attrName, int resId, int defaultValue) {
        if (!TypedArrayUtils.hasAttribute(parser, attrName)) {
            return defaultValue;
        }
        return a.getColor(resId, defaultValue);
    }

    public static ColorStateList getNamedColorStateList(TypedArray a, XmlPullParser parser, Resources.Theme theme, String attrName, int resId) {
        int type;
        int i;
        if (TypedArrayUtils.hasAttribute(parser, attrName)) {
            TypedValue typedValue = new TypedValue();
            a.getValue(resId, typedValue);
            if (typedValue.type == 2) {
            } else {
                if (typedValue.type >= 28 && typedValue.type <= 31) {
                    if (typedValue.type <= 31) {
                        return TypedArrayUtils.getNamedColorStateListFromInt(typedValue);
                    }
                }
                return ColorStateListInflaterCompat.inflate(a.getResources(), a.getResourceId(resId, 0), theme);
            }
            StringBuilder stringBuilder = new StringBuilder();
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(stringBuilder.append("Failed to resolve attribute at index ").append(resId).append(": ").append(typedValue).toString());
            throw unsupportedOperationException;
        }
        return null;
    }

    private static ColorStateList getNamedColorStateListFromInt(TypedValue value) {
        return ColorStateList.valueOf(value.data);
    }

    public static androidx.core.content.res.ComplexColorCompat getNamedComplexColor(TypedArray a, XmlPullParser parser, Resources.Theme theme, String attrName, int resId, int defaultValue) {
        boolean typedValue;
        int type;
        androidx.core.content.res.ComplexColorCompat inflate;
        int i;
        int resourceId;
        typedValue = new TypedValue();
        a.getValue(resId, typedValue);
        if (TypedArrayUtils.hasAttribute(parser, attrName) && typedValue.type >= 28 && typedValue.type <= 31) {
            typedValue = new TypedValue();
            a.getValue(resId, typedValue);
            if (typedValue.type >= 28) {
                if (typedValue.type <= 31) {
                    return ComplexColorCompat.from(typedValue.data);
                }
            }
            inflate = ComplexColorCompat.inflate(a.getResources(), a.getResourceId(resId, 0), theme);
            if (inflate != null) {
                return inflate;
            }
        }
        return ComplexColorCompat.from(defaultValue);
    }

    public static float getNamedFloat(TypedArray a, XmlPullParser parser, String attrName, int resId, float defaultValue) {
        if (!TypedArrayUtils.hasAttribute(parser, attrName)) {
            return defaultValue;
        }
        return a.getFloat(resId, defaultValue);
    }

    public static int getNamedInt(TypedArray a, XmlPullParser parser, String attrName, int resId, int defaultValue) {
        if (!TypedArrayUtils.hasAttribute(parser, attrName)) {
            return defaultValue;
        }
        return a.getInt(resId, defaultValue);
    }

    public static int getNamedResourceId(TypedArray a, XmlPullParser parser, String attrName, int resId, int defaultValue) {
        if (!TypedArrayUtils.hasAttribute(parser, attrName)) {
            return defaultValue;
        }
        return a.getResourceId(resId, defaultValue);
    }

    public static String getNamedString(TypedArray a, XmlPullParser parser, String attrName, int resId) {
        if (!TypedArrayUtils.hasAttribute(parser, attrName)) {
            return null;
        }
        return a.getString(resId);
    }

    public static int getResourceId(TypedArray a, int index, int fallbackIndex, int defaultValue) {
        return a.getResourceId(index, a.getResourceId(fallbackIndex, defaultValue));
    }

    public static String getString(TypedArray a, int index, int fallbackIndex) {
        String val;
        if (a.getString(index) == null) {
            val = a.getString(fallbackIndex);
        }
        return val;
    }

    public static java.lang.CharSequence getText(TypedArray a, int index, int fallbackIndex) {
        java.lang.CharSequence val;
        if (a.getText(index) == null) {
            val = a.getText(fallbackIndex);
        }
        return val;
    }

    public static java.lang.CharSequence[] getTextArray(TypedArray a, int index, int fallbackIndex) {
        java.lang.CharSequence[] val;
        if (a.getTextArray(index) == null) {
            val = a.getTextArray(fallbackIndex);
        }
        return val;
    }

    public static boolean hasAttribute(XmlPullParser parser, String attrName) {
        int i;
        i = parser.getAttributeValue("http://schemas.android.com/apk/res/android", attrName) != null ? 1 : 0;
        return i;
    }

    public static TypedArray obtainAttributes(Resources res, Resources.Theme theme, AttributeSet set, int[] attrs) {
        if (theme == null) {
            return res.obtainAttributes(set, attrs);
        }
        int i = 0;
        return theme.obtainStyledAttributes(set, attrs, i, i);
    }

    public static TypedValue peekNamedValue(TypedArray a, XmlPullParser parser, String attrName, int resId) {
        if (!TypedArrayUtils.hasAttribute(parser, attrName)) {
            return null;
        }
        return a.peekValue(resId);
    }
}

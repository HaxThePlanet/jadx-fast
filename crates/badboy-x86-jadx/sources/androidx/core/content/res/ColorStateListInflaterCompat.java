package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R.attr;
import androidx.core.R.styleable;
import androidx.core.math.MathUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public final class ColorStateListInflaterCompat {

    private static final java.lang.ThreadLocal<TypedValue> sTempTypedValue;
    static {
        ThreadLocal threadLocal = new ThreadLocal();
        ColorStateListInflaterCompat.sTempTypedValue = threadLocal;
    }

    public static ColorStateList createFromXml(Resources r, XmlPullParser parser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        int i2;
        int i;
        next = parser.next();
        i2 = next;
        i = 2;
        while (next != i) {
            if (i2 != 1) {
            }
            next = parser.next();
            i2 = next;
            i = 2;
        }
        if (i2 != i) {
        } else {
            return ColorStateListInflaterCompat.createFromXmlInner(r, parser, Xml.asAttributeSet(parser), theme);
        }
        XmlPullParserException xmlPullParserException = new XmlPullParserException("No start tag found");
        throw xmlPullParserException;
    }

    public static ColorStateList createFromXmlInner(Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        final String name = parser.getName();
        if (!name.equals("selector")) {
        } else {
            return ColorStateListInflaterCompat.inflate(r, parser, attrs, theme);
        }
        StringBuilder stringBuilder = new StringBuilder();
        XmlPullParserException xmlPullParserException = new XmlPullParserException(stringBuilder.append(parser.getPositionDescription()).append(": invalid color state list tag ").append(name).toString());
        throw xmlPullParserException;
    }

    private static TypedValue getTypedValue() {
        Object tv;
        java.lang.ThreadLocal sTempTypedValue;
        if ((TypedValue)ColorStateListInflaterCompat.sTempTypedValue.get() == null) {
            TypedValue typedValue = new TypedValue();
            ColorStateListInflaterCompat.sTempTypedValue.set(typedValue);
        }
        return tv;
    }

    public static ColorStateList inflate(Resources resources, int resId, Resources.Theme theme) {
        try {
            return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(resId), theme);
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
            Throwable e = null;
            return e;
        }
    }

    private static ColorStateList inflate(Resources r, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        int[][] defaultColor;
        int depth;
        int colorStateListItem_android_color;
        Resources resources;
        Resources.Theme theme2;
        int i3;
        int i;
        float float;
        int value;
        int i2;
        int[][] colorList;
        int[] colorList2;
        int listSize;
        int i7;
        int type;
        int i4;
        int i11;
        Object attributes;
        int alphaMod;
        int i9;
        int resourceId;
        int attributeCount;
        boolean colorStateListItem_alpha;
        int innerDepth;
        int i10;
        int innerDepth2;
        int i6;
        int i5;
        int i8;
        boolean attributeBooleanValue;
        resources = r;
        final AttributeSet set = attrs;
        theme2 = theme;
        i = 1;
        i2 = depth2 + 1;
        defaultColor = new int[20];
        listSize = i13;
        colorList2 = iArr4;
        colorList = defaultColor;
        depth = parser.next();
        i7 = depth;
        while (depth != i) {
            depth = parser.getDepth();
            if (i7 == 2 && depth <= i2) {
            } else {
            }
            innerDepth = i2;
            i6 = i7;
            resources = r;
            theme2 = theme;
            i2 = innerDepth;
            i = 1;
            depth = parser.next();
            i7 = depth;
            if (depth <= i2) {
            } else {
            }
            if (!parser.getName().equals("item")) {
            } else {
            }
            attributes = ColorStateListInflaterCompat.obtainAttributes(resources, theme2, set, R.styleable.ColorStateListItem);
            i9 = -1;
            resourceId = attributes.getResourceId(R.styleable.ColorStateListItem_android_color, i9);
            if (resourceId != i9 && !ColorStateListInflaterCompat.isColorInt(resources, resourceId)) {
            } else {
            }
            defaultColor = attributes.getColor(R.styleable.ColorStateListItem_android_color, -65281);
            alphaMod = 1065353216;
            if (attributes.hasValue(R.styleable.ColorStateListItem_android_alpha)) {
            } else {
            }
            if (attributes.hasValue(R.styleable.ColorStateListItem_alpha)) {
            }
            int i17 = -1082130432;
            if (Build.VERSION.SDK_INT >= 31 && attributes.hasValue(R.styleable.ColorStateListItem_android_lStar)) {
            } else {
            }
            float = attributes.getFloat(R.styleable.ColorStateListItem_lStar, i17);
            attributes.recycle();
            i4 = 0;
            attributeCount = set.getAttributeCount();
            int[] iArr2 = new int[attributeCount];
            i3 = i10;
            while (i3 < attributeCount) {
                int attributeNameResource = set.getAttributeNameResource(i3);
                if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R.attr.alpha && attributeNameResource != R.attr.lStar) {
                }
                i3++;
                i2 = i10;
                i7 = i6;
                if (attributeNameResource != 16843551) {
                }
                if (attributeNameResource != R.attr.alpha) {
                }
                if (attributeNameResource != R.attr.lStar) {
                }
                if (set.getAttributeBooleanValue(i3, false)) {
                } else {
                }
                type = -attributeNameResource;
                iArr2[i4] = type;
                i4 = i8;
                type = attributeNameResource;
            }
            i6 = i7;
            colorList2 = GrowingArrayUtils.append(colorList2, listSize, ColorStateListInflaterCompat.modulateColorAlpha(defaultColor, alphaMod, float));
            colorList = append;
            listSize++;
            resources = r;
            theme2 = theme;
            i2 = innerDepth;
            i = 1;
            attributeNameResource = set.getAttributeNameResource(i3);
            if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R.attr.alpha && attributeNameResource != R.attr.lStar) {
            }
            i3++;
            i2 = i10;
            i7 = i6;
            if (attributeNameResource != 16843551) {
            }
            if (attributeNameResource != R.attr.alpha) {
            }
            if (attributeNameResource != R.attr.lStar) {
            }
            if (set.getAttributeBooleanValue(i3, false)) {
            } else {
            }
            type = -attributeNameResource;
            iArr2[i4] = type;
            i4 = i8;
            type = attributeNameResource;
            if (attributes.hasValue(R.styleable.ColorStateListItem_android_lStar)) {
            } else {
            }
            float = attributes.getFloat(R.styleable.ColorStateListItem_android_lStar, i17);
            alphaMod = attributes.getFloat(R.styleable.ColorStateListItem_alpha, alphaMod);
            alphaMod = attributes.getFloat(R.styleable.ColorStateListItem_android_alpha, alphaMod);
            if (!ColorStateListInflaterCompat.isColorInt(resources, resourceId)) {
            } else {
            }
            defaultColor = ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(resourceId), theme2).getDefaultColor();
            innerDepth = i2;
            Throwable e = obj12.getColor(R.styleable.ColorStateListItem_android_color, obj15);
        }
        innerDepth2 = i2;
        i5 = i7;
        int[] iArr = new int[listSize];
        int[][] iArr3 = new int[listSize];
        int i16 = 0;
        System.arraycopy(colorList2, i16, iArr, i16, listSize);
        System.arraycopy(colorList, i16, iArr3, i16, listSize);
        ColorStateList colorStateList = new ColorStateList(iArr3, iArr);
        return colorStateList;
    }

    private static boolean isColorInt(Resources r, int resId) {
        int i2;
        int type;
        int i;
        final TypedValue typedValue = ColorStateListInflaterCompat.getTypedValue();
        r.getValue(resId, typedValue, true);
        if (typedValue.type >= 28 && typedValue.type <= 31) {
            if (typedValue.type <= 31) {
            } else {
                i2 = 0;
            }
        } else {
        }
        return i2;
    }

    private static int modulateColorAlpha(int color, float alphaMod, float lStar) {
        int cmp;
        int i;
        int color2;
        int hue;
        float chroma;
        int obj6;
        int i4 = 0;
        if (Float.compare(lStar, i2) >= 0 && Float.compare(lStar, i3) <= 0) {
            i = Float.compare(lStar, i3) <= 0 ? 1 : i4;
        } else {
        }
        if (Float.compare(alphaMod, i5) == 0 && i == 0) {
            if (i == 0) {
                return color;
            }
        }
        if (i != 0) {
            color2 = CamColor.fromColor(color);
            obj6 = CamColor.toColor(color2.getHue(), color2.getChroma(), lStar);
        }
        return i8 |= i11;
    }

    private static TypedArray obtainAttributes(Resources res, Resources.Theme theme, AttributeSet set, int[] attrs) {
        TypedArray styledAttributes;
        if (theme == null) {
            styledAttributes = res.obtainAttributes(set, attrs);
        } else {
            int i = 0;
            styledAttributes = theme.obtainStyledAttributes(set, attrs, i, i);
        }
        return styledAttributes;
    }
}

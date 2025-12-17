package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.core.R.styleable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
final class GradientColorInflaterCompat {

    private static final int TILE_MODE_CLAMP = 0;
    private static final int TILE_MODE_MIRROR = 2;
    private static final int TILE_MODE_REPEAT = 1;

    static final class ColorStops {

        final int[] mColors;
        final float[] mOffsets;
        ColorStops(int startColor, int endColor) {
            super();
            this.mColors = /* result */;
            float[] fArr = new float[2];
            fArr = new int[]{0, 1065353216};
            this.mOffsets = fArr;
        }

        ColorStops(int startColor, int centerColor, int endColor) {
            super();
            this.mColors = /* result */;
            float[] fArr = new float[3];
            fArr = new int[]{0, 1056964608, 1065353216};
            this.mOffsets = fArr;
        }

        ColorStops(List<Integer> list, List<Float> list2) {
            int i;
            float[] mOffsets;
            float floatValue;
            super();
            final int size = list.size();
            this.mColors = new int[size];
            this.mOffsets = new float[size];
            i = 0;
            while (i < size) {
                this.mColors[i] = (Integer)list.get(i).intValue();
                this.mOffsets[i] = (Float)list2.get(i).floatValue();
                i++;
            }
        }
    }
    private static androidx.core.content.res.GradientColorInflaterCompat.ColorStops checkColors(androidx.core.content.res.GradientColorInflaterCompat.ColorStops colorItems, int startColor, int endColor, boolean hasCenterColor, int centerColor) {
        if (colorItems != null) {
            return colorItems;
        }
        if (hasCenterColor) {
            GradientColorInflaterCompat.ColorStops colorStops = new GradientColorInflaterCompat.ColorStops(startColor, centerColor, endColor);
            return colorStops;
        }
        GradientColorInflaterCompat.ColorStops colorStops2 = new GradientColorInflaterCompat.ColorStops(startColor, endColor);
        return colorStops2;
    }

    static Shader createFromXml(Resources resources, XmlPullParser parser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        int i;
        int i2;
        next = parser.next();
        i = next;
        i2 = 2;
        while (next != i2) {
            if (i != 1) {
            }
            next = parser.next();
            i = next;
            i2 = 2;
        }
        if (i != i2) {
        } else {
            return GradientColorInflaterCompat.createFromXmlInner(resources, parser, Xml.asAttributeSet(parser), theme);
        }
        XmlPullParserException xmlPullParserException = new XmlPullParserException("No start tag found");
        throw xmlPullParserException;
    }

    static Shader createFromXmlInner(Resources resources, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws IOException, XmlPullParserException {
        XmlPullParser xmlPullParser = parser;
        final String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
        } else {
            TypedArray attributes = TypedArrayUtils.obtainAttributes(resources, theme, attrs, R.styleable.GradientColor);
            int i2 = 0;
            float namedFloat6 = TypedArrayUtils.getNamedFloat(attributes, xmlPullParser, "centerX", R.styleable.GradientColor_android_centerX, i2);
            float namedFloat = TypedArrayUtils.getNamedFloat(attributes, xmlPullParser, "centerY", R.styleable.GradientColor_android_centerY, i2);
            int i3 = 0;
            String str12 = "centerColor";
            boolean attribute = TypedArrayUtils.hasAttribute(xmlPullParser, str12);
            int i = 0;
            final int i6 = namedInt;
            final float namedFloat7 = TypedArrayUtils.getNamedFloat(attributes, xmlPullParser, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, 0);
            attributes.recycle();
            androidx.core.content.res.GradientColorInflaterCompat.ColorStops colorStops = GradientColorInflaterCompat.checkColors(GradientColorInflaterCompat.inflateChildElements(resources, parser, attrs, theme), TypedArrayUtils.getNamedColor(attributes, xmlPullParser, "startColor", R.styleable.GradientColor_android_startColor, i3), TypedArrayUtils.getNamedColor(attributes, xmlPullParser, "endColor", R.styleable.GradientColor_android_endColor, i), attribute, TypedArrayUtils.getNamedColor(attributes, xmlPullParser, str12, R.styleable.GradientColor_android_centerColor, i));
            switch (i5) {
                case 1:
                    boolean z2 = attribute;
                    float f4 = namedFloat;
                    RadialGradient hasCenterColor3 = new RadialGradient(namedFloat6, f4, namedFloat7, colorStops.mColors, colorStops.mOffsets, GradientColorInflaterCompat.parseTileMode(i6));
                    float f = namedFloat6;
                    float f3 = f4;
                    return hasCenterColor3;
                    boolean hasCenterColor2 = attribute;
                    XmlPullParserException xmlPullParserException = new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
                    throw xmlPullParserException;
                case 2:
                    SweepGradient centerY2 = new SweepGradient(namedFloat6, namedFloat, colorStops.mColors, colorStops.mOffsets);
                    return centerY2;
                default:
                    float f2 = namedFloat;
                    boolean z = attribute;
                    float centerY = namedFloat6;
                    LinearGradient linearGradient = new LinearGradient(TypedArrayUtils.getNamedFloat(attributes, xmlPullParser, "startX", R.styleable.GradientColor_android_startX, i2), TypedArrayUtils.getNamedFloat(attributes, xmlPullParser, "startY", R.styleable.GradientColor_android_startY, i2), TypedArrayUtils.getNamedFloat(attributes, xmlPullParser, "endX", R.styleable.GradientColor_android_endX, i2), TypedArrayUtils.getNamedFloat(attributes, xmlPullParser, "endY", R.styleable.GradientColor_android_endY, i2), colorStops.mColors, colorStops.mOffsets, GradientColorInflaterCompat.parseTileMode(i6));
                    return linearGradient;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        XmlPullParserException hasCenterColor = new XmlPullParserException(stringBuilder.append(parser.getPositionDescription()).append(": invalid gradient color tag ").append(name).toString());
        throw hasCenterColor;
    }

    private static androidx.core.content.res.GradientColorInflaterCompat.ColorStops inflateChildElements(Resources resources, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        int attributes;
        int depth;
        int i2;
        int i;
        boolean value2;
        boolean value;
        int color;
        float float;
        Float valueOf;
        int i4 = 1;
        depth2 += i4;
        attributes = 20;
        ArrayList arrayList = new ArrayList(attributes);
        ArrayList arrayList2 = new ArrayList(attributes);
        depth = parser.next();
        i2 = depth;
        while (depth != i4) {
            depth = parser.getDepth();
            depth = parser.next();
            i2 = depth;
            attributes = TypedArrayUtils.obtainAttributes(resources, theme, attrs, R.styleable.GradientColorItem);
            attributes.recycle();
            arrayList2.add(Integer.valueOf(attributes.getColor(R.styleable.GradientColorItem_android_color, 0)));
            arrayList.add(Float.valueOf(attributes.getFloat(R.styleable.GradientColorItem_android_offset, 0)));
        }
        if (arrayList2.size() > 0) {
            GradientColorInflaterCompat.ColorStops colorStops = new GradientColorInflaterCompat.ColorStops(arrayList2, arrayList);
            return colorStops;
        }
        return null;
    }

    private static Shader.TileMode parseTileMode(int tileMode) {
        switch (tileMode) {
            case 1:
                return Shader.TileMode.REPEAT;
            case 2:
                return Shader.TileMode.MIRROR;
            default:
                return Shader.TileMode.CLAMP;
        }
    }
}

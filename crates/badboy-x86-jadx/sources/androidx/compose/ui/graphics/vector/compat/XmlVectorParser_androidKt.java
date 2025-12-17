package androidx.compose.ui.graphics.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendMode.Companion;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.PathFillType.Companion;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeCap.Companion;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.StrokeJoin.Companion;
import androidx.compose.ui.graphics.vector.ImageVector.Builder;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u001a$\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011\u001a$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0011\u001a\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a*\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u000c\u0010\u001e\u001a\u0008\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0000\u001a\u000c\u0010\"\u001a\u00020#*\u00020$H\u0000\u001a2\u0010%\u001a\u00020&*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u000c\u0010\u001e\u001a\u0008\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020\u001aH\u0000\u001a<\u0010(\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u000e\u0008\u0002\u0010\u001e\u001a\u0008\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0001H\u0000\u001a2\u0010*\u001a\u00020&*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u000c\u0010\u001e\u001a\u0008\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020\u001aH\u0000\u001a2\u0010+\u001a\u00020&*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u000c\u0010\u001e\u001a\u0008\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020\u001aH\u0000\u001a\u000c\u0010,\u001a\u00020$*\u00020$H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006-", d2 = {"FILL_TYPE_WINDING", "", "LINECAP_BUTT", "LINECAP_ROUND", "LINECAP_SQUARE", "LINEJOIN_BEVEL", "LINEJOIN_MITER", "LINEJOIN_ROUND", "SHAPE_CLIP_PATH", "", "SHAPE_GROUP", "SHAPE_PATH", "getStrokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "id", "defValue", "getStrokeLineCap-CSYIeUk", "(II)I", "getStrokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getStrokeLineJoin-kLtJ_vA", "obtainBrushFromComplexColor", "Landroidx/compose/ui/graphics/Brush;", "complexColor", "Landroidx/core/content/res/ComplexColorCompat;", "createVectorImageBuilder", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "Landroidx/compose/ui/graphics/vector/compat/AndroidVectorParser;", "res", "Landroid/content/res/Resources;", "theme", "Landroid/content/res/Resources$Theme;", "attrs", "Landroid/util/AttributeSet;", "isAtEnd", "", "Lorg/xmlpull/v1/XmlPullParser;", "parseClipPath", "", "builder", "parseCurrentVectorNode", "nestedGroups", "parseGroup", "parsePath", "seekToStartTag", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class XmlVectorParser_androidKt {

    private static final int FILL_TYPE_WINDING = 0;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";
    static {
    }

    public static final ImageVector.Builder createVectorImageBuilder(androidx.compose.ui.graphics.vector.compat.AndroidVectorParser $this$createVectorImageBuilder, Resources res, Resources.Theme theme, AttributeSet attrs) {
        Object typedValue;
        long tintColorStateList;
        int modulate-0nO6VwU;
        int companion;
        long l;
        int i;
        final int obj = $this$createVectorImageBuilder;
        final Resources.Theme theme2 = theme;
        final Resources resources = res;
        TypedArray attributes = obj.obtainAttributes(resources, theme2, attrs, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY());
        int i5 = 0;
        final float namedFloat = obj.getNamedFloat(attributes, "viewportWidth", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_VIEWPORT_WIDTH(), i5);
        final float namedFloat2 = obj.getNamedFloat(attributes, "viewportHeight", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_VIEWPORT_HEIGHT(), i5);
        if (Float.compare(namedFloat, i5) <= 0) {
        } else {
            if (Float.compare(namedFloat2, i5) <= 0) {
            } else {
                if (attributes.hasValue(AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TINT())) {
                    typedValue = new TypedValue();
                    attributes.getValue(AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TINT(), typedValue);
                    if (typedValue.type == 2) {
                        l = tintColorStateList;
                    } else {
                        tintColorStateList = obj.getNamedColorStateList(attributes, theme2, "tint", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TINT());
                        if (tintColorStateList != null) {
                            l = companion;
                        } else {
                            l = tintColorStateList;
                        }
                    }
                } else {
                    l = tintColorStateList;
                }
                int i6 = -1;
                int int = obj.getInt(attributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_TINT_MODE(), i6);
                if (int != i6) {
                    switch (int) {
                        case 3:
                            i = modulate-0nO6VwU;
                            break;
                        case 5:
                            i = modulate-0nO6VwU;
                            break;
                        case 9:
                            i = modulate-0nO6VwU;
                            break;
                        case 14:
                            i = modulate-0nO6VwU;
                            break;
                        case 15:
                            i = modulate-0nO6VwU;
                            break;
                        case 16:
                            i = modulate-0nO6VwU;
                            break;
                        default:
                            i = modulate-0nO6VwU;
                    }
                } else {
                    i = modulate-0nO6VwU;
                }
                int i9 = 0;
                int i10 = 0;
                attributes.recycle();
                ImageVector.Builder builder = new ImageVector.Builder(0, Dp.constructor-impl(dimension / density), Dp.constructor-impl(dimension2 / density2), namedFloat, namedFloat2, l, obj15, i, obj.getNamedBoolean(attributes, "autoMirrored", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_AUTO_MIRRORED(), false), 1, 0);
                return builder;
            }
            StringBuilder stringBuilder = new StringBuilder();
            XmlPullParserException defaultWidth = new XmlPullParserException(stringBuilder.append(attributes.getPositionDescription()).append("<VectorGraphic> tag requires viewportHeight > 0").toString());
            throw defaultWidth;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        XmlPullParserException xmlPullParserException = new XmlPullParserException(stringBuilder2.append(attributes.getPositionDescription()).append("<VectorGraphic> tag requires viewportWidth > 0").toString());
        throw xmlPullParserException;
    }

    private static final int getStrokeLineCap-CSYIeUk(int id, int defValue) {
        int square-KaPHkGw;
        switch (id) {
            case 0:
                square-KaPHkGw = StrokeCap.Companion.getButt-KaPHkGw();
                break;
            case 1:
                square-KaPHkGw = StrokeCap.Companion.getRound-KaPHkGw();
                break;
            case 2:
                square-KaPHkGw = StrokeCap.Companion.getSquare-KaPHkGw();
                break;
            default:
                square-KaPHkGw = defValue;
        }
        return square-KaPHkGw;
    }

    static int getStrokeLineCap-CSYIeUk$default(int i, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 2 != 0) {
            obj1 = StrokeCap.Companion.getButt-KaPHkGw();
        }
        return XmlVectorParser_androidKt.getStrokeLineCap-CSYIeUk(i, obj1);
    }

    private static final int getStrokeLineJoin-kLtJ_vA(int id, int defValue) {
        int round-LxFBmk8;
        switch (id) {
            case 0:
                round-LxFBmk8 = StrokeJoin.Companion.getMiter-LxFBmk8();
                break;
            case 1:
                round-LxFBmk8 = StrokeJoin.Companion.getRound-LxFBmk8();
                break;
            case 2:
                round-LxFBmk8 = StrokeJoin.Companion.getBevel-LxFBmk8();
                break;
            default:
                round-LxFBmk8 = defValue;
        }
        return round-LxFBmk8;
    }

    static int getStrokeLineJoin-kLtJ_vA$default(int i, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 2 != 0) {
            obj1 = StrokeJoin.Companion.getMiter-LxFBmk8();
        }
        return XmlVectorParser_androidKt.getStrokeLineJoin-kLtJ_vA(i, obj1);
    }

    public static final boolean isAtEnd(XmlPullParser $this$isAtEnd) {
        int eventType;
        int i;
        int i2;
        i = 1;
        if ($this$isAtEnd.getEventType() != i) {
            if ($this$isAtEnd.getDepth() < i && $this$isAtEnd.getEventType() == 3) {
                if ($this$isAtEnd.getEventType() == 3) {
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static final Brush obtainBrushFromComplexColor(ComplexColorCompat complexColor) {
        android.graphics.Shader shader;
        SolidColor i;
        SolidColor solidColor;
        long l;
        if (complexColor.willDraw()) {
            shader = complexColor.getShader();
            if (shader != null) {
                i = BrushKt.ShaderBrush(shader);
            } else {
                solidColor = new SolidColor(ColorKt.Color(complexColor.getColor()), obj4, 0);
                i = solidColor;
            }
        } else {
        }
        return i;
    }

    public static final void parseClipPath(androidx.compose.ui.graphics.vector.compat.AndroidVectorParser $this$parseClipPath, Resources res, Resources.Theme theme, AttributeSet attrs, ImageVector.Builder builder) {
        String string;
        Object pathStringToNodes$default;
        int i;
        int i2;
        final Object obj = $this$parseClipPath;
        TypedArray attributes = obj.obtainAttributes(res, theme, attrs, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH());
        if (obj.getString(attributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH_NAME()) == null) {
            string = "";
        }
        String string2 = obj.getString(attributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH_PATH_DATA());
        if (string2 == null) {
            pathStringToNodes$default = VectorKt.getEmptyPath();
        } else {
            i2 = 0;
            pathStringToNodes$default = PathParser.pathStringToNodes$default(obj.pathParser, string2, i2, 2, i2);
        }
        attributes.recycle();
        ImageVector.Builder.addGroup$default(builder, string, 0, 0, 0, 0, 0, 0, 0, pathStringToNodes$default, 254, 0);
    }

    public static final int parseCurrentVectorNode(androidx.compose.ui.graphics.vector.compat.AndroidVectorParser $this$parseCurrentVectorNode, Resources res, AttributeSet attrs, Resources.Theme theme, ImageVector.Builder builder, int nestedGroups) {
        int eventType;
        String str;
        int i2;
        int i4;
        int i3;
        int i;
        str = "group";
        switch (eventType) {
            case 2:
                eventType = $this$parseCurrentVectorNode.getXmlParser().getName();
                XmlVectorParser_androidKt.parseGroup($this$parseCurrentVectorNode, res, theme, attrs, builder);
                XmlVectorParser_androidKt.parsePath($this$parseCurrentVectorNode, res, theme, attrs, builder);
                XmlVectorParser_androidKt.parseClipPath($this$parseCurrentVectorNode, res, theme, attrs, builder);
                return nestedGroups + 1;
                break;
            case 3:
                int i8 = 0;
                i4 = i8;
                i3 = i4;
                i = 0;
                builder.clearGroup();
                i4++;
                return i8;
            default:
        }
        return nestedGroups;
    }

    public static int parseCurrentVectorNode$default(androidx.compose.ui.graphics.vector.compat.AndroidVectorParser androidVectorParser, Resources resources2, AttributeSet attributeSet3, Resources.Theme resources$Theme4, ImageVector.Builder imageVector$Builder5, int i6, int i7, Object object8) {
        int i;
        int obj9;
        i = i7 &= 4 != 0 ? obj9 : theme4;
        return XmlVectorParser_androidKt.parseCurrentVectorNode(androidVectorParser, resources2, attributeSet3, i, builder5, i6);
    }

    public static final void parseGroup(androidx.compose.ui.graphics.vector.compat.AndroidVectorParser $this$parseGroup, Resources res, Resources.Theme theme, AttributeSet attrs, ImageVector.Builder builder) {
        String string;
        String str;
        final Object obj = $this$parseGroup;
        TypedArray attributes = obj.obtainAttributes(res, theme, attrs, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP());
        final int i = 0;
        int i2 = 1065353216;
        string = obj.getString(attributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_NAME());
        str = string == null ? string : string;
        attributes.recycle();
        builder.addGroup(str, obj.getNamedFloat(attributes, "rotation", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_ROTATION(), i), obj.getFloat(attributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_PIVOT_X(), i), obj.getFloat(attributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_PIVOT_Y(), i), obj.getNamedFloat(attributes, "scaleX", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_SCALE_X(), i2), obj.getNamedFloat(attributes, "scaleY", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_SCALE_Y(), i2), obj.getNamedFloat(attributes, "translateX", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_TRANSLATE_X(), i), obj.getNamedFloat(attributes, "translateY", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_TRANSLATE_Y(), i), VectorKt.getEmptyPath());
    }

    public static final void parsePath(androidx.compose.ui.graphics.vector.compat.AndroidVectorParser $this$parsePath, Resources res, Resources.Theme theme, AttributeSet attrs, ImageVector.Builder builder) throws java.lang.IllegalArgumentException {
        String string;
        Object pathStringToNodes$default;
        int str;
        int i;
        Object obj;
        int nonZero-Rg-k1Os;
        final Object obj2 = $this$parsePath;
        Resources.Theme theme2 = theme;
        TypedArray attributes = obj2.obtainAttributes(res, theme2, attrs, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH());
        if (!TypedArrayUtils.hasAttribute(obj2.getXmlParser(), "pathData")) {
        } else {
            if (obj2.getString(attributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_NAME()) == null) {
                string = "";
            }
            String string2 = obj2.getString(attributes, AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_PATH_DATA());
            if (string2 == null) {
                obj = pathStringToNodes$default;
            } else {
                i = 0;
                obj = pathStringToNodes$default;
            }
            int i4 = 0;
            int i7 = 1065353216;
            int i2 = -1;
            int namedInt2 = obj2.getNamedInt(attributes, "strokeLineCap", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_LINE_CAP(), i2);
            int namedInt3 = obj2.getNamedInt(attributes, "strokeLineJoin", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_LINE_JOIN(), i2);
            int i5 = 0;
            attributes.recycle();
            PathFillType.Companion companion3 = PathFillType.Companion;
            if (obj2.getNamedInt(attributes, "fillType", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_FILLTYPE(), XmlVectorParser_androidKt.FILL_TYPE_WINDING) == 0) {
                nonZero-Rg-k1Os = companion3.getNonZero-Rg-k1Os();
            } else {
                nonZero-Rg-k1Os = companion3.getEvenOdd-Rg-k1Os();
            }
            final int i8 = i6;
            int lineJoin = i3;
            String lineCap = string2;
            builder.addPath-oIyEayM(obj, nonZero-Rg-k1Os, string, XmlVectorParser_androidKt.obtainBrushFromComplexColor(obj2.getNamedComplexColor(attributes, theme2, "fillColor", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_FILL_COLOR(), i4)), obj2.getNamedFloat(attributes, "fillAlpha", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_FILL_ALPHA(), i7), XmlVectorParser_androidKt.obtainBrushFromComplexColor(obj2.getNamedComplexColor(attributes, theme, "strokeColor", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_COLOR(), i4)), obj2.getNamedFloat(attributes, "strokeAlpha", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_ALPHA(), i7), obj2.getNamedFloat(attributes, "strokeWidth", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_WIDTH(), i7), XmlVectorParser_androidKt.getStrokeLineCap-CSYIeUk(namedInt2, StrokeCap.Companion.getButt-KaPHkGw()), XmlVectorParser_androidKt.getStrokeLineJoin-kLtJ_vA(namedInt3, StrokeJoin.Companion.getBevel-LxFBmk8()), obj2.getNamedFloat(attributes, "strokeMiterLimit", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_MITER_LIMIT(), i7), obj2.getNamedFloat(attributes, "trimPathStart", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_START(), i5), obj2.getNamedFloat(attributes, "trimPathEnd", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_END(), i7), obj2.getNamedFloat(attributes, "trimPathOffset", AndroidVectorResources.INSTANCE.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_OFFSET(), i5));
        }
        IllegalArgumentException fillRule = new IllegalArgumentException("No path data available");
        throw fillRule;
    }

    public static final XmlPullParser seekToStartTag(XmlPullParser $this$seekToStartTag) throws XmlPullParserException {
        int type;
        int i;
        int i2;
        type = $this$seekToStartTag.next();
        i = 2;
        while (type != i) {
            if (type != 1) {
            }
            type = $this$seekToStartTag.next();
            i = 2;
        }
        if (type != i) {
        } else {
            return $this$seekToStartTag;
        }
        XmlPullParserException xmlPullParserException = new XmlPullParserException("No start tag found");
        throw xmlPullParserException;
    }
}

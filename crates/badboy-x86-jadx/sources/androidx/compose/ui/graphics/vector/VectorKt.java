package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendMode.Companion;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.PathFillType.Companion;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeCap.Companion;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.StrokeJoin.Companion;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u001a(\u0010(\u001a\u0008\u0012\u0004\u0012\u00020%0$2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*¢\u0006\u0002\u0008-H\u0086\u0008\u001a\u0016\u0010.\u001a\u0008\u0012\u0004\u0012\u00020%0$2\u0008\u0010/\u001a\u0004\u0018\u00010\u0006\u001a\u001e\u00100\u001a\u000201*\u00020\u001a2\u0006\u00102\u001a\u00020\u001aH\u0000ø\u0001\u0000¢\u0006\u0004\u00083\u00104\u001a\u000e\u00105\u001a\u000201*\u0004\u0018\u000106H\u0000\"\u0013\u0010\u0000\u001a\u00020\u0001¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0002\u0010\u0003\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u0013\u0010\u000e\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0010\u0010\u0003\"\u0013\u0010\u0011\u001a\u00020\u0012¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0013\u0010\u0003\"\u000e\u0010\u0014\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0016\u001a\u00020\u0017¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0018\u0010\u0003\"\u0013\u0010\u0019\u001a\u00020\u001a¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\u0008\u001b\u0010\u001c\"\u000e\u0010\u001e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\"\u0017\u0010#\u001a\u0008\u0012\u0004\u0012\u00020%0$¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00067", d2 = {"DefaultFillType", "Landroidx/compose/ui/graphics/PathFillType;", "getDefaultFillType", "()I", "I", "DefaultGroupName", "", "DefaultPathName", "DefaultPivotX", "", "DefaultPivotY", "DefaultRotation", "DefaultScaleX", "DefaultScaleY", "DefaultStrokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getDefaultStrokeLineCap", "DefaultStrokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getDefaultStrokeLineJoin", "DefaultStrokeLineMiter", "DefaultStrokeLineWidth", "DefaultTintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getDefaultTintBlendMode", "DefaultTintColor", "Landroidx/compose/ui/graphics/Color;", "getDefaultTintColor", "()J", "J", "DefaultTranslationX", "DefaultTranslationY", "DefaultTrimPathEnd", "DefaultTrimPathOffset", "DefaultTrimPathStart", "EmptyPath", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "getEmptyPath", "()Ljava/util/List;", "PathData", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "Lkotlin/ExtensionFunctionType;", "addPathNodes", "pathStr", "rgbEqual", "", "other", "rgbEqual--OWjLjI", "(JJ)Z", "tintableWithAlphaMask", "Landroidx/compose/ui/graphics/ColorFilter;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VectorKt {

    private static final int DefaultFillType = 0;
    public static final String DefaultGroupName = "";
    public static final String DefaultPathName = "";
    public static final float DefaultPivotX = 0f;
    public static final float DefaultPivotY = 0f;
    public static final float DefaultRotation = 0f;
    public static final float DefaultScaleX = 1f;
    public static final float DefaultScaleY = 1f;
    private static final int DefaultStrokeLineCap = 0;
    private static final int DefaultStrokeLineJoin = 0;
    public static final float DefaultStrokeLineMiter = 4f;
    public static final float DefaultStrokeLineWidth = 0f;
    private static final int DefaultTintBlendMode = 0;
    private static final long DefaultTintColor = 0L;
    public static final float DefaultTranslationX = 0f;
    public static final float DefaultTranslationY = 0f;
    public static final float DefaultTrimPathEnd = 1f;
    public static final float DefaultTrimPathOffset;
    public static final float DefaultTrimPathStart;
    private static final List<androidx.compose.ui.graphics.vector.PathNode> EmptyPath;
    static {
        VectorKt.EmptyPath = CollectionsKt.emptyList();
        VectorKt.DefaultStrokeLineCap = StrokeCap.Companion.getButt-KaPHkGw();
        VectorKt.DefaultStrokeLineJoin = StrokeJoin.Companion.getMiter-LxFBmk8();
        VectorKt.DefaultTintBlendMode = BlendMode.Companion.getSrcIn-0nO6VwU();
        VectorKt.DefaultTintColor = Color.Companion.getTransparent-0d7_KjU();
        VectorKt.DefaultFillType = PathFillType.Companion.getNonZero-Rg-k1Os();
    }

    public static final List<androidx.compose.ui.graphics.vector.PathNode> PathData(Function1<? super androidx.compose.ui.graphics.vector.PathBuilder, Unit> block) {
        final int i = 0;
        PathBuilder pathBuilder = new PathBuilder();
        final int i2 = 0;
        block.invoke(pathBuilder);
        return pathBuilder.getNodes();
    }

    public static final List<androidx.compose.ui.graphics.vector.PathNode> addPathNodes(String pathStr) {
        List emptyPath;
        if (pathStr == null) {
            emptyPath = VectorKt.EmptyPath;
        } else {
            PathParser pathParser = new PathParser();
            emptyPath = pathParser.parsePathString(pathStr).toNodes();
        }
        return emptyPath;
    }

    public static final int getDefaultFillType() {
        return VectorKt.DefaultFillType;
    }

    public static final int getDefaultStrokeLineCap() {
        return VectorKt.DefaultStrokeLineCap;
    }

    public static final int getDefaultStrokeLineJoin() {
        return VectorKt.DefaultStrokeLineJoin;
    }

    public static final int getDefaultTintBlendMode() {
        return VectorKt.DefaultTintBlendMode;
    }

    public static final long getDefaultTintColor() {
        return VectorKt.DefaultTintColor;
    }

    public static final List<androidx.compose.ui.graphics.vector.PathNode> getEmptyPath() {
        return VectorKt.EmptyPath;
    }

    public static final boolean rgbEqual--OWjLjI(long $this$rgbEqual_u2d_u2dOWjLjI, long other) {
        int i;
        int i2;
        float green-impl;
        i2 = 1;
        final int i3 = 0;
        i = Float.compare(red-impl, red-impl2) == 0 ? i2 : i3;
        if (i != 0) {
            i = Float.compare(green-impl2, green-impl) == 0 ? i2 : i3;
            if (i != 0) {
                i = Float.compare(blue-impl, green-impl) == 0 ? i2 : i3;
                if (i != 0) {
                } else {
                    i2 = i3;
                }
            } else {
            }
        } else {
        }
        return i2;
    }

    public static final boolean tintableWithAlphaMask(ColorFilter $this$tintableWithAlphaMask) {
        boolean equals-impl0;
        int i;
        int srcOver-0nO6VwU;
        i = 1;
        final int i2 = 0;
        if ($this$tintableWithAlphaMask instanceof BlendModeColorFilter) {
            if (!BlendMode.equals-impl0((BlendModeColorFilter)$this$tintableWithAlphaMask.getBlendMode-0nO6VwU(), BlendMode.Companion.getSrcIn-0nO6VwU())) {
                if (BlendMode.equals-impl0((BlendModeColorFilter)$this$tintableWithAlphaMask.getBlendMode-0nO6VwU(), BlendMode.Companion.getSrcOver-0nO6VwU())) {
                } else {
                    i = i2;
                }
            }
        } else {
            if ($this$tintableWithAlphaMask == null) {
            } else {
                i = i2;
            }
        }
        return i;
    }
}

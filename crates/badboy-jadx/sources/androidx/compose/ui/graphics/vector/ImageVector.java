package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendMode.Companion;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u001a\u0008\u0007\u0018\u0000 ,2\u00020\u0001:\u0002+,BY\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0008\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0013\u0010(\u001a\u00020\u00112\u0008\u0010)\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010*\u001a\u00020\u0013H\u0016R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0019\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\u0008\u0017\u0010\u0018R\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\u0008\u001a\u0010\u0018R\u0014\u0010\u0012\u001a\u00020\u0013X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0019\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\"\u001a\u0004\u0008!\u0010\u001cR\u0019\u0010\u000c\u001a\u00020\rø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010%\u001a\u0004\u0008#\u0010$R\u0011\u0010\t\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u0018\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006-", d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector;", "", "name", "", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "root", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "autoMirror", "", "genId", "", "(Ljava/lang/String;FFFFLandroidx/compose/ui/graphics/vector/VectorGroup;JIZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAutoMirror", "()Z", "getDefaultHeight-D9Ej5fM", "()F", "F", "getDefaultWidth-D9Ej5fM", "getGenId$ui_release", "()I", "getName", "()Ljava/lang/String;", "getRoot", "()Landroidx/compose/ui/graphics/vector/VectorGroup;", "getTintBlendMode-0nO6VwU", "I", "getTintColor-0d7_KjU", "()J", "J", "getViewportHeight", "getViewportWidth", "equals", "other", "hashCode", "Builder", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ImageVector {

    public static final int $stable;
    public static final androidx.compose.ui.graphics.vector.ImageVector.Companion Companion;
    private static int imageVectorCount;
    private final boolean autoMirror;
    private final float defaultHeight;
    private final float defaultWidth;
    private final int genId;
    private final String name;
    private final androidx.compose.ui.graphics.vector.VectorGroup root;
    private final int tintBlendMode;
    private final long tintColor;
    private final float viewportHeight;
    private final float viewportWidth;

    @Metadata(d1 = "\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001:\u0001DBE\u0008\u0017\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eBM\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011Jf\u0010\u001e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u00082\u0008\u0008\u0002\u0010 \u001a\u00020\u00082\u0008\u0008\u0002\u0010!\u001a\u00020\u00082\u0008\u0008\u0002\u0010\"\u001a\u00020\u00082\u0008\u0008\u0002\u0010#\u001a\u00020\u00082\u0008\u0008\u0002\u0010$\u001a\u00020\u00082\u0008\u0008\u0002\u0010%\u001a\u00020\u00082\u000e\u0008\u0002\u0010&\u001a\u0008\u0012\u0004\u0012\u00020(0'J¤\u0001\u0010)\u001a\u00020\u00002\u000c\u0010*\u001a\u0008\u0012\u0004\u0012\u00020(0'2\u0008\u0008\u0002\u0010+\u001a\u00020,2\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010-\u001a\u0004\u0018\u00010.2\u0008\u0008\u0002\u0010/\u001a\u00020\u00082\n\u0008\u0002\u00100\u001a\u0004\u0018\u00010.2\u0008\u0008\u0002\u00101\u001a\u00020\u00082\u0008\u0008\u0002\u00102\u001a\u00020\u00082\u0008\u0008\u0002\u00103\u001a\u0002042\u0008\u0008\u0002\u00105\u001a\u0002062\u0008\u0008\u0002\u00107\u001a\u00020\u00082\u0008\u0008\u0002\u00108\u001a\u00020\u00082\u0008\u0008\u0002\u00109\u001a\u00020\u00082\u0008\u0008\u0002\u0010:\u001a\u00020\u0008ø\u0001\u0000¢\u0006\u0004\u0008;\u0010<J\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020\u0000J\u0008\u0010@\u001a\u00020AH\u0002J\u000c\u0010B\u001a\u00020C*\u00020\u0013H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0019j\u0008\u0012\u0004\u0012\u00020\u0013`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000c\u001a\u00020\rX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001cR\u0016\u0010\n\u001a\u00020\u000bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\t\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006E", d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "", "name", "", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "(Ljava/lang/String;FFFFJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "autoMirror", "", "(Ljava/lang/String;FFFFJIZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "currentGroup", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "getCurrentGroup", "()Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "F", "isConsumed", "nodes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "root", "I", "J", "addGroup", "rotate", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "addPath", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "addPath-oIyEayM", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFF)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "build", "Landroidx/compose/ui/graphics/vector/ImageVector;", "clearGroup", "ensureNotConsumed", "", "asVectorGroup", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "GroupParams", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {

        public static final int $stable = 8;
        private final boolean autoMirror;
        private final float defaultHeight;
        private final float defaultWidth;
        private boolean isConsumed;
        private final String name;
        private final ArrayList<androidx.compose.ui.graphics.vector.ImageVector.Builder.GroupParams> nodes;
        private androidx.compose.ui.graphics.vector.ImageVector.Builder.GroupParams root;
        private final int tintBlendMode;
        private final long tintColor;
        private final float viewportHeight;
        private final float viewportWidth;
        static {
            final int i = 8;
        }

        private Builder(String name, float defaultWidth, float defaultHeight, float viewportWidth, float viewportHeight, long tintColor, int tintBlendMode) {
            super(name, defaultWidth, defaultHeight, viewportWidth, viewportHeight, tintColor, obj7, obj19, 0, 0);
        }

        public Builder(String string, float f2, float f3, float f4, float f5, long l6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker9) {
            String str;
            long unspecified-0d7_KjU;
            long l;
            int i;
            String obj11;
            str = defaultConstructorMarker9 & 1 != 0 ? obj11 : string;
            if (defaultConstructorMarker9 & 32 != 0) {
                l = unspecified-0d7_KjU;
            } else {
                l = l6;
            }
            if (defaultConstructorMarker9 & 64 != 0) {
                i = obj11;
            } else {
                i = i8;
            }
            super(str, f2, f3, f4, f5, l, obj7, i, 0);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with ImageVector.Builder that consumes an optional auto mirror parameter", replaceWith = @ReplaceWith(...))
        public Builder(String string, float f2, float f3, float f4, float f5, long l6, int i7, DefaultConstructorMarker defaultConstructorMarker8) {
            super(string, f2, f3, f4, f5, l6, i7, defaultConstructorMarker8);
        }

        private Builder(String name, float defaultWidth, float defaultHeight, float viewportWidth, float viewportHeight, long tintColor, int tintBlendMode, boolean autoMirror) {
            final Object obj = this;
            super();
            obj.name = name;
            obj.defaultWidth = defaultWidth;
            obj.defaultHeight = defaultHeight;
            obj.viewportWidth = viewportWidth;
            obj.viewportHeight = viewportHeight;
            obj.tintColor = tintColor;
            obj.tintBlendMode = autoMirror;
            obj.autoMirror = obj33;
            ArrayList arrayList = new ArrayList();
            obj.nodes = arrayList;
            ImageVector.Builder.GroupParams groupParams = new ImageVector.Builder.GroupParams(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1023, 0);
            obj.root = groupParams;
            ImageVectorKt.access$push(obj.nodes, obj.root);
        }

        public Builder(String string, float f2, float f3, float f4, float f5, long l6, int i7, boolean z8, int i9, DefaultConstructorMarker defaultConstructorMarker10) {
            String str;
            long unspecified-0d7_KjU;
            long l;
            int i;
            int i2;
            String obj12;
            int i3 = defaultConstructorMarker10;
            str = i3 & 1 != 0 ? obj12 : string;
            if (i3 & 32 != 0) {
                l = unspecified-0d7_KjU;
            } else {
                l = l6;
            }
            if (i3 & 64 != 0) {
                i = obj12;
            } else {
                i = z8;
            }
            i2 = i3 & 128 != 0 ? obj12 : i9;
            super(str, f2, f3, f4, f5, l, obj7, i, i2, 0);
        }

        public Builder(String string, float f2, float f3, float f4, float f5, long l6, int i7, boolean z8, DefaultConstructorMarker defaultConstructorMarker9) {
            super(string, f2, f3, f4, f5, l6, i7, z8, defaultConstructorMarker9);
        }

        public static androidx.compose.ui.graphics.vector.ImageVector.Builder addGroup$default(androidx.compose.ui.graphics.vector.ImageVector.Builder imageVector$Builder, String string2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, List list10, int i11, Object object12) {
            String obj3;
            int obj4;
            int obj5;
            int obj6;
            int obj7;
            int obj8;
            int obj9;
            int obj10;
            List obj11;
            List obj13;
            if (i11 & 1 != 0) {
                obj3 = "";
            }
            final int i = 0;
            if (i11 & 2 != 0) {
                obj4 = i;
            }
            if (i11 & 4 != 0) {
                obj5 = i;
            }
            if (i11 & 8 != 0) {
                obj6 = i;
            }
            final int i2 = 1065353216;
            if (i11 & 16 != 0) {
                obj7 = i2;
            }
            if (i11 & 32 != 0) {
                obj8 = i2;
            }
            if (i11 & 64 != 0) {
                obj9 = i;
            }
            if (i11 & 128 != 0) {
                obj10 = i;
            }
            if (i11 &= 256 != 0) {
                obj13 = obj11;
            } else {
                obj13 = list10;
            }
            return builder.addGroup(obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj13);
        }

        public static androidx.compose.ui.graphics.vector.ImageVector.Builder addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector.Builder imageVector$Builder, List list2, int i3, String string4, Brush brush5, float f6, Brush brush7, float f8, float f9, int i10, int i11, float f12, float f13, float f14, float f15, int i16, Object object17) {
            int defaultFillType;
            String str;
            int i;
            int i7;
            int i12;
            int i9;
            int i8;
            int i5;
            int i6;
            int defaultStrokeLineCap;
            int defaultStrokeLineJoin;
            int i2;
            int i4;
            int i13 = i16;
            if (i13 & 2 != 0) {
                defaultFillType = VectorKt.getDefaultFillType();
            } else {
                defaultFillType = i3;
            }
            str = i13 & 4 != 0 ? "" : string4;
            i = i13 & 8 != 0 ? i7 : brush5;
            i9 = 1065353216;
            i12 = i13 & 16 != 0 ? i9 : f6;
            if (i13 & 32 != 0) {
            } else {
                i7 = brush7;
            }
            i8 = i13 & 64 != 0 ? i9 : f8;
            i6 = 0;
            i5 = i13 & 128 != 0 ? i6 : f9;
            if (i13 & 256 != 0) {
                defaultStrokeLineCap = VectorKt.getDefaultStrokeLineCap();
            } else {
                defaultStrokeLineCap = i10;
            }
            if (i13 & 512 != 0) {
                defaultStrokeLineJoin = VectorKt.getDefaultStrokeLineJoin();
            } else {
                defaultStrokeLineJoin = i11;
            }
            i2 = i13 & 1024 != 0 ? 1082130432 : f12;
            i4 = i13 & 2048 != 0 ? i6 : f13;
            if (i13 & 4096 != 0) {
            } else {
                i9 = f14;
            }
            if (i13 &= 8192 != 0) {
            } else {
                i6 = f15;
            }
            return builder.addPath-oIyEayM(list2, defaultFillType, str, i, i12, i7, i8, i5, defaultStrokeLineCap, defaultStrokeLineJoin, i2, i4, i9, i6);
        }

        private final androidx.compose.ui.graphics.vector.VectorGroup asVectorGroup(androidx.compose.ui.graphics.vector.ImageVector.Builder.GroupParams $this$asVectorGroup) {
            VectorGroup vectorGroup = new VectorGroup($this$asVectorGroup.getName(), $this$asVectorGroup.getRotate(), $this$asVectorGroup.getPivotX(), $this$asVectorGroup.getPivotY(), $this$asVectorGroup.getScaleX(), $this$asVectorGroup.getScaleY(), $this$asVectorGroup.getTranslationX(), $this$asVectorGroup.getTranslationY(), $this$asVectorGroup.getClipPathData(), $this$asVectorGroup.getChildren());
            return vectorGroup;
        }

        private final void ensureNotConsumed() {
            String $i$a$CheckPreconditionImageVector$Builder$ensureNotConsumed$1;
            final int i2 = 0;
            if (isConsumed ^= 1 == 0) {
                int i3 = 0;
                InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
            }
        }

        private final androidx.compose.ui.graphics.vector.ImageVector.Builder.GroupParams getCurrentGroup() {
            return (ImageVector.Builder.GroupParams)ImageVectorKt.access$peek(this.nodes);
        }

        public final androidx.compose.ui.graphics.vector.ImageVector.Builder addGroup(String name, float rotate, float pivotX, float pivotY, float scaleX, float scaleY, float translationX, float translationY, List<? extends androidx.compose.ui.graphics.vector.PathNode> clipPathData) {
            ensureNotConsumed();
            ImageVector.Builder.GroupParams groupParams = new ImageVector.Builder.GroupParams(name, rotate, pivotX, pivotY, scaleX, scaleY, translationX, translationY, clipPathData, 0, 512, 0);
            ImageVectorKt.access$push(this.nodes, groupParams);
            return this;
        }

        public final androidx.compose.ui.graphics.vector.ImageVector.Builder addPath-oIyEayM(List<? extends androidx.compose.ui.graphics.vector.PathNode> pathData, int pathFillType, String name, Brush fill, float fillAlpha, Brush stroke, float strokeAlpha, float strokeLineWidth, int strokeLineCap, int strokeLineJoin, float strokeLineMiter, float trimPathStart, float trimPathEnd, float trimPathOffset) {
            ensureNotConsumed();
            VectorPath vectorPath = new VectorPath(name, pathData, pathFillType, fill, fillAlpha, stroke, strokeAlpha, strokeLineWidth, strokeLineCap, strokeLineJoin, strokeLineMiter, trimPathStart, trimPathEnd, trimPathOffset, 0);
            getCurrentGroup().getChildren().add(vectorPath);
            return this;
        }

        public final androidx.compose.ui.graphics.vector.ImageVector build() {
            int size;
            int i;
            final Object obj = this;
            obj.ensureNotConsumed();
            i = 1;
            while (obj.nodes.size() > i) {
                obj.clearGroup();
                i = 1;
            }
            ImageVector imageVector = new ImageVector(obj.name, obj.defaultWidth, obj.defaultHeight, obj.viewportWidth, obj.viewportHeight, obj.asVectorGroup(obj.root), obj.tintColor, obj11, obj.tintBlendMode, obj.autoMirror, 0, 512, 0);
            obj.isConsumed = i;
            return imageVector;
        }

        public final androidx.compose.ui.graphics.vector.ImageVector.Builder clearGroup() {
            ensureNotConsumed();
            getCurrentGroup().getChildren().add(asVectorGroup((ImageVector.Builder.GroupParams)ImageVectorKt.access$pop(this.nodes)));
            return this;
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0008\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Landroidx/compose/ui/graphics/vector/ImageVector$Companion;", "", "()V", "imageVectorCount", "", "generateImageVectorId", "generateImageVectorId$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int generateImageVectorId$ui_release() {
            final int i = 0;
            androidx.compose.ui.graphics.vector.ImageVector.Companion companion = ImageVector.Companion;
            int i2 = ImageVector.access$getImageVectorCount$cp();
            ImageVector.access$setImageVectorCount$cp(i2 + 1);
            return i2;
            synchronized (this) {
                i = 0;
                companion = ImageVector.Companion;
                i2 = ImageVector.access$getImageVectorCount$cp();
                ImageVector.access$setImageVectorCount$cp(i2 + 1);
                return i2;
            }
        }
    }
    static {
        ImageVector.Companion companion = new ImageVector.Companion(0);
        ImageVector.Companion = companion;
    }

    private ImageVector(String name, float defaultWidth, float defaultHeight, float viewportWidth, float viewportHeight, androidx.compose.ui.graphics.vector.VectorGroup root, long tintColor, int tintBlendMode, boolean autoMirror, int genId) {
        super();
        this.name = name;
        this.defaultWidth = defaultWidth;
        this.defaultHeight = defaultHeight;
        this.viewportWidth = viewportWidth;
        this.viewportHeight = viewportHeight;
        this.root = root;
        this.tintColor = tintColor;
        this.tintBlendMode = autoMirror;
        this.autoMirror = genId;
        this.genId = obj11;
    }

    public ImageVector(String string, float f2, float f3, float f4, float f5, androidx.compose.ui.graphics.vector.VectorGroup vectorGroup6, long l7, int i8, boolean z9, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker12) {
        int imageVectorId$ui_release;
        int i;
        if (i2 &= 512 != 0) {
            i = imageVectorId$ui_release;
        } else {
            i = i11;
        }
        super(string, f2, f3, f4, f5, vectorGroup6, l7, obj9, z9, i10, i, 0);
    }

    public ImageVector(String string, float f2, float f3, float f4, float f5, androidx.compose.ui.graphics.vector.VectorGroup vectorGroup6, long l7, int i8, boolean z9, int i10, DefaultConstructorMarker defaultConstructorMarker11) {
        super(string, f2, f3, f4, f5, vectorGroup6, l7, i8, z9, i10, defaultConstructorMarker11);
    }

    public static final int access$getImageVectorCount$cp() {
        return ImageVector.imageVectorCount;
    }

    public static final void access$setImageVectorCount$cp(int <set-?>) {
        ImageVector.imageVectorCount = <set-?>;
    }

    public boolean equals(Object other) {
        int i2;
        int i;
        final int i3 = 1;
        if (this == other) {
            return i3;
        }
        final int i4 = 0;
        if (!other instanceof ImageVector) {
            return i4;
        }
        if (!Intrinsics.areEqual(this.name, obj2.name)) {
            return i4;
        }
        if (!Dp.equals-impl0(this.defaultWidth, obj3.defaultWidth)) {
            return i4;
        }
        if (!Dp.equals-impl0(this.defaultHeight, obj4.defaultHeight)) {
            return i4;
        }
        i2 = Float.compare(viewportWidth, viewportWidth2) == 0 ? i3 : i4;
        if (i2 == 0) {
            return i4;
        }
        i = Float.compare(viewportHeight, viewportHeight2) == 0 ? i3 : i4;
        if (i == 0) {
            return i4;
        }
        if (!Intrinsics.areEqual(this.root, obj7.root)) {
            return i4;
        }
        if (!Color.equals-impl0(this.tintColor, obj4)) {
            return i4;
        }
        if (!BlendMode.equals-impl0(this.tintBlendMode, obj8.tintBlendMode)) {
            return i4;
        }
        if (this.autoMirror != obj9.autoMirror) {
            return i4;
        }
        return i3;
    }

    public final boolean getAutoMirror() {
        return this.autoMirror;
    }

    public final float getDefaultHeight-D9Ej5fM() {
        return this.defaultHeight;
    }

    public final float getDefaultWidth-D9Ej5fM() {
        return this.defaultWidth;
    }

    public final int getGenId$ui_release() {
        return this.genId;
    }

    public final String getName() {
        return this.name;
    }

    public final androidx.compose.ui.graphics.vector.VectorGroup getRoot() {
        return this.root;
    }

    public final int getTintBlendMode-0nO6VwU() {
        return this.tintBlendMode;
    }

    public final long getTintColor-0d7_KjU() {
        return this.tintColor;
    }

    public final float getViewportHeight() {
        return this.viewportHeight;
    }

    public final float getViewportWidth() {
        return this.viewportWidth;
    }

    public int hashCode() {
        return result4 += i18;
    }
}

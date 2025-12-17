package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.DpRect;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@MeasureScopeMarker
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008g\u0018\u00002\u00020\u0001Jd\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0008\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u00082\u001b\u0008\u0002\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0002\u0008\u000e2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000eH\u0016JG\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0008\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u00082\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000eH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0011À\u0006\u0003", d2 = {"Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "placementBlock", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MeasureScope extends androidx.compose.ui.layout.IntrinsicMeasureScope {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isLookingAhead(androidx.compose.ui.layout.MeasureScope $this) {
            return MeasureScope.access$isLookingAhead$jd($this);
        }

        @Deprecated
        public static androidx.compose.ui.layout.MeasureResult layout(androidx.compose.ui.layout.MeasureScope $this, int width, int height, Map<androidx.compose.ui.layout.AlignmentLine, Integer> alignmentLines, Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, Unit> placementBlock) {
            return MeasureScope.access$layout$jd($this, width, height, alignmentLines, placementBlock);
        }

        @Deprecated
        public static androidx.compose.ui.layout.MeasureResult layout(androidx.compose.ui.layout.MeasureScope $this, int width, int height, Map<androidx.compose.ui.layout.AlignmentLine, Integer> alignmentLines, Function1<? super androidx.compose.ui.layout.RulerScope, Unit> rulers, Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, Unit> placementBlock) {
            return MeasureScope.access$layout$jd($this, width, height, alignmentLines, rulers, placementBlock);
        }

        public static androidx.compose.ui.layout.MeasureResult layout$default(androidx.compose.ui.layout.MeasureScope measureScope, int i2, int i3, Map map4, Function1 function15, int i6, Object object7) {
            return MeasureScope.layout$default(measureScope, i2, i3, map4, function15, i6, object7);
        }

        public static androidx.compose.ui.layout.MeasureResult layout$default(androidx.compose.ui.layout.MeasureScope measureScope, int i2, int i3, Map map4, Function1 function15, Function1 function16, int i7, Object object8) {
            return MeasureScope.layout$default(measureScope, i2, i3, map4, function15, function16, i7, object8);
        }

        @Deprecated
        public static int roundToPx--R2X_6o(androidx.compose.ui.layout.MeasureScope $this, long $receiver) {
            return MeasureScope.access$roundToPx--R2X_6o$jd($this, $receiver);
        }

        @Deprecated
        public static int roundToPx-0680j_4(androidx.compose.ui.layout.MeasureScope $this, float $receiver) {
            return MeasureScope.access$roundToPx-0680j_4$jd($this, $receiver);
        }

        @Deprecated
        public static float toDp-GaN1DYA(androidx.compose.ui.layout.MeasureScope $this, long $receiver) {
            return MeasureScope.access$toDp-GaN1DYA$jd($this, $receiver);
        }

        @Deprecated
        public static float toDp-u2uoSUM(androidx.compose.ui.layout.MeasureScope $this, float $receiver) {
            return MeasureScope.access$toDp-u2uoSUM$jd($this, $receiver);
        }

        @Deprecated
        public static float toDp-u2uoSUM(androidx.compose.ui.layout.MeasureScope $this, int $receiver) {
            return MeasureScope.access$toDp-u2uoSUM$jd($this, $receiver);
        }

        @Deprecated
        public static long toDpSize-k-rfVVM(androidx.compose.ui.layout.MeasureScope $this, long $receiver) {
            return MeasureScope.access$toDpSize-k-rfVVM$jd($this, $receiver);
        }

        @Deprecated
        public static float toPx--R2X_6o(androidx.compose.ui.layout.MeasureScope $this, long $receiver) {
            return MeasureScope.access$toPx--R2X_6o$jd($this, $receiver);
        }

        @Deprecated
        public static float toPx-0680j_4(androidx.compose.ui.layout.MeasureScope $this, float $receiver) {
            return MeasureScope.access$toPx-0680j_4$jd($this, $receiver);
        }

        @Deprecated
        public static Rect toRect(androidx.compose.ui.layout.MeasureScope $this, DpRect $receiver) {
            return MeasureScope.access$toRect$jd($this, $receiver);
        }

        @Deprecated
        public static long toSize-XkaWNTQ(androidx.compose.ui.layout.MeasureScope $this, long $receiver) {
            return MeasureScope.access$toSize-XkaWNTQ$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-0xMU5do(androidx.compose.ui.layout.MeasureScope $this, float $receiver) {
            return MeasureScope.access$toSp-0xMU5do$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-kPz2Gy4(androidx.compose.ui.layout.MeasureScope $this, float $receiver) {
            return MeasureScope.access$toSp-kPz2Gy4$jd($this, $receiver);
        }

        @Deprecated
        public static long toSp-kPz2Gy4(androidx.compose.ui.layout.MeasureScope $this, int $receiver) {
            return MeasureScope.access$toSp-kPz2Gy4$jd($this, $receiver);
        }
    }
    public static boolean access$isLookingAhead$jd(androidx.compose.ui.layout.MeasureScope $this) {
        return super.isLookingAhead();
    }

    public static androidx.compose.ui.layout.MeasureResult access$layout$jd(androidx.compose.ui.layout.MeasureScope $this, int width, int height, Map alignmentLines, Function1 placementBlock) {
        return super.layout(width, height, alignmentLines, placementBlock);
    }

    public static androidx.compose.ui.layout.MeasureResult access$layout$jd(androidx.compose.ui.layout.MeasureScope $this, int width, int height, Map alignmentLines, Function1 rulers, Function1 placementBlock) {
        return super.layout(width, height, alignmentLines, rulers, placementBlock);
    }

    public static int access$roundToPx--R2X_6o$jd(androidx.compose.ui.layout.MeasureScope $this, long $receiver) {
        return super.roundToPx--R2X_6o($receiver);
    }

    public static int access$roundToPx-0680j_4$jd(androidx.compose.ui.layout.MeasureScope $this, float $receiver) {
        return super.roundToPx-0680j_4($receiver);
    }

    public static float access$toDp-GaN1DYA$jd(androidx.compose.ui.layout.MeasureScope $this, long $receiver) {
        return super.toDp-GaN1DYA($receiver);
    }

    public static float access$toDp-u2uoSUM$jd(androidx.compose.ui.layout.MeasureScope $this, float $receiver) {
        return super.toDp-u2uoSUM($receiver);
    }

    public static float access$toDp-u2uoSUM$jd(androidx.compose.ui.layout.MeasureScope $this, int $receiver) {
        return super.toDp-u2uoSUM($receiver);
    }

    public static long access$toDpSize-k-rfVVM$jd(androidx.compose.ui.layout.MeasureScope $this, long $receiver) {
        return super.toDpSize-k-rfVVM($receiver);
    }

    public static float access$toPx--R2X_6o$jd(androidx.compose.ui.layout.MeasureScope $this, long $receiver) {
        return super.toPx--R2X_6o($receiver);
    }

    public static float access$toPx-0680j_4$jd(androidx.compose.ui.layout.MeasureScope $this, float $receiver) {
        return super.toPx-0680j_4($receiver);
    }

    public static Rect access$toRect$jd(androidx.compose.ui.layout.MeasureScope $this, DpRect $receiver) {
        return super.toRect($receiver);
    }

    public static long access$toSize-XkaWNTQ$jd(androidx.compose.ui.layout.MeasureScope $this, long $receiver) {
        return super.toSize-XkaWNTQ($receiver);
    }

    public static long access$toSp-0xMU5do$jd(androidx.compose.ui.layout.MeasureScope $this, float $receiver) {
        return super.toSp-0xMU5do($receiver);
    }

    public static long access$toSp-kPz2Gy4$jd(androidx.compose.ui.layout.MeasureScope $this, float $receiver) {
        return super.toSp-kPz2Gy4($receiver);
    }

    public static long access$toSp-kPz2Gy4$jd(androidx.compose.ui.layout.MeasureScope $this, int $receiver) {
        return super.toSp-kPz2Gy4($receiver);
    }

    public static androidx.compose.ui.layout.MeasureResult layout$default(androidx.compose.ui.layout.MeasureScope measureScope, int i2, int i3, Map map4, Function1 function15, int i6, Object object7) {
        Map obj3;
        if (object7 != null) {
        } else {
            if (i6 &= 4 != 0) {
                obj3 = MapsKt.emptyMap();
            }
            return measureScope.layout(i2, i3, obj3, function15);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
        throw obj0;
    }

    public static androidx.compose.ui.layout.MeasureResult layout$default(androidx.compose.ui.layout.MeasureScope measureScope, int i2, int i3, Map map4, Function1 function15, Function1 function16, int i7, Object object8) {
        Map map;
        int i;
        Map obj9;
        int obj10;
        if (object8 != null) {
        } else {
            if (i7 & 4 != 0) {
                map = obj9;
            } else {
                map = map4;
            }
            i = i7 & 8 != 0 ? obj10 : function15;
            return measureScope.layout(i2, i3, map, i, function16);
        }
        UnsupportedOperationException obj6 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
        throw obj6;
    }

    public androidx.compose.ui.layout.MeasureResult layout(int width, int height, Map<androidx.compose.ui.layout.AlignmentLine, Integer> alignmentLines, Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, Unit> placementBlock) {
        return this.layout(width, height, alignmentLines, 0, placementBlock);
    }

    public androidx.compose.ui.layout.MeasureResult layout(int width, int height, Map<androidx.compose.ui.layout.AlignmentLine, Integer> alignmentLines, Function1<? super androidx.compose.ui.layout.RulerScope, Unit> rulers, Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, Unit> placementBlock) {
        int i2;
        int i;
        String $i$a$CheckPreconditionLookaheadDelegateKt$checkMeasuredSize$1$iv;
        StringBuilder append;
        String str;
        int i3 = 0;
        i2 = -16777216;
        if (width & i2 == 0 && i2 &= height == 0) {
            i = i2 &= height == 0 ? 1 : 0;
        } else {
        }
        int i7 = 0;
        if (i == 0) {
            int i8 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            InlineClassHelperKt.throwIllegalStateException(stringBuilder.append("Size(").append(width).append(" x ").append(height).append(") is out of range. Each dimension must be between 0 and 16777215.").toString());
        }
        MeasureScope.layout.1 $i$f$checkMeasuredSize = new MeasureScope.layout.1(width, height, alignmentLines, rulers, this, placementBlock);
        return (MeasureResult)$i$f$checkMeasuredSize;
    }
}

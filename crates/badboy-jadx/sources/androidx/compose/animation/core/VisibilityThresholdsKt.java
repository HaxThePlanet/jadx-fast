package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.DpOffset.Companion;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010\u0005\u001a\u0016\u0012\u000c\u0012\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0015\u0010\n\u001a\u00020\u000b*\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000e\"\u0015\u0010\n\u001a\u00020\u0004*\u00020\u000f8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u0010\"\u0015\u0010\n\u001a\u00020\u0011*\u00020\u00128F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u0013\"\u0015\u0010\n\u001a\u00020\u0014*\u00020\u00158F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u0016\"\u0015\u0010\n\u001a\u00020\u0017*\u00020\u00188F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u0019\"\u0015\u0010\n\u001a\u00020\u001a*\u00020\u001b8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u001c\"\u0015\u0010\n\u001a\u00020\u001d*\u00020\u001e8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u001f\"\u0015\u0010\n\u001a\u00020 *\u00020!8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\"¨\u0006#", d2 = {"DpVisibilityThreshold", "", "PxVisibilityThreshold", "rectVisibilityThreshold", "Landroidx/compose/ui/geometry/Rect;", "visibilityThresholdMap", "", "Landroidx/compose/animation/core/TwoWayConverter;", "getVisibilityThresholdMap", "()Ljava/util/Map;", "VisibilityThreshold", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Offset$Companion;", "getVisibilityThreshold", "(Landroidx/compose/ui/geometry/Offset$Companion;)J", "Landroidx/compose/ui/geometry/Rect$Companion;", "(Landroidx/compose/ui/geometry/Rect$Companion;)Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/geometry/Size$Companion;", "(Landroidx/compose/ui/geometry/Size$Companion;)J", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/Dp$Companion;", "(Landroidx/compose/ui/unit/Dp$Companion;)F", "Landroidx/compose/ui/unit/DpOffset;", "Landroidx/compose/ui/unit/DpOffset$Companion;", "(Landroidx/compose/ui/unit/DpOffset$Companion;)J", "Landroidx/compose/ui/unit/IntOffset;", "Landroidx/compose/ui/unit/IntOffset$Companion;", "(Landroidx/compose/ui/unit/IntOffset$Companion;)J", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/IntSize$Companion;", "(Landroidx/compose/ui/unit/IntSize$Companion;)J", "", "Lkotlin/Int$Companion;", "(Lkotlin/jvm/internal/IntCompanionObject;)I", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VisibilityThresholdsKt {

    private static final float DpVisibilityThreshold = 0.1f;
    private static final float PxVisibilityThreshold = 0.5f;
    private static final Rect rectVisibilityThreshold;
    private static final Map<androidx.compose.animation.core.TwoWayConverter<?, ?>, Float> visibilityThresholdMap;
    static {
        int i2 = 1056964608;
        Float valueOf = Float.valueOf(i2);
        Rect rect = new Rect(i2, i2, i2, i2);
        VisibilityThresholdsKt.rectVisibilityThreshold = rect;
        kotlin.Pair[] arr = new Pair[9];
        Float valueOf3 = 1f;
        Float valueOf2 = 0.1f;
        VisibilityThresholdsKt.visibilityThresholdMap = MapsKt.mapOf(TuplesKt.to(VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), valueOf3), TuplesKt.to(VectorConvertersKt.getVectorConverter(IntSize.Companion), valueOf3), TuplesKt.to(VectorConvertersKt.getVectorConverter(IntOffset.Companion), valueOf3), TuplesKt.to(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), 0.01f), TuplesKt.to(VectorConvertersKt.getVectorConverter(Rect.Companion), valueOf), TuplesKt.to(VectorConvertersKt.getVectorConverter(Size.Companion), valueOf), TuplesKt.to(VectorConvertersKt.getVectorConverter(Offset.Companion), valueOf), TuplesKt.to(VectorConvertersKt.getVectorConverter(Dp.Companion), valueOf2), TuplesKt.to(VectorConvertersKt.getVectorConverter(DpOffset.Companion), valueOf2));
    }

    public static final float getVisibilityThreshold(Dp.Companion $this$VisibilityThreshold) {
        final int i2 = 0;
        return Dp.constructor-impl(1036831949);
    }

    public static final int getVisibilityThreshold(IntCompanionObject $this$VisibilityThreshold) {
        return 1;
    }

    public static final long getVisibilityThreshold(Offset.Companion $this$VisibilityThreshold) {
        int i = 1056964608;
        return OffsetKt.Offset(i, i);
    }

    public static final long getVisibilityThreshold(Size.Companion $this$VisibilityThreshold) {
        int i = 1056964608;
        return SizeKt.Size(i, i);
    }

    public static final long getVisibilityThreshold(DpOffset.Companion $this$VisibilityThreshold) {
        return DpKt.DpOffset-YgX7TsA(VisibilityThresholdsKt.getVisibilityThreshold(Dp.Companion), VisibilityThresholdsKt.getVisibilityThreshold(Dp.Companion));
    }

    public static final long getVisibilityThreshold(IntOffset.Companion $this$VisibilityThreshold) {
        int i = 1;
        return IntOffsetKt.IntOffset(i, i);
    }

    public static final long getVisibilityThreshold(IntSize.Companion $this$VisibilityThreshold) {
        int i = 1;
        return IntSizeKt.IntSize(i, i);
    }

    public static final Rect getVisibilityThreshold(Rect.Companion $this$VisibilityThreshold) {
        return VisibilityThresholdsKt.rectVisibilityThreshold;
    }

    public static final Map<androidx.compose.animation.core.TwoWayConverter<?, ?>, Float> getVisibilityThresholdMap() {
        return VisibilityThresholdsKt.visibilityThresholdMap;
    }
}

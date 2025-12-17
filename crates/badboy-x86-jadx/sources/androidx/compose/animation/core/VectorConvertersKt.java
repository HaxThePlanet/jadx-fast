package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.DpOffset.Companion;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0090\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001aJ\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u0002H,0\u0001\"\u0004\u0008\u0000\u0010+\"\u0008\u0008\u0001\u0010,*\u00020-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u0002H+\u0012\u0004\u0012\u0002H,0/2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u0002H,\u0012\u0004\u0012\u0002H+0/\u001a \u00101\u001a\u00020\u00082\u0006\u00102\u001a\u00020\u00082\u0006\u00103\u001a\u00020\u00082\u0006\u00104\u001a\u00020\u0008H\u0000\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"!\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00178F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019\"!\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0001*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u001b\"!\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u001c8F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u001d\"!\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u001e8F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u001f\"!\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020 8F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010!\"!\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\"8F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010#\"!\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00030\u0001*\u00020$8F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010%\"!\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00060\u0001*\u00020&8F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010'\"!\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\u0001*\u00020(8F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010)¨\u00065", d2 = {"DpOffsetToVector", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/DpOffset;", "Landroidx/compose/animation/core/AnimationVector2D;", "DpToVector", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/animation/core/AnimationVector1D;", "FloatToVector", "", "IntOffsetToVector", "Landroidx/compose/ui/unit/IntOffset;", "IntSizeToVector", "Landroidx/compose/ui/unit/IntSize;", "IntToVector", "", "OffsetToVector", "Landroidx/compose/ui/geometry/Offset;", "RectToVector", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/AnimationVector4D;", "SizeToVector", "Landroidx/compose/ui/geometry/Size;", "VectorConverter", "Landroidx/compose/ui/geometry/Offset$Companion;", "getVectorConverter", "(Landroidx/compose/ui/geometry/Offset$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/geometry/Rect$Companion;", "(Landroidx/compose/ui/geometry/Rect$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/geometry/Size$Companion;", "(Landroidx/compose/ui/geometry/Size$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/Dp$Companion;", "(Landroidx/compose/ui/unit/Dp$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/DpOffset$Companion;", "(Landroidx/compose/ui/unit/DpOffset$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/IntOffset$Companion;", "(Landroidx/compose/ui/unit/IntOffset$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/unit/IntSize$Companion;", "(Landroidx/compose/ui/unit/IntSize$Companion;)Landroidx/compose/animation/core/TwoWayConverter;", "Lkotlin/Float$Companion;", "(Lkotlin/jvm/internal/FloatCompanionObject;)Landroidx/compose/animation/core/TwoWayConverter;", "Lkotlin/Int$Companion;", "(Lkotlin/jvm/internal/IntCompanionObject;)Landroidx/compose/animation/core/TwoWayConverter;", "TwoWayConverter", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "convertToVector", "Lkotlin/Function1;", "convertFromVector", "lerp", "start", "stop", "fraction", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VectorConvertersKt {

    private static final androidx.compose.animation.core.TwoWayConverter<DpOffset, androidx.compose.animation.core.AnimationVector2D> DpOffsetToVector;
    private static final androidx.compose.animation.core.TwoWayConverter<Dp, androidx.compose.animation.core.AnimationVector1D> DpToVector;
    private static final androidx.compose.animation.core.TwoWayConverter<Float, androidx.compose.animation.core.AnimationVector1D> FloatToVector;
    private static final androidx.compose.animation.core.TwoWayConverter<IntOffset, androidx.compose.animation.core.AnimationVector2D> IntOffsetToVector;
    private static final androidx.compose.animation.core.TwoWayConverter<IntSize, androidx.compose.animation.core.AnimationVector2D> IntSizeToVector;
    private static final androidx.compose.animation.core.TwoWayConverter<Integer, androidx.compose.animation.core.AnimationVector1D> IntToVector;
    private static final androidx.compose.animation.core.TwoWayConverter<Offset, androidx.compose.animation.core.AnimationVector2D> OffsetToVector;
    private static final androidx.compose.animation.core.TwoWayConverter<Rect, androidx.compose.animation.core.AnimationVector4D> RectToVector;
    private static final androidx.compose.animation.core.TwoWayConverter<Size, androidx.compose.animation.core.AnimationVector2D> SizeToVector;
    static {
        VectorConvertersKt.FloatToVector = VectorConvertersKt.TwoWayConverter((Function1)VectorConvertersKt.FloatToVector.1.INSTANCE, (Function1)VectorConvertersKt.FloatToVector.2.INSTANCE);
        VectorConvertersKt.IntToVector = VectorConvertersKt.TwoWayConverter((Function1)VectorConvertersKt.IntToVector.1.INSTANCE, (Function1)VectorConvertersKt.IntToVector.2.INSTANCE);
        VectorConvertersKt.DpToVector = VectorConvertersKt.TwoWayConverter((Function1)VectorConvertersKt.DpToVector.1.INSTANCE, (Function1)VectorConvertersKt.DpToVector.2.INSTANCE);
        VectorConvertersKt.DpOffsetToVector = VectorConvertersKt.TwoWayConverter((Function1)VectorConvertersKt.DpOffsetToVector.1.INSTANCE, (Function1)VectorConvertersKt.DpOffsetToVector.2.INSTANCE);
        VectorConvertersKt.SizeToVector = VectorConvertersKt.TwoWayConverter((Function1)VectorConvertersKt.SizeToVector.1.INSTANCE, (Function1)VectorConvertersKt.SizeToVector.2.INSTANCE);
        VectorConvertersKt.OffsetToVector = VectorConvertersKt.TwoWayConverter((Function1)VectorConvertersKt.OffsetToVector.1.INSTANCE, (Function1)VectorConvertersKt.OffsetToVector.2.INSTANCE);
        VectorConvertersKt.IntOffsetToVector = VectorConvertersKt.TwoWayConverter((Function1)VectorConvertersKt.IntOffsetToVector.1.INSTANCE, (Function1)VectorConvertersKt.IntOffsetToVector.2.INSTANCE);
        VectorConvertersKt.IntSizeToVector = VectorConvertersKt.TwoWayConverter((Function1)VectorConvertersKt.IntSizeToVector.1.INSTANCE, (Function1)VectorConvertersKt.IntSizeToVector.2.INSTANCE);
        VectorConvertersKt.RectToVector = VectorConvertersKt.TwoWayConverter((Function1)VectorConvertersKt.RectToVector.1.INSTANCE, (Function1)VectorConvertersKt.RectToVector.2.INSTANCE);
    }

    public static final <T, V extends androidx.compose.animation.core.AnimationVector> androidx.compose.animation.core.TwoWayConverter<T, V> TwoWayConverter(Function1<? super T, ? extends V> convertToVector, Function1<? super V, ? extends T> convertFromVector) {
        TwoWayConverterImpl twoWayConverterImpl = new TwoWayConverterImpl(convertToVector, convertFromVector);
        return (TwoWayConverter)twoWayConverterImpl;
    }

    public static final androidx.compose.animation.core.TwoWayConverter<Offset, androidx.compose.animation.core.AnimationVector2D> getVectorConverter(Offset.Companion $this$VectorConverter) {
        return VectorConvertersKt.OffsetToVector;
    }

    public static final androidx.compose.animation.core.TwoWayConverter<Rect, androidx.compose.animation.core.AnimationVector4D> getVectorConverter(Rect.Companion $this$VectorConverter) {
        return VectorConvertersKt.RectToVector;
    }

    public static final androidx.compose.animation.core.TwoWayConverter<Size, androidx.compose.animation.core.AnimationVector2D> getVectorConverter(Size.Companion $this$VectorConverter) {
        return VectorConvertersKt.SizeToVector;
    }

    public static final androidx.compose.animation.core.TwoWayConverter<Dp, androidx.compose.animation.core.AnimationVector1D> getVectorConverter(Dp.Companion $this$VectorConverter) {
        return VectorConvertersKt.DpToVector;
    }

    public static final androidx.compose.animation.core.TwoWayConverter<DpOffset, androidx.compose.animation.core.AnimationVector2D> getVectorConverter(DpOffset.Companion $this$VectorConverter) {
        return VectorConvertersKt.DpOffsetToVector;
    }

    public static final androidx.compose.animation.core.TwoWayConverter<IntOffset, androidx.compose.animation.core.AnimationVector2D> getVectorConverter(IntOffset.Companion $this$VectorConverter) {
        return VectorConvertersKt.IntOffsetToVector;
    }

    public static final androidx.compose.animation.core.TwoWayConverter<IntSize, androidx.compose.animation.core.AnimationVector2D> getVectorConverter(IntSize.Companion $this$VectorConverter) {
        return VectorConvertersKt.IntSizeToVector;
    }

    public static final androidx.compose.animation.core.TwoWayConverter<Float, androidx.compose.animation.core.AnimationVector1D> getVectorConverter(FloatCompanionObject $this$VectorConverter) {
        return VectorConvertersKt.FloatToVector;
    }

    public static final androidx.compose.animation.core.TwoWayConverter<Integer, androidx.compose.animation.core.AnimationVector1D> getVectorConverter(IntCompanionObject $this$VectorConverter) {
        return VectorConvertersKt.IntToVector;
    }

    public static final float lerp(float start, float stop, float fraction) {
        return i3 += i5;
    }
}

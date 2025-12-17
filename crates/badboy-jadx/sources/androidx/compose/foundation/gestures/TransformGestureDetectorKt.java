package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function4;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0002*\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u001a\u000f\u0010\u000b\u001a\u00020\u0002*\u00020\u0006¢\u0006\u0002\u0010\u000c\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0006\u001a~\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00082`\u0010\u0013\u001a\\\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0017\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0018\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0019\u0012\u0013\u0012\u00110\u0001¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u001a\u0012\u0004\u0012\u00020\u00100\u0014H\u0086@¢\u0006\u0002\u0010\u001b\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001c", d2 = {"angle", "", "Landroidx/compose/ui/geometry/Offset;", "angle-k-4lQ0M", "(J)F", "calculateCentroid", "Landroidx/compose/ui/input/pointer/PointerEvent;", "useCurrent", "", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)J", "calculateCentroidSize", "calculatePan", "(Landroidx/compose/ui/input/pointer/PointerEvent;)J", "calculateRotation", "calculateZoom", "detectTransformGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "panZoomLock", "onGesture", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "centroid", "pan", "zoom", "rotation", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TransformGestureDetectorKt {
    private static final float angle-k-4lQ0M(long $this$angle_u2dk_u2d4lQ0M) {
        int cmp;
        int i;
        double i2;
        i = 0;
        final int i6 = 0;
        cmp = Float.compare(x-impl, i) == 0 ? i2 : i6;
        if (cmp != 0) {
            if (Float.compare(y-impl, i) == 0) {
            } else {
                i2 = i6;
            }
            if (i2 != 0) {
            } else {
                i = cmp / i5;
            }
        } else {
        }
        return i;
    }

    public static final long calculateCentroid(PointerEvent $this$calculateCentroid, boolean useCurrent) {
        long centroid;
        int centroidWeight;
        long div-tuRUvjQ;
        int index$iv;
        Object obj2;
        Object obj;
        int i;
        boolean previousPressed;
        int i2 = 0;
        centroid = Offset.Companion.getZero-F1C5BW0();
        centroidWeight = 0;
        List changes = $this$calculateCentroid.getChanges();
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < changes.size()) {
            obj = obj2;
            i = 0;
            if ((PointerInputChange)obj.getPressed() && obj.getPreviousPressed()) {
            }
            index$iv++;
            if (obj.getPreviousPressed()) {
            }
            if (useCurrent) {
            } else {
            }
            previousPressed = obj.getPreviousPosition-F1C5BW0();
            centroid = Offset.plus-MK-Hz9U(centroid, obj1);
            centroidWeight++;
            previousPressed = obj.getPosition-F1C5BW0();
        }
        if (centroidWeight == 0) {
            div-tuRUvjQ = Offset.Companion.getUnspecified-F1C5BW0();
        } else {
            div-tuRUvjQ = Offset.div-tuRUvjQ(centroid, obj1);
        }
        return div-tuRUvjQ;
    }

    public static long calculateCentroid$default(PointerEvent pointerEvent, boolean z2, int i3, Object object4) {
        int obj1;
        final int obj3 = 1;
        if (i3 &= obj3 != 0) {
            obj1 = obj3;
        }
        return TransformGestureDetectorKt.calculateCentroid(pointerEvent, obj1);
    }

    public static final float calculateCentroidSize(PointerEvent $this$calculateCentroidSize, boolean useCurrent) {
        int distanceToCentroid;
        int distanceWeight;
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        boolean previousPressed;
        float distance-impl;
        final long centroid = TransformGestureDetectorKt.calculateCentroid($this$calculateCentroidSize, useCurrent);
        if (Offset.equals-impl0(centroid, obj1)) {
            return 0;
        }
        distanceToCentroid = 0;
        distanceWeight = 0;
        List changes = $this$calculateCentroidSize.getChanges();
        final int i4 = 0;
        index$iv = 0;
        while (index$iv < changes.size()) {
            obj2 = obj;
            i = 0;
            if ((PointerInputChange)obj2.getPressed() && obj2.getPreviousPressed()) {
            }
            index$iv++;
            if (obj2.getPreviousPressed()) {
            }
            if (useCurrent) {
            } else {
            }
            previousPressed = obj2.getPreviousPosition-F1C5BW0();
            distanceToCentroid += distance-impl;
            distanceWeight++;
            previousPressed = obj2.getPosition-F1C5BW0();
        }
        return distanceToCentroid / $this$fastForEach$iv;
    }

    public static float calculateCentroidSize$default(PointerEvent pointerEvent, boolean z2, int i3, Object object4) {
        int obj1;
        final int obj3 = 1;
        if (i3 &= obj3 != 0) {
            obj1 = obj3;
        }
        return TransformGestureDetectorKt.calculateCentroidSize(pointerEvent, obj1);
    }

    public static final long calculatePan(PointerEvent $this$calculatePan) {
        long centroid = TransformGestureDetectorKt.calculateCentroid($this$calculatePan, true);
        if (Offset.equals-impl0(centroid, obj1)) {
            return Offset.Companion.getZero-F1C5BW0();
        }
        return Offset.minus-MK-Hz9U(centroid, obj1);
    }

    public static final float calculateRotation(PointerEvent $this$calculateRotation) {
        PointerEvent minus-MK-Hz9U2;
        int rotation;
        int position-F1C5BW0;
        int i10;
        int sum$iv;
        int index$iv$iv;
        long minus-MK-Hz9U;
        int previousPosition-F1C5BW0;
        int i;
        int i2;
        Object obj;
        int rotationWeight;
        Object obj4;
        int i5;
        Object obj2;
        int index$iv;
        int i12;
        boolean previousPressed2;
        Object obj3;
        int i3;
        int i7;
        boolean previousPressed;
        int i9;
        int rotation2;
        long l2;
        float angle-k-4lQ0M;
        float angle-k-4lQ0M2;
        int i6;
        int i4;
        long l;
        int i8;
        int i11;
        minus-MK-Hz9U2 = $this$calculateRotation;
        int i14 = 0;
        sum$iv = 0;
        List list = changes;
        index$iv$iv = 0;
        final int size = list.size();
        i2 = 1;
        while (index$iv$iv < size) {
            i5 = 0;
            obj2 = obj4;
            i12 = 0;
            if ((PointerInputChange)obj2.getPreviousPressed() && obj2.getPressed()) {
            }
            sum$iv += previousPosition-F1C5BW0;
            index$iv$iv++;
            i2 = 1;
            if (obj2.getPressed()) {
            }
            previousPosition-F1C5BW0 = i2;
        }
        if (sum$iv < 2) {
            return 0;
        }
        minus-MK-Hz9U = TransformGestureDetectorKt.calculateCentroid(minus-MK-Hz9U2, false);
        rotation = 0;
        rotationWeight = 0;
        List changes2 = minus-MK-Hz9U2.getChanges();
        int i16 = 0;
        index$iv = 0;
        while (index$iv < changes2.size()) {
            obj3 = previousPressed2;
            i3 = 0;
            if ((PointerInputChange)obj3.getPressed() && obj3.getPreviousPressed()) {
            } else {
            }
            i9 = position-F1C5BW0;
            i7 = sum$iv;
            l2 = minus-MK-Hz9U;
            rotation = rotation2;
            index$iv++;
            minus-MK-Hz9U2 = $this$calculateRotation;
            sum$iv = i7;
            position-F1C5BW0 = i9;
            minus-MK-Hz9U = l2;
            previousPosition-F1C5BW0 = 0;
            i2 = 1;
            if (obj3.getPreviousPressed()) {
            } else {
            }
            i9 = position-F1C5BW0;
            i7 = sum$iv;
            minus-MK-Hz9U2 = Offset.minus-MK-Hz9U(obj3.getPreviousPosition-F1C5BW0(), i2);
            l2 = minus-MK-Hz9U;
            minus-MK-Hz9U = Offset.minus-MK-Hz9U(obj3.getPosition-F1C5BW0(), sum$iv);
            i6 = angle-k-4lQ0M2 - angle-k-4lQ0M;
            distance-impl /= i21;
            i11 = 1135869952;
            if (Float.compare(i6, i22) > 0) {
            } else {
            }
            if (Float.compare(i6, i23) < 0) {
            } else {
            }
            i8 = i6;
            rotationWeight += i4;
            rotation = rotation2;
            i8 = i6 + i11;
            i8 = i6 - i11;
        }
        int i18 = position-F1C5BW0;
        int i17 = sum$iv;
        long l3 = minus-MK-Hz9U;
        i = Float.compare(rotationWeight, i18) == 0 ? 1 : 0;
        i10 = i != 0 ? i18 : i19 / rotationWeight;
        return i10;
    }

    public static final float calculateZoom(PointerEvent $this$calculateZoom) {
        int i2;
        int cmp;
        int i;
        i2 = 1;
        final float centroidSize = TransformGestureDetectorKt.calculateCentroidSize($this$calculateZoom, i2);
        final int i5 = 0;
        final float centroidSize2 = TransformGestureDetectorKt.calculateCentroidSize($this$calculateZoom, i5);
        cmp = 0;
        i = Float.compare(centroidSize, cmp) == 0 ? i2 : i5;
        if (i == 0) {
            if (Float.compare(centroidSize2, cmp) == 0) {
            } else {
                i2 = i5;
            }
            if (i2 != 0) {
            }
            return centroidSize / centroidSize2;
        }
        return 1065353216;
    }

    public static final Object detectTransformGestures(PointerInputScope $this$detectTransformGestures, boolean panZoomLock, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> onGesture, Continuation<? super Unit> $completion) {
        TransformGestureDetectorKt.detectTransformGestures.2 anon = new TransformGestureDetectorKt.detectTransformGestures.2(panZoomLock, onGesture, 0);
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectTransformGestures, (Function2)anon, $completion);
        if (awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return awaitEachGesture;
        }
        return Unit.INSTANCE;
    }

    public static Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z2, Function4 function43, Continuation continuation4, int i5, Object object6) {
        int obj1;
        if (i5 &= 1 != 0) {
            obj1 = 0;
        }
        return TransformGestureDetectorKt.detectTransformGestures(pointerInputScope, obj1, function43, continuation4);
    }
}

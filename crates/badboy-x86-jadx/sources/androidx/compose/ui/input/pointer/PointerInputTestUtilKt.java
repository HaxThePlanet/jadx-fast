package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0011\n\u0002\u0008\n\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0010\u0008\u0002\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0000\u001aD\u0010\u000b\u001a\u00020\u000c*\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000c0\rj\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015\u001aL\u0010\u0016\u001a\u00020\u000c*\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000c0\rj\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u001aX\u0010\u001a\u001a\u00020\u000c*\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000c0\rj\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0012\u0010\u001b\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u000f0\u001c\"\u00020\u000f2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001e\u001aR\u0010\u001a\u001a\u00020\u000c*\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000c0\rj\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\t2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001f\u001a(\u0010 \u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010!\u001a\u00020\u00062\u0008\u0008\u0002\u0010\"\u001a\u00020\u0006H\u0000\u001a(\u0010#\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u0014\u0010$\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000*<\u0008\u0000\u0010%\"\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000c0\r2\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000c0\r\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006&", d2 = {"down", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "id", "", "durationMillis", "x", "", "y", "historicalData", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "invokeOverAllPasses", "", "Lkotlin/Function3;", "Landroidx/compose/ui/input/pointer/PointerEvent;", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/input/pointer/PointerInputHandler;", "pointerEvent", "size", "invokeOverAllPasses-H0pRuoY", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;J)V", "invokeOverPass", "pointerEventPass", "invokeOverPass-hUlJWOE", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "invokeOverPasses", "pointerEventPasses", "", "invokeOverPasses-hUlJWOE", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;[Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/input/pointer/PointerEvent;Ljava/util/List;J)V", "moveBy", "dx", "dy", "moveTo", "up", "PointerInputHandler", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PointerInputTestUtilKt {
    public static final androidx.compose.ui.input.pointer.PointerInputChange down(long id, long durationMillis, float x, float y, List<androidx.compose.ui.input.pointer.HistoricalChange> historicalData) {
        int i;
        boolean empty;
        final long l2 = OffsetKt.Offset(historicalData, obj25);
        final int i5 = 1;
        final long l = x;
        PointerInputChange pointerInputChange = new PointerInputChange(PointerId.constructor-impl(id), obj2, l, obj4, l2, obj6, i5, 1065353216, x, obj10, OffsetKt.Offset(historicalData, obj25), obj12, 0, 0, 0, 0, obj17, 1536, 0);
        androidx.compose.ui.input.pointer.PointerInputChange pointerInputChange2 = pointerInputChange;
        empty = obj26;
        if ((Collection)empty) {
            if ((Collection)empty.isEmpty()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        if (i == 0) {
            return PointerInputChange.copy-OHpmEuE$default(pointerInputChange2, 0, l, 0, l2, 0, i5, false, 0, obj10, 0, obj12, 0);
        }
        return pointerInputChange2;
    }

    public static androidx.compose.ui.input.pointer.PointerInputChange down$default(long l, long l2, float f3, float f4, List list5, int i6, Object object7) {
        int i;
        int i3;
        int i4;
        int i2;
        int obj9;
        int obj13;
        i = obj14 & 2 != 0 ? obj9 : f3;
        final int obj10 = 0;
        i3 = obj14 & 4 != 0 ? obj10 : list5;
        i4 = obj14 & 8 != 0 ? obj10 : i6;
        i2 = obj14 & 16 != 0 ? obj13 : object7;
        return PointerInputTestUtilKt.down(l, obj1, i, obj3, i3);
    }

    public static final void invokeOverAllPasses-H0pRuoY(Function3<? super androidx.compose.ui.input.pointer.PointerEvent, ? super androidx.compose.ui.input.pointer.PointerEventPass, ? super IntSize, Unit> $this$invokeOverAllPasses_u2dH0pRuoY, androidx.compose.ui.input.pointer.PointerEvent pointerEvent, long size) {
        androidx.compose.ui.input.pointer.PointerEventPass[] arr = new PointerEventPass[3];
        PointerInputTestUtilKt.invokeOverPasses-hUlJWOE($this$invokeOverAllPasses_u2dH0pRuoY, pointerEvent, CollectionsKt.listOf(PointerEventPass.Initial, PointerEventPass.Main, PointerEventPass.Final), size);
    }

    public static void invokeOverAllPasses-H0pRuoY$default(Function3 function3, androidx.compose.ui.input.pointer.PointerEvent pointerEvent2, long l3, int i4, Object object5) {
        long obj2;
        if (object5 &= 2 != 0) {
            obj2 = Integer.MAX_VALUE;
            obj2 = IntSizeKt.IntSize(obj2, obj2);
        }
        PointerInputTestUtilKt.invokeOverAllPasses-H0pRuoY(function3, pointerEvent2, obj2);
    }

    public static final void invokeOverPass-hUlJWOE(Function3<? super androidx.compose.ui.input.pointer.PointerEvent, ? super androidx.compose.ui.input.pointer.PointerEventPass, ? super IntSize, Unit> $this$invokeOverPass_u2dhUlJWOE, androidx.compose.ui.input.pointer.PointerEvent pointerEvent, androidx.compose.ui.input.pointer.PointerEventPass pointerEventPass, long size) {
        PointerInputTestUtilKt.invokeOverPasses-hUlJWOE($this$invokeOverPass_u2dhUlJWOE, pointerEvent, CollectionsKt.listOf(pointerEventPass), size);
    }

    public static void invokeOverPass-hUlJWOE$default(Function3 function3, androidx.compose.ui.input.pointer.PointerEvent pointerEvent2, androidx.compose.ui.input.pointer.PointerEventPass pointerEventPass3, long l4, int i5, Object object6) {
        long obj3;
        if (object6 &= 4 != 0) {
            obj3 = Integer.MAX_VALUE;
            obj3 = IntSizeKt.IntSize(obj3, obj3);
        }
        PointerInputTestUtilKt.invokeOverPass-hUlJWOE(function3, pointerEvent2, pointerEventPass3, obj3);
    }

    public static final void invokeOverPasses-hUlJWOE(Function3<? super androidx.compose.ui.input.pointer.PointerEvent, ? super androidx.compose.ui.input.pointer.PointerEventPass, ? super IntSize, Unit> $this$invokeOverPasses_u2dhUlJWOE, androidx.compose.ui.input.pointer.PointerEvent pointerEvent, List<? extends androidx.compose.ui.input.pointer.PointerEventPass> pointerEventPasses, long size) {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        IntSize box-impl;
        if ((Collection)pointerEvent.getChanges().isEmpty()) {
        } else {
            if ((Collection)pointerEventPasses.isEmpty()) {
            } else {
                Object obj3 = pointerEventPasses;
                int i4 = 0;
                index$iv = 0;
                while (index$iv < obj3.size()) {
                    i = 0;
                    $this$invokeOverPasses_u2dhUlJWOE.invoke(pointerEvent, (PointerEventPass)obj3.get(index$iv), IntSize.box-impl(size));
                    index$iv++;
                }
            }
            int i3 = 0;
            IllegalArgumentException $i$a$RequirePointerInputTestUtilKt$invokeOverPasses$2 = new IllegalArgumentException("invokeOverPasses called with no passes".toString());
            throw $i$a$RequirePointerInputTestUtilKt$invokeOverPasses$2;
        }
        int i2 = 0;
        IllegalArgumentException $i$a$RequirePointerInputTestUtilKt$invokeOverPasses$1 = new IllegalArgumentException("invokeOverPasses called with no changes".toString());
        throw $i$a$RequirePointerInputTestUtilKt$invokeOverPasses$1;
    }

    public static final void invokeOverPasses-hUlJWOE(Function3<? super androidx.compose.ui.input.pointer.PointerEvent, ? super androidx.compose.ui.input.pointer.PointerEventPass, ? super IntSize, Unit> $this$invokeOverPasses_u2dhUlJWOE, androidx.compose.ui.input.pointer.PointerEvent pointerEvent, androidx.compose.ui.input.pointer.PointerEventPass[] pointerEventPasses, long size) {
        PointerInputTestUtilKt.invokeOverPasses-hUlJWOE($this$invokeOverPasses_u2dhUlJWOE, pointerEvent, ArraysKt.toList(pointerEventPasses), size);
    }

    public static void invokeOverPasses-hUlJWOE$default(Function3 function3, androidx.compose.ui.input.pointer.PointerEvent pointerEvent2, List list3, long l4, int i5, Object object6) {
        long obj3;
        if (object6 &= 4 != 0) {
            obj3 = Integer.MAX_VALUE;
            obj3 = IntSizeKt.IntSize(obj3, obj3);
        }
        PointerInputTestUtilKt.invokeOverPasses-hUlJWOE(function3, pointerEvent2, list3, obj3);
    }

    public static void invokeOverPasses-hUlJWOE$default(Function3 function3, androidx.compose.ui.input.pointer.PointerEvent pointerEvent2, androidx.compose.ui.input.pointer.PointerEventPass[] pointerEventPass3Arr3, long l4, int i5, Object object6) {
        long obj3;
        if (object6 &= 4 != 0) {
            obj3 = Integer.MAX_VALUE;
            obj3 = IntSizeKt.IntSize(obj3, obj3);
        }
        PointerInputTestUtilKt.invokeOverPasses-hUlJWOE(function3, pointerEvent2, pointerEventPass3Arr3, obj3);
    }

    public static final androidx.compose.ui.input.pointer.PointerInputChange moveBy(androidx.compose.ui.input.pointer.PointerInputChange $this$moveBy, long durationMillis, float dx, float dy) {
        PointerInputChange pointerInputChange = new PointerInputChange($this$moveBy.getId-J3iCeTQ(), obj2, uptimeMillis += durationMillis, obj4, OffsetKt.Offset(x-impl += dy, y-impl += obj24), obj6, 1, 1065353216, $this$moveBy.getUptimeMillis(), obj10, $this$moveBy.getPosition-F1C5BW0(), obj12, $this$moveBy.getPressed(), 0, 0, 0, obj17, 1536, 0);
        return pointerInputChange;
    }

    public static androidx.compose.ui.input.pointer.PointerInputChange moveBy$default(androidx.compose.ui.input.pointer.PointerInputChange pointerInputChange, long l2, float f3, float f4, int i5, Object object6) {
        int obj4;
        int obj5;
        final int i = 0;
        if (object6 & 2 != 0) {
            obj4 = i;
        }
        if (object6 &= 4 != 0) {
            obj5 = i;
        }
        return PointerInputTestUtilKt.moveBy(pointerInputChange, l2, f3, obj4);
    }

    public static final androidx.compose.ui.input.pointer.PointerInputChange moveTo(androidx.compose.ui.input.pointer.PointerInputChange $this$moveTo, long durationMillis, float x, float y) {
        PointerInputChange pointerInputChange = new PointerInputChange($this$moveTo.getId-J3iCeTQ(), obj2, durationMillis, obj4, OffsetKt.Offset(y, obj24), obj6, 1, 1065353216, $this$moveTo.getUptimeMillis(), obj10, $this$moveTo.getPosition-F1C5BW0(), obj12, $this$moveTo.getPressed(), 0, 0, 0, obj17, 1536, 0);
        return pointerInputChange;
    }

    public static androidx.compose.ui.input.pointer.PointerInputChange moveTo$default(androidx.compose.ui.input.pointer.PointerInputChange pointerInputChange, long l2, float f3, float f4, int i5, Object object6) {
        int obj4;
        int obj5;
        final int i = 0;
        if (object6 & 2 != 0) {
            obj4 = i;
        }
        if (object6 &= 4 != 0) {
            obj5 = i;
        }
        return PointerInputTestUtilKt.moveTo(pointerInputChange, l2, f3, obj4);
    }

    public static final androidx.compose.ui.input.pointer.PointerInputChange up(androidx.compose.ui.input.pointer.PointerInputChange $this$up, long durationMillis) {
        PointerInputChange pointerInputChange = new PointerInputChange($this$up.getId-J3iCeTQ(), obj2, durationMillis, obj4, $this$up.getPosition-F1C5BW0(), obj6, 0, 1065353216, $this$up.getUptimeMillis(), obj10, $this$up.getPosition-F1C5BW0(), obj12, $this$up.getPressed(), 0, 0, 0, obj17, 1536, 0);
        return pointerInputChange;
    }
}

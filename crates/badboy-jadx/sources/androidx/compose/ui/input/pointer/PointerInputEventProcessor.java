package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import java.util.Collection;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J-\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "hitPathTracker", "Landroidx/compose/ui/input/pointer/HitPathTracker;", "hitResult", "Landroidx/compose/ui/node/HitTestResult;", "isProcessing", "", "pointerInputChangeEventProducer", "Landroidx/compose/ui/input/pointer/PointerInputChangeEventProducer;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "clearPreviouslyHitModifierNodes", "", "process", "Landroidx/compose/ui/input/pointer/ProcessResult;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerInputEvent;", "positionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "isInBounds", "process-BIzXfog", "(Landroidx/compose/ui/input/pointer/PointerInputEvent;Landroidx/compose/ui/input/pointer/PositionCalculator;Z)I", "processCancel", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PointerInputEventProcessor {

    public static final int $stable = 8;
    private final androidx.compose.ui.input.pointer.HitPathTracker hitPathTracker;
    private final HitTestResult hitResult;
    private boolean isProcessing;
    private final androidx.compose.ui.input.pointer.PointerInputChangeEventProducer pointerInputChangeEventProducer;
    private final LayoutNode root;
    static {
        final int i = 8;
    }

    public PointerInputEventProcessor(LayoutNode root) {
        super();
        this.root = root;
        HitPathTracker hitPathTracker = new HitPathTracker(this.root.getCoordinates());
        this.hitPathTracker = hitPathTracker;
        PointerInputChangeEventProducer pointerInputChangeEventProducer = new PointerInputChangeEventProducer();
        this.pointerInputChangeEventProducer = pointerInputChangeEventProducer;
        HitTestResult hitTestResult = new HitTestResult();
        this.hitResult = hitTestResult;
    }

    public static int process-BIzXfog$default(androidx.compose.ui.input.pointer.PointerInputEventProcessor pointerInputEventProcessor, androidx.compose.ui.input.pointer.PointerInputEvent pointerInputEvent2, androidx.compose.ui.input.pointer.PositionCalculator positionCalculator3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 1;
        }
        return pointerInputEventProcessor.process-BIzXfog(pointerInputEvent2, positionCalculator3, obj3);
    }

    public final void clearPreviouslyHitModifierNodes() {
        this.hitPathTracker.clearPreviouslyHitModifierNodeCache();
    }

    public final LayoutNode getRoot() {
        return this.root;
    }

    public final int process-BIzXfog(androidx.compose.ui.input.pointer.PointerInputEvent pointerEvent, androidx.compose.ui.input.pointer.PositionCalculator positionCalculator, boolean isInBounds) {
        androidx.compose.ui.input.pointer.PointerInputEvent pointerInputEvent;
        androidx.compose.ui.input.pointer.PositionCalculator positionCalculator2;
        int isHover;
        int i2;
        int i4;
        boolean z;
        Object valueAt2;
        int result;
        boolean i3;
        LayoutNode id-J3iCeTQ;
        long valueAt;
        long positionChangedIgnoreConsumed;
        HitTestResult changedToDownIgnoreConsumed;
        boolean z2;
        int i;
        int i6;
        int i5;
        final Object obj = this;
        final int i9 = 0;
        if (obj.isProcessing) {
            return PointerInputEventProcessorKt.ProcessResult(i9, i9);
        }
        obj.isProcessing = true;
        androidx.compose.ui.input.pointer.InternalPointerEvent produce = obj.pointerInputChangeEventProducer.produce(pointerEvent, positionCalculator);
        isHover = 1;
        i2 = 0;
        while (i2 < produce.getChanges().size()) {
            valueAt2 = produce.getChanges().valueAt(i2);
            i2++;
        }
        i4 = 0;
        while (i4 < produce.getChanges().size()) {
            valueAt2 = produce.getChanges().valueAt(i4);
            if (isHover == 0) {
            } else {
            }
            valueAt = valueAt2.getPosition-F1C5BW0();
            LayoutNode.hitTest-M_7yMNQ$ui_release$default(obj.root, valueAt, positionChangedIgnoreConsumed, obj.hitResult, PointerType.equals-impl0((PointerInputChange)valueAt2.getType-T8wyACA(), PointerType.Companion.getTouch-T8wyACA()), 0, 8);
            if (!(Collection)obj.hitResult.isEmpty()) {
            }
            i4++;
            obj.hitPathTracker.addHitPath-QJqDSyo(valueAt2.getId-J3iCeTQ(), valueAt, (List)obj.hitResult);
            obj.hitResult.clear();
            valueAt = valueAt2.getPosition-F1C5BW0();
            LayoutNode.hitTest-M_7yMNQ$ui_release$default(obj.root, valueAt, positionChangedIgnoreConsumed, obj.hitResult, PointerType.equals-impl0(valueAt2.getType-T8wyACA(), PointerType.Companion.getTouch-T8wyACA()), 0, 8);
            if (PointerEventKt.changedToDownIgnoreConsumed(valueAt2) && !(Collection)obj.hitResult.isEmpty()) {
            }
        }
        try {
            obj.hitPathTracker.removeDetachedPointerInputNodes();
            if (produce.getSuppressMovementConsumption()) {
            } else {
            }
            result = i9;
            result = 0;
            i3 = 0;
        } catch (Throwable th) {
        }
        obj.isProcessing = i9;
        return PointerInputEventProcessorKt.ProcessResult(obj.hitPathTracker.dispatchChanges(produce, isInBounds), result);
    }

    public final void processCancel() {
        boolean hitPathTracker;
        if (!this.isProcessing) {
            this.pointerInputChangeEventProducer.clear();
            this.hitPathTracker.processCancel();
        }
    }
}

package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.input.pointer.PointerType.Companion;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.ViewConfiguration;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref.LongRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002\u001a\u0012\u0010\u000c\u001a\u00020\u0004*\u00020\rH\u0082@¢\u0006\u0002\u0010\u000e\u001a*\u0010\u000f\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0016\u001a*\u0010\u0017\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0016\u001a\u001c\u0010\u0018\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0000\u001a\"\u0010\u001d\u001a\u00020\u0010*\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0080@¢\u0006\u0002\u0010\u001f\u001a\"\u0010 \u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010!\u001a\"\u0010\"\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010!\u001a\"\u0010$\u001a\u00020\u0010*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010!\u001a \u0010%\u001a\u00020\u0019*\u00020\u00192\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00100'H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0005¨\u0006(", d2 = {"STATIC_KEY", "", "isPrecisePointer", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "distanceIsTolerable", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "change1", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "change2", "awaitDown", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelection", "", "observer", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "clicksCounter", "Landroidx/compose/foundation/text/selection/ClicksCounter;", "down", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/selection/ClicksCounter;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelectionBtf2", "selectionGestureInput", "Landroidx/compose/ui/Modifier;", "mouseSelectionObserver", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "selectionGesturePointerInputBtf2", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelection", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelectionFirstPress", "downEvent", "touchSelectionSubsequentPress", "updateSelectionTouchMode", "updateTouchMode", "Lkotlin/Function1;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SelectionGesturesKt {

    private static final int STATIC_KEY = 8675309;
    public static final Object access$awaitDown(AwaitPointerEventScope $receiver, Continuation $completion) {
        return SelectionGesturesKt.awaitDown($receiver, $completion);
    }

    public static final boolean access$distanceIsTolerable(ViewConfiguration viewConfiguration, PointerInputChange change1, PointerInputChange change2) {
        return SelectionGesturesKt.distanceIsTolerable(viewConfiguration, change1, change2);
    }

    public static final Object access$mouseSelection(AwaitPointerEventScope $receiver, androidx.compose.foundation.text.selection.MouseSelectionObserver observer, androidx.compose.foundation.text.selection.ClicksCounter clicksCounter, PointerEvent down, Continuation $completion) {
        return SelectionGesturesKt.mouseSelection($receiver, observer, clicksCounter, down, $completion);
    }

    public static final Object access$mouseSelectionBtf2(AwaitPointerEventScope $receiver, androidx.compose.foundation.text.selection.MouseSelectionObserver observer, androidx.compose.foundation.text.selection.ClicksCounter clicksCounter, PointerEvent down, Continuation $completion) {
        return SelectionGesturesKt.mouseSelectionBtf2($receiver, observer, clicksCounter, down, $completion);
    }

    public static final Object access$touchSelection(AwaitPointerEventScope $receiver, TextDragObserver observer, PointerEvent down, Continuation $completion) {
        return SelectionGesturesKt.touchSelection($receiver, observer, down, $completion);
    }

    public static final Object access$touchSelectionFirstPress(AwaitPointerEventScope $receiver, TextDragObserver observer, PointerEvent downEvent, Continuation $completion) {
        return SelectionGesturesKt.touchSelectionFirstPress($receiver, observer, downEvent, $completion);
    }

    public static final Object access$touchSelectionSubsequentPress(AwaitPointerEventScope $receiver, TextDragObserver observer, PointerEvent downEvent, Continuation $completion) {
        return SelectionGesturesKt.touchSelectionSubsequentPress($receiver, observer, downEvent, $completion);
    }

    private static final Object awaitDown(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerEvent> continuation2) {
        Object obj2;
        Object event;
        boolean $result;
        Object $continuation;
        int i;
        androidx.compose.foundation.text.selection.SelectionGesturesKt.awaitDown.1 anon;
        Object $continuation2;
        int i7;
        Object $this$awaitDown;
        Object obj3;
        Object obj;
        List changes;
        int i4;
        int i2;
        int index$iv$iv;
        int i3;
        Object obj5;
        Object obj4;
        int i5;
        boolean it;
        int i6;
        androidx.compose.foundation.text.selection.SelectionGesturesKt.awaitDown.1 anon2;
        obj2 = continuation2;
        $result = obj2;
        i7 = Integer.MIN_VALUE;
        if (obj2 instanceof SelectionGesturesKt.awaitDown.1 && label2 &= i7 != 0) {
            $result = obj2;
            i7 = Integer.MIN_VALUE;
            if (label2 &= i7 != 0) {
                $result.label = label -= i7;
            } else {
                $result = new SelectionGesturesKt.awaitDown.1(obj2);
            }
        } else {
        }
        event = $result.result;
        final int i8 = 1;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure(event);
                obj3 = awaitPointerEventScope;
                break;
            case 1:
                ResultKt.throwOnFailure(event);
                obj = l$0;
                $this$awaitDown = $continuation2;
                anon = $result;
                $continuation = event;
                changes = (PointerEvent)event.getChanges();
                i4 = 0;
                i2 = 0;
                index$iv$iv = 0;
                i5 = 0;
                i6 = 0;
                i3 = 0;
                index$iv$iv++;
                i3 = i8;
                return event;
                event = $continuation;
                $result = anon;
                $continuation2 = $this$awaitDown;
                obj3 = obj;
                break;
            default:
                IllegalStateException $result2 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw $result2;
        }
        $result.L$0 = obj3;
        $result.label = i8;
        Object awaitPointerEvent = obj3.awaitPointerEvent(PointerEventPass.Main, $result);
        if (awaitPointerEvent != $continuation2) {
            $continuation = event;
            event = awaitPointerEvent;
            obj = obj3;
            $this$awaitDown = $continuation2;
            anon = anon2;
        }
        return $continuation2;
    }

    private static final boolean distanceIsTolerable(ViewConfiguration viewConfiguration, PointerInputChange change1, PointerInputChange change2) {
        int i;
        i = Float.compare(distance-impl, pointerSlop-E8SPZFQ) < 0 ? 1 : 0;
        return i;
    }

    public static final boolean isPrecisePointer(PointerEvent $this$isPrecisePointer) {
        int index$iv$iv;
        int i2;
        Object obj;
        Object obj2;
        int i3;
        boolean it;
        int i;
        int type-T8wyACA;
        int mouse-T8wyACA;
        final int i4 = 0;
        final List list = changes;
        final int i5 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            i3 = 0;
            i = 0;
            index$iv$iv++;
        }
        i2 = 1;
        return i2;
    }

    private static final Object mouseSelection(AwaitPointerEventScope awaitPointerEventScope, androidx.compose.foundation.text.selection.MouseSelectionObserver mouseSelectionObserver2, androidx.compose.foundation.text.selection.ClicksCounter clicksCounter3, PointerEvent pointerEvent4, Continuation<? super Unit> continuation5) {
        boolean anon;
        int i3;
        Object cOROUTINE_SUSPENDED;
        int i;
        Object label;
        boolean shiftPressed;
        int changedToUp;
        int i2;
        androidx.compose.foundation.text.selection.MouseSelectionObserver mouseSelectionObserver;
        Object obj7;
        Object obj8;
        boolean obj9;
        PointerEvent obj10;
        Object obj11;
        anon = continuation5;
        i = Integer.MIN_VALUE;
        if (continuation5 instanceof SelectionGesturesKt.mouseSelection.1 && label2 &= i != 0) {
            anon = continuation5;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon.label = obj11 -= i;
            } else {
                anon = new SelectionGesturesKt.mouseSelection.1(continuation5);
            }
        } else {
        }
        obj11 = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj11);
                clicksCounter3.update(pointerEvent4);
                label = pointerEvent4.getChanges().get(0);
                shiftPressed = new SelectionGesturesKt.mouseSelection.shouldConsumeUp.1(mouseSelectionObserver2);
                anon.L$0 = awaitPointerEventScope;
                anon.L$1 = mouseSelectionObserver2;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj8 = awaitPointerEventScope;
                obj7 = mouseSelectionObserver;
                obj9 = SelectionAdjustment.Companion.getParagraph();
                obj9 = SelectionAdjustment.Companion.getWord();
                obj9 = SelectionAdjustment.Companion.getNone();
                obj10 = new SelectionGesturesKt.mouseSelection.shouldConsumeUp.2(mouseSelectionObserver2, obj9);
                anon.L$0 = awaitPointerEventScope;
                anon.L$1 = mouseSelectionObserver2;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                obj8 = awaitPointerEventScope;
                obj7 = mouseSelectionObserver;
                obj8 = obj8.getCurrentEvent().getChanges();
                obj9 = 0;
                obj10 = 0;
                label = obj8.get(obj10);
                shiftPressed = null;
                label.consume();
                obj10++;
                obj7.onDragDone();
                return Unit.INSTANCE;
            case 1:
                obj7 = anon.L$1;
                obj8 = anon.L$0;
                ResultKt.throwOnFailure(obj11);
                obj9 = obj11;
                break;
            case 2:
                obj7 = anon.L$1;
                obj8 = anon.L$0;
                ResultKt.throwOnFailure(obj11);
                obj9 = obj11;
                obj8 = obj8.getCurrentEvent().getChanges();
                obj9 = 0;
                obj10 = 0;
                label = obj8.get(obj10);
                shiftPressed = null;
                label.consume();
                obj10++;
                obj7.onDragDone();
                return Unit.INSTANCE;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        if ((Boolean)obj9.booleanValue()) {
            obj8 = obj8.getCurrentEvent().getChanges();
            obj9 = 0;
            obj10 = 0;
            while (obj10 < obj8.size()) {
                label = obj8.get(obj10);
                shiftPressed = null;
                if (PointerEventKt.changedToUp((PointerInputChange)label) != 0) {
                }
                obj10++;
                label.consume();
            }
        }
        obj7.onDragDone();
    }

    private static final Object mouseSelectionBtf2(AwaitPointerEventScope awaitPointerEventScope, androidx.compose.foundation.text.selection.MouseSelectionObserver mouseSelectionObserver2, androidx.compose.foundation.text.selection.ClicksCounter clicksCounter3, PointerEvent pointerEvent4, Continuation<? super Unit> continuation5) {
        boolean anon;
        int i2;
        Object cOROUTINE_SUSPENDED;
        int i3;
        int item$iv;
        androidx.compose.foundation.text.selection.SelectionGesturesKt.mouseSelectionBtf2.shouldConsumeUp.1 shiftPressed;
        int changedToUp;
        int i;
        Throwable th;
        Object obj7;
        Object obj8;
        Object obj9;
        PointerEvent obj10;
        Object obj11;
        anon = continuation5;
        i3 = Integer.MIN_VALUE;
        if (continuation5 instanceof SelectionGesturesKt.mouseSelectionBtf2.1 && label &= i3 != 0) {
            anon = continuation5;
            i3 = Integer.MIN_VALUE;
            if (label &= i3 != 0) {
                anon.label = obj11 -= i3;
            } else {
                anon = new SelectionGesturesKt.mouseSelectionBtf2.1(continuation5);
            }
        } else {
        }
        obj11 = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (item$iv) {
            case 0:
                ResultKt.throwOnFailure(obj11);
                item$iv = pointerEvent4.getChanges().get(0);
                item$iv.consume();
                shiftPressed = new SelectionGesturesKt.mouseSelectionBtf2.shouldConsumeUp.1(mouseSelectionObserver2);
                anon.L$0 = awaitPointerEventScope;
                anon.L$1 = mouseSelectionObserver2;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                obj8 = awaitPointerEventScope;
                obj7 = th;
                obj9 = SelectionAdjustment.Companion.getParagraph();
                obj9 = SelectionAdjustment.Companion.getWord();
                obj9 = SelectionAdjustment.Companion.getNone();
                item$iv.consume();
                obj10 = new SelectionGesturesKt.mouseSelectionBtf2.shouldConsumeUp.2(mouseSelectionObserver2, obj9);
                anon.L$0 = awaitPointerEventScope;
                anon.L$1 = mouseSelectionObserver2;
                anon.label = 2;
                return cOROUTINE_SUSPENDED;
                obj8 = awaitPointerEventScope;
                obj7 = th;
                obj9 = obj8.getCurrentEvent().getChanges();
                obj8 = 0;
                obj10 = 0;
                shiftPressed = obj2;
                item$iv = 0;
                shiftPressed.consume();
                obj10++;
                obj7.onDragDone();
                return Unit.INSTANCE;
            case 1:
                obj7 = anon.L$1;
                obj8 = anon.L$0;
                ResultKt.throwOnFailure(obj11);
                obj9 = obj11;
                break;
            case 2:
                obj7 = anon.L$1;
                obj8 = anon.L$0;
                ResultKt.throwOnFailure(obj11);
                obj10 = obj11;
                obj9 = obj8.getCurrentEvent().getChanges();
                obj8 = 0;
                obj10 = 0;
                shiftPressed = obj2;
                item$iv = 0;
                shiftPressed.consume();
                obj10++;
                obj7.onDragDone();
                return Unit.INSTANCE;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        if ((Boolean)obj9.booleanValue()) {
            obj9 = obj8.getCurrentEvent().getChanges();
            obj8 = 0;
            obj10 = 0;
            while (obj10 < obj9.size()) {
                shiftPressed = obj;
                item$iv = 0;
                if (PointerEventKt.changedToUp((PointerInputChange)shiftPressed) != 0) {
                }
                obj10++;
                shiftPressed.consume();
            }
        }
        obj7.onDragDone();
    }

    public static final Modifier selectionGestureInput(Modifier $this$selectionGestureInput, androidx.compose.foundation.text.selection.MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver) {
        SelectionGesturesKt.selectionGestureInput.1 anon = new SelectionGesturesKt.selectionGestureInput.1(mouseSelectionObserver, textDragObserver, 0);
        return SuspendingPointerInputFilterKt.pointerInput($this$selectionGestureInput, mouseSelectionObserver, textDragObserver, (Function2)anon);
    }

    public static final Object selectionGesturePointerInputBtf2(PointerInputScope $this$selectionGesturePointerInputBtf2, androidx.compose.foundation.text.selection.MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super Unit> $completion) {
        ClicksCounter clicksCounter = new ClicksCounter($this$selectionGesturePointerInputBtf2.getViewConfiguration());
        SelectionGesturesKt.selectionGesturePointerInputBtf2.2 anon = new SelectionGesturesKt.selectionGesturePointerInputBtf2.2(clicksCounter, mouseSelectionObserver, textDragObserver, 0);
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$selectionGesturePointerInputBtf2, (Function2)anon, $completion);
        if (awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return awaitEachGesture;
        }
        return Unit.INSTANCE;
    }

    private static final Object touchSelection(AwaitPointerEventScope awaitPointerEventScope, TextDragObserver textDragObserver2, PointerEvent pointerEvent3, Continuation<? super Unit> continuation4) {
        boolean anon;
        int i2;
        Object index$iv;
        int i;
        Object firstDown;
        long item$iv;
        long l;
        int changedToUp;
        Object obj;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        anon = continuation4;
        i = Integer.MIN_VALUE;
        if (continuation4 instanceof SelectionGesturesKt.touchSelection.1 && label &= i != 0) {
            anon = continuation4;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj10 -= i;
            } else {
                anon = new SelectionGesturesKt.touchSelection.1(continuation4);
            }
        } else {
        }
        obj10 = anon.result;
        index$iv = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (firstDown) {
            case 0:
                ResultKt.throwOnFailure(obj10);
                Object first = CollectionsKt.first(pointerEvent3.getChanges());
                anon.L$0 = awaitPointerEventScope;
                anon.L$1 = textDragObserver2;
                anon.L$2 = first;
                anon.label = 1;
                obj9 = DragGestureDetectorKt.awaitLongPressOrCancellation-rnUCldI(awaitPointerEventScope, (PointerInputChange)first.getId-J3iCeTQ(), obj4);
                return index$iv;
                obj9 = awaitPointerEventScope;
                obj7 = first;
                firstDown = obj;
                break;
            case 1:
                obj7 = anon.L$2;
                obj8 = anon.L$1;
                obj9 = anon.L$0;
                ResultKt.throwOnFailure(obj10);
                firstDown = obj10;
                break;
            case 2:
                ResultKt.throwOnFailure(obj10);
                obj9 = obj8;
                obj8 = obj7;
                obj7 = obj10;
                obj7 = obj9.getCurrentEvent().getChanges();
                obj9 = 0;
                index$iv = 0;
                l = obj2;
                item$iv = 0L;
                l.consume();
                index$iv++;
                obj8.onStop();
                obj8.onCancel();
                return Unit.INSTANCE;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        obj8.onStart-k-4lQ0M(firstDown.getPosition-F1C5BW0());
        obj7 = new SelectionGesturesKt.touchSelection.2(obj8);
        anon.L$0 = obj9;
        anon.L$1 = obj8;
        anon.L$2 = 0;
        anon.label = 2;
        if (firstDown != null && SelectionGesturesKt.distanceIsTolerable(obj9.getViewConfiguration(), obj7, (PointerInputChange)firstDown) && DragGestureDetectorKt.drag-jO51t88(obj9, firstDown.getId-J3iCeTQ(), obj4, (Function1)obj7) == index$iv) {
            if (SelectionGesturesKt.distanceIsTolerable(obj9.getViewConfiguration(), obj7, firstDown)) {
                obj8.onStart-k-4lQ0M(firstDown.getPosition-F1C5BW0());
                obj7 = new SelectionGesturesKt.touchSelection.2(obj8);
                anon.L$0 = obj9;
                anon.L$1 = obj8;
                anon.L$2 = 0;
                anon.label = 2;
                if (DragGestureDetectorKt.drag-jO51t88(obj9, firstDown.getId-J3iCeTQ(), obj4, (Function1)obj7) == index$iv) {
                    return index$iv;
                }
            }
        }
    }

    private static final Object touchSelectionFirstPress(AwaitPointerEventScope awaitPointerEventScope, TextDragObserver textDragObserver2, PointerEvent pointerEvent3, Continuation<? super Unit> continuation4) {
        boolean anon;
        int i2;
        Object index$iv;
        int i;
        Object firstDown;
        long item$iv;
        long l;
        int changedToUp;
        Object obj;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        anon = continuation4;
        i = Integer.MIN_VALUE;
        if (continuation4 instanceof SelectionGesturesKt.touchSelectionFirstPress.1 && label &= i != 0) {
            anon = continuation4;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj10 -= i;
            } else {
                anon = new SelectionGesturesKt.touchSelectionFirstPress.1(continuation4);
            }
        } else {
        }
        obj10 = anon.result;
        index$iv = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (firstDown) {
            case 0:
                ResultKt.throwOnFailure(obj10);
                Object first = CollectionsKt.first(pointerEvent3.getChanges());
                anon.L$0 = awaitPointerEventScope;
                anon.L$1 = textDragObserver2;
                anon.L$2 = first;
                anon.label = 1;
                obj9 = DragGestureDetectorKt.awaitLongPressOrCancellation-rnUCldI(awaitPointerEventScope, (PointerInputChange)first.getId-J3iCeTQ(), obj4);
                return index$iv;
                obj9 = awaitPointerEventScope;
                obj7 = first;
                firstDown = obj;
                break;
            case 1:
                obj7 = anon.L$2;
                obj8 = anon.L$1;
                obj9 = anon.L$0;
                ResultKt.throwOnFailure(obj10);
                firstDown = obj10;
                break;
            case 2:
                ResultKt.throwOnFailure(obj10);
                obj9 = obj8;
                obj8 = obj7;
                obj7 = obj10;
                obj7 = obj9.getCurrentEvent().getChanges();
                obj9 = 0;
                index$iv = 0;
                l = obj2;
                item$iv = 0L;
                l.consume();
                index$iv++;
                obj8.onStop();
                obj8.onCancel();
                return Unit.INSTANCE;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        obj8.onStart-k-4lQ0M(firstDown.getPosition-F1C5BW0());
        obj7 = new SelectionGesturesKt.touchSelectionFirstPress.dragCompletedWithUp.1(obj8);
        anon.L$0 = obj9;
        anon.L$1 = obj8;
        anon.L$2 = 0;
        anon.label = 2;
        if (firstDown != null && SelectionGesturesKt.distanceIsTolerable(obj9.getViewConfiguration(), obj7, (PointerInputChange)firstDown) && DragGestureDetectorKt.drag-jO51t88(obj9, firstDown.getId-J3iCeTQ(), obj4, (Function1)obj7) == index$iv) {
            if (SelectionGesturesKt.distanceIsTolerable(obj9.getViewConfiguration(), obj7, firstDown)) {
                obj8.onStart-k-4lQ0M(firstDown.getPosition-F1C5BW0());
                obj7 = new SelectionGesturesKt.touchSelectionFirstPress.dragCompletedWithUp.1(obj8);
                anon.L$0 = obj9;
                anon.L$1 = obj8;
                anon.L$2 = 0;
                anon.label = 2;
                if (DragGestureDetectorKt.drag-jO51t88(obj9, firstDown.getId-J3iCeTQ(), obj4, (Function1)obj7) == index$iv) {
                    return index$iv;
                }
            }
        }
    }

    private static final Object touchSelectionSubsequentPress(AwaitPointerEventScope awaitPointerEventScope, TextDragObserver textDragObserver2, PointerEvent pointerEvent3, Continuation<? super Unit> continuation4) {
        boolean anon2;
        int i3;
        int index$iv;
        int i2;
        int label;
        Object first;
        int item$iv;
        long observer;
        Object changedToUp;
        Object downResolution;
        kotlin.jvm.functions.Function2 position-F1C5BW0;
        androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelectionSubsequentPress.downResolution.1 anon;
        int i;
        Throwable th;
        Object obj12;
        Object obj13;
        Object obj14;
        Object obj15;
        anon2 = continuation4;
        i2 = Integer.MIN_VALUE;
        if (continuation4 instanceof SelectionGesturesKt.touchSelectionSubsequentPress.1 && label2 &= i2 != 0) {
            anon2 = continuation4;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon2.label = obj15 -= i2;
            } else {
                anon2 = new SelectionGesturesKt.touchSelectionSubsequentPress.1(continuation4);
            }
        } else {
        }
        obj15 = anon2.result;
        index$iv = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        item$iv = 0;
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj15);
                first = CollectionsKt.first(pointerEvent3.getChanges());
                observer = (PointerInputChange)first.getId-J3iCeTQ();
                obj14 = new Ref.LongRef();
                obj14.element = Offset.Companion.getUnspecified-F1C5BW0();
                anon = new SelectionGesturesKt.touchSelectionSubsequentPress.downResolution.1(observer, obj5, obj14, item$iv);
                anon2.L$0 = awaitPointerEventScope;
                anon2.L$1 = textDragObserver2;
                anon2.L$2 = first;
                anon2.L$3 = obj14;
                anon2.J$0 = observer;
                anon2.label = 1;
                return index$iv;
                obj13 = awaitPointerEventScope;
                obj12 = th;
                break;
            case 1:
                obj14 = anon2.L$3;
                first = anon2.L$2;
                ResultKt.throwOnFailure(obj15);
                downResolution = obj15;
                obj12 = l$1;
                obj13 = changedToUp;
                observer = th;
                break;
            case 2:
                obj12 = anon2.L$1;
                obj13 = anon2.L$0;
                ResultKt.throwOnFailure(obj15);
                obj14 = obj15;
                obj14 = obj13.getCurrentEvent().getChanges();
                obj13 = 0;
                index$iv = 0;
                observer = obj;
                item$iv = 0;
                observer.consume();
                index$iv++;
                obj12.onStop();
                obj12.onCancel();
                return Unit.INSTANCE;
            default:
                obj12 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj12;
        }
        if ((DownResolution)downResolution == null) {
            downResolution = DownResolution.Timeout;
        }
        if (downResolution == DownResolution.Cancel) {
            return Unit.INSTANCE;
        }
        position-F1C5BW0 = first.getPosition-F1C5BW0();
        obj12.onStart-k-4lQ0M(position-F1C5BW0);
        if (downResolution == DownResolution.Up) {
            obj12.onStop();
            return Unit.INSTANCE;
        }
        if (downResolution == DownResolution.Drag) {
            obj12.onDrag-k-4lQ0M(obj14.element);
        }
        obj14 = new SelectionGesturesKt.touchSelectionSubsequentPress.dragCompletedWithUp.1(obj12);
        anon2.L$0 = obj13;
        anon2.L$1 = obj12;
        anon2.L$2 = item$iv;
        anon2.L$3 = item$iv;
        anon2.label = 2;
        if (DragGestureDetectorKt.drag-jO51t88(obj13, observer, changedToUp, (Function1)obj14) == index$iv) {
            return index$iv;
        }
    }

    public static final Modifier updateSelectionTouchMode(Modifier $this$updateSelectionTouchMode, Function1<? super Boolean, Unit> updateTouchMode) {
        SelectionGesturesKt.updateSelectionTouchMode.1 anon = new SelectionGesturesKt.updateSelectionTouchMode.1(updateTouchMode, 0);
        return SuspendingPointerInputFilterKt.pointerInput($this$updateSelectionTouchMode, 8675309, (Function2)anon);
    }
}

package androidx.compose.foundation.text.selection;

import androidx.collection.LongIntMapKt;
import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongIntMap;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType.Companion;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedString.Builder;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010r\u001a\u00020O2\u0006\u0010s\u001a\u00020\u0018ø\u0001\u0000¢\u0006\u0004\u0008t\u0010$J\"\u0010u\u001a\u00020\u00182\u0006\u0010v\u001a\u00020\u00112\u0006\u0010w\u001a\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\u0008x\u0010yJ\r\u0010z\u001a\u00020OH\u0000¢\u0006\u0002\u0008{J\u0018\u0010|\u001a\u0004\u0018\u00010}2\u0006\u0010~\u001a\u00020\u007fH\u0000¢\u0006\u0003\u0008\u0080\u0001J\u000c\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001H\u0002J\u0012\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001H\u0000¢\u0006\u0003\u0008\u0085\u0001J/\u0010\u0086\u0001\u001a\u00020W2\u0006\u0010s\u001a\u00020\u00182\u0007\u0010\u0087\u0001\u001a\u00020\u00182\u0007\u0010\u0088\u0001\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0006\u0008\u0089\u0001\u0010\u008a\u0001J\u0011\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0007\u0010\u0088\u0001\u001a\u00020\u0007J\u000f\u0010\u008d\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\u0008\u008e\u0001J\u000f\u0010\u008f\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\u0008\u0090\u0001J\u000f\u0010\u0091\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\u0008\u0092\u0001J\u0007\u0010\u0093\u0001\u001a\u00020OJ\u000f\u0010\u0094\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\u0008\u0095\u0001J\u000f\u0010\u0096\u0001\u001a\u00020OH\u0000¢\u0006\u0003\u0008\u0097\u0001J:\u0010\u0098\u0001\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\t0\u009a\u00010\u0099\u00012\u0008\u0010\u009b\u0001\u001a\u00030\u009c\u00012\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0003\u0008\u009e\u0001J\u001b\u0010\u009f\u0001\u001a\u00020O2\u0007\u0010 \u0001\u001a\u00020W2\u0007\u0010¡\u0001\u001a\u00020\tH\u0002J\u000f\u0010¢\u0001\u001a\u00020\u0007H\u0001¢\u0006\u0003\u0008£\u0001J0\u0010¤\u0001\u001a\u00020O2\u0006\u0010s\u001a\u00020\u00182\u0007\u0010\u0088\u0001\u001a\u00020\u00072\u0008\u0010¥\u0001\u001a\u00030¦\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\u0008§\u0001\u0010¨\u0001J\t\u0010©\u0001\u001a\u00020OH\u0002J\t\u0010ª\u0001\u001a\u00020OH\u0002J9\u0010«\u0001\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u00182\u0007\u0010\u0087\u0001\u001a\u00020\u00182\u0007\u0010\u0088\u0001\u001a\u00020\u00072\u0008\u0010¥\u0001\u001a\u00030¦\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\u0008¬\u0001\u0010­\u0001J;\u0010«\u0001\u001a\u00020\u00072\t\u0010®\u0001\u001a\u0004\u0018\u00010\u00182\u0006\u0010U\u001a\u00020\u00182\u0007\u0010\u0088\u0001\u001a\u00020\u00072\u0008\u0010¥\u0001\u001a\u00030¦\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\u0008¯\u0001\u0010°\u0001J\t\u0010±\u0001\u001a\u00020OH\u0002J*\u0010²\u0001\u001a\u00020O*\u00030³\u00012\u0013\u0010´\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020O0NH\u0082@¢\u0006\u0003\u0010µ\u0001J\u001d\u0010¶\u0001\u001a\u00020J*\u00020J2\u000e\u0010·\u0001\u001a\t\u0012\u0004\u0012\u00020O0¸\u0001H\u0002R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0008\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR(\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R5\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00188F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008\u001e\u0010\u001f\u001a\u0004\u0008\u001a\u0010\u001b\"\u0004\u0008\u001c\u0010\u001dR1\u0010 \u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188@@BX\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008%\u0010\u001f\u001a\u0004\u0008!\u0010\"\"\u0004\u0008#\u0010$R1\u0010&\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188@@BX\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008)\u0010\u001f\u001a\u0004\u0008'\u0010\"\"\u0004\u0008(\u0010$R/\u0010+\u001a\u0004\u0018\u00010*2\u0008\u0010\u0017\u001a\u0004\u0018\u00010*8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u00080\u0010\u001f\u001a\u0004\u0008,\u0010-\"\u0004\u0008.\u0010/R5\u00101\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00188F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u00084\u0010\u001f\u001a\u0004\u00082\u0010\u001b\"\u0004\u00083\u0010\u001dR\u001a\u00105\u001a\u000206X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00087\u00108\"\u0004\u00089\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008=\u0010>\"\u0004\u0008?\u0010@R+\u0010A\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008F\u0010\u001f\u001a\u0004\u0008B\u0010C\"\u0004\u0008D\u0010ER$\u0010G\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008G\u0010C\"\u0004\u0008H\u0010ER\u0011\u0010I\u001a\u00020J8F¢\u0006\u0006\u001a\u0004\u0008K\u0010LR@\u0010P\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020O0N2\u0014\u0010M\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020O0N@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Q\u0010R\"\u0004\u0008S\u0010TR\u0016\u0010U\u001a\u0004\u0018\u00010\u0018X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R&\u0010V\u001a\u0004\u0018\u00010W8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008X\u0010Y\u001a\u0004\u0008Z\u0010[\"\u0004\u0008\\\u0010]R(\u0010^\u001a\u0004\u0018\u00010\t2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008_\u0010`\"\u0004\u0008a\u0010bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010c\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008d\u0010CR$\u0010e\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008f\u0010C\"\u0004\u0008g\u0010ER5\u0010h\u001a\u0004\u0018\u00010\u00182\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00188F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008k\u0010\u001f\u001a\u0004\u0008i\u0010\u001b\"\u0004\u0008j\u0010\u001dR\u001c\u0010l\u001a\u0004\u0018\u00010mX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008n\u0010o\"\u0004\u0008p\u0010q\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006¹\u0001", d2 = {"Landroidx/compose/foundation/text/selection/SelectionManager;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "(Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;)V", "_isInTouchMode", "Landroidx/compose/runtime/MutableState;", "", "_selection", "Landroidx/compose/foundation/text/selection/Selection;", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "value", "Landroidx/compose/ui/layout/LayoutCoordinates;", "containerLayoutCoordinates", "getContainerLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setContainerLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "Landroidx/compose/runtime/MutableState;", "dragBeginPosition", "getDragBeginPosition-F1C5BW0$foundation_release", "()J", "setDragBeginPosition-k-4lQ0M", "(J)V", "dragBeginPosition$delegate", "dragTotalDistance", "getDragTotalDistance-F1C5BW0$foundation_release", "setDragTotalDistance-k-4lQ0M", "dragTotalDistance$delegate", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "endHandlePosition", "getEndHandlePosition-_m7T9-E", "setEndHandlePosition-_kEHs6E", "endHandlePosition$delegate", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "isInTouchMode", "setInTouchMode", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "newOnSelectionChange", "Lkotlin/Function1;", "", "onSelectionChange", "getOnSelectionChange", "()Lkotlin/jvm/functions/Function1;", "setOnSelectionChange", "(Lkotlin/jvm/functions/Function1;)V", "previousPosition", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "getPreviousSelectionLayout$foundation_release$annotations", "()V", "getPreviousSelectionLayout$foundation_release", "()Landroidx/compose/foundation/text/selection/SelectionLayout;", "setPreviousSelectionLayout$foundation_release", "(Landroidx/compose/foundation/text/selection/SelectionLayout;)V", "selection", "getSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "setSelection", "(Landroidx/compose/foundation/text/selection/Selection;)V", "shouldShowMagnifier", "getShouldShowMagnifier", "showToolbar", "getShowToolbar$foundation_release", "setShowToolbar$foundation_release", "startHandlePosition", "getStartHandlePosition-_m7T9-E", "setStartHandlePosition-_kEHs6E", "startHandlePosition$delegate", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "contextMenuOpenAdjustment", "position", "contextMenuOpenAdjustment-k-4lQ0M", "convertToContainerCoordinates", "layoutCoordinates", "offset", "convertToContainerCoordinates-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "copy", "copy$foundation_release", "getAnchorSelectable", "Landroidx/compose/foundation/text/selection/Selectable;", "anchor", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getAnchorSelectable$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getSelectedText", "Landroidx/compose/ui/text/AnnotatedString;", "getSelectedText$foundation_release", "getSelectionLayout", "previousHandlePosition", "isStartHandle", "getSelectionLayout-Wko1d7g", "(JJZ)Landroidx/compose/foundation/text/selection/SelectionLayout;", "handleDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "isEntireContainerSelected", "isEntireContainerSelected$foundation_release", "isNonEmptySelection", "isNonEmptySelection$foundation_release", "isTriviallyCollapsedSelection", "isTriviallyCollapsedSelection$foundation_release", "onRelease", "requireContainerCoordinates", "requireContainerCoordinates$foundation_release", "selectAll", "selectAll$foundation_release", "selectAllInSelectable", "Lkotlin/Pair;", "Landroidx/collection/LongObjectMap;", "selectableId", "", "previousSelection", "selectAllInSelectable$foundation_release", "selectionChanged", "selectionLayout", "newSelection", "shouldPerformHaptics", "shouldPerformHaptics$foundation_release", "startSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "startSelection-9KIMszo", "(JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)V", "toolbarCopy", "updateHandleOffsets", "updateSelection", "updateSelection-jyLRC_s$foundation_release", "(JJZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "newPosition", "updateSelection-qNKwrvQ$foundation_release", "(Landroidx/compose/ui/geometry/Offset;JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "updateSelectionToolbar", "detectNonConsumingTap", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClearSelectionRequested", "block", "Lkotlin/Function0;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelectionManager {

    public static final int $stable = 8;
    private final MutableState<Boolean> _isInTouchMode;
    private final MutableState<androidx.compose.foundation.text.selection.Selection> _selection;
    private ClipboardManager clipboardManager;
    private LayoutCoordinates containerLayoutCoordinates;
    private final MutableState currentDragPosition$delegate;
    private final MutableState dragBeginPosition$delegate;
    private final MutableState dragTotalDistance$delegate;
    private final MutableState draggingHandle$delegate;
    private final MutableState endHandlePosition$delegate;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final MutableState hasFocus$delegate;
    private Function1<? super androidx.compose.foundation.text.selection.Selection, Unit> onSelectionChange;
    private Offset previousPosition;
    private androidx.compose.foundation.text.selection.SelectionLayout previousSelectionLayout;
    private final androidx.compose.foundation.text.selection.SelectionRegistrarImpl selectionRegistrar;
    private boolean showToolbar;
    private final MutableState startHandlePosition$delegate;
    private TextToolbar textToolbar;
    static {
        final int i = 8;
    }

    public SelectionManager(androidx.compose.foundation.text.selection.SelectionRegistrarImpl selectionRegistrar) {
        super();
        this.selectionRegistrar = selectionRegistrar;
        int i = 0;
        int i2 = 2;
        this._selection = SnapshotStateKt.mutableStateOf$default(i, i, i2, i);
        this._isInTouchMode = SnapshotStateKt.mutableStateOf$default(true, i, i2, i);
        SelectionManager.onSelectionChange.1 anon8 = new SelectionManager.onSelectionChange.1(this);
        this.onSelectionChange = (Function1)anon8;
        FocusRequester focusRequester = new FocusRequester();
        this.focusRequester = focusRequester;
        this.hasFocus$delegate = SnapshotStateKt.mutableStateOf$default(false, i, i2, i);
        this.dragBeginPosition$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), i, i2, i);
        this.dragTotalDistance$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), i, i2, i);
        this.startHandlePosition$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i2, i);
        this.endHandlePosition$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i2, i);
        this.draggingHandle$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i2, i);
        this.currentDragPosition$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i2, i);
        SelectionManager.1 anon = new SelectionManager.1(this);
        this.selectionRegistrar.setOnPositionChangeCallback$foundation_release((Function1)anon);
        SelectionManager.2 anon2 = new SelectionManager.2(this);
        this.selectionRegistrar.setOnSelectionUpdateStartCallback$foundation_release((Function4)anon2);
        SelectionManager.3 anon3 = new SelectionManager.3(this);
        this.selectionRegistrar.setOnSelectionUpdateSelectAll$foundation_release((Function2)anon3);
        SelectionManager.4 anon4 = new SelectionManager.4(this);
        this.selectionRegistrar.setOnSelectionUpdateCallback$foundation_release((Function6)anon4);
        SelectionManager.5 anon5 = new SelectionManager.5(this);
        this.selectionRegistrar.setOnSelectionUpdateEndCallback$foundation_release((Function0)anon5);
        SelectionManager.6 anon6 = new SelectionManager.6(this);
        this.selectionRegistrar.setOnSelectableChangeCallback$foundation_release((Function1)anon6);
        SelectionManager.7 anon7 = new SelectionManager.7(this);
        this.selectionRegistrar.setAfterSelectableUnsubscribe$foundation_release((Function1)anon7);
    }

    public static final long access$convertToContainerCoordinates-R5De75A(androidx.compose.foundation.text.selection.SelectionManager $this, LayoutCoordinates layoutCoordinates, long offset) {
        return $this.convertToContainerCoordinates-R5De75A(layoutCoordinates, offset);
    }

    public static final Object access$detectNonConsumingTap(androidx.compose.foundation.text.selection.SelectionManager $this, PointerInputScope $receiver, Function1 onTap, Continuation $completion) {
        return $this.detectNonConsumingTap($receiver, onTap, $completion);
    }

    public static final androidx.compose.foundation.text.selection.SelectionRegistrarImpl access$getSelectionRegistrar$p(androidx.compose.foundation.text.selection.SelectionManager $this) {
        return $this.selectionRegistrar;
    }

    public static final void access$setCurrentDragPosition-_kEHs6E(androidx.compose.foundation.text.selection.SelectionManager $this, Offset <set-?>) {
        $this.setCurrentDragPosition-_kEHs6E(<set-?>);
    }

    public static final void access$setDragBeginPosition-k-4lQ0M(androidx.compose.foundation.text.selection.SelectionManager $this, long <set-?>) {
        $this.setDragBeginPosition-k-4lQ0M(<set-?>);
    }

    public static final void access$setDragTotalDistance-k-4lQ0M(androidx.compose.foundation.text.selection.SelectionManager $this, long <set-?>) {
        $this.setDragTotalDistance-k-4lQ0M(<set-?>);
    }

    public static final void access$setDraggingHandle(androidx.compose.foundation.text.selection.SelectionManager $this, Handle <set-?>) {
        $this.setDraggingHandle(<set-?>);
    }

    public static final void access$setEndHandlePosition-_kEHs6E(androidx.compose.foundation.text.selection.SelectionManager $this, Offset <set-?>) {
        $this.setEndHandlePosition-_kEHs6E(<set-?>);
    }

    public static final void access$setStartHandlePosition-_kEHs6E(androidx.compose.foundation.text.selection.SelectionManager $this, Offset <set-?>) {
        $this.setStartHandlePosition-_kEHs6E(<set-?>);
    }

    public static final void access$startSelection-9KIMszo(androidx.compose.foundation.text.selection.SelectionManager $this, long position, boolean isStartHandle, androidx.compose.foundation.text.selection.SelectionAdjustment adjustment) {
        $this.startSelection-9KIMszo(position, isStartHandle, adjustment);
    }

    public static final void access$toolbarCopy(androidx.compose.foundation.text.selection.SelectionManager $this) {
        $this.toolbarCopy();
    }

    public static final void access$updateHandleOffsets(androidx.compose.foundation.text.selection.SelectionManager $this) {
        $this.updateHandleOffsets();
    }

    public static final void access$updateSelectionToolbar(androidx.compose.foundation.text.selection.SelectionManager $this) {
        $this.updateSelectionToolbar();
    }

    private final long convertToContainerCoordinates-R5De75A(LayoutCoordinates layoutCoordinates, long offset) {
        boolean attached;
        final LayoutCoordinates containerLayoutCoordinates = this.containerLayoutCoordinates;
        if (containerLayoutCoordinates != null && !containerLayoutCoordinates.isAttached()) {
            if (!containerLayoutCoordinates.isAttached()) {
            }
            return requireContainerCoordinates$foundation_release().localPositionOf-R5De75A(layoutCoordinates, offset);
        }
        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    private final Object detectNonConsumingTap(PointerInputScope $this$detectNonConsumingTap, Function1<? super Offset, Unit> onTap, Continuation<? super Unit> $completion) {
        SelectionManager.detectNonConsumingTap.2 anon = new SelectionManager.detectNonConsumingTap.2(onTap, 0);
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectNonConsumingTap, (Function2)anon, $completion);
        if (awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return awaitEachGesture;
        }
        return Unit.INSTANCE;
    }

    private final Rect getContentRect() {
        int i2;
        Pair it;
        List sort;
        int cmp;
        int index$iv$iv;
        Object obj;
        Object obj2;
        int i;
        Object obj3;
        int i3;
        LongObjectMap subselections;
        int i4;
        List list;
        final Object obj4 = this;
        i2 = 0;
        if (obj4.getSelection() == null) {
            return i2;
        }
        LayoutCoordinates containerLayoutCoordinates = obj4.containerLayoutCoordinates;
        if (containerLayoutCoordinates == null) {
            return i2;
        }
        if (!containerLayoutCoordinates.isAttached()) {
            return i2;
        }
        sort = obj4.selectionRegistrar.sort(obj4.requireContainerCoordinates$foundation_release());
        int i5 = 0;
        ArrayList arrayList = new ArrayList(sort.size());
        List list4 = sort;
        int i8 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list4.size()) {
            i = 0;
            obj3 = obj2;
            i3 = 0;
            i4 = i2;
            Object obj5 = obj4.selectionRegistrar.getSubselections().get((Selectable)obj3.getSelectableId());
            if ((Selection)obj5 != null) {
            } else {
            }
            it = i4;
            if (it != null) {
            }
            index$iv$iv++;
            i2 = i4;
            sort = list;
            sort = 0;
            (Collection)arrayList.add(it);
            sort = 0;
            it = TuplesKt.to(obj3, (Selection)obj5);
        }
        int i16 = i2;
        List list5 = sort;
        List list3 = SelectionManagerKt.access$firstAndLast((List)arrayList);
        if (list3.isEmpty()) {
            return i16;
        }
        Rect selectedRegionRect = SelectionManagerKt.getSelectedRegionRect(list3, containerLayoutCoordinates);
        if (Intrinsics.areEqual(selectedRegionRect, SelectionManagerKt.access$getInvertedInfiniteRect$p())) {
            return i16;
        }
        Rect intersect = SelectionManagerKt.visibleBounds(containerLayoutCoordinates).intersect(selectedRegionRect);
        int i6 = 0;
        if (Float.compare(width, i6) >= 0 && Float.compare(height, i6) < 0) {
            if (Float.compare(height, i6) < 0) {
            }
            Rect translate-k-4lQ0M = intersect.translate-k-4lQ0M(LayoutCoordinatesKt.positionInRoot(containerLayoutCoordinates));
            return Rect.copy$default(translate-k-4lQ0M, 0, 0, 0, bottom + i7, 7, 0);
        }
        return i16;
    }

    public static void getPreviousSelectionLayout$foundation_release$annotations() {
    }

    private final androidx.compose.foundation.text.selection.SelectionLayout getSelectionLayout-Wko1d7g(long position, long previousHandlePosition, boolean isStartHandle) {
        androidx.compose.foundation.text.selection.Selection selection;
        int index$iv;
        int index$iv2;
        boolean z;
        Object obj;
        java.util.Comparator comparator;
        int i;
        int i2;
        int i3;
        long selectableId;
        final LayoutCoordinates requireContainerCoordinates$foundation_release = requireContainerCoordinates$foundation_release();
        final List sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release);
        final MutableLongIntMap mutableLongIntMapOf = LongIntMapKt.mutableLongIntMapOf();
        List list = sort;
        int i4 = 0;
        index$iv = 0;
        while (index$iv < list.size()) {
            i2 = 0;
            mutableLongIntMapOf.set((Selectable)list.get(index$iv).getSelectableId(), obj13);
            index$iv++;
        }
        SelectionManager.getSelectionLayout-Wko1d7g$$inlined.compareBy.1 $this$fastForEachIndexed$iv = new SelectionManager.getSelectionLayout-Wko1d7g$$inlined.compareBy.1(mutableLongIntMapOf);
        if (OffsetKt.isUnspecified-k-4lQ0M(isStartHandle)) {
            selection = 0;
        } else {
            selection = getSelection();
        }
        SelectionLayoutBuilder selectionLayoutBuilder = new SelectionLayoutBuilder(position, index$iv, isStartHandle, z, requireContainerCoordinates$foundation_release, obj19, selection, (Comparator)$this$fastForEachIndexed$iv, 0);
        List list2 = sort;
        int i5 = 0;
        index$iv2 = 0;
        while (index$iv2 < list2.size()) {
            selectableId = 0;
            (Selectable)list2.get(index$iv2).appendSelectableInfoToBuilder(selectionLayoutBuilder);
            index$iv2++;
        }
        return selectionLayoutBuilder.build();
    }

    private final boolean getShouldShowMagnifier() {
        int i;
        Handle triviallyCollapsedSelection$foundation_release;
        if (getDraggingHandle() != null && isInTouchMode() && !isTriviallyCollapsedSelection$foundation_release()) {
            if (isInTouchMode()) {
                i = !isTriviallyCollapsedSelection$foundation_release() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private final Modifier onClearSelectionRequested(Modifier $this$onClearSelectionRequested, Function0<Unit> block) {
        Modifier pointerInput;
        androidx.compose.foundation.text.selection.SelectionManager.onClearSelectionRequested.1 anon;
        int i;
        if (getHasFocus()) {
            anon = new SelectionManager.onClearSelectionRequested.1(this, block, 0);
            pointerInput = SuspendingPointerInputFilterKt.pointerInput($this$onClearSelectionRequested, Unit.INSTANCE, (Function2)anon);
        } else {
            pointerInput = $this$onClearSelectionRequested;
        }
        return pointerInput;
    }

    private final void selectionChanged(androidx.compose.foundation.text.selection.SelectionLayout selectionLayout, androidx.compose.foundation.text.selection.Selection newSelection) {
        boolean performHaptics$foundation_release;
        int textHandleMove-5zf0vsI;
        performHaptics$foundation_release = this.hapticFeedBack;
        if (shouldPerformHaptics$foundation_release() && performHaptics$foundation_release != null) {
            performHaptics$foundation_release = this.hapticFeedBack;
            if (performHaptics$foundation_release != null) {
                performHaptics$foundation_release.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
            }
        }
        this.selectionRegistrar.setSubselections(selectionLayout.createSubSelections(newSelection));
        this.onSelectionChange.invoke(newSelection);
    }

    private final void setCurrentDragPosition-_kEHs6E(Offset <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.currentDragPosition$delegate.setValue(<set-?>);
    }

    private final void setDragBeginPosition-k-4lQ0M(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.dragBeginPosition$delegate.setValue(Offset.box-impl(<set-?>));
    }

    private final void setDragTotalDistance-k-4lQ0M(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.dragTotalDistance$delegate.setValue(Offset.box-impl(<set-?>));
    }

    private final void setDraggingHandle(Handle <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.draggingHandle$delegate.setValue(<set-?>);
    }

    private final void setEndHandlePosition-_kEHs6E(Offset <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.endHandlePosition$delegate.setValue(<set-?>);
    }

    private final void setStartHandlePosition-_kEHs6E(Offset <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.startHandlePosition$delegate.setValue(<set-?>);
    }

    private final void startSelection-9KIMszo(long position, boolean isStartHandle, androidx.compose.foundation.text.selection.SelectionAdjustment adjustment) {
        this.previousSelectionLayout = 0;
        this.updateSelection-jyLRC_s$foundation_release(position, obj3, Offset.Companion.getUnspecified-F1C5BW0(), obj5);
    }

    private final void toolbarCopy() {
        copy$foundation_release();
        onRelease();
    }

    private final void updateHandleOffsets() {
        boolean inclusive-Uv8p0NA;
        Object containerCoordinates;
        int i4;
        Handle inclusive-Uv8p0NA2;
        int i2;
        int handleCoordinates;
        androidx.compose.foundation.text.selection.Selection.AnchorInfo start;
        int p0;
        int end;
        androidx.compose.foundation.text.selection.Selectable p02;
        int i5;
        LayoutCoordinates layoutCoordinates2;
        LayoutCoordinates layoutCoordinates;
        boolean attached;
        Handle selectionStart;
        int unbox-impl;
        LayoutCoordinates handlePosition-dBAh8RU2;
        int i6;
        long handlePosition-dBAh8RU;
        boolean localPositionOf-R5De75A;
        long l;
        int box-impl;
        int i;
        LayoutCoordinates layoutCoordinates4;
        androidx.compose.foundation.text.selection.Selection selection;
        androidx.compose.foundation.text.selection.Selection selection2;
        int i3;
        LayoutCoordinates layoutCoordinates3;
        LayoutCoordinates layoutCoordinates5;
        final Object obj = this;
        inclusive-Uv8p0NA = obj.getSelection();
        containerCoordinates = obj.containerLayoutCoordinates;
        start = inclusive-Uv8p0NA.getStart();
        if (inclusive-Uv8p0NA != null && start != null) {
            start = inclusive-Uv8p0NA.getStart();
            if (start != null) {
                end = 0;
                p0 = obj.getAnchorSelectable$foundation_release(start);
            } else {
                p0 = 0;
            }
        } else {
        }
        end = inclusive-Uv8p0NA.getEnd();
        if (inclusive-Uv8p0NA != null && end != null) {
            end = inclusive-Uv8p0NA.getEnd();
            if (end != null) {
                i5 = 0;
                p02 = obj.getAnchorSelectable$foundation_release(end);
            } else {
                p02 = 0;
            }
        } else {
        }
        if (p0 != 0) {
            layoutCoordinates2 = p0.getLayoutCoordinates();
        } else {
            layoutCoordinates2 = 0;
        }
        if (p02 != null) {
            layoutCoordinates = p02.getLayoutCoordinates();
        } else {
            layoutCoordinates = 0;
        }
        if (inclusive-Uv8p0NA != null) {
            if (containerCoordinates != null) {
                if (containerCoordinates.isAttached()) {
                    if (layoutCoordinates2 == null && layoutCoordinates == null) {
                        if (layoutCoordinates == null) {
                            selection2 = inclusive-Uv8p0NA;
                            layoutCoordinates5 = containerCoordinates;
                        } else {
                            Rect visibleBounds = SelectionManagerKt.visibleBounds(containerCoordinates);
                            if (layoutCoordinates2 != null) {
                                handlePosition-dBAh8RU2 = layoutCoordinates2;
                                i6 = 0;
                                handlePosition-dBAh8RU = p0.getHandlePosition-dBAh8RU(inclusive-Uv8p0NA, true);
                                if (OffsetKt.isUnspecified-k-4lQ0M(handlePosition-dBAh8RU)) {
                                    box-impl = 0;
                                } else {
                                    layoutCoordinates4 = handlePosition-dBAh8RU2;
                                    i3 = 0;
                                    if (obj.getDraggingHandle() != Handle.SelectionStart) {
                                        if (SelectionManagerKt.containsInclusive-Uv8p0NA(visibleBounds, Offset.box-impl(containerCoordinates.localPositionOf-R5De75A(handlePosition-dBAh8RU2, handlePosition-dBAh8RU)).unbox-impl())) {
                                            i4 = 1;
                                        } else {
                                            i4 = 0;
                                        }
                                    } else {
                                    }
                                    if (i4 != 0) {
                                    } else {
                                        box-impl = 0;
                                    }
                                }
                                i2 = box-impl;
                            } else {
                                i2 = 0;
                            }
                            obj.setStartHandlePosition-_kEHs6E(i2);
                            if (layoutCoordinates != null) {
                                selectionStart = 0;
                                handlePosition-dBAh8RU2 = p02.getHandlePosition-dBAh8RU(inclusive-Uv8p0NA, false);
                                if (OffsetKt.isUnspecified-k-4lQ0M(handlePosition-dBAh8RU2)) {
                                    selection = inclusive-Uv8p0NA;
                                    layoutCoordinates3 = containerCoordinates;
                                    handleCoordinates = 0;
                                } else {
                                    l = handlePosition-dBAh8RU2;
                                    i6 = 0;
                                    selection = inclusive-Uv8p0NA;
                                    layoutCoordinates3 = containerCoordinates;
                                    if (obj.getDraggingHandle() != Handle.SelectionEnd) {
                                        if (SelectionManagerKt.containsInclusive-Uv8p0NA(visibleBounds, Offset.box-impl(containerCoordinates.localPositionOf-R5De75A(layoutCoordinates, handlePosition-dBAh8RU2)).unbox-impl())) {
                                            i = 1;
                                        } else {
                                            i = 0;
                                        }
                                    } else {
                                    }
                                    if (i != 0) {
                                    } else {
                                        localPositionOf-R5De75A = 0;
                                    }
                                    handleCoordinates = localPositionOf-R5De75A;
                                }
                            } else {
                                selection = inclusive-Uv8p0NA;
                                layoutCoordinates3 = containerCoordinates;
                                handleCoordinates = 0;
                            }
                        }
                    } else {
                    }
                    obj.setEndHandlePosition-_kEHs6E(handleCoordinates);
                }
                selection2 = inclusive-Uv8p0NA;
                layoutCoordinates5 = containerCoordinates;
            } else {
                selection2 = inclusive-Uv8p0NA;
                layoutCoordinates5 = containerCoordinates;
            }
        } else {
            selection2 = inclusive-Uv8p0NA;
            layoutCoordinates5 = containerCoordinates;
        }
        int selection3 = 0;
        obj.setStartHandlePosition-_kEHs6E(selection3);
        obj.setEndHandlePosition-_kEHs6E(selection3);
    }

    private final void updateSelectionToolbar() {
        Object status;
        boolean showToolbar;
        Object contentRect;
        androidx.compose.foundation.text.selection.SelectionManager.updateSelectionToolbar.1 anon2;
        int anon;
        int i5;
        int i3;
        int i;
        int i2;
        int i4;
        if (!getHasFocus()) {
        }
        TextToolbar textToolbar = this.textToolbar;
        if (textToolbar == null) {
        }
        final TextToolbar textToolbar2 = textToolbar;
        if (this.showToolbar && isInTouchMode()) {
            if (isInTouchMode()) {
                contentRect = getContentRect();
                if (contentRect == null) {
                }
                if (isNonEmptySelection$foundation_release()) {
                    status = new SelectionManager.updateSelectionToolbar.1(this);
                } else {
                    status = anon;
                }
                if (isEntireContainerSelected$foundation_release()) {
                } else {
                    anon = new SelectionManager.updateSelectionToolbar.2(this);
                }
                TextToolbar.showMenu$default(textToolbar2, contentRect, (Function0)status, 0, 0, (Function0)anon, 12, 0);
            } else {
                if (textToolbar2.getStatus() == TextToolbarStatus.Shown) {
                    textToolbar2.hide();
                }
            }
        } else {
        }
    }

    public final void contextMenuOpenAdjustment-k-4lQ0M(long position) {
        boolean collapsed-impl;
        long textRange-d9O1mEE;
        androidx.compose.foundation.text.selection.Selection selection = getSelection();
        final int i = 1;
        if (selection != null) {
            collapsed-impl = TextRange.getCollapsed-impl(selection.toTextRange-d9O1mEE());
        } else {
            collapsed-impl = i;
        }
        if (collapsed-impl) {
            startSelection-9KIMszo(position, obj6, i);
        }
    }

    public final void copy$foundation_release() {
        AnnotatedString selectedText$foundation_release;
        AnnotatedString str;
        int clipboardManager;
        int i;
        selectedText$foundation_release = getSelectedText$foundation_release();
        if (selectedText$foundation_release != null) {
            clipboardManager = 0;
            i = (CharSequence)selectedText$foundation_release.length() > 0 ? 1 : 0;
            if (i != 0) {
            } else {
                selectedText$foundation_release = 0;
            }
            str = 0;
            clipboardManager = this.clipboardManager;
            if (selectedText$foundation_release != 0 && clipboardManager != null) {
                str = 0;
                clipboardManager = this.clipboardManager;
                if (clipboardManager != null) {
                    clipboardManager.setText(selectedText$foundation_release);
                }
            }
        }
    }

    public final androidx.compose.foundation.text.selection.Selectable getAnchorSelectable$foundation_release(androidx.compose.foundation.text.selection.Selection.AnchorInfo anchor) {
        return (Selectable)this.selectionRegistrar.getSelectableMap$foundation_release().get(anchor.getSelectableId());
    }

    public final ClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    public final LayoutCoordinates getContainerLayoutCoordinates() {
        return this.containerLayoutCoordinates;
    }

    public final Offset getCurrentDragPosition-_m7T9-E() {
        final int i = 0;
        final int i2 = 0;
        return (Offset)(State)this.currentDragPosition$delegate.getValue();
    }

    public final long getDragBeginPosition-F1C5BW0$foundation_release() {
        final int i = 0;
        final int i2 = 0;
        return (Offset)(State)this.dragBeginPosition$delegate.getValue().unbox-impl();
    }

    public final long getDragTotalDistance-F1C5BW0$foundation_release() {
        final int i = 0;
        final int i2 = 0;
        return (Offset)(State)this.dragTotalDistance$delegate.getValue().unbox-impl();
    }

    public final Handle getDraggingHandle() {
        final int i = 0;
        final int i2 = 0;
        return (Handle)(State)this.draggingHandle$delegate.getValue();
    }

    public final Offset getEndHandlePosition-_m7T9-E() {
        final int i = 0;
        final int i2 = 0;
        return (Offset)(State)this.endHandlePosition$delegate.getValue();
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final boolean getHasFocus() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.hasFocus$delegate.getValue().booleanValue();
    }

    public final Modifier getModifier() {
        Modifier selectionMagnifier;
        SelectionManager.modifier.1 anon = new SelectionManager.modifier.1(this);
        SelectionManager.modifier.2 anon2 = new SelectionManager.modifier.2(this);
        SelectionManager.modifier.3 anon3 = new SelectionManager.modifier.3(this);
        int i = 0;
        SelectionManager.modifier.4 anon4 = new SelectionManager.modifier.4(this);
        SelectionManager.modifier.5 anon5 = new SelectionManager.modifier.5(this);
        if (getShouldShowMagnifier()) {
            selectionMagnifier = SelectionManager_androidKt.selectionMagnifier((Modifier)Modifier.Companion, this);
        } else {
            selectionMagnifier = Modifier.Companion;
        }
        return KeyInputModifierKt.onKeyEvent(SelectionGesturesKt.updateSelectionTouchMode(FocusableKt.focusable$default(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(OnGloballyPositionedModifierKt.onGloballyPositioned(onClearSelectionRequested((Modifier)Modifier.Companion, (Function0)anon), (Function1)anon2), this.focusRequester), (Function1)anon3), false, i, 3, i), (Function1)anon4), (Function1)anon5).then(selectionMagnifier);
    }

    public final Function1<androidx.compose.foundation.text.selection.Selection, Unit> getOnSelectionChange() {
        return this.onSelectionChange;
    }

    public final androidx.compose.foundation.text.selection.SelectionLayout getPreviousSelectionLayout$foundation_release() {
        return this.previousSelectionLayout;
    }

    public final AnnotatedString getSelectedText$foundation_release() {
        Object subSequence;
        androidx.compose.foundation.text.selection.Selection selection;
        int index$iv;
        Object obj3;
        Object obj;
        int i;
        Object obj2;
        long selectableId;
        AnnotatedString text;
        int offset;
        androidx.compose.foundation.text.selection.Selection.AnchorInfo start;
        subSequence = this;
        int i3 = 0;
        if (subSequence.getSelection() != null) {
            if (subSequence.selectionRegistrar.getSubselections().isEmpty()) {
            } else {
                int i2 = 0;
                AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, i3);
                int i5 = 0;
                List sort = subSequence.selectionRegistrar.sort(subSequence.requireContainerCoordinates$foundation_release());
                int i7 = 0;
                index$iv = 0;
                while (index$iv < sort.size()) {
                    obj = obj3;
                    i = 0;
                    obj2 = subSequence.selectionRegistrar.getSubselections().get((Selectable)obj.getSelectableId());
                    if ((Selection)obj2 != null) {
                    }
                    index$iv++;
                    subSequence = this;
                    selectableId = 0;
                    text = obj.getText();
                    if ((Selection)obj2.getHandlesCrossed()) {
                    } else {
                    }
                    subSequence = text.subSequence(obj2.getStart().getOffset(), obj2.getEnd().getOffset());
                    builder.append(subSequence);
                    subSequence = text.subSequence(obj2.getEnd().getOffset(), obj2.getStart().getOffset());
                }
            }
            return builder.toAnnotatedString();
        }
        return i3;
    }

    public final androidx.compose.foundation.text.selection.Selection getSelection() {
        return (Selection)this._selection.getValue();
    }

    public final boolean getShowToolbar$foundation_release() {
        return this.showToolbar;
    }

    public final Offset getStartHandlePosition-_m7T9-E() {
        final int i = 0;
        final int i2 = 0;
        return (Offset)(State)this.startHandlePosition$delegate.getValue();
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final TextDragObserver handleDragObserver(boolean isStartHandle) {
        SelectionManager.handleDragObserver.1 anon = new SelectionManager.handleDragObserver.1(isStartHandle, this);
        return (TextDragObserver)anon;
    }

    public final boolean isEntireContainerSelected$foundation_release() {
        Object obj2;
        List length;
        int subSelection;
        int i2;
        int offset;
        int index$iv$iv;
        Object obj;
        Object obj3;
        int i5;
        Object obj4;
        int i3;
        AnnotatedString text;
        int subselections;
        int i4;
        int i;
        List selectables;
        obj2 = this;
        length = obj2.selectionRegistrar.sort(obj2.requireContainerCoordinates$foundation_release());
        if (length.isEmpty()) {
            return 1;
        }
        offset = 0;
        final List list2 = list;
        final int i6 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list2.size()) {
            i5 = 0;
            obj4 = obj3;
            i3 = 0;
            text = (Selectable)obj4.getText();
            i4 = 0;
            if ((CharSequence)text.length() == 0) {
            } else {
            }
            subselections = i4;
            if (subselections != 0) {
            } else {
            }
            i = offset;
            Object obj5 = obj2.selectionRegistrar.getSubselections().get(obj4.getSelectableId());
            if ((Selection)obj5 == null) {
            } else {
            }
            selectables = length;
            if (Math.abs(offset - subselections) == text.length()) {
            } else {
            }
            subSelection = i4;
            index$iv$iv++;
            subSelection = 1;
            obj2 = this;
            offset = i;
            length = selectables;
            subSelection = 1;
            selectables = length;
            subSelection = i4;
            selectables = length;
            i = offset;
            subselections = subSelection;
        }
        selectables = length;
        i = offset;
        i2 = 1;
        return i2;
    }

    public final boolean isInTouchMode() {
        return (Boolean)this._isInTouchMode.getValue().booleanValue();
    }

    public final boolean isNonEmptySelection$foundation_release() {
        int i4;
        int i3;
        int $this$isNonEmptySelection_u24lambda_u2413_u24lambda_u2412;
        List sort;
        int offset;
        int index$iv$iv;
        Object obj;
        Object obj2;
        int i2;
        Object obj3;
        int i;
        int subselections;
        List $this$fastAny$iv;
        androidx.compose.foundation.text.selection.Selection.AnchorInfo end;
        final Object obj4 = this;
        final androidx.compose.foundation.text.selection.Selection selection = obj4.getSelection();
        i4 = 0;
        if (selection == null) {
            return i4;
        }
        if (Intrinsics.areEqual(selection.getStart(), selection.getEnd())) {
            return i4;
        }
        if (Long.compare(selectableId2, selectableId3) == 0) {
            return 1;
        }
        int i5 = 0;
        final List list = sort;
        final int i6 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            i2 = 0;
            i = 0;
            Object obj5 = obj4.selectionRegistrar.getSubselections().get((Selectable)list.get(index$iv$iv).getSelectableId());
            if ((Selection)obj5 != null) {
            } else {
            }
            $this$isNonEmptySelection_u24lambda_u2413_u24lambda_u2412 = 0;
            index$iv$iv++;
            sort = $this$fastAny$iv;
            i4 = 0;
            offset = 1;
            sort = 0;
            if ((Selection)obj5.getStart().getOffset() != obj5.getEnd().getOffset()) {
            } else {
            }
            $this$isNonEmptySelection_u24lambda_u2413_u24lambda_u2412 = 0;
            $this$isNonEmptySelection_u24lambda_u2413_u24lambda_u2412 = 1;
        }
        $this$fastAny$iv = sort;
        i3 = 0;
        return i3;
    }

    public final boolean isTriviallyCollapsedSelection$foundation_release() {
        androidx.compose.foundation.text.selection.Selection selection = getSelection();
        if (selection == null) {
            return 1;
        }
        return Intrinsics.areEqual(selection.getStart(), selection.getEnd());
    }

    public final void onRelease() {
        androidx.compose.foundation.text.selection.Selection hapticFeedBack;
        LongObjectMap textHandleMove-5zf0vsI;
        this.selectionRegistrar.setSubselections(LongObjectMapKt.emptyLongObjectMap());
        setShowToolbar$foundation_release(false);
        this.onSelectionChange.invoke(0);
        hapticFeedBack = this.hapticFeedBack;
        if (getSelection() != null && isInTouchMode() && hapticFeedBack != null) {
            this.onSelectionChange.invoke(0);
            if (isInTouchMode()) {
                hapticFeedBack = this.hapticFeedBack;
                if (hapticFeedBack != null) {
                    hapticFeedBack.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
                }
            }
        }
    }

    public final LayoutCoordinates requireContainerCoordinates$foundation_release() {
        final LayoutCoordinates containerLayoutCoordinates = this.containerLayoutCoordinates;
        if (containerLayoutCoordinates == null) {
        } else {
            if (!containerLayoutCoordinates.isAttached()) {
            } else {
                return containerLayoutCoordinates;
            }
            int i = 0;
            IllegalArgumentException $i$a$RequireSelectionManager$requireContainerCoordinates$2 = new IllegalArgumentException("unattached coordinates".toString());
            throw $i$a$RequireSelectionManager$requireContainerCoordinates$2;
        }
        int i2 = 0;
        IllegalArgumentException $i$a$RequireNotNullSelectionManager$requireContainerCoordinates$1 = new IllegalArgumentException("null coordinates".toString());
        throw $i$a$RequireNotNullSelectionManager$requireContainerCoordinates$1;
    }

    public final void selectAll$foundation_release() {
        List selectableId;
        androidx.compose.foundation.text.selection.Selection selection;
        int firstSubSelection;
        int lastSubSelection;
        Object start;
        androidx.compose.foundation.text.selection.Selection.AnchorInfo end;
        int list;
        int index$iv;
        Object obj2;
        Object obj;
        int i;
        androidx.compose.foundation.text.selection.Selection selectAllSelection;
        List list2;
        int i2;
        final Object obj3 = this;
        selectableId = obj3.selectionRegistrar.sort(obj3.requireContainerCoordinates$foundation_release());
        if (selectableId.isEmpty()) {
        }
        firstSubSelection = 0;
        lastSubSelection = 0;
        final MutableLongObjectMap mutableLongObjectMapOf = LongObjectMapKt.mutableLongObjectMapOf();
        end = 0;
        list = selectableId;
        final int i4 = 0;
        index$iv = 0;
        while (index$iv < list.size()) {
            obj = obj2;
            i = 0;
            selectAllSelection = (Selectable)obj.getSelectAllSelection();
            if (selectAllSelection == null) {
            } else {
            }
            if (firstSubSelection == 0) {
            }
            lastSubSelection = selectAllSelection;
            list2 = selectableId;
            mutableLongObjectMapOf.put(obj.getSelectableId(), firstSubSelection);
            firstSubSelection = i2;
            index$iv++;
            selectableId = list2;
            firstSubSelection = selectAllSelection;
            list2 = selectableId;
        }
        List selectables = selectableId;
        if (mutableLongObjectMapOf.isEmpty()) {
        }
        if (firstSubSelection == lastSubSelection) {
            selection = firstSubSelection;
        } else {
            Intrinsics.checkNotNull(firstSubSelection);
            Intrinsics.checkNotNull(lastSubSelection);
            selection = new Selection(firstSubSelection.getStart(), lastSubSelection.getEnd(), 0);
        }
        obj3.selectionRegistrar.setSubselections((LongObjectMap)mutableLongObjectMapOf);
        obj3.onSelectionChange.invoke(selection);
        obj3.previousSelectionLayout = 0;
    }

    public final Pair<androidx.compose.foundation.text.selection.Selection, LongObjectMap<androidx.compose.foundation.text.selection.Selection>> selectAllInSelectable$foundation_release(long selectableId, androidx.compose.foundation.text.selection.Selection previousSelection) {
        List selectableId2;
        Object obj3;
        int hapticFeedBack;
        int $i$f$fastFold;
        int accumulator$iv;
        int index$iv$iv;
        Object obj;
        Object obj2;
        int i2;
        Object obj4;
        int i3;
        int i4;
        androidx.compose.foundation.text.selection.Selection selectAllSelection;
        androidx.compose.foundation.text.selection.Selection selection;
        int i5;
        List $this$fastFold$iv;
        int i;
        int i6;
        final Object obj5 = this;
        final MutableLongObjectMap mutableLongObjectMapOf = LongObjectMapKt.mutableLongObjectMapOf();
        $i$f$fastFold = 0;
        int i7 = 0;
        accumulator$iv = hapticFeedBack;
        final List list = selectableId2;
        final int i8 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            i2 = 0;
            obj4 = obj2;
            i4 = 0;
            if (Long.compare(selectableId3, selectableId) == 0) {
            } else {
            }
            selectAllSelection = 0;
            selection = selectAllSelection;
            if (selection != null) {
            } else {
            }
            $this$fastFold$iv = selectableId2;
            i = hapticFeedBack;
            i6 = $i$f$fastFold;
            accumulator$iv = merge;
            index$iv$iv++;
            selectableId2 = $this$fastFold$iv;
            hapticFeedBack = i;
            $i$f$fastFold = i6;
            i5 = 0;
            $this$fastFold$iv = selectableId2;
            i = hapticFeedBack;
            i6 = $i$f$fastFold;
            mutableLongObjectMapOf.set(obj4.getSelectableId(), hapticFeedBack);
            selectAllSelection = obj4.getSelectAllSelection();
        }
        List $this$fastFold$iv2 = selectableId2;
        int i9 = hapticFeedBack;
        int i10 = $i$f$fastFold;
        if (obj5.isInTouchMode()) {
            hapticFeedBack = obj5.hapticFeedBack;
            if (!Intrinsics.areEqual(accumulator$iv, obj25) && hapticFeedBack != null) {
                hapticFeedBack = obj5.hapticFeedBack;
                if (hapticFeedBack != null) {
                    hapticFeedBack.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
                }
            }
        } else {
            obj3 = obj25;
        }
        Pair pair = new Pair(accumulator$iv, mutableLongObjectMapOf);
        return pair;
    }

    public final void setClipboardManager(ClipboardManager <set-?>) {
        this.clipboardManager = <set-?>;
    }

    public final void setContainerLayoutCoordinates(LayoutCoordinates value) {
        boolean hasFocus;
        long equal;
        this.containerLayoutCoordinates = value;
        if (getHasFocus() && getSelection() != null) {
            if (getSelection() != null) {
                if (value != null) {
                    hasFocus = Offset.box-impl(LayoutCoordinatesKt.positionInWindow(value));
                } else {
                    hasFocus = 0;
                }
                if (!Intrinsics.areEqual(this.previousPosition, hasFocus)) {
                    this.previousPosition = hasFocus;
                    updateHandleOffsets();
                    updateSelectionToolbar();
                }
            }
        }
    }

    public final void setFocusRequester(FocusRequester <set-?>) {
        this.focusRequester = <set-?>;
    }

    public final void setHapticFeedBack(HapticFeedback <set-?>) {
        this.hapticFeedBack = <set-?>;
    }

    public final void setHasFocus(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.hasFocus$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    public final void setInTouchMode(boolean value) {
        boolean _isInTouchMode;
        Boolean valueOf;
        if ((Boolean)this._isInTouchMode.getValue().booleanValue() != value) {
            this._isInTouchMode.setValue(Boolean.valueOf(value));
            updateSelectionToolbar();
        }
    }

    public final void setOnSelectionChange(Function1<? super androidx.compose.foundation.text.selection.Selection, Unit> newOnSelectionChange) {
        SelectionManager.onSelectionChange.2 anon = new SelectionManager.onSelectionChange.2(this, newOnSelectionChange);
        this.onSelectionChange = (Function1)anon;
    }

    public final void setPreviousSelectionLayout$foundation_release(androidx.compose.foundation.text.selection.SelectionLayout <set-?>) {
        this.previousSelectionLayout = <set-?>;
    }

    public final void setSelection(androidx.compose.foundation.text.selection.Selection value) {
        this._selection.setValue(value);
        if (value != null) {
            updateHandleOffsets();
        }
    }

    public final void setShowToolbar$foundation_release(boolean value) {
        this.showToolbar = value;
        updateSelectionToolbar();
    }

    public final void setTextToolbar(TextToolbar <set-?>) {
        this.textToolbar = <set-?>;
    }

    public final boolean shouldPerformHaptics$foundation_release() {
        int $this$fastAny$iv;
        int i6;
        int i4;
        List list;
        int i5;
        int index$iv$iv;
        int size;
        int i3;
        Object obj;
        Object obj3;
        int i;
        Object obj2;
        int i7;
        int i2;
        i6 = 0;
        if (isInTouchMode()) {
            i4 = 0;
            list = selectables$foundation_release;
            i5 = 0;
            index$iv$iv = 0;
            i3 = 1;
            while (index$iv$iv < list.size()) {
                i = 0;
                i7 = 0;
                if ((CharSequence)(Selectable)list.get(index$iv$iv).getText().length() > 0) {
                } else {
                }
                i2 = i6;
                index$iv$iv++;
                i3 = 1;
                i2 = i3;
            }
            $this$fastAny$iv = i6;
            if ($this$fastAny$iv != 0) {
                i6 = i3;
            } else {
            }
        } else {
        }
        return i6;
    }

    public final boolean updateSelection-jyLRC_s$foundation_release(long position, long previousHandlePosition, boolean isStartHandle, androidx.compose.foundation.text.selection.SelectionAdjustment adjustment) {
        Handle selectionStart;
        selectionStart = obj9 != null ? Handle.SelectionStart : Handle.SelectionEnd;
        setDraggingHandle(selectionStart);
        setCurrentDragPosition-_kEHs6E(Offset.box-impl(position));
        androidx.compose.foundation.text.selection.SelectionLayout selectionLayout-Wko1d7g = getSelectionLayout-Wko1d7g(position, previousHandlePosition, isStartHandle);
        final Object obj = obj9;
        final boolean obj8 = isStartHandle;
        final long obj6 = position;
        final Object obj5 = this;
        if (!selectionLayout-Wko1d7g.shouldRecomputeSelection(obj5.previousSelectionLayout)) {
            return 0;
        }
        androidx.compose.foundation.text.selection.Selection adjust = obj10.adjust(selectionLayout-Wko1d7g);
        if (!Intrinsics.areEqual(adjust, getSelection())) {
            selectionChanged(selectionLayout-Wko1d7g, adjust);
        }
        obj5.previousSelectionLayout = selectionLayout-Wko1d7g;
        return 1;
    }

    public final boolean updateSelection-qNKwrvQ$foundation_release(Offset newPosition, long previousPosition, boolean isStartHandle, androidx.compose.foundation.text.selection.SelectionAdjustment adjustment) {
        if (newPosition == null) {
            return 0;
        }
        return this.updateSelection-jyLRC_s$foundation_release(newPosition.unbox-impl(), obj3, previousPosition, obj5);
    }
}

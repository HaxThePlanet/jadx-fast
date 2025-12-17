package androidx.compose.foundation.text.input.internal.selection;

import _COROUTINE.CoroutineDebuggingKt;
import androidx.compose.foundation.content.ReceiveContentListener;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent.Source;
import androidx.compose.foundation.content.TransferableContent.Source.Companion;
import androidx.compose.foundation.content.TransferableContent_androidKt;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction.Press;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.MathUtilsKt;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionAdjustment.Companion;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionLayout;
import androidx.compose.foundation.text.selection.SelectionLayoutKt;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextSelectionDelegateKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType.Companion;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRange.Companion;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.LongRef;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u001d\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008\u0000\u0018\u00002\u00020\u0001:\u0006«\u0001¬\u0001­\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\u000c\u001a\u00020\t¢\u0006\u0002\u0010\rJ\u0006\u0010W\u001a\u00020\tJ\u0006\u0010X\u001a\u00020\tJ\u0006\u0010Y\u001a\u00020\tJ\u0006\u0010Z\u001a\u00020\tJ\u0006\u0010[\u001a\u00020\\J\u0010\u0010]\u001a\u00020\\2\u0008\u0008\u0002\u0010^\u001a\u00020\tJ\u0006\u0010_\u001a\u00020\\J\u0006\u0010`\u001a\u00020\\J\u0006\u0010a\u001a\u00020\\J\u0008\u0010b\u001a\u00020cH\u0002J\u0015\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\tH\u0000¢\u0006\u0002\u0008gJ\u0006\u0010h\u001a\u00020cJ\u001d\u0010i\u001a\u00020\u00112\u0006\u0010j\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008k\u0010lJ\u001d\u0010m\u001a\u00020e2\u0006\u0010j\u001a\u00020\t2\u0006\u0010f\u001a\u00020\tH\u0000¢\u0006\u0002\u0008nJ<\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u0002032\u0006\u0010r\u001a\u0002032\u0008\u0010s\u001a\u0004\u0018\u00010p2\u0006\u0010j\u001a\u00020\t2\u0006\u0010t\u001a\u00020uH\u0002ø\u0001\u0000¢\u0006\u0004\u0008v\u0010wJ\u0008\u0010x\u001a\u00020\\H\u0002J\u0008\u0010y\u001a\u00020\tH\u0002J\u0008\u0010z\u001a\u00020\\H\u0002J1\u0010{\u001a\n\u0012\u0004\u0012\u00020\\\u0018\u00010<2\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010|\u001a\u00020P2\u000e\u0008\u0004\u0010}\u001a\u0008\u0012\u0004\u0012\u00020\\0<H\u0082\u0008J\u000e\u0010~\u001a\u00020\\H\u0086@¢\u0006\u0002\u0010\u007fJ\u000f\u0010\u0080\u0001\u001a\u00020\\H\u0082@¢\u0006\u0002\u0010\u007fJ\u000f\u0010\u0081\u0001\u001a\u00020\\H\u0082@¢\u0006\u0002\u0010\u007fJ\u0007\u0010\u0082\u0001\u001a\u00020\\J\t\u0010\u0083\u0001\u001a\u00020\\H\u0002J\u001e\u0010\u0084\u0001\u001a\u00020\t2\u0007\u0010\u0085\u0001\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0006\u0008\u0086\u0001\u0010\u0087\u0001J\u0007\u0010\u0088\u0001\u001a\u00020\\J\u0012\u0010\u0089\u0001\u001a\u00020\\2\u0007\u0010\u008a\u0001\u001a\u00020cH\u0002J?\u0010\u008b\u0001\u001a\u00020\\2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020O2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\tJ%\u0010\u008c\u0001\u001a\u00020\\2\u0007\u0010\u008d\u0001\u001a\u00020\u001d2\u0007\u0010\u008e\u0001\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0006\u0008\u008f\u0001\u0010\u0090\u0001JZ\u0010\u0091\u0001\u001a\u00020p2\u0008\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0007\u0010\u0094\u0001\u001a\u0002032\u0007\u0010\u0095\u0001\u001a\u0002032\u0006\u0010j\u001a\u00020\t2\u0006\u0010t\u001a\u00020u2\t\u0008\u0002\u0010\u0096\u0001\u001a\u00020\t2\t\u0008\u0002\u0010\u0097\u0001\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\u0008\u0098\u0001\u0010\u0099\u0001J\u000f\u0010\u009a\u0001\u001a\u00020\\2\u0006\u0010Q\u001a\u00020PJ\u0015\u0010\u009b\u0001\u001a\u00020\\*\u00030\u009c\u0001H\u0086@¢\u0006\u0003\u0010\u009d\u0001J\u0015\u0010\u009e\u0001\u001a\u00020\\*\u00030\u009c\u0001H\u0082@¢\u0006\u0003\u0010\u009d\u0001J\u001d\u0010\u009f\u0001\u001a\u00020\\*\u00030\u009c\u00012\u0006\u0010j\u001a\u00020\tH\u0082@¢\u0006\u0003\u0010 \u0001J?\u0010¡\u0001\u001a\u00020\\*\u00030\u009c\u00012\n\u0010¢\u0001\u001a\u0005\u0018\u00010£\u00012\r\u0010¤\u0001\u001a\u0008\u0012\u0004\u0012\u00020\\0<2\r\u0010¥\u0001\u001a\u0008\u0012\u0004\u0012\u00020\\0<H\u0086@¢\u0006\u0003\u0010¦\u0001J\u0015\u0010§\u0001\u001a\u00020\\*\u00030\u009c\u0001H\u0086@¢\u0006\u0003\u0010\u009d\u0001J\u001d\u0010¨\u0001\u001a\u00020\\*\u00030\u009c\u00012\u0006\u0010j\u001a\u00020\tH\u0086@¢\u0006\u0003\u0010 \u0001J$\u0010©\u0001\u001a\u00020\\*\u00030\u009c\u00012\r\u0010¤\u0001\u001a\u0008\u0012\u0004\u0012\u00020\\0<H\u0086@¢\u0006\u0003\u0010ª\u0001R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001b\u0010\u001c\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR/\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u001d8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008#\u0010\u001c\u001a\u0004\u0008\u001f\u0010 \"\u0004\u0008!\u0010\"R\u0014\u0010$\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008%\u0010&R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\u00020\u00118Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008(\u0010\u0013R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010&\"\u0004\u0008+\u0010,R+\u0010-\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008/\u0010\u001c\u001a\u0004\u0008-\u0010&\"\u0004\u0008.\u0010,R\u000e\u0010\u000c\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R1\u00106\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00118B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008:\u0010\u001c\u001a\u0004\u00087\u0010\u0013\"\u0004\u00088\u00109R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010;\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010=\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008>\u0010?\"\u0004\u0008@\u0010AR+\u0010B\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008E\u0010\u001c\u001a\u0004\u0008C\u0010&\"\u0004\u0008D\u0010,R1\u0010F\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00118B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008I\u0010\u001c\u001a\u0004\u0008G\u0010\u0013\"\u0004\u0008H\u00109R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010J\u001a\u0004\u0018\u00010K8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008L\u0010MR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010Q\u001a\u00020P2\u0006\u0010\u0014\u001a\u00020P8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008V\u0010\u001c\u001a\u0004\u0008R\u0010S\"\u0004\u0008T\u0010U\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006®\u0001", d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "density", "Landroidx/compose/ui/unit/Density;", "enabled", "", "readOnly", "isFocused", "isPassword", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/unit/Density;ZZZZ)V", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "currentTextLayoutPositionInWindow", "Landroidx/compose/ui/geometry/Offset;", "getCurrentTextLayoutPositionInWindow-F1C5BW0", "()J", "<set-?>", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "directDragGestureInitiator", "getDirectDragGestureInitiator", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "setDirectDragGestureInitiator", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;)V", "directDragGestureInitiator$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "editable", "getEditable", "()Z", "handleDragPosition", "getHandleDragPosition-F1C5BW0", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setFocused", "(Z)V", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "pressInteraction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "previousRawDragOffset", "", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "rawHandleDragPosition", "getRawHandleDragPosition-F1C5BW0", "setRawHandleDragPosition-k-4lQ0M", "(J)V", "rawHandleDragPosition$delegate", "receiveContentConfiguration", "Lkotlin/Function0;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "getReceiveContentConfiguration", "()Lkotlin/jvm/functions/Function0;", "setReceiveContentConfiguration", "(Lkotlin/jvm/functions/Function0;)V", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "startTextLayoutPositionInWindow", "getStartTextLayoutPositionInWindow-F1C5BW0", "setStartTextLayoutPositionInWindow-k-4lQ0M", "startTextLayoutPositionInWindow$delegate", "textLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getTextLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "textToolbarState", "getTextToolbarState", "()Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "setTextToolbarState", "(Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;)V", "textToolbarState$delegate", "canCopy", "canCut", "canPaste", "canSelectAll", "clearHandleDragging", "", "copy", "cancelSelection", "cut", "deselect", "dispose", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "includePosition", "getCursorHandleState$foundation_release", "getCursorRect", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ", "(Z)J", "getSelectionHandleState", "getSelectionHandleState$foundation_release", "getTextFieldSelection", "Landroidx/compose/ui/text/TextRange;", "rawStartOffset", "rawEndOffset", "previousSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getTextFieldSelection-qeG_v_k", "(IILandroidx/compose/ui/text/TextRange;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)J", "hideTextToolbar", "isCursorHandleInVisibleBounds", "markStartContentVisibleOffset", "menuItem", "desiredState", "operation", "observeChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeTextChanges", "observeTextToolbarVisibility", "paste", "pasteAsPlainText", "placeCursorAtNearestOffset", "offset", "placeCursorAtNearestOffset-k-4lQ0M", "(J)Z", "selectAll", "showTextToolbar", "contentRect", "update", "updateHandleDragging", "handle", "position", "updateHandleDragging-Uv8p0NA", "(Landroidx/compose/foundation/text/Handle;J)V", "updateSelection", "textFieldCharSequence", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "startOffset", "endOffset", "allowPreviousSelectionCollapsed", "isStartOfSelection", "updateSelection-SsL-Rf8", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;IIZLandroidx/compose/foundation/text/selection/SelectionAdjustment;ZZ)J", "updateTextToolbarState", "cursorHandleGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectCursorHandleDragGestures", "detectSelectionHandleDragGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTextFieldTapGestures", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "requestFocus", "showKeyboard", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTouchMode", "selectionHandleGestures", "textFieldSelectionGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "InputType", "TextFieldMouseSelectionObserver", "TextFieldTextDragObserver", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldSelectionState {

    public static final int $stable = 8;
    private ClipboardManager clipboardManager;
    private Density density;
    private final MutableState directDragGestureInitiator$delegate;
    private final MutableState draggingHandle$delegate;
    private boolean enabled;
    private HapticFeedback hapticFeedBack;
    private boolean isFocused;
    private final MutableState isInTouchMode$delegate;
    private boolean isPassword;
    private PressInteraction.Press pressInteraction;
    private int previousRawDragOffset = -1;
    private SelectionLayout previousSelectionLayout;
    private final MutableState rawHandleDragPosition$delegate;
    private boolean readOnly;
    private Function0<? extends ReceiveContentConfiguration> receiveContentConfiguration;
    private final MutableState showCursorHandle$delegate;
    private final MutableState startTextLayoutPositionInWindow$delegate;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private TextToolbar textToolbar;
    private final MutableState textToolbarState$delegate;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "", "(Ljava/lang/String;I)V", "None", "Touch", "Mouse", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static enum InputType {

        None,
        Touch,
        Mouse;
        private static final androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.InputType[] $values() {
            return /* result */;
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\"\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0008\u0010\u0012\u001a\u00020\u0004H\u0016J\u001a\u0010\u0013\u001a\u00020\u000c2\u0006\u0010\u0014\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0016J\"\u0010\u0019\u001a\u00020\u000c2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u0011J*\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000cH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0008\u001a\u00020\tX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006 ", d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldMouseSelectionObserver;", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "requestFocus", "Lkotlin/Function0;", "", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "onDrag", "", "dragPosition", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "onDrag-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "onDragDone", "onExtend", "downPosition", "onExtend-k-4lQ0M", "(J)Z", "onExtendDrag", "onExtendDrag-k-4lQ0M", "onStart", "onStart-3MmeM6k", "updateSelection", "Landroidx/compose/ui/text/TextRange;", "isStartOfSelection", "updateSelection-r1Wruf4", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class TextFieldMouseSelectionObserver implements MouseSelectionObserver {

        private int dragBeginOffsetInText = -1;
        private long dragBeginPosition;
        private final Function0<Unit> requestFocus;
        final androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState this$0;
        public TextFieldMouseSelectionObserver(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState this$0, Function0 requestFocus) {
            this.this$0 = this$0;
            super();
            this.requestFocus = requestFocus;
            int i = -1;
            this.dragBeginPosition = Offset.Companion.getUnspecified-F1C5BW0();
        }

        private final long updateSelection-r1Wruf4(long dragPosition, SelectionAdjustment adjustment, boolean isStartOfSelection) {
            Integer valueOf;
            int offsetForPosition-3MmeM6k;
            long newSelection;
            int dragBeginPosition;
            int dragBeginOffsetInText;
            int i;
            int i3 = 0;
            i = (Number)Integer.valueOf(this.dragBeginOffsetInText).intValue() >= 0 ? 1 : i3;
            if (i != 0) {
            } else {
                valueOf = 0;
            }
            if (valueOf != null) {
                offsetForPosition-3MmeM6k = valueOf.intValue();
            } else {
                offsetForPosition-3MmeM6k = TextFieldSelectionState.access$getTextLayoutState$p(this.this$0).getOffsetForPosition-3MmeM6k(this.dragBeginPosition, false);
            }
            newSelection = TextFieldSelectionState.access$updateSelection-SsL-Rf8(this.this$0, TextFieldSelectionState.access$getTextFieldState$p(this.this$0).getVisualText(), offsetForPosition-3MmeM6k, TextFieldSelectionState.access$getTextLayoutState$p(this.this$0).getOffsetForPosition-3MmeM6k(dragPosition, adjustment), false, isStartOfSelection, false, obj16);
            if (this.dragBeginOffsetInText == -1 && !TextRange.getCollapsed-impl(newSelection)) {
                if (!TextRange.getCollapsed-impl(newSelection)) {
                    this.dragBeginOffsetInText = TextRange.getStart-impl(newSelection);
                }
            }
            if (TextRange.getReversed-impl(newSelection)) {
                newSelection = TextFieldSelectionStateKt.access$reverse-5zc-tL8(newSelection);
            }
            TextFieldSelectionState.access$getTextFieldState$p(this.this$0).selectCharsIn-5zc-tL8(newSelection);
            this.this$0.updateTextToolbarState(TextToolbarState.Selection);
            return newSelection;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        public boolean onDrag-3MmeM6k(long dragPosition, SelectionAdjustment adjustment) {
            boolean z;
            int i;
            final int i2 = 0;
            if (TextFieldSelectionState.access$getEnabled$p(this.this$0)) {
                i = 1;
                z = (CharSequence)TextFieldSelectionState.access$getTextFieldState$p(this.this$0).getVisualText().length() == 0 ? i : i2;
                if (z != 0) {
                }
                TextFieldSelectionState.TextFieldMouseSelectionObserver.onDrag.1 anon = new TextFieldSelectionState.TextFieldMouseSelectionObserver.onDrag.1(dragPosition, adjustment);
                TextFieldSelectionStateKt.access$logDebug((Function0)anon);
                updateSelection-r1Wruf4(dragPosition, adjustment, obj6);
                return i;
            }
            return i2;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        public void onDragDone() {
            TextFieldSelectionStateKt.access$logDebug((Function0)TextFieldSelectionState.TextFieldMouseSelectionObserver.onDragDone.1.INSTANCE);
            this.this$0.setDirectDragGestureInitiator(TextFieldSelectionState.InputType.None);
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        public boolean onExtend-k-4lQ0M(long downPosition) {
            TextFieldSelectionStateKt.access$logDebug((Function0)TextFieldSelectionState.TextFieldMouseSelectionObserver.onExtend.1.INSTANCE);
            return 1;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        public boolean onExtendDrag-k-4lQ0M(long dragPosition) {
            TextFieldSelectionStateKt.access$logDebug((Function0)TextFieldSelectionState.TextFieldMouseSelectionObserver.onExtendDrag.1.INSTANCE);
            return 1;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        public boolean onStart-3MmeM6k(long downPosition, SelectionAdjustment adjustment) {
            boolean z;
            int i;
            int i2 = 0;
            if (TextFieldSelectionState.access$getEnabled$p(this.this$0)) {
                i = 1;
                z = (CharSequence)TextFieldSelectionState.access$getTextFieldState$p(this.this$0).getVisualText().length() == 0 ? i : i2;
                if (z != 0) {
                }
                TextFieldSelectionStateKt.access$logDebug((Function0)TextFieldSelectionState.TextFieldMouseSelectionObserver.onStart.1.INSTANCE);
                this.this$0.setDirectDragGestureInitiator(TextFieldSelectionState.InputType.Mouse);
                this.requestFocus.invoke();
                int i3 = -1;
                TextFieldSelectionState.access$setPreviousRawDragOffset$p(this.this$0, i3);
                this.dragBeginOffsetInText = i3;
                this.dragBeginPosition = downPosition;
                this.dragBeginOffsetInText = TextRange.getStart-impl(updateSelection-r1Wruf4(downPosition, adjustment, obj7));
                return i;
            }
            return i2;
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0008\u0010\u000e\u001a\u00020\u0004H\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0012J\u0008\u0010\u0016\u001a\u00020\u0004H\u0002J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u0012J\u0008\u0010\u001a\u001a\u00020\u0004H\u0016J\u0008\u0010\u001b\u001a\u00020\u0004H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000cR\u0016\u0010\r\u001a\u00020\u000bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000cR\u0014\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001c", d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldTextDragObserver;", "Landroidx/compose/foundation/text/TextDragObserver;", "requestFocus", "Lkotlin/Function0;", "", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "actingHandle", "Landroidx/compose/foundation/text/Handle;", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "dragTotalDistance", "onCancel", "onDown", "point", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onDragStop", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class TextFieldTextDragObserver implements TextDragObserver {

        private Handle actingHandle;
        private int dragBeginOffsetInText = -1;
        private long dragBeginPosition;
        private long dragTotalDistance;
        private final Function0<Unit> requestFocus;
        final androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState this$0;
        public TextFieldTextDragObserver(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState this$0, Function0 requestFocus) {
            this.this$0 = this$0;
            super();
            this.requestFocus = requestFocus;
            int i = -1;
            this.dragBeginPosition = Offset.Companion.getUnspecified-F1C5BW0();
            this.dragTotalDistance = Offset.Companion.getZero-F1C5BW0();
            this.actingHandle = Handle.SelectionEnd;
        }

        private final void onDragStop() {
            boolean specified-k-4lQ0M;
            long none;
            if (OffsetKt.isSpecified-k-4lQ0M(this.dragBeginPosition)) {
                TextFieldSelectionStateKt.access$logDebug((Function0)TextFieldSelectionState.TextFieldTextDragObserver.onDragStop.1.INSTANCE);
                this.this$0.clearHandleDragging();
                int i = -1;
                this.dragBeginOffsetInText = i;
                this.dragBeginPosition = Offset.Companion.getUnspecified-F1C5BW0();
                this.dragTotalDistance = Offset.Companion.getZero-F1C5BW0();
                TextFieldSelectionState.access$setPreviousRawDragOffset$p(this.this$0, i);
                this.this$0.setDirectDragGestureInitiator(TextFieldSelectionState.InputType.None);
                this.requestFocus.invoke();
            }
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onCancel() {
            onDragStop();
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onDown-k-4lQ0M(long point) {
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onDrag-k-4lQ0M(long delta) {
            int z;
            int startOffset;
            int i3;
            int offsetForPosition-3MmeM6k;
            int offsetForPosition-3MmeM6k2;
            int i5;
            SelectionAdjustment word;
            long newSelection;
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState this$0;
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState selection;
            int dragBeginOffsetInText2;
            int start-impl2;
            int start-impl;
            Handle newMiddle;
            TransformedTextFieldState collapsed-impl;
            long l;
            long dragBeginOffsetInText;
            int selectionStart;
            int intValue;
            int end-impl;
            int i;
            int i2;
            int i7;
            int i4;
            int i6;
            SelectionAdjustment selectionAdjustment;
            final Object obj = this;
            if (TextFieldSelectionState.access$getEnabled$p(obj.this$0)) {
                i5 = 0;
                z = (CharSequence)TextFieldSelectionState.access$getTextFieldState$p(obj.this$0).getVisualText().length() == 0 ? i3 : i5;
                if (z != 0) {
                    l = delta;
                } else {
                    obj.dragTotalDistance = Offset.plus-MK-Hz9U(obj.dragTotalDistance, obj5);
                    final long plus-MK-Hz9U2 = Offset.plus-MK-Hz9U(obj.dragBeginPosition, obj5);
                    TextFieldSelectionState.TextFieldTextDragObserver.onDrag.1 anon = new TextFieldSelectionState.TextFieldTextDragObserver.onDrag.1(plus-MK-Hz9U2, obj12);
                    TextFieldSelectionStateKt.access$logDebug((Function0)anon);
                    int i8 = 0;
                    this$0 = 0;
                    selection = 0;
                    if (obj.dragBeginOffsetInText < 0 && !TextFieldSelectionState.access$getTextLayoutState$p(obj.this$0).isPositionOnText-k-4lQ0M(plus-MK-Hz9U2)) {
                        if (!TextFieldSelectionState.access$getTextLayoutState$p(obj.this$0).isPositionOnText-k-4lQ0M(plus-MK-Hz9U2)) {
                            startOffset = TextLayoutState.getOffsetForPosition-3MmeM6k$default(TextFieldSelectionState.access$getTextLayoutState$p(obj.this$0), obj.dragBeginPosition, obj15, 0, 2);
                            offsetForPosition-3MmeM6k = TextLayoutState.getOffsetForPosition-3MmeM6k$default(TextFieldSelectionState.access$getTextLayoutState$p(obj.this$0), plus-MK-Hz9U2, obj12, 0, 2);
                            if (startOffset == offsetForPosition-3MmeM6k) {
                                word = SelectionAdjustment.Companion.getNone();
                            } else {
                                word = SelectionAdjustment.Companion.getWord();
                            }
                            i7 = startOffset;
                            i4 = offsetForPosition-3MmeM6k;
                            selectionAdjustment = word;
                        } else {
                            intValue = (Number)Integer.valueOf(obj.dragBeginOffsetInText).intValue();
                            end-impl = 0;
                            if (intValue >= 0) {
                            } else {
                                i3 = i5;
                            }
                            if (i3 != 0) {
                            } else {
                                dragBeginOffsetInText = 0;
                            }
                            if (dragBeginOffsetInText != 0) {
                                offsetForPosition-3MmeM6k2 = dragBeginOffsetInText.intValue();
                            } else {
                                offsetForPosition-3MmeM6k2 = TextFieldSelectionState.access$getTextLayoutState$p(obj.this$0).getOffsetForPosition-3MmeM6k(obj.dragBeginPosition, intValue);
                            }
                            startOffset = offsetForPosition-3MmeM6k2;
                            offsetForPosition-3MmeM6k = TextFieldSelectionState.access$getTextLayoutState$p(obj.this$0).getOffsetForPosition-3MmeM6k(plus-MK-Hz9U2, obj12);
                            if (obj.dragBeginOffsetInText < 0 && startOffset == offsetForPosition-3MmeM6k) {
                                if (startOffset == offsetForPosition-3MmeM6k) {
                                }
                            }
                            obj.this$0.updateTextToolbarState(TextToolbarState.Selection);
                            i7 = startOffset;
                            i4 = offsetForPosition-3MmeM6k;
                            selectionAdjustment = word;
                        }
                    } else {
                    }
                    long selection-d9O1mEE = TextFieldSelectionState.access$getTextFieldState$p(obj.this$0).getVisualText().getSelection-d9O1mEE();
                    newSelection = TextFieldSelectionState.updateSelection-SsL-Rf8$default(obj.this$0, TextFieldSelectionState.access$getTextFieldState$p(obj.this$0).getVisualText(), i7, i4, false, selectionAdjustment, false, false, 64, 0);
                    if (obj.dragBeginOffsetInText == -1 && !TextRange.getCollapsed-impl(newSelection)) {
                        if (!TextRange.getCollapsed-impl(newSelection)) {
                            obj.dragBeginOffsetInText = TextRange.getStart-impl(newSelection);
                        }
                    }
                    if (TextRange.getReversed-impl(newSelection)) {
                        newSelection = TextFieldSelectionStateKt.access$reverse-5zc-tL8(newSelection);
                    }
                    if (!TextRange.equals-impl0(newSelection, this$0)) {
                        if (TextRange.getStart-impl(newSelection) != TextRange.getStart-impl(selection-d9O1mEE) && TextRange.getEnd-impl(newSelection) == TextRange.getEnd-impl(selection-d9O1mEE)) {
                            if (TextRange.getEnd-impl(newSelection) == TextRange.getEnd-impl(selection-d9O1mEE)) {
                                newMiddle = Handle.SelectionStart;
                            } else {
                                if (TextRange.getStart-impl(newSelection) == TextRange.getStart-impl(selection-d9O1mEE) && TextRange.getEnd-impl(newSelection) != TextRange.getEnd-impl(selection-d9O1mEE)) {
                                    newMiddle = TextRange.getEnd-impl(newSelection) != TextRange.getEnd-impl(selection-d9O1mEE) ? Handle.SelectionEnd : cmp > 0 ? selectionStart : selectionStart;
                                } else {
                                }
                            }
                        } else {
                        }
                        obj.actingHandle = newMiddle;
                    }
                    if (!TextRange.getCollapsed-impl(selection-d9O1mEE)) {
                        if (!TextRange.getCollapsed-impl(newSelection)) {
                            TextFieldSelectionState.access$getTextFieldState$p(obj.this$0).selectCharsIn-5zc-tL8(newSelection);
                        }
                    } else {
                    }
                }
                obj.this$0.updateHandleDragging-Uv8p0NA(obj.actingHandle, plus-MK-Hz9U2);
            }
            l = delta;
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onStart-k-4lQ0M(long startPoint) {
            int offsetForPosition-3MmeM6k$default2;
            Object this$0;
            long textHandleMove-5zf0vsI;
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState start-impl;
            int selection;
            int i2;
            int i3;
            int i4;
            int this$02;
            TextFieldCharSequence textFieldCharSequence;
            int offsetForPosition-3MmeM6k$default;
            int i5;
            int i8;
            SelectionAdjustment word;
            TextRange textRange;
            int i;
            int i6;
            int i7;
            int i9;
            final Object obj = this;
            long l = startPoint;
            if (!TextFieldSelectionState.access$getEnabled$p(obj.this$0)) {
            }
            TextFieldSelectionState.TextFieldTextDragObserver.onStart.1 anon = new TextFieldSelectionState.TextFieldTextDragObserver.onStart.1(l, obj3);
            TextFieldSelectionStateKt.access$logDebug((Function0)anon);
            obj.this$0.updateHandleDragging-Uv8p0NA(obj.actingHandle, l);
            TextFieldSelectionState.access$setShowCursorHandle(obj.this$0, false);
            obj.this$0.setDirectDragGestureInitiator(TextFieldSelectionState.InputType.Touch);
            obj.dragBeginPosition = l;
            obj.dragTotalDistance = Offset.Companion.getZero-F1C5BW0();
            TextFieldSelectionState.access$setPreviousRawDragOffset$p(obj.this$0, -1);
            this$02 = 1;
            if (!TextFieldSelectionState.access$getTextLayoutState$p(obj.this$0).isPositionOnText-k-4lQ0M(l)) {
                HapticFeedback hapticFeedback = TextFieldSelectionState.access$getHapticFeedBack$p(obj.this$0);
                if (hapticFeedback != null) {
                    hapticFeedback.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
                }
                TextFieldSelectionState.access$getTextFieldState$p(obj.this$0).placeCursorBeforeCharAt(TextLayoutState.getOffsetForPosition-3MmeM6k$default(TextFieldSelectionState.access$getTextLayoutState$p(obj.this$0), l, obj3, 0, 2));
                TextFieldSelectionState.access$setShowCursorHandle(obj.this$0, this$02);
                obj.this$0.updateTextToolbarState(TextToolbarState.Cursor);
            } else {
                if ((CharSequence)TextFieldSelectionState.access$getTextFieldState$p(obj.this$0).getVisualText().length() == 0) {
                    i2 = this$02;
                }
                if (i2 != 0) {
                }
                this$0 = startPoint;
                offsetForPosition-3MmeM6k$default = TextLayoutState.getOffsetForPosition-3MmeM6k$default(TextFieldSelectionState.access$getTextLayoutState$p(obj.this$0), this$0, obj3, 0, 2);
                super((CharSequence)TextFieldSelectionState.access$getTextFieldState$p(obj.this$0).getVisualText(), TextRange.Companion.getZero-d9O1mEE(), obj13, 0, 0, 12, 0);
                offsetForPosition-3MmeM6k$default2 = TextFieldSelectionState.updateSelection-SsL-Rf8$default(obj.this$0, textFieldCharSequence, offsetForPosition-3MmeM6k$default, offsetForPosition-3MmeM6k$default, false, SelectionAdjustment.Companion.getWord(), false, false, 96, 0);
                TextFieldSelectionState.access$getTextFieldState$p(obj.this$0).selectCharsIn-5zc-tL8(offsetForPosition-3MmeM6k$default2);
                obj.this$0.updateTextToolbarState(TextToolbarState.Selection);
                obj.dragBeginOffsetInText = TextRange.getStart-impl(offsetForPosition-3MmeM6k$default2);
            }
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onStop() {
            onDragStop();
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onUp() {
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int ordinal4;
            int ordinal3;
            int[] iArr = new int[values.length];
            iArr[IndexTransformationType.Untransformed.ordinal()] = 1;
            iArr[IndexTransformationType.Deletion.ordinal()] = 2;
            iArr[IndexTransformationType.Insertion.ordinal()] = 3;
            iArr[IndexTransformationType.Replacement.ordinal()] = 4;
            TextFieldSelectionState.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        final int i = 8;
    }

    public TextFieldSelectionState(TransformedTextFieldState textFieldState, TextLayoutState textLayoutState, Density density, boolean enabled, boolean readOnly, boolean isFocused, boolean isPassword) {
        super();
        this.textFieldState = textFieldState;
        this.textLayoutState = textLayoutState;
        this.density = density;
        this.enabled = enabled;
        this.readOnly = readOnly;
        this.isFocused = isFocused;
        this.isPassword = isPassword;
        final int i4 = 0;
        final int i5 = 2;
        this.isInTouchMode$delegate = SnapshotStateKt.mutableStateOf$default(true, i4, i5, i4);
        this.startTextLayoutPositionInWindow$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getUnspecified-F1C5BW0()), i4, i5, i4);
        this.rawHandleDragPosition$delegate = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getUnspecified-F1C5BW0()), i4, i5, i4);
        this.draggingHandle$delegate = SnapshotStateKt.mutableStateOf$default(i4, i4, i5, i4);
        this.directDragGestureInitiator$delegate = SnapshotStateKt.mutableStateOf$default(TextFieldSelectionState.InputType.None, i4, i5, i4);
        this.showCursorHandle$delegate = SnapshotStateKt.mutableStateOf$default(false, i4, i5, i4);
        this.textToolbarState$delegate = SnapshotStateKt.mutableStateOf$default(TextToolbarState.None, i4, i5, i4);
        int i3 = -1;
    }

    public static final Object access$detectCursorHandleDragGestures(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this, PointerInputScope $receiver, Continuation $completion) {
        return $this.detectCursorHandleDragGestures($receiver, $completion);
    }

    public static final void access$detectCursorHandleDragGestures$onDragStop(Ref.LongRef cursorDragStart, Ref.LongRef cursorDragDelta, androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState this$0) {
        TextFieldSelectionState.detectCursorHandleDragGestures$onDragStop(cursorDragStart, cursorDragDelta, this$0);
    }

    public static final Object access$detectSelectionHandleDragGestures(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this, PointerInputScope $receiver, boolean isStartHandle, Continuation $completion) {
        return $this.detectSelectionHandleDragGestures($receiver, isStartHandle, $completion);
    }

    public static final void access$detectSelectionHandleDragGestures$onDragStop$5(Ref.LongRef dragBeginPosition, androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState this$0, Ref.LongRef dragTotalDistance) {
        TextFieldSelectionState.detectSelectionHandleDragGestures$onDragStop$5(dragBeginPosition, this$0, dragTotalDistance);
    }

    public static final Rect access$getContentRect(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this) {
        return $this.getContentRect();
    }

    public static final boolean access$getEnabled$p(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this) {
        return $this.enabled;
    }

    public static final long access$getHandlePosition-tuRUvjQ(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this, boolean isStartHandle) {
        return $this.getHandlePosition-tuRUvjQ(isStartHandle);
    }

    public static final HapticFeedback access$getHapticFeedBack$p(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this) {
        return $this.hapticFeedBack;
    }

    public static final PressInteraction.Press access$getPressInteraction$p(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this) {
        return $this.pressInteraction;
    }

    public static final boolean access$getReadOnly$p(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this) {
        return $this.readOnly;
    }

    public static final TransformedTextFieldState access$getTextFieldState$p(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this) {
        return $this.textFieldState;
    }

    public static final LayoutCoordinates access$getTextLayoutCoordinates(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this) {
        return $this.getTextLayoutCoordinates();
    }

    public static final TextLayoutState access$getTextLayoutState$p(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this) {
        return $this.textLayoutState;
    }

    public static final androidx.compose.foundation.text.input.internal.selection.TextToolbarState access$getTextToolbarState(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this) {
        return $this.getTextToolbarState();
    }

    public static final void access$hideTextToolbar(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this) {
        $this.hideTextToolbar();
    }

    public static final void access$markStartContentVisibleOffset(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this) {
        $this.markStartContentVisibleOffset();
    }

    public static final Object access$observeTextChanges(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this, Continuation $completion) {
        return $this.observeTextChanges($completion);
    }

    public static final Object access$observeTextToolbarVisibility(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this, Continuation $completion) {
        return $this.observeTextToolbarVisibility($completion);
    }

    public static final boolean access$placeCursorAtNearestOffset-k-4lQ0M(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this, long offset) {
        return $this.placeCursorAtNearestOffset-k-4lQ0M(offset);
    }

    public static final void access$setPressInteraction$p(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this, PressInteraction.Press <set-?>) {
        $this.pressInteraction = <set-?>;
    }

    public static final void access$setPreviousRawDragOffset$p(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this, int <set-?>) {
        $this.previousRawDragOffset = <set-?>;
    }

    public static final void access$setShowCursorHandle(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this, boolean <set-?>) {
        $this.setShowCursorHandle(<set-?>);
    }

    public static final void access$setTextToolbarState(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this, androidx.compose.foundation.text.input.internal.selection.TextToolbarState <set-?>) {
        $this.setTextToolbarState(<set-?>);
    }

    public static final void access$showTextToolbar(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this, Rect contentRect) {
        $this.showTextToolbar(contentRect);
    }

    public static final long access$updateSelection-SsL-Rf8(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState $this, TextFieldCharSequence textFieldCharSequence, int startOffset, int endOffset, boolean isStartHandle, SelectionAdjustment adjustment, boolean allowPreviousSelectionCollapsed, boolean isStartOfSelection) {
        return $this.updateSelection-SsL-Rf8(textFieldCharSequence, startOffset, endOffset, isStartHandle, adjustment, allowPreviousSelectionCollapsed, isStartOfSelection);
    }

    public static void copy$default(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState textFieldSelectionState, boolean z2, int i3, Object object4) {
        int obj1;
        final int obj3 = 1;
        if (i3 &= obj3 != 0) {
            obj1 = obj3;
        }
        textFieldSelectionState.copy(obj1);
    }

    private final Object detectCursorHandleDragGestures(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation2) {
        boolean anon4;
        Object cOROUTINE_SUSPENDED;
        Ref.LongRef num;
        Object obj;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState field;
        Object obj3;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures.3 anon2;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures.4 anon;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures.5 anon3;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState field2;
        Ref.LongRef num2;
        int i;
        Object obj11;
        Object obj12;
        anon4 = continuation2;
        field = Integer.MIN_VALUE;
        if (continuation2 instanceof TextFieldSelectionState.detectCursorHandleDragGestures.1 && label &= field != 0) {
            anon4 = continuation2;
            field = Integer.MIN_VALUE;
            if (label &= field != 0) {
                anon4.label = obj12 -= field;
            } else {
                anon4 = new TextFieldSelectionState.detectCursorHandleDragGestures.1(this, continuation2);
            }
        } else {
        }
        final androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures.1 field3 = anon4;
        obj12 = field3.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj12);
                field2 = this;
                obj11 = new Ref.LongRef();
                obj11.element = Offset.Companion.getUnspecified-F1C5BW0();
                Ref.LongRef longRef = new Ref.LongRef();
                num2 = longRef;
                num2.element = Offset.Companion.getUnspecified-F1C5BW0();
                TextFieldSelectionState.detectCursorHandleDragGestures.2 anon5 = new TextFieldSelectionState.detectCursorHandleDragGestures.2(obj11, field2, num2);
                anon2 = new TextFieldSelectionState.detectCursorHandleDragGestures.3(obj11, num2, field2);
                anon = new TextFieldSelectionState.detectCursorHandleDragGestures.4(obj11, num2, field2);
                anon3 = new TextFieldSelectionState.detectCursorHandleDragGestures.5(num2, field2, obj11);
                field3.L$0 = field2;
                field3.L$1 = obj11;
                field3.L$2 = num2;
                field3.label = 1;
                return cOROUTINE_SUSPENDED;
                obj = obj11;
                obj3 = field2;
                obj11 = num2;
                break;
            case 1:
                obj11 = field3.L$2;
                obj = l$1;
                obj3 = cOROUTINE_SUSPENDED;
                ResultKt.throwOnFailure(obj12);
                break;
            default:
                obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj11;
        }
        TextFieldSelectionState.detectCursorHandleDragGestures$onDragStop(obj, obj11, obj3);
        return Unit.INSTANCE;
    }

    private static final void detectCursorHandleDragGestures$onDragStop(Ref.LongRef cursorDragStart, Ref.LongRef cursorDragDelta, androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState this$0) {
        boolean specified-k-4lQ0M;
        if (OffsetKt.isSpecified-k-4lQ0M(cursorDragStart.element)) {
            cursorDragStart.element = Offset.Companion.getUnspecified-F1C5BW0();
            cursorDragDelta.element = Offset.Companion.getUnspecified-F1C5BW0();
            this$0.clearHandleDragging();
        }
    }

    private final Object detectSelectionHandleDragGestures(PointerInputScope pointerInputScope, boolean z2, Continuation<? super Unit> continuation3) {
        Object obj2;
        Object cOROUTINE_SUSPENDED;
        boolean anon2;
        Handle handle;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState field;
        Object obj3;
        Ref.LongRef num2;
        Object obj5;
        Ref.LongRef num4;
        Handle selectionStart;
        int i;
        Object obj4;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState field5;
        Object obj;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.6 draggingHandle;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.5 anon;
        Ref.LongRef dragTotalDistance;
        Ref.LongRef num3;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState field4;
        int handle3;
        Handle handle2;
        Handle dragBeginPosition2;
        Handle dragBeginPosition;
        Ref.LongRef num;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.3 field2;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.4 field3;
        obj2 = continuation3;
        anon2 = obj2;
        num2 = Integer.MIN_VALUE;
        if (obj2 instanceof TextFieldSelectionState.detectSelectionHandleDragGestures.1 && label2 &= num2 != 0) {
            anon2 = obj2;
            num2 = Integer.MIN_VALUE;
            if (label2 &= num2 != 0) {
                anon2.label = label -= num2;
                field = this;
            } else {
                anon2 = new TextFieldSelectionState.detectSelectionHandleDragGestures.1(this, obj2);
            }
        } else {
        }
        final androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures.1 field10 = anon2;
        Object result = field10.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure(result);
                field4 = this;
                Handle obj6 = z2;
                Ref.LongRef longRef = new Ref.LongRef();
                longRef.element = Offset.Companion.getUnspecified-F1C5BW0();
                Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = Offset.Companion.getZero-F1C5BW0();
                selectionStart = Handle.SelectionStart;
                selectionStart = Handle.SelectionEnd;
                Handle handle4 = selectionStart;
                int i2 = 1;
                num3 = longRef;
                dragBeginPosition = handle4;
                handle3 = i2;
                num3 = longRef;
                dragBeginPosition = handle4;
                handle3 = i;
                TextFieldSelectionState.detectSelectionHandleDragGestures.2 anon4 = new TextFieldSelectionState.detectSelectionHandleDragGestures.2(num3, field4, handle3, dragBeginPosition, longRef2);
                TextFieldSelectionState.detectSelectionHandleDragGestures.3 anon5 = new TextFieldSelectionState.detectSelectionHandleDragGestures.3(num3, field4, longRef2);
                TextFieldSelectionState.detectSelectionHandleDragGestures.4 anon6 = new TextFieldSelectionState.detectSelectionHandleDragGestures.4(num3, field4, longRef2);
                i = i2;
                handle2 = dragBeginPosition;
                Ref.LongRef handle5 = num3;
                Ref.LongRef dragBeginPosition3 = longRef2;
                anon = new TextFieldSelectionState.detectSelectionHandleDragGestures.5(dragBeginPosition3, field4, handle2, handle5, i);
                num = dragBeginPosition3;
                dragTotalDistance = handle5;
                dragBeginPosition2 = handle2;
                field10.L$0 = field4;
                field10.L$1 = dragTotalDistance;
                field10.L$2 = num;
                field10.L$3 = dragBeginPosition2;
                field10.label = i2;
                return cOROUTINE_SUSPENDED;
                obj4 = dragTotalDistance;
                obj = field4;
                obj3 = dragBeginPosition2;
                obj5 = num;
                break;
            case 1:
                obj3 = l$3;
                obj5 = l$2;
                obj4 = l$1;
                obj = cOROUTINE_SUSPENDED;
                ResultKt.throwOnFailure(result);
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw illegalStateException;
        }
        TextFieldSelectionState.detectSelectionHandleDragGestures.6 anon3 = new TextFieldSelectionState.detectSelectionHandleDragGestures.6(obj, obj3);
        TextFieldSelectionStateKt.access$logDebug((Function0)anon3);
        if (obj.getDraggingHandle() == obj3) {
            TextFieldSelectionState.detectSelectionHandleDragGestures$onDragStop$5(obj4, obj, obj5);
        }
        return Unit.INSTANCE;
    }

    private static final void detectSelectionHandleDragGestures$onDragStop$5(Ref.LongRef dragBeginPosition, androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState this$0, Ref.LongRef dragTotalDistance) {
        boolean specified-k-4lQ0M;
        if (OffsetKt.isSpecified-k-4lQ0M(dragBeginPosition.element)) {
            this$0.clearHandleDragging();
            dragBeginPosition.element = Offset.Companion.getUnspecified-F1C5BW0();
            dragTotalDistance.element = Offset.Companion.getZero-F1C5BW0();
            this$0.previousRawDragOffset = -1;
        }
    }

    private final Rect getContentRect() {
        long localToRoot-MK-Hz9U2;
        long localToRoot-MK-Hz9U4;
        long handlePosition-tuRUvjQ2;
        long topLeft-F1C5BW0;
        long localToRoot-MK-Hz9U;
        long handlePosition-tuRUvjQ;
        int y-impl2;
        int y-impl;
        Object layoutResult2;
        int top;
        long localToRoot-MK-Hz9U3;
        int start-impl;
        Object layoutResult;
        int top2;
        long end-impl;
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (TextRange.getCollapsed-impl(visualText.getSelection-d9O1mEE())) {
            Rect cursorRect = getCursorRect();
            LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
            if (textLayoutCoordinates2 != null) {
                localToRoot-MK-Hz9U4 = textLayoutCoordinates2.localToRoot-MK-Hz9U(cursorRect.getTopLeft-F1C5BW0());
            } else {
                localToRoot-MK-Hz9U4 = Offset.Companion.getZero-F1C5BW0();
            }
            return RectKt.Rect-tz77jQw(localToRoot-MK-Hz9U4, topLeft-F1C5BW0);
        }
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        if (textLayoutCoordinates != null) {
            localToRoot-MK-Hz9U2 = textLayoutCoordinates.localToRoot-MK-Hz9U(getHandlePosition-tuRUvjQ(true));
        } else {
            localToRoot-MK-Hz9U2 = Offset.Companion.getZero-F1C5BW0();
        }
        LayoutCoordinates textLayoutCoordinates3 = getTextLayoutCoordinates();
        if (textLayoutCoordinates3 != null) {
            localToRoot-MK-Hz9U = textLayoutCoordinates3.localToRoot-MK-Hz9U(getHandlePosition-tuRUvjQ(false));
        } else {
            localToRoot-MK-Hz9U = Offset.Companion.getZero-F1C5BW0();
        }
        LayoutCoordinates textLayoutCoordinates4 = getTextLayoutCoordinates();
        y-impl = 0;
        if (textLayoutCoordinates4 != null) {
            layoutResult2 = this.textLayoutState.getLayoutResult();
            layoutResult2 = layoutResult2.getCursorRect(TextRange.getStart-impl(visualText.getSelection-d9O1mEE()));
            if (layoutResult2 != null && layoutResult2 != null) {
                layoutResult2 = layoutResult2.getCursorRect(TextRange.getStart-impl(visualText.getSelection-d9O1mEE()));
                if (layoutResult2 != null) {
                    top = layoutResult2.getTop();
                } else {
                    top = y-impl;
                }
            } else {
            }
            y-impl2 = Offset.getY-impl(textLayoutCoordinates4.localToRoot-MK-Hz9U(OffsetKt.Offset(y-impl, top)));
        } else {
            y-impl2 = y-impl;
        }
        LayoutCoordinates textLayoutCoordinates5 = getTextLayoutCoordinates();
        if (textLayoutCoordinates5 != null) {
            layoutResult = this.textLayoutState.getLayoutResult();
            layoutResult = layoutResult.getCursorRect(TextRange.getEnd-impl(visualText.getSelection-d9O1mEE()));
            if (layoutResult != null && layoutResult != null) {
                layoutResult = layoutResult.getCursorRect(TextRange.getEnd-impl(visualText.getSelection-d9O1mEE()));
                if (layoutResult != null) {
                    top2 = layoutResult.getTop();
                } else {
                    top2 = y-impl;
                }
            } else {
            }
            y-impl = Offset.getY-impl(textLayoutCoordinates5.localToRoot-MK-Hz9U(OffsetKt.Offset(y-impl, top2)));
        } else {
        }
        Rect rect2 = new Rect(Math.min(Offset.getX-impl(localToRoot-MK-Hz9U2), Offset.getX-impl(localToRoot-MK-Hz9U)), Math.min(y-impl2, y-impl), Math.max(Offset.getX-impl(localToRoot-MK-Hz9U2), Offset.getX-impl(localToRoot-MK-Hz9U)), Math.max(Offset.getY-impl(localToRoot-MK-Hz9U2), Offset.getY-impl(localToRoot-MK-Hz9U)));
        return rect2;
    }

    private final long getCurrentTextLayoutPositionInWindow-F1C5BW0() {
        long positionInWindow;
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        if (textLayoutCoordinates != null) {
            positionInWindow = LayoutCoordinatesKt.positionInWindow(textLayoutCoordinates);
        } else {
            positionInWindow = Offset.Companion.getUnspecified-F1C5BW0();
        }
        return positionInWindow;
    }

    private final boolean getEditable() {
        boolean readOnly;
        int i;
        if (this.enabled && !this.readOnly) {
            i = !this.readOnly ? 1 : 0;
        } else {
        }
        return i;
    }

    private final long getHandlePosition-tuRUvjQ(boolean isStartHandle) {
        int start-impl;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Offset.Companion.getZero-F1C5BW0();
        }
        long selection-d9O1mEE = this.textFieldState.getVisualText().getSelection-d9O1mEE();
        if (isStartHandle) {
            start-impl = TextRange.getStart-impl(selection-d9O1mEE);
        } else {
            start-impl = TextRange.getEnd-impl(selection-d9O1mEE);
        }
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult, start-impl, isStartHandle, TextRange.getReversed-impl(selection-d9O1mEE));
    }

    private final long getRawHandleDragPosition-F1C5BW0() {
        final int i = 0;
        final int i2 = 0;
        return (Offset)(State)this.rawHandleDragPosition$delegate.getValue().unbox-impl();
    }

    private final boolean getShowCursorHandle() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.showCursorHandle$delegate.getValue().booleanValue();
    }

    private final long getStartTextLayoutPositionInWindow-F1C5BW0() {
        final int i = 0;
        final int i2 = 0;
        return (Offset)(State)this.startTextLayoutPositionInWindow$delegate.getValue().unbox-impl();
    }

    private final long getTextFieldSelection-qeG_v_k(int rawStartOffset, int rawEndOffset, TextRange previousSelection, boolean isStartHandle, SelectionAdjustment adjustment) {
        TextLayoutResult layoutResult;
        long zero-d9O1mEE;
        int i;
        int obj12;
        layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextRange.Companion.getZero-d9O1mEE();
        }
        if (previousSelection == null && Intrinsics.areEqual(adjustment, SelectionAdjustment.Companion.getCharacter())) {
            if (Intrinsics.areEqual(adjustment, SelectionAdjustment.Companion.getCharacter())) {
                return TextRangeKt.TextRange(rawStartOffset, rawEndOffset);
            }
        }
        if (previousSelection != null) {
            zero-d9O1mEE = previousSelection.unbox-impl();
        } else {
            zero-d9O1mEE = TextRange.Companion.getZero-d9O1mEE();
        }
        i = previousSelection == null ? 1 : 0;
        final int i2 = rawStartOffset;
        final int i3 = rawEndOffset;
        final boolean z = isStartHandle;
        final SelectionLayout obj11 = SelectionLayoutKt.getTextFieldSelectionLayout-RcvT-LA(layoutResult, i2, i3, this.previousRawDragOffset, zero-d9O1mEE, obj7, i);
        if (previousSelection != null && !obj11.shouldRecomputeSelection(this.previousSelectionLayout)) {
            if (!obj11.shouldRecomputeSelection(this.previousSelectionLayout)) {
                return previousSelection.unbox-impl();
            }
        }
        this.previousSelectionLayout = obj11;
        obj12 = z ? i2 : i3;
        this.previousRawDragOffset = obj12;
        return adjustment.adjust(obj11).toTextRange-d9O1mEE();
    }

    private final LayoutCoordinates getTextLayoutCoordinates() {
        int textLayoutNodeCoordinates;
        boolean it;
        int i;
        textLayoutNodeCoordinates = this.textLayoutState.getTextLayoutNodeCoordinates();
        i = 0;
        if (textLayoutNodeCoordinates != null && textLayoutNodeCoordinates.isAttached()) {
            i = 0;
            if (textLayoutNodeCoordinates.isAttached()) {
            } else {
                textLayoutNodeCoordinates = i2;
            }
        } else {
        }
        return textLayoutNodeCoordinates;
    }

    private final androidx.compose.foundation.text.input.internal.selection.TextToolbarState getTextToolbarState() {
        final int i = 0;
        final int i2 = 0;
        return (TextToolbarState)(State)this.textToolbarState$delegate.getValue();
    }

    private final void hideTextToolbar() {
        TextToolbarStatus textToolbar;
        TextToolbar textToolbar2 = this.textToolbar;
        if (textToolbar2 != null) {
            textToolbar = textToolbar2.getStatus();
        } else {
            textToolbar = 0;
        }
        textToolbar = this.textToolbar;
        if (textToolbar == TextToolbarStatus.Shown && textToolbar != null) {
            textToolbar = this.textToolbar;
            if (textToolbar != null) {
                textToolbar.hide();
            }
        }
    }

    private final boolean isCursorHandleInVisibleBounds() {
        int inclusive-Uv8p0NA;
        Object textLayoutCoordinates;
        int readObserver;
        Snapshot.Companion companion = Snapshot.Companion;
        final int i = 0;
        final Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        if (currentThreadSnapshot != null) {
            readObserver = currentThreadSnapshot.getReadObserver();
        } else {
            readObserver = 0;
        }
        final int i2 = 0;
        companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), readObserver);
        textLayoutCoordinates = getTextLayoutCoordinates();
        textLayoutCoordinates = SelectionManagerKt.visibleBounds(textLayoutCoordinates);
        if (textLayoutCoordinates != null && textLayoutCoordinates != null) {
            textLayoutCoordinates = SelectionManagerKt.visibleBounds(textLayoutCoordinates);
            if (textLayoutCoordinates != null) {
                inclusive-Uv8p0NA = SelectionManagerKt.containsInclusive-Uv8p0NA(textLayoutCoordinates, getCursorRect().getBottomCenter-F1C5BW0());
            } else {
                inclusive-Uv8p0NA = 0;
            }
        } else {
        }
        return inclusive-Uv8p0NA;
    }

    private final void markStartContentVisibleOffset() {
        setStartTextLayoutPositionInWindow-k-4lQ0M(getCurrentTextLayoutPositionInWindow-F1C5BW0());
    }

    private final Function0<Unit> menuItem(boolean enabled, androidx.compose.foundation.text.input.internal.selection.TextToolbarState desiredState, Function0<Unit> operation) {
        int anon;
        final int i = 0;
        if (!enabled) {
            anon = 0;
        } else {
            anon = new TextFieldSelectionState.menuItem.1(operation, this, desiredState);
        }
        return anon;
    }

    private final Object observeTextChanges(Continuation<? super Unit> $completion) {
        TextFieldSelectionState.observeTextChanges.2 anon = new TextFieldSelectionState.observeTextChanges.2(this);
        TextFieldSelectionState.observeTextChanges.4 anon2 = new TextFieldSelectionState.observeTextChanges.4(this);
        Object collect = FlowKt.drop(FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow((Function0)anon), (Function2)TextFieldSelectionState.observeTextChanges.3.INSTANCE), 1).collect((FlowCollector)anon2, $completion);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    private final Object observeTextToolbarVisibility(Continuation<? super Unit> $completion) {
        TextFieldSelectionState.observeTextToolbarVisibility.2 anon = new TextFieldSelectionState.observeTextToolbarVisibility.2(this);
        TextFieldSelectionState.observeTextToolbarVisibility.3 anon2 = new TextFieldSelectionState.observeTextToolbarVisibility.3(this);
        Object collect = SnapshotStateKt.snapshotFlow((Function0)anon).collect((FlowCollector)anon2, $completion);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }

    private final void pasteAsPlainText() {
        Object clipboardManager;
        clipboardManager = this.clipboardManager;
        clipboardManager = clipboardManager.getText();
        clipboardManager = clipboardManager.getText();
        if (clipboardManager != null && clipboardManager != null && clipboardManager == null) {
            clipboardManager = clipboardManager.getText();
            if (clipboardManager != null) {
                clipboardManager = clipboardManager.getText();
                if (clipboardManager == null) {
                }
                TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, (CharSequence)clipboardManager, false, TextFieldEditUndoBehavior.NeverMerge, 2, 0);
            }
        }
    }

    private final boolean placeCursorAtNearestOffset-k-4lQ0M(long offset) {
        long selectionWedgeAffinity;
        long start;
        int cursorRect;
        boolean equal;
        TransformedTextFieldState textFieldState;
        int offsetForPosition-k-4lQ0M;
        int newAffinity;
        TransformedTextFieldState textFieldState2;
        IndexTransformationType untransformed;
        boolean collapsed-impl;
        boolean collapsed-impl3;
        boolean collapsed-impl2;
        int i2;
        int i;
        int start-impl;
        final Object obj = this;
        selectionWedgeAffinity = offset;
        TextLayoutResult layoutResult = obj.textLayoutState.getLayoutResult();
        cursorRect = 0;
        if (layoutResult == null) {
            return cursorRect;
        }
        offsetForPosition-k-4lQ0M = layoutResult.getOffsetForPosition-k-4lQ0M(selectionWedgeAffinity);
        if (offsetForPosition-k-4lQ0M == -1) {
            return cursorRect;
        }
        newAffinity = 0;
        textFieldState2 = obj.textFieldState;
        final int i5 = 0;
        final long mapFromTransformed--jx7JFs = textFieldState2.mapFromTransformed--jx7JFs(offsetForPosition-k-4lQ0M);
        final long mapToTransformed-GEjPoXI = textFieldState2.mapToTransformed-GEjPoXI(mapFromTransformed--jx7JFs);
        if (TextRange.getCollapsed-impl(mapFromTransformed--jx7JFs) && TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI)) {
            if (TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI)) {
                untransformed = IndexTransformationType.Untransformed;
            } else {
                if (!TextRange.getCollapsed-impl(mapFromTransformed--jx7JFs) && !TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI)) {
                    if (!TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI)) {
                        untransformed = IndexTransformationType.Replacement;
                    } else {
                        if (TextRange.getCollapsed-impl(mapFromTransformed--jx7JFs) && !TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI)) {
                            untransformed = !TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI) ? IndexTransformationType.Insertion : IndexTransformationType.Deletion;
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
        final long l2 = mapToTransformed-GEjPoXI;
        final long l3 = mapFromTransformed--jx7JFs;
        final int i6 = 0;
        switch (i7) {
            case 1:
                i2 = cursorRect;
                i = offsetForPosition-k-4lQ0M;
                start-impl = TextRange.getStart-impl(l3);
                break;
            case 2:
                i2 = cursorRect;
                i = offsetForPosition-k-4lQ0M;
                start-impl = TextRange.getStart-impl(l3);
                break;
            case 3:
                i2 = cursorRect;
                i = offsetForPosition-k-4lQ0M;
                selectionWedgeAffinity = new SelectionWedgeAffinity(WedgeAffinity.Start);
                selectionWedgeAffinity = new SelectionWedgeAffinity(WedgeAffinity.End);
                newAffinity = selectionWedgeAffinity;
                start-impl = TextRange.getStart-impl(l3);
                break;
            case 4:
                i2 = cursorRect;
                i = offsetForPosition-k-4lQ0M;
                start-impl = TextRange.getStart-impl(l3);
                start-impl = TextRange.getEnd-impl(l3);
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        long l = TextRangeKt.TextRange(start-impl);
        if (TextRange.equals-impl0(l, start) && newAffinity != 0 && Intrinsics.areEqual(newAffinity, obj.textFieldState.getSelectionWedgeAffinity())) {
            if (newAffinity != 0) {
                if (Intrinsics.areEqual(newAffinity, obj.textFieldState.getSelectionWedgeAffinity())) {
                }
            }
            return i2;
        }
        obj.textFieldState.selectUntransformedCharsIn-5zc-tL8(l);
        if (newAffinity != 0) {
            offsetForPosition-k-4lQ0M = 0;
            obj.textFieldState.setSelectionWedgeAffinity(newAffinity);
        }
        return 1;
    }

    private final void setRawHandleDragPosition-k-4lQ0M(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.rawHandleDragPosition$delegate.setValue(Offset.box-impl(<set-?>));
    }

    private final void setShowCursorHandle(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.showCursorHandle$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void setStartTextLayoutPositionInWindow-k-4lQ0M(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.startTextLayoutPositionInWindow$delegate.setValue(Offset.box-impl(<set-?>));
    }

    private final void setTextToolbarState(androidx.compose.foundation.text.input.internal.selection.TextToolbarState <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.textToolbarState$delegate.setValue(<set-?>);
    }

    private final void showTextToolbar(Rect contentRect) {
        Rect contentRect2;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.showTextToolbar$$inlined.menuItem.1 field;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.showTextToolbar$$inlined.menuItem.2 field3;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.showTextToolbar$$inlined.menuItem.3 field2;
        int anon2;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.showTextToolbar$$inlined.menuItem.1 anon;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.showTextToolbar$$inlined.menuItem.2 anon4;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.showTextToolbar$$inlined.menuItem.3 anon3;
        final TextToolbar textToolbar = this.textToolbar;
        if (textToolbar != null) {
            int i = 0;
            anon2 = 0;
            if (!canCopy()) {
                anon = anon2;
            } else {
                anon = new TextFieldSelectionState.showTextToolbar$$inlined.menuItem.1(this, TextToolbarState.None, this);
            }
            int i2 = 0;
            if (!canPaste()) {
                anon4 = anon2;
            } else {
                anon4 = new TextFieldSelectionState.showTextToolbar$$inlined.menuItem.2(this, TextToolbarState.None, this);
            }
            int i3 = 0;
            if (!canCut()) {
                anon3 = anon2;
            } else {
                anon3 = new TextFieldSelectionState.showTextToolbar$$inlined.menuItem.3(this, TextToolbarState.None, this);
            }
            int i4 = 0;
            if (!canSelectAll()) {
            } else {
                anon2 = new TextFieldSelectionState.showTextToolbar$$inlined.menuItem.4(this, TextToolbarState.Selection, this);
            }
            textToolbar.showMenu(contentRect, anon, anon4, anon3, anon2);
        } else {
            contentRect2 = contentRect;
        }
    }

    private final long updateSelection-SsL-Rf8(TextFieldCharSequence textFieldCharSequence, int startOffset, int endOffset, boolean isStartHandle, SelectionAdjustment adjustment, boolean allowPreviousSelectionCollapsed, boolean isStartOfSelection) {
        TextRange box-impl;
        int it;
        boolean reversed-impl;
        boolean hapticFeedBack;
        boolean textHandleMove-5zf0vsI;
        int i;
        boolean collapsed-impl;
        long selection-d9O1mEE;
        int end-impl;
        int start-impl;
        final int i3 = 0;
        if (!isStartOfSelection) {
            if (!allowPreviousSelectionCollapsed) {
                it = !TextRange.getCollapsed-impl(TextRange.box-impl(textFieldCharSequence.getSelection-d9O1mEE()).unbox-impl()) ? i : i3;
            } else {
            }
        } else {
        }
        if (it != 0) {
        } else {
            box-impl = 0;
        }
        end-impl = endOffset;
        long textFieldSelection-qeG_v_k = this.getTextFieldSelection-qeG_v_k(startOffset, end-impl, box-impl, isStartHandle, adjustment);
        if (TextRange.equals-impl0(textFieldSelection-qeG_v_k, it)) {
            return textFieldSelection-qeG_v_k;
        }
        textHandleMove-5zf0vsI = TextRange.getReversed-impl(textFieldCharSequence.getSelection-d9O1mEE());
        long l = textFieldSelection-qeG_v_k;
        int i5 = 0;
        end-impl = TextRange.getEnd-impl(l);
        if (TextRange.getReversed-impl(textFieldSelection-qeG_v_k) != textHandleMove-5zf0vsI && TextRange.equals-impl0(TextRangeKt.TextRange(end-impl, TextRange.getStart-impl(l)), textHandleMove-5zf0vsI)) {
            l = textFieldSelection-qeG_v_k;
            i5 = 0;
            end-impl = TextRange.getEnd-impl(l);
            if (TextRange.equals-impl0(TextRangeKt.TextRange(end-impl, TextRange.getStart-impl(l)), textHandleMove-5zf0vsI)) {
            } else {
                i = i3;
            }
        } else {
        }
        hapticFeedBack = this.hapticFeedBack;
        if (isInTouchMode() && i == 0 && hapticFeedBack != null) {
            if (i == 0) {
                hapticFeedBack = this.hapticFeedBack;
                if (hapticFeedBack != null) {
                    hapticFeedBack.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
                }
            }
        }
        return textFieldSelection-qeG_v_k;
    }

    static long updateSelection-SsL-Rf8$default(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState textFieldSelectionState, TextFieldCharSequence textFieldCharSequence2, int i3, int i4, boolean z5, SelectionAdjustment selectionAdjustment6, boolean z7, boolean z8, int i9, Object object10) {
        int obj7;
        int obj8;
        final int i = 0;
        if (i9 & 32 != 0) {
            obj7 = i;
        }
        if (i9 &= 64 != 0) {
            obj8 = i;
        }
        return textFieldSelectionState.updateSelection-SsL-Rf8(textFieldCharSequence2, i3, i4, z5, selectionAdjustment6, obj7, obj8);
    }

    public final boolean canCopy() {
        boolean isPassword;
        int i;
        if (!TextRange.getCollapsed-impl(this.textFieldState.getVisualText().getSelection-d9O1mEE()) && !this.isPassword) {
            i = !this.isPassword ? 1 : 0;
        } else {
        }
        return i;
    }

    public final boolean canCut() {
        int i;
        boolean isPassword;
        if (!TextRange.getCollapsed-impl(this.textFieldState.getVisualText().getSelection-d9O1mEE()) && getEditable() && !this.isPassword) {
            if (getEditable()) {
                i = !this.isPassword ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public final boolean canPaste() {
        int i;
        Object clipboardManager;
        ClipboardManager clipboardManager2;
        int i2;
        int clip;
        i2 = 0;
        if (!getEditable()) {
            return i2;
        }
        clipboardManager2 = this.clipboardManager;
        final int i3 = 1;
        if (clipboardManager2 != null && clipboardManager2.hasText() == i3) {
            i = clipboardManager2.hasText() == i3 ? i3 : i2;
        } else {
        }
        if (i != 0) {
            return i3;
        }
        Function0 receiveContentConfiguration = this.receiveContentConfiguration;
        if (receiveContentConfiguration != null) {
            clipboardManager = receiveContentConfiguration.invoke();
        } else {
            clipboardManager = clip;
        }
        clipboardManager = this.clipboardManager;
        if (clipboardManager != null && clipboardManager != null) {
            clipboardManager = this.clipboardManager;
            if (clipboardManager != null) {
                clip = clipboardManager.getClip();
            }
            if (clip != 0) {
                i2 = i3;
            }
        }
        return i2;
    }

    public final boolean canSelectAll() {
        int i;
        i = TextRange.getLength-impl(this.textFieldState.getVisualText().getSelection-d9O1mEE()) != this.textFieldState.getVisualText().length() ? 1 : 0;
        return i;
    }

    public final void clearHandleDragging() {
        setDraggingHandle(0);
        setRawHandleDragPosition-k-4lQ0M(Offset.Companion.getUnspecified-F1C5BW0());
        setStartTextLayoutPositionInWindow-k-4lQ0M(Offset.Companion.getUnspecified-F1C5BW0());
    }

    public final void copy(boolean cancelSelection) {
        long annotatedString;
        String string;
        int i4;
        int i;
        int i3;
        int i2;
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (TextRange.getCollapsed-impl(visualText.getSelection-d9O1mEE())) {
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            annotatedString = new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(visualText).toString(), 0, 0, 6, 0);
            clipboardManager.setText(annotatedString);
        }
        if (!cancelSelection) {
        }
        this.textFieldState.collapseSelectionToMax();
    }

    public final Object cursorHandleGestures(PointerInputScope $this$cursorHandleGestures, Continuation<? super Unit> $completion) {
        TextFieldSelectionState.cursorHandleGestures.2 anon = new TextFieldSelectionState.cursorHandleGestures.2(this, $this$cursorHandleGestures, 0);
        Object coroutineScope = CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
        if (coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    public final void cut() {
        long annotatedString;
        String string;
        int i;
        int i3;
        int i2;
        int i4;
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (TextRange.getCollapsed-impl(visualText.getSelection-d9O1mEE())) {
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            annotatedString = new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(visualText).toString(), 0, 0, 6, 0);
            clipboardManager.setText(annotatedString);
        }
        this.textFieldState.deleteSelectedText();
    }

    public final void deselect() {
        boolean textFieldState;
        if (!TextRange.getCollapsed-impl(this.textFieldState.getVisualText().getSelection-d9O1mEE())) {
            this.textFieldState.collapseSelectionToEnd();
        }
        setShowCursorHandle(false);
        updateTextToolbarState(TextToolbarState.None);
    }

    public final Object detectTextFieldTapGestures(PointerInputScope $this$detectTextFieldTapGestures, MutableInteractionSource interactionSource, Function0<Unit> requestFocus, Function0<Unit> showKeyboard, Continuation<? super Unit> $completion) {
        TextFieldSelectionState.detectTextFieldTapGestures.2 anon = new TextFieldSelectionState.detectTextFieldTapGestures.2(interactionSource, this, 0);
        TextFieldSelectionState.detectTextFieldTapGestures.3 anon2 = new TextFieldSelectionState.detectTextFieldTapGestures.3(requestFocus, this, showKeyboard);
        Object detectTapAndPress = TapGestureDetectorKt.detectTapAndPress($this$detectTextFieldTapGestures, (Function3)anon, (Function1)anon2, $completion);
        if (detectTapAndPress == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return detectTapAndPress;
        }
        return Unit.INSTANCE;
    }

    public final Object detectTouchMode(PointerInputScope $this$detectTouchMode, Continuation<? super Unit> $completion) {
        TextFieldSelectionState.detectTouchMode.2 anon = new TextFieldSelectionState.detectTouchMode.2(this, 0);
        Object awaitPointerEventScope = $this$detectTouchMode.awaitPointerEventScope((Function2)anon, $completion);
        if (awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return awaitPointerEventScope;
        }
        return Unit.INSTANCE;
    }

    public final void dispose() {
        hideTextToolbar();
        final int i = 0;
        this.textToolbar = i;
        this.clipboardManager = i;
        this.hapticFeedBack = i;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState getCursorHandleState$foundation_release(boolean includePosition) {
        int i;
        int i2;
        Object cursorRect;
        boolean cursorHandleInVisibleBounds;
        long bottomCenter-F1C5BW0;
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        i2 = 1;
        int i3 = 0;
        i = getDirectDragGestureInitiator() == TextFieldSelectionState.InputType.None ? i2 : i3;
        if (getShowCursorHandle() && i != 0 && TextRange.getCollapsed-impl(visualText.getSelection-d9O1mEE()) && visualText.shouldShowSelection()) {
            if (i != 0) {
                if (TextRange.getCollapsed-impl(visualText.getSelection-d9O1mEE())) {
                    if (visualText.shouldShowSelection()) {
                        cursorHandleInVisibleBounds = (CharSequence)visualText.length() > 0 ? i2 : i3;
                        if (cursorHandleInVisibleBounds != 0) {
                            if (getDraggingHandle() != Handle.Cursor) {
                                if (isCursorHandleInVisibleBounds()) {
                                } else {
                                    i2 = i3;
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (i2 == 0) {
            return TextFieldHandleState.Companion.getHidden();
        }
        if (includePosition) {
            bottomCenter-F1C5BW0 = getCursorRect().getBottomCenter-F1C5BW0();
        } else {
            bottomCenter-F1C5BW0 = Offset.Companion.getUnspecified-F1C5BW0();
        }
        TextFieldHandleState textFieldHandleState = new TextFieldHandleState(1, bottomCenter-F1C5BW0, obj9, ResolvedTextDirection.Ltr, 0, 0);
        return textFieldHandleState;
    }

    public final Rect getCursorRect() {
        int i2;
        int i;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Rect.Companion.getZero();
        }
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (!TextRange.getCollapsed-impl(visualText.getSelection-d9O1mEE())) {
            return Rect.Companion.getZero();
        }
        Rect cursorRect = layoutResult.getCursorRect(TextRange.getStart-impl(visualText.getSelection-d9O1mEE()));
        int i3 = 0;
        float $this$getCursorRect_u24lambda_u242 = this.density.toPx-0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
        int i5 = 2;
        if (layoutResult.getLayoutInput().getLayoutDirection() == LayoutDirection.Ltr) {
            left += i;
        } else {
            right -= i;
        }
        float f4 = (float)i5;
        float coerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(i2, f -= i8), $this$getCursorRect_u24lambda_u242 / f4);
        Rect rect = new Rect(coerceAtLeast - i10, cursorRect.getTop(), i6 += coerceAtLeast, cursorRect.getBottom());
        return rect;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.InputType getDirectDragGestureInitiator() {
        final int i = 0;
        final int i2 = 0;
        return (TextFieldSelectionState.InputType)(State)this.directDragGestureInitiator$delegate.getValue();
    }

    public final Handle getDraggingHandle() {
        final int i = 0;
        final int i2 = 0;
        return (Handle)(State)this.draggingHandle$delegate.getValue();
    }

    public final long getHandleDragPosition-F1C5BW0() {
        long decorationToTextLayout-Uv8p0NA;
        long rawHandleDragPosition-F1C5BW0;
        long minus-MK-Hz9U;
        long currentTextLayoutPositionInWindow-F1C5BW0;
        if (OffsetKt.isUnspecified-k-4lQ0M(getRawHandleDragPosition-F1C5BW0())) {
            decorationToTextLayout-Uv8p0NA = Offset.Companion.getUnspecified-F1C5BW0();
        } else {
            if (OffsetKt.isUnspecified-k-4lQ0M(getStartTextLayoutPositionInWindow-F1C5BW0())) {
                decorationToTextLayout-Uv8p0NA = TextLayoutStateKt.fromDecorationToTextLayout-Uv8p0NA(this.textLayoutState, getRawHandleDragPosition-F1C5BW0());
            } else {
                decorationToTextLayout-Uv8p0NA = Offset.plus-MK-Hz9U(getRawHandleDragPosition-F1C5BW0(), obj1);
            }
        }
        return decorationToTextLayout-Uv8p0NA;
    }

    public final Function0<ReceiveContentConfiguration> getReceiveContentConfiguration() {
        return this.receiveContentConfiguration;
    }

    public final androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState getSelectionHandleState$foundation_release(boolean isStartHandle, boolean includePosition) {
        Handle selectionStart;
        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.InputType directDragGestureInitiator;
        Object textLayoutCoordinates;
        int i;
        int start-impl;
        Object it;
        int i2;
        long l;
        final Object obj = this;
        selectionStart = isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd;
        TextLayoutResult layoutResult = obj.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextFieldHandleState.Companion.getHidden();
        }
        long selection-d9O1mEE = obj.textFieldState.getVisualText().getSelection-d9O1mEE();
        if (TextRange.getCollapsed-impl(selection-d9O1mEE)) {
            return TextFieldHandleState.Companion.getHidden();
        }
        long handlePosition-tuRUvjQ = getHandlePosition-tuRUvjQ(isStartHandle);
        int i4 = 1;
        i2 = 0;
        if (obj.getDirectDragGestureInitiator() == TextFieldSelectionState.InputType.None) {
            if (obj.getDraggingHandle() != selectionStart) {
                textLayoutCoordinates = obj.getTextLayoutCoordinates();
                textLayoutCoordinates = SelectionManagerKt.visibleBounds(textLayoutCoordinates);
                if (textLayoutCoordinates != null && textLayoutCoordinates != null) {
                    textLayoutCoordinates = SelectionManagerKt.visibleBounds(textLayoutCoordinates);
                    if (textLayoutCoordinates != null) {
                        directDragGestureInitiator = SelectionManagerKt.containsInclusive-Uv8p0NA(textLayoutCoordinates, handlePosition-tuRUvjQ);
                    } else {
                        directDragGestureInitiator = i2;
                    }
                } else {
                }
                i = directDragGestureInitiator != 0 ? i4 : i2;
            } else {
            }
        } else {
        }
        if (i == 0) {
            return TextFieldHandleState.Companion.getHidden();
        }
        if (!obj.textFieldState.getVisualText().shouldShowSelection()) {
            return TextFieldHandleState.Companion.getHidden();
        }
        if (isStartHandle) {
            start-impl = TextRange.getStart-impl(selection-d9O1mEE);
        } else {
            start-impl = Math.max(end-impl -= i4, i2);
        }
        if (includePosition) {
            it = obj.getTextLayoutCoordinates();
            it = SelectionManagerKt.visibleBounds(it);
            if (it != null && it != null) {
                it = SelectionManagerKt.visibleBounds(it);
                if (it != null) {
                    i2 = 0;
                    l = it;
                } else {
                    l = handlePosition-tuRUvjQ;
                }
            } else {
            }
        } else {
            l = it;
        }
        TextFieldHandleState textFieldHandleState = new TextFieldHandleState(1, l, obj12, layoutResult.getBidiRunDirection(start-impl), TextRange.getReversed-impl(selection-d9O1mEE), 0);
        return textFieldHandleState;
    }

    public final boolean isFocused() {
        return this.isFocused;
    }

    public final boolean isInTouchMode() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isInTouchMode$delegate.getValue().booleanValue();
    }

    public final Object observeChanges(Continuation<? super Unit> continuation) {
        boolean anon;
        Throwable th;
        Object l$0;
        Throwable _this;
        int label;
        boolean textToolbarState;
        androidx.compose.foundation.text.input.internal.selection.TextToolbarState coroutineScope;
        int i;
        Throwable th2;
        Object obj8;
        anon = continuation;
        _this = Integer.MIN_VALUE;
        if (continuation instanceof TextFieldSelectionState.observeChanges.1 && label2 &= _this != 0) {
            anon = continuation;
            _this = Integer.MIN_VALUE;
            if (label2 &= _this != 0) {
                anon.label = obj8 -= _this;
            } else {
                anon = new TextFieldSelectionState.observeChanges.1(this, continuation);
            }
        } else {
        }
        obj8 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj8);
                label = this;
                TextFieldSelectionState.observeChanges.2 anon2 = new TextFieldSelectionState.observeChanges.2(label, 0);
                anon.L$0 = label;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                l$0 = label;
                break;
            case 1:
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj8);
                break;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        l$0.setShowCursorHandle(false);
        if (l$0.getTextToolbarState() != TextToolbarState.None) {
            l$0.hideTextToolbar();
        }
        return Unit.INSTANCE;
    }

    public final void paste() {
        Object receiveContentConfiguration;
        Object clipboardManager;
        Object transferableContent;
        int clipboard-kB6V9T0;
        int textFieldState;
        int i;
        int i4;
        TextFieldEditUndoBehavior neverMerge;
        int i2;
        int i3;
        receiveContentConfiguration = this.receiveContentConfiguration;
        if (receiveContentConfiguration != null) {
            receiveContentConfiguration = receiveContentConfiguration.invoke();
            if ((ReceiveContentConfiguration)receiveContentConfiguration == null) {
            } else {
                clipboardManager = this.clipboardManager;
                if (clipboardManager != null) {
                    clipboardManager = clipboardManager.getClip();
                    if (clipboardManager == null) {
                    } else {
                        final ClipEntry clipEntry = clipboardManager;
                        transferableContent = new TransferableContent(clipEntry, clipEntry.getClipMetadata(), TransferableContent.Source.Companion.getClipboard-kB6V9T0(), 0, 8, 0);
                        TransferableContent onReceive = (ReceiveContentConfiguration)receiveContentConfiguration.getReceiveContentListener().onReceive(transferableContent);
                        transferableContent = onReceive.getClipEntry();
                        transferableContent = TransferableContent_androidKt.readPlainText(transferableContent);
                        if (onReceive != null && transferableContent != null && transferableContent != null) {
                            transferableContent = onReceive.getClipEntry();
                            if (transferableContent != null) {
                                transferableContent = TransferableContent_androidKt.readPlainText(transferableContent);
                                if (transferableContent != null) {
                                    clipboard-kB6V9T0 = 0;
                                    TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, (CharSequence)transferableContent, false, TextFieldEditUndoBehavior.NeverMerge, 2, 0);
                                }
                            }
                        }
                    }
                }
            }
            pasteAsPlainText();
        }
        pasteAsPlainText();
    }

    public final void selectAll() {
        this.textFieldState.selectAll();
    }

    public final Object selectionHandleGestures(PointerInputScope $this$selectionHandleGestures, boolean isStartHandle, Continuation<? super Unit> $completion) {
        TextFieldSelectionState.selectionHandleGestures.2 anon = new TextFieldSelectionState.selectionHandleGestures.2(this, $this$selectionHandleGestures, isStartHandle, 0);
        Object coroutineScope = CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
        if (coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    public final void setDirectDragGestureInitiator(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.InputType <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.directDragGestureInitiator$delegate.setValue(<set-?>);
    }

    public final void setDraggingHandle(Handle <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.draggingHandle$delegate.setValue(<set-?>);
    }

    public final void setFocused(boolean <set-?>) {
        this.isFocused = <set-?>;
    }

    public final void setInTouchMode(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isInTouchMode$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    public final void setReceiveContentConfiguration(Function0<? extends ReceiveContentConfiguration> <set-?>) {
        this.receiveContentConfiguration = <set-?>;
    }

    public final Object textFieldSelectionGestures(PointerInputScope $this$textFieldSelectionGestures, Function0<Unit> requestFocus, Continuation<? super Unit> $completion) {
        TextFieldSelectionState.TextFieldMouseSelectionObserver textFieldMouseSelectionObserver = new TextFieldSelectionState.TextFieldMouseSelectionObserver(this, requestFocus);
        TextFieldSelectionState.TextFieldTextDragObserver textFieldTextDragObserver = new TextFieldSelectionState.TextFieldTextDragObserver(this, requestFocus);
        Object selectionGesturePointerInputBtf2 = SelectionGesturesKt.selectionGesturePointerInputBtf2($this$textFieldSelectionGestures, (MouseSelectionObserver)textFieldMouseSelectionObserver, (TextDragObserver)textFieldTextDragObserver, $completion);
        if (selectionGesturePointerInputBtf2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return selectionGesturePointerInputBtf2;
        }
        return Unit.INSTANCE;
    }

    public final void update(HapticFeedback hapticFeedBack, ClipboardManager clipboardManager, TextToolbar textToolbar, Density density, boolean enabled, boolean readOnly, boolean isPassword) {
        if (!enabled) {
            hideTextToolbar();
        }
        this.hapticFeedBack = hapticFeedBack;
        this.clipboardManager = clipboardManager;
        this.textToolbar = textToolbar;
        this.density = density;
        this.enabled = enabled;
        this.readOnly = readOnly;
        this.isPassword = isPassword;
    }

    public final void updateHandleDragging-Uv8p0NA(Handle handle, long position) {
        setDraggingHandle(handle);
        setRawHandleDragPosition-k-4lQ0M(position);
    }

    public final void updateTextToolbarState(androidx.compose.foundation.text.input.internal.selection.TextToolbarState textToolbarState) {
        setTextToolbarState(textToolbarState);
    }
}

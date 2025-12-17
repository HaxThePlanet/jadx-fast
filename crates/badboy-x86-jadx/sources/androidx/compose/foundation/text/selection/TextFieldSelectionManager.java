package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType.Companion;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRange.Companion;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.input.VisualTransformation.Companion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\r\u0010p\u001a\u00020FH\u0000¢\u0006\u0002\u0008qJ\u0018\u0010r\u001a\u00020F2\u0006\u0010s\u001a\u00020\u000cø\u0001\u0000¢\u0006\u0004\u0008t\u0010uJ\u0017\u0010v\u001a\u00020F2\u0008\u0008\u0002\u0010w\u001a\u00020!H\u0000¢\u0006\u0002\u0008xJ\"\u0010y\u001a\u00020C2\u0006\u0010z\u001a\u00020_2\u0006\u0010{\u001a\u00020|H\u0002ø\u0001\u0000¢\u0006\u0004\u0008}\u0010~J\u000e\u0010\u007f\u001a\u00020[H\u0000¢\u0006\u0003\u0008\u0080\u0001J\u000f\u0010\u0081\u0001\u001a\u00020FH\u0000¢\u0006\u0003\u0008\u0082\u0001J\u001e\u0010\u0083\u0001\u001a\u00020F2\n\u0008\u0002\u0010s\u001a\u0004\u0018\u00010\u000cH\u0000ø\u0001\u0000¢\u0006\u0003\u0008\u0084\u0001J\u001a\u0010\u0085\u0001\u001a\u00020F2\t\u0008\u0002\u0010\u0086\u0001\u001a\u00020!H\u0000¢\u0006\u0003\u0008\u0087\u0001J\u000f\u0010\u0088\u0001\u001a\u00020FH\u0000¢\u0006\u0003\u0008\u0089\u0001J\n\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0002J\"\u0010\u008c\u0001\u001a\u00020\u000c2\u0008\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\u0008\u008f\u0001\u0010\u0090\u0001J!\u0010\u0091\u0001\u001a\u00020\u000c2\u0007\u0010\u0092\u0001\u001a\u00020!H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\u0008\u0093\u0001\u0010\u0094\u0001J\u0018\u0010\u0095\u0001\u001a\u00020[2\u0007\u0010\u0092\u0001\u001a\u00020!H\u0000¢\u0006\u0003\u0008\u0096\u0001J\u000f\u0010\u0097\u0001\u001a\u00020FH\u0000¢\u0006\u0003\u0008\u0098\u0001J\u000f\u0010\u0099\u0001\u001a\u00020!H\u0000¢\u0006\u0003\u0008\u009a\u0001J\u000f\u0010\u009b\u0001\u001a\u00020FH\u0000¢\u0006\u0003\u0008\u009c\u0001J\u000f\u0010\u009d\u0001\u001a\u00020FH\u0000¢\u0006\u0003\u0008\u009e\u0001J\u001d\u0010\u009f\u0001\u001a\u00020F2\u0007\u0010 \u0001\u001a\u00020|H\u0000ø\u0001\u0000¢\u0006\u0005\u0008¡\u0001\u0010uJ\u0013\u0010¢\u0001\u001a\u00020F2\u0008\u0010£\u0001\u001a\u00030¤\u0001H\u0002J\u001d\u0010¥\u0001\u001a\u00020F2\u0007\u0010 \u0001\u001a\u00020|H\u0000ø\u0001\u0000¢\u0006\u0005\u0008¦\u0001\u0010uJ\u000f\u0010§\u0001\u001a\u00020FH\u0000¢\u0006\u0003\u0008¨\u0001J\u0012\u0010©\u0001\u001a\u00020F2\u0007\u0010ª\u0001\u001a\u00020!H\u0002JK\u0010«\u0001\u001a\u00020|2\u0006\u0010d\u001a\u00020C2\u0007\u0010¬\u0001\u001a\u00020\u000c2\u0007\u0010­\u0001\u001a\u00020!2\u0007\u0010\u0092\u0001\u001a\u00020!2\u0008\u0010®\u0001\u001a\u00030¯\u00012\u0007\u0010°\u0001\u001a\u00020!H\u0002ø\u0001\u0000¢\u0006\u0006\u0008±\u0001\u0010²\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR5\u0010\r\u001a\u0004\u0018\u00010\u000c2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c8F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u000cX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u000cX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R/\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u001a8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008 \u0010\u0013\u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR+\u0010\"\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008'\u0010\u0013\u001a\u0004\u0008#\u0010$\"\u0004\u0008%\u0010&R+\u0010(\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020!8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008+\u0010\u0013\u001a\u0004\u0008)\u0010$\"\u0004\u0008*\u0010&R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008.\u0010/\"\u0004\u00080\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00084\u00105\"\u0004\u00086\u00107R\u0014\u00108\u001a\u000209X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010;R\u001a\u0010<\u001a\u00020=X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008>\u0010?\"\u0004\u0008@\u0010AR\u000e\u0010B\u001a\u00020CX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010D\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020F0EX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008G\u0010H\"\u0004\u0008I\u0010JR\u000e\u0010K\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010N\u001a\u0004\u0018\u00010OX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008P\u0010Q\"\u0004\u0008R\u0010SR\u001c\u0010T\u001a\u0004\u0018\u00010UX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008V\u0010W\"\u0004\u0008X\u0010YR\u0014\u0010Z\u001a\u00020[X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\\\u0010]R\u0016\u0010^\u001a\u0004\u0018\u00010_8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008`\u0010aR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008b\u0010cR+\u0010d\u001a\u00020C2\u0006\u0010\u000b\u001a\u00020C8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u0008i\u0010\u0013\u001a\u0004\u0008e\u0010f\"\u0004\u0008g\u0010hR\u001a\u0010j\u001a\u00020kX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008l\u0010m\"\u0004\u0008n\u0010o\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006³\u0001", d2 = {"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "(Landroidx/compose/foundation/text/UndoManager;)V", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager$foundation_release", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager$foundation_release", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "Landroidx/compose/runtime/MutableState;", "dragBeginOffsetInText", "", "Ljava/lang/Integer;", "dragBeginPosition", "J", "dragTotalDistance", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "", "editable", "getEditable", "()Z", "setEditable", "(Z)V", "editable$delegate", "enabled", "getEnabled", "setEnabled", "enabled$delegate", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping$foundation_release", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping$foundation_release", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "oldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "", "getOnValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "previousRawDragOffset", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "getState$foundation_release", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "setState$foundation_release", "(Landroidx/compose/foundation/text/LegacyTextFieldState;)V", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "touchSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getTouchSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/TextDragObserver;", "transformedText", "Landroidx/compose/ui/text/AnnotatedString;", "getTransformedText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "value", "getValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "value$delegate", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation$foundation_release", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setVisualTransformation$foundation_release", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "clearPreviewHighlight", "clearPreviewHighlight$foundation_release", "contextMenuOpenAdjustment", "position", "contextMenuOpenAdjustment-k-4lQ0M", "(J)V", "copy", "cancelSelection", "copy$foundation_release", "createTextFieldValue", "annotatedString", "selection", "Landroidx/compose/ui/text/TextRange;", "createTextFieldValue-FDrldGo", "(Landroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/input/TextFieldValue;", "cursorDragObserver", "cursorDragObserver$foundation_release", "cut", "cut$foundation_release", "deselect", "deselect-_kEHs6E$foundation_release", "enterSelectionMode", "showFloatingToolbar", "enterSelectionMode$foundation_release", "exitSelectionMode", "exitSelectionMode$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorPosition", "density", "Landroidx/compose/ui/unit/Density;", "getCursorPosition-tuRUvjQ$foundation_release", "(Landroidx/compose/ui/unit/Density;)J", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ$foundation_release", "(Z)J", "handleDragObserver", "handleDragObserver$foundation_release", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "isTextChanged", "isTextChanged$foundation_release", "paste", "paste$foundation_release", "selectAll", "selectAll$foundation_release", "setDeletionPreviewHighlight", "range", "setDeletionPreviewHighlight-5zc-tL8$foundation_release", "setHandleState", "handleState", "Landroidx/compose/foundation/text/HandleState;", "setSelectionPreviewHighlight", "setSelectionPreviewHighlight-5zc-tL8$foundation_release", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "updateFloatingToolbar", "show", "updateSelection", "currentPosition", "isStartOfSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "isTouchBasedSelection", "updateSelection-8UEBfa8", "(Landroidx/compose/ui/text/input/TextFieldValue;JZZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldSelectionManager {

    public static final int $stable = 8;
    private ClipboardManager clipboardManager;
    private final MutableState currentDragPosition$delegate;
    private Integer dragBeginOffsetInText;
    private long dragBeginPosition;
    private long dragTotalDistance;
    private final MutableState draggingHandle$delegate;
    private final MutableState editable$delegate;
    private final MutableState enabled$delegate;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final androidx.compose.foundation.text.selection.MouseSelectionObserver mouseSelectionObserver;
    private OffsetMapping offsetMapping;
    private TextFieldValue oldValue;
    private Function1<? super TextFieldValue, Unit> onValueChange;
    private int previousRawDragOffset;
    private androidx.compose.foundation.text.selection.SelectionLayout previousSelectionLayout;
    private LegacyTextFieldState state;
    private TextToolbar textToolbar;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;
    private final MutableState value$delegate;
    private VisualTransformation visualTransformation;
    static {
        final int i = 8;
    }

    public TextFieldSelectionManager() {
        final int i = 0;
        super(i, 1, i);
    }

    public TextFieldSelectionManager(UndoManager undoManager) {
        super();
        this.undoManager = undoManager;
        this.offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
        this.onValueChange = (Function1)TextFieldSelectionManager.onValueChange.1.INSTANCE;
        final int i10 = 7;
        final int i11 = 0;
        final int i9 = 0;
        TextFieldValue textFieldValue = new TextFieldValue(0, 0, obj4, i9, i10, i11);
        int i = 0;
        int i5 = 2;
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(textFieldValue, i, i5, i);
        this.visualTransformation = VisualTransformation.Companion.getNone();
        Boolean valueOf = true;
        this.editable$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i, i5, i);
        this.enabled$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i, i5, i);
        this.dragBeginPosition = Offset.Companion.getZero-F1C5BW0();
        this.dragTotalDistance = Offset.Companion.getZero-F1C5BW0();
        this.draggingHandle$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i5, i);
        this.currentDragPosition$delegate = SnapshotStateKt.mutableStateOf$default(i, i, i5, i);
        this.previousRawDragOffset = -1;
        TextFieldValue textFieldValue2 = new TextFieldValue(0, 0, obj4, i9, i10, i11);
        this.oldValue = textFieldValue2;
        TextFieldSelectionManager.touchSelectionObserver.1 anon = new TextFieldSelectionManager.touchSelectionObserver.1(this);
        this.touchSelectionObserver = (TextDragObserver)anon;
        TextFieldSelectionManager.mouseSelectionObserver.1 anon2 = new TextFieldSelectionManager.mouseSelectionObserver.1(this);
        this.mouseSelectionObserver = (MouseSelectionObserver)anon2;
    }

    public TextFieldSelectionManager(UndoManager undoManager, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public static final TextFieldValue access$createTextFieldValue-FDrldGo(androidx.compose.foundation.text.selection.TextFieldSelectionManager $this, AnnotatedString annotatedString, long selection) {
        return $this.createTextFieldValue-FDrldGo(annotatedString, selection);
    }

    public static final Integer access$getDragBeginOffsetInText$p(androidx.compose.foundation.text.selection.TextFieldSelectionManager $this) {
        return $this.dragBeginOffsetInText;
    }

    public static final long access$getDragBeginPosition$p(androidx.compose.foundation.text.selection.TextFieldSelectionManager $this) {
        return $this.dragBeginPosition;
    }

    public static final long access$getDragTotalDistance$p(androidx.compose.foundation.text.selection.TextFieldSelectionManager $this) {
        return $this.dragTotalDistance;
    }

    public static final void access$setCurrentDragPosition-_kEHs6E(androidx.compose.foundation.text.selection.TextFieldSelectionManager $this, Offset <set-?>) {
        $this.setCurrentDragPosition-_kEHs6E(<set-?>);
    }

    public static final void access$setDragBeginOffsetInText$p(androidx.compose.foundation.text.selection.TextFieldSelectionManager $this, Integer <set-?>) {
        $this.dragBeginOffsetInText = <set-?>;
    }

    public static final void access$setDragBeginPosition$p(androidx.compose.foundation.text.selection.TextFieldSelectionManager $this, long <set-?>) {
        $this.dragBeginPosition = <set-?>;
    }

    public static final void access$setDragTotalDistance$p(androidx.compose.foundation.text.selection.TextFieldSelectionManager $this, long <set-?>) {
        $this.dragTotalDistance = <set-?>;
    }

    public static final void access$setDraggingHandle(androidx.compose.foundation.text.selection.TextFieldSelectionManager $this, Handle <set-?>) {
        $this.setDraggingHandle(<set-?>);
    }

    public static final void access$setHandleState(androidx.compose.foundation.text.selection.TextFieldSelectionManager $this, HandleState handleState) {
        $this.setHandleState(handleState);
    }

    public static final void access$setPreviousRawDragOffset$p(androidx.compose.foundation.text.selection.TextFieldSelectionManager $this, int <set-?>) {
        $this.previousRawDragOffset = <set-?>;
    }

    public static final void access$updateFloatingToolbar(androidx.compose.foundation.text.selection.TextFieldSelectionManager $this, boolean show) {
        $this.updateFloatingToolbar(show);
    }

    public static final long access$updateSelection-8UEBfa8(androidx.compose.foundation.text.selection.TextFieldSelectionManager $this, TextFieldValue value, long currentPosition, boolean isStartOfSelection, boolean isStartHandle, androidx.compose.foundation.text.selection.SelectionAdjustment adjustment, boolean isTouchBasedSelection) {
        return $this.updateSelection-8UEBfa8(value, currentPosition, isStartOfSelection, isStartHandle, adjustment, isTouchBasedSelection);
    }

    public static void copy$foundation_release$default(androidx.compose.foundation.text.selection.TextFieldSelectionManager textFieldSelectionManager, boolean z2, int i3, Object object4) {
        int obj1;
        final int obj3 = 1;
        if (i3 &= obj3 != 0) {
            obj1 = obj3;
        }
        textFieldSelectionManager.copy$foundation_release(obj1);
    }

    private final TextFieldValue createTextFieldValue-FDrldGo(AnnotatedString annotatedString, long selection) {
        TextFieldValue textFieldValue = new TextFieldValue(annotatedString, selection, obj3, 0, 4, 0);
        return textFieldValue;
    }

    public static void deselect-_kEHs6E$foundation_release$default(androidx.compose.foundation.text.selection.TextFieldSelectionManager textFieldSelectionManager, Offset offset2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        textFieldSelectionManager.deselect-_kEHs6E$foundation_release(obj1);
    }

    public static void enterSelectionMode$foundation_release$default(androidx.compose.foundation.text.selection.TextFieldSelectionManager textFieldSelectionManager, boolean z2, int i3, Object object4) {
        int obj1;
        final int obj3 = 1;
        if (i3 &= obj3 != 0) {
            obj1 = obj3;
        }
        textFieldSelectionManager.enterSelectionMode$foundation_release(obj1);
    }

    private final Rect getContentRect() {
        int state;
        LegacyTextFieldState field;
        int i;
        boolean layoutResultStale;
        long localToRoot-MK-Hz9U;
        Object layoutCoordinates4;
        long handlePosition-tuRUvjQ$foundation_release2;
        Object layoutCoordinates;
        long localToRoot-MK-Hz9U3;
        long handlePosition-tuRUvjQ$foundation_release;
        int y-impl2;
        Object layoutCoordinates2;
        int y-impl;
        long localToRoot-MK-Hz9U2;
        Object layoutCoordinates3;
        float top;
        Object layoutResult2;
        long l;
        Object layoutResult;
        float top2;
        Object obj = this;
        state = obj.state;
        if (state != null) {
            i = 0;
            if (!state.isLayoutResultStale()) {
            } else {
                state = 0;
            }
            if (state != 0) {
                int i3 = 0;
                layoutCoordinates4 = obj.state;
                layoutCoordinates4 = layoutCoordinates4.getLayoutCoordinates();
                if (layoutCoordinates4 != null && layoutCoordinates4 != null) {
                    layoutCoordinates4 = layoutCoordinates4.getLayoutCoordinates();
                    if (layoutCoordinates4 != null) {
                        localToRoot-MK-Hz9U = layoutCoordinates4.localToRoot-MK-Hz9U(obj.getHandlePosition-tuRUvjQ$foundation_release(true));
                    } else {
                        localToRoot-MK-Hz9U = Offset.Companion.getZero-F1C5BW0();
                    }
                } else {
                }
                layoutCoordinates = obj.state;
                layoutCoordinates = layoutCoordinates.getLayoutCoordinates();
                if (layoutCoordinates != null && layoutCoordinates != null) {
                    layoutCoordinates = layoutCoordinates.getLayoutCoordinates();
                    if (layoutCoordinates != null) {
                        localToRoot-MK-Hz9U3 = layoutCoordinates.localToRoot-MK-Hz9U(obj.getHandlePosition-tuRUvjQ$foundation_release(false));
                    } else {
                        localToRoot-MK-Hz9U3 = Offset.Companion.getZero-F1C5BW0();
                    }
                } else {
                }
                layoutCoordinates2 = obj.state;
                y-impl = 0;
                layoutCoordinates2 = layoutCoordinates2.getLayoutCoordinates();
                if (layoutCoordinates2 != null && layoutCoordinates2 != null) {
                    layoutCoordinates2 = layoutCoordinates2.getLayoutCoordinates();
                    if (layoutCoordinates2 != null) {
                        layoutResult2 = state.getLayoutResult();
                        layoutResult2 = layoutResult2.getValue();
                        layoutResult2 = layoutResult2.getCursorRect(obj.offsetMapping.originalToTransformed(TextRange.getStart-impl(obj.getValue$foundation_release().getSelection-d9O1mEE())));
                        if (layoutResult2 != null && layoutResult2 != null && layoutResult2 != null) {
                            layoutResult2 = layoutResult2.getValue();
                            if (layoutResult2 != null) {
                                layoutResult2 = layoutResult2.getCursorRect(originalToTransformed);
                                if (layoutResult2 != null) {
                                    top = layoutResult2.getTop();
                                } else {
                                    top = y-impl;
                                }
                            } else {
                            }
                        } else {
                        }
                        y-impl2 = Offset.getY-impl(layoutCoordinates2.localToRoot-MK-Hz9U(OffsetKt.Offset(y-impl, top)));
                    } else {
                        y-impl2 = y-impl;
                    }
                } else {
                }
                layoutCoordinates3 = obj.state;
                layoutCoordinates3 = layoutCoordinates3.getLayoutCoordinates();
                if (layoutCoordinates3 != null && layoutCoordinates3 != null) {
                    layoutCoordinates3 = layoutCoordinates3.getLayoutCoordinates();
                    if (layoutCoordinates3 != null) {
                        layoutResult = state.getLayoutResult();
                        layoutResult = layoutResult.getValue();
                        layoutResult = layoutResult.getCursorRect(obj.offsetMapping.originalToTransformed(TextRange.getEnd-impl(obj.getValue$foundation_release().getSelection-d9O1mEE())));
                        if (layoutResult != null && layoutResult != null && layoutResult != null) {
                            layoutResult = layoutResult.getValue();
                            if (layoutResult != null) {
                                layoutResult = layoutResult.getCursorRect(originalToTransformed2);
                                if (layoutResult != null) {
                                    top2 = layoutResult.getTop();
                                } else {
                                    top2 = y-impl;
                                }
                            } else {
                            }
                        } else {
                        }
                        y-impl = Offset.getY-impl(layoutCoordinates3.localToRoot-MK-Hz9U(OffsetKt.Offset(y-impl, top2)));
                    } else {
                    }
                } else {
                }
                final int i8 = 0;
                Rect rect = new Rect(Math.min(Offset.getX-impl(localToRoot-MK-Hz9U), Offset.getX-impl(localToRoot-MK-Hz9U3)), Math.min(y-impl2, y-impl), Math.max(Offset.getX-impl(localToRoot-MK-Hz9U), Offset.getX-impl(localToRoot-MK-Hz9U3)), f5 += i2);
                return rect;
            }
        }
        return Rect.Companion.getZero();
    }

    private final void setCurrentDragPosition-_kEHs6E(Offset <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.currentDragPosition$delegate.setValue(<set-?>);
    }

    private final void setDraggingHandle(Handle <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.draggingHandle$delegate.setValue(<set-?>);
    }

    private final void setHandleState(HandleState handleState) {
        LegacyTextFieldState state;
        LegacyTextFieldState field;
        int i;
        int i2;
        state = this.state;
        if (state != null) {
            i = 0;
            i2 = state.getHandleState() == handleState ? 1 : 0;
            if (i2 == 0) {
            } else {
                state = 0;
            }
            if (state != 0) {
                field = 0;
                state.setHandleState(handleState);
            }
        }
    }

    private final void updateFloatingToolbar(boolean show) {
        final LegacyTextFieldState state = this.state;
        if (state == null) {
        } else {
            state.setShowFloatingToolbar(show);
        }
        if (show) {
            showSelectionToolbar$foundation_release();
        } else {
            hideSelectionToolbar$foundation_release();
        }
    }

    private final long updateSelection-8UEBfa8(TextFieldValue value, long currentPosition, boolean isStartOfSelection, boolean isStartHandle, androidx.compose.foundation.text.selection.SelectionAdjustment adjustment, boolean isTouchBasedSelection) {
        int z;
        Object layoutResult;
        int i2;
        boolean reversed-impl;
        int start-impl;
        int previousRawDragOffset;
        boolean collapsed-impl2;
        int i;
        int selection-d9O1mEE;
        int textHandleMove-5zf0vsI;
        Function1 onValueChange;
        int collapsed-impl;
        int previousRawDragOffset2;
        int i3;
        Object obj2;
        long l;
        boolean selectionHandleInVisibleBound3;
        int $i$a$WithTextFieldSelectionManager$updateSelection$onlyChangeIsReversed$1;
        int selectionHandleInVisibleBound;
        long selectionHandleInVisibleBound2;
        final Object obj = this;
        z = obj32;
        layoutResult = obj.state;
        if (layoutResult != null) {
            layoutResult = layoutResult.getLayoutResult();
            if (layoutResult == null) {
                l = currentPosition;
                obj2 = isTouchBasedSelection;
                return TextRange.Companion.getZero-d9O1mEE();
            } else {
                final long l5 = TextRangeKt.TextRange(obj.offsetMapping.originalToTransformed(TextRange.getStart-impl(value.getSelection-d9O1mEE())), obj.offsetMapping.originalToTransformed(TextRange.getEnd-impl(value.getSelection-d9O1mEE())));
                int offsetForPosition-3MmeM6k = layoutResult.getOffsetForPosition-3MmeM6k(currentPosition, obj14);
                if (!adjustment) {
                    if (isStartHandle) {
                        selection-d9O1mEE = offsetForPosition-3MmeM6k;
                    } else {
                        selection-d9O1mEE = start-impl;
                    }
                } else {
                }
                if (adjustment) {
                    if (isStartHandle) {
                        textHandleMove-5zf0vsI = offsetForPosition-3MmeM6k;
                    } else {
                        textHandleMove-5zf0vsI = start-impl;
                    }
                } else {
                }
                final androidx.compose.foundation.text.selection.SelectionLayout previousSelectionLayout = obj.previousSelectionLayout;
                previousRawDragOffset = -1;
                if (!isStartHandle && previousSelectionLayout != null) {
                    if (previousSelectionLayout != null) {
                        if (obj.previousRawDragOffset == previousRawDragOffset) {
                            i3 = previousRawDragOffset;
                        } else {
                            i3 = previousRawDragOffset;
                        }
                    } else {
                    }
                } else {
                }
                androidx.compose.foundation.text.selection.SelectionLayout textFieldSelectionLayout-RcvT-LA = SelectionLayoutKt.getTextFieldSelectionLayout-RcvT-LA(layoutResult.getValue(), selection-d9O1mEE, textHandleMove-5zf0vsI, i3, l5, obj10, isStartHandle);
                if (!textFieldSelectionLayout-RcvT-LA.shouldRecomputeSelection(previousSelectionLayout)) {
                    return value.getSelection-d9O1mEE();
                }
                obj.previousSelectionLayout = textFieldSelectionLayout-RcvT-LA;
                obj.previousRawDragOffset = offsetForPosition-3MmeM6k;
                androidx.compose.foundation.text.selection.Selection adjust = isTouchBasedSelection.adjust(textFieldSelectionLayout-RcvT-LA);
                final TextLayoutResultProxy textLayoutResultProxy = layoutResult;
                final int i5 = offsetForPosition-3MmeM6k;
                int transformedToOriginal2 = obj.offsetMapping.transformedToOriginal(adjust.getEnd().getOffset());
                long l2 = TextRangeKt.TextRange(obj.offsetMapping.transformedToOriginal(adjust.getStart().getOffset()), transformedToOriginal2);
                androidx.compose.foundation.text.selection.SelectionLayout selectionLayout = textFieldSelectionLayout-RcvT-LA;
                if (TextRange.equals-impl0(l2, transformedToOriginal2)) {
                    return value.getSelection-d9O1mEE();
                }
                boolean reversed-impl2 = TextRange.getReversed-impl(value.getSelection-d9O1mEE());
                int i6 = selection-d9O1mEE;
                if (TextRange.getReversed-impl(l2) != reversed-impl2) {
                    long l3 = l2;
                    int i7 = 0;
                    $i$a$WithTextFieldSelectionManager$updateSelection$onlyChangeIsReversed$1 = textHandleMove-5zf0vsI;
                    i2 = TextRange.equals-impl0(TextRangeKt.TextRange(TextRange.getEnd-impl(l3), TextRange.getStart-impl(l3)), reversed-impl2) ? selectionHandleInVisibleBound : 0;
                } else {
                    $i$a$WithTextFieldSelectionManager$updateSelection$onlyChangeIsReversed$1 = textHandleMove-5zf0vsI;
                    selectionHandleInVisibleBound = 1;
                }
                if (TextRange.getCollapsed-impl(l2) && TextRange.getCollapsed-impl(value.getSelection-d9O1mEE())) {
                    i = TextRange.getCollapsed-impl(value.getSelection-d9O1mEE()) ? selectionHandleInVisibleBound : 0;
                } else {
                }
                if (z) {
                    selection-d9O1mEE = (CharSequence)value.getText().length() > 0 ? selectionHandleInVisibleBound : 0;
                    selection-d9O1mEE = obj.hapticFeedBack;
                    if (selection-d9O1mEE != 0 && i2 == 0 && i == 0 && selection-d9O1mEE != null) {
                        if (i2 == 0) {
                            if (i == 0) {
                                selection-d9O1mEE = obj.hapticFeedBack;
                                if (selection-d9O1mEE != null) {
                                    selection-d9O1mEE.performHapticFeedback-CdsT49E(HapticFeedbackType.Companion.getTextHandleMove-5zf0vsI());
                                }
                            }
                        }
                    }
                }
                obj.onValueChange.invoke(obj.createTextFieldValue-FDrldGo(value.getAnnotatedString(), l2));
                if (!z) {
                    obj.updateFloatingToolbar(collapsed-impl4 ^= 1);
                }
                LegacyTextFieldState state3 = obj.state;
                if (state3 == null) {
                } else {
                    state3.setInTouchMode(z);
                }
                collapsed-impl = obj.state;
                if (collapsed-impl == null) {
                } else {
                    if (!TextRange.getCollapsed-impl(l2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(obj, selectionHandleInVisibleBound)) {
                        z = TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(obj, selectionHandleInVisibleBound) ? 1 : 0;
                    } else {
                    }
                    collapsed-impl.setShowSelectionHandleStart(z);
                }
                LegacyTextFieldState state = obj.state;
                if (state == null) {
                } else {
                    if (!TextRange.getCollapsed-impl(l2)) {
                        if (TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(obj, false)) {
                            collapsed-impl = 1;
                        }
                    } else {
                        collapsed-impl = 0;
                    }
                    state.setShowSelectionHandleEnd(collapsed-impl);
                }
                LegacyTextFieldState state2 = obj.state;
                if (state2 == null) {
                } else {
                    if (TextRange.getCollapsed-impl(l2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(obj, true)) {
                        if (TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(obj, true)) {
                        } else {
                            collapsed-impl = 0;
                        }
                    } else {
                    }
                    state2.setShowCursorHandle(collapsed-impl);
                }
            }
            return l2;
        }
        l = currentPosition;
        obj2 = isTouchBasedSelection;
    }

    public final void clearPreviewHighlight$foundation_release() {
        long zero-d9O1mEE;
        LegacyTextFieldState state = this.state;
        if (state == null) {
        } else {
            state.setDeletionPreviewHighlightRange-5zc-tL8(TextRange.Companion.getZero-d9O1mEE());
        }
        LegacyTextFieldState state2 = this.state;
        if (state2 == null) {
        } else {
            state2.setSelectionPreviewHighlightRange-5zc-tL8(TextRange.Companion.getZero-d9O1mEE());
        }
    }

    public final void contextMenuOpenAdjustment-k-4lQ0M(long position) {
        Object layoutResult;
        TextLayoutResultProxy textLayoutResultProxy;
        TextLayoutResultProxy position2;
        long value$foundation_release;
        long selection-d9O1mEE;
        int i;
        int i2;
        int i4;
        androidx.compose.foundation.text.selection.SelectionAdjustment word;
        int i3;
        int obj11;
        boolean obj12;
        layoutResult = this.state;
        layoutResult = layoutResult.getLayoutResult();
        if (layoutResult != null && layoutResult != null) {
            layoutResult = layoutResult.getLayoutResult();
            if (layoutResult != null) {
                layoutResult = 0;
                i = 2;
                position2 = position;
                if (!TextRange.contains-impl(getValue$foundation_release().getSelection-d9O1mEE(), i)) {
                    this.previousRawDragOffset = -1;
                    selection-d9O1mEE = position2;
                    this.updateSelection-8UEBfa8(getValue$foundation_release(), selection-d9O1mEE, i, true, 0, SelectionAdjustment.Companion.getWord());
                    position2 = selection-d9O1mEE;
                }
            } else {
                position2 = position;
            }
        } else {
        }
    }

    public final void copy$foundation_release(boolean cancelSelection) {
        long selectedText;
        if (TextRange.getCollapsed-impl(getValue$foundation_release().getSelection-d9O1mEE())) {
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        if (!cancelSelection) {
        }
        int max-impl = TextRange.getMax-impl(getValue$foundation_release().getSelection-d9O1mEE());
        this.onValueChange.invoke(createTextFieldValue-FDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(max-impl, max-impl)));
        setHandleState(HandleState.None);
    }

    public final TextDragObserver cursorDragObserver$foundation_release() {
        TextFieldSelectionManager.cursorDragObserver.1 anon = new TextFieldSelectionManager.cursorDragObserver.1(this);
        return (TextDragObserver)anon;
    }

    public final void cut$foundation_release() {
        long selectedText;
        if (TextRange.getCollapsed-impl(getValue$foundation_release().getSelection-d9O1mEE())) {
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        int length2 = getValue$foundation_release().getText().length();
        int min-impl = TextRange.getMin-impl(getValue$foundation_release().getSelection-d9O1mEE());
        this.onValueChange.invoke(createTextFieldValue-FDrldGo(TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), length2)), TextRangeKt.TextRange(min-impl, min-impl)));
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
    }

    public final void deselect-_kEHs6E$foundation_release(Offset position) {
        boolean transformedToOriginal;
        int layoutResult;
        long l2;
        HandleState cursor;
        TextFieldValue copy-3r_uNRQ$default;
        long offsetForPosition-3MmeM6k$default;
        long onValueChange;
        long l;
        int i;
        int i3;
        int i2;
        int i4;
        if (!TextRange.getCollapsed-impl(getValue$foundation_release().getSelection-d9O1mEE())) {
            LegacyTextFieldState state = this.state;
            if (state != null) {
                layoutResult = state.getLayoutResult();
            } else {
                layoutResult = 0;
            }
            l2 = layoutResult;
            if (position != null && l2 != 0) {
                if (l2 != 0) {
                    transformedToOriginal = this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.getOffsetForPosition-3MmeM6k$default(l2, position.unbox-impl(), obj3, 0, 2));
                } else {
                    transformedToOriginal = TextRange.getMax-impl(getValue$foundation_release().getSelection-d9O1mEE());
                }
            } else {
            }
            this.onValueChange.invoke(TextFieldValue.copy-3r_uNRQ$default(getValue$foundation_release(), 0, TextRangeKt.TextRange(transformedToOriginal), i, 0, 5));
        }
        int newCursorOffset = 0;
        if (position != null) {
            l2 = (CharSequence)getValue$foundation_release().getText().length() > 0 ? 1 : newCursorOffset;
            cursor = l2 != 0 ? HandleState.Cursor : HandleState.None;
        } else {
        }
        setHandleState(cursor);
        updateFloatingToolbar(newCursorOffset);
    }

    public final void enterSelectionMode$foundation_release(boolean showFloatingToolbar) {
        LegacyTextFieldState focusRequester;
        int i;
        focusRequester = this.state;
        i = 0;
        if (focusRequester != null && !focusRequester.getHasFocus()) {
            if (!focusRequester.getHasFocus()) {
                i = 1;
            }
        }
        focusRequester = this.focusRequester;
        if (i != 0 && focusRequester != null) {
            focusRequester = this.focusRequester;
            if (focusRequester != null) {
                focusRequester.requestFocus();
            }
        }
        this.oldValue = getValue$foundation_release();
        updateFloatingToolbar(showFloatingToolbar);
        setHandleState(HandleState.Selection);
    }

    public final void exitSelectionMode$foundation_release() {
        updateFloatingToolbar(false);
        setHandleState(HandleState.None);
    }

    public final ClipboardManager getClipboardManager$foundation_release() {
        return this.clipboardManager;
    }

    public final Offset getCurrentDragPosition-_m7T9-E() {
        final int i = 0;
        final int i2 = 0;
        return (Offset)(State)this.currentDragPosition$delegate.getValue();
    }

    public final long getCursorPosition-tuRUvjQ$foundation_release(Density density) {
        TextLayoutResultProxy layoutResult;
        LegacyTextFieldState state = this.state;
        if (state != null) {
            layoutResult = state.getLayoutResult();
        } else {
            layoutResult = 0;
        }
        Intrinsics.checkNotNull(layoutResult);
        TextLayoutResult value = layoutResult.getValue();
        Rect cursorRect = value.getCursorRect(RangesKt.coerceIn(this.offsetMapping.originalToTransformed(TextRange.getStart-impl(getValue$foundation_release().getSelection-d9O1mEE())), 0, value.getLayoutInput().getText().length()));
        final int i2 = 0;
        return OffsetKt.Offset(left += i4, cursorRect.getBottom());
    }

    public final Handle getDraggingHandle() {
        final int i = 0;
        final int i2 = 0;
        return (Handle)(State)this.draggingHandle$delegate.getValue();
    }

    public final boolean getEditable() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.editable$delegate.getValue().booleanValue();
    }

    public final boolean getEnabled() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.enabled$delegate.getValue().booleanValue();
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final long getHandlePosition-tuRUvjQ$foundation_release(boolean isStartHandle) {
        Object layoutResult;
        int start-impl;
        layoutResult = this.state;
        layoutResult = layoutResult.getLayoutResult();
        if (layoutResult != null && layoutResult != null) {
            layoutResult = layoutResult.getLayoutResult();
            if (layoutResult != null) {
                layoutResult = layoutResult.getValue();
                if (layoutResult == null) {
                } else {
                    AnnotatedString transformedText$foundation_release = getTransformedText$foundation_release();
                    if (transformedText$foundation_release == null) {
                        return Offset.Companion.getUnspecified-F1C5BW0();
                    }
                    if (!Intrinsics.areEqual(transformedText$foundation_release.getText(), layoutResult.getLayoutInput().getText().getText())) {
                        return Offset.Companion.getUnspecified-F1C5BW0();
                    }
                    long selection-d9O1mEE = getValue$foundation_release().getSelection-d9O1mEE();
                    if (isStartHandle) {
                        start-impl = TextRange.getStart-impl(selection-d9O1mEE);
                    } else {
                        start-impl = TextRange.getEnd-impl(selection-d9O1mEE);
                    }
                }
                return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult, this.offsetMapping.originalToTransformed(start-impl), isStartHandle, TextRange.getReversed-impl(getValue$foundation_release().getSelection-d9O1mEE()));
            }
        }
        return Offset.Companion.getUnspecified-F1C5BW0();
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final androidx.compose.foundation.text.selection.MouseSelectionObserver getMouseSelectionObserver$foundation_release() {
        return this.mouseSelectionObserver;
    }

    public final OffsetMapping getOffsetMapping$foundation_release() {
        return this.offsetMapping;
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange$foundation_release() {
        return this.onValueChange;
    }

    public final LegacyTextFieldState getState$foundation_release() {
        return this.state;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final TextDragObserver getTouchSelectionObserver$foundation_release() {
        return this.touchSelectionObserver;
    }

    public final AnnotatedString getTransformedText$foundation_release() {
        Object textDelegate;
        int text;
        textDelegate = this.state;
        textDelegate = textDelegate.getTextDelegate();
        if (textDelegate != null && textDelegate != null) {
            textDelegate = textDelegate.getTextDelegate();
            if (textDelegate != null) {
                text = textDelegate.getText();
            } else {
                text = 0;
            }
        } else {
        }
        return text;
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    public final TextFieldValue getValue$foundation_release() {
        final int i = 0;
        final int i2 = 0;
        return (TextFieldValue)(State)this.value$delegate.getValue();
    }

    public final VisualTransformation getVisualTransformation$foundation_release() {
        return this.visualTransformation;
    }

    public final TextDragObserver handleDragObserver$foundation_release(boolean isStartHandle) {
        TextFieldSelectionManager.handleDragObserver.1 anon = new TextFieldSelectionManager.handleDragObserver.1(this, isStartHandle);
        return (TextDragObserver)anon;
    }

    public final void hideSelectionToolbar$foundation_release() {
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

    public final boolean isTextChanged$foundation_release() {
        return equal ^= 1;
    }

    public final void paste$foundation_release() {
        Object clipboardManager;
        clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager = clipboardManager.getText();
            if (clipboardManager == null) {
            } else {
                int length2 = getValue$foundation_release().getText().length();
                min-impl += length3;
                this.onValueChange.invoke(createTextFieldValue-FDrldGo(TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(clipboardManager).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), length2)), TextRangeKt.TextRange(i, i)));
                setHandleState(HandleState.None);
                UndoManager undoManager = this.undoManager;
                if (undoManager != null) {
                    undoManager.forceNextSnapshot();
                }
            }
        }
    }

    public final void selectAll$foundation_release() {
        int i2 = 0;
        TextFieldValue textFieldValue-FDrldGo = createTextFieldValue-FDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(i2, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(textFieldValue-FDrldGo);
        this.oldValue = TextFieldValue.copy-3r_uNRQ$default(this.oldValue, 0, textFieldValue-FDrldGo.getSelection-d9O1mEE(), obj5, 0, 5);
        enterSelectionMode$foundation_release(true);
    }

    public final void setClipboardManager$foundation_release(ClipboardManager <set-?>) {
        this.clipboardManager = <set-?>;
    }

    public final void setDeletionPreviewHighlight-5zc-tL8$foundation_release(long range) {
        long zero-d9O1mEE;
        LegacyTextFieldState state = this.state;
        if (state == null) {
        } else {
            state.setDeletionPreviewHighlightRange-5zc-tL8(range);
        }
        LegacyTextFieldState state2 = this.state;
        if (state2 == null) {
        } else {
            state2.setSelectionPreviewHighlightRange-5zc-tL8(TextRange.Companion.getZero-d9O1mEE());
        }
        if (!TextRange.getCollapsed-impl(range)) {
            exitSelectionMode$foundation_release();
        }
    }

    public final void setEditable(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.editable$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    public final void setEnabled(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.enabled$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    public final void setFocusRequester(FocusRequester <set-?>) {
        this.focusRequester = <set-?>;
    }

    public final void setHapticFeedBack(HapticFeedback <set-?>) {
        this.hapticFeedBack = <set-?>;
    }

    public final void setOffsetMapping$foundation_release(OffsetMapping <set-?>) {
        this.offsetMapping = <set-?>;
    }

    public final void setOnValueChange$foundation_release(Function1<? super TextFieldValue, Unit> <set-?>) {
        this.onValueChange = <set-?>;
    }

    public final void setSelectionPreviewHighlight-5zc-tL8$foundation_release(long range) {
        long zero-d9O1mEE;
        LegacyTextFieldState state = this.state;
        if (state == null) {
        } else {
            state.setSelectionPreviewHighlightRange-5zc-tL8(range);
        }
        LegacyTextFieldState state2 = this.state;
        if (state2 == null) {
        } else {
            state2.setDeletionPreviewHighlightRange-5zc-tL8(TextRange.Companion.getZero-d9O1mEE());
        }
        if (!TextRange.getCollapsed-impl(range)) {
            exitSelectionMode$foundation_release();
        }
    }

    public final void setState$foundation_release(LegacyTextFieldState <set-?>) {
        this.state = <set-?>;
    }

    public final void setTextToolbar(TextToolbar <set-?>) {
        this.textToolbar = <set-?>;
    }

    public final void setValue$foundation_release(TextFieldValue <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.value$delegate.setValue(<set-?>);
    }

    public final void setVisualTransformation$foundation_release(VisualTransformation <set-?>) {
        this.visualTransformation = <set-?>;
    }

    public final void showSelectionToolbar$foundation_release() {
        boolean enabled;
        LegacyTextFieldState inTouchMode;
        int anon;
        androidx.compose.foundation.text.selection.TextFieldSelectionManager.showSelectionToolbar.selectAll.1 length-impl;
        int i;
        androidx.compose.foundation.text.selection.TextFieldSelectionManager.showSelectionToolbar.copy.1 anon2;
        boolean collapsed-impl;
        boolean clipboardManager;
        androidx.compose.foundation.text.selection.TextFieldSelectionManager.showSelectionToolbar.selectAll.1 i2;
        long contentRect;
        androidx.compose.foundation.text.selection.TextFieldSelectionManager.showSelectionToolbar.paste.1 field;
        androidx.compose.foundation.text.selection.TextFieldSelectionManager.showSelectionToolbar.cut.1 field3;
        androidx.compose.foundation.text.selection.TextFieldSelectionManager.showSelectionToolbar.selectAll.1 field2;
        if (getEnabled()) {
            inTouchMode = this.state;
            anon = 1;
            i = 0;
            if (inTouchMode != null && !inTouchMode.isInTouchMode()) {
                enabled = !inTouchMode.isInTouchMode() ? anon : i;
            } else {
            }
            if (enabled != 0) {
            } else {
                boolean z = visualTransformation instanceof PasswordVisualTransformation;
                i2 = 0;
                if (!TextRange.getCollapsed-impl(getValue$foundation_release().getSelection-d9O1mEE()) && !z) {
                    if (!z) {
                        anon2 = new TextFieldSelectionManager.showSelectionToolbar.copy.1(this);
                    } else {
                        anon2 = i2;
                    }
                } else {
                }
                if (!TextRange.getCollapsed-impl(getValue$foundation_release().getSelection-d9O1mEE()) && getEditable() && !z) {
                    if (getEditable()) {
                        if (!z) {
                            collapsed-impl = new TextFieldSelectionManager.showSelectionToolbar.cut.1(this);
                            field3 = collapsed-impl;
                        } else {
                            field3 = i2;
                        }
                    } else {
                    }
                } else {
                }
                if (getEditable()) {
                    clipboardManager = this.clipboardManager;
                    if (clipboardManager != null && clipboardManager.hasText() == anon) {
                        if (clipboardManager.hasText() == anon) {
                        } else {
                            anon = i;
                        }
                    } else {
                    }
                    if (anon != 0) {
                        anon = new TextFieldSelectionManager.showSelectionToolbar.paste.1(this);
                        field = anon;
                    } else {
                        field = i2;
                    }
                } else {
                }
                if (TextRange.getLength-impl(getValue$foundation_release().getSelection-d9O1mEE()) != getValue$foundation_release().getText().length()) {
                    length-impl = new TextFieldSelectionManager.showSelectionToolbar.selectAll.1(this);
                    field2 = i2;
                } else {
                    field2 = i2;
                }
                TextToolbar textToolbar = this.textToolbar;
                if (textToolbar != null) {
                    textToolbar.showMenu(getContentRect(), anon2, field, field3, field2);
                }
            }
        }
    }
}

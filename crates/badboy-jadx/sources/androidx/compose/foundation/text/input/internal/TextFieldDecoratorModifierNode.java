package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.content.internal.ReceiveContentConfigurationKt;
import androidx.compose.foundation.interaction.HoverInteraction.Enter;
import androidx.compose.foundation.interaction.HoverInteraction.Exit;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.handwriting.StylusHandwritingNode;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.ui.draganddrop.DragAndDropModifierNode;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.PlatformTextInputModifierNode;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeAction.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0081\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000*\u0001>\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\u00082\u00020\t2\u00020\n2\u00020\u000b2\u00020\u000cBY\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0008\u0010d\u001a\u00020\"H\u0002J\u0008\u0010e\u001a\u00020\"H\u0002J\u0008\u0010f\u001a\u00020\"H\u0016J\u0008\u0010g\u001a\u00020\"H\u0016J\u0008\u0010h\u001a\u00020\"H\u0016J\u0008\u0010i\u001a\u00020\"H\u0002J\u0010\u0010j\u001a\u00020\"2\u0006\u0010k\u001a\u00020lH\u0016J\u0010\u0010m\u001a\u00020\"2\u0006\u0010n\u001a\u00020oH\u0016J\u001a\u0010p\u001a\u00020\"2\u0006\u0010q\u001a\u00020rH\u0002ø\u0001\u0000¢\u0006\u0004\u0008s\u0010tJ\u001a\u0010u\u001a\u00020\u00162\u0006\u0010v\u001a\u00020wH\u0016ø\u0001\u0000¢\u0006\u0004\u0008x\u0010yJ\u0008\u0010z\u001a\u00020\"H\u0016J.\u0010{\u001a\u00020\"2\u0006\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\u007f2\u0008\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\u0008\u0082\u0001\u0010\u0083\u0001J\u001c\u0010\u0084\u0001\u001a\u00020\u00162\u0006\u0010v\u001a\u00020wH\u0016ø\u0001\u0000¢\u0006\u0005\u0008\u0085\u0001\u0010yJ\n\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0002J\u0012\u0010\u0088\u0001\u001a\u00020\"2\u0007\u0010\u0089\u0001\u001a\u00020\u0016H\u0002J[\u0010\u008a\u0001\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u008b\u0001\u001a\u00020\"*\u00030\u008c\u0001H\u0016R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008(\u0010)R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008*\u0010)\"\u0004\u0008+\u0010,R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008-\u0010.\"\u0004\u0008/\u00100R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00083\u00104\"\u0004\u00085\u00106R\u000e\u00107\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u00088\u0010)R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00089\u0010:\"\u0004\u0008;\u0010<R\u0010\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?R\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008A\u0010BR\u0010\u0010C\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008F\u0010)\"\u0004\u0008G\u0010,R\u0016\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010J0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010K\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008L\u0010)R\u001a\u0010\u001c\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008M\u0010)\"\u0004\u0008N\u0010,R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010Q\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008R\u0010SR\u000e\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008V\u0010W\"\u0004\u0008X\u0010YR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Z\u0010[\"\u0004\u0008\\\u0010]R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008^\u0010_\"\u0004\u0008`\u0010aR\u0010\u0010b\u001a\u0004\u0018\u00010cX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u008d\u0001", d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "filter", "Landroidx/compose/foundation/text/input/InputTransformation;", "enabled", "", "readOnly", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActionHandler", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "singleLine", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/InputTransformation;ZZLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;)V", "backingStylusHandwritingTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "dragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "dragEnterEvent", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "editable", "getEditable", "()Z", "getEnabled", "setEnabled", "(Z)V", "getFilter", "()Landroidx/compose/foundation/text/input/InputTransformation;", "setFilter", "(Landroidx/compose/foundation/text/input/InputTransformation;)V", "inputSessionJob", "Lkotlinx/coroutines/Job;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "setInteractionSource", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "isElementFocused", "isFocused", "getKeyboardActionHandler", "()Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "setKeyboardActionHandler", "(Landroidx/compose/foundation/text/input/KeyboardActionHandler;)V", "keyboardActionScope", "androidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1", "Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1;", "<set-?>", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "observeChangesJob", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "getReadOnly", "setReadOnly", "receiveContentConfigurationProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "getSingleLine", "setSingleLine", "stylusHandwritingNode", "Landroidx/compose/foundation/text/handwriting/StylusHandwritingNode;", "stylusHandwritingTrigger", "getStylusHandwritingTrigger", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "textFieldKeyEventHandler", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "getTextFieldSelectionState", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "setTextFieldSelectionState", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;)V", "getTextFieldState", "()Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "setTextFieldState", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;)V", "getTextLayoutState", "()Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "setTextLayoutState", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;)V", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "disposeInputSession", "emitDragExitEvent", "onAttach", "onCancelPointerInput", "onDetach", "onFocusChange", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onImeActionPerformed", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "onImeActionPerformed-KlQnJC8", "(I)V", "onKeyEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onObservedReadsChanged", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "requireKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "startInputSession", "fromTap", "updateNode", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldDecoratorModifierNode extends DelegatingNode implements PlatformTextInputModifierNode, SemanticsModifierNode, FocusRequesterModifierNode, FocusEventModifierNode, GlobalPositionAwareModifierNode, PointerInputModifierNode, KeyInputModifierNode, CompositionLocalConsumerModifierNode, ModifierLocalModifierNode, ObserverModifierNode, LayoutAwareModifierNode {

    public static final int $stable = 8;
    private MutableSharedFlow<Unit> backingStylusHandwritingTrigger;
    private final DragAndDropModifierNode dragAndDropNode;
    private HoverInteraction.Enter dragEnterEvent;
    private boolean enabled;
    private InputTransformation filter;
    private Job inputSessionJob;
    private MutableInteractionSource interactionSource;
    private boolean isElementFocused;
    private KeyboardActionHandler keyboardActionHandler;
    private final androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.keyboardActionScope.1 keyboardActionScope;
    private KeyboardOptions keyboardOptions;
    private Job observeChangesJob;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private boolean readOnly;
    private final Function0<ReceiveContentConfiguration> receiveContentConfigurationProvider;
    private boolean singleLine;
    private final StylusHandwritingNode stylusHandwritingNode;
    private final androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler textFieldKeyEventHandler;
    private TextFieldSelectionState textFieldSelectionState;
    private androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState;
    private androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState;
    private WindowInfo windowInfo;
    static {
        final int i = 8;
    }

    public TextFieldDecoratorModifierNode(androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, InputTransformation filter, boolean enabled, boolean readOnly, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, boolean singleLine, MutableInteractionSource interactionSource) {
        int keyboardOptions2;
        final Object obj = this;
        final KeyboardOptions keyboardOptions3 = keyboardOptions;
        super();
        obj.textFieldState = textFieldState;
        obj.textLayoutState = textLayoutState;
        obj.textFieldSelectionState = textFieldSelectionState;
        obj.filter = filter;
        obj.enabled = enabled;
        obj.readOnly = readOnly;
        obj.keyboardActionHandler = keyboardActionHandler;
        obj.singleLine = singleLine;
        obj.interactionSource = interactionSource;
        TextFieldDecoratorModifierNode.pointerInputNode.1 anon = new TextFieldDecoratorModifierNode.pointerInputNode.1(obj, 0);
        obj.pointerInputNode = (SuspendingPointerInputModifierNode)obj.delegate((DelegatableNode)SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode((Function2)anon));
        TextFieldDecoratorModifierNode.stylusHandwritingNode.1 anon11 = new TextFieldDecoratorModifierNode.stylusHandwritingNode.1(obj, keyboardOptions3);
        StylusHandwritingNode stylusHandwritingNode = new StylusHandwritingNode((Function0)anon11);
        obj.stylusHandwritingNode = (StylusHandwritingNode)obj.delegate((DelegatableNode)stylusHandwritingNode);
        TextFieldDecoratorModifierNode.dragAndDropNode.1 anon2 = new TextFieldDecoratorModifierNode.dragAndDropNode.1(obj);
        TextFieldDecoratorModifierNode.dragAndDropNode.2 anon3 = new TextFieldDecoratorModifierNode.dragAndDropNode.2(obj);
        TextFieldDecoratorModifierNode.dragAndDropNode.3 anon4 = new TextFieldDecoratorModifierNode.dragAndDropNode.3(obj);
        TextFieldDecoratorModifierNode.dragAndDropNode.4 anon5 = new TextFieldDecoratorModifierNode.dragAndDropNode.4(obj);
        TextFieldDecoratorModifierNode.dragAndDropNode.5 anon6 = new TextFieldDecoratorModifierNode.dragAndDropNode.5(obj);
        TextFieldDecoratorModifierNode.dragAndDropNode.6 anon7 = new TextFieldDecoratorModifierNode.dragAndDropNode.6(obj);
        TextFieldDecoratorModifierNode.dragAndDropNode.7 anon8 = new TextFieldDecoratorModifierNode.dragAndDropNode.7(obj);
        obj.dragAndDropNode = (DragAndDropModifierNode)obj.delegate((DelegatableNode)TextFieldDragAndDropNode_androidKt.textFieldDragAndDropNode$default((Function0)anon2, (Function2)anon3, (Function1)anon4, 0, (Function1)anon5, (Function1)anon6, 0, (Function1)anon7, (Function1)anon8, 72, 0));
        InputTransformation filter2 = obj.filter;
        if (filter2 != null) {
            keyboardOptions2 = filter2.getKeyboardOptions();
        }
        obj.keyboardOptions = keyboardOptions3.fillUnspecifiedValuesWith$foundation_release(keyboardOptions2);
        obj.textFieldKeyEventHandler = TextFieldKeyEventHandler_androidKt.createTextFieldKeyEventHandler();
        TextFieldDecoratorModifierNode.keyboardActionScope.1 anon9 = new TextFieldDecoratorModifierNode.keyboardActionScope.1(obj);
        obj.keyboardActionScope = anon9;
        TextFieldDecoratorModifierNode.receiveContentConfigurationProvider.1 anon10 = new TextFieldDecoratorModifierNode.receiveContentConfigurationProvider.1(obj);
        obj.receiveContentConfigurationProvider = (Function0)anon10;
    }

    public static final void access$emitDragExitEvent(androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode $this) {
        $this.emitDragExitEvent();
    }

    public static final boolean access$getEditable(androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode $this) {
        return $this.getEditable();
    }

    public static final Job access$getInputSessionJob$p(androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode $this) {
        return $this.inputSessionJob;
    }

    public static final androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.keyboardActionScope.1 access$getKeyboardActionScope$p(androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode $this) {
        return $this.keyboardActionScope;
    }

    public static final MutableSharedFlow access$getStylusHandwritingTrigger(androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode $this) {
        return $this.getStylusHandwritingTrigger();
    }

    public static final boolean access$isFocused(androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode $this) {
        return $this.isFocused();
    }

    public static final void access$onFocusChange(androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode $this) {
        $this.onFocusChange();
    }

    public static final void access$onImeActionPerformed-KlQnJC8(androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode $this, int imeAction) {
        $this.onImeActionPerformed-KlQnJC8(imeAction);
    }

    public static final SoftwareKeyboardController access$requireKeyboardController(androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode $this) {
        return $this.requireKeyboardController();
    }

    public static final void access$setDragEnterEvent$p(androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode $this, HoverInteraction.Enter <set-?>) {
        $this.dragEnterEvent = <set-?>;
    }

    public static final void access$setWindowInfo$p(androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode $this, WindowInfo <set-?>) {
        $this.windowInfo = <set-?>;
    }

    public static final void access$startInputSession(androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode $this, boolean fromTap) {
        $this.startInputSession(fromTap);
    }

    private final void disposeInputSession() {
        int i;
        Job inputSessionJob = this.inputSessionJob;
        final int i2 = 0;
        if (inputSessionJob != null) {
            Job.DefaultImpls.cancel$default(inputSessionJob, i2, 1, i2);
        }
        this.inputSessionJob = i2;
        MutableSharedFlow stylusHandwritingTrigger = getStylusHandwritingTrigger();
        if (stylusHandwritingTrigger != null) {
            stylusHandwritingTrigger.resetReplayCache();
        }
    }

    private final void emitDragExitEvent() {
        int i2;
        int i;
        HoverInteraction.Exit exit;
        final HoverInteraction.Enter dragEnterEvent = this.dragEnterEvent;
        if (dragEnterEvent != null) {
            i2 = 0;
            exit = new HoverInteraction.Exit(dragEnterEvent);
            this.interactionSource.tryEmit((Interaction)exit);
            this.dragEnterEvent = 0;
        }
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

    private final MutableSharedFlow<Unit> getStylusHandwritingTrigger() {
        final MutableSharedFlow backingStylusHandwritingTrigger = this.backingStylusHandwritingTrigger;
        if (backingStylusHandwritingTrigger != null) {
            return backingStylusHandwritingTrigger;
        }
        int i = 0;
        if (!StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
            return i;
        }
        MutableSharedFlow mutableSharedFlow = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_LATEST, 2, i);
        int i3 = 0;
        this.backingStylusHandwritingTrigger = mutableSharedFlow;
        return mutableSharedFlow;
    }

    private final boolean isFocused() {
        WindowInfo windowFocused;
        int i2;
        int i;
        windowFocused = this.windowInfo;
        i = 1;
        final int i3 = 0;
        if (windowFocused != null && windowFocused.isWindowFocused() == i) {
            i2 = windowFocused.isWindowFocused() == i ? i : i3;
        } else {
        }
        if (this.isElementFocused && i2 != 0) {
            if (i2 != 0) {
            } else {
                i = i3;
            }
        } else {
        }
        return i;
    }

    private final void onFocusChange() {
        boolean observeChangesJob2;
        boolean observeChangesJob;
        int coroutineScope;
        int i3;
        int i;
        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.onFocusChange.1 field;
        int i2;
        int i4;
        this.textFieldSelectionState.setFocused(isFocused());
        int i5 = 0;
        if (isFocused() && this.observeChangesJob == null) {
            if (this.observeChangesJob == null) {
                TextFieldDecoratorModifierNode.onFocusChange.1 anon = new TextFieldDecoratorModifierNode.onFocusChange.1(this, i5);
                this.observeChangesJob = BuildersKt.launch$default(getCoroutineScope(), 0, 0, (Function2)anon, 3, 0);
            } else {
                observeChangesJob2 = this.observeChangesJob;
                if (!isFocused() && observeChangesJob2 != null) {
                    observeChangesJob2 = this.observeChangesJob;
                    if (observeChangesJob2 != null) {
                        Job.DefaultImpls.cancel$default(observeChangesJob2, i5, 1, i5);
                    }
                    this.observeChangesJob = i5;
                }
            }
        } else {
        }
    }

    private final void onImeActionPerformed-KlQnJC8(int imeAction) {
        boolean keyboardActionHandler;
        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.onImeActionPerformed.1 anon;
        if (!ImeAction.equals-impl0(imeAction, ImeAction.Companion.getNone-eUduSuo()) && !ImeAction.equals-impl0(imeAction, ImeAction.Companion.getDefault-eUduSuo())) {
            if (!ImeAction.equals-impl0(imeAction, ImeAction.Companion.getDefault-eUduSuo())) {
                if (this.keyboardActionHandler == null) {
                } else {
                    KeyboardActionHandler keyboardActionHandler2 = this.keyboardActionHandler;
                    if (keyboardActionHandler2 != null) {
                        anon = new TextFieldDecoratorModifierNode.onImeActionPerformed.1(this, imeAction);
                        keyboardActionHandler2.onKeyboardAction((Function0)anon);
                    }
                }
            }
        }
        this.keyboardActionScope.defaultKeyboardAction-KlQnJC8(imeAction);
    }

    private final SoftwareKeyboardController requireKeyboardController() {
        Object currentValueOf = CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)this, (CompositionLocal)CompositionLocalsKt.getLocalSoftwareKeyboardController());
        if ((SoftwareKeyboardController)currentValueOf == null) {
        } else {
            return (SoftwareKeyboardController)currentValueOf;
        }
        IllegalStateException illegalStateException = new IllegalStateException("No software keyboard controller".toString());
        throw illegalStateException;
    }

    private final void startInputSession(boolean fromTap) {
        boolean showKeyboardOnFocusOrDefault$foundation_release;
        if (!fromTap && !this.keyboardOptions.getShowKeyboardOnFocusOrDefault$foundation_release()) {
            if (!this.keyboardOptions.getShowKeyboardOnFocusOrDefault$foundation_release()) {
            }
        }
        final int i2 = 0;
        TextFieldDecoratorModifierNode.startInputSession.1 anon = new TextFieldDecoratorModifierNode.startInputSession.1(this, ReceiveContentConfigurationKt.getReceiveContentConfiguration((ModifierLocalModifierNode)this), i2);
        this.inputSessionJob = BuildersKt.launch$default(getCoroutineScope(), 0, i2, (Function2)anon, 3, 0);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        boolean editable;
        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.applySemantics.5 anon;
        int i2;
        int i;
        boolean obj13;
        TextFieldCharSequence outputText = this.textFieldState.getOutputText();
        final long selection-d9O1mEE = outputText.getSelection-d9O1mEE();
        AnnotatedString annotatedString = new AnnotatedString(outputText.toString(), 0, 0, 6, 0);
        SemanticsPropertiesKt.setEditableText($this$applySemantics, annotatedString);
        SemanticsPropertiesKt.setTextSelectionRange-FDrldGo($this$applySemantics, selection-d9O1mEE);
        if (!this.enabled) {
            SemanticsPropertiesKt.disabled($this$applySemantics);
        }
        SemanticsPropertiesKt.setEditable($this$applySemantics, getEditable());
        TextFieldDecoratorModifierNode.applySemantics.1 anon2 = new TextFieldDecoratorModifierNode.applySemantics.1(this);
        i2 = 0;
        i = 1;
        SemanticsPropertiesKt.getTextLayoutResult$default($this$applySemantics, i2, (Function1)anon2, i, i2);
        if (getEditable()) {
            TextFieldDecoratorModifierNode.applySemantics.2 anon3 = new TextFieldDecoratorModifierNode.applySemantics.2(this);
            SemanticsPropertiesKt.setText$default($this$applySemantics, i2, (Function1)anon3, i, i2);
            editable = new TextFieldDecoratorModifierNode.applySemantics.3(this);
            SemanticsPropertiesKt.insertTextAtCursor$default($this$applySemantics, i2, (Function1)editable, i, i2);
        }
        TextFieldDecoratorModifierNode.applySemantics.4 anon4 = new TextFieldDecoratorModifierNode.applySemantics.4(this);
        SemanticsPropertiesKt.setSelection$default($this$applySemantics, i2, (Function3)anon4, i, i2);
        int imeActionOrDefault-eUduSuo$foundation_release = this.keyboardOptions.getImeActionOrDefault-eUduSuo$foundation_release();
        anon = new TextFieldDecoratorModifierNode.applySemantics.5(this, imeActionOrDefault-eUduSuo$foundation_release);
        SemanticsPropertyReceiver semanticsPropertyReceiver = $this$applySemantics;
        SemanticsPropertiesKt.onImeAction-9UiTYpY$default(semanticsPropertyReceiver, imeActionOrDefault-eUduSuo$foundation_release, 0, (Function0)anon, 2, 0);
        obj13 = new TextFieldDecoratorModifierNode.applySemantics.6(this);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, i2, (Function0)obj13, i, i2);
        obj13 = new TextFieldDecoratorModifierNode.applySemantics.7(this);
        SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, i2, (Function0)obj13, i, i2);
        obj13 = new TextFieldDecoratorModifierNode.applySemantics.8(this);
        SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, i2, (Function0)obj13, i, i2);
        if (!TextRange.getCollapsed-impl(selection-d9O1mEE) && this.enabled && !this.readOnly) {
            obj13 = new TextFieldDecoratorModifierNode.applySemantics.8(this);
            SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, i2, (Function0)obj13, i, i2);
            if (this.enabled) {
                if (!this.readOnly) {
                    obj13 = new TextFieldDecoratorModifierNode.applySemantics.9(this);
                    SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, i2, (Function0)obj13, i, i2);
                }
            }
        }
        if (getEditable()) {
            obj13 = new TextFieldDecoratorModifierNode.applySemantics.10(this);
            SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, i2, (Function0)obj13, i, i2);
        }
        obj13 = this.filter;
        if (obj13 != null) {
            anon = 0;
            i = 0;
            obj13.applySemantics(semanticsPropertyReceiver);
        }
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final boolean getEnabled() {
        return this.enabled;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final InputTransformation getFilter() {
        return this.filter;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final KeyboardActionHandler getKeyboardActionHandler() {
        return this.keyboardActionHandler;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final KeyboardOptions getKeyboardOptions() {
        return this.keyboardOptions;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final boolean getReadOnly() {
        return this.readOnly;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public boolean getShouldMergeDescendantSemantics() {
        return 1;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final boolean getSingleLine() {
        return this.singleLine;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final TextFieldSelectionState getTextFieldSelectionState() {
        return this.textFieldSelectionState;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final androidx.compose.foundation.text.input.internal.TransformedTextFieldState getTextFieldState() {
        return this.textFieldState;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final androidx.compose.foundation.text.input.internal.TextLayoutState getTextLayoutState() {
        return this.textLayoutState;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onAttach() {
        onObservedReadsChanged();
        this.textFieldSelectionState.setReceiveContentConfiguration(this.receiveContentConfigurationProvider);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onCancelPointerInput() {
        this.stylusHandwritingNode.onCancelPointerInput();
        this.pointerInputNode.onCancelPointerInput();
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onDetach() {
        disposeInputSession();
        this.textFieldSelectionState.setReceiveContentConfiguration(0);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onFocusEvent(FocusState focusState) {
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$iv;
        int focused;
        int i;
        TextFieldState field;
        InputTransformation inputTransformation;
        TextFieldEditUndoBehavior mergeIfPossible;
        int i3;
        androidx.compose.foundation.text.input.internal.EditingBuffer mainBuffer$foundation_release;
        int i2;
        if (this.isElementFocused == focusState.isFocused()) {
        }
        this.isElementFocused = focusState.isFocused();
        onFocusChange();
        if (focusState.isFocused()) {
            if (getEditable()) {
                startInputSession(false);
            }
        } else {
            disposeInputSession();
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState = this.textFieldState;
            i = 0;
            field = TransformedTextFieldState.access$getTextFieldState$p(textFieldState);
            i3 = 0;
            field.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
            i2 = 0;
            EditCommandKt.finishComposingText(field.getMainBuffer$foundation_release());
            TextFieldState.access$commitEditAsUser(field, TransformedTextFieldState.access$getInputTransformation$p(textFieldState), true, TextFieldEditUndoBehavior.MergeIfPossible);
            this.textFieldState.collapseSelectionToMax();
        }
        this.stylusHandwritingNode.onFocusEvent(focusState);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        this.textLayoutState.setDecoratorNodeCoordinates(coordinates);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public boolean onKeyEvent-ZmokQxo(KeyEvent event) {
        boolean readOnly;
        int i;
        if (this.enabled && !this.readOnly) {
            i = !this.readOnly ? 1 : 0;
        } else {
        }
        TextFieldDecoratorModifierNode.onKeyEvent.1 anon = new TextFieldDecoratorModifierNode.onKeyEvent.1(this);
        return this.textFieldKeyEventHandler.onKeyEvent-6ptp14s(event, this.textFieldState, this.textLayoutState, this.textFieldSelectionState, i, this.singleLine, (Function0)anon);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onObservedReadsChanged() {
        TextFieldDecoratorModifierNode.onObservedReadsChanged.1 anon = new TextFieldDecoratorModifierNode.onObservedReadsChanged.1(this);
        ObserverModifierNodeKt.observeReads((Modifier.Node)this, (Function0)anon);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onPointerEvent-H0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        this.stylusHandwritingNode.onPointerEvent-H0pRuoY(pointerEvent, pass, bounds);
        this.pointerInputNode.onPointerEvent-H0pRuoY(pointerEvent, pass, bounds);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public boolean onPreKeyEvent-ZmokQxo(KeyEvent event) {
        return this.textFieldKeyEventHandler.onPreKeyEvent-MyFupTE(event, this.textFieldState, this.textFieldSelectionState, (FocusManager)CompositionLocalConsumerModifierNodeKt.currentValueOf((CompositionLocalConsumerModifierNode)this, (CompositionLocal)CompositionLocalsKt.getLocalFocusManager()), requireKeyboardController());
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void setEnabled(boolean <set-?>) {
        this.enabled = <set-?>;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void setFilter(InputTransformation <set-?>) {
        this.filter = <set-?>;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void setInteractionSource(MutableInteractionSource <set-?>) {
        this.interactionSource = <set-?>;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void setKeyboardActionHandler(KeyboardActionHandler <set-?>) {
        this.keyboardActionHandler = <set-?>;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void setReadOnly(boolean <set-?>) {
        this.readOnly = <set-?>;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void setSingleLine(boolean <set-?>) {
        this.singleLine = <set-?>;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void setTextFieldSelectionState(TextFieldSelectionState <set-?>) {
        this.textFieldSelectionState = <set-?>;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void setTextFieldState(androidx.compose.foundation.text.input.internal.TransformedTextFieldState <set-?>) {
        this.textFieldState = <set-?>;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void setTextLayoutState(androidx.compose.foundation.text.input.internal.TextLayoutState <set-?>) {
        this.textLayoutState = <set-?>;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void updateNode(androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, InputTransformation filter, boolean enabled, boolean readOnly, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, boolean singleLine, MutableInteractionSource interactionSource) {
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState focused;
        boolean receiveContentConfigurationProvider;
        boolean stylusHandwritingNode;
        boolean readOnly2;
        int i2;
        int i;
        KeyboardOptions keyboardOptions2;
        final Object obj = this;
        focused = textFieldState;
        final TextFieldSelectionState field = textFieldSelectionState;
        InputTransformation inputTransformation = filter;
        final boolean z2 = enabled;
        final boolean z3 = readOnly;
        final MutableInteractionSource mutableInteractionSource = interactionSource;
        if (obj.enabled && !obj.readOnly) {
            i2 = !obj.readOnly ? i : 0;
        } else {
        }
        if (z2 && !z3) {
            if (!z3) {
            } else {
                i = 0;
            }
        } else {
        }
        obj.textFieldState = focused;
        obj.textLayoutState = textLayoutState;
        obj.textFieldSelectionState = field;
        obj.filter = inputTransformation;
        obj.enabled = z2;
        obj.readOnly = z3;
        if (inputTransformation != null) {
            keyboardOptions2 = inputTransformation.getKeyboardOptions();
        } else {
            keyboardOptions2 = 0;
        }
        obj.keyboardOptions = keyboardOptions.fillUnspecifiedValuesWith$foundation_release(keyboardOptions2);
        obj.keyboardActionHandler = keyboardActionHandler;
        obj.singleLine = singleLine;
        obj.interactionSource = mutableInteractionSource;
        if (i == i2 && Intrinsics.areEqual(focused, obj.textFieldState)) {
            if (Intrinsics.areEqual(focused, textFieldState2)) {
                if (!Intrinsics.areEqual(obj.keyboardOptions, obj.keyboardOptions)) {
                    if (i != 0 && obj.isFocused()) {
                        if (obj.isFocused()) {
                            obj.startInputSession(false);
                        } else {
                            if (i == 0) {
                                obj.disposeInputSession();
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
        if (obj.enabled != z2) {
            SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode)obj);
        }
        obj.pointerInputNode.resetPointerInputHandler();
        obj.stylusHandwritingNode.resetPointerInputHandler();
        if (!Intrinsics.areEqual(field, obj.textFieldSelectionState) && obj.isAttached()) {
            obj.pointerInputNode.resetPointerInputHandler();
            obj.stylusHandwritingNode.resetPointerInputHandler();
            if (obj.isAttached()) {
                field.setReceiveContentConfiguration(obj.receiveContentConfigurationProvider);
            }
        }
        if (!Intrinsics.areEqual(mutableInteractionSource, obj.interactionSource)) {
            obj.pointerInputNode.resetPointerInputHandler();
            obj.stylusHandwritingNode.resetPointerInputHandler();
        }
    }
}

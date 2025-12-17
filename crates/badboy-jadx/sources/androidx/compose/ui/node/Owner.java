package androidx.compose.ui.node;

import android.view.KeyEvent;
import android.view.View;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.draganddrop.DragAndDropManager;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.PlatformTextInputSessionScope;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.font.Font.ResourceLoader;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000à\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008`\u0018\u0000 º\u00012\u00020\u0001:\u0004º\u0001»\u0001J\u001a\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020zH&ø\u0001\u0000¢\u0006\u0004\u0008|\u0010}J\u001b\u0010~\u001a\u00020z2\u0006\u0010\u007f\u001a\u00020zH&ø\u0001\u0000¢\u0006\u0005\u0008\u0080\u0001\u0010}Jn\u0010\u0081\u0001\u001a\u00030\u0082\u00012C\u0010\u0083\u0001\u001a>\u0012\u0017\u0012\u00150\u0085\u0001¢\u0006\u000f\u0008\u0086\u0001\u0012\n\u0008\u0087\u0001\u0012\u0005\u0008\u0008(\u0088\u0001\u0012\u0019\u0012\u0017\u0018\u00010\u0089\u0001¢\u0006\u000f\u0008\u0086\u0001\u0012\n\u0008\u0087\u0001\u0012\u0005\u0008\u0008(\u008a\u0001\u0012\u0005\u0012\u00030\u008b\u00010\u0084\u00012\u000f\u0010\u008c\u0001\u001a\n\u0012\u0005\u0012\u00030\u008b\u00010\u008d\u00012\u000c\u0008\u0002\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u0089\u0001H&J\u001e\u0010\u008f\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u0090\u0001\u001a\u00020O2\t\u0008\u0002\u0010\u0091\u0001\u001a\u00020[H&J\"\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\u0008\u0010\u0094\u0001\u001a\u00030\u0095\u0001H&ø\u0001\u0000¢\u0006\u0006\u0008\u0096\u0001\u0010\u0097\u0001J)\u0010\u0098\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u0090\u0001\u001a\u00020O2\u0008\u0010\u0099\u0001\u001a\u00030\u009a\u0001H&ø\u0001\u0000¢\u0006\u0006\u0008\u009b\u0001\u0010\u009c\u0001J\u0015\u0010\u0098\u0001\u001a\u00030\u008b\u00012\t\u0008\u0002\u0010\u009d\u0001\u001a\u00020[H&J\u0013\u0010\u009e\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u009f\u0001\u001a\u00020OH&J\u0013\u0010 \u0001\u001a\u00030\u008b\u00012\u0007\u0010\u009f\u0001\u001a\u00020OH&J\n\u0010¡\u0001\u001a\u00030\u008b\u0001H&J\u0019\u0010¢\u0001\u001a\u00030\u008b\u00012\r\u0010£\u0001\u001a\u00080¤\u0001j\u0003`¥\u0001H'J\u0013\u0010¦\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u0090\u0001\u001a\u00020OH&J4\u0010§\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u0090\u0001\u001a\u00020O2\t\u0008\u0002\u0010\u0091\u0001\u001a\u00020[2\t\u0008\u0002\u0010¨\u0001\u001a\u00020[2\t\u0008\u0002\u0010©\u0001\u001a\u00020[H&J)\u0010ª\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u0090\u0001\u001a\u00020O2\t\u0008\u0002\u0010\u0091\u0001\u001a\u00020[2\t\u0008\u0002\u0010¨\u0001\u001a\u00020[H&J\n\u0010«\u0001\u001a\u00030\u008b\u0001H&J\u001b\u0010¬\u0001\u001a\u00030\u008b\u00012\u000f\u0010­\u0001\u001a\n\u0012\u0005\u0012\u00030\u008b\u00010\u008d\u0001H&J\u0014\u0010®\u0001\u001a\u00030\u008b\u00012\u0008\u0010­\u0001\u001a\u00030¯\u0001H&J\t\u0010°\u0001\u001a\u00020[H&J\u0013\u0010±\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u0090\u0001\u001a\u00020OH&JA\u0010²\u0001\u001a\u00030³\u00012.\u0010´\u0001\u001a)\u0008\u0001\u0012\u0005\u0012\u00030µ\u0001\u0012\u000c\u0012\n\u0012\u0005\u0012\u00030³\u00010¶\u0001\u0012\u0007\u0012\u0005\u0018\u00010·\u00010\u0084\u0001¢\u0006\u0003\u0008¸\u0001H¦@¢\u0006\u0003\u0010¹\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00078gX§\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bR\u001a\u0010\u000c\u001a\u00020\r8gX§\u0004¢\u0006\u000c\u0012\u0004\u0008\u000e\u0010\t\u001a\u0004\u0008\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u001eX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010 R\u0012\u0010!\u001a\u00020\"X¦\u0004¢\u0006\u0006\u001a\u0004\u0008#\u0010$R\u0012\u0010%\u001a\u00020&X¦\u0004¢\u0006\u0006\u001a\u0004\u0008'\u0010(R\u001a\u0010)\u001a\u00020*8&X§\u0004¢\u0006\u000c\u0012\u0004\u0008+\u0010\t\u001a\u0004\u0008,\u0010-R\u0012\u0010.\u001a\u00020/X¦\u0004¢\u0006\u0006\u001a\u0004\u00080\u00101R\u0012\u00102\u001a\u000203X¦\u0004¢\u0006\u0006\u001a\u0004\u00084\u00105R\u0012\u00106\u001a\u000207X¦\u0004¢\u0006\u0006\u001a\u0004\u00088\u00109R\u0012\u0010:\u001a\u00020;X¦\u0004¢\u0006\u0006\u001a\u0004\u0008<\u0010=R\u0012\u0010>\u001a\u00020?X¦\u0004¢\u0006\u0006\u001a\u0004\u0008@\u0010AR\u0012\u0010B\u001a\u00020CX¦\u0004¢\u0006\u0006\u001a\u0004\u0008D\u0010ER\u0014\u0010F\u001a\u00020G8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008H\u0010IR\u0012\u0010J\u001a\u00020KX¦\u0004¢\u0006\u0006\u001a\u0004\u0008L\u0010MR\u0012\u0010N\u001a\u00020OX¦\u0004¢\u0006\u0006\u001a\u0004\u0008P\u0010QR\u0012\u0010R\u001a\u00020SX¦\u0004¢\u0006\u0006\u001a\u0004\u0008T\u0010UR\u0012\u0010V\u001a\u00020WX¦\u0004¢\u0006\u0006\u001a\u0004\u0008X\u0010YR\"\u0010\\\u001a\u00020[2\u0006\u0010Z\u001a\u00020[@gX¦\u000e¢\u0006\u000c\u001a\u0004\u0008]\u0010^\"\u0004\u0008_\u0010`R\u0012\u0010a\u001a\u00020bX¦\u0004¢\u0006\u0006\u001a\u0004\u0008c\u0010dR\u0012\u0010e\u001a\u00020fX¦\u0004¢\u0006\u0006\u001a\u0004\u0008g\u0010hR\u0012\u0010i\u001a\u00020jX¦\u0004¢\u0006\u0006\u001a\u0004\u0008k\u0010lR\u0012\u0010m\u001a\u00020nX¦\u0004¢\u0006\u0006\u001a\u0004\u0008o\u0010pR\u0012\u0010q\u001a\u00020rX¦\u0004¢\u0006\u0006\u001a\u0004\u0008s\u0010tR\u0012\u0010u\u001a\u00020vX¦\u0004¢\u0006\u0006\u001a\u0004\u0008w\u0010xø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006¼\u0001À\u0006\u0001", d2 = {"Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "accessibilityManager", "Landroidx/compose/ui/platform/AccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AccessibilityManager;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill$annotations", "()V", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree$annotations", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/ClipboardManager;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "dragAndDropManager", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/DragAndDropManager;", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "getFocusOwner", "()Landroidx/compose/ui/focus/FocusOwner;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "inputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "measureIteration", "", "getMeasureIteration", "()J", "modifierLocalManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "<set-?>", "", "showLayoutBounds", "getShowLayoutBounds", "()Z", "setShowLayoutBounds", "(Z)V", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "softwareKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getSoftwareKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "calculateLocalPosition", "Landroidx/compose/ui/geometry/Offset;", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "(J)J", "calculatePositionInWindow", "localPosition", "calculatePositionInWindow-MK-Hz9U", "createLayer", "Landroidx/compose/ui/node/OwnedLayer;", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "parentLayer", "", "invalidateParentLayer", "Lkotlin/Function0;", "explicitLayer", "forceMeasureTheSubtree", "layoutNode", "affectsLookahead", "getFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "measureAndLayout", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "sendPointerUpdate", "onAttach", "node", "onDetach", "onEndApplyChanges", "onInteropViewLayoutChange", "view", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/InteropView;", "onLayoutChange", "onRequestMeasure", "forceRequest", "scheduleMeasureAndLayout", "onRequestRelayout", "onSemanticsChange", "registerOnEndApplyChangesListener", "listener", "registerOnLayoutCompletedListener", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "requestFocus", "requestOnPositionedCallback", "textInputSession", "", "session", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "OnLayoutCompletedListener", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Owner extends PositionCalculator {

    public static final androidx.compose.ui.node.Owner.Companion Companion;

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0004À\u0006\u0001", d2 = {"Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "", "onLayoutComplete", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnLayoutCompletedListener {
        public abstract void onLayoutComplete();
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Landroidx/compose/ui/node/Owner$Companion;", "", "()V", "enableExtraAssertions", "", "getEnableExtraAssertions", "()Z", "setEnableExtraAssertions", "(Z)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.node.Owner.Companion $$INSTANCE;
        private static boolean enableExtraAssertions;
        static {
            Owner.Companion companion = new Owner.Companion();
            Owner.Companion.$$INSTANCE = companion;
        }

        public final boolean getEnableExtraAssertions() {
            return Owner.Companion.enableExtraAssertions;
        }

        public final void setEnableExtraAssertions(boolean <set-?>) {
            Owner.Companion.enableExtraAssertions = <set-?>;
        }
    }
    static {
        Owner.Companion = Owner.Companion.$$INSTANCE;
    }

    public static androidx.compose.ui.node.OwnedLayer createLayer$default(androidx.compose.ui.node.Owner owner, Function2 function22, Function0 function03, GraphicsLayer graphicsLayer4, int i5, Object object6) {
        int obj3;
        if (object6 != null) {
        } else {
            if (i5 &= 4 != 0) {
                obj3 = 0;
            }
            return owner.createLayer(function22, function03, obj3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLayer");
        throw obj0;
    }

    public static void forceMeasureTheSubtree$default(androidx.compose.ui.node.Owner owner, androidx.compose.ui.node.LayoutNode layoutNode2, boolean z3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            owner.forceMeasureTheSubtree(layoutNode2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: forceMeasureTheSubtree");
        throw obj0;
    }

    public static void getAutofill$annotations() {
    }

    public static void getAutofillTree$annotations() {
    }

    @Deprecated(message = "fontLoader is deprecated, use fontFamilyResolver", replaceWith = @ReplaceWith(...))
    public static void getFontLoader$annotations() {
    }

    public static void measureAndLayout$default(androidx.compose.ui.node.Owner owner, boolean z2, int i3, Object object4) {
        int obj1;
        if (object4 != null) {
        } else {
            final int obj3 = 1;
            if (i3 &= obj3 != 0) {
                obj1 = obj3;
            }
            owner.measureAndLayout(obj1);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: measureAndLayout");
        throw obj0;
    }

    public static void onRequestMeasure$default(androidx.compose.ui.node.Owner owner, androidx.compose.ui.node.LayoutNode layoutNode2, boolean z3, boolean z4, boolean z5, int i6, Object object7) {
        int obj3;
        int obj4;
        int obj5;
        if (object7 != null) {
        } else {
            final int i = 0;
            if (i6 & 2 != 0) {
                obj3 = i;
            }
            if (i6 & 4 != 0) {
                obj4 = i;
            }
            if (i6 &= 8 != 0) {
                obj5 = 1;
            }
            owner.onRequestMeasure(layoutNode2, obj3, obj4, obj5);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRequestMeasure");
        throw obj1;
    }

    public static void onRequestRelayout$default(androidx.compose.ui.node.Owner owner, androidx.compose.ui.node.LayoutNode layoutNode2, boolean z3, boolean z4, int i5, Object object6) {
        int obj3;
        int obj4;
        if (object6 != null) {
        } else {
            final int i = 0;
            if (i5 & 2 != 0) {
                obj3 = i;
            }
            if (i5 &= 4 != 0) {
                obj4 = i;
            }
            owner.onRequestRelayout(layoutNode2, obj3, obj4);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRequestRelayout");
        throw obj1;
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract long calculateLocalPosition-MK-Hz9U(long l);

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract long calculatePositionInWindow-MK-Hz9U(long l);

    public abstract androidx.compose.ui.node.OwnedLayer createLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function02, GraphicsLayer graphicsLayer3);

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract void forceMeasureTheSubtree(androidx.compose.ui.node.LayoutNode layoutNode, boolean z2);

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract AccessibilityManager getAccessibilityManager();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract Autofill getAutofill();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract AutofillTree getAutofillTree();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract ClipboardManager getClipboardManager();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract CoroutineContext getCoroutineContext();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract Density getDensity();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract DragAndDropManager getDragAndDropManager();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract FocusDirection getFocusDirection-P8AzH3I(KeyEvent keyEvent);

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract FocusOwner getFocusOwner();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract FontFamily.Resolver getFontFamilyResolver();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract Font.ResourceLoader getFontLoader();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract GraphicsContext getGraphicsContext();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract HapticFeedback getHapticFeedBack();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract InputModeManager getInputModeManager();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract LayoutDirection getLayoutDirection();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract long getMeasureIteration();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract ModifierLocalManager getModifierLocalManager();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public Placeable.PlacementScope getPlacementScope() {
        return PlaceableKt.PlacementScope(this);
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract PointerIconService getPointerIconService();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract androidx.compose.ui.node.LayoutNode getRoot();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract androidx.compose.ui.node.RootForTest getRootForTest();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract androidx.compose.ui.node.LayoutNodeDrawScope getSharedDrawScope();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract boolean getShowLayoutBounds();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract androidx.compose.ui.node.OwnerSnapshotObserver getSnapshotObserver();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract SoftwareKeyboardController getSoftwareKeyboardController();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract TextInputService getTextInputService();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract TextToolbar getTextToolbar();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract ViewConfiguration getViewConfiguration();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract WindowInfo getWindowInfo();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract void measureAndLayout(boolean z);

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract void measureAndLayout-0kLqBqw(androidx.compose.ui.node.LayoutNode layoutNode, long l2);

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract void onAttach(androidx.compose.ui.node.LayoutNode layoutNode);

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract void onDetach(androidx.compose.ui.node.LayoutNode layoutNode);

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract void onEndApplyChanges();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract void onInteropViewLayoutChange(View view);

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract void onLayoutChange(androidx.compose.ui.node.LayoutNode layoutNode);

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract void onRequestMeasure(androidx.compose.ui.node.LayoutNode layoutNode, boolean z2, boolean z3, boolean z4);

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract void onRequestRelayout(androidx.compose.ui.node.LayoutNode layoutNode, boolean z2, boolean z3);

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract void onSemanticsChange();

    public abstract void registerOnEndApplyChangesListener(Function0<Unit> function0);

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract void registerOnLayoutCompletedListener(androidx.compose.ui.node.Owner.OnLayoutCompletedListener owner$OnLayoutCompletedListener);

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract boolean requestFocus();

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract void requestOnPositionedCallback(androidx.compose.ui.node.LayoutNode layoutNode);

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    public abstract void setShowLayoutBounds(boolean z);

    public abstract Object textInputSession(Function2<? super PlatformTextInputSessionScope, ? super Continuation<?>, ? extends Object> function2, Continuation<?> continuation2);
}

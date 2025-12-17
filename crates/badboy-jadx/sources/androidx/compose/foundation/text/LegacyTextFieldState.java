package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRange.Companion;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily.Resolver;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u001c\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010|\u001a\u00020\u001bJx\u0010}\u001a\u00020L2\u0006\u0010v\u001a\u00020w2\u0006\u0010~\u001a\u00020w2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\u0007\u0010\u0081\u0001\u001a\u00020\u001b2\u0008\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0008\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020L0J2\u0008\u0010\u0086\u0001\u001a\u00030\u0087\u00012\u0008\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0006\u0010Y\u001a\u00020Zø\u0001\u0000¢\u0006\u0006\u0008\u008a\u0001\u0010\u008b\u0001R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00148F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001a\u0010\u0013\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R+\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u001b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008!\u0010\u0013\u001a\u0004\u0008\u001d\u0010\u001e\"\u0004\u0008\u001f\u0010 R\u0011\u0010\"\u001a\u00020#¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008(\u0010)\"\u0004\u0008*\u0010+R+\u0010,\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u001b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008.\u0010\u0013\u001a\u0004\u0008,\u0010\u001e\"\u0004\u0008-\u0010 R\u001e\u0010/\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010\u001eR\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u00103R(\u00105\u001a\u0004\u0018\u00010\n2\u0008\u00104\u001a\u0004\u0018\u00010\n8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u00086\u00107\"\u0004\u00088\u00109R(\u0010;\u001a\u0004\u0018\u00010:2\u0008\u00104\u001a\u0004\u0018\u00010:8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008<\u0010=\"\u0004\u0008>\u0010?R\u0016\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:0AX\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010C\u001a\u00020B2\u0006\u0010\u000b\u001a\u00020B8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008H\u0010\u0013\u001a\u0004\u0008D\u0010E\"\u0004\u0008F\u0010GR\u001d\u0010I\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020L0J¢\u0006\u0008\n\u0000\u001a\u0004\u0008M\u0010NR\u001d\u0010O\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020L0J¢\u0006\u0008\n\u0000\u001a\u0004\u0008Q\u0010NR\u001a\u0010R\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020L0JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010S\u001a\u00020T¢\u0006\u0008\n\u0000\u001a\u0004\u0008U\u0010VR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008W\u0010XR\"\u0010Y\u001a\u00020ZX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010]\u001a\u0004\u0008[\u0010\u000f\"\u0004\u0008\\\u0010\u0011R1\u0010^\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000c8F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008a\u0010\u0013\u001a\u0004\u0008_\u0010\u000f\"\u0004\u0008`\u0010\u0011R+\u0010b\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u001b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008e\u0010\u0013\u001a\u0004\u0008c\u0010\u001e\"\u0004\u0008d\u0010 R+\u0010f\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u001b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008i\u0010\u0013\u001a\u0004\u0008g\u0010\u001e\"\u0004\u0008h\u0010 R+\u0010j\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u001b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008m\u0010\u0013\u001a\u0004\u0008k\u0010\u001e\"\u0004\u0008l\u0010 R+\u0010n\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u001b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008q\u0010\u0013\u001a\u0004\u0008o\u0010\u001e\"\u0004\u0008p\u0010 R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008r\u0010s\"\u0004\u0008t\u0010uR\u001c\u0010v\u001a\u0004\u0018\u00010wX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008x\u0010y\"\u0004\u0008z\u0010{\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u008c\u0001", d2 = {"Landroidx/compose/foundation/text/LegacyTextFieldState;", "", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "(Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/runtime/RecomposeScope;Landroidx/compose/ui/platform/SoftwareKeyboardController;)V", "_layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "<set-?>", "Landroidx/compose/ui/text/TextRange;", "deletionPreviewHighlightRange", "getDeletionPreviewHighlightRange-d9O1mEE", "()J", "setDeletionPreviewHighlightRange-5zc-tL8", "(J)V", "deletionPreviewHighlightRange$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/HandleState;", "handleState", "getHandleState", "()Landroidx/compose/foundation/text/HandleState;", "setHandleState", "(Landroidx/compose/foundation/text/HandleState;)V", "handleState$delegate", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "highlightPaint", "Landroidx/compose/ui/graphics/Paint;", "getHighlightPaint", "()Landroidx/compose/ui/graphics/Paint;", "inputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "getInputSession", "()Landroidx/compose/ui/text/input/TextInputSession;", "setInputSession", "(Landroidx/compose/ui/text/input/TextInputSession;)V", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "isLayoutResultStale", "keyboardActionRunner", "Landroidx/compose/foundation/text/KeyboardActionRunner;", "getKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "value", "layoutCoordinates", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "layoutResult", "getLayoutResult", "()Landroidx/compose/foundation/text/TextLayoutResultProxy;", "setLayoutResult", "(Landroidx/compose/foundation/text/TextLayoutResultProxy;)V", "layoutResultState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/unit/Dp;", "minHeightForSingleLineField", "getMinHeightForSingleLineField-D9Ej5fM", "()F", "setMinHeightForSingleLineField-0680j_4", "(F)V", "minHeightForSingleLineField$delegate", "onImeActionPerformed", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/ImeAction;", "", "getOnImeActionPerformed", "()Lkotlin/jvm/functions/Function1;", "onValueChange", "Landroidx/compose/ui/text/input/TextFieldValue;", "getOnValueChange", "onValueChangeOriginal", "processor", "Landroidx/compose/ui/text/input/EditProcessor;", "getProcessor", "()Landroidx/compose/ui/text/input/EditProcessor;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "selectionBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "getSelectionBackgroundColor-0d7_KjU", "setSelectionBackgroundColor-8_81llA", "J", "selectionPreviewHighlightRange", "getSelectionPreviewHighlightRange-d9O1mEE", "setSelectionPreviewHighlightRange-5zc-tL8", "selectionPreviewHighlightRange$delegate", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "showFloatingToolbar", "getShowFloatingToolbar", "setShowFloatingToolbar", "showFloatingToolbar$delegate", "showSelectionHandleEnd", "getShowSelectionHandleEnd", "setShowSelectionHandleEnd", "showSelectionHandleEnd$delegate", "showSelectionHandleStart", "getShowSelectionHandleStart", "setShowSelectionHandleStart", "showSelectionHandleStart$delegate", "getTextDelegate", "()Landroidx/compose/foundation/text/TextDelegate;", "setTextDelegate", "(Landroidx/compose/foundation/text/TextDelegate;)V", "untransformedText", "Landroidx/compose/ui/text/AnnotatedString;", "getUntransformedText", "()Landroidx/compose/ui/text/AnnotatedString;", "setUntransformedText", "(Landroidx/compose/ui/text/AnnotatedString;)V", "hasHighlight", "update", "visualText", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "softWrap", "density", "Landroidx/compose/ui/unit/Density;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "update-fnh65Uc", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/ui/focus/FocusManager;J)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LegacyTextFieldState {

    public static final int $stable = 8;
    private LayoutCoordinates _layoutCoordinates;
    private final MutableState deletionPreviewHighlightRange$delegate;
    private final MutableState handleState$delegate;
    private final MutableState hasFocus$delegate;
    private final Paint highlightPaint;
    private TextInputSession inputSession;
    private final MutableState isInTouchMode$delegate;
    private boolean isLayoutResultStale = true;
    private final androidx.compose.foundation.text.KeyboardActionRunner keyboardActionRunner;
    private final SoftwareKeyboardController keyboardController;
    private final MutableState<androidx.compose.foundation.text.TextLayoutResultProxy> layoutResultState;
    private final MutableState minHeightForSingleLineField$delegate;
    private final Function1<ImeAction, Unit> onImeActionPerformed;
    private final Function1<TextFieldValue, Unit> onValueChange;
    private Function1<? super TextFieldValue, Unit> onValueChangeOriginal;
    private final EditProcessor processor;
    private final RecomposeScope recomposeScope;
    private long selectionBackgroundColor;
    private final MutableState selectionPreviewHighlightRange$delegate;
    private final MutableState showCursorHandle$delegate;
    private final MutableState showFloatingToolbar$delegate;
    private final MutableState showSelectionHandleEnd$delegate;
    private final MutableState showSelectionHandleStart$delegate;
    private androidx.compose.foundation.text.TextDelegate textDelegate;
    private AnnotatedString untransformedText;
    static {
        final int i = 8;
    }

    public LegacyTextFieldState(androidx.compose.foundation.text.TextDelegate textDelegate, RecomposeScope recomposeScope, SoftwareKeyboardController keyboardController) {
        super();
        this.textDelegate = textDelegate;
        this.recomposeScope = recomposeScope;
        this.keyboardController = keyboardController;
        EditProcessor editProcessor = new EditProcessor();
        this.processor = editProcessor;
        Boolean valueOf = false;
        final int i3 = 0;
        final int i4 = 2;
        this.hasFocus$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i3, i4, i3);
        final int i6 = 0;
        this.minHeightForSingleLineField$delegate = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl((float)i5)), i3, i4, i3);
        this.layoutResultState = SnapshotStateKt.mutableStateOf$default(i3, i3, i4, i3);
        this.handleState$delegate = SnapshotStateKt.mutableStateOf$default(HandleState.None, i3, i4, i3);
        this.showFloatingToolbar$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i3, i4, i3);
        this.showSelectionHandleStart$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i3, i4, i3);
        this.showSelectionHandleEnd$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i3, i4, i3);
        this.showCursorHandle$delegate = SnapshotStateKt.mutableStateOf$default(valueOf, i3, i4, i3);
        this.isInTouchMode$delegate = SnapshotStateKt.mutableStateOf$default(true, i3, i4, i3);
        KeyboardActionRunner keyboardActionRunner = new KeyboardActionRunner(this.keyboardController);
        this.keyboardActionRunner = keyboardActionRunner;
        this.onValueChangeOriginal = (Function1)LegacyTextFieldState.onValueChangeOriginal.1.INSTANCE;
        LegacyTextFieldState.onValueChange.1 anon = new LegacyTextFieldState.onValueChange.1(this);
        this.onValueChange = (Function1)anon;
        LegacyTextFieldState.onImeActionPerformed.1 anon2 = new LegacyTextFieldState.onImeActionPerformed.1(this);
        this.onImeActionPerformed = (Function1)anon2;
        this.highlightPaint = AndroidPaint_androidKt.Paint();
        this.selectionBackgroundColor = Color.Companion.getUnspecified-0d7_KjU();
        this.selectionPreviewHighlightRange$delegate = SnapshotStateKt.mutableStateOf$default(TextRange.box-impl(TextRange.Companion.getZero-d9O1mEE()), i3, i4, i3);
        this.deletionPreviewHighlightRange$delegate = SnapshotStateKt.mutableStateOf$default(TextRange.box-impl(TextRange.Companion.getZero-d9O1mEE()), i3, i4, i3);
    }

    public static final androidx.compose.foundation.text.KeyboardActionRunner access$getKeyboardActionRunner$p(androidx.compose.foundation.text.LegacyTextFieldState $this) {
        return $this.keyboardActionRunner;
    }

    public static final Function1 access$getOnValueChangeOriginal$p(androidx.compose.foundation.text.LegacyTextFieldState $this) {
        return $this.onValueChangeOriginal;
    }

    public final long getDeletionPreviewHighlightRange-d9O1mEE() {
        final int i = 0;
        final int i2 = 0;
        return (TextRange)(State)this.deletionPreviewHighlightRange$delegate.getValue().unbox-impl();
    }

    public final androidx.compose.foundation.text.HandleState getHandleState() {
        final int i = 0;
        final int i2 = 0;
        return (HandleState)(State)this.handleState$delegate.getValue();
    }

    public final boolean getHasFocus() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.hasFocus$delegate.getValue().booleanValue();
    }

    public final Paint getHighlightPaint() {
        return this.highlightPaint;
    }

    public final TextInputSession getInputSession() {
        return this.inputSession;
    }

    public final SoftwareKeyboardController getKeyboardController() {
        return this.keyboardController;
    }

    public final LayoutCoordinates getLayoutCoordinates() {
        int _layoutCoordinates;
        boolean it;
        int i;
        _layoutCoordinates = this._layoutCoordinates;
        i = 0;
        if (_layoutCoordinates != null && _layoutCoordinates.isAttached()) {
            i = 0;
            if (_layoutCoordinates.isAttached()) {
            } else {
                _layoutCoordinates = i2;
            }
        } else {
        }
        return _layoutCoordinates;
    }

    public final androidx.compose.foundation.text.TextLayoutResultProxy getLayoutResult() {
        return (TextLayoutResultProxy)this.layoutResultState.getValue();
    }

    public final float getMinHeightForSingleLineField-D9Ej5fM() {
        final int i = 0;
        final int i2 = 0;
        return (Dp)(State)this.minHeightForSingleLineField$delegate.getValue().unbox-impl();
    }

    public final Function1<ImeAction, Unit> getOnImeActionPerformed() {
        return this.onImeActionPerformed;
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange() {
        return this.onValueChange;
    }

    public final EditProcessor getProcessor() {
        return this.processor;
    }

    public final RecomposeScope getRecomposeScope() {
        return this.recomposeScope;
    }

    public final long getSelectionBackgroundColor-0d7_KjU() {
        return this.selectionBackgroundColor;
    }

    public final long getSelectionPreviewHighlightRange-d9O1mEE() {
        final int i = 0;
        final int i2 = 0;
        return (TextRange)(State)this.selectionPreviewHighlightRange$delegate.getValue().unbox-impl();
    }

    public final boolean getShowCursorHandle() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.showCursorHandle$delegate.getValue().booleanValue();
    }

    public final boolean getShowFloatingToolbar() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.showFloatingToolbar$delegate.getValue().booleanValue();
    }

    public final boolean getShowSelectionHandleEnd() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.showSelectionHandleEnd$delegate.getValue().booleanValue();
    }

    public final boolean getShowSelectionHandleStart() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.showSelectionHandleStart$delegate.getValue().booleanValue();
    }

    public final androidx.compose.foundation.text.TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public final AnnotatedString getUntransformedText() {
        return this.untransformedText;
    }

    public final boolean hasHighlight() {
        int i;
        boolean collapsed-impl;
        if (TextRange.getCollapsed-impl(getSelectionPreviewHighlightRange-d9O1mEE())) {
            if (!TextRange.getCollapsed-impl(getDeletionPreviewHighlightRange-d9O1mEE())) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final boolean isInTouchMode() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isInTouchMode$delegate.getValue().booleanValue();
    }

    public final boolean isLayoutResultStale() {
        return this.isLayoutResultStale;
    }

    public final void setDeletionPreviewHighlightRange-5zc-tL8(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.deletionPreviewHighlightRange$delegate.setValue(TextRange.box-impl(<set-?>));
    }

    public final void setHandleState(androidx.compose.foundation.text.HandleState <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.handleState$delegate.setValue(<set-?>);
    }

    public final void setHasFocus(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.hasFocus$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    public final void setInTouchMode(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isInTouchMode$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    public final void setInputSession(TextInputSession <set-?>) {
        this.inputSession = <set-?>;
    }

    public final void setLayoutCoordinates(LayoutCoordinates value) {
        this._layoutCoordinates = value;
    }

    public final void setLayoutResult(androidx.compose.foundation.text.TextLayoutResultProxy value) {
        this.layoutResultState.setValue(value);
        this.isLayoutResultStale = false;
    }

    public final void setMinHeightForSingleLineField-0680j_4(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.minHeightForSingleLineField$delegate.setValue(Dp.box-impl(<set-?>));
    }

    public final void setSelectionBackgroundColor-8_81llA(long <set-?>) {
        this.selectionBackgroundColor = <set-?>;
    }

    public final void setSelectionPreviewHighlightRange-5zc-tL8(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.selectionPreviewHighlightRange$delegate.setValue(TextRange.box-impl(<set-?>));
    }

    public final void setShowCursorHandle(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.showCursorHandle$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    public final void setShowFloatingToolbar(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.showFloatingToolbar$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    public final void setShowSelectionHandleEnd(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.showSelectionHandleEnd$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    public final void setShowSelectionHandleStart(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.showSelectionHandleStart$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    public final void setTextDelegate(androidx.compose.foundation.text.TextDelegate <set-?>) {
        this.textDelegate = <set-?>;
    }

    public final void setUntransformedText(AnnotatedString <set-?>) {
        this.untransformedText = <set-?>;
    }

    public final void update-fnh65Uc(AnnotatedString untransformedText, AnnotatedString visualText, TextStyle textStyle, boolean softWrap, Density density, FontFamily.Resolver fontFamilyResolver, Function1<? super TextFieldValue, Unit> onValueChange, androidx.compose.foundation.text.KeyboardActions keyboardActions, FocusManager focusManager, long selectionBackgroundColor) {
        androidx.compose.foundation.text.TextDelegate textDelegate;
        final Object obj = this;
        obj.onValueChangeOriginal = onValueChange;
        obj.selectionBackgroundColor = selectionBackgroundColor;
        androidx.compose.foundation.text.KeyboardActionRunner keyboardActionRunner = obj.keyboardActionRunner;
        int i = 0;
        keyboardActionRunner.setKeyboardActions(keyboardActions);
        keyboardActionRunner.setFocusManager(focusManager);
        obj.untransformedText = untransformedText;
        androidx.compose.foundation.text.TextDelegate textDelegate-rm0N8CA$default = TextDelegateKt.updateTextDelegate-rm0N8CA$default(obj.textDelegate, visualText, textStyle, density, fontFamilyResolver, softWrap, 0, 0, 0, CollectionsKt.emptyList(), 448, 0);
        if (obj.textDelegate != textDelegate-rm0N8CA$default) {
            obj.isLayoutResultStale = true;
        }
        obj.textDelegate = textDelegate-rm0N8CA$default;
    }
}

package androidx.compose.ui.text.input;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo.Builder;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Deprecated(message = "Only exists to support the legacy TextInputService APIs. It is not used by any Compose code. A copy of this class in foundation is used by the legacy BasicTextField.")
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\"\u001a\u00020\u001dJ6\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ\u0008\u0010&\u001a\u00020\u001dH\u0002JB\u0010'\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0013\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u000cR\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006(", d2 = {"Landroidx/compose/ui/text/input/CursorAnchorInfoController;", "", "rootPositionCalculator", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "(Landroidx/compose/ui/input/pointer/PositionCalculator;Landroidx/compose/ui/text/input/InputMethodManager;)V", "androidMatrix", "Landroid/graphics/Matrix;", "builder", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "decorationBoxBounds", "Landroidx/compose/ui/geometry/Rect;", "hasPendingImmediateRequest", "", "includeCharacterBounds", "includeEditorBounds", "includeInsertionMarker", "includeLineBounds", "innerTextFieldBounds", "lock", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "monitorEnabled", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textFieldToRootTransform", "Lkotlin/Function1;", "", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "invalidate", "requestUpdate", "immediate", "monitor", "updateCursorAnchorInfo", "updateTextLayoutResult", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CursorAnchorInfoController {

    public static final int $stable = 8;
    private final Matrix androidMatrix;
    private final CursorAnchorInfo.Builder builder;
    private Rect decorationBoxBounds;
    private boolean hasPendingImmediateRequest;
    private boolean includeCharacterBounds;
    private boolean includeEditorBounds;
    private boolean includeInsertionMarker;
    private boolean includeLineBounds;
    private Rect innerTextFieldBounds;
    private final androidx.compose.ui.text.input.InputMethodManager inputMethodManager;
    private final Object lock;
    private final float[] matrix;
    private boolean monitorEnabled;
    private androidx.compose.ui.text.input.OffsetMapping offsetMapping;
    private final PositionCalculator rootPositionCalculator;
    private Function1<? super Matrix, Unit> textFieldToRootTransform;
    private androidx.compose.ui.text.input.TextFieldValue textFieldValue;
    private TextLayoutResult textLayoutResult;
    static {
        final int i = 8;
    }

    public CursorAnchorInfoController(PositionCalculator rootPositionCalculator, androidx.compose.ui.text.input.InputMethodManager inputMethodManager) {
        super();
        this.rootPositionCalculator = rootPositionCalculator;
        this.inputMethodManager = inputMethodManager;
        Object object = new Object();
        this.lock = object;
        this.textFieldToRootTransform = (Function1)CursorAnchorInfoController.textFieldToRootTransform.1.INSTANCE;
        CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
        this.builder = builder;
        int i = 0;
        this.matrix = Matrix.constructor-impl$default(i, 1, i);
        Matrix matrix = new Matrix();
        this.androidMatrix = matrix;
    }

    private final void updateCursorAnchorInfo() {
        if (!this.inputMethodManager.isActive()) {
        }
        this.textFieldToRootTransform.invoke(Matrix.box-impl(this.matrix));
        this.rootPositionCalculator.localToScreen-58bKbWc(this.matrix);
        AndroidMatrixConversions_androidKt.setFrom-EL8BTi8(this.androidMatrix, this.matrix);
        final androidx.compose.ui.text.input.TextFieldValue textFieldValue = this.textFieldValue;
        Intrinsics.checkNotNull(textFieldValue);
        final androidx.compose.ui.text.input.OffsetMapping offsetMapping = this.offsetMapping;
        Intrinsics.checkNotNull(offsetMapping);
        final TextLayoutResult textLayoutResult = this.textLayoutResult;
        Intrinsics.checkNotNull(textLayoutResult);
        final Rect innerTextFieldBounds = this.innerTextFieldBounds;
        Intrinsics.checkNotNull(innerTextFieldBounds);
        final Rect decorationBoxBounds = this.decorationBoxBounds;
        Intrinsics.checkNotNull(decorationBoxBounds);
        this.inputMethodManager.updateCursorAnchorInfo(CursorAnchorInfoBuilder_androidKt.build(this.builder, textFieldValue, offsetMapping, textLayoutResult, this.androidMatrix, innerTextFieldBounds, decorationBoxBounds, this.includeInsertionMarker, this.includeCharacterBounds, this.includeEditorBounds, this.includeLineBounds));
        this.hasPendingImmediateRequest = false;
    }

    public final void invalidate() {
        final Object lock = this.lock;
        int i = 0;
        final int i2 = 0;
        this.textFieldValue = i2;
        this.offsetMapping = i2;
        this.textLayoutResult = i2;
        this.textFieldToRootTransform = (Function1)CursorAnchorInfoController.invalidate.1.1.INSTANCE;
        this.innerTextFieldBounds = i2;
        this.decorationBoxBounds = i2;
        Unit iNSTANCE = Unit.INSTANCE;
        return;
        synchronized (lock) {
            lock = this.lock;
            i = 0;
            i2 = 0;
            this.textFieldValue = i2;
            this.offsetMapping = i2;
            this.textLayoutResult = i2;
            this.textFieldToRootTransform = (Function1)CursorAnchorInfoController.invalidate.1.1.INSTANCE;
            this.innerTextFieldBounds = i2;
            this.decorationBoxBounds = i2;
            iNSTANCE = Unit.INSTANCE;
        }
    }

    public final void requestUpdate(boolean immediate, boolean monitor, boolean includeInsertionMarker, boolean includeCharacterBounds, boolean includeEditorBounds, boolean includeLineBounds) {
        androidx.compose.ui.text.input.TextFieldValue textFieldValue;
        final Object lock = this.lock;
        int i = 0;
        this.includeInsertionMarker = includeInsertionMarker;
        this.includeCharacterBounds = includeCharacterBounds;
        this.includeEditorBounds = includeEditorBounds;
        this.includeLineBounds = includeLineBounds;
        synchronized (lock) {
            this.hasPendingImmediateRequest = true;
            if (this.textFieldValue != null) {
                updateCursorAnchorInfo();
            }
            this.monitorEnabled = monitor;
            Unit iNSTANCE = Unit.INSTANCE;
        }
    }

    public final void updateTextLayoutResult(androidx.compose.ui.text.input.TextFieldValue textFieldValue, androidx.compose.ui.text.input.OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Function1<? super Matrix, Unit> textFieldToRootTransform, Rect innerTextFieldBounds, Rect decorationBoxBounds) {
        boolean hasPendingImmediateRequest;
        final Object lock = this.lock;
        int i = 0;
        this.textFieldValue = textFieldValue;
        this.offsetMapping = offsetMapping;
        this.textLayoutResult = textLayoutResult;
        this.textFieldToRootTransform = textFieldToRootTransform;
        this.innerTextFieldBounds = innerTextFieldBounds;
        this.decorationBoxBounds = decorationBoxBounds;
        synchronized (lock) {
            if (this.monitorEnabled) {
                updateCursorAnchorInfo();
            }
            Unit iNSTANCE = Unit.INSTANCE;
        }
    }
}

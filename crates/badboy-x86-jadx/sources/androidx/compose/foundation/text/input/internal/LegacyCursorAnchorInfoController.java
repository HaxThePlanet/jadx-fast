package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo.Builder;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0000\u0018\u00002\u00020\u0001B!\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010 \u001a\u00020\u0005J6\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010J\u0008\u0010$\u001a\u00020\u0005H\u0002J.\u0010%\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006&", d2 = {"Landroidx/compose/foundation/text/input/internal/LegacyCursorAnchorInfoController;", "", "localToScreen", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Matrix;", "", "inputMethodManager", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/input/internal/InputMethodManager;)V", "androidMatrix", "Landroid/graphics/Matrix;", "builder", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "decorationBoxBounds", "Landroidx/compose/ui/geometry/Rect;", "hasPendingImmediateRequest", "", "includeCharacterBounds", "includeEditorBounds", "includeInsertionMarker", "includeLineBounds", "innerTextFieldBounds", "lock", "matrix", "[F", "monitorEnabled", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "invalidate", "requestUpdate", "immediate", "monitor", "updateCursorAnchorInfo", "updateTextLayoutResult", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LegacyCursorAnchorInfoController {

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
    private final androidx.compose.foundation.text.input.internal.InputMethodManager inputMethodManager;
    private final Function1<Matrix, Unit> localToScreen;
    private final Object lock;
    private final float[] matrix;
    private boolean monitorEnabled;
    private OffsetMapping offsetMapping;
    private TextFieldValue textFieldValue;
    private TextLayoutResult textLayoutResult;
    static {
        final int i = 8;
    }

    public LegacyCursorAnchorInfoController(Function1<? super Matrix, Unit> localToScreen, androidx.compose.foundation.text.input.internal.InputMethodManager inputMethodManager) {
        super();
        this.localToScreen = localToScreen;
        this.inputMethodManager = inputMethodManager;
        Object object = new Object();
        this.lock = object;
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
        Matrix.reset-impl(this.matrix);
        this.localToScreen.invoke(Matrix.box-impl(this.matrix));
        Rect decorationBoxBounds = this.decorationBoxBounds;
        Intrinsics.checkNotNull(decorationBoxBounds);
        Rect decorationBoxBounds2 = this.decorationBoxBounds;
        Intrinsics.checkNotNull(decorationBoxBounds2);
        Matrix.translate-impl(this.matrix, -left, -top, 0);
        AndroidMatrixConversions_androidKt.setFrom-EL8BTi8(this.androidMatrix, this.matrix);
        TextFieldValue textFieldValue = this.textFieldValue;
        Intrinsics.checkNotNull(textFieldValue);
        OffsetMapping offsetMapping = this.offsetMapping;
        Intrinsics.checkNotNull(offsetMapping);
        final TextLayoutResult textLayoutResult = this.textLayoutResult;
        Intrinsics.checkNotNull(textLayoutResult);
        final Rect innerTextFieldBounds = this.innerTextFieldBounds;
        Intrinsics.checkNotNull(innerTextFieldBounds);
        final Rect decorationBoxBounds3 = this.decorationBoxBounds;
        Intrinsics.checkNotNull(decorationBoxBounds3);
        this.inputMethodManager.updateCursorAnchorInfo(LegacyCursorAnchorInfoBuilder_androidKt.build(this.builder, textFieldValue, offsetMapping, textLayoutResult, this.androidMatrix, innerTextFieldBounds, decorationBoxBounds3, this.includeInsertionMarker, this.includeCharacterBounds, this.includeEditorBounds, this.includeLineBounds));
        this.hasPendingImmediateRequest = false;
    }

    public final void invalidate() {
        final Object lock = this.lock;
        int i = 0;
        final int i2 = 0;
        this.textFieldValue = i2;
        this.offsetMapping = i2;
        this.textLayoutResult = i2;
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
            this.innerTextFieldBounds = i2;
            this.decorationBoxBounds = i2;
            iNSTANCE = Unit.INSTANCE;
        }
    }

    public final void requestUpdate(boolean immediate, boolean monitor, boolean includeInsertionMarker, boolean includeCharacterBounds, boolean includeEditorBounds, boolean includeLineBounds) {
        TextFieldValue textFieldValue;
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

    public final void updateTextLayoutResult(TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Rect innerTextFieldBounds, Rect decorationBoxBounds) {
        boolean hasPendingImmediateRequest;
        final Object lock = this.lock;
        int i = 0;
        this.textFieldValue = textFieldValue;
        this.offsetMapping = offsetMapping;
        this.textLayoutResult = textLayoutResult;
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

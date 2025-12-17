package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.CursorAnchorInfo.Builder;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Job.DefaultImpls;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J8\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"J\u0008\u0010#\u001a\u00020\u001eH\u0002R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006$", d2 = {"Landroidx/compose/foundation/text/input/internal/CursorAnchorInfoController;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "composeImm", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;", "monitorScope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManager;Lkotlinx/coroutines/CoroutineScope;)V", "androidMatrix", "Landroid/graphics/Matrix;", "builder", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "hasPendingImmediateRequest", "", "includeCharacterBounds", "includeEditorBounds", "includeInsertionMarker", "includeLineBounds", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "monitorEnabled", "monitorJob", "Lkotlinx/coroutines/Job;", "calculateCursorAnchorInfo", "Landroid/view/inputmethod/CursorAnchorInfo;", "requestUpdates", "", "immediate", "monitor", "cursorUpdateMode", "", "startOrStopMonitoring", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CursorAnchorInfoController {

    public static final int $stable = 8;
    private final Matrix androidMatrix;
    private final CursorAnchorInfo.Builder builder;
    private final androidx.compose.foundation.text.input.internal.ComposeInputMethodManager composeImm;
    private boolean hasPendingImmediateRequest;
    private boolean includeCharacterBounds;
    private boolean includeEditorBounds;
    private boolean includeInsertionMarker;
    private boolean includeLineBounds;
    private final float[] matrix;
    private boolean monitorEnabled;
    private Job monitorJob;
    private final CoroutineScope monitorScope;
    private final androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState;
    private final androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState;
    static {
        final int i = 8;
    }

    public CursorAnchorInfoController(androidx.compose.foundation.text.input.internal.TransformedTextFieldState textFieldState, androidx.compose.foundation.text.input.internal.TextLayoutState textLayoutState, androidx.compose.foundation.text.input.internal.ComposeInputMethodManager composeImm, CoroutineScope monitorScope) {
        super();
        this.textFieldState = textFieldState;
        this.textLayoutState = textLayoutState;
        this.composeImm = composeImm;
        this.monitorScope = monitorScope;
        CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
        this.builder = builder;
        int i = 0;
        this.matrix = Matrix.constructor-impl$default(i, 1, i);
        Matrix matrix = new Matrix();
        this.androidMatrix = matrix;
    }

    public static final CursorAnchorInfo access$calculateCursorAnchorInfo(androidx.compose.foundation.text.input.internal.CursorAnchorInfoController $this) {
        return $this.calculateCursorAnchorInfo();
    }

    public static final androidx.compose.foundation.text.input.internal.ComposeInputMethodManager access$getComposeImm$p(androidx.compose.foundation.text.input.internal.CursorAnchorInfoController $this) {
        return $this.composeImm;
    }

    private final CursorAnchorInfo calculateCursorAnchorInfo() {
        int textLayoutNodeCoordinates;
        LayoutCoordinates coreNodeCoordinates;
        boolean it3;
        LayoutCoordinates decoratorNodeCoordinates;
        int it2;
        boolean it;
        int i;
        int textLayoutCoordinates2;
        int textLayoutCoordinates;
        final Object obj = this;
        textLayoutNodeCoordinates = obj.textLayoutState.getTextLayoutNodeCoordinates();
        int i2 = 0;
        if (textLayoutNodeCoordinates != null) {
            it2 = 0;
            if (textLayoutNodeCoordinates.isAttached()) {
            } else {
                textLayoutNodeCoordinates = i2;
            }
            if (textLayoutNodeCoordinates != 0) {
                coreNodeCoordinates = obj.textLayoutState.getCoreNodeCoordinates();
                if (coreNodeCoordinates != null) {
                    it = 0;
                    if (coreNodeCoordinates.isAttached()) {
                    } else {
                        coreNodeCoordinates = i2;
                    }
                    if (coreNodeCoordinates != null) {
                        decoratorNodeCoordinates = obj.textLayoutState.getDecoratorNodeCoordinates();
                        if (decoratorNodeCoordinates != null) {
                            i = 0;
                            if (decoratorNodeCoordinates.isAttached()) {
                            } else {
                                decoratorNodeCoordinates = i2;
                            }
                            androidx.compose.ui.text.TextLayoutResult layoutResult = obj.textLayoutState.getLayoutResult();
                            if (decoratorNodeCoordinates != null && layoutResult == null) {
                                layoutResult = obj.textLayoutState.getLayoutResult();
                                if (layoutResult == null) {
                                    return i2;
                                }
                                TextFieldCharSequence visualText = obj.textFieldState.getVisualText();
                                Matrix.reset-impl(obj.matrix);
                                textLayoutNodeCoordinates.transformToScreen-58bKbWc(obj.matrix);
                                AndroidMatrixConversions_androidKt.setFrom-EL8BTi8(obj.androidMatrix, obj.matrix);
                                int i3 = textLayoutNodeCoordinates;
                                return CursorAnchorInfoBuilder_androidKt.build-vxqZcH0(obj.builder, (CharSequence)visualText, visualText.getSelection-d9O1mEE(), obj9, visualText.getComposition-MzsxiRA(), layoutResult, obj.androidMatrix, SelectionManagerKt.visibleBounds(coreNodeCoordinates).translate-k-4lQ0M(textLayoutNodeCoordinates.localPositionOf-R5De75A(coreNodeCoordinates, Offset.Companion.getZero-F1C5BW0())), SelectionManagerKt.visibleBounds(decoratorNodeCoordinates).translate-k-4lQ0M(textLayoutNodeCoordinates.localPositionOf-R5De75A(decoratorNodeCoordinates, Offset.Companion.getZero-F1C5BW0())), obj.includeInsertionMarker, obj.includeCharacterBounds, obj.includeEditorBounds);
                            }
                            textLayoutCoordinates2 = textLayoutNodeCoordinates;
                        } else {
                            textLayoutCoordinates2 = textLayoutNodeCoordinates;
                        }
                        return i2;
                    }
                    textLayoutCoordinates = textLayoutNodeCoordinates;
                } else {
                    textLayoutCoordinates = textLayoutNodeCoordinates;
                }
                return i2;
            }
        }
        return i2;
    }

    private final void requestUpdates(boolean immediate, boolean monitor, boolean includeInsertionMarker, boolean includeCharacterBounds, boolean includeEditorBounds, boolean includeLineBounds) {
        CursorAnchorInfo cursorAnchorInfo;
        androidx.compose.foundation.text.input.internal.ComposeInputMethodManager composeImm;
        int i;
        this.includeInsertionMarker = includeInsertionMarker;
        this.includeCharacterBounds = includeCharacterBounds;
        this.includeEditorBounds = includeEditorBounds;
        this.includeLineBounds = includeLineBounds;
        this.hasPendingImmediateRequest = true;
        cursorAnchorInfo = calculateCursorAnchorInfo();
        if (immediate && cursorAnchorInfo != null) {
            this.hasPendingImmediateRequest = true;
            cursorAnchorInfo = calculateCursorAnchorInfo();
            if (cursorAnchorInfo != null) {
                i = 0;
                this.composeImm.updateCursorAnchorInfo(cursorAnchorInfo);
            }
        }
        this.monitorEnabled = monitor;
        startOrStopMonitoring();
    }

    private final void startOrStopMonitoring() {
        Job monitorJob;
        int i2;
        int monitorScope;
        int i3;
        CoroutineStart uNDISPATCHED;
        androidx.compose.foundation.text.input.internal.CursorAnchorInfoController.startOrStopMonitoring.1 anon;
        int i4;
        int i;
        i2 = 1;
        final int i5 = 0;
        if (this.monitorEnabled) {
            monitorJob = this.monitorJob;
            if (monitorJob != null && monitorJob.isActive() == i2) {
                if (monitorJob.isActive() == i2) {
                } else {
                    i2 = monitorScope;
                }
            } else {
            }
            if (i2 == 0) {
                CursorAnchorInfoController.startOrStopMonitoring.1 anon2 = new CursorAnchorInfoController.startOrStopMonitoring.1(this, i5);
                this.monitorJob = BuildersKt.launch$default(this.monitorScope, 0, CoroutineStart.UNDISPATCHED, (Function2)anon2, 1, 0);
            }
        } else {
            monitorJob = this.monitorJob;
            if (monitorJob != null) {
                Job.DefaultImpls.cancel$default(monitorJob, i5, i2, i5);
            }
            this.monitorJob = i5;
        }
    }

    public final void requestUpdates(int cursorUpdateMode) {
        int i2;
        int includeInsertionMarker;
        int sDK_INT;
        int includeCharacterBounds;
        int i3;
        int includeEditorBounds;
        int includeLineBounds;
        int includeLineBounds2;
        int i6;
        int i4;
        int i;
        int sDK_INT2;
        int i5;
        int i7;
        sDK_INT = 0;
        final int i10 = 1;
        i2 = cursorUpdateMode & 1 != 0 ? i10 : sDK_INT;
        i3 = cursorUpdateMode & 2 != 0 ? i10 : sDK_INT;
        if (Build.VERSION.SDK_INT >= 33) {
            i6 = cursorUpdateMode & 16 != 0 ? i10 : sDK_INT;
            includeInsertionMarker = i6;
            i4 = cursorUpdateMode & 8 != 0 ? i10 : sDK_INT;
            includeCharacterBounds = i4;
            i = cursorUpdateMode & 4 != 0 ? i10 : sDK_INT;
            int includeEditorBounds2 = i;
            int i17 = 34;
            if (Build.VERSION.SDK_INT >= i17 && cursorUpdateMode & 32 != 0) {
                if (cursorUpdateMode & 32 != 0) {
                    sDK_INT = i10;
                }
                includeLineBounds = sDK_INT;
            }
            if (includeInsertionMarker == 0 && includeCharacterBounds == 0 && includeEditorBounds2 == 0 && includeLineBounds == 0) {
                if (includeCharacterBounds == 0) {
                    if (includeEditorBounds2 == 0) {
                        if (includeLineBounds == 0) {
                            includeInsertionMarker = 1;
                            includeCharacterBounds = 1;
                            int includeEditorBounds3 = 1;
                            if (Build.VERSION.SDK_INT >= i17) {
                                i5 = includeEditorBounds3;
                                i7 = includeLineBounds3;
                                includeEditorBounds = includeInsertionMarker;
                                includeLineBounds2 = includeCharacterBounds;
                            } else {
                                i5 = includeEditorBounds3;
                                i7 = includeLineBounds;
                                includeEditorBounds = includeInsertionMarker;
                                includeLineBounds2 = includeCharacterBounds;
                            }
                        } else {
                            i5 = includeEditorBounds2;
                            i7 = includeLineBounds;
                            includeEditorBounds = includeInsertionMarker;
                            includeLineBounds2 = includeCharacterBounds;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
            i5 = i12;
            i7 = includeLineBounds;
            includeEditorBounds = includeInsertionMarker;
            includeLineBounds2 = includeCharacterBounds;
        }
        this.requestUpdates(i2, i3, includeEditorBounds, includeLineBounds2, i5, i7);
    }
}

package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.TextHighlightType.Companion;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextGranularity.Companion;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextInclusionStrategy.Companion;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.text.Regex;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008H\u0003J>\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008H\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013J,\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00162\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008H\u0003J8\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008H\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J&\u0010\u001e\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0002ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"J0\u0010#\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008H\u0003J\u001c\u0010#\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0003J0\u0010(\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008H\u0003J\u001c\u0010(\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0003J&\u0010*\u001a\u00020\n*\u00020\u001d2\u0006\u0010+\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-JA\u0010.\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0010/\u001a\u0004\u0018\u00010\u00192\u0008\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008H\u0001¢\u0006\u0002\u00082J+\u0010.\u001a\u00020\u0004*\u00020\u001d2\u0006\u00103\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'2\u0008\u00100\u001a\u0004\u0018\u000101H\u0001¢\u0006\u0002\u00082J2\u00104\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u0002052\u0008\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008H\u0003J&\u00104\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u0002052\u0006\u0010&\u001a\u00020'2\u0008\u00100\u001a\u0004\u0018\u000101H\u0003J:\u00106\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u0002072\u0006\u0010\u000e\u001a\u00020\u000f2\u0008\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008H\u0003J&\u00106\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u0002072\u0006\u0010&\u001a\u00020'2\u0008\u00100\u001a\u0004\u0018\u000101H\u0003J:\u00108\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u0002092\u0006\u0010\u000e\u001a\u00020\u000f2\u0008\u00100\u001a\u0004\u0018\u0001012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008H\u0003J&\u00108\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u0002092\u0006\u0010&\u001a\u00020'2\u0008\u00100\u001a\u0004\u0018\u000101H\u0003J2\u0010:\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020;2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008H\u0003J\u001c\u0010:\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020;2\u0006\u0010&\u001a\u00020'H\u0003J2\u0010<\u001a\u00020\u0004*\u00020$2\u0006\u0010\u0005\u001a\u00020=2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008H\u0003J\u001c\u0010<\u001a\u00020\u0004*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020=2\u0006\u0010&\u001a\u00020'H\u0003J\u001e\u0010>\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020%2\u0008\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010>\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0003J\u001e\u0010?\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020)2\u0008\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010?\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010&\u001a\u00020'H\u0003J-\u0010@\u001a\u00020\u0011*\u00020$2\u0006\u0010\u0005\u001a\u00020A2\u0008\u0010/\u001a\u0004\u0018\u00010\u00192\u0008\u0010B\u001a\u0004\u0018\u00010CH\u0001¢\u0006\u0002\u0008DJ+\u0010@\u001a\u00020\u0011*\u00020\u001d2\u0006\u00103\u001a\u00020A2\u0006\u0010&\u001a\u00020'2\u0008\u0010B\u001a\u0004\u0018\u00010CH\u0001¢\u0006\u0002\u0008DJ\u001e\u0010E\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020;2\u0008\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010E\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020;2\u0006\u0010&\u001a\u00020'H\u0003J\u001e\u0010F\u001a\u00020\n*\u00020$2\u0006\u0010\u0005\u001a\u00020=2\u0008\u0010/\u001a\u0004\u0018\u00010\u0019H\u0003J\u001c\u0010F\u001a\u00020\n*\u00020\u001d2\u0006\u0010\u0005\u001a\u00020=2\u0006\u0010&\u001a\u00020'H\u0003J\u0019\u0010G\u001a\u00020H*\u00020\u0004H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008I\u0010J\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006K", d2 = {"Landroidx/compose/foundation/text/input/internal/HandwritingGestureApi34;", "", "()V", "fallbackOnLegacyTextField", "", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "editCommandConsumer", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/EditCommand;", "", "performDeletionOnLegacyTextField", "range", "Landroidx/compose/ui/text/TextRange;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "adjustRange", "", "performDeletionOnLegacyTextField-vJH6DeI", "(JLandroidx/compose/ui/text/AnnotatedString;ZLkotlin/jvm/functions/Function1;)V", "performInsertionOnLegacyTextField", "offset", "", "performSelectionOnLegacyTextField", "textSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "performSelectionOnLegacyTextField-8ffj60Q", "(JLandroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function1;)V", "fallback", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "highlightRange", "type", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlightRange-XJREzCE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JI)V", "performDeleteGesture", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "Landroid/view/inputmethod/DeleteGesture;", "layoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "performDeleteRangeGesture", "Landroid/view/inputmethod/DeleteRangeGesture;", "performDeletion", "rangeInTransformedText", "performDeletion-Sb-Bc2M", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JZ)V", "performHandwritingGesture", "textFieldSelectionManager", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "performHandwritingGesture$foundation_release", "handwritingGesture", "performInsertGesture", "Landroid/view/inputmethod/InsertGesture;", "performJoinOrSplitGesture", "Landroid/view/inputmethod/JoinOrSplitGesture;", "performRemoveSpaceGesture", "Landroid/view/inputmethod/RemoveSpaceGesture;", "performSelectGesture", "Landroid/view/inputmethod/SelectGesture;", "performSelectRangeGesture", "Landroid/view/inputmethod/SelectRangeGesture;", "previewDeleteGesture", "previewDeleteRangeGesture", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "previewHandwritingGesture$foundation_release", "previewSelectGesture", "previewSelectRangeGesture", "toTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toTextGranularity-NUwxegE", "(I)I", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HandwritingGestureApi34 {

    public static final int $stable;
    public static final androidx.compose.foundation.text.input.internal.HandwritingGestureApi34 INSTANCE;
    public static void $r8$lambda$8nr13tCGwbbQRzAr0zojfE-zSzU(TextFieldSelectionManager textFieldSelectionManager) {
        HandwritingGestureApi34.previewHandwritingGesture$lambda$9(textFieldSelectionManager);
    }

    public static void $r8$lambda$SyCjAwtO30unj_g9LamP0q_Tjjs(androidx.compose.foundation.text.input.internal.TransformedTextFieldState transformedTextFieldState) {
        HandwritingGestureApi34.previewHandwritingGesture$lambda$1(transformedTextFieldState);
    }

    static {
        HandwritingGestureApi34 handwritingGestureApi34 = new HandwritingGestureApi34();
        HandwritingGestureApi34.INSTANCE = handwritingGestureApi34;
    }

    private final int fallback(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$fallback, HandwritingGesture gesture) {
        int i3 = 0;
        TextFieldState field2 = TransformedTextFieldState.access$getTextFieldState$p($this$fallback);
        int i6 = 0;
        field2.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        final int i9 = 0;
        field2.getMainBuffer$foundation_release().clearHighlight();
        TextFieldState.access$commitEditAsUser(field2, TransformedTextFieldState.access$getInputTransformation$p($this$fallback), true, TextFieldEditUndoBehavior.MergeIfPossible);
        String fallbackText = gesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        TransformedTextFieldState.replaceSelectedText$default($this$fallback, (CharSequence)fallbackText, true, 0, 4, 0);
        return 5;
    }

    private final int fallbackOnLegacyTextField(HandwritingGesture gesture, Function1<? super EditCommand, Unit> editCommandConsumer) {
        String fallbackText = gesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        CommitTextCommand commitTextCommand = new CommitTextCommand(fallbackText, 1);
        editCommandConsumer.invoke(commitTextCommand);
        return 5;
    }

    private final void highlightRange-XJREzCE(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$highlightRange_u2dXJREzCE, long range, int type) {
        int collapsed-impl;
        int i;
        TextFieldState field;
        androidx.compose.foundation.text.input.InputTransformation inputTransformation;
        TextFieldEditUndoBehavior mergeIfPossible;
        int i2;
        androidx.compose.foundation.text.input.internal.EditingBuffer mainBuffer$foundation_release;
        int i3;
        if (TextRange.getCollapsed-impl(range)) {
            i = 0;
            field = TransformedTextFieldState.access$getTextFieldState$p($this$highlightRange_u2dXJREzCE);
            i2 = 0;
            field.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
            i3 = 0;
            field.getMainBuffer$foundation_release().clearHighlight();
            TextFieldState.access$commitEditAsUser(field, TransformedTextFieldState.access$getInputTransformation$p($this$highlightRange_u2dXJREzCE), true, TextFieldEditUndoBehavior.MergeIfPossible);
        } else {
            $this$highlightRange_u2dXJREzCE.highlightCharsIn-7RAjNK8(obj12, range);
        }
    }

    private final int performDeleteGesture(LegacyTextFieldState $this$performDeleteGesture, DeleteGesture gesture, AnnotatedString text, Function1<? super EditCommand, Unit> editCommandConsumer) {
        int textGranularity-NUwxegE = toTextGranularity-NUwxegE(gesture.getGranularity());
        TextInclusionStrategy containsCenter = TextInclusionStrategy.Companion.getContainsCenter();
        long l = HandwritingGesture_androidKt.access$getRangeForScreenRect-OH9lIzo($this$performDeleteGesture, RectHelper_androidKt.toComposeRect(gesture.getDeletionArea()), textGranularity-NUwxegE, containsCenter);
        int i2 = 0;
        if (TextRange.getCollapsed-impl(l)) {
            return HandwritingGestureApi34.INSTANCE.fallbackOnLegacyTextField((HandwritingGesture)gesture, editCommandConsumer);
        }
        this.performDeletionOnLegacyTextField-vJH6DeI(l, containsCenter, text, TextGranularity.equals-impl0(textGranularity-NUwxegE, TextGranularity.Companion.getWord-DRrd7Zo()));
        return 1;
    }

    private final int performDeleteGesture(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$performDeleteGesture, DeleteGesture gesture, androidx.compose.foundation.text.input.internal.TextLayoutState layoutState) {
        int textGranularity-NUwxegE = toTextGranularity-NUwxegE(gesture.getGranularity());
        TextInclusionStrategy containsCenter = TextInclusionStrategy.Companion.getContainsCenter();
        long l = HandwritingGesture_androidKt.access$getRangeForScreenRect-OH9lIzo(layoutState, RectHelper_androidKt.toComposeRect(gesture.getDeletionArea()), textGranularity-NUwxegE, containsCenter);
        final int i2 = 0;
        if (TextRange.getCollapsed-impl(l)) {
            return HandwritingGestureApi34.INSTANCE.fallback($this$performDeleteGesture, (HandwritingGesture)gesture);
        }
        performDeletion-Sb-Bc2M($this$performDeleteGesture, l, containsCenter);
        return 1;
    }

    private final int performDeleteRangeGesture(LegacyTextFieldState $this$performDeleteRangeGesture, DeleteRangeGesture gesture, AnnotatedString text, Function1<? super EditCommand, Unit> editCommandConsumer) {
        int textGranularity-NUwxegE = toTextGranularity-NUwxegE(gesture.getGranularity());
        androidx.compose.ui.geometry.Rect composeRect2 = RectHelper_androidKt.toComposeRect(gesture.getDeletionEndArea());
        long l = HandwritingGesture_androidKt.access$getRangeForScreenRects-O048IG0($this$performDeleteRangeGesture, RectHelper_androidKt.toComposeRect(gesture.getDeletionStartArea()), composeRect2, textGranularity-NUwxegE, TextInclusionStrategy.Companion.getContainsCenter());
        int i2 = 0;
        if (TextRange.getCollapsed-impl(l)) {
            return HandwritingGestureApi34.INSTANCE.fallbackOnLegacyTextField((HandwritingGesture)gesture, editCommandConsumer);
        }
        this.performDeletionOnLegacyTextField-vJH6DeI(l, composeRect2, text, TextGranularity.equals-impl0(textGranularity-NUwxegE, TextGranularity.Companion.getWord-DRrd7Zo()));
        return 1;
    }

    private final int performDeleteRangeGesture(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$performDeleteRangeGesture, DeleteRangeGesture gesture, androidx.compose.foundation.text.input.internal.TextLayoutState layoutState) {
        int textGranularity-NUwxegE = toTextGranularity-NUwxegE(gesture.getGranularity());
        androidx.compose.ui.geometry.Rect composeRect2 = RectHelper_androidKt.toComposeRect(gesture.getDeletionEndArea());
        long l = HandwritingGesture_androidKt.access$getRangeForScreenRects-O048IG0(layoutState, RectHelper_androidKt.toComposeRect(gesture.getDeletionStartArea()), composeRect2, textGranularity-NUwxegE, TextInclusionStrategy.Companion.getContainsCenter());
        final int i2 = 0;
        if (TextRange.getCollapsed-impl(l)) {
            return HandwritingGestureApi34.INSTANCE.fallback($this$performDeleteRangeGesture, (HandwritingGesture)gesture);
        }
        performDeletion-Sb-Bc2M($this$performDeleteRangeGesture, l, composeRect2);
        return 1;
    }

    private final void performDeletion-Sb-Bc2M(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$performDeletion_u2dSb_u2dBc2M, long rangeInTransformedText, boolean adjustRange) {
        long l;
        if (obj14 != null) {
            l = HandwritingGesture_androidKt.access$adjustHandwritingDeleteGestureRange-72CqOWE(rangeInTransformedText, adjustRange);
        } else {
            l = rangeInTransformedText;
        }
        TransformedTextFieldState.replaceText-M8tDOmk$default($this$performDeletion_u2dSb_u2dBc2M, (CharSequence)"", l, obj5, false, 0, 12);
    }

    private final void performDeletionOnLegacyTextField-vJH6DeI(long range, AnnotatedString text, boolean adjustRange, Function1<? super EditCommand, Unit> editCommandConsumer) {
        long l;
        if (editCommandConsumer != null) {
            l = HandwritingGesture_androidKt.access$adjustHandwritingDeleteGestureRange-72CqOWE(range, text);
        } else {
            l = range;
        }
        EditCommand[] arr = new EditCommand[2];
        SetSelectionCommand setSelectionCommand = new SetSelectionCommand(TextRange.getEnd-impl(l), TextRange.getEnd-impl(l));
        int i3 = 0;
        arr[i3] = setSelectionCommand;
        DeleteSurroundingTextCommand deleteSurroundingTextCommand = new DeleteSurroundingTextCommand(TextRange.getLength-impl(l), i3);
        arr[1] = deleteSurroundingTextCommand;
        obj11.invoke(HandwritingGesture_androidKt.access$compoundEditCommand(arr));
    }

    private final int performInsertGesture(LegacyTextFieldState $this$performInsertGesture, InsertGesture gesture, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> editCommandConsumer) {
        TextLayoutResultProxy layoutResult;
        int i2;
        int i;
        if (viewConfiguration == null) {
            return fallbackOnLegacyTextField((HandwritingGesture)gesture, editCommandConsumer);
        }
        int i3 = HandwritingGesture_androidKt.access$getOffsetForHandwritingGesture-d-4ec7I($this$performInsertGesture, HandwritingGesture_androidKt.access$toOffset(gesture.getInsertionPoint()), obj1);
        layoutResult = $this$performInsertGesture.getLayoutResult();
        i2 = 0;
        i = 1;
        layoutResult = layoutResult.getValue();
        if (i3 != -1 && layoutResult != null && layoutResult != null && HandwritingGesture_androidKt.access$isBiDiBoundary(layoutResult, i3) == i) {
            layoutResult = $this$performInsertGesture.getLayoutResult();
            i2 = 0;
            i = 1;
            if (layoutResult != null) {
                layoutResult = layoutResult.getValue();
                if (layoutResult != null) {
                    if (HandwritingGesture_androidKt.access$isBiDiBoundary(layoutResult, i3) == i) {
                        i2 = i;
                    }
                }
            }
            if (i2 != 0) {
            }
            performInsertionOnLegacyTextField(i3, gesture.getTextToInsert(), editCommandConsumer);
            return i;
        }
        return fallbackOnLegacyTextField((HandwritingGesture)gesture, editCommandConsumer);
    }

    private final int performInsertGesture(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$performInsertGesture, InsertGesture gesture, androidx.compose.foundation.text.input.internal.TextLayoutState layoutState, ViewConfiguration viewConfiguration) {
        int i = HandwritingGesture_androidKt.access$getOffsetForHandwritingGesture-d-4ec7I(layoutState, HandwritingGesture_androidKt.access$toOffset(gesture.getInsertionPoint()), obj1);
        if (i == -1) {
            return fallback($this$performInsertGesture, (HandwritingGesture)gesture);
        }
        TransformedTextFieldState.replaceText-M8tDOmk$default($this$performInsertGesture, (CharSequence)gesture.getTextToInsert(), TextRangeKt.TextRange(i), obj5, false, 0, 12);
        return 1;
    }

    private final void performInsertionOnLegacyTextField(int offset, String text, Function1<? super EditCommand, Unit> editCommandConsumer) {
        EditCommand[] arr = new EditCommand[2];
        SetSelectionCommand setSelectionCommand = new SetSelectionCommand(offset, offset);
        int i3 = 1;
        CommitTextCommand commitTextCommand = new CommitTextCommand(text, i3);
        arr[i3] = commitTextCommand;
        editCommandConsumer.invoke(HandwritingGesture_androidKt.access$compoundEditCommand(arr));
    }

    private final int performJoinOrSplitGesture(LegacyTextFieldState $this$performJoinOrSplitGesture, JoinOrSplitGesture gesture, AnnotatedString text, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> editCommandConsumer) {
        TextLayoutResultProxy layoutResult;
        boolean collapsed-impl;
        int str;
        int i;
        Object obj;
        Object obj2;
        boolean z;
        java.lang.CharSequence charSequence;
        int i2;
        Function1 function1;
        Function1 function12;
        if (viewConfiguration == null) {
            return fallbackOnLegacyTextField((HandwritingGesture)gesture, editCommandConsumer);
        }
        int i3 = HandwritingGesture_androidKt.access$getOffsetForHandwritingGesture-d-4ec7I($this$performJoinOrSplitGesture, HandwritingGesture_androidKt.access$toOffset(gesture.getJoinOrSplitPoint()), obj1);
        layoutResult = $this$performJoinOrSplitGesture.getLayoutResult();
        str = 0;
        i = 1;
        layoutResult = layoutResult.getValue();
        if (i3 != -1 && layoutResult != null && layoutResult != null && HandwritingGesture_androidKt.access$isBiDiBoundary(layoutResult, i3) == i) {
            layoutResult = $this$performJoinOrSplitGesture.getLayoutResult();
            str = 0;
            i = 1;
            if (layoutResult != null) {
                layoutResult = layoutResult.getValue();
                if (layoutResult != null) {
                    if (HandwritingGesture_androidKt.access$isBiDiBoundary(layoutResult, i3) == i) {
                        str = i;
                    }
                }
            }
            if (str != null) {
                obj2 = this;
                charSequence = text;
                function12 = editCommandConsumer;
                return fallbackOnLegacyTextField((HandwritingGesture)gesture, function12);
            } else {
                final long l2 = HandwritingGesture_androidKt.access$rangeOfWhitespaces((CharSequence)text, i3);
                if (TextRange.getCollapsed-impl(l2)) {
                    performInsertionOnLegacyTextField(TextRange.getStart-impl(l2), " ", editCommandConsumer);
                    obj = this;
                    z = text;
                    function1 = editCommandConsumer;
                } else {
                    this.performDeletionOnLegacyTextField-vJH6DeI(l2, obj6, text, 0);
                }
            }
            return i;
        }
        obj2 = this;
        charSequence = text;
        function12 = editCommandConsumer;
    }

    private final int performJoinOrSplitGesture(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$performJoinOrSplitGesture, JoinOrSplitGesture gesture, androidx.compose.foundation.text.input.internal.TextLayoutState layoutState, ViewConfiguration viewConfiguration) {
        int i4;
        boolean collapsed-impl;
        TextLayoutResult layoutResult;
        int untransformedText;
        int i;
        int i2;
        int i3;
        int i5;
        int i6;
        untransformedText = $this$performJoinOrSplitGesture.getUntransformedText();
        if ($this$performJoinOrSplitGesture.getOutputText() != untransformedText) {
            return 3;
        }
        final Object obj = layoutState;
        final int i8 = HandwritingGesture_androidKt.access$getOffsetForHandwritingGesture-d-4ec7I(layoutState, HandwritingGesture_androidKt.access$toOffset(gesture.getJoinOrSplitPoint()), untransformedText);
        if (i8 != -1) {
            layoutResult = layoutState.getLayoutResult();
            i6 = 1;
            untransformedText = 0;
            if (layoutResult != null && HandwritingGesture_androidKt.access$isBiDiBoundary(layoutResult, i8) == i6) {
                i4 = HandwritingGesture_androidKt.access$isBiDiBoundary(layoutResult, i8) == i6 ? i6 : untransformedText;
            } else {
            }
            if (i4 != 0) {
            } else {
                final long l2 = HandwritingGesture_androidKt.access$rangeOfWhitespaces((CharSequence)$this$performJoinOrSplitGesture.getVisualText(), i8);
                if (TextRange.getCollapsed-impl(l2)) {
                    TransformedTextFieldState.replaceText-M8tDOmk$default($this$performJoinOrSplitGesture, (CharSequence)" ", l2, obj3, false, 0, 12);
                } else {
                    performDeletion-Sb-Bc2M($this$performJoinOrSplitGesture, l2, obj3);
                }
            }
            return i6;
        }
        return fallback($this$performJoinOrSplitGesture, (HandwritingGesture)gesture);
    }

    private final int performRemoveSpaceGesture(LegacyTextFieldState $this$performRemoveSpaceGesture, RemoveSpaceGesture gesture, AnnotatedString text, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> editCommandConsumer) {
        int value;
        int element;
        final Function1 function1 = editCommandConsumer;
        TextLayoutResultProxy layoutResult = $this$performRemoveSpaceGesture.getLayoutResult();
        if (layoutResult != null) {
            value = layoutResult.getValue();
        } else {
            value = 0;
        }
        int i = value;
        long l = HandwritingGesture_androidKt.access$getRangeForRemoveSpaceGesture-5iVPX68(i, HandwritingGesture_androidKt.access$toOffset(gesture.getStartPoint()), obj4, HandwritingGesture_androidKt.access$toOffset(gesture.getEndPoint()), obj6);
        int i4 = 0;
        if (TextRange.getCollapsed-impl(l)) {
            return HandwritingGestureApi34.INSTANCE.fallbackOnLegacyTextField((HandwritingGesture)gesture, function1);
        }
        Ref.IntRef intRef = new Ref.IntRef();
        int i2 = -1;
        intRef.element = i2;
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = i2;
        Regex regex = new Regex("\\s+");
        HandwritingGestureApi34.performRemoveSpaceGesture.newText.2 anon = new HandwritingGestureApi34.performRemoveSpaceGesture.newText.2(intRef, intRef2);
        String replace = regex.replace((CharSequence)TextRangeKt.substring-FDrldGo((CharSequence)text, l), (Function1)anon);
        if (intRef.element != i2 && intRef2.element == i2) {
            if (intRef2.element == i2) {
            }
            String substring = replace.substring(intRef.element, length -= i8);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            EditCommand[] arr = new EditCommand[2];
            SetSelectionCommand setSelectionCommand = new SetSelectionCommand(start-impl += element2, start-impl2 += element3);
            int i10 = 1;
            CommitTextCommand commitTextCommand = new CommitTextCommand(substring, i10);
            arr[i10] = commitTextCommand;
            function1.invoke(HandwritingGesture_androidKt.access$compoundEditCommand(arr));
            return i10;
        }
        return fallbackOnLegacyTextField((HandwritingGesture)gesture, function1);
    }

    private final int performRemoveSpaceGesture(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$performRemoveSpaceGesture, RemoveSpaceGesture gesture, androidx.compose.foundation.text.input.internal.TextLayoutState layoutState, ViewConfiguration viewConfiguration) {
        int element;
        long l5 = HandwritingGesture_androidKt.access$toOffset(gesture.getEndPoint());
        long l = HandwritingGesture_androidKt.access$getRangeForRemoveSpaceGesture-5iVPX68(layoutState.getLayoutResult(), HandwritingGesture_androidKt.access$toOffset(gesture.getStartPoint()), obj3, l5, obj5);
        int i7 = 0;
        if (TextRange.getCollapsed-impl(l)) {
            return HandwritingGestureApi34.INSTANCE.fallback($this$performRemoveSpaceGesture, (HandwritingGesture)gesture);
        }
        final long l6 = l;
        Ref.IntRef intRef = new Ref.IntRef();
        final Ref.IntRef intRef3 = intRef;
        int i = -1;
        intRef3.element = i;
        Ref.IntRef intRef2 = new Ref.IntRef();
        final Ref.IntRef intRef4 = intRef2;
        intRef4.element = i;
        Regex regex = new Regex("\\s+");
        HandwritingGestureApi34.performRemoveSpaceGesture.newText.1 anon = new HandwritingGestureApi34.performRemoveSpaceGesture.newText.1(intRef3, intRef4);
        final String replace = regex.replace((CharSequence)TextRangeKt.substring-FDrldGo((CharSequence)$this$performRemoveSpaceGesture.getVisualText(), l6), (Function1)anon);
        if (intRef3.element != i && intRef4.element == i) {
            if (intRef4.element == i) {
            }
            int element4 = intRef4.element;
            String substring = replace.substring(intRef3.element, length -= i8);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            TransformedTextFieldState.replaceText-M8tDOmk$default($this$performRemoveSpaceGesture, (CharSequence)substring, TextRangeKt.TextRange(start-impl += element3, start-impl2 += element4), element4, false, 0, 12);
            return 1;
        }
        return fallback($this$performRemoveSpaceGesture, (HandwritingGesture)gesture);
    }

    private final int performSelectGesture(LegacyTextFieldState $this$performSelectGesture, SelectGesture gesture, TextFieldSelectionManager textSelectionManager, Function1<? super EditCommand, Unit> editCommandConsumer) {
        int textGranularity-NUwxegE = toTextGranularity-NUwxegE(gesture.getGranularity());
        long l = HandwritingGesture_androidKt.access$getRangeForScreenRect-OH9lIzo($this$performSelectGesture, RectHelper_androidKt.toComposeRect(gesture.getSelectionArea()), textGranularity-NUwxegE, TextInclusionStrategy.Companion.getContainsCenter());
        final int i2 = 0;
        if (TextRange.getCollapsed-impl(l)) {
            return HandwritingGestureApi34.INSTANCE.fallbackOnLegacyTextField((HandwritingGesture)gesture, editCommandConsumer);
        }
        performSelectionOnLegacyTextField-8ffj60Q(l, textGranularity-NUwxegE, textSelectionManager);
        return 1;
    }

    private final int performSelectGesture(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$performSelectGesture, SelectGesture gesture, androidx.compose.foundation.text.input.internal.TextLayoutState layoutState) {
        int textGranularity-NUwxegE = toTextGranularity-NUwxegE(gesture.getGranularity());
        long l = HandwritingGesture_androidKt.access$getRangeForScreenRect-OH9lIzo(layoutState, RectHelper_androidKt.toComposeRect(gesture.getSelectionArea()), textGranularity-NUwxegE, TextInclusionStrategy.Companion.getContainsCenter());
        final int i2 = 0;
        if (TextRange.getCollapsed-impl(l)) {
            return HandwritingGestureApi34.INSTANCE.fallback($this$performSelectGesture, (HandwritingGesture)gesture);
        }
        $this$performSelectGesture.selectCharsIn-5zc-tL8(l);
        return 1;
    }

    private final int performSelectRangeGesture(LegacyTextFieldState $this$performSelectRangeGesture, SelectRangeGesture gesture, TextFieldSelectionManager textSelectionManager, Function1<? super EditCommand, Unit> editCommandConsumer) {
        androidx.compose.ui.geometry.Rect composeRect2 = RectHelper_androidKt.toComposeRect(gesture.getSelectionEndArea());
        TextInclusionStrategy containsCenter = TextInclusionStrategy.Companion.getContainsCenter();
        long l = HandwritingGesture_androidKt.access$getRangeForScreenRects-O048IG0($this$performSelectRangeGesture, RectHelper_androidKt.toComposeRect(gesture.getSelectionStartArea()), composeRect2, toTextGranularity-NUwxegE(gesture.getGranularity()), containsCenter);
        final int i2 = 0;
        if (TextRange.getCollapsed-impl(l)) {
            return HandwritingGestureApi34.INSTANCE.fallbackOnLegacyTextField((HandwritingGesture)gesture, editCommandConsumer);
        }
        performSelectionOnLegacyTextField-8ffj60Q(l, composeRect2, textSelectionManager);
        return 1;
    }

    private final int performSelectRangeGesture(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$performSelectRangeGesture, SelectRangeGesture gesture, androidx.compose.foundation.text.input.internal.TextLayoutState layoutState) {
        androidx.compose.ui.geometry.Rect composeRect2 = RectHelper_androidKt.toComposeRect(gesture.getSelectionEndArea());
        TextInclusionStrategy containsCenter = TextInclusionStrategy.Companion.getContainsCenter();
        long l = HandwritingGesture_androidKt.access$getRangeForScreenRects-O048IG0(layoutState, RectHelper_androidKt.toComposeRect(gesture.getSelectionStartArea()), composeRect2, toTextGranularity-NUwxegE(gesture.getGranularity()), containsCenter);
        final int i2 = 0;
        if (TextRange.getCollapsed-impl(l)) {
            return HandwritingGestureApi34.INSTANCE.fallback($this$performSelectRangeGesture, (HandwritingGesture)gesture);
        }
        $this$performSelectRangeGesture.selectCharsIn-5zc-tL8(l);
        return 1;
    }

    private final void performSelectionOnLegacyTextField-8ffj60Q(long range, TextFieldSelectionManager textSelectionManager, Function1<? super EditCommand, Unit> editCommandConsumer) {
        SetSelectionCommand setSelectionCommand;
        setSelectionCommand = new SetSelectionCommand(TextRange.getStart-impl(range), TextRange.getEnd-impl(range));
        obj7.invoke(setSelectionCommand);
        if (editCommandConsumer != null) {
            editCommandConsumer.enterSelectionMode$foundation_release(true);
        }
    }

    private final void previewDeleteGesture(LegacyTextFieldState $this$previewDeleteGesture, DeleteGesture gesture, TextFieldSelectionManager textFieldSelectionManager) {
        long l;
        int textGranularity-NUwxegE;
        TextInclusionStrategy containsCenter;
        if (textFieldSelectionManager != null) {
            textGranularity-NUwxegE = toTextGranularity-NUwxegE(gesture.getGranularity());
            textFieldSelectionManager.setDeletionPreviewHighlight-5zc-tL8$foundation_release(HandwritingGesture_androidKt.access$getRangeForScreenRect-OH9lIzo($this$previewDeleteGesture, RectHelper_androidKt.toComposeRect(gesture.getDeletionArea()), textGranularity-NUwxegE, TextInclusionStrategy.Companion.getContainsCenter()));
        }
    }

    private final void previewDeleteGesture(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$previewDeleteGesture, DeleteGesture gesture, androidx.compose.foundation.text.input.internal.TextLayoutState layoutState) {
        int textGranularity-NUwxegE = toTextGranularity-NUwxegE(gesture.getGranularity());
        highlightRange-XJREzCE($this$previewDeleteGesture, HandwritingGesture_androidKt.access$getRangeForScreenRect-OH9lIzo(layoutState, RectHelper_androidKt.toComposeRect(gesture.getDeletionArea()), textGranularity-NUwxegE, TextInclusionStrategy.Companion.getContainsCenter()), textGranularity-NUwxegE);
    }

    private final void previewDeleteRangeGesture(LegacyTextFieldState $this$previewDeleteRangeGesture, DeleteRangeGesture gesture, TextFieldSelectionManager textFieldSelectionManager) {
        long l;
        androidx.compose.ui.geometry.Rect composeRect;
        int textGranularity-NUwxegE;
        TextInclusionStrategy containsCenter;
        if (textFieldSelectionManager != null) {
            composeRect = RectHelper_androidKt.toComposeRect(gesture.getDeletionEndArea());
            textFieldSelectionManager.setDeletionPreviewHighlight-5zc-tL8$foundation_release(HandwritingGesture_androidKt.access$getRangeForScreenRects-O048IG0($this$previewDeleteRangeGesture, RectHelper_androidKt.toComposeRect(gesture.getDeletionStartArea()), composeRect, toTextGranularity-NUwxegE(gesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()));
        }
    }

    private final void previewDeleteRangeGesture(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$previewDeleteRangeGesture, DeleteRangeGesture gesture, androidx.compose.foundation.text.input.internal.TextLayoutState layoutState) {
        androidx.compose.ui.geometry.Rect composeRect2 = RectHelper_androidKt.toComposeRect(gesture.getDeletionEndArea());
        highlightRange-XJREzCE($this$previewDeleteRangeGesture, HandwritingGesture_androidKt.access$getRangeForScreenRects-O048IG0(layoutState, RectHelper_androidKt.toComposeRect(gesture.getDeletionStartArea()), composeRect2, toTextGranularity-NUwxegE(gesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()), composeRect2);
    }

    private static final void previewHandwritingGesture$lambda$1(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this_previewHandwritingGesture) {
        final int i2 = 0;
        final TextFieldState field = TransformedTextFieldState.access$getTextFieldState$p($this_previewHandwritingGesture);
        final int i3 = 0;
        field.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        final int i4 = 0;
        field.getMainBuffer$foundation_release().clearHighlight();
        TextFieldState.access$commitEditAsUser(field, TransformedTextFieldState.access$getInputTransformation$p($this_previewHandwritingGesture), true, TextFieldEditUndoBehavior.MergeIfPossible);
    }

    private static final void previewHandwritingGesture$lambda$9(TextFieldSelectionManager $textFieldSelectionManager) {
        if ($textFieldSelectionManager != null) {
            $textFieldSelectionManager.clearPreviewHighlight$foundation_release();
        }
    }

    private final void previewSelectGesture(LegacyTextFieldState $this$previewSelectGesture, SelectGesture gesture, TextFieldSelectionManager textFieldSelectionManager) {
        long l;
        int textGranularity-NUwxegE;
        TextInclusionStrategy containsCenter;
        if (textFieldSelectionManager != null) {
            textGranularity-NUwxegE = toTextGranularity-NUwxegE(gesture.getGranularity());
            textFieldSelectionManager.setSelectionPreviewHighlight-5zc-tL8$foundation_release(HandwritingGesture_androidKt.access$getRangeForScreenRect-OH9lIzo($this$previewSelectGesture, RectHelper_androidKt.toComposeRect(gesture.getSelectionArea()), textGranularity-NUwxegE, TextInclusionStrategy.Companion.getContainsCenter()));
        }
    }

    private final void previewSelectGesture(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$previewSelectGesture, SelectGesture gesture, androidx.compose.foundation.text.input.internal.TextLayoutState layoutState) {
        int textGranularity-NUwxegE = toTextGranularity-NUwxegE(gesture.getGranularity());
        highlightRange-XJREzCE($this$previewSelectGesture, HandwritingGesture_androidKt.access$getRangeForScreenRect-OH9lIzo(layoutState, RectHelper_androidKt.toComposeRect(gesture.getSelectionArea()), textGranularity-NUwxegE, TextInclusionStrategy.Companion.getContainsCenter()), textGranularity-NUwxegE);
    }

    private final void previewSelectRangeGesture(LegacyTextFieldState $this$previewSelectRangeGesture, SelectRangeGesture gesture, TextFieldSelectionManager textFieldSelectionManager) {
        long l;
        androidx.compose.ui.geometry.Rect composeRect;
        int textGranularity-NUwxegE;
        TextInclusionStrategy containsCenter;
        if (textFieldSelectionManager != null) {
            composeRect = RectHelper_androidKt.toComposeRect(gesture.getSelectionEndArea());
            textFieldSelectionManager.setSelectionPreviewHighlight-5zc-tL8$foundation_release(HandwritingGesture_androidKt.access$getRangeForScreenRects-O048IG0($this$previewSelectRangeGesture, RectHelper_androidKt.toComposeRect(gesture.getSelectionStartArea()), composeRect, toTextGranularity-NUwxegE(gesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()));
        }
    }

    private final void previewSelectRangeGesture(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$previewSelectRangeGesture, SelectRangeGesture gesture, androidx.compose.foundation.text.input.internal.TextLayoutState layoutState) {
        androidx.compose.ui.geometry.Rect composeRect2 = RectHelper_androidKt.toComposeRect(gesture.getSelectionEndArea());
        highlightRange-XJREzCE($this$previewSelectRangeGesture, HandwritingGesture_androidKt.access$getRangeForScreenRects-O048IG0(layoutState, RectHelper_androidKt.toComposeRect(gesture.getSelectionStartArea()), composeRect2, toTextGranularity-NUwxegE(gesture.getGranularity()), TextInclusionStrategy.Companion.getContainsCenter()), composeRect2);
    }

    private final int toTextGranularity-NUwxegE(int $this$toTextGranularity_u2dNUwxegE) {
        int character-DRrd7Zo;
        switch ($this$toTextGranularity_u2dNUwxegE) {
            case 1:
                character-DRrd7Zo = TextGranularity.Companion.getWord-DRrd7Zo();
                break;
            case 2:
                character-DRrd7Zo = TextGranularity.Companion.getCharacter-DRrd7Zo();
                break;
            default:
                character-DRrd7Zo = TextGranularity.Companion.getCharacter-DRrd7Zo();
        }
        return character-DRrd7Zo;
    }

    public final int performHandwritingGesture$foundation_release(LegacyTextFieldState $this$performHandwritingGesture, HandwritingGesture gesture, TextFieldSelectionManager textFieldSelectionManager, ViewConfiguration viewConfiguration, Function1<? super EditCommand, Unit> editCommandConsumer) {
        Object layoutResult;
        AnnotatedString text;
        int selectRangeGesture;
        Object obj6;
        LegacyTextFieldState field;
        Object obj;
        ViewConfiguration view;
        Function1 function1;
        LegacyTextFieldState obj9;
        AnnotatedString untransformedText = $this$performHandwritingGesture.getUntransformedText();
        final int i = 3;
        if (untransformedText == null) {
            return i;
        }
        final AnnotatedString str = untransformedText;
        layoutResult = $this$performHandwritingGesture.getLayoutResult();
        layoutResult = layoutResult.getValue();
        layoutResult = layoutResult.getLayoutInput();
        if (layoutResult != null && layoutResult != null && layoutResult != null) {
            layoutResult = layoutResult.getValue();
            if (layoutResult != null) {
                layoutResult = layoutResult.getLayoutInput();
                if (layoutResult != null) {
                    text = layoutResult.getText();
                } else {
                    text = 0;
                }
            } else {
            }
        } else {
        }
        if (!Intrinsics.areEqual(str, text)) {
            return i;
        }
        if (gesture instanceof SelectGesture) {
            selectRangeGesture = performSelectGesture($this$performHandwritingGesture, (SelectGesture)gesture, textFieldSelectionManager, editCommandConsumer);
            field = $this$performHandwritingGesture;
            view = viewConfiguration;
            function1 = editCommandConsumer;
        } else {
            if (gesture instanceof DeleteGesture) {
                selectRangeGesture = performDeleteGesture($this$performHandwritingGesture, (DeleteGesture)gesture, str, editCommandConsumer);
                field = $this$performHandwritingGesture;
                view = viewConfiguration;
                function1 = editCommandConsumer;
            } else {
                if (gesture instanceof SelectRangeGesture) {
                    selectRangeGesture = performSelectRangeGesture($this$performHandwritingGesture, (SelectRangeGesture)gesture, textFieldSelectionManager, editCommandConsumer);
                    field = $this$performHandwritingGesture;
                    view = viewConfiguration;
                    function1 = editCommandConsumer;
                } else {
                    if (gesture instanceof DeleteRangeGesture) {
                        selectRangeGesture = performDeleteRangeGesture($this$performHandwritingGesture, (DeleteRangeGesture)gesture, str, editCommandConsumer);
                        field = $this$performHandwritingGesture;
                        view = viewConfiguration;
                        function1 = editCommandConsumer;
                    } else {
                        if (gesture instanceof JoinOrSplitGesture) {
                            selectRangeGesture = this.performJoinOrSplitGesture($this$performHandwritingGesture, (JoinOrSplitGesture)gesture, str, viewConfiguration, editCommandConsumer);
                        } else {
                            field = $this$performHandwritingGesture;
                            view = viewConfiguration;
                            function1 = editCommandConsumer;
                            if (gesture instanceof InsertGesture) {
                                selectRangeGesture = performInsertGesture(field, (InsertGesture)gesture, view, function1);
                            } else {
                                if (gesture instanceof RemoveSpaceGesture) {
                                    selectRangeGesture = this.performRemoveSpaceGesture(field, (RemoveSpaceGesture)gesture, str, view, function1);
                                } else {
                                    selectRangeGesture = 2;
                                }
                            }
                        }
                    }
                }
            }
        }
        return selectRangeGesture;
    }

    public final int performHandwritingGesture$foundation_release(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$performHandwritingGesture, HandwritingGesture handwritingGesture, androidx.compose.foundation.text.input.internal.TextLayoutState layoutState, ViewConfiguration viewConfiguration) {
        int deleteRangeGesture;
        if (handwritingGesture instanceof SelectGesture) {
            deleteRangeGesture = performSelectGesture($this$performHandwritingGesture, (SelectGesture)handwritingGesture, layoutState);
        } else {
            if (handwritingGesture instanceof DeleteGesture) {
                deleteRangeGesture = performDeleteGesture($this$performHandwritingGesture, (DeleteGesture)handwritingGesture, layoutState);
            } else {
                if (handwritingGesture instanceof SelectRangeGesture) {
                    deleteRangeGesture = performSelectRangeGesture($this$performHandwritingGesture, (SelectRangeGesture)handwritingGesture, layoutState);
                } else {
                    if (handwritingGesture instanceof DeleteRangeGesture) {
                        deleteRangeGesture = performDeleteRangeGesture($this$performHandwritingGesture, (DeleteRangeGesture)handwritingGesture, layoutState);
                    } else {
                        if (handwritingGesture instanceof JoinOrSplitGesture) {
                            deleteRangeGesture = performJoinOrSplitGesture($this$performHandwritingGesture, (JoinOrSplitGesture)handwritingGesture, layoutState, viewConfiguration);
                        } else {
                            if (handwritingGesture instanceof InsertGesture) {
                                deleteRangeGesture = performInsertGesture($this$performHandwritingGesture, (InsertGesture)handwritingGesture, layoutState, viewConfiguration);
                            } else {
                                if (handwritingGesture instanceof RemoveSpaceGesture) {
                                    deleteRangeGesture = performRemoveSpaceGesture($this$performHandwritingGesture, (RemoveSpaceGesture)handwritingGesture, layoutState, viewConfiguration);
                                } else {
                                    deleteRangeGesture = 2;
                                }
                            }
                        }
                    }
                }
            }
        }
        return deleteRangeGesture;
    }

    public final boolean previewHandwritingGesture$foundation_release(LegacyTextFieldState $this$previewHandwritingGesture, PreviewableHandwritingGesture gesture, TextFieldSelectionManager textFieldSelectionManager, CancellationSignal cancellationSignal) {
        Object externalSyntheticLambda0;
        Object layoutResult;
        AnnotatedString text;
        boolean z;
        final AnnotatedString untransformedText = $this$previewHandwritingGesture.getUntransformedText();
        int i = 0;
        if (untransformedText == null) {
            return i;
        }
        layoutResult = $this$previewHandwritingGesture.getLayoutResult();
        layoutResult = layoutResult.getValue();
        layoutResult = layoutResult.getLayoutInput();
        if (layoutResult != null && layoutResult != null && layoutResult != null) {
            layoutResult = layoutResult.getValue();
            if (layoutResult != null) {
                layoutResult = layoutResult.getLayoutInput();
                if (layoutResult != null) {
                    text = layoutResult.getText();
                } else {
                    text = 0;
                }
            } else {
            }
        } else {
        }
        if (!Intrinsics.areEqual(untransformedText, text)) {
            return i;
        }
        if (gesture instanceof SelectGesture) {
            previewSelectGesture($this$previewHandwritingGesture, (SelectGesture)gesture, textFieldSelectionManager);
            if (cancellationSignal != null) {
                externalSyntheticLambda0 = new HandwritingGestureApi34$$ExternalSyntheticLambda0(textFieldSelectionManager);
                cancellationSignal.setOnCancelListener(externalSyntheticLambda0);
            }
            return 1;
        } else {
            if (gesture instanceof DeleteGesture) {
                previewDeleteGesture($this$previewHandwritingGesture, (DeleteGesture)gesture, textFieldSelectionManager);
            } else {
                if (gesture instanceof SelectRangeGesture) {
                    previewSelectRangeGesture($this$previewHandwritingGesture, (SelectRangeGesture)gesture, textFieldSelectionManager);
                } else {
                    if (gesture instanceof DeleteRangeGesture) {
                        previewDeleteRangeGesture($this$previewHandwritingGesture, (DeleteRangeGesture)gesture, textFieldSelectionManager);
                    }
                }
            }
        }
        return i;
    }

    public final boolean previewHandwritingGesture$foundation_release(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$previewHandwritingGesture, PreviewableHandwritingGesture handwritingGesture, androidx.compose.foundation.text.input.internal.TextLayoutState layoutState, CancellationSignal cancellationSignal) {
        Object externalSyntheticLambda1;
        if (handwritingGesture instanceof SelectGesture) {
            previewSelectGesture($this$previewHandwritingGesture, (SelectGesture)handwritingGesture, layoutState);
            if (cancellationSignal != null) {
                externalSyntheticLambda1 = new HandwritingGestureApi34$$ExternalSyntheticLambda1($this$previewHandwritingGesture);
                cancellationSignal.setOnCancelListener(externalSyntheticLambda1);
            }
            return 1;
        } else {
            if (handwritingGesture instanceof DeleteGesture) {
                previewDeleteGesture($this$previewHandwritingGesture, (DeleteGesture)handwritingGesture, layoutState);
            } else {
                if (handwritingGesture instanceof SelectRangeGesture) {
                    previewSelectRangeGesture($this$previewHandwritingGesture, (SelectRangeGesture)handwritingGesture, layoutState);
                } else {
                    if (handwritingGesture instanceof DeleteRangeGesture) {
                        previewDeleteRangeGesture($this$previewHandwritingGesture, (DeleteRangeGesture)handwritingGesture, layoutState);
                    }
                }
            }
        }
        return 0;
    }
}

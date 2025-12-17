package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.OffsetMapping.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000c¨\u0006\r", d2 = {"Landroidx/compose/foundation/text/selection/TextPreparedSelection;", "Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "originalText", "Landroidx/compose/ui/text/AnnotatedString;", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextPreparedSelection extends androidx.compose.foundation.text.selection.BaseTextPreparedSelection<androidx.compose.foundation.text.selection.TextPreparedSelection> {

    public static final int $stable;
    static {
    }

    private TextPreparedSelection(AnnotatedString originalText, long originalSelection, TextLayoutResult layoutResult, OffsetMapping offsetMapping, androidx.compose.foundation.text.selection.TextPreparedSelectionState state) {
        super(originalText, originalSelection, obj3, offsetMapping, state, obj14, 0);
    }

    public TextPreparedSelection(AnnotatedString annotatedString, long l2, TextLayoutResult textLayoutResult3, OffsetMapping offsetMapping4, androidx.compose.foundation.text.selection.TextPreparedSelectionState textPreparedSelectionState5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        int i;
        OffsetMapping map;
        androidx.compose.foundation.text.selection.TextPreparedSelectionState textPreparedSelectionState;
        int obj12;
        OffsetMapping obj13;
        androidx.compose.foundation.text.selection.TextPreparedSelectionState obj14;
        i = defaultConstructorMarker7 & 4 != 0 ? obj12 : offsetMapping4;
        if (defaultConstructorMarker7 & 8 != 0) {
            map = obj13;
        } else {
            map = textPreparedSelectionState5;
        }
        if (defaultConstructorMarker7 & 16 != 0) {
            obj14 = new TextPreparedSelectionState();
            textPreparedSelectionState = obj14;
        } else {
            textPreparedSelectionState = i6;
        }
        super(annotatedString, l2, obj3, i, map, textPreparedSelectionState, 0);
    }

    public TextPreparedSelection(AnnotatedString annotatedString, long l2, TextLayoutResult textLayoutResult3, OffsetMapping offsetMapping4, androidx.compose.foundation.text.selection.TextPreparedSelectionState textPreparedSelectionState5, DefaultConstructorMarker defaultConstructorMarker6) {
        super(annotatedString, l2, textLayoutResult3, offsetMapping4, textPreparedSelectionState5, defaultConstructorMarker6);
    }
}

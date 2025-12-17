package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldBuffer.ChangeList;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldState.NotifyImeListener;
import androidx.compose.foundation.text.input.UndoState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\r\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008\u0001\u0018\u0000 ]2\u00020\u0001:\u0002]^B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0086@¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020!J,\u0010)\u001a\u00020!2\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020!0-¢\u0006\u0002\u0008/H\u0086\u0008J\u0013\u00100\u001a\u00020+2\u0008\u00101\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u00102\u001a\u000203H\u0016J \u00104\u001a\u00020!2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208ø\u0001\u0000¢\u0006\u0004\u00089\u0010:J\u0018\u0010;\u001a\u0002082\u0006\u0010<\u001a\u000208ø\u0001\u0000¢\u0006\u0004\u0008=\u0010>J\u001b\u0010;\u001a\u0002082\u0006\u0010?\u001a\u000203ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008@\u0010AJ\u0018\u0010B\u001a\u0002082\u0006\u0010<\u001a\u000208ø\u0001\u0000¢\u0006\u0004\u0008C\u0010>J\u001b\u0010B\u001a\u0002082\u0006\u0010?\u001a\u000203ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008D\u0010AJ\u000e\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u000203J\u0006\u0010G\u001a\u00020!J\u000e\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020JJ\"\u0010K\u001a\u00020!2\u0006\u0010I\u001a\u00020J2\u0008\u0008\u0002\u0010L\u001a\u00020+2\u0008\u0008\u0002\u0010M\u001a\u00020NJ4\u0010O\u001a\u00020!2\u0006\u0010I\u001a\u00020J2\u0006\u0010<\u001a\u0002082\u0008\u0008\u0002\u0010M\u001a\u00020N2\u0008\u0008\u0002\u0010*\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\u0008P\u0010QJ\u0006\u0010R\u001a\u00020!J\u0018\u0010S\u001a\u00020!2\u0006\u00107\u001a\u000208ø\u0001\u0000¢\u0006\u0004\u0008T\u0010UJ\u0018\u0010V\u001a\u00020!2\u0006\u0010W\u001a\u000208ø\u0001\u0000¢\u0006\u0004\u0008X\u0010UJ\u0008\u0010Y\u001a\u00020ZH\u0016J\u0006\u0010[\u001a\u00020!J\u0010\u0010\\\u001a\u00020!2\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001a\u0010\u001b\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u0011R\u0011\u0010\u001e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u0011\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006_", d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;)V", "codepointTransformedText", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "outputText", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getOutputText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "outputTransformedText", "<set-?>", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "selectionWedgeAffinity", "getSelectionWedgeAffinity", "()Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "setSelectionWedgeAffinity", "(Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)V", "selectionWedgeAffinity$delegate", "Landroidx/compose/runtime/MutableState;", "untransformedText", "getUntransformedText", "visualText", "getVisualText", "collapseSelectionToEnd", "", "collapseSelectionToMax", "collectImeNotifications", "", "notifyImeListener", "Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "(Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSelectedText", "editUntransformedTextAsUser", "restartImeIfContentChanges", "", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "Lkotlin/ExtensionFunctionType;", "equals", "other", "hashCode", "", "highlightCharsIn", "type", "Landroidx/compose/foundation/text/input/TextHighlightType;", "transformedRange", "Landroidx/compose/ui/text/TextRange;", "highlightCharsIn-7RAjNK8", "(IJ)V", "mapFromTransformed", "range", "mapFromTransformed-GEjPoXI", "(J)J", "offset", "mapFromTransformed--jx7JFs", "(I)J", "mapToTransformed", "mapToTransformed-GEjPoXI", "mapToTransformed--jx7JFs", "placeCursorBeforeCharAt", "transformedOffset", "redo", "replaceAll", "newText", "", "replaceSelectedText", "clearComposition", "undoBehavior", "Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "replaceText", "replaceText-M8tDOmk", "(Ljava/lang/CharSequence;JLandroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;Z)V", "selectAll", "selectCharsIn", "selectCharsIn-5zc-tL8", "(J)V", "selectUntransformedCharsIn", "untransformedRange", "selectUntransformedCharsIn-5zc-tL8", "toString", "", "undo", "update", "Companion", "TransformedText", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TransformedTextFieldState {

    public static final int $stable;
    private static final androidx.compose.foundation.text.input.internal.TransformedTextFieldState.Companion Companion;
    private final androidx.compose.foundation.text.input.internal.CodepointTransformation codepointTransformation;
    private final State<androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText> codepointTransformedText;
    private InputTransformation inputTransformation;
    private final OutputTransformation outputTransformation;
    private final State<androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText> outputTransformedText;
    private final MutableState selectionWedgeAffinity$delegate;
    private final TextFieldState textFieldState;

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0003J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\t\u001a\u00020\nH\u0003J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013J.\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0017", d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$Companion;", "", "()V", "calculateTransformedText", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "untransformedValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "wedgeAffinity", "Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "mapFromTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "mapFromTransformed-xdX6-G0", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)J", "mapToTransformed", "mapToTransformed-XGyztTk", "(JLandroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;Landroidx/compose/foundation/text/input/internal/SelectionWedgeAffinity;)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText access$calculateTransformedText(androidx.compose.foundation.text.input.internal.TransformedTextFieldState.Companion $this, TextFieldCharSequence untransformedValue, OutputTransformation outputTransformation, androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity wedgeAffinity) {
            return $this.calculateTransformedText(untransformedValue, outputTransformation, wedgeAffinity);
        }

        public static final androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText access$calculateTransformedText(androidx.compose.foundation.text.input.internal.TransformedTextFieldState.Companion $this, TextFieldCharSequence untransformedValue, androidx.compose.foundation.text.input.internal.CodepointTransformation codepointTransformation, androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity wedgeAffinity) {
            return $this.calculateTransformedText(untransformedValue, codepointTransformation, wedgeAffinity);
        }

        public static final long access$mapFromTransformed-xdX6-G0(androidx.compose.foundation.text.input.internal.TransformedTextFieldState.Companion $this, long range, androidx.compose.foundation.text.input.internal.OffsetMappingCalculator mapping) {
            return $this.mapFromTransformed-xdX6-G0(range, mapping);
        }

        public static final long access$mapToTransformed-XGyztTk(androidx.compose.foundation.text.input.internal.TransformedTextFieldState.Companion $this, long range, androidx.compose.foundation.text.input.internal.OffsetMappingCalculator mapping, androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity wedgeAffinity) {
            return $this.mapToTransformed-XGyztTk(range, mapping, wedgeAffinity);
        }

        @JvmStatic
        private final androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText calculateTransformedText(TextFieldCharSequence untransformedValue, OutputTransformation outputTransformation, androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity wedgeAffinity) {
            int box-impl;
            int it;
            TextRange obj9;
            OffsetMappingCalculator offsetMappingCalculator = new OffsetMappingCalculator();
            final androidx.compose.foundation.text.input.internal.OffsetMappingCalculator map = offsetMappingCalculator;
            final int i4 = 0;
            final int i3 = 0;
            final TextFieldCharSequence field2 = untransformedValue;
            TextFieldBuffer textFieldBuffer = new TextFieldBuffer(field2, 0, i3, map, 6, i4);
            int i = 0;
            outputTransformation.transformOutput(textFieldBuffer);
            if (textFieldBuffer.getChanges().getChangeCount() == 0) {
                return null;
            }
            obj9 = field2.getComposition-MzsxiRA();
            if (obj9 != null) {
                obj9 = 0;
                box-impl = TextRange.box-impl(TransformedTextFieldState.access$getCompanion$p().mapToTransformed-XGyztTk(obj9.unbox-impl(), i4, map));
            }
            TransformedTextFieldState.TransformedText transformedText = new TransformedTextFieldState.TransformedText(textFieldBuffer.toTextFieldCharSequence-udt6zUU$foundation_release(mapToTransformed-XGyztTk(field2.getSelection-d9O1mEE(), i3, map), i3), map);
            return transformedText;
        }

        @JvmStatic
        private final androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText calculateTransformedText(TextFieldCharSequence untransformedValue, androidx.compose.foundation.text.input.internal.CodepointTransformation codepointTransformation, androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity wedgeAffinity) {
            int box-impl;
            int i;
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState.Companion field;
            OffsetMappingCalculator offsetMappingCalculator = new OffsetMappingCalculator();
            final java.lang.CharSequence charSequence = visualText;
            if (charSequence == untransformedValue) {
                return null;
            }
            TextRange composition-MzsxiRA = untransformedValue.getComposition-MzsxiRA();
            if (composition-MzsxiRA != null) {
                i = 0;
                box-impl = TextRange.box-impl(TransformedTextFieldState.access$getCompanion$p().mapToTransformed-XGyztTk(composition-MzsxiRA.unbox-impl(), composition-MzsxiRA, offsetMappingCalculator));
            }
            TextFieldCharSequence textFieldCharSequence = new TextFieldCharSequence(charSequence, mapToTransformed-XGyztTk(untransformedValue.getSelection-d9O1mEE(), obj5, offsetMappingCalculator), obj5, box-impl, 0, 8, 0);
            TransformedTextFieldState.TransformedText transformedText = new TransformedTextFieldState.TransformedText(textFieldCharSequence, offsetMappingCalculator);
            return transformedText;
        }

        @JvmStatic
        private final long mapFromTransformed-xdX6-G0(long range, androidx.compose.foundation.text.input.internal.OffsetMappingCalculator mapping) {
            long mapFromDest--jx7JFs;
            long l;
            long mapFromDest--jx7JFs2 = obj11.mapFromDest--jx7JFs(TextRange.getStart-impl(range));
            if (TextRange.getCollapsed-impl(range)) {
                mapFromDest--jx7JFs = mapFromDest--jx7JFs2;
            } else {
                mapFromDest--jx7JFs = obj11.mapFromDest--jx7JFs(TextRange.getEnd-impl(range));
            }
            int i = Math.min(TextRange.getMin-impl(mapFromDest--jx7JFs2), TextRange.getMin-impl(mapFromDest--jx7JFs));
            int i2 = Math.max(TextRange.getMax-impl(mapFromDest--jx7JFs2), TextRange.getMax-impl(mapFromDest--jx7JFs));
            if (TextRange.getReversed-impl(range)) {
                l = TextRangeKt.TextRange(i2, i);
            } else {
                l = TextRangeKt.TextRange(i, i2);
            }
            return l;
        }

        @JvmStatic
        private final long mapToTransformed-XGyztTk(long range, androidx.compose.foundation.text.input.internal.OffsetMappingCalculator mapping, androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity wedgeAffinity) {
            long mapFromSource--jx7JFs;
            long l;
            int collapsed-impl;
            androidx.compose.foundation.text.input.internal.WedgeAffinity startAffinity;
            long l2;
            int[] $EnumSwitchMapping$0;
            long mapFromSource--jx7JFs2 = wedgeAffinity.mapFromSource--jx7JFs(TextRange.getStart-impl(range));
            if (TextRange.getCollapsed-impl(range)) {
                mapFromSource--jx7JFs = mapFromSource--jx7JFs2;
            } else {
                mapFromSource--jx7JFs = wedgeAffinity.mapFromSource--jx7JFs(TextRange.getEnd-impl(range));
            }
            int i = Math.min(TextRange.getMin-impl(mapFromSource--jx7JFs2), TextRange.getMin-impl(mapFromSource--jx7JFs));
            int i2 = Math.max(TextRange.getMax-impl(mapFromSource--jx7JFs2), TextRange.getMax-impl(mapFromSource--jx7JFs));
            if (TextRange.getReversed-impl(range)) {
                l = TextRangeKt.TextRange(i2, i);
            } else {
                l = TextRangeKt.TextRange(i, i2);
            }
            if (TextRange.getCollapsed-impl(range) && !TextRange.getCollapsed-impl(l)) {
                if (!TextRange.getCollapsed-impl(l)) {
                    if (obj14 != null) {
                        startAffinity = obj14.getStartAffinity();
                    } else {
                        startAffinity = 0;
                    }
                    if (startAffinity == null) {
                        collapsed-impl = -1;
                    } else {
                        collapsed-impl = TransformedTextFieldState.Companion.WhenMappings.$EnumSwitchMapping$0[startAffinity.ordinal()];
                    }
                    switch (collapsed-impl) {
                        case -1:
                            l2 = l;
                            break;
                        case 0:
                            NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                            throw noWhenBranchMatchedException;
                        case 1:
                            l2 = TextRangeKt.TextRange(TextRange.getStart-impl(l));
                            break;
                        default:
                            l2 = TextRangeKt.TextRange(TextRange.getEnd-impl(l));
                    }
                } else {
                }
            } else {
            }
            return l2;
        }

        static long mapToTransformed-XGyztTk$default(androidx.compose.foundation.text.input.internal.TransformedTextFieldState.Companion transformedTextFieldState$Companion, long l2, androidx.compose.foundation.text.input.internal.OffsetMappingCalculator offsetMappingCalculator3, androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity selectionWedgeAffinity4, int i5, Object object6) {
            int obj4;
            if (object6 &= 4 != 0) {
                obj4 = 0;
            }
            return companion.mapToTransformed-XGyztTk(l2, offsetMappingCalculator3, selectionWedgeAffinity4);
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0015", d2 = {"Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState$TransformedText;", "", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "offsetMapping", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)V", "getOffsetMapping", "()Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class TransformedText {

        private final androidx.compose.foundation.text.input.internal.OffsetMappingCalculator offsetMapping;
        private final TextFieldCharSequence text;
        public TransformedText(TextFieldCharSequence text, androidx.compose.foundation.text.input.internal.OffsetMappingCalculator offsetMapping) {
            super();
            this.text = text;
            this.offsetMapping = offsetMapping;
        }

        public static androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText copy$default(androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText transformedTextFieldState$TransformedText, TextFieldCharSequence textFieldCharSequence2, androidx.compose.foundation.text.input.internal.OffsetMappingCalculator offsetMappingCalculator3, int i4, Object object5) {
            TextFieldCharSequence obj1;
            androidx.compose.foundation.text.input.internal.OffsetMappingCalculator obj2;
            if (i4 & 1 != 0) {
                obj1 = transformedText.text;
            }
            if (i4 &= 2 != 0) {
                obj2 = transformedText.offsetMapping;
            }
            return transformedText.copy(obj1, obj2);
        }

        public final TextFieldCharSequence component1() {
            return this.text;
        }

        public final androidx.compose.foundation.text.input.internal.OffsetMappingCalculator component2() {
            return this.offsetMapping;
        }

        public final androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText copy(TextFieldCharSequence textFieldCharSequence, androidx.compose.foundation.text.input.internal.OffsetMappingCalculator offsetMappingCalculator2) {
            TransformedTextFieldState.TransformedText transformedText = new TransformedTextFieldState.TransformedText(textFieldCharSequence, offsetMappingCalculator2);
            return transformedText;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof TransformedTextFieldState.TransformedText) {
                return i2;
            }
            Object obj = object;
            if (!Intrinsics.areEqual(this.text, obj.text)) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.offsetMapping, obj.offsetMapping)) {
                return i2;
            }
            return i;
        }

        public final androidx.compose.foundation.text.input.internal.OffsetMappingCalculator getOffsetMapping() {
            return this.offsetMapping;
        }

        public final TextFieldCharSequence getText() {
            return this.text;
        }

        public int hashCode() {
            return i2 += i4;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("TransformedText(text=").append(this.text).append(", offsetMapping=").append(this.offsetMapping).append(')').toString();
        }
    }
    static {
        TransformedTextFieldState.Companion companion = new TransformedTextFieldState.Companion(0);
        TransformedTextFieldState.Companion = companion;
    }

    public TransformedTextFieldState(TextFieldState textFieldState, InputTransformation inputTransformation, androidx.compose.foundation.text.input.internal.CodepointTransformation codepointTransformation, OutputTransformation outputTransformation) {
        State transformation;
        int transformation2;
        int i;
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState.outputTransformedText.1.1 anon;
        super();
        this.textFieldState = textFieldState;
        this.inputTransformation = inputTransformation;
        this.codepointTransformation = codepointTransformation;
        this.outputTransformation = outputTransformation;
        OutputTransformation outputTransformation2 = this.outputTransformation;
        final int i2 = 0;
        if (outputTransformation2 != null) {
            i = 0;
            anon = new TransformedTextFieldState.outputTransformedText.1.1(this, outputTransformation2);
            transformation = SnapshotStateKt.derivedStateOf((Function0)anon);
        } else {
            transformation = i2;
        }
        this.outputTransformedText = transformation;
        androidx.compose.foundation.text.input.internal.CodepointTransformation codepointTransformation2 = this.codepointTransformation;
        if (codepointTransformation2 != null) {
            i = 0;
            anon = new TransformedTextFieldState.codepointTransformedText.1.1(this, codepointTransformation2);
            transformation2 = SnapshotStateKt.derivedStateOf((Function0)anon);
        } else {
            transformation2 = i2;
        }
        this.codepointTransformedText = transformation2;
        SelectionWedgeAffinity selectionWedgeAffinity = new SelectionWedgeAffinity(WedgeAffinity.Start);
        this.selectionWedgeAffinity$delegate = SnapshotStateKt.mutableStateOf$default(selectionWedgeAffinity, i2, 2, i2);
    }

    public TransformedTextFieldState(TextFieldState textFieldState, InputTransformation inputTransformation2, androidx.compose.foundation.text.input.internal.CodepointTransformation codepointTransformation3, OutputTransformation outputTransformation4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj3;
        int obj4;
        int obj5;
        final int i = 0;
        obj3 = i5 & 2 != 0 ? i : obj3;
        obj4 = i5 & 4 != 0 ? i : obj4;
        obj5 = i5 &= 8 != 0 ? i : obj5;
        super(textFieldState, obj3, obj4, obj5);
    }

    public static final androidx.compose.foundation.text.input.internal.TransformedTextFieldState.Companion access$getCompanion$p() {
        return TransformedTextFieldState.Companion;
    }

    public static final InputTransformation access$getInputTransformation$p(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this) {
        return $this.inputTransformation;
    }

    public static final State access$getOutputTransformedText$p(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this) {
        return $this.outputTransformedText;
    }

    public static final TextFieldState access$getTextFieldState$p(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this) {
        return $this.textFieldState;
    }

    @JvmStatic
    private static final androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, OutputTransformation outputTransformation2, androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity selectionWedgeAffinity3) {
        return TransformedTextFieldState.Companion.access$calculateTransformedText(TransformedTextFieldState.Companion, textFieldCharSequence, outputTransformation2, selectionWedgeAffinity3);
    }

    @JvmStatic
    private static final androidx.compose.foundation.text.input.internal.TransformedTextFieldState.TransformedText calculateTransformedText(TextFieldCharSequence textFieldCharSequence, androidx.compose.foundation.text.input.internal.CodepointTransformation codepointTransformation2, androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity selectionWedgeAffinity3) {
        return TransformedTextFieldState.Companion.access$calculateTransformedText(TransformedTextFieldState.Companion, textFieldCharSequence, codepointTransformation2, selectionWedgeAffinity3);
    }

    public static void editUntransformedTextAsUser$default(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this, boolean restartImeIfContentChanges, Function1 block, int i4, Object object5) {
        int obj5;
        if (i4 &= 1 != 0) {
            obj5 = 1;
        }
        int obj7 = 0;
        final TextFieldState obj8 = TransformedTextFieldState.access$getTextFieldState$p($this);
        final int i = 0;
        obj8.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        block.invoke(obj8.getMainBuffer$foundation_release());
        TextFieldState.access$commitEditAsUser(obj8, TransformedTextFieldState.access$getInputTransformation$p($this), obj5, TextFieldEditUndoBehavior.MergeIfPossible);
    }

    @JvmStatic
    private static final long mapFromTransformed-xdX6-G0(long l, androidx.compose.foundation.text.input.internal.OffsetMappingCalculator offsetMappingCalculator2) {
        return TransformedTextFieldState.Companion.access$mapFromTransformed-xdX6-G0(TransformedTextFieldState.Companion, l, offsetMappingCalculator2);
    }

    @JvmStatic
    private static final long mapToTransformed-XGyztTk(long l, androidx.compose.foundation.text.input.internal.OffsetMappingCalculator offsetMappingCalculator2, androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity selectionWedgeAffinity3) {
        return TransformedTextFieldState.Companion.access$mapToTransformed-XGyztTk(TransformedTextFieldState.Companion, l, offsetMappingCalculator2, selectionWedgeAffinity3);
    }

    public static void replaceSelectedText$default(androidx.compose.foundation.text.input.internal.TransformedTextFieldState transformedTextFieldState, java.lang.CharSequence charSequence2, boolean z3, TextFieldEditUndoBehavior textFieldEditUndoBehavior4, int i5, Object object6) {
        int obj2;
        TextFieldEditUndoBehavior obj3;
        if (i5 & 2 != 0) {
            obj2 = 0;
        }
        if (i5 &= 4 != 0) {
            obj3 = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        transformedTextFieldState.replaceSelectedText(charSequence2, obj2, obj3);
    }

    public static void replaceText-M8tDOmk$default(androidx.compose.foundation.text.input.internal.TransformedTextFieldState transformedTextFieldState, java.lang.CharSequence charSequence2, long l3, TextFieldEditUndoBehavior textFieldEditUndoBehavior4, boolean z5, int i6, Object object7) {
        TextFieldEditUndoBehavior field;
        int i;
        TextFieldEditUndoBehavior obj10;
        int obj11;
        field = object7 & 4 != 0 ? obj10 : z5;
        i = object7 & 8 != 0 ? obj11 : i6;
        transformedTextFieldState.replaceText-M8tDOmk(charSequence2, l3, obj3, field);
    }

    public final void collapseSelectionToEnd() {
        final TextFieldState textFieldState = this.textFieldState;
        final int i2 = 0;
        textFieldState.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        androidx.compose.foundation.text.input.internal.EditingBuffer mainBuffer$foundation_release2 = textFieldState.getMainBuffer$foundation_release();
        final int i3 = 0;
        mainBuffer$foundation_release2.setSelection(TextRange.getEnd-impl(mainBuffer$foundation_release2.getSelection-d9O1mEE()), TextRange.getEnd-impl(mainBuffer$foundation_release2.getSelection-d9O1mEE()));
        TextFieldState.access$commitEditAsUser(textFieldState, this.inputTransformation, true, TextFieldEditUndoBehavior.MergeIfPossible);
    }

    public final void collapseSelectionToMax() {
        final TextFieldState textFieldState = this.textFieldState;
        final int i2 = 0;
        textFieldState.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        androidx.compose.foundation.text.input.internal.EditingBuffer mainBuffer$foundation_release2 = textFieldState.getMainBuffer$foundation_release();
        final int i3 = 0;
        mainBuffer$foundation_release2.setSelection(TextRange.getMax-impl(mainBuffer$foundation_release2.getSelection-d9O1mEE()), TextRange.getMax-impl(mainBuffer$foundation_release2.getSelection-d9O1mEE()));
        TextFieldState.access$commitEditAsUser(textFieldState, this.inputTransformation, true, TextFieldEditUndoBehavior.MergeIfPossible);
    }

    public final Object collectImeNotifications(TextFieldState.NotifyImeListener textFieldState$NotifyImeListener, Continuation<?> continuation2) {
        boolean anon;
        int i2;
        Object cOROUTINE_SUSPENDED;
        int i5;
        Object cOROUTINE_SUSPENDED2;
        int i4;
        CancellableContinuationImpl cancellableContinuationImpl2;
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState.collectImeNotifications.1 field;
        int i;
        CancellableContinuationImpl cancellableContinuationImpl;
        int i3;
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState.collectImeNotifications.2.1 anon2;
        int obj11;
        Object obj12;
        anon = continuation2;
        i5 = Integer.MIN_VALUE;
        if (continuation2 instanceof TransformedTextFieldState.collectImeNotifications.1 && label &= i5 != 0) {
            anon = continuation2;
            i5 = Integer.MIN_VALUE;
            if (label &= i5 != 0) {
                anon.label = obj12 -= i5;
            } else {
                anon = new TransformedTextFieldState.collectImeNotifications.1(this, continuation2);
            }
        } else {
        }
        obj12 = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (cOROUTINE_SUSPENDED2) {
            case 0:
                ResultKt.throwOnFailure(obj12);
                androidx.compose.foundation.text.input.internal.TransformedTextFieldState field2 = this;
                anon.L$0 = field2;
                anon.L$1 = notifyImeListener;
                int i6 = 1;
                anon.label = i6;
                i = 0;
                cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation)anon), i6);
                cancellableContinuationImpl.initCancellability();
                i3 = 0;
                TransformedTextFieldState.access$getTextFieldState$p(field2).addNotifyImeListener$foundation_release(notifyImeListener);
                anon2 = new TransformedTextFieldState.collectImeNotifications.2.1(field2, notifyImeListener);
                (CancellableContinuation)cancellableContinuationImpl.invokeOnCancellation((Function1)anon2);
                obj11 = cancellableContinuationImpl.getResult();
                DebugProbesKt.probeCoroutineSuspended((Continuation)anon);
                return cOROUTINE_SUSPENDED;
                obj11 = i4;
                break;
            case 1:
                obj11 = 0;
                Object l$1 = anon.L$1;
                cOROUTINE_SUSPENDED = anon.L$0;
                ResultKt.throwOnFailure(obj12);
                break;
            default:
                obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj11;
        }
        obj11 = new KotlinNothingValueException();
        throw obj11;
    }

    public final void deleteSelectedText() {
        final TextFieldState textFieldState = this.textFieldState;
        final int i2 = 0;
        textFieldState.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        androidx.compose.foundation.text.input.internal.EditingBuffer mainBuffer$foundation_release2 = textFieldState.getMainBuffer$foundation_release();
        final int i3 = 0;
        int max-impl = TextRange.getMax-impl(mainBuffer$foundation_release2.getSelection-d9O1mEE());
        mainBuffer$foundation_release2.delete(TextRange.getMin-impl(mainBuffer$foundation_release2.getSelection-d9O1mEE()), max-impl);
        mainBuffer$foundation_release2.setSelection(TextRange.getMin-impl(mainBuffer$foundation_release2.getSelection-d9O1mEE()), TextRange.getMin-impl(mainBuffer$foundation_release2.getSelection-d9O1mEE()));
        TextFieldState.access$commitEditAsUser(textFieldState, this.inputTransformation, true, TextFieldEditUndoBehavior.NeverMerge);
    }

    public final void editUntransformedTextAsUser(boolean restartImeIfContentChanges, Function1<? super androidx.compose.foundation.text.input.internal.EditingBuffer, Unit> block) {
        final int i = 0;
        final TextFieldState field = TransformedTextFieldState.access$getTextFieldState$p(this);
        final int i2 = 0;
        field.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        block.invoke(field.getMainBuffer$foundation_release());
        TextFieldState.access$commitEditAsUser(field, TransformedTextFieldState.access$getInputTransformation$p(this), restartImeIfContentChanges, TextFieldEditUndoBehavior.MergeIfPossible);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return 1;
        }
        int i2 = 0;
        if (!other instanceof TransformedTextFieldState) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.textFieldState, obj2.textFieldState)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.codepointTransformation, obj3.codepointTransformation)) {
            return i2;
        }
        return Intrinsics.areEqual(this.outputTransformation, obj.outputTransformation);
    }

    public final TextFieldCharSequence getOutputText() {
        Object outputTransformedText;
        outputTransformedText = this.outputTransformedText;
        outputTransformedText = outputTransformedText.getValue();
        if (outputTransformedText != null && (TransformedTextFieldState.TransformedText)outputTransformedText != null) {
            outputTransformedText = outputTransformedText.getValue();
            if ((TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)outputTransformedText != null) {
                if ((TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)outputTransformedText.getText() == null) {
                    outputTransformedText = getUntransformedText();
                }
            } else {
            }
        } else {
        }
        return outputTransformedText;
    }

    public final androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity getSelectionWedgeAffinity() {
        final int i = 0;
        final int i2 = 0;
        return (SelectionWedgeAffinity)(State)this.selectionWedgeAffinity$delegate.getValue();
    }

    public final TextFieldCharSequence getUntransformedText() {
        return this.textFieldState.getValue$foundation_release();
    }

    public final TextFieldCharSequence getVisualText() {
        Object codepointTransformedText;
        codepointTransformedText = this.codepointTransformedText;
        codepointTransformedText = codepointTransformedText.getValue();
        if (codepointTransformedText != null && (TransformedTextFieldState.TransformedText)codepointTransformedText != null) {
            codepointTransformedText = codepointTransformedText.getValue();
            if ((TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)codepointTransformedText != null) {
                if ((TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)codepointTransformedText.getText() == null) {
                    codepointTransformedText = getOutputText();
                }
            } else {
            }
        } else {
        }
        return codepointTransformedText;
    }

    public int hashCode() {
        int i;
        int i2;
        androidx.compose.foundation.text.input.internal.CodepointTransformation codepointTransformation = this.codepointTransformation;
        if (codepointTransformation != null) {
            i = codepointTransformation.hashCode();
        } else {
            i = i2;
        }
        OutputTransformation outputTransformation = this.outputTransformation;
        if (outputTransformation != null) {
            i2 = outputTransformation.hashCode();
        }
        return result += i2;
    }

    public final void highlightCharsIn-7RAjNK8(int type, long transformedRange) {
        final long mapFromTransformed-GEjPoXI = mapFromTransformed-GEjPoXI(transformedRange);
        final TextFieldState textFieldState = this.textFieldState;
        final int i2 = 0;
        textFieldState.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        final int i3 = 0;
        textFieldState.getMainBuffer$foundation_release().setHighlight-K7f2yys(type, TextRange.getStart-impl(mapFromTransformed-GEjPoXI), TextRange.getEnd-impl(mapFromTransformed-GEjPoXI));
        TextFieldState.access$commitEditAsUser(textFieldState, this.inputTransformation, true, TextFieldEditUndoBehavior.MergeIfPossible);
    }

    public final long mapFromTransformed--jx7JFs(int offset) {
        Object outputTransformedText;
        int offsetMapping2;
        int offsetMapping;
        Object codepointTransformedText;
        long mapFromDest--jx7JFs;
        long it;
        int i;
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState.Companion companion;
        outputTransformedText = this.outputTransformedText;
        outputTransformedText = outputTransformedText.getValue();
        if (outputTransformedText != null && (TransformedTextFieldState.TransformedText)outputTransformedText != null) {
            outputTransformedText = outputTransformedText.getValue();
            if ((TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)outputTransformedText != null) {
                offsetMapping2 = (TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)outputTransformedText.getOffsetMapping();
            } else {
                offsetMapping2 = offsetMapping;
            }
        } else {
        }
        codepointTransformedText = this.codepointTransformedText;
        codepointTransformedText = codepointTransformedText.getValue();
        if (codepointTransformedText != null && (TransformedTextFieldState.TransformedText)codepointTransformedText != null) {
            codepointTransformedText = codepointTransformedText.getValue();
            if ((TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)codepointTransformedText != null) {
                offsetMapping = (TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)codepointTransformedText.getOffsetMapping();
            }
        }
        if (offsetMapping != 0) {
            mapFromDest--jx7JFs = offsetMapping.mapFromDest--jx7JFs(offset);
        } else {
            mapFromDest--jx7JFs = TextRangeKt.TextRange(offset);
        }
        if (offsetMapping2 != 0) {
            i = 0;
            it = TransformedTextFieldState.Companion.access$mapFromTransformed-xdX6-G0(TransformedTextFieldState.Companion, mapFromDest--jx7JFs, obj3);
        } else {
            it = mapFromDest--jx7JFs;
        }
        return it;
    }

    public final long mapFromTransformed-GEjPoXI(long range) {
        Object outputTransformedText;
        int offsetMapping2;
        int offsetMapping;
        Object codepointTransformedText;
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState.Companion it2;
        int i;
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState.Companion companion;
        long it;
        int i2;
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState.Companion companion2;
        outputTransformedText = this.outputTransformedText;
        outputTransformedText = outputTransformedText.getValue();
        if (outputTransformedText != null && (TransformedTextFieldState.TransformedText)outputTransformedText != null) {
            outputTransformedText = outputTransformedText.getValue();
            if ((TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)outputTransformedText != null) {
                offsetMapping2 = (TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)outputTransformedText.getOffsetMapping();
            } else {
                offsetMapping2 = offsetMapping;
            }
        } else {
        }
        codepointTransformedText = this.codepointTransformedText;
        codepointTransformedText = codepointTransformedText.getValue();
        if (codepointTransformedText != null && (TransformedTextFieldState.TransformedText)codepointTransformedText != null) {
            codepointTransformedText = codepointTransformedText.getValue();
            if ((TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)codepointTransformedText != null) {
                offsetMapping = (TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)codepointTransformedText.getOffsetMapping();
            }
        }
        if (offsetMapping != 0) {
            i = 0;
            it2 = TransformedTextFieldState.Companion.access$mapFromTransformed-xdX6-G0(TransformedTextFieldState.Companion, range, obj9);
        } else {
            it2 = range;
        }
        if (offsetMapping2 != 0) {
            i2 = 0;
            it = TransformedTextFieldState.Companion.access$mapFromTransformed-xdX6-G0(TransformedTextFieldState.Companion, it2, i);
        } else {
            it = it2;
        }
        return it;
    }

    public final long mapToTransformed--jx7JFs(int offset) {
        Object outputTransformedText;
        int offsetMapping;
        int offsetMapping2;
        Object codepointTransformedText;
        long mapFromSource--jx7JFs;
        long it;
        int i;
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState.Companion companion;
        androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity selectionWedgeAffinity;
        outputTransformedText = this.outputTransformedText;
        outputTransformedText = outputTransformedText.getValue();
        if (outputTransformedText != null && (TransformedTextFieldState.TransformedText)outputTransformedText != null) {
            outputTransformedText = outputTransformedText.getValue();
            if ((TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)outputTransformedText != null) {
                offsetMapping = (TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)outputTransformedText.getOffsetMapping();
            } else {
                offsetMapping = offsetMapping2;
            }
        } else {
        }
        codepointTransformedText = this.codepointTransformedText;
        codepointTransformedText = codepointTransformedText.getValue();
        if (codepointTransformedText != null && (TransformedTextFieldState.TransformedText)codepointTransformedText != null) {
            codepointTransformedText = codepointTransformedText.getValue();
            if ((TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)codepointTransformedText != null) {
                offsetMapping2 = (TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)codepointTransformedText.getOffsetMapping();
            }
        }
        if (offsetMapping != 0) {
            mapFromSource--jx7JFs = offsetMapping.mapFromSource--jx7JFs(offset);
        } else {
            mapFromSource--jx7JFs = TextRangeKt.TextRange(offset);
        }
        if (offsetMapping2 != 0) {
            i = 0;
            it = TransformedTextFieldState.Companion.access$mapToTransformed-XGyztTk(TransformedTextFieldState.Companion, mapFromSource--jx7JFs, obj3, offsetMapping2);
        } else {
            it = mapFromSource--jx7JFs;
        }
        return it;
    }

    public final long mapToTransformed-GEjPoXI(long range) {
        Object outputTransformedText;
        int offsetMapping;
        int offsetMapping2;
        Object codepointTransformedText;
        androidx.compose.foundation.text.input.internal.TransformedTextFieldState.Companion range2;
        int i;
        long l;
        int companion;
        int selectionWedgeAffinity;
        int i3;
        int i2;
        long obj11;
        outputTransformedText = this.outputTransformedText;
        outputTransformedText = outputTransformedText.getValue();
        if (outputTransformedText != null && (TransformedTextFieldState.TransformedText)outputTransformedText != null) {
            outputTransformedText = outputTransformedText.getValue();
            if ((TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)outputTransformedText != null) {
                offsetMapping = (TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)outputTransformedText.getOffsetMapping();
            } else {
                offsetMapping = offsetMapping2;
            }
        } else {
        }
        codepointTransformedText = this.codepointTransformedText;
        codepointTransformedText = codepointTransformedText.getValue();
        if (codepointTransformedText != null && (TransformedTextFieldState.TransformedText)codepointTransformedText != null) {
            codepointTransformedText = codepointTransformedText.getValue();
            if ((TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)codepointTransformedText != null) {
                offsetMapping2 = (TransformedTextFieldState.TransformedText)(TransformedTextFieldState.TransformedText)codepointTransformedText.getOffsetMapping();
            }
        }
        if (offsetMapping != 0) {
            i2 = 0;
            obj11 = TransformedTextFieldState.Companion.mapToTransformed-XGyztTk$default(TransformedTextFieldState.Companion, range, obj4, offsetMapping, 0, 4);
        } else {
            range2 = range;
        }
        if (offsetMapping2 != 0) {
            int i4 = 0;
            l = TransformedTextFieldState.Companion.access$mapToTransformed-XGyztTk(TransformedTextFieldState.Companion, obj11, obj12, offsetMapping2);
        } else {
            l = obj11;
        }
        return l;
    }

    public final void placeCursorBeforeCharAt(int transformedOffset) {
        selectCharsIn-5zc-tL8(TextRangeKt.TextRange(transformedOffset));
    }

    public final void redo() {
        this.textFieldState.getUndoState().redo();
    }

    public final void replaceAll(java.lang.CharSequence newText) {
        final TextFieldState textFieldState = this.textFieldState;
        final int i2 = 0;
        textFieldState.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        androidx.compose.foundation.text.input.internal.EditingBuffer mainBuffer$foundation_release2 = textFieldState.getMainBuffer$foundation_release();
        final int i3 = 0;
        EditCommandKt.deleteAll(mainBuffer$foundation_release2);
        EditCommandKt.commitText(mainBuffer$foundation_release2, newText.toString(), 1);
        TextFieldState.access$commitEditAsUser(textFieldState, this.inputTransformation, true, TextFieldEditUndoBehavior.MergeIfPossible);
    }

    public final void replaceSelectedText(java.lang.CharSequence newText, boolean clearComposition, TextFieldEditUndoBehavior undoBehavior) {
        final TextFieldState textFieldState = this.textFieldState;
        final int i2 = 0;
        textFieldState.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        androidx.compose.foundation.text.input.internal.EditingBuffer mainBuffer$foundation_release2 = textFieldState.getMainBuffer$foundation_release();
        final int i3 = 0;
        if (clearComposition) {
            mainBuffer$foundation_release2.commitComposition();
        }
        final long selection-d9O1mEE = mainBuffer$foundation_release2.getSelection-d9O1mEE();
        mainBuffer$foundation_release2.replace(TextRange.getMin-impl(selection-d9O1mEE), TextRange.getMax-impl(selection-d9O1mEE), newText);
        min-impl2 += length;
        mainBuffer$foundation_release2.setSelection(i4, i4);
        TextFieldState.access$commitEditAsUser(textFieldState, this.inputTransformation, true, undoBehavior);
    }

    public final void replaceText-M8tDOmk(java.lang.CharSequence newText, long range, TextFieldEditUndoBehavior undoBehavior, boolean restartImeIfContentChanges) {
        final TextFieldState textFieldState = this.textFieldState;
        final int i = 0;
        textFieldState.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        androidx.compose.foundation.text.input.internal.EditingBuffer mainBuffer$foundation_release2 = textFieldState.getMainBuffer$foundation_release();
        final int i2 = 0;
        final long mapFromTransformed-GEjPoXI = mapFromTransformed-GEjPoXI(range);
        mainBuffer$foundation_release2.replace(TextRange.getMin-impl(mapFromTransformed-GEjPoXI), TextRange.getMax-impl(mapFromTransformed-GEjPoXI), newText);
        min-impl2 += length;
        mainBuffer$foundation_release2.setSelection(i3, i3);
        TextFieldState.access$commitEditAsUser(textFieldState, this.inputTransformation, obj14, restartImeIfContentChanges);
    }

    public final void selectAll() {
        final TextFieldState textFieldState = this.textFieldState;
        final int i2 = 0;
        textFieldState.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        androidx.compose.foundation.text.input.internal.EditingBuffer mainBuffer$foundation_release2 = textFieldState.getMainBuffer$foundation_release();
        final int i3 = 0;
        mainBuffer$foundation_release2.setSelection(0, mainBuffer$foundation_release2.getLength());
        TextFieldState.access$commitEditAsUser(textFieldState, this.inputTransformation, true, TextFieldEditUndoBehavior.MergeIfPossible);
    }

    public final void selectCharsIn-5zc-tL8(long transformedRange) {
        selectUntransformedCharsIn-5zc-tL8(mapFromTransformed-GEjPoXI(transformedRange));
    }

    public final void selectUntransformedCharsIn-5zc-tL8(long untransformedRange) {
        final TextFieldState textFieldState = this.textFieldState;
        final int i2 = 0;
        textFieldState.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        final int i3 = 0;
        textFieldState.getMainBuffer$foundation_release().setSelection(TextRange.getStart-impl(untransformedRange), TextRange.getEnd-impl(untransformedRange));
        TextFieldState.access$commitEditAsUser(textFieldState, this.inputTransformation, true, TextFieldEditUndoBehavior.MergeIfPossible);
    }

    public final void setSelectionWedgeAffinity(androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.selectionWedgeAffinity$delegate.setValue(<set-?>);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("TransformedTextFieldState(textFieldState=").append(this.textFieldState).append(", outputTransformation=").append(this.outputTransformation).append(", outputTransformedText=").append(this.outputTransformedText).append(", codepointTransformation=").append(this.codepointTransformation).append(", codepointTransformedText=").append(this.codepointTransformedText).append(", outputText=\"").append(getOutputText()).append("\", visualText=\"").append(getVisualText()).append("\")").toString();
    }

    public final void undo() {
        this.textFieldState.getUndoState().undo();
    }

    public final void update(InputTransformation inputTransformation) {
        this.inputTransformation = inputTransformation;
    }
}

package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a^\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042<\u0010\u0005\u001a8\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u00110\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u0002H\u00010\u0006H\u0080\u0008¢\u0006\u0002\u0010\r¨\u0006\u000e", d2 = {"getIndexTransformationType", "R", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "transformedQueryIndex", "", "onResult", "Lkotlin/Function3;", "Landroidx/compose/foundation/text/input/internal/IndexTransformationType;", "Landroidx/compose/ui/text/TextRange;", "Lkotlin/ParameterName;", "name", "untransformed", "retransformed", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;ILkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TransformedTextFieldStateKt {
    public static final <R> R getIndexTransformationType(androidx.compose.foundation.text.input.internal.TransformedTextFieldState $this$getIndexTransformationType, int transformedQueryIndex, Function3<? super androidx.compose.foundation.text.input.internal.IndexTransformationType, ? super TextRange, ? super TextRange, ? extends R> onResult) {
        boolean collapsed-impl2;
        boolean collapsed-impl;
        boolean collapsed-impl3;
        androidx.compose.foundation.text.input.internal.IndexTransformationType untransformed;
        final int i = 0;
        final long mapFromTransformed--jx7JFs = $this$getIndexTransformationType.mapFromTransformed--jx7JFs(transformedQueryIndex);
        final long mapToTransformed-GEjPoXI = $this$getIndexTransformationType.mapToTransformed-GEjPoXI(mapFromTransformed--jx7JFs);
        if (TextRange.getCollapsed-impl(mapFromTransformed--jx7JFs) && TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI)) {
            if (TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI)) {
                untransformed = IndexTransformationType.Untransformed;
            } else {
                if (!TextRange.getCollapsed-impl(mapFromTransformed--jx7JFs) && !TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI)) {
                    if (!TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI)) {
                        untransformed = IndexTransformationType.Replacement;
                    } else {
                        if (TextRange.getCollapsed-impl(mapFromTransformed--jx7JFs) && !TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI)) {
                            untransformed = !TextRange.getCollapsed-impl(mapToTransformed-GEjPoXI) ? IndexTransformationType.Insertion : IndexTransformationType.Deletion;
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
        return onResult.invoke(untransformed, TextRange.box-impl(mapFromTransformed--jx7JFs), TextRange.box-impl(mapToTransformed-GEjPoXI));
    }
}

package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.OffsetMapping.Companion;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002\u001a \u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\u001e\u0010\u0012\u001a\u00020\u0005*\u00020\u000e2\u0006\u0010\u000c\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0007H\u0001\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u0014", d2 = {"ValidatingEmptyOffsetMappingIdentity", "Landroidx/compose/ui/text/input/OffsetMapping;", "getValidatingEmptyOffsetMappingIdentity", "()Landroidx/compose/ui/text/input/OffsetMapping;", "validateOriginalToTransformed", "", "transformedOffset", "", "transformedLength", "offset", "validateTransformedToOriginal", "originalOffset", "originalLength", "filterWithValidation", "Landroidx/compose/ui/text/input/TransformedText;", "Landroidx/compose/ui/text/input/VisualTransformation;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "throwIfNotValidTransform", "limit", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ValidatingOffsetMappingKt {

    private static final OffsetMapping ValidatingEmptyOffsetMappingIdentity;
    static {
        final int i = 0;
        ValidatingOffsetMapping validatingOffsetMapping = new ValidatingOffsetMapping(OffsetMapping.Companion.getIdentity(), i, i);
        ValidatingOffsetMappingKt.ValidatingEmptyOffsetMappingIdentity = (OffsetMapping)validatingOffsetMapping;
    }

    public static final void access$validateOriginalToTransformed(int transformedOffset, int transformedLength, int offset) {
        ValidatingOffsetMappingKt.validateOriginalToTransformed(transformedOffset, transformedLength, offset);
    }

    public static final void access$validateTransformedToOriginal(int originalOffset, int originalLength, int offset) {
        ValidatingOffsetMappingKt.validateTransformedToOriginal(originalOffset, originalLength, offset);
    }

    public static final TransformedText filterWithValidation(VisualTransformation $this$filterWithValidation, AnnotatedString text) {
        final TransformedText filter = $this$filterWithValidation.filter(text);
        ValidatingOffsetMappingKt.throwIfNotValidTransform$default(filter, text.length(), 0, 2, 0);
        ValidatingOffsetMapping validatingOffsetMapping = new ValidatingOffsetMapping(filter.getOffsetMapping(), text.length(), filter.getText().length());
        TransformedText transformedText = new TransformedText(filter.getText(), (OffsetMapping)validatingOffsetMapping);
        return transformedText;
    }

    public static final OffsetMapping getValidatingEmptyOffsetMappingIdentity() {
        return ValidatingOffsetMappingKt.ValidatingEmptyOffsetMappingIdentity;
    }

    public static final void throwIfNotValidTransform(TransformedText $this$throwIfNotValidTransform, int originalLength, int limit) {
        int offset2;
        int offset;
        int originalToTransformed;
        int transformedToOriginal;
        int length = $this$throwIfNotValidTransform.getText().length();
        offset2 = 0;
        while (offset2 < Math.min(originalLength, limit)) {
            ValidatingOffsetMappingKt.validateOriginalToTransformed($this$throwIfNotValidTransform.getOffsetMapping().originalToTransformed(offset2), length, offset2);
            offset2++;
        }
        ValidatingOffsetMappingKt.validateOriginalToTransformed($this$throwIfNotValidTransform.getOffsetMapping().originalToTransformed(originalLength), length, originalLength);
        offset = 0;
        while (offset < Math.min(length, limit)) {
            ValidatingOffsetMappingKt.validateTransformedToOriginal($this$throwIfNotValidTransform.getOffsetMapping().transformedToOriginal(offset), originalLength, offset);
            offset++;
        }
        ValidatingOffsetMappingKt.validateTransformedToOriginal($this$throwIfNotValidTransform.getOffsetMapping().transformedToOriginal(length), originalLength, length);
    }

    public static void throwIfNotValidTransform$default(TransformedText transformedText, int i2, int i3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 100;
        }
        ValidatingOffsetMappingKt.throwIfNotValidTransform(transformedText, i2, obj2);
    }

    private static final void validateOriginalToTransformed(int transformedOffset, int transformedLength, int offset) {
        int i;
        i = 0;
        if (transformedOffset >= 0 && transformedOffset <= transformedLength) {
            if (transformedOffset <= transformedLength) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("OffsetMapping.originalToTransformed returned invalid mapping: ").append(offset).append(" -> ").append(transformedOffset).append(" is not in range of transformed text [0, ").append(transformedLength).append(']').toString().toString());
        throw illegalStateException;
    }

    private static final void validateTransformedToOriginal(int originalOffset, int originalLength, int offset) {
        int i;
        i = 0;
        if (originalOffset >= 0 && originalOffset <= originalLength) {
            if (originalOffset <= originalLength) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("OffsetMapping.transformedToOriginal returned invalid mapping: ").append(offset).append(" -> ").append(originalOffset).append(" is not in range of original text [0, ").append(originalLength).append(']').toString().toString());
        throw illegalStateException;
    }
}

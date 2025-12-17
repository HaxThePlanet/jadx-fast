package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.StringHelpers_jvmKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000c\n\u0000\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b", d2 = {"mask", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation$Companion;", "character", "", "toVisualText", "", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "codepointTransformation", "offsetMappingCalculator", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CodepointTransformationKt {
    public static final androidx.compose.foundation.text.input.internal.CodepointTransformation mask(androidx.compose.foundation.text.input.internal.CodepointTransformation.Companion $this$mask, char character) {
        MaskCodepointTransformation maskCodepointTransformation = new MaskCodepointTransformation(character);
        return (CodepointTransformation)maskCodepointTransformation;
    }

    public static final java.lang.CharSequence toVisualText(TextFieldCharSequence $this$toVisualText, androidx.compose.foundation.text.input.internal.CodepointTransformation codepointTransformation, androidx.compose.foundation.text.input.internal.OffsetMappingCalculator offsetMappingCalculator) {
        int changed;
        String str;
        int charOffset;
        int codePointOffset;
        int codePointAt;
        int transform;
        int charCount2;
        int charCount;
        int length;
        int i;
        final java.lang.CharSequence charSequence = $this$toVisualText;
        changed = 0;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        final int i2 = 0;
        charOffset = 0;
        codePointOffset = 0;
        while (charOffset < charSequence.length()) {
            codePointAt = CodepointHelpers_jvmKt.codePointAt((CharSequence)charSequence, charOffset);
            transform = codepointTransformation.transform(codePointOffset, codePointAt);
            charCount2 = CodepointHelpers_jvmKt.charCount(codePointAt);
            if (transform != codePointAt) {
            }
            StringHelpers_jvmKt.appendCodePointX(sb, transform);
            charOffset += charCount2;
            codePointOffset++;
            changed = 1;
            offsetMappingCalculator.recordEditOperation(sb.length(), length3 += charCount2, CodepointHelpers_jvmKt.charCount(transform));
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        if (changed != 0) {
            str = string;
        } else {
            str = $this$toVisualText;
        }
        return str;
    }
}

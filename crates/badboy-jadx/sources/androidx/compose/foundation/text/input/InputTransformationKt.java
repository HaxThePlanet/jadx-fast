package androidx.compose.foundation.text.input;

import androidx.compose.ui.text.intl.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001aD\u0010\u0004\u001a\u00020\u0001*\u00020\u000126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007\u001a\u0014\u0010\u000c\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000c\u001a\u00020\rH\u0007\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007¨\u0006\u0010", d2 = {"allCaps", "Landroidx/compose/foundation/text/input/InputTransformation;", "locale", "Landroidx/compose/ui/text/intl/Locale;", "byValue", "transformation", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "current", "proposed", "maxLength", "", "then", "next", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InputTransformationKt {
    public static final androidx.compose.foundation.text.input.InputTransformation allCaps(androidx.compose.foundation.text.input.InputTransformation $this$allCaps, Locale locale) {
        AllCapsTransformation allCapsTransformation = new AllCapsTransformation(locale);
        return InputTransformationKt.then($this$allCaps, (InputTransformation)allCapsTransformation);
    }

    public static final androidx.compose.foundation.text.input.InputTransformation byValue(androidx.compose.foundation.text.input.InputTransformation $this$byValue, Function2<? super java.lang.CharSequence, ? super java.lang.CharSequence, ? extends java.lang.CharSequence> transformation) {
        InputTransformationByValue inputTransformationByValue = new InputTransformationByValue(transformation);
        return InputTransformationKt.then($this$byValue, (InputTransformation)inputTransformationByValue);
    }

    public static final androidx.compose.foundation.text.input.InputTransformation maxLength(androidx.compose.foundation.text.input.InputTransformation $this$maxLength, int maxLength) {
        MaxLengthFilter maxLengthFilter = new MaxLengthFilter(maxLength);
        return InputTransformationKt.then($this$maxLength, (InputTransformation)maxLengthFilter);
    }

    public static final androidx.compose.foundation.text.input.InputTransformation then(androidx.compose.foundation.text.input.InputTransformation $this$then, androidx.compose.foundation.text.input.InputTransformation next) {
        FilterChain filterChain = new FilterChain($this$then, next);
        return (InputTransformation)filterChain;
    }
}

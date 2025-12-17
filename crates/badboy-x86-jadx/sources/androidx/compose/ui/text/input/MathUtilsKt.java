package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\u0008\u001a#\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0004H\u0080\u0008¨\u0006\u0006", d2 = {"addExactOrElse", "", "right", "defaultValue", "Lkotlin/Function0;", "subtractExactOrElse", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MathUtilsKt {
    public static final int addExactOrElse(int $this$addExactOrElse, int right, Function0<Integer> defaultValue) {
        int intValue;
        final int i = 0;
        final int i2 = $this$addExactOrElse + right;
        if (i3 &= i5 < 0) {
            intValue = (Number)defaultValue.invoke().intValue();
        } else {
            intValue = i2;
        }
        return intValue;
    }

    public static final int subtractExactOrElse(int $this$subtractExactOrElse, int right, Function0<Integer> defaultValue) {
        int intValue;
        final int i = 0;
        final int i2 = $this$subtractExactOrElse - right;
        if (i3 &= i5 < 0) {
            intValue = (Number)defaultValue.invoke().intValue();
        } else {
            intValue = i2;
        }
        return intValue;
    }
}

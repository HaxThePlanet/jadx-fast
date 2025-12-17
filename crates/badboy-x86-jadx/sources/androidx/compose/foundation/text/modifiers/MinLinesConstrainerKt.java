package androidx.compose.foundation.text.modifiers;

import kotlin.Metadata;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"DefaultWidthCharCount", "", "EmptyTextReplacement", "", "TwoLineTextReplacement", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MinLinesConstrainerKt {

    private static final int DefaultWidthCharCount = 10;
    private static final String EmptyTextReplacement;
    private static final String TwoLineTextReplacement;
    static {
        int i = 10;
        MinLinesConstrainerKt.EmptyTextReplacement = StringsKt.repeat((CharSequence)"H", i);
        StringBuilder stringBuilder = new StringBuilder();
        MinLinesConstrainerKt.TwoLineTextReplacement = stringBuilder.append(MinLinesConstrainerKt.EmptyTextReplacement).append(i).append(MinLinesConstrainerKt.EmptyTextReplacement).toString();
    }

    public static final String access$getEmptyTextReplacement$p() {
        return MinLinesConstrainerKt.EmptyTextReplacement;
    }

    public static final String access$getTwoLineTextReplacement$p() {
        return MinLinesConstrainerKt.TwoLineTextReplacement;
    }
}

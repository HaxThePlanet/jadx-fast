package androidx.compose.ui.text.input;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¨\u0006\u0005", d2 = {"isSurrogatePair", "", "high", "", "low", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EditCommandKt {
    public static final boolean access$isSurrogatePair(char high, char low) {
        return EditCommandKt.isSurrogatePair(high, low);
    }

    private static final boolean isSurrogatePair(char high, char low) {
        boolean highSurrogate;
        int i;
        if (Character.isHighSurrogate(high) && Character.isLowSurrogate(low)) {
            i = Character.isLowSurrogate(low) ? 1 : 0;
        } else {
        }
        return i;
    }
}

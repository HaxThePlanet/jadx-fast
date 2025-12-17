package androidx.compose.foundation.text;

import androidx.emoji2.text.EmojiCompat;
import java.text.BreakIterator;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u001a\n\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003H\u0000¨\u0006\u0007", d2 = {"getEmojiCompatIfLoaded", "Landroidx/emoji2/text/EmojiCompat;", "findFollowingBreak", "", "", "index", "findPrecedingBreak", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StringHelpers_androidKt {
    public static final int findFollowingBreak(String $this$findFollowingBreak, int index) {
        Object emojiCompatIfLoaded;
        int i2;
        int intValue;
        int i3;
        int i;
        emojiCompatIfLoaded = StringHelpers_androidKt.getEmojiCompatIfLoaded();
        i2 = 0;
        if (emojiCompatIfLoaded != null) {
            emojiCompatIfLoaded = Integer.valueOf(emojiCompatIfLoaded.getEmojiEnd((CharSequence)$this$findFollowingBreak, index));
            i3 = 0;
            i = (Number)emojiCompatIfLoaded.intValue() == -1 ? 1 : 0;
            if (i == 0) {
                i2 = emojiCompatIfLoaded;
            }
        }
        if (i2 != 0) {
            return i2.intValue();
        }
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText($this$findFollowingBreak);
        return characterInstance.following(index);
    }

    public static final int findPrecedingBreak(String $this$findPrecedingBreak, int index) {
        Object emojiCompatIfLoaded;
        int i;
        int intValue;
        int i3;
        int i4;
        int i2;
        emojiCompatIfLoaded = StringHelpers_androidKt.getEmojiCompatIfLoaded();
        i = 0;
        emojiCompatIfLoaded = Integer.valueOf(emojiCompatIfLoaded.getEmojiStart((CharSequence)$this$findPrecedingBreak, Math.max(0, index + -1)));
        i3 = 0;
        if (emojiCompatIfLoaded != null && (Number)emojiCompatIfLoaded.intValue() == -1) {
            emojiCompatIfLoaded = Integer.valueOf(emojiCompatIfLoaded.getEmojiStart((CharSequence)$this$findPrecedingBreak, Math.max(0, index + -1)));
            i3 = 0;
            if ((Number)emojiCompatIfLoaded.intValue() == -1) {
                i4 = 1;
            }
            if (i4 == 0) {
                i = emojiCompatIfLoaded;
            }
        }
        if (i != 0) {
            return i.intValue();
        }
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText($this$findPrecedingBreak);
        return characterInstance.preceding(index);
    }

    private static final EmojiCompat getEmojiCompatIfLoaded() {
        boolean configured;
        int i3;
        EmojiCompat emojiCompat;
        int i2;
        int loadState;
        int i;
        i3 = 0;
        if (EmojiCompat.isConfigured()) {
            configured = EmojiCompat.get();
            i2 = 0;
            if (configured.getLoadState() == 1) {
            } else {
                i = 0;
            }
            if (i != 0) {
                i3 = configured;
            }
        } else {
        }
        return i3;
    }
}

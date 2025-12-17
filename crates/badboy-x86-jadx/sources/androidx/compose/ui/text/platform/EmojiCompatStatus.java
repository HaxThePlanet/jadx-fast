package androidx.compose.ui.text.platform;

import androidx.compose.runtime.State;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0001¢\u0006\u0002\u0008\u000cR\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\r", d2 = {"Landroidx/compose/ui/text/platform/EmojiCompatStatus;", "Landroidx/compose/ui/text/platform/EmojiCompatStatusDelegate;", "()V", "delegate", "fontLoaded", "Landroidx/compose/runtime/State;", "", "getFontLoaded", "()Landroidx/compose/runtime/State;", "setDelegateForTesting", "", "newDelegate", "setDelegateForTesting$ui_text_release", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EmojiCompatStatus implements androidx.compose.ui.text.platform.EmojiCompatStatusDelegate {

    public static final int $stable = 8;
    public static final androidx.compose.ui.text.platform.EmojiCompatStatus INSTANCE;
    private static androidx.compose.ui.text.platform.EmojiCompatStatusDelegate delegate;
    static {
        EmojiCompatStatus emojiCompatStatus = new EmojiCompatStatus();
        EmojiCompatStatus.INSTANCE = emojiCompatStatus;
        DefaultImpl defaultImpl = new DefaultImpl();
        EmojiCompatStatus.delegate = (EmojiCompatStatusDelegate)defaultImpl;
        int i = 8;
    }

    public State<Boolean> getFontLoaded() {
        return EmojiCompatStatus.delegate.getFontLoaded();
    }

    @Override // androidx.compose.ui.text.platform.EmojiCompatStatusDelegate
    public final void setDelegateForTesting$ui_text_release(androidx.compose.ui.text.platform.EmojiCompatStatusDelegate newDelegate) {
        androidx.compose.ui.text.platform.DefaultImpl defaultImpl;
        if (newDelegate == null) {
            defaultImpl = new DefaultImpl();
        } else {
            defaultImpl = newDelegate;
        }
        EmojiCompatStatus.delegate = defaultImpl;
    }
}

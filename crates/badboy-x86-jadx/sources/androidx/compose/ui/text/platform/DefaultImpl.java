package androidx.compose.ui.text.platform;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.emoji2.text.EmojiCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004H\u0002R\u001a\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u0016\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Landroidx/compose/ui/text/platform/DefaultImpl;", "Landroidx/compose/ui/text/platform/EmojiCompatStatusDelegate;", "()V", "fontLoaded", "Landroidx/compose/runtime/State;", "", "getFontLoaded", "()Landroidx/compose/runtime/State;", "loadState", "getFontLoadState", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultImpl implements androidx.compose.ui.text.platform.EmojiCompatStatusDelegate {

    private State<Boolean> loadState = null;
    public DefaultImpl() {
        super();
        if (EmojiCompat.isConfigured()) {
            State fontLoadState = getFontLoadState();
        }
        int i = 0;
    }

    public static final void access$setLoadState$p(androidx.compose.ui.text.platform.DefaultImpl $this, State <set-?>) {
        $this.loadState = <set-?>;
    }

    private final State<Boolean> getFontLoadState() {
        Object mutableStateOf$default;
        int anon;
        androidx.compose.ui.text.platform.DefaultImpl.getFontLoadState.initCallback.1 anon2;
        final EmojiCompat emojiCompat = EmojiCompat.get();
        anon = 1;
        if (emojiCompat.getLoadState() == anon) {
            mutableStateOf$default = new ImmutableBool(anon);
        } else {
            int i3 = 0;
            anon = new DefaultImpl.getFontLoadState.initCallback.1(SnapshotStateKt.mutableStateOf$default(false, i3, 2, i3), this);
            emojiCompat.registerInitCallback((EmojiCompat.InitCallback)anon);
        }
        return mutableStateOf$default;
    }

    public State<Boolean> getFontLoaded() {
        State loadState;
        if (this.loadState != null) {
            Intrinsics.checkNotNull(this.loadState);
        } else {
            if (EmojiCompat.isConfigured()) {
                this.loadState = getFontLoadState();
                Intrinsics.checkNotNull(this.loadState);
            } else {
                loadState = EmojiCompatStatus_androidKt.access$getFalsey$p();
            }
        }
        return loadState;
    }
}

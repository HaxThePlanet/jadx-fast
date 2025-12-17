package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.KeyEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u001c\u0010\u0004\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\t", d2 = {"defaultKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "getDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "commonKeyMapping", "shortcutModifier", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class KeyMappingKt {

    private static final androidx.compose.foundation.text.KeyMapping defaultKeyMapping;
    static {
        final int i = 0;
        KeyMappingKt.defaultKeyMapping.2.1 anon = new KeyMappingKt.defaultKeyMapping.2.1(KeyMappingKt.commonKeyMapping((Function1)KeyMappingKt.defaultKeyMapping.1.INSTANCE));
        KeyMappingKt.defaultKeyMapping = (KeyMapping)anon;
    }

    public static final androidx.compose.foundation.text.KeyMapping commonKeyMapping(Function1<? super KeyEvent, Boolean> shortcutModifier) {
        KeyMappingKt.commonKeyMapping.1 anon = new KeyMappingKt.commonKeyMapping.1(shortcutModifier);
        return (KeyMapping)anon;
    }

    public static final androidx.compose.foundation.text.KeyMapping getDefaultKeyMapping() {
        return KeyMappingKt.defaultKeyMapping;
    }
}

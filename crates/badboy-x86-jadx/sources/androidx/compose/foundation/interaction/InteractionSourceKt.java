package androidx.compose.foundation.interaction;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002", d2 = {"MutableInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InteractionSourceKt {
    public static final androidx.compose.foundation.interaction.MutableInteractionSource MutableInteractionSource() {
        MutableInteractionSourceImpl mutableInteractionSourceImpl = new MutableInteractionSourceImpl();
        return (MutableInteractionSource)mutableInteractionSourceImpl;
    }
}

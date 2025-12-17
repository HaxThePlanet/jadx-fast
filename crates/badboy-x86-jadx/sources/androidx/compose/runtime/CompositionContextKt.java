package androidx.compose.runtime;

import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002", d2 = {"EmptyPersistentCompositionLocalMap", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CompositionContextKt {

    private static final androidx.compose.runtime.PersistentCompositionLocalMap EmptyPersistentCompositionLocalMap;
    static {
        CompositionContextKt.EmptyPersistentCompositionLocalMap = (PersistentCompositionLocalMap)PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
    }

    public static final androidx.compose.runtime.PersistentCompositionLocalMap access$getEmptyPersistentCompositionLocalMap$p() {
        return CompositionContextKt.EmptyPersistentCompositionLocalMap;
    }
}

package androidx.compose.runtime;

import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008v\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\"\u0010\u0002\u001a\u0002H\u0003\"\u0004\u0008\u0000\u0010\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0005H¦\u0002¢\u0006\u0002\u0010\u0006\u0082\u0001\u0001\u0008ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\tÀ\u0006\u0001", d2 = {"Landroidx/compose/runtime/CompositionLocalMap;", "", "get", "T", "key", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "Companion", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CompositionLocalMap {

    public static final androidx.compose.runtime.CompositionLocalMap.Companion Companion;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/runtime/CompositionLocalMap$Companion;", "", "()V", "Empty", "Landroidx/compose/runtime/CompositionLocalMap;", "getEmpty", "()Landroidx/compose/runtime/CompositionLocalMap;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.runtime.CompositionLocalMap.Companion $$INSTANCE;
        private static final androidx.compose.runtime.CompositionLocalMap Empty;
        static {
            CompositionLocalMap.Companion companion = new CompositionLocalMap.Companion();
            CompositionLocalMap.Companion.$$INSTANCE = companion;
            CompositionLocalMap.Companion.Empty = (CompositionLocalMap)PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
        }

        public final androidx.compose.runtime.CompositionLocalMap getEmpty() {
            return CompositionLocalMap.Companion.Empty;
        }
    }
    static {
        CompositionLocalMap.Companion = CompositionLocalMap.Companion.$$INSTANCE;
    }

    public abstract <T> T get(androidx.compose.runtime.CompositionLocal<T> compositionLocal);
}

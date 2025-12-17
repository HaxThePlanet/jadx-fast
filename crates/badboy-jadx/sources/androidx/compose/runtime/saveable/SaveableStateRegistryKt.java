package androidx.compose.runtime.saveable;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.text.CharsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\u001a8\u0010\u0005\u001a\u00020\u00022\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\u0008\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0018\u00010\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\u000c\u001a\u000c\u0010\u000e\u001a\u00020\r*\u00020\u000fH\u0002\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\u0010", d2 = {"LocalSaveableStateRegistry", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "getLocalSaveableStateRegistry", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "SaveableStateRegistry", "restoredValues", "", "", "", "", "canBeSaved", "Lkotlin/Function1;", "", "fastIsBlank", "", "runtime-saveable_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SaveableStateRegistryKt {

    private static final ProvidableCompositionLocal<androidx.compose.runtime.saveable.SaveableStateRegistry> LocalSaveableStateRegistry;
    static {
        SaveableStateRegistryKt.LocalSaveableStateRegistry = CompositionLocalKt.staticCompositionLocalOf((Function0)SaveableStateRegistryKt.LocalSaveableStateRegistry.1.INSTANCE);
    }

    public static final androidx.compose.runtime.saveable.SaveableStateRegistry SaveableStateRegistry(Map<String, ? extends List<? extends Object>> restoredValues, Function1<Object, Boolean> canBeSaved) {
        SaveableStateRegistryImpl saveableStateRegistryImpl = new SaveableStateRegistryImpl(restoredValues, canBeSaved);
        return (SaveableStateRegistry)saveableStateRegistryImpl;
    }

    public static final boolean access$fastIsBlank(java.lang.CharSequence $receiver) {
        return SaveableStateRegistryKt.fastIsBlank($receiver);
    }

    private static final boolean fastIsBlank(java.lang.CharSequence $this$fastIsBlank) {
        int blank;
        int i;
        boolean whitespace;
        blank = 1;
        i = 0;
        while (i < $this$fastIsBlank.length()) {
            if (!CharsKt.isWhitespace($this$fastIsBlank.charAt(i))) {
                break;
            } else {
            }
            i++;
        }
        return blank;
    }

    public static final ProvidableCompositionLocal<androidx.compose.runtime.saveable.SaveableStateRegistry> getLocalSaveableStateRegistry() {
        return SaveableStateRegistryKt.LocalSaveableStateRegistry;
    }
}

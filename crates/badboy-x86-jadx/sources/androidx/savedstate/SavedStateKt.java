package androidx.savedstate;

import android.os.Bundle;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
@Metadata(d1 = {"androidx/savedstate/SavedStateKt__SavedStateKt", "androidx/savedstate/SavedStateKt__SavedState_androidKt"}, k = 4, mv = {2, 0, 0}, xi = 48)
public final class SavedStateKt {
    public static final <T> T read(Bundle $this$read, Function1<? super androidx.savedstate.SavedStateReader, ? extends T> block) {
        return SavedStateKt__SavedStateKt.read($this$read, block);
    }

    public static final Bundle savedState(Bundle initialState, Function1<? super androidx.savedstate.SavedStateWriter, Unit> builderAction) {
        return SavedStateKt__SavedState_androidKt.savedState(initialState, builderAction);
    }

    public static final Bundle savedState(Map<String, ? extends Object> initialState, Function1<? super androidx.savedstate.SavedStateWriter, Unit> builderAction) {
        return SavedStateKt__SavedState_androidKt.savedState(initialState, builderAction);
    }

    public static Bundle savedState$default(Bundle initialState, Function1 builderAction, int i3, Object object4) {
        return SavedStateKt__SavedState_androidKt.savedState$default(initialState, builderAction, i3, object4);
    }

    public static Bundle savedState$default(Map initialState, Function1 builderAction, int i3, Object object4) {
        return SavedStateKt__SavedState_androidKt.savedState$default(initialState, builderAction, i3, object4);
    }

    public static final <T> T write(Bundle $this$write, Function1<? super androidx.savedstate.SavedStateWriter, ? extends T> block) {
        return SavedStateKt__SavedStateKt.write($this$write, block);
    }
}

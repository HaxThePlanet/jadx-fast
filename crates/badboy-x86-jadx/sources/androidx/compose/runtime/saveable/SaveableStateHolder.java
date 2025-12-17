package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0008\u0007H'¢\u0006\u0002\u0010\u0008J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\nÀ\u0006\u0001", d2 = {"Landroidx/compose/runtime/saveable/SaveableStateHolder;", "", "SaveableStateProvider", "", "key", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "removeState", "runtime-saveable_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SaveableStateHolder {
    public abstract void SaveableStateProvider(Object object, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer3, int i4);

    public abstract void removeState(Object object);
}

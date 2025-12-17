package androidx.compose.foundation.interaction;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u0008g\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\tÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/interaction/InteractionSource;", "emit", "", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "(Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryEmit", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MutableInteractionSource extends androidx.compose.foundation.interaction.InteractionSource {
    public abstract Object emit(androidx.compose.foundation.interaction.Interaction interaction, Continuation<? super Unit> continuation2);

    @Override // androidx.compose.foundation.interaction.InteractionSource
    public abstract boolean tryEmit(androidx.compose.foundation.interaction.Interaction interaction);
}

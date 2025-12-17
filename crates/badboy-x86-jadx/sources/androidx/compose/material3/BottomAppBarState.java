package androidx.compose.material3;

import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u000e\u0008g\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0007\u0010\u0005\"\u0004\u0008\u0008\u0010\tR\u0018\u0010\n\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u000b\u0010\u0005\"\u0004\u0008\u000c\u0010\tR\u0018\u0010\r\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u000e\u0010\u0005\"\u0004\u0008\u000f\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0011À\u0006\u0001", d2 = {"Landroidx/compose/material3/BottomAppBarState;", "", "collapsedFraction", "", "getCollapsedFraction", "()F", "contentOffset", "getContentOffset", "setContentOffset", "(F)V", "heightOffset", "getHeightOffset", "setHeightOffset", "heightOffsetLimit", "getHeightOffsetLimit", "setHeightOffsetLimit", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface BottomAppBarState {

    public static final androidx.compose.material3.BottomAppBarState.Companion Companion;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u000c\u0012\u0004\u0012\u00020\u0005\u0012\u0002\u0008\u00030\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/material3/BottomAppBarState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/BottomAppBarState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.material3.BottomAppBarState.Companion $$INSTANCE;
        private static final Saver<androidx.compose.material3.BottomAppBarState, ?> Saver;
        static {
            BottomAppBarState.Companion companion = new BottomAppBarState.Companion();
            BottomAppBarState.Companion.$$INSTANCE = companion;
            BottomAppBarState.Companion.Saver = ListSaverKt.listSaver((Function2)BottomAppBarState.Companion.Saver.1.INSTANCE, (Function1)BottomAppBarState.Companion.Saver.2.INSTANCE);
        }

        public final Saver<androidx.compose.material3.BottomAppBarState, ?> getSaver() {
            return BottomAppBarState.Companion.Saver;
        }
    }
    static {
        BottomAppBarState.Companion = BottomAppBarState.Companion.$$INSTANCE;
    }

    public abstract float getCollapsedFraction();

    public abstract float getContentOffset();

    public abstract float getHeightOffset();

    public abstract float getHeightOffsetLimit();

    public abstract void setContentOffset(float f);

    public abstract void setHeightOffset(float f);

    public abstract void setHeightOffsetLimit(float f);
}

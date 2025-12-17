package androidx.compose.material3.internal;

import androidx.compose.foundation.MutatorMutex;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Landroidx/compose/material3/internal/BasicTooltipDefaults;", "", "()V", "GlobalMutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "getGlobalMutatorMutex", "()Landroidx/compose/foundation/MutatorMutex;", "TooltipDuration", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BasicTooltipDefaults {

    public static final int $stable = 0;
    private static final MutatorMutex GlobalMutatorMutex = null;
    public static final androidx.compose.material3.internal.BasicTooltipDefaults INSTANCE = null;
    public static final long TooltipDuration = 1500L;
    static {
        BasicTooltipDefaults basicTooltipDefaults = new BasicTooltipDefaults();
        BasicTooltipDefaults.INSTANCE = basicTooltipDefaults;
        MutatorMutex mutatorMutex = new MutatorMutex();
        BasicTooltipDefaults.GlobalMutatorMutex = mutatorMutex;
    }

    public final MutatorMutex getGlobalMutatorMutex() {
        return BasicTooltipDefaults.GlobalMutatorMutex;
    }
}

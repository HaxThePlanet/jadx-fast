package androidx.compose.ui.layout;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000c", d2 = {"Landroidx/compose/ui/layout/NoOpSubcomposeSlotReusePolicy;", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "()V", "areCompatible", "", "slotId", "", "reusableSlotId", "getSlotsToRetain", "", "slotIds", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class NoOpSubcomposeSlotReusePolicy implements androidx.compose.ui.layout.SubcomposeSlotReusePolicy {

    public static final androidx.compose.ui.layout.NoOpSubcomposeSlotReusePolicy INSTANCE;
    static {
        NoOpSubcomposeSlotReusePolicy noOpSubcomposeSlotReusePolicy = new NoOpSubcomposeSlotReusePolicy();
        NoOpSubcomposeSlotReusePolicy.INSTANCE = noOpSubcomposeSlotReusePolicy;
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public boolean areCompatible(Object slotId, Object reusableSlotId) {
        return 0;
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public void getSlotsToRetain(androidx.compose.ui.layout.SubcomposeSlotReusePolicy.SlotIdsSet slotIds) {
        slotIds.clear();
    }
}

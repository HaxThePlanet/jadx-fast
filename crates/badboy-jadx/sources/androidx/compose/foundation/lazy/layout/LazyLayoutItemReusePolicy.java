package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy.SlotIdsSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00080\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemReusePolicy;", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "factory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;)V", "countPerType", "", "", "", "areCompatible", "", "slotId", "reusableSlotId", "getSlotsToRetain", "", "slotIds", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LazyLayoutItemReusePolicy implements SubcomposeSlotReusePolicy {

    private final Map<Object, Integer> countPerType;
    private final androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory factory;
    public LazyLayoutItemReusePolicy(androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory factory) {
        super();
        this.factory = factory;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.countPerType = (Map)linkedHashMap;
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public boolean areCompatible(Object slotId, Object reusableSlotId) {
        return Intrinsics.areEqual(this.factory.getContentType(slotId), this.factory.getContentType(reusableSlotId));
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public void getSlotsToRetain(SubcomposeSlotReusePolicy.SlotIdsSet slotIds) {
        Object next;
        Object contentType;
        int intValue;
        Map countPerType;
        Integer valueOf;
        this.countPerType.clear();
        Iterator iterator = slotIds.iterator();
        final int i = 0;
        while (iterator.hasNext()) {
            contentType = this.factory.getContentType(iterator.next());
            Object obj = this.countPerType.get(contentType);
            if ((Integer)obj != null) {
            } else {
            }
            intValue = 0;
            if (intValue == 7) {
            } else {
            }
            this.countPerType.put(contentType, Integer.valueOf(intValue + 1));
            iterator.remove();
            intValue = (Integer)obj.intValue();
        }
    }
}

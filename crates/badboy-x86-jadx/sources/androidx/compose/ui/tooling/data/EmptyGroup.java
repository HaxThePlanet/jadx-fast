package androidx.compose.ui.tooling.data;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Landroidx/compose/ui/tooling/data/EmptyGroup;", "Landroidx/compose/ui/tooling/data/Group;", "()V", "ui-tooling-data_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class EmptyGroup extends androidx.compose.ui.tooling.data.Group {

    public static final androidx.compose.ui.tooling.data.EmptyGroup INSTANCE;
    static {
        EmptyGroup emptyGroup = new EmptyGroup();
        EmptyGroup.INSTANCE = emptyGroup;
    }

    private EmptyGroup() {
        super(0, 0, 0, 0, SlotTreeKt.getEmptyBox(), (Collection)CollectionsKt.emptyList(), (Collection)CollectionsKt.emptyList(), 0, 0);
    }
}

package androidx.compose.foundation.contextmenu;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001:\u0001\u0013B\u0011\u0008\u0000\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016R+\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\u0004¨\u0006\u0014", d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuState;", "", "initialStatus", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", "(Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;)V", "<set-?>", "status", "getStatus", "()Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", "setStatus", "status$delegate", "Landroidx/compose/runtime/MutableState;", "equals", "", "other", "hashCode", "", "toString", "", "Status", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContextMenuState {

    public static final int $stable;
    private final MutableState status$delegate;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuState$Status;", "", "()V", "Closed", "Open", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status$Closed;", "Landroidx/compose/foundation/contextmenu/ContextMenuState$Status$Open;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class Status {

        public static final int $stable;
        static {
        }

        public Status(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
    }

    public ContextMenuState() {
        final int i = 0;
        super(i, 1, i);
    }

    public ContextMenuState(androidx.compose.foundation.contextmenu.ContextMenuState.Status initialStatus) {
        super();
        int i = 0;
        this.status$delegate = SnapshotStateKt.mutableStateOf$default(initialStatus, i, 2, i);
    }

    public ContextMenuState(androidx.compose.foundation.contextmenu.ContextMenuState.Status contextMenuState$Status, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        androidx.compose.foundation.contextmenu.ContextMenuState.Status.Closed obj1;
        if (i2 &= 1 != 0) {
            obj1 = ContextMenuState.Status.Closed.INSTANCE;
        }
        super(obj1);
    }

    public boolean equals(Object other) {
        if (other == this) {
            return 1;
        }
        if (!other instanceof ContextMenuState) {
            return 0;
        }
        return Intrinsics.areEqual((ContextMenuState)other.getStatus(), getStatus());
    }

    public final androidx.compose.foundation.contextmenu.ContextMenuState.Status getStatus() {
        final int i = 0;
        final int i2 = 0;
        return (ContextMenuState.Status)(State)this.status$delegate.getValue();
    }

    public int hashCode() {
        return getStatus().hashCode();
    }

    public final void setStatus(androidx.compose.foundation.contextmenu.ContextMenuState.Status <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.status$delegate.setValue(<set-?>);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ContextMenuState(status=").append(getStatus()).append(')').toString();
    }
}

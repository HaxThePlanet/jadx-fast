package androidx.compose.runtime;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\u0004R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0014", d2 = {"Landroidx/compose/runtime/Anchor;", "", "loc", "", "(I)V", "location", "getLocation$runtime_release", "()I", "setLocation$runtime_release", "valid", "", "getValid", "()Z", "toIndexFor", "slots", "Landroidx/compose/runtime/SlotTable;", "writer", "Landroidx/compose/runtime/SlotWriter;", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Anchor {

    public static final int $stable = 8;
    private int location;
    static {
        final int i = 8;
    }

    public Anchor(int loc) {
        super();
        this.location = loc;
    }

    public final int getLocation$runtime_release() {
        return this.location;
    }

    public final boolean getValid() {
        int i;
        i = this.location != Integer.MIN_VALUE ? 1 : 0;
        return i;
    }

    public final void setLocation$runtime_release(int <set-?>) {
        this.location = <set-?>;
    }

    public final int toIndexFor(androidx.compose.runtime.SlotTable slots) {
        return slots.anchorIndex(this);
    }

    public final int toIndexFor(androidx.compose.runtime.SlotWriter writer) {
        return writer.anchorIndex(this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(super.toString()).append("{ location = ").append(this.location).append(" }").toString();
    }
}

package androidx.compose.runtime;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u000f\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J\u0015\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\u000c2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u000c2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J \u0010\u0015\u001a\u00020\u000c2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0018\u0010\u0019\u001a\u00020\u000c2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0008\u0010\u001a\u001a\u00020\u000cH\u0016R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Landroidx/compose/runtime/OffsetApplier;", "N", "Landroidx/compose/runtime/Applier;", "applier", "offset", "", "(Landroidx/compose/runtime/Applier;I)V", "current", "getCurrent", "()Ljava/lang/Object;", "nesting", "clear", "", "down", "node", "(Ljava/lang/Object;)V", "insertBottomUp", "index", "instance", "(ILjava/lang/Object;)V", "insertTopDown", "move", "from", "to", "count", "remove", "up", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OffsetApplier<N>  implements androidx.compose.runtime.Applier<N> {

    public static final int $stable = 8;
    private final androidx.compose.runtime.Applier<N> applier;
    private int nesting;
    private final int offset;
    static {
        final int i = 8;
    }

    public OffsetApplier(androidx.compose.runtime.Applier<N> applier, int offset) {
        super();
        this.applier = applier;
        this.offset = offset;
    }

    @Override // androidx.compose.runtime.Applier
    public void clear() {
        final int i = 0;
        final int i2 = 0;
        int i3 = 0;
        ComposerKt.composeImmediateRuntimeError("Clear is not valid on OffsetApplier");
    }

    public void down(N node) {
        this.nesting = nesting++;
        this.applier.down(node);
    }

    public N getCurrent() {
        return this.applier.getCurrent();
    }

    public void insertBottomUp(int index, N instance) {
        int offset;
        offset = this.nesting == 0 ? this.offset : 0;
        this.applier.insertBottomUp(offset += index, instance);
    }

    public void insertTopDown(int index, N instance) {
        int offset;
        offset = this.nesting == 0 ? this.offset : 0;
        this.applier.insertTopDown(offset += index, instance);
    }

    @Override // androidx.compose.runtime.Applier
    public void move(int from, int to, int count) {
        int offset;
        offset = this.nesting == 0 ? this.offset : 0;
        this.applier.move(from + offset, to + offset, count);
    }

    @Override // androidx.compose.runtime.Applier
    public void remove(int index, int count) {
        int offset;
        offset = this.nesting == 0 ? this.offset : 0;
        this.applier.remove(offset += index, count);
    }

    @Override // androidx.compose.runtime.Applier
    public void up() {
        int i;
        String str;
        i = this.nesting > 0 ? 1 : 0;
        final int i3 = 0;
        if (i == 0) {
            int i4 = 0;
            ComposerKt.composeImmediateRuntimeError("OffsetApplier up called with no corresponding down");
        }
        this.nesting = value$iv--;
        this.applier.up();
    }
}

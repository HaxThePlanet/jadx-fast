package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008'\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0012\u001a\u00020\u000fH$J\u0008\u0010\u0013\u001a\u00020\u000fH\u0016J*\u0010\u0014\u001a\u00020\u000f*\u0008\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0004J\"\u0010\u0019\u001a\u00020\u000f*\u0008\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0004R&\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000@TX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\u0004R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u000b\u0010\u0008R\u0014\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b", d2 = {"Landroidx/compose/runtime/AbstractApplier;", "T", "Landroidx/compose/runtime/Applier;", "root", "(Ljava/lang/Object;)V", "<set-?>", "current", "getCurrent", "()Ljava/lang/Object;", "setCurrent", "Ljava/lang/Object;", "getRoot", "stack", "", "clear", "", "down", "node", "onClear", "up", "move", "from", "", "to", "count", "remove", "index", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AbstractApplier<T>  implements androidx.compose.runtime.Applier<T> {

    public static final int $stable = 8;
    private T current;
    private final T root;
    private final List<T> stack;
    static {
        final int i = 8;
    }

    public AbstractApplier(T root) {
        super();
        this.root = root;
        ArrayList arrayList = new ArrayList();
        this.stack = (List)arrayList;
        this.current = this.root;
    }

    @Override // androidx.compose.runtime.Applier
    public final void clear() {
        this.stack.clear();
        setCurrent(this.root);
        onClear();
    }

    public void down(T node) {
        this.stack.add(getCurrent());
        setCurrent(node);
    }

    public T getCurrent() {
        return this.current;
    }

    public final T getRoot() {
        return this.root;
    }

    protected final void move(List<T> $this$move, int from, int to, int count) {
        int i;
        Object subList;
        int i2;
        Object mutableList;
        List list;
        i = from > to ? to : to - count;
        if (count == 1) {
            if (from != to + 1) {
                if (from == to + -1) {
                    $this$move.set(from, $this$move.set(to, $this$move.get(from)));
                } else {
                    $this$move.add(i, $this$move.remove(from));
                }
            } else {
            }
        } else {
            subList = $this$move.subList(from, from + count);
            subList.clear();
            $this$move.addAll(i, (Collection)CollectionsKt.toMutableList((Collection)subList));
        }
    }

    @Override // androidx.compose.runtime.Applier
    protected abstract void onClear();

    protected final void remove(List<T> $this$remove, int index, int count) {
        int subList;
        if (count == 1) {
            $this$remove.remove(index);
        } else {
            $this$remove.subList(index, index + count).clear();
        }
    }

    protected void setCurrent(T <set-?>) {
        this.current = <set-?>;
    }

    @Override // androidx.compose.runtime.Applier
    public void up() {
        String str;
        int i2 = 0;
        if (empty ^= 1 == 0) {
            int i4 = 0;
            PreconditionsKt.throwIllegalStateException("empty stack");
        }
        setCurrent(this.stack.remove(size--));
    }
}

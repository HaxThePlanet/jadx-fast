package kotlin.y;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.d.j0.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008&\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0006\u001a\u00020\u0002H&¨\u0006\u0007", d2 = {"Lkotlin/collections/IntIterator;", "", "", "()V", "next", "()Ljava/lang/Integer;", "nextInt", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public abstract class h0 implements Iterator<Integer>, a {
    @Override // java.util.Iterator
    public final Integer c() {
        return Integer.valueOf(d());
    }

    @Override // java.util.Iterator
    public abstract int d();

    @Override // java.util.Iterator
    public Object next() {
        return c();
    }

    @Override // java.util.Iterator
    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

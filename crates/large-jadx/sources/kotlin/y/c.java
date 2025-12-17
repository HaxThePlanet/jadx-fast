package kotlin.y;

import java.util.AbstractCollection;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.d0.d.j0.b;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008'\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0008¨\u0006\t", d2 = {"Lkotlin/collections/AbstractMutableCollection;", "E", "", "Ljava/util/AbstractCollection;", "()V", "add", "", "element", "(Ljava/lang/Object;)Z", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public abstract class c<E>  extends AbstractCollection<E> implements Collection<E>, b {
    @Override // java.util.AbstractCollection
    public abstract int d();

    @Override // java.util.AbstractCollection
    public final int size() {
        return d();
    }
}

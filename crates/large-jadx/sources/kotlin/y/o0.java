package kotlin.y;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\n\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\u0008\u0010\u000f\u001a\u00020\u000bH\u0016J\u0016\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u000c\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u000c\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u000c\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u0015", d2 = {"Lkotlin/collections/ReversedList;", "T", "Lkotlin/collections/AbstractMutableList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "add", "", "index", "element", "(ILjava/lang/Object;)V", "clear", "get", "(I)Ljava/lang/Object;", "removeAt", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
final class o0<T>  extends kotlin.y.d<T> {

    private final List<T> a;
    public o0(List<T> list) {
        n.f(list, "delegate");
        super();
        this.a = list;
    }

    public void add(int i, T t2) {
        this.a.add(x.D(this, i), t2);
    }

    @Override // kotlin.y.d
    public void clear() {
        this.a.clear();
    }

    @Override // kotlin.y.d
    public int d() {
        return this.a.size();
    }

    public T g(int i) {
        return this.a.remove(x.C(this, i));
    }

    public T get(int i) {
        return this.a.get(x.C(this, i));
    }

    public T set(int i, T t2) {
        return this.a.set(x.C(this, i), t2);
    }
}

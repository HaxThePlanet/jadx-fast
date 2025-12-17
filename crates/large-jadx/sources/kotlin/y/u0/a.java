package kotlin.y.u0;

import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.f;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010&\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008 \u0018\u0000*\u0014\u0008\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0002*\u0004\u0008\u0001\u0010\u0003*\u0004\u0008\u0002\u0010\u00042\u0008\u0012\u0004\u0012\u0002H\u00010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\u00082\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0002H&¨\u0006\u000c", d2 = {"Lkotlin/collections/builders/AbstractMapBuilderEntrySet;", "E", "", "K", "V", "Lkotlin/collections/AbstractMutableSet;", "()V", "contains", "", "element", "(Ljava/util/Map$Entry;)Z", "containsEntry", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public abstract class a<E extends Map.Entry<? extends K, ? extends V>, K, V>  extends f<E> {
    @Override // kotlin.y.f
    public final boolean contains(Object object) {
        if (object instanceof Map.Entry) {
            return g((Map.Entry)object);
        }
        return 0;
    }

    public final boolean g(E e) {
        n.f(e, "element");
        return h(e);
    }

    public abstract boolean h(Map.Entry<? extends K, ? extends V> map$Entry);

    @Override // kotlin.y.f
    public abstract boolean i(Map.Entry map$Entry);

    @Override // kotlin.y.f
    public final boolean remove(Object object) {
        if (object instanceof Map.Entry) {
            return i((Map.Entry)object);
        }
        return 0;
    }
}

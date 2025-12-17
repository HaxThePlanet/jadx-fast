package kotlin.y;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0010\"\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a,\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0008H\u0086\u0002\u001a-\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\u0008¢\u0006\u0002\u0010\u0004\u001a,\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0008H\u0086\u0002\u001a-\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\u0008¢\u0006\u0002\u0010\u0004¨\u0006\r", d2 = {"minus", "", "T", "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "elements", "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/SetsKt")
class t0 extends kotlin.y.s0 {
    public static <T> Set<T> h(Set<? extends T> set, Iterable<? extends T> iterable2) {
        Object next;
        boolean contains;
        n.f(set, "$this$minus");
        n.f(iterable2, "elements");
        final Collection obj4 = s.t(iterable2, set);
        if (obj4.isEmpty()) {
            return p.P0(set);
        }
        if (obj4 instanceof Set != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator obj3 = set.iterator();
            while (obj3.hasNext()) {
                next = obj3.next();
                if (!obj4.contains(next)) {
                }
                linkedHashSet.add(next);
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(obj4);
        return linkedHashSet2;
    }

    public static <T> Set<T> i(Set<? extends T> set, Iterable<? extends T> iterable2) {
        int intValue;
        int i;
        n.f(set, "$this$plus");
        n.f(iterable2, "elements");
        Integer num = s.s(iterable2);
        if (num != null) {
            size += intValue;
        } else {
            i = intValue * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(j0.d(i));
        linkedHashSet.addAll(set);
        p.y(linkedHashSet, iterable2);
        return linkedHashSet;
    }

    public static <T> Set<T> j(Set<? extends T> set, T t2) {
        n.f(set, "$this$plus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(j0.d(size++));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t2);
        return linkedHashSet;
    }
}

package kotlin.y;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000R\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u001f\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0006\u0012\u0002\u0008\u00030\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0005\u001aA\u0010\u0006\u001a\u0002H\u0007\"\u0010\u0008\u0000\u0010\u0007*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u0008\"\u0004\u0008\u0001\u0010\u0002*\u0006\u0012\u0002\u0008\u00030\u00032\u0006\u0010\t\u001a\u0002H\u00072\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\u000c\"\u0004\u0008\u0000\u0010\r*\u0008\u0012\u0004\u0012\u0002H\r0\u000e\u001a5\u0010\u000f\u001a\u00020\u0010\"\u0004\u0008\u0000\u0010\r*\u0008\u0012\u0004\u0012\u0002H\r0\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00100\u0012H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0008\u0013\u001a5\u0010\u000f\u001a\u00020\u0014\"\u0004\u0008\u0000\u0010\r*\u0008\u0012\u0004\u0012\u0002H\r0\u00032\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00140\u0012H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0008\u0015\u001a&\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\r0\u0017\"\u000e\u0008\u0000\u0010\r*\u0008\u0012\u0004\u0012\u0002H\r0\u0018*\u0008\u0012\u0004\u0012\u0002H\r0\u0003\u001a8\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\r0\u0017\"\u0004\u0008\u0000\u0010\r*\u0008\u0012\u0004\u0012\u0002H\r0\u00032\u001a\u0010\u0019\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\r0\u001aj\n\u0012\u0006\u0008\u0000\u0012\u0002H\r`\u001b\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u001c", d2 = {"filterIsInstance", "", "R", "", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Ljava/lang/Iterable;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "reverse", "", "T", "", "sumOf", "Ljava/math/BigDecimal;", "selector", "Lkotlin/Function1;", "sumOfBigDecimal", "Ljava/math/BigInteger;", "sumOfBigInteger", "toSortedSet", "Ljava/util/SortedSet;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/CollectionsKt")
class y extends kotlin.y.x {
    public static <R> List<R> I(Iterable<?> iterable, Class<R> class2) {
        n.f(iterable, "$this$filterIsInstance");
        n.f(class2, "klass");
        ArrayList arrayList = new ArrayList();
        y.J(iterable, arrayList, class2);
        return (List)arrayList;
    }

    public static final <C extends Collection<? super R>, R> C J(Iterable<?> iterable, C c2, Class<R> class3) {
        String next;
        boolean instance;
        n.f(iterable, "$this$filterIsInstanceTo");
        n.f(c2, "destination");
        n.f(class3, "klass");
        final Iterator obj2 = iterable.iterator();
        while (obj2.hasNext()) {
            next = obj2.next();
            if (class3.isInstance(next)) {
            }
            c2.add(next);
        }
        return c2;
    }

    public static final <T> void K(List<T> list) {
        n.f(list, "$this$reverse");
        Collections.reverse(list);
    }
}

package kotlin.y;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0010\u001c\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a.\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0014\u0008\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\u0008ø\u0001\u0000\u001a \u0010\u0006\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0008\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\t\u001a\u0004\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0001H\u0001¢\u0006\u0002\u0010\n\u001a\u001e\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u000c\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u001a,\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u000c\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\u001a\"\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0010\"\u0004\u0008\u0000\u0010\u0002*\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a\u001d\u0010\u0011\u001a\u00020\u0012\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000cH\u0002¢\u0006\u0002\u0008\u0013\u001a@\u0010\u0014\u001a\u001a\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00160\u00100\u0015\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0016*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00160\u00150\u0001\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0017", d2 = {"Iterable", "", "T", "iterator", "Lkotlin/Function0;", "", "collectionSizeOrDefault", "", "default", "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "convertToSetForSetOperation", "", "convertToSetForSetOperationWith", "source", "flatten", "", "safeToConvertToSet", "", "safeToConvertToSet$CollectionsKt__IterablesKt", "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/CollectionsKt")
class s extends kotlin.y.r {
    public static <T> int r(Iterable<? extends T> iterable, int i2) {
        int obj2;
        n.f(iterable, "$this$collectionSizeOrDefault");
        if (iterable instanceof Collection != null) {
            obj2 = (Collection)iterable.size();
        }
        return obj2;
    }

    public static final <T> Integer s(Iterable<? extends T> iterable) {
        Integer obj1;
        n.f(iterable, "$this$collectionSizeOrNull");
        if (iterable instanceof Collection != null) {
            obj1 = Integer.valueOf((Collection)iterable.size());
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    public static final <T> Collection<T> t(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        boolean z;
        Object obj1;
        Object obj2;
        n.f(iterable, "$this$convertToSetForSetOperationWith");
        n.f(iterable2, "source");
        if (iterable instanceof Set != null) {
        } else {
            if (iterable instanceof Collection != null) {
                if (iterable2 instanceof Collection != null && (Collection)iterable2.size() < 2) {
                    if ((Collection)iterable2.size() < 2) {
                    } else {
                        obj2 = iterable;
                        if (s.v((Collection)obj2)) {
                            obj1 = p.J0((Collection)(Collection)iterable);
                        } else {
                            obj1 = obj2;
                        }
                    }
                } else {
                }
            } else {
                obj1 = p.J0(iterable);
            }
        }
        return obj1;
    }

    public static <T> List<T> u(Iterable<? extends Iterable<? extends T>> iterable) {
        Object next;
        n.f(iterable, "$this$flatten");
        ArrayList arrayList = new ArrayList();
        final Iterator obj2 = iterable.iterator();
        for (Iterable next : obj2) {
            p.y(arrayList, next);
        }
        return arrayList;
    }

    private static final <T> boolean v(Collection<? extends T> collection) {
        Object obj2;
        if (collection.size() > 2 && collection instanceof ArrayList != null) {
            obj2 = collection instanceof ArrayList != null ? 1 : 0;
        } else {
        }
        return obj2;
    }
}

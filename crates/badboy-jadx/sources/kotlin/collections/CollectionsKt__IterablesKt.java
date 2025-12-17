package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0010\u001c\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a.\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0014\u0008\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\u0008ø\u0001\u0000\u001a \u0010\u0006\u001a\u00020\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0008\u001a\u00020\u0007H\u0001\u001a\u001f\u0010\t\u001a\u0004\u0018\u00010\u0007\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0001H\u0001¢\u0006\u0002\u0010\n\u001a\"\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u000c\"\u0004\u0008\u0000\u0010\u0002*\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a@\u0010\r\u001a\u001a\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u000c\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u000f0\u000c0\u000e\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u000f*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000f0\u000e0\u0001\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0010", d2 = {"Iterable", "", "T", "iterator", "Lkotlin/Function0;", "", "collectionSizeOrDefault", "", "default", "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "flatten", "", "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__IterablesKt extends kotlin.collections.CollectionsKt__CollectionsKt {
    private static final <T> Iterable<T> Iterable(Function0<? extends Iterator<? extends T>> iterator) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        CollectionsKt__IterablesKt.Iterable.1 anon = new CollectionsKt__IterablesKt.Iterable.1(iterator);
        return (Iterable)anon;
    }

    public static final <T> int collectionSizeOrDefault(Iterable<? extends T> $this$collectionSizeOrDefault, int default) {
        int size;
        Intrinsics.checkNotNullParameter($this$collectionSizeOrDefault, "<this>");
        if ($this$collectionSizeOrDefault instanceof Collection != null) {
            size = (Collection)$this$collectionSizeOrDefault.size();
        } else {
            size = default;
        }
        return size;
    }

    public static final <T> Integer collectionSizeOrNull(Iterable<? extends T> $this$collectionSizeOrNull) {
        Integer valueOf;
        Intrinsics.checkNotNullParameter($this$collectionSizeOrNull, "<this>");
        if ($this$collectionSizeOrNull instanceof Collection != null) {
            valueOf = Integer.valueOf((Collection)$this$collectionSizeOrNull.size());
        } else {
            valueOf = 0;
        }
        return valueOf;
    }

    public static final <T> List<T> flatten(Iterable<? extends Iterable<? extends T>> $this$flatten) {
        Object next;
        ArrayList list;
        Intrinsics.checkNotNullParameter($this$flatten, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator iterator = $this$flatten.iterator();
        for (Iterable next : iterator) {
            CollectionsKt.addAll((Collection)arrayList, next);
        }
        return (List)arrayList;
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Iterable<? extends Pair<? extends T, ? extends R>> $this$unzip) {
        Object next;
        Object second;
        Intrinsics.checkNotNullParameter($this$unzip, "<this>");
        int collectionSizeOrDefault = CollectionsKt.collectionSizeOrDefault($this$unzip, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator iterator = $this$unzip.iterator();
        for (Pair next : iterator) {
            arrayList.add(next.getFirst());
            arrayList2.add(next.getSecond());
        }
        return TuplesKt.to(arrayList, arrayList2);
    }
}

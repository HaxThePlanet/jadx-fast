package androidx.compose.ui.tooling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.sequences.SequencesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u001c\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001H\u0000¨\u0006\u0004", d2 = {"stitchTrees", "", "Landroidx/compose/ui/tooling/ViewInfo;", "allViewInfoRoots", "ui-tooling_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ShadowViewInfo_androidKt {
    public static final List<androidx.compose.ui.tooling.ViewInfo> stitchTrees(List<androidx.compose.ui.tooling.ViewInfo> allViewInfoRoots) {
        Object next;
        Iterator iterator;
        Object next4;
        boolean next6;
        boolean next2;
        boolean next3;
        boolean next5;
        int $this$getOrPut$iv$iv$iv;
        androidx.compose.ui.tooling.ShadowViewInfo it;
        androidx.compose.ui.layout.LayoutInfo layoutInfo;
        Object obj;
        int i;
        Object arrayList;
        if (allViewInfoRoots.size() < 2) {
            return allViewInfoRoots;
        }
        Iterable iterable = allViewInfoRoots;
        int i6 = 0;
        int i8 = 10;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, i8));
        int i9 = 0;
        Iterator iterator2 = iterable.iterator();
        for (Object next : iterator2) {
            $this$getOrPut$iv$iv$iv = 0;
            it = new ShadowViewInfo((ViewInfo)next);
            (Collection)arrayList3.add(it);
        }
        int i7 = 0;
        ArrayList arrayList4 = new ArrayList();
        int i12 = 0;
        Iterator iterator4 = (Iterable)(List)arrayList3.iterator();
        for (Object next4 : iterator4) {
            it = 0;
            CollectionsKt.addAll((Collection)arrayList4, (ShadowViewInfo)next4.getAllNodes());
        }
        int i2 = 0;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)(List)arrayList4, i8));
        int i13 = 0;
        Iterator iterator5 = arrayList4.iterator();
        for (Object next6 : iterator5) {
            boolean z2 = next6;
            it = 0;
            (Collection)arrayList2.add(TuplesKt.to((ShadowViewInfo)z2.getLayoutInfo(), z2));
        }
        int i3 = 0;
        ArrayList arrayList5 = new ArrayList();
        int i14 = 0;
        Iterator iterator6 = (Iterable)(List)arrayList2.iterator();
        while (iterator6.hasNext()) {
            next2 = iterator6.next();
            it = 0;
            if ((Pair)next2.getFirst() != null) {
            } else {
            }
            layoutInfo = 0;
            if (layoutInfo != 0) {
            }
            (Collection)arrayList5.add(next2);
            layoutInfo = 1;
        }
        int i4 = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i15 = 0;
        iterator = (Iterable)(List)arrayList5.iterator();
        while (iterator.hasNext()) {
            next3 = iterator.next();
            int i17 = 0;
            layoutInfo = (Pair)next3.getFirst();
            LinkedHashMap map = linkedHashMap;
            it = 0;
            obj = map.get((LayoutInfo)layoutInfo);
            if (obj == null) {
            } else {
            }
            arrayList = obj;
            (List)arrayList.add(next3);
            i = 0;
            arrayList = new ArrayList();
            map.put(layoutInfo, (List)arrayList);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet((Collection)arrayList3);
        int i10 = 0;
        Iterator iterator3 = (Iterable)arrayList3.iterator();
        while (iterator3.hasNext()) {
            next5 = iterator;
            $this$getOrPut$iv$iv$iv = 0;
            ShadowViewInfo_androidKt.stitchTrees.1.1 anon = new ShadowViewInfo_androidKt.stitchTrees.1.1((Map)linkedHashMap);
            ShadowViewInfo_androidKt.stitchTrees.1.2 anon2 = new ShadowViewInfo_androidKt.stitchTrees.1.2(next5);
            it = SequencesKt.firstOrNull(SequencesKt.map(SequencesKt.filter(SequencesKt.flatMapIterable((ShadowViewInfo)next5.getAllNodes(), (Function1)anon), (Function1)anon2), (Function1)ShadowViewInfo_androidKt.stitchTrees.1.3.INSTANCE));
            if ((ShadowViewInfo)it != null) {
            }
            layoutInfo = 0;
            next5.setNewParent((ShadowViewInfo)it);
            linkedHashSet.remove(next5);
        }
        LinkedHashSet $this$forEach$iv = linkedHashSet;
        int i11 = 0;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$forEach$iv, i8));
        ArrayList list2 = arrayList6;
        int i16 = 0;
        Iterator iterator7 = $this$forEach$iv.iterator();
        for (Object $this$getOrPut$iv$iv$iv : iterator7) {
            layoutInfo = 0;
            (Collection)list2.add((ShadowViewInfo)$this$getOrPut$iv$iv$iv.toViewInfo());
        }
        return (List)list2;
    }
}

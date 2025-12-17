package androidx.compose.ui.text.android;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u001f\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001\u001a]\u0010\u0006\u001a\u0002H\u0007\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0008\"\u0010\u0008\u0002\u0010\u0007*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00080\t*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\n\u001a\u0002H\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00080\u0005H\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u000c\u001aJ\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0003\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00080\u000eH\u0080\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¨\u0006\u000f", d2 = {"fastForEach", "", "T", "", "action", "Lkotlin/Function1;", "fastMapTo", "C", "R", "", "destination", "transform", "(Ljava/util/List;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "fastZipWithNext", "Lkotlin/Function2;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ListUtils_androidKt {
    public static final <T> void fastForEach(List<? extends T> $this$fastForEach, Function1<? super T, Unit> action) {
        int index;
        Object obj;
        final int i = 0;
        index = 0;
        while (index < $this$fastForEach.size()) {
            action.invoke($this$fastForEach.get(index));
            index++;
        }
    }

    public static final <T, R, C extends Collection<? super R>> C fastMapTo(List<? extends T> $this$fastMapTo, C destination, Function1<? super T, ? extends R> transform) {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        Object invoke;
        final int i2 = 0;
        final Object obj3 = $this$fastMapTo;
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i = 0;
            destination.add(transform.invoke(obj3.get(index$iv)));
            index$iv++;
        }
        return destination;
    }

    public static final <T, R> List<R> fastZipWithNext(List<? extends T> $this$fastZipWithNext, Function2<? super T, ? super T, ? extends R> transform) {
        int size;
        int i;
        Object current;
        int i2;
        Object obj;
        Object invoke;
        final int i3 = 0;
        if ($this$fastZipWithNext.size() != 0) {
            if ($this$fastZipWithNext.size() == 1) {
            } else {
                ArrayList arrayList = new ArrayList();
                current = $this$fastZipWithNext.get(0);
                i2 = 0;
                while (i2 < CollectionsKt.getLastIndex($this$fastZipWithNext)) {
                    obj = $this$fastZipWithNext.get(i2 + 1);
                    (List)arrayList.add(transform.invoke(current, obj));
                    current = obj;
                    i2++;
                }
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }
}

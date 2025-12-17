package androidx.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002:\u0003678B\u000f\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000b\u001a\u00020\u000f2\u0008\u0008\u0001\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\u0012\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0014J\u0019\u0010\u0012\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0012\u001a\u00020\u000c2\u0008\u0008\u0001\u0010\u0010\u001a\u00020\u00042\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002J#\u0010\u0012\u001a\u00020\u000c2\u0008\u0008\u0001\u0010\u0010\u001a\u00020\u00042\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0012\u001a\u00020\u000c2\u0008\u0008\u0001\u0010\u0010\u001a\u00020\u00042\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0018J\u0014\u0010\u0012\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u0010\u0012\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001aJ\u0014\u0010\u0012\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001bJ\u000e\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001eJ\u0006\u0010\u001f\u001a\u00020\u000fJ\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010!\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\"J\u0017\u0010!\u001a\u00020\u000f2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010!\u001a\u00020\u000f2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0014H\u0086\u0002J\u001c\u0010!\u001a\u00020\u000f2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010#J\u0017\u0010!\u001a\u00020\u000f2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u0017\u0010!\u001a\u00020\u000f2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001aH\u0086\u0002J\u0017\u0010!\u001a\u00020\u000f2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001bH\u0086\u0002J\u0016\u0010$\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\"J\u0017\u0010$\u001a\u00020\u000f2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010$\u001a\u00020\u000f2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0014H\u0086\u0002J\u001c\u0010$\u001a\u00020\u000f2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0015H\u0086\u0002¢\u0006\u0002\u0010#J\u0017\u0010$\u001a\u00020\u000f2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002J\u0017\u0010$\u001a\u00020\u000f2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001aH\u0086\u0002J\u0017\u0010$\u001a\u00020\u000f2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001bH\u0086\u0002J\u0013\u0010%\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ\u0014\u0010&\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010&\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0014J\u0019\u0010&\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u0014\u0010&\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u0010&\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001aJ\u0014\u0010&\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001bJ\u0015\u0010'\u001a\u00028\u00002\u0008\u0008\u0001\u0010\u0010\u001a\u00020\u0004¢\u0006\u0002\u0010(J/\u0010)\u001a\u00020\u000f2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008,\u0012\u0008\u0008-\u0012\u0004\u0008\u0008(\r\u0012\u0004\u0012\u00020\u000c0+H\u0086\u0008ø\u0001\u0000J\u001a\u0010.\u001a\u00020\u000f2\u0008\u0008\u0001\u0010/\u001a\u00020\u00042\u0008\u0008\u0001\u00100\u001a\u00020\u0004J\u0014\u00101\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002J\u0019\u00101\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u0014\u00101\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0018J\u0014\u00101\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u00101\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001bJ \u00102\u001a\u00028\u00002\u0008\u0008\u0001\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020\u000f2\u0008\u0008\u0002\u00105\u001a\u00020\u0004R\u0012\u0010\u0006\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u00069", d2 = {"Landroidx/collection/MutableObjectList;", "E", "Landroidx/collection/ObjectList;", "initialCapacity", "", "(I)V", "capacity", "getCapacity", "()I", "list", "Landroidx/collection/MutableObjectList$ObjectListMutableList;", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "Landroidx/collection/ScatterSet;", "", "([Ljava/lang/Object;)Z", "(I[Ljava/lang/Object;)Z", "", "", "", "Lkotlin/sequences/Sequence;", "asList", "asMutableList", "", "clear", "ensureCapacity", "minusAssign", "(Ljava/lang/Object;)V", "([Ljava/lang/Object;)V", "plusAssign", "remove", "removeAll", "removeAt", "(I)Ljava/lang/Object;", "removeIf", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "removeRange", "start", "end", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "trim", "minCapacity", "MutableObjectListIterator", "ObjectListMutableList", "SubList", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MutableObjectList<E>  extends androidx.collection.ObjectList<E> {

    private androidx.collection.MutableObjectList.ObjectListMutableList<E> list;

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\t\u0008\u0002\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000cJ\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\u0008\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0011J\u0008\u0010\u0012\u001a\u00020\u0006H\u0016J\r\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\u0008\u0010\u0014\u001a\u00020\u0006H\u0016J\u0008\u0010\u0015\u001a\u00020\nH\u0016J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000cR\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Landroidx/collection/MutableObjectList$MutableObjectListIterator;", "T", "", "list", "", "index", "", "(Ljava/util/List;I)V", "prevIndex", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class MutableObjectListIterator implements ListIterator<T>, KMutableListIterator {

        private final List<T> list;
        private int prevIndex;
        public MutableObjectListIterator(List<T> list, int index) {
            Intrinsics.checkNotNullParameter(list, "list");
            super();
            this.list = list;
            this.prevIndex = index + -1;
        }

        public void add(T element) {
            this.prevIndex = prevIndex++;
            this.list.add(this.prevIndex, element);
        }

        @Override // java.util.ListIterator
        public boolean hasNext() {
            int i;
            if (this.prevIndex < size -= i) {
            } else {
                i = 0;
            }
            return i;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            int i;
            i = this.prevIndex >= 0 ? 1 : 0;
            return i;
        }

        public T next() {
            this.prevIndex = prevIndex++;
            return this.list.get(this.prevIndex);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return prevIndex++;
        }

        public T previous() {
            final int prevIndex = this.prevIndex;
            this.prevIndex = prevIndex + -1;
            return this.list.get(prevIndex);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.prevIndex;
        }

        @Override // java.util.ListIterator
        public void remove() {
            this.list.remove(this.prevIndex);
            this.prevIndex = prevIndex--;
        }

        public void set(T element) {
            this.list.set(this.prevIndex, element);
        }
    }

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0002\u0008\t\n\u0002\u0010)\n\u0002\u0008\u0002\n\u0002\u0010+\n\u0002\u0008\n\u0008\u0002\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u001d\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00072\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0011\u001a\u00020\u000b2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0008\u0010\u0014\u001a\u00020\u000eH\u0016J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\rJ\u0016\u0010\u0016\u001a\u00020\u000b2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0017\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u0008\u0010\u001b\u001a\u00020\u000bH\u0016J\u000f\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u001dH\u0096\u0002J\u0015\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0016\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0015\u0010!\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u0016\u0010\"\u001a\u00020\u000b2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0015\u0010#\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0018J\u0016\u0010$\u001a\u00020\u000b2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u001e\u0010%\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010&J\u001e\u0010'\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006*", d2 = {"Landroidx/collection/MutableObjectList$ObjectListMutableList;", "T", "", "objectList", "Landroidx/collection/MutableObjectList;", "(Landroidx/collection/MutableObjectList;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ObjectListMutableList implements List<T>, KMutableList {

        private final androidx.collection.MutableObjectList<T> objectList;
        public ObjectListMutableList(androidx.collection.MutableObjectList<T> objectList) {
            Intrinsics.checkNotNullParameter(objectList, "objectList");
            super();
            this.objectList = objectList;
        }

        public void add(int index, T element) {
            this.objectList.add(index, element);
        }

        public boolean add(T element) {
            return this.objectList.add(element);
        }

        public boolean addAll(int index, Collection<? extends T> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return this.objectList.addAll(index, elements);
        }

        public boolean addAll(Collection<? extends T> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return this.objectList.addAll((Iterable)elements);
        }

        @Override // java.util.List
        public void clear() {
            this.objectList.clear();
        }

        @Override // java.util.List
        public boolean contains(Object element) {
            return this.objectList.contains(element);
        }

        public boolean containsAll(Collection<? extends Object> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return this.objectList.containsAll((Iterable)elements);
        }

        public T get(int index) {
            ObjectListKt.access$checkIndex((List)this, index);
            return this.objectList.get(index);
        }

        @Override // java.util.List
        public int getSize() {
            return this.objectList.getSize();
        }

        @Override // java.util.List
        public int indexOf(Object element) {
            return this.objectList.indexOf(element);
        }

        @Override // java.util.List
        public boolean isEmpty() {
            return this.objectList.isEmpty();
        }

        public Iterator<T> iterator() {
            MutableObjectList.MutableObjectListIterator mutableObjectListIterator = new MutableObjectList.MutableObjectListIterator((List)this, 0);
            return (Iterator)mutableObjectListIterator;
        }

        @Override // java.util.List
        public int lastIndexOf(Object element) {
            return this.objectList.lastIndexOf(element);
        }

        public ListIterator<T> listIterator() {
            MutableObjectList.MutableObjectListIterator mutableObjectListIterator = new MutableObjectList.MutableObjectListIterator((List)this, 0);
            return (ListIterator)mutableObjectListIterator;
        }

        public ListIterator<T> listIterator(int index) {
            MutableObjectList.MutableObjectListIterator mutableObjectListIterator = new MutableObjectList.MutableObjectListIterator((List)this, index);
            return (ListIterator)mutableObjectListIterator;
        }

        public final T remove(int index) {
            return removeAt(index);
        }

        @Override // java.util.List
        public boolean remove(Object element) {
            return this.objectList.remove(element);
        }

        public boolean removeAll(Collection<? extends Object> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return this.objectList.removeAll((Iterable)elements);
        }

        public T removeAt(int index) {
            ObjectListKt.access$checkIndex((List)this, index);
            return this.objectList.removeAt(index);
        }

        public boolean retainAll(Collection<? extends Object> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return this.objectList.retainAll(elements);
        }

        public T set(int index, T element) {
            ObjectListKt.access$checkIndex((List)this, index);
            return this.objectList.set(index, element);
        }

        @Override // java.util.List
        public final int size() {
            return getSize();
        }

        public List<T> subList(int fromIndex, int toIndex) {
            ObjectListKt.access$checkSubIndex((List)this, fromIndex, toIndex);
            MutableObjectList.SubList subList = new MutableObjectList.SubList((List)this, fromIndex, toIndex);
            return (List)subList;
        }

        @Override // java.util.List
        public Object[] toArray() {
            return CollectionToArray.toArray((Collection)this);
        }

        public <T> T[] toArray(T[] tArr) {
            Intrinsics.checkNotNullParameter(tArr, "array");
            return CollectionToArray.toArray((Collection)this, tArr);
        }
    }

    @Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0002\u0008\t\n\u0002\u0010)\n\u0002\u0008\u0002\n\u0002\u0010+\n\u0002\u0008\n\u0008\u0002\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u00052\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0012\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0008\u0010\u0015\u001a\u00020\u000fH\u0016J\u0016\u0010\u0016\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0017\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bJ\u0008\u0010\u001c\u001a\u00020\u000cH\u0016J\u000f\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u001eH\u0096\u0002J\u0015\u0010\u001f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bJ\u000e\u0010 \u001a\u0008\u0012\u0004\u0012\u00028\u00010!H\u0016J\u0016\u0010 \u001a\u0008\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0015\u0010\"\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u0016\u0010#\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0015\u0010$\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010%\u001a\u00020\u000c2\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u001e\u0010&\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0016R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+", d2 = {"Landroidx/collection/MutableObjectList$SubList;", "T", "", "list", "start", "", "end", "(Ljava/util/List;II)V", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class SubList implements List<T>, KMutableList {

        private int end;
        private final List<T> list;
        private final int start;
        public SubList(List<T> list, int start, int end) {
            Intrinsics.checkNotNullParameter(list, "list");
            super();
            this.list = list;
            this.start = start;
            this.end = end;
        }

        public void add(int index, T element) {
            this.list.add(start += index, element);
            this.end = end++;
        }

        public boolean add(T element) {
            final int end = this.end;
            this.end = end + 1;
            this.list.add(end, element);
            return 1;
        }

        public boolean addAll(int index, Collection<? extends T> elements) {
            int i;
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.list.addAll(start += index, elements);
            this.end = end += size2;
            i = elements.size() > 0 ? 1 : 0;
            return i;
        }

        public boolean addAll(Collection<? extends T> elements) {
            int i;
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.list.addAll(this.end, elements);
            this.end = end += size2;
            i = elements.size() > 0 ? 1 : 0;
            return i;
        }

        @Override // java.util.List
        public void clear() {
            int i;
            List list;
            final int start = this.start;
            if (start <= end--) {
            }
            this.end = this.start;
        }

        @Override // java.util.List
        public boolean contains(Object element) {
            int i;
            boolean equal;
            i = this.start;
            while (i < this.end) {
                i++;
            }
            return 0;
        }

        public boolean containsAll(Collection<? extends Object> elements) {
            Object next;
            Object obj;
            int i;
            boolean contains;
            Intrinsics.checkNotNullParameter(elements, "elements");
            final int i2 = 0;
            Iterator iterator = (Iterable)elements.iterator();
            for (Object next : iterator) {
                i = 0;
            }
            return 1;
        }

        public T get(int index) {
            ObjectListKt.access$checkIndex((List)this, index);
            return this.list.get(start += index);
        }

        @Override // java.util.List
        public int getSize() {
            return end -= start;
        }

        @Override // java.util.List
        public int indexOf(Object element) {
            int i;
            boolean equal;
            i = this.start;
            while (i < this.end) {
                i++;
            }
            return -1;
        }

        @Override // java.util.List
        public boolean isEmpty() {
            int i;
            i = this.end == this.start ? 1 : 0;
            return i;
        }

        public Iterator<T> iterator() {
            MutableObjectList.MutableObjectListIterator mutableObjectListIterator = new MutableObjectList.MutableObjectListIterator((List)this, 0);
            return (Iterator)mutableObjectListIterator;
        }

        @Override // java.util.List
        public int lastIndexOf(Object element) {
            int i;
            boolean equal;
            int start = this.start;
            if (start <= end--) {
            }
            return -1;
        }

        public ListIterator<T> listIterator() {
            MutableObjectList.MutableObjectListIterator mutableObjectListIterator = new MutableObjectList.MutableObjectListIterator((List)this, 0);
            return (ListIterator)mutableObjectListIterator;
        }

        public ListIterator<T> listIterator(int index) {
            MutableObjectList.MutableObjectListIterator mutableObjectListIterator = new MutableObjectList.MutableObjectListIterator((List)this, index);
            return (ListIterator)mutableObjectListIterator;
        }

        public final T remove(int index) {
            return removeAt(index);
        }

        @Override // java.util.List
        public boolean remove(Object element) {
            int i;
            boolean equal;
            i = this.start;
            while (i < this.end) {
                i++;
            }
            return 0;
        }

        public boolean removeAll(Collection<? extends Object> elements) {
            int i2;
            Object next;
            Object obj;
            int i;
            Intrinsics.checkNotNullParameter(elements, "elements");
            final int i3 = 0;
            final Iterator iterator = (Iterable)elements.iterator();
            for (Object next : iterator) {
                i = 0;
                remove(next);
            }
            i2 = this.end != this.end ? 1 : 0;
            return i2;
        }

        public T removeAt(int index) {
            ObjectListKt.access$checkIndex((List)this, index);
            this.end = end--;
            return this.list.remove(start += index);
        }

        public boolean retainAll(Collection<? extends Object> elements) {
            int i2;
            int i;
            Object obj;
            boolean contains;
            Intrinsics.checkNotNullParameter(elements, "elements");
            final int start = this.start;
            if (start <= end2 -= i) {
            }
            if (this.end != this.end) {
            } else {
                i = 0;
            }
            return i;
        }

        public T set(int index, T element) {
            ObjectListKt.access$checkIndex((List)this, index);
            return this.list.set(start += index, element);
        }

        @Override // java.util.List
        public final int size() {
            return getSize();
        }

        public List<T> subList(int fromIndex, int toIndex) {
            ObjectListKt.access$checkSubIndex((List)this, fromIndex, toIndex);
            MutableObjectList.SubList subList = new MutableObjectList.SubList((List)this, fromIndex, toIndex);
            return (List)subList;
        }

        @Override // java.util.List
        public Object[] toArray() {
            return CollectionToArray.toArray((Collection)this);
        }

        public <T> T[] toArray(T[] tArr) {
            Intrinsics.checkNotNullParameter(tArr, "array");
            return CollectionToArray.toArray((Collection)this, tArr);
        }
    }
    public MutableObjectList() {
        super(0, 1, 0);
    }

    public MutableObjectList(int initialCapacity) {
        super(initialCapacity, 0);
    }

    public MutableObjectList(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 16 : obj1;
        super(obj1);
    }

    public static void trim$default(androidx.collection.MutableObjectList mutableObjectList, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = mutableObjectList._size;
        }
        mutableObjectList.trim(obj1);
    }

    public final void add(int index, E element) {
        int i;
        int _size2;
        int _size3;
        int _size;
        i = 0;
        int i3 = 1;
        if (index >= 0 && index <= this._size) {
            if (index <= this._size) {
                i = i3;
            }
        }
        if (i == 0) {
        } else {
            ensureCapacity(_size4 += i3);
            Object[] content2 = this.content;
            if (index != this._size) {
                ArraysKt.copyInto(content2, content2, index + 1, index, this._size);
            }
            content2[index] = element;
            this._size = _size6 += i3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException content = new IndexOutOfBoundsException(stringBuilder.append("Index ").append(index).append(" must be in 0..").append(this._size).toString());
        throw content;
    }

    public final boolean add(E element) {
        final int i3 = 1;
        ensureCapacity(_size += i3);
        this.content[this._size] = element;
        this._size = _size2 += i3;
        return i3;
    }

    public final boolean addAll(int index, androidx.collection.ObjectList<E> elements) {
        int _size;
        int i;
        int _size2;
        int _size3;
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i2 = 1;
        int i3 = 0;
        if (index >= 0 && index <= this._size) {
            i = index <= this._size ? i2 : i3;
        } else {
        }
        if (i == 0) {
        } else {
            if (elements.isEmpty()) {
                return i3;
            }
            ensureCapacity(_size6 += _size7);
            Object[] content = this.content;
            if (index != this._size) {
                ArraysKt.copyInto(content, content, _size9 += index, index, this._size);
            }
            ArraysKt.copyInto(elements.content, content, index, i3, elements._size);
            this._size = _size4 += _size8;
            return i2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("Index ").append(index).append(" must be in 0..").append(this._size).toString());
        throw indexOutOfBoundsException;
    }

    public final boolean addAll(int index, Collection<? extends E> elements) {
        int _size;
        int i2;
        int _size3;
        int _size2;
        int i;
        Object next;
        int i3;
        Object obj;
        int i5;
        int i4;
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i6 = 1;
        int i7 = 0;
        if (index >= 0 && index <= this._size) {
            i2 = index <= this._size ? i6 : i7;
        } else {
        }
        if (i2 == 0) {
        } else {
            if (elements.isEmpty()) {
                return i7;
            }
            ensureCapacity(_size4 += size);
            Object[] content = this.content;
            if (index != this._size) {
                ArraysKt.copyInto(content, content, size2 += index, index, this._size);
            }
            int i10 = 0;
            i = 0;
            final Iterator iterator = (Iterable)elements.iterator();
            while (iterator.hasNext()) {
                if (i < 0) {
                }
                i5 = 0;
                content[index + i] = iterator.next();
                i = i3;
                CollectionsKt.throwIndexOverflow();
            }
            this._size = $this$forEachIndexed$iv += size3;
            return i6;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("Index ").append(index).append(" must be in 0..").append(this._size).toString());
        throw indexOutOfBoundsException;
    }

    public final boolean addAll(int index, E[] elements) {
        int _size2;
        int _size;
        int i;
        int i2;
        int length;
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i3 = 1;
        int i4 = 0;
        if (index >= 0 && index <= this._size) {
            i = index <= this._size ? i3 : i4;
        } else {
        }
        if (i == 0) {
        } else {
            i2 = elements.length == 0 ? i3 : i4;
            if (i2 != 0) {
                return i4;
            }
            ensureCapacity(_size4 += length);
            final Object[] content = this.content;
            if (index != this._size) {
                ArraysKt.copyInto(content, content, length2 += index, index, this._size);
            }
            Object obj2 = elements;
            ArraysKt.copyInto$default(obj2, content, index, 0, 0, 12, 0);
            this._size = obj10 += obj11;
            return i3;
        }
        Object obj = elements;
        StringBuilder obj11 = new StringBuilder();
        IndexOutOfBoundsException obj10 = new IndexOutOfBoundsException(obj11.append("Index ").append(index).append(" must be in 0..").append(this._size).toString());
        throw obj10;
    }

    public final boolean addAll(androidx.collection.ObjectList<E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        plusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    public final boolean addAll(androidx.collection.ScatterSet<E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        plusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    public final boolean addAll(Iterable<? extends E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        plusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    public final boolean addAll(List<? extends E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        plusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    public final boolean addAll(Sequence<? extends E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        plusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    public final boolean addAll(E[] elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        plusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    public List<E> asList() {
        return asMutableList();
    }

    public final List<E> asMutableList() {
        androidx.collection.MutableObjectList.ObjectListMutableList objectListMutableList;
        androidx.collection.MutableObjectList.ObjectListMutableList list;
        int i;
        if (this.list != null) {
        } else {
            objectListMutableList = new MutableObjectList.ObjectListMutableList(this);
            i = 0;
            this.list = objectListMutableList;
        }
        return (List)objectListMutableList;
    }

    @Override // androidx.collection.ObjectList
    public final void clear() {
        final int i2 = 0;
        ArraysKt.fill(this.content, 0, i2, this._size);
        this._size = i2;
    }

    @Override // androidx.collection.ObjectList
    public final void ensureCapacity(int capacity) {
        int length;
        Object[] copyOf;
        String str;
        final Object[] content = this.content;
        if (content.length < capacity) {
            copyOf = Arrays.copyOf(content, Math.max(capacity, i /= 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    @Override // androidx.collection.ObjectList
    public final int getCapacity() {
        final int i = 0;
        return content.length;
    }

    public final void minusAssign(androidx.collection.ObjectList<E> elements) {
        int i$iv;
        Object obj;
        int i2;
        Object obj3;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj2 = elements;
        final int i3 = 0;
        i$iv = 0;
        while (i$iv < obj2._size) {
            i2 = 0;
            i = 0;
            this.remove(obj2.content[i$iv]);
            i$iv++;
        }
    }

    public final void minusAssign(androidx.collection.ScatterSet<E> elements) {
        int this_$iv2;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i4;
        int j$iv$iv;
        int i;
        int i5;
        long l;
        int i6;
        int i3;
        int i2;
        Object obj;
        int i7;
        Object this_$iv;
        Intrinsics.checkNotNullParameter(elements, "elements");
        this_$iv2 = elements;
        final int i8 = 0;
        final int i9 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i10) {
        } else {
            this_$iv = this_$iv2;
        }
    }

    public final void minusAssign(Iterable<? extends E> elements) {
        Object next;
        Object obj;
        int i;
        Object obj3;
        int i2;
        Intrinsics.checkNotNullParameter(elements, "elements");
        final int i3 = 0;
        final Iterator iterator = elements.iterator();
        for (Object next : iterator) {
            i = 0;
            i2 = 0;
            this.remove(next);
        }
    }

    public final void minusAssign(E element) {
        final int i = 0;
        remove(element);
    }

    public final void minusAssign(List<? extends E> elements) {
        int i2;
        Object obj;
        Object obj2;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        i2 = 0;
        while (i2 < elements.size()) {
            i = 0;
            this.remove(elements.get(i2));
            i2++;
        }
    }

    public final void minusAssign(Sequence<? extends E> elements) {
        Object next;
        Object obj;
        int i2;
        Object obj3;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        final int i3 = 0;
        final Iterator iterator = elements.iterator();
        for (Object next : iterator) {
            i2 = 0;
            i = 0;
            this.remove(next);
        }
    }

    public final void minusAssign(E[] elements) {
        int i3;
        Object obj;
        Object obj2;
        int i2;
        Object obj4;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj3 = elements;
        final int i4 = 0;
        i3 = 0;
        while (i3 < obj3.length) {
            i2 = 0;
            i = 0;
            this.remove(obj3[i3]);
            i3++;
        }
    }

    public final void plusAssign(androidx.collection.ObjectList<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
        }
        ensureCapacity(_size += _size2);
        ArraysKt.copyInto(elements.content, this.content, this._size, 0, elements._size);
        this._size = _size3 += _size5;
    }

    public final void plusAssign(androidx.collection.ScatterSet<E> elements) {
        Object cmp;
        Object obj;
        Object obj3;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i;
        int i6;
        Object this_$iv;
        long l;
        int i4;
        int i5;
        int i3;
        Object obj2;
        int i2;
        cmp = this;
        obj3 = elements;
        Intrinsics.checkNotNullParameter(obj3, "elements");
        if (obj3.isEmpty()) {
        }
        cmp.ensureCapacity(_size += size);
        obj = elements;
        int i15 = 0;
        final int i16 = 0;
        final long[] metadata = obj4.metadata;
        length += -2;
        if (0 <= i17) {
        } else {
            this_$iv = obj;
        }
    }

    public final void plusAssign(Iterable<? extends E> elements) {
        Object next;
        Object obj;
        int i2;
        Object obj3;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        final int i3 = 0;
        final Iterator iterator = elements.iterator();
        for (Object next : iterator) {
            i2 = 0;
            i = 0;
            this.add(next);
        }
    }

    public final void plusAssign(E element) {
        final int i = 0;
        add(element);
    }

    public final void plusAssign(List<? extends E> elements) {
        int i2;
        int i;
        Object obj;
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
        }
        int _size = this._size;
        ensureCapacity(size += _size);
        i2 = 0;
        while (i2 < elements.size()) {
            this.content[i2 + _size] = elements.get(i2);
            i2++;
        }
        this._size = i4 += size3;
    }

    public final void plusAssign(Sequence<? extends E> elements) {
        Object next;
        Object obj;
        int i2;
        Object obj3;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        final int i3 = 0;
        final Iterator iterator = elements.iterator();
        for (Object next : iterator) {
            i2 = 0;
            i = 0;
            this.add(next);
        }
    }

    public final void plusAssign(E[] elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        i = elements.length == 0 ? 1 : 0;
        if (i != 0) {
        }
        ensureCapacity(_size += length3);
        Object obj = elements;
        ArraysKt.copyInto$default(obj, this.content, this._size, 0, 0, 12, 0);
        this._size = obj9 += length2;
    }

    public final boolean remove(E element) {
        final int indexOf = indexOf(element);
        if (indexOf >= 0) {
            removeAt(indexOf);
            return 1;
        }
        return 0;
    }

    public final boolean removeAll(androidx.collection.ObjectList<E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        minusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    public final boolean removeAll(androidx.collection.ScatterSet<E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        minusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    public final boolean removeAll(Iterable<? extends E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        minusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    public final boolean removeAll(List<? extends E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        minusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    public final boolean removeAll(Sequence<? extends E> elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        minusAssign(elements);
        i = this._size != this._size ? 1 : 0;
        return i;
    }

    public final boolean removeAll(E[] elements) {
        int i;
        int i2;
        Object obj;
        Intrinsics.checkNotNullParameter(elements, "elements");
        i = 0;
        while (i < elements.length) {
            remove(elements[i]);
            i++;
        }
        i2 = this._size != this._size ? 1 : 0;
        return i2;
    }

    public final E removeAt(int index) {
        int i;
        int i2;
        int _size;
        Object _size2;
        i = 0;
        i2 = 1;
        if (index >= 0 && index < this._size) {
            if (index < this._size) {
                i = i2;
            }
        }
        if (i == 0) {
        } else {
            Object[] content2 = this.content;
            int i6 = 0;
            if (index != _size6 -= i2) {
                ArraysKt.copyInto(content2, content2, index, index + 1, this._size);
            }
            this._size = _size3--;
            content2[this._size] = 0;
            return content2[index];
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i5 = 0;
        IndexOutOfBoundsException content = new IndexOutOfBoundsException(stringBuilder.append("Index ").append(index).append(" must be in 0..").append(_size5 -= i2).toString());
        throw content;
    }

    public final void removeIf(Function1<? super E, Boolean> predicate) {
        int gap;
        int i;
        int booleanValue;
        int _size;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        gap = 0;
        final int _size2 = this._size;
        final Object[] content = this.content;
        int i5 = 0;
        IntRange this_$iv = RangesKt.until(0, obj._size);
        int last = this_$iv.getLast();
        if (this_$iv.getFirst() <= last) {
        }
        ArraysKt.fill(content, 0, _size2 - gap, _size2);
        this._size = _size3 -= gap;
    }

    @Override // androidx.collection.ObjectList
    public final void removeRange(int start, int end) {
        int i;
        int content;
        int content2;
        int _size;
        int _size3;
        String _size2;
        content2 = 0;
        if (start >= 0 && start <= this._size) {
            _size3 = start <= this._size ? i : content2;
        } else {
        }
        _size2 = "Start (";
        if (_size3 == 0) {
        } else {
            if (end >= 0 && end <= this._size) {
                if (end <= this._size) {
                } else {
                    i = content2;
                }
            } else {
            }
            if (i == 0) {
            } else {
                if (end < start) {
                } else {
                    if (end != start && end < this._size) {
                        if (end < this._size) {
                            ArraysKt.copyInto(this.content, this.content, start, end, this._size);
                        }
                        _size4 -= i2;
                        ArraysKt.fill(this.content, 0, i, this._size);
                        this._size = i;
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.append(_size2).append(start).append(") is more than end (").append(end).append(')').toString());
                throw illegalArgumentException;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append(_size2).append(start).append(") and end (").append(end).append(") must be in 0..").append(this._size).toString());
        throw indexOutOfBoundsException;
    }

    public final boolean retainAll(androidx.collection.ObjectList<E> elements) {
        Object obj;
        int contains;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        contains = 0;
        _size3 -= i;
        while (-1 < i2) {
            if (elements.contains(this.content[i2]) == 0) {
            }
            i2--;
            removeAt(i2);
        }
        if (this._size != this._size) {
        } else {
            i = 0;
        }
        return i;
    }

    public final boolean retainAll(Iterable<? extends E> elements) {
        Object obj;
        int contains;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        contains = 0;
        _size3 -= i;
        while (-1 < i2) {
            if (CollectionsKt.contains(elements, this.content[i2]) == 0) {
            }
            i2--;
            removeAt(i2);
        }
        if (this._size != this._size) {
        } else {
            i = 0;
        }
        return i;
    }

    public final boolean retainAll(Collection<? extends E> elements) {
        Object obj;
        int contains;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        contains = 0;
        _size3 -= i;
        while (-1 < i2) {
            if (elements.contains(this.content[i2]) == 0) {
            }
            i2--;
            removeAt(i2);
        }
        if (this._size != this._size) {
        } else {
            i = 0;
        }
        return i;
    }

    public final boolean retainAll(Sequence<? extends E> elements) {
        Object obj;
        int contains;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        contains = 0;
        _size3 -= i;
        while (-1 < i2) {
            if (SequencesKt.contains(elements, this.content[i2]) == 0) {
            }
            i2--;
            removeAt(i2);
        }
        if (this._size != this._size) {
        } else {
            i = 0;
        }
        return i;
    }

    public final boolean retainAll(E[] elements) {
        Object obj;
        int indexOf;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        indexOf = 0;
        _size3 -= i;
        while (-1 < i2) {
            if (ArraysKt.indexOf(elements, this.content[i2]) < 0) {
            }
            i2--;
            removeAt(i2);
        }
        if (this._size != this._size) {
        } else {
            i = 0;
        }
        return i;
    }

    public final E set(int index, E element) {
        int i;
        int _size;
        int i2 = 1;
        i = 0;
        if (index >= 0 && index < this._size) {
            if (index < this._size) {
                i = i2;
            }
        }
        if (i == 0) {
        } else {
            Object[] content = this.content;
            content[index] = element;
            return content[index];
        }
        StringBuilder stringBuilder = new StringBuilder();
        final int i3 = 0;
        IndexOutOfBoundsException old = new IndexOutOfBoundsException(stringBuilder.append("set index ").append(index).append(" must be between 0 .. ").append(_size2 -= i2).toString());
        throw old;
    }

    @Override // androidx.collection.ObjectList
    public final void trim(int minCapacity) {
        int this_$iv;
        int str;
        int i = Math.max(minCapacity, this._size);
        str = 0;
        if (content2.length > i) {
            this_$iv = Arrays.copyOf(this.content, i);
            Intrinsics.checkNotNullExpressionValue(this_$iv, "copyOf(this, newSize)");
            this.content = this_$iv;
        }
    }
}

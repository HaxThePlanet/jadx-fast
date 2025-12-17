package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap.Companion;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010(\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000 '*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001'B-\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0002\u0010\nJ\u001b\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\u000e\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001bH\u0016J\u000e\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001fJ\u000f\u0010 \u001a\u0008\u0012\u0004\u0012\u00028\u00000!H\u0096\u0002J\u001b\u0010\"\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\"\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e0%H\u0016J\u001c\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0019H\u0016J\u001c\u0010&\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0019H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u0008X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000cR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006(", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet;", "E", "Lkotlin/collections/AbstractSet;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "firstElement", "", "lastElement", "hashMap", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/Links;", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;)V", "getFirstElement$runtime_release", "()Ljava/lang/Object;", "getHashMap$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "getLastElement$runtime_release", "size", "", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "addAll", "elements", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet$Builder;", "clear", "contains", "", "(Ljava/lang/Object;)Z", "iterator", "", "remove", "removeAll", "predicate", "Lkotlin/Function1;", "retainAll", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PersistentOrderedSet<E>  extends AbstractSet<E> implements PersistentSet<E> {

    public static final int $stable = 8;
    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet.Companion Companion;
    private static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet EMPTY;
    private final Object firstElement;
    private final PersistentHashMap<E, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.Links> hashMap;
    private final Object lastElement;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\"\u0004\u0008\u0001\u0010\u0008H\u0000¢\u0006\u0002\u0008\tR\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet;", "", "emptyOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "E", "emptyOf$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final <E> PersistentSet<E> emptyOf$runtime_release() {
            return (PersistentSet)PersistentOrderedSet.access$getEMPTY$cp();
        }
    }
    static {
        PersistentOrderedSet.Companion companion = new PersistentOrderedSet.Companion(0);
        PersistentOrderedSet.Companion = companion;
        int i = 8;
        PersistentOrderedSet persistentOrderedSet = new PersistentOrderedSet(EndOfChain.INSTANCE, EndOfChain.INSTANCE, PersistentHashMap.Companion.emptyOf$runtime_release());
        PersistentOrderedSet.EMPTY = persistentOrderedSet;
    }

    public PersistentOrderedSet(Object firstElement, Object lastElement, PersistentHashMap<E, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.Links> hashMap) {
        super();
        this.firstElement = firstElement;
        this.lastElement = lastElement;
        this.hashMap = hashMap;
    }

    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet access$getEMPTY$cp() {
        return PersistentOrderedSet.EMPTY;
    }

    @Override // kotlin.collections.AbstractSet
    public PersistentCollection add(Object element) {
        return (PersistentCollection)add(element);
    }

    public PersistentSet<E> add(E element) {
        if (this.hashMap.containsKey(element)) {
            return (PersistentSet)this;
        }
        if (isEmpty()) {
            Links links = new Links();
            PersistentOrderedSet persistentOrderedSet = new PersistentOrderedSet(element, element, this.hashMap.put(element, links));
            return (PersistentSet)persistentOrderedSet;
        }
        Object newMap = this.lastElement;
        Object obj2 = this.hashMap.get(newMap);
        Intrinsics.checkNotNull(obj2);
        Links links2 = new Links(newMap);
        PersistentOrderedSet persistentOrderedSet2 = new PersistentOrderedSet(this.firstElement, element, this.hashMap.put(newMap, (Links)obj2.withNext(element)).put(element, links2));
        return (PersistentSet)persistentOrderedSet2;
    }

    @Override // kotlin.collections.AbstractSet
    public PersistentCollection addAll(Collection elements) {
        return (PersistentCollection)addAll(elements);
    }

    public PersistentSet<E> addAll(Collection<? extends E> elements) {
        final int i = 0;
        final PersistentSet.Builder builder = (PersistentSet)this.builder();
        final int i2 = 0;
        (Set)builder.addAll(elements);
        return builder.build();
    }

    @Override // kotlin.collections.AbstractSet
    public PersistentCollection.Builder builder() {
        return (PersistentCollection.Builder)builder();
    }

    public PersistentSet.Builder<E> builder() {
        PersistentOrderedSetBuilder persistentOrderedSetBuilder = new PersistentOrderedSetBuilder(this);
        return (PersistentSet.Builder)persistentOrderedSetBuilder;
    }

    @Override // kotlin.collections.AbstractSet
    public PersistentCollection clear() {
        return (PersistentCollection)clear();
    }

    public PersistentSet<E> clear() {
        return PersistentOrderedSet.Companion.emptyOf$runtime_release();
    }

    @Override // kotlin.collections.AbstractSet
    public boolean contains(Object element) {
        return this.hashMap.containsKey(element);
    }

    @Override // kotlin.collections.AbstractSet
    public final Object getFirstElement$runtime_release() {
        return this.firstElement;
    }

    public final PersistentHashMap<E, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.Links> getHashMap$runtime_release() {
        return this.hashMap;
    }

    @Override // kotlin.collections.AbstractSet
    public final Object getLastElement$runtime_release() {
        return this.lastElement;
    }

    @Override // kotlin.collections.AbstractSet
    public int getSize() {
        return this.hashMap.size();
    }

    public Iterator<E> iterator() {
        PersistentOrderedSetIterator persistentOrderedSetIterator = new PersistentOrderedSetIterator(this.firstElement, (Map)this.hashMap);
        return (Iterator)persistentOrderedSetIterator;
    }

    @Override // kotlin.collections.AbstractSet
    public PersistentCollection remove(Object element) {
        return (PersistentCollection)remove(element);
    }

    public PersistentSet<E> remove(E element) {
        PersistentHashMap newMap;
        boolean hasPrevious;
        boolean hasNext;
        Object firstElement;
        Object previous;
        Object lastElement;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.Links previous2;
        Object obj = this.hashMap.get(element);
        if ((Links)obj == null) {
            return (PersistentSet)this;
        }
        newMap = this.hashMap.remove(element);
        if ((Links)obj.getHasPrevious()) {
            hasPrevious = (Map)newMap.get(obj.getPrevious());
            Intrinsics.checkNotNull(hasPrevious);
            newMap = newMap.put(obj.getPrevious(), (Links)hasPrevious.withNext(obj.getNext()));
        }
        if (obj.getHasNext()) {
            hasNext = (Map)newMap.get(obj.getNext());
            Intrinsics.checkNotNull(hasNext);
            newMap = newMap.put(obj.getNext(), (Links)hasNext.withPrevious(obj.getPrevious()));
        }
        if (!obj.getHasPrevious()) {
            firstElement = obj.getNext();
        } else {
            firstElement = this.firstElement;
        }
        if (!obj.getHasNext()) {
            lastElement = obj.getPrevious();
        } else {
            lastElement = this.lastElement;
        }
        PersistentOrderedSet persistentOrderedSet = new PersistentOrderedSet(firstElement, lastElement, newMap);
        return (PersistentSet)persistentOrderedSet;
    }

    @Override // kotlin.collections.AbstractSet
    public PersistentCollection removeAll(Collection elements) {
        return (PersistentCollection)removeAll(elements);
    }

    @Override // kotlin.collections.AbstractSet
    public PersistentCollection removeAll(Function1 predicate) {
        return (PersistentCollection)removeAll(predicate);
    }

    public PersistentSet<E> removeAll(Collection<? extends E> elements) {
        final int i = 0;
        final PersistentSet.Builder builder = (PersistentSet)this.builder();
        final int i2 = 0;
        (Set)builder.removeAll(elements);
        return builder.build();
    }

    public PersistentSet<E> removeAll(Function1<? super E, Boolean> predicate) {
        final int i = 0;
        final PersistentSet.Builder builder = (PersistentSet)this.builder();
        final int i2 = 0;
        CollectionsKt.removeAll((Iterable)(Set)builder, predicate);
        return builder.build();
    }

    @Override // kotlin.collections.AbstractSet
    public PersistentCollection retainAll(Collection elements) {
        return (PersistentCollection)retainAll(elements);
    }

    public PersistentSet<E> retainAll(Collection<? extends E> elements) {
        final int i = 0;
        final PersistentSet.Builder builder = (PersistentSet)this.builder();
        final int i2 = 0;
        (Set)builder.retainAll(elements);
        return builder.build();
    }
}

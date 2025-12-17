package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010)\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001cH\u0016J\u0008\u0010\u001d\u001a\u00020\u001eH\u0016J\u0016\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001aJ\u000f\u0010 \u001a\u0008\u0012\u0004\u0012\u00028\u00000!H\u0096\u0002J\u0015\u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u000eX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006#", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSetBuilder;", "E", "Lkotlin/collections/AbstractMutableSet;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet$Builder;", "set", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet;)V", "firstElement", "", "getFirstElement$runtime_release", "()Ljava/lang/Object;", "setFirstElement$runtime_release", "(Ljava/lang/Object;)V", "hashMapBuilder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/Links;", "getHashMapBuilder$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "lastElement", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "build", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "clear", "", "contains", "iterator", "", "remove", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PersistentOrderedSetBuilder<E>  extends AbstractMutableSet<E> implements PersistentSet.Builder<E> {

    public static final int $stable = 8;
    private Object firstElement;
    private final PersistentHashMapBuilder<E, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.Links> hashMapBuilder;
    private Object lastElement;
    private androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet<E> set;
    static {
        final int i = 8;
    }

    public PersistentOrderedSetBuilder(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet<E> set) {
        super();
        this.set = set;
        this.firstElement = this.set.getFirstElement$runtime_release();
        this.lastElement = this.set.getLastElement$runtime_release();
        this.hashMapBuilder = this.set.getHashMap$runtime_release().builder();
    }

    public boolean add(E element) {
        if (this.hashMapBuilder.containsKey(element)) {
            return 0;
        }
        final int i2 = 1;
        if (isEmpty()) {
            this.firstElement = element;
            this.lastElement = element;
            Links links = new Links();
            (Map)this.hashMapBuilder.put(element, links);
            return i2;
        }
        Object obj = (Map)this.hashMapBuilder.get(this.lastElement);
        Intrinsics.checkNotNull(obj);
        (Map)this.hashMapBuilder.put(this.lastElement, (Links)obj.withNext(element));
        Links links2 = new Links(this.lastElement);
        (Map)this.hashMapBuilder.put(element, links2);
        this.lastElement = element;
        return i2;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public PersistentCollection build() {
        return (PersistentCollection)build();
    }

    public PersistentSet<E> build() {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSet persistentOrderedSet;
        int i2;
        Object lastElement$runtime_release;
        int lastElement;
        int i;
        PersistentHashMap build = this.hashMapBuilder.build();
        if (build == this.set.getHashMap$runtime_release()) {
            i = 0;
            i2 = this.firstElement == this.set.getFirstElement$runtime_release() ? lastElement : i;
            CommonFunctionsKt.assert(i2);
            if (this.lastElement == this.set.getLastElement$runtime_release()) {
            } else {
                lastElement = i;
            }
            CommonFunctionsKt.assert(lastElement);
            persistentOrderedSet = this.set;
        } else {
            persistentOrderedSet = new PersistentOrderedSet(this.firstElement, this.lastElement, build);
        }
        this.set = persistentOrderedSet;
        return (PersistentSet)this.set;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public void clear() {
        this.hashMapBuilder.clear();
        this.firstElement = EndOfChain.INSTANCE;
        this.lastElement = EndOfChain.INSTANCE;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public boolean contains(Object element) {
        return this.hashMapBuilder.containsKey(element);
    }

    @Override // kotlin.collections.AbstractMutableSet
    public final Object getFirstElement$runtime_release() {
        return this.firstElement;
    }

    public final PersistentHashMapBuilder<E, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.Links> getHashMapBuilder$runtime_release() {
        return this.hashMapBuilder;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.hashMapBuilder.size();
    }

    public Iterator<E> iterator() {
        PersistentOrderedSetMutableIterator persistentOrderedSetMutableIterator = new PersistentOrderedSetMutableIterator(this);
        return (Iterator)persistentOrderedSetMutableIterator;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public boolean remove(Object element) {
        Object next;
        Object previous3;
        PersistentHashMapBuilder hashMapBuilder;
        Object previous2;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedSet.Links previous;
        Object remove = this.hashMapBuilder.remove(element);
        if ((Links)remove == null) {
            return 0;
        }
        if ((Links)remove.getHasPrevious()) {
            next = (Map)this.hashMapBuilder.get(remove.getPrevious());
            Intrinsics.checkNotNull(next);
            (Map)this.hashMapBuilder.put(remove.getPrevious(), (Links)next.withNext(remove.getNext()));
        } else {
            this.firstElement = remove.getNext();
        }
        if (remove.getHasNext()) {
            previous3 = (Map)this.hashMapBuilder.get(remove.getNext());
            Intrinsics.checkNotNull(previous3);
            (Map)this.hashMapBuilder.put(remove.getNext(), (Links)previous3.withPrevious(remove.getPrevious()));
        } else {
            this.lastElement = remove.getPrevious();
        }
        return 1;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public final void setFirstElement$runtime_release(Object <set-?>) {
        this.firstElement = <set-?>;
    }
}

package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010(\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u0000 !*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001!B\u001b\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u001b\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\u000e\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0014H\u0016J\u000e\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00172\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\u000f\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001bH\u0096\u0002J\u001b\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\"\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\u001fH\u0016J\u001c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\u001c\u0010 \u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00032\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0012H\u0016R\u001a\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\"", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet;", "E", "Lkotlin/collections/AbstractSet;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "size", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;I)V", "getNode$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "addAll", "elements", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet$Builder;", "clear", "contains", "", "(Ljava/lang/Object;)Z", "containsAll", "iterator", "", "remove", "removeAll", "predicate", "Lkotlin/Function1;", "retainAll", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PersistentHashSet<E>  extends AbstractSet<E> implements PersistentSet<E> {

    public static final int $stable = 8;
    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSet.Companion Companion;
    private static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSet EMPTY;
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> node;
    private final int size;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u0007\"\u0004\u0008\u0001\u0010\u0008H\u0000¢\u0006\u0002\u0008\tR\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet;", "", "emptyOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "E", "emptyOf$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final <E> PersistentSet<E> emptyOf$runtime_release() {
            return (PersistentSet)PersistentHashSet.access$getEMPTY$cp();
        }
    }
    static {
        PersistentHashSet.Companion companion = new PersistentHashSet.Companion(0);
        PersistentHashSet.Companion = companion;
        int i = 8;
        PersistentHashSet persistentHashSet = new PersistentHashSet(TrieNode.Companion.getEMPTY$runtime_release(), 0);
        PersistentHashSet.EMPTY = persistentHashSet;
    }

    public PersistentHashSet(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> node, int size) {
        super();
        this.node = node;
        this.size = size;
    }

    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSet access$getEMPTY$cp() {
        return PersistentHashSet.EMPTY;
    }

    @Override // kotlin.collections.AbstractSet
    public PersistentCollection add(Object element) {
        return (PersistentCollection)add(element);
    }

    public PersistentSet<E> add(E element) {
        int i;
        int i2 = 0;
        if (element != null) {
            i = element.hashCode();
        } else {
            i = i2;
        }
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode set = this.node.add(i, element, i2);
        if (this.node == set) {
            return (PersistentSet)this;
        }
        PersistentHashSet persistentHashSet = new PersistentHashSet(set, size++);
        return (PersistentSet)persistentHashSet;
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
        PersistentHashSetBuilder persistentHashSetBuilder = new PersistentHashSetBuilder(this);
        return (PersistentSet.Builder)persistentHashSetBuilder;
    }

    @Override // kotlin.collections.AbstractSet
    public PersistentCollection clear() {
        return (PersistentCollection)clear();
    }

    public PersistentSet<E> clear() {
        return PersistentHashSet.Companion.emptyOf$runtime_release();
    }

    @Override // kotlin.collections.AbstractSet
    public boolean contains(Object element) {
        int i;
        final int i2 = 0;
        if (element != null) {
            i = element.hashCode();
        } else {
            i = i2;
        }
        return this.node.contains(i, element, i2);
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        final int i = 0;
        if (elements instanceof PersistentHashSet != null) {
            return this.node.containsAll(obj.node, i);
        }
        if (elements instanceof PersistentHashSetBuilder != null) {
            return this.node.containsAll((PersistentHashSetBuilder)elements.getNode$runtime_release(), i);
        }
        return super.containsAll(elements);
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> getNode$runtime_release() {
        return this.node;
    }

    @Override // kotlin.collections.AbstractSet
    public int getSize() {
        return this.size;
    }

    public Iterator<E> iterator() {
        PersistentHashSetIterator persistentHashSetIterator = new PersistentHashSetIterator(this.node);
        return (Iterator)persistentHashSetIterator;
    }

    @Override // kotlin.collections.AbstractSet
    public PersistentCollection remove(Object element) {
        return (PersistentCollection)remove(element);
    }

    public PersistentSet<E> remove(E element) {
        int i;
        int i2 = 0;
        if (element != null) {
            i = element.hashCode();
        } else {
            i = i2;
        }
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode remove = this.node.remove(i, element, i2);
        if (this.node == remove) {
            return (PersistentSet)this;
        }
        PersistentHashSet persistentHashSet = new PersistentHashSet(remove, size--);
        return (PersistentSet)persistentHashSet;
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

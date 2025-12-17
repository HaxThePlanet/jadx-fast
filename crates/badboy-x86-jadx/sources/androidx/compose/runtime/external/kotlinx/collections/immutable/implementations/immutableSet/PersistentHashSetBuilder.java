package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010)\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001a2\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u000e\u0010 \u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J\u0008\u0010!\u001a\u00020\"H\u0016J\u0016\u0010#\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001cJ\u0016\u0010$\u001a\u00020\u001a2\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u000f\u0010%\u001a\u0008\u0012\u0004\u0012\u00028\u00000&H\u0096\u0002J\u0015\u0010'\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u0016\u0010(\u001a\u00020\u001a2\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u0016\u0010)\u001a\u00020\u001a2\u000c\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001fH\u0016R\u001e\u0010\t\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u0008@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR*\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000c2\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000c@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0010@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00082\u0006\u0010\u0014\u001a\u00020\u0008@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u000b\"\u0004\u0008\u0017\u0010\u0018¨\u0006*", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "E", "Lkotlin/collections/AbstractMutableSet;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet$Builder;", "set", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet;)V", "<set-?>", "", "modCount", "getModCount$runtime_release", "()I", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "node", "getNode$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "ownership", "getOwnership$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "value", "size", "getSize", "setSize", "(I)V", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "build", "clear", "", "contains", "containsAll", "iterator", "", "remove", "removeAll", "retainAll", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PersistentHashSetBuilder<E>  extends AbstractMutableSet<E> implements PersistentSet.Builder<E> {

    public static final int $stable = 8;
    private int modCount;
    private androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> node;
    private MutabilityOwnership ownership;
    private androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSet<E> set;
    private int size;
    static {
        final int i = 8;
    }

    public PersistentHashSetBuilder(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSet<E> set) {
        super();
        this.set = set;
        MutabilityOwnership mutabilityOwnership = new MutabilityOwnership();
        this.ownership = mutabilityOwnership;
        this.node = this.set.getNode$runtime_release();
        this.size = this.set.size();
    }

    public boolean add(E element) {
        int i;
        int i2;
        i = 0;
        if (element != null) {
            i2 = element.hashCode();
        } else {
            i2 = i;
        }
        this.node = this.node.mutableAdd(i2, element, i, this);
        if (size() != size()) {
            i = 1;
        }
        return i;
    }

    public boolean addAll(Collection<? extends E> elements) {
        Object build;
        int i;
        int i2;
        int i3 = 0;
        if (elements instanceof PersistentHashSet != null) {
            build = elements;
        } else {
            build = i3;
        }
        if (build == null) {
            if (elements instanceof PersistentHashSetBuilder != null) {
                i = elements;
            } else {
                i = i3;
            }
            if (i != 0) {
                build = i.build();
            } else {
                build = i3;
            }
        }
        i2 = 0;
        final int i4 = 1;
        DeltaCounter deltaCounter = new DeltaCounter(i2, i4, i3);
        int size = size();
        i5 -= count;
        if (build != null && size != i6) {
            i2 = 0;
            i4 = 1;
            deltaCounter = new DeltaCounter(i2, i4, i3);
            size = size();
            i5 -= count;
            if (size != i6) {
                this.node = this.node.mutableAddAll(build.getNode$runtime_release(), i2, deltaCounter, this);
                setSize(i6);
            }
            if (size != size()) {
                i2 = i4;
            }
            return i2;
        }
        return super.addAll(elements);
    }

    @Override // kotlin.collections.AbstractMutableSet
    public PersistentCollection build() {
        return (PersistentCollection)build();
    }

    @Override // kotlin.collections.AbstractMutableSet
    public PersistentSet build() {
        return (PersistentSet)build();
    }

    public androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSet<E> build() {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSet persistentHashSet;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode node$runtime_release;
        int size;
        if (this.node == this.set.getNode$runtime_release()) {
            persistentHashSet = this.set;
        } else {
            MutabilityOwnership mutabilityOwnership = new MutabilityOwnership();
            this.ownership = mutabilityOwnership;
            persistentHashSet = new PersistentHashSet(this.node, size());
        }
        this.set = persistentHashSet;
        return this.set;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public void clear() {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode eMPTY$runtime_release = TrieNode.Companion.getEMPTY$runtime_release();
        Intrinsics.checkNotNull(eMPTY$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
        this.node = eMPTY$runtime_release;
        setSize(0);
    }

    @Override // kotlin.collections.AbstractMutableSet
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
            return this.node.containsAll((PersistentHashSet)elements.getNode$runtime_release(), i);
        }
        if (elements instanceof PersistentHashSetBuilder != null) {
            return this.node.containsAll(obj2.node, i);
        }
        return super.containsAll(elements);
    }

    @Override // kotlin.collections.AbstractMutableSet
    public final int getModCount$runtime_release() {
        return this.modCount;
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> getNode$runtime_release() {
        return this.node;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public final MutabilityOwnership getOwnership$runtime_release() {
        return this.ownership;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.size;
    }

    public Iterator<E> iterator() {
        PersistentHashSetMutableIterator persistentHashSetMutableIterator = new PersistentHashSetMutableIterator(this);
        return (Iterator)persistentHashSetMutableIterator;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public boolean remove(Object element) {
        int i;
        int i2;
        i = 0;
        if (element != null) {
            i2 = element.hashCode();
        } else {
            i2 = i;
        }
        this.node = this.node.mutableRemove(i2, element, i, this);
        if (size() != size()) {
            i = 1;
        }
        return i;
    }

    public boolean removeAll(Collection<? extends Object> elements) {
        Object build;
        int i;
        int i2;
        Object obj;
        int i3 = 0;
        if (elements instanceof PersistentHashSet != null) {
            build = elements;
        } else {
            build = i3;
        }
        if (build == null) {
            if (elements instanceof PersistentHashSetBuilder != null) {
                i = elements;
            } else {
                i = i3;
            }
            if (i != 0) {
                build = i.build();
            } else {
                build = i3;
            }
        }
        if (build != null) {
            i2 = 0;
            final int i4 = 1;
            DeltaCounter deltaCounter = new DeltaCounter(i2, i4, i3);
            int size = size();
            Object mutableRemoveAll = this.node.mutableRemoveAll(build.getNode$runtime_release(), i2, deltaCounter, this);
            int i5 = size - count;
            if (i5 == 0) {
                clear();
            } else {
                if (i5 != size) {
                    Intrinsics.checkNotNull(mutableRemoveAll, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
                    this.node = (TrieNode)mutableRemoveAll;
                    setSize(i5);
                }
            }
            if (size != size()) {
                i2 = i4;
            }
            return i2;
        }
        return super.removeAll(elements);
    }

    public boolean retainAll(Collection<? extends Object> elements) {
        Object build;
        int i;
        int i2;
        Object obj;
        int i3 = 0;
        if (elements instanceof PersistentHashSet != null) {
            build = elements;
        } else {
            build = i3;
        }
        if (build == null) {
            if (elements instanceof PersistentHashSetBuilder != null) {
                i = elements;
            } else {
                i = i3;
            }
            if (i != 0) {
                build = i.build();
            } else {
                build = i3;
            }
        }
        if (build != null) {
            i2 = 0;
            final int i4 = 1;
            DeltaCounter deltaCounter = new DeltaCounter(i2, i4, i3);
            int size = size();
            Object mutableRetainAll = this.node.mutableRetainAll(build.getNode$runtime_release(), i2, deltaCounter, this);
            int count = deltaCounter.getCount();
            if (count == 0) {
                clear();
            } else {
                if (count != size) {
                    Intrinsics.checkNotNull(mutableRetainAll, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
                    this.node = (TrieNode)mutableRetainAll;
                    setSize(count);
                }
            }
            if (size != size()) {
                i2 = i4;
            }
            return i2;
        }
        return super.retainAll(elements);
    }

    @Override // kotlin.collections.AbstractMutableSet
    public void setSize(int value) {
        this.size = value;
        this.modCount = modCount++;
    }
}

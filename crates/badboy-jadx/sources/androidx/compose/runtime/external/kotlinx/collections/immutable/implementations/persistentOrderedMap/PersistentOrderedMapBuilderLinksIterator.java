package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0008\u0010\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B#\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\u001a\u001a\u00020\u001bH\u0002J\u0008\u0010\u001c\u001a\u00020\u001bH\u0002J\u0008\u0010\u001d\u001a\u00020\u001bH\u0002J\t\u0010\u001e\u001a\u00020\u0019H\u0096\u0002J\u000f\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002J\u0008\u0010 \u001a\u00020\u001bH\u0016R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0008X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilderLinksIterator;", "K", "V", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "nextKey", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;)V", "getBuilder$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;", "expectedModCount", "", "index", "getIndex$runtime_release", "()I", "setIndex$runtime_release", "(I)V", "lastIteratedKey", "getLastIteratedKey$runtime_release", "()Ljava/lang/Object;", "setLastIteratedKey$runtime_release", "(Ljava/lang/Object;)V", "nextWasInvoked", "", "checkForComodification", "", "checkHasNext", "checkNextWasInvoked", "hasNext", "next", "remove", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class PersistentOrderedMapBuilderLinksIterator<K, V>  implements Iterator<androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.LinkedValue<V>>, KMutableIterator {

    public static final int $stable = 8;
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder<K, V> builder;
    private int expectedModCount;
    private int index;
    private Object lastIteratedKey;
    private Object nextKey;
    private boolean nextWasInvoked;
    static {
        final int i = 8;
    }

    public PersistentOrderedMapBuilderLinksIterator(Object nextKey, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder<K, V> builder) {
        super();
        this.nextKey = nextKey;
        this.builder = builder;
        this.lastIteratedKey = EndOfChain.INSTANCE;
        this.expectedModCount = this.builder.getHashMapBuilder$runtime_release().getModCount$runtime_release();
    }

    private final void checkForComodification() {
        if (this.builder.getHashMapBuilder$runtime_release().getModCount$runtime_release() != this.expectedModCount) {
        } else {
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    private final void checkHasNext() {
        if (!hasNext()) {
        } else {
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    private final void checkNextWasInvoked() {
        if (!this.nextWasInvoked) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMapBuilder<K, V> getBuilder$runtime_release() {
        return this.builder;
    }

    @Override // java.util.Iterator
    public final int getIndex$runtime_release() {
        return this.index;
    }

    @Override // java.util.Iterator
    public final Object getLastIteratedKey$runtime_release() {
        return this.lastIteratedKey;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i;
        i = this.index < this.builder.size() ? 1 : 0;
        return i;
    }

    public androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap.LinkedValue<V> next() {
        checkForComodification();
        checkHasNext();
        this.lastIteratedKey = this.nextKey;
        int i = 1;
        this.nextWasInvoked = i;
        this.index = index += i;
        Object obj = (Map)this.builder.getHashMapBuilder$runtime_release().get(this.nextKey);
        if (obj == null) {
        } else {
            this.nextKey = (LinkedValue)obj.getNext();
            return obj;
        }
        int result = 0;
        StringBuilder stringBuilder = new StringBuilder();
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException(stringBuilder.append("Hash code of a key (").append(this.nextKey).append(") has changed after it was added to the persistent map.").toString());
        throw concurrentModificationException;
    }

    @Override // java.util.Iterator
    public Object next() {
        return next();
    }

    @Override // java.util.Iterator
    public void remove() {
        checkNextWasInvoked();
        TypeIntrinsics.asMutableMap((Map)this.builder).remove(this.lastIteratedKey);
        this.lastIteratedKey = 0;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.getHashMapBuilder$runtime_release().getModCount$runtime_release();
        this.index = index--;
    }

    @Override // java.util.Iterator
    public final void setIndex$runtime_release(int <set-?>) {
        this.index = <set-?>;
    }

    @Override // java.util.Iterator
    public final void setLastIteratedKey$runtime_release(Object <set-?>) {
        this.lastIteratedKey = <set-?>;
    }
}

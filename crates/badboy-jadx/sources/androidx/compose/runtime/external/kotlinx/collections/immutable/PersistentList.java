package androidx.compose.runtime.external.kotlinx.collections.immutable;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMutableList;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008`\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0019J\u001b\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J#\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0007\u001a\u00020\u00082\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000cH&J\u001c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000cH&J\u000e\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000fH&J\u000e\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000H&J\u001b\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\"\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0014H&J\u001c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000cH&J\u0016\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0007\u001a\u00020\u0008H&J\u001c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000cH&J#\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u001aÀ\u0006\u0001", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "add", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "index", "", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "addAll", "c", "", "elements", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "clear", "remove", "removeAll", "predicate", "Lkotlin/Function1;", "", "removeAt", "retainAll", "set", "Builder", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PersistentList<E>  extends androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList<E>, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<E> {

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003J\u000e\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0006À\u0006\u0001", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "E", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection$Builder;", "build", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Builder extends List<E>, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder<E>, KMutableList {
        public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> build();
    }
    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> add(int i, E e2);

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> add(E e);

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> addAll(int i, Collection<? extends E> collection2);

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> addAll(Collection<? extends E> collection);

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder<E> builder();

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> clear();

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> remove(E e);

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> removeAll(Collection<? extends E> collection);

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> removeAll(Function1<? super E, Boolean> function1);

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> removeAt(int i);

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> retainAll(Collection<? extends E> collection);

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<E> set(int i, E e2);
}

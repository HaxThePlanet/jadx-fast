package androidx.compose.runtime.external.kotlinx.collections.immutable;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMutableCollection;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008`\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0012J\u001b\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008H&J\u000e\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00000\nH&J\u000e\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000H&J\u001b\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0005J\"\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u000fH&J\u001c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008H&J\u001c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0013À\u0006\u0001", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "add", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "addAll", "elements", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection$Builder;", "clear", "remove", "removeAll", "predicate", "Lkotlin/Function1;", "", "retainAll", "Builder", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PersistentCollection<E>  extends androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableCollection<E> {

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002J\u000e\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0005À\u0006\u0001", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection$Builder;", "E", "", "build", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentCollection;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Builder extends Collection<E>, KMutableCollection {
        public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<E> build();
    }
    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<E> add(E e);

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<E> addAll(Collection<? extends E> collection);

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder<E> builder();

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<E> clear();

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<E> remove(E e);

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<E> removeAll(Collection<? extends E> collection);

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<E> removeAll(Function1<? super E, Boolean> function1);

    public abstract androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection<E> retainAll(Collection<? extends E> collection);
}

package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008'\u0018\u0000 \u000b*\u0006\u0008\u0000\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u000bB\u0007\u0008\u0004¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0096\u0002J\u0008\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000c", d2 = {"Lkotlin/collections/AbstractSet;", "E", "Lkotlin/collections/AbstractCollection;", "", "()V", "equals", "", "other", "", "hashCode", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractSet<E>  extends kotlin.collections.AbstractCollection<E> implements Set<E>, KMappedMarker {

    public static final kotlin.collections.AbstractSet.Companion Companion;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0010\u001e\n\u0002\u0008\u0002\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u0006H\u0000¢\u0006\u0002\u0008\u0008J\u0019\u0010\t\u001a\u00020\n2\n\u0010\u0005\u001a\u0006\u0012\u0002\u0008\u00030\u000bH\u0000¢\u0006\u0002\u0008\u000c¨\u0006\r", d2 = {"Lkotlin/collections/AbstractSet$Companion;", "", "()V", "setEquals", "", "c", "", "other", "setEquals$kotlin_stdlib", "unorderedHashCode", "", "", "unorderedHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final boolean setEquals$kotlin_stdlib(Set<?> c, Set<?> other) {
            Intrinsics.checkNotNullParameter(c, "c");
            Intrinsics.checkNotNullParameter(other, "other");
            if (c.size() != other.size()) {
                return 0;
            }
            return (Collection)c.containsAll((Collection)other);
        }

        public final int unorderedHashCode$kotlin_stdlib(Collection<?> c) {
            int hashCode;
            Object next;
            int i;
            Intrinsics.checkNotNullParameter(c, "c");
            hashCode = 0;
            final Iterator iterator = c.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (next != null) {
                } else {
                }
                i = 0;
                hashCode += i;
                i = next.hashCode();
            }
            return hashCode;
        }
    }
    static {
        AbstractSet.Companion companion = new AbstractSet.Companion(0);
        AbstractSet.Companion = companion;
    }

    @Override // kotlin.collections.AbstractCollection
    public boolean equals(Object other) {
        if (other == this) {
            return 1;
        }
        if (other instanceof Set == null) {
            return 0;
        }
        return AbstractSet.Companion.setEquals$kotlin_stdlib((Set)this, (Set)other);
    }

    @Override // kotlin.collections.AbstractCollection
    public int hashCode() {
        return AbstractSet.Companion.unorderedHashCode$kotlin_stdlib((Collection)this);
    }

    public Iterator<E> iterator() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

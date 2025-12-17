package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0008\u0005\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0008\u0008J\u001d\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0008\nJ%\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0008\u000eJ%\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\u0008\u00030\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\u0008\u00030\u0012H\u0001¢\u0006\u0002\u0008\u0014J\u0019\u0010\u0015\u001a\u00020\u00062\n\u0010\u0011\u001a\u0006\u0012\u0002\u0008\u00030\u0012H\u0001¢\u0006\u0002\u0008\u0016¨\u0006\u0017", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/ListImplementation;", "", "()V", "checkElementIndex", "", "index", "", "size", "checkElementIndex$runtime_release", "checkPositionIndex", "checkPositionIndex$runtime_release", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$runtime_release", "orderedEquals", "", "c", "", "other", "orderedEquals$runtime_release", "orderedHashCode", "orderedHashCode$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ListImplementation {

    public static final int $stable;
    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation INSTANCE;
    static {
        ListImplementation listImplementation = new ListImplementation();
        ListImplementation.INSTANCE = listImplementation;
    }

    @JvmStatic
    public static final void checkElementIndex$runtime_release(int index, int size) {
        if (index < 0) {
        } else {
            if (index >= size) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("index: ").append(index).append(", size: ").append(size).toString());
        throw indexOutOfBoundsException;
    }

    @JvmStatic
    public static final void checkPositionIndex$runtime_release(int index, int size) {
        if (index < 0) {
        } else {
            if (index > size) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("index: ").append(index).append(", size: ").append(size).toString());
        throw indexOutOfBoundsException;
    }

    @JvmStatic
    public static final void checkRangeIndexes$runtime_release(int fromIndex, int toIndex, int size) {
        String str = "fromIndex: ";
        if (fromIndex < 0) {
        } else {
            if (toIndex > size) {
            } else {
                if (fromIndex > toIndex) {
                } else {
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.append(str).append(fromIndex).append(" > toIndex: ").append(toIndex).toString());
                throw illegalArgumentException;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append(str).append(fromIndex).append(", toIndex: ").append(toIndex).append(", size: ").append(size).toString());
        throw indexOutOfBoundsException;
    }

    @JvmStatic
    public static final boolean orderedEquals$runtime_release(Collection<?> c, Collection<?> other) {
        Object next;
        Object next2;
        boolean equal;
        final int i2 = 0;
        if (c.size() != other.size()) {
            return i2;
        }
        Iterator iterator2 = c.iterator();
        for (Object next : iterator2) {
        }
        return 1;
    }

    @JvmStatic
    public static final int orderedHashCode$runtime_release(Collection<?> c) {
        int hashCode;
        Object next;
        int i2;
        int i;
        hashCode = 1;
        final Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next != null) {
            } else {
            }
            i = 0;
            hashCode = i2 + i;
            i = next.hashCode();
        }
        return hashCode;
    }
}

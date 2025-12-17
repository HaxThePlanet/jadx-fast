package kotlin.enums;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractList.Companion;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0000\n\u0000\u0008\u0003\u0018\u0000*\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u00032\u0008\u0012\u0004\u0012\u0002H\u00010\u00042\u00060\u0005j\u0002`\u0006B\u0013\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008¢\u0006\u0002\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u000cH\u0096\u0002¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u000c2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u000c2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u0008\u0010\u0019\u001a\u00020\u001aH\u0002R\u0016\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\u00020\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001b", d2 = {"Lkotlin/enums/EnumEntriesList;", "T", "", "Lkotlin/enums/EnumEntries;", "Lkotlin/collections/AbstractList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "entries", "", "([Ljava/lang/Enum;)V", "[Ljava/lang/Enum;", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Enum;)Z", "get", "index", "(I)Ljava/lang/Enum;", "indexOf", "(Ljava/lang/Enum;)I", "lastIndexOf", "writeReplace", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class EnumEntriesList<T extends Enum<T>>  extends AbstractList<T> implements kotlin.enums.EnumEntries<T>, Serializable {

    private final T[] entries;
    public EnumEntriesList(T[] entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        super();
        this.entries = entries;
    }

    private final Object writeReplace() {
        EnumEntriesSerializationProxy enumEntriesSerializationProxy = new EnumEntriesSerializationProxy(this.entries);
        return enumEntriesSerializationProxy;
    }

    public boolean contains(T element) {
        int i;
        Intrinsics.checkNotNullParameter(element, "element");
        i = (Enum)ArraysKt.getOrNull(this.entries, element.ordinal()) == element ? 1 : 0;
        return i;
    }

    @Override // kotlin.collections.AbstractList
    public final boolean contains(Object element) {
        if (!element instanceof Enum) {
            return 0;
        }
        return contains((Enum)element);
    }

    public T get(int index) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(index, entries2.length);
        return this.entries[index];
    }

    @Override // kotlin.collections.AbstractList
    public Object get(int index) {
        return get(index);
    }

    @Override // kotlin.collections.AbstractList
    public int getSize() {
        return entries.length;
    }

    public int indexOf(T element) {
        int i;
        Intrinsics.checkNotNullParameter(element, "element");
        int ordinal = element.ordinal();
        i = (Enum)ArraysKt.getOrNull(this.entries, ordinal) == element ? ordinal : -1;
        return i;
    }

    @Override // kotlin.collections.AbstractList
    public final int indexOf(Object element) {
        if (!element instanceof Enum) {
            return -1;
        }
        return indexOf((Enum)element);
    }

    public int lastIndexOf(T element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return indexOf(element);
    }

    @Override // kotlin.collections.AbstractList
    public final int lastIndexOf(Object element) {
        if (!element instanceof Enum) {
            return -1;
        }
        return lastIndexOf((Enum)element);
    }
}

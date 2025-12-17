package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\u000c\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ(\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\n¨\u0006\u0016", d2 = {"Lkotlin/collections/IndexedValue;", "T", "", "index", "", "value", "(ILjava/lang/Object;)V", "getIndex", "()I", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(ILjava/lang/Object;)Lkotlin/collections/IndexedValue;", "equals", "", "other", "hashCode", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IndexedValue<T>  {

    private final int index;
    private final T value;
    public IndexedValue(int index, T value) {
        super();
        this.index = index;
        this.value = value;
    }

    public static kotlin.collections.IndexedValue copy$default(kotlin.collections.IndexedValue indexedValue, int i2, Object object3, int i4, Object object5) {
        int obj1;
        Object obj2;
        if (i4 & 1 != 0) {
            obj1 = indexedValue.index;
        }
        if (i4 &= 2 != 0) {
            obj2 = indexedValue.value;
        }
        return indexedValue.copy(obj1, obj2);
    }

    public final int component1() {
        return this.index;
    }

    public final T component2() {
        return this.value;
    }

    public final kotlin.collections.IndexedValue<T> copy(int i, T t2) {
        IndexedValue indexedValue = new IndexedValue(i, t2);
        return indexedValue;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof IndexedValue) {
            return i2;
        }
        Object obj = object;
        if (this.index != obj.index) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.value, obj.value)) {
            return i2;
        }
        return i;
    }

    public final int getIndex() {
        return this.index;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        int i;
        if (this.value == null) {
            i = 0;
        } else {
            i = this.value.hashCode();
        }
        return i3 += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("IndexedValue(index=").append(this.index).append(", value=").append(this.value).append(')').toString();
    }
}

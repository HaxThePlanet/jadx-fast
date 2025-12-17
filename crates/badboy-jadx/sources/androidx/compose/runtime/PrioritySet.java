package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000c\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0007R\u0014\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Landroidx/compose/runtime/PrioritySet;", "", "list", "", "", "(Ljava/util/List;)V", "add", "", "value", "isEmpty", "", "isNotEmpty", "peek", "takeMax", "validateHeap", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PrioritySet {

    public static final int $stable = 8;
    private final List<Integer> list;
    static {
        final int i = 8;
    }

    public PrioritySet() {
        final int i = 0;
        super(i, 1, i);
    }

    public PrioritySet(List<Integer> list) {
        super();
        this.list = list;
    }

    public PrioritySet(List list, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        ArrayList obj1;
        if (i2 &= 1 != 0) {
            obj1 = new ArrayList();
        }
        super(obj1);
    }

    public final void add(int value) {
        int intValue;
        int index;
        int i;
        List list2;
        Integer intValue2;
        List list;
        Integer valueOf;
        if (!(Collection)this.list.isEmpty() && (Number)this.list.get(0).intValue() != value && (Number)this.list.get(size--).intValue() == value) {
            if ((Number)this.list.get(0).intValue() != value) {
                if ((Number)this.list.get(size--).intValue() == value) {
                }
            }
        }
        index = this.list.size();
        this.list.add(Integer.valueOf(value));
        while (index > 0) {
            i3--;
            intValue2 = (Number)this.list.get(list2).intValue();
            if (value <= intValue2) {
                break;
            } else {
            }
            this.list.set(index, Integer.valueOf(intValue2));
            index = list2;
        }
        this.list.set(index, Integer.valueOf(value));
    }

    public final boolean isEmpty() {
        return this.list.isEmpty();
    }

    public final boolean isNotEmpty() {
        return empty ^= 1;
    }

    public final int peek() {
        return (Number)CollectionsKt.first(this.list).intValue();
    }

    public final int takeMax() {
        int i2;
        int index;
        boolean intValue;
        String $i$a$RuntimeCheckPrioritySet$takeMax$1;
        int i4;
        int intValue4;
        int i3;
        int intValue3;
        int i;
        int intValue2;
        List valueOf;
        Integer valueOf2;
        final int i5 = 0;
        final int i6 = 1;
        i2 = this.list.size() > 0 ? i6 : i5;
        index = 0;
        if (i2 == 0) {
            int i7 = 0;
            ComposerKt.composeImmediateRuntimeError("Set is empty");
        }
        int intValue5 = (Number)this.list.get(i5).intValue();
        while (!(Collection)this.list.isEmpty()) {
            if ((Number)this.list.get(i5).intValue() == intValue5) {
            }
            this.list.set(i5, CollectionsKt.last(this.list));
            this.list.remove(size2 -= i6);
            index = 0;
            while (index < size3 >>>= i6) {
                intValue4 = (Number)this.list.get(index).intValue();
                i10 -= i6;
                intValue3 = (Number)this.list.get(i3).intValue();
                i11 *= 2;
                this.list.set(index, Integer.valueOf(intValue3));
                this.list.set(i3, Integer.valueOf(intValue4));
                index = i3;
                intValue2 = (Number)this.list.get(i).intValue();
                this.list.set(index, Integer.valueOf(intValue2));
                this.list.set(i, Integer.valueOf(intValue4));
                index = i;
            }
            intValue4 = (Number)this.list.get(index).intValue();
            i10 -= i6;
            intValue3 = (Number)this.list.get(i3).intValue();
            i11 *= 2;
            if (i < this.list.size()) {
            } else {
            }
            if (intValue3 > intValue4) {
            } else {
            }
            this.list.set(index, Integer.valueOf(intValue3));
            this.list.set(i3, Integer.valueOf(intValue4));
            index = i3;
            intValue2 = (Number)this.list.get(i).intValue();
            if (intValue2 > intValue3) {
            } else {
            }
            if (intValue2 > intValue4) {
            } else {
            }
            this.list.set(index, Integer.valueOf(intValue2));
            this.list.set(i, Integer.valueOf(intValue4));
            index = i;
        }
        return intValue5;
    }

    public final void validateHeap() {
        int index;
        int i;
        int i5;
        int i4;
        int i2;
        int intValue;
        int intValue2;
        int i3;
        String str;
        int size = this.list.size();
        index = 0;
        while (index < size / 2) {
            i5 = 1;
            i9 *= 2;
            i3 = 0;
            if ((Number)this.list.get(index).intValue() >= (Number)this.list.get(i8 -= i5).intValue()) {
            } else {
            }
            intValue = i3;
            intValue2 = 0;
            str = "Check failed.";
            if (intValue == 0) {
            }
            if (i4 < size) {
            }
            i2 = 0;
            if (i5 == 0) {
            }
            index++;
            PreconditionsKt.throwIllegalStateException(str);
            if ((Number)this.list.get(index).intValue() >= (Number)this.list.get(i4).intValue()) {
            } else {
            }
            i5 = i3;
            PreconditionsKt.throwIllegalStateException(str);
            intValue = i5;
        }
    }
}

package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012<\u0010\u0005\u001a8\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\u000b\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00020\u000c0\u0006¢\u0006\u0002\u0010\rJ\u0017\u0010\u0015\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0002\u0008\u0016J\t\u0010\u0017\u001a\u00020\u0018H\u0096\u0002J\t\u0010\u0019\u001a\u00020\u0002H\u0096\u0002R\u0014\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000RD\u0010\u0005\u001a8\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\u000b\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00020\u000c0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"Landroidx/compose/foundation/layout/ContextualFlowItemIterator;", "", "Landroidx/compose/ui/layout/Measurable;", "itemCount", "", "getMeasurables", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "", "(ILkotlin/jvm/functions/Function2;)V", "_list", "", "itemIndex", "list", "getList", "()Ljava/util/List;", "listIndex", "getNext", "getNext$foundation_layout_release", "hasNext", "", "next", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContextualFlowItemIterator implements Iterator<Measurable>, KMappedMarker {

    public static final int $stable = 8;
    private final List<Measurable> _list;
    private final Function2<Integer, androidx.compose.foundation.layout.FlowLineInfo, List<Measurable>> getMeasurables;
    private final int itemCount;
    private int itemIndex;
    private int listIndex;
    static {
        final int i = 8;
    }

    public ContextualFlowItemIterator(int itemCount, Function2<? super Integer, ? super androidx.compose.foundation.layout.FlowLineInfo, ? extends List<? extends Measurable>> getMeasurables) {
        super();
        this.itemCount = itemCount;
        this.getMeasurables = getMeasurables;
        ArrayList arrayList = new ArrayList();
        this._list = (List)arrayList;
    }

    public static Measurable getNext$foundation_layout_release$default(androidx.compose.foundation.layout.ContextualFlowItemIterator contextualFlowItemIterator, androidx.compose.foundation.layout.FlowLineInfo flowLineInfo2, int i3, Object object4) {
        androidx.compose.foundation.layout.FlowLineInfo flowLineInfo;
        int i7;
        int i;
        int i2;
        int i4;
        int i5;
        int i6;
        androidx.compose.foundation.layout.FlowLineInfo obj8;
        if (i3 &= 1 != 0) {
            flowLineInfo = new FlowLineInfo(0, 0, 0, 0, 15, 0);
            obj8 = flowLineInfo;
        }
        return contextualFlowItemIterator.getNext$foundation_layout_release(obj8);
    }

    public final List<Measurable> getList() {
        return this._list;
    }

    @Override // java.util.Iterator
    public final Measurable getNext$foundation_layout_release(androidx.compose.foundation.layout.FlowLineInfo info) {
        Object measurables;
        Object first;
        int i;
        Object obj;
        if (this.listIndex < getList().size()) {
            measurables = getList().get(this.listIndex);
            this.listIndex = listIndex3++;
            return measurables;
        } else {
            if (this.itemIndex >= this.itemCount) {
            } else {
                Object invoke = this.getMeasurables.invoke(Integer.valueOf(this.itemIndex), info);
                this.itemIndex = itemIndex3++;
                if ((List)invoke.isEmpty()) {
                    measurables = first;
                } else {
                    this._list.addAll((Collection)invoke);
                    this.listIndex = listIndex4++;
                    measurables = first;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(stringBuilder.append("No item returned at index call. Index: ").append(this.itemIndex).toString());
        throw arrayIndexOutOfBoundsException;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i;
        int listIndex;
        int itemCount;
        if (this.listIndex >= getList().size()) {
            if (this.itemIndex < this.itemCount) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // java.util.Iterator
    public Measurable next() {
        int i = 0;
        return ContextualFlowItemIterator.getNext$foundation_layout_release$default(this, i, 1, i);
    }

    @Override // java.util.Iterator
    public Object next() {
        return next();
    }

    @Override // java.util.Iterator
    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

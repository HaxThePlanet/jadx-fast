package kotlin.jvm.internal;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\n\n\u0002\u0008\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0002J\u000c\u0010\u000c\u001a\u00020\u0004*\u00020\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lkotlin/jvm/internal/ShortSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", "value", "", "toArray", "getSize", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ShortSpreadBuilder extends kotlin.jvm.internal.PrimitiveSpreadBuilder<short[]> {

    private final short[] values;
    public ShortSpreadBuilder(int size) {
        super(size);
        this.values = new short[size];
    }

    @Override // kotlin.jvm.internal.PrimitiveSpreadBuilder
    public final void add(short value) {
        final int position = getPosition();
        setPosition(position + 1);
        this.values[position] = value;
    }

    @Override // kotlin.jvm.internal.PrimitiveSpreadBuilder
    public int getSize(Object $this$getSize) {
        return getSize((short[])$this$getSize);
    }

    @Override // kotlin.jvm.internal.PrimitiveSpreadBuilder
    protected int getSize(short[] $this$getSize) {
        Intrinsics.checkNotNullParameter($this$getSize, "<this>");
        return $this$getSize.length;
    }

    @Override // kotlin.jvm.internal.PrimitiveSpreadBuilder
    public final short[] toArray() {
        return (short[])toArray(this.values, new short[size()]);
    }
}

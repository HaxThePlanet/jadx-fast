package kotlin.jvm.internal;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0011\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\t\u0008&\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0008\u0010\u0003\u001a\u00020\u0004H\u0004J\u001d\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0004*\u00028\u0000H$¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\u0005R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000bX\u0082\u0004¢\u0006\n\n\u0002\u0010\u000e\u0012\u0004\u0008\u000c\u0010\r¨\u0006\u0019", d2 = {"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "T", "", "size", "", "(I)V", "position", "getPosition", "()I", "setPosition", "spreads", "", "getSpreads$annotations", "()V", "[Ljava/lang/Object;", "addSpread", "", "spreadArgument", "(Ljava/lang/Object;)V", "toArray", "values", "result", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getSize", "(Ljava/lang/Object;)I", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class PrimitiveSpreadBuilder<T>  {

    private int position;
    private final int size;
    private final T[] spreads;
    public PrimitiveSpreadBuilder(int size) {
        super();
        this.size = size;
        this.spreads = new Object[this.size];
    }

    private static void getSpreads$annotations() {
    }

    public final void addSpread(T spreadArgument) {
        Intrinsics.checkNotNullParameter(spreadArgument, "spreadArgument");
        final int position = this.position;
        this.position = position + 1;
        this.spreads[position] = spreadArgument;
    }

    protected final int getPosition() {
        return this.position;
    }

    protected abstract int getSize(T t);

    protected final void setPosition(int <set-?>) {
        this.position = <set-?>;
    }

    protected final int size() {
        int totalLength;
        int i;
        int size;
        totalLength = 0;
        final int i3 = 1;
        size2 -= i3;
        if (0 <= i2) {
        }
        return totalLength;
    }

    protected final T toArray(T values, T result) {
        int dstIndex;
        int copyValuesFrom;
        int i3;
        int i2;
        Object obj;
        int size;
        int i;
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(result, "result");
        dstIndex = 0;
        copyValuesFrom = 0;
        size3--;
        if (0 <= i4) {
        }
        if (copyValuesFrom < this.size) {
            System.arraycopy(values, copyValuesFrom, result, dstIndex, size2 -= copyValuesFrom);
        }
        return result;
    }
}

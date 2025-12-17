package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000c\u001a\u00020\rJ\u000b\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u00112\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00000\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0008\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0013", d2 = {"Landroidx/compose/ui/node/NestedVectorStack;", "T", "", "()V", "currentIndexes", "", "size", "", "vectors", "", "Landroidx/compose/runtime/collection/MutableVector;", "[Landroidx/compose/runtime/collection/MutableVector;", "isNotEmpty", "", "pop", "()Ljava/lang/Object;", "push", "", "vector", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NestedVectorStack<T>  {

    public static final int $stable = 8;
    private int[] currentIndexes;
    private int size;
    private MutableVector<T>[] vectors;
    static {
        final int i = 8;
    }

    public NestedVectorStack() {
        super();
        int i = 16;
        this.currentIndexes = new int[i];
        this.vectors = new MutableVector[i];
    }

    public final boolean isNotEmpty() {
        int size;
        int i;
        int i2;
        if (this.size > 0 && this.currentIndexes[size2 -= i2] >= 0) {
            if (this.currentIndexes[size2 -= i2] >= 0) {
            } else {
                i2 = 0;
            }
        } else {
        }
        return i2;
    }

    public final T pop() {
        int i2;
        int currentIndexes;
        int i;
        int i4 = 1;
        i2 = this.size > 0 ? i4 : 0;
        if (i2 == 0) {
        } else {
            size2 -= i4;
            int i5 = this.currentIndexes[i3];
            MutableVector mutableVector = this.vectors[i3];
            Intrinsics.checkNotNull(mutableVector);
            if (i5 > 0) {
                currentIndexes = this.currentIndexes;
                currentIndexes[i3] = i6--;
            } else {
                if (i5 == 0) {
                    this.vectors[i3] = 0;
                    this.size = size3--;
                }
            }
            int i7 = 0;
            return mutableVector.getContent()[i5];
        }
        int indexOfVector = 0;
        IllegalStateException illegalStateException = new IllegalStateException("Cannot call pop() on an empty stack. Guard with a call to isNotEmpty()".toString());
        throw illegalStateException;
    }

    public final void push(MutableVector<T> vector) {
        int copyOf;
        String str;
        int i;
        if (vector.isEmpty()) {
        }
        int size = this.size;
        if (size >= currentIndexes.length) {
            int[] copyOf2 = Arrays.copyOf(this.currentIndexes, length *= 2);
            str = "copyOf(this, newSize)";
            Intrinsics.checkNotNullExpressionValue(copyOf2, str);
            this.currentIndexes = copyOf2;
            copyOf = Arrays.copyOf(this.vectors, length2 *= 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, str);
            this.vectors = (MutableVector[])copyOf;
        }
        this.currentIndexes[size] = size3--;
        this.vectors[size] = vector;
        this.size = size2++;
    }
}

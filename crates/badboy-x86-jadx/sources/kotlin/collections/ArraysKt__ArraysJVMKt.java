package kotlin.collections;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0008\u0002\u001a/\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0010\u0006\u001a\u0018\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a#\u0010\n\u001a\u00020\u0005\"\u0004\u0008\u0000\u0010\u0002*\u000c\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0018\u00010\u0001H\u0001¢\u0006\u0004\u0008\u000b\u0010\u000c\u001a,\u0010\r\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0001\"\u0006\u0008\u0000\u0010\u0002\u0018\u0001*\u000c\u0012\u0006\u0008\u0001\u0012\u0002H\u0002\u0018\u00010\u0001H\u0086\u0008¢\u0006\u0002\u0010\u000e\u001a\u0015\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\u0008\u001a&\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\u0008\u0000\u0010\u0002\u0018\u0001*\u0008\u0012\u0004\u0012\u0002H\u00020\u0015H\u0086\u0008¢\u0006\u0002\u0010\u0016¨\u0006\u0017", d2 = {"arrayOfNulls", "", "T", "reference", "size", "", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfRangeToIndexCheck", "", "toIndex", "contentDeepHashCodeImpl", "contentDeepHashCode", "([Ljava/lang/Object;)I", "orEmpty", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "", "charset", "Ljava/nio/charset/Charset;", "toTypedArray", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
class ArraysKt__ArraysJVMKt {
    public static final <T> T[] arrayOfNulls(T[] reference, int size) {
        Intrinsics.checkNotNullParameter(reference, "reference");
        Object instance = Array.newInstance(reference.getClass().getComponentType(), size);
        Intrinsics.checkNotNull(instance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (Object[])instance;
    }

    public static final <T> int contentDeepHashCode(T[] $this$contentDeepHashCodeImpl) {
        return Arrays.deepHashCode($this$contentDeepHashCodeImpl);
    }

    public static final void copyOfRangeToIndexCheck(int toIndex, int size) {
        if (toIndex > size) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("toIndex (").append(toIndex).append(") is greater than size (").append(size).append(").").toString());
        throw indexOutOfBoundsException;
    }

    public static final <T> T[] orEmpty(T[] $this$orEmpty) {
        Object[] arr;
        int i;
        final int i2 = 0;
        if ($this$orEmpty == null) {
            i = 0;
            Intrinsics.reifiedOperationMarker(i, "T");
            arr = new Object[i];
        } else {
            arr = $this$orEmpty;
        }
        return arr;
    }

    private static final String toString(byte[] $this$toString, Charset charset) {
        Intrinsics.checkNotNullParameter($this$toString, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String string = new String($this$toString, charset);
        return string;
    }

    public static final <T> T[] toTypedArray(Collection<? extends T> $this$toTypedArray) {
        Intrinsics.checkNotNullParameter($this$toTypedArray, "<this>");
        int i = 0;
        final int i2 = 0;
        Intrinsics.reifiedOperationMarker(i2, "T?");
        return (Collection)$this$toTypedArray.toArray(new Object[i2]);
    }
}

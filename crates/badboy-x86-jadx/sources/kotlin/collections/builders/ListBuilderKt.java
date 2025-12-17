package kotlin.collections.builders;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\u0008\u0002\u001a!\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001a+\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0001\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\u0008\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\t\u001a%\u0010\n\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000c\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\r\u001a-\u0010\u000e\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0011\u001a9\u0010\u0012\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\n\u0010\u0016\u001a\u0006\u0012\u0002\u0008\u00030\u0017H\u0002¢\u0006\u0002\u0010\u0018\u001a-\u0010\u0019\u001a\u00020\u0004\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u001a\u001a=\u0010\u001b\u001a\u00020\u001c\"\u0004\u0008\u0000\u0010\u0007*\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u001eH\u0002¢\u0006\u0002\u0010\u001f¨\u0006 ", d2 = {"arrayOfUninitializedElements", "", "E", "size", "", "(I)[Ljava/lang/Object;", "copyOfUninitializedElements", "T", "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "resetAt", "", "index", "([Ljava/lang/Object;I)V", "resetRange", "fromIndex", "toIndex", "([Ljava/lang/Object;II)V", "subarrayContentEquals", "", "offset", "length", "other", "", "([Ljava/lang/Object;IILjava/util/List;)Z", "subarrayContentHashCode", "([Ljava/lang/Object;II)I", "subarrayContentToString", "", "thisCollection", "", "([Ljava/lang/Object;IILjava/util/Collection;)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ListBuilderKt {
    public static final boolean access$subarrayContentEquals(Object[] $receiver, int offset, int length, List other) {
        return ListBuilderKt.subarrayContentEquals($receiver, offset, length, other);
    }

    public static final int access$subarrayContentHashCode(Object[] $receiver, int offset, int length) {
        return ListBuilderKt.subarrayContentHashCode($receiver, offset, length);
    }

    public static final String access$subarrayContentToString(Object[] $receiver, int offset, int length, Collection thisCollection) {
        return ListBuilderKt.subarrayContentToString($receiver, offset, length, thisCollection);
    }

    public static final <E> E[] arrayOfUninitializedElements(int size) {
        int i;
        i = size >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            return new Object[size];
        }
        int i2 = 0;
        IllegalArgumentException $i$a$RequireListBuilderKt$arrayOfUninitializedElements$1 = new IllegalArgumentException("capacity must be non-negative.".toString());
        throw $i$a$RequireListBuilderKt$arrayOfUninitializedElements$1;
    }

    public static final <T> T[] copyOfUninitializedElements(T[] $this$copyOfUninitializedElements, int newSize) {
        Intrinsics.checkNotNullParameter($this$copyOfUninitializedElements, "<this>");
        Object[] copyOf = Arrays.copyOf($this$copyOfUninitializedElements, newSize);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static final <E> void resetAt(E[] $this$resetAt, int index) {
        Intrinsics.checkNotNullParameter($this$resetAt, "<this>");
        $this$resetAt[index] = 0;
    }

    public static final <E> void resetRange(E[] $this$resetRange, int fromIndex, int toIndex) {
        int index;
        Intrinsics.checkNotNullParameter($this$resetRange, "<this>");
        index = fromIndex;
        while (index < toIndex) {
            ListBuilderKt.resetAt($this$resetRange, index);
            index++;
        }
    }

    private static final <T> boolean subarrayContentEquals(T[] $this$subarrayContentEquals, int offset, int length, List<?> other) {
        int i;
        boolean equal;
        Object obj;
        int i2 = 0;
        if (length != other.size()) {
            return i2;
        }
        i = 0;
        while (i < length) {
            i++;
        }
        return 1;
    }

    private static final <T> int subarrayContentHashCode(T[] $this$subarrayContentHashCode, int offset, int length) {
        int result;
        int i3;
        Object obj;
        int i2;
        int i;
        result = 1;
        i3 = 0;
        while (i3 < length) {
            obj = $this$subarrayContentHashCode[offset + i3];
            if (obj != null) {
            } else {
            }
            i = 0;
            result = i2 + i;
            i3++;
            i = obj.hashCode();
        }
        return result;
    }

    private static final <T> String subarrayContentToString(T[] $this$subarrayContentToString, int offset, int length, Collection<? extends T> thisCollection) {
        int i;
        Object str2;
        String str;
        StringBuilder stringBuilder = new StringBuilder(i2 += 2);
        stringBuilder.append("[");
        i = 0;
        while (i < length) {
            if (i > 0) {
            }
            str2 = $this$subarrayContentToString[offset + i];
            if (str2 == thisCollection) {
            } else {
            }
            stringBuilder.append(str2);
            i++;
            stringBuilder.append("(this Collection)");
            stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}

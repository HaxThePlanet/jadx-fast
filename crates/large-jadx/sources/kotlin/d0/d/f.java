package kotlin.d0.d;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u001e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u0008H\u0007¢\u0006\u0004\u0008\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u00082\u0010\u0010\u000b\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007¢\u0006\u0004\u0008\t\u0010\u000c\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u00082\u0014\u0010\u000e\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\u0082\u0008¢\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
public final class f {

    private static final Object[] a;
    static {
        f.a = new Object[0];
    }

    public static final Object[] a(Collection<?> collection) {
        int copyOf;
        boolean next;
        int i;
        int i2;
        int i3;
        Object next2;
        Object obj4;
        n.f(collection, "collection");
        copyOf = collection.size();
        if (copyOf == 0) {
            obj4 = f.a;
            return obj4;
        } else {
        }
        obj4 = new OutOfMemoryError();
        throw obj4;
    }

    public static final Object[] b(Collection<?> collection, Object[] object2Arr2) {
        Object copyOf;
        int next;
        int i;
        int length;
        Object next2;
        String obj5;
        Object[] obj6;
        n.f(collection, "collection");
        Objects.requireNonNull(object2Arr2);
        copyOf = collection.size();
        final int i2 = 0;
        next = 0;
        if (copyOf == 0) {
            if (object2Arr2.length > 0) {
                object2Arr2[next] = i2;
            }
            return obj6;
        } else {
            obj5 = collection.iterator();
            if (!obj5.hasNext()) {
                if (object2Arr2.length > 0) {
                    object2Arr2[next] = i2;
                }
            } else {
                if (copyOf <= object2Arr2.length) {
                    copyOf = object2Arr2;
                } else {
                    Objects.requireNonNull(Array.newInstance(object2Arr2.getClass().getComponentType(), copyOf), "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                }
                length = next + 1;
                copyOf[next] = obj5.next();
                while (length >= copyOf.length) {
                    next2 = 2147483645;
                    n.e(Arrays.copyOf(copyOf, i), "Arrays.copyOf(result, newSize)");
                    next = length;
                    length = next + 1;
                    copyOf[next] = obj5.next();
                    i = next2;
                }
                obj6 = copyOf;
            }
        }
        obj5 = new OutOfMemoryError();
        throw obj5;
    }
}

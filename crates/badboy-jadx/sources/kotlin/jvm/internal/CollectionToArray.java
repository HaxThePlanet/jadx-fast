package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u001e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u0008H\u0007¢\u0006\u0004\u0008\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u00082\u0010\u0010\u000b\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007¢\u0006\u0004\u0008\t\u0010\u000c\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u00082\u0014\u0010\u000e\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\u0082\u0008¢\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CollectionToArray {

    private static final Object[] EMPTY = null;
    private static final int MAX_SIZE = 2147483645;
    static {
        CollectionToArray.EMPTY = new Object[0];
    }

    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(warningSince = "1.9")
    public static final Object[] toArray(Collection<?> collection) {
        Object[] $i$a$ToArrayImplCollectionToArray$collectionToArray$1;
        Object[] $i$a$ToArrayImplCollectionToArray$collectionToArray$12;
        boolean next;
        int newSize$iv;
        int newSize$iv2;
        int i;
        String str;
        int copyOf2;
        int i2;
        Object[] copyOf;
        Intrinsics.checkNotNullParameter(collection, "collection");
        int i3 = 0;
        final int size = collection.size();
        if (size == 0) {
            int i4 = 0;
            $i$a$ToArrayImplCollectionToArray$collectionToArray$1 = CollectionToArray.EMPTY;
            return $i$a$ToArrayImplCollectionToArray$collectionToArray$1;
        } else {
            Iterator iterator = collection.iterator();
            if (!iterator.hasNext()) {
                int i5 = 0;
                $i$a$ToArrayImplCollectionToArray$collectionToArray$1 = $i$a$ToArrayImplCollectionToArray$collectionToArray$12;
            } else {
                int i7 = 0;
                $i$a$ToArrayImplCollectionToArray$collectionToArray$12 = new Object[size];
                newSize$iv = 0;
                i = newSize$iv + 1;
                $i$a$ToArrayImplCollectionToArray$collectionToArray$12[newSize$iv] = iterator.next();
                str = "copyOf(...)";
                while (i >= $i$a$ToArrayImplCollectionToArray$collectionToArray$12.length) {
                    copyOf2 = Arrays.copyOf($i$a$ToArrayImplCollectionToArray$collectionToArray$12, newSize$iv2);
                    Intrinsics.checkNotNullExpressionValue(copyOf2, str);
                    $i$a$ToArrayImplCollectionToArray$collectionToArray$12 = copyOf2;
                    newSize$iv = i;
                    i = newSize$iv + 1;
                    $i$a$ToArrayImplCollectionToArray$collectionToArray$12[newSize$iv] = iterator.next();
                    str = "copyOf(...)";
                    newSize$iv = i;
                    newSize$iv2 = 2147483645;
                }
                $i$a$ToArrayImplCollectionToArray$collectionToArray$1 = $i$a$ToArrayImplCollectionToArray$collectionToArray$12;
            }
        }
        OutOfMemoryError outOfMemoryError = new OutOfMemoryError();
        throw outOfMemoryError;
    }

    @Deprecated(message = "This function will be made internal in a future release")
    @DeprecatedSinceKotlin(warningSince = "1.9")
    public static final Object[] toArray(Collection<?> collection, Object[] a) {
        int newSize$iv2;
        int newSize$iv;
        int next;
        Object[] copyOf2;
        int iterator;
        int length;
        int length2;
        Object result$iv;
        String str;
        int copyOf;
        int i;
        Intrinsics.checkNotNullParameter(collection, "collection");
        if (a == null) {
        } else {
            int i2 = 0;
            final int size = collection.size();
            next = 0;
            copyOf2 = 0;
            if (size == 0) {
                iterator = 0;
                if (a.length > 0) {
                    a[next] = copyOf2;
                }
                result$iv = a;
                return result$iv;
            } else {
                iterator = collection.iterator();
                if (!iterator.hasNext()) {
                    length = 0;
                    if (a.length > 0) {
                        a[next] = copyOf2;
                    }
                } else {
                    int i3 = size;
                    length = 0;
                    if (i3 <= a.length) {
                        result$iv = a;
                    } else {
                        Intrinsics.checkNotNull(Array.newInstance(a.getClass().getComponentType(), i3), "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    }
                    newSize$iv2 = 0;
                    length = newSize$iv2 + 1;
                    result$iv[newSize$iv2] = iterator.next();
                    str = "copyOf(...)";
                    while (length >= result$iv.length) {
                        copyOf = Arrays.copyOf(result$iv, newSize$iv);
                        Intrinsics.checkNotNullExpressionValue(copyOf, str);
                        result$iv = copyOf;
                        newSize$iv2 = length;
                        length = newSize$iv2 + 1;
                        result$iv[newSize$iv2] = iterator.next();
                        str = "copyOf(...)";
                        newSize$iv2 = length;
                        newSize$iv = 2147483645;
                    }
                }
            }
            OutOfMemoryError outOfMemoryError = new OutOfMemoryError();
            throw outOfMemoryError;
        }
        NullPointerException $i$f$toArrayImpl = new NullPointerException();
        throw $i$f$toArrayImpl;
    }

    private static final Object[] toArrayImpl(Collection<?> collection, Function0<Object[]> empty, Function1<? super Integer, Object[]> alloc, Function2<? super Object[], ? super Integer, Object[]> trim) {
        Object result;
        int newSize2;
        int newSize;
        int i;
        Object[] copyOf;
        String str;
        final int i2 = 0;
        final int size = collection.size();
        if (size == 0) {
            return (Object[])empty.invoke();
        }
        Iterator iterator = collection.iterator();
        if (!iterator.hasNext()) {
            return (Object[])empty.invoke();
        }
        result = alloc.invoke(Integer.valueOf(size));
        newSize2 = 0;
        i = newSize2 + 1;
        result[newSize2] = iterator.next();
        while (i >= result.length) {
            copyOf = Arrays.copyOf(result, newSize);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            result = copyOf;
            newSize2 = i;
            i = newSize2 + 1;
            result[newSize2] = iterator.next();
            newSize2 = i;
            newSize = 2147483645;
        }
        return result;
    }
}

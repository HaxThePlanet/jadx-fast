package androidx.collection;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005H\u0080\u0008¢\u0006\u0002\u0008\u0006¨\u0006\u0007", d2 = {"Landroidx/collection/CollectionPlatformUtils;", "", "()V", "createIndexOutOfBoundsException", "Ljava/lang/IndexOutOfBoundsException;", "Lkotlin/IndexOutOfBoundsException;", "createIndexOutOfBoundsException$collection", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CollectionPlatformUtils {

    public static final androidx.collection.CollectionPlatformUtils INSTANCE;
    static {
        CollectionPlatformUtils collectionPlatformUtils = new CollectionPlatformUtils();
        CollectionPlatformUtils.INSTANCE = collectionPlatformUtils;
    }

    public final java.lang.IndexOutOfBoundsException createIndexOutOfBoundsException$collection() {
        final int i = 0;
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        return (IndexOutOfBoundsException)arrayIndexOutOfBoundsException;
    }
}

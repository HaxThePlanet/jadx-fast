package kotlinx.serialization.internal;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010(\n\u0002\u0008\u0002\u0008!\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u000e\u0008\u0001\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00010\u0003*\u0004\u0008\u0002\u0010\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0005B\u0015\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\u0008\u0008\u0010\tJ\u0011\u0010\n\u001a\u00020\u000b*\u00028\u0001H\u0014¢\u0006\u0002\u0010\u000cJ\u0017\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000e*\u00028\u0001H\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0010", d2 = {"Lkotlinx/serialization/internal/CollectionSerializer;", "E", "C", "", "B", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "element", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "collectionSize", "", "(Ljava/util/Collection;)I", "collectionIterator", "", "(Ljava/util/Collection;)Ljava/util/Iterator;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class CollectionSerializer<E, C extends Collection<? extends E>, B>  extends kotlinx.serialization.internal.CollectionLikeSerializer<E, C, B> {
    public CollectionSerializer(KSerializer<E> element) {
        Intrinsics.checkNotNullParameter(element, "element");
        super(element, 0);
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public Iterator collectionIterator(Object $this$collectionIterator) {
        return collectionIterator((Collection)$this$collectionIterator);
    }

    protected Iterator<E> collectionIterator(C $this$collectionIterator) {
        Intrinsics.checkNotNullParameter($this$collectionIterator, "<this>");
        return $this$collectionIterator.iterator();
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public int collectionSize(Object $this$collectionSize) {
        return collectionSize((Collection)$this$collectionSize);
    }

    protected int collectionSize(C $this$collectionSize) {
        Intrinsics.checkNotNullParameter($this$collectionSize, "<this>");
        return $this$collectionSize.size();
    }
}

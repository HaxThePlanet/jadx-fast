package kotlinx.serialization.internal;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0008\u0001\u0018\u0000*\u0004\u0008\u0000\u0010\u00012*\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00010\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00010\u0004j\u0008\u0012\u0004\u0012\u0002H\u0001`\u00050\u0002B\u0015\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\u0008\u0008\u0010\tJ\u0018\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\u0008\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J\u001c\u0010\u000f\u001a\u00020\u0010*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\u0008\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J\"\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\u0008\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J\"\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\u0008\u0012\u0004\u0012\u00028\u0000`\u0005*\u0008\u0012\u0004\u0012\u00028\u00000\u0003H\u0014J$\u0010\u0013\u001a\u00020\u0014*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\u0008\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0015\u001a\u00020\u0010H\u0014J1\u0010\u0016\u001a\u00020\u0014*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\u0008\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0019R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u001a", d2 = {"Lkotlinx/serialization/internal/LinkedHashSetSerializer;", "E", "Lkotlinx/serialization/internal/CollectionSerializer;", "", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "eSerializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builder", "builderSize", "", "toResult", "toBuilder", "checkCapacity", "", "size", "insert", "index", "element", "(Ljava/util/LinkedHashSet;ILjava/lang/Object;)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LinkedHashSetSerializer<E>  extends kotlinx.serialization.internal.CollectionSerializer<E, Set<? extends E>, LinkedHashSet<E>> {

    private final SerialDescriptor descriptor;
    public LinkedHashSetSerializer(KSerializer<E> eSerializer) {
        Intrinsics.checkNotNullParameter(eSerializer, "eSerializer");
        super(eSerializer);
        LinkedHashSetClassDesc linkedHashSetClassDesc = new LinkedHashSetClassDesc(eSerializer.getDescriptor());
        this.descriptor = (SerialDescriptor)linkedHashSetClassDesc;
    }

    @Override // kotlinx.serialization.internal.CollectionSerializer
    public Object builder() {
        return builder();
    }

    protected LinkedHashSet<E> builder() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        return linkedHashSet;
    }

    @Override // kotlinx.serialization.internal.CollectionSerializer
    public int builderSize(Object $this$builderSize) {
        return builderSize((LinkedHashSet)$this$builderSize);
    }

    protected int builderSize(LinkedHashSet<E> $this$builderSize) {
        Intrinsics.checkNotNullParameter($this$builderSize, "<this>");
        return $this$builderSize.size();
    }

    @Override // kotlinx.serialization.internal.CollectionSerializer
    public void checkCapacity(Object $this$checkCapacity, int size) {
        checkCapacity((LinkedHashSet)$this$checkCapacity, size);
    }

    protected void checkCapacity(LinkedHashSet<E> $this$checkCapacity, int size) {
        Intrinsics.checkNotNullParameter($this$checkCapacity, "<this>");
    }

    @Override // kotlinx.serialization.internal.CollectionSerializer
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.internal.CollectionSerializer
    public void insert(Object $this$insert, int index, Object element) {
        insert((LinkedHashSet)$this$insert, index, element);
    }

    protected void insert(LinkedHashSet<E> $this$insert, int index, E element) {
        Intrinsics.checkNotNullParameter($this$insert, "<this>");
        $this$insert.add(element);
    }

    @Override // kotlinx.serialization.internal.CollectionSerializer
    public Object toBuilder(Object $this$toBuilder) {
        return toBuilder((Set)$this$toBuilder);
    }

    protected LinkedHashSet<E> toBuilder(Set<? extends E> $this$toBuilder) {
        Object linkedHashSet;
        Object obj;
        Intrinsics.checkNotNullParameter($this$toBuilder, "<this>");
        if ($this$toBuilder instanceof LinkedHashSet != null) {
            linkedHashSet = $this$toBuilder;
        } else {
            linkedHashSet = 0;
        }
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet((Collection)$this$toBuilder);
        }
        return linkedHashSet;
    }

    @Override // kotlinx.serialization.internal.CollectionSerializer
    public Object toResult(Object $this$toResult) {
        return toResult((LinkedHashSet)$this$toResult);
    }

    protected Set<E> toResult(LinkedHashSet<E> $this$toResult) {
        Intrinsics.checkNotNullParameter($this$toResult, "<this>");
        return (Set)$this$toResult;
    }
}

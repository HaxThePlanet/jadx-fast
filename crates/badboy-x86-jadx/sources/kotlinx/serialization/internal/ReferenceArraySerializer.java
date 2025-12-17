package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010(\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0008\u0001\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\n\u0008\u0001\u0010\u0003*\u0004\u0018\u0001H\u00012*\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00030\u0006j\u0008\u0012\u0004\u0012\u0002H\u0003`\u00070\u0004B#\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\t\u0012\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0004\u0008\u000c\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u0013*\u0008\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0016*\u0008\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\u0008\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014J\u001c\u0010\u0019\u001a\u00020\u0013*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\u0008\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014J'\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0005*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\u0008\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014¢\u0006\u0002\u0010\u001bJ'\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\u0008\u0012\u0004\u0012\u00028\u0001`\u0007*\u0008\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0002\u0010\u001dJ$\u0010\u001e\u001a\u00020\u001f*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\u0008\u0012\u0004\u0012\u00028\u0001`\u00072\u0006\u0010 \u001a\u00020\u0013H\u0014J1\u0010!\u001a\u00020\u001f*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\u0008\u0012\u0004\u0012\u00028\u0001`\u00072\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010$R\u0014\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006%", d2 = {"Lkotlinx/serialization/internal/ReferenceArraySerializer;", "ElementKlass", "", "Element", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "kClass", "Lkotlin/reflect/KClass;", "eSerializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "collectionSize", "", "([Ljava/lang/Object;)I", "collectionIterator", "", "([Ljava/lang/Object;)Ljava/util/Iterator;", "builder", "builderSize", "toResult", "(Ljava/util/ArrayList;)[Ljava/lang/Object;", "toBuilder", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "checkCapacity", "", "size", "insert", "index", "element", "(Ljava/util/ArrayList;ILjava/lang/Object;)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ReferenceArraySerializer<ElementKlass, Element extends ElementKlass>  extends kotlinx.serialization.internal.CollectionLikeSerializer<Element, Element[], ArrayList<Element>> {

    private final SerialDescriptor descriptor;
    private final KClass<ElementKlass> kClass;
    public ReferenceArraySerializer(KClass<ElementKlass> kClass, KSerializer<Element> eSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(eSerializer, "eSerializer");
        super(eSerializer, 0);
        this.kClass = kClass;
        ArrayClassDesc arrayClassDesc = new ArrayClassDesc(eSerializer.getDescriptor());
        this.descriptor = (SerialDescriptor)arrayClassDesc;
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public Object builder() {
        return builder();
    }

    protected ArrayList<Element> builder() {
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public int builderSize(Object $this$builderSize) {
        return builderSize((ArrayList)$this$builderSize);
    }

    protected int builderSize(ArrayList<Element> $this$builderSize) {
        Intrinsics.checkNotNullParameter($this$builderSize, "<this>");
        return $this$builderSize.size();
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public void checkCapacity(Object $this$checkCapacity, int size) {
        checkCapacity((ArrayList)$this$checkCapacity, size);
    }

    protected void checkCapacity(ArrayList<Element> $this$checkCapacity, int size) {
        Intrinsics.checkNotNullParameter($this$checkCapacity, "<this>");
        $this$checkCapacity.ensureCapacity(size);
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public Iterator collectionIterator(Object $this$collectionIterator) {
        return collectionIterator((Object[])$this$collectionIterator);
    }

    protected Iterator<Element> collectionIterator(Element[] $this$collectionIterator) {
        Intrinsics.checkNotNullParameter($this$collectionIterator, "<this>");
        return ArrayIteratorKt.iterator($this$collectionIterator);
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public int collectionSize(Object $this$collectionSize) {
        return collectionSize((Object[])$this$collectionSize);
    }

    protected int collectionSize(Element[] $this$collectionSize) {
        Intrinsics.checkNotNullParameter($this$collectionSize, "<this>");
        return $this$collectionSize.length;
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public void insert(Object $this$insert, int index, Object element) {
        insert((ArrayList)$this$insert, index, element);
    }

    protected void insert(ArrayList<Element> $this$insert, int index, Element element) {
        Intrinsics.checkNotNullParameter($this$insert, "<this>");
        $this$insert.add(index, element);
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public Object toBuilder(Object $this$toBuilder) {
        return toBuilder((Object[])$this$toBuilder);
    }

    protected ArrayList<Element> toBuilder(Element[] $this$toBuilder) {
        Intrinsics.checkNotNullParameter($this$toBuilder, "<this>");
        ArrayList arrayList = new ArrayList((Collection)ArraysKt.asList($this$toBuilder));
        return arrayList;
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public Object toResult(Object $this$toResult) {
        return toResult((ArrayList)$this$toResult);
    }

    protected Element[] toResult(ArrayList<Element> $this$toResult) {
        Intrinsics.checkNotNullParameter($this$toResult, "<this>");
        return PlatformKt.toNativeArrayImpl($this$toResult, this.kClass);
    }
}

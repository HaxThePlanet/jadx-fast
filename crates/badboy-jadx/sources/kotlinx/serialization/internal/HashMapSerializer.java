package kotlinx.serialization.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010(\n\u0002\u0010&\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0008\u0001\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022B\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004\u0012 \u0012\u001e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005j\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002`\u00060\u0003B#\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0008\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0008¢\u0006\u0004\u0008\n\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u0011*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014J*\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140\u0013*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014J$\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014J(\u0010\u0016\u001a\u00020\u0011*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014J4\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014J4\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0014J0\u0010\u0019\u001a\u00020\u001a*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00062\u0006\u0010\u001b\u001a\u00020\u0011H\u0014JE\u0010\u001c\u001a\u00020\u001a*\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00062\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010 R\u0014\u0010\u000c\u001a\u00020\rX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006!", d2 = {"Lkotlinx/serialization/internal/HashMapSerializer;", "K", "V", "Lkotlinx/serialization/internal/MapLikeSerializer;", "", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "kSerializer", "Lkotlinx/serialization/KSerializer;", "vSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "collectionSize", "", "collectionIterator", "", "", "builder", "builderSize", "toResult", "toBuilder", "checkCapacity", "", "size", "insertKeyValuePair", "index", "key", "value", "(Ljava/util/HashMap;ILjava/lang/Object;Ljava/lang/Object;)V", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HashMapSerializer<K, V>  extends kotlinx.serialization.internal.MapLikeSerializer<K, V, Map<K, ? extends V>, HashMap<K, V>> {

    private final SerialDescriptor descriptor;
    public HashMapSerializer(KSerializer<K> kSerializer, KSerializer<V> vSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "kSerializer");
        Intrinsics.checkNotNullParameter(vSerializer, "vSerializer");
        super(kSerializer, vSerializer, 0);
        HashMapClassDesc hashMapClassDesc = new HashMapClassDesc(kSerializer.getDescriptor(), vSerializer.getDescriptor());
        this.descriptor = (SerialDescriptor)hashMapClassDesc;
    }

    @Override // kotlinx.serialization.internal.MapLikeSerializer
    public Object builder() {
        return builder();
    }

    protected HashMap<K, V> builder() {
        HashMap hashMap = new HashMap();
        return hashMap;
    }

    @Override // kotlinx.serialization.internal.MapLikeSerializer
    public int builderSize(Object $this$builderSize) {
        return builderSize((HashMap)$this$builderSize);
    }

    protected int builderSize(HashMap<K, V> $this$builderSize) {
        Intrinsics.checkNotNullParameter($this$builderSize, "<this>");
        return size *= 2;
    }

    @Override // kotlinx.serialization.internal.MapLikeSerializer
    public void checkCapacity(Object $this$checkCapacity, int size) {
        checkCapacity((HashMap)$this$checkCapacity, size);
    }

    protected void checkCapacity(HashMap<K, V> $this$checkCapacity, int size) {
        Intrinsics.checkNotNullParameter($this$checkCapacity, "<this>");
    }

    @Override // kotlinx.serialization.internal.MapLikeSerializer
    public Iterator collectionIterator(Object $this$collectionIterator) {
        return collectionIterator((Map)$this$collectionIterator);
    }

    protected Iterator<Map.Entry<K, V>> collectionIterator(Map<K, ? extends V> $this$collectionIterator) {
        Intrinsics.checkNotNullParameter($this$collectionIterator, "<this>");
        return $this$collectionIterator.entrySet().iterator();
    }

    @Override // kotlinx.serialization.internal.MapLikeSerializer
    public int collectionSize(Object $this$collectionSize) {
        return collectionSize((Map)$this$collectionSize);
    }

    protected int collectionSize(Map<K, ? extends V> $this$collectionSize) {
        Intrinsics.checkNotNullParameter($this$collectionSize, "<this>");
        return $this$collectionSize.size();
    }

    @Override // kotlinx.serialization.internal.MapLikeSerializer
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    protected void insertKeyValuePair(HashMap<K, V> $this$insertKeyValuePair, int index, K key, V value) {
        Intrinsics.checkNotNullParameter($this$insertKeyValuePair, "<this>");
        (Map)$this$insertKeyValuePair.put(key, value);
    }

    @Override // kotlinx.serialization.internal.MapLikeSerializer
    public void insertKeyValuePair(Map $this$insertKeyValuePair, int index, Object key, Object value) {
        insertKeyValuePair((HashMap)$this$insertKeyValuePair, index, key, value);
    }

    @Override // kotlinx.serialization.internal.MapLikeSerializer
    public Object toBuilder(Object $this$toBuilder) {
        return toBuilder((Map)$this$toBuilder);
    }

    protected HashMap<K, V> toBuilder(Map<K, ? extends V> $this$toBuilder) {
        Object hashMap;
        Intrinsics.checkNotNullParameter($this$toBuilder, "<this>");
        if ($this$toBuilder instanceof HashMap != null) {
            hashMap = $this$toBuilder;
        } else {
            hashMap = 0;
        }
        if (hashMap == null) {
            hashMap = new HashMap($this$toBuilder);
        }
        return hashMap;
    }

    @Override // kotlinx.serialization.internal.MapLikeSerializer
    public Object toResult(Object $this$toResult) {
        return toResult((HashMap)$this$toResult);
    }

    protected Map<K, V> toResult(HashMap<K, V> $this$toResult) {
        Intrinsics.checkNotNullParameter($this$toResult, "<this>");
        return (Map)$this$toResult;
    }
}

package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0001\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B#\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\u0008\u0008\u0010\tJ)\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u0014R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR$\u0010\u000e\u001a\u00028\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R$\u0010\u0011\u001a\u00028\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0010¨\u0006\u0015", d2 = {"Lkotlinx/serialization/internal/PairSerializer;", "K", "V", "Lkotlinx/serialization/internal/KeyValueSerializer;", "Lkotlin/Pair;", "keySerializer", "Lkotlinx/serialization/KSerializer;", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "key", "getKey", "(Lkotlin/Pair;)Ljava/lang/Object;", "value", "getValue", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PairSerializer<K, V>  extends kotlinx.serialization.internal.KeyValueSerializer<K, V, Pair<? extends K, ? extends V>> {

    private final SerialDescriptor descriptor;
    public static Unit $r8$lambda$PyYh3K_WyfkMELTGMAMFhINXUbo(KSerializer kSerializer, KSerializer kSerializer2, ClassSerialDescriptorBuilder classSerialDescriptorBuilder3) {
        return PairSerializer.descriptor$lambda$0(kSerializer, kSerializer2, classSerialDescriptorBuilder3);
    }

    public PairSerializer(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        Intrinsics.checkNotNullParameter(keySerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(valueSerializer, "valueSerializer");
        super(keySerializer, valueSerializer, 0);
        PairSerializer$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new PairSerializer$$ExternalSyntheticLambda0(keySerializer, valueSerializer);
        this.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlin.Pair", new SerialDescriptor[0], externalSyntheticLambda0);
    }

    private static final Unit descriptor$lambda$0(KSerializer $keySerializer, KSerializer $valueSerializer, ClassSerialDescriptorBuilder $this$buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter($this$buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        final int i3 = 12;
        final int i4 = 0;
        final int i = 0;
        final int i2 = 0;
        final Object obj = $this$buildClassSerialDescriptor;
        ClassSerialDescriptorBuilder.element$default(obj, "first", $keySerializer.getDescriptor(), i, i2, i3, i4);
        ClassSerialDescriptorBuilder.element$default(obj, "second", $valueSerializer.getDescriptor(), i, i2, i3, i4);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public Object getKey(Object $this$getKey) {
        return getKey((Pair)$this$getKey);
    }

    protected K getKey(Pair<? extends K, ? extends V> $this$key) {
        Intrinsics.checkNotNullParameter($this$key, "<this>");
        return $this$key.getFirst();
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public Object getValue(Object $this$getValue) {
        return getValue((Pair)$this$getValue);
    }

    protected V getValue(Pair<? extends K, ? extends V> $this$value) {
        Intrinsics.checkNotNullParameter($this$value, "<this>");
        return $this$value.getSecond();
    }

    @Override // kotlinx.serialization.internal.KeyValueSerializer
    public Object toResult(Object key, Object value) {
        return toResult(key, value);
    }

    protected Pair<K, V> toResult(K key, V value) {
        return TuplesKt.to(key, value);
    }
}

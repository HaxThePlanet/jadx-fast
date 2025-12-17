package kotlinx.serialization.builtins;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.UByte;
import kotlin.UByte.Companion;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UInt.Companion;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULong.Companion;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShort.Companion;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.time.Duration;
import kotlin.time.Duration.Companion;
import kotlin.uuid.Uuid;
import kotlin.uuid.Uuid.Companion;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanArraySerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ByteArraySerializer;
import kotlinx.serialization.internal.ByteSerializer;
import kotlinx.serialization.internal.CharArraySerializer;
import kotlinx.serialization.internal.CharSerializer;
import kotlinx.serialization.internal.DoubleArraySerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.DurationSerializer;
import kotlinx.serialization.internal.FloatArraySerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.IntArraySerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.LongArraySerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.MapEntrySerializer;
import kotlinx.serialization.internal.NothingSerializer;
import kotlinx.serialization.internal.NullableSerializer;
import kotlinx.serialization.internal.PairSerializer;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.ShortArraySerializer;
import kotlinx.serialization.internal.ShortSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.TripleSerializer;
import kotlinx.serialization.internal.UByteArraySerializer;
import kotlinx.serialization.internal.UByteSerializer;
import kotlinx.serialization.internal.UIntArraySerializer;
import kotlinx.serialization.internal.UIntSerializer;
import kotlinx.serialization.internal.ULongArraySerializer;
import kotlinx.serialization.internal.ULongSerializer;
import kotlinx.serialization.internal.UShortArraySerializer;
import kotlinx.serialization.internal.UShortSerializer;
import kotlinx.serialization.internal.UnitSerializer;
import kotlinx.serialization.internal.UuidSerializer;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0096\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\u001a@\u0010\u0008\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0\t0\u0001\"\u0004\u0008\u0000\u0010\n\"\u0004\u0008\u0001\u0010\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u00012\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u0001\u001a@\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0\u000f0\u0001\"\u0004\u0008\u0000\u0010\n\"\u0004\u0008\u0001\u0010\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u00012\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u0001\u001aZ\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00140\u00110\u0001\"\u0004\u0008\u0000\u0010\u0012\"\u0004\u0008\u0001\u0010\u0013\"\u0004\u0008\u0002\u0010\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00120\u00012\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\u00130\u00012\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u0001\u001a\u0010\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u001a\u001a\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u0001\u001a\u0010\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u0001*\u00020\u001e\u001a\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020 0\u0001\u001a\u000e\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\"0\u0001H\u0007\u001a\u0010\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020#0\u0001*\u00020$\u001a\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020&0\u0001\u001a\u000e\u0010'\u001a\u0008\u0012\u0004\u0012\u00020(0\u0001H\u0007\u001a\u0010\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020)0\u0001*\u00020*\u001a\u000c\u0010+\u001a\u0008\u0012\u0004\u0012\u00020,0\u0001\u001a\u000e\u0010-\u001a\u0008\u0012\u0004\u0012\u00020.0\u0001H\u0007\u001a\u0010\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020/0\u0001*\u000200\u001a\u000c\u00101\u001a\u0008\u0012\u0004\u0012\u0002020\u0001\u001a\u000e\u00103\u001a\u0008\u0012\u0004\u0012\u0002040\u0001H\u0007\u001a\u0010\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002050\u0001*\u000206\u001a\u000c\u00107\u001a\u0008\u0012\u0004\u0012\u0002080\u0001\u001a\u0010\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002090\u0001*\u00020:\u001a\u000c\u0010;\u001a\u0008\u0012\u0004\u0012\u00020<0\u0001\u001a\u0015\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020=0\u0001*\u00020>¢\u0006\u0002\u0010?\u001a\u000c\u0010@\u001a\u0008\u0012\u0004\u0012\u00020A0\u0001\u001a\u0015\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020B0\u0001*\u00020B¢\u0006\u0002\u0010C\u001a\u0010\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020D0\u0001*\u00020E\u001a=\u0010F\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002HH0G0\u0001\"\n\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u000c\u0008\u0001\u0010H\u0018\u0001*\u0004\u0018\u0001H\u00022\u000c\u0010I\u001a\u0008\u0012\u0004\u0012\u0002HH0\u0001H\u0087\u0008\u001aF\u0010F\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002HH0G0\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003\"\n\u0008\u0001\u0010H*\u0004\u0018\u0001H\u00022\u000c\u0010J\u001a\u0008\u0012\u0004\u0012\u0002H\u00020K2\u000c\u0010I\u001a\u0008\u0012\u0004\u0012\u0002HH0\u0001H\u0007\u001a&\u0010L\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020M0\u0001\"\u0004\u0008\u0000\u0010\u00022\u000c\u0010I\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\u001a&\u0010N\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020O0\u0001\"\u0004\u0008\u0000\u0010\u00022\u000c\u0010I\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\u001a@\u0010P\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0Q0\u0001\"\u0004\u0008\u0000\u0010\n\"\u0004\u0008\u0001\u0010\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u00012\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u0001\u001a\u0010\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020R0\u0001*\u00020S\u001a\u0010\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020T0\u0001*\u00020U\u001a\u0010\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020V0\u0001*\u00020W\u001a\u0010\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020X0\u0001*\u00020Y\u001a\u0010\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020Z0\u0001*\u00020[\u001a\u0012\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\\0\u0001*\u00020]H\u0007\u001a\u000e\u0010^\u001a\u0008\u0012\u0004\u0012\u00020_0\u0001H\u0007\"3\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\u0008\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u000c\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006`", d2 = {"nullable", "Lkotlinx/serialization/KSerializer;", "T", "", "getNullable$annotations", "(Lkotlinx/serialization/KSerializer;)V", "getNullable", "(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "PairSerializer", "Lkotlin/Pair;", "K", "V", "keySerializer", "valueSerializer", "MapEntrySerializer", "", "TripleSerializer", "Lkotlin/Triple;", "A", "B", "C", "aSerializer", "bSerializer", "cSerializer", "serializer", "", "Lkotlin/Char$Companion;", "CharArraySerializer", "", "", "Lkotlin/Byte$Companion;", "ByteArraySerializer", "", "UByteArraySerializer", "Lkotlin/UByteArray;", "", "Lkotlin/Short$Companion;", "ShortArraySerializer", "", "UShortArraySerializer", "Lkotlin/UShortArray;", "", "Lkotlin/Int$Companion;", "IntArraySerializer", "", "UIntArraySerializer", "Lkotlin/UIntArray;", "", "Lkotlin/Long$Companion;", "LongArraySerializer", "", "ULongArraySerializer", "Lkotlin/ULongArray;", "", "Lkotlin/Float$Companion;", "FloatArraySerializer", "", "", "Lkotlin/Double$Companion;", "DoubleArraySerializer", "", "", "Lkotlin/Boolean$Companion;", "(Lkotlin/jvm/internal/BooleanCompanionObject;)Lkotlinx/serialization/KSerializer;", "BooleanArraySerializer", "", "", "(Lkotlin/Unit;)Lkotlinx/serialization/KSerializer;", "", "Lkotlin/String$Companion;", "ArraySerializer", "", "E", "elementSerializer", "kClass", "Lkotlin/reflect/KClass;", "ListSerializer", "", "SetSerializer", "", "MapSerializer", "", "Lkotlin/UInt;", "Lkotlin/UInt$Companion;", "Lkotlin/ULong;", "Lkotlin/ULong$Companion;", "Lkotlin/UByte;", "Lkotlin/UByte$Companion;", "Lkotlin/UShort;", "Lkotlin/UShort$Companion;", "Lkotlin/time/Duration;", "Lkotlin/time/Duration$Companion;", "Lkotlin/uuid/Uuid;", "Lkotlin/uuid/Uuid$Companion;", "NothingSerializer", "", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BuiltinSerializersKt {
    @ExperimentalSerializationApi
    public static final <T, E extends T> KSerializer<E[]> ArraySerializer(KClass<T> kClass, KSerializer<E> elementSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(elementSerializer, "elementSerializer");
        ReferenceArraySerializer referenceArraySerializer = new ReferenceArraySerializer(kClass, elementSerializer);
        return (KSerializer)referenceArraySerializer;
    }

    @ExperimentalSerializationApi
    public static final <T, E extends T> KSerializer<E[]> ArraySerializer(KSerializer<E> elementSerializer) {
        Intrinsics.checkNotNullParameter(elementSerializer, "elementSerializer");
        int i = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        return BuiltinSerializersKt.ArraySerializer(Reflection.getOrCreateKotlinClass(Object.class), elementSerializer);
    }

    public static final KSerializer<boolean[]> BooleanArraySerializer() {
        return (KSerializer)BooleanArraySerializer.INSTANCE;
    }

    public static final KSerializer<byte[]> ByteArraySerializer() {
        return (KSerializer)ByteArraySerializer.INSTANCE;
    }

    public static final KSerializer<char[]> CharArraySerializer() {
        return (KSerializer)CharArraySerializer.INSTANCE;
    }

    public static final KSerializer<double[]> DoubleArraySerializer() {
        return (KSerializer)DoubleArraySerializer.INSTANCE;
    }

    public static final KSerializer<float[]> FloatArraySerializer() {
        return (KSerializer)FloatArraySerializer.INSTANCE;
    }

    public static final KSerializer<int[]> IntArraySerializer() {
        return (KSerializer)IntArraySerializer.INSTANCE;
    }

    public static final <T> KSerializer<List<T>> ListSerializer(KSerializer<T> elementSerializer) {
        Intrinsics.checkNotNullParameter(elementSerializer, "elementSerializer");
        ArrayListSerializer arrayListSerializer = new ArrayListSerializer(elementSerializer);
        return (KSerializer)arrayListSerializer;
    }

    public static final KSerializer<long[]> LongArraySerializer() {
        return (KSerializer)LongArraySerializer.INSTANCE;
    }

    public static final <K, V> KSerializer<Map.Entry<K, V>> MapEntrySerializer(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        Intrinsics.checkNotNullParameter(keySerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(valueSerializer, "valueSerializer");
        MapEntrySerializer mapEntrySerializer = new MapEntrySerializer(keySerializer, valueSerializer);
        return (KSerializer)mapEntrySerializer;
    }

    public static final <K, V> KSerializer<Map<K, V>> MapSerializer(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        Intrinsics.checkNotNullParameter(keySerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(valueSerializer, "valueSerializer");
        LinkedHashMapSerializer linkedHashMapSerializer = new LinkedHashMapSerializer(keySerializer, valueSerializer);
        return (KSerializer)linkedHashMapSerializer;
    }

    @ExperimentalSerializationApi
    public static final KSerializer NothingSerializer() {
        return (KSerializer)NothingSerializer.INSTANCE;
    }

    public static final <K, V> KSerializer<Pair<K, V>> PairSerializer(KSerializer<K> keySerializer, KSerializer<V> valueSerializer) {
        Intrinsics.checkNotNullParameter(keySerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(valueSerializer, "valueSerializer");
        PairSerializer pairSerializer = new PairSerializer(keySerializer, valueSerializer);
        return (KSerializer)pairSerializer;
    }

    public static final <T> KSerializer<Set<T>> SetSerializer(KSerializer<T> elementSerializer) {
        Intrinsics.checkNotNullParameter(elementSerializer, "elementSerializer");
        LinkedHashSetSerializer linkedHashSetSerializer = new LinkedHashSetSerializer(elementSerializer);
        return (KSerializer)linkedHashSetSerializer;
    }

    public static final KSerializer<short[]> ShortArraySerializer() {
        return (KSerializer)ShortArraySerializer.INSTANCE;
    }

    public static final <A, B, C> KSerializer<Triple<A, B, C>> TripleSerializer(KSerializer<A> aSerializer, KSerializer<B> bSerializer, KSerializer<C> cSerializer) {
        Intrinsics.checkNotNullParameter(aSerializer, "aSerializer");
        Intrinsics.checkNotNullParameter(bSerializer, "bSerializer");
        Intrinsics.checkNotNullParameter(cSerializer, "cSerializer");
        TripleSerializer tripleSerializer = new TripleSerializer(aSerializer, bSerializer, cSerializer);
        return (KSerializer)tripleSerializer;
    }

    @ExperimentalSerializationApi
    public static final KSerializer<UByteArray> UByteArraySerializer() {
        return (KSerializer)UByteArraySerializer.INSTANCE;
    }

    @ExperimentalSerializationApi
    public static final KSerializer<UIntArray> UIntArraySerializer() {
        return (KSerializer)UIntArraySerializer.INSTANCE;
    }

    @ExperimentalSerializationApi
    public static final KSerializer<ULongArray> ULongArraySerializer() {
        return (KSerializer)ULongArraySerializer.INSTANCE;
    }

    @ExperimentalSerializationApi
    public static final KSerializer<UShortArray> UShortArraySerializer() {
        return (KSerializer)UShortArraySerializer.INSTANCE;
    }

    public static final <T> KSerializer<T> getNullable(KSerializer<T> $this$nullable) {
        Object nullableSerializer;
        Intrinsics.checkNotNullParameter($this$nullable, "<this>");
        if ($this$nullable.getDescriptor().isNullable()) {
            nullableSerializer = $this$nullable;
        } else {
            nullableSerializer = new NullableSerializer($this$nullable);
        }
        return nullableSerializer;
    }

    public static void getNullable$annotations(KSerializer kSerializer) {
    }

    public static final KSerializer<UByte> serializer(UByte.Companion $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return (KSerializer)UByteSerializer.INSTANCE;
    }

    public static final KSerializer<UInt> serializer(UInt.Companion $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return (KSerializer)UIntSerializer.INSTANCE;
    }

    public static final KSerializer<ULong> serializer(ULong.Companion $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return (KSerializer)ULongSerializer.INSTANCE;
    }

    public static final KSerializer<UShort> serializer(UShort.Companion $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return (KSerializer)UShortSerializer.INSTANCE;
    }

    public static final KSerializer<Unit> serializer(Unit $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return (KSerializer)UnitSerializer.INSTANCE;
    }

    public static final KSerializer<Boolean> serializer(BooleanCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return (KSerializer)BooleanSerializer.INSTANCE;
    }

    public static final KSerializer<Byte> serializer(ByteCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return (KSerializer)ByteSerializer.INSTANCE;
    }

    public static final KSerializer<Character> serializer(CharCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return (KSerializer)CharSerializer.INSTANCE;
    }

    public static final KSerializer<Double> serializer(DoubleCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return (KSerializer)DoubleSerializer.INSTANCE;
    }

    public static final KSerializer<Float> serializer(FloatCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return (KSerializer)FloatSerializer.INSTANCE;
    }

    public static final KSerializer<Integer> serializer(IntCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return (KSerializer)IntSerializer.INSTANCE;
    }

    public static final KSerializer<Long> serializer(LongCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return (KSerializer)LongSerializer.INSTANCE;
    }

    public static final KSerializer<Short> serializer(ShortCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return (KSerializer)ShortSerializer.INSTANCE;
    }

    public static final KSerializer<String> serializer(StringCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return (KSerializer)StringSerializer.INSTANCE;
    }

    public static final KSerializer<Duration> serializer(Duration.Companion $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return (KSerializer)DurationSerializer.INSTANCE;
    }

    public static final KSerializer<Uuid> serializer(Uuid.Companion $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return (KSerializer)UuidSerializer.INSTANCE;
    }
}

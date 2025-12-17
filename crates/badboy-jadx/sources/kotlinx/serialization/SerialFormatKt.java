package kotlinx.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlinx.serialization.internal.InternalHexConverter;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0012\n\u0002\u0008\u0005\u001a\"\u0010\u0000\u001a\u00020\u0001\"\u0006\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0086\u0008¢\u0006\u0002\u0010\u0005\u001a\"\u0010\u0006\u001a\u0002H\u0002\"\u0006\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\u0008¢\u0006\u0002\u0010\u0008\u001a+\u0010\t\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u00020\n2\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0006\u0010\u0004\u001a\u0002H\u0002¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u00020\n2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001¢\u0006\u0002\u0010\u0012\u001a\"\u0010\t\u001a\u00020\u0001\"\u0006\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\n2\u0006\u0010\u0004\u001a\u0002H\u0002H\u0086\u0008¢\u0006\u0002\u0010\u0013\u001a\"\u0010\u000e\u001a\u0002H\u0002\"\u0006\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0001H\u0086\u0008¢\u0006\u0002\u0010\u0014\u001a\"\u0010\u0015\u001a\u00020\u0016\"\u0006\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\n2\u0006\u0010\u0004\u001a\u0002H\u0002H\u0086\u0008¢\u0006\u0002\u0010\u0017\u001a\"\u0010\u0018\u001a\u0002H\u0002\"\u0006\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0016H\u0086\u0008¢\u0006\u0002\u0010\u001a¨\u0006\u001b", d2 = {"encodeToString", "", "T", "Lkotlinx/serialization/StringFormat;", "value", "(Lkotlinx/serialization/StringFormat;Ljava/lang/Object;)Ljava/lang/String;", "decodeFromString", "string", "(Lkotlinx/serialization/StringFormat;Ljava/lang/String;)Ljava/lang/Object;", "encodeToHexString", "Lkotlinx/serialization/BinaryFormat;", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/BinaryFormat;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;", "decodeFromHexString", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "hex", "(Lkotlinx/serialization/BinaryFormat;Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;", "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/String;)Ljava/lang/Object;", "encodeToByteArray", "", "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/Object;)[B", "decodeFromByteArray", "bytes", "(Lkotlinx/serialization/BinaryFormat;[B)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SerialFormatKt {
    public static final <T> T decodeFromByteArray(kotlinx.serialization.BinaryFormat $this$decodeFromByteArray, byte[] bytes) {
        Intrinsics.checkNotNullParameter($this$decodeFromByteArray, "<this>");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        int i = 0;
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return $this$decodeFromByteArray.decodeFromByteArray((DeserializationStrategy)SerializersKt.serializer($this$decodeFromByteArray.getSerializersModule(), 0), bytes);
    }

    public static final <T> T decodeFromHexString(kotlinx.serialization.BinaryFormat $this$decodeFromHexString, String hex) {
        Intrinsics.checkNotNullParameter($this$decodeFromHexString, "<this>");
        Intrinsics.checkNotNullParameter(hex, "hex");
        int i = 0;
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SerialFormatKt.decodeFromHexString($this$decodeFromHexString, (DeserializationStrategy)SerializersKt.serializer($this$decodeFromHexString.getSerializersModule(), 0), hex);
    }

    public static final <T> T decodeFromHexString(kotlinx.serialization.BinaryFormat $this$decodeFromHexString, kotlinx.serialization.DeserializationStrategy<? extends T> deserializer, String hex) {
        Intrinsics.checkNotNullParameter($this$decodeFromHexString, "<this>");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(hex, "hex");
        return $this$decodeFromHexString.decodeFromByteArray(deserializer, InternalHexConverter.INSTANCE.parseHexBinary(hex));
    }

    public static final <T> T decodeFromString(kotlinx.serialization.StringFormat $this$decodeFromString, String string) {
        Intrinsics.checkNotNullParameter($this$decodeFromString, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        int i = 0;
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return $this$decodeFromString.decodeFromString((DeserializationStrategy)SerializersKt.serializer($this$decodeFromString.getSerializersModule(), 0), string);
    }

    public static final <T> byte[] encodeToByteArray(kotlinx.serialization.BinaryFormat $this$encodeToByteArray, T value) {
        Intrinsics.checkNotNullParameter($this$encodeToByteArray, "<this>");
        int i = 0;
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return $this$encodeToByteArray.encodeToByteArray((SerializationStrategy)SerializersKt.serializer($this$encodeToByteArray.getSerializersModule(), 0), value);
    }

    public static final <T> String encodeToHexString(kotlinx.serialization.BinaryFormat $this$encodeToHexString, T value) {
        Intrinsics.checkNotNullParameter($this$encodeToHexString, "<this>");
        int i = 0;
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return SerialFormatKt.encodeToHexString($this$encodeToHexString, (SerializationStrategy)SerializersKt.serializer($this$encodeToHexString.getSerializersModule(), 0), value);
    }

    public static final <T> String encodeToHexString(kotlinx.serialization.BinaryFormat $this$encodeToHexString, kotlinx.serialization.SerializationStrategy<? super T> serializer, T value) {
        Intrinsics.checkNotNullParameter($this$encodeToHexString, "<this>");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        return InternalHexConverter.INSTANCE.printHexBinary($this$encodeToHexString.encodeToByteArray(serializer, value), true);
    }

    public static final <T> String encodeToString(kotlinx.serialization.StringFormat $this$encodeToString, T value) {
        Intrinsics.checkNotNullParameter($this$encodeToString, "<this>");
        int i = 0;
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
        return $this$encodeToString.encodeToString((SerializationStrategy)SerializersKt.serializer($this$encodeToString.getSerializersModule(), 0), value);
    }
}

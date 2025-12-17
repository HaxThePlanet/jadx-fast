package kotlinx.serialization;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u00062\u0006\u0010\u0007\u001a\u0002H\u0004H&¢\u0006\u0002\u0010\u0008J)\u0010\t\u001a\u0002H\u0004\"\u0004\u0008\u0000\u0010\u00042\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u000b2\u0006\u0010\u000c\u001a\u00020\u0003H&¢\u0006\u0002\u0010\r¨\u0006\u000e", d2 = {"Lkotlinx/serialization/StringFormat;", "Lkotlinx/serialization/SerialFormat;", "encodeToString", "", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;", "decodeFromString", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "string", "(Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface StringFormat extends kotlinx.serialization.SerialFormat {
    public abstract <T> T decodeFromString(kotlinx.serialization.DeserializationStrategy<? extends T> deserializationStrategy, String string2);

    public abstract <T> String encodeToString(kotlinx.serialization.SerializationStrategy<? super T> serializationStrategy, T t2);
}

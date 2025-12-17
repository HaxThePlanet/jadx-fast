package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0001\u0018\u0000*\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\u0008\u0008\u0010\tB'\u0008\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\u0008\u0008\u0010\u000cJ\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u001d\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u001cH\u0016¢\u0006\u0002\u0010\u001dJ\u0008\u0010\u001e\u001a\u00020\u0005H\u0016R\u0016\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001f", d2 = {"Lkotlinx/serialization/internal/EnumSerializer;", "T", "", "Lkotlinx/serialization/KSerializer;", "serialName", "", "values", "", "<init>", "(Ljava/lang/String;[Ljava/lang/Enum;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Ljava/lang/String;[Ljava/lang/Enum;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "[Ljava/lang/Enum;", "overriddenDescriptor", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "createUnmarkedDescriptor", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Enum;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Enum;", "toString", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EnumSerializer<T extends Enum<T>>  implements KSerializer<T> {

    private final Lazy descriptor$delegate;
    private SerialDescriptor overriddenDescriptor;
    private final T[] values;
    public static SerialDescriptor $r8$lambda$TJMXX3M6I7vxH4CVgqgiNEiaiFI(kotlinx.serialization.internal.EnumSerializer enumSerializer, String string2) {
        return EnumSerializer.descriptor_delegate$lambda$0(enumSerializer, string2);
    }

    public EnumSerializer(String serialName, T[] values) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        super();
        this.values = values;
        EnumSerializer$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new EnumSerializer$$ExternalSyntheticLambda0(this, serialName);
        this.descriptor$delegate = LazyKt.lazy(externalSyntheticLambda0);
    }

    public EnumSerializer(String serialName, T[] values, SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        super(serialName, values);
        this.overriddenDescriptor = descriptor;
    }

    private final SerialDescriptor createUnmarkedDescriptor(String serialName) {
        int i;
        Enum obj;
        Enum obj2;
        int i3;
        kotlinx.serialization.internal.EnumDescriptor enumDescriptor;
        String name;
        int i4;
        int i2;
        EnumDescriptor enumDescriptor2 = new EnumDescriptor(serialName, values.length);
        Enum[] values2 = this.values;
        final int i5 = 0;
        final int i6 = 0;
        i = i6;
        while (i < values2.length) {
            i3 = 0;
            PluginGeneratedSerialDescriptor.addElement$default((PluginGeneratedSerialDescriptor)enumDescriptor2, values2[i].name(), i6, 2, 0);
            i++;
        }
        return (SerialDescriptor)enumDescriptor2;
    }

    private static final SerialDescriptor descriptor_delegate$lambda$0(kotlinx.serialization.internal.EnumSerializer this$0, String $serialName) {
        SerialDescriptor overriddenDescriptor;
        if (this$0.overriddenDescriptor == null) {
            overriddenDescriptor = this$0.createUnmarkedDescriptor($serialName);
        }
        return overriddenDescriptor;
    }

    public T deserialize(Decoder decoder) {
        int i;
        int length;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        int decodeEnum = decoder.decodeEnum(getDescriptor());
        i = 0;
        if (decodeEnum >= 0 && decodeEnum < values2.length) {
            if (decodeEnum < values2.length) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
            return this.values[decodeEnum];
        }
        StringBuilder stringBuilder = new StringBuilder();
        SerializationException serializationException = new SerializationException(stringBuilder.append(decodeEnum).append(" is not among valid ").append(getDescriptor().getSerialName()).append(" enum values, values size is ").append(values3.length).toString());
        throw serializationException;
    }

    @Override // kotlinx.serialization.KSerializer
    public Object deserialize(Decoder decoder) {
        return deserialize(decoder);
    }

    @Override // kotlinx.serialization.KSerializer
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor)this.descriptor$delegate.getValue();
    }

    public void serialize(Encoder encoder, T value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        int indexOf = ArraysKt.indexOf(this.values, value);
        if (indexOf == -1) {
        } else {
            encoder.encodeEnum(getDescriptor(), indexOf);
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = Arrays.toString(this.values);
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        SerializationException serializationException = new SerializationException(stringBuilder.append(value).append(" is not a valid enum ").append(getDescriptor().getSerialName()).append(", must be one of ").append(string2).toString());
        throw serializationException;
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(Encoder encoder, Object value) {
        serialize(encoder, (Enum)value);
    }

    @Override // kotlinx.serialization.KSerializer
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("kotlinx.serialization.internal.EnumSerializer<").append(getDescriptor().getSerialName()).append('>').toString();
    }
}

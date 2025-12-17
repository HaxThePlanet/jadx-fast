package androidx.savedstate.serialization.serializers;

import android.util.SizeF;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import androidx.savedstate.serialization.SavedStateDecoder;
import androidx.savedstate.serialization.SavedStateEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0011", d2 = {"Landroidx/savedstate/serialization/serializers/SizeFSerializer;", "Lkotlinx/serialization/KSerializer;", "Landroid/util/SizeF;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SizeFSerializer implements KSerializer<SizeF> {

    public static final androidx.savedstate.serialization.serializers.SizeFSerializer INSTANCE;
    private static final SerialDescriptor descriptor;
    static {
        SizeFSerializer sizeFSerializer = new SizeFSerializer();
        SizeFSerializer.INSTANCE = sizeFSerializer;
        final int i2 = 0;
        SizeFSerializer.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor$default("android.util.SizeF", new SerialDescriptor[0], i2, 4, i2);
    }

    @Override // kotlinx.serialization.KSerializer
    public SizeF deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (!decoder instanceof SavedStateDecoder) {
        } else {
            Object obj = decoder;
            int i2 = 0;
            final int i3 = 0;
            final int i4 = 0;
            return SavedStateReader.getSizeF-impl(SavedStateReader.constructor-impl((SavedStateDecoder)obj.getSavedState$savedstate_release()), obj.getKey$savedstate_release());
        }
        int i = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(SizeFSerializer.INSTANCE.getDescriptor().getSerialName(), decoder).toString());
        throw illegalArgumentException;
    }

    @Override // kotlinx.serialization.KSerializer
    public Object deserialize(Decoder decoder) {
        return deserialize(decoder);
    }

    @Override // kotlinx.serialization.KSerializer
    public SerialDescriptor getDescriptor() {
        return SizeFSerializer.descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(Encoder encoder, SizeF value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!encoder instanceof SavedStateEncoder) {
        } else {
            Object obj = encoder;
            int i2 = 0;
            final int i3 = 0;
            final int i4 = 0;
            SavedStateWriter.putSizeF-impl(SavedStateWriter.constructor-impl((SavedStateEncoder)obj.getSavedState$savedstate_release()), obj.getKey$savedstate_release(), value);
        }
        int i = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(SizeFSerializer.INSTANCE.getDescriptor().getSerialName(), encoder).toString());
        throw illegalArgumentException;
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(Encoder encoder, Object value) {
        serialize(encoder, (SizeF)value);
    }
}

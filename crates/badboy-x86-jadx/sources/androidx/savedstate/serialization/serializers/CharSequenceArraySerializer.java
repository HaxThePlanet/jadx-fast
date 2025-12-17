package androidx.savedstate.serialization.serializers;

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
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008À\u0002\u0018\u00002\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J#\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\u000fJ\u001b\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u0014", d2 = {"Landroidx/savedstate/serialization/serializers/CharSequenceArraySerializer;", "Lkotlinx/serialization/KSerializer;", "", "", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;[Ljava/lang/CharSequence;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)[Ljava/lang/CharSequence;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CharSequenceArraySerializer implements KSerializer<java.lang.CharSequence[]> {

    public static final androidx.savedstate.serialization.serializers.CharSequenceArraySerializer INSTANCE;
    private static final SerialDescriptor descriptor;
    static {
        CharSequenceArraySerializer charSequenceArraySerializer = new CharSequenceArraySerializer();
        CharSequenceArraySerializer.INSTANCE = charSequenceArraySerializer;
        final int i2 = 0;
        CharSequenceArraySerializer.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor$default("kotlin.Array<kotlin.CharSequence>", new SerialDescriptor[0], i2, 4, i2);
    }

    @Override // kotlinx.serialization.KSerializer
    public Object deserialize(Decoder decoder) {
        return deserialize(decoder);
    }

    @Override // kotlinx.serialization.KSerializer
    public java.lang.CharSequence[] deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (!decoder instanceof SavedStateDecoder) {
        } else {
            Object obj = decoder;
            int i2 = 0;
            final int i3 = 0;
            final int i4 = 0;
            return SavedStateReader.getCharSequenceArray-impl(SavedStateReader.constructor-impl((SavedStateDecoder)obj.getSavedState$savedstate_release()), obj.getKey$savedstate_release());
        }
        int i = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(CharSequenceArraySerializer.INSTANCE.getDescriptor().getSerialName(), decoder).toString());
        throw illegalArgumentException;
    }

    @Override // kotlinx.serialization.KSerializer
    public SerialDescriptor getDescriptor() {
        return CharSequenceArraySerializer.descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(Encoder encoder, Object value) {
        serialize(encoder, (CharSequence[])value);
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(Encoder encoder, java.lang.CharSequence[] value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!encoder instanceof SavedStateEncoder) {
        } else {
            Object obj = encoder;
            int i2 = 0;
            final int i3 = 0;
            final int i4 = 0;
            SavedStateWriter.putCharSequenceArray-impl(SavedStateWriter.constructor-impl((SavedStateEncoder)obj.getSavedState$savedstate_release()), obj.getKey$savedstate_release(), value);
        }
        int i = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(CharSequenceArraySerializer.INSTANCE.getDescriptor().getSerialName(), encoder).toString());
        throw illegalArgumentException;
    }
}

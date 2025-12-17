package androidx.savedstate.serialization.serializers;

import android.os.Bundle;
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
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002j\u0002`\u00030\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u0014", d2 = {"Landroidx/savedstate/serialization/serializers/SavedStateSerializer;", "Lkotlinx/serialization/KSerializer;", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Landroid/os/Bundle;)V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Landroid/os/Bundle;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateSerializer implements KSerializer<Bundle> {

    public static final androidx.savedstate.serialization.serializers.SavedStateSerializer INSTANCE;
    private static final SerialDescriptor descriptor;
    static {
        SavedStateSerializer savedStateSerializer = new SavedStateSerializer();
        SavedStateSerializer.INSTANCE = savedStateSerializer;
        final int i2 = 0;
        SavedStateSerializer.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor$default("androidx.savedstate.SavedState", new SerialDescriptor[0], i2, 4, i2);
    }

    @Override // kotlinx.serialization.KSerializer
    public Bundle deserialize(Decoder decoder) {
        Bundle $this$read$iv;
        int str;
        Bundle $this$deserialize_u24lambda_u246_u24lambda_u245;
        int i;
        String key$savedstate_release;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (!decoder instanceof SavedStateDecoder) {
        } else {
            Object obj = decoder;
            int i3 = 0;
            if (Intrinsics.areEqual((SavedStateDecoder)obj.getKey$savedstate_release(), "")) {
                $this$read$iv = obj.getSavedState$savedstate_release();
            } else {
                str = 0;
                i = 0;
                $this$read$iv = $this$deserialize_u24lambda_u246_u24lambda_u245;
            }
            return $this$read$iv;
        }
        int i2 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(BuiltInSerializerKt.decoderErrorMessage(SavedStateSerializer.INSTANCE.getDescriptor().getSerialName(), decoder).toString());
        throw illegalArgumentException;
    }

    @Override // kotlinx.serialization.KSerializer
    public Object deserialize(Decoder decoder) {
        return deserialize(decoder);
    }

    @Override // kotlinx.serialization.KSerializer
    public SerialDescriptor getDescriptor() {
        return SavedStateSerializer.descriptor;
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(Encoder encoder, Bundle value) {
        Bundle savedState$savedstate_release;
        int i;
        Bundle constructor-impl;
        int i2;
        String key$savedstate_release;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!encoder instanceof SavedStateEncoder) {
        } else {
            Object obj = encoder;
            int i4 = 0;
            if (Intrinsics.areEqual((SavedStateEncoder)obj.getKey$savedstate_release(), "")) {
                i = 0;
                i2 = 0;
                SavedStateWriter.putAll-impl(SavedStateWriter.constructor-impl(obj.getSavedState$savedstate_release()), value);
            } else {
                i = 0;
                i2 = 0;
                SavedStateWriter.putSavedState-impl(SavedStateWriter.constructor-impl(obj.getSavedState$savedstate_release()), obj.getKey$savedstate_release(), value);
            }
        }
        int i3 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(BuiltInSerializerKt.encoderErrorMessage(SavedStateSerializer.INSTANCE.getDescriptor().getSerialName(), encoder).toString());
        throw illegalArgumentException;
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(Encoder encoder, Object value) {
        serialize(encoder, (Bundle)value);
    }
}

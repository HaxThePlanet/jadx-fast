package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Á\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u001e\u0010\u0008\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0002\u0010\u000cR\u0012\u0010\r\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0011", d2 = {"Lkotlinx/serialization/internal/UnitSerializer;", "Lkotlinx/serialization/KSerializer;", "", "<init>", "()V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Lkotlin/Unit;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnitSerializer implements KSerializer<Unit> {

    public static final kotlinx.serialization.internal.UnitSerializer INSTANCE;
    private final kotlinx.serialization.internal.ObjectSerializer<Unit> $$delegate_0;
    static {
        UnitSerializer unitSerializer = new UnitSerializer();
        UnitSerializer.INSTANCE = unitSerializer;
    }

    private UnitSerializer() {
        super();
        ObjectSerializer objectSerializer = new ObjectSerializer("kotlin.Unit", Unit.INSTANCE);
        this.$$delegate_0 = objectSerializer;
    }

    @Override // kotlinx.serialization.KSerializer
    public Object deserialize(Decoder decoder) {
        deserialize(decoder);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.serialization.KSerializer
    public void deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        this.$$delegate_0.deserialize(decoder);
    }

    @Override // kotlinx.serialization.KSerializer
    public SerialDescriptor getDescriptor() {
        return this.$$delegate_0.getDescriptor();
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(Encoder encoder, Object value) {
        serialize(encoder, (Unit)value);
    }

    @Override // kotlinx.serialization.KSerializer
    public void serialize(Encoder encoder, Unit unit2) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(unit2, "value");
        this.$$delegate_0.serialize(encoder, unit2);
    }
}

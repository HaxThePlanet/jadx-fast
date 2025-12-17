package androidx.savedstate.serialization;

import androidx.savedstate.serialization.serializers.SizeFSerializer;
import androidx.savedstate.serialization.serializers.SizeSerializer;
import androidx.savedstate.serialization.serializers.SparseArraySerializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002", d2 = {"getDefaultSerializersModuleOnPlatform", "Lkotlinx/serialization/modules/SerializersModule;", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SavedStateConfig_androidKt {
    public static KSerializer $r8$lambda$orfFsZZdVWSKUh60gLG7SsK1BYg(List list) {
        return SavedStateConfig_androidKt.getDefaultSerializersModuleOnPlatform$lambda$1$lambda$0(list);
    }

    public static final SerializersModule getDefaultSerializersModuleOnPlatform() {
        int i = 0;
        SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
        final SerializersModuleBuilder builder = serializersModuleBuilder;
        final int i2 = 0;
        SerializersModuleBuilder builder2 = builder;
        int i3 = 0;
        builder2.contextual(Reflection.getOrCreateKotlinClass(Size.class), (KSerializer)SizeSerializer.INSTANCE);
        int i4 = 0;
        builder2.contextual(Reflection.getOrCreateKotlinClass(SizeF.class), (KSerializer)SizeFSerializer.INSTANCE);
        SavedStateConfig_androidKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new SavedStateConfig_androidKt$$ExternalSyntheticLambda0();
        builder.contextual(Reflection.getOrCreateKotlinClass(SparseArray.class), externalSyntheticLambda0);
        return serializersModuleBuilder.build();
    }

    private static final KSerializer getDefaultSerializersModuleOnPlatform$lambda$1$lambda$0(List argSerializers) {
        Intrinsics.checkNotNullParameter(argSerializers, "argSerializers");
        SparseArraySerializer sparseArraySerializer = new SparseArraySerializer((KSerializer)CollectionsKt.first(argSerializers));
        return (KSerializer)sparseArraySerializer;
    }
}

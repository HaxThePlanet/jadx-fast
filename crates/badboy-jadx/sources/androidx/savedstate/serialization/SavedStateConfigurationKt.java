package androidx.savedstate.serialization;

import androidx.savedstate.serialization.serializers.SavedStateSerializer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuilder;
import kotlinx.serialization.modules.SerializersModuleKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0008\u0007H\u0007\"\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"SavedStateConfiguration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "from", "builderAction", "Lkotlin/Function1;", "Landroidx/savedstate/serialization/SavedStateConfiguration$Builder;", "", "Lkotlin/ExtensionFunctionType;", "DEFAULT_SERIALIZERS_MODULE", "Lkotlinx/serialization/modules/SerializersModule;", "savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SavedStateConfigurationKt {

    private static final SerializersModule DEFAULT_SERIALIZERS_MODULE;
    static {
        int i = 0;
        SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
        final int i2 = 0;
        final int i3 = 0;
        serializersModuleBuilder.contextual(Reflection.getOrCreateKotlinClass(Bundle.class), (KSerializer)SavedStateSerializer.INSTANCE);
        SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE = SerializersModuleKt.plus(serializersModuleBuilder.build(), SavedStateConfig_androidKt.getDefaultSerializersModuleOnPlatform());
    }

    public static final androidx.savedstate.serialization.SavedStateConfiguration SavedStateConfiguration(androidx.savedstate.serialization.SavedStateConfiguration from, Function1<? super androidx.savedstate.serialization.SavedStateConfiguration.Builder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        SavedStateConfiguration.Builder builder = new SavedStateConfiguration.Builder(from);
        builderAction.invoke(builder);
        return builder.build$savedstate_release();
    }

    public static final androidx.savedstate.serialization.SavedStateConfiguration SavedStateConfiguration(Function1<? super androidx.savedstate.serialization.SavedStateConfiguration.Builder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        int i = 0;
        return SavedStateConfigurationKt.SavedStateConfiguration$default(i, builderAction, 1, i);
    }

    public static androidx.savedstate.serialization.SavedStateConfiguration SavedStateConfiguration$default(androidx.savedstate.serialization.SavedStateConfiguration savedStateConfiguration, Function1 function12, int i3, Object object4) {
        androidx.savedstate.serialization.SavedStateConfiguration obj0;
        if (i3 &= 1 != 0) {
            obj0 = SavedStateConfiguration.DEFAULT;
        }
        return SavedStateConfigurationKt.SavedStateConfiguration(obj0, function12);
    }

    public static final SerializersModule access$getDEFAULT_SERIALIZERS_MODULE$p() {
        return SavedStateConfigurationKt.DEFAULT_SERIALIZERS_MODULE;
    }
}

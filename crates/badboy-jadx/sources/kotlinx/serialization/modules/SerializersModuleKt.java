package kotlinx.serialization.modules;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0008\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\u0004\"\u001c\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0002\u0010\u0003\u001a\u0004\u0008\u0004\u0010\u0005*\\\u0008\u0000\u0010\t\u001a\u0004\u0008\u0000\u0010\n\"'\u0012\u0015\u0012\u0013\u0018\u00010\u000c¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u000f\u0012\u000c\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u00100\u000b2'\u0012\u0015\u0012\u0013\u0018\u00010\u000c¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u000f\u0012\u000c\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u00100\u000b*X\u0008\u0000\u0010\u0011\u001a\u0004\u0008\u0000\u0010\n\"%\u0012\u0013\u0012\u0011H\n¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u0012\u0012\u000c\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u00130\u000b2%\u0012\u0013\u0012\u0011H\n¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u0012\u0012\u000c\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u00130\u000b¨\u0006\u0014", d2 = {"EmptySerializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getEmptySerializersModule$annotations", "()V", "getEmptySerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "plus", "other", "overwriteWith", "PolymorphicDeserializerProvider", "Base", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "className", "Lkotlinx/serialization/DeserializationStrategy;", "PolymorphicSerializerProvider", "value", "Lkotlinx/serialization/SerializationStrategy;", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SerializersModuleKt {

    private static final kotlinx.serialization.modules.SerializersModule EmptySerializersModule;
    static {
        SerialModuleImpl serialModuleImpl = new SerialModuleImpl(MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), 0);
        SerializersModuleKt.EmptySerializersModule = (SerializersModule)serialModuleImpl;
    }

    public static final kotlinx.serialization.modules.SerializersModule getEmptySerializersModule() {
        return SerializersModuleKt.EmptySerializersModule;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in the favour of 'EmptySerializersModule()'", replaceWith = @ReplaceWith(...))
    public static void getEmptySerializersModule$annotations() {
    }

    public static final kotlinx.serialization.modules.SerializersModule overwriteWith(kotlinx.serialization.modules.SerializersModule $this$overwriteWith, kotlinx.serialization.modules.SerializersModule other) {
        Intrinsics.checkNotNullParameter($this$overwriteWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int i = 0;
        SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
        final kotlinx.serialization.modules.SerializersModuleBuilder builder = serializersModuleBuilder;
        final int i2 = 0;
        builder.include($this$overwriteWith);
        SerializersModuleKt.overwriteWith.1.1 anon = new SerializersModuleKt.overwriteWith.1.1(builder);
        other.dumpTo((SerializersModuleCollector)anon);
        return serializersModuleBuilder.build();
    }

    public static final kotlinx.serialization.modules.SerializersModule plus(kotlinx.serialization.modules.SerializersModule $this$plus, kotlinx.serialization.modules.SerializersModule other) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int i = 0;
        SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
        final kotlinx.serialization.modules.SerializersModuleBuilder builder = serializersModuleBuilder;
        final int i2 = 0;
        builder.include($this$plus);
        builder.include(other);
        return serializersModuleBuilder.build();
    }
}

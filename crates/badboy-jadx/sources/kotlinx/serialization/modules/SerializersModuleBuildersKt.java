package kotlinx.serialization.modules;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0007\u001a#\u0010\u0000\u001a\u00020\u0001\"\n\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\u0008\u001a%\u0010\u0008\u001a\u00020\u00012\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c0\n¢\u0006\u0002\u0008\rH\u0086\u0008ø\u0001\u0000\u001a\u0006\u0010\u000e\u001a\u00020\u0001\u001a'\u0010\u000f\u001a\u00020\u000c\"\n\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u000b2\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\u0008\u001a[\u0010\u0010\u001a\u00020\u000c\"\u0008\u0008\u0000\u0010\u0011*\u00020\u0003*\u00020\u000b2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00110\u00052\u0010\u0008\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0011\u0018\u00010\u00072\u001f\u0008\u0002\u0010\t\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00110\u0014\u0012\u0004\u0012\u00020\u000c0\n¢\u0006\u0002\u0008\rH\u0086\u0008ø\u0001\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0015", d2 = {"serializersModuleOf", "Lkotlinx/serialization/modules/SerializersModule;", "T", "", "kClass", "Lkotlin/reflect/KClass;", "serializer", "Lkotlinx/serialization/KSerializer;", "SerializersModule", "builderAction", "Lkotlin/Function1;", "Lkotlinx/serialization/modules/SerializersModuleBuilder;", "", "Lkotlin/ExtensionFunctionType;", "EmptySerializersModule", "contextual", "polymorphic", "Base", "baseClass", "baseSerializer", "Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SerializersModuleBuildersKt {
    public static final kotlinx.serialization.modules.SerializersModule EmptySerializersModule() {
        return SerializersModuleKt.getEmptySerializersModule();
    }

    public static final kotlinx.serialization.modules.SerializersModule SerializersModule(Function1<? super kotlinx.serialization.modules.SerializersModuleBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        int i = 0;
        SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
        builderAction.invoke(serializersModuleBuilder);
        return serializersModuleBuilder.build();
    }

    public static final <T> void contextual(kotlinx.serialization.modules.SerializersModuleBuilder $this$contextual, KSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter($this$contextual, "<this>");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        int i = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        $this$contextual.contextual(Reflection.getOrCreateKotlinClass(Object.class), serializer);
    }

    public static final <Base> void polymorphic(kotlinx.serialization.modules.SerializersModuleBuilder $this$polymorphic, KClass<Base> baseClass, KSerializer<Base> baseSerializer, Function1<? super kotlinx.serialization.modules.PolymorphicModuleBuilder<? super Base>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter($this$polymorphic, "<this>");
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        int i = 0;
        PolymorphicModuleBuilder polymorphicModuleBuilder = new PolymorphicModuleBuilder(baseClass, baseSerializer);
        builderAction.invoke(polymorphicModuleBuilder);
        polymorphicModuleBuilder.buildTo($this$polymorphic);
    }

    public static void polymorphic$default(kotlinx.serialization.modules.SerializersModuleBuilder $this$polymorphic_u24default, KClass baseClass, KSerializer baseSerializer, Function1 builderAction, int i5, Object object6) {
        int obj2;
        kotlinx.serialization.modules.SerializersModuleBuildersKt.polymorphic.1 obj3;
        int obj4;
        if (i5 & 2 != 0) {
            obj2 = 0;
        }
        if (i5 &= 4 != 0) {
            obj3 = obj4;
        }
        Intrinsics.checkNotNullParameter($this$polymorphic_u24default, "<this>");
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(obj3, "builderAction");
        obj4 = 0;
        PolymorphicModuleBuilder obj5 = new PolymorphicModuleBuilder(baseClass, obj2);
        obj3.invoke(obj5);
        obj5.buildTo($this$polymorphic_u24default);
    }

    public static final <T> kotlinx.serialization.modules.SerializersModule serializersModuleOf(KClass<T> kClass, KSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        int i = 0;
        SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
        final int i2 = 0;
        serializersModuleBuilder.contextual(kClass, serializer);
        return serializersModuleBuilder.build();
    }

    public static final <T> kotlinx.serialization.modules.SerializersModule serializersModuleOf(KSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        int i = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        return SerializersModuleBuildersKt.serializersModuleOf(Reflection.getOrCreateKotlinClass(Object.class), serializer);
    }
}

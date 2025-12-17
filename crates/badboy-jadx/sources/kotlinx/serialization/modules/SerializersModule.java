package kotlinx.serialization.modules;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001B\t\u0008\u0004¢\u0006\u0004\u0008\u0002\u0010\u0003J(\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\u0008\u0008\u0000\u0010\u0006*\u00020\u00012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0008H\u0007J<\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\u0008\u0008\u0000\u0010\u0006*\u00020\u00012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u00082\u0012\u0008\u0002\u0010\n\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00050\u000bH'J7\u0010\u000c\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\r\"\u0008\u0008\u0000\u0010\u0006*\u00020\u00012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00060\u00082\u0006\u0010\u000f\u001a\u0002H\u0006H'¢\u0006\u0002\u0010\u0010J4\u0010\u000c\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0011\"\u0008\u0008\u0000\u0010\u0006*\u00020\u00012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00060\u00082\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013H'J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H'R\u001a\u0010\u0018\u001a\u00020\u00198 X¡\u0004¢\u0006\u000c\u0012\u0004\u0008\u001a\u0010\u0003\u001a\u0004\u0008\u001b\u0010\u001c\u0082\u0001\u0001\u001d¨\u0006\u001e", d2 = {"Lkotlinx/serialization/modules/SerializersModule;", "", "<init>", "()V", "getContextual", "Lkotlinx/serialization/KSerializer;", "T", "kclass", "Lkotlin/reflect/KClass;", "kClass", "typeArgumentsSerializers", "", "getPolymorphic", "Lkotlinx/serialization/SerializationStrategy;", "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/DeserializationStrategy;", "serializedClassName", "", "dumpTo", "", "collector", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "hasInterfaceContextualSerializers", "", "getHasInterfaceContextualSerializers$kotlinx_serialization_core$annotations", "getHasInterfaceContextualSerializers$kotlinx_serialization_core", "()Z", "Lkotlinx/serialization/modules/SerialModuleImpl;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class SerializersModule {
    public SerializersModule(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public static KSerializer getContextual$default(kotlinx.serialization.modules.SerializersModule serializersModule, KClass kClass2, List list3, int i4, Object object5) {
        List obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = CollectionsKt.emptyList();
            }
            return serializersModule.getContextual(kClass2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
        throw obj0;
    }

    @InternalSerializationApi
    public static void getHasInterfaceContextualSerializers$kotlinx_serialization_core$annotations() {
    }

    @ExperimentalSerializationApi
    public abstract void dumpTo(kotlinx.serialization.modules.SerializersModuleCollector serializersModuleCollector);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of overload with default parameter", replaceWith = @ReplaceWith(...))
    @ExperimentalSerializationApi
    public final KSerializer getContextual(KClass kclass) {
        Intrinsics.checkNotNullParameter(kclass, "kclass");
        return getContextual(kclass, CollectionsKt.emptyList());
    }

    @ExperimentalSerializationApi
    public abstract <T> KSerializer<T> getContextual(KClass<T> kClass, List<? extends KSerializer<?>> list2);

    public abstract boolean getHasInterfaceContextualSerializers$kotlinx_serialization_core();

    @ExperimentalSerializationApi
    public abstract <T> DeserializationStrategy<T> getPolymorphic(KClass<? super T> kClass, String string2);

    @ExperimentalSerializationApi
    public abstract <T> SerializationStrategy<T> getPolymorphic(KClass<? super T> kClass, T t2);
}

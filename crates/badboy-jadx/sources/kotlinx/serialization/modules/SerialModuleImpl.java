package kotlinx.serialization.modules;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001Bî\u0001\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012*\u0010\u0006\u001a&\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0018\u0012\u0016\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00070\u00030\u0003\u0012.\u0010\u0008\u001a*\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u001c\u0012\u001a\u0012\u0002\u0008\u0003\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\n0\tj\u0006\u0012\u0002\u0008\u0003`\u000b0\u0003\u0012&\u0010\u000c\u001a\"\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00070\u00030\u0003\u0012A\u0010\u000e\u001a=\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0011\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00120\tj\u0006\u0012\u0002\u0008\u0003`\u00130\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\u0008\u0016\u0010\u0017J7\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u001b\u0018\u00010\n\"\u0008\u0008\u0000\u0010\u001b*\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0008\u0000\u0012\u0002H\u001b0\u00042\u0006\u0010\u001e\u001a\u0002H\u001bH\u0016¢\u0006\u0002\u0010\u001fJ4\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u001b\u0018\u00010\u0012\"\u0008\u0008\u0000\u0010\u001b*\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0008\u0000\u0012\u0002H\u001b0\u00042\u0008\u0010 \u001a\u0004\u0018\u00010\rH\u0016J:\u0010!\u001a\n\u0012\u0004\u0012\u0002H\u001b\u0018\u00010\u0007\"\u0008\u0008\u0000\u0010\u001b*\u00020\u001c2\u000c\u0010\"\u001a\u0008\u0012\u0004\u0012\u0002H\u001b0\u00042\u0010\u0010#\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00070$H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016R\u001e\u0010\u0002\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0006\u001a&\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0018\u0012\u0016\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00070\u00030\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R6\u0010\u0008\u001a*\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u001c\u0012\u001a\u0012\u0002\u0008\u0003\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\n0\tj\u0006\u0012\u0002\u0008\u0003`\u000b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u000c\u001a\"\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00070\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RI\u0010\u000e\u001a=\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0011\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00120\tj\u0006\u0012\u0002\u0008\u0003`\u00130\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0090\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019¨\u0006)", d2 = {"Lkotlinx/serialization/modules/SerialModuleImpl;", "Lkotlinx/serialization/modules/SerializersModule;", "class2ContextualFactory", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/modules/ContextualProvider;", "polyBase2Serializers", "Lkotlinx/serialization/KSerializer;", "polyBase2DefaultSerializerProvider", "Lkotlin/Function1;", "Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicSerializerProvider;", "polyBase2NamedSerializers", "", "polyBase2DefaultDeserializerProvider", "Lkotlin/ParameterName;", "name", "className", "Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicDeserializerProvider;", "hasInterfaceContextualSerializers", "", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Z)V", "getHasInterfaceContextualSerializers$kotlinx_serialization_core", "()Z", "getPolymorphic", "T", "", "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "serializedClassName", "getContextual", "kClass", "typeArgumentsSerializers", "", "dumpTo", "", "collector", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SerialModuleImpl extends kotlinx.serialization.modules.SerializersModule {

    private final Map<KClass<?>, kotlinx.serialization.modules.ContextualProvider> class2ContextualFactory;
    private final boolean hasInterfaceContextualSerializers;
    private final Map<KClass<?>, Function1<String, DeserializationStrategy<?>>> polyBase2DefaultDeserializerProvider;
    private final Map<KClass<?>, Function1<?, SerializationStrategy<?>>> polyBase2DefaultSerializerProvider;
    private final Map<KClass<?>, Map<String, KSerializer<?>>> polyBase2NamedSerializers;
    public final Map<KClass<?>, Map<KClass<?>, KSerializer<?>>> polyBase2Serializers;
    public SerialModuleImpl(Map<KClass<?>, ? extends kotlinx.serialization.modules.ContextualProvider> class2ContextualFactory, Map<KClass<?>, ? extends Map<KClass<?>, ? extends KSerializer<?>>> polyBase2Serializers, Map<KClass<?>, ? extends Function1<?, ? extends SerializationStrategy<?>>> polyBase2DefaultSerializerProvider, Map<KClass<?>, ? extends Map<String, ? extends KSerializer<?>>> polyBase2NamedSerializers, Map<KClass<?>, ? extends Function1<? super String, ? extends DeserializationStrategy<?>>> polyBase2DefaultDeserializerProvider, boolean hasInterfaceContextualSerializers) {
        Intrinsics.checkNotNullParameter(class2ContextualFactory, "class2ContextualFactory");
        Intrinsics.checkNotNullParameter(polyBase2Serializers, "polyBase2Serializers");
        Intrinsics.checkNotNullParameter(polyBase2DefaultSerializerProvider, "polyBase2DefaultSerializerProvider");
        Intrinsics.checkNotNullParameter(polyBase2NamedSerializers, "polyBase2NamedSerializers");
        Intrinsics.checkNotNullParameter(polyBase2DefaultDeserializerProvider, "polyBase2DefaultDeserializerProvider");
        super(0);
        this.class2ContextualFactory = class2ContextualFactory;
        this.polyBase2Serializers = polyBase2Serializers;
        this.polyBase2DefaultSerializerProvider = polyBase2DefaultSerializerProvider;
        this.polyBase2NamedSerializers = polyBase2NamedSerializers;
        this.polyBase2DefaultDeserializerProvider = polyBase2DefaultDeserializerProvider;
        this.hasInterfaceContextualSerializers = hasInterfaceContextualSerializers;
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public void dumpTo(kotlinx.serialization.modules.SerializersModuleCollector collector) {
        Map $this$forEach$iv2;
        int i4;
        Object next4;
        boolean next;
        boolean next5;
        boolean next3;
        KSerializer serializer;
        int beforeCheckcastToFunctionOfArity;
        Object key2;
        Object value;
        String value2;
        int beforeCheckcastToFunctionOfArity2;
        Iterator iterator;
        boolean next2;
        int i2;
        Object key;
        Object value3;
        Object obj;
        int i;
        Map $this$forEach$iv;
        int i3;
        final Object obj2 = this;
        final Object obj3 = collector;
        Intrinsics.checkNotNullParameter(obj3, "collector");
        int i5 = 0;
        Iterator iterator2 = obj2.class2ContextualFactory.entrySet().iterator();
        String str2 = "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>";
        for (Map.Entry next4 : iterator2) {
            beforeCheckcastToFunctionOfArity = 0;
            key2 = next4.getKey();
            value = next4.getValue();
            obj3.contextual((KClass)key2, (ContextualProvider.WithTypeArguments)(ContextualProvider)value.getProvider());
            str2 = "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>";
            Intrinsics.checkNotNull(key2, str2);
            serializer = (ContextualProvider.Argless)value.getSerializer();
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
            obj3.contextual(key2, serializer);
        }
        i4 = 0;
        Iterator iterator3 = obj2.polyBase2Serializers.entrySet().iterator();
        for (Map.Entry next : iterator3) {
            beforeCheckcastToFunctionOfArity = 0;
            key2 = next.getKey();
            beforeCheckcastToFunctionOfArity2 = 0;
            iterator = (Map)next.getValue().entrySet().iterator();
            for (Map.Entry next2 : iterator) {
                i2 = 0;
                key = next2.getKey();
                Intrinsics.checkNotNull((KClass)key2, str2);
                Intrinsics.checkNotNull((KClass)key, str2);
                i = 0;
                Object $i$f$forEach = obj;
                Intrinsics.checkNotNull($i$f$forEach, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                obj3.polymorphic(key2, key, $i$f$forEach);
                $this$forEach$iv2 = $this$forEach$iv;
                i4 = i3;
            }
            $this$forEach$iv = $this$forEach$iv2;
            i3 = i4;
            next2 = iterator.next();
            i2 = 0;
            key = (Map.Entry)next2.getKey();
            Intrinsics.checkNotNull(key2, str2);
            Intrinsics.checkNotNull((KClass)key, str2);
            i = 0;
            $i$f$forEach = obj;
            Intrinsics.checkNotNull($i$f$forEach, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            obj3.polymorphic(key2, key, $i$f$forEach);
            $this$forEach$iv2 = $this$forEach$iv;
            i4 = i3;
        }
        Map $this$forEach$iv6 = $this$forEach$iv2;
        int i9 = i4;
        int i6 = 0;
        Iterator iterator4 = obj2.polyBase2DefaultSerializerProvider.entrySet().iterator();
        int i8 = 1;
        for (Map.Entry next5 : iterator4) {
            key2 = 0;
            value = next5.getKey();
            value2 = next5.getValue();
            Intrinsics.checkNotNull((KClass)value, str2);
            Intrinsics.checkNotNull((Function1)value2, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"value\")] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>");
            obj3.polymorphicDefaultSerializer(value, (Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(value2, i8));
            i8 = 1;
        }
        int i7 = 0;
        Iterator iterator5 = obj2.polyBase2DefaultDeserializerProvider.entrySet().iterator();
        for (Map.Entry next3 : iterator5) {
            key2 = 0;
            value = next3.getKey();
            value2 = next3.getValue();
            Intrinsics.checkNotNull((KClass)value, str2);
            Intrinsics.checkNotNull((Function1)value2, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"className\")] kotlin.String?, kotlinx.serialization.DeserializationStrategy<kotlin.Any>?>");
            obj3.polymorphicDefaultDeserializer(value, (Function1)TypeIntrinsics.beforeCheckcastToFunctionOfArity(value2, i8));
        }
    }

    public <T> KSerializer<T> getContextual(KClass<T> kClass, List<? extends KSerializer<?>> typeArgumentsSerializers) {
        KSerializer invoke;
        int i;
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
        Object obj = this.class2ContextualFactory.get(kClass);
        if ((ContextualProvider)obj != null) {
            invoke = (ContextualProvider)obj.invoke(typeArgumentsSerializers);
        } else {
            invoke = i;
        }
        if (invoke instanceof KSerializer) {
            i = invoke;
        }
        return i;
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public boolean getHasInterfaceContextualSerializers$kotlinx_serialization_core() {
        return this.hasInterfaceContextualSerializers;
    }

    public <T> DeserializationStrategy<T> getPolymorphic(KClass<? super T> baseClass, String serializedClassName) {
        int i;
        int invoke;
        int obj;
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Object obj2 = this.polyBase2NamedSerializers.get(baseClass);
        invoke = 0;
        if ((Map)obj2 != null) {
            i = (Map)obj2.get(serializedClassName);
        } else {
            i = invoke;
        }
        if (i instanceof KSerializer) {
        } else {
            i = invoke;
        }
        if (i != 0) {
            return (DeserializationStrategy)i;
        }
        if (TypeIntrinsics.isFunctionOfArity(this.polyBase2DefaultDeserializerProvider.get(baseClass), 1)) {
        } else {
            obj = invoke;
        }
        if (obj != null) {
            invoke = obj.invoke(serializedClassName);
        }
        return invoke;
    }

    public <T> SerializationStrategy<T> getPolymorphic(KClass<? super T> baseClass, T value) {
        Object obj2;
        int invoke;
        KClass orCreateKotlinClass;
        Object obj;
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(value, "value");
        invoke = 0;
        if (!baseClass.isInstance(value)) {
            return invoke;
        }
        Object obj3 = this.polyBase2Serializers.get(baseClass);
        if ((Map)obj3 != null) {
            obj2 = (Map)obj3.get(Reflection.getOrCreateKotlinClass(value.getClass()));
        } else {
            obj2 = invoke;
        }
        if (obj2 instanceof SerializationStrategy) {
        } else {
            obj2 = invoke;
        }
        if (obj2 != null) {
            return obj2;
        }
        if (TypeIntrinsics.isFunctionOfArity(this.polyBase2DefaultSerializerProvider.get(baseClass), 1)) {
        } else {
            obj = invoke;
        }
        if (obj != null) {
            invoke = obj.invoke(value);
        }
        return invoke;
    }
}

package kotlinx.serialization.modules;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.PlatformKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u00002\u00020\u0001B\t\u0008\u0001¢\u0006\u0004\u0008\u0002\u0010\u0003J.\u0010\u0018\u001a\u00020\u0019\"\u0008\u0008\u0000\u0010\u001a*\u00020\u001b2\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u0002H\u001a0\u00062\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u0002H\u001a0\tH\u0016JQ\u0010\u0018\u001a\u00020\u0019\"\u0008\u0008\u0000\u0010\u001a*\u00020\u001b2\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u0002H\u001a0\u00062/\u0010\u001e\u001a+\u0012\u001d\u0012\u001b\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\t0\u001f¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008( \u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\t0\u000bH\u0016JF\u0010!\u001a\u00020\u0019\"\u0008\u0008\u0000\u0010\"*\u00020\u001b\"\u0008\u0008\u0001\u0010#*\u0002H\"2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\"0\u00062\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u0002H#0\u00062\u000c\u0010&\u001a\u0008\u0012\u0004\u0012\u0002H#0\tH\u0016JK\u0010'\u001a\u00020\u0019\"\u0008\u0008\u0000\u0010\"*\u00020\u001b2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\"0\u00062)\u0010(\u001a%\u0012\u0013\u0012\u0011H\"¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008()\u0012\u000c\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010\u000c0\u000bH\u0016JM\u0010*\u001a\u00020\u0019\"\u0008\u0008\u0000\u0010\"*\u00020\u001b2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\"0\u00062+\u0010+\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u000c\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010\u00140\u000bH\u0016J\u000e\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.J2\u0010/\u001a\u00020\u0019\"\u0008\u0008\u0000\u0010\u001a*\u00020\u001b2\u000c\u00100\u001a\u0008\u0012\u0004\u0012\u0002H\u001a0\u00062\u0006\u0010\u001e\u001a\u00020\u00072\u0008\u0008\u0002\u00101\u001a\u00020\u0017H\u0001JS\u00102\u001a\u00020\u0019\"\u0008\u0008\u0000\u0010\"*\u00020\u001b2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\"0\u00062)\u0010(\u001a%\u0012\u0013\u0012\u0011H\"¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008()\u0012\u000c\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010\u000c0\u000b2\u0006\u00101\u001a\u00020\u0017H\u0001JU\u00103\u001a\u00020\u0019\"\u0008\u0008\u0000\u0010\"*\u00020\u001b2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\"0\u00062+\u0010+\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u000c\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010\u00140\u000b2\u0006\u00101\u001a\u00020\u0017H\u0001JP\u00104\u001a\u00020\u0019\"\u0008\u0008\u0000\u0010\"*\u00020\u001b\"\u0008\u0008\u0001\u0010#*\u0002H\"2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\"0\u00062\u000c\u00105\u001a\u0008\u0012\u0004\u0012\u0002H#0\u00062\u000c\u00106\u001a\u0008\u0012\u0004\u0012\u0002H#0\t2\u0008\u0008\u0002\u00101\u001a\u00020\u0017H\u0001J\u0008\u00107\u001a\u00020.H\u0001R\u001e\u0010\u0004\u001a\u0012\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0008\u001a&\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0006\u0012\u0018\u0012\u0016\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0006\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\t0\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\n\u001a*\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0006\u0012\u001c\u0012\u001a\u0012\u0002\u0008\u0003\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u000c0\u000bj\u0006\u0012\u0002\u0008\u0003`\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u000e\u001a\"\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\t0\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RI\u0010\u0010\u001a=\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0006\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00140\u000bj\u0006\u0012\u0002\u0008\u0003`\u00150\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068", d2 = {"Lkotlinx/serialization/modules/SerializersModuleBuilder;", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "<init>", "()V", "class2ContextualProvider", "", "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/modules/ContextualProvider;", "polyBase2Serializers", "Lkotlinx/serialization/KSerializer;", "polyBase2DefaultSerializerProvider", "Lkotlin/Function1;", "Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicSerializerProvider;", "polyBase2NamedSerializers", "", "polyBase2DefaultDeserializerProvider", "Lkotlin/ParameterName;", "name", "className", "Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicDeserializerProvider;", "hasInterfaceContextualSerializers", "", "contextual", "", "T", "", "kClass", "serializer", "provider", "", "typeArgumentsSerializers", "polymorphic", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "polymorphicDefaultSerializer", "defaultSerializerProvider", "value", "polymorphicDefaultDeserializer", "defaultDeserializerProvider", "include", "module", "Lkotlinx/serialization/modules/SerializersModule;", "registerSerializer", "forClass", "allowOverwrite", "registerDefaultPolymorphicSerializer", "registerDefaultPolymorphicDeserializer", "registerPolymorphicSerializer", "concreteClass", "concreteSerializer", "build", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SerializersModuleBuilder implements kotlinx.serialization.modules.SerializersModuleCollector {

    private final Map<KClass<?>, kotlinx.serialization.modules.ContextualProvider> class2ContextualProvider;
    private boolean hasInterfaceContextualSerializers;
    private final Map<KClass<?>, Function1<String, DeserializationStrategy<?>>> polyBase2DefaultDeserializerProvider;
    private final Map<KClass<?>, Function1<?, SerializationStrategy<?>>> polyBase2DefaultSerializerProvider;
    private final Map<KClass<?>, Map<String, KSerializer<?>>> polyBase2NamedSerializers;
    private final Map<KClass<?>, Map<KClass<?>, KSerializer<?>>> polyBase2Serializers;
    public SerializersModuleBuilder() {
        super();
        HashMap hashMap = new HashMap();
        this.class2ContextualProvider = (Map)hashMap;
        HashMap hashMap2 = new HashMap();
        this.polyBase2Serializers = (Map)hashMap2;
        HashMap hashMap3 = new HashMap();
        this.polyBase2DefaultSerializerProvider = (Map)hashMap3;
        HashMap hashMap4 = new HashMap();
        this.polyBase2NamedSerializers = (Map)hashMap4;
        HashMap hashMap5 = new HashMap();
        this.polyBase2DefaultDeserializerProvider = (Map)hashMap5;
    }

    public static void registerPolymorphicSerializer$default(kotlinx.serialization.modules.SerializersModuleBuilder serializersModuleBuilder, KClass kClass2, KClass kClass3, KSerializer kSerializer4, boolean z5, int i6, Object object7) {
        int obj4;
        if (i6 &= 8 != 0) {
            obj4 = 0;
        }
        serializersModuleBuilder.registerPolymorphicSerializer(kClass2, kClass3, kSerializer4, obj4);
    }

    public static void registerSerializer$default(kotlinx.serialization.modules.SerializersModuleBuilder serializersModuleBuilder, KClass kClass2, kotlinx.serialization.modules.ContextualProvider contextualProvider3, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        serializersModuleBuilder.registerSerializer(kClass2, contextualProvider3, obj3);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public final kotlinx.serialization.modules.SerializersModule build() {
        SerialModuleImpl serialModuleImpl = new SerialModuleImpl(this.class2ContextualProvider, this.polyBase2Serializers, this.polyBase2DefaultSerializerProvider, this.polyBase2NamedSerializers, this.polyBase2DefaultDeserializerProvider, this.hasInterfaceContextualSerializers);
        return (SerializersModule)serialModuleImpl;
    }

    public <T> void contextual(KClass<T> kClass, Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> provider) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(provider, "provider");
        ContextualProvider.WithTypeArguments withTypeArguments = new ContextualProvider.WithTypeArguments(provider);
        SerializersModuleBuilder.registerSerializer$default(this, kClass, (ContextualProvider)withTypeArguments, false, 4, 0);
    }

    public <T> void contextual(KClass<T> kClass, KSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        ContextualProvider.Argless argless = new ContextualProvider.Argless(serializer);
        SerializersModuleBuilder.registerSerializer$default(this, kClass, (ContextualProvider)argless, false, 4, 0);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public final void include(kotlinx.serialization.modules.SerializersModule module) {
        Intrinsics.checkNotNullParameter(module, "module");
        module.dumpTo((SerializersModuleCollector)this);
    }

    public <Base, Sub extends Base> void polymorphic(KClass<Base> baseClass, KClass<Sub> actualClass, KSerializer<Sub> actualSerializer) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(actualClass, "actualClass");
        Intrinsics.checkNotNullParameter(actualSerializer, "actualSerializer");
        SerializersModuleBuilder.registerPolymorphicSerializer$default(this, baseClass, actualClass, actualSerializer, false, 8, 0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer", replaceWith = @ReplaceWith(...))
    public <Base> void polymorphicDefault(KClass<Base> baseClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider) {
        SerializersModuleCollector.DefaultImpls.polymorphicDefault(this, baseClass, defaultDeserializerProvider);
    }

    public <Base> void polymorphicDefaultDeserializer(KClass<Base> baseClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
        registerDefaultPolymorphicDeserializer(baseClass, defaultDeserializerProvider, false);
    }

    public <Base> void polymorphicDefaultSerializer(KClass<Base> baseClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> defaultSerializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultSerializerProvider, "defaultSerializerProvider");
        registerDefaultPolymorphicSerializer(baseClass, defaultSerializerProvider, false);
    }

    public final <Base> void registerDefaultPolymorphicDeserializer(KClass<Base> baseClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider, boolean allowOverwrite) {
        boolean equal;
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
        Object obj = this.polyBase2DefaultDeserializerProvider.get(baseClass);
        if (obj != null && !Intrinsics.areEqual((Function1)obj, defaultDeserializerProvider)) {
            if (!Intrinsics.areEqual(obj, defaultDeserializerProvider)) {
                if (!allowOverwrite) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Default deserializers provider for ").append(baseClass).append(" is already registered: ").append(obj).toString());
                throw illegalArgumentException;
            }
        }
        this.polyBase2DefaultDeserializerProvider.put(baseClass, defaultDeserializerProvider);
    }

    public final <Base> void registerDefaultPolymorphicSerializer(KClass<Base> baseClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> defaultSerializerProvider, boolean allowOverwrite) {
        boolean equal;
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultSerializerProvider, "defaultSerializerProvider");
        Object obj = this.polyBase2DefaultSerializerProvider.get(baseClass);
        if (obj != null && !Intrinsics.areEqual((Function1)obj, defaultSerializerProvider)) {
            if (!Intrinsics.areEqual(obj, defaultSerializerProvider)) {
                if (!allowOverwrite) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Default serializers provider for ").append(baseClass).append(" is already registered: ").append(obj).toString());
                throw illegalArgumentException;
            }
        }
        this.polyBase2DefaultSerializerProvider.put(baseClass, defaultSerializerProvider);
    }

    public final <Base, Sub extends Base> void registerPolymorphicSerializer(KClass<Base> baseClass, KClass<Sub> concreteClass, KSerializer<Sub> concreteSerializer, boolean allowOverwrite) {
        int i2;
        int serialName;
        int i3;
        Object hashMap;
        int i;
        Object hashMap2;
        int i4;
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(concreteClass, "concreteClass");
        Intrinsics.checkNotNullParameter(concreteSerializer, "concreteSerializer");
        String serialName2 = concreteSerializer.getDescriptor().getSerialName();
        Map polyBase2Serializers = this.polyBase2Serializers;
        int i5 = 0;
        Object obj2 = polyBase2Serializers.get(baseClass);
        if (obj2 == null) {
            i2 = 0;
            i3 = 0;
            hashMap = new HashMap();
            polyBase2Serializers.put(baseClass, hashMap);
        } else {
            hashMap = obj2;
        }
        HashMap $this$getOrPut$iv = hashMap;
        Object obj = (Map)$this$getOrPut$iv.get(concreteClass);
        Map polyBase2NamedSerializers = this.polyBase2NamedSerializers;
        serialName = 0;
        Object obj4 = polyBase2NamedSerializers.get(baseClass);
        if (obj4 == null) {
            hashMap = 0;
            i = 0;
            hashMap2 = new HashMap();
            polyBase2NamedSerializers.put(baseClass, hashMap2);
        } else {
            hashMap2 = obj4;
        }
        HashMap $this$getOrPut$iv2 = hashMap2;
        if (allowOverwrite && (KSerializer)obj != null) {
            if ((KSerializer)obj != null) {
                (Map)$this$getOrPut$iv2.remove((KSerializer)obj.getDescriptor().getSerialName());
            }
            $this$getOrPut$iv.put(concreteClass, concreteSerializer);
            $this$getOrPut$iv2.put(serialName2, concreteSerializer);
        }
        if (obj != null) {
            if (!Intrinsics.areEqual(obj, concreteSerializer)) {
            } else {
                serialName = $this$getOrPut$iv2.remove(obj.getDescriptor().getSerialName());
            }
            SerializerAlreadyRegisteredException serializerAlreadyRegisteredException = new SerializerAlreadyRegisteredException(baseClass, concreteClass);
            throw serializerAlreadyRegisteredException;
        }
        Object obj3 = $this$getOrPut$iv2.get(serialName2);
        if ((KSerializer)obj3 != null) {
            Object obj5 = this.polyBase2Serializers.get(baseClass);
            Intrinsics.checkNotNull(obj5);
            Iterator iterator = MapsKt.asSequence((Map)obj5).iterator();
            while (iterator.hasNext()) {
                hashMap2 = null;
                if ((Map.Entry)iterator.next().getValue() == (KSerializer)obj3) {
                } else {
                }
                i4 = 0;
                i4 = 1;
            }
            hashMap = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Multiple polymorphic serializers for base class '").append(baseClass).append("' have the same serial name '").append(serialName2).append("': '").append(concreteClass).append("' and '").append((Map.Entry)hashMap).append('\'').toString());
            throw illegalArgumentException;
        }
        $this$getOrPut$iv.put(concreteClass, concreteSerializer);
        $this$getOrPut$iv2.put(serialName2, concreteSerializer);
    }

    public final <T> void registerSerializer(KClass<T> forClass, kotlinx.serialization.modules.ContextualProvider provider, boolean allowOverwrite) {
        Object str;
        boolean interface;
        boolean equal;
        Intrinsics.checkNotNullParameter(forClass, "forClass");
        Intrinsics.checkNotNullParameter(provider, "provider");
        str = this.class2ContextualProvider.get(forClass);
        if (!allowOverwrite && (ContextualProvider)str != null) {
            str = this.class2ContextualProvider.get(forClass);
            if ((ContextualProvider)(ContextualProvider)str != null) {
                if (!Intrinsics.areEqual((ContextualProvider)(ContextualProvider)str, provider)) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                SerializerAlreadyRegisteredException serializerAlreadyRegisteredException = new SerializerAlreadyRegisteredException(stringBuilder.append("Contextual serializer or serializer provider for ").append(forClass).append(" already registered in this module").toString());
                throw serializerAlreadyRegisteredException;
            }
        }
        this.class2ContextualProvider.put(forClass, provider);
        if (PlatformKt.isInterface(forClass)) {
            this.hasInterfaceContextualSerializers = true;
        }
    }
}

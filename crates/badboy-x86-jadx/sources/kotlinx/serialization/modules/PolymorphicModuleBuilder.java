package kotlinx.serialization.modules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\n\u0008\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0002B)\u0008\u0001\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0010\u0008\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0004\u0008\u0007\u0010\u0008J,\u0010\u0012\u001a\u00020\u0013\"\u0008\u0008\u0001\u0010\u0014*\u00028\u00002\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u00042\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00140\u0006J3\u0010\u0016\u001a\u00020\u00132+\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\u0019\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00110\rJ5\u0010\u001a\u001a\u00020\u00132+\u0010\u000c\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\u0019\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00110\rH\u0007J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0001R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\t\u001a$\u0012 \u0012\u001e\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u0004\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u00060\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000c\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "Base", "", "baseClass", "Lkotlin/reflect/KClass;", "baseSerializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)V", "subclasses", "", "Lkotlin/Pair;", "defaultSerializerProvider", "Lkotlin/Function1;", "Lkotlinx/serialization/SerializationStrategy;", "defaultDeserializerProvider", "", "Lkotlinx/serialization/DeserializationStrategy;", "subclass", "", "T", "serializer", "defaultDeserializer", "Lkotlin/ParameterName;", "name", "className", "default", "buildTo", "builder", "Lkotlinx/serialization/modules/SerializersModuleBuilder;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PolymorphicModuleBuilder<Base>  {

    private final KClass<Base> baseClass;
    private final KSerializer<Base> baseSerializer;
    private Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider;
    private Function1<? super Base, ? extends SerializationStrategy<? super Base>> defaultSerializerProvider;
    private final List<Pair<KClass<? extends Base>, KSerializer<? extends Base>>> subclasses;
    public PolymorphicModuleBuilder(KClass<Base> baseClass, KSerializer<Base> baseSerializer) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        super();
        this.baseClass = baseClass;
        this.baseSerializer = baseSerializer;
        ArrayList arrayList = new ArrayList();
        this.subclasses = (List)arrayList;
    }

    public PolymorphicModuleBuilder(KClass kClass, KSerializer kSerializer2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(kClass, obj2);
    }

    public final void buildTo(kotlinx.serialization.modules.SerializersModuleBuilder builder) {
        Object obj;
        List subclasses;
        Object baseSerializer2;
        KClass baseClass2;
        KSerializer baseSerializer;
        int baseClass;
        int i3;
        int i2;
        Object next;
        int i;
        Object obj2;
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (this.baseSerializer != null) {
            SerializersModuleBuilder.registerPolymorphicSerializer$default(builder, this.baseClass, this.baseClass, this.baseSerializer, false, 8, 0);
        }
        final int i6 = 0;
        final Iterator iterator = (Iterable)this.subclasses.iterator();
        for (Object next : iterator) {
            Object obj3 = next;
            i = 0;
            baseClass2 = component1;
            Intrinsics.checkNotNull((KClass)baseClass2, "null cannot be cast to non-null type kotlin.reflect.KClass<Base of kotlinx.serialization.modules.PolymorphicModuleBuilder>");
            baseSerializer = obj2;
            int i4 = 0;
            Intrinsics.checkNotNull(baseSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            SerializersModuleBuilder.registerPolymorphicSerializer$default(builder, this.baseClass, baseClass2, baseSerializer, false, 8, 0);
        }
        Function1 defaultSerializerProvider = this.defaultSerializerProvider;
        int i5 = 0;
        if (defaultSerializerProvider != null) {
            builder.registerDefaultPolymorphicSerializer(this.baseClass, defaultSerializerProvider, i5);
        }
        Function1 defaultDeserializerProvider = this.defaultDeserializerProvider;
        if (defaultDeserializerProvider != null) {
            builder.registerDefaultPolymorphicDeserializer(this.baseClass, defaultDeserializerProvider, i5);
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of function with more precise name: defaultDeserializer", replaceWith = @ReplaceWith(...))
    public final void default(Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultSerializerProvider) {
        Intrinsics.checkNotNullParameter(defaultSerializerProvider, "defaultSerializerProvider");
        defaultDeserializer(defaultSerializerProvider);
    }

    public final void defaultDeserializer(Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider) {
        int i;
        Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
        i = this.defaultDeserializerProvider == null ? 1 : 0;
        if (i == 0) {
        } else {
            this.defaultDeserializerProvider = defaultDeserializerProvider;
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Default deserializer provider is already registered for class ").append(this.baseClass).append(": ").append(this.defaultDeserializerProvider).toString().toString());
        throw illegalArgumentException;
    }

    public final <T extends Base> void subclass(KClass<T> subclass, KSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(subclass, "subclass");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.subclasses.add(TuplesKt.to(subclass, serializer));
    }
}

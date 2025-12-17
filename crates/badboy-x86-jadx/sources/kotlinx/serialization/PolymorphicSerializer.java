package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.PolymorphicKind.OPEN;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind.CONTEXTUAL;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\u0008\u0006\u0010\u0007B%\u0008\u0011\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\u0008\u0006\u0010\u000bJ\u0008\u0010\u0016\u001a\u00020\u0017H\u0016R\u001a\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0014\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u0015\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006\u0018", d2 = {"Lkotlinx/serialization/PolymorphicSerializer;", "T", "", "Lkotlinx/serialization/internal/AbstractPolymorphicSerializer;", "baseClass", "Lkotlin/reflect/KClass;", "<init>", "(Lkotlin/reflect/KClass;)V", "classAnnotations", "", "", "(Lkotlin/reflect/KClass;[Ljava/lang/annotation/Annotation;)V", "getBaseClass", "()Lkotlin/reflect/KClass;", "_annotations", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lkotlin/Lazy;", "toString", "", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PolymorphicSerializer<T>  extends AbstractPolymorphicSerializer<T> {

    private List<? extends Annotation> _annotations;
    private final KClass<T> baseClass;
    private final Lazy descriptor$delegate;
    public static SerialDescriptor $r8$lambda$6EKP3bxERH5YJPjPHsTd5thYe-8(kotlinx.serialization.PolymorphicSerializer polymorphicSerializer) {
        return PolymorphicSerializer.descriptor_delegate$lambda$1(polymorphicSerializer);
    }

    public static Unit $r8$lambda$KIOp2r6bAbWdljehXTvxkt0OQzY(kotlinx.serialization.PolymorphicSerializer polymorphicSerializer, ClassSerialDescriptorBuilder classSerialDescriptorBuilder2) {
        return PolymorphicSerializer.descriptor_delegate$lambda$1$lambda$0(polymorphicSerializer, classSerialDescriptorBuilder2);
    }

    public PolymorphicSerializer(KClass<T> baseClass) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        super();
        this.baseClass = baseClass;
        this._annotations = CollectionsKt.emptyList();
        PolymorphicSerializer$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new PolymorphicSerializer$$ExternalSyntheticLambda1(this);
        this.descriptor$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, externalSyntheticLambda1);
    }

    public PolymorphicSerializer(KClass<T> baseClass, Annotation[] classAnnotations) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(classAnnotations, "classAnnotations");
        super(baseClass);
        this._annotations = ArraysKt.asList(classAnnotations);
    }

    private static final SerialDescriptor descriptor_delegate$lambda$1(kotlinx.serialization.PolymorphicSerializer this$0) {
        PolymorphicSerializer$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new PolymorphicSerializer$$ExternalSyntheticLambda0(this$0);
        return ContextAwareKt.withContext(SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.Polymorphic", (SerialKind)PolymorphicKind.OPEN.INSTANCE, new SerialDescriptor[0], externalSyntheticLambda0), this$0.getBaseClass());
    }

    private static final Unit descriptor_delegate$lambda$1$lambda$0(kotlinx.serialization.PolymorphicSerializer this$0, ClassSerialDescriptorBuilder $this$buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter($this$buildSerialDescriptor, "$this$buildSerialDescriptor");
        final int i11 = 0;
        ClassSerialDescriptorBuilder.element$default($this$buildSerialDescriptor, "type", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), 0, false, 12, i11);
        StringBuilder stringBuilder = new StringBuilder();
        ClassSerialDescriptorBuilder.element$default($this$buildSerialDescriptor, "value", SerialDescriptorsKt.buildSerialDescriptor$default(stringBuilder.append("kotlinx.serialization.Polymorphic<").append(this$0.getBaseClass().getSimpleName()).append('>').toString(), (SerialKind)SerialKind.CONTEXTUAL.INSTANCE, new SerialDescriptor[0], 0, 8, i11), 0, false, 12, i11);
        $this$buildSerialDescriptor.setAnnotations(this$0._annotations);
        return Unit.INSTANCE;
    }

    public KClass<T> getBaseClass() {
        return this.baseClass;
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor)this.descriptor$delegate.getValue();
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("kotlinx.serialization.PolymorphicSerializer(baseClass: ").append(getBaseClass()).append(')').toString();
    }
}

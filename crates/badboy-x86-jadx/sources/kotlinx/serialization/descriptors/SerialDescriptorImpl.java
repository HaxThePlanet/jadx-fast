package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.internal.CachedNames;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptorKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u001b\n\u0002\u0008\u0003\n\u0002\u0010\"\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0006\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010$\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0004\u0008\r\u0010\u000eJ\u0010\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0008H\u0016J\u0010\u0010/\u001a\u00020\u00082\u0006\u00100\u001a\u00020\u0004H\u0016J\u0016\u00101\u001a\u0008\u0012\u0004\u0012\u00020\u00160\n2\u0006\u0010.\u001a\u00020\u0008H\u0016J\u0010\u00102\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0008H\u0016J\u0010\u00103\u001a\u0002042\u0006\u0010.\u001a\u00020\u0008H\u0016J\u0013\u00105\u001a\u0002042\u0008\u00106\u001a\u0004\u0018\u000107H\u0096\u0002J\u0008\u00108\u001a\u00020\u0008H\u0016J\u0008\u00109\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00160\nX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u001aX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u0016\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u00010\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u001c\u0010\"\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\n0\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00080'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u001b\u0010)\u001a\u00020\u00088BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008+\u0010,\u001a\u0004\u0008*\u0010\u0014¨\u0006:", d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptorImpl;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "elementsCount", "", "typeParameters", "", "builder", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;ILjava/util/List;Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;)V", "getSerialName", "()Ljava/lang/String;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "getElementsCount", "()I", "annotations", "", "getAnnotations", "()Ljava/util/List;", "serialNames", "", "getSerialNames", "()Ljava/util/Set;", "elementNames", "", "[Ljava/lang/String;", "elementDescriptors", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementAnnotations", "[Ljava/util/List;", "elementOptionality", "", "name2Index", "", "typeParametersDescriptors", "_hashCode", "get_hashCode", "_hashCode$delegate", "Lkotlin/Lazy;", "getElementName", "index", "getElementIndex", "name", "getElementAnnotations", "getElementDescriptor", "isElementOptional", "", "equals", "other", "", "hashCode", "toString", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SerialDescriptorImpl implements kotlinx.serialization.descriptors.SerialDescriptor, CachedNames {

    private final Lazy _hashCode$delegate;
    private final List<Annotation> annotations;
    private final List<Annotation>[] elementAnnotations;
    private final kotlinx.serialization.descriptors.SerialDescriptor[] elementDescriptors;
    private final String[] elementNames;
    private final boolean[] elementOptionality;
    private final int elementsCount;
    private final kotlinx.serialization.descriptors.SerialKind kind;
    private final Map<String, Integer> name2Index;
    private final String serialName;
    private final Set<String> serialNames;
    private final kotlinx.serialization.descriptors.SerialDescriptor[] typeParametersDescriptors;
    public static int $r8$lambda$5V-SQfcoD1sJfwkMIDcFMGE0yyI(kotlinx.serialization.descriptors.SerialDescriptorImpl serialDescriptorImpl) {
        return SerialDescriptorImpl._hashCode_delegate$lambda$1(serialDescriptorImpl);
    }

    public static java.lang.CharSequence $r8$lambda$mnASpSJ9HSI9yUkc_heX_evsxiQ(kotlinx.serialization.descriptors.SerialDescriptorImpl serialDescriptorImpl, int i2) {
        return SerialDescriptorImpl.toString$lambda$3(serialDescriptorImpl, i2);
    }

    public SerialDescriptorImpl(String serialName, kotlinx.serialization.descriptors.SerialKind kind, int elementsCount, List<? extends kotlinx.serialization.descriptors.SerialDescriptor> typeParameters, kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder builder) {
        Object obj;
        Object next;
        Object obj2;
        int i;
        Object value;
        int index;
        final Object obj3 = this;
        obj = serialName;
        final Object obj4 = kind;
        Intrinsics.checkNotNullParameter(obj, "serialName");
        Intrinsics.checkNotNullParameter(obj4, "kind");
        final Object obj5 = typeParameters;
        Intrinsics.checkNotNullParameter(obj5, "typeParameters");
        final Object obj6 = builder;
        Intrinsics.checkNotNullParameter(obj6, "builder");
        super();
        obj3.serialName = obj;
        obj3.kind = obj4;
        obj3.elementsCount = elementsCount;
        obj3.annotations = obj6.getAnnotations();
        obj3.serialNames = (Set)CollectionsKt.toHashSet((Iterable)obj6.getElementNames$kotlinx_serialization_core());
        int i3 = 0;
        int i6 = 0;
        obj3.elementNames = (String[])(Collection)obj6.getElementNames$kotlinx_serialization_core().toArray(new String[i6]);
        obj3.elementDescriptors = Platform_commonKt.compactArray(obj6.getElementDescriptors$kotlinx_serialization_core());
        int i4 = 0;
        obj3.elementAnnotations = (List[])(Collection)obj6.getElementAnnotations$kotlinx_serialization_core().toArray(new List[i6]);
        obj3.elementOptionality = CollectionsKt.toBooleanArray((Collection)obj6.getElementOptionality$kotlinx_serialization_core());
        Iterable index2 = ArraysKt.withIndex(obj3.elementNames);
        int i5 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(index2, 10));
        int i8 = 0;
        final Iterator iterator = index2.iterator();
        for (Object next : iterator) {
            obj2 = next;
            i = 0;
            (Collection)arrayList.add(TuplesKt.to((IndexedValue)obj2.getValue(), Integer.valueOf(obj2.getIndex())));
            obj = serialName;
        }
        obj3.name2Index = MapsKt.toMap((Iterable)(List)arrayList);
        obj3.typeParametersDescriptors = Platform_commonKt.compactArray(obj5);
        SerialDescriptorImpl$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new SerialDescriptorImpl$$ExternalSyntheticLambda0(obj3);
        obj3._hashCode$delegate = LazyKt.lazy(externalSyntheticLambda0);
    }

    private static final int _hashCode_delegate$lambda$1(kotlinx.serialization.descriptors.SerialDescriptorImpl this$0) {
        return PluginGeneratedSerialDescriptorKt.hashCodeImpl((SerialDescriptor)this$0, this$0.typeParametersDescriptors);
    }

    private final int get_hashCode() {
        return (Number)this._hashCode$delegate.getValue().intValue();
    }

    private static final java.lang.CharSequence toString$lambda$3(kotlinx.serialization.descriptors.SerialDescriptorImpl this$0, int it) {
        StringBuilder stringBuilder = new StringBuilder();
        return (CharSequence)stringBuilder.append(this$0.getElementName(it)).append(": ").append(this$0.getElementDescriptor(it).getSerialName()).toString();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean equals(Object other) {
        int i2;
        boolean index$iv;
        int i;
        int elementsCount;
        boolean equals;
        kotlinx.serialization.descriptors.SerialDescriptor[] typeParametersDescriptors;
        final Object obj = this;
        final int i3 = 0;
        i2 = 1;
        if ((SerialDescriptor)obj == other) {
        } else {
            i = 0;
            if (!other instanceof SerialDescriptorImpl) {
                i2 = i;
            } else {
                if (!Intrinsics.areEqual((SerialDescriptor)obj.getSerialName(), (SerialDescriptor)other.getSerialName())) {
                    i2 = i;
                } else {
                    elementsCount = 0;
                    if (!Arrays.equals(this.typeParametersDescriptors, index$iv.typeParametersDescriptors)) {
                        i2 = i;
                    } else {
                        if (obj.getElementsCount() != (SerialDescriptor)other.getElementsCount()) {
                            i2 = i;
                        } else {
                            index$iv = 0;
                            while (index$iv < obj.getElementsCount()) {
                                index$iv++;
                            }
                        }
                    }
                }
            }
        }
        return i2;
    }

    public List<Annotation> getAnnotations() {
        return this.annotations;
    }

    public List<Annotation> getElementAnnotations(int index) {
        final int i = 0;
        return this.elementAnnotations[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public kotlinx.serialization.descriptors.SerialDescriptor getElementDescriptor(int index) {
        final int i = 0;
        return this.elementDescriptors[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementIndex(String name) {
        int intValue;
        Intrinsics.checkNotNullParameter(name, "name");
        Object obj = this.name2Index.get(name);
        if ((Integer)obj != null) {
            intValue = (Integer)obj.intValue();
        } else {
            intValue = -3;
        }
        return intValue;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getElementName(int index) {
        final int i = 0;
        return this.elementNames[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementsCount() {
        return this.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public kotlinx.serialization.descriptors.SerialKind getKind() {
        return this.kind;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getSerialName() {
        return this.serialName;
    }

    public Set<String> getSerialNames() {
        return this.serialNames;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int hashCode() {
        return get_hashCode();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isElementOptional(int index) {
        final int i = 0;
        return this.elementOptionality[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.isInline(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isNullable() {
        return SerialDescriptor.DefaultImpls.isNullable(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        SerialDescriptorImpl$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new SerialDescriptorImpl$$ExternalSyntheticLambda1(this);
        return CollectionsKt.joinToString$default((Iterable)RangesKt.until(0, getElementsCount()), (CharSequence)", ", (CharSequence)stringBuilder.append(getSerialName()).append('(').toString(), (CharSequence)")", 0, 0, externalSyntheticLambda1, 24, 0);
    }
}

package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptor.DefaultImpls;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind.CLASS;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0008\u0003\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\"\n\u0002\u0008\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0011\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0004\u0008\t\u0010\nJ\u0018\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00042\u0008\u0008\u0002\u00108\u001a\u000209J\u000e\u0010:\u001a\u0002062\u0006\u0010;\u001a\u00020\u0015J\u000e\u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020\u0015J\u0010\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u0008H\u0016J\u0010\u0010@\u001a\u0002092\u0006\u0010?\u001a\u00020\u0008H\u0016J\u0016\u0010A\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010?\u001a\u00020\u0008H\u0016J\u0010\u0010B\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u0008H\u0016J\u0010\u0010C\u001a\u00020\u00082\u0006\u00107\u001a\u00020\u0004H\u0016J\u0014\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00080'H\u0002J\u0013\u0010E\u001a\u0002092\u0008\u0010F\u001a\u0004\u0018\u00010GH\u0096\u0002J\u0008\u0010H\u001a\u00020\u0008H\u0016J\u0008\u0010I\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0005\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u001e\u0010\u001c\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001d0\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u00040#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008$\u0010%R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00080'X\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010(\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030)0\u001a8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008,\u0010-\u001a\u0004\u0008*\u0010+R!\u0010.\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u001a8@X\u0080\u0084\u0002¢\u0006\u000c\n\u0004\u00081\u0010-\u001a\u0004\u0008/\u00100R\u001b\u00102\u001a\u00020\u00088BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u00084\u0010-\u001a\u0004\u00083\u0010\u000e¨\u0006J", d2 = {"Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "serialName", "", "generatedSerializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "elementsCount", "", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;I)V", "getSerialName", "()Ljava/lang/String;", "getElementsCount", "()I", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "added", "names", "", "[Ljava/lang/String;", "propertiesAnnotations", "", "[Ljava/util/List;", "classAnnotations", "elementsOptionality", "", "serialNames", "", "getSerialNames", "()Ljava/util/Set;", "indices", "", "childSerializers", "Lkotlinx/serialization/KSerializer;", "getChildSerializers", "()[Lkotlinx/serialization/KSerializer;", "childSerializers$delegate", "Lkotlin/Lazy;", "typeParameterDescriptors", "getTypeParameterDescriptors$kotlinx_serialization_core", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParameterDescriptors$delegate", "_hashCode", "get_hashCode", "_hashCode$delegate", "addElement", "", "name", "isOptional", "", "pushAnnotation", "annotation", "pushClassAnnotation", "a", "getElementDescriptor", "index", "isElementOptional", "getElementAnnotations", "getElementName", "getElementIndex", "buildIndices", "equals", "other", "", "hashCode", "toString", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class PluginGeneratedSerialDescriptor implements SerialDescriptor, kotlinx.serialization.internal.CachedNames {

    private final Lazy _hashCode$delegate;
    private int added;
    private final Lazy childSerializers$delegate;
    private List<Annotation> classAnnotations;
    private final int elementsCount;
    private final boolean[] elementsOptionality;
    private final kotlinx.serialization.internal.GeneratedSerializer<?> generatedSerializer;
    private Map<String, Integer> indices;
    private final String[] names;
    private final List<Annotation>[] propertiesAnnotations;
    private final String serialName;
    private final Lazy typeParameterDescriptors$delegate;
    public static java.lang.CharSequence $r8$lambda$GTOVxxhMu_PmCRfzm2Nhhn4QCQs(kotlinx.serialization.internal.PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, int i2) {
        return PluginGeneratedSerialDescriptor.toString$lambda$6(pluginGeneratedSerialDescriptor, i2);
    }

    public static int $r8$lambda$cDPWE4SK_6AyKNo6PzcexLAZOkg(kotlinx.serialization.internal.PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        return PluginGeneratedSerialDescriptor._hashCode_delegate$lambda$3(pluginGeneratedSerialDescriptor);
    }

    public static SerialDescriptor[] $r8$lambda$lHVbRHJZFJeOCNqxR0MeP9mvMTI(kotlinx.serialization.internal.PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        return PluginGeneratedSerialDescriptor.typeParameterDescriptors_delegate$lambda$2(pluginGeneratedSerialDescriptor);
    }

    public static KSerializer[] $r8$lambda$r9j3qqfSiBWrCfo_6pw28Hdd2Aw(kotlinx.serialization.internal.PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor) {
        return PluginGeneratedSerialDescriptor.childSerializers_delegate$lambda$0(pluginGeneratedSerialDescriptor);
    }

    public PluginGeneratedSerialDescriptor(String serialName, kotlinx.serialization.internal.GeneratedSerializer<?> generatedSerializer, int elementsCount) {
        int i;
        String str;
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        super();
        this.serialName = serialName;
        this.generatedSerializer = generatedSerializer;
        this.elementsCount = elementsCount;
        this.added = -1;
        int elementsCount2 = this.elementsCount;
        String[] strArr = new String[elementsCount2];
        i = 0;
        while (i < elementsCount2) {
            strArr[i] = "[UNINITIALIZED]";
            i++;
        }
        this.names = strArr;
        this.propertiesAnnotations = new List[this.elementsCount];
        this.elementsOptionality = new boolean[this.elementsCount];
        this.indices = MapsKt.emptyMap();
        PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda1(this);
        this.childSerializers$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, externalSyntheticLambda1);
        PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda2 externalSyntheticLambda2 = new PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda2(this);
        this.typeParameterDescriptors$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, externalSyntheticLambda2);
        PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda3 externalSyntheticLambda3 = new PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda3(this);
        this._hashCode$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, externalSyntheticLambda3);
    }

    public PluginGeneratedSerialDescriptor(String string, kotlinx.serialization.internal.GeneratedSerializer generatedSerializer2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj2;
        obj2 = i4 &= 2 != 0 ? 0 : obj2;
        super(string, obj2, i3);
    }

    private static final int _hashCode_delegate$lambda$3(kotlinx.serialization.internal.PluginGeneratedSerialDescriptor this$0) {
        return PluginGeneratedSerialDescriptorKt.hashCodeImpl((SerialDescriptor)this$0, this$0.getTypeParameterDescriptors$kotlinx_serialization_core());
    }

    public static void addElement$default(kotlinx.serialization.internal.PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, String string2, boolean z3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            pluginGeneratedSerialDescriptor.addElement(string2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
        throw obj0;
    }

    private final Map<String, Integer> buildIndices() {
        int i;
        Integer valueOf;
        HashMap map;
        String str;
        HashMap hashMap = new HashMap();
        i = 0;
        while (i < names.length) {
            (Map)hashMap.put(this.names[i], Integer.valueOf(i));
            i++;
        }
        return (Map)hashMap;
    }

    private static final KSerializer[] childSerializers_delegate$lambda$0(kotlinx.serialization.internal.PluginGeneratedSerialDescriptor this$0) {
        KSerializer[] eMPTY_SERIALIZER_ARRAY;
        eMPTY_SERIALIZER_ARRAY = this$0.generatedSerializer;
        if (eMPTY_SERIALIZER_ARRAY != null) {
            if (eMPTY_SERIALIZER_ARRAY.childSerializers() == null) {
                eMPTY_SERIALIZER_ARRAY = PluginHelperInterfacesKt.EMPTY_SERIALIZER_ARRAY;
            }
        } else {
        }
        return eMPTY_SERIALIZER_ARRAY;
    }

    private final KSerializer<?>[] getChildSerializers() {
        return (KSerializer[])this.childSerializers$delegate.getValue();
    }

    private final int get_hashCode() {
        return (Number)this._hashCode$delegate.getValue().intValue();
    }

    private static final java.lang.CharSequence toString$lambda$6(kotlinx.serialization.internal.PluginGeneratedSerialDescriptor this$0, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        return (CharSequence)stringBuilder.append(this$0.getElementName(i)).append(": ").append(this$0.getElementDescriptor(i).getSerialName()).toString();
    }

    private static final SerialDescriptor[] typeParameterDescriptors_delegate$lambda$2(kotlinx.serialization.internal.PluginGeneratedSerialDescriptor this$0) {
        kotlinx.serialization.internal.GeneratedSerializer typeParametersSerializers;
        int i2;
        int arrayList;
        KSerializer[] objArr;
        int i;
        int length;
        int i4;
        KSerializer kSerializer;
        SerialDescriptor it;
        int i3;
        typeParametersSerializers = this$0.generatedSerializer;
        typeParametersSerializers = typeParametersSerializers.typeParametersSerializers();
        if (typeParametersSerializers != null && typeParametersSerializers != null) {
            typeParametersSerializers = typeParametersSerializers.typeParametersSerializers();
            if (typeParametersSerializers != null) {
                i2 = 0;
                arrayList = new ArrayList(typeParametersSerializers.length);
                objArr = typeParametersSerializers;
                i = 0;
                i4 = 0;
                while (i4 < objArr.length) {
                    i3 = 0;
                    (Collection)arrayList.add(objArr[i4].getDescriptor());
                    i4++;
                }
            } else {
                arrayList = 0;
            }
        } else {
        }
        return Platform_commonKt.compactArray(arrayList);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final void addElement(String name, boolean isOptional) {
        int indices;
        Intrinsics.checkNotNullParameter(name, "name");
        this.added = added++;
        this.names[this.added] = name;
        this.elementsOptionality[this.added] = isOptional;
        this.propertiesAnnotations[this.added] = 0;
        if (this.added == elementsCount--) {
            this.indices = buildIndices();
        }
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean equals(Object other) {
        int i;
        boolean index$iv;
        int i2;
        int elementsCount;
        boolean equals;
        SerialDescriptor[] typeParameterDescriptors$kotlinx_serialization_core;
        final Object obj = this;
        final int i3 = 0;
        i = 1;
        if ((SerialDescriptor)obj == other) {
        } else {
            i2 = 0;
            if (!other instanceof PluginGeneratedSerialDescriptor) {
                i = i2;
            } else {
                if (!Intrinsics.areEqual((SerialDescriptor)obj.getSerialName(), (SerialDescriptor)other.getSerialName())) {
                    i = i2;
                } else {
                    elementsCount = 0;
                    if (!Arrays.equals(getTypeParameterDescriptors$kotlinx_serialization_core(), (PluginGeneratedSerialDescriptor)other.getTypeParameterDescriptors$kotlinx_serialization_core())) {
                        i = i2;
                    } else {
                        if (obj.getElementsCount() != (SerialDescriptor)other.getElementsCount()) {
                            i = i2;
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
        return i;
    }

    public List<Annotation> getAnnotations() {
        List classAnnotations;
        if (this.classAnnotations == null) {
            classAnnotations = CollectionsKt.emptyList();
        }
        return classAnnotations;
    }

    public List<Annotation> getElementAnnotations(int index) {
        List $this$getChecked$iv;
        final int i = 0;
        if (this.propertiesAnnotations[index] == null) {
            $this$getChecked$iv = CollectionsKt.emptyList();
        }
        return $this$getChecked$iv;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor getElementDescriptor(int index) {
        final int i = 0;
        return getChildSerializers()[index].getDescriptor();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementIndex(String name) {
        int intValue;
        Intrinsics.checkNotNullParameter(name, "name");
        Object obj = this.indices.get(name);
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
        return this.names[index];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int getElementsCount() {
        return this.elementsCount;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind getKind() {
        return (SerialKind)StructureKind.CLASS.INSTANCE;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getSerialName() {
        return this.serialName;
    }

    public Set<String> getSerialNames() {
        return this.indices.keySet();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor[] getTypeParameterDescriptors$kotlinx_serialization_core() {
        return (SerialDescriptor[])this.typeParameterDescriptors$delegate.getValue();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int hashCode() {
        return get_hashCode();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isElementOptional(int index) {
        final int i = 0;
        return this.elementsOptionality[index];
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
    public final void pushAnnotation(Annotation annotation) {
        Object arrayList;
        List[] propertiesAnnotations;
        int added;
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        List list = this.propertiesAnnotations[this.added];
        int i = 0;
        if (list == null) {
            arrayList = new ArrayList(1);
            this.propertiesAnnotations[this.added] = arrayList;
        } else {
            arrayList = list;
        }
        arrayList.add(annotation);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final void pushClassAnnotation(Annotation a) {
        Object classAnnotations;
        int i;
        Intrinsics.checkNotNullParameter(a, "a");
        if (this.classAnnotations == null) {
            classAnnotations = new ArrayList(1);
            this.classAnnotations = (List)classAnnotations;
        }
        List classAnnotations2 = this.classAnnotations;
        Intrinsics.checkNotNull(classAnnotations2);
        classAnnotations2.add(a);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new PluginGeneratedSerialDescriptor$$ExternalSyntheticLambda0(this);
        return CollectionsKt.joinToString$default((Iterable)RangesKt.until(0, this.elementsCount), (CharSequence)", ", (CharSequence)stringBuilder.append(getSerialName()).append('(').toString(), (CharSequence)")", 0, 0, externalSyntheticLambda0, 24, 0);
    }
}

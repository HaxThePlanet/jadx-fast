package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0008\u0006\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J0\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u001d2\u000e\u0008\u0002\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00102\u0008\u0008\u0002\u0010'\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R$\u0010\u0008\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u0008\u0010\u000c\"\u0004\u0008\r\u0010\u000eR*\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u0012\u0010\u000b\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0018X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0014R\u0014\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u0018X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0014R \u0010\u001f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u00100\u0018X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0014R\u001a\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0018X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u0014¨\u0006(", d2 = {"Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "", "serialName", "", "<init>", "(Ljava/lang/String;)V", "getSerialName", "()Ljava/lang/String;", "isNullable", "", "isNullable$annotations", "()V", "()Z", "setNullable", "(Z)V", "annotations", "", "", "getAnnotations$annotations", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "elementNames", "", "getElementNames$kotlinx_serialization_core", "uniqueNames", "", "elementDescriptors", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors$kotlinx_serialization_core", "elementAnnotations", "getElementAnnotations$kotlinx_serialization_core", "elementOptionality", "getElementOptionality$kotlinx_serialization_core", "element", "", "elementName", "descriptor", "isOptional", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ClassSerialDescriptorBuilder {

    private List<? extends Annotation> annotations;
    private final List<List<Annotation>> elementAnnotations;
    private final List<kotlinx.serialization.descriptors.SerialDescriptor> elementDescriptors;
    private final List<String> elementNames;
    private final List<Boolean> elementOptionality;
    private boolean isNullable;
    private final String serialName;
    private final Set<String> uniqueNames;
    public ClassSerialDescriptorBuilder(String serialName) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        super();
        this.serialName = serialName;
        this.annotations = CollectionsKt.emptyList();
        ArrayList arrayList = new ArrayList();
        this.elementNames = (List)arrayList;
        HashSet hashSet = new HashSet();
        this.uniqueNames = (Set)hashSet;
        ArrayList arrayList2 = new ArrayList();
        this.elementDescriptors = (List)arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.elementAnnotations = (List)arrayList3;
        ArrayList arrayList4 = new ArrayList();
        this.elementOptionality = (List)arrayList4;
    }

    public static void element$default(kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder classSerialDescriptorBuilder, String string2, kotlinx.serialization.descriptors.SerialDescriptor serialDescriptor3, List list4, boolean z5, int i6, Object object7) {
        List obj3;
        int obj4;
        if (i6 & 4 != 0) {
            obj3 = CollectionsKt.emptyList();
        }
        if (i6 &= 8 != 0) {
            obj4 = 0;
        }
        classSerialDescriptorBuilder.element(string2, serialDescriptor3, obj3, obj4);
    }

    @ExperimentalSerializationApi
    public static void getAnnotations$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "isNullable inside buildSerialDescriptor is deprecated. Please use SerialDescriptor.nullable extension on a builder result.")
    @ExperimentalSerializationApi
    public static void isNullable$annotations() {
    }

    public final void element(String elementName, kotlinx.serialization.descriptors.SerialDescriptor descriptor, List<? extends Annotation> annotations, boolean isOptional) {
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        if (!this.uniqueNames.add(elementName)) {
        } else {
            (Collection)this.elementNames.add(elementName);
            (Collection)this.elementDescriptors.add(descriptor);
            (Collection)this.elementAnnotations.add(annotations);
            (Collection)this.elementOptionality.add(Boolean.valueOf(isOptional));
        }
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Element with name '").append(elementName).append("' is already registered in ").append(this.serialName).toString().toString());
        throw illegalArgumentException;
    }

    public final List<Annotation> getAnnotations() {
        return this.annotations;
    }

    public final List<List<Annotation>> getElementAnnotations$kotlinx_serialization_core() {
        return this.elementAnnotations;
    }

    public final List<kotlinx.serialization.descriptors.SerialDescriptor> getElementDescriptors$kotlinx_serialization_core() {
        return this.elementDescriptors;
    }

    public final List<String> getElementNames$kotlinx_serialization_core() {
        return this.elementNames;
    }

    public final List<Boolean> getElementOptionality$kotlinx_serialization_core() {
        return this.elementOptionality;
    }

    public final String getSerialName() {
        return this.serialName;
    }

    public final boolean isNullable() {
        return this.isNullable;
    }

    public final void setAnnotations(List<? extends Annotation> <set-?>) {
        Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
        this.annotations = <set-?>;
    }

    public final void setNullable(boolean <set-?>) {
        this.isNullable = <set-?>;
    }
}

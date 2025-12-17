package kotlinx.serialization.descriptors;

import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u000b\u0008f\u0018\u00002\u00020\u0001J\u0016\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u001f\u001a\u00020\nH'J\u0010\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\nH'J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001aH'J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\nH'J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\nH'R \u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00038VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u0005\u0010\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\t\u001a\u00020\n8&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u000b\u0010\u0006\u001a\u0004\u0008\u000c\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u0010\u0010\u0006\u001a\u0004\u0008\u000e\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000f8VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u0013\u0010\u0006\u001a\u0004\u0008\u0012\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u00158&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u0016\u0010\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001a8&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u001b\u0010\u0006\u001a\u0004\u0008\u001c\u0010\u001d¨\u0006%", d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "annotations", "", "", "getAnnotations$annotations", "()V", "getAnnotations", "()Ljava/util/List;", "elementsCount", "", "getElementsCount$annotations", "getElementsCount", "()I", "isInline", "", "isInline$annotations", "()Z", "isNullable", "isNullable$annotations", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind$annotations", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "serialName", "", "getSerialName$annotations", "getSerialName", "()Ljava/lang/String;", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface SerialDescriptor {
    public abstract String a();

    public abstract int b();

    public abstract String c(int i);

    public abstract kotlinx.serialization.descriptors.SerialDescriptor d(int i);

    public abstract kotlinx.serialization.descriptors.c f();
}

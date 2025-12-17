package kotlinx.serialization.encoding;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\u0008\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0008\u0008H\u0086\u0008ø\u0001\u0000\u001a;\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0019\u0008\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0008\u0008H\u0086\u0008ø\u0001\u0000\u001ab\u0010\t\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u000c*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u000c0\u000e24\u0008\u0004\u0010\u0005\u001a.\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0012\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\u0008\u0008H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0013", d2 = {"encodeStructure", "", "Lkotlinx/serialization/encoding/Encoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "block", "Lkotlin/Function1;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "Lkotlin/ExtensionFunctionType;", "encodeCollection", "collectionSize", "", "E", "collection", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "index", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class EncodingKt {
    public static final void encodeCollection(kotlinx.serialization.encoding.Encoder $this$encodeCollection, SerialDescriptor descriptor, int collectionSize, Function1<? super kotlinx.serialization.encoding.CompositeEncoder, Unit> block) {
        Intrinsics.checkNotNullParameter($this$encodeCollection, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        int i = 0;
        final kotlinx.serialization.encoding.CompositeEncoder beginCollection = $this$encodeCollection.beginCollection(descriptor, collectionSize);
        block.invoke(beginCollection);
        beginCollection.endStructure(descriptor);
    }

    public static final <E> void encodeCollection(kotlinx.serialization.encoding.Encoder $this$encodeCollection, SerialDescriptor descriptor, Collection<? extends E> collection, Function3<? super kotlinx.serialization.encoding.CompositeEncoder, ? super Integer, ? super E, Unit> block) {
        Object obj2;
        int i2;
        int i4;
        Object next;
        int i5;
        Object obj;
        int i3;
        int i;
        final Object obj3 = descriptor;
        obj2 = collection;
        final Object obj4 = block;
        Intrinsics.checkNotNullParameter($this$encodeCollection, "<this>");
        Intrinsics.checkNotNullParameter(obj3, "descriptor");
        Intrinsics.checkNotNullParameter(obj2, "collection");
        Intrinsics.checkNotNullParameter(obj4, "block");
        i2 = 0;
        final int i6 = 0;
        final kotlinx.serialization.encoding.CompositeEncoder beginCollection = $this$encodeCollection.beginCollection(obj3, obj2.size());
        final int i7 = 0;
        final int i8 = 0;
        i4 = 0;
        final Iterator iterator = (Iterable)obj2.iterator();
        while (iterator.hasNext()) {
            if (i4 < 0) {
            }
            i3 = 0;
            obj4.invoke(beginCollection, Integer.valueOf(i4), iterator.next());
            obj2 = collection;
            i4 = i5;
            i2 = i;
            CollectionsKt.throwIndexOverflow();
        }
        beginCollection.endStructure(obj3);
    }

    public static final void encodeStructure(kotlinx.serialization.encoding.Encoder $this$encodeStructure, SerialDescriptor descriptor, Function1<? super kotlinx.serialization.encoding.CompositeEncoder, Unit> block) {
        Intrinsics.checkNotNullParameter($this$encodeStructure, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(block, "block");
        int i = 0;
        final kotlinx.serialization.encoding.CompositeEncoder beginStructure = $this$encodeStructure.beginStructure(descriptor);
        block.invoke(beginStructure);
        beginStructure.endStructure(descriptor);
    }
}

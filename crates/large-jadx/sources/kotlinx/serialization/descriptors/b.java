package kotlinx.serialization.descriptors;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.d.j0.a;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0003\"$\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"$\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\t\u0010\u0004\u001a\u0004\u0008\n\u0010\u0006¨\u0006\u000b", d2 = {"elementDescriptors", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getElementDescriptors", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/lang/Iterable;", "elementNames", "", "getElementNames$annotations", "getElementNames", "kotlinx-serialization-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class b {

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"kotlinx/serialization/descriptors/SerialDescriptorKt$elementDescriptors$1$1", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementsLeft", "", "hasNext", "", "next", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Iterator<kotlinx.serialization.descriptors.SerialDescriptor>, a {

        private int a;
        final kotlinx.serialization.descriptors.SerialDescriptor b;
        a(kotlinx.serialization.descriptors.SerialDescriptor serialDescriptor) {
            this.b = serialDescriptor;
            super();
            this.a = serialDescriptor.b();
        }

        @Override // java.util.Iterator
        public kotlinx.serialization.descriptors.SerialDescriptor c() {
            kotlinx.serialization.descriptors.SerialDescriptor serialDescriptor = this.b;
            final int i3 = this.a;
            this.a = i3 + -1;
            return serialDescriptor.d(i -= i3);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i;
            i = this.a > 0 ? 1 : 0;
            return i;
        }

        @Override // java.util.Iterator
        public Object next() {
            return c();
        }

        @Override // java.util.Iterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004¸\u0006\u0000", d2 = {"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class b implements Iterable<kotlinx.serialization.descriptors.SerialDescriptor>, a {

        final kotlinx.serialization.descriptors.SerialDescriptor a;
        public b(kotlinx.serialization.descriptors.SerialDescriptor serialDescriptor) {
            this.a = serialDescriptor;
            super();
        }

        public Iterator<kotlinx.serialization.descriptors.SerialDescriptor> iterator() {
            b.a aVar = new b.a(this.a);
            return aVar;
        }
    }
    public static final Iterable<kotlinx.serialization.descriptors.SerialDescriptor> a(kotlinx.serialization.descriptors.SerialDescriptor serialDescriptor) {
        n.f(serialDescriptor, "<this>");
        b.b bVar = new b.b(serialDescriptor);
        return bVar;
    }
}

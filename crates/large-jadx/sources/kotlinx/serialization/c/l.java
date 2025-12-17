package kotlinx.serialization.c;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.b;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u001aN\u0010\u0000\u001a\u00020\u0001\"\n\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u00022\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0080\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u001f\u0010\u000c\u001a\u00020\r*\u00020\u00032\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000fH\u0000¢\u0006\u0002\u0010\u0010\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0011", d2 = {"equalsImpl", "", "SD", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "other", "", "typeParamsAreEqual", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "otherDescriptor", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "hashCodeImpl", "", "typeParams", "", "(Lkotlinx/serialization/descriptors/SerialDescriptor;[Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "kotlinx-serialization-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class l {
    public static final int a(SerialDescriptor serialDescriptor, SerialDescriptor[] serialDescriptor2Arr2) {
        int i;
        int i3;
        String str;
        int i2;
        Iterator obj6;
        n.f(serialDescriptor, "<this>");
        n.f(serialDescriptor2Arr2, "typeParams");
        Iterable obj5 = b.a(serialDescriptor);
        obj6 = obj5.iterator();
        i3 = i;
        while (obj6.hasNext()) {
            str = (SerialDescriptor)obj6.next().a();
            if (str != null) {
            }
            i12 += i2;
            i2 = str.hashCode();
        }
        obj5 = obj5.iterator();
        while (obj5.hasNext()) {
            obj6 = (SerialDescriptor)obj5.next().f();
            if (obj6 != null) {
            } else {
            }
            obj6 = i2;
            i11 += obj6;
            obj6 = obj6.hashCode();
        }
        return i9 += i;
    }
}

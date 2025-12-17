package kotlinx.serialization.c;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.h0.g;
import kotlin.j;
import kotlin.y.j0;
import kotlin.y.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.c;
import kotlinx.serialization.descriptors.d.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\"\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\r\u0008\u0011\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00042\u0008\u0008\u0002\u00107\u001a\u000208J\u0014\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00080!H\u0002J\u0013\u0010:\u001a\u0002082\u0008\u0010;\u001a\u0004\u0018\u00010<H\u0096\u0002J\u0016\u0010=\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010>\u001a\u00020\u0008H\u0016J\u0010\u0010?\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\u0008H\u0016J\u0010\u0010@\u001a\u00020\u00082\u0006\u00106\u001a\u00020\u0004H\u0016J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u0008H\u0016J\u0008\u0010B\u001a\u00020\u0008H\u0016J\u0010\u0010C\u001a\u0002082\u0006\u0010>\u001a\u00020\u0008H\u0016J\u000e\u0010D\u001a\u0002052\u0006\u0010E\u001a\u00020\u0012J\u000e\u0010F\u001a\u0002052\u0006\u0010G\u001a\u00020\u0012J\u0008\u0010H\u001a\u00020\u0004H\u0016R\u001b\u0010\n\u001a\u00020\u00088BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u000f\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R%\u0010\u0015\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00170\u00168BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u001a\u0010\u000e\u001a\u0004\u0008\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u000cR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00080!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008$\u0010%R\u0016\u0010&\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u001e\u0010(\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001c0\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u001a\u0010,\u001a\u0008\u0012\u0004\u0012\u00020\u00040-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008.\u0010/R!\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00168@X\u0080\u0084\u0002¢\u0006\u000c\n\u0004\u00083\u0010\u000e\u001a\u0004\u00081\u00102¨\u0006I", d2 = {"Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "serialName", "", "generatedSerializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "elementsCount", "", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;I)V", "_hashCode", "get_hashCode", "()I", "_hashCode$delegate", "Lkotlin/Lazy;", "added", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "getChildSerializers", "()[Lkotlinx/serialization/KSerializer;", "childSerializers$delegate", "classAnnotations", "", "getElementsCount", "elementsOptionality", "", "indices", "", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "names", "[Ljava/lang/String;", "propertiesAnnotations", "[Ljava/util/List;", "getSerialName", "()Ljava/lang/String;", "serialNames", "", "getSerialNames", "()Ljava/util/Set;", "typeParameterDescriptors", "getTypeParameterDescriptors$kotlinx_serialization_core", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParameterDescriptors$delegate", "addElement", "", "name", "isOptional", "", "buildIndices", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "getElementName", "hashCode", "isElementOptional", "pushAnnotation", "annotation", "pushClassAnnotation", "a", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class k implements SerialDescriptor {

    private final String a;
    private final kotlinx.serialization.c.b<?> b;
    private final int c;
    private int d = -1;
    private final String[] e;
    private final List<Annotation>[] f;
    private final boolean[] g;
    private Map<String, Integer> h;
    private final h i;
    private final h j;
    private final h k;

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0008\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements a<Integer> {

        final kotlinx.serialization.c.k this$0;
        a(kotlinx.serialization.c.k k) {
            this.this$0 = k;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final int a() {
            kotlinx.serialization.c.k this$0 = this.this$0;
            return l.a(this$0, this$0.j());
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return Integer.valueOf(a());
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\u0010\u0000\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u0001H\n", d2 = {"<anonymous>", "", "Lkotlinx/serialization/KSerializer;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<KSerializer<?>[]> {

        final kotlinx.serialization.c.k this$0;
        b(kotlinx.serialization.c.k k) {
            this.this$0 = k;
            super(0);
        }

        public final KSerializer<?>[] a() {
            int childSerializers;
            kotlinx.serialization.c.b bVar = k.e(this.this$0);
            if (bVar == null) {
                childSerializers = 0;
            } else {
                childSerializers = bVar.childSerializers();
            }
            if (childSerializers == 0) {
                childSerializers = new KSerializer[0];
            }
            return childSerializers;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "i", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<Integer, java.lang.CharSequence> {

        final kotlinx.serialization.c.k this$0;
        c(kotlinx.serialization.c.k k) {
            this.this$0 = k;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final java.lang.CharSequence a(int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.this$0.c(i));
            stringBuilder.append(": ");
            stringBuilder.append(this.this$0.d(i).a());
            return stringBuilder.toString();
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((Number)object.intValue());
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001H\n", d2 = {"<anonymous>", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<SerialDescriptor[]> {

        final kotlinx.serialization.c.k this$0;
        d(kotlinx.serialization.c.k k) {
            this.this$0 = k;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final SerialDescriptor[] a() {
            KSerializer[] typeParametersSerializers;
            int arrayList;
            int length;
            int i;
            SerialDescriptor descriptor;
            typeParametersSerializers = k.e(this.this$0);
            arrayList = 0;
            if (typeParametersSerializers == null) {
            } else {
                typeParametersSerializers = typeParametersSerializers.typeParametersSerializers();
                if (typeParametersSerializers == null) {
                } else {
                    arrayList = new ArrayList(typeParametersSerializers.length);
                    i = 0;
                    while (i < typeParametersSerializers.length) {
                        arrayList.add(typeParametersSerializers[i].getDescriptor());
                        i++;
                    }
                }
            }
            return i.a(arrayList);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
    }

    public k(String string, kotlinx.serialization.c.b<?> b2, int i3) {
        String str;
        int obj3;
        n.f(string, "serialName");
        super();
        this.a = string;
        this.b = b2;
        this.c = i3;
        int obj2 = -1;
        obj2 = new String[i3];
        obj3 = 0;
        while (obj3 < i3) {
            obj2[obj3] = "[UNINITIALIZED]";
            obj3++;
        }
        this.e = obj2;
        obj2 = this.c;
        this.f = new List[obj2];
        this.g = new boolean[obj2];
        this.h = j0.h();
        obj2 = new k.b(this);
        this.i = j.b(obj2);
        obj2 = new k.d(this);
        this.j = j.b(obj2);
        obj2 = new k.a(this);
        this.k = j.b(obj2);
    }

    public static final kotlinx.serialization.c.b e(kotlinx.serialization.c.k k) {
        return k.b;
    }

    private final Map<String, Integer> h() {
        int i2;
        Integer valueOf;
        int i;
        String str;
        HashMap hashMap = new HashMap();
        length--;
        if (i3 >= 0) {
            i2 = 0;
            i = i2 + 1;
            hashMap.put(this.e[i2], Integer.valueOf(i2));
            while (i > i3) {
                i2 = i;
                i = i2 + 1;
                hashMap.put(this.e[i2], Integer.valueOf(i2));
            }
        }
        return hashMap;
    }

    private final KSerializer<?>[] i() {
        return (KSerializer[])this.i.getValue();
    }

    private final int k() {
        return (Number)this.k.getValue().intValue();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String a() {
        return this.a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final int b() {
        return this.c;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String c(int i) {
        return this.e[i];
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor d(int i) {
        return i()[i].getDescriptor();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean equals(Object object) {
        int i;
        boolean z;
        Object obj;
        String str;
        c cVar;
        String str2;
        Object obj8;
        i = 1;
        final int i2 = 0;
        if (this == object) {
        } else {
            if (!object instanceof k) {
                i = i2;
            } else {
            }
        }
        return i;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public c f() {
        return d.a.a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final void g(String string, boolean z2) {
        int obj3;
        n.f(string, "name");
        i++;
        this.d = i2;
        this.e[i2] = string;
        this.g[i2] = z2;
        this.f[i2] = 0;
        if (i2 == obj3--) {
            this.h = h();
        }
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int hashCode() {
        return k();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor[] j() {
        return (SerialDescriptor[])this.j.getValue();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String toString() {
        k.c cVar = new k.c(this);
        return p.h0(g.l(0, this.c), ", ", n.o(a(), "("), ")", 0, 0, cVar, 24, 0);
    }
}

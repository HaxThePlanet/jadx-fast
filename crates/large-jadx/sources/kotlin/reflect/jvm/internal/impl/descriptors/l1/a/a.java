package kotlin.reflect.jvm.internal.impl.descriptors.l1.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.d.b.a0.a;
import kotlin.i0.z.e.m0.d.b.a0.a.a;
import kotlin.i0.z.e.m0.d.b.e;
import kotlin.i0.z.e.m0.d.b.n;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.i.t.c;
import kotlin.i0.z.e.m0.i.v.b;
import kotlin.i0.z.e.m0.i.v.b.a;
import kotlin.i0.z.e.m0.i.v.h;
import kotlin.i0.z.e.m0.j.b.j;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.m;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class a {

    private final e a;
    private final kotlin.reflect.jvm.internal.impl.descriptors.l1.a.g b;
    private final ConcurrentHashMap<a, h> c;
    public a(e e, kotlin.reflect.jvm.internal.impl.descriptors.l1.a.g g2) {
        n.f(e, "resolver");
        n.f(g2, "kotlinClassFinder");
        super();
        this.a = e;
        this.b = g2;
        ConcurrentHashMap obj2 = new ConcurrentHashMap();
        this.c = obj2;
    }

    public final h a(kotlin.reflect.jvm.internal.impl.descriptors.l1.a.f f) {
        Object ifAbsent;
        Object obj;
        java.util.List list;
        Object iterator;
        b.a aVar;
        Object arrayList;
        boolean stringBuilder;
        Object str;
        e eVar;
        Object obj9;
        n.f(f, "fileClass");
        ifAbsent = this.c;
        final a aVar2 = f.e();
        if (ifAbsent.get(aVar2) != null) {
        } else {
            kotlin.i0.z.e.m0.f.b bVar = f.e().h();
            n.e(bVar, "fileClass.classId.packageFqName");
            if (f.a().c() == a.a.MULTIFILE_CLASS) {
                arrayList = new ArrayList();
                iterator = f.a().f().iterator();
                while (iterator.hasNext()) {
                    a aVar6 = a.m(c.d((String)iterator.next()).e());
                    n.e(aVar6, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                    stringBuilder = n.b(this.b, aVar6);
                    if (stringBuilder != null) {
                    }
                    arrayList.add(stringBuilder);
                }
            } else {
                arrayList = p.b(f);
            }
            m mVar = new m(this.a.f().p(), bVar);
            ArrayList arrayList2 = new ArrayList();
            Iterator iterator2 = arrayList.iterator();
            while (iterator2.hasNext()) {
                str = this.a.d(mVar, (o)iterator2.next());
                if (str != null) {
                }
                arrayList2.add(str);
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("package ");
            stringBuilder.append(bVar);
            stringBuilder.append(" (");
            stringBuilder.append(f);
            stringBuilder.append(')');
            obj9 = b.d.a(stringBuilder.toString(), p.L0(arrayList2));
            ifAbsent = ifAbsent.putIfAbsent(aVar2, obj9);
            obj = ifAbsent != null ? ifAbsent : obj9;
        }
        n.e(obj, "cache.getOrPut(fileClass.classId) {\n        val fqName = fileClass.classId.packageFqName\n\n        val parts =\n            if (fileClass.classHeader.kind == KotlinClassHeader.Kind.MULTIFILE_CLASS)\n                fileClass.classHeader.multifilePartNames.mapNotNull { partName ->\n                    val classId = ClassId.topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)\n                    kotlinClassFinder.findKotlinClass(classId)\n                }\n            else listOf(fileClass)\n\n        val packageFragment = EmptyPackageFragmentDescriptor(resolver.components.moduleDescriptor, fqName)\n\n        val scopes = parts.mapNotNull { part ->\n            resolver.createKotlinPackagePartScope(packageFragment, part)\n        }.toList()\n\n        ChainedMemberScope.create(\"package $fqName ($fileClass)\", scopes)\n    }");
        return (h)obj;
    }
}

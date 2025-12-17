package m.a.c.e;

import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.i0.d;
import m.a.c.j.a;
import m.a.e.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u001aw\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\u0008\u0000\u0010\u0002\u0018\u00012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062)\u0008\u0008\u0010\u0007\u001a#\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00020\u0008j\u0008\u0012\u0004\u0012\u0002H\u0002`\u000b¢\u0006\u0002\u0008\u000c2\u0012\u0008\u0002\u0010\r\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\u0008ø\u0001\u0000\u001a$\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\u0008\u00030\u000f2\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0006*>\u0010\u0015\u001a\u0004\u0008\u0000\u0010\u0002\"\u0019\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00020\u0008¢\u0006\u0002\u0008\u000c2\u0019\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00020\u0008¢\u0006\u0002\u0008\u000c*\n\u0010\u0016\"\u00020\u00122\u00020\u0012\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0017", d2 = {"createDefinition", "Lorg/koin/core/definition/BeanDefinition;", "T", "kind", "Lorg/koin/core/definition/Kind;", "qualifier", "Lorg/koin/core/qualifier/Qualifier;", "definition", "Lkotlin/Function2;", "Lorg/koin/core/scope/Scope;", "Lorg/koin/core/parameter/ParametersHolder;", "Lorg/koin/core/definition/Definition;", "Lkotlin/ExtensionFunctionType;", "secondaryTypes", "", "Lkotlin/reflect/KClass;", "scopeQualifier", "indexKey", "", "clazz", "typeQualifier", "Definition", "IndexKey", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class b {
    public static final String a(d<?> d, a a2, a a3) {
        String str;
        String obj2;
        n.f(d, "clazz");
        n.f(a3, "scopeQualifier");
        str = "";
        if (a2 == null) {
        } else {
            obj2 = a2.getValue();
            if (obj2 == null) {
            } else {
                str = obj2;
            }
        }
        obj2 = new StringBuilder();
        obj2.append(a.a(d));
        int obj1 = 58;
        obj2.append(obj1);
        obj2.append(str);
        obj2.append(obj1);
        obj2.append(a3);
        return obj2.toString();
    }
}

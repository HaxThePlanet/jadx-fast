package m.a.c.h;

import kotlin.Metadata;
import kotlin.d0.d.n;
import m.a.c.f.c;
import org.koin.core.error.DefinitionOverrideException;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a \u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0001\u001a!\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008*\u0008\u0012\u0004\u0012\u00020\t0\u00082\u0006\u0010\n\u001a\u00020\tH\u0086\u0002¨\u0006\u000b", d2 = {"overrideError", "", "factory", "Lorg/koin/core/instance/InstanceFactory;", "mapping", "", "Lorg/koin/core/definition/IndexKey;", "plus", "", "Lorg/koin/core/module/Module;", "module", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class b {
    public static final void a(c<?> c, String string2) {
        n.f(c, "factory");
        n.f(string2, "mapping");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Already existing definition for ");
        stringBuilder.append(c.c());
        stringBuilder.append(" at ");
        stringBuilder.append(string2);
        DefinitionOverrideException definitionOverrideException = new DefinitionOverrideException(stringBuilder.toString());
        throw definitionOverrideException;
    }
}

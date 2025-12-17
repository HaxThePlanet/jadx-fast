package kotlin.reflect.jvm.internal.impl.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.y.j0;

/* loaded from: classes3.dex */
public final class e {

    public static final kotlin.reflect.jvm.internal.impl.utils.h i;
    public static final kotlin.reflect.jvm.internal.impl.utils.e j;
    private final kotlin.reflect.jvm.internal.impl.utils.h a;
    private final kotlin.reflect.jvm.internal.impl.utils.h b;
    private final Map<String, kotlin.reflect.jvm.internal.impl.utils.h> c;
    private final boolean d;
    private final kotlin.reflect.jvm.internal.impl.utils.h e;
    private final h f;
    private final boolean g;
    private final boolean h;

    static final class a extends p implements a<String[]> {

        final kotlin.reflect.jvm.internal.impl.utils.e this$0;
        a(kotlin.reflect.jvm.internal.impl.utils.e e) {
            this.this$0 = e;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final String[] a() {
            Object hVar;
            String string;
            StringBuilder stringBuilder;
            int i;
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.this$0.d().getDescription());
            hVar = this.this$0.f();
            if (hVar == null) {
            } else {
                arrayList.add(n.o("under-migration:", hVar.getDescription()));
            }
            Iterator iterator = this.this$0.g().entrySet().iterator();
            for (Map.Entry next2 : iterator) {
                stringBuilder = new StringBuilder();
                stringBuilder.append('@');
                stringBuilder.append((String)next2.getKey());
                stringBuilder.append(':');
                stringBuilder.append((h)next2.getValue().getDescription());
                arrayList.add(stringBuilder.toString());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            return (String[])array;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    static {
        kotlin.reflect.jvm.internal.impl.utils.h wARN = h.WARN;
        e.i = wARN;
        e eVar = new e(wARN, 0, j0.h(), 0, 0, 24, 0);
        final kotlin.reflect.jvm.internal.impl.utils.h iGNORE = h.IGNORE;
        super(iGNORE, iGNORE, j0.h(), 0, 0, 24, 0);
        e.j = eVar2;
        kotlin.reflect.jvm.internal.impl.utils.h sTRICT = h.STRICT;
        e eVar3 = new e(sTRICT, sTRICT, j0.h(), 0, 0, 24, 0);
    }

    public e(kotlin.reflect.jvm.internal.impl.utils.h h, kotlin.reflect.jvm.internal.impl.utils.h h2, Map<String, ? extends kotlin.reflect.jvm.internal.impl.utils.h> map3, boolean z4, kotlin.reflect.jvm.internal.impl.utils.h h5) {
        int i;
        int obj3;
        n.f(h, "globalJsr305Level");
        n.f(map3, "userDefinedLevelForSpecificJsr305Annotation");
        n.f(h5, "jspecifyReportLevel");
        super();
        this.a = h;
        this.b = h2;
        this.c = map3;
        this.d = z4;
        this.e = h5;
        e.a obj6 = new e.a(this);
        this.f = j.b(obj6);
        obj6 = h.IGNORE;
        final int i2 = 0;
        if (h == obj6 && h2 == obj6 && map3.isEmpty()) {
            if (h2 == obj6) {
                obj3 = map3.isEmpty() ? i : i2;
            } else {
            }
        } else {
        }
        this.g = obj3;
        if (obj3 == null) {
            if (h5 == obj6) {
            } else {
                i = i2;
            }
        }
        this.h = i;
    }

    public e(kotlin.reflect.jvm.internal.impl.utils.h h, kotlin.reflect.jvm.internal.impl.utils.h h2, Map map3, boolean z4, kotlin.reflect.jvm.internal.impl.utils.h h5, int i6, g g7) {
        int obj10;
        kotlin.reflect.jvm.internal.impl.utils.h obj11;
        obj10 = i6 & 8 != 0 ? 1 : obj10;
        obj11 = i6 & 16 != 0 ? e.i : obj11;
        super(h, h2, map3, obj10, obj11);
    }

    public final boolean a() {
        return this.h;
    }

    public final boolean b() {
        return this.g;
    }

    public final boolean c() {
        return this.d;
    }

    public final kotlin.reflect.jvm.internal.impl.utils.h d() {
        return this.a;
    }

    public final kotlin.reflect.jvm.internal.impl.utils.h e() {
        return this.e;
    }

    public final kotlin.reflect.jvm.internal.impl.utils.h f() {
        return this.b;
    }

    public final Map<String, kotlin.reflect.jvm.internal.impl.utils.h> g() {
        return this.c;
    }
}

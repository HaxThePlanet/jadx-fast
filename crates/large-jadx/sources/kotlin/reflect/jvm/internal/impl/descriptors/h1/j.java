package kotlin.reflect.jvm.internal.impl.descriptors.h1;

import java.util.Map;
import kotlin.d0.c.a;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.q.g;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.j;
import kotlin.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* loaded from: classes3.dex */
public final class j implements kotlin.reflect.jvm.internal.impl.descriptors.h1.c {

    private final h a;
    private final b b;
    private final Map<e, g<?>> c;
    private final h d;

    static final class a extends p implements a<i0> {

        final kotlin.reflect.jvm.internal.impl.descriptors.h1.j this$0;
        a(kotlin.reflect.jvm.internal.impl.descriptors.h1.j j) {
            this.this$0 = j;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final i0 a() {
            return j.b(this.this$0).o(this.this$0.d()).q();
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    public j(h h, b b2, Map<e, ? extends g<?>> map3) {
        n.f(h, "builtIns");
        n.f(b2, "fqName");
        n.f(map3, "allValueArguments");
        super();
        this.a = h;
        this.b = b2;
        this.c = map3;
        j.a obj3 = new j.a(this);
        this.d = j.a(m.PUBLICATION, obj3);
    }

    public static final h b(kotlin.reflect.jvm.internal.impl.descriptors.h1.j j) {
        return j.a;
    }

    public Map<e, g<?>> a() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public b d() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public u0 getSource() {
        final u0 u0Var = u0.a;
        n.e(u0Var, "NO_SOURCE");
        return u0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1.c
    public b0 getType() {
        Object value = this.d.getValue();
        n.e(value, "pyright 2010-2017 JetBrains s.r.o.\n *\n * Licensed under the Apache License, Version 2.0 (the \"License\");\n * you may not use this file except in compliance with the License.\n * You may obtain a copy of the License at\n *\n * http://www.apache.org/licenses/LICENSE-2.0\n *\n * Unless required by applicable law or agreed to in writing, software\n * distributed under the License is distributed on an \"AS IS\" BASIS,\n * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n * See the License for the specific language governing permissions and\n * limitations under the License.\n */\n\npackage org.jetbrains.kotlin.descriptors.annotations\n\nimport org.jetbrains.kotlin.builtins.KotlinBuiltIns\nimport org.jetbrains.kotlin.descriptors.SourceElement\nimport org.jetbrains.kotlin.name.FqName\nimport org.jetbrains.kotlin.name.Name\nimport org.jetbrains.kotlin.resolve.constants.ConstantValue\nimport org.jetbrains.kotlin.types.KotlinType\nimport kotlin.LazyThreadSafetyMode.PUBLICATION\n\nclass BuiltInAnnotationDescriptor(\n        private val builtIns: KotlinBuiltIns,\n        override val fqName: FqName,\n        override val allValueArguments: Map<Name, ConstantValue<*>>\n) : AnnotationDescriptor {\n    override val type: KotlinType by lazy(PUBLICATION) {\n        builtIns.getBuiltInClassByFqName(fqName).defaultType\n    }");
        return (b0)value;
    }
}

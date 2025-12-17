package androidx.camera.core;

import androidx.camera.core.impl.i;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class b {

    private LinkedHashSet<androidx.camera.core.a> a;

    public static final class a {

        private final LinkedHashSet<androidx.camera.core.a> a;
        public a() {
            super();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            this.a = linkedHashSet;
        }

        public androidx.camera.core.b a() {
            b bVar = new b(this.a);
            return bVar;
        }

        public androidx.camera.core.b.a b(int i) {
            i iVar = new i(i);
            this.a.add(iVar);
            return this;
        }
    }
    static {
        b.a aVar = new b.a();
        aVar.b(0);
        aVar.a();
        b.a aVar2 = new b.a();
        aVar2.b(1);
        aVar2.a();
    }

    b(LinkedHashSet<androidx.camera.core.a> linkedHashSet) {
        super();
        this.a = linkedHashSet;
    }
}

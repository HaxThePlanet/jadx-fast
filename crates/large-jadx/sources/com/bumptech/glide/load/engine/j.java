package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.c;

/* loaded from: classes.dex */
public abstract class j {

    public static final com.bumptech.glide.load.engine.j a;
    public static final com.bumptech.glide.load.engine.j b;
    public static final com.bumptech.glide.load.engine.j c;

    class a extends com.bumptech.glide.load.engine.j {
        @Override // com.bumptech.glide.load.engine.j
        public boolean a() {
            return 0;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean b() {
            return 0;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean c(a a) {
            return 0;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean d(boolean z, a a2, c c3) {
            return 0;
        }
    }

    class b extends com.bumptech.glide.load.engine.j {
        @Override // com.bumptech.glide.load.engine.j
        public boolean a() {
            return 1;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean b() {
            return 0;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean c(a a) {
            a dATA_DISK_CACHE;
            int obj2;
            if (a != a.DATA_DISK_CACHE && a != a.MEMORY_CACHE) {
                obj2 = a != a.MEMORY_CACHE ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean d(boolean z, a a2, c c3) {
            return 0;
        }
    }

    class c extends com.bumptech.glide.load.engine.j {
        @Override // com.bumptech.glide.load.engine.j
        public boolean a() {
            return 1;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean b() {
            return 1;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean c(a a) {
            int obj2;
            obj2 = a == a.REMOTE ? 1 : 0;
            return obj2;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean d(boolean z, a a2, c c3) {
            a obj1;
            if (z != null) {
                if (a2 != a.DATA_DISK_CACHE) {
                    if (a2 == a.LOCAL && c3 == c.TRANSFORMED) {
                        obj1 = c3 == c.TRANSFORMED ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
            return obj1;
        }
    }
    static {
        j.a aVar = new j.a();
        j.a = aVar;
        j.b bVar = new j.b();
        j.b = bVar;
        j.c cVar = new j.c();
        j.c = cVar;
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(a a);

    public abstract boolean d(boolean z, a a2, c c3);
}

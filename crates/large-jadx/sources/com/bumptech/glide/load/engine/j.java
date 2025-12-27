package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.a;
import com.bumptech.glide.load.c;

/* compiled from: DiskCacheStrategy.java */
/* loaded from: classes.dex */
public abstract class j {

    public static final j a = new j$a();
    public static final j b = new j$b();
    public static final j c = new j$c();

    class a extends j {
        a() {
            super();
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean a() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean b() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean c(a aVar) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean d(boolean z, a aVar, c cVar) {
            return false;
        }
    }

    class b extends j {
        b() {
            super();
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean c(a aVar) {
            a dATA_DISK_CACHE2;
            boolean z = false;
            aVar = aVar != a.DATA_DISK_CACHE && aVar != a.MEMORY_CACHE ? 1 : 0;
            return (aVar != a.DATA_DISK_CACHE && aVar != a.MEMORY_CACHE ? 1 : 0);
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean b() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean d(boolean z, a aVar, c cVar) {
            return false;
        }
    }

    class c extends j {
        c() {
            super();
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean c(a aVar) {
            boolean z = true;
            aVar = aVar == a.REMOTE ? 1 : 0;
            return (aVar == a.REMOTE ? 1 : 0);
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean d(boolean z, a aVar, c cVar) {
            boolean z2 = true;
            if (!a.DATA_DISK_CACHE || aVar != a.DATA_DISK_CACHE) {
                z = aVar == a.LOCAL && cVar == c.TRANSFORMED ? 1 : 0;
            }
            return (aVar == a.LOCAL && cVar == c.TRANSFORMED ? 1 : 0);
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean a() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.j
        public boolean b() {
            return true;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(a aVar);

    public abstract boolean d(boolean z, a aVar, c cVar);
}

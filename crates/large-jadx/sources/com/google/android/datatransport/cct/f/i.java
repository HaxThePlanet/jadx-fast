package com.google.android.datatransport.cct.f;

/* loaded from: classes.dex */
final class i extends com.google.android.datatransport.cct.f.o {

    private final com.google.android.datatransport.cct.f.o.c a;
    private final com.google.android.datatransport.cct.f.o.b b;

    static class a {
    }

    static final class b extends com.google.android.datatransport.cct.f.o.a {

        private com.google.android.datatransport.cct.f.o.c a;
        private com.google.android.datatransport.cct.f.o.b b;
        @Override // com.google.android.datatransport.cct.f.o$a
        public com.google.android.datatransport.cct.f.o a() {
            i iVar = new i(this.a, this.b, 0);
            return iVar;
        }

        @Override // com.google.android.datatransport.cct.f.o$a
        public com.google.android.datatransport.cct.f.o.a b(com.google.android.datatransport.cct.f.o.b o$b) {
            this.b = b;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.o$a
        public com.google.android.datatransport.cct.f.o.a c(com.google.android.datatransport.cct.f.o.c o$c) {
            this.a = c;
            return this;
        }
    }
    private i(com.google.android.datatransport.cct.f.o.c o$c, com.google.android.datatransport.cct.f.o.b o$b2) {
        super();
        this.a = c;
        this.b = b2;
    }

    i(com.google.android.datatransport.cct.f.o.c o$c, com.google.android.datatransport.cct.f.o.b o$b2, com.google.android.datatransport.cct.f.i.a i$a3) {
        super(c, b2);
    }

    @Override // com.google.android.datatransport.cct.f.o
    public com.google.android.datatransport.cct.f.o.b b() {
        return this.b;
    }

    @Override // com.google.android.datatransport.cct.f.o
    public com.google.android.datatransport.cct.f.o.c c() {
        return this.a;
    }

    @Override // com.google.android.datatransport.cct.f.o
    public boolean equals(Object object) {
        int i;
        boolean equals;
        com.google.android.datatransport.cct.f.o.c cVar;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof o) {
            com.google.android.datatransport.cct.f.o.c cVar2 = this.a;
            if (cVar2 == null) {
                if ((o)object.c() == null) {
                    equals = this.b;
                    if (equals == null) {
                        if (object.b() == null) {
                        } else {
                            i = i2;
                        }
                    } else {
                        if (equals.equals(object.b())) {
                        } else {
                        }
                    }
                } else {
                }
            } else {
                if (cVar2.equals(object.c())) {
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.android.datatransport.cct.f.o
    public int hashCode() {
        int i2;
        int i;
        com.google.android.datatransport.cct.f.o.c cVar = this.a;
        if (cVar == null) {
            i2 = i;
        } else {
            i2 = cVar.hashCode();
        }
        int i6 = 1000003;
        com.google.android.datatransport.cct.f.o.b bVar = this.b;
        if (bVar == null) {
        } else {
            i = bVar.hashCode();
        }
        return i4 ^= i;
    }

    @Override // com.google.android.datatransport.cct.f.o
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NetworkConnectionInfo{networkType=");
        stringBuilder.append(this.a);
        stringBuilder.append(", mobileSubtype=");
        stringBuilder.append(this.b);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

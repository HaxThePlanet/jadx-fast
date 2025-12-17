package com.google.android.datatransport.cct.f;

/* loaded from: classes.dex */
final class e extends com.google.android.datatransport.cct.f.k {

    private final com.google.android.datatransport.cct.f.k.b a;
    private final com.google.android.datatransport.cct.f.a b;

    static class a {
    }

    static final class b extends com.google.android.datatransport.cct.f.k.a {

        private com.google.android.datatransport.cct.f.k.b a;
        private com.google.android.datatransport.cct.f.a b;
        @Override // com.google.android.datatransport.cct.f.k$a
        public com.google.android.datatransport.cct.f.k a() {
            e eVar = new e(this.a, this.b, 0);
            return eVar;
        }

        @Override // com.google.android.datatransport.cct.f.k$a
        public com.google.android.datatransport.cct.f.k.a b(com.google.android.datatransport.cct.f.a a) {
            this.b = a;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.k$a
        public com.google.android.datatransport.cct.f.k.a c(com.google.android.datatransport.cct.f.k.b k$b) {
            this.a = b;
            return this;
        }
    }
    private e(com.google.android.datatransport.cct.f.k.b k$b, com.google.android.datatransport.cct.f.a a2) {
        super();
        this.a = b;
        this.b = a2;
    }

    e(com.google.android.datatransport.cct.f.k.b k$b, com.google.android.datatransport.cct.f.a a2, com.google.android.datatransport.cct.f.e.a e$a3) {
        super(b, a2);
    }

    @Override // com.google.android.datatransport.cct.f.k
    public com.google.android.datatransport.cct.f.a b() {
        return this.b;
    }

    @Override // com.google.android.datatransport.cct.f.k
    public com.google.android.datatransport.cct.f.k.b c() {
        return this.a;
    }

    @Override // com.google.android.datatransport.cct.f.k
    public boolean equals(Object object) {
        int i;
        boolean equals;
        com.google.android.datatransport.cct.f.k.b bVar;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof k) {
            com.google.android.datatransport.cct.f.k.b bVar2 = this.a;
            if (bVar2 == null) {
                if ((k)object.c() == null) {
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
                if (bVar2.equals(object.c())) {
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.android.datatransport.cct.f.k
    public int hashCode() {
        int i;
        int i2;
        com.google.android.datatransport.cct.f.k.b bVar = this.a;
        if (bVar == null) {
            i = i2;
        } else {
            i = bVar.hashCode();
        }
        int i6 = 1000003;
        com.google.android.datatransport.cct.f.a aVar = this.b;
        if (aVar == null) {
        } else {
            i2 = aVar.hashCode();
        }
        return i4 ^= i2;
    }

    @Override // com.google.android.datatransport.cct.f.k
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClientInfo{clientType=");
        stringBuilder.append(this.a);
        stringBuilder.append(", androidClientInfo=");
        stringBuilder.append(this.b);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

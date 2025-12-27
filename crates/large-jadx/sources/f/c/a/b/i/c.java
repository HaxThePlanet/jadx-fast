package f.c.a.b.i;

import java.util.Map;
import java.util.Objects;

/* compiled from: AutoValue_EventInternal.java */
/* loaded from: classes.dex */
final class c extends j {

    private final String a;
    private final Integer b;
    private final i c;
    private final long d;
    private final long e;
    private final Map<String, String> f;

    static class a {
    }

    static final class b extends j.a {

        private String a;
        private Integer b;
        private i c;
        private Long d;
        private Long e;
        private Map<String, String> f;
        b() {
            super();
        }

        @Override // f.c.a.b.i.j$a
        public j d() {
            String str2;
            str2 = "";
            if (this.a == null) {
                StringBuilder stringBuilder5 = new StringBuilder();
                String str7 = " transportName";
                str2 = str2 + str7;
            }
            if (this.c == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = " encodedPayload";
                str2 = str2 + str3;
            }
            if (this.d == null) {
                StringBuilder stringBuilder4 = new StringBuilder();
                String str6 = " eventMillis";
                str2 = str2 + str6;
            }
            if (this.e == null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str4 = " uptimeMillis";
                str2 = str2 + str4;
            }
            if (this.f == null) {
                StringBuilder stringBuilder3 = new StringBuilder();
                String str5 = " autoMetadata";
                str2 = str2 + str5;
            }
            if (!str2.isEmpty()) {
                StringBuilder stringBuilder6 = new StringBuilder();
                String str9 = "Missing required properties:";
                r1 = str9 + str2;
                throw new IllegalStateException(r1);
            } else {
                c cVar = new c(this.a, this.b, this.c, this.d.longValue(), l5, this.e.longValue(), aVar, this.f, 0);
                return cVar;
            }
        }

        @Override // f.c.a.b.i.j$a
        protected Map<String, String> e() {
            if (this.f == null) {
                throw new IllegalStateException("Property \"autoMetadata\" has not been set");
            } else {
                return this.f;
            }
        }

        @Override // f.c.a.b.i.j$a
        protected j.a f(Map<String, String> map) {
            Objects.requireNonNull(map, "Null autoMetadata");
            this.f = map;
            return this;
        }

        @Override // f.c.a.b.i.j$a
        public j.a g(Integer integer) {
            this.b = integer;
            return this;
        }

        @Override // f.c.a.b.i.j$a
        public j.a h(i iVar) {
            Objects.requireNonNull(iVar, "Null encodedPayload");
            this.c = iVar;
            return this;
        }

        @Override // f.c.a.b.i.j$a
        public j.a i(long j) {
            this.d = Long.valueOf(j);
            return this;
        }

        @Override // f.c.a.b.i.j$a
        public j.a j(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.a = str;
            return this;
        }

        @Override // f.c.a.b.i.j$a
        public j.a k(long j) {
            this.e = Long.valueOf(j);
            return this;
        }
    }
    /* synthetic */ c(String str, Integer integer, i iVar, long j, long j2, Map map, c.a aVar) {
        this(str, integer, iVar, j, r5, j2, r7, map);
    }

    @Override // f.c.a.b.i.j
    protected Map<String, String> c() {
        return this.f;
    }

    @Override // f.c.a.b.i.j
    public Integer d() {
        return this.b;
    }

    @Override // f.c.a.b.i.j
    public i e() {
        return this.c;
    }

    @Override // f.c.a.b.i.j
    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        String str;
        long l2;
        boolean equals2;
        z = true;
        if (object == this) {
            return true;
        }
        final int i = 0;
        if (object instanceof j) {
            if (!this.a.equals(object.j()) || this.b == null) {
            }
            return z;
        }
        return false;
    }

    @Override // f.c.a.b.i.j
    public long f() {
        return this.d;
    }

    @Override // f.c.a.b.i.j
    public int hashCode() {
        int i = 0;
        int i14 = 1000003;
        if (this.b == null) {
            i = 0;
        } else {
            i = this.b.hashCode();
        }
        int i19 = 32;
        return (this.a.hashCode() ^ i14) * i14 ^ i * i14 ^ this.c.hashCode() * i14 ^ (int)(l ^ (l >>> i19)) * i14 ^ (int)(l3 ^ (l3 >>> i19)) * i14 ^ this.f.hashCode();
    }

    @Override // f.c.a.b.i.j
    public String j() {
        return this.a;
    }

    @Override // f.c.a.b.i.j
    public long k() {
        return this.e;
    }

    @Override // f.c.a.b.i.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "EventInternal{transportName=";
        String str4 = ", code=";
        String str5 = ", encodedPayload=";
        String str6 = ", eventMillis=";
        String str7 = ", uptimeMillis=";
        String str8 = ", autoMetadata=";
        String str9 = "}";
        str = str2 + this.a + str4 + this.b + str5 + this.c + str6 + this.d + str7 + this.e + str8 + this.f + str9;
        return str;
    }

    private c(String str, Integer integer, i iVar, long j, long j2, Map<String, String> map) {
        super();
        this.a = str;
        this.b = integer;
        this.c = iVar;
        this.d = j;
        this.e = j2;
        this.f = map;
    }
}

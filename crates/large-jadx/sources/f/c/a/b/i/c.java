package f.c.a.b.i;

import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
final class c extends f.c.a.b.i.j {

    private final String a;
    private final Integer b;
    private final f.c.a.b.i.i c;
    private final long d;
    private final long e;
    private final Map<String, String> f;

    static class a {
    }

    static final class b extends f.c.a.b.i.j.a {

        private String a;
        private Integer b;
        private f.c.a.b.i.i c;
        private Long d;
        private Long e;
        private Map<String, String> f;
        @Override // f.c.a.b.i.j$a
        public f.c.a.b.i.j d() {
            Object stringBuilder;
            Object stringBuilder5;
            Object stringBuilder3;
            Object stringBuilder4;
            Object stringBuilder2;
            String string;
            if (this.a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(" transportName");
                string = stringBuilder.toString();
            }
            if (this.c == null) {
                stringBuilder5 = new StringBuilder();
                stringBuilder5.append(string);
                stringBuilder5.append(" encodedPayload");
                string = stringBuilder5.toString();
            }
            if (this.d == null) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(string);
                stringBuilder3.append(" eventMillis");
                string = stringBuilder3.toString();
            }
            if (this.e == null) {
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(string);
                stringBuilder4.append(" uptimeMillis");
                string = stringBuilder4.toString();
            }
            if (this.f == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(" autoMetadata");
                string = stringBuilder2.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.a, this.b, this.c, this.d.longValue(), obj7, this.e.longValue(), obj9, this.f, 0);
                return cVar;
            }
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append("Missing required properties:");
            stringBuilder6.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder6.toString());
            throw illegalStateException;
        }

        protected Map<String, String> e() {
            Map map = this.f;
            if (map == null) {
            } else {
                return map;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Property \"autoMetadata\" has not been set");
            throw illegalStateException;
        }

        protected f.c.a.b.i.j.a f(Map<String, String> map) {
            Objects.requireNonNull(map, "Null autoMetadata");
            this.f = map;
            return this;
        }

        @Override // f.c.a.b.i.j$a
        public f.c.a.b.i.j.a g(Integer integer) {
            this.b = integer;
            return this;
        }

        @Override // f.c.a.b.i.j$a
        public f.c.a.b.i.j.a h(f.c.a.b.i.i i) {
            Objects.requireNonNull(i, "Null encodedPayload");
            this.c = i;
            return this;
        }

        @Override // f.c.a.b.i.j$a
        public f.c.a.b.i.j.a i(long l) {
            this.d = Long.valueOf(l);
            return this;
        }

        @Override // f.c.a.b.i.j$a
        public f.c.a.b.i.j.a j(String string) {
            Objects.requireNonNull(string, "Null transportName");
            this.a = string;
            return this;
        }

        @Override // f.c.a.b.i.j$a
        public f.c.a.b.i.j.a k(long l) {
            this.e = Long.valueOf(l);
            return this;
        }
    }
    private c(String string, Integer integer2, f.c.a.b.i.i i3, long l4, long l5, Map<String, String> map6) {
        super();
        this.a = string;
        this.b = integer2;
        this.c = i3;
        this.d = l4;
        this.e = map6;
        this.f = obj8;
    }

    c(String string, Integer integer2, f.c.a.b.i.i i3, long l4, long l5, Map map6, f.c.a.b.i.c.a c$a7) {
        super(string, integer2, i3, l4, l5, map6, a7, obj8);
    }

    protected Map<String, String> c() {
        return this.f;
    }

    @Override // f.c.a.b.i.j
    public Integer d() {
        return this.b;
    }

    @Override // f.c.a.b.i.j
    public f.c.a.b.i.i e() {
        return this.c;
    }

    @Override // f.c.a.b.i.j
    public boolean equals(Object object) {
        int i;
        Map equals;
        long str;
        long l;
        boolean obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof j) {
            if (this.a.equals((j)object.j())) {
                Integer num = this.b;
                if (num == null) {
                    if (object.d() == null) {
                        if (this.c.equals(object.e())) {
                            if (Long.compare(str, l) == 0) {
                                if (Long.compare(str, l) == 0) {
                                    if (this.f.equals(object.c())) {
                                    } else {
                                        i = i2;
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                    if (num.equals(object.d()) && this.c.equals(object.e()) && Long.compare(str, l) == 0 && Long.compare(str, l) == 0 && this.f.equals(object.c())) {
                    } else {
                    }
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // f.c.a.b.i.j
    public long f() {
        return this.d;
    }

    @Override // f.c.a.b.i.j
    public int hashCode() {
        int i;
        int i14 = 1000003;
        Integer num = this.b;
        if (num == null) {
            i = 0;
        } else {
            i = num.hashCode();
        }
        long l = this.d;
        int i21 = 32;
        long l2 = this.e;
        return i12 ^= i15;
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
        stringBuilder.append("EventInternal{transportName=");
        stringBuilder.append(this.a);
        stringBuilder.append(", code=");
        stringBuilder.append(this.b);
        stringBuilder.append(", encodedPayload=");
        stringBuilder.append(this.c);
        stringBuilder.append(", eventMillis=");
        stringBuilder.append(this.d);
        stringBuilder.append(", uptimeMillis=");
        stringBuilder.append(this.e);
        stringBuilder.append(", autoMetadata=");
        stringBuilder.append(this.f);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

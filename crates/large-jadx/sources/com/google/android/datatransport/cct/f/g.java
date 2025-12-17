package com.google.android.datatransport.cct.f;

import com.google.firebase.encoders.annotations.Encodable.Field;
import java.util.List;

/* loaded from: classes.dex */
final class g extends com.google.android.datatransport.cct.f.m {

    private final long a;
    private final long b;
    private final com.google.android.datatransport.cct.f.k c;
    private final Integer d;
    private final String e;
    private final List<com.google.android.datatransport.cct.f.l> f;
    private final com.google.android.datatransport.cct.f.p g;

    static class a {
    }

    static final class b extends com.google.android.datatransport.cct.f.m.a {

        private Long a;
        private Long b;
        private com.google.android.datatransport.cct.f.k c;
        private Integer d;
        private String e;
        private List<com.google.android.datatransport.cct.f.l> f;
        private com.google.android.datatransport.cct.f.p g;
        @Override // com.google.android.datatransport.cct.f.m$a
        public com.google.android.datatransport.cct.f.m a() {
            Object stringBuilder;
            Object stringBuilder2;
            String string;
            if (this.a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(" requestTimeMs");
                string = stringBuilder.toString();
            }
            if (this.b == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(" requestUptimeMs");
                string = stringBuilder2.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.a.longValue(), obj4, this.b.longValue(), obj6, this.c, this.d, this.e, this.f, this.g, 0);
                return gVar;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Missing required properties:");
            stringBuilder3.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder3.toString());
            throw illegalStateException;
        }

        @Override // com.google.android.datatransport.cct.f.m$a
        public com.google.android.datatransport.cct.f.m.a b(com.google.android.datatransport.cct.f.k k) {
            this.c = k;
            return this;
        }

        public com.google.android.datatransport.cct.f.m.a c(List<com.google.android.datatransport.cct.f.l> list) {
            this.f = list;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.m$a
        com.google.android.datatransport.cct.f.m.a d(Integer integer) {
            this.d = integer;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.m$a
        com.google.android.datatransport.cct.f.m.a e(String string) {
            this.e = string;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.m$a
        public com.google.android.datatransport.cct.f.m.a f(com.google.android.datatransport.cct.f.p p) {
            this.g = p;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.m$a
        public com.google.android.datatransport.cct.f.m.a g(long l) {
            this.a = Long.valueOf(l);
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.m$a
        public com.google.android.datatransport.cct.f.m.a h(long l) {
            this.b = Long.valueOf(l);
            return this;
        }
    }
    private g(long l, long l2, com.google.android.datatransport.cct.f.k k3, Integer integer4, String string5, List<com.google.android.datatransport.cct.f.l> list6, com.google.android.datatransport.cct.f.p p7) {
        super();
        this.a = l;
        this.b = k3;
        this.c = string5;
        this.d = list6;
        this.e = p7;
        this.f = obj8;
        this.g = obj9;
    }

    g(long l, long l2, com.google.android.datatransport.cct.f.k k3, Integer integer4, String string5, List list6, com.google.android.datatransport.cct.f.p p7, com.google.android.datatransport.cct.f.g.a g$a8) {
        super(l, l2, k3, integer4, string5, list6, p7, a8, obj9);
    }

    @Override // com.google.android.datatransport.cct.f.m
    public com.google.android.datatransport.cct.f.k b() {
        return this.c;
    }

    @Encodable$Field(name = "logEvent")
    public List<com.google.android.datatransport.cct.f.l> c() {
        return this.f;
    }

    @Override // com.google.android.datatransport.cct.f.m
    public Integer d() {
        return this.d;
    }

    @Override // com.google.android.datatransport.cct.f.m
    public String e() {
        return this.e;
    }

    @Override // com.google.android.datatransport.cct.f.m
    public boolean equals(Object object) {
        int i;
        com.google.android.datatransport.cct.f.p equals;
        Integer l2;
        long l;
        com.google.android.datatransport.cct.f.p obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof m) {
            if (Long.compare(l2, l) == 0 && Long.compare(l2, l) == 0) {
                if (Long.compare(l2, l) == 0) {
                    com.google.android.datatransport.cct.f.k kVar = this.c;
                    if (kVar == null) {
                        if (object.b() == null) {
                            Integer num = this.d;
                            if (num == null) {
                                if (object.d() == null) {
                                    String str = this.e;
                                    if (str == null) {
                                        if (object.e() == null) {
                                            List list = this.f;
                                            if (list == null) {
                                                if (object.c() == null) {
                                                    equals = this.g;
                                                    if (equals == null) {
                                                        if (object.f() == null) {
                                                        } else {
                                                            i = i2;
                                                        }
                                                    } else {
                                                        if (equals.equals(object.f())) {
                                                        } else {
                                                        }
                                                    }
                                                } else {
                                                }
                                            } else {
                                                if (list.equals(object.c())) {
                                                } else {
                                                }
                                            }
                                        } else {
                                        }
                                    } else {
                                        if (str.equals(object.e())) {
                                        } else {
                                        }
                                    }
                                } else {
                                }
                            } else {
                                if (num.equals(object.d())) {
                                } else {
                                }
                            }
                        } else {
                        }
                    } else {
                        if (kVar.equals(object.b())) {
                        } else {
                        }
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.android.datatransport.cct.f.m
    public com.google.android.datatransport.cct.f.p f() {
        return this.g;
    }

    @Override // com.google.android.datatransport.cct.f.m
    public long g() {
        return this.a;
    }

    @Override // com.google.android.datatransport.cct.f.m
    public long h() {
        return this.b;
    }

    @Override // com.google.android.datatransport.cct.f.m
    public int hashCode() {
        int i5;
        int i3;
        int i2;
        int i4;
        int i;
        long l = this.a;
        int i22 = 32;
        int i21 = 1000003;
        long l2 = this.b;
        com.google.android.datatransport.cct.f.k kVar = this.c;
        i = 0;
        if (kVar == null) {
            i5 = i;
        } else {
            i5 = kVar.hashCode();
        }
        Integer num = this.d;
        if (num == null) {
            i3 = i;
        } else {
            i3 = num.hashCode();
        }
        String str = this.e;
        if (str == null) {
            i2 = i;
        } else {
            i2 = str.hashCode();
        }
        List list = this.f;
        if (list == null) {
            i4 = i;
        } else {
            i4 = list.hashCode();
        }
        com.google.android.datatransport.cct.f.p pVar = this.g;
        if (pVar == null) {
        } else {
            i = pVar.hashCode();
        }
        return i19 ^= i;
    }

    @Override // com.google.android.datatransport.cct.f.m
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LogRequest{requestTimeMs=");
        stringBuilder.append(this.a);
        stringBuilder.append(", requestUptimeMs=");
        stringBuilder.append(this.b);
        stringBuilder.append(", clientInfo=");
        stringBuilder.append(this.c);
        stringBuilder.append(", logSource=");
        stringBuilder.append(this.d);
        stringBuilder.append(", logSourceName=");
        stringBuilder.append(this.e);
        stringBuilder.append(", logEvents=");
        stringBuilder.append(this.f);
        stringBuilder.append(", qosTier=");
        stringBuilder.append(this.g);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

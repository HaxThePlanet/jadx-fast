package com.google.android.datatransport.cct.f;

import java.util.Arrays;

/* loaded from: classes.dex */
final class f extends com.google.android.datatransport.cct.f.l {

    private final long a;
    private final Integer b;
    private final long c;
    private final byte[] d;
    private final String e;
    private final long f;
    private final com.google.android.datatransport.cct.f.o g;

    static class a {
    }

    static final class b extends com.google.android.datatransport.cct.f.l.a {

        private Long a;
        private Integer b;
        private Long c;
        private byte[] d;
        private String e;
        private Long f;
        private com.google.android.datatransport.cct.f.o g;
        @Override // com.google.android.datatransport.cct.f.l$a
        public com.google.android.datatransport.cct.f.l a() {
            Object stringBuilder;
            Object stringBuilder3;
            Object stringBuilder2;
            String string;
            if (this.a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(" eventTimeMs");
                string = stringBuilder.toString();
            }
            if (this.c == null) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(string);
                stringBuilder3.append(" eventUptimeMs");
                string = stringBuilder3.toString();
            }
            if (this.f == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(" timezoneOffsetSeconds");
                string = stringBuilder2.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.a.longValue(), obj4, this.b, this.c.longValue(), obj7, this.d, this.e, this.f.longValue(), obj11, this.g, 0);
                return fVar;
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Missing required properties:");
            stringBuilder4.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder4.toString());
            throw illegalStateException;
        }

        @Override // com.google.android.datatransport.cct.f.l$a
        public com.google.android.datatransport.cct.f.l.a b(Integer integer) {
            this.b = integer;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.l$a
        public com.google.android.datatransport.cct.f.l.a c(long l) {
            this.a = Long.valueOf(l);
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.l$a
        public com.google.android.datatransport.cct.f.l.a d(long l) {
            this.c = Long.valueOf(l);
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.l$a
        public com.google.android.datatransport.cct.f.l.a e(com.google.android.datatransport.cct.f.o o) {
            this.g = o;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.l$a
        com.google.android.datatransport.cct.f.l.a f(byte[] bArr) {
            this.d = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.l$a
        com.google.android.datatransport.cct.f.l.a g(String string) {
            this.e = string;
            return this;
        }

        @Override // com.google.android.datatransport.cct.f.l$a
        public com.google.android.datatransport.cct.f.l.a h(long l) {
            this.f = Long.valueOf(l);
            return this;
        }
    }
    private f(long l, Integer integer2, long l3, byte[] b4Arr4, String string5, long l6, com.google.android.datatransport.cct.f.o o7) {
        super();
        this.a = l;
        this.b = l3;
        this.c = b4Arr4;
        this.d = l6;
        this.e = o7;
        this.f = obj8;
        this.g = obj10;
    }

    f(long l, Integer integer2, long l3, byte[] b4Arr4, String string5, long l6, com.google.android.datatransport.cct.f.o o7, com.google.android.datatransport.cct.f.f.a f$a8) {
        super(l, integer2, l3, b4Arr4, string5, l6, o7, a8, obj9, obj10);
    }

    @Override // com.google.android.datatransport.cct.f.l
    public Integer b() {
        return this.b;
    }

    @Override // com.google.android.datatransport.cct.f.l
    public long c() {
        return this.a;
    }

    @Override // com.google.android.datatransport.cct.f.l
    public long d() {
        return this.c;
    }

    @Override // com.google.android.datatransport.cct.f.l
    public com.google.android.datatransport.cct.f.o e() {
        return this.g;
    }

    @Override // com.google.android.datatransport.cct.f.l
    public boolean equals(Object object) {
        int i;
        int equals;
        long l2;
        long l;
        Object obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof l) {
            if (Long.compare(l2, l) == 0) {
                Integer num = this.b;
                if (num == null) {
                    if (object.b() == null) {
                        if (Long.compare(l2, l) == 0) {
                            if (object instanceof f) {
                                l2 = obj.d;
                            } else {
                                l2 = object.f();
                            }
                            if (Arrays.equals(this.d, l2)) {
                                String str = this.e;
                                if (str == null) {
                                    if (object.g() == null) {
                                        if (Long.compare(l2, l) == 0) {
                                            equals = this.g;
                                            if (equals == null) {
                                                if (object.e() == null) {
                                                } else {
                                                    i = i2;
                                                }
                                            } else {
                                                if (equals.equals(object.e())) {
                                                } else {
                                                }
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                    if (str.equals(object.g()) && Long.compare(l2, l) == 0) {
                                    } else {
                                    }
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                    if (num.equals(object.b()) && Long.compare(l2, l) == 0) {
                    } else {
                    }
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.android.datatransport.cct.f.l
    public byte[] f() {
        return this.d;
    }

    @Override // com.google.android.datatransport.cct.f.l
    public String g() {
        return this.e;
    }

    @Override // com.google.android.datatransport.cct.f.l
    public long h() {
        return this.f;
    }

    @Override // com.google.android.datatransport.cct.f.l
    public int hashCode() {
        int i;
        int i3;
        int i2;
        long l = this.a;
        int i20 = 32;
        int i19 = 1000003;
        Integer num = this.b;
        i2 = 0;
        if (num == null) {
            i = i2;
        } else {
            i = num.hashCode();
        }
        long l2 = this.c;
        String str = this.e;
        if (str == null) {
            i3 = i2;
        } else {
            i3 = str.hashCode();
        }
        long l3 = this.f;
        com.google.android.datatransport.cct.f.o oVar = this.g;
        if (oVar == null) {
        } else {
            i2 = oVar.hashCode();
        }
        return i17 ^= i2;
    }

    @Override // com.google.android.datatransport.cct.f.l
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LogEvent{eventTimeMs=");
        stringBuilder.append(this.a);
        stringBuilder.append(", eventCode=");
        stringBuilder.append(this.b);
        stringBuilder.append(", eventUptimeMs=");
        stringBuilder.append(this.c);
        stringBuilder.append(", sourceExtension=");
        stringBuilder.append(Arrays.toString(this.d));
        stringBuilder.append(", sourceExtensionJsonProto3=");
        stringBuilder.append(this.e);
        stringBuilder.append(", timezoneOffsetSeconds=");
        stringBuilder.append(this.f);
        stringBuilder.append(", networkConnectionInfo=");
        stringBuilder.append(this.g);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

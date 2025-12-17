package d.s.a;

/* loaded from: classes.dex */
public final class a implements d.s.a.j {

    private final String a;
    private final Object[] b;
    public a(String string) {
        super(string, 0);
    }

    public a(String string, Object[] object2Arr2) {
        super();
        this.a = string;
        this.b = object2Arr2;
    }

    private static void b(d.s.a.i i, int i2, Object object3) {
        boolean doubleValue;
        Object obj4;
        if (object3 == null) {
            i.k1(i2);
        } else {
            if (object3 instanceof byte[]) {
                i.B0(i2, (byte[])object3);
            } else {
                if (object3 instanceof Float) {
                    i.W(i2, (double)obj4);
                } else {
                    if (object3 instanceof Double) {
                        i.W(i2, (Double)object3.doubleValue());
                    } else {
                        if (object3 instanceof Long) {
                            i.u0(i2, (Long)object3.longValue());
                        } else {
                            if (object3 instanceof Integer) {
                                i.u0(i2, (long)obj4);
                            } else {
                                if (object3 instanceof Short) {
                                    i.u0(i2, (long)obj4);
                                } else {
                                    if (object3 instanceof Byte) {
                                        i.u0(i2, (long)obj4);
                                    } else {
                                        if (object3 instanceof String != null) {
                                            i.D(i2, (String)object3);
                                        } else {
                                            if (!object3 instanceof Boolean) {
                                            } else {
                                                doubleValue = (Boolean)object3.booleanValue() ? 1 : 0;
                                                i.u0(i2, doubleValue);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot bind ");
        stringBuilder.append(object3);
        stringBuilder.append(" at index ");
        stringBuilder.append(i2);
        stringBuilder.append(" Supported types: null, byte[], float, double, long, int, short, byte, string");
        IllegalArgumentException obj2 = new IllegalArgumentException(stringBuilder.toString());
        throw obj2;
    }

    public static void d(d.s.a.i i, Object[] object2Arr2) {
        int i2;
        Object obj;
        if (object2Arr2 == null) {
        }
        i2 = 0;
        while (i2 < object2Arr2.length) {
            a.b(i, i2++, object2Arr2[i2]);
        }
    }

    @Override // d.s.a.j
    public String a() {
        return this.a;
    }

    @Override // d.s.a.j
    public void c(d.s.a.i i) {
        a.d(i, this.b);
    }
}

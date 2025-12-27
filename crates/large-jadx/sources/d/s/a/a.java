package d.s.a;

/* compiled from: SimpleSQLiteQuery.java */
/* loaded from: classes.dex */
public final class a implements j {

    private final String a;
    private final Object[] b;
    public a(String str, Object[] objectArr) {
        super();
        this.a = str;
        this.b = objectArr;
    }

    private static void b(i iVar, int i, Object object) {
        if (object == null) {
            iVar.k1(i);
            return;
        } else {
            z = object instanceof byte[];
            if (object instanceof byte[]) {
                iVar.B0(i, object);
            } else {
                if (object instanceof Float) {
                    iVar.W(i, (double)object.floatValue());
                } else {
                    if (object instanceof Double) {
                        iVar.W(i, object.doubleValue());
                    } else {
                        if (object instanceof Long) {
                            iVar.u0(i, object.longValue());
                        } else {
                            if (object instanceof Integer) {
                                iVar.u0(i, (long)object.intValue());
                            } else {
                                if (object instanceof Short) {
                                    iVar.u0(i, (long)object.shortValue());
                                } else {
                                    if (object instanceof Byte) {
                                        iVar.u0(i, (long)object.byteValue());
                                    } else {
                                        z = object instanceof String;
                                        if (object instanceof String) {
                                            iVar.D(i, object);
                                        } else {
                                            if (object instanceof Boolean) {
                                                int r0 = object.booleanValue() ? 1 : 0;
                                                iVar.u0(i, (object.booleanValue() ? 1 : 0));
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
        final String str = "Cannot bind ";
        String str3 = " at index ";
        String str2 = " Supported types: null, byte[], float, double, long, int, short, byte, string";
        i = str + object + str3 + i + str2;
        throw new IllegalArgumentException(i);
    }

    public static void d(i iVar, Object[] objectArr) {
        int i = 0;
        if (objectArr == null) {
            return;
        }
        i = 0;
        while (i < objectArr.length) {
            i = i + 1;
            a.b(iVar, i, objectArr[i]);
        }
    }

    public String a() {
        return this.a;
    }

    public void c(i iVar) {
        a.d(iVar, this.b);
    }

    public a(String str) {
        this(str, null);
    }
}

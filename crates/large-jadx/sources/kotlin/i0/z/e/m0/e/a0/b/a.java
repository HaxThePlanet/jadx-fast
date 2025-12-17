package kotlin.i0.z.e.m0.e.a0.b;

/* loaded from: classes3.dex */
public class a {
    static {
        String property;
        try {
            property = System.getProperty("kotlin.jvm.serialization.use8to7");
            int i = 0;
            "true".equals(property);
        }
    }

    private static void a(int i) {
        Object illegalStateException;
        String str;
        int i2;
        String str3;
        String str2;
        int i3 = i;
        final int i4 = 14;
        final int i5 = 12;
        final int i6 = 10;
        final int i7 = 8;
        final int i8 = 6;
        final int i9 = 3;
        final int i10 = 1;
        if (i3 != i10 && i3 != i9 && i3 != i8 && i3 != i7 && i3 != i6 && i3 != i5 && i3 != i4) {
            if (i3 != i9) {
                if (i3 != i8) {
                    if (i3 != i7) {
                        if (i3 != i6) {
                            if (i3 != i5) {
                                str = i3 != i4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
                            } else {
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
        }
        final int i11 = 2;
        if (i3 != i10 && i3 != i9 && i3 != i8 && i3 != i7 && i3 != i6 && i3 != i5 && i3 != i4) {
            if (i3 != i9) {
                if (i3 != i8) {
                    if (i3 != i7) {
                        if (i3 != i6) {
                            if (i3 != i5) {
                                i2 = i3 != i4 ? i9 : i11;
                            } else {
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
        }
        Object[] arr = new Object[i2];
        str3 = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
        int i12 = 0;
        if (i3 != i10 && i3 != i9 && i3 != i8 && i3 != i7 && i3 != i6 && i3 != i5 && i3 != i4) {
            if (i3 != i9) {
                if (i3 != i8) {
                    if (i3 != i7) {
                        if (i3 != i6) {
                            if (i3 != i5) {
                                if (i3 != i4) {
                                    arr[i12] = "data";
                                } else {
                                    arr[i12] = str3;
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
            }
        } else {
        }
        String str4 = "decode7to8";
        String str5 = "combineStringArrayIntoBytes";
        final String str6 = "dropMarker";
        final String str7 = "decodeBytes";
        final String str8 = "splitBytesToStringArray";
        final String str9 = "encode8to7";
        final String str10 = "encodeBytes";
        if (i3 != i10) {
            if (i3 != i9) {
                if (i3 != i8) {
                    if (i3 != i7) {
                        if (i3 != i6) {
                            if (i3 != i5) {
                                if (i3 != i4) {
                                    arr[i10] = str3;
                                } else {
                                    arr[i10] = str4;
                                }
                            } else {
                                arr[i10] = str5;
                            }
                        } else {
                            arr[i10] = str6;
                        }
                    } else {
                        arr[i10] = str7;
                    }
                } else {
                    arr[i10] = str8;
                }
            } else {
                arr[i10] = str9;
            }
        } else {
            arr[i10] = str10;
        }
        switch (i3) {
            case 2:
                arr[i11] = str9;
                break;
            case 3:
                arr[i11] = "addModuloByte";
                break;
            case 4:
                arr[i11] = str8;
                break;
            case 5:
                arr[i11] = str7;
                break;
            case 6:
                arr[i11] = str6;
                break;
            case 7:
                arr[i11] = str5;
                break;
            case 8:
                arr[i11] = str4;
                break;
            default:
                arr[i11] = str10;
        }
        String format = String.format(str, arr);
        if (i3 != i10 && i3 != i9 && i3 != i8 && i3 != i7 && i3 != i6 && i3 != i5 && i3 != i4) {
            if (i3 != i9) {
                if (i3 != i8) {
                    if (i3 != i7) {
                        if (i3 != i6) {
                            if (i3 != i5) {
                                if (i3 != i4) {
                                    illegalStateException = new IllegalArgumentException(format);
                                } else {
                                    illegalStateException = new IllegalStateException(format);
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
            }
        } else {
        }
        throw illegalStateException;
    }

    private static void b(byte[] bArr, int i2) {
        int i;
        byte b;
        if (bArr == null) {
        } else {
            i = 0;
            while (i < bArr.length) {
                bArr[i] = (byte)i4;
                i++;
            }
        }
        a.a(4);
        throw 0;
    }

    private static byte[] c(String[] stringArr) {
        int i4;
        int i2;
        int i5;
        int length2;
        int i3;
        Object obj;
        int length;
        int i;
        int i6;
        byte b;
        if (stringArr == null) {
        } else {
            final int i7 = 0;
            i2 = i4;
            while (i4 < stringArr.length) {
                i2 += length2;
                i4++;
            }
            byte[] bArr = new byte[i2];
            i3 = i5;
            while (i5 < stringArr.length) {
                obj = stringArr[i5];
                i = i7;
                while (i < obj.length()) {
                    bArr[i3] = (byte)charAt;
                    i++;
                    i3 = i6;
                }
                i5++;
                bArr[i3] = (byte)charAt;
                i++;
                i3 = i6;
            }
            return bArr;
        }
        a.a(11);
        throw 0;
    }

    private static byte[] d(byte[] bArr) {
        int i6;
        int i7;
        int i4;
        int i8;
        int i5;
        int i2;
        int i3;
        int i;
        if (bArr == null) {
        } else {
            i9 /= 8;
            final byte[] bArr2 = new byte[i10];
            final int i11 = 0;
            i4 = i7;
            while (i6 < i10) {
                int i15 = 1;
                i7 += i15;
                i3 = i4 + 1;
                bArr2[i6] = (byte)i14;
                if (i4 == 6) {
                } else {
                }
                i4 = i3;
                i6++;
                i7++;
                i4 = i11;
            }
            return bArr2;
        }
        a.a(13);
        throw 0;
    }

    public static byte[] e(String[] stringArr) {
        int i;
        int charAt;
        boolean empty;
        String[] obj3;
        i = 0;
        if (stringArr == null) {
        } else {
            charAt = 0;
            charAt = stringArr[charAt].charAt(charAt);
            if (stringArr.length > 0 && !stringArr[charAt].isEmpty() && charAt == 0) {
                charAt = 0;
                if (!stringArr[charAt].isEmpty()) {
                    charAt = stringArr[charAt].charAt(charAt);
                    if (charAt == 0) {
                        obj3 = i.a(a.f(stringArr));
                        if (obj3 == null) {
                        } else {
                            return obj3;
                        }
                        a.a(8);
                        throw i;
                    }
                    if (charAt == 65535) {
                        obj3 = a.f(stringArr);
                    }
                }
            }
            obj3 = a.c(obj3);
            a.b(obj3, 127);
            return a.d(obj3);
        }
        a.a(7);
        throw i;
    }

    private static String[] f(String[] stringArr) {
        final int i = 0;
        if (stringArr == null) {
        } else {
            Object obj4 = stringArr.clone();
            final int i2 = 0;
            obj4[i2] = (String[])obj4[i2].substring(1);
            if (obj4 == null) {
            } else {
                return obj4;
            }
            a.a(10);
            throw i;
        }
        a.a(9);
        throw i;
    }
}

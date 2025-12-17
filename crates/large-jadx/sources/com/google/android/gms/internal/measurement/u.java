package com.google.android.gms.internal.measurement;

import android.accounts.Account;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class u implements Iterable<com.google.android.gms.internal.measurement.q>, com.google.android.gms.internal.measurement.q {

    private final String a;
    public u(String string) {
        super();
        if (string == null) {
        } else {
            this.a = string;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("StringValue cannot be null.");
        throw obj2;
    }

    static String g(com.google.android.gms.internal.measurement.u u) {
        return u.a;
    }

    @Override // java.lang.Iterable
    public final com.google.android.gms.internal.measurement.q b() {
        u uVar = new u(this.a);
        return uVar;
    }

    @Override // java.lang.Iterable
    public final Boolean d() {
        return Boolean.valueOf(empty ^= 1);
    }

    @Override // java.lang.Iterable
    public final boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (!object instanceof u) {
            return 0;
        }
        return this.a.equals(object.a);
    }

    public final Iterator<com.google.android.gms.internal.measurement.q> h() {
        s sVar = new s(this);
        return sVar;
    }

    @Override // java.lang.Iterable
    public final int hashCode() {
        return this.a.hashCode();
    }

    public final Iterator<com.google.android.gms.internal.measurement.q> iterator() {
        t tVar = new t(this);
        return tVar;
    }

    public final com.google.android.gms.internal.measurement.q m(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        int size2;
        String upperCase;
        com.google.android.gms.internal.measurement.q i5;
        double doubleValue5;
        int i;
        int i8;
        int length4;
        int length3;
        Object list2;
        double doubleValue4;
        Object obj2;
        Object substring;
        int length2;
        Object iVar;
        Object list;
        String[] split;
        int i3;
        Object equals;
        int cREATOR;
        int doubleValue3;
        double d2;
        int eNGLISH;
        int i6;
        int size;
        int i7;
        String indexOf;
        double doubleValue;
        double d;
        int size4;
        double doubleValue2;
        double d3;
        com.google.android.gms.internal.measurement.q size3;
        int i9;
        Object uVar;
        double d4;
        String arrayList;
        double i4;
        boolean list4;
        boolean equals2;
        int length;
        int cmp;
        StringBuilder stringBuilder;
        String str2;
        String str3;
        String equals3;
        String str6;
        Object obj;
        int str;
        String equals4;
        String str4;
        String str5;
        Object obj3 = this;
        equals = string;
        int i27 = b52;
        List list16 = list3;
        String str28 = "charAt";
        length = "indexOf";
        stringBuilder = "replace";
        str2 = "substring";
        final String str30 = "split";
        final String str31 = "slice";
        final String str32 = "match";
        str3 = "lastIndexOf";
        final String str34 = "search";
        final String str35 = "toLowerCase";
        eNGLISH = "toLocaleLowerCase";
        String str7 = "toString";
        String str26 = "hasOwnProperty";
        final String str36 = str28;
        uVar = "toUpperCase";
        equals4 = equals3;
        if (!str28.equals(equals) && !"concat".equals(equals) && !str26.equals(equals) && !length.equals(equals) && !str3.equals(equals) && !str32.equals(equals) && !stringBuilder.equals(equals) && !str34.equals(equals) && !str31.equals(equals) && !str30.equals(equals) && !str2.equals(equals) && !str35.equals(equals) && !eNGLISH.equals(equals) && !str7.equals(equals) && !uVar.equals(equals)) {
            if (!"concat".equals(equals)) {
                if (!str26.equals(equals)) {
                    if (!length.equals(equals)) {
                        if (!str3.equals(equals)) {
                            if (!str32.equals(equals)) {
                                if (!stringBuilder.equals(equals)) {
                                    if (!str34.equals(equals)) {
                                        if (!str31.equals(equals)) {
                                            if (!str30.equals(equals)) {
                                                if (!str2.equals(equals)) {
                                                    if (!str35.equals(equals)) {
                                                        if (!eNGLISH.equals(equals)) {
                                                            if (!str7.equals(equals)) {
                                                                if (!uVar.equals(equals)) {
                                                                    if (!equals4.equals(equals)) {
                                                                        if (!"trim".equals(equals)) {
                                                                        } else {
                                                                        }
                                                                        Object[] arr2 = new Object[1];
                                                                        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(String.format("%s is not a String function", equals));
                                                                        throw illegalArgumentException2;
                                                                    }
                                                                } else {
                                                                    arrayList = equals4;
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
            } else {
            }
        } else {
        }
        String str37 = str26;
        switch (str) {
            case -1789698943:
                str6 = str36;
                str4 = str7;
                i8 = 2;
                i8 = -1;
                str4 = str7;
                break;
            case -1776922004:
                indexOf = str37;
                str6 = str36;
                i8 = 14;
                indexOf = str37;
                i8 = -1;
                str4 = str7;
                break;
            case -1464939364:
                indexOf = str37;
                str6 = str36;
                i8 = 12;
                indexOf = str37;
                i8 = -1;
                str4 = str7;
                break;
            case -1361633751:
                indexOf = str37;
                indexOf = str37;
                i8 = 0;
                i8 = -1;
                str4 = str7;
                break;
            case -1354795244:
                str6 = str36;
                indexOf = str37;
                str6 = str36;
                indexOf = str37;
                i8 = 1;
                i8 = -1;
                str4 = str7;
                break;
            case -1137582698:
                str6 = str36;
                indexOf = str37;
                i8 = 13;
                str6 = str36;
                indexOf = str37;
                i8 = -1;
                str4 = str7;
                break;
            case -906336856:
                str6 = str36;
                indexOf = str37;
                i8 = 7;
                str6 = str36;
                indexOf = str37;
                i8 = -1;
                str4 = str7;
                break;
            case -726908483:
                str6 = str36;
                indexOf = str37;
                i8 = 11;
                str6 = str36;
                indexOf = str37;
                i8 = -1;
                str4 = str7;
                break;
            case -467511597:
                str6 = str36;
                indexOf = str37;
                i8 = 4;
                str6 = str36;
                indexOf = str37;
                i8 = -1;
                str4 = str7;
                break;
            case -399551817:
                str6 = str36;
                indexOf = str37;
                i8 = 15;
                str6 = str36;
                indexOf = str37;
                i8 = -1;
                str4 = str7;
                break;
            case 3568674:
                str6 = str36;
                indexOf = str37;
                i8 = 16;
                str6 = str36;
                indexOf = str37;
                i8 = -1;
                str4 = str7;
                break;
            case 103668165:
                str6 = str36;
                indexOf = str37;
                i8 = 5;
                str6 = str36;
                indexOf = str37;
                i8 = -1;
                str4 = str7;
                break;
            case 109526418:
                str6 = str36;
                indexOf = str37;
                i8 = 8;
                str6 = str36;
                indexOf = str37;
                i8 = -1;
                str4 = str7;
                break;
            case 109648666:
                str6 = str36;
                indexOf = str37;
                i8 = 9;
                str6 = str36;
                indexOf = str37;
                i8 = -1;
                str4 = str7;
                break;
            case 530542161:
                str6 = str36;
                indexOf = str37;
                i8 = 10;
                str6 = str36;
                indexOf = str37;
                i8 = -1;
                str4 = str7;
                break;
            case 1094496948:
                str6 = str36;
                indexOf = str37;
                i8 = 6;
                str6 = str36;
                indexOf = str37;
                i8 = -1;
                str4 = str7;
                break;
            case 1943291465:
                str6 = str36;
                indexOf = str37;
                i8 = 3;
                str6 = str36;
                indexOf = str37;
                i8 = -1;
                str4 = str7;
                break;
            default:
                str6 = str36;
                indexOf = str37;
                i8 = -1;
                str4 = str7;
        }
        upperCase = "";
        str5 = "undefined";
        switch (i8) {
            case 0:
                List list7 = list3;
                b6.j(str6, 1, list7);
                upperCase = (int)d5;
                upperCase = 0;
                String str20 = obj.a;
                eNGLISH = new u(String.valueOf(str20.charAt(upperCase)));
                iVar = eNGLISH;
                iVar = q.o;
                return iVar;
            case 1:
                StringBuilder stringBuilder2 = new StringBuilder(obj.a);
                eNGLISH = 0;
                stringBuilder2.append(b52.b((q)list3.get(eNGLISH)).zzi());
                eNGLISH++;
                iVar = new u(stringBuilder2.toString());
                iVar = obj;
                return iVar;
            case 2:
                List list8 = list3;
                b6.h(indexOf, 1, list8);
                com.google.android.gms.internal.measurement.q qVar5 = b52.b((q)list8.get(0));
                eNGLISH = "length".equals(qVar5.zzi());
                iVar = q.m;
                doubleValue4 = qVar5.zzh().doubleValue();
                doubleValue4 = (int)doubleValue4;
                iVar = q.m;
                iVar = q.n;
                return iVar;
            case 3:
                int i47 = b52;
                substring = list3;
                int i19 = 2;
                b6.j(length, i19, substring);
                str5 = i47.b((q)substring.get(0)).zzi();
                doubleValue5 = stringBuilder;
                doubleValue5 = i47.b((q)substring.get(1)).zzh().doubleValue();
                uVar = new i(Double.valueOf((double)indexOf2));
                iVar = uVar;
                return iVar;
            case 4:
                uVar = b52;
                list = list3;
                int i39 = 2;
                b6.j(str3, i39, list);
                str5 = uVar.b((q)list.get(0)).zzi();
                doubleValue2 = 9221120237041090560L;
                doubleValue2 = uVar.b((q)list.get(1)).zzh().doubleValue();
                d3 = 9218868437227405312L;
                d3 = b6.a(doubleValue2);
                indexOf = (int)d3;
                iVar = new i(Double.valueOf((double)lastIndexOf));
                return iVar;
            case 5:
                list2 = list3;
                b6.j(str32, 1, list2);
                upperCase = b52.b((q)list2.get(0)).zzi();
                upperCase = Pattern.compile(upperCase).matcher(obj.a);
                eNGLISH = new q[1];
                indexOf = new u(upperCase.group());
                iVar = new f(Arrays.asList(indexOf));
                iVar = q.i;
                return iVar;
            case 6:
                obj = this;
                uVar = b52;
                List list13 = list3;
                b6.j(stringBuilder, 2, list13);
                upperCase = q.h;
                str5 = uVar.b((q)list13.get(0)).zzi();
                indexOf = 1;
                upperCase = uVar.b((q)list13.get(indexOf));
                obj2 = str5;
                eNGLISH = obj.a;
                indexOf = eNGLISH.indexOf(obj2);
                com.google.android.gms.internal.measurement.q[] arr3 = new q[3];
                u uVar2 = new u(obj2);
                i iVar2 = new i(Double.valueOf((double)indexOf));
                upperCase = (j)upperCase.a(uVar, Arrays.asList(uVar2, iVar2, obj));
                arrayList = eNGLISH.substring(0, indexOf);
                String str16 = upperCase.zzi();
                substring = eNGLISH.substring(indexOf += length5);
                stringBuilder = new StringBuilder(i33 += length);
                stringBuilder.append(arrayList);
                stringBuilder.append(str16);
                stringBuilder.append(substring);
                uVar = new u(stringBuilder.toString());
                iVar = uVar;
                iVar = obj;
                return iVar;
            case 7:
                List list5 = list3;
                indexOf = 0;
                b6.j(str34, 1, list5);
                str5 = b52.b((q)list5.get(indexOf)).zzi();
                Matcher matcher = Pattern.compile(str5).matcher(obj.a);
                iVar = new i(Double.valueOf((double)start));
                iVar = new i(Double.valueOf(-4616189618054758400L));
                return iVar;
            case 8:
                uVar = b52;
                List list6 = list3;
                b6.j(str31, 2, list6);
                String str9 = obj.a;
                doubleValue3 = uVar.b((q)list6.get(0)).zzh().doubleValue();
                doubleValue3 = 0;
                double d8 = b6.a(doubleValue3);
                i4 = 0;
                d2 = Math.max(d12 += d8, str2);
                d2 = Math.min(d8, indexOf);
                eNGLISH = (int)d2;
                int i48 = 1;
                doubleValue = uVar.b((q)list6.get(i48)).zzh().doubleValue();
                doubleValue = (double)length4;
                double d10 = b6.a(doubleValue);
                stringBuilder = 0;
                d = Math.max(d11 += d10, length);
                d = Math.min(d10, uVar);
                indexOf = new u(str9.substring(eNGLISH, i24 += eNGLISH));
                break;
            case 9:
                obj = this;
                uVar = b52;
                split = list3;
                b6.j(str30, 2, split);
                eNGLISH = obj.a;
                com.google.android.gms.internal.measurement.q[] arr = new q[1];
                iVar = new f(Arrays.asList(obj));
                arrayList = new ArrayList();
                arrayList.add(obj);
                indexOf = uVar.b((q)split.get(0)).zzi();
                stringBuilder = 1;
                length = b6.d(uVar.b((q)split.get(stringBuilder)).zzh().doubleValue());
                length = Integer.MAX_VALUE;
                iVar = new f();
                split = eNGLISH.split(Pattern.quote(indexOf), i45 += str2);
                int length7 = split.length;
                uVar = length7;
                equals4 = indexOf;
                uVar = length7;
                equals4 = 0;
                uVar--;
                upperCase = equals4;
                eNGLISH = new u(split[upperCase]);
                arrayList.add(eNGLISH);
                upperCase++;
                iVar = new f(arrayList);
                return iVar;
            case 10:
                List list9 = list3;
                b6.j(str2, 2, list9);
                String str11 = obj.a;
                i6 = (int)d9;
                d4 = b52;
                i6 = 0;
                arrayList = 1;
                length2 = (int)size4;
                length2 = str11.length();
                int i38 = 0;
                eNGLISH = Math.min(Math.max(i6, i38), str11.length());
                int i26 = Math.min(Math.max(length2, i38), str11.length());
                indexOf = new u(str11.substring(Math.min(eNGLISH, i26), Math.max(eNGLISH, i26)));
                break;
            case 11:
                b6.h(arrayList, 0, list3);
                iVar = new u(obj.a.toUpperCase());
                return iVar;
            case 12:
                b6.h(eNGLISH, 0, list3);
                iVar = new u(obj.a.toLowerCase());
                return iVar;
            case 13:
                b6.h(str35, 0, list3);
                iVar = new u(obj.a.toLowerCase(Locale.ENGLISH));
                return iVar;
            case 14:
                obj = this;
                b6.h(str4, 0, list3);
                iVar = obj;
                return iVar;
            case 15:
                b6.h(uVar, 0, list3);
                iVar = new u(obj.a.toUpperCase(Locale.ENGLISH));
                return iVar;
            case 16:
                b6.h(uVar, 0, list3);
                iVar = new u(obj.a.trim());
                return iVar;
            default:
                Object obj19 = this;
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Command not supported");
                throw illegalArgumentException;
        }
        iVar = indexOf;
    }

    @Override // java.lang.Iterable
    public final String toString() {
        String str = this.a;
        StringBuilder stringBuilder = new StringBuilder(length += 2);
        int i2 = 34;
        stringBuilder.append(i2);
        stringBuilder.append(str);
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    @Override // java.lang.Iterable
    public final Double zzh() {
        if (this.a.isEmpty()) {
            return Double.valueOf(0);
        }
        return Double.valueOf(this.a);
    }

    @Override // java.lang.Iterable
    public final String zzi() {
        return this.a;
    }
}

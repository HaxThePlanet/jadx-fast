package net.time4j.calendar.t;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;
import net.time4j.g1.b;
import net.time4j.g1.m;
import net.time4j.g1.s;
import net.time4j.g1.u;
import net.time4j.g1.v;
import net.time4j.h1.d;
import net.time4j.h1.e;

/* loaded from: classes3.dex */
public final class b implements u {

    private static final String[] a;
    private static final Set<String> b;
    private static final Set<String> c;
    static {
        Object rOOT;
        boolean locale;
        b.a = new String[0];
        HashSet hashSet2 = new HashSet();
        Collections.addAll(hashSet2, e.h("calendar/names/generic/generic", Locale.ROOT).f("languages").split(" "));
        hashSet2.add("");
        Set unmodifiableSet = Collections.unmodifiableSet(hashSet2);
        b.c = unmodifiableSet;
        HashSet hashSet3 = new HashSet();
        Iterator iterator = unmodifiableSet.iterator();
        while (iterator.hasNext()) {
            rOOT = iterator.next();
            if ((String)rOOT.isEmpty()) {
            } else {
            }
            locale = new Locale(rOOT);
            hashSet3.add(locale);
            hashSet3.add(Locale.ROOT);
        }
        Collections.unmodifiableSet(hashSet3);
        HashSet hashSet = new HashSet();
        hashSet.add("buddhist");
        hashSet.add("chinese");
        hashSet.add("coptic");
        hashSet.add("dangi");
        hashSet.add("ethiopic");
        hashSet.add("frenchrev");
        hashSet.add("hindu");
        hashSet.add("generic");
        hashSet.add("hebrew");
        hashSet.add("indian");
        hashSet.add("islamic");
        hashSet.add("japanese");
        hashSet.add("juche");
        hashSet.add("persian");
        hashSet.add("roc");
        hashSet.add("vietnam");
        b.b = Collections.unmodifiableSet(hashSet);
    }

    private static int a(String string) {
        String equals;
        int obj1;
        if (string.equals("hindu")) {
            return 6;
        }
        if (!string.equals("ethiopic") && !string.equals("generic") && !string.equals("roc") && !string.equals("buddhist")) {
            if (!string.equals("generic")) {
                if (!string.equals("roc")) {
                    if (!string.equals("buddhist")) {
                        if (string.equals("korean")) {
                            obj1 = 2;
                        } else {
                            obj1 = 1;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private static int e(String string) {
        boolean equals;
        int obj1;
        if (!string.equals("coptic") && !string.equals("ethiopic") && !string.equals("generic")) {
            if (!string.equals("ethiopic")) {
                if (!string.equals("generic")) {
                    if (string.equals("hebrew")) {
                        obj1 = 13;
                    } else {
                        obj1 = 12;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    static e g(String string, Locale locale2) {
        Locale obj3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("calendar/names/");
        stringBuilder.append(string);
        stringBuilder.append("/");
        stringBuilder.append(string);
        if (b.c.contains(d.getAlias(locale2))) {
        } else {
            obj3 = Locale.ROOT;
        }
        return e.h(stringBuilder.toString(), obj3);
    }

    private static String k(e e, String string2) {
        String str;
        boolean obj2;
        str = "useShortKeys";
        if (e.b(str) && "true".equals(e.f(str))) {
            if ("true".equals(e.f(str))) {
                return string2.substring(0, 1);
            }
        }
        return string2;
    }

    private static String[] l(e e, String string2, String string3, int i4, String string5, v v6, m m7, boolean z8, int i9) {
        int i2;
        int i;
        String str;
        boolean equals2;
        char sTANDALONE;
        int equals;
        m sTANDALONE2;
        final String[] strArr = new String[i4];
        final int i3 = 0;
        if (string5.length() == 1) {
        } else {
            i = i3;
        }
        i2 = i3;
        while (i2 < i4) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string5);
            stringBuilder.append('(');
            if (i != 0) {
            } else {
            }
            stringBuilder.append(v6.name());
            sTANDALONE2 = 124;
            if (m7 == m.STANDALONE) {
            }
            if (z8) {
            }
            stringBuilder.append(')');
            stringBuilder.append('_');
            stringBuilder.append(i2 + i9);
            if (z8 && i2 == 6 && string2.equals("hebrew")) {
            }
            String string = stringBuilder.toString();
            if (z8 && string2.equals("chinese")) {
            }
            strArr[i2] = str;
            i2++;
            if (string2.equals("chinese")) {
            }
            str = b.m(e.f(string), string3, v6, m7);
            if (i2 == 6) {
            }
            if (string2.equals("hebrew")) {
            }
            stringBuilder.append('L');
            stringBuilder.append(sTANDALONE2);
            stringBuilder.append("LEAP");
            stringBuilder.append(sTANDALONE2);
            stringBuilder.append(m7.name());
            if (m7 != m.STANDALONE) {
            }
            stringBuilder.append(sTANDALONE);
            sTANDALONE = Character.toLowerCase(v6.name().charAt(i3));
        }
        return strArr;
    }

    private static String m(String string, String string2, v v3, m m4) {
        boolean equals;
        String str;
        String obj2;
        StringBuilder obj3;
        Object obj4;
        str = "i";
        if (string2.equals("en")) {
            if (v3 == v.NARROW) {
                obj3 = new StringBuilder();
                obj3.append(str);
                obj3.append(string);
                obj2 = obj3.toString();
            } else {
                obj3 = new StringBuilder();
                obj3.append("(leap) ");
                obj3.append(string);
                obj2 = obj3.toString();
            }
        } else {
            if (!string2.equals("de") && !string2.equals("es") && !string2.equals("fr") && !string2.equals("it") && !string2.equals("pt")) {
                if (!string2.equals("es")) {
                    if (!string2.equals("fr")) {
                        if (!string2.equals("it")) {
                            if (!string2.equals("pt")) {
                                if (string2.equals("ro")) {
                                    if (v3 == v.NARROW) {
                                        obj3 = new StringBuilder();
                                        obj3.append(str);
                                        obj3.append(string);
                                        obj2 = obj3.toString();
                                    } else {
                                        obj3 = new StringBuilder();
                                        obj3.append("(i) ");
                                        obj3.append(string);
                                        obj2 = obj3.toString();
                                    }
                                } else {
                                    str = "閏";
                                    if (string2.equals("ja")) {
                                        obj3 = new StringBuilder();
                                        obj3.append(str);
                                        obj3.append(string);
                                        obj2 = obj3.toString();
                                    } else {
                                        if (string2.equals("ko")) {
                                            obj3 = new StringBuilder();
                                            obj3.append("윤");
                                            obj3.append(string);
                                            obj2 = obj3.toString();
                                        } else {
                                            if (string2.equals("zh")) {
                                                obj3 = new StringBuilder();
                                                obj3.append(str);
                                                obj3.append(string);
                                                obj2 = obj3.toString();
                                            } else {
                                                if (string2.equals("vi")) {
                                                    if (v3 == v.NARROW) {
                                                        obj3 = new StringBuilder();
                                                        obj3.append(string);
                                                        obj3.append("n");
                                                        obj2 = obj3.toString();
                                                    } else {
                                                        obj3 = new StringBuilder();
                                                        obj3.append(string);
                                                        obj2 = m4 == m.STANDALONE ? " Nhuận" : " nhuận";
                                                        obj3.append(obj2);
                                                        obj2 = obj3.toString();
                                                    }
                                                } else {
                                                    obj3 = new StringBuilder();
                                                    obj3.append("*");
                                                    obj3.append(string);
                                                    obj2 = obj3.toString();
                                                }
                                            }
                                        }
                                    }
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
        }
        return obj2;
    }

    @Override // net.time4j.g1.u
    public String[] b(String string, Locale locale2, v v3) {
        boolean equals;
        String[] strArr;
        boolean aBBREVIATED;
        String obj12;
        v obj14;
        if (!string.equals("chinese")) {
            if (string.equals("vietnam")) {
            } else {
                if (string.equals("japanese") && v3 == v.NARROW) {
                    if (v3 == v.NARROW) {
                        return /* result */;
                    }
                    return /* result */;
                }
                String str6 = "dangi";
                if (!string.equals(str6)) {
                    if (string.equals("juche")) {
                    } else {
                        final e eVar = b.g(string, locale2);
                        if (v3 == v.SHORT) {
                            obj14 = v.ABBREVIATED;
                        }
                        aBBREVIATED = v.ABBREVIATED;
                        if (b.l(eVar, string, locale2.getLanguage(), b.a(string), b.k(eVar, "ERA"), obj14, m.FORMAT, false, 0) == null && obj14 != aBBREVIATED) {
                            aBBREVIATED = v.ABBREVIATED;
                            if (obj14 != aBBREVIATED) {
                                strArr = b(string, locale2, aBBREVIATED);
                            }
                        }
                        if (strArr == null) {
                        } else {
                            return strArr;
                        }
                    }
                    obj12 = new MissingResourceException("Cannot find calendar resource for era.", b.class.getName(), locale2.toString());
                    throw obj12;
                }
                String[] obj13 = b("korean", locale2, v3);
                obj14 = 1;
                String[] strArr2 = new String[obj14];
                int i = 0;
                obj12 = string.equals(str6) ? obj13[i] : obj13[obj14];
            }
            strArr2[i] = obj12;
            return strArr2;
        }
        return b.a;
    }

    @Override // net.time4j.g1.u
    public String[] c(String string, Locale locale2, v v3, m m4) {
        return b.a;
    }

    @Override // net.time4j.g1.u
    public String[] d(String string, Locale locale2, v v3, m m4) {
        return b.a;
    }

    @Override // net.time4j.g1.u
    public boolean f(Locale locale) {
        return 1;
    }

    @Override // net.time4j.g1.u
    public boolean h(String string) {
        return b.b.contains(string);
    }

    @Override // net.time4j.g1.u
    public String[] i(String string, Locale locale2, v v3, m m4) {
        return b.a;
    }

    @Override // net.time4j.g1.u
    public String[] j(String string, Locale locale2, v v3, m m4, boolean z5) {
        String str;
        String[] strArr;
        v aBBREVIATED;
        Object nARROW;
        boolean equals2;
        String language;
        boolean equals;
        int i;
        Object wIDE;
        Enum sTANDALONE;
        m mVar;
        str = string;
        aBBREVIATED = v3;
        m mVar2 = m4;
        if (!str.equals("roc")) {
            if (str.equals("buddhist")) {
            } else {
                if (str.equals("japanese")) {
                    return /* result */;
                }
                if (!str.equals("dangi")) {
                    if (str.equals("vietnam")) {
                        str = "chinese";
                    } else {
                        if (str.equals("hindu")) {
                            str = "indian";
                        } else {
                            if (str.equals("juche")) {
                                return (String[])b.d(locale2).l(aBBREVIATED, mVar2).b().toArray(new String[12]);
                            }
                        }
                    }
                } else {
                }
                String str19 = str;
                e eVar = b.g(str19, locale2);
                if (aBBREVIATED == v.SHORT) {
                    aBBREVIATED = v.ABBREVIATED;
                }
                v vVar = aBBREVIATED;
                if (b.l(eVar, str19, locale2.getLanguage(), b.e(str19), b.k(eVar, "MONTH_OF_YEAR"), vVar, m4, z5, 1) == null) {
                    sTANDALONE = m.STANDALONE;
                    if (mVar2 == sTANDALONE) {
                        if (vVar != v.NARROW) {
                            strArr = this.j(str19, locale2, vVar, m.FORMAT, z5);
                        }
                    } else {
                        if (vVar == v.ABBREVIATED) {
                            strArr = this.j(str19, locale2, v.WIDE, m.FORMAT, z5);
                        } else {
                            if (vVar == v.NARROW) {
                                strArr = this.j(str19, locale2, vVar, sTANDALONE, z5);
                            }
                        }
                    }
                }
                if (strArr == null) {
                } else {
                    return strArr;
                }
            }
            MissingResourceException missingResourceException = new MissingResourceException("Cannot find calendar month.", b.class.getName(), locale2.toString());
            throw missingResourceException;
        }
        Locale locale3 = locale2;
        List list2 = b.d(locale2).l(aBBREVIATED, mVar2).b();
        return (String[])list2.toArray(new String[list2.size()]);
    }

    @Override // net.time4j.g1.u
    public String toString() {
        return "GenericTextProviderSPI";
    }
}

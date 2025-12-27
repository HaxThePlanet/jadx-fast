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

/* compiled from: GenericTextProviderSPI.java */
/* loaded from: classes3.dex */
public final class b implements u {

    private static final String[] a;
    private static final Set<String> b;
    private static final Set<String> c;
    static {
        b.a = new String[0];
        HashSet hashSet2 = new HashSet();
        Collections.addAll(hashSet2, e.h("calendar/names/generic/generic", Locale.ROOT).f("languages").split(" "));
        hashSet2.add("");
        Set unmodifiable = Collections.unmodifiableSet(hashSet2);
        b.c = unmodifiable;
        HashSet hashSet3 = new HashSet();
        Iterator it = unmodifiable.iterator();
        while (it.hasNext()) {
            Locale item = it.next();
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

    private static int a(String str) {
        boolean equals;
        int i = 1;
        if (str.equals("hindu")) {
            return 6;
        }
        if (!str.equals("ethiopic")) {
            if (!str.equals("generic")) {
                if (!str.equals("roc")) {
                    if (!str.equals("buddhist")) {
                        str2 = "korean";
                        if (str.equals(str2)) {
                            i = 2;
                        } else {
                            i = 1;
                        }
                    }
                }
            }
        }
        return i;
    }

    private static int e(String str) {
        boolean equals;
        int i = 13;
        if (!str.equals("coptic")) {
            if (!str.equals("ethiopic")) {
                if (!str.equals("generic")) {
                    if (str.equals("hebrew")) {
                        i = 13;
                    } else {
                        i = 12;
                    }
                }
            }
        }
        return i;
    }

    static e g(String str, Locale locale) {
        Locale rOOT2;
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "calendar/names/";
        String str3 = "/";
        str4 = str2 + str + str3 + str;
        if (!(b.c.contains(d.getAlias(locale)))) {
            rOOT2 = Locale.ROOT;
        }
        return e.h(str2 + str + str3 + str, rOOT2);
    }

    private static String k(e eVar, String str) {
        str = "useShortKeys";
        if (eVar.b(str)) {
            str = "true";
            if (str.equals(eVar.f(str))) {
                return str.substring(0, 1);
            }
        }
        return str;
    }

    private static String[] l(e eVar, String str, String str2, int i, String str3, v vVar, m mVar, boolean z, int i2) {
        char lowerCase;
        m sTANDALONE2;
        boolean equals;
        m sTANDALONE22;
        final String[] strArr = new String[i];
        i = 0;
        i = 1;
        if (str3.length() != 1) {
        }
        while (i < i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str3);
            stringBuilder.append('(');
            stringBuilder.append(')');
            stringBuilder.append('_');
            i2 = i + i2;
            stringBuilder.append(i2);
            String str4 = stringBuilder.toString();
            if (eVar.b(str4) && z) {
                return null;
            }
        }
        return strArr;
    }

    private static String m(String str, String str2, v vVar, m mVar) {
        boolean equals;
        String str4;
        String str5;
        str3 = "i";
        if (str2.equals("en")) {
            if (vVar == v.NARROW) {
                StringBuilder stringBuilder = new StringBuilder();
                str4 = str3 + str;
            } else {
                stringBuilder = new StringBuilder();
                str6 = "(leap) ";
                str4 = str6 + str;
            }
        } else {
            if (!str2.equals("de")) {
                if (!str2.equals("es")) {
                    if (!str2.equals("fr")) {
                        if (!str2.equals("it")) {
                            if (!str2.equals("pt")) {
                                if (str2.equals("ro")) {
                                    if (vVar == v.NARROW) {
                                        stringBuilder = new StringBuilder();
                                        str4 = str3 + str;
                                    } else {
                                        stringBuilder = new StringBuilder();
                                        str6 = "(i) ";
                                        str4 = str6 + str;
                                    }
                                } else {
                                    str3 = "閏";
                                    if (str2.equals("ja")) {
                                        stringBuilder = new StringBuilder();
                                        str4 = str3 + str;
                                    } else {
                                        if (str2.equals("ko")) {
                                            stringBuilder = new StringBuilder();
                                            str6 = "윤";
                                            str4 = str6 + str;
                                        } else {
                                            if (str2.equals("zh")) {
                                                stringBuilder = new StringBuilder();
                                                str4 = str3 + str;
                                            } else {
                                                if (!str2.equals("vi")) {
                                                    stringBuilder = new StringBuilder();
                                                    str6 = "*";
                                                    str4 = str6 + str;
                                                } else {
                                                    if (vVar == v.NARROW) {
                                                        stringBuilder = new StringBuilder();
                                                        String str18 = "n";
                                                        str4 = str + str18;
                                                    } else {
                                                        stringBuilder = new StringBuilder();
                                                        stringBuilder.append(str);
                                                        str = mVar == m.STANDALONE ? " Nhuận" : " nhuận";
                                                        stringBuilder.append((mVar == m.STANDALONE ? " Nhuận" : " nhuận"));
                                                        str4 = stringBuilder.toString();
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
            }
        }
        return str4;
    }

    public String[] b(String str, Locale locale, v vVar) {
        String[] strArr;
        String str3;
        v vVar32;
        if (!str.equals("chinese")) {
            if (!str.equals("vietnam")) {
                if (str.equals("japanese")) {
                    if (vVar == v.NARROW) {
                        return new String[] { "M", "T", "S", "H" };
                    }
                    return new String[] { "Meiji", "Taishō", "Shōwa", "Heisei" };
                }
                String str9 = "dangi";
                if (!str.equals(str9)) {
                    if (!str.equals("juche")) {
                        final e eVar = b.g(str, locale);
                        if (vVar == v.SHORT) {
                            vVar32 = v.ABBREVIATED;
                        }
                        if (b.l(eVar, str, locale.getLanguage(), b.a(str), b.k(eVar, "ERA"), vVar32, m.FORMAT, false, 0) == null && vVar32 != v.ABBREVIATED) {
                            strArr = b(str, locale, v.ABBREVIATED);
                        }
                        if (v.SHORT != null) {
                            return strArr;
                        }
                    }
                    throw new MissingResourceException("Cannot find calendar resource for era.", b.class.getName(), locale.toString());
                }
                String[] strArr6 = b("korean", locale, vVar);
                int i5 = 1;
                String[] strArr2 = new String[i5];
                int i = 0;
                str = str.equals(str9) ? strArr6[i] : strArr6[i5];
            }
            strArr2[i] = (str.equals(str9) ? strArr6[i] : strArr6[i5]);
            return strArr2;
        }
        return b.a;
    }

    public String[] c(String str, Locale locale, v vVar, m mVar) {
        return b.a;
    }

    public String[] d(String str, Locale locale, v vVar, m mVar) {
        return b.a;
    }

    public boolean h(String str) {
        return b.b.contains(str);
    }

    public String[] i(String str, Locale locale, v vVar, m mVar) {
        return b.a;
    }

    public String[] j(String str, Locale locale, v vVar, m mVar, boolean z) {
        String str2;
        String[] strArr;
        v vVar32;
        boolean equals2;
        str2 = str;
        vVar32 = vVar;
        m mVar42 = mVar;
        if (!str2.equals("roc")) {
            if (!str2.equals("buddhist")) {
                if (str2.equals("japanese")) {
                    return new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" };
                }
                if (!str2.equals("dangi")) {
                    if (!str2.equals("vietnam")) {
                        if (!str2.equals("hindu")) {
                            if (str2.equals("juche")) {
                                return (String[])b.d(locale).l(vVar32, mVar42).b().toArray(new String[12]);
                            }
                        } else {
                            str2 = "indian";
                        }
                    } else {
                        str2 = "chinese";
                    }
                }
                e eVar = b.g(str2, locale);
                if (vVar32 == v.SHORT) {
                    vVar32 = v.ABBREVIATED;
                }
                if (b.l(eVar, str2, locale.getLanguage(), b.e(str2), b.k(eVar, "MONTH_OF_YEAR"), vVar32, mVar, z, 1) == null) {
                    m sTANDALONE2 = m.STANDALONE;
                    if (mVar42 == m.STANDALONE) {
                        if (vVar32 != v.NARROW) {
                            strArr = this.j(str2, locale, vVar32, m.FORMAT, z);
                        }
                    } else {
                        if (vVar32 == v.ABBREVIATED) {
                            strArr = this.j(str2, locale, v.WIDE, m.FORMAT, z);
                        } else {
                            if (vVar32 == v.NARROW) {
                                strArr = this.j(str2, locale, vVar32, m.STANDALONE, z);
                            }
                        }
                    }
                }
                if (strArr != null) {
                    return strArr;
                }
            }
            throw new MissingResourceException("Cannot find calendar month.", b.class.getName(), locale.toString());
        }
        List list2 = b.d(locale).l(vVar32, mVar42).b();
        return (String[])list2.toArray(new String[list2.size()]);
    }

    public boolean f(Locale locale) {
        return true;
    }

    @Override // java.lang.Object
    public String toString() {
        return "GenericTextProviderSPI";
    }
}

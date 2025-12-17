package com.google.android.exoplayer2.text.r;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.util.w;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class a extends d {

    private static final Pattern p;
    private static final Pattern q;
    private final StringBuilder n;
    private final ArrayList<String> o;
    static {
        a.p = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
        a.q = Pattern.compile("\\{\\\\.*?\\}");
    }

    public a() {
        super("SubripDecoder");
        StringBuilder stringBuilder = new StringBuilder();
        this.n = stringBuilder;
        ArrayList arrayList = new ArrayList();
        this.o = arrayList;
    }

    private c C(Spanned spanned, String string2) {
        int i;
        boolean equals2;
        Object obj;
        int i3;
        int i2;
        boolean equals;
        int i4;
        equals2 = string2;
        c.b bVar = new c.b();
        bVar.o(spanned);
        if (!equals2) {
            return bVar.a();
        }
        final String str = "{\\an9}";
        final String str2 = "{\\an8}";
        final String str3 = "{\\an7}";
        final String str4 = "{\\an6}";
        final String str5 = "{\\an5}";
        final String str6 = "{\\an4}";
        final String str7 = "{\\an3}";
        final String str8 = "{\\an2}";
        final String str9 = "{\\an1}";
        i4 = 4;
        final int i10 = 3;
        final int i11 = 2;
        final int i9 = 1;
        switch (equals) {
            case -685620710:
                i3 = 0;
                i3 = -1;
                break;
            case -685620679:
                i3 = 6;
                i3 = -1;
                break;
            case -685620648:
                i3 = i10;
                i3 = -1;
                break;
            case -685620617:
                i3 = i9;
                i3 = -1;
                break;
            case -685620586:
                i3 = 7;
                i3 = -1;
                break;
            case -685620555:
                i3 = i4;
                i3 = -1;
                break;
            case -685620524:
                i3 = i11;
                i3 = -1;
                break;
            case -685620493:
                i3 = 8;
                i3 = -1;
                break;
            case -685620462:
                i3 = 5;
                i3 = -1;
                break;
            default:
                i3 = -1;
        }
        if (i3 != 0 && i3 != i9 && i3 != i11) {
            if (i3 != i9) {
                if (i3 != i11) {
                    if (i3 != i10 && i3 != i4 && i3 != 5) {
                        if (i3 != i4) {
                            if (i3 != 5) {
                                bVar.l(i9);
                            } else {
                                bVar.l(i11);
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                    bVar.l(0);
                }
            } else {
            }
        } else {
        }
        switch (i2) {
            case -685620710:
                i = 0;
                i = -1;
                break;
            case -685620679:
                i = i9;
                i = -1;
                break;
            case -685620648:
                i = i11;
                i = -1;
                break;
            case -685620617:
                i = 6;
                i = -1;
                break;
            case -685620586:
                i = 7;
                i = -1;
                break;
            case -685620555:
                i = 8;
                i = -1;
                break;
            case -685620524:
                i = i10;
                i = -1;
                break;
            case -685620493:
                i = 4;
                i = -1;
                break;
            case -685620462:
                i = 5;
                i = -1;
                break;
            default:
                i = -1;
        }
        if (i != 0 && i != i9 && i != i11) {
            if (i != i9) {
                if (i != i11) {
                    if (i != i10 && i != 4 && i != 5) {
                        if (i != 4) {
                            if (i != 5) {
                                bVar.i(i9);
                            } else {
                                bVar.i(0);
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                    bVar.i(i11);
                }
            } else {
            }
        } else {
        }
        bVar.k(a.D(bVar.d()));
        bVar.h(a.D(bVar.c()), 0);
        return bVar.a();
    }

    static float D(int i) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                if (i != 2) {
                } else {
                    return 1064011039;
                }
                IllegalArgumentException obj1 = new IllegalArgumentException();
                throw obj1;
            }
            return 1056964608;
        }
        return 1034147594;
    }

    private static long E(Matcher matcher, int i2) {
        int i;
        int i3;
        String obj9;
        String group = matcher.group(i2 + 1);
        final int i8 = 60;
        final int i9 = 1000;
        if (group != null) {
            i13 *= i9;
        } else {
            i = 0;
        }
        String group2 = matcher.group(i2 + 2);
        g.e(group2);
        String group3 = matcher.group(i2 + 3);
        g.e(group3);
        obj9 = matcher.group(i2 += 4);
        if (obj9 != null) {
            i3 += obj9;
        }
        return i3 *= i9;
    }

    private String F(String string, ArrayList<String> arrayList2) {
        int i2;
        int length;
        int i3;
        int i;
        String str;
        String obj7 = string.trim();
        StringBuilder stringBuilder = new StringBuilder(obj7);
        obj7 = a.q.matcher(obj7);
        i2 = 0;
        while (obj7.find()) {
            String group = obj7.group();
            arrayList2.add(group);
            start -= i2;
            length = group.length();
            stringBuilder.replace(i3, i3 + length, "");
            i2 += length;
        }
        return stringBuilder.toString();
    }

    @Override // com.google.android.exoplayer2.text.d
    protected f z(byte[] bArr, int i2, boolean z3) {
        int length;
        long l;
        int length2;
        boolean matches2;
        boolean matches;
        byte[] obj7;
        int obj8;
        String obj9 = "SubripDecoder";
        ArrayList arrayList = new ArrayList();
        w wVar = new w();
        d0 d0Var = new d0(bArr, i2);
        obj7 = d0Var.o();
        obj8 = 0;
        while (obj7 != null) {
            if (obj7.length() != 0) {
                break;
            } else {
            }
            Integer.parseInt(obj7);
            obj7 = d0Var.o();
            if (obj7 == null) {
                break;
            } else {
            }
            Matcher matcher = a.p.matcher(obj7);
            if (matcher.matches()) {
            } else {
            }
            obj8 = "Skipping invalid timing: ";
            obj7 = String.valueOf(obj7);
            if (obj7.length() != 0) {
            } else {
            }
            obj7 = new String(obj8);
            v.h(obj9, obj7);
            obj7 = d0Var.o();
            obj8 = 0;
            obj7 = obj8.concat(obj7);
            matches2 = a.E(matcher, 1);
            wVar.a(matches2);
            wVar.a(a.E(matcher, 6));
            this.n.setLength(obj8);
            this.o.clear();
            obj7 = d0Var.o();
            while (!TextUtils.isEmpty(obj7)) {
                if (this.n.length() > 0) {
                }
                this.n.append(F(obj7, this.o));
                obj7 = d0Var.o();
                this.n.append("<br>");
            }
            length = 0;
            while (obj8 < this.o.size()) {
                matches2 = this.o.get(obj8);
                if ((String)matches2.matches("\\{\\\\an[1-9]\\}")) {
                    break loop_13;
                } else {
                }
                obj8++;
            }
            arrayList.add(C(Html.fromHtml(this.n.toString()), length));
            arrayList.add(c.r);
            matches2 = this.o.get(obj8);
            if ((String)matches2.matches("\\{\\\\an[1-9]\\}")) {
            } else {
            }
            obj8++;
            length = matches2;
            if (this.n.length() > 0) {
            }
            this.n.append(F(obj7, this.o));
            obj7 = d0Var.o();
            this.n.append("<br>");
        }
        obj9 = new b((c[])arrayList.toArray(new c[obj8]), wVar.d());
        return obj9;
    }
}

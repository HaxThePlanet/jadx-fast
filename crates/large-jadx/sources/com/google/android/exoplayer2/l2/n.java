package com.google.android.exoplayer2.l2;

import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.util.p0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class n {

    private static final Pattern c;
    public int a = -1;
    public int b = -1;
    static {
        n.c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    }

    public n() {
        super();
        final int i = -1;
    }

    private boolean b(String string) {
        boolean find;
        int int;
        int i;
        int i2;
        Matcher obj5;
        obj5 = n.c.matcher(string);
        find = 1;
        String group = obj5.group(find);
        p0.i(group);
        i = 16;
        int = Integer.parseInt((String)group, i);
        obj5 = obj5.group(2);
        p0.i(obj5);
        obj5 = Integer.parseInt((String)obj5, i);
        if (obj5.find() && int <= 0 && obj5 > 0) {
            find = 1;
            group = obj5.group(find);
            p0.i(group);
            i = 16;
            int = Integer.parseInt((String)group, i);
            obj5 = obj5.group(2);
            p0.i(obj5);
            obj5 = Integer.parseInt((String)obj5, i);
            if (int <= 0) {
                if (obj5 > 0) {
                }
            }
            this.a = int;
            this.b = obj5;
            return find;
        }
        return 0;
    }

    public boolean a() {
        int i;
        int i2;
        final int i3 = -1;
        if (this.a != i3 && this.b != i3) {
            i2 = this.b != i3 ? 1 : 0;
        } else {
        }
        return i2;
    }

    public boolean c(a a) {
        int i2;
        com.google.android.exoplayer2.m2.a.b bVar;
        boolean equals;
        String str;
        int i;
        String str2;
        final int i3 = 0;
        i2 = i3;
        while (i2 < a.d()) {
            bVar = a.c(i2);
            str = "iTunSMPB";
            i = 1;
            i2++;
        }
        return i3;
    }

    public boolean d(int i) {
        final int i2 = i >> 12;
        i &= 4095;
        if (i2 <= 0 && obj2 > 0) {
            if (obj2 > 0) {
            }
            return 0;
        }
        this.a = i2;
        this.b = obj2;
        return 1;
    }
}

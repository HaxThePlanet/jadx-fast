package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.room.e1.a;
import d.s.a.h.c;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class e0 {

    public final h.c a;
    public final Context b;
    public final String c;
    public final androidx.room.u0.d d;
    public final List<androidx.room.u0.b> e;
    public final androidx.room.u0.e f;
    public final List<Object> g;
    public final List<a> h;
    public final boolean i;
    public final androidx.room.u0.c j;
    public final Executor k;
    public final Executor l;
    public final boolean m;
    public final Intent n;
    public final boolean o;
    public final boolean p;
    private final Set<Integer> q;
    public final Callable<InputStream> r;
    public e0(Context context, String string2, h.c h$c3, androidx.room.u0.d u0$d4, List<androidx.room.u0.b> list5, boolean z6, androidx.room.u0.c u0$c7, Executor executor8, Executor executor9, Intent intent10, boolean z11, boolean z12, Set<Integer> set13, String string14, File file15, Callable<InputStream> callable16, androidx.room.u0.e u0$e17, List<Object> list18, List<a> list19) {
        int i;
        List emptyList;
        List emptyList2;
        final Object obj = this;
        Intent intent = intent10;
        super();
        obj.a = c3;
        obj.b = context;
        obj.c = string2;
        obj.d = d4;
        obj.e = list5;
        obj.i = z6;
        obj.j = c7;
        obj.k = executor8;
        obj.l = executor9;
        obj.n = intent;
        i = intent != null ? 1 : 0;
        obj.m = i;
        obj.o = z11;
        obj.p = z12;
        obj.q = set13;
        obj.r = callable16;
        if (list18 == null) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = list18;
        }
        obj.g = emptyList;
        if (list19 == null) {
            emptyList2 = Collections.emptyList();
        } else {
            emptyList2 = list19;
        }
        obj.h = emptyList2;
    }

    public boolean a(int i, int i2) {
        int i3;
        int obj3;
        int obj4;
        final int i4 = 0;
        obj4 = i > i2 ? i3 : i4;
        if (obj4 != null && this.p) {
            if (this.p) {
                return i4;
            }
        }
        if (this.o) {
            obj4 = this.q;
            if (obj4 != null) {
                if (!obj4.contains(Integer.valueOf(i))) {
                } else {
                    i3 = i4;
                }
            }
        } else {
        }
        return i3;
    }
}

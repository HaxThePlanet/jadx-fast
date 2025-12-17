package com.google.android.exoplayer2.m2;

import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.m2.h.b;
import com.google.android.exoplayer2.m2.i.b;
import com.google.android.exoplayer2.m2.j.a;
import com.google.android.exoplayer2.m2.k.h;
import com.google.android.exoplayer2.m2.l.c;

/* loaded from: classes2.dex */
public interface c {

    public static final com.google.android.exoplayer2.m2.c a;

    class a implements com.google.android.exoplayer2.m2.c {
        @Override // com.google.android.exoplayer2.m2.c
        public com.google.android.exoplayer2.m2.b a(i1 i1) {
            int i;
            boolean equals;
            String obj4;
            obj4 = i1.D;
            if (obj4 != null) {
                obj4.hashCode();
                i = -1;
                switch (obj4) {
                    case "application/vnd.dvb.ait":
                        i = 0;
                        break;
                    case "application/x-icy":
                        i = 1;
                        break;
                    case "application/id3":
                        i = 2;
                        break;
                    case "application/x-emsg":
                        i = 3;
                        break;
                    case "application/x-scte35":
                        i = 4;
                        break;
                    default:
                }
                switch (i) {
                    case 0:
                        obj4 = new b();
                        return obj4;
                    case 1:
                        obj4 = new a();
                        return obj4;
                    case 2:
                        obj4 = new h();
                        return obj4;
                    case 3:
                        obj4 = new b();
                        return obj4;
                    case 4:
                        obj4 = new c();
                        return obj4;
                    default:
                }
            }
            String str = "Attempted to create decoder for unsupported MIME type: ";
            obj4 = String.valueOf(obj4);
            if (obj4.length() != 0) {
                obj4 = str.concat(obj4);
            } else {
                obj4 = new String(str);
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(obj4);
            throw illegalArgumentException;
        }

        @Override // com.google.android.exoplayer2.m2.c
        public boolean b(i1 i1) {
            boolean equals;
            String obj2;
            obj2 = i1.D;
            if (!"application/id3".equals(obj2) && !"application/x-emsg".equals(obj2) && !"application/x-scte35".equals(obj2) && !"application/x-icy".equals(obj2)) {
                if (!"application/x-emsg".equals(obj2)) {
                    if (!"application/x-scte35".equals(obj2)) {
                        if (!"application/x-icy".equals(obj2)) {
                            if ("application/vnd.dvb.ait".equals(obj2)) {
                                obj2 = 1;
                            } else {
                                obj2 = 0;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return obj2;
        }
    }
    static {
        c.a aVar = new c.a();
        c.a = aVar;
    }

    public abstract com.google.android.exoplayer2.m2.b a(i1 i1);

    public abstract boolean b(i1 i1);
}

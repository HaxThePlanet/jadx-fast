package com.google.android.exoplayer2.text;

import android.accounts.Account;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.text.m.c;
import com.google.android.exoplayer2.text.m.d;
import com.google.android.exoplayer2.text.n.a;
import com.google.android.exoplayer2.text.o.a;
import com.google.android.exoplayer2.text.q.a;
import com.google.android.exoplayer2.text.r.a;
import com.google.android.exoplayer2.text.s.c;
import com.google.android.exoplayer2.text.t.a;
import com.google.android.exoplayer2.text.u.c;
import com.google.android.exoplayer2.text.u.i;
import com.google.firebase.dynamiclinks.internal.DynamicLinkDataCreator;
import io.grpc.a.c;

/* loaded from: classes2.dex */
public interface h {

    public static final com.google.android.exoplayer2.text.h a;

    class a implements com.google.android.exoplayer2.text.h {
        @Override // com.google.android.exoplayer2.text.h
        public com.google.android.exoplayer2.text.g a(i1 i1) {
            String string;
            int i;
            boolean equals;
            String str = i1.D;
            if (str != null) {
                str.hashCode();
                i = -1;
                switch (str) {
                    case "application/dvbsubs":
                        i = 0;
                        break;
                    case "application/pgs":
                        i = 1;
                        break;
                    case "application/x-mp4-vtt":
                        i = 2;
                        break;
                    case "text/vtt":
                        i = 3;
                        break;
                    case "application/x-quicktime-tx3g":
                        i = 4;
                        break;
                    case "text/x-ssa":
                        i = 5;
                        break;
                    case "application/x-mp4-cea-608":
                        i = 6;
                        break;
                    case "application/cea-608":
                        i = 7;
                        break;
                    case "application/cea-708":
                        i = 8;
                        break;
                    case "application/x-subrip":
                        i = 9;
                        break;
                    case "application/ttml+xml":
                        i = 10;
                        break;
                    default:
                }
                switch (i) {
                    case 0:
                        a aVar = new a(i1.F);
                        return aVar;
                    case 1:
                        a obj5 = new a();
                        return obj5;
                    case 2:
                        obj5 = new c();
                        return obj5;
                    case 3:
                        obj5 = new i();
                        return obj5;
                    case 4:
                        a aVar2 = new a(i1.F);
                        return aVar2;
                    case 5:
                        a aVar3 = new a(i1.F);
                        return aVar3;
                    case 6:
                        c cVar = new c(str, i1.V, 16000, obj3);
                        return cVar;
                    case 7:
                        d dVar = new d(i1.V, i1.F);
                        return dVar;
                    case 8:
                        obj5 = new a();
                        return obj5;
                    case 9:
                        obj5 = new c();
                        return obj5;
                    default:
                }
            }
            String str2 = "Attempted to create decoder for unsupported MIME type: ";
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                string = str2.concat(valueOf);
            } else {
                string = new String(str2);
            }
            obj5 = new IllegalArgumentException(string);
            throw obj5;
        }

        @Override // com.google.android.exoplayer2.text.h
        public boolean b(i1 i1) {
            String equals;
            int obj2;
            obj2 = i1.D;
            if (!"text/vtt".equals(obj2) && !"text/x-ssa".equals(obj2) && !"application/ttml+xml".equals(obj2) && !"application/x-mp4-vtt".equals(obj2) && !"application/x-subrip".equals(obj2) && !"application/x-quicktime-tx3g".equals(obj2) && !"application/cea-608".equals(obj2) && !"application/x-mp4-cea-608".equals(obj2) && !"application/cea-708".equals(obj2) && !"application/dvbsubs".equals(obj2)) {
                if (!"text/x-ssa".equals(obj2)) {
                    if (!"application/ttml+xml".equals(obj2)) {
                        if (!"application/x-mp4-vtt".equals(obj2)) {
                            if (!"application/x-subrip".equals(obj2)) {
                                if (!"application/x-quicktime-tx3g".equals(obj2)) {
                                    if (!"application/cea-608".equals(obj2)) {
                                        if (!"application/x-mp4-cea-608".equals(obj2)) {
                                            if (!"application/cea-708".equals(obj2)) {
                                                if (!"application/dvbsubs".equals(obj2)) {
                                                    if ("application/pgs".equals(obj2)) {
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
            return obj2;
        }
    }
    static {
        h.a aVar = new h.a();
        h.a = aVar;
    }

    public abstract com.google.android.exoplayer2.text.g a(i1 i1);

    public abstract boolean b(i1 i1);
}

package com.facebook.internal.g0;

import com.facebook.internal.g0.g.b;
import com.facebook.internal.g0.h.a;
import com.facebook.internal.g0.h.a.a;
import com.facebook.internal.g0.i.a;
import com.facebook.internal.g0.j.b;
import com.facebook.internal.g0.k.a;
import com.facebook.internal.l;
import com.facebook.internal.l.a;
import com.facebook.internal.l.b;
import com.facebook.o;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005", d2 = {"Lcom/facebook/internal/instrument/InstrumentManager;", "", "()V", "start", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class e {

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "enabled", "", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class a implements l.a {

        public static final com.facebook.internal.g0.e.a a;
        static {
            e.a aVar = new e.a();
            e.a.a = aVar;
        }

        @Override // com.facebook.internal.l$a
        public final void a(boolean z) {
            boolean obj1;
            a.d.a();
            if (z && l.g(l.b.CrashShield)) {
                a.d.a();
                if (l.g(l.b.CrashShield)) {
                    a.a();
                    a.a();
                }
                if (l.g(l.b.ThreadCheck)) {
                    a.a();
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "enabled", "", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class b implements l.a {

        public static final com.facebook.internal.g0.e.b a;
        static {
            e.b bVar = new e.b();
            e.b.a = bVar;
        }

        @Override // com.facebook.internal.l$a
        public final void a(boolean z) {
            if (z) {
                b.a();
            }
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "enabled", "", "onCompleted"}, k = 3, mv = {1, 5, 1})
    static final class c implements l.a {

        public static final com.facebook.internal.g0.e.c a;
        static {
            e.c cVar = new e.c();
            e.c.a = cVar;
        }

        @Override // com.facebook.internal.l$a
        public final void a(boolean z) {
            if (z) {
                b.a();
            }
        }
    }
    static {
    }

    public static final void a() {
        if (!o.j()) {
        }
        l.a(l.b.CrashReport, e.a.a);
        l.a(l.b.ErrorReport, e.b.a);
        l.a(l.b.AnrReport, e.c.a);
    }
}

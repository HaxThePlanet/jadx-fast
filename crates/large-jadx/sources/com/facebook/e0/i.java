package com.facebook.e0;

import com.facebook.internal.g0.i.a;
import com.facebook.internal.l;
import com.facebook.internal.l.b;
import com.facebook.internal.p;
import com.facebook.internal.q;
import com.facebook.internal.q.b;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005", d2 = {"Lcom/facebook/appevents/AppEventsManager;", "", "()V", "start", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class i {

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007", d2 = {"com/facebook/appevents/AppEventsManager$start$1", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "onError", "", "onSuccess", "fetchedAppSettings", "Lcom/facebook/internal/FetchedAppSettings;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements q.b {
        @Override // com.facebook.internal.q$b
        public void a() {
        }

        @Override // com.facebook.internal.q$b
        public void b(p p) {
            l.a(l.b.AAM, i.a.a.a);
            l.a(l.b.RestrictiveDataFiltering, i.a.b.a);
            l.a(l.b.PrivacyProtection, i.a.c.a);
            l.a(l.b.EventDeactivation, i.a.d.a);
            l.a(l.b.IapLogging, i.a.e.a);
        }
    }
    static {
    }

    public static final void a() {
        if (a.d(i.class)) {
        }
        i.a aVar = new i.a();
        q.h(aVar);
    }
}

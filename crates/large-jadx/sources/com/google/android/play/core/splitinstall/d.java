package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class d {
    public static com.google.android.play.core.splitinstall.d b(int i, int i2, int i3, long l4, long l5, List<String> list6, List<String> list7) {
        if (i2 == 8) {
        } else {
            super(i, i2, i3, l4, obj6, list6, obj8, obj20, obj21, 0, 0);
            return hVar;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("REQUIRES_USER_CONFIRMATION state not supported.");
        throw illegalArgumentException;
    }

    public static com.google.android.play.core.splitinstall.d n(Bundle bundle) {
        super(bundle.getInt("session_id"), bundle.getInt("status"), bundle.getInt("error_code"), bundle.getLong("bytes_downloaded"), obj5, bundle.getLong("total_bytes_to_download"), obj7, bundle.getStringArrayList("module_names"), bundle.getStringArrayList("languages"), (PendingIntent)bundle.getParcelable("user_confirmation_intent"), bundle.getParcelableArrayList("split_file_intents"));
        return hVar2;
    }

    public abstract long a();

    public abstract int c();

    public boolean d() {
        int i;
        int i2 = i();
        if (i2 != 0 && i2 != 5 && i2 != 6 && i2 == 7) {
            if (i2 != 5) {
                if (i2 != 6) {
                    if (i2 == 7) {
                    }
                    return 0;
                }
            }
        }
        return 1;
    }

    public List<String> e() {
        ArrayList arrayList;
        List list;
        if (k() != null) {
            arrayList = new ArrayList(k());
        } else {
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    public List<String> f() {
        ArrayList arrayList;
        List list;
        if (l() != null) {
            arrayList = new ArrayList(l());
        } else {
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    @Deprecated
    public abstract PendingIntent g();

    public abstract int h();

    public abstract int i();

    public abstract long j();

    abstract List<String> k();

    abstract List<String> l();

    abstract List<Intent> m();
}

package d.c.b;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import c.a.a.a;
import c.a.a.b;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    private final b a;
    private final a b;
    private final ComponentName c;
    e(b b, a a2, ComponentName componentName3) {
        super();
        this.a = b;
        this.b = a2;
        this.c = componentName3;
    }

    IBinder a() {
        return this.b.asBinder();
    }

    ComponentName b() {
        return this.c;
    }

    public boolean c(Uri uri, Bundle bundle2, List<Bundle> list3) {
        try {
            return this.a.E(this.b, uri, bundle2, list3);
            uri = null;
            return uri;
        }
    }
}

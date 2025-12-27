package d.c.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.e;
import androidx.core.content.a;
import java.util.ArrayList;

/* compiled from: CustomTabsIntent.java */
/* loaded from: classes.dex */
public final class c {

    public final Intent a;
    public final Bundle b;

    public static final class a {

        private final Intent a;
        private ArrayList<Bundle> b;
        private Bundle c;
        private ArrayList<Bundle> d;
        private boolean e;
        public a() {
            this(null);
        }

        public c a() {
            Intent intent;
            String str;
            if (this.b != null) {
                str = "android.support.customtabs.extra.MENU_ITEMS";
                this.a.putParcelableArrayListExtra(str, this.b);
            }
            if (this.d != null) {
                str = "android.support.customtabs.extra.TOOLBAR_ITEMS";
                this.a.putParcelableArrayListExtra(str, this.d);
            }
            this.a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.e);
            return new c(this.a, this.c);
        }

        public a(e eVar) {
            Object obj = null;
            super();
            final Intent intent = new Intent("android.intent.action.VIEW");
            this.a = intent;
            ArrayList list = null;
            this.b = list;
            this.c = list;
            this.d = list;
            boolean z = true;
            this.e = z;
            if (eVar != null) {
                intent.setPackage(eVar.b().getPackageName());
            }
            Bundle bundle = new Bundle();
            if (eVar != null) {
                android.os.IBinder iBinder = eVar.a();
            }
            e.b(bundle, "android.support.customtabs.extra.SESSION", obj);
            intent.putExtras(bundle);
        }
    }
    c(Intent intent, Bundle bundle) {
        super();
        this.a = intent;
        this.b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.a.setData(uri);
        a.n(context, this.a, this.b);
    }
}

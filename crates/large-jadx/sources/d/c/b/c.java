package d.c.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.e;
import androidx.core.content.a;
import java.util.ArrayList;

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
            super(0);
        }

        public a(d.c.b.e e) {
            int i;
            int packageName;
            super();
            Intent intent = new Intent("android.intent.action.VIEW");
            this.a = intent;
            i = 0;
            this.b = i;
            this.c = i;
            this.d = i;
            this.e = true;
            if (e != null) {
                intent.setPackage(e.b().getPackageName());
            }
            Bundle bundle = new Bundle();
            if (e == null) {
            } else {
                i = e.a();
            }
            e.b(bundle, "android.support.customtabs.extra.SESSION", i);
            intent.putExtras(bundle);
        }

        public d.c.b.c a() {
            Intent intent;
            String str;
            ArrayList list = this.b;
            if (list != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", list);
            }
            ArrayList list2 = this.d;
            if (list2 != null) {
                this.a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", list2);
            }
            this.a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.e);
            c cVar = new c(this.a, this.c);
            return cVar;
        }
    }
    c(Intent intent, Bundle bundle2) {
        super();
        this.a = intent;
        this.b = bundle2;
    }

    public void a(Context context, Uri uri2) {
        this.a.setData(uri2);
        a.n(context, this.a, this.b);
    }
}

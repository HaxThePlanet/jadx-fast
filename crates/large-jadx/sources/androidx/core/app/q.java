package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.a;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class q implements Iterable<Intent> {

    private final ArrayList<Intent> a;
    private final Context b;

    public interface a {
        public abstract Intent getSupportParentActivityIntent();
    }
    private q(Context context) {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = context;
    }

    public static androidx.core.app.q i(Context context) {
        q qVar = new q(context);
        return qVar;
    }

    @Override // java.lang.Iterable
    public androidx.core.app.q b(Intent intent) {
        this.a.add(intent);
        return this;
    }

    @Override // java.lang.Iterable
    public androidx.core.app.q d(Intent intent) {
        ComponentName resolveActivity;
        if (intent.getComponent() == null) {
            resolveActivity = intent.resolveActivity(this.b.getPackageManager());
        }
        if (resolveActivity != null) {
            h(resolveActivity);
        }
        b(intent);
        return this;
    }

    @Override // java.lang.Iterable
    public androidx.core.app.q g(Activity activity) {
        int supportParentActivityIntent;
        ComponentName obj2;
        if (activity instanceof q.a) {
            supportParentActivityIntent = (q.a)activity.getSupportParentActivityIntent();
        } else {
            supportParentActivityIntent = 0;
        }
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = h.a(activity);
        }
        if (supportParentActivityIntent != null && supportParentActivityIntent.getComponent() == null) {
            if (supportParentActivityIntent.getComponent() == null) {
                obj2 = supportParentActivityIntent.resolveActivity(this.b.getPackageManager());
            }
            h(obj2);
            b(supportParentActivityIntent);
        }
        return this;
    }

    @Override // java.lang.Iterable
    public androidx.core.app.q h(ComponentName componentName) {
        Context context;
        Intent obj3;
        obj3 = h.b(this.b, componentName);
        while (obj3 != null) {
            this.a.add(this.a.size(), obj3);
            obj3 = h.b(this.b, obj3.getComponent());
        }
        return this;
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.a.iterator();
    }

    @Override // java.lang.Iterable
    public void l() {
        m(0);
    }

    @Override // java.lang.Iterable
    public void m(Bundle bundle) {
        Object[] array;
        Context context;
        boolean obj5;
        if (this.a.isEmpty()) {
        } else {
            ArrayList list2 = this.a;
            array = list2.toArray(new Intent[list2.size()]);
            final int i2 = 0;
            Intent intent = new Intent((Intent[])array[i2]);
            array[i2] = intent.addFlags(268484608);
            if (!a.m(this.b, array, bundle)) {
                obj5 = new Intent(array[length--]);
                obj5.addFlags(268435456);
                this.b.startActivity(obj5);
            }
        }
        obj5 = new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        throw obj5;
    }
}

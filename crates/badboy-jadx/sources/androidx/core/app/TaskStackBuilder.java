package androidx.core.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes5.dex */
public final class TaskStackBuilder implements Iterable<Intent> {

    private static final String TAG = "TaskStackBuilder";
    private final ArrayList<Intent> mIntents;
    private final Context mSourceContext;

    public interface SupportParentable {
        public abstract Intent getSupportParentActivityIntent();
    }
    private TaskStackBuilder(Context a) {
        super();
        ArrayList arrayList = new ArrayList();
        this.mIntents = arrayList;
        this.mSourceContext = a;
    }

    public static androidx.core.app.TaskStackBuilder create(Context context) {
        TaskStackBuilder taskStackBuilder = new TaskStackBuilder(context);
        return taskStackBuilder;
    }

    @Deprecated
    public static androidx.core.app.TaskStackBuilder from(Context context) {
        return TaskStackBuilder.create(context);
    }

    @Override // java.lang.Iterable
    public androidx.core.app.TaskStackBuilder addNextIntent(Intent nextIntent) {
        this.mIntents.add(nextIntent);
        return this;
    }

    @Override // java.lang.Iterable
    public androidx.core.app.TaskStackBuilder addNextIntentWithParentStack(Intent nextIntent) {
        ComponentName target;
        android.content.pm.PackageManager packageManager;
        if (nextIntent.getComponent() == null) {
            target = nextIntent.resolveActivity(this.mSourceContext.getPackageManager());
        }
        if (target != null) {
            addParentStack(target);
        }
        addNextIntent(nextIntent);
        return this;
    }

    @Override // java.lang.Iterable
    public androidx.core.app.TaskStackBuilder addParentStack(Activity sourceActivity) {
        int parent;
        boolean target;
        android.content.pm.PackageManager packageManager;
        parent = 0;
        if (sourceActivity instanceof TaskStackBuilder.SupportParentable) {
            parent = (TaskStackBuilder.SupportParentable)sourceActivity.getSupportParentActivityIntent();
        }
        if (parent == 0) {
            parent = NavUtils.getParentActivityIntent(sourceActivity);
        }
        if (parent != 0 && parent.getComponent() == null) {
            if (parent.getComponent() == null) {
                target = parent.resolveActivity(this.mSourceContext.getPackageManager());
            }
            addParentStack(target);
            addNextIntent(parent);
        }
        return this;
    }

    @Override // java.lang.Iterable
    public androidx.core.app.TaskStackBuilder addParentStack(ComponentName sourceActivityName) {
        Intent parent;
        Object illegalArgumentException;
        Object component;
        parent = NavUtils.getParentActivityIntent(this.mSourceContext, sourceActivityName);
        while (parent != null) {
            this.mIntents.add(this.mIntents.size(), parent);
            parent = illegalArgumentException;
        }
        return this;
    }

    public androidx.core.app.TaskStackBuilder addParentStack(Class<?> class) {
        ComponentName componentName = new ComponentName(this.mSourceContext, class);
        return addParentStack(componentName);
    }

    @Override // java.lang.Iterable
    public Intent editIntentAt(int index) {
        return (Intent)this.mIntents.get(index);
    }

    @Deprecated
    public Intent getIntent(int index) {
        return editIntentAt(index);
    }

    @Override // java.lang.Iterable
    public int getIntentCount() {
        return this.mIntents.size();
    }

    @Override // java.lang.Iterable
    public Intent[] getIntents() {
        int i2;
        int intent;
        int i;
        Intent[] arr = new Intent[this.mIntents.size()];
        if (arr.length == 0) {
            return arr;
        }
        i = 0;
        Intent intent2 = new Intent((Intent)this.mIntents.get(i));
        arr[i] = intent2.addFlags(268484608);
        i2 = 1;
        while (i2 < arr.length) {
            intent = new Intent((Intent)this.mIntents.get(i2));
            arr[i2] = intent;
            i2++;
        }
        return arr;
    }

    @Override // java.lang.Iterable
    public PendingIntent getPendingIntent(int requestCode, int flags) {
        return getPendingIntent(requestCode, flags, 0);
    }

    @Override // java.lang.Iterable
    public PendingIntent getPendingIntent(int requestCode, int flags, Bundle options) {
        if (this.mIntents.isEmpty()) {
        } else {
            int i = 0;
            Object[] array = this.mIntents.toArray(new Intent[i]);
            Intent intent = new Intent((Intent[])array[i]);
            array[i] = intent.addFlags(268484608);
            return PendingIntent.getActivities(this.mSourceContext, requestCode, array, flags, options);
        }
        IllegalStateException intents = new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        throw intents;
    }

    @Override // java.lang.Iterable
    public PendingIntent getPendingIntent(int requestCode, int flags, Bundle options, boolean isMutable) {
        return getPendingIntent(requestCode, PendingIntentCompat.addMutabilityFlags(isMutable, flags), options);
    }

    @Override // java.lang.Iterable
    public PendingIntent getPendingIntent(int requestCode, int flags, boolean isMutable) {
        return getPendingIntent(requestCode, PendingIntentCompat.addMutabilityFlags(isMutable, flags));
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.mIntents.iterator();
    }

    @Override // java.lang.Iterable
    public void startActivities() {
        startActivities(0);
    }

    @Override // java.lang.Iterable
    public void startActivities(Bundle options) {
        boolean activities;
        Object mSourceContext;
        if (this.mIntents.isEmpty()) {
        } else {
            int i = 0;
            Object[] array = this.mIntents.toArray(new Intent[i]);
            Intent intent = new Intent((Intent[])array[i]);
            array[i] = intent.addFlags(268484608);
            if (!ContextCompat.startActivities(this.mSourceContext, array, options)) {
                activities = new Intent(array[length--]);
                activities.addFlags(268435456);
                this.mSourceContext.startActivity(activities);
            }
        }
        IllegalStateException intents = new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        throw intents;
    }
}

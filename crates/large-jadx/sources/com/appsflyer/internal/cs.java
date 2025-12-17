package com.appsflyer.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import com.appsflyer.AFLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public final class cs {

    public final FutureTask<List<String>> AFInAppEventParameterName;
    public cs(Context context) {
        super();
        cs.3 anon = new cs.3(context);
        FutureTask futureTask = new FutureTask(anon);
        this.AFInAppEventParameterName = futureTask;
    }

    public final List<String> AFInAppEventParameterName() {
        if (valueOf()) {
            try {
                return (List)this.AFInAppEventParameterName.get();
                return 0;
            }
        }
    }

    public final boolean valueOf() {
        return this.AFInAppEventParameterName.isDone();
    }
}

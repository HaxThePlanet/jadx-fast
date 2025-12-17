package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

/* loaded from: classes.dex */
public class CoreComponentFactory extends AppComponentFactory {

    public interface a {
        public abstract Object a();
    }
    static <T> T a(T t) {
        boolean z;
        z = (CoreComponentFactory.a)t.a();
        if (t instanceof CoreComponentFactory.a && z != null) {
            z = (CoreComponentFactory.a)t.a();
            if (z != null) {
                return z;
            }
        }
        return t;
    }

    @Override // android.app.AppComponentFactory
    public Activity instantiateActivity(java.lang.ClassLoader classLoader, String string2, Intent intent3) {
        return (Activity)CoreComponentFactory.a(super.instantiateActivity(classLoader, string2, intent3));
    }

    @Override // android.app.AppComponentFactory
    public Application instantiateApplication(java.lang.ClassLoader classLoader, String string2) {
        return (Application)CoreComponentFactory.a(super.instantiateApplication(classLoader, string2));
    }

    @Override // android.app.AppComponentFactory
    public ContentProvider instantiateProvider(java.lang.ClassLoader classLoader, String string2) {
        return (ContentProvider)CoreComponentFactory.a(super.instantiateProvider(classLoader, string2));
    }

    @Override // android.app.AppComponentFactory
    public BroadcastReceiver instantiateReceiver(java.lang.ClassLoader classLoader, String string2, Intent intent3) {
        return (BroadcastReceiver)CoreComponentFactory.a(super.instantiateReceiver(classLoader, string2, intent3));
    }

    @Override // android.app.AppComponentFactory
    public Service instantiateService(java.lang.ClassLoader classLoader, String string2, Intent intent3) {
        return (Service)CoreComponentFactory.a(super.instantiateService(classLoader, string2, intent3));
    }
}

package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

/* loaded from: classes5.dex */
public class CoreComponentFactory extends AppComponentFactory {

    public interface CompatWrapped {
        public abstract Object getWrapper();
    }
    static <T> T checkCompatWrapper(T t) {
        boolean wrapper;
        wrapper = (CoreComponentFactory.CompatWrapped)t.getWrapper();
        if (t instanceof CoreComponentFactory.CompatWrapped && wrapper != null) {
            wrapper = (CoreComponentFactory.CompatWrapped)t.getWrapper();
            if (wrapper != null) {
                return wrapper;
            }
        }
        return t;
    }

    public Activity instantiateActivity(java.lang.ClassLoader cl, String className, Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (Activity)CoreComponentFactory.checkCompatWrapper(super.instantiateActivity(cl, className, intent));
    }

    public Application instantiateApplication(java.lang.ClassLoader cl, String className) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (Application)CoreComponentFactory.checkCompatWrapper(super.instantiateApplication(cl, className));
    }

    public ContentProvider instantiateProvider(java.lang.ClassLoader cl, String className) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (ContentProvider)CoreComponentFactory.checkCompatWrapper(super.instantiateProvider(cl, className));
    }

    public BroadcastReceiver instantiateReceiver(java.lang.ClassLoader cl, String className, Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (BroadcastReceiver)CoreComponentFactory.checkCompatWrapper(super.instantiateReceiver(cl, className, intent));
    }

    public Service instantiateService(java.lang.ClassLoader cl, String className, Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (Service)CoreComponentFactory.checkCompatWrapper(super.instantiateService(cl, className, intent));
    }
}

package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import java.lang.reflect.Constructor;

/* loaded from: classes5.dex */
public class AppComponentFactory extends AppComponentFactory {
    public final Activity instantiateActivity(java.lang.ClassLoader cl, String className, Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (Activity)CoreComponentFactory.checkCompatWrapper(instantiateActivityCompat(cl, className, intent));
    }

    public Activity instantiateActivityCompat(java.lang.ClassLoader cl, String className, Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        int i = 0;
        return (Activity)Class.forName(className, i, cl).asSubclass(Activity.class).getDeclaredConstructor(new Class[i]).newInstance(new Object[i]);
    }

    public final Application instantiateApplication(java.lang.ClassLoader cl, String className) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (Application)CoreComponentFactory.checkCompatWrapper(instantiateApplicationCompat(cl, className));
    }

    public Application instantiateApplicationCompat(java.lang.ClassLoader cl, String className) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        int i = 0;
        return (Application)Class.forName(className, i, cl).asSubclass(Application.class).getDeclaredConstructor(new Class[i]).newInstance(new Object[i]);
    }

    public final ContentProvider instantiateProvider(java.lang.ClassLoader cl, String className) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (ContentProvider)CoreComponentFactory.checkCompatWrapper(instantiateProviderCompat(cl, className));
    }

    public ContentProvider instantiateProviderCompat(java.lang.ClassLoader cl, String className) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        int i = 0;
        return (ContentProvider)Class.forName(className, i, cl).asSubclass(ContentProvider.class).getDeclaredConstructor(new Class[i]).newInstance(new Object[i]);
    }

    public final BroadcastReceiver instantiateReceiver(java.lang.ClassLoader cl, String className, Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (BroadcastReceiver)CoreComponentFactory.checkCompatWrapper(instantiateReceiverCompat(cl, className, intent));
    }

    public BroadcastReceiver instantiateReceiverCompat(java.lang.ClassLoader cl, String className, Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        int i = 0;
        return (BroadcastReceiver)Class.forName(className, i, cl).asSubclass(BroadcastReceiver.class).getDeclaredConstructor(new Class[i]).newInstance(new Object[i]);
    }

    public final Service instantiateService(java.lang.ClassLoader cl, String className, Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        return (Service)CoreComponentFactory.checkCompatWrapper(instantiateServiceCompat(cl, className, intent));
    }

    public Service instantiateServiceCompat(java.lang.ClassLoader cl, String className, Intent intent) throws java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException {
        int i = 0;
        return (Service)Class.forName(className, i, cl).asSubclass(Service.class).getDeclaredConstructor(new Class[i]).newInstance(new Object[i]);
    }
}

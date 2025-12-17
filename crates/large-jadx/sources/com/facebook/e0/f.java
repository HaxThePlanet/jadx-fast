package com.facebook.e0;

import android.content.Context;
import android.util.Log;
import com.facebook.e0.v.b;
import com.facebook.internal.b0;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008Á\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\rH\u0007J\u0008\u0010\u000e\u001a\u00020\u000fH\u0007J\u0017\u0010\u0010\u001a\u00020\u00072\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0002\u0008\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lcom/facebook/appevents/AppEventStore;", "", "()V", "PERSISTED_EVENTS_FILENAME", "", "TAG", "persistEvents", "", "accessTokenAppIdPair", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "appEvents", "Lcom/facebook/appevents/SessionEventsState;", "eventsToPersist", "Lcom/facebook/appevents/AppEventCollection;", "readAndClearStore", "Lcom/facebook/appevents/PersistedEvents;", "saveEventsToDisk", "saveEventsToDisk$facebook_core_release", "MovedClassObjectInputStream", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class f {

    private static final String a;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\u0008", d2 = {"Lcom/facebook/appevents/AppEventStore$MovedClassObjectInputStream;", "Ljava/io/ObjectInputStream;", "inputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "readClassDescriptor", "Ljava/io/ObjectStreamClass;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class a extends ObjectInputStream {
        static {
        }

        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        protected ObjectStreamClass readClassDescriptor() {
            ObjectStreamClass classDescriptor;
            boolean z;
            String str;
            classDescriptor = super.readClassDescriptor();
            final String str2 = "resultClassDescriptor";
            n.e(classDescriptor, str2);
            if (n.b(classDescriptor.getName(), "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
                classDescriptor = ObjectStreamClass.lookup(a.a.class);
            } else {
                if (n.b(classDescriptor.getName(), "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2")) {
                    classDescriptor = ObjectStreamClass.lookup(c.b.class);
                }
            }
            n.e(classDescriptor, str2);
            return classDescriptor;
        }
    }
    static {
        String name = f.class.getName();
        n.e(name, "AppEventStore::class.java.name");
        f.a = name;
    }

    public static final void a(com.facebook.e0.a a, com.facebook.e0.o o2) {
        final Class<com.facebook.e0.f> obj = f.class;
        synchronized (obj) {
        }
    }

    public static final void b(com.facebook.e0.d d) {
        Object next;
        java.util.List list;
        final Class<com.facebook.e0.f> obj = f.class;
        synchronized (obj) {
        }
    }

    public static final com.facebook.e0.n c() {
        Throwable th;
        File fileStreamPath;
        Throwable th2;
        Object nVar;
        String str;
        String str3;
        String str2;
        BufferedInputStream bufferedInputStream;
        String str4;
        final Class<com.facebook.e0.f> obj = f.class;
        synchronized (obj) {
            return null;
        }
    }

    public static final void d(com.facebook.e0.n n) {
        java.io.Closeable closeable;
        int i;
        ObjectOutputStream objectOutputStream;
        BufferedOutputStream bufferedOutputStream;
        Object obj7;
        if (a.d(f.class)) {
        }
        i = 0;
        bufferedOutputStream = new BufferedOutputStream(o.f().openFileOutput("AppEventsLogger.persistedevents", 0));
        objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
        objectOutputStream.writeObject(n);
        b0.i(objectOutputStream);
    }
}

package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.util.Log;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {

    int a = 0;
    final HashMap<Integer, String> b;
    final RemoteCallbackList<androidx.room.i0> c;
    private final androidx.room.j0.a v;

    class a extends RemoteCallbackList<androidx.room.i0> {

        final androidx.room.MultiInstanceInvalidationService a;
        a(androidx.room.MultiInstanceInvalidationService multiInstanceInvalidationService) {
            this.a = multiInstanceInvalidationService;
            super();
        }

        @Override // android.os.RemoteCallbackList
        public void a(androidx.room.i0 i0, Object object2) {
            obj1.b.remove(Integer.valueOf((Integer)object2.intValue()));
        }

        @Override // android.os.RemoteCallbackList
        public void onCallbackDied(IInterface iInterface, Object object2) {
            a((i0)iInterface, object2);
        }
    }

    class b extends androidx.room.j0.a {

        final androidx.room.MultiInstanceInvalidationService a;
        b(androidx.room.MultiInstanceInvalidationService multiInstanceInvalidationService) {
            this.a = multiInstanceInvalidationService;
            super();
        }

        @Override // androidx.room.j0$a
        public void X1(int i, String[] string2Arr2) {
            int i2;
            Throwable broadcastItem;
            Object str;
            Object valueOf;
            RemoteCallbackList list = service.c;
            Object obj = service2.b.get(Integer.valueOf(i));
            synchronized (list) {
                Log.w("ROOM", "Remote invalidation client ID not registered");
            }
        }

        @Override // androidx.room.j0$a
        public int e0(androidx.room.i0 i0, String string2) {
            int i = 0;
            if (string2 == null) {
                return i;
            }
            RemoteCallbackList list = service.c;
            androidx.room.MultiInstanceInvalidationService service2 = this.a;
            i2++;
            service2.a = i3;
            synchronized (list) {
                obj6.b.put(Integer.valueOf(i3), string2);
                return i3;
            }
        }

        @Override // androidx.room.j0$a
        public void f2(androidx.room.i0 i0, int i2) {
            RemoteCallbackList list = service.c;
            service2.c.unregister(i0);
            obj3.b.remove(Integer.valueOf(i2));
            return;
            synchronized (list) {
                list = service.c;
                service2.c.unregister(i0);
                obj3.b.remove(Integer.valueOf(i2));
            }
        }
    }
    public MultiInstanceInvalidationService() {
        super();
        int i = 0;
        HashMap hashMap = new HashMap();
        this.b = hashMap;
        MultiInstanceInvalidationService.a aVar = new MultiInstanceInvalidationService.a(this);
        this.c = aVar;
        MultiInstanceInvalidationService.b bVar = new MultiInstanceInvalidationService.b(this);
        this.v = bVar;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.v;
    }
}

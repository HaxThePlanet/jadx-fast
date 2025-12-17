package androidx.room;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.room.f1.e;
import d.b.a.c.a;
import d.s.a.c;
import d.s.a.e;
import d.s.a.f;
import d.s.a.g;
import d.s.a.h;
import d.s.a.i;
import d.s.a.j;
import d.s.a.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class a0 implements h, androidx.room.f0 {

    private final h a;
    private final androidx.room.a0.a b;
    private final androidx.room.z c;

    private static final class c implements Cursor {

        private final Cursor a;
        private final androidx.room.z b;
        c(Cursor cursor, androidx.room.z z2) {
            super();
            this.a = cursor;
            this.b = z2;
        }

        @Override // android.database.Cursor
        public void close() {
            this.a.close();
            this.b.b();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer2) {
            this.a.copyStringToBuffer(i, charArrayBuffer2);
        }

        @Deprecated
        public void deactivate() {
            this.a.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i) {
            return this.a.getBlob(i);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.a.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String string) {
            return this.a.getColumnIndex(string);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String string) {
            return this.a.getColumnIndexOrThrow(string);
        }

        @Override // android.database.Cursor
        public String getColumnName(int i) {
            return this.a.getColumnName(i);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.a.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.a.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i) {
            return this.a.getDouble(i);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.a.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i) {
            return this.a.getFloat(i);
        }

        @Override // android.database.Cursor
        public int getInt(int i) {
            return this.a.getInt(i);
        }

        @Override // android.database.Cursor
        public long getLong(int i) {
            return this.a.getLong(i);
        }

        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            return c.a(this.a);
        }

        public List<Uri> getNotificationUris() {
            return f.a(this.a);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.a.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i) {
            return this.a.getShort(i);
        }

        @Override // android.database.Cursor
        public String getString(int i) {
            return this.a.getString(i);
        }

        @Override // android.database.Cursor
        public int getType(int i) {
            return this.a.getType(i);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.a.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.a.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.a.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.a.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.a.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.a.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i) {
            return this.a.isNull(i);
        }

        @Override // android.database.Cursor
        public boolean move(int i) {
            return this.a.move(i);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.a.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.a.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.a.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i) {
            return this.a.moveToPosition(i);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.a.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.a.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.a.registerDataSetObserver(dataSetObserver);
        }

        @Deprecated
        public boolean requery() {
            return this.a.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.a.respond(bundle);
        }

        @Override // android.database.Cursor
        public void setExtras(Bundle bundle) {
            e.a(this.a, bundle);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri2) {
            this.a.setNotificationUri(contentResolver, uri2);
        }

        public void setNotificationUris(ContentResolver contentResolver, List<Uri> list2) {
            f.b(this.a, contentResolver, list2);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.a.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.a.unregisterDataSetObserver(dataSetObserver);
        }
    }

    static final class a implements g {

        private final androidx.room.z a;
        a(androidx.room.z z) {
            super();
            this.a = z;
        }

        static Object a(String string, g g2) {
            g2.C(string);
            return null;
        }

        static Long c(String string, int i2, ContentValues contentValues3, g g4) {
            return Long.valueOf(g4.P0(string, i2, contentValues3));
        }

        static Boolean e(g g) {
            if (Build.VERSION.SDK_INT >= 16) {
                return Boolean.valueOf(g.F1());
            }
            return Boolean.FALSE;
        }

        static Object f(g g) {
            return null;
        }

        static Object i(int i, g g2) {
            g2.setVersion(i);
            return null;
        }

        static Integer j(String string, int i2, ContentValues contentValues3, String string4, Object[] object5Arr5, g g6) {
            return Integer.valueOf(g6.y0(string, i2, contentValues3, string4, object5Arr5));
        }

        @Override // d.s.a.g
        public void C(String string) {
            c cVar = new c(string);
            this.a.c(cVar);
        }

        @Override // d.s.a.g
        public boolean F1() {
            return (Boolean)this.a.c(e.a).booleanValue();
        }

        @Override // d.s.a.g
        public Cursor H0(String string) {
            try {
                a0.c cVar = new a0.c(this.a.e().H0(string), this.a);
                return cVar;
                this.a.b();
                throw string;
            }
        }

        @Override // d.s.a.g
        public k O(String string) {
            a0.b bVar = new a0.b(string, this.a);
            return bVar;
        }

        @Override // d.s.a.g
        public long P0(String string, int i2, ContentValues contentValues3) {
            d dVar = new d(string, i2, contentValues3);
            return (Long)this.a.c(dVar).longValue();
        }

        @Override // d.s.a.g
        public void beginTransaction() {
            this.a.e().beginTransaction();
        }

        @Override // d.s.a.g
        public void close() {
            this.a.a();
        }

        @Override // d.s.a.g
        public void endTransaction() {
            if (this.a.d() == null) {
            } else {
                this.a.d().endTransaction();
                this.a.b();
            }
            IllegalStateException illegalStateException = new IllegalStateException("End transaction called but delegateDb is null");
            throw illegalStateException;
        }

        @Override // d.s.a.g
        public Cursor f0(j j, CancellationSignal cancellationSignal2) {
            try {
                a0.c obj3 = new a0.c(this.a.e().f0(j, cancellationSignal2), this.a);
                return obj3;
                cancellationSignal2 = this.a;
                cancellationSignal2.b();
                throw j;
            }
        }

        @Override // d.s.a.g
        public String getPath() {
            return (String)this.a.c(a.a);
        }

        @Override // d.s.a.g
        public boolean isOpen() {
            g gVar = this.a.d();
            if (gVar == null) {
                return 0;
            }
            return gVar.isOpen();
        }

        @Override // d.s.a.g
        public Cursor j1(j j) {
            try {
                a0.c cVar = new a0.c(this.a.e().j1(j), this.a);
                return cVar;
                this.a.b();
                throw j;
            }
        }

        @Override // d.s.a.g
        void k() {
            this.a.c(f.a);
        }

        @Override // d.s.a.g
        public boolean q1() {
            if (this.a.d() == null) {
                return 0;
            }
            return (Boolean)this.a.c(i.a).booleanValue();
        }

        @Override // d.s.a.g
        public void setTransactionSuccessful() {
            g gVar = this.a.d();
            if (gVar == null) {
            } else {
                gVar.setTransactionSuccessful();
            }
            IllegalStateException illegalStateException = new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
            throw illegalStateException;
        }

        @Override // d.s.a.g
        public void setVersion(int i) {
            g gVar = new g(i);
            this.a.c(gVar);
        }

        @Override // d.s.a.g
        public void x0() {
            this.a.e().x0();
        }

        @Override // d.s.a.g
        public int y0(String string, int i2, ContentValues contentValues3, String string4, Object[] object5Arr5) {
            super(string, i2, contentValues3, string4, object5Arr5);
            return (Integer)this.a.c(bVar2).intValue();
        }

        public List<Pair<String, String>> z() {
            return (List)this.a.c(w.a);
        }
    }

    private static class b implements k {

        private final String a;
        private final ArrayList<Object> b;
        private final androidx.room.z c;
        b(String string, androidx.room.z z2) {
            super();
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            this.a = string;
            this.c = z2;
        }

        private void a(k k) {
            int i;
            int i2;
            ArrayList doubleValue;
            i = 0;
            while (i < this.b.size()) {
                i2 = i + 1;
                Object obj = this.b.get(i);
                if (obj == null) {
                } else {
                }
                if (obj instanceof Long) {
                } else {
                }
                if (obj instanceof Double) {
                } else {
                }
                if (obj instanceof String != null) {
                } else {
                }
                if (obj instanceof byte[]) {
                }
                i = i2;
                k.B0(i2, (byte[])obj);
                k.D(i2, (String)obj);
                k.W(i2, (Double)obj.doubleValue());
                k.u0(i2, (Long)obj.longValue());
                k.k1(i2);
            }
        }

        private <T> T c(a<k, T> a) {
            h hVar = new h(this, a);
            return this.c.c(hVar);
        }

        private Object e(a a, g g2) {
            final k obj3 = g2.O(this.a);
            a(obj3);
            return a.apply(obj3);
        }

        private void i(int i, Object object2) {
            int size;
            ArrayList list;
            int i2;
            i--;
            if (obj4 >= this.b.size()) {
                size = this.b.size();
                while (size <= obj4) {
                    this.b.add(0);
                    size++;
                }
            }
            this.b.set(obj4, object2);
        }

        @Override // d.s.a.k
        public void B0(int i, byte[] b2Arr2) {
            i(i, b2Arr2);
        }

        @Override // d.s.a.k
        public void D(int i, String string2) {
            i(i, string2);
        }

        @Override // d.s.a.k
        public int N() {
            return (Integer)c(y.a).intValue();
        }

        @Override // d.s.a.k
        public void W(int i, double d2) {
            i(i, Double.valueOf(d2));
        }

        @Override // d.s.a.k
        public long a2() {
            return (Long)c(v.a).longValue();
        }

        @Override // d.s.a.k
        public void close() {
        }

        @Override // d.s.a.k
        public Object f(a a, g g2) {
            return e(a, g2);
        }

        @Override // d.s.a.k
        public void k1(int i) {
            i(i, 0);
        }

        @Override // d.s.a.k
        public void u0(int i, long l2) {
            i(i, Long.valueOf(l2));
        }
    }
    a0(h h, androidx.room.z z2) {
        super();
        this.a = h;
        this.c = z2;
        z2.f(h);
        a0.a obj1 = new a0.a(z2);
        this.b = obj1;
    }

    @Override // d.s.a.h
    androidx.room.z a() {
        return this.c;
    }

    @Override // d.s.a.h
    public void close() {
        try {
            this.b.close();
            e.a(th);
            Throwable th = null;
            throw th;
        }
    }

    @Override // d.s.a.h
    public String getDatabaseName() {
        return this.a.getDatabaseName();
    }

    @Override // d.s.a.h
    public h getDelegate() {
        return this.a;
    }

    @Override // d.s.a.h
    public g getReadableDatabase() {
        this.b.k();
        return this.b;
    }

    @Override // d.s.a.h
    public g getWritableDatabase() {
        this.b.k();
        return this.b;
    }

    @Override // d.s.a.h
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.a.setWriteAheadLoggingEnabled(z);
    }
}

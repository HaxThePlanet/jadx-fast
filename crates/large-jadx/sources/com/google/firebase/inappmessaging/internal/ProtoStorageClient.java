package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.protobuf.a;
import com.google.protobuf.d1;
import i.b.b;
import i.b.l;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public class ProtoStorageClient {

    private final Application application;
    private final String fileName;
    public ProtoStorageClient(Application application, String string2) {
        super();
        this.application = application;
        this.fileName = string2;
    }

    private a a(d1 d1) {
        FileInputStream fileInput = this.application.openFileInput(this.fileName);
        synchronized (this) {
            try {
                fileInput.close();
                return (a)d1.b(fileInput);
                if (stringBuilder == null) {
                } else {
                }
                stringBuilder.close();
                d1.addSuppressed(stringBuilder);
                throw d1;
            } catch (Throwable th) {
            }
            throw d1;
        }
    }

    private Object c(a a) {
        FileOutputStream fileOutput = this.application.openFileOutput(this.fileName, 0);
        fileOutput.write(a.toByteArray());
        synchronized (this) {
            try {
                fileOutput.close();
                return a;
                if (th == null) {
                } else {
                }
                th.close();
                a.addSuppressed(th);
                throw a;
                throw a;
            } catch (Throwable th) {
            }
        }
    }

    public a b(d1 d1) {
        return a(d1);
    }

    public Object d(a a) {
        c(a);
        return a;
    }

    public <T extends a> l<T> read(d1<T> d1) {
        s1 s1Var = new s1(this, d1);
        return l.n(s1Var);
    }

    public b write(a a) {
        r1 r1Var = new r1(this, a);
        return b.o(r1Var);
    }
}

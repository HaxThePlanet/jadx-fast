package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* loaded from: classes.dex */
public class ResultReceiver implements Parcelable {

    public static final Parcelable.Creator<android.support.v4.os.ResultReceiver> CREATOR;
    final Handler mHandler;
    final boolean mLocal;
    android.support.v4.os.IResultReceiver mReceiver;

    class MyResultReceiver extends android.support.v4.os.IResultReceiver.Stub {

        final android.support.v4.os.ResultReceiver this$0;
        MyResultReceiver(android.support.v4.os.ResultReceiver this$0) {
            this.this$0 = this$0;
            super();
        }

        @Override // android.support.v4.os.IResultReceiver$Stub
        public void send(int resultCode, Bundle resultData) {
            Object mHandler;
            android.support.v4.os.ResultReceiver.MyRunnable myRunnable;
            android.support.v4.os.ResultReceiver this$0;
            if (this$02.mHandler != null) {
                myRunnable = new ResultReceiver.MyRunnable(this.this$0, resultCode, resultData);
                this$03.mHandler.post(myRunnable);
            } else {
                this.this$0.onReceiveResult(resultCode, resultData);
            }
        }
    }

    class MyRunnable implements Runnable {

        final int mResultCode;
        final Bundle mResultData;
        final android.support.v4.os.ResultReceiver this$0;
        MyRunnable(android.support.v4.os.ResultReceiver this$0, int resultCode, Bundle resultData) {
            this.this$0 = this$0;
            super();
            this.mResultCode = resultCode;
            this.mResultData = resultData;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.onReceiveResult(this.mResultCode, this.mResultData);
        }
    }
    static {
        ResultReceiver.1 anon = new ResultReceiver.1();
        ResultReceiver.CREATOR = anon;
    }

    public ResultReceiver(Handler handler) {
        super();
        this.mLocal = true;
        this.mHandler = handler;
    }

    ResultReceiver(Parcel in) {
        super();
        this.mLocal = false;
        this.mHandler = 0;
        this.mReceiver = IResultReceiver.Stub.asInterface(in.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    protected void onReceiveResult(int resultCode, Bundle resultData) {
    }

    @Override // android.os.Parcelable
    public void send(int resultCode, Bundle resultData) {
        android.support.v4.os.IResultReceiver mReceiver;
        Handler mHandler;
        android.support.v4.os.ResultReceiver.MyRunnable myRunnable;
        if (this.mLocal) {
            if (this.mHandler != null) {
                myRunnable = new ResultReceiver.MyRunnable(this, resultCode, resultData);
                this.mHandler.post(myRunnable);
            } else {
                onReceiveResult(resultCode, resultData);
            }
        }
        if (this.mReceiver != null) {
            this.mReceiver.send(resultCode, resultData);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        android.support.v4.os.IResultReceiver myResultReceiver;
        synchronized (this) {
            try {
                myResultReceiver = new ResultReceiver.MyResultReceiver(this);
                this.mReceiver = myResultReceiver;
                out.writeStrongBinder(this.mReceiver.asBinder());
                throw th;
            }
        }
    }
}

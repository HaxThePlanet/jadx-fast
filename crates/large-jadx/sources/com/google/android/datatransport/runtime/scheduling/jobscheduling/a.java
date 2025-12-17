package com.google.android.datatransport.runtime.scheduling.jobscheduling;

/* loaded from: classes.dex */
public final class a implements Runnable {

    public static final com.google.android.datatransport.runtime.scheduling.jobscheduling.a a;
    static {
        a aVar = new a();
        a.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AlarmManagerSchedulerBroadcastReceiver.a();
    }
}

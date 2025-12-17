package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes5.dex */
@Deprecated
public abstract class JobIntentService extends Service {

    static final boolean DEBUG = false;
    static final String TAG = "JobIntentService";
    static final HashMap<ComponentName, androidx.core.app.JobIntentService.WorkEnqueuer> sClassWorkEnqueuer;
    static final Object sLock;
    final ArrayList<androidx.core.app.JobIntentService.CompatWorkItem> mCompatQueue = null;
    androidx.core.app.JobIntentService.WorkEnqueuer mCompatWorkEnqueuer;
    androidx.core.app.JobIntentService.CommandProcessor mCurProcessor;
    boolean mDestroyed = false;
    boolean mInterruptIfStopped = false;
    androidx.core.app.JobIntentService.CompatJobEngine mJobImpl;
    boolean mStopped = false;

    final class CommandProcessor extends AsyncTask<Void, Void, Void> {

        final androidx.core.app.JobIntentService this$0;
        CommandProcessor(androidx.core.app.JobIntentService this$0) {
            this.this$0 = this$0;
            super();
        }

        protected Object doInBackground(Object[] objectArr) {
            return doInBackground((Void[])objectArr);
        }

        @Override // android.os.AsyncTask
        protected Void doInBackground(Void... params) {
            androidx.core.app.JobIntentService this$0;
            androidx.core.app.JobIntentService.GenericWorkItem service;
            Intent intent;
            androidx.core.app.JobIntentService.GenericWorkItem dequeueWork = this.this$0.dequeueWork();
            service = dequeueWork;
            while (dequeueWork != null) {
                this.this$0.onHandleWork(service.getIntent());
                service.complete();
                dequeueWork = this.this$0.dequeueWork();
                service = dequeueWork;
            }
            return null;
        }

        protected void onCancelled(Object object) {
            onCancelled((Void)object);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled(Void aVoid) {
            this.this$0.processorFinished();
        }

        protected void onPostExecute(Object object) {
            onPostExecute((Void)object);
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(Void aVoid) {
            this.this$0.processorFinished();
        }
    }

    interface CompatJobEngine {
        public abstract IBinder compatGetBinder();

        public abstract androidx.core.app.JobIntentService.GenericWorkItem dequeueWork();
    }

    static abstract class WorkEnqueuer {

        final ComponentName mComponentName;
        boolean mHasJobId;
        int mJobId;
        WorkEnqueuer(ComponentName cn) {
            super();
            this.mComponentName = cn;
        }

        abstract void enqueueWork(Intent intent);

        void ensureJobId(int jobId) {
            int mJobId;
            if (!this.mHasJobId) {
                this.mHasJobId = true;
                this.mJobId = jobId;
            } else {
                if (this.mJobId != jobId) {
                } else {
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Given job ID ").append(jobId).append(" is different than previous ").append(this.mJobId).toString());
            throw illegalArgumentException;
        }

        public void serviceProcessingFinished() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceStartReceived() {
        }
    }

    static final class CompatWorkEnqueuer extends androidx.core.app.JobIntentService.WorkEnqueuer {

        private final Context mContext;
        private final PowerManager.WakeLock mLaunchWakeLock;
        boolean mLaunchingService;
        private final PowerManager.WakeLock mRunWakeLock;
        boolean mServiceProcessing;
        CompatWorkEnqueuer(Context context, ComponentName cn) {
            super(cn);
            this.mContext = context.getApplicationContext();
            Object systemService = context.getSystemService("power");
            StringBuilder stringBuilder = new StringBuilder();
            int i = 1;
            this.mLaunchWakeLock = (PowerManager)systemService.newWakeLock(i, stringBuilder.append(cn.getClassName()).append(":launch").toString());
            final int i2 = 0;
            this.mLaunchWakeLock.setReferenceCounted(i2);
            StringBuilder stringBuilder2 = new StringBuilder();
            this.mRunWakeLock = systemService.newWakeLock(i, stringBuilder2.append(cn.getClassName()).append(":run").toString());
            this.mRunWakeLock.setReferenceCounted(i2);
        }

        @Override // androidx.core.app.JobIntentService$WorkEnqueuer
        void enqueueWork(Intent work) {
            boolean mServiceProcessing;
            int i;
            Intent intent = new Intent(work);
            intent.setComponent(this.mComponentName);
            this.mLaunchingService = true;
            if (this.mContext.startService(intent) != null && this.mLaunchingService == null && !this.mServiceProcessing) {
                synchronized (this) {
                    this.mLaunchingService = true;
                    if (!this.mServiceProcessing) {
                        this.mLaunchWakeLock.acquire(60000);
                    }
                }
            }
        }

        @Override // androidx.core.app.JobIntentService$WorkEnqueuer
        public void serviceProcessingFinished() {
            boolean mLaunchingService;
            boolean mServiceProcessing;
            int i;
            synchronized (this) {
                try {
                    if (this.mLaunchingService != null) {
                    }
                    this.mLaunchWakeLock.acquire(60000);
                    this.mServiceProcessing = false;
                    this.mRunWakeLock.release();
                    throw th;
                }
            }
        }

        @Override // androidx.core.app.JobIntentService$WorkEnqueuer
        public void serviceProcessingStarted() {
            boolean mServiceProcessing;
            int i;
            synchronized (this) {
                try {
                    this.mServiceProcessing = true;
                    this.mRunWakeLock.acquire(600000);
                    this.mLaunchWakeLock.release();
                    throw th;
                }
            }
        }

        @Override // androidx.core.app.JobIntentService$WorkEnqueuer
        public void serviceStartReceived() {
            this.mLaunchingService = false;
            return;
            synchronized (this) {
                this.mLaunchingService = false;
            }
        }
    }

    interface GenericWorkItem {
        public abstract void complete();

        public abstract Intent getIntent();
    }

    final class CompatWorkItem implements androidx.core.app.JobIntentService.GenericWorkItem {

        final Intent mIntent;
        final int mStartId;
        final androidx.core.app.JobIntentService this$0;
        CompatWorkItem(androidx.core.app.JobIntentService this$0, Intent intent, int startId) {
            this.this$0 = this$0;
            super();
            this.mIntent = intent;
            this.mStartId = startId;
        }

        @Override // androidx.core.app.JobIntentService$GenericWorkItem
        public void complete() {
            this.this$0.stopSelf(this.mStartId);
        }

        @Override // androidx.core.app.JobIntentService$GenericWorkItem
        public Intent getIntent() {
            return this.mIntent;
        }
    }

    static final class JobServiceEngineImpl extends JobServiceEngine implements androidx.core.app.JobIntentService.CompatJobEngine {

        static final boolean DEBUG = false;
        static final String TAG = "JobServiceEngineImpl";
        final Object mLock;
        JobParameters mParams;
        final androidx.core.app.JobIntentService mService;
        JobServiceEngineImpl(androidx.core.app.JobIntentService service) {
            super(service);
            Object object = new Object();
            this.mLock = object;
            this.mService = service;
        }

        @Override // android.app.job.JobServiceEngine
        public IBinder compatGetBinder() {
            return getBinder();
        }

        @Override // android.app.job.JobServiceEngine
        public androidx.core.app.JobIntentService.GenericWorkItem dequeueWork() {
            Object mLock = this.mLock;
            int i = 0;
            synchronized (mLock) {
                return i;
            }
            try {
                dequeueWork.getIntent().setExtrasClassLoader(this.mService.getClassLoader());
                JobIntentService.JobServiceEngineImpl.WrapperWorkItem wrapperWorkItem = new JobIntentService.JobServiceEngineImpl.WrapperWorkItem(this, dequeueWork);
                return wrapperWorkItem;
                return i;
                throw work;
            }
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters params) {
            this.mParams = params;
            this.mService.ensureProcessorRunningLocked(false);
            return 1;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters params) {
            final Object mLock = this.mLock;
            this.mParams = 0;
            return this.mService.doStopCurrentWork();
            synchronized (mLock) {
                mLock = this.mLock;
                this.mParams = 0;
                return this.mService.doStopCurrentWork();
            }
        }
    }

    static final class JobWorkEnqueuer extends androidx.core.app.JobIntentService.WorkEnqueuer {

        private final JobInfo mJobInfo;
        private final JobScheduler mJobScheduler;
        JobWorkEnqueuer(Context context, ComponentName cn, int jobId) {
            super(cn);
            ensureJobId(jobId);
            JobInfo.Builder builder = new JobInfo.Builder(jobId, this.mComponentName);
            this.mJobInfo = builder.setOverrideDeadline(0).build();
            this.mJobScheduler = (JobScheduler)context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // androidx.core.app.JobIntentService$WorkEnqueuer
        void enqueueWork(Intent work) {
            JobWorkItem jobWorkItem = new JobWorkItem(work);
            this.mJobScheduler.enqueue(this.mJobInfo, jobWorkItem);
        }
    }
    static {
        Object object = new Object();
        JobIntentService.sLock = object;
        HashMap hashMap = new HashMap();
        JobIntentService.sClassWorkEnqueuer = hashMap;
    }

    public JobIntentService() {
        super();
        int i = 0;
        int i2 = 0;
    }

    public static void enqueueWork(Context context, ComponentName component, int jobId, Intent work) {
        if (work == null) {
        } else {
            Object sLock = JobIntentService.sLock;
            androidx.core.app.JobIntentService.WorkEnqueuer workEnqueuer = JobIntentService.getWorkEnqueuer(context, component, true, jobId);
            workEnqueuer.ensureJobId(jobId);
            workEnqueuer.enqueueWork(work);
            return;
            synchronized (sLock) {
                sLock = JobIntentService.sLock;
                workEnqueuer = JobIntentService.getWorkEnqueuer(context, component, true, jobId);
                workEnqueuer.ensureJobId(jobId);
                workEnqueuer.enqueueWork(work);
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("work must not be null");
        throw illegalArgumentException;
    }

    public static void enqueueWork(Context context, Class<?> class2, int jobId, Intent work) {
        ComponentName componentName = new ComponentName(context, class2);
        JobIntentService.enqueueWork(context, componentName, jobId, work);
    }

    static androidx.core.app.JobIntentService.WorkEnqueuer getWorkEnqueuer(Context context, ComponentName cn, boolean hasJobId, int jobId) {
        Object we;
        HashMap sClassWorkEnqueuer;
        if ((JobIntentService.WorkEnqueuer)JobIntentService.sClassWorkEnqueuer.get(cn) == null) {
            if (!hasJobId) {
            } else {
                JobIntentService.JobWorkEnqueuer jobWorkEnqueuer = new JobIntentService.JobWorkEnqueuer(context, cn, jobId);
                JobIntentService.sClassWorkEnqueuer.put(cn, jobWorkEnqueuer);
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't be here without a job id");
            throw illegalArgumentException;
        }
        return we;
    }

    @Override // android.app.Service
    androidx.core.app.JobIntentService.GenericWorkItem dequeueWork() {
        if (this.mJobImpl != null) {
            return this.mJobImpl.dequeueWork();
        }
        ArrayList mCompatQueue = this.mCompatQueue;
        synchronized (mCompatQueue) {
            return (JobIntentService.GenericWorkItem)this.mCompatQueue.remove(0);
        }
    }

    @Override // android.app.Service
    boolean doStopCurrentWork() {
        androidx.core.app.JobIntentService.CommandProcessor mCurProcessor;
        boolean mInterruptIfStopped;
        if (this.mCurProcessor != null) {
            this.mCurProcessor.cancel(this.mInterruptIfStopped);
        }
        this.mStopped = true;
        return onStopCurrentWork();
    }

    @Override // android.app.Service
    void ensureProcessorRunningLocked(boolean reportStarted) {
        androidx.core.app.JobIntentService.WorkEnqueuer mCompatWorkEnqueuer;
        androidx.core.app.JobIntentService.CommandProcessor mCurProcessor;
        java.util.concurrent.Executor tHREAD_POOL_EXECUTOR;
        Void[] arr;
        JobIntentService.CommandProcessor commandProcessor = new JobIntentService.CommandProcessor(this);
        this.mCurProcessor = commandProcessor;
        if (this.mCurProcessor == null && this.mCompatWorkEnqueuer != null && reportStarted) {
            commandProcessor = new JobIntentService.CommandProcessor(this);
            this.mCurProcessor = commandProcessor;
            if (this.mCompatWorkEnqueuer != null) {
                if (reportStarted) {
                    this.mCompatWorkEnqueuer.serviceProcessingStarted();
                }
            }
            this.mCurProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    @Override // android.app.Service
    public boolean isStopped() {
        return this.mStopped;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.mJobImpl != null) {
            return this.mJobImpl.compatGetBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        JobIntentService.JobServiceEngineImpl jobServiceEngineImpl = new JobIntentService.JobServiceEngineImpl(this);
        this.mJobImpl = jobServiceEngineImpl;
        this.mCompatWorkEnqueuer = 0;
    }

    @Override // android.app.Service
    public void onDestroy() {
        ArrayList mCompatQueue;
        Object mCompatWorkEnqueuer;
        super.onDestroy();
        if (this.mCompatQueue != null) {
            mCompatQueue = this.mCompatQueue;
            this.mDestroyed = true;
            this.mCompatWorkEnqueuer.serviceProcessingFinished();
            synchronized (mCompatQueue) {
                mCompatQueue = this.mCompatQueue;
                this.mDestroyed = true;
                this.mCompatWorkEnqueuer.serviceProcessingFinished();
            }
        }
    }

    @Override // android.app.Service
    protected abstract void onHandleWork(Intent intent);

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent intent2;
        if (this.mCompatQueue != null) {
            this.mCompatWorkEnqueuer.serviceStartReceived();
            ArrayList mCompatQueue2 = this.mCompatQueue;
            synchronized (mCompatQueue2) {
                intent2 = intent;
                JobIntentService.CompatWorkItem compatWorkItem = new JobIntentService.CompatWorkItem(this, intent2, startId);
                this.mCompatQueue.add(compatWorkItem);
                ensureProcessorRunningLocked(true);
                return 3;
            }
        }
        return 2;
    }

    @Override // android.app.Service
    public boolean onStopCurrentWork() {
        return 1;
    }

    @Override // android.app.Service
    void processorFinished() {
        ArrayList mCompatQueue;
        int mCompatWorkEnqueuer;
        ArrayList mCompatQueue2;
        if (this.mCompatQueue != null) {
            mCompatQueue = this.mCompatQueue;
            this.mCurProcessor = 0;
            synchronized (mCompatQueue) {
                if (this.mCompatQueue.size() > 0) {
                    ensureProcessorRunningLocked(false);
                } else {
                    if (!this.mDestroyed) {
                        this.mCompatWorkEnqueuer.serviceProcessingFinished();
                    }
                }
            }
        }
        try {
        }
    }

    @Override // android.app.Service
    public void setInterruptIfStopped(boolean interruptIfStopped) {
        this.mInterruptIfStopped = interruptIfStopped;
    }
}

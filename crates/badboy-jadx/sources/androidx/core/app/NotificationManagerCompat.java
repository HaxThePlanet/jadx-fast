package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.service.notification.StatusBarNotification;
import android.support.v4.app.INotificationSideChannel;
import android.support.v4.app.INotificationSideChannel.Stub;
import android.util.Log;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes5.dex */
public final class NotificationManagerCompat {

    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MAX = 5;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;
    public static final int INTERRUPTION_FILTER_ALARMS = 4;
    public static final int INTERRUPTION_FILTER_ALL = 1;
    public static final int INTERRUPTION_FILTER_NONE = 3;
    public static final int INTERRUPTION_FILTER_PRIORITY = 2;
    public static final int INTERRUPTION_FILTER_UNKNOWN = 0;
    static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    private static final String TAG = "NotifManCompat";
    private static Set<String> sEnabledNotificationListenerPackages;
    private static String sEnabledNotificationListeners;
    private static final Object sEnabledNotificationListenersLock;
    private static final Object sLock;
    private static androidx.core.app.NotificationManagerCompat.SideChannelManager sSideChannelManager;
    private final Context mContext;
    private final NotificationManager mNotificationManager;

    static class Api23Impl {
        static List<StatusBarNotification> getActiveNotifications(NotificationManager notificationManager) {
            final StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
            if (activeNotifications == null) {
                ArrayList arrayList = new ArrayList();
                return arrayList;
            }
            return Arrays.asList(activeNotifications);
        }

        static int getCurrentInterruptionFilter(NotificationManager notificationManager) {
            return notificationManager.getCurrentInterruptionFilter();
        }
    }

    static class Api24Impl {
        static boolean areNotificationsEnabled(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        static int getImportance(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    static class Api26Impl {
        static void createNotificationChannel(NotificationManager notificationManager, NotificationChannel channel) {
            notificationManager.createNotificationChannel(channel);
        }

        static void createNotificationChannelGroup(NotificationManager notificationManager, NotificationChannelGroup group) {
            notificationManager.createNotificationChannelGroup(group);
        }

        static void createNotificationChannelGroups(NotificationManager notificationManager, List<NotificationChannelGroup> list2) {
            notificationManager.createNotificationChannelGroups(list2);
        }

        static void createNotificationChannels(NotificationManager notificationManager, List<NotificationChannel> list2) {
            notificationManager.createNotificationChannels(list2);
        }

        static void deleteNotificationChannel(NotificationManager notificationManager, String channelId) {
            notificationManager.deleteNotificationChannel(channelId);
        }

        static void deleteNotificationChannelGroup(NotificationManager notificationManager, String groupId) {
            notificationManager.deleteNotificationChannelGroup(groupId);
        }

        static String getId(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        static String getId(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        static NotificationChannel getNotificationChannel(NotificationManager notificationManager, String channelId) {
            return notificationManager.getNotificationChannel(channelId);
        }

        static List<NotificationChannelGroup> getNotificationChannelGroups(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannelGroups();
        }

        static List<NotificationChannel> getNotificationChannels(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannels();
        }
    }

    static class Api28Impl {
        static NotificationChannelGroup getNotificationChannelGroup(NotificationManager notificationManager, String channelGroupId) {
            return notificationManager.getNotificationChannelGroup(channelGroupId);
        }
    }

    static class Api30Impl {
        static NotificationChannel getNotificationChannel(NotificationManager notificationManager, String channelId, String conversationId) {
            return notificationManager.getNotificationChannel(channelId, conversationId);
        }

        static String getParentChannelId(NotificationChannel notificationChannel) {
            return notificationChannel.getParentChannelId();
        }
    }

    static class Api34Impl {
        static boolean canUseFullScreenIntent(NotificationManager notificationManager) {
            return notificationManager.canUseFullScreenIntent();
        }
    }

    private interface Task {
        public abstract void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    private static class CancelTask implements androidx.core.app.NotificationManagerCompat.Task {

        final boolean all;
        final int id;
        final String packageName;
        final String tag;
        CancelTask(String packageName) {
            super();
            this.packageName = packageName;
            this.id = 0;
            this.tag = 0;
            this.all = true;
        }

        CancelTask(String packageName, int id, String tag) {
            super();
            this.packageName = packageName;
            this.id = id;
            this.tag = tag;
            this.all = false;
        }

        public void send(INotificationSideChannel service) throws RemoteException {
            String packageName;
            int i;
            String tag;
            if (this.all) {
                service.cancelAll(this.packageName);
            } else {
                service.cancel(this.packageName, this.id, this.tag);
            }
        }

        @Override // androidx.core.app.NotificationManagerCompat$Task
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("CancelTask[");
            stringBuilder.append("packageName:").append(this.packageName);
            stringBuilder.append(", id:").append(this.id);
            stringBuilder.append(", tag:").append(this.tag);
            stringBuilder.append(", all:").append(this.all);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface InterruptionFilter {
    }

    public static class NotificationWithIdAndTag {

        final int mId;
        Notification mNotification;
        final String mTag;
        public NotificationWithIdAndTag(int id, Notification notification) {
            super(0, id, notification);
        }

        public NotificationWithIdAndTag(String tag, int id, Notification notification) {
            super();
            this.mTag = tag;
            this.mId = id;
            this.mNotification = notification;
        }
    }

    private static class NotifyTask implements androidx.core.app.NotificationManagerCompat.Task {

        final int id;
        final Notification notif;
        final String packageName;
        final String tag;
        NotifyTask(String packageName, int id, String tag, Notification notif) {
            super();
            this.packageName = packageName;
            this.id = id;
            this.tag = tag;
            this.notif = notif;
        }

        public void send(INotificationSideChannel service) throws RemoteException {
            service.notify(this.packageName, this.id, this.tag, this.notif);
        }

        @Override // androidx.core.app.NotificationManagerCompat$Task
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
            stringBuilder.append("packageName:").append(this.packageName);
            stringBuilder.append(", id:").append(this.id);
            stringBuilder.append(", tag:").append(this.tag);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    private static class ServiceConnectedEvent {

        final ComponentName componentName;
        final IBinder iBinder;
        ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            super();
            this.componentName = componentName;
            this.iBinder = iBinder;
        }
    }

    private static class SideChannelManager implements Handler.Callback, ServiceConnection {

        private static final int MSG_QUEUE_TASK = 0;
        private static final int MSG_RETRY_LISTENER_QUEUE = 3;
        private static final int MSG_SERVICE_CONNECTED = 1;
        private static final int MSG_SERVICE_DISCONNECTED = 2;
        private Set<String> mCachedEnabledPackages;
        private final Context mContext;
        private final Handler mHandler;
        private final HandlerThread mHandlerThread;
        private final Map<ComponentName, androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord> mRecordMap;
        SideChannelManager(Context context) {
            super();
            HashMap hashMap = new HashMap();
            this.mRecordMap = hashMap;
            HashSet hashSet = new HashSet();
            this.mCachedEnabledPackages = hashSet;
            this.mContext = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread = handlerThread;
            this.mHandlerThread.start();
            Handler handler = new Handler(this.mHandlerThread.getLooper(), this);
            this.mHandler = handler;
        }

        private boolean ensureServiceBound(androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord record) {
            int mContext;
            int str;
            if (record.bound) {
                return 1;
            }
            Intent intent = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL");
            record.bound = this.mContext.bindService(intent.setComponent(record.componentName), this, 33);
            if (record.bound) {
                record.retryCount = 0;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                Log.w("NotifManCompat", stringBuilder.append("Unable to bind to listener ").append(record.componentName).toString());
                this.mContext.unbindService(this);
            }
            return record.bound;
        }

        private void ensureServiceUnbound(androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord record) {
            boolean bound;
            if (record.bound) {
                this.mContext.unbindService(this);
                record.bound = false;
            }
            record.service = 0;
        }

        private void handleQueueTask(androidx.core.app.NotificationManagerCompat.Task task) {
            Object next;
            ArrayDeque taskQueue;
            updateListenerMap();
            Iterator iterator = this.mRecordMap.values().iterator();
            for (NotificationManagerCompat.SideChannelManager.ListenerRecord next : iterator) {
                next.taskQueue.add(task);
                processListenerQueue(next);
            }
        }

        private void handleRetryListenerQueue(ComponentName componentName) {
            Object obj = this.mRecordMap.get(componentName);
            if ((NotificationManagerCompat.SideChannelManager.ListenerRecord)obj != null) {
                processListenerQueue((NotificationManagerCompat.SideChannelManager.ListenerRecord)obj);
            }
        }

        private void handleServiceConnected(ComponentName componentName, IBinder iBinder) {
            int i;
            Object obj = this.mRecordMap.get(componentName);
            if ((NotificationManagerCompat.SideChannelManager.ListenerRecord)obj != null) {
                obj.service = INotificationSideChannel.Stub.asInterface(iBinder);
                obj.retryCount = 0;
                processListenerQueue((NotificationManagerCompat.SideChannelManager.ListenerRecord)obj);
            }
        }

        private void handleServiceDisconnected(ComponentName componentName) {
            Object obj = this.mRecordMap.get(componentName);
            if ((NotificationManagerCompat.SideChannelManager.ListenerRecord)obj != null) {
                ensureServiceUnbound((NotificationManagerCompat.SideChannelManager.ListenerRecord)obj);
            }
        }

        private void processListenerQueue(androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord record) {
            Throwable string;
            int i;
            boolean loggable;
            INotificationSideChannel ensureServiceBound;
            StringBuilder taskQueue;
            boolean loggable2;
            String componentName;
            String str = "NotifManCompat";
            i = 3;
            if (Log.isLoggable(str, i)) {
                StringBuilder stringBuilder = new StringBuilder();
                Log.d(str, stringBuilder.append("Processing component ").append(record.componentName).append(", ").append(record.taskQueue.size()).append(" queued tasks").toString());
            }
            if (record.taskQueue.isEmpty()) {
            }
            if (ensureServiceBound(record) && record.service == null) {
                if (record.service == null) {
                }
            }
            scheduleListenerRetry(record);
        }

        private void scheduleListenerRetry(androidx.core.app.NotificationManagerCompat.SideChannelManager.ListenerRecord record) {
            boolean loggable;
            int str;
            int i6 = 3;
            if (this.mHandler.hasMessages(i6, record.componentName)) {
            }
            int i5 = 1;
            record.retryCount = retryCount += i5;
            final String str7 = "NotifManCompat";
            if (record.retryCount > 6) {
                StringBuilder stringBuilder = new StringBuilder();
                Log.w(str7, stringBuilder.append("Giving up on delivering ").append(record.taskQueue.size()).append(" tasks to ").append(record.componentName).append(" after ").append(record.retryCount).append(" retries").toString());
                record.taskQueue.clear();
            }
            i3 *= 1000;
            if (Log.isLoggable(str7, i6)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                Log.d(str7, stringBuilder2.append("Scheduling retry for ").append(i4).append(" ms").toString());
            }
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(i6, record.componentName), (long)i4);
        }

        private void updateListenerMap() {
            Object next3;
            boolean next;
            boolean next2;
            String str;
            ComponentName componentName;
            boolean loggable;
            String listenerRecord;
            boolean loggable2;
            String name;
            Set enabledListenerPackages = NotificationManagerCompat.getEnabledListenerPackages(this.mContext);
            if (enabledListenerPackages.equals(this.mCachedEnabledPackages)) {
            }
            this.mCachedEnabledPackages = enabledListenerPackages;
            Intent intent = new Intent();
            HashSet hashSet = new HashSet();
            Iterator iterator = this.mContext.getPackageManager().queryIntentServices(intent.setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0).iterator();
            str = "NotifManCompat";
            while (iterator.hasNext()) {
                next3 = iterator.next();
                if (!enabledListenerPackages.contains(serviceInfo.packageName)) {
                } else {
                }
                componentName = new ComponentName(serviceInfo2.packageName, serviceInfo4.name);
                if (serviceInfo3.permission != null) {
                } else {
                }
                hashSet.add(componentName);
                str = "NotifManCompat";
                StringBuilder stringBuilder3 = new StringBuilder();
                Log.w(str, stringBuilder3.append("Permission present on component ").append(componentName).append(", not adding listener record.").toString());
            }
            Iterator iterator2 = hashSet.iterator();
            componentName = 3;
            while (iterator2.hasNext()) {
                next = iterator2.next();
                if (!this.mRecordMap.containsKey((ComponentName)next) && Log.isLoggable(str, componentName)) {
                }
                componentName = 3;
                if (Log.isLoggable(str, componentName)) {
                }
                listenerRecord = new NotificationManagerCompat.SideChannelManager.ListenerRecord(next);
                this.mRecordMap.put(next, listenerRecord);
                StringBuilder stringBuilder = new StringBuilder();
                Log.d(str, stringBuilder.append("Adding listener record for ").append(next).toString());
            }
            Iterator iterator3 = this.mRecordMap.entrySet().iterator();
            while (iterator3.hasNext()) {
                next2 = iterator3.next();
                if (!hashSet.contains((Map.Entry)next2.getKey()) && Log.isLoggable(str, componentName)) {
                }
                if (Log.isLoggable(str, componentName)) {
                }
                ensureServiceUnbound((NotificationManagerCompat.SideChannelManager.ListenerRecord)next2.getValue());
                iterator3.remove();
                StringBuilder stringBuilder2 = new StringBuilder();
                Log.d(str, stringBuilder2.append("Removing listener record for ").append(next2.getKey()).toString());
            }
        }

        @Override // android.os.Handler$Callback
        public boolean handleMessage(Message msg) {
            final int i3 = 1;
            switch (what) {
                case 0:
                    handleQueueTask((NotificationManagerCompat.Task)msg.obj);
                    return i3;
                case 1:
                    Object obj2 = msg.obj;
                    handleServiceConnected(obj2.componentName, obj2.iBinder);
                    return i3;
                case 2:
                    handleServiceDisconnected((ComponentName)msg.obj);
                    return i3;
                case 3:
                    handleRetryListenerQueue((ComponentName)msg.obj);
                    return i3;
                default:
                    return 0;
            }
        }

        @Override // android.os.Handler$Callback
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            boolean loggable;
            String str;
            String str2 = "NotifManCompat";
            if (Log.isLoggable(str2, 3)) {
                StringBuilder stringBuilder = new StringBuilder();
                Log.d(str2, stringBuilder.append("Connected to service ").append(componentName).toString());
            }
            NotificationManagerCompat.ServiceConnectedEvent serviceConnectedEvent = new NotificationManagerCompat.ServiceConnectedEvent(componentName, iBinder);
            this.mHandler.obtainMessage(1, serviceConnectedEvent).sendToTarget();
        }

        @Override // android.os.Handler$Callback
        public void onServiceDisconnected(ComponentName componentName) {
            boolean loggable;
            String str;
            String str2 = "NotifManCompat";
            if (Log.isLoggable(str2, 3)) {
                StringBuilder stringBuilder = new StringBuilder();
                Log.d(str2, stringBuilder.append("Disconnected from service ").append(componentName).toString());
            }
            this.mHandler.obtainMessage(2, componentName).sendToTarget();
        }

        @Override // android.os.Handler$Callback
        public void queueTask(androidx.core.app.NotificationManagerCompat.Task task) {
            this.mHandler.obtainMessage(0, task).sendToTarget();
        }
    }
    static {
        Object object = new Object();
        NotificationManagerCompat.sEnabledNotificationListenersLock = object;
        HashSet hashSet = new HashSet();
        NotificationManagerCompat.sEnabledNotificationListenerPackages = hashSet;
        Object object2 = new Object();
        NotificationManagerCompat.sLock = object2;
    }

    NotificationManagerCompat(NotificationManager notificationManager, Context context) {
        super();
        this.mContext = context;
        this.mNotificationManager = notificationManager;
    }

    private NotificationManagerCompat(Context context) {
        super();
        this.mContext = context;
        this.mNotificationManager = (NotificationManager)this.mContext.getSystemService("notification");
    }

    public static androidx.core.app.NotificationManagerCompat from(Context context) {
        NotificationManagerCompat notificationManagerCompat = new NotificationManagerCompat(context);
        return notificationManagerCompat;
    }

    public static Set<String> getEnabledListenerPackages(Context context) {
        boolean equals;
        HashSet hashSet;
        int length;
        int i;
        String str;
        ComponentName unflattenFromString;
        String packageName;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        Object sEnabledNotificationListenersLock = NotificationManagerCompat.sEnabledNotificationListenersLock;
        synchronized (sEnabledNotificationListenersLock) {
            if (!string.equals(NotificationManagerCompat.sEnabledNotificationListeners)) {
                equals = string.split(":", -1);
                hashSet = new HashSet(equals.length);
                i = 0;
                while (i < equals.length) {
                    unflattenFromString = ComponentName.unflattenFromString(equals[i]);
                    if (unflattenFromString != null) {
                    }
                    i++;
                    hashSet.add(unflattenFromString.getPackageName());
                }
                NotificationManagerCompat.sEnabledNotificationListenerPackages = hashSet;
                NotificationManagerCompat.sEnabledNotificationListeners = string;
            }
            return NotificationManagerCompat.sEnabledNotificationListenerPackages;
        }
    }

    private void pushSideChannelQueue(androidx.core.app.NotificationManagerCompat.Task task) {
        androidx.core.app.NotificationManagerCompat.SideChannelManager sSideChannelManager;
        Context applicationContext;
        final Object sLock = NotificationManagerCompat.sLock;
        synchronized (sLock) {
            sSideChannelManager = new NotificationManagerCompat.SideChannelManager(this.mContext.getApplicationContext());
            NotificationManagerCompat.sSideChannelManager = sSideChannelManager;
            NotificationManagerCompat.sSideChannelManager.queueTask(task);
        }
    }

    private static boolean useSideChannelForNotification(Notification notification) {
        boolean boolean;
        int i;
        final Bundle extras = NotificationCompat.getExtras(notification);
        if (extras != null && extras.getBoolean("android.support.useSideChannel")) {
            i = extras.getBoolean("android.support.useSideChannel") ? 1 : 0;
        } else {
        }
        return i;
    }

    public boolean areNotificationsEnabled() {
        return NotificationManagerCompat.Api24Impl.areNotificationsEnabled(this.mNotificationManager);
    }

    public boolean canUseFullScreenIntent() {
        int i;
        if (Build.VERSION.SDK_INT < 34) {
            i = this.mContext.checkSelfPermission("android.permission.USE_FULL_SCREEN_INTENT") == 0 ? 1 : 0;
            return i;
        }
        return NotificationManagerCompat.Api34Impl.canUseFullScreenIntent(this.mNotificationManager);
    }

    public void cancel(int id) {
        cancel(0, id);
    }

    public void cancel(String tag, int id) {
        this.mNotificationManager.cancel(tag, id);
    }

    public void cancelAll() {
        this.mNotificationManager.cancelAll();
    }

    public void createNotificationChannel(NotificationChannel channel) {
        NotificationManagerCompat.Api26Impl.createNotificationChannel(this.mNotificationManager, channel);
    }

    public void createNotificationChannel(androidx.core.app.NotificationChannelCompat channel) {
        createNotificationChannel(channel.getNotificationChannel());
    }

    public void createNotificationChannelGroup(NotificationChannelGroup group) {
        NotificationManagerCompat.Api26Impl.createNotificationChannelGroup(this.mNotificationManager, group);
    }

    public void createNotificationChannelGroup(androidx.core.app.NotificationChannelGroupCompat group) {
        createNotificationChannelGroup(group.getNotificationChannelGroup());
    }

    public void createNotificationChannelGroups(List<NotificationChannelGroup> list) {
        NotificationManagerCompat.Api26Impl.createNotificationChannelGroups(this.mNotificationManager, list);
    }

    public void createNotificationChannelGroupsCompat(List<androidx.core.app.NotificationChannelGroupCompat> list) {
        boolean arrayList;
        NotificationManager mNotificationManager;
        boolean next;
        NotificationChannelGroup notificationChannelGroup;
        if (!list.isEmpty()) {
            arrayList = new ArrayList(list.size());
            Iterator iterator = list.iterator();
            for (NotificationChannelGroupCompat next : iterator) {
                arrayList.add(next.getNotificationChannelGroup());
            }
            NotificationManagerCompat.Api26Impl.createNotificationChannelGroups(this.mNotificationManager, arrayList);
        }
    }

    public void createNotificationChannels(List<NotificationChannel> list) {
        NotificationManagerCompat.Api26Impl.createNotificationChannels(this.mNotificationManager, list);
    }

    public void createNotificationChannelsCompat(List<androidx.core.app.NotificationChannelCompat> list) {
        boolean arrayList;
        NotificationManager mNotificationManager;
        boolean next;
        NotificationChannel notificationChannel;
        if (!list.isEmpty()) {
            arrayList = new ArrayList(list.size());
            Iterator iterator = list.iterator();
            for (NotificationChannelCompat next : iterator) {
                arrayList.add(next.getNotificationChannel());
            }
            NotificationManagerCompat.Api26Impl.createNotificationChannels(this.mNotificationManager, arrayList);
        }
    }

    public void deleteNotificationChannel(String channelId) {
        NotificationManagerCompat.Api26Impl.deleteNotificationChannel(this.mNotificationManager, channelId);
    }

    public void deleteNotificationChannelGroup(String groupId) {
        NotificationManagerCompat.Api26Impl.deleteNotificationChannelGroup(this.mNotificationManager, groupId);
    }

    public void deleteUnlistedNotificationChannels(Collection<String> collection) {
        Object next;
        boolean mNotificationManager;
        String str;
        Iterator iterator = NotificationManagerCompat.Api26Impl.getNotificationChannels(this.mNotificationManager).iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (collection.contains(NotificationManagerCompat.Api26Impl.getId((NotificationChannel)next))) {
            } else {
            }
            if (Build.VERSION.SDK_INT >= 30 && collection.contains(NotificationManagerCompat.Api30Impl.getParentChannelId(next))) {
            } else {
            }
            NotificationManagerCompat.Api26Impl.deleteNotificationChannel(this.mNotificationManager, NotificationManagerCompat.Api26Impl.getId(next));
            if (collection.contains(NotificationManagerCompat.Api30Impl.getParentChannelId(next))) {
            } else {
            }
        }
    }

    public List<StatusBarNotification> getActiveNotifications() {
        return NotificationManagerCompat.Api23Impl.getActiveNotifications(this.mNotificationManager);
    }

    public int getCurrentInterruptionFilter() {
        return NotificationManagerCompat.Api23Impl.getCurrentInterruptionFilter(this.mNotificationManager);
    }

    public int getImportance() {
        return NotificationManagerCompat.Api24Impl.getImportance(this.mNotificationManager);
    }

    public NotificationChannel getNotificationChannel(String channelId) {
        return NotificationManagerCompat.Api26Impl.getNotificationChannel(this.mNotificationManager, channelId);
    }

    public NotificationChannel getNotificationChannel(String channelId, String conversationId) {
        if (Build.VERSION.SDK_INT >= 30) {
            return NotificationManagerCompat.Api30Impl.getNotificationChannel(this.mNotificationManager, channelId, conversationId);
        }
        return getNotificationChannel(channelId);
    }

    public androidx.core.app.NotificationChannelCompat getNotificationChannelCompat(String channelId) {
        NotificationChannel notificationChannel = getNotificationChannel(channelId);
        if (notificationChannel != null) {
            NotificationChannelCompat notificationChannelCompat = new NotificationChannelCompat(notificationChannel);
            return notificationChannelCompat;
        }
        return null;
    }

    public androidx.core.app.NotificationChannelCompat getNotificationChannelCompat(String channelId, String conversationId) {
        NotificationChannel notificationChannel = getNotificationChannel(channelId, conversationId);
        if (notificationChannel != null) {
            NotificationChannelCompat notificationChannelCompat = new NotificationChannelCompat(notificationChannel);
            return notificationChannelCompat;
        }
        return null;
    }

    public NotificationChannelGroup getNotificationChannelGroup(String channelGroupId) {
        return NotificationManagerCompat.Api28Impl.getNotificationChannelGroup(this.mNotificationManager, channelGroupId);
    }

    public androidx.core.app.NotificationChannelGroupCompat getNotificationChannelGroupCompat(String channelGroupId) {
        NotificationChannelGroup notificationChannelGroup = getNotificationChannelGroup(channelGroupId);
        if (notificationChannelGroup != null) {
            NotificationChannelGroupCompat notificationChannelGroupCompat = new NotificationChannelGroupCompat(notificationChannelGroup);
            return notificationChannelGroupCompat;
        }
        return null;
    }

    public List<NotificationChannelGroup> getNotificationChannelGroups() {
        return NotificationManagerCompat.Api26Impl.getNotificationChannelGroups(this.mNotificationManager);
    }

    public List<androidx.core.app.NotificationChannelGroupCompat> getNotificationChannelGroupsCompat() {
        Object next;
        androidx.core.app.NotificationChannelGroupCompat notificationChannelGroupCompat;
        List notificationChannelGroups = getNotificationChannelGroups();
        if (!notificationChannelGroups.isEmpty()) {
            List emptyList2 = Collections.emptyList();
            ArrayList arrayList = new ArrayList(notificationChannelGroups.size());
            Iterator iterator = notificationChannelGroups.iterator();
            for (NotificationChannelGroup next : iterator) {
                notificationChannelGroupCompat = new NotificationChannelGroupCompat(next);
                arrayList.add(notificationChannelGroupCompat);
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public List<NotificationChannel> getNotificationChannels() {
        return NotificationManagerCompat.Api26Impl.getNotificationChannels(this.mNotificationManager);
    }

    public List<androidx.core.app.NotificationChannelCompat> getNotificationChannelsCompat() {
        Object next;
        androidx.core.app.NotificationChannelCompat notificationChannelCompat;
        List notificationChannels = getNotificationChannels();
        if (!notificationChannels.isEmpty()) {
            ArrayList arrayList = new ArrayList(notificationChannels.size());
            Iterator iterator = notificationChannels.iterator();
            for (NotificationChannel next : iterator) {
                notificationChannelCompat = new NotificationChannelCompat(next);
                arrayList.add(notificationChannelCompat);
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void notify(int id, Notification notification) {
        notify(0, id, notification);
    }

    public void notify(String tag, int id, Notification notification) {
        NotificationManager mNotificationManager;
        String packageName;
        if (NotificationManagerCompat.useSideChannelForNotification(notification)) {
            NotificationManagerCompat.NotifyTask notifyTask = new NotificationManagerCompat.NotifyTask(this.mContext.getPackageName(), id, tag, notification);
            pushSideChannelQueue(notifyTask);
            this.mNotificationManager.cancel(tag, id);
        } else {
            this.mNotificationManager.notify(tag, id, notification);
        }
    }

    public void notify(List<androidx.core.app.NotificationManagerCompat.NotificationWithIdAndTag> list) {
        int i;
        Object obj;
        String mTag;
        int mId;
        Notification mNotification;
        i = 0;
        while (i < list.size()) {
            obj = list.get(i);
            notify(obj.mTag, obj.mId, obj.mNotification);
            i++;
        }
    }
}

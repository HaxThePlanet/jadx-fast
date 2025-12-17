package com.google.firebase.crashlytics.internal.common;

import android.app.ApplicationExitInfo;
import android.content.Context;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log.Builder;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class SessionReportingCoordinator implements com.google.firebase.crashlytics.internal.common.CrashlyticsLifecycleEvents {

    private static final int DEFAULT_BUFFER_SIZE = 8192;
    private static final int EVENT_THREAD_IMPORTANCE = 4;
    private static final String EVENT_TYPE_CRASH = "crash";
    private static final String EVENT_TYPE_LOGGED = "error";
    private static final int MAX_CHAINED_EXCEPTION_DEPTH = 8;
    private final com.google.firebase.crashlytics.internal.common.CrashlyticsReportDataCapture dataCapture;
    private final LogFileManager logFileManager;
    private final com.google.firebase.crashlytics.internal.common.UserMetadata reportMetadata;
    private final CrashlyticsReportPersistence reportPersistence;
    private final DataTransportCrashlyticsReportSender reportsSender;
    SessionReportingCoordinator(com.google.firebase.crashlytics.internal.common.CrashlyticsReportDataCapture crashlyticsReportDataCapture, CrashlyticsReportPersistence crashlyticsReportPersistence2, DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender3, LogFileManager logFileManager4, com.google.firebase.crashlytics.internal.common.UserMetadata userMetadata5) {
        super();
        this.dataCapture = crashlyticsReportDataCapture;
        this.reportPersistence = crashlyticsReportPersistence2;
        this.reportsSender = dataTransportCrashlyticsReportSender3;
        this.logFileManager = logFileManager4;
        this.reportMetadata = userMetadata5;
    }

    public static boolean a(com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator sessionReportingCoordinator, j j2) {
        return sessionReportingCoordinator.onReportSendComplete(j2);
    }

    private CrashlyticsReport.Session.Event addLogsAndCustomKeysToEvent(CrashlyticsReport.Session.Event crashlyticsReport$Session$Event) {
        return addLogsAndCustomKeysToEvent(event, this.logFileManager, this.reportMetadata);
    }

    private CrashlyticsReport.Session.Event addLogsAndCustomKeysToEvent(CrashlyticsReport.Session.Event crashlyticsReport$Session$Event, LogFileManager logFileManager2, com.google.firebase.crashlytics.internal.common.UserMetadata userMetadata3) {
        Object builder;
        CrashlyticsReport.Session.Event.Application obj3;
        Object obj4;
        final CrashlyticsReport.Session.Event.Builder builder2 = event.toBuilder();
        obj4 = logFileManager2.getLogString();
        if (obj4 != null) {
            builder2.setLog(CrashlyticsReport.Session.Event.Log.builder().setContent(obj4).build());
        } else {
            Logger.getLogger().v("No log data to include with this event.");
        }
        obj4 = SessionReportingCoordinator.getSortedCustomAttributes(userMetadata3.getCustomKeys());
        if (!obj4.isEmpty()) {
            builder2.setApp(event.getApp().toBuilder().setCustomAttributes(ImmutableList.from(obj4)).setInternalKeys(ImmutableList.from(SessionReportingCoordinator.getSortedCustomAttributes(userMetadata3.getInternalKeys()))).build());
        }
        return builder2.build();
    }

    static int b(CrashlyticsReport.CustomAttribute crashlyticsReport$CustomAttribute, CrashlyticsReport.CustomAttribute crashlyticsReport$CustomAttribute2) {
        return customAttribute.getKey().compareTo(customAttribute2.getKey());
    }

    private static CrashlyticsReport.ApplicationExitInfo convertApplicationExitInfo(ApplicationExitInfo applicationExitInfo) {
        int convertInputStreamToString;
        InputStream traceInputStream;
        Logger logger;
        StringBuilder stringBuilder;
        String str;
        convertInputStreamToString = 0;
        traceInputStream = applicationExitInfo.getTraceInputStream();
        if (traceInputStream != null) {
            try {
                convertInputStreamToString = SessionReportingCoordinator.convertInputStreamToString(traceInputStream);
                stringBuilder = new StringBuilder();
                str = "Could not get input trace in application exit info: ";
                stringBuilder.append(str);
                str = applicationExitInfo.toString();
                stringBuilder.append(str);
                str = " Error: ";
                stringBuilder.append(str);
                stringBuilder.append(string);
                Throwable string = stringBuilder.toString();
                Logger.getLogger().w(string);
                return CrashlyticsReport.ApplicationExitInfo.builder().setImportance(applicationExitInfo.getImportance()).setProcessName(applicationExitInfo.getProcessName()).setReasonCode(applicationExitInfo.getReason()).setTimestamp(applicationExitInfo.getTimestamp()).setPid(applicationExitInfo.getPid()).setPss(applicationExitInfo.getPss()).setRss(applicationExitInfo.getRss()).setTraceFile(convertInputStreamToString).build();
            }
        }
    }

    public static String convertInputStreamToString(InputStream inputStream) {
        int read;
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        read = inputStream.read(bArr);
        while (read != -1) {
            byteArrayOutputStream.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
        return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
    }

    public static com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator create(Context context, com.google.firebase.crashlytics.internal.common.IdManager idManager2, FileStore fileStore3, com.google.firebase.crashlytics.internal.common.AppData appData4, LogFileManager logFileManager5, com.google.firebase.crashlytics.internal.common.UserMetadata userMetadata6, StackTraceTrimmingStrategy stackTraceTrimmingStrategy7, SettingsDataProvider settingsDataProvider8) {
        File file = new File(fileStore3.getFilesDirPath());
        CrashlyticsReportDataCapture crashlyticsReportDataCapture = new CrashlyticsReportDataCapture(context, idManager2, appData4, stackTraceTrimmingStrategy7);
        CrashlyticsReportPersistence crashlyticsReportPersistence = new CrashlyticsReportPersistence(file, settingsDataProvider8);
        super(crashlyticsReportDataCapture, crashlyticsReportPersistence, DataTransportCrashlyticsReportSender.create(context), logFileManager5, userMetadata6);
        return obj7;
    }

    private ApplicationExitInfo findRelevantApplicationExitInfo(String string, List<ApplicationExitInfo> list2) {
        int reason;
        int i;
        Object obj7;
        final Iterator obj6 = list2.iterator();
        int i2 = 0;
        for (ApplicationExitInfo obj7 : obj6) {
            i2 = 0;
        }
        return i2;
    }

    private static List<CrashlyticsReport.CustomAttribute> getSortedCustomAttributes(Map<String, String> map) {
        int build;
        CrashlyticsReport.CustomAttribute.Builder key;
        Object key2;
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        Iterator obj4 = map.entrySet().iterator();
        for (Map.Entry next2 : obj4) {
            arrayList.add(CrashlyticsReport.CustomAttribute.builder().setKey((String)next2.getKey()).setValue((String)next2.getValue()).build());
        }
        Collections.sort(arrayList, d.a);
        return arrayList;
    }

    private boolean onReportSendComplete(j<com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId> j) {
        if (j.isSuccessful()) {
            Object obj4 = j.getResult();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Crashlytics report successfully enqueued to DataTransport: ");
            stringBuilder.append((CrashlyticsReportWithSessionId)obj4.getSessionId());
            Logger.getLogger().d(stringBuilder.toString());
            this.reportPersistence.deleteFinalizedReport(obj4.getSessionId());
            return 1;
        }
        Logger.getLogger().w("Crashlytics report could not be enqueued to DataTransport", j.getException());
        return 0;
    }

    private void persistEvent(Throwable throwable, Thread thread2, String string3, String string4, long l5, boolean z6) {
        final Object obj = this;
        String str2 = string3;
        obj.reportPersistence.persistEvent(addLogsAndCustomKeysToEvent(obj.dataCapture.captureEventData(throwable, thread2, string4, l5, obj7, 4, true)), string3, string4.equals("crash"));
    }

    public void finalizeSessionWithNativeEvent(String string, List<com.google.firebase.crashlytics.internal.common.NativeSessionFile> list2) {
        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File filePayload;
        ArrayList arrayList = new ArrayList();
        Iterator obj4 = list2.iterator();
        while (obj4.hasNext()) {
            filePayload = (NativeSessionFile)obj4.next().asFilePayload();
            if (filePayload != null) {
            }
            arrayList.add(filePayload);
        }
        this.reportPersistence.finalizeSessionWithNativeEvent(string, CrashlyticsReport.FilesPayload.builder().setFiles(ImmutableList.from(arrayList)).build());
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsLifecycleEvents
    public void finalizeSessions(long l, String string2) {
        this.reportPersistence.finalizeReports(obj4, l);
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsLifecycleEvents
    public boolean hasReportsToSend() {
        return this.reportPersistence.hasFinalizedReports();
    }

    public List<String> listSortedOpenSessionIds() {
        return this.reportPersistence.listSortedOpenSessionIds();
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsLifecycleEvents
    public void onBeginSession(String string, long l2) {
        this.reportPersistence.persistReport(this.dataCapture.captureReportData(string, l2));
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsLifecycleEvents
    public void onCustomKey(String string, String string2) {
        this.reportMetadata.setCustomKey(string, string2);
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsLifecycleEvents
    public void onLog(long l, String string2) {
        this.logFileManager.writeToLog(l, string2);
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsLifecycleEvents
    public void onUserId(String string) {
        this.reportMetadata.setUserId(string);
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsLifecycleEvents
    public void persistFatalEvent(Throwable throwable, Thread thread2, String string3, long l4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Persisting fatal event for session ");
        stringBuilder.append(string3);
        Logger.getLogger().v(stringBuilder.toString());
        this.persistEvent(throwable, thread2, string3, "crash", l4, obj8);
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsLifecycleEvents
    public void persistNonFatalEvent(Throwable throwable, Thread thread2, String string3, long l4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Persisting non-fatal event for session ");
        stringBuilder.append(string3);
        Logger.getLogger().v(stringBuilder.toString());
        this.persistEvent(throwable, thread2, string3, "error", l4, obj8);
    }

    public void persistRelevantAppExitInfoEvent(String string, List<ApplicationExitInfo> list2, LogFileManager logFileManager3, com.google.firebase.crashlytics.internal.common.UserMetadata userMetadata4) {
        ApplicationExitInfo obj5 = findRelevantApplicationExitInfo(string, list2);
        if (obj5 == null) {
            StringBuilder obj6 = new StringBuilder();
            obj6.append("No relevant ApplicationExitInfo occurred during session: ");
            obj6.append(string);
            Logger.getLogger().v(obj6.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Persisting anr for session ");
        stringBuilder.append(string);
        Logger.getLogger().d(stringBuilder.toString());
        this.reportPersistence.persistEvent(addLogsAndCustomKeysToEvent(this.dataCapture.captureAnrEventData(SessionReportingCoordinator.convertApplicationExitInfo(obj5)), logFileManager3, userMetadata4), string, true);
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsLifecycleEvents
    public void persistUserId(String string) {
        String userId = this.reportMetadata.getUserId();
        if (userId == null) {
            Logger.getLogger().v("Could not persist user ID; no user ID available");
        }
        this.reportPersistence.persistUserIdForSession(userId, string);
    }

    @Override // com.google.firebase.crashlytics.internal.common.CrashlyticsLifecycleEvents
    public void removeAllReports() {
        this.reportPersistence.deleteAllReports();
    }

    public j<Void> sendReports(Executor executor) {
        j continueWith;
        com.google.firebase.crashlytics.internal.common.c cVar;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.reportPersistence.loadFinalizedReports().iterator();
        for (CrashlyticsReportWithSessionId next2 : iterator) {
            cVar = new c(this);
            arrayList.add(this.reportsSender.sendReport(next2).continueWith(executor, cVar));
        }
        return m.f(arrayList);
    }
}

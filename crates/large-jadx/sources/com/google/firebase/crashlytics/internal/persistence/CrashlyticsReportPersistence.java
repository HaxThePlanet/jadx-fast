package com.google.firebase.crashlytics.internal.persistence;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class CrashlyticsReportPersistence {

    private static final String APP_EXIT_INFO_FILE_NAME = "app-exit-info";
    private static final String EVENT_COUNTER_FORMAT = "%010d";
    private static final int EVENT_COUNTER_WIDTH = 10;
    private static final FilenameFilter EVENT_FILE_FILTER = null;
    private static final String EVENT_FILE_NAME_PREFIX = "event";
    private static final int EVENT_NAME_LENGTH = 0;
    private static final String EVENT_TYPE_ANR = "anr";
    private static final Comparator<? super File> LATEST_SESSION_ID_FIRST_COMPARATOR = null;
    private static final int MAX_OPEN_SESSIONS = 8;
    private static final String NATIVE_REPORTS_DIRECTORY = "native-reports";
    private static final String NORMAL_EVENT_SUFFIX = "";
    private static final String OPEN_SESSIONS_DIRECTORY_NAME = "sessions";
    private static final String PRIORITY_EVENT_SUFFIX = "_";
    private static final String PRIORITY_REPORTS_DIRECTORY = "priority-reports";
    private static final String REPORTS_DIRECTORY = "reports";
    private static final String REPORT_FILE_NAME = "report";
    private static final String SESSION_START_TIMESTAMP_FILE_NAME = "start-time";
    private static final CrashlyticsReportJsonTransform TRANSFORM = null;
    private static final String USER_FILE_NAME = "user";
    private static final Charset UTF_8 = null;
    private static final String WORKING_DIRECTORY_NAME = "report-persistence";
    private final AtomicInteger eventCounter;
    private final File nativeReportsDirectory;
    private final File openSessionsDirectory;
    private final File priorityReportsDirectory;
    private final File reportsDirectory;
    private final SettingsDataProvider settingsDataProvider;
    static {
        CrashlyticsReportPersistence.UTF_8 = Charset.forName("UTF-8");
        CrashlyticsReportPersistence.EVENT_NAME_LENGTH = 15;
        CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = new CrashlyticsReportJsonTransform();
        CrashlyticsReportPersistence.TRANSFORM = crashlyticsReportJsonTransform;
        CrashlyticsReportPersistence.LATEST_SESSION_ID_FIRST_COMPARATOR = a.a;
        CrashlyticsReportPersistence.EVENT_FILE_FILTER = f.a;
    }

    public CrashlyticsReportPersistence(File file, SettingsDataProvider settingsDataProvider2) {
        super();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.eventCounter = atomicInteger;
        File file2 = new File(file, "report-persistence");
        File obj3 = new File(file2, "sessions");
        this.openSessionsDirectory = obj3;
        obj3 = new File(file2, "priority-reports");
        this.priorityReportsDirectory = obj3;
        obj3 = new File(file2, "reports");
        this.reportsDirectory = obj3;
        obj3 = new File(file2, "native-reports");
        this.nativeReportsDirectory = obj3;
        this.settingsDataProvider = settingsDataProvider2;
    }

    public static boolean a(File file, String string2) {
        return CrashlyticsReportPersistence.isNormalPriorityEventFile(file, string2);
    }

    static boolean b(String string, File file2) {
        Object obj1;
        String obj2;
        if (file2.isDirectory() != null && file2.getName().equals(string) == null) {
            obj1 = file2.getName().equals(string) == null ? 1 : 0;
        } else {
        }
        return obj1;
    }

    static boolean c(String string, File file2, String string3) {
        return string3.startsWith(string);
    }

    private List<File> capAndGetOpenSessions(String string) {
        Object next;
        d dVar = new d(string);
        List obj4 = CrashlyticsReportPersistence.getFilesInDirectory(this.openSessionsDirectory, dVar);
        Collections.sort(obj4, CrashlyticsReportPersistence.LATEST_SESSION_ID_FIRST_COMPARATOR);
        final int i2 = 8;
        if (obj4.size() <= i2) {
            return obj4;
        }
        Iterator iterator = obj4.subList(i2, obj4.size()).iterator();
        for (File next : iterator) {
            CrashlyticsReportPersistence.recursiveDelete(next);
        }
        return obj4.subList(0, i2);
    }

    private static int capFilesCount(List<File> list, int i2) {
        int size;
        Object next;
        size = list.size();
        final Iterator obj2 = list.iterator();
        for (File next : obj2) {
            CrashlyticsReportPersistence.recursiveDelete(next);
            size--;
        }
        return size;
    }

    private void capFinalizedReports() {
        List allFinalizedReportFiles;
        int maxCompleteSessionsCount = sessionData.maxCompleteSessionsCount;
        allFinalizedReportFiles = getAllFinalizedReportFiles();
        final int size = allFinalizedReportFiles.size();
        if (size <= maxCompleteSessionsCount) {
        }
        Iterator iterator = allFinalizedReportFiles.subList(maxCompleteSessionsCount, size).iterator();
        for (File allFinalizedReportFiles : iterator) {
            allFinalizedReportFiles.delete();
        }
    }

    private static List<File> combineReportFiles(List<File>... listArr) {
        int i;
        int i2;
        int i3;
        int size;
        ArrayList arrayList = new ArrayList();
        i3 = i2;
        while (i2 < listArr.length) {
            i3 += size;
            i2++;
        }
        arrayList.ensureCapacity(i3);
        while (i < listArr.length) {
            arrayList.addAll(listArr[i]);
            i++;
        }
        return arrayList;
    }

    private static long convertTimestampFromSecondsToMs(long l) {
        return l *= i;
    }

    public static int d(File file, File file2) {
        return CrashlyticsReportPersistence.oldestEventFileFirst(file, file2);
    }

    static int e(File file, File file2) {
        return file2.getName().compareTo(file.getName());
    }

    static boolean f(File file, String string2) {
        return string2.startsWith("event");
    }

    private static String generateEventFilename(int i, boolean z2) {
        String obj4;
        Object[] arr = new Object[1];
        obj4 = z2 ? "_" : "";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("event");
        stringBuilder.append(String.format(Locale.US, "%010d", Integer.valueOf(i)));
        stringBuilder.append(obj4);
        return stringBuilder.toString();
    }

    private static List<File> getAllFilesInDirectory(File file) {
        return CrashlyticsReportPersistence.getFilesInDirectory(file, 0);
    }

    private List<File> getAllFinalizedReportFiles() {
        int i = 2;
        final List[] arr2 = new List[i];
        List[] arr = new List[i];
        final int i2 = 0;
        arr[i2] = CrashlyticsReportPersistence.getAllFilesInDirectory(this.priorityReportsDirectory);
        final int i3 = 1;
        arr[i3] = CrashlyticsReportPersistence.getAllFilesInDirectory(this.nativeReportsDirectory);
        arr2[i2] = CrashlyticsReportPersistence.combineReportFiles(arr);
        arr2[i3] = CrashlyticsReportPersistence.getAllFilesInDirectory(this.reportsDirectory);
        return CrashlyticsReportPersistence.sortAndCombineReportFiles(arr2);
    }

    private static String getEventNameWithoutPriority(String string) {
        return string.substring(0, CrashlyticsReportPersistence.EVENT_NAME_LENGTH);
    }

    private static List<File> getFilesInDirectory(File file, FileFilter fileFilter2) {
        File[] obj1;
        if (file.isDirectory() == null) {
            return Collections.emptyList();
        }
        if (fileFilter2 == null) {
            obj1 = file.listFiles();
        } else {
            obj1 = file.listFiles(fileFilter2);
        }
        if (obj1 != null) {
            obj1 = Arrays.asList(obj1);
        } else {
            obj1 = Collections.emptyList();
        }
        return obj1;
    }

    private static List<File> getFilesInDirectory(File file, FilenameFilter filenameFilter2) {
        File[] obj1;
        if (file.isDirectory() == null) {
            return Collections.emptyList();
        }
        if (filenameFilter2 == null) {
            obj1 = file.listFiles();
        } else {
            obj1 = file.listFiles(filenameFilter2);
        }
        if (obj1 != null) {
            obj1 = Arrays.asList(obj1);
        } else {
            obj1 = Collections.emptyList();
        }
        return obj1;
    }

    private File getSessionDirectoryById(String string) {
        File file = new File(this.openSessionsDirectory, string);
        return file;
    }

    private static boolean isHighPriorityEventFile(String string) {
        boolean startsWith;
        boolean obj1;
        if (string.startsWith("event") && string.endsWith("_")) {
            obj1 = string.endsWith("_") ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private static boolean isNormalPriorityEventFile(File file, String string2) {
        boolean obj0;
        if (string2.startsWith("event") && !string2.endsWith("_")) {
            obj0 = !string2.endsWith("_") ? 1 : 0;
        } else {
        }
        return obj0;
    }

    private static boolean makeDirectory(File file) {
        int obj1;
        if (file.exists() == null) {
            if (file.mkdirs() != null) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    private static int oldestEventFileFirst(File file, File file2) {
        return CrashlyticsReportPersistence.getEventNameWithoutPriority(file.getName()).compareTo(CrashlyticsReportPersistence.getEventNameWithoutPriority(file2.getName()));
    }

    private static File prepareDirectory(File file) {
        if (CrashlyticsReportPersistence.makeDirectory(file) == null) {
        } else {
            return file;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not create directory ");
        stringBuilder.append(file);
        IOException iOException = new IOException(stringBuilder.toString());
        throw iOException;
    }

    private static String readTextFile(File file) {
        int i;
        File obj4;
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        obj4 = fileInputStream.read(bArr);
        while (obj4 > 0) {
            byteArrayOutputStream.write(bArr, 0, obj4);
            obj4 = fileInputStream.read(bArr);
        }
        obj4 = new String(byteArrayOutputStream.toByteArray(), CrashlyticsReportPersistence.UTF_8);
        fileInputStream.close();
        return obj4;
    }

    private static void recursiveDelete(File file) {
        boolean listFiles;
        int length;
        int i;
        File file2;
        if (file == null) {
        }
        if (file.isDirectory() != null) {
            listFiles = file.listFiles();
            i = 0;
            while (i < listFiles.length) {
                CrashlyticsReportPersistence.recursiveDelete(listFiles[i]);
                i++;
            }
        }
        file.delete();
    }

    private static List<File> sortAndCombineReportFiles(List<File>... listArr) {
        int i;
        Object obj;
        Comparator lATEST_SESSION_ID_FIRST_COMPARATOR;
        i = 0;
        while (i < listArr.length) {
            Collections.sort(listArr[i], CrashlyticsReportPersistence.LATEST_SESSION_ID_FIRST_COMPARATOR);
            i++;
        }
        return CrashlyticsReportPersistence.combineReportFiles(listArr);
    }

    private static void synthesizeNativeReportFile(File file, File file2, CrashlyticsReport.FilesPayload crashlyticsReport$FilesPayload3, String string4) {
        CrashlyticsReportJsonTransform tRANSFORM;
        File obj2;
        String obj3;
        CrashlyticsReport obj4;
        String obj5;
        try {
            tRANSFORM = CrashlyticsReportPersistence.TRANSFORM;
            File file3 = new File(CrashlyticsReportPersistence.prepareDirectory(file2), string4);
            CrashlyticsReportPersistence.writeTextFile(file3, tRANSFORM.reportToJson(tRANSFORM.reportFromJson(CrashlyticsReportPersistence.readTextFile(file)).withNdkPayload(filesPayload3)));
            filesPayload3 = Logger.getLogger();
            string4 = new StringBuilder();
            string4.append("Could not synthesize final native report file for ");
            string4.append(file);
            file = string4.toString();
            filesPayload3.w(file, file2);
        }
    }

    private void synthesizeReport(File file, long l2) {
        int textFile2;
        File file3;
        Object highPriorityEventFile;
        boolean file2;
        Object eventFromJson;
        int i;
        Object textFile;
        StringBuilder stringBuilder;
        String str;
        File obj10;
        List filesInDirectory = CrashlyticsReportPersistence.getFilesInDirectory(file, CrashlyticsReportPersistence.EVENT_FILE_FILTER);
        if (filesInDirectory.isEmpty() != null) {
            StringBuilder obj12 = new StringBuilder();
            obj12.append("Session ");
            obj12.append(file.getName());
            obj12.append(" has no events.");
            Logger.getLogger().v(obj12.toString());
        }
        Collections.sort(filesInDirectory);
        ArrayList arrayList = new ArrayList();
        Iterator iterator = filesInDirectory.iterator();
        while (/* condition */) {
            while (iterator.hasNext()) {
                highPriorityEventFile = iterator.next();
                arrayList.add(CrashlyticsReportPersistence.TRANSFORM.eventFromJson(CrashlyticsReportPersistence.readTextFile((File)highPriorityEventFile)));
                if (i == 0) {
                    break loop_4;
                } else {
                }
                i = highPriorityEventFile;
                if (CrashlyticsReportPersistence.isHighPriorityEventFile(highPriorityEventFile.getName()) == null) {
                    break loop_4;
                } else {
                }
            }
            highPriorityEventFile = iterator.next();
            arrayList.add(CrashlyticsReportPersistence.TRANSFORM.eventFromJson(CrashlyticsReportPersistence.readTextFile((File)highPriorityEventFile)));
            if (i == 0) {
            } else {
            }
            i = highPriorityEventFile;
            if (CrashlyticsReportPersistence.isHighPriorityEventFile(highPriorityEventFile.getName()) != null) {
            } else {
            }
            i = i2;
            textFile = Logger.getLogger();
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not add event to report for ");
            stringBuilder.append(highPriorityEventFile);
            highPriorityEventFile = stringBuilder.toString();
            textFile.w(highPriorityEventFile, eventFromJson);
        }
        if (arrayList.isEmpty()) {
            obj12 = new StringBuilder();
            obj12.append("Could not parse event files for session ");
            obj12.append(file.getName());
            Logger.getLogger().w(obj12.toString());
        }
        textFile2 = 0;
        file3 = new File(file, "user");
        if (file3.isFile() != null) {
            textFile2 = CrashlyticsReportPersistence.readTextFile(file3);
        }
        File file4 = new File(file, "report");
        obj10 = i != 0 ? this.priorityReportsDirectory : this.reportsDirectory;
        CrashlyticsReportPersistence.synthesizeReportFile(file4, obj10, arrayList, l2, eventFromJson, i);
    }

    private static void synthesizeReportFile(File file, File file2, List<CrashlyticsReport.Session.Event> list3, long l4, boolean z5, String string6) {
        File obj2;
        String obj3;
        CrashlyticsReport obj4;
        String obj5;
        File obj6;
        try {
            final CrashlyticsReportJsonTransform tRANSFORM = CrashlyticsReportPersistence.TRANSFORM;
            obj4 = tRANSFORM.reportFromJson(CrashlyticsReportPersistence.readTextFile(file)).withSessionEndFields(l4, z5, string6).withEvents(ImmutableList.from(list3));
            obj5 = obj4.getSession();
            if (obj5 == null) {
            }
            obj6 = new File(CrashlyticsReportPersistence.prepareDirectory(file2), obj5.getIdentifier());
            CrashlyticsReportPersistence.writeTextFile(obj6, tRANSFORM.reportToJson(obj4));
            list3 = Logger.getLogger();
            l4 = new StringBuilder();
            z5 = "Could not synthesize final report file for ";
            l4.append(z5);
            l4.append(file);
            file = l4.toString();
            list3.w(file, file2);
        }
    }

    private static int trimEvents(File file, int i2) {
        List obj1 = CrashlyticsReportPersistence.getFilesInDirectory(file, b.a);
        Collections.sort(obj1, e.a);
        return CrashlyticsReportPersistence.capFilesCount(obj1, i2);
    }

    private static void writeTextFile(File file, String string2) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, CrashlyticsReportPersistence.UTF_8);
        outputStreamWriter.write(string2);
        outputStreamWriter.close();
    }

    private static void writeTextFile(File file, String string2, long l3) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, CrashlyticsReportPersistence.UTF_8);
        outputStreamWriter.write(string2);
        file.setLastModified(CrashlyticsReportPersistence.convertTimestampFromSecondsToMs(l3));
        outputStreamWriter.close();
    }

    public void deleteAllReports() {
        Object next;
        Iterator iterator = getAllFinalizedReportFiles().iterator();
        for (File next : iterator) {
            next.delete();
        }
    }

    public void deleteFinalizedReport(String string) {
        List filesInDirectory;
        c cVar = new c(string);
        List[] obj4 = new List[3];
        obj4 = CrashlyticsReportPersistence.combineReportFiles(CrashlyticsReportPersistence.getFilesInDirectory(this.priorityReportsDirectory, cVar), CrashlyticsReportPersistence.getFilesInDirectory(this.nativeReportsDirectory, cVar), CrashlyticsReportPersistence.getFilesInDirectory(this.reportsDirectory, cVar)).iterator();
        for (File filesInDirectory : obj4) {
            filesInDirectory.delete();
        }
    }

    public void finalizeReports(String string, long l2) {
        Object next;
        Logger logger;
        String string2;
        String name;
        Iterator obj5 = capAndGetOpenSessions(string).iterator();
        for (File next : obj5) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Finalizing report for session ");
            stringBuilder.append(next.getName());
            Logger.getLogger().v(stringBuilder.toString());
            synthesizeReport(next, l2);
            CrashlyticsReportPersistence.recursiveDelete(next);
        }
        capFinalizedReports();
    }

    public void finalizeSessionWithNativeEvent(String string, CrashlyticsReport.FilesPayload crashlyticsReport$FilesPayload2) {
        File file = new File(getSessionDirectoryById(string), "report");
        CrashlyticsReportPersistence.synthesizeNativeReportFile(file, this.nativeReportsDirectory, filesPayload2, string);
    }

    public long getStartTimestampMillis(String string) {
        File file = new File(getSessionDirectoryById(string), "start-time");
        return file.lastModified();
    }

    public boolean hasFinalizedReports() {
        return empty ^= 1;
    }

    public List<String> listSortedOpenSessionIds() {
        String name;
        List allFilesInDirectory = CrashlyticsReportPersistence.getAllFilesInDirectory(this.openSessionsDirectory);
        Collections.sort(allFilesInDirectory, CrashlyticsReportPersistence.LATEST_SESSION_ID_FIRST_COMPARATOR);
        ArrayList arrayList = new ArrayList();
        Iterator iterator = allFilesInDirectory.iterator();
        for (File next2 : iterator) {
            arrayList.add(next2.getName());
        }
        return arrayList;
    }

    public List<CrashlyticsReportWithSessionId> loadFinalizedReports() {
        Object next;
        Object create;
        Object logger;
        StringBuilder string;
        String str;
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(getAllFinalizedReportFiles().size());
        Iterator iterator = getAllFinalizedReportFiles().iterator();
        for (File next : iterator) {
            arrayList.add(CrashlyticsReportWithSessionId.create(CrashlyticsReportPersistence.TRANSFORM.reportFromJson(CrashlyticsReportPersistence.readTextFile(next)), next.getName()));
        }
        return arrayList;
    }

    public void persistEvent(CrashlyticsReport.Session.Event crashlyticsReport$Session$Event, String string2) {
        persistEvent(event, string2, false);
    }

    public void persistEvent(CrashlyticsReport.Session.Event crashlyticsReport$Session$Event, String string2, boolean z3) {
        File file;
        String str;
        String obj5;
        String obj6;
        String obj7;
        final File sessionDirectoryById = getSessionDirectoryById(string2);
        file = new File(sessionDirectoryById, CrashlyticsReportPersistence.generateEventFilename(this.eventCounter.getAndIncrement(), z3));
        CrashlyticsReportPersistence.writeTextFile(file, CrashlyticsReportPersistence.TRANSFORM.eventToJson(event));
        CrashlyticsReportPersistence.trimEvents(sessionDirectoryById, sessionData.maxCustomExceptionEvents);
    }

    public void persistReport(CrashlyticsReport crashlyticsReport) {
        CrashlyticsReport.Session session;
        String identifier;
        String str;
        long startedAt;
        File obj6;
        session = crashlyticsReport.getSession();
        if (session == null) {
            Logger.getLogger().d("Could not get session for report");
        }
        File prepareDirectory = CrashlyticsReportPersistence.prepareDirectory(getSessionDirectoryById(session.getIdentifier()));
        final String str5 = "report";
        File file = new File(prepareDirectory, str5);
        CrashlyticsReportPersistence.writeTextFile(file, CrashlyticsReportPersistence.TRANSFORM.reportToJson(crashlyticsReport));
        obj6 = new File(prepareDirectory, "start-time");
        CrashlyticsReportPersistence.writeTextFile(obj6, "", session.getStartedAt());
    }

    public void persistUserIdForSession(String string, String string2) {
        File sessionDirectoryById;
        File file;
        String str;
        String obj4;
        String obj5;
        file = new File(getSessionDirectoryById(string2), "user");
        CrashlyticsReportPersistence.writeTextFile(file, string);
    }
}

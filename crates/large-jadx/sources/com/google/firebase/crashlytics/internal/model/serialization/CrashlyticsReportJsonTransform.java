package com.google.firebase.crashlytics.internal.model.serialization;

import android.accounts.Account;
import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import android.util.JsonReader;
import com.google.android.exoplayer2.l2.v.e0.d;
import com.google.firebase.abt.R.styleable;
import com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User.Builder;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.revenuecat.purchases.R.id;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CrashlyticsReportJsonTransform {

    private static final DataEncoder CRASHLYTICS_REPORT_JSON_ENCODER;

    private interface ObjectParser {
        public abstract T parse(JsonReader jsonReader);
    }
    static {
        JsonDataEncoderBuilder jsonDataEncoderBuilder = new JsonDataEncoderBuilder();
        CrashlyticsReportJsonTransform.CRASHLYTICS_REPORT_JSON_ENCODER = jsonDataEncoderBuilder.configureWith(AutoCrashlyticsReportEncoder.CONFIG).ignoreNullValues(true).build();
    }

    public static CrashlyticsReport.Session.Event a(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseEvent(jsonReader);
    }

    public static CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame b(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseEventFrame(jsonReader);
    }

    public static CrashlyticsReport.Session.Event.Application.Execution.Thread c(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseEventThread(jsonReader);
    }

    public static CrashlyticsReport.FilesPayload.File d(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseFile(jsonReader);
    }

    public static CrashlyticsReport.Session.Event.Application.Execution.BinaryImage e(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseEventBinaryImage(jsonReader);
    }

    public static CrashlyticsReport.CustomAttribute f(JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.parseCustomAttribute(jsonReader);
    }

    private static CrashlyticsReport.Session.Application parseApp(JsonReader jsonReader) {
        String nextString;
        int i;
        int str;
        final CrashlyticsReport.Session.Application.Builder builder = CrashlyticsReport.Session.Application.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            nextString = jsonReader.nextName();
            nextString.hashCode();
            i = -1;
            jsonReader.skipValue();
            builder.setDisplayVersion(jsonReader.nextString());
            builder.setInstallationUuid(jsonReader.nextString());
            builder.setVersion(jsonReader.nextString());
            builder.setDevelopmentPlatformVersion(jsonReader.nextString());
            builder.setDevelopmentPlatform(jsonReader.nextString());
            builder.setIdentifier(jsonReader.nextString());
            if (!nextString.equals("displayVersion")) {
            } else {
            }
            i = 5;
            if (!nextString.equals("installationUuid")) {
            } else {
            }
            i = 4;
            if (!nextString.equals("version")) {
            } else {
            }
            i = 3;
            if (!nextString.equals("developmentPlatformVersion")) {
            } else {
            }
            i = 2;
            if (!nextString.equals("developmentPlatform")) {
            } else {
            }
            i = 1;
            if (!nextString.equals("identifier")) {
            } else {
            }
            i = 0;
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.ApplicationExitInfo parseAppExitInfo(JsonReader jsonReader) {
        String nextString;
        int i2;
        String str;
        final CrashlyticsReport.ApplicationExitInfo.Builder builder = CrashlyticsReport.ApplicationExitInfo.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            nextString = jsonReader.nextName();
            nextString.hashCode();
            i2 = -1;
            jsonReader.skipValue();
            builder.setImportance(jsonReader.nextInt());
            builder.setTraceFile(jsonReader.nextString());
            builder.setReasonCode(jsonReader.nextInt());
            builder.setProcessName(jsonReader.nextString());
            builder.setTimestamp(jsonReader.nextLong());
            builder.setRss(jsonReader.nextLong());
            builder.setPss(jsonReader.nextLong());
            builder.setPid(jsonReader.nextInt());
            if (!nextString.equals("importance")) {
            } else {
            }
            i2 = 7;
            if (nextString.equals("traceFile") == null) {
            } else {
            }
            i2 = 6;
            if (!nextString.equals("reasonCode")) {
            } else {
            }
            i2 = 5;
            if (!nextString.equals("processName")) {
            } else {
            }
            i2 = 4;
            if (!nextString.equals("timestamp")) {
            } else {
            }
            i2 = 3;
            if (!nextString.equals("rss")) {
            } else {
            }
            i2 = 2;
            if (!nextString.equals("pss")) {
            } else {
            }
            i2 = 1;
            if (!nextString.equals("pid")) {
            } else {
            }
            i2 = 0;
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static <T> ImmutableList<T> parseArray(JsonReader jsonReader, com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser<T> crashlyticsReportJsonTransform$ObjectParser2) {
        Object parse;
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(objectParser2.parse(jsonReader));
        }
        jsonReader.endArray();
        return ImmutableList.from(arrayList);
    }

    private static CrashlyticsReport.CustomAttribute parseCustomAttribute(JsonReader jsonReader) {
        String nextString;
        String equals;
        final CrashlyticsReport.CustomAttribute.Builder builder = CrashlyticsReport.CustomAttribute.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("key")) {
            } else {
            }
            builder.setKey(jsonReader.nextString());
            if (!nextName.equals("value")) {
            } else {
            }
            builder.setValue(jsonReader.nextString());
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Device parseDevice(JsonReader jsonReader) {
        int nextBoolean;
        int i;
        int str;
        final CrashlyticsReport.Session.Device.Builder builder = CrashlyticsReport.Session.Device.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            nextBoolean = jsonReader.nextName();
            nextBoolean.hashCode();
            i = -1;
            jsonReader.skipValue();
            builder.setModelClass(jsonReader.nextString());
            builder.setState(jsonReader.nextInt());
            builder.setModel(jsonReader.nextString());
            builder.setCores(jsonReader.nextInt());
            builder.setDiskSpace(jsonReader.nextLong());
            builder.setArch(jsonReader.nextInt());
            builder.setRam(jsonReader.nextLong());
            builder.setManufacturer(jsonReader.nextString());
            builder.setSimulator(jsonReader.nextBoolean());
            if (!nextBoolean.equals("modelClass")) {
            } else {
            }
            i = 8;
            if (!nextBoolean.equals("state")) {
            } else {
            }
            i = 7;
            if (!nextBoolean.equals("model")) {
            } else {
            }
            i = 6;
            if (!nextBoolean.equals("cores")) {
            } else {
            }
            i = 5;
            if (!nextBoolean.equals("diskSpace")) {
            } else {
            }
            i = 4;
            if (!nextBoolean.equals("arch")) {
            } else {
            }
            i = 3;
            if (!nextBoolean.equals("ram")) {
            } else {
            }
            i = 2;
            if (!nextBoolean.equals("manufacturer")) {
            } else {
            }
            i = 1;
            if (!nextBoolean.equals("simulator")) {
            } else {
            }
            i = 0;
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event parseEvent(JsonReader jsonReader) {
        String eventDevice;
        int i;
        int str;
        final CrashlyticsReport.Session.Event.Builder builder = CrashlyticsReport.Session.Event.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            eventDevice = jsonReader.nextName();
            eventDevice.hashCode();
            i = -1;
            jsonReader.skipValue();
            builder.setTimestamp(jsonReader.nextLong());
            builder.setType(jsonReader.nextString());
            builder.setLog(CrashlyticsReportJsonTransform.parseEventLog(jsonReader));
            builder.setApp(CrashlyticsReportJsonTransform.parseEventApp(jsonReader));
            builder.setDevice(CrashlyticsReportJsonTransform.parseEventDevice(jsonReader));
            if (!eventDevice.equals("timestamp")) {
            } else {
            }
            i = 4;
            if (!eventDevice.equals("type")) {
            } else {
            }
            i = 3;
            if (!eventDevice.equals("log")) {
            } else {
            }
            i = 2;
            if (!eventDevice.equals("app")) {
            } else {
            }
            i = 1;
            if (!eventDevice.equals("device")) {
            } else {
            }
            i = 0;
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application parseEventApp(JsonReader jsonReader) {
        ImmutableList eventExecution;
        int i;
        int str;
        final CrashlyticsReport.Session.Event.Application.Builder builder = CrashlyticsReport.Session.Event.Application.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            eventExecution = jsonReader.nextName();
            eventExecution.hashCode();
            i = -1;
            jsonReader.skipValue();
            builder.setUiOrientation(jsonReader.nextInt());
            builder.setCustomAttributes(CrashlyticsReportJsonTransform.parseArray(jsonReader, f.a));
            builder.setInternalKeys(CrashlyticsReportJsonTransform.parseArray(jsonReader, f.a));
            builder.setExecution(CrashlyticsReportJsonTransform.parseEventExecution(jsonReader));
            builder.setBackground(Boolean.valueOf(jsonReader.nextBoolean()));
            if (!eventExecution.equals("uiOrientation")) {
            } else {
            }
            i = 4;
            if (!eventExecution.equals("customAttributes")) {
            } else {
            }
            i = 3;
            if (!eventExecution.equals("internalKeys")) {
            } else {
            }
            i = 2;
            if (!eventExecution.equals("execution")) {
            } else {
            }
            i = 1;
            if (!eventExecution.equals("background")) {
            } else {
            }
            i = 0;
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application.Execution.BinaryImage parseEventBinaryImage(JsonReader jsonReader) {
        String nextString;
        int i;
        int str;
        int i2;
        final CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            nextString = jsonReader.nextName();
            nextString.hashCode();
            i = -1;
            i2 = 2;
            jsonReader.skipValue();
            builder.setBaseAddress(jsonReader.nextLong());
            builder.setUuidFromUtf8Bytes(Base64.decode(jsonReader.nextString(), i2));
            builder.setSize(jsonReader.nextLong());
            builder.setName(jsonReader.nextString());
            if (!nextString.equals("baseAddress")) {
            } else {
            }
            i = 3;
            if (!nextString.equals("uuid")) {
            } else {
            }
            i = i2;
            if (!nextString.equals("size")) {
            } else {
            }
            i = 1;
            if (!nextString.equals("name")) {
            } else {
            }
            i = 0;
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Device parseEventDevice(JsonReader jsonReader) {
        long nextBoolean;
        int i;
        int str;
        final CrashlyticsReport.Session.Event.Device.Builder builder = CrashlyticsReport.Session.Event.Device.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            nextBoolean = jsonReader.nextName();
            nextBoolean.hashCode();
            i = -1;
            jsonReader.skipValue();
            builder.setProximityOn(jsonReader.nextBoolean());
            builder.setRamUsed(jsonReader.nextLong());
            builder.setDiskUsed(jsonReader.nextLong());
            builder.setOrientation(jsonReader.nextInt());
            builder.setBatteryVelocity(jsonReader.nextInt());
            builder.setBatteryLevel(Double.valueOf(jsonReader.nextDouble()));
            if (!nextBoolean.equals("proximityOn")) {
            } else {
            }
            i = 5;
            if (!nextBoolean.equals("ramUsed")) {
            } else {
            }
            i = 4;
            if (!nextBoolean.equals("diskUsed")) {
            } else {
            }
            i = 3;
            if (!nextBoolean.equals("orientation")) {
            } else {
            }
            i = 2;
            if (!nextBoolean.equals("batteryVelocity")) {
            } else {
            }
            i = 1;
            if (!nextBoolean.equals("batteryLevel")) {
            } else {
            }
            i = 0;
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application.Execution parseEventExecution(JsonReader jsonReader) {
        Object eventExecutionException;
        int i;
        int str;
        final CrashlyticsReport.Session.Event.Application.Execution.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            eventExecutionException = jsonReader.nextName();
            eventExecutionException.hashCode();
            i = -1;
            jsonReader.skipValue();
            builder.setException(CrashlyticsReportJsonTransform.parseEventExecutionException(jsonReader));
            builder.setBinaries(CrashlyticsReportJsonTransform.parseArray(jsonReader, e.a));
            builder.setSignal(CrashlyticsReportJsonTransform.parseEventSignal(jsonReader));
            builder.setThreads(CrashlyticsReportJsonTransform.parseArray(jsonReader, c.a));
            builder.setAppExitInfo(CrashlyticsReportJsonTransform.parseAppExitInfo(jsonReader));
            if (!eventExecutionException.equals("exception")) {
            } else {
            }
            i = 4;
            if (!eventExecutionException.equals("binaries")) {
            } else {
            }
            i = 3;
            if (!eventExecutionException.equals("signal")) {
            } else {
            }
            i = 2;
            if (!eventExecutionException.equals("threads")) {
            } else {
            }
            i = 1;
            if (!eventExecutionException.equals("appExitInfo")) {
            } else {
            }
            i = 0;
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application.Execution.Exception parseEventExecutionException(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Application.Execution.Exception eventExecutionException;
        int i;
        int str;
        final CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Exception.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            eventExecutionException = jsonReader.nextName();
            eventExecutionException.hashCode();
            i = -1;
            jsonReader.skipValue();
            builder.setOverflowCount(jsonReader.nextInt());
            builder.setCausedBy(CrashlyticsReportJsonTransform.parseEventExecutionException(jsonReader));
            builder.setType(jsonReader.nextString());
            builder.setReason(jsonReader.nextString());
            builder.setFrames(CrashlyticsReportJsonTransform.parseArray(jsonReader, b.a));
            if (!eventExecutionException.equals("overflowCount")) {
            } else {
            }
            i = 4;
            if (!eventExecutionException.equals("causedBy")) {
            } else {
            }
            i = 3;
            if (!eventExecutionException.equals("type")) {
            } else {
            }
            i = 2;
            if (!eventExecutionException.equals("reason")) {
            } else {
            }
            i = 1;
            if (!eventExecutionException.equals("frames")) {
            } else {
            }
            i = 0;
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame parseEventFrame(JsonReader jsonReader) {
        String nextString;
        int i;
        int str;
        final CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            nextString = jsonReader.nextName();
            nextString.hashCode();
            i = -1;
            jsonReader.skipValue();
            builder.setImportance(jsonReader.nextInt());
            builder.setFile(jsonReader.nextString());
            builder.setPc(jsonReader.nextLong());
            builder.setSymbol(jsonReader.nextString());
            builder.setOffset(jsonReader.nextLong());
            if (!nextString.equals("importance")) {
            } else {
            }
            i = 4;
            if (nextString.equals("file") == null) {
            } else {
            }
            i = 3;
            if (!nextString.equals("pc")) {
            } else {
            }
            i = 2;
            if (!nextString.equals("symbol")) {
            } else {
            }
            i = 1;
            if (!nextString.equals("offset")) {
            } else {
            }
            i = 0;
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Log parseEventLog(JsonReader jsonReader) {
        boolean nextString;
        String str;
        final CrashlyticsReport.Session.Event.Log.Builder builder = CrashlyticsReport.Session.Event.Log.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("content")) {
            } else {
            }
            builder.setContent(jsonReader.nextString());
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application.Execution.Signal parseEventSignal(JsonReader jsonReader) {
        String nextString;
        int i;
        int str;
        final CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Signal.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            nextString = jsonReader.nextName();
            nextString.hashCode();
            i = -1;
            jsonReader.skipValue();
            builder.setName(jsonReader.nextString());
            builder.setCode(jsonReader.nextString());
            builder.setAddress(jsonReader.nextLong());
            if (!nextString.equals("name")) {
            } else {
            }
            i = 2;
            if (!nextString.equals("code")) {
            } else {
            }
            i = 1;
            if (!nextString.equals("address")) {
            } else {
            }
            i = 0;
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application.Execution.Thread parseEventThread(JsonReader jsonReader) {
        String nextString;
        int i;
        int str;
        final CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Thread.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            nextString = jsonReader.nextName();
            nextString.hashCode();
            i = -1;
            jsonReader.skipValue();
            builder.setImportance(jsonReader.nextInt());
            builder.setName(jsonReader.nextString());
            builder.setFrames(CrashlyticsReportJsonTransform.parseArray(jsonReader, b.a));
            if (!nextString.equals("importance")) {
            } else {
            }
            i = 2;
            if (!nextString.equals("name")) {
            } else {
            }
            i = 1;
            if (!nextString.equals("frames")) {
            } else {
            }
            i = 0;
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.FilesPayload.File parseFile(JsonReader jsonReader) {
        byte[] nextString;
        int equals;
        final CrashlyticsReport.FilesPayload.File.Builder builder = CrashlyticsReport.FilesPayload.File.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("filename") == null) {
            } else {
            }
            builder.setFilename(jsonReader.nextString());
            if (!nextName.equals("contents")) {
            } else {
            }
            builder.setContents(Base64.decode(jsonReader.nextString(), 2));
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.FilesPayload parseNdkPayload(JsonReader jsonReader) {
        String nextString;
        String equals;
        final CrashlyticsReport.FilesPayload.Builder builder = CrashlyticsReport.FilesPayload.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("files") == null) {
            } else {
            }
            builder.setFiles(CrashlyticsReportJsonTransform.parseArray(jsonReader, d.a));
            if (!nextName.equals("orgId")) {
            } else {
            }
            builder.setOrgId(jsonReader.nextString());
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.OperatingSystem parseOs(JsonReader jsonReader) {
        String nextBoolean;
        int i;
        int str;
        final CrashlyticsReport.Session.OperatingSystem.Builder builder = CrashlyticsReport.Session.OperatingSystem.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            nextBoolean = jsonReader.nextName();
            nextBoolean.hashCode();
            i = -1;
            jsonReader.skipValue();
            builder.setPlatform(jsonReader.nextInt());
            builder.setVersion(jsonReader.nextString());
            builder.setJailbroken(jsonReader.nextBoolean());
            builder.setBuildVersion(jsonReader.nextString());
            if (!nextBoolean.equals("platform")) {
            } else {
            }
            i = 3;
            if (!nextBoolean.equals("version")) {
            } else {
            }
            i = 2;
            if (!nextBoolean.equals("jailbroken")) {
            } else {
            }
            i = 1;
            if (!nextBoolean.equals("buildVersion")) {
            } else {
            }
            i = 0;
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport parseReport(JsonReader jsonReader) {
        int nextString;
        int i;
        String str;
        final CrashlyticsReport.Builder builder = CrashlyticsReport.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            nextString = jsonReader.nextName();
            nextString.hashCode();
            i = -1;
            jsonReader.skipValue();
            builder.setSession(CrashlyticsReportJsonTransform.parseSession(jsonReader));
            builder.setDisplayVersion(jsonReader.nextString());
            builder.setPlatform(jsonReader.nextInt());
            builder.setInstallationUuid(jsonReader.nextString());
            builder.setGmpAppId(jsonReader.nextString());
            builder.setBuildVersion(jsonReader.nextString());
            builder.setSdkVersion(jsonReader.nextString());
            builder.setNdkPayload(CrashlyticsReportJsonTransform.parseNdkPayload(jsonReader));
            if (!nextString.equals("session")) {
            } else {
            }
            i = 7;
            if (!nextString.equals("displayVersion")) {
            } else {
            }
            i = 6;
            if (!nextString.equals("platform")) {
            } else {
            }
            i = 5;
            if (!nextString.equals("installationUuid")) {
            } else {
            }
            i = 4;
            if (!nextString.equals("gmpAppId")) {
            } else {
            }
            i = 3;
            if (!nextString.equals("buildVersion")) {
            } else {
            }
            i = 2;
            if (!nextString.equals("sdkVersion")) {
            } else {
            }
            i = 1;
            if (!nextString.equals("ndkPayload")) {
            } else {
            }
            i = 0;
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session parseSession(JsonReader jsonReader) {
        CrashlyticsReport.Session.OperatingSystem nextBoolean;
        int i;
        String str;
        int i3;
        final CrashlyticsReport.Session.Builder builder = CrashlyticsReport.Session.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            nextBoolean = jsonReader.nextName();
            nextBoolean.hashCode();
            i = -1;
            i3 = 2;
            jsonReader.skipValue();
            builder.setGeneratorType(jsonReader.nextInt());
            builder.setCrashed(jsonReader.nextBoolean());
            builder.setGenerator(jsonReader.nextString());
            builder.setUser(CrashlyticsReportJsonTransform.parseUser(jsonReader));
            builder.setApp(CrashlyticsReportJsonTransform.parseApp(jsonReader));
            builder.setOs(CrashlyticsReportJsonTransform.parseOs(jsonReader));
            builder.setEvents(CrashlyticsReportJsonTransform.parseArray(jsonReader, a.a));
            builder.setDevice(CrashlyticsReportJsonTransform.parseDevice(jsonReader));
            builder.setEndedAt(Long.valueOf(jsonReader.nextLong()));
            builder.setIdentifierFromUtf8Bytes(Base64.decode(jsonReader.nextString(), i3));
            builder.setStartedAt(jsonReader.nextLong());
            if (!nextBoolean.equals("generatorType")) {
            } else {
            }
            i = 10;
            if (!nextBoolean.equals("crashed")) {
            } else {
            }
            i = 9;
            if (!nextBoolean.equals("generator")) {
            } else {
            }
            i = 8;
            if (!nextBoolean.equals("user")) {
            } else {
            }
            i = 7;
            if (!nextBoolean.equals("app")) {
            } else {
            }
            i = 6;
            if (!nextBoolean.equals("os")) {
            } else {
            }
            i = 5;
            if (!nextBoolean.equals("events")) {
            } else {
            }
            i = 4;
            if (!nextBoolean.equals("device")) {
            } else {
            }
            i = 3;
            if (!nextBoolean.equals("endedAt")) {
            } else {
            }
            i = i3;
            if (!nextBoolean.equals("identifier")) {
            } else {
            }
            i = 1;
            if (!nextBoolean.equals("startedAt")) {
            } else {
            }
            i = 0;
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.User parseUser(JsonReader jsonReader) {
        boolean nextString;
        String str;
        final CrashlyticsReport.Session.User.Builder builder = CrashlyticsReport.Session.User.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("identifier")) {
            } else {
            }
            builder.setIdentifier(jsonReader.nextString());
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return builder.build();
    }

    public CrashlyticsReport.ApplicationExitInfo applicationExitInfoFromJson(String string) {
        try {
            StringReader stringReader = new StringReader(string);
            JsonReader jsonReader = new JsonReader(stringReader);
            jsonReader.close();
            return CrashlyticsReportJsonTransform.parseAppExitInfo(jsonReader);
            iOException.close();
            string.addSuppressed(iOException);
            throw string;
            IOException iOException = new IOException(string);
            throw iOException;
        } catch (Throwable th) {
        }
    }

    public String applicationExitInfoToJson(CrashlyticsReport.ApplicationExitInfo crashlyticsReport$ApplicationExitInfo) {
        return CrashlyticsReportJsonTransform.CRASHLYTICS_REPORT_JSON_ENCODER.encode(applicationExitInfo);
    }

    public CrashlyticsReport.Session.Event eventFromJson(String string) {
        try {
            StringReader stringReader = new StringReader(string);
            JsonReader jsonReader = new JsonReader(stringReader);
            jsonReader.close();
            return CrashlyticsReportJsonTransform.parseEvent(jsonReader);
            iOException.close();
            string.addSuppressed(iOException);
            throw string;
            IOException iOException = new IOException(string);
            throw iOException;
        } catch (Throwable th) {
        }
    }

    public String eventToJson(CrashlyticsReport.Session.Event crashlyticsReport$Session$Event) {
        return CrashlyticsReportJsonTransform.CRASHLYTICS_REPORT_JSON_ENCODER.encode(event);
    }

    public CrashlyticsReport reportFromJson(String string) {
        try {
            StringReader stringReader = new StringReader(string);
            JsonReader jsonReader = new JsonReader(stringReader);
            jsonReader.close();
            return CrashlyticsReportJsonTransform.parseReport(jsonReader);
            iOException.close();
            string.addSuppressed(iOException);
            throw string;
            IOException iOException = new IOException(string);
            throw iOException;
        } catch (Throwable th) {
        }
    }

    public String reportToJson(CrashlyticsReport crashlyticsReport) {
        return CrashlyticsReportJsonTransform.CRASHLYTICS_REPORT_JSON_ENCODER.encode(crashlyticsReport);
    }
}

package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import com.google.android.datatransport.cct.c;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import f.c.a.b.b;
import f.c.a.b.c;
import f.c.a.b.e;
import f.c.a.b.f;
import f.c.a.b.g;
import f.c.a.b.i.t;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public class DataTransportCrashlyticsReportSender {

    private static final String CRASHLYTICS_API_KEY = null;
    private static final String CRASHLYTICS_ENDPOINT = null;
    private static final String CRASHLYTICS_TRANSPORT_NAME = "FIREBASE_CRASHLYTICS_REPORT";
    private static final e<CrashlyticsReport, byte[]> DEFAULT_TRANSFORM;
    private static final CrashlyticsReportJsonTransform TRANSFORM;
    private final f<CrashlyticsReport> transport;
    private final e<CrashlyticsReport, byte[]> transportTransform;
    static {
        CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = new CrashlyticsReportJsonTransform();
        DataTransportCrashlyticsReportSender.TRANSFORM = crashlyticsReportJsonTransform;
        DataTransportCrashlyticsReportSender.CRASHLYTICS_ENDPOINT = DataTransportCrashlyticsReportSender.mergeStrings("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
        DataTransportCrashlyticsReportSender.CRASHLYTICS_API_KEY = DataTransportCrashlyticsReportSender.mergeStrings("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
        DataTransportCrashlyticsReportSender.DEFAULT_TRANSFORM = a.a;
    }

    DataTransportCrashlyticsReportSender(f<CrashlyticsReport> f, e<CrashlyticsReport, byte[]> e2) {
        super();
        this.transport = f;
        this.transportTransform = e2;
    }

    static void a(k k, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId2, Exception exception3) {
        if (exception3 != null) {
            k.d(exception3);
        }
        k.e(crashlyticsReportWithSessionId2);
    }

    static byte[] b(CrashlyticsReport crashlyticsReport) {
        return DataTransportCrashlyticsReportSender.TRANSFORM.reportToJson(crashlyticsReport).getBytes(Charset.forName("UTF-8"));
    }

    public static com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender create(Context context) {
        t.f(context);
        c cVar = new c(DataTransportCrashlyticsReportSender.CRASHLYTICS_ENDPOINT, DataTransportCrashlyticsReportSender.CRASHLYTICS_API_KEY);
        e dEFAULT_TRANSFORM = DataTransportCrashlyticsReportSender.DEFAULT_TRANSFORM;
        DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender = new DataTransportCrashlyticsReportSender(t.c().g(cVar).b("FIREBASE_CRASHLYTICS_REPORT", CrashlyticsReport.class, b.b("json"), dEFAULT_TRANSFORM), dEFAULT_TRANSFORM);
        return dataTransportCrashlyticsReportSender;
    }

    private static String mergeStrings(String string, String string2) {
        int i;
        int length;
        int charAt;
        length2 -= length;
        if (i2 < 0) {
        } else {
            if (i2 > 1) {
            } else {
                StringBuilder stringBuilder = new StringBuilder(length3 += charAt);
                i = 0;
                while (i < string.length()) {
                    stringBuilder.append(string.charAt(i));
                    if (string2.length() > i) {
                    }
                    i++;
                    stringBuilder.append(string2.charAt(i));
                }
                return stringBuilder.toString();
            }
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("Invalid input received");
        throw obj3;
    }

    public j<CrashlyticsReportWithSessionId> sendReport(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        k kVar = new k();
        b bVar = new b(kVar, crashlyticsReportWithSessionId);
        this.transport.b(c.f(crashlyticsReportWithSessionId.getReport()), bVar);
        return kVar.a();
    }
}

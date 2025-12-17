package com.google.firebase.inappmessaging.internal;

import com.google.firebase.abt.AbtExperimentInfo;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.protobuf.z;
import f.c.f.a.a.a.b;
import f.c.f.a.a.a.c;
import f.c.f.a.a.a.c.c;
import f.c.f.a.a.a.e.e;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class AbtIntegrationHelper {

    private final FirebaseABTesting abTesting;
    Executor executor;
    public AbtIntegrationHelper(FirebaseABTesting firebaseABTesting) {
        super();
        this.executor = Executors.newSingleThreadExecutor();
        this.abTesting = firebaseABTesting;
    }

    private void a(ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload) {
        FirebaseABTesting abTesting;
        AbtExperimentInfo abtExperimentInfo;
        Throwable obj12;
        try {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Updating active experiment: ");
            stringBuilder2.append(experimentPayload.toString());
            Logging.logd(stringBuilder2.toString());
            Date date = new Date(experimentPayload.getExperimentStartTimeMillis(), obj7);
            super(experimentPayload.getExperimentId(), experimentPayload.getVariantId(), experimentPayload.getTriggerEvent(), date, experimentPayload.getTriggerTimeoutMillis(), obj7, experimentPayload.getTimeToLiveMillis(), obj9);
            this.abTesting.reportActiveExperiment(abtExperimentInfo2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to set experiment as active with ABT, missing analytics?\n");
            experimentPayload = experimentPayload.getMessage();
            stringBuilder.append(experimentPayload);
            experimentPayload = stringBuilder.toString();
            Logging.loge(experimentPayload);
        }
    }

    private void c(ArrayList arrayList) {
        FirebaseABTesting abTesting;
        String str;
        List obj3;
        try {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Updating running experiments with: ");
            stringBuilder2.append(arrayList.size());
            stringBuilder2.append(" experiments");
            Logging.logd(stringBuilder2.toString());
            this.abTesting.validateRunningExperiments(arrayList);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to register experiments with ABT, missing analytics?\n");
            arrayList = arrayList.getMessage();
            stringBuilder.append(arrayList);
            arrayList = stringBuilder.toString();
            Logging.loge(arrayList);
        }
    }

    public void b(ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload) {
        a(experimentPayload);
    }

    public void d(ArrayList arrayList) {
        c(arrayList);
    }

    void setExperimentActive(ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload) {
        c cVar = new c(this, experimentPayload);
        this.executor.execute(cVar);
    }

    void updateRunningExperiments(e e) {
        Object next;
        boolean equals;
        Object eXPERIMENTAL_PAYLOAD;
        String variantId;
        String triggerEvent;
        Date date;
        long triggerTimeoutMillis;
        long timeToLiveMillis;
        AbtExperimentInfo abtExperimentInfo;
        ArrayList arrayList = new ArrayList();
        Iterator obj13 = e.f().iterator();
        while (obj13.hasNext()) {
            next = obj13.next();
            if (!(c)next.e() && next.f().equals(c.c.EXPERIMENTAL_PAYLOAD)) {
            }
            if (next.f().equals(c.c.EXPERIMENTAL_PAYLOAD)) {
            }
            next = next.d().g();
            date = new Date(next.getExperimentStartTimeMillis(), obj8);
            super(next.getExperimentId(), next.getVariantId(), next.getTriggerEvent(), date, next.getTriggerTimeoutMillis(), obj8, next.getTimeToLiveMillis(), obj10);
            arrayList.add(abtExperimentInfo);
        }
        if (arrayList.isEmpty()) {
        }
        b bVar2 = new b(this, arrayList);
        this.executor.execute(bVar2);
    }
}

package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class InstrHttpInputStream extends InputStream {

    private long bytesRead = -1;
    private final InputStream inputStream;
    private final NetworkRequestMetricBuilder networkMetricBuilder;
    private long timeToResponseInitiated;
    private long timeToResponseLastRead = -1;
    private final Timer timer;
    public InstrHttpInputStream(InputStream inputStream, NetworkRequestMetricBuilder networkRequestMetricBuilder2, Timer timer3) {
        super();
        final int i = -1;
        this.timer = timer3;
        this.inputStream = inputStream;
        this.networkMetricBuilder = networkRequestMetricBuilder2;
        this.timeToResponseInitiated = networkRequestMetricBuilder2.getTimeToResponseInitiatedMicros();
    }

    @Override // java.io.InputStream
    public int available() {
        try {
            return this.inputStream.available();
            NetworkRequestMetricBuilder networkMetricBuilder = this.networkMetricBuilder;
            Timer durationMicros = this.timer;
            durationMicros = durationMicros.getDurationMicros();
            networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
            networkMetricBuilder = this.networkMetricBuilder;
            NetworkRequestMetricBuilderUtil.logError(networkMetricBuilder);
            throw th;
        }
    }

    @Override // java.io.InputStream
    public void close() {
        int networkMetricBuilder;
        int networkMetricBuilder2;
        final int i = -1;
        if (Long.compare(timeToResponseLastRead2, i) == 0) {
            this.timeToResponseLastRead = this.timer.getDurationMicros();
        }
        this.inputStream.close();
        long bytesRead = this.bytesRead;
        if (Long.compare(bytesRead, i) != 0) {
            this.networkMetricBuilder.setResponsePayloadBytes(bytesRead);
        }
        long timeToResponseInitiated = this.timeToResponseInitiated;
        if (Long.compare(timeToResponseInitiated, i) != 0) {
            this.networkMetricBuilder.setTimeToResponseInitiatedMicros(timeToResponseInitiated);
        }
        this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timeToResponseLastRead);
        this.networkMetricBuilder.build();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.inputStream.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.inputStream.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        NetworkRequestMetricBuilder networkMetricBuilder;
        int cmp;
        NetworkRequestMetricBuilder networkMetricBuilder2;
        try {
            int read = this.inputStream.read();
            long durationMicros = this.timer.getDurationMicros();
            final int i2 = -1;
            if (Long.compare(timeToResponseInitiated, i2) == 0) {
            }
            this.timeToResponseInitiated = durationMicros;
            if (read == -1 && Long.compare(timeToResponseLastRead, i2) == 0) {
            } else {
            }
            if (Long.compare(timeToResponseLastRead, i2) == 0) {
            } else {
            }
            this.timeToResponseLastRead = durationMicros;
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
            this.networkMetricBuilder.build();
            bytesRead += i;
            this.bytesRead = networkMetricBuilder;
            this.networkMetricBuilder.setResponsePayloadBytes(networkMetricBuilder);
            return read;
            NetworkRequestMetricBuilder networkMetricBuilder3 = this.networkMetricBuilder;
            Timer durationMicros2 = this.timer;
            durationMicros2 = durationMicros2.getDurationMicros();
            networkMetricBuilder3.setTimeToResponseCompletedMicros(durationMicros2);
            networkMetricBuilder3 = this.networkMetricBuilder;
            NetworkRequestMetricBuilderUtil.logError(networkMetricBuilder3);
            throw th;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        NetworkRequestMetricBuilder networkMetricBuilder2;
        int cmp;
        NetworkRequestMetricBuilder networkMetricBuilder;
        try {
            final int obj7 = this.inputStream.read(bArr);
            long durationMicros = this.timer.getDurationMicros();
            final int i = -1;
            if (Long.compare(timeToResponseInitiated, i) == 0) {
            }
            this.timeToResponseInitiated = durationMicros;
            if (obj7 == -1 && Long.compare(timeToResponseLastRead, i) == 0) {
            } else {
            }
            if (Long.compare(timeToResponseLastRead, i) == 0) {
            } else {
            }
            this.timeToResponseLastRead = durationMicros;
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
            this.networkMetricBuilder.build();
            bytesRead += l;
            this.bytesRead = networkMetricBuilder2;
            this.networkMetricBuilder.setResponsePayloadBytes(networkMetricBuilder2);
            return obj7;
            NetworkRequestMetricBuilder networkMetricBuilder3 = this.networkMetricBuilder;
            Timer durationMicros2 = this.timer;
            durationMicros2 = durationMicros2.getDurationMicros();
            networkMetricBuilder3.setTimeToResponseCompletedMicros(durationMicros2);
            networkMetricBuilder3 = this.networkMetricBuilder;
            NetworkRequestMetricBuilderUtil.logError(networkMetricBuilder3);
            throw bArr;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        int cmp;
        NetworkRequestMetricBuilder networkMetricBuilder;
        NetworkRequestMetricBuilder obj6;
        try {
            final int obj5 = this.inputStream.read(bArr, i2, i3);
            obj6 = this.timer.getDurationMicros();
            final int i = -1;
            if (Long.compare(timeToResponseInitiated, i) == 0) {
            }
            this.timeToResponseInitiated = obj6;
            if (obj5 == -1 && Long.compare(timeToResponseLastRead, i) == 0) {
            } else {
            }
            if (Long.compare(timeToResponseLastRead, i) == 0) {
            } else {
            }
            this.timeToResponseLastRead = obj6;
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(obj6);
            this.networkMetricBuilder.build();
            obj6 += l;
            this.bytesRead = obj6;
            this.networkMetricBuilder.setResponsePayloadBytes(obj6);
            return obj5;
            i2 = this.networkMetricBuilder;
            i3 = this.timer;
            i2.setTimeToResponseCompletedMicros(i3.getDurationMicros());
            i2 = this.networkMetricBuilder;
            NetworkRequestMetricBuilderUtil.logError(i2);
            throw bArr;
        }
    }

    @Override // java.io.InputStream
    public void reset() {
        try {
            this.inputStream.reset();
            NetworkRequestMetricBuilder networkMetricBuilder = this.networkMetricBuilder;
            Timer durationMicros = this.timer;
            durationMicros = durationMicros.getDurationMicros();
            networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
            networkMetricBuilder = this.networkMetricBuilder;
            NetworkRequestMetricBuilderUtil.logError(networkMetricBuilder);
            throw th;
        }
    }

    @Override // java.io.InputStream
    public long skip(long l) {
        long durationMicros;
        int cmp;
        NetworkRequestMetricBuilder networkMetricBuilder;
        try {
            final long obj7 = this.inputStream.skip(l);
            durationMicros = this.timer.getDurationMicros();
            final int i = -1;
            if (Long.compare(timeToResponseInitiated, i) == 0) {
            }
            this.timeToResponseInitiated = durationMicros;
            if (Long.compare(obj7, i) == 0 && Long.compare(timeToResponseLastRead, i) == 0) {
            } else {
            }
            if (Long.compare(timeToResponseLastRead, i) == 0) {
            } else {
            }
            this.timeToResponseLastRead = durationMicros;
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
            bytesRead += obj7;
            this.bytesRead = durationMicros;
            this.networkMetricBuilder.setResponsePayloadBytes(durationMicros);
            return obj7;
            obj8 = this.networkMetricBuilder;
            Timer durationMicros2 = this.timer;
            durationMicros2 = durationMicros2.getDurationMicros();
            obj8.setTimeToResponseCompletedMicros(durationMicros2);
            obj8 = this.networkMetricBuilder;
            NetworkRequestMetricBuilderUtil.logError(obj8);
            throw l;
        }
    }
}

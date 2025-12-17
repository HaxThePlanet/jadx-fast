package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class InstrHttpOutputStream extends OutputStream {

    long bytesWritten = -1;
    NetworkRequestMetricBuilder networkMetricBuilder;
    private final OutputStream outputStream;
    private final Timer timer;
    public InstrHttpOutputStream(OutputStream outputStream, NetworkRequestMetricBuilder networkRequestMetricBuilder2, Timer timer3) {
        super();
        final int i = -1;
        this.outputStream = outputStream;
        this.networkMetricBuilder = networkRequestMetricBuilder2;
        this.timer = timer3;
    }

    @Override // java.io.OutputStream
    public void close() {
        int networkMetricBuilder;
        long bytesWritten = this.bytesWritten;
        if (Long.compare(bytesWritten, i) != 0) {
            this.networkMetricBuilder.setRequestPayloadBytes(bytesWritten);
        }
        this.networkMetricBuilder.setTimeToRequestCompletedMicros(this.timer.getDurationMicros());
        this.outputStream.close();
    }

    @Override // java.io.OutputStream
    public void flush() {
        try {
            this.outputStream.flush();
            NetworkRequestMetricBuilder networkMetricBuilder = this.networkMetricBuilder;
            Timer durationMicros = this.timer;
            durationMicros = durationMicros.getDurationMicros();
            networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
            networkMetricBuilder = this.networkMetricBuilder;
            NetworkRequestMetricBuilderUtil.logError(networkMetricBuilder);
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        try {
            this.outputStream.write(i);
            bytesWritten += i3;
            this.bytesWritten = i2;
            this.networkMetricBuilder.setRequestPayloadBytes(i2);
            NetworkRequestMetricBuilder networkMetricBuilder = this.networkMetricBuilder;
            Timer durationMicros = this.timer;
            durationMicros = durationMicros.getDurationMicros();
            networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
            networkMetricBuilder = this.networkMetricBuilder;
            NetworkRequestMetricBuilderUtil.logError(networkMetricBuilder);
            throw i;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        try {
            this.outputStream.write(bArr);
            bytesWritten += l;
            this.bytesWritten = i;
            this.networkMetricBuilder.setRequestPayloadBytes(i);
            NetworkRequestMetricBuilder networkMetricBuilder = this.networkMetricBuilder;
            Timer durationMicros = this.timer;
            durationMicros = durationMicros.getDurationMicros();
            networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
            networkMetricBuilder = this.networkMetricBuilder;
            NetworkRequestMetricBuilderUtil.logError(networkMetricBuilder);
            throw bArr;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        try {
            this.outputStream.write(bArr, i2, i3);
            obj3 += l;
            this.bytesWritten = obj3;
            this.networkMetricBuilder.setRequestPayloadBytes(obj3);
            i2 = this.networkMetricBuilder;
            i3 = this.timer;
            i2.setTimeToResponseCompletedMicros(i3.getDurationMicros());
            i2 = this.networkMetricBuilder;
            NetworkRequestMetricBuilderUtil.logError(i2);
            throw bArr;
        }
    }
}

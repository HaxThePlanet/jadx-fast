package com.squareup.picasso;

import java.io.PrintWriter;

/* loaded from: classes2.dex */
public class b0 {

    public final int a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final long i;
    public final long j;
    public final int k;
    public final int l;
    public final int m;
    public final long n;
    public b0(int i, int i2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, int i11, int i12, int i13, long l14) {
        final Object obj = this;
        super();
        obj.a = i;
        obj.b = i2;
        obj.c = l3;
        obj.d = l5;
        obj.e = l7;
        obj.f = l9;
        obj.g = i11;
        obj.h = i13;
        obj.i = obj18;
        obj.j = obj20;
        obj.k = obj22;
        obj.l = obj23;
        obj.m = obj24;
        obj.n = obj25;
    }

    public void a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.b);
        printWriter.print("  Cache % Full: ");
        int i11 = 1120403456;
        printWriter.println((int)ceil);
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StatsSnapshot{maxSize=");
        stringBuilder.append(this.a);
        stringBuilder.append(", size=");
        stringBuilder.append(this.b);
        stringBuilder.append(", cacheHits=");
        stringBuilder.append(this.c);
        stringBuilder.append(", cacheMisses=");
        stringBuilder.append(this.d);
        stringBuilder.append(", downloadCount=");
        stringBuilder.append(this.k);
        stringBuilder.append(", totalDownloadSize=");
        stringBuilder.append(this.e);
        stringBuilder.append(", averageDownloadSize=");
        stringBuilder.append(this.h);
        stringBuilder.append(", totalOriginalBitmapSize=");
        stringBuilder.append(this.f);
        stringBuilder.append(", totalTransformedBitmapSize=");
        stringBuilder.append(this.g);
        stringBuilder.append(", averageOriginalBitmapSize=");
        stringBuilder.append(this.i);
        stringBuilder.append(", averageTransformedBitmapSize=");
        stringBuilder.append(this.j);
        stringBuilder.append(", originalBitmapCount=");
        stringBuilder.append(this.l);
        stringBuilder.append(", transformedBitmapCount=");
        stringBuilder.append(this.m);
        stringBuilder.append(", timeStamp=");
        stringBuilder.append(this.n);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

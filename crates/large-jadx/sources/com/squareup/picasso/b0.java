package com.squareup.picasso;

import java.io.PrintWriter;

/* compiled from: StatsSnapshot.java */
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
    public b0(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        final Object i7 = this;
        super();
        i7.a = i;
        i7.b = i2;
        i7.c = j;
        i7.d = j2;
        i7.e = j3;
        i7.f = j4;
        i7.g = j5;
        i7.h = j6;
        i7.i = j7;
        i7.j = j8;
        i7.k = i3;
        i7.l = i4;
        i7.m = i5;
        i7.n = j9;
    }

    public void a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.b);
        printWriter.print("  Cache % Full: ");
        float f5 = 100f;
        printWriter.println((int)(Math.ceil((double)(float)this.b / (float)this.a * f5)));
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
        String str2 = "StatsSnapshot{maxSize=";
        String str3 = ", size=";
        String str4 = ", cacheHits=";
        String str5 = ", cacheMisses=";
        String str6 = ", downloadCount=";
        String str7 = ", totalDownloadSize=";
        String str8 = ", averageDownloadSize=";
        String str9 = ", totalOriginalBitmapSize=";
        String str10 = ", totalTransformedBitmapSize=";
        String str11 = ", averageOriginalBitmapSize=";
        String str12 = ", averageTransformedBitmapSize=";
        String str13 = ", originalBitmapCount=";
        String str14 = ", transformedBitmapCount=";
        String str15 = ", timeStamp=";
        str = str2 + this.a + str3 + this.b + str4 + this.c + str5 + this.d + str6 + this.k + str7 + this.e + str8 + this.h + str9 + this.f + str10 + this.g + str11 + this.i + str12 + this.j + str13 + this.l + str14 + this.m + str15 + this.n + 125;
        return str;
    }
}

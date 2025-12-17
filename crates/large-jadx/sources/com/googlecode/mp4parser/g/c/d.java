package com.googlecode.mp4parser.g.c;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class d {

    public int a;
    public int b;
    public int c;
    public int[] d;
    public int[] e;
    public boolean[] f;
    public int g;
    public int h;
    public int i;
    public int j;
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("HRDParameters{cpb_cnt_minus1=");
        stringBuilder.append(this.a);
        stringBuilder.append(", bit_rate_scale=");
        stringBuilder.append(this.b);
        stringBuilder.append(", cpb_size_scale=");
        stringBuilder.append(this.c);
        stringBuilder.append(", bit_rate_value_minus1=");
        stringBuilder.append(Arrays.toString(this.d));
        stringBuilder.append(", cpb_size_value_minus1=");
        stringBuilder.append(Arrays.toString(this.e));
        stringBuilder.append(", cbr_flag=");
        stringBuilder.append(Arrays.toString(this.f));
        stringBuilder.append(", initial_cpb_removal_delay_length_minus1=");
        stringBuilder.append(this.g);
        stringBuilder.append(", cpb_removal_delay_length_minus1=");
        stringBuilder.append(this.h);
        stringBuilder.append(", dpb_output_delay_length_minus1=");
        stringBuilder.append(this.i);
        stringBuilder.append(", time_offset_length=");
        stringBuilder.append(this.j);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

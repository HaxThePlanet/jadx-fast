package com.googlecode.mp4parser.g.c;

import java.util.Arrays;

/* compiled from: HRDParameters.java */
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
        String str2 = "HRDParameters{cpb_cnt_minus1=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = ", bit_rate_scale=";
        String str4 = ", cpb_size_scale=";
        String str5 = ", bit_rate_value_minus1=";
        String str6 = Arrays.toString(this.d);
        String str7 = ", cpb_size_value_minus1=";
        String str8 = Arrays.toString(this.e);
        String str9 = ", cbr_flag=";
        String str10 = Arrays.toString(this.f);
        String str11 = ", initial_cpb_removal_delay_length_minus1=";
        String str12 = ", cpb_removal_delay_length_minus1=";
        String str13 = ", dpb_output_delay_length_minus1=";
        String str14 = ", time_offset_length=";
        str = str2 + this.a + str3 + this.b + str4 + this.c + str5 + str6 + str7 + str8 + str9 + str10 + str11 + this.g + str12 + this.h + str13 + this.i + str14 + this.j + 125;
        return str;
    }
}

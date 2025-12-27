package com.googlecode.mp4parser.g.c;

/* compiled from: VUIParameters.java */
/* loaded from: classes2.dex */
public class i {

    public boolean a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public int n;
    public int o;
    public boolean p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public d v;
    public d w;
    public i.a x;
    public a y;

    public static class a {

        public boolean a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public String toString() {
            String str2 = "BitstreamRestriction{";
            StringBuilder stringBuilder = new StringBuilder(str2);
            String str3 = "motion_vectors_over_pic_boundaries_flag=";
            String str4 = ", max_bytes_per_pic_denom=";
            String str5 = ", max_bits_per_mb_denom=";
            String str6 = ", log2_max_mv_length_horizontal=";
            String str7 = ", log2_max_mv_length_vertical=";
            String str8 = ", num_reorder_frames=";
            String str9 = ", max_dec_frame_buffering=";
            str = str2 + str3 + this.a + str4 + this.b + str5 + this.c + str6 + this.d + str7 + this.e + str8 + this.f + str9 + this.g + 125;
            return str;
        }
    }
    public String toString() {
        String str2 = "VUIParameters{\naspect_ratio_info_present_flag=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = "\n";
        String str4 = ", sar_width=";
        String str5 = ", sar_height=";
        String str6 = ", overscan_info_present_flag=";
        String str7 = ", overscan_appropriate_flag=";
        String str8 = ", video_signal_type_present_flag=";
        String str9 = ", video_format=";
        String str10 = ", video_full_range_flag=";
        String str11 = ", colour_description_present_flag=";
        String str12 = ", colour_primaries=";
        String str13 = ", transfer_characteristics=";
        String str14 = ", matrix_coefficients=";
        String str15 = ", chroma_loc_info_present_flag=";
        String str16 = ", chroma_sample_loc_type_top_field=";
        String str17 = ", chroma_sample_loc_type_bottom_field=";
        String str18 = ", timing_info_present_flag=";
        String str19 = ", num_units_in_tick=";
        String str20 = ", time_scale=";
        String str21 = ", fixed_frame_rate_flag=";
        String str22 = ", low_delay_hrd_flag=";
        String str23 = ", pic_struct_present_flag=";
        String str24 = ", nalHRDParams=";
        String str25 = ", vclHRDParams=";
        String str26 = ", bitstreamRestriction=";
        String str27 = ", aspect_ratio=";
        str = str2 + this.a + str3 + str4 + this.b + str3 + str5 + this.c + str3 + str6 + this.d + str3 + str7 + this.e + str3 + str8 + this.f + str3 + str9 + this.g + str3 + str10 + this.h + str3 + str11 + this.i + str3 + str12 + this.j + str3 + str13 + this.k + str3 + str14 + this.l + str3 + str15 + this.m + str3 + str16 + this.n + str3 + str17 + this.o + str3 + str18 + this.p + str3 + str19 + this.q + str3 + str20 + this.r + str3 + str21 + this.s + str3 + str22 + this.t + str3 + str23 + this.u + str3 + str24 + this.v + str3 + str25 + this.w + str3 + str26 + this.x + str3 + str27 + this.y + str3 + 125;
        return str;
    }
}

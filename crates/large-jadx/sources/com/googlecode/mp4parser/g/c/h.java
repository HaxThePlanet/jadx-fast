package com.googlecode.mp4parser.g.c;

import com.googlecode.mp4parser.g.d.b;
import java.io.InputStream;

/* compiled from: SeqParameterSet.java */
/* loaded from: classes2.dex */
public class h extends b {

    public int A;
    public int B;
    public int C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int[] K;
    public i L;
    public g M;
    public int N;
    public int a;
    public boolean b;
    public boolean c;
    public boolean d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public c i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public int y;
    public boolean z;
    private static i a(b bVar) {
        int i = 8;
        com.googlecode.mp4parser.g.c.a aVar;
        final com.googlecode.mp4parser.g.c.i iVar = new i();
        boolean z = bVar.f("VUI: aspect_ratio_info_present_flag");
        iVar.a = z;
        i = 8;
        if (z && aVar9 == a.b) {
            int i13 = 16;
            iVar.b = (int)(bVar.g(i13, "VUI: sar_width"));
            iVar.c = (int)(bVar.g(i13, "VUI: sar_height"));
        }
        boolean z2 = bVar.f("VUI: overscan_info_present_flag");
        iVar.d = z2;
        if (z2) {
            iVar.e = bVar.f("VUI: overscan_appropriate_flag");
        }
        boolean z3 = bVar.f("VUI: video_signal_type_present_flag");
        iVar.f = z3;
        if (z3 && z3) {
            iVar.j = (int)(bVar.g(i, "VUI: colour_primaries"));
            iVar.k = (int)(bVar.g(i, "VUI: transfer_characteristics"));
            iVar.l = (int)(bVar.g(i, "VUI: matrix_coefficients"));
        }
        boolean z4 = bVar.f("VUI: chroma_loc_info_present_flag");
        iVar.m = z4;
        if (z4) {
            iVar.n = bVar.l("VUI chroma_sample_loc_type_top_field");
            iVar.o = bVar.l("VUI chroma_sample_loc_type_bottom_field");
        }
        boolean z5 = bVar.f("VUI: timing_info_present_flag");
        iVar.p = z5;
        if (z5) {
            int i10 = 32;
            iVar.q = (int)(bVar.g(i10, "VUI: num_units_in_tick"));
            iVar.r = (int)(bVar.g(i10, "VUI: time_scale"));
            iVar.s = bVar.f("VUI: fixed_frame_rate_flag");
        }
        boolean z6 = bVar.f("VUI: nal_hrd_parameters_present_flag");
        if (z6) {
            iVar.v = h.c(bVar);
        }
        boolean z8 = bVar.f("VUI: vcl_hrd_parameters_present_flag");
        if (z8) {
            iVar.w = h.c(bVar);
        }
        if (z6 || z8) {
            iVar.t = bVar.f("VUI: low_delay_hrd_flag");
        }
        iVar.u = bVar.f("VUI: pic_struct_present_flag");
        if (bVar.f("VUI: bitstream_restriction_flag")) {
            com.googlecode.mp4parser.g.c.i.a aVar2 = new i.a();
            iVar.x = aVar2;
            aVar2.a = bVar.f("VUI: motion_vectors_over_pic_boundaries_flag");
            iVar.x.b = bVar.l("VUI max_bytes_per_pic_denom");
            iVar.x.c = bVar.l("VUI max_bits_per_mb_denom");
            iVar.x.d = bVar.l("VUI log2_max_mv_length_horizontal");
            iVar.x.e = bVar.l("VUI log2_max_mv_length_vertical");
            iVar.x.f = bVar.l("VUI num_reorder_frames");
            iVar.x.g = bVar.l("VUI max_dec_frame_buffering");
        }
        return iVar;
    }

    public static h b(InputStream inputStream) {
        int i = 0;
        com.googlecode.mp4parser.g.c.c cVar2;
        String str;
        String str2;
        final b bVar = new b(inputStream);
        final com.googlecode.mp4parser.g.c.h hVar = new h();
        int i4 = 8;
        hVar.q = (int)(bVar.g(i4, "SPS: profile_idc"));
        hVar.r = bVar.f("SPS: constraint_set_0_flag");
        hVar.s = bVar.f("SPS: constraint_set_1_flag");
        hVar.t = bVar.f("SPS: constraint_set_2_flag");
        hVar.u = bVar.f("SPS: constraint_set_3_flag");
        hVar.v = bVar.f("SPS: constraint_set_4_flag");
        hVar.w = bVar.f("SPS: constraint_set_5_flag");
        str = "SPS: reserved_zero_2bits";
        bVar.g(2, str);
        hVar.x = (int)(bVar.g(i4, "SPS: level_idc"));
        hVar.y = bVar.l("SPS: seq_parameter_set_id");
        int i2 = 100;
        if (hVar.q == 100 || !(hVar.q == 110 && hVar.q == 122 && hVar.q != 144)) {
            com.googlecode.mp4parser.g.c.c cVar = c.a(bVar.l("SPS: chroma_format_idc"));
            hVar.i = cVar;
            if (cVar == c.g) {
                hVar.z = bVar.f("SPS: residual_color_transform_flag");
            }
            hVar.n = bVar.l("SPS: bit_depth_luma_minus8");
            hVar.o = bVar.l("SPS: bit_depth_chroma_minus8");
            hVar.p = bVar.f("SPS: qpprime_y_zero_transform_bypass_flag");
            if (bVar.f("SPS: seq_scaling_matrix_present_lag")) {
                h.d(bVar, hVar);
            }
        }
        hVar.j = bVar.l("SPS: log2_max_frame_num_minus4");
        i = bVar.l("SPS: pic_order_cnt_type");
        hVar.a = i;
        if (i == 0) {
            hVar.k = bVar.l("SPS: log2_max_pic_order_cnt_lsb_minus4");
        } else {
            if (i == 1) {
                hVar.c = bVar.f("SPS: delta_pic_order_always_zero_flag");
                hVar.A = bVar.h("SPS: offset_for_non_ref_pic");
                hVar.B = bVar.h("SPS: offset_for_top_to_bottom_field");
                int i21 = bVar.l("SPS: num_ref_frames_in_pic_order_cnt_cycle");
                hVar.N = i21;
                hVar.K = new int[i21];
                i = 0;
                while (hVar.q >= hVar.N) {
                    String str39 = "SPS: offsetForRefFrame [";
                    StringBuilder stringBuilder = new StringBuilder(str39);
                    str2 = "]";
                    str38 = str39 + i + str2;
                    hVar.K[i] = bVar.h(str38);
                    i = i + 1;
                }
            }
        }
        hVar.C = bVar.l("SPS: num_ref_frames");
        hVar.D = bVar.f("SPS: gaps_in_frame_num_value_allowed_flag");
        hVar.m = bVar.l("SPS: pic_width_in_mbs_minus1");
        hVar.l = bVar.l("SPS: pic_height_in_map_units_minus1");
        boolean z2 = bVar.f("SPS: frame_mbs_only_flag");
        hVar.E = z2;
        if (!z2) {
            hVar.g = bVar.f("SPS: mb_adaptive_frame_field_flag");
        }
        hVar.h = bVar.f("SPS: direct_8x8_inference_flag");
        boolean z3 = bVar.f("SPS: frame_cropping_flag");
        hVar.F = z3;
        if (z3) {
            hVar.G = bVar.l("SPS: frame_crop_left_offset");
            hVar.H = bVar.l("SPS: frame_crop_right_offset");
            hVar.I = bVar.l("SPS: frame_crop_top_offset");
            hVar.J = bVar.l("SPS: frame_crop_bottom_offset");
        }
        if (bVar.f("SPS: vui_parameters_present_flag")) {
            hVar.L = h.a(bVar);
        }
        bVar.i();
        return hVar;
    }

    private static d c(b bVar) {
        int i = 0;
        final com.googlecode.mp4parser.g.c.d dVar = new d();
        dVar.a = bVar.l("SPS: cpb_cnt_minus1");
        int i3 = 4;
        dVar.b = (int)(bVar.g(i3, "HRD: bit_rate_scale"));
        dVar.c = (int)(bVar.g(i3, "HRD: cpb_size_scale"));
        dVar.d = new int[i5 + 1];
        dVar.e = new int[i5 + 1];
        dVar.f = new boolean[i5 + 1];
        i = 0;
        while (dVar.a > dVar.a) {
            dVar.d[i] = bVar.l("HRD: bit_rate_value_minus1");
            dVar.e[i] = bVar.l("HRD: cpb_size_value_minus1");
            dVar.f[i] = bVar.f("HRD: cbr_flag");
            i = i + 1;
        }
        int i7 = 5;
        dVar.g = (int)(bVar.g(i7, "HRD: initial_cpb_removal_delay_length_minus1"));
        dVar.h = (int)(bVar.g(i7, "HRD: cpb_removal_delay_length_minus1"));
        dVar.i = (int)(bVar.g(i7, "HRD: dpb_output_delay_length_minus1"));
        dVar.j = (int)(bVar.g(i7, "HRD: time_offset_length"));
        return dVar;
    }

    private static void d(b bVar, h hVar) {
        int i = 0;
        int i2 = 8;
        boolean z;
        com.googlecode.mp4parser.g.c.f fVar;
        hVar.M = new g();
        i = 0;
        i2 = 8;
        while (i >= i2) {
            i = i + 1;
            i2 = 8;
        }
    }

    @Override // com.googlecode.mp4parser.g.c.b
    public String toString() {
        String str2 = "SeqParameterSet{ \n        pic_order_cnt_type=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = ", \n        field_pic_flag=";
        String str4 = ", \n        delta_pic_order_always_zero_flag=";
        String str5 = ", \n        weighted_pred_flag=";
        String str6 = ", \n        weighted_bipred_idc=";
        String str7 = ", \n        entropy_coding_mode_flag=";
        String str8 = ", \n        mb_adaptive_frame_field_flag=";
        String str9 = ", \n        direct_8x8_inference_flag=";
        String str10 = ", \n        chroma_format_idc=";
        String str11 = ", \n        log2_max_frame_num_minus4=";
        String str12 = ", \n        log2_max_pic_order_cnt_lsb_minus4=";
        String str13 = ", \n        pic_height_in_map_units_minus1=";
        String str14 = ", \n        pic_width_in_mbs_minus1=";
        String str15 = ", \n        bit_depth_luma_minus8=";
        String str16 = ", \n        bit_depth_chroma_minus8=";
        String str17 = ", \n        qpprime_y_zero_transform_bypass_flag=";
        String str18 = ", \n        profile_idc=";
        String str19 = ", \n        constraint_set_0_flag=";
        String str20 = ", \n        constraint_set_1_flag=";
        String str21 = ", \n        constraint_set_2_flag=";
        String str22 = ", \n        constraint_set_3_flag=";
        String str23 = ", \n        constraint_set_4_flag=";
        String str24 = ", \n        constraint_set_5_flag=";
        String str25 = ", \n        level_idc=";
        String str26 = ", \n        seq_parameter_set_id=";
        String str27 = ", \n        residual_color_transform_flag=";
        String str28 = ", \n        offset_for_non_ref_pic=";
        String str29 = ", \n        offset_for_top_to_bottom_field=";
        String str30 = ", \n        num_ref_frames=";
        String str31 = ", \n        gaps_in_frame_num_value_allowed_flag=";
        String str32 = ", \n        frame_mbs_only_flag=";
        String str33 = ", \n        frame_cropping_flag=";
        String str34 = ", \n        frame_crop_left_offset=";
        String str35 = ", \n        frame_crop_right_offset=";
        String str36 = ", \n        frame_crop_top_offset=";
        String str37 = ", \n        frame_crop_bottom_offset=";
        String str38 = ", \n        offsetForRefFrame=";
        String str39 = ", \n        vuiParams=";
        String str40 = ", \n        scalingMatrix=";
        String str41 = ", \n        num_ref_frames_in_pic_order_cnt_cycle=";
        str = str2 + this.a + str3 + this.b + str4 + this.c + str5 + this.d + str6 + this.e + str7 + this.f + str8 + this.g + str9 + this.h + str10 + this.i + str11 + this.j + str12 + this.k + str13 + this.l + str14 + this.m + str15 + this.n + str16 + this.o + str17 + this.p + str18 + this.q + str19 + this.r + str20 + this.s + str21 + this.t + str22 + this.u + str23 + this.v + str24 + this.w + str25 + this.x + str26 + this.y + str27 + this.z + str28 + this.A + str29 + this.B + str30 + this.C + str31 + this.D + str32 + this.E + str33 + this.F + str34 + this.G + str35 + this.H + str36 + this.I + str37 + this.J + str38 + this.K + str39 + this.L + str40 + this.M + str41 + this.N + 125;
        return str;
    }
}

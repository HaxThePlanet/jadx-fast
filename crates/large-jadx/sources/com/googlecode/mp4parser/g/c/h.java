package com.googlecode.mp4parser.g.c;

import com.googlecode.mp4parser.g.d.b;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class h extends com.googlecode.mp4parser.g.c.b {

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
    public com.googlecode.mp4parser.g.c.i L;
    public com.googlecode.mp4parser.g.c.g M;
    public int N;
    public int a;
    public boolean b;
    public boolean c;
    public boolean d;
    public int e;
    public boolean f;
    public boolean g;
    public boolean h;
    public com.googlecode.mp4parser.g.c.c i;
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
    private static com.googlecode.mp4parser.g.c.i a(b b) {
        boolean z6;
        boolean z2;
        boolean z4;
        boolean z3;
        boolean z5;
        boolean z;
        boolean z7;
        int str;
        boolean str2;
        com.googlecode.mp4parser.g.c.a aVar;
        b obj5;
        i iVar = new i();
        z6 = b.f("VUI: aspect_ratio_info_present_flag");
        iVar.a = z6;
        str = 8;
        z6 = a.a((int)l5);
        iVar.y = z6;
        if (z6 && z6 == a.b) {
            z6 = a.a((int)l5);
            iVar.y = z6;
            if (z6 == a.b) {
                int i9 = 16;
                iVar.b = (int)l6;
                iVar.c = (int)aVar;
            }
        }
        z2 = b.f("VUI: overscan_info_present_flag");
        iVar.d = z2;
        if (z2) {
            iVar.e = b.f("VUI: overscan_appropriate_flag");
        }
        z4 = b.f("VUI: video_signal_type_present_flag");
        iVar.f = z4;
        iVar.g = (int)aVar;
        iVar.h = b.f("VUI: video_full_range_flag");
        z4 = b.f("VUI: colour_description_present_flag");
        iVar.i = z4;
        if (z4 && z4) {
            iVar.g = (int)aVar;
            iVar.h = b.f("VUI: video_full_range_flag");
            z4 = b.f("VUI: colour_description_present_flag");
            iVar.i = z4;
            if (z4) {
                iVar.j = (int)l4;
                iVar.k = (int)aVar;
                iVar.l = (int)l;
            }
        }
        z3 = b.f("VUI: chroma_loc_info_present_flag");
        iVar.m = z3;
        if (z3) {
            iVar.n = b.l("VUI chroma_sample_loc_type_top_field");
            iVar.o = b.l("VUI chroma_sample_loc_type_bottom_field");
        }
        z5 = b.f("VUI: timing_info_present_flag");
        iVar.p = z5;
        if (z5) {
            int i6 = 32;
            iVar.q = (int)l3;
            iVar.r = (int)l2;
            iVar.s = b.f("VUI: fixed_frame_rate_flag");
        }
        z = b.f("VUI: nal_hrd_parameters_present_flag");
        if (z) {
            iVar.v = h.c(b);
        }
        str2 = b.f("VUI: vcl_hrd_parameters_present_flag");
        if (str2 != null) {
            iVar.w = h.c(b);
        }
        if (!z) {
            if (str2 != null) {
                iVar.t = b.f("VUI: low_delay_hrd_flag");
            }
        } else {
        }
        iVar.u = b.f("VUI: pic_struct_present_flag");
        if (b.f("VUI: bitstream_restriction_flag")) {
            i.a aVar2 = new i.a();
            iVar.x = aVar2;
            aVar2.a = b.f("VUI: motion_vectors_over_pic_boundaries_flag");
            aVar3.b = b.l("VUI max_bytes_per_pic_denom");
            aVar4.c = b.l("VUI max_bits_per_mb_denom");
            aVar5.d = b.l("VUI log2_max_mv_length_horizontal");
            aVar6.e = b.l("VUI log2_max_mv_length_vertical");
            aVar7.f = b.l("VUI num_reorder_frames");
            z7.g = b.l("VUI max_dec_frame_buffering");
        }
        return iVar;
    }

    public static com.googlecode.mp4parser.g.c.h b(InputStream inputStream) {
        com.googlecode.mp4parser.g.c.c cVar;
        boolean z4;
        int i2;
        boolean z2;
        boolean z3;
        boolean z;
        int i;
        String str2;
        String str;
        b bVar = new b(inputStream);
        h obj5 = new h();
        int i3 = 8;
        obj5.q = (int)l2;
        obj5.r = bVar.f("SPS: constraint_set_0_flag");
        obj5.s = bVar.f("SPS: constraint_set_1_flag");
        obj5.t = bVar.f("SPS: constraint_set_2_flag");
        obj5.u = bVar.f("SPS: constraint_set_3_flag");
        obj5.v = bVar.f("SPS: constraint_set_4_flag");
        obj5.w = bVar.f("SPS: constraint_set_5_flag");
        bVar.g(2, "SPS: reserved_zero_2bits");
        obj5.x = (int)l;
        obj5.y = bVar.l("SPS: seq_parameter_set_id");
        int i6 = obj5.q;
        if (i6 != 100 && i6 != 110 && i6 != 122) {
            if (i6 != 110) {
                if (i6 != 122) {
                    if (i6 == 144) {
                        cVar = c.a(bVar.l("SPS: chroma_format_idc"));
                        obj5.i = cVar;
                        if (cVar == c.g) {
                            obj5.z = bVar.f("SPS: residual_color_transform_flag");
                        }
                        obj5.n = bVar.l("SPS: bit_depth_luma_minus8");
                        obj5.o = bVar.l("SPS: bit_depth_chroma_minus8");
                        obj5.p = bVar.f("SPS: qpprime_y_zero_transform_bypass_flag");
                        if (bVar.f("SPS: seq_scaling_matrix_present_lag")) {
                            h.d(bVar, obj5);
                        }
                    } else {
                        obj5.i = c.e;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        obj5.j = bVar.l("SPS: log2_max_frame_num_minus4");
        i2 = bVar.l("SPS: pic_order_cnt_type");
        obj5.a = i2;
        if (i2 == 0) {
            obj5.k = bVar.l("SPS: log2_max_pic_order_cnt_lsb_minus4");
        } else {
            if (i2 == 1) {
                obj5.c = bVar.f("SPS: delta_pic_order_always_zero_flag");
                obj5.A = bVar.h("SPS: offset_for_non_ref_pic");
                obj5.B = bVar.h("SPS: offset_for_top_to_bottom_field");
                int i19 = bVar.l("SPS: num_ref_frames_in_pic_order_cnt_cycle");
                obj5.N = i19;
                obj5.K = new int[i19];
                i2 = 0;
                while (i2 >= obj5.N) {
                    StringBuilder stringBuilder = new StringBuilder("SPS: offsetForRefFrame [");
                    stringBuilder.append(i2);
                    stringBuilder.append("]");
                    obj5.K[i2] = bVar.h(stringBuilder.toString());
                    i2++;
                }
            }
        }
        obj5.C = bVar.l("SPS: num_ref_frames");
        obj5.D = bVar.f("SPS: gaps_in_frame_num_value_allowed_flag");
        obj5.m = bVar.l("SPS: pic_width_in_mbs_minus1");
        obj5.l = bVar.l("SPS: pic_height_in_map_units_minus1");
        z2 = bVar.f("SPS: frame_mbs_only_flag");
        obj5.E = z2;
        if (!z2) {
            obj5.g = bVar.f("SPS: mb_adaptive_frame_field_flag");
        }
        obj5.h = bVar.f("SPS: direct_8x8_inference_flag");
        z3 = bVar.f("SPS: frame_cropping_flag");
        obj5.F = z3;
        if (z3) {
            obj5.G = bVar.l("SPS: frame_crop_left_offset");
            obj5.H = bVar.l("SPS: frame_crop_right_offset");
            obj5.I = bVar.l("SPS: frame_crop_top_offset");
            obj5.J = bVar.l("SPS: frame_crop_bottom_offset");
        }
        if (bVar.f("SPS: vui_parameters_present_flag")) {
            obj5.L = h.a(bVar);
        }
        bVar.i();
        return obj5;
    }

    private static com.googlecode.mp4parser.g.c.d c(b b) {
        int i;
        int[] iArr;
        boolean z;
        d dVar = new d();
        dVar.a = b.l("SPS: cpb_cnt_minus1");
        int i3 = 4;
        dVar.b = (int)l3;
        dVar.c = (int)l;
        int i5 = dVar.a;
        dVar.d = new int[i5 + 1];
        dVar.e = new int[i5 + 1];
        dVar.f = new boolean[i5++];
        i = 0;
        while (i > dVar.a) {
            dVar.d[i] = b.l("HRD: bit_rate_value_minus1");
            dVar.e[i] = b.l("HRD: cpb_size_value_minus1");
            dVar.f[i] = b.f("HRD: cbr_flag");
            i++;
        }
        int i7 = 5;
        dVar.g = (int)l4;
        dVar.h = (int)l5;
        dVar.i = (int)l6;
        dVar.j = (int)l2;
        return dVar;
    }

    private static void d(b b, com.googlecode.mp4parser.g.c.h h2) {
        int i;
        int arr;
        boolean z;
        com.googlecode.mp4parser.g.c.f arr2;
        g gVar = new g();
        h2.M = gVar;
        i = 0;
        arr = 8;
        while (i >= arr) {
            if (b.f("SPS: seqScalingListPresentFlag")) {
            }
            i++;
            arr = 8;
            com.googlecode.mp4parser.g.c.g gVar2 = h2.M;
            arr2 = new f[arr];
            gVar2.a = arr2;
            arr = new f[arr];
            gVar2.b = arr;
            if (i < 6) {
            } else {
            }
            arr[i + -6] = f.a(b, 64);
            arr2[i] = f.a(b, 16);
        }
    }

    @Override // com.googlecode.mp4parser.g.c.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SeqParameterSet{ \n        pic_order_cnt_type=");
        stringBuilder.append(this.a);
        stringBuilder.append(", \n        field_pic_flag=");
        stringBuilder.append(this.b);
        stringBuilder.append(", \n        delta_pic_order_always_zero_flag=");
        stringBuilder.append(this.c);
        stringBuilder.append(", \n        weighted_pred_flag=");
        stringBuilder.append(this.d);
        stringBuilder.append(", \n        weighted_bipred_idc=");
        stringBuilder.append(this.e);
        stringBuilder.append(", \n        entropy_coding_mode_flag=");
        stringBuilder.append(this.f);
        stringBuilder.append(", \n        mb_adaptive_frame_field_flag=");
        stringBuilder.append(this.g);
        stringBuilder.append(", \n        direct_8x8_inference_flag=");
        stringBuilder.append(this.h);
        stringBuilder.append(", \n        chroma_format_idc=");
        stringBuilder.append(this.i);
        stringBuilder.append(", \n        log2_max_frame_num_minus4=");
        stringBuilder.append(this.j);
        stringBuilder.append(", \n        log2_max_pic_order_cnt_lsb_minus4=");
        stringBuilder.append(this.k);
        stringBuilder.append(", \n        pic_height_in_map_units_minus1=");
        stringBuilder.append(this.l);
        stringBuilder.append(", \n        pic_width_in_mbs_minus1=");
        stringBuilder.append(this.m);
        stringBuilder.append(", \n        bit_depth_luma_minus8=");
        stringBuilder.append(this.n);
        stringBuilder.append(", \n        bit_depth_chroma_minus8=");
        stringBuilder.append(this.o);
        stringBuilder.append(", \n        qpprime_y_zero_transform_bypass_flag=");
        stringBuilder.append(this.p);
        stringBuilder.append(", \n        profile_idc=");
        stringBuilder.append(this.q);
        stringBuilder.append(", \n        constraint_set_0_flag=");
        stringBuilder.append(this.r);
        stringBuilder.append(", \n        constraint_set_1_flag=");
        stringBuilder.append(this.s);
        stringBuilder.append(", \n        constraint_set_2_flag=");
        stringBuilder.append(this.t);
        stringBuilder.append(", \n        constraint_set_3_flag=");
        stringBuilder.append(this.u);
        stringBuilder.append(", \n        constraint_set_4_flag=");
        stringBuilder.append(this.v);
        stringBuilder.append(", \n        constraint_set_5_flag=");
        stringBuilder.append(this.w);
        stringBuilder.append(", \n        level_idc=");
        stringBuilder.append(this.x);
        stringBuilder.append(", \n        seq_parameter_set_id=");
        stringBuilder.append(this.y);
        stringBuilder.append(", \n        residual_color_transform_flag=");
        stringBuilder.append(this.z);
        stringBuilder.append(", \n        offset_for_non_ref_pic=");
        stringBuilder.append(this.A);
        stringBuilder.append(", \n        offset_for_top_to_bottom_field=");
        stringBuilder.append(this.B);
        stringBuilder.append(", \n        num_ref_frames=");
        stringBuilder.append(this.C);
        stringBuilder.append(", \n        gaps_in_frame_num_value_allowed_flag=");
        stringBuilder.append(this.D);
        stringBuilder.append(", \n        frame_mbs_only_flag=");
        stringBuilder.append(this.E);
        stringBuilder.append(", \n        frame_cropping_flag=");
        stringBuilder.append(this.F);
        stringBuilder.append(", \n        frame_crop_left_offset=");
        stringBuilder.append(this.G);
        stringBuilder.append(", \n        frame_crop_right_offset=");
        stringBuilder.append(this.H);
        stringBuilder.append(", \n        frame_crop_top_offset=");
        stringBuilder.append(this.I);
        stringBuilder.append(", \n        frame_crop_bottom_offset=");
        stringBuilder.append(this.J);
        stringBuilder.append(", \n        offsetForRefFrame=");
        stringBuilder.append(this.K);
        stringBuilder.append(", \n        vuiParams=");
        stringBuilder.append(this.L);
        stringBuilder.append(", \n        scalingMatrix=");
        stringBuilder.append(this.M);
        stringBuilder.append(", \n        num_ref_frames_in_pic_order_cnt_cycle=");
        stringBuilder.append(this.N);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

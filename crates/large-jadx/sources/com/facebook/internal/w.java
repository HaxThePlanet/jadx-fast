package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.internal.g0.i.a;
import com.facebook.login.c;
import com.facebook.login.s;
import com.facebook.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008;\n\u0002\u0010\u0011\n\u0002\u0010\u0008\n\u0002\u00085\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u0002\n\u0002\u0008\r\u0008Ç\u0002\u0018\u00002\u00020\u0001:\u0010Ï\u0001Ð\u0001Ñ\u0001Ò\u0001Ó\u0001Ô\u0001Õ\u0001Ö\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010~\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020y0x0wH\u0002J\u000e\u0010\u007f\u001a\u0008\u0012\u0004\u0012\u00020y0xH\u0002J\u000f\u0010\u0080\u0001\u001a\u0008\u0012\u0004\u0012\u00020y0xH\u0002J\u0013\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020yH\u0002J.\u0010\u0084\u0001\u001a\u00020A2\u0010\u0010\u0085\u0001\u001a\u000b\u0012\u0004\u0012\u00020A\u0018\u00010\u0086\u00012\u0007\u0010\u0087\u0001\u001a\u00020A2\u0008\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0007J\u0018\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u00012\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0007J\u0093\u0001\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u00012\u0008\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0007\u0010\u0092\u0001\u001a\u00020\u00042\u0010\u0010\u0093\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u00042\u0008\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0008\u0010\u0098\u0001\u001a\u00030\u0097\u00012\u0008\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u00042\u0007\u0010\u009c\u0001\u001a\u00020\u00042\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u009e\u0001\u001a\u00030\u0097\u00012\u0008\u0010\u009f\u0001\u001a\u00030\u0097\u00012\u0008\u0010 \u0001\u001a\u00030\u0097\u0001H\u0007J\u0093\u0001\u0010¡\u0001\u001a\u0005\u0018\u00010\u008f\u00012\u0008\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0007\u0010\u0092\u0001\u001a\u00020\u00042\u0010\u0010\u0093\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u00042\u0008\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0008\u0010\u0098\u0001\u001a\u00030\u0097\u00012\u0008\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u00042\u0007\u0010\u009c\u0001\u001a\u00020\u00042\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u009e\u0001\u001a\u00030\u0097\u00012\u0008\u0010\u009f\u0001\u001a\u00030\u0097\u00012\u0008\u0010 \u0001\u001a\u00030\u0097\u0001H\u0007J§\u0001\u0010¢\u0001\u001a\u0005\u0018\u00010\u008f\u00012\u0007\u0010\u0083\u0001\u001a\u00020y2\u0007\u0010\u0092\u0001\u001a\u00020\u00042\u0010\u0010\u0093\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u00042\u0008\u0010\u0098\u0001\u001a\u00030\u0097\u00012\u0008\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u00042\u0007\u0010\u009c\u0001\u001a\u00020\u00042\u0008\u0010£\u0001\u001a\u00030\u0097\u00012\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u009e\u0001\u001a\u00030\u0097\u00012\u0008\u0010¤\u0001\u001a\u00030¥\u00012\u0008\u0010\u009f\u0001\u001a\u00030\u0097\u00012\u0008\u0010 \u0001\u001a\u00030\u0097\u00012\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u0004H\u0002JD\u0010§\u0001\u001a\u0005\u0018\u00010\u008f\u00012\u0008\u0010\u0090\u0001\u001a\u00030\u0091\u00012\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010©\u0001\u001a\u0004\u0018\u00010\u00042\n\u0010ª\u0001\u001a\u0005\u0018\u00010«\u00012\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0007J\u0016\u0010­\u0001\u001a\u0005\u0018\u00010\u008f\u00012\u0008\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0007J.\u0010®\u0001\u001a\u0005\u0018\u00010\u008f\u00012\u0008\u0010¯\u0001\u001a\u00030\u008f\u00012\n\u0010°\u0001\u001a\u0005\u0018\u00010\u008b\u00012\n\u0010±\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0007J®\u0001\u0010²\u0001\u001a\t\u0012\u0005\u0012\u00030\u008f\u00010x2\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u00012\u0007\u0010\u0092\u0001\u001a\u00020\u00042\u0010\u0010\u0093\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u00042\u0008\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0008\u0010\u0098\u0001\u001a\u00030\u0097\u00012\u0008\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u00042\u0007\u0010\u009c\u0001\u001a\u00020\u00042\u0008\u0010£\u0001\u001a\u00030\u0097\u00012\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u009e\u0001\u001a\u00030\u0097\u00012\u0008\u0010\u009f\u0001\u001a\u00030\u0097\u00012\u0008\u0010 \u0001\u001a\u00030\u0097\u00012\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010³\u0001\u001a\u0005\u0018\u00010\u008f\u00012\u0008\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0007J\u0019\u0010´\u0001\u001a\t\u0012\u0004\u0012\u00020A0\u0086\u00012\u0007\u0010\u0083\u0001\u001a\u00020yH\u0002J\u0016\u0010µ\u0001\u001a\u0005\u0018\u00010\u008b\u00012\u0008\u0010¶\u0001\u001a\u00030\u008f\u0001H\u0007J\u0018\u0010·\u0001\u001a\u0005\u0018\u00010¸\u00012\n\u0010¶\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0007J\u0016\u0010¹\u0001\u001a\u0005\u0018\u00010\u008b\u00012\u0008\u0010º\u0001\u001a\u00030\u008f\u0001H\u0007J\u0018\u0010»\u0001\u001a\u0005\u0018\u00010\u008d\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0007J\u001d\u0010½\u0001\u001a\u00030«\u00012\u0007\u0010©\u0001\u001a\u00020\u00042\u0008\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0007J%\u0010¾\u0001\u001a\u00030«\u00012\u000f\u0010¿\u0001\u001a\n\u0012\u0004\u0012\u00020y\u0018\u00010x2\u0008\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0002J\u0012\u0010À\u0001\u001a\u00020A2\u0007\u0010Á\u0001\u001a\u00020AH\u0007J\t\u0010Â\u0001\u001a\u00020AH\u0007J\u0016\u0010Ã\u0001\u001a\u0005\u0018\u00010\u008b\u00012\u0008\u0010¶\u0001\u001a\u00030\u008f\u0001H\u0007J\u0013\u0010Ä\u0001\u001a\u00020A2\u0008\u0010¶\u0001\u001a\u00030\u008f\u0001H\u0007J\u0016\u0010Å\u0001\u001a\u0005\u0018\u00010\u008b\u00012\u0008\u0010º\u0001\u001a\u00030\u008f\u0001H\u0007J\u0014\u0010Æ\u0001\u001a\u00030\u0097\u00012\u0008\u0010º\u0001\u001a\u00030\u008f\u0001H\u0007J\u0013\u0010Ç\u0001\u001a\u00030\u0097\u00012\u0007\u0010È\u0001\u001a\u00020AH\u0007J?\u0010É\u0001\u001a\u00030Ê\u00012\u0008\u0010¶\u0001\u001a\u00030\u008f\u00012\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010©\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010È\u0001\u001a\u00020A2\n\u0010Ë\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0007J\n\u0010Ì\u0001\u001a\u00030Ê\u0001H\u0007J-\u0010Í\u0001\u001a\u0005\u0018\u00010\u008f\u00012\u0008\u0010\u0090\u0001\u001a\u00030\u0091\u00012\n\u0010¶\u0001\u001a\u0005\u0018\u00010\u008f\u00012\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010yH\u0007J-\u0010Î\u0001\u001a\u0005\u0018\u00010\u008f\u00012\u0008\u0010\u0090\u0001\u001a\u00030\u0091\u00012\n\u0010¶\u0001\u001a\u0005\u0018\u00010\u008f\u00012\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010yH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010?\u001a\u0008\u0012\u0004\u0012\u00020A0@X\u0082\u0004¢\u0006\u0004\n\u0002\u0010BR\u000e\u0010C\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020AX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R \u0010v\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020y0x0wX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010z\u001a\u0008\u0012\u0004\u0012\u00020y0xX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010{\u001a\u0008\u0012\u0004\u0012\u00020y0xX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020}X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006×\u0001", d2 = {"Lcom/facebook/internal/NativeProtocol;", "", "()V", "ACTION_APPINVITE_DIALOG", "", "ACTION_CAMERA_EFFECT", "ACTION_FEED_DIALOG", "ACTION_LIKE_DIALOG", "ACTION_MESSAGE_DIALOG", "ACTION_OGACTIONPUBLISH_DIALOG", "ACTION_OGMESSAGEPUBLISH_DIALOG", "ACTION_SHARE_STORY", "AUDIENCE_EVERYONE", "AUDIENCE_FRIENDS", "AUDIENCE_ME", "BRIDGE_ARG_ACTION_ID_STRING", "BRIDGE_ARG_APP_NAME_STRING", "BRIDGE_ARG_ERROR_BUNDLE", "BRIDGE_ARG_ERROR_CODE", "BRIDGE_ARG_ERROR_DESCRIPTION", "BRIDGE_ARG_ERROR_JSON", "BRIDGE_ARG_ERROR_SUBCODE", "BRIDGE_ARG_ERROR_TYPE", "CONTENT_SCHEME", "ERROR_APPLICATION_ERROR", "ERROR_NETWORK_ERROR", "ERROR_PERMISSION_DENIED", "ERROR_PROTOCOL_ERROR", "ERROR_SERVICE_DISABLED", "ERROR_UNKNOWN_ERROR", "ERROR_USER_CANCELED", "EXTRA_ACCESS_TOKEN", "EXTRA_APPLICATION_ID", "EXTRA_APPLICATION_NAME", "EXTRA_AUTHENTICATION_TOKEN", "EXTRA_DATA_ACCESS_EXPIRATION_TIME", "EXTRA_DIALOG_COMPLETE_KEY", "EXTRA_DIALOG_COMPLETION_GESTURE_KEY", "EXTRA_EXPIRES_SECONDS_SINCE_EPOCH", "EXTRA_GET_INSTALL_DATA_PACKAGE", "EXTRA_GRAPH_API_VERSION", "EXTRA_LOGGER_REF", "EXTRA_NONCE", "EXTRA_PERMISSIONS", "EXTRA_PROTOCOL_ACTION", "EXTRA_PROTOCOL_BRIDGE_ARGS", "EXTRA_PROTOCOL_CALL_ID", "EXTRA_PROTOCOL_METHOD_ARGS", "EXTRA_PROTOCOL_METHOD_RESULTS", "EXTRA_PROTOCOL_VERSION", "EXTRA_PROTOCOL_VERSIONS", "EXTRA_TOAST_DURATION_MS", "EXTRA_USER_ID", "FACEBOOK_PROXY_AUTH_ACTIVITY", "FACEBOOK_PROXY_AUTH_APP_ID_KEY", "FACEBOOK_PROXY_AUTH_E2E_KEY", "FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY", "FACEBOOK_SDK_VERSION_KEY", "FACEBOOK_TOKEN_REFRESH_ACTIVITY", "IMAGE_URL_KEY", "IMAGE_USER_GENERATED_KEY", "INTENT_ACTION_PLATFORM_ACTIVITY", "INTENT_ACTION_PLATFORM_SERVICE", "KNOWN_PROTOCOL_VERSIONS", "", "", "[Ljava/lang/Integer;", "MESSAGE_GET_ACCESS_TOKEN_REPLY", "MESSAGE_GET_ACCESS_TOKEN_REQUEST", "MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY", "MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST", "MESSAGE_GET_INSTALL_DATA_REPLY", "MESSAGE_GET_INSTALL_DATA_REQUEST", "MESSAGE_GET_LIKE_STATUS_REPLY", "MESSAGE_GET_LIKE_STATUS_REQUEST", "MESSAGE_GET_LOGIN_STATUS_REPLY", "MESSAGE_GET_LOGIN_STATUS_REQUEST", "MESSAGE_GET_PROTOCOL_VERSIONS_REPLY", "MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST", "NO_PROTOCOL_AVAILABLE", "OPEN_GRAPH_CREATE_OBJECT_KEY", "PLATFORM_PROVIDER", "PLATFORM_PROVIDER_VERSIONS", "PLATFORM_PROVIDER_VERSION_COLUMN", "PROTOCOL_VERSION_20121101", "PROTOCOL_VERSION_20130502", "PROTOCOL_VERSION_20130618", "PROTOCOL_VERSION_20131107", "PROTOCOL_VERSION_20140204", "PROTOCOL_VERSION_20140324", "PROTOCOL_VERSION_20140701", "PROTOCOL_VERSION_20141001", "PROTOCOL_VERSION_20141028", "PROTOCOL_VERSION_20141107", "PROTOCOL_VERSION_20141218", "PROTOCOL_VERSION_20160327", "PROTOCOL_VERSION_20170213", "PROTOCOL_VERSION_20170411", "PROTOCOL_VERSION_20170417", "PROTOCOL_VERSION_20171115", "PROTOCOL_VERSION_20210906", "RESULT_ARGS_ACCESS_TOKEN", "RESULT_ARGS_DIALOG_COMPLETE_KEY", "RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY", "RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH", "RESULT_ARGS_GRAPH_DOMAIN", "RESULT_ARGS_PERMISSIONS", "RESULT_ARGS_SIGNED_REQUEST", "STATUS_ERROR_CODE", "STATUS_ERROR_DESCRIPTION", "STATUS_ERROR_JSON", "STATUS_ERROR_SUBCODE", "STATUS_ERROR_TYPE", "TAG", "WEB_DIALOG_ACTION", "WEB_DIALOG_IS_FALLBACK", "WEB_DIALOG_PARAMS", "WEB_DIALOG_URL", "actionToAppInfoMap", "", "", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "effectCameraAppInfoList", "facebookAppInfoList", "protocolVersionsAsyncUpdating", "Ljava/util/concurrent/atomic/AtomicBoolean;", "buildActionToAppInfoMap", "buildEffectCameraAppInfoList", "buildFacebookAppList", "buildPlatformProviderVersionURI", "Landroid/net/Uri;", "appInfo", "computeLatestAvailableVersionFromVersionSpec", "allAvailableFacebookAppVersions", "Ljava/util/TreeSet;", "latestSdkVersion", "versionSpec", "", "createBundleForException", "Landroid/os/Bundle;", "e", "Lcom/facebook/FacebookException;", "createFacebookLiteIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "applicationId", "permissions", "", "e2e", "isRerequest", "", "isForPublish", "defaultAudience", "Lcom/facebook/login/DefaultAudience;", "clientState", "authType", "messengerPageId", "resetMessengerState", "isFamilyLogin", "shouldSkipAccountDedupe", "createInstagramIntent", "createNativeAppIntent", "ignoreAppSwitchToLoggedOut", "targetApp", "Lcom/facebook/login/LoginTargetApp;", "nonce", "createPlatformActivityIntent", "callId", "action", "versionResult", "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "extras", "createPlatformServiceIntent", "createProtocolResultIntent", "requestIntent", "results", "error", "createProxyAuthIntents", "createTokenRefreshIntent", "fetchAllAvailableProtocolVersionsForAppInfo", "getBridgeArgumentsFromIntent", "intent", "getCallIdFromIntent", "Ljava/util/UUID;", "getErrorDataFromResultIntent", "resultIntent", "getExceptionFromErrorData", "errorData", "getLatestAvailableProtocolVersionForAction", "getLatestAvailableProtocolVersionForAppInfoList", "appInfoList", "getLatestAvailableProtocolVersionForService", "minimumVersion", "getLatestKnownVersion", "getMethodArgumentsFromIntent", "getProtocolVersionFromIntent", "getSuccessResultsFromIntent", "isErrorResult", "isVersionCompatibleWithBucketedIntent", "version", "setupProtocolRequestIntent", "", "params", "updateAllAvailableProtocolVersionsAsync", "validateActivityIntent", "validateServiceIntent", "EffectTestAppInfo", "FBLiteAppInfo", "InstagramAppInfo", "KatanaAppInfo", "MessengerAppInfo", "NativeAppInfo", "ProtocolVersionQueryResult", "WakizashiAppInfo", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class w {

    private static final String a;
    private static final List<com.facebook.internal.w.f> b;
    private static final List<com.facebook.internal.w.f> c;
    private static final Map<String, List<com.facebook.internal.w.f>> d;
    private static final AtomicBoolean e;
    private static final Integer[] f;
    public static final com.facebook.internal.w g;

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tJ\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\n\u0010\u000b\u001a\u0004\u0018\u00010\u000cH&J\u0008\u0010\r\u001a\u00020\u000cH&J\u0008\u0010\u000e\u001a\u00020\u000cH\u0016J\u0008\u0010\u000f\u001a\u00020\u0007H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "", "()V", "availableVersions", "Ljava/util/TreeSet;", "", "fetchAvailableVersions", "", "force", "", "getAvailableVersions", "getLoginActivity", "", "getPackage", "getResponseType", "onAvailableVersionsNullOrEmpty", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static abstract class f {

        private TreeSet<Integer> a;
        public final void a(boolean z) {
            boolean obj1;
            synchronized (this) {
                obj1 = this.a;
                if (obj1 != null) {
                    if (obj1 != null) {
                        try {
                            if (obj1.isEmpty()) {
                            }
                            this.a = w.a(w.g, this);
                            obj1 = this.a;
                            if (obj1 != null) {
                            } else {
                            }
                            if (obj1.isEmpty()) {
                            } else {
                            }
                            obj1 = 0;
                            obj1 = 1;
                            if (obj1 != null) {
                            }
                            f();
                            throw z;
                        }
                    } else {
                    }
                } else {
                }
            }
        }

        public final TreeSet<Integer> b() {
            TreeSet empty;
            empty = this.a;
            if (empty != null && empty != null) {
                if (empty != null) {
                    if (empty.isEmpty()) {
                        a(false);
                    }
                } else {
                }
            } else {
            }
            return this.a;
        }

        public abstract String c();

        public abstract String d();

        public String e() {
            return "id_token,token,signed_request,graph_domain";
        }

        public void f() {
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0018\u0000 \u000c2\u00020\u0001:\u0001\u000cB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u0008@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\r", d2 = {"Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "", "()V", "<set-?>", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "appInfo", "getAppInfo", "()Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "", "protocolVersion", "getProtocolVersion", "()I", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class g {

        public static final com.facebook.internal.w.g.a c;
        private com.facebook.internal.w.f a;
        private int b;
        static {
            w.g.a aVar = new w.g.a(0);
            w.g.c = aVar;
        }

        public g(g g) {
            super();
        }

        public static final void a(com.facebook.internal.w.g w$g, com.facebook.internal.w.f w$f2) {
            g.a = f2;
        }

        public static final void b(com.facebook.internal.w.g w$g, int i2) {
            g.b = i2;
        }

        public final int c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\u0008\u0002", d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
    static final class i implements Runnable {

        public static final com.facebook.internal.w.i a;
        static {
            w.i iVar = new w.i();
            w.i.a = iVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object next;
            int i;
            if (a.d(this)) {
            }
            Iterator iterator = w.b(w.g).iterator();
            for (w.f next : iterator) {
                next.a(true);
            }
            w.c(w.g).set(false);
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u0008\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007", d2 = {"Lcom/facebook/internal/NativeProtocol$EffectTestAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class a extends com.facebook.internal.w.f {
        @Override // com.facebook.internal.w$f
        public String c() {
            return (String)g();
        }

        @Override // com.facebook.internal.w$f
        public String d() {
            return "com.facebook.arstudio.player";
        }

        @Override // com.facebook.internal.w$f
        public Void g() {
            return null;
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0016J\u0008\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007", d2 = {"Lcom/facebook/internal/NativeProtocol$FBLiteAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class b extends com.facebook.internal.w.f {
        static {
        }

        @Override // com.facebook.internal.w$f
        public String c() {
            return "com.facebook.lite.platform.LoginGDPDialogActivity";
        }

        @Override // com.facebook.internal.w$f
        public String d() {
            return "com.facebook.lite";
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0016J\u0008\u0010\u0005\u001a\u00020\u0004H\u0016J\u0008\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007", d2 = {"Lcom/facebook/internal/NativeProtocol$InstagramAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "getResponseType", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class c extends com.facebook.internal.w.f {
        @Override // com.facebook.internal.w$f
        public String c() {
            return "com.instagram.platform.AppAuthorizeActivity";
        }

        @Override // com.facebook.internal.w$f
        public String d() {
            return "com.instagram.android";
        }

        @Override // com.facebook.internal.w$f
        public String e() {
            return "token,signed_request,graph_domain,granted_scopes";
        }
    }

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0016J\u0008\u0010\u0005\u001a\u00020\u0004H\u0016J\u0008\u0010\u0006\u001a\u00020\u0007H\u0002J\u0008\u0010\u0008\u001a\u00020\tH\u0016¨\u0006\n", d2 = {"Lcom/facebook/internal/NativeProtocol$KatanaAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "isAndroidAPIVersionNotLessThan30", "", "onAvailableVersionsNullOrEmpty", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class d extends com.facebook.internal.w.f {
        private final boolean g() {
            int i;
            i = applicationInfo.targetSdkVersion >= 30 ? 1 : 0;
            return i;
        }

        @Override // com.facebook.internal.w$f
        public String c() {
            return "com.facebook.katana.ProxyAuth";
        }

        @Override // com.facebook.internal.w$f
        public String d() {
            return "com.facebook.katana";
        }

        @Override // com.facebook.internal.w$f
        public void f() {
            boolean z;
            String str;
            if (g()) {
                Log.w(w.d(w.g), "Apps that target Android API 30+ (Android 11+) cannot call Facebook native apps unless the package visibility needs are declared. Please follow https://developers.facebook.com/docs/android/troubleshooting/#faq_267321845055988 to make the declaration.");
            }
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u0008\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007", d2 = {"Lcom/facebook/internal/NativeProtocol$MessengerAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class e extends com.facebook.internal.w.f {
        @Override // com.facebook.internal.w$f
        public String c() {
            return (String)g();
        }

        @Override // com.facebook.internal.w$f
        public String d() {
            return "com.facebook.orca";
        }

        @Override // com.facebook.internal.w$f
        public Void g() {
            return null;
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0016J\u0008\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006", d2 = {"Lcom/facebook/internal/NativeProtocol$WakizashiAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class h extends com.facebook.internal.w.f {
        @Override // com.facebook.internal.w$f
        public String c() {
            return "com.facebook.katana.ProxyAuth";
        }

        @Override // com.facebook.internal.w$f
        public String d() {
            return "com.facebook.wakizashi";
        }
    }
    static {
        w wVar = new w();
        w.g = wVar;
        String name = w.class.getName();
        n.e(name, "NativeProtocol::class.java.name");
        w.a = name;
        w.b = wVar.g();
        w.c = wVar.f();
        w.d = wVar.e();
        int i2 = 0;
        AtomicBoolean atomicBoolean = new AtomicBoolean(i2);
        w.e = atomicBoolean;
        Integer[] arr = new Integer[14];
        arr[i2] = 20210906;
        arr[1] = 20170417;
        arr[2] = 20160327;
        arr[3] = 20141218;
        arr[4] = 20141107;
        arr[5] = 20141028;
        arr[6] = 20141001;
        arr[7] = 20140701;
        arr[8] = 20140324;
        arr[9] = 20140204;
        arr[10] = 20131107;
        arr[11] = 20130618;
        arr[12] = 20130502;
        arr[13] = 20121101;
        w.f = arr;
    }

    public static final Intent A(Context context, Intent intent2, com.facebook.internal.w.f w$f3) {
        Intent obj4;
        final int i = 0;
        if (a.d(w.class)) {
            return i;
        }
        n.f(context, "context");
        if (intent2 == null) {
            return i;
        }
        android.content.pm.ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent2, 0);
        String packageName = activityInfo.packageName;
        n.e(packageName, "resolveInfo.activityInfo.packageName");
        if (resolveActivity != null && !j.a(context, packageName)) {
            packageName = activityInfo.packageName;
            n.e(packageName, "resolveInfo.activityInfo.packageName");
            if (!j.a(context, packageName)) {
                obj4 = i;
            }
            return obj4;
        }
        return i;
    }

    public static final Intent B(Context context, Intent intent2, com.facebook.internal.w.f w$f3) {
        Intent obj4;
        final int i = 0;
        if (a.d(w.class)) {
            return i;
        }
        n.f(context, "context");
        if (intent2 == null) {
            return i;
        }
        android.content.pm.ResolveInfo resolveService = context.getPackageManager().resolveService(intent2, 0);
        String packageName = serviceInfo.packageName;
        n.e(packageName, "resolveInfo.serviceInfo.packageName");
        if (resolveService != null && !j.a(context, packageName)) {
            packageName = serviceInfo.packageName;
            n.e(packageName, "resolveInfo.serviceInfo.packageName");
            if (!j.a(context, packageName)) {
                obj4 = i;
            }
            return obj4;
        }
        return i;
    }

    public static final TreeSet a(com.facebook.internal.w w, com.facebook.internal.w.f w$f2) {
        if (a.d(w.class)) {
            return null;
        }
        return w.q(f2);
    }

    public static final List b(com.facebook.internal.w w) {
        if (a.d(w.class)) {
            return null;
        }
        return w.b;
    }

    public static final AtomicBoolean c(com.facebook.internal.w w) {
        if (a.d(w.class)) {
            return null;
        }
        return w.e;
    }

    public static final String d(com.facebook.internal.w w) {
        if (a.d(w.class)) {
            return null;
        }
        return w.a;
    }

    private final Map<String, List<com.facebook.internal.w.f>> e() {
        if (a.d(this)) {
            return 0;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        w.e eVar = new w.e();
        arrayList.add(eVar);
        final List list2 = w.b;
        hashMap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", list2);
        hashMap.put("com.facebook.platform.action.request.FEED_DIALOG", list2);
        hashMap.put("com.facebook.platform.action.request.LIKE_DIALOG", list2);
        hashMap.put("com.facebook.platform.action.request.APPINVITES_DIALOG", list2);
        hashMap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", arrayList);
        hashMap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", arrayList);
        hashMap.put("com.facebook.platform.action.request.CAMERA_EFFECT", w.c);
        hashMap.put("com.facebook.platform.action.request.SHARE_STORY", list2);
        return hashMap;
    }

    private final List<com.facebook.internal.w.f> f() {
        if (a.d(this)) {
            return 0;
        }
        com.facebook.internal.w.f[] arr = new w.f[1];
        w.a aVar = new w.a();
        ArrayList list = p.c(aVar);
        list.addAll(g());
        return list;
    }

    private final List<com.facebook.internal.w.f> g() {
        if (a.d(this)) {
            return 0;
        }
        com.facebook.internal.w.f[] arr = new w.f[2];
        w.d dVar = new w.d();
        w.h hVar = new w.h();
        return p.c(dVar, hVar);
    }

    private final Uri h(com.facebook.internal.w.f w$f) {
        if (a.d(this)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("content://");
        stringBuilder.append(f.d());
        stringBuilder.append(".provider.PlatformProvider/versions");
        Uri obj4 = Uri.parse(stringBuilder.toString());
        n.e(obj4, "Uri.parse(CONTENT_SCHEME…ATFORM_PROVIDER_VERSIONS)");
        return obj4;
    }

    public static final int i(TreeSet<Integer> treeSet, int i2, int[] i3Arr3) {
        int i4;
        int i;
        int i3;
        int intValue2;
        int i5;
        int intValue3;
        int intValue;
        if (a.d(w.class)) {
            return 0;
        }
        n.f(i3Arr3, "versionSpec");
        i4 = -1;
        if (treeSet == null) {
            return i4;
        }
        length--;
        final Iterator obj8 = treeSet.descendingIterator();
        i3 = i4;
        for (Integer next : obj8) {
            n.e(next, "fbAppVersion");
            while (i >= 0) {
                if (i3Arr3[i] > next.intValue()) {
                }
                i--;
            }
            if (i3Arr3[i] == next.intValue()) {
                break;
            } else {
            }
            if (i3Arr3[i] > next.intValue()) {
            }
            i--;
        }
        return i4;
    }

    public static final Bundle j(FacebookException facebookException) {
        String str;
        boolean obj5;
        final int i = 0;
        if (a.d(w.class)) {
            return i;
        }
        if (facebookException == null) {
            return i;
        }
        Bundle bundle = new Bundle();
        bundle.putString("error_description", facebookException.toString());
        if (facebookException instanceof FacebookOperationCanceledException != null) {
            bundle.putString("error_type", "UserCanceled");
        }
        return bundle;
    }

    public static final Intent k(Context context, String string2, Collection<String> collection3, String string4, boolean z5, boolean z6, c c7, String string8, String string9, String string10, boolean z11, boolean z12, boolean z13) {
        Object obj = context;
        if (a.d(w.class)) {
            return null;
        }
        n.f(obj, "context");
        n.f(string2, "applicationId");
        n.f(collection3, "permissions");
        n.f(string4, "e2e");
        n.f(c7, "defaultAudience");
        n.f(string8, "clientState");
        n.f(string9, "authType");
        w.b bVar = new w.b();
        return w.A(obj, w.g.m(bVar, string2, collection3, string4, z6, c7, string8, string9, false, string10, z11, s.FACEBOOK, z12, z13, ""), bVar);
    }

    public static final Intent l(Context context, String string2, Collection<String> collection3, String string4, boolean z5, boolean z6, c c7, String string8, String string9, String string10, boolean z11, boolean z12, boolean z13) {
        Object obj = context;
        if (a.d(w.class)) {
            return null;
        }
        n.f(obj, "context");
        n.f(string2, "applicationId");
        n.f(collection3, "permissions");
        n.f(string4, "e2e");
        n.f(c7, "defaultAudience");
        n.f(string8, "clientState");
        n.f(string9, "authType");
        w.c cVar = new w.c();
        return w.A(obj, w.g.m(cVar, string2, collection3, string4, z6, c7, string8, string9, false, string10, z11, s.INSTAGRAM, z12, z13, ""), cVar);
    }

    private final Intent m(com.facebook.internal.w.f w$f, String string2, Collection<String> collection3, String string4, boolean z5, c c6, String string7, String string8, boolean z9, String string10, boolean z11, s s12, boolean z13, boolean z14, String string15) {
        boolean str2;
        boolean str3;
        String str5;
        String join;
        String nativeProtocolAudience;
        String str4;
        String str;
        Collection collection;
        boolean string;
        final int i = 0;
        if (a.d(this)) {
            return i;
        }
        String str6 = f.c();
        Intent intent = new Intent();
        String str16 = string2;
        Intent extra = intent.setClassName(f.d(), str6).putExtra("client_id", string2);
        n.e(extra, "Intent()\n            .se…PP_ID_KEY, applicationId)");
        extra.putExtra("facebook_sdk_version", o.u());
        if (str6 != null && !b0.X(collection3)) {
            intent = new Intent();
            str16 = string2;
            extra = intent.setClassName(f.d(), str6).putExtra("client_id", string2);
            n.e(extra, "Intent()\n            .se…PP_ID_KEY, applicationId)");
            extra.putExtra("facebook_sdk_version", o.u());
            if (!b0.X(collection3)) {
                collection = collection3;
                extra.putExtra("scope", TextUtils.join(",", collection3));
            }
            if (!b0.W(string4)) {
                join = string4;
                extra.putExtra("e2e", string4);
            }
            String str18 = string7;
            extra.putExtra("state", string7);
            extra.putExtra("response_type", f.e());
            extra.putExtra("nonce", string15);
            extra.putExtra("return_scopes", "true");
            if (z5) {
                try {
                    extra.putExtra("default_audience", c6.getNativeProtocolAudience());
                    extra.putExtra("legacy_override", o.p());
                    str4 = string8;
                    extra.putExtra("auth_type", string8);
                    int i2 = 1;
                    if (z9) {
                    }
                    extra.putExtra("fail_on_logged_out", i2);
                    String str23 = string10;
                    extra.putExtra("messenger_page_id", string10);
                    extra.putExtra("reset_messenger_state", z11);
                    if (z13) {
                    }
                    extra.putExtra("fx_app", s12.toString());
                    if (z14) {
                    }
                    extra.putExtra("skip_dedupe", i2);
                    return extra;
                    return i;
                    Object obj = this;
                    a.b(th, this);
                    return obj1;
                }
            }
        }
    }

    public static final Intent n(Context context) {
        Intent intent;
        Intent category;
        String str;
        final int i = 0;
        if (a.d(w.class)) {
            return i;
        }
        n.f(context, "context");
        Iterator iterator = w.b.iterator();
        for (w.f next2 : iterator) {
            Intent intent2 = new Intent("com.facebook.platform.PLATFORM_SERVICE");
            intent = w.B(context, intent2.setPackage(next2.d()).addCategory("android.intent.category.DEFAULT"), next2);
        }
        return i;
    }

    public static final Intent o(Intent intent, Bundle bundle2, FacebookException facebookException3) {
        String string;
        Object obj5;
        Object obj7;
        final int i = 0;
        if (a.d(w.class)) {
            return i;
        }
        n.f(intent, "requestIntent");
        UUID uuid = w.r(intent);
        Intent intent2 = new Intent();
        intent2.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", w.x(intent));
        obj5 = new Bundle();
        obj5.putString("action_id", uuid.toString());
        if (uuid != null && facebookException3 != null) {
            intent2 = new Intent();
            intent2.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", w.x(intent));
            obj5 = new Bundle();
            obj5.putString("action_id", uuid.toString());
            if (facebookException3 != null) {
                obj5.putBundle("error", w.j(facebookException3));
            }
            intent2.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", obj5);
            if (bundle2 != null) {
                intent2.putExtra("com.facebook.platform.protocol.RESULT_ARGS", bundle2);
            }
            return intent2;
        }
        return i;
    }

    public static final List<Intent> p(Context context, String string2, Collection<String> collection3, String string4, boolean z5, boolean z6, c c7, String string8, String string9, boolean z10, String string11, boolean z12, boolean z13, boolean z14, String string15) {
        int i;
        Intent intent;
        Object obj3;
        String str2;
        Collection collection;
        String str3;
        boolean z;
        ArrayList arrayList;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj;
        Object obj4;
        Object obj2;
        boolean z2;
        boolean z3;
        String str;
        if (a.d(w.class)) {
            return 0;
        }
        n.f(string2, "applicationId");
        n.f(collection3, "permissions");
        n.f(string4, "e2e");
        n.f(c7, "defaultAudience");
        n.f(string8, "clientState");
        n.f(string9, "authType");
        arrayList = new ArrayList();
        Iterator iterator = w.b.iterator();
        while (iterator.hasNext()) {
            ArrayList list3 = arrayList;
            intent = w.g.m((w.f)iterator.next(), string2, collection3, string4, z6, c7, string8, string9, z10, string11, z12, s.FACEBOOK, z13, z14, string15);
            if (intent != null) {
            }
            obj2 = string2;
            obj4 = collection3;
            obj = string4;
            obj7 = c7;
            obj6 = string8;
            obj5 = string9;
            arrayList = list3;
            i = 0;
            list3.add(intent);
        }
        return arrayList;
    }

    private final TreeSet<Integer> q(com.facebook.internal.w.f w$f) {
        String moveToNext;
        PackageManager packageManager;
        int i2;
        int i;
        int i3;
        Throwable th;
        android.content.pm.ProviderInfo obj13;
        final String str = "version";
        moveToNext = "Failed to query content resolver.";
        final int i4 = 0;
        if (a.d(this)) {
            return i4;
        }
        TreeSet treeSet = new TreeSet();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f.d());
        stringBuilder.append(".provider.PlatformProvider");
        obj13 = o.f().getPackageManager().resolveContentProvider(stringBuilder.toString(), 0);
        if (obj13 != null) {
            obj13 = o.f().getContentResolver().query(h(f), /* result */, 0, 0, 0);
            if (obj13 != null) {
            }
        } else {
            obj13 = i4;
        }
        if (obj13 != null) {
            obj13.close();
        }
        return treeSet;
    }

    public static final UUID r(Intent intent) {
        String str;
        int string;
        int obj3;
        string = 0;
        if (a.d(w.class)) {
            return string;
        }
        if (intent == null) {
            return string;
        }
        if (w.y(w.x(intent))) {
            obj3 = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
            if (obj3 != null) {
                obj3 = obj3.getString("action_id");
            } else {
                obj3 = string;
            }
        } else {
            obj3 = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        }
        if (obj3 != null) {
            string = UUID.fromString(obj3);
        }
        return string;
    }

    public static final FacebookException s(Bundle bundle) {
        String string;
        String string2;
        int i;
        boolean obj5;
        final int i2 = 0;
        if (a.d(w.class)) {
            return i2;
        }
        if (bundle == null) {
            return i2;
        }
        if (bundle.getString("error_type") == null) {
            string = bundle.getString("com.facebook.platform.status.ERROR_TYPE");
        }
        if (bundle.getString("error_description") == null) {
            string2 = bundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
        }
        if (string != null && l.x(string, "UserCanceled", true)) {
            if (l.x(string, "UserCanceled", true)) {
                obj5 = new FacebookOperationCanceledException(string2);
            } else {
                obj5 = new FacebookException(string2);
            }
        } else {
        }
        return obj5;
    }

    private final com.facebook.internal.w.g t(List<? extends com.facebook.internal.w.f> list, int[] i2Arr2) {
        boolean next;
        int i2;
        int i;
        if (a.d(this)) {
            return null;
        }
        w.z();
        if (list == null) {
            return w.g.c.b();
        }
        Iterator obj5 = list.iterator();
        for (w.f next : obj5) {
            i2 = w.i(next.b(), w.v(), i2Arr2);
        }
        try {
            return w.g.c.b();
            a.b(list, this);
            return obj1;
        }
    }

    public static final int u(int i) {
        final int i2 = 0;
        if (a.d(w.class)) {
            return i2;
        }
        int[] iArr = new int[1];
        iArr[i2] = i;
        return w.g.t(w.b, iArr).c();
    }

    public static final int v() {
        final int i = 0;
        if (a.d(w.class)) {
            return i;
        }
        return w.f[i].intValue();
    }

    public static final Bundle w(Intent intent) {
        boolean str;
        Bundle obj3;
        if (a.d(w.class)) {
            return null;
        }
        n.f(intent, "intent");
        if (!w.y(w.x(intent))) {
            obj3 = intent.getExtras();
        } else {
            obj3 = intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
        }
        return obj3;
    }

    public static final int x(Intent intent) {
        final int i = 0;
        if (a.d(w.class)) {
            return i;
        }
        n.f(intent, "intent");
        return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", i);
    }

    public static final boolean y(int i) {
        boolean z;
        int i2;
        if (a.d(w.class)) {
            return 0;
        }
        if (i.t(w.f, Integer.valueOf(i)) && i >= 20140701) {
            if (i >= 20140701) {
                i2 = 1;
            }
        }
        return i2;
    }

    public static final void z() {
        if (a.d(w.class)) {
        }
        if (!w.e.compareAndSet(false, true)) {
        }
        o.n().execute(w.i.a);
    }
}

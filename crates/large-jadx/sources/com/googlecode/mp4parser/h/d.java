package com.googlecode.mp4parser.h;

import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: JuliLogger.java */
/* loaded from: classes2.dex */
public class d extends f {

    Logger a;
    public d(String str) {
        super();
        this.a = Logger.getLogger(str);
    }

    @Override // com.googlecode.mp4parser.h.f
    public void b(String str) {
        this.a.log(Level.FINE, str);
    }

    @Override // com.googlecode.mp4parser.h.f
    public void c(String str) {
        this.a.log(Level.SEVERE, str);
    }

    @Override // com.googlecode.mp4parser.h.f
    public void d(String str) {
        this.a.log(Level.WARNING, str);
    }
}

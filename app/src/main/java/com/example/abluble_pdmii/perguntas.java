package com.example.abluble_pdmii;

public class perguntas {
    private String pergunta, ra, rb, rc, rd, gabarito;

    public perguntas(String pergunta, String ra,String rb,String rc,String rd,String gabarito){
        this.pergunta = pergunta;
        this.ra = ra;
        this.rb = rb;
        this.rc = rc;
        this.rd = rd;
        this.gabarito = gabarito;
    }

    public String getPergunta() {
        return pergunta;
    }
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }


    public String getRa() {
        return ra;
    }
    public void setRa(String ra) {
        this.ra = ra;
    }


    public String getRb() {
        return rb;
    }
    public void setRb(String rb) {
        this.rb = rb;
    }


    public String getRc() {
        return rc;
    }
    public void setRc(String rc) {
        this.rc = rc;
    }


    public String getRd() {
        return rd;
    }
    public void setRd(String rd) {
        this.rd = rd;
    }


    public String getGabarito() {
        return gabarito;
    }
    public void setGabarito(String gabarito) {
        this.gabarito = gabarito;
    }
}

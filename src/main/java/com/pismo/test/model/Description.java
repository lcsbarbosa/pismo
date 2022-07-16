package com.pismo.test.model;

public enum Description {
    COMPRA_A_VISTA ("COMPRA A VISTA"),
    COMPRA_PARCELADA ("COMPRA PARCELADA"),
    SAQUE ("SAQUE"),
    PAGAMENTO ("PAGAMENTO");

    private String display;

    Description (String display){
        this.display = display;
    }

    public String getDisplay() {
        return this.display;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf.b3c3;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class InputNumberView implements Serializable {
 
    private int pageDepartSuppression;
    private int nbrePagesSuppression;
    private int nbrePagesExtraction;
    private Double input1 = new Double(0);
    private Double input2 = new Double(0);
    private Double input3 = new Double(0);
    private Double input4 = new Double(0);
    private Double input5 = new Double(0);
    private Double input6 = new Double(0);
    private Double input7 = null;
    private BigDecimal input8 = new BigDecimal(0);
 
 
    public InputNumberView() {
        nbrePagesSuppression = 0;
        pageDepartSuppression = 0;
        nbrePagesExtraction = 0;
        input1 = 0d;
        input2 = 0d;
        input3 = 0d;
        input4 = 0d;
        input5 = 251.31;
        input6 = 60d;
        input8 = new BigDecimal("1234.000000001");
    }

    public int getNbrePagesSuppression() {
        return nbrePagesSuppression;
    }

    public void setNbrePagesSuppression(int nbrePagesSuppression) {
        this.nbrePagesSuppression = nbrePagesSuppression;
    }

    public int getPageDepartSuppression() {
        return pageDepartSuppression;
    }

    public void setPageDepartSuppression(int pageDepartSuppression) {
        this.pageDepartSuppression = pageDepartSuppression;
    }

    public int getNbrePagesExtraction() {
        return nbrePagesExtraction;
    }

    public void setNbrePagesExtraction(int nbrePagesExtraction) {
        this.nbrePagesExtraction = nbrePagesExtraction;
    }
 
    
    
    public Double getInput1() {
        return input1;
    }
 
    public void setInput1(Double input1) {
        this.input1 = input1;
    }
 
    public Double getInput2() {
        return input2;
    }
 
    public void setInput2(Double input2) {
        this.input2 = input2;
    }
 
    public Double getInput3() {
        return input3;
    }
 
    public void setInput3(Double input3) {
        this.input3 = input3;
    }
 
    public Double getInput4() {
        return input4;
    }
 
    public void setInput4(Double input4) {
        this.input4 = input4;
    }
 
    public Double getInput5() {
        return input5;
    }
 
    public void setInput5(Double input5) {
        this.input5 = input5;
    }
 
    public Double getInput6() {
        return input6;
    }
 
    public void setInput6(Double input6) {
        this.input6 = input6;
    }
 
    public Double getInput7() {
        return input7;
    }
 
    public void setInput7(Double input7) {
        this.input7 = input7;
    }
 
    public BigDecimal getInput8() {
        return input8;
    }
 
    public void setInput8(BigDecimal input8) {
        this.input8 = input8;
    }
}
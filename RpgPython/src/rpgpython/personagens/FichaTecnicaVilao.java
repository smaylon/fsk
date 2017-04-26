package rpgpython.personagens;

import java.util.Random;

public class FichaTecnicaVilao extends FichaTecnica{
    Random r = new Random();
        
    private int level;
    private String listaItem[] = {"Dente de Víbora", "Olho do Sábio", "Coroa do Imperador", "Kagame"};
    public int acresAle(){
        int acrescimo = r.nextInt(16);
        if(acrescimo<5){
            acrescimo=5;
        }
    return acrescimo;
    }
    public int acresVda(){
        int acresV = r.nextInt(1001);
        if(acresV<20){
            acresV=20;
        }
    return acresV;
    }
    public FichaTecnicaVilao(){
        this.setPtsVida(super.ptsVida+acresVda());
        this.setLevel(levelVilao(this.getPtsVida()));
        }
    public int getPtsVida() {
        return ptsVida;
    }
    public void setPtsVida(int ptsVida) {
        this.ptsVida = ptsVida;
    }
    public int getLevel() {
        return this.level;
    }
    public void setLevel(byte level) {
        this.level = level;
    }
    public int getPtsAtk() {
        return ptsAtk;
    }
    public void setPtsAtk(int ptsAtk) {
        this.ptsAtk = ptsAtk;
    }
    public int getPtsDef() {
        return ptsDef;
    }
    public void setPtsDef(int ptsDef) {
        this.ptsDef = ptsDef;
    }
    private byte levelVilao(int ptsVida){
        byte lvl=0;
        if(this.getPtsVida()<151){
            lvl = 1;
            }else if(this.getPtsVida()<201){
                lvl = 2;
                this.setPtsAtk(super.ptsAtk+acresAle()+1);
                this.setPtsDef(super.ptsDef+acresAle()+1);
            }else if(this.getPtsVida()<401){
                lvl = 3;
                this.setPtsAtk(super.ptsAtk+acresAle()+2);
                this.setPtsDef(super.ptsDef+acresAle()+1);
            }else if(this.getPtsVida()<801){
                lvl = 4;
                this.setPtsAtk(super.ptsAtk+acresAle()+3);
                this.setPtsDef(super.ptsDef+acresAle()+2);
            }else if(this.getPtsVida()<1001){
                lvl = 5;
                this.setPtsAtk(super.ptsAtk+acresAle()+3);
                this.setPtsDef(super.ptsDef+acresAle()+3);
            }
        return lvl;
        }
    public String dropItem(){
        int sort = r.nextInt(16);
        String drop = (sort!=0 && sort!=1 && sort!=2 && sort!=3) ? "moeda" : listaItem[sort];
        if(this.getPtsVida()==0){
            return drop;
        }
        return "vazio";
        }
}
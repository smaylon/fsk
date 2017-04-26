package rpgpython.personagens;

import java.util.Random;

public class FichaTecnicaHeroi extends FichaTecnica {
    Random r = new Random();
    private static String nick;
    private static int kills;

    public int getKills() {
        return kills;
    }
    public void setKills(FichaTecnicaVilao vilao1) {
        if(vilao1.getPtsVida()==0){
        this.kills = this.getKills()+1;}
    }
    public String getNick() {
        return nick;
    }
    public void setNick(String nick) {
        FichaTecnicaHeroi.nick = nick;
    }
    public int acresVda(){
        int acresV = r.nextInt(21);
        if(acresV<10){
            acresV=10;
        }
    return acresV;
    }
    public int acresAle(){
        int acrescimo = r.nextInt(21);
        if(acrescimo<8){
            acrescimo=8;
        }
    return acrescimo;
    }
    private int levelCheck(int ptsVida){
        if(this.ptsVida<121){
        this.setLevel(0);
        }else if(this.ptsVida<151){
            this.setLevel(this.getLevel()+1);
            }else if(this.ptsVida<201){
                this.setLevel(this.getLevel()+1);
            }else if(this.ptsVida<401){
                this.setLevel(this.getLevel()+1);
            }else if(this.ptsVida<801){
                this.setLevel(this.getLevel()+1);
            }else if(this.ptsVida<1001){
                this.setLevel(this.getLevel()+1);
            }
        return level;
    }
    public FichaTecnicaHeroi(String nick) {
        this.setLevel(super.level);
        this.setPtsVida(super.ptsVida+acresVda());
        this.setPtsAtk(super.ptsAtk+acresAle());
        this.setPtsDef(super.ptsDef+acresAle());
        this.setNick(nick);
    }
    public void levelUpHeroi(FichaTecnicaVilao vilao1){
        if(vilao1.getPtsVida()<=0){
            this.setPtsVida(this.getPtsVida()+r.nextInt(35));
            this.setPtsAtk(this.getPtsAtk()+r.nextInt(4));
            this.setPtsDef(this.getPtsDef()+r.nextInt(4));
            this.levelCheck(this.getPtsVida());
        }
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getPtsAtk() {
        return this.ptsAtk;
    }
    public void setPtsAtk(int ptsAtk) {
        this.ptsAtk = ptsAtk;
    }
    public int getPtsDef() {
        return this.ptsDef;
    }
    public void setPtsDef(int ptsDef) {
        this.ptsDef = ptsDef;
    }
    public int getPtsVida() {
        return this.ptsVida;
    }
    public void setPtsVida(int ptsVida) {
        this.ptsVida = ptsVida;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public void pegaItem(boolean option, String item){
        if (option){
            this.setItem(item);
        }
    }
    public boolean equipado(boolean opcao, boolean option, String item){
        if(opcao){
            pegaItem(option, item);
            return true;
        }
    return false;
    }
}

package rpgpython.luta;

import java.util.Scanner;
import java.util.Random;
import rpgpython.personagens.FichaTecnicaBoss;
import rpgpython.personagens.FichaTecnicaHeroi;
import rpgpython.personagens.FichaTecnicaVilao;

public class Lutar {
    Random r = new Random();
    /*
    public Lutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    public int defenderH(FichaTecnicaHeroi ptsDef, FichaTecnicaVilao ptsAtk){
        int difer=0;
        if(ptsDef.getPtsDef()<ptsAtk.getPtsAtk()){
            difer =  ptsAtk.getPtsAtk()-ptsDef.getPtsDef();
            return difer;
        }
        return difer;
    }
    public String ataqueH(FichaTecnicaHeroi ptsAtk, FichaTecnicaVilao ptsDef){
        int dano;
        if(acertoH()){
            ptsDef.setPtsVida(ptsDef.getPtsVida()-defenderV(ptsDef, ptsAtk));
            dano = defenderV(ptsDef, ptsAtk);
            return ("Dano " + dano);
        }
        return ("MISS!");
    }
    public int defenderV(FichaTecnicaVilao ptsDef, FichaTecnicaHeroi ptsAtk){
        int difer=0;
        if(ptsDef.getPtsDef()<ptsAtk.getPtsAtk()){
            difer = ptsAtk.getPtsAtk()-ptsDef.getPtsDef();
            return difer;}
        return difer;
    }
    public String ataqueV(FichaTecnicaVilao ptsAtk, FichaTecnicaHeroi ptsDef){
        int dano;
        if(acertoV()){
            ptsDef.setPtsVida(ptsDef.getPtsVida()-defenderH(ptsDef, ptsAtk));
            dano=defenderH(ptsDef, ptsAtk);
            return ("Dano " + dano);
        }
        return ("MISS!");
    }
    private boolean acertoH(){
        boolean ac = r.nextBoolean();
        return ac;
    }
    private boolean acertoV(){
        boolean ac[] = {true, true, true, true, true, true, true, false, false, false};
        int c=r.nextInt(10);
        return ac[c];
    }
    public boolean lutCheck(FichaTecnicaHeroi heroi1, FichaTecnicaVilao vilao1){
        int difer; boolean ret = true;
        if (heroi1.getLevel()>vilao1.getLevel()){
            difer=heroi1.getLevel()-vilao1.getLevel();
            if(difer>2){
                ret = false;
            }else{
                ret = true;
            }
        }else if(heroi1.getLevel()<vilao1.getLevel()){
            difer = vilao1.getLevel() - heroi1.getLevel();
            if(difer<=3){
                ret = true;
            }else{
                ret = false;
            }
        }
    return ret;
    }    
    public boolean lt(boolean lutCheck, String nick, FichaTecnicaHeroi heroi1, FichaTecnicaVilao vilao1){
        boolean permitido=false;
        Scanner in = new Scanner(System.in);
        if(lutCheck){
        System.out.println("Level: " + heroi1.getLevel() + "\nNome: " + heroi1.getNick() + "\nForça: " + heroi1.getPtsAtk()
        + "\nResist.: " + heroi1.getPtsDef() + "\nLife: " + heroi1.getPtsVida());
        
        System.out.print("\nLevel: " + vilao1.getLevel() + "\nForça: " + vilao1.getPtsAtk()
        + "\nResist.: " + vilao1.getPtsDef() + "\nLife: " + vilao1.getPtsVida());
        permitido = true;
        }
        return permitido;
    }
    
    public int defenderB(FichaTecnicaBoss ptDeB, FichaTecnicaHeroi ptsAtk){
        int difer=0;
        if(ptDeB.getPtsDef()<ptsAtk.getPtsAtk()){
            difer = ptsAtk.getPtsAtk()-ptDeB.getPtsDef();
            return difer;}
        return difer;
    }
    public String ataqueB(FichaTecnicaBoss ptAtB, FichaTecnicaHeroi ptsDef){
        int dano;
        if(acertoV()){
            ptsDef.setPtsVida(ptsDef.getPtsVida()-defenderHB(ptsDef, ptAtB));
            dano=defenderHB(ptsDef, ptAtB);
            return ("Dano " + dano);
        }
        return ("MISS!");
    }
    
    public int defenderHB(FichaTecnicaHeroi ptsDef, FichaTecnicaBoss ptsAtk){
        int difer=0;
        if(ptsDef.getPtsDef()<ptsAtk.getPtsAtk()){
            difer =  ptsAtk.getPtsAtk()-ptsDef.getPtsDef();
            return difer;
        }
        return difer;
    }
    public String ataqueHB(FichaTecnicaHeroi ptsAtk, FichaTecnicaBoss ptsDef){
        int dano;
        if(acertoH()){
            ptsDef.setPtsVida(ptsDef.getPtsVida()-defenderB(ptsDef, ptsAtk));
            dano = defenderB(ptsDef, ptsAtk);
            return ("Dano " + dano);
        }
        return ("MISS!");
    }
}
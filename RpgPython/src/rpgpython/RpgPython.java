package rpgpython;

import java.util.Scanner;
import rpgpython.luta.Lutar;
import rpgpython.personagens.FichaTecnicaBoss;
import rpgpython.personagens.FichaTecnicaHeroi;
import rpgpython.personagens.FichaTecnicaVilao;

public class RpgPython {
    public static void main(String[] args) {
        //construindo a luta
        byte turno = 0;
        Lutar luta = new Lutar();
        Scanner in = new Scanner(System.in);
        boolean continuar = true;
        System.out.print("Qual seu nome? Heroi! ");
        String nick = in.next();
        FichaTecnicaHeroi heroi1 = new FichaTecnicaHeroi(nick);
        System.out.println("Encontre seu caminho!");
        
        while(continuar){            
            System.out.println("Confusão! Um inimigo a frente.");
            FichaTecnicaVilao vilao1 = new FichaTecnicaVilao();
            
            Lutar ltr = new Lutar();
           if(heroi1.getKills()==8 ||heroi1.getKills()==16 || heroi1.getKills()==32 || heroi1.getKills()>32 ){
               FichaTecnicaBoss boss1 = new FichaTecnicaBoss(heroi1);
               System.out.println("Level: " + boss1.getLevel() + "\nNome: " + boss1.getNome()+ "\nForça: " 
                                            + boss1.getPtsAtk() + "\nResist.: " + boss1.getPtsDef()
                                            + "\nLife: " + boss1.getPtsVida());
               while(boss1.getPtsVida()>0){
                    System.out.print("\n1-Ataca <-> 2-Defender\nR: ");
                    byte choice=in.nextByte();
                    if(choice==1){//este codigo implementa o ataque na luta
                    System.out.println(ltr.ataqueHB(heroi1, boss1));
                    System.out.println(ltr.defenderB(boss1, heroi1));
                    System.out.println("\nHlife: " + heroi1.getPtsVida());
                    System.out.println("Vlife: " + vilao1.getPtsVida());
                    turno++;
                }else if(choice==2){//este código implementa a defesa na luta
                    System.out.println(ltr.defenderHB(heroi1, boss1));
                    System.out.println(ltr.ataqueB(boss1, heroi1));
                    System.out.println("\nHlife: " + heroi1.getPtsVida());
                    System.out.println("Vlife: " + boss1.getPtsVida());
                }else if(choice!=1 && choice!=2){//implementa um ataque adcional caso o jogador se distraia na escolha
                    System.out.println("Moscou ele tenta atacar!");
                    System.out.println(ltr.ataqueB(boss1, heroi1));
                    System.out.println("\nHlife: " + heroi1.getPtsVida());
                    System.out.println("Vlife: " + boss1.getPtsVida());
                }
                if(turno==3){//implementa um ataque adcional após 3 ataques do heroi
                    System.out.println(ltr.ataqueV(vilao1, heroi1));
                    turno=0; 
                    if(heroi1.getPtsVida()<=0){
                        System.out.println("Voce Morreu");
                        break;
                        }
                    }
               }
           }else if(ltr.lt(ltr.lutCheck(heroi1, vilao1), nick, heroi1, vilao1)){
                boolean vidaVilaoHeroi = true;
                while(vidaVilaoHeroi){
                System.out.print("\n1-Ataca <-> 2-Defender\nR: ");
                byte choice=in.nextByte();
                if(choice==1){//este codigo implementa o ataque na luta
                    System.out.println(ltr.ataqueH(heroi1, vilao1));
                    System.out.println(ltr.defenderV(vilao1, heroi1));
                    System.out.println("\nHlife: " + heroi1.getPtsVida());
                    System.out.println("Vlife: " + vilao1.getPtsVida());
                    turno++;
                }else if(choice==2){//este código implementa a defesa na luta
                    System.out.println(ltr.defenderH(heroi1, vilao1));
                    System.out.println(ltr.ataqueV(vilao1, heroi1));
                    System.out.println("\nHlife: " + heroi1.getPtsVida());
                    System.out.println("Vlife: " + vilao1.getPtsVida());
                }else if(choice!=1 && choice!=2){//implementa um ataque adcional caso o jogador se distraia na escolha
                    System.out.println("Moscou ele tenta atacar!");
                    System.out.println(ltr.ataqueV(vilao1, heroi1));
                    System.out.println("\nHlife: " + heroi1.getPtsVida());
                    System.out.println("Vlife: " + vilao1.getPtsVida());
                }
                if(turno==3){//implementa um ataque adcional após 3 ataques do heroi
                    System.out.println(ltr.ataqueV(vilao1, heroi1));
                    turno=0;                    
                }
                if (vilao1.getPtsVida()==0) {
                    String li[] = {"VAZIO", "VAZIO", "VAZIO", "VAZIO"};
                    System.out.print("O inimigo Deixou Cair um Item, Pegar: 1-Sim ou 2-Não: ");
                    int pi = in.nextInt();
                    System.out.println("Onde deseja Guardar? 1-"+li[0]+"\n2-"+li[1]+"\n3-"+li[2]+"\n4-"+li[3]+"");
                    li[in.nextInt()] = vilao1.dropItem();
                    heroi1.setKills(vilao1);
                    //derrota = false;
                    vidaVilaoHeroi=false;
            } else if (heroi1.getPtsVida()==0){
                System.out.println("Você Morreu.");
                vidaVilaoHeroi=false;
                }
            };
            }else{
                heroi1.levelUpHeroi(vilao1);
                System.out.println("Novo Status: ");
                System.out.println("Level: " + heroi1.getLevel() + "\nNome: " + heroi1.getNick()
                                             + "\nForça: " + heroi1.getPtsAtk() + "\nResist.: " + heroi1.getPtsDef() 
                                             + "\nLife: " + heroi1.getPtsVida());
            System.out.println("Inimigo eliminado");}
        }
    }
}
package rpgpython.personagens;
public class FichaTecnicaBoss extends FichaTecnica {
    private String habDep[] = {"Divine life", "Shadow foot", "Proud Prince", "Akashi"};
    private String habilidade;
    private String nome;

    public FichaTecnicaBoss(FichaTecnicaHeroi heroi1) {
        this.setHabilidade(heroi1);
        this.setNome();
        this.setLevel();
        this.setPtsAtk(heroi1);
        this.setPtsDef(heroi1);
        this.setPtsVida(4900);
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(){
        if(this.getHabilidade().equals(habDep[0])){
            this.nome = "Corrompido";
        }else if(this.getHabilidade().equals(habDep[1])){
            this.nome = "Mago";
        }else if(this.getHabilidade().equals(habDep[2])){
            this.nome = "Prince";
        }else if(this.getHabilidade().equals(habDep[3])){
            this.nome = "False Emperor";
        }
    }
    public String getHabilidade() {
        return this.habilidade;
    }
    public void setHabilidade(FichaTecnicaHeroi heroi1) {
        if(heroi1.getKills()>8 && heroi1.getKills()<=15){
            this.habilidade = habDep[0];
        }else if(heroi1.getKills()<=23){
            this.habilidade = habDep[1];
        }else if(heroi1.getKills()<=32){
            this.habilidade = habDep[2];
        }else{
            this.habilidade = habDep[3];
        }
    }
    public int getPtsVida() {
        return this.ptsVida;
    }
    public void setPtsVida(int pts) {
        this.ptsVida = (super.ptsVida) + pts;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel() {
        if(this.getHabilidade().equals(habDep[0])){
            this.level = 1;
        }else if(this.getHabilidade().equals(habDep[1])){
            this.level = 2;
        }else if(this.getHabilidade().equals(habDep[2])){
            this.level = 3;
        }else if(this.getHabilidade().equals(habDep[3])){
            this.level = 5;
        }
        
    }
    public int getPtsAtk() {
        return this.ptsAtk;
    }
    public void setPtsAtk(FichaTecnicaHeroi heroi1) {
        this.ptsAtk = heroi1.getPtsDef() + 3;
    }
    public int getPtsDef() {
        return ptsDef;
    }
    public void setPtsDef(FichaTecnicaHeroi heroi1) {
        this.ptsDef = heroi1.getPtsAtk() - 2;
    }
    public void usoHabilidade(boolean equipado, String item){
        if(equipado==false){
            if(this.getHabilidade().equals(habDep[0]) && item!="Dente de Víbora"){
                if(this.getPtsVida()<1000){
                    this.setPtsVida(-4000);
                }
            }else if(this.getHabilidade().equals(habDep[1]) && item!="Olho do Sábio"){
                if(this.getPtsVida()<900){
                    this.setPtsVida(-3000);
                }
            }else if(this.getHabilidade().equals(habDep[2]) && item!="Coroa do Imperador"){
                if(this.getPtsVida()<500){
                    this.setPtsVida(-2000);
                }
            }else if(this.getHabilidade().equals(habDep[3]) && item!="Kagame"){
                if(this.getPtsVida()<200){
                    this.setPtsVida(0);
                }
            }
        }
    }
}

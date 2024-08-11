package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class ProcessoSeletivo {

    public static void main(String[] args) {
        System.out.println("Processo Seletivo");
        

        String candidatos [] = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};

        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }

    }


    //Ligar para candidato
    static void entrandoEmContato(String candidato){
        int tentativaRealizadas = 1;
        boolean continuaTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuaTentando = !atendeu;

            if (continuaTentando) {
                tentativaRealizadas++;
            }else {
                System.out.println("Contato realizado com sucesso!");
            }
            
        } while (continuaTentando && tentativaRealizadas < 3);
            
        if (atendeu) {
                System.out.println("Conseguimos contato com " + candidato + " na " + tentativaRealizadas);
        } else{
                System.out.println("Não conseguimos contato com " + candidato + " número máximo de tentativas " + tentativaRealizadas);
            
        }
    }

    //metodo auxiliar
    static boolean atender(){
        return new Random().nextInt(3) == 0;
    }
    

    //Analise salario candidatos
    static void analisarCandidato(double salarioPretendido){

        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.err.println("Ligar para o candidato com contra proposta!");
        } else {
            System.out.println("Aguardando o resultado dos demais candidatos");
        }
        
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
        System.out.println("Imprimindo a lista de candidatos informando o indica do elemento");

        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("O candidato de n° " + (i+1) + " e o " + candidatos[i]);
        }
    }


    //Gerando valor prentendido
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    //Seleção de candidatos                                                                                                      ,]
     static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","FABRICIO","MIRELA","DANIELA"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou esse valor de salario " + salarioPretendido);

            if(salarioBase > salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            } 

            candidatoAtual++;

        }
    }
}


package atividade1;

import java.util.ArrayList;
import java.util.Scanner;

public class Atividade1 {
    private static Scanner ler;

    public static void main(String[] args) {
        ler = new Scanner(System.in);
        
        ArrayList<String> arrayListNome = new ArrayList<>();
        ArrayList<String> arrayListTelefone = new ArrayList<>();
        
        Usuario usuario = new Usuario();
        
        arrayListNome.add(0, "Rafael");
        arrayListTelefone.add(0, "84792087");
        
        arrayListNome.add(1, "Ricardo");
        arrayListTelefone.add(1, "96269482");
        
        usuario.setNome(arrayListNome);
        usuario.setNumero(arrayListTelefone);
        
        iniciar(usuario);
    }
    
    private static void iniciar(Usuario usuario){
        while(usuario.getNome().size() != 0){
            String nomeNumero;

            System.out.println("Digite o nome ou o telefone: ");
            nomeNumero = ler.nextLine();

            listarUsuario(nomeNumero, usuario);
        }
    }
    
    private static void listarUsuario(String nomeNumero, Usuario usuario){
        int opcao;
        for(int i = 0; i < usuario.getNome().size(); i++){
            if(usuario.getNome().get(i).equals(nomeNumero) || usuario.getNumero().get(i).equals(nomeNumero)){
                System.out.println("ID: "+i+"\nNome: "+usuario.getNome().get(i)+"\nTelefone: "+usuario.getNumero().get(i)+"\n");
                
                System.out.println("Opções:\n1 - Fazer nova consulta\n2 - Apagar\n3 - Sair\nEscolha uma opção: ");
                opcao = ler.nextInt();
                
                if(opcao == 1){
                    iniciar(usuario);
                
                }else if(opcao == 2){
                    excluirUsuario(i, usuario);
                    
                }else if(opcao == 3){
                    System.exit(0);
                    
                }else{
                    while(opcao != 1 || opcao != 2 || opcao != 3){
                        System.out.println("Digite uma opção válida! ");
                        
                        System.out.println("Opções:\n1 - Fazer nova consulta\n2 - Apagar\n3 - Sair\nEscolha uma opção: ");
                        opcao = ler.nextInt();

                        if(opcao == 1){
                            iniciar(usuario);

                        }else if(opcao == 2){
                            excluirUsuario(i, usuario);

                        }else if(opcao == 3){
                            System.exit(0);

                        }
                    }
                }
            }
        }
    }
    
    private static void excluirUsuario(int i, Usuario usuario){
        System.out.println("Aqui tem: "+usuario.getNome()+usuario.getNumero());
        int opcaoApagar, opcao;
        System.out.println("Deseja excluir o usuário de ID "+i+"?\n1 - Sim\n2 - Não\nDigite uma opção: ");
        opcaoApagar = ler.nextInt();
        
        if(opcaoApagar == 1){
            usuario.getNome().remove(i);
            usuario.getNumero().remove(i);
            
            System.out.println("Usuário removido!\nO que deseja fazer?\n1 - Fazer nova consulta\n2 - Sair\nDigite uma opção: ");
            opcao = ler.nextInt();
            
            if(opcao == 1){
                iniciar(usuario);
            
            }else if(opcao == 2){
                System.exit(0);
            }
                   
        }else{
            System.out.println("Cancelado!\nO que deseja fazer?\n1 - Fazer nova consulta\n2 - Sair\nDigite uma opção: ");
            opcao = ler.nextInt();
            
            if(opcao == 1){
                iniciar(usuario);
            
            }else if(opcao == 2){
                System.exit(0);
            }
        }
    }
}

package jogodavelha;

import java.util.Scanner;

/**
 *
 * @author fabio.aglubacheski
 */
public class JogoDaVelha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        game();
    }
    
    public static void game(){
        
        Scanner ler = new Scanner(System.in);
        // cria o tabuleiro
        int M[][] = initialize();
        int N[][] = initialize();
        
        int jogoAtivo=-1, lin, col;
        char jogador='O';
        
        
        print(M);
        /*        
        while( jogoAtivo == -1 ){
            // imprime o tabuleiro
            print(M);
            System.out.println("Vez do jogador "+jogador);
            System.out.println("Escolha a posicao para jogar (lin col):");
            lin=ler.nextInt();
            col=ler.nextInt();
            
            // joga - step
            if( step(M,lin,col, jogador)){ // se o jogador conseguiu jogar
                    
                
                // troca jogador
                if( jogador == 'O'){
                    // verifica status
                    jogoAtivo = status(M, 'O', 1);
                    jogador = 'X';
                }else{
                    jogoAtivo = status(M, 'X', 2);
                    jogador = 'O';
                }
            }
            else
                System.out.println("Jogador ["+jogador+"] jogue novamente utilizando uma posiÃ§Ã£o valida do tabuleiro.");
            
            
        }
        // imprime vencedor ou empate
        print(M);
        System.out.print("Jogo encerrado:");
        if( jogoAtivo == 0 )
            System.out.println("Empatou");
        else if( jogoAtivo == 1 )
            System.out.println("Jogador 0 venceu!");
        else
            System.out.println("Jogador X venceu!");
       */
    }
    /*
    A funÃ§Ã£o initialize() deverÃ¡ devolver uma matriz de caracteres 3x3,
    com algum valor preenchido para indicar que uma posiÃ§Ã£o nÃ£o foi 
    ocupada
    */
    private static int[][] initialize() {
        //cria uma matriz de caracteres 3x3
        int tabuleiro[][]= new int [6][6];
        int ParteBranca[][]= new int [8][8];
        for( int i=0;i<tabuleiro.length;i++) //anda na linha
            for( int j=0;j<tabuleiro[0].length;j++) //anda na coluna
                for (int k=0;k<ParteBranca[0].length;k++)
                    for(int l=0;l<ParteBranca.length;l++)
               tabuleiro[0][0]=-1;
               tabuleiro[3][2]=-1;
               tabuleiro[5][5]=-1;
               tabuleiro[3][4]=-1;
               tabuleiro[2][3]=-1;
               tabuleiro[1][3]=-1; 
        return tabuleiro;
    }

    private static void print(int[][] M ) {
        for( int i=0;i<M.length;i++){ //anda na linha
            for( int j=0;j<M[0].length;j++) //anda na coluna
                System.out.print("["+M[i][j]+"]");
        
            System.out.println();
        } 
    }
    /*
    A funÃ§Ã£o step receba uma matriz do jogo da velha, uma posiÃ§Ã£o (linha, coluna) 
    e o cÃ³digo do jogador (X ou O) e devolva a matriz com a posiÃ§Ã£o preenchida com o cÃ³digo do jogador, caso esteja livre. 
    Se a posiÃ§Ã£o conseguiu ser preenchida,  step deve retornar true, caso nÃ£o puder ser preenchida, retorna false.
    */
    public static boolean step(int M[ ][ ], int lin, int col, char gamer)
    {
        if(M[lin][col]=='-' ){
            M[lin][col]=gamer;
            return true;
                
        }
       
        return false;
    }
    /*
    a funÃ§Ã£o status recebe a matriz do jogo do jogo da velha e verifica 
    o estado do jogo: se alguÃ©m venceu, ocorreu um empate ou o jogo deve 
    continuar. Vamos usar o seguinte cÃ³digo: 
    -1 (o jogo pode continuar), 
    0 (ocorreu um empate), 
    1 (O venceu) e 
    2 (X venceu). 
    */
    
    public static int status (int M[ ][ ], char jogador, int ret){
        // testa se alguem venceu
        for( int i = 0; i < M.length;i++){
            // testa linha do jogador
            if( M[i][0]==jogador && M[i][1]==jogador && M[i][2]==jogador)
                return ret; 
            // testa coluna do jogador
            if( M[0][i]==jogador && M[1][i]==jogador && M[2][i]==jogador)
                return ret; 
        }
        // diagonal principal
        if( M[0][0]==jogador && M[1][1]==jogador && M[2][2]==jogador)
            return ret;
        // diagonal principal
        if( M[0][2]==jogador && M[1][1]==jogador && M[2][0]==jogador)
            return ret;
        
        // procura um espaco vazio 
        for( int i = 0; i < M.length;i++){
            for( int j = 0; j < M.length;j++){
                if(M[i][j]=='-')//se achei espaco em branco  nao empatou 
                    return -1; //jogo pode continuar
            }
        }
        // se cheguei ate aqui ninguem venceu e nao tem posicao vazia
        // para jogar, ou seja, empatou 
        return 0;
    }
    
}

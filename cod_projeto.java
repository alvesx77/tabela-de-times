package projeto;

import java.util.Scanner;

public class cod_projeto {
	
	private static Scanner leitor=new Scanner(System.in);
	
	static int total_de_times_participantes=3;
	static int total_de_partidas=3;
	
	public static void alocar_memory(obj_projeto times[]) {
		for(int i=0;i<total_de_times_participantes;i++) {
			times[i]=new obj_projeto();
		}
	}
	
	public static void add_times_participantes(obj_projeto times[]) {
		int cont=0;
		String nome;
		while(cont<total_de_times_participantes) {
			System.out.print("digite o nome do "+(cont+1)+"° time: ");
			nome=leitor.nextLine();
			times[cont].set_nome(nome);
			cont++;
		}
	}
	
	public static void add_partidas(obj_projeto times[],int tabela_de_pontos[][]){
		String resultado;
		for(int i=0;i<total_de_times_participantes;i++) {
			int total_de_pontos_de_cada_time=0;
			for(int j=0;j<total_de_partidas;j++) {
				System.out.print("digite V caso o time "+times[i].get_nome()+"\ndigite E caso o time "+times[i].get_nome()+"\n"+"digite P caso o time "+times[i].get_nome()+"\n qual o resultado do time "+times[i].get_nome()+"na "+(j+1)+"° partida: ");
				resultado=leitor.nextLine();
				resultado=resultado.toUpperCase();
				if(resultado.equals("V")){
					tabela_de_pontos[i][j]=3;
					total_de_pontos_de_cada_time+=3;
				}
				else if(resultado.equals("E")) {
					tabela_de_pontos[i][j]=1;
					total_de_pontos_de_cada_time+=1;
				}
				else {
					tabela_de_pontos[i][j]=0;
					total_de_pontos_de_cada_time=0;
					
				}
				times[i].set_ponto(total_de_pontos_de_cada_time);
			}
		}
	}
	
	public static void ordenar_os_times(obj_projeto times[]){
		int ponto;
		String nome;
		for(int i=0;i<total_de_times_participantes;i++) {
			for(int j=0;j<total_de_times_participantes;j++) {
				if(times[i].get_ponto()>times[j].get_ponto()) {
					ponto=times[i].get_ponto();
					nome=times[i].get_nome();
					times[i].set_nome(times[j].get_nome());
					times[i].set_ponto(times[j].get_ponto());
					times[j].set_nome(nome);
					times[j].set_ponto(ponto);
				}
			}
		}
	}
	public static void m_t(obj_projeto times[]) {
		for(int i=0;i<total_de_times_participantes;i++) {
			System.out.print(times[i].get_nome()+times[i].get_ponto()+"\n");
		}
	}
	public static void main(String []args) {
		
		obj_projeto times[]=new obj_projeto[20];
		alocar_memory(times);
		add_times_participantes(times);
		int tabela_de_pontos[][]=new int [total_de_times_participantes][total_de_partidas];
		add_partidas(times,tabela_de_pontos);
		ordenar_os_times(times);
		m_t(times);
	}
}

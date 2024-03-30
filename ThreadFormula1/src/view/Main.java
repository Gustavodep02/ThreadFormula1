package view;

import java.util.concurrent.Semaphore;

import controller.TreinoController;

public class Main {

	public static void main(String[] args) {
		int permissoes = 5;
		int equipe = 1;
		int carro = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		TreinoController[] TreinoControllers = new TreinoController[14];
		for (int i = 0; i < 7; i++) {
			TreinoControllers[i]= new TreinoController(equipe,carro,permissoes,semaforo);
            TreinoControllers[i].start();
            equipe++;
		}
		carro = 2;
		equipe = 1;
		for (int j = 0; j < 7; j++) {
			TreinoControllers[j+7]= new TreinoController(equipe,carro,permissoes,semaforo);
            TreinoControllers[j+7].start();
            equipe++;
		}
		for (int k = 0; k < 14; k++) {
            try {
				TreinoControllers[k].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		TreinoController t = new TreinoController(equipe,carro,permissoes,semaforo);
		t.melhores();
}}

package controller;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class TreinoController extends Thread {
	private int equipe;
	private int carro;
	private int permissoes=5;
	private static int [] melhoresTempos =new int [14];
	Semaphore semaforo = new Semaphore(permissoes);
	Semaphore semaforoEquipe1 = new Semaphore(1);
	Semaphore semaforoEquipe2 = new Semaphore(1);
	Semaphore semaforoEquipe3 = new Semaphore(1);
	Semaphore semaforoEquipe4 = new Semaphore(1);
	Semaphore semaforoEquipe5 = new Semaphore(1);
	Semaphore semaforoEquipe6 = new Semaphore(1);
	Semaphore semaforoEquipe7 = new Semaphore(1);
	
	public TreinoController(int equipe, int carro, int permissoes, Semaphore semaforo) {
		this.equipe = equipe;
		this.carro = carro;
		this.permissoes = permissoes;
		this.semaforo = semaforo;
	}
	@Override
	public void run() {
		switch (equipe) {
		case 1:
			try {
			semaforoEquipe1.acquire();
			try {
                semaforo.acquire();
                treino();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaforo.release();
            }
			}catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            	semaforoEquipe1.release();
            }
			
            break;
        case 2:
        	try {
    			semaforoEquipe2.acquire();
    			try {
                    semaforo.acquire();
                    treino();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaforo.release();
                }
    			}catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                	semaforoEquipe2.release();
                }
    			
                break;
            case 3:
            	try {
        			semaforoEquipe3.acquire();
        			try {
                        semaforo.acquire();
                        treino();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaforo.release();
                    }
        			}catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                    	semaforoEquipe3.release();
                    }
        			
                    break;
            case 4:
            	try {
        			semaforoEquipe4.acquire();
        			try {
                        semaforo.acquire();
                        treino();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaforo.release();
                    }
        			}catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                    	semaforoEquipe4.release();
                    }
        			
                    break;
            case 5:
            	try {
        			semaforoEquipe5.acquire();
        			try {
                        semaforo.acquire();
                        treino();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaforo.release();
                    }
        			}catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                    	semaforoEquipe5.release();
                    }
        			
                    break;
            case 6:
            	try {
        			semaforoEquipe6.acquire();
        			try {
                        semaforo.acquire();
                        treino();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaforo.release();
                    }
        			}catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                    	semaforoEquipe6.release();
                    }
        			
                    break;
            case 7:
            	try {
        			semaforoEquipe7.acquire();
        			try {
                        semaforo.acquire();
                        treino();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaforo.release();
                    }
        			}catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                    	semaforoEquipe7.release();
                    }
        			
                    break;
            default:
            	break;
							
		}
	}
	public void treino() {
		int voltaMenor= 2001 ;
        System.out.println("Carro "+carro+" da equipe " + equipe + " treinando");
        for (int i = 0; i < 3; i++) {
            
        try {
        	int sleep = (int) ((Math.random() * 1001) + 1000);
            Thread.sleep(sleep);
            if (sleep<voltaMenor){
            voltaMenor = sleep;
            }
            System.out.println("Volta "+(i+1)+" do carro "+carro+" da equipe " + equipe + " foi de "+sleep+"ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
        melhoresTempos[((equipe - 1) * 2) + (carro - 1) % 7] = voltaMenor;
        //melhoresTempos[(equipe*carro)-1]=voltaMenor;
        System.out.println("Carro "+carro+" da equipe " + equipe + " terminou de treinar, sua melhor volta foi de "+voltaMenor+"ms");
    }
	public void melhores() {
		Arrays.sort(melhoresTempos);
		for(int i =0;i<14;i++) {
		System.out.println("Melhores tempos: "+melhoresTempos[i]);
		}
	}
}

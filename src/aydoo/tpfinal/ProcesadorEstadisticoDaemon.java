package aydoo.tpfinal;

import java.io.IOException;

public class ProcesadorEstadisticoDaemon implements ProcesadorEstadistico {
	
	private String pathEntrada;
	private String pathDeSalidaInforme="salidas/daemon/YML/";
	private ProcesadorDeDatos procesador;
	
	public ProcesadorEstadisticoDaemon(String pathEntrada) {
		
		this.pathEntrada = pathEntrada;
		this.procesador = new ProcesadorDeDatos();
		
	}
	

	@Override
	public void ejecutar() {

		SupervisadorDeDirectorio supervisador = new SupervisadorDeDirectorio(this.pathEntrada, this);
		supervisador.correrSupervisadorDeDirectorio();

	}

	public void generarInforme() {

		try {
			this.procesador.generarInforme(this.pathEntrada,
					this.pathDeSalidaInforme, true);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
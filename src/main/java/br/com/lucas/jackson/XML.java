package br.com.lucas.jackson;

import java.util.List;

public interface XML {

	public abstract void escreveListaNoArquivo();
	
	public abstract List<?> getLista();
}

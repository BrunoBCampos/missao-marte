package br.com.elo7.banco;

public interface Repository {
	
	void cadastrar(Object o);
	void atualizar(Object o);
	<T> T buscar(Class<T> tipo, Long id);

}

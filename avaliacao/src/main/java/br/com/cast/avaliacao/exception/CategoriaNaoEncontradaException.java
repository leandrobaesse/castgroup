package br.com.cast.avaliacao.exception;

public class CategoriaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public CategoriaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public CategoriaNaoEncontradaException(Long categoriaId) {
		this(String.format("Não existe uma categoria de curso com código %d", categoriaId));
	}
	
}

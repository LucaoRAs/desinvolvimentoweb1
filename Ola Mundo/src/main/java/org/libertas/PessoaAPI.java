package org.libertas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

import com.google.gson.Gson;

/**
 * Servlet implementation class PessoaAPI
 */
//@WebServlet("/PessoaAPI/*")
public class PessoaAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PessoaAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PessoaDao pdao = new PessoaDao();
		Gson gson = new Gson();
		
		int id = 0;
		try {
			id = Integer.parseInt( request.getPathInfo().substring(1));
		} catch (Exception e) {
		}
		
		String resposta;
		if (id==0) {
			//listar todos
			resposta = gson.toJson(pdao.listar());
		} else {
			//consultar apenas 1
			resposta = gson.toJson(pdao.consultar(id));
		}
		
		response.setHeader("content-type", "application/json");
		response.getWriter().print(resposta);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pega o body da requisiçao
		String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		//converte o body p obj java
		Gson gson = new Gson();
		Pessoa p = gson.fromJson(body, Pessoa.class);
		
		//salva a nova pessoa
		PessoaDao pdao = new PessoaDao();
		Retorno retorno = pdao.inserir(p);
		
		//envia resposta
		
		String resposta = gson.toJson(retorno);
		response.setHeader("content-type", "application/json");
		response.getWriter().print(resposta);
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pega o body da requisição
		String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		//converte o body para um obj java
		Gson gson = new Gson();
		Pessoa p = gson.fromJson(body, Pessoa.class);
		
		//pega o id passado por parametro
		int id = 0;
		try {
			id = Integer.parseInt( request.getPathInfo().substring(1));
		} catch (Exception e) {
		}
		p.setIdpessoa(id);
		
		//salva 
		PessoaDao pdao = new PessoaDao();
		Retorno retorno = pdao.alterar(p);
		
		//envia resposta
		String resposta = gson.toJson(retorno);
		response.setHeader("content-type", "application/json");
		response.getWriter().print(resposta);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pega o id passado por parametro
		int id = 0;
		try {
			id = Integer.parseInt( request.getPathInfo().substring(1));
		} catch (Exception e) {
		}
		
		//exclui a nova pessoa
		PessoaDao pdao = new PessoaDao();
		Pessoa p = new Pessoa();
		Gson gson = new Gson();
		p.setIdpessoa(id);
		Retorno retorno = pdao.excluir(p);
		
		//envia a resposta
		String resposta = gson.toJson(retorno);
		response.setHeader("content-type", "application/json");
		response.getWriter().print(resposta);
	}

}

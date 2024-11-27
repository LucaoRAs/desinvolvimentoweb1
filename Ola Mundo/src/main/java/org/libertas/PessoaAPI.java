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
			//pega o id passado por parametro 
			id = Integer.parseInt(request.getPathInfo().substring(1));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
				
		String pesquisa = request.getParameter("pesquisa");
		
		String resposta;
		if (id==0) {
			//listar todos
			resposta = gson.toJson(pdao.listar(pesquisa));
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
		//pega o body da request
		String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		//converte o body para um objeto Java
		Gson gson = new Gson();
		Pessoa p = gson.fromJson(body,  Pessoa.class);
		
		//salva a nova pessoa
		PessoaDao pdao = new PessoaDao();
//		pdao.inserir(p);
		
		
		
		//envia a resposta
		String resposta = gson.toJson(pdao.inserir(p));
		response.setHeader("content-type", "application/json");
		response.getWriter().print(resposta);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pega o body da request
		String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		//converte o body para um objeto Java
		Gson gson = new Gson();
		Pessoa p = gson.fromJson(body,  Pessoa.class);
		
		//pega o id passado por parametro
		int id = 0;
		try {
			id = Integer.parseInt(request.getPathInfo().substring(1));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		p.setIdpessoa(id);
		
		//salva a nova pessoa
		PessoaDao pdao = new PessoaDao();
		pdao.alterar(p);
				
		
		//envia a resposta
		String resposta = gson.toJson(pdao.alterar(p));
		response.setHeader("content-type", "application/json");
		response.getWriter().print(resposta);		
		
		
	}
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pega o id passado por parametro
		int id = 0;
		try {
			id = Integer.parseInt(request.getPathInfo().substring(1));
					
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//exclui a nova pessoa
		PessoaDao pdao = new PessoaDao();
		Pessoa p = new Pessoa();
		Gson gson = new Gson();
		p.setIdpessoa(id);
		pdao.excluir(p);
		
		//evia resposta
		
		String resposta = gson.toJson(pdao.excluir(p));
		response.setHeader("content-type", "application/json");
		response.getWriter().print(resposta);	
	}

}
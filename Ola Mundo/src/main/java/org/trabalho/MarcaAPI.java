package org.trabalho;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;
import com.google.gson.Gson;

@WebServlet("/MarcaAPI/*")
public class MarcaAPI extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MarcaAPI() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MarcaDao mdao = new MarcaDao();
        Gson gson = new Gson();

        int id = 0;
        try {
            id = Integer.parseInt(request.getPathInfo().substring(1));
        } catch (Exception e) {
            // No ID in URL; defaults to 0 and lists all
        }

        String resposta;
        if (id == 0) {
            // Listar marca
            resposta = gson.toJson(mdao.listar());
        } else {
            // Consulta marca
            resposta = gson.toJson(mdao.consultar(id));
        }

        response.setContentType("application/json");
        response.getWriter().print(resposta);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Gson gson = new Gson();
        Marca m = gson.fromJson(body, Marca.class);

        MarcaDao mdao = new MarcaDao();
        mdao.inserir(m);

        String resposta = "inserido com sucesso";
        response.getWriter().print(resposta);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));

        Gson gson = new Gson();
        Marca m = gson.fromJson(body, Marca.class);

        int id = 0;
        try {
            id = Integer.parseInt(request.getPathInfo().substring(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        m.setId(id);

        MarcaDao mdao = new MarcaDao();
        mdao.alterar(m);

        String resposta = "alterado com sucesso";
        response.getWriter().print(resposta);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getPathInfo().substring(1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        MarcaDao mdao = new MarcaDao();
        Marca m = new Marca();
        m.setId(id);
        mdao.excluir(m);

        String resposta = "excluido com sucesso";
        response.getWriter().print(resposta);
    }
}

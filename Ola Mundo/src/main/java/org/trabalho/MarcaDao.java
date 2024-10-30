package org.trabalho;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class MarcaDao {

    public void salvar(Marca m) {
        if (m.getId() > 0) {
            alterar(m);
        } else {
            inserir(m);
        }
    }

    public void inserir(Marca m) {
        Conexao con = new Conexao();
        try {
            String sql = "INSERT INTO marca (nome, descricao, pais_origem, ano_fundacao, website)"
                    + " VALUES (?,?,?,?,?)";
            PreparedStatement prep = con.getConnection().prepareStatement(sql);
            prep.setString(1, m.getNome());
            prep.setString(2, m.getDescricao());
            prep.setString(3, m.getPaisOrigem());
            prep.setInt(4, m.getAnoFundacao());
            prep.setString(5, m.getWebsite());
            prep.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        con.desconecta();
    }

    public LinkedList<Marca> listar() {
        LinkedList<Marca> lista = new LinkedList<Marca>();
        Conexao con = new Conexao();
        try {
            String sql = "SELECT * FROM marca";
            Statement sta = con.getConnection().createStatement();
            ResultSet res = sta.executeQuery(sql);
            while (res.next()) {
                Marca m = new Marca();
                m.setId(res.getInt("id"));
                m.setNome(res.getString("nome"));
                m.setDescricao(res.getString("descricao"));
                m.setPaisOrigem(res.getString("pais_origem"));
                m.setAnoFundacao(res.getInt("ano_fundacao"));
                m.setWebsite(res.getString("website"));
                lista.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        con.desconecta();
        return lista;
    }

    public void alterar(Marca m) {
        Conexao con = new Conexao();
        try {
            String sql = "UPDATE marca SET nome = ?, descricao = ?, pais_origem = ?, ano_fundacao = ?, website = ? WHERE id = ?";
            PreparedStatement prep = con.getConnection().prepareStatement(sql);
            prep.setString(1, m.getNome());
            prep.setString(2, m.getDescricao());
            prep.setString(3, m.getPaisOrigem());
            prep.setInt(4, m.getAnoFundacao());
            prep.setString(5, m.getWebsite());
            prep.setInt(6, m.getId());
            prep.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        con.desconecta();
    }

    public void excluir(Marca m) {
        Conexao con = new Conexao();
        try {
            String sql = "DELETE FROM marca WHERE id = ?";
            PreparedStatement prep = con.getConnection().prepareStatement(sql);
            prep.setInt(1, m.getId());
            prep.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        con.desconecta();
    }

    public Marca consultar(int id) {
        Marca m = new Marca();
        Conexao con = new Conexao();
        try {
            String sql = "SELECT * FROM marca WHERE id = " + id;
            Statement sta = con.getConnection().createStatement();
            ResultSet res = sta.executeQuery(sql);
            if (res.next()) {
                m.setId(res.getInt("id"));
                m.setNome(res.getString("nome"));
                m.setDescricao(res.getString("descricao"));
                m.setPaisOrigem(res.getString("pais_origem"));
                m.setAnoFundacao(res.getInt("ano_fundacao"));
                m.setWebsite(res.getString("website"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        con.desconecta();
        return m;
    }
}
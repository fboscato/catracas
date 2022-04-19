/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faee.service;

import br.com.faee.ConexaoBD;
import br.com.faee.model.Catraca;
import br.com.faee.model.ExameFisico;
import br.com.faee.model.ExameMedico;
import br.com.faee.model.LancamentoConta;
import br.com.faee.model.ParametroCatraca;
import br.com.faee.model.Pessoa;
import br.com.faee.model.Usuario;
import br.com.faee.repository.PessoaRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

/**
 *
 * @author mauricio
 */
public class ValidacaoCatraca {

    ConexaoBD connect = new ConexaoBD();
    PessoaRepository pessoaRepository = new PessoaRepository();

    public String validacao(Integer codigo, String ipCatraca, String tipoLeitura, Integer idCatraca, List<ParametroCatraca> parametros, BigDecimal acesso) throws SQLException, IOException {
        connect.conexao();
//        if(tipoLeitura != null){
        Pessoa pessoa = buscaPessoa(tipoLeitura, codigo, acesso);
        Catraca catraca = buscaCatracaPorIp(ipCatraca);
        URL url = new URL("https://clube.faee.com.br/backend/catraca/recebeConteudoDispositivo?e=srmampituba&t=Baer%20eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjksImlhdCI6MTYwNjQyOTA4MX0.HfsgYtL3AkS_dlhGMTJ7UZV6TQPI7Lt8-vYR4ykp14s"
                + "&conteudo=" + codigo + "&catraca_id=" + idCatraca);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        String line = "";
        InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder response = new StringBuilder();
         System.out.println("Enstrou ");
        //verificar se existe cadastro da pessoaok ag
        if (pessoa.getId() != null) {
            if (pessoa.getUltimoAcesso() == null || LocalDateTime.now().isAfter(pessoa.getUltimoAcesso())) {
                System.out.print(pessoa.getUltimoAcesso());
                pessoa.setUltimoAcesso(LocalDateTime.now().plusMinutes(catraca.getTempoBloqueio()));
                pessoaRepository.alterar(pessoa, connect);
            } else {
                entradaHistorico(catraca, pessoa, "Entrada bloqueada durante " + catraca.getTempoBloqueio() + " minutos", false);
                System.out.println("Nao Liberou: Tempo");
                return "01+REON+00+30]5]Entrada bloqueada durante " + catraca.getTempoBloqueio() + " minutos]";
            }
            //verifica se é funcionario            
            for (Usuario usuario : buscaUsuariosPorPessoa(pessoa.getId())) {
                if (usuario.getTipoUsuario().equals("funcionario")) {
                    entradaHistorico(catraca, pessoa, null, true);
                    System.out.println("Liberou " + pessoa.getId());
                    return "01+REON+00+1]5]Acesso liberado]";
                }
            }
            for (int i = 0; i < parametros.size(); i++) {
                if (parametros.get(i).getDescricao().equals("Financeiro") && buscaVencidosPorPessoa(pessoa.getId(), parametros.get(i).getDias()).getId() != null) {
                    entradaHistorico(catraca, pessoa, parametros.get(i).getDescricao(), false);
                    System.out.println("Nao Liberou: Financeiro");
                    return "01+REON+00+30]5]Acesso Negado Pendência Financeira]";
                }
                if (parametros.get(i).getDescricao().equals("Exame Médico") && buscaExameMedicoVencidoPorPessoa(pessoa.getId(), parametros.get(i).getDias()).getId() != null) {
                    entradaHistorico(catraca, pessoa, parametros.get(i).getDescricao(), false);
                    System.out.println("Nao Liberou: exame médico");
                    return "01+REON+00+30]5]Acesso Negado Exame médico vencido]";
                }
                if (parametros.get(i).getDescricao().equals("Exame Físico") && buscaExameFisicoVencidoPorPessoa(pessoa.getId(), parametros.get(i).getDias()).getId() != null) {
                    entradaHistorico(catraca, pessoa, parametros.get(i).getDescricao(), false);
                    System.out.println("Nao Liberou: exame físico");
                    return "01+REON+00+30]5]Acesso Negado Exame físico vencido]";
                }
            }
            entradaHistorico(catraca, pessoa, null, true);
            System.out.println("Liberou " + pessoa.getId());
            return "01+REON+00+1]5]Acesso liberado]";
        } else {
            entradaHistorico(catraca, pessoa, "CADASTRO NÃO ENCONTRADO!", false);
            System.out.println("Não encontrado"+ pessoa.getId());
            return "01+REON+00+30]5]Cadastro não encontrado]";
        } 
    }

    private void entradaHistorico(Catraca catraca, Pessoa pessoa, String motivo, Boolean autorizacao) throws SQLException, MalformedURLException, IOException {
        URL url = new URL("http://clube.faee.com.br/backend/catraca/entradaHistorico?e=srmampituba&t=Baer%20eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjksImlhdCI6MTYwNjQyOTA4MX0.HfsgYtL3AkS_dlhGMTJ7UZV6TQPI7Lt8-vYR4ykp14s"
                + "&catraca_id=" + catraca.getId() + "&pessoa_id=" + pessoa.getId() + "&motivo=" + motivo + "&autorizacao=" + autorizacao);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
    }

    private Pessoa buscaPessoa(String tipoLeitura, Integer codigo, BigDecimal acesso) throws SQLException {

        if (codigo != null) {
            connect.executaSQL("select * from pessoa where " + tipoLeitura + " = " + codigo);
        }
        if (acesso != null) {
            connect.executaSQL("select * from pessoa where " + tipoLeitura + " = " + acesso);
        }
        Pessoa pessoa = new Pessoa();
        if (connect.rs != null && connect.rs.first() == true) {
            pessoa.setId(connect.rs.getInt("id"));
            pessoa.setNome(connect.rs.getString("nome"));
            pessoa.setBarcode(connect.rs.getBigDecimal("barcode"));
            pessoa.setRfid(connect.rs.getBigDecimal("rfid"));
            pessoa.setCpf(connect.rs.getString("cpf"));
            pessoa.setUltimoAcesso(connect.rs.getTimestamp("ultimo_acesso") != null ? new LocalDateTime(connect.rs.getTimestamp("ultimo_acesso")) : null);
        }
        return pessoa;
    }

    private List<Usuario> buscaUsuariosPorPessoa(Integer id) throws SQLException {
        connect.executaSQL("select * from usuario where pessoa_id = " + id);
        List<Usuario> lista = new ArrayList<>();
        while (connect.rs.next()) {
            Usuario usuario = new Usuario(connect.rs.getInt("id"), connect.rs.getInt("pessoa_id"), connect.rs.getString("tipo_usuario"));
            lista.add(usuario);
        }
        return lista;
    }

    private Catraca buscaCatracaPorIp(String ip) throws SQLException {
        connect.executaSQL("select * from catraca where ip = '" + ip + "'");
        Catraca catraca = new Catraca();
        if (connect.rs.first() == true) {
            catraca.setId(connect.rs.getInt("id"));
            catraca.setIp(connect.rs.getString("ip"));
            catraca.setNome(connect.rs.getString("nome"));
        }
        return catraca;
    }

    private ExameMedico buscaExameMedicoVencidoPorPessoa(Integer pessoa_id, Integer dias) throws SQLException {
        connect.executaSQL("select * from exame_medico where pessoa_id = " + pessoa_id + " and data_validade < '" + new LocalDate().minusDays(dias) + "'");
        ExameMedico exameMedico = new ExameMedico();
        try {
            if (connect.rs.first() == true) {
                exameMedico.setId(connect.rs.getInt("id"));
            }
        } catch (Exception e) {
        }
        return exameMedico;
    }

    private ExameFisico buscaExameFisicoVencidoPorPessoa(Integer pessoa_id, Integer dias) throws SQLException {
        connect.executaSQL("select * from exame_fisico where pessoa_id = " + pessoa_id + " order by data_validade desc");
        ExameFisico exameFisico = new ExameFisico();
        if (connect.rs.first() == true) {
            Timestamp hoje = new Timestamp(System.currentTimeMillis());
            Timestamp data_validade = connect.rs.getTimestamp("data_validade");
            if (hoje.after(data_validade)) {
                exameFisico.setId(connect.rs.getInt("id"));
            }
        }
        return exameFisico;
    }

    private LancamentoConta buscaVencidosAMais60DiasPorPessoa(Integer pessoa_id) throws SQLException {
        connect.executaSQL("select * from lancamento_conta where pessoa_id=" + pessoa_id + " and data_vencimento < '" + new LocalDate().minusDays(60) + "'"
                + " and data_pagamento is null");
        LancamentoConta lancamentoConta = new LancamentoConta();
        if (connect.rs.first() == true) {
            lancamentoConta.setId(connect.rs.getInt("id"));
        }
        return lancamentoConta;
    }

    private LancamentoConta buscaVencidosPorPessoa(Integer pessoa_id, Integer dias) throws SQLException {
        connect.executaSQL("select * from lancamento_conta where pessoa_id=" + pessoa_id + " and data_vencimento < '" + new LocalDate().minusDays(dias) + "'"
                + " and data_pagamento is null");
        LancamentoConta lancamentoConta = new LancamentoConta();
        if (connect.rs.first() == true) {
            lancamentoConta.setId(connect.rs.getInt("id"));
        }
        return lancamentoConta;
    }

}

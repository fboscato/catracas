/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faee;

import br.com.faee.model.Catraca;
import br.com.faee.repository.CatracaRepository;
import br.com.faee.service.ValidacaoCatraca;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import tcpcom.TcpClient;

/**
 *
 * @author mauricio
 */
public class ThreadCatraca {

    private TcpClient client;
    private TcpClient client2;
    private TcpClient client3;
    private TcpClient client4;
    private TcpClient client5;
    private TcpClient client6;
    private TcpClient client7;
    private TcpClient client8;
    private TcpClient client9;
    private TcpClient client10;
    private static List<Catraca> listaCatraca;

    public void gerenciamentoCatracas() throws SQLException {
        new Thread(new Runnable() {
            public void run() {
                ConexaoBD connect = new ConexaoBD();
                connect.conexao();
                try {
                        CatracaRepository catracaRepository = new CatracaRepository();
                        listaCatraca = catracaRepository.todosComParametros(connect);
                        if (listaCatraca.size() > 0) {
                            if (client == null || !client.isConnected()) {
                                catraca1(listaCatraca, connect);
                                if (listaCatraca.get(0).getStatusConexao().equals("Online")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(0).getId(), "Offline", connect);
                                }
                            } else {
                                if (listaCatraca.get(0).getStatusConexao().equals("Offline")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(0).getId(), "Online", connect);
                                }
                            }
                        }
                        if (listaCatraca.size() > 1) {
                            if (client2 == null || !client2.isConnected()) {
                                catraca2(listaCatraca, connect);
                                if (listaCatraca.get(1).getStatusConexao().equals("Online")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(1).getId(), "Offline", connect);
                                }
                            } else {
                                if (listaCatraca.get(1).getStatusConexao().equals("Offline")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(1).getId(), "Online", connect);
                                }
                            }
                        }
                        if (listaCatraca.size() > 2) {
                            if (client3 == null || !client3.isConnected()) {
                                catraca3(listaCatraca, connect);
                                if (listaCatraca.get(2).getStatusConexao().equals("Online")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(2).getId(), "Offline", connect);
                                }
                            } else {
                                if (listaCatraca.get(2).getStatusConexao().equals("Offline")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(2).getId(), "Online", connect);
                                }
                            }
                        }
                        if (listaCatraca.size() > 3) {
                            if (client4 == null || !client4.isConnected()) {
                                catraca4(listaCatraca, connect);
                                if (listaCatraca.get(3).getStatusConexao().equals("Online")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(3).getId(), "Offline", connect);
                                }
                            } else {
                                if (listaCatraca.get(3).getStatusConexao().equals("Offline")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(3).getId(), "Online", connect);
                                }
                            }
                        }
                        if (listaCatraca.size() > 4) {
                            if (client5 == null || !client5.isConnected()) {
                                catraca5(listaCatraca, connect);
                                if (listaCatraca.get(4).getStatusConexao().equals("Online")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(4).getId(), "Offline", connect);
                                }
                            } else {
                                if (listaCatraca.get(4).getStatusConexao().equals("Offline")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(4).getId(), "Online", connect);
                                }
                            }
                        }
                        if (listaCatraca.size() > 5) {
                            if (client6 == null || !client6.isConnected()) {
                                catraca6(listaCatraca, connect);
                                if (listaCatraca.get(5).getStatusConexao().equals("Online")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(5).getId(), "Offline", connect);
                                }
                            } else {
                                if (listaCatraca.get(5).getStatusConexao().equals("Offline")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(5).getId(), "Online", connect);
                                }
                            }
                        }
                        if (listaCatraca.size() > 6) {
                            if (client7 == null || !client7.isConnected()) {
                                catraca7(listaCatraca, connect);
                                if (listaCatraca.get(6).getStatusConexao().equals("Online")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(6).getId(), "Offline", connect);
                                }
                            } else {
                                if (listaCatraca.get(6).getStatusConexao().equals("Offline")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(6).getId(), "Online", connect);
                                }
                            }
                        }
                        if (listaCatraca.size() > 7) {
                            if (client8 == null || !client8.isConnected()) {
                                catraca8(listaCatraca, connect);
                                if (listaCatraca.get(7).getStatusConexao().equals("Online")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(7).getId(), "Offline", connect);
                                }
                            } else {
                                if (listaCatraca.get(7).getStatusConexao().equals("Offline")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(7).getId(), "Online", connect);
                                }
                            }
                        }
                        if (listaCatraca.size() > 8) {
                            if (client9 == null || !client9.isConnected()) {
                                catraca9(listaCatraca, connect);
                                if (listaCatraca.get(8).getStatusConexao().equals("Online")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(8).getId(), "Offline", connect);
                                }
                            } else {
                                if (listaCatraca.get(8).getStatusConexao().equals("Offline")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(8).getId(), "Online", connect);
                                }
                            }
                        }
                        if (listaCatraca.size() > 9) {
                            if (client10 == null || !client10.isConnected()) {
                                catraca10(listaCatraca, connect);
                                if (listaCatraca.get(9).getStatusConexao().equals("Online")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(9).getId(), "Offline", connect);
                                }
                            } else {
                                if (listaCatraca.get(9).getStatusConexao().equals("Offline")) {
                                    catracaRepository.alterarStatus(listaCatraca.get(9).getId(), "Online", connect);
                                }
                            }
                        }
                        Thread.sleep(10000);  //esperando resposta quem da a resposta?
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }).start();

    }

    public String textFormat(char[] data) {
        String aux = "", aux2 = "", str = "";
        char BYTE_INIT, BYTE_END, BYTE_TAM[] = {0, 0}, BYTE_CKSUM;
        BYTE_INIT = (char) Integer.valueOf("2", 16).intValue();//conf. bit inicial
        BYTE_END = (char) Integer.valueOf("3", 16).intValue();//conf. bit final
        BYTE_TAM[0] = (char) data.length;//conf. tamanho dos dados
        BYTE_TAM[1] = (char) Integer.valueOf("0", 16).intValue();
        aux2 += BYTE_INIT; //Inserindo byte inicial
        aux2 += BYTE_TAM[0]; //Inserindo byte do tamanho
        aux2 += BYTE_TAM[1];
        for (char chr : data) {
            str += chr;
        }
        aux = new String(aux2 + str); // concatenando com a informação

        BYTE_CKSUM = aux.charAt(1);//Calculo do Checksum
        for (int a = 2; a < aux.length(); a++) {
            BYTE_CKSUM = (char) (BYTE_CKSUM ^ aux.charAt(a));
        }
        aux += BYTE_CKSUM; //Inserindo Checksum
        aux += BYTE_END; //Inserindo byte Final
        return aux;

    }

    public String stringHexFormat(String str) {
        String aux = "", temp = "";
        for (char ch : str.toCharArray()) {
            temp += Integer.toHexString(ch).toUpperCase();
            //Converte Hexa em String
            if (temp.length() == 1) {
                aux += "0" + temp + " ";//se tiver 1 digito complementa com 0
            } else {
                aux += temp + " ";
            }
            temp = new String();
        }
        return aux;
    }

    private static boolean isInteger(String str) {
        return str != null && str.matches("[0-9]*");
    }

    final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    private void catraca1(final List<Catraca> lista, ConexaoBD connect) throws SQLException {
        if (lista.size() > 0 && !lista.get(0).getIp().equals("000.000.000.000")) {
            client = new TcpClient(lista.get(0).getIp(), 3000);
            client.connect();
            if (client.isConnected()) {
                CatracaRepository catracaRepository = new CatracaRepository();
                if (lista.get(0).getStatusConexao().equals("Offline")) {
                    catracaRepository.alterarStatus(lista.get(0).getId(), "Online", connect);
                }
                service.scheduleAtFixedRate(new Runnable() {
                    @Override
                    public void run() {
//                        try {
//                            while (true) {
                        Boolean pacoteEnviado = false;
                        if (client.availableData() > 0) {
//                                if (client.availableData() > 0 && client.availableData() != 46) {
                            char[] temp = client.receiveData(client.availableData()); //recebendo dados
                            String str = "";
                            for (char chr : temp) {
                                str += chr;
                            }
                            //enviar instrução
                            if (pacoteEnviado == false) {
//                                if (str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30")) {
                                    try {
                                        Integer codigo = null;
                                        BigDecimal acesso = null;
                                        Integer IDLeitura = Integer.parseInt(str.substring(str.length() - 3, str.length() - 2));
                                        switch (IDLeitura) {
                                            case 1:
                                                if (str.substring(6, 17).equals("REON+000+0]")) {
                                                    if (isInteger(str.substring(25, 37))) {
                                                        acesso = new BigDecimal(str.substring(25, 37));
                                                    }
                                                }
                                                if (str.substring(6, 17).equals("REON+000+30")) {
                                                    if (isInteger(str.substring(72, 83))) {
                                                        acesso = new BigDecimal(str.substring(72, 83));
                                                    }
                                                }
                                                validacao(str, codigo, lista, "barcode", acesso);
                                                break;
                                            case 2:
                                                if (str.substring(6, 17).equals("REON+000+0]")) {
                                                    codigo = Integer.parseInt(str.substring(25, 37));
                                                }
                                                if (str.substring(6, 17).equals("REON+000+30")) {
                                                    codigo = Integer.parseInt(str.substring(72, 83));
                                                }
                                                validacao(str, codigo, lista, "rfid", acesso);
                                                break;
                                            case 4:
                                                if (str.substring(6, 17).equals("REON+000+0]")) {
                                                    acesso = new BigDecimal(str.substring(25, 37));
                                                }
                                                if (str.substring(6, 17).equals("REON+000+30")) {
                                                    acesso = new BigDecimal(str.substring(72, 83));
                                                }
                                                validacao(str, codigo, lista, "cpf", acesso);
                                                break;
                                            case 5:
                                                codigo = Integer.parseInt(str.substring(str.length() - 38, str.length() - 28));
                                                validacao(str, codigo, lista, "biometria", acesso);
                                                break;
                                            default:
                                                validacao(str, null, null, null, null);
                                                break;
                                        }
                                    } catch (SQLException | IOException ex) {
                                        Logger.getLogger(ThreadCatraca.class.getName()).log(Level.SEVERE, null, ex);
                                    }

//                                }
                                pacoteEnviado = true;

                            }

                            //valida retorno se a catraca liberou com sucesso
                            if (str.substring(6, 17).equals("REON+000+80") || str.substring(6, 17).equals("REON+000+30")
                                    || str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30]")
                                    || str.substring(6, 17).equals("REON+00+30]")) {
                                pacoteEnviado = false;
                            }
                        }
//                                Thread.sleep(700);  //esperando resposta
//                            }
//                        } catch (IOException | InterruptedException | NumberFormatException | SQLException e) {
//                            System.err.println(e);
//                        }
                    }
                }, 1, 700, TimeUnit.MILLISECONDS);
            }
        }
    }

    private void validacao(String str, Integer codigo, List<Catraca> lista, String tipoLeitura, BigDecimal acesso) throws SQLException, IOException {
        if (str.substring(39, 40).equals("2")) {
            System.out.println("Saiu");
            client.sendData("01+REON+00+6]5]Saída Liberada]".toCharArray());
        } 
        if(tipoLeitura != null){
            if(acesso != null  || codigo != null){
                ValidacaoCatraca validacaoCatraca = new ValidacaoCatraca();
            char[] data;
            data = validacaoCatraca.validacao(codigo, lista.get(0).getIp(), tipoLeitura, lista.get(0).getId(),
                    lista.get(0).getParametros(), acesso).toCharArray();
            str = textFormat(data);//formatando texto (cabeçalho, checksum e Byte final)
            client.sendData(str.toCharArray()); 
            }
        }
    }

    private void catraca2(final List<Catraca> lista, ConexaoBD connect) throws SQLException {

        final Catraca catraca = lista.get(1);
        client2 = new TcpClient(catraca.getIp(),
                3000);
        client2.connect();
        if (client2.isConnected()) {
            CatracaRepository catracaRepository = new CatracaRepository();
            if (catraca.getStatusConexao().equals("Offline")) {
                catracaRepository.alterarStatus(catraca.getId(), "Online", connect);
            }
            new Thread(new Runnable() {
                public void run() {
                    String aux2 = "";
                    Boolean pacoteEnviado = false;
                    try {
                        while (true) {
                            if (client2.availableData() > 0 && client2.availableData() != 46) {
                                char[] temp = client2.receiveData(client2.
                                        availableData()); //recebendo dados
                                String str = "", aux = "";
                                for (char chr : temp) {
                                    str += chr;
                                }
                                //enviar instrução
                                if (pacoteEnviado == false) {
                                    if (str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30")) {
                                        //verifica qual é tipo de leitura
                                        String tipoLeitura = "";
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 5) {
                                            tipoLeitura = "biometria";
                                        }
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 2) {
                                            tipoLeitura = "rfid";
                                        }
                                        Integer codigo = null;
                                        BigDecimal acesso = new BigDecimal(BigInteger.ZERO);
                                        if (tipoLeitura.equals("rfid")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                codigo = Integer.parseInt(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                codigo = Integer.parseInt(str.substring(72, 83));
                                            }
                                        }
                                        if (tipoLeitura.equals("biometria")) {
                                            codigo = Integer.parseInt(str.substring(str.length() - 38, str.length() - 28));
                                        }
                                        if (tipoLeitura.equals("cpf")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                acesso = new BigDecimal(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                acesso = new BigDecimal(str.substring(72, 83));
                                            }
                                        }
                                        ValidacaoCatraca validacaoCatraca = new ValidacaoCatraca();
                                        char[] data;
                                        data = validacaoCatraca.validacao(codigo, catraca.getIp(), tipoLeitura, catraca.getId(),
                                                catraca.getParametros(), acesso).toCharArray();
                                        str = textFormat(data);//formatando texto (cabeçalho, checksum e Byte final)
                                        aux = stringHexFormat(str);//formatando para numero Hexadecimal
                                        client2.sendData(str.toCharArray());
                                    }

                                    pacoteEnviado = true;
                                }

                                //valida retorno se a catraca liberou com sucesso
                                if (str.substring(6, 17).equals("REON+000+80") || str.substring(6, 17).equals("REON+000+30")
                                        || str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30]")
                                        || str.substring(6, 17).equals("REON+00+30]")) {
                                    pacoteEnviado = false;
                                }
                            }
                            Thread.sleep(500);  //esperando resposta
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
            }).start();
        }
    }

    private void catraca3(final List<Catraca> lista, ConexaoBD connect) throws SQLException {
        final Catraca catraca = lista.get(2);
        client3 = new TcpClient(catraca.getIp(),
                3000);
        client3.connect();
        if (client3.isConnected()) {
            CatracaRepository catracaRepository = new CatracaRepository();
            if (catraca.getStatusConexao().equals("Offline")) {
                catracaRepository.alterarStatus(catraca.getId(), "Online", connect);
            }
            new Thread(new Runnable() {
                public void run() {
                    String aux2 = "";
                    Boolean pacoteEnviado = false;
                    try {
                        while (true) {
                            if (client3.availableData() > 0 && client3.availableData() != 46) {
                                char[] temp = client3.receiveData(client3.
                                        availableData()); //recebendo dados
                                String str = "", aux = "";
                                for (char chr : temp) {
                                    str += chr;
                                }
                                //enviar instrução
                                if (pacoteEnviado == false) {
                                    if (str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30")) {
                                        //verifica qual é tipo de leitura
                                        String tipoLeitura = "";
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 5) {
                                            tipoLeitura = "biometria";
                                        }
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 2) {
                                            tipoLeitura = "rfid";
                                        }
                                        Integer codigo = null;
                                        BigDecimal acesso = new BigDecimal(BigInteger.ZERO);
                                        if (tipoLeitura.equals("rfid")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                codigo = Integer.parseInt(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                codigo = Integer.parseInt(str.substring(72, 83));
                                            }
                                        }
                                        if (tipoLeitura.equals("biometria")) {
                                            codigo = Integer.parseInt(str.substring(str.length() - 38, str.length() - 28));
                                        }
                                        if (tipoLeitura.equals("cpf")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                acesso = new BigDecimal(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                acesso = new BigDecimal(str.substring(72, 83));
                                            }
                                        }
                                        ValidacaoCatraca validacaoCatraca = new ValidacaoCatraca();
                                        char[] data;
                                        data = validacaoCatraca.validacao(codigo, catraca.getIp(), tipoLeitura, catraca.getId(),
                                                catraca.getParametros(), acesso).toCharArray();
                                        str = textFormat(data);//formatando texto (cabeçalho, checksum e Byte final)
                                        aux = stringHexFormat(str);//formatando para numero Hexadecimal
                                        client3.sendData(str.toCharArray());
                                    }

                                    pacoteEnviado = true;
                                }

                                //valida retorno se a catraca liberou com sucesso
                                if (str.substring(6, 17).equals("REON+000+80") || str.substring(6, 17).equals("REON+000+30")
                                        || str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30]")
                                        || str.substring(6, 17).equals("REON+00+30]")) {
                                    pacoteEnviado = false;
                                }
                            }
                            Thread.sleep(500);  //esperando resposta
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
            }).start();
        }
    }

    private void catraca4(final List<Catraca> lista, ConexaoBD connect) throws SQLException {
        final Catraca catraca = lista.get(3);
        client4 = new TcpClient(catraca.getIp(),
                3000);
        client4.connect();
        if (client4.isConnected()) {
            CatracaRepository catracaRepository = new CatracaRepository();
            if (catraca.getStatusConexao().equals("Offline")) {
                catracaRepository.alterarStatus(catraca.getId(), "Online", connect);
            }
            new Thread(new Runnable() {
                public void run() {
                    String aux2 = "";
                    Boolean pacoteEnviado = false;
                    try {
                        while (true) {
                            if (client4.availableData() > 0 && client4.availableData() != 46) {
                                char[] temp = client4.receiveData(client4.
                                        availableData()); //recebendo dados
                                String str = "", aux = "";
                                for (char chr : temp) {
                                    str += chr;
                                }
                                //enviar instrução
                                if (pacoteEnviado == false) {
                                    if (str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30")) {
                                        //verifica qual é tipo de leitura
                                        String tipoLeitura = "";
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 5) {
                                            tipoLeitura = "biometria";
                                        }
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 2) {
                                            tipoLeitura = "rfid";
                                        }
                                        Integer codigo = null;
                                        BigDecimal acesso = new BigDecimal(BigInteger.ZERO);
                                        if (tipoLeitura.equals("rfid")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                codigo = Integer.parseInt(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                codigo = Integer.parseInt(str.substring(72, 83));
                                            }
                                        }
                                        if (tipoLeitura.equals("biometria")) {
                                            codigo = Integer.parseInt(str.substring(str.length() - 38, str.length() - 28));
                                        }
                                        if (tipoLeitura.equals("cpf")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                acesso = new BigDecimal(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                acesso = new BigDecimal(str.substring(72, 83));
                                            }
                                        }
                                        ValidacaoCatraca validacaoCatraca = new ValidacaoCatraca();
                                        char[] data;
                                        data = validacaoCatraca.validacao(codigo, catraca.getIp(), tipoLeitura, catraca.getId(),
                                                catraca.getParametros(), acesso).toCharArray();
                                        str = textFormat(data);//formatando texto (cabeçalho, checksum e Byte final)
                                        aux = stringHexFormat(str);//formatando para numero Hexadecimal
                                        client4.sendData(str.toCharArray());
                                    }

                                    pacoteEnviado = true;
                                }

                                //valida retorno se a catraca liberou com sucesso
                                if (str.substring(6, 17).equals("REON+000+80") || str.substring(6, 17).equals("REON+000+30")
                                        || str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30]")
                                        || str.substring(6, 17).equals("REON+00+30]")) {
                                    pacoteEnviado = false;
                                }
                            }
                            Thread.sleep(500);  //esperando resposta
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
            }).start();
        }
    }

    private void catraca5(final List<Catraca> lista, ConexaoBD connect) throws SQLException {
        final Catraca catraca = lista.get(4);
        client5 = new TcpClient(catraca.getIp(),
                3000);
        client5.connect();
        if (client5.isConnected()) {
            CatracaRepository catracaRepository = new CatracaRepository();
            if (catraca.getStatusConexao().equals("Offline")) {
                catracaRepository.alterarStatus(catraca.getId(), "Online", connect);
            }
            new Thread(new Runnable() {
                public void run() {
                    String aux2 = "";
                    Boolean pacoteEnviado = false;
                    try {
                        while (true) {
                            if (client5.availableData() > 0 && client5.availableData() != 46) {
                                char[] temp = client5.receiveData(client5.
                                        availableData()); //recebendo dados
                                String str = "", aux = "";
                                for (char chr : temp) {
                                    str += chr;
                                }
                                //enviar instrução
                                if (pacoteEnviado == false) {
                                    if (str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30")) {
                                        //verifica qual é tipo de leitura
                                        String tipoLeitura = "";
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 5) {
                                            tipoLeitura = "biometria";
                                        }
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 2) {
                                            tipoLeitura = "rfid";
                                        }
                                        Integer codigo = null;
                                        BigDecimal acesso = new BigDecimal(BigInteger.ZERO);
                                        if (tipoLeitura.equals("rfid")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                codigo = Integer.parseInt(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                codigo = Integer.parseInt(str.substring(72, 83));
                                            }
                                        }
                                        if (tipoLeitura.equals("biometria")) {
                                            codigo = Integer.parseInt(str.substring(str.length() - 38, str.length() - 28));
                                        }
                                        if (tipoLeitura.equals("cpf")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                acesso = new BigDecimal(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                acesso = new BigDecimal(str.substring(72, 83));
                                            }
                                        }
                                        ValidacaoCatraca validacaoCatraca = new ValidacaoCatraca();
                                        char[] data;
                                        data = validacaoCatraca.validacao(codigo, catraca.getIp(), tipoLeitura, catraca.getId(),
                                                catraca.getParametros(), acesso).toCharArray();
                                        str = textFormat(data);//formatando texto (cabeçalho, checksum e Byte final)
                                        aux = stringHexFormat(str);//formatando para numero Hexadecimal
                                        client5.sendData(str.toCharArray());
                                    }

                                    pacoteEnviado = true;
                                }

                                //valida retorno se a catraca liberou com sucesso
                                if (str.substring(6, 17).equals("REON+000+80") || str.substring(6, 17).equals("REON+000+30")
                                        || str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30]")
                                        || str.substring(6, 17).equals("REON+00+30]")) {
                                    pacoteEnviado = false;
                                }
                            }
                            Thread.sleep(500);  //esperando resposta
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
            }).start();
        }
    }

    private void catraca6(final List<Catraca> lista, ConexaoBD connect) throws SQLException {
        final Catraca catraca = lista.get(5);
        client6 = new TcpClient(catraca.getIp(),
                3000);
        client6.connect();
        if (client6.isConnected()) {
            CatracaRepository catracaRepository = new CatracaRepository();
            if (catraca.getStatusConexao().equals("Offline")) {
                catracaRepository.alterarStatus(catraca.getId(), "Online", connect);
            }
            new Thread(new Runnable() {
                public void run() {
                    String aux2 = "";
                    Boolean pacoteEnviado = false;
                    try {
                        while (true) {
                            if (client6.availableData() > 0 && client6.availableData() != 46) {
                                char[] temp = client6.receiveData(client6.
                                        availableData()); //recebendo dados
                                String str = "", aux = "";
                                for (char chr : temp) {
                                    str += chr;
                                }
                                //enviar instrução
                                if (pacoteEnviado == false) {
                                    if (str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30")) {
                                        //verifica qual é tipo de leitura
                                        String tipoLeitura = "";
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 5) {
                                            tipoLeitura = "biometria";
                                        }
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 2) {
                                            tipoLeitura = "rfid";
                                        }
                                        Integer codigo = null;
                                        BigDecimal acesso = new BigDecimal(BigInteger.ZERO);
                                        if (tipoLeitura.equals("rfid")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                codigo = Integer.parseInt(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                codigo = Integer.parseInt(str.substring(72, 83));
                                            }
                                        }
                                        if (tipoLeitura.equals("biometria")) {
                                            codigo = Integer.parseInt(str.substring(str.length() - 38, str.length() - 28));
                                        }
                                        if (tipoLeitura.equals("cpf")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                acesso = new BigDecimal(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                acesso = new BigDecimal(str.substring(72, 83));
                                            }
                                        }
                                        ValidacaoCatraca validacaoCatraca = new ValidacaoCatraca();
                                        char[] data;
                                        data = validacaoCatraca.validacao(codigo, catraca.getIp(), tipoLeitura, catraca.getId(),
                                                catraca.getParametros(), acesso).toCharArray();
                                        str = textFormat(data);//formatando texto (cabeçalho, checksum e Byte final)
                                        aux = stringHexFormat(str);//formatando para numero Hexadecimal
                                        client6.sendData(str.toCharArray());
                                    }

                                    pacoteEnviado = true;
                                }

                                //valida retorno se a catraca liberou com sucesso
                                if (str.substring(6, 17).equals("REON+000+80") || str.substring(6, 17).equals("REON+000+30")
                                        || str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30]")
                                        || str.substring(6, 17).equals("REON+00+30]")) {
                                    pacoteEnviado = false;
                                }
                            }
                            Thread.sleep(500);  //esperando resposta
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
            }).start();
        }
    }

    private void catraca7(final List<Catraca> lista, ConexaoBD connect) throws SQLException {
        final Catraca catraca = lista.get(6);
        client7 = new TcpClient(catraca.getIp(),
                3000);
        client7.connect();
        if (client7.isConnected()) {
            CatracaRepository catracaRepository = new CatracaRepository();
            if (catraca.getStatusConexao().equals("Offline")) {
                catracaRepository.alterarStatus(catraca.getId(), "Online", connect);
            }
            new Thread(new Runnable() {
                public void run() {
                    String aux2 = "";
                    Boolean pacoteEnviado = false;
                    try {
                        while (true) {
                            if (client7.availableData() > 0 && client7.availableData() != 46) {
                                char[] temp = client7.receiveData(client7.
                                        availableData()); //recebendo dados
                                String str = "", aux = "";
                                for (char chr : temp) {
                                    str += chr;
                                }
                                //enviar instrução
                                if (pacoteEnviado == false) {
                                    if (str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30")) {
                                        //verifica qual é tipo de leitura
                                        String tipoLeitura = "";
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 5) {
                                            tipoLeitura = "biometria";
                                        }
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 2) {
                                            tipoLeitura = "rfid";
                                        }
                                        Integer codigo = null;
                                        BigDecimal acesso = new BigDecimal(BigInteger.ZERO);
                                        if (tipoLeitura.equals("rfid")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                codigo = Integer.parseInt(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                codigo = Integer.parseInt(str.substring(72, 83));
                                            }
                                        }
                                        if (tipoLeitura.equals("biometria")) {
                                            codigo = Integer.parseInt(str.substring(str.length() - 38, str.length() - 28));
                                        }
                                        if (tipoLeitura.equals("cpf")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                acesso = new BigDecimal(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                acesso = new BigDecimal(str.substring(72, 83));
                                            }
                                        }
                                        ValidacaoCatraca validacaoCatraca = new ValidacaoCatraca();
                                        char[] data;
                                        data = validacaoCatraca.validacao(codigo, catraca.getIp(), tipoLeitura, catraca.getId(),
                                                catraca.getParametros(), acesso).toCharArray();
                                        str = textFormat(data);//formatando texto (cabeçalho, checksum e Byte final)
                                        aux = stringHexFormat(str);//formatando para numero Hexadecimal
                                        client7.sendData(str.toCharArray());
                                    }

                                    pacoteEnviado = true;
                                }

                                //valida retorno se a catraca liberou com sucesso
                                if (str.substring(6, 17).equals("REON+000+80") || str.substring(6, 17).equals("REON+000+30")
                                        || str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30]")
                                        || str.substring(6, 17).equals("REON+00+30]")) {
                                    pacoteEnviado = false;
                                }
                            }
                            Thread.sleep(500);  //esperando resposta
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
            }).start();
        }
    }

    private void catraca8(final List<Catraca> lista, ConexaoBD connect) throws SQLException {
        final Catraca catraca = lista.get(7);
        client8 = new TcpClient(catraca.getIp(),
                3000);
        client8.connect();
        if (client8.isConnected()) {
            CatracaRepository catracaRepository = new CatracaRepository();
            if (catraca.getStatusConexao().equals("Offline")) {
                catracaRepository.alterarStatus(catraca.getId(), "Online", connect);
            }
            new Thread(new Runnable() {
                public void run() {
                    String aux2 = "";
                    Boolean pacoteEnviado = false;
                    try {
                        while (true) {
                            if (client8.availableData() > 0 && client8.availableData() != 46) {
                                char[] temp = client8.receiveData(client8.
                                        availableData()); //recebendo dados
                                String str = "", aux = "";
                                for (char chr : temp) {
                                    str += chr;
                                }
                                //enviar instrução
                                if (pacoteEnviado == false) {
                                    if (str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30")) {
                                        //verifica qual é tipo de leitura
                                        String tipoLeitura = "";
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 5) {
                                            tipoLeitura = "biometria";
                                        }
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 2) {
                                            tipoLeitura = "rfid";
                                        }
                                        Integer codigo = null;
                                        BigDecimal acesso = new BigDecimal(BigInteger.ZERO);
                                        if (tipoLeitura.equals("rfid")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                codigo = Integer.parseInt(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                codigo = Integer.parseInt(str.substring(72, 83));
                                            }
                                        }
                                        if (tipoLeitura.equals("biometria")) {
                                            codigo = Integer.parseInt(str.substring(str.length() - 38, str.length() - 28));
                                        }
                                        if (tipoLeitura.equals("cpf")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                acesso = new BigDecimal(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                acesso = new BigDecimal(str.substring(72, 83));
                                            }
                                        }
                                        ValidacaoCatraca validacaoCatraca = new ValidacaoCatraca();
                                        char[] data;
                                        data = validacaoCatraca.validacao(codigo, catraca.getIp(), tipoLeitura, catraca.getId(),
                                                catraca.getParametros(), acesso).toCharArray();
                                        str = textFormat(data);//formatando texto (cabeçalho, checksum e Byte final)
                                        aux = stringHexFormat(str);//formatando para numero Hexadecimal
                                        client8.sendData(str.toCharArray());
                                    }

                                    pacoteEnviado = true;
                                }

                                //valida retorno se a catraca liberou com sucesso
                                if (str.substring(6, 17).equals("REON+000+80") || str.substring(6, 17).equals("REON+000+30")
                                        || str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30]")
                                        || str.substring(6, 17).equals("REON+00+30]")) {
                                    pacoteEnviado = false;
                                }
                            }
                            Thread.sleep(500);  //esperando resposta
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
            }).start();
        }
    }

    private void catraca9(final List<Catraca> lista, ConexaoBD connect) throws SQLException {
        final Catraca catraca = lista.get(8);
        client9 = new TcpClient(catraca.getIp(),
                3000);
        client9.connect();
        if (client9.isConnected()) {
            CatracaRepository catracaRepository = new CatracaRepository();
            if (catraca.getStatusConexao().equals("Offline")) {
                catracaRepository.alterarStatus(catraca.getId(), "Online", connect);
            }
            new Thread(new Runnable() {
                public void run() {
                    String aux2 = "";
                    Boolean pacoteEnviado = false;
                    try {
                        while (true) {
                            if (client9.availableData() > 0 && client9.availableData() != 46) {
                                char[] temp = client9.receiveData(client9.
                                        availableData()); //recebendo dados
                                String str = "", aux = "";
                                for (char chr : temp) {
                                    str += chr;
                                }
                                //enviar instrução
                                if (pacoteEnviado == false) {
                                    if (str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30")) {
                                        //verifica qual é tipo de leitura
                                        String tipoLeitura = "";
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 5) {
                                            tipoLeitura = "biometria";
                                        }
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 2) {
                                            tipoLeitura = "rfid";
                                        }
                                        Integer codigo = null;
                                        BigDecimal acesso = new BigDecimal(BigInteger.ZERO);
                                        if (tipoLeitura.equals("rfid")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                codigo = Integer.parseInt(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                codigo = Integer.parseInt(str.substring(72, 83));
                                            }
                                        }
                                        if (tipoLeitura.equals("biometria")) {
                                            codigo = Integer.parseInt(str.substring(str.length() - 38, str.length() - 28));
                                        }
                                        if (tipoLeitura.equals("cpf")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                acesso = new BigDecimal(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                acesso = new BigDecimal(str.substring(72, 83));
                                            }
                                        }
                                        ValidacaoCatraca validacaoCatraca = new ValidacaoCatraca();
                                        char[] data;
                                        data = validacaoCatraca.validacao(codigo, catraca.getIp(), tipoLeitura, catraca.getId(),
                                                catraca.getParametros(), acesso).toCharArray();
                                        str = textFormat(data);//formatando texto (cabeçalho, checksum e Byte final)
                                        aux = stringHexFormat(str);//formatando para numero Hexadecimal
                                        client9.sendData(str.toCharArray());
                                    }

                                    pacoteEnviado = true;
                                }

                                //valida retorno se a catraca liberou com sucesso
                                if (str.substring(6, 17).equals("REON+000+80") || str.substring(6, 17).equals("REON+000+30")
                                        || str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30]")
                                        || str.substring(6, 17).equals("REON+00+30]")) {
                                    pacoteEnviado = false;
                                }
                            }
                            Thread.sleep(500);  //esperando resposta
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
            }).start();
        }
    }

    private void catraca10(final List<Catraca> lista, ConexaoBD connect) throws SQLException {
        final Catraca catraca = lista.get(9);
        client10 = new TcpClient(catraca.getIp(),
                3000);
        client10.connect();
        if (client10.isConnected()) {
            CatracaRepository catracaRepository = new CatracaRepository();
            if (catraca.getStatusConexao().equals("Offline")) {
                catracaRepository.alterarStatus(catraca.getId(), "Online", connect);
            }
            new Thread(new Runnable() {
                public void run() {
                    String aux2 = "";
                    Boolean pacoteEnviado = false;
                    try {
                        while (true) {
                            if (client10.availableData() > 0 && client10.availableData() != 46) {
                                char[] temp = client10.receiveData(client10.
                                        availableData()); //recebendo dados
                                String str = "", aux = "";
                                for (char chr : temp) {
                                    str += chr;
                                }
                                //enviar instrução
                                if (pacoteEnviado == false) {
                                    if (str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30")) {
                                        //verifica qual é tipo de leitura
                                        String tipoLeitura = "";
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 5) {
                                            tipoLeitura = "biometria";
                                        }
                                        if (Integer.parseInt(str.substring(str.length() - 3, str.length() - 2)) == 2) {
                                            tipoLeitura = "rfid";
                                        }
                                        Integer codigo = null;
                                        BigDecimal acesso = new BigDecimal(BigInteger.ZERO);
                                        if (tipoLeitura.equals("rfid")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                codigo = Integer.parseInt(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                codigo = Integer.parseInt(str.substring(72, 83));
                                            }
                                        }
                                        if (tipoLeitura.equals("biometria")) {
                                            codigo = Integer.parseInt(str.substring(str.length() - 38, str.length() - 28));
                                        }
                                        if (tipoLeitura.equals("cpf")) {
                                            if (str.substring(6, 17).equals("REON+000+0]")) {
                                                acesso = new BigDecimal(str.substring(25, 37));
                                            }
                                            if (str.substring(6, 17).equals("REON+000+30")) {
                                                acesso = new BigDecimal(str.substring(72, 83));
                                            }
                                        }
                                        ValidacaoCatraca validacaoCatraca = new ValidacaoCatraca();
                                        char[] data;
                                        data = validacaoCatraca.validacao(codigo, catraca.getIp(), tipoLeitura, catraca.getId(),
                                                catraca.getParametros(), acesso).toCharArray();
                                        str = textFormat(data);//formatando texto (cabeçalho, checksum e Byte final)
                                        aux = stringHexFormat(str);//formatando para numero Hexadecimal
                                        client10.sendData(str.toCharArray());
                                    }

                                    pacoteEnviado = true;
                                }

                                //valida retorno se a catraca liberou com sucesso
                                if (str.substring(6, 17).equals("REON+000+80") || str.substring(6, 17).equals("REON+000+30")
                                        || str.substring(6, 17).equals("REON+000+0]") || str.substring(6, 17).equals("REON+000+30]")
                                        || str.substring(6, 17).equals("REON+00+30]")) {
                                    pacoteEnviado = false;
                                }
                            }
                            Thread.sleep(500);  //esperando resposta
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
            }).start();
        }
    }
}

/*  
 *
 * Software de comunicação 8x em java
 *
 * 
 */

package br.com.faee;


import br.com.faee.model.Catraca;
import br.com.faee.repository.CatracaRepository;
import java.awt.Dialog.ModalExclusionType;
import tcpcom.TcpClient;
import javax.swing.*;
import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 */

public class FrmClient extends javax.swing.JFrame {

    private TcpClient client;
    private TcpClient client2;
    private TcpClient client3;
    private CatracaRepository catracaRepository = new CatracaRepository();
    private static List<Catraca> listaCatraca;

    /** Creates new form FrmMain */
    public FrmClient() throws SQLException {
        initComponents();
        this.setVisible(true);
        this.repaint();
        ThreadCatraca threadCatraca = new ThreadCatraca();
        threadCatraca.gerenciamentoCatracas();
        //Thread Atualização de conexão com catraca
        new Thread(new Runnable() {
                public void run() {
                    ConexaoBD connect = new ConexaoBD();
                    connect.conexao();
                    try {
                        while (true) {
                            try {
                               listaCatraca = catracaRepository.todos(connect);
                            } catch (SQLException e) {
                                System.out.println(e);
                            }
                            DefaultTableModel tm =(DefaultTableModel)tableCatraca.getModel();
                            tm.setRowCount(0);
                            for(Catraca catraca : listaCatraca){
                                Object o[]={catraca.getId(),catraca.getNome(),catraca.getIp(),catraca.getStatusConexao()};
                                tm.addRow(o);
                            }
                            Thread.sleep(200);  //esperando resposta
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                        connect.desconecta();
                    }
                    connect.desconecta();
                }
              }).start();
        
       
        //Retirando Visibilidade de objetos não necessários inicialmente e
        //parametros iniciais de formulário
        jfProgresso.setLocationRelativeTo(null);
        jfSleep.setLocationRelativeTo(null);
        jfSleep.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        ImageIcon ii = new ImageIcon(this.getClass().getResource(
                    "ampulheta.gif")); //animando o GIF
        jlbGif.setIcon(ii);
        jfcArquivo.setVisible(false);
        jfSleep.setVisible(false);
       

        //configuração da caixa de dialogo para abrir arquivos de extensão .txt
        jfcArquivo.setFileFilter(new javax.swing.filechooser.FileFilter(){
            public boolean accept(File f){
                return f.getName().toLowerCase().endsWith(".txt")
                        || f.isDirectory();
            }
            public String getDescription() {
                return "Arquivos Texto (.txt)";
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */

    @SuppressWarnings("unchecked")



    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngEnvRecDados = new javax.swing.ButtonGroup();
        btngParametro = new javax.swing.ButtonGroup();
        btngQdeStatus = new javax.swing.ButtonGroup();
        jfProgresso = new javax.swing.JFrame();
        jpProgresso = new javax.swing.JPanel();
        jpbProgresso = new javax.swing.JProgressBar();
        jlbX = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlbY = new javax.swing.JLabel();
        jlbProcLoop = new javax.swing.JLabel();
        jlbPorcentagem = new javax.swing.JLabel();
        jfcArquivo = new javax.swing.JFileChooser();
        jfSleep = new javax.swing.JFrame();
        jpSleep = new javax.swing.JPanel();
        jlbAguarde = new javax.swing.JLabel();
        jlbGif = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCatraca = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jfProgresso.setTitle("Progresso");
        jfProgresso.setMinimumSize(new java.awt.Dimension(275, 180));

        jpProgresso.setBorder(javax.swing.BorderFactory.createTitledBorder("Progresso"));

        jlbX.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlbX.setText("0");

        jLabel2.setText("de");

        jlbY.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbY.setText("Y");

        jlbProcLoop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbProcLoop.setText("Processando loop 1 de 1");

        jlbPorcentagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbPorcentagem.setText("0%");

        javax.swing.GroupLayout jpProgressoLayout = new javax.swing.GroupLayout(jpProgresso);
        jpProgresso.setLayout(jpProgressoLayout);
        jpProgressoLayout.setHorizontalGroup(
            jpProgressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbProcLoop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProgressoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbX, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbY, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProgressoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpbProgresso, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpProgressoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jpProgressoLayout.setVerticalGroup(
            jpProgressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProgressoLayout.createSequentialGroup()
                .addComponent(jlbProcLoop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpbProgresso, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addComponent(jlbPorcentagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpProgressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpProgressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbX)
                        .addComponent(jLabel2))
                    .addComponent(jlbY))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jfProgressoLayout = new javax.swing.GroupLayout(jfProgresso.getContentPane());
        jfProgresso.getContentPane().setLayout(jfProgressoLayout);
        jfProgressoLayout.setHorizontalGroup(
            jfProgressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jfProgressoLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jpProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jfProgressoLayout.setVerticalGroup(
            jfProgressoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfProgressoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jfcArquivo.setDialogTitle("Abrir Arquivo");

        jfSleep.setTitle("Sleep");
        jfSleep.setAlwaysOnTop(true);
        jfSleep.setMinimumSize(new java.awt.Dimension(185, 150));

        jpSleep.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        jlbAguarde.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbAguarde.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbAguarde.setText("Aguarde...");

        jlbGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/faee/ampulheta.gif"))); // NOI18N

        javax.swing.GroupLayout jpSleepLayout = new javax.swing.GroupLayout(jpSleep);
        jpSleep.setLayout(jpSleepLayout);
        jpSleepLayout.setHorizontalGroup(
            jpSleepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSleepLayout.createSequentialGroup()
                .addGroup(jpSleepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpSleepLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlbAguarde, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                    .addGroup(jpSleepLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jlbGif)))
                .addContainerGap())
        );
        jpSleepLayout.setVerticalGroup(
            jpSleepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSleepLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jlbAguarde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbGif)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jfSleepLayout = new javax.swing.GroupLayout(jfSleep.getContentPane());
        jfSleep.getContentPane().setLayout(jfSleepLayout);
        jfSleepLayout.setHorizontalGroup(
            jfSleepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfSleepLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpSleep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jfSleepLayout.setVerticalGroup(
            jfSleepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jfSleepLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpSleep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Faee - Gerenciador de Catraca");
        setBackground(new java.awt.Color(54, 181, 63));
        setMaximumSize(new java.awt.Dimension(2147483647, 2147463647));

        jPanel3.setBackground(new java.awt.Color(193, 193, 193));

        tableCatraca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Nome", "Ip", "Status Conexão"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableCatraca);
        if (tableCatraca.getColumnModel().getColumnCount() > 0) {
            tableCatraca.getColumnModel().getColumn(0).setResizable(false);
            tableCatraca.getColumnModel().getColumn(1).setResizable(false);
            tableCatraca.getColumnModel().getColumn(2).setResizable(false);
            tableCatraca.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/faee/faee.png"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/faee/icon.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel4.setText("Catracas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(353, 353, 353)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 495, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(506, 506, 506)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(59, 59, 59)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean validarNumero(String txt){
        try{
            int num = Integer.parseInt(txt);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public void progress(int a){//alterar barra de progresso
        int b =Integer.parseInt(jlbX.getText())+1;
        int porcentagem = (b*100)/Integer.parseInt(jlbY.getText());
        jlbPorcentagem.setText(Integer.toString(porcentagem)+"%");
        jlbX.setText(Integer.toString(b));
        jpbProgresso.setValue(b);
    }

    public String textFormat (char[] data){
        String aux="", aux2 ="", str="";
        char BYTE_INIT, BYTE_END, BYTE_TAM[] = {0,0}, BYTE_CKSUM;
        BYTE_INIT = (char)Integer.valueOf("2", 16).intValue();//conf. bit inicial
        BYTE_END = (char)Integer.valueOf("3", 16).intValue();//conf. bit final
        BYTE_TAM[0] = (char)data.length;//conf. tamanho dos dados
        BYTE_TAM[1] = (char)Integer.valueOf("0", 16).intValue();
        aux2 += BYTE_INIT; //Inserindo byte inicial
        aux2 += BYTE_TAM[0]; //Inserindo byte do tamanho
        aux2 += BYTE_TAM[1];
        for (char chr : data) {
            str += chr;
        }
        aux = new String (aux2+str); // concatenando com a informação

        BYTE_CKSUM = aux.charAt(1);//Calculo do Checksum
        for (int a=2; a<aux.length();a++){
            BYTE_CKSUM = (char) (BYTE_CKSUM ^ aux.charAt(a));
        }
        aux += BYTE_CKSUM; //Inserindo Checksum
        aux += BYTE_END; //Inserindo byte Final
        return aux;

    }

    public String stringHexFormat(String str){
        String aux = "", temp = "";
        for (char ch : str.toCharArray()){
                temp += Integer.toHexString(ch).toUpperCase();
                //Converte Hexa em String
                if (temp.length()==1){
                    aux += "0"+temp+" ";//se tiver 1 digito complementa com 0
                }
                else{
                    aux+=temp+" ";
                }
                temp = new String ();
        }
        return aux;
    }

    public class gravarDados extends Thread{
     @Override
     public void run() {
         File file = new File (""),
                resposta = new File ("Resposta.txt");
        if (file.exists()){ //verificar se arquivo existe
            try{
                //construtores de edição
                jfProgresso.setVisible(true);
                //inicia parametros para leitura e graação de arquivos
                FileWriter writer = new FileWriter (resposta);
                PrintWriter saida = new PrintWriter(writer,true);
                FileReader reader = new FileReader (file.getPath());
                BufferedReader leitor = new BufferedReader(reader);
                PrintWriter s_resposta = new PrintWriter
                        (new FileWriter (resposta),true);
                String linha, nextLine;
                LineNumberReader lineCounter = new LineNumberReader
                   (new InputStreamReader(new FileInputStream(file.getPath())));
                try{//Contagem das linhas do arquivo
                    while((nextLine = lineCounter.readLine()) != null){
                        if (nextLine == null)
                            break;
                        }
                }catch(Exception done){
                    done.printStackTrace();
                }
                jlbX.setText(Integer.toString(0));
                jlbY.setText(Integer.toString(lineCounter.getLineNumber()));
                jpbProgresso.setMinimum(Integer.parseInt(jlbX.getText()));
                jpbProgresso.setMaximum(Integer.parseInt(jlbY.getText()));
                while ((linha = leitor.readLine()) != null){
                    progress (Integer.parseInt(jlbY.getText()));
                    int a=0, b=0;
                    //recebe a linha do arquivo txt
                    linha.trim();
                    if (!(linha.substring(0, 1).equals("//")) &&
                            !(linha.trim().equals(""))){
                        //verifica se a linha não contem '//' ou espaço vazio
                        a=linha.indexOf("*pause*");
                        if(a<0){ // se não contem pause
                            b=linha.indexOf("*sleep*");
                            if(b<0){ //se não contem sleep
                                saida.println("Mensagem:  01+"+ linha);
                                client.sendData(textFormat("".
                                            toCharArray()).toCharArray());
                                //envia os dados formatados
                                try{
                                    Thread.sleep(500);
                                }catch(Exception e){
                                    e.printStackTrace();
                                }//tempo para resposta
                                //grava dados e limpa campos de texto
                            }
                            else{
                                try{
                                    jfSleep.setVisible(true);
                                    jfSleep.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
                                    Thread.sleep(Integer.parseInt
                                            (linha.substring(7).trim()));
                                    jfSleep.setVisible(false);
                                }catch(Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Pause");
                        }
                    }
                        else{
                        s_resposta.println(linha);
                    }
                }
                writer.close();    //fechando os construtores de edição
                saida.close();
                reader.close();
                leitor.close();
                lineCounter.close();
                s_resposta.close();
                jfProgresso.setVisible(false);
            }catch(IOException e){
                JOptionPane.showMessageDialog(null, "Falha ao ler arquivo!",
                        "Erro", JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Falha ao ler arquivo ou " +
                "arquivo inexistente!", "Erro", JOptionPane.WARNING_MESSAGE);
        }
      }
    }

    public void changeTextField (){
        //Alterar dados do campo de Envio conforme o Evento Online
        String aux = "";
        
    }

    public void documentListener(){
    new Thread(new Runnable() {//definindo thread
        
        public void run() {
             //Configura os DocuemntListener dos campos jtfTextoSeg e
             //jtfLiberado para alterar quando digitados
            
            changeTextField ();
            //Enquanto o item da lista for o Evento Online, a função irá ler o
            //jtaDadosRec e buscar a ultima resposta de evento do aparelho e
            //concatenar o numero de resposta com a string de Envio
          
     }
     }).start();
    }
    
    public class loop extends Thread{
        @Override
        //Thread do loop de arquivo
        public void run() {
            int cont =1;
            
            }
        }
        

    public void selectData(){
        //Ocultando botões não necessários
       
    }
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new FrmClient().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btngEnvRecDados;
    private javax.swing.ButtonGroup btngParametro;
    private javax.swing.ButtonGroup btngQdeStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFrame jfProgresso;
    private javax.swing.JFrame jfSleep;
    private javax.swing.JFileChooser jfcArquivo;
    private javax.swing.JLabel jlbAguarde;
    private javax.swing.JLabel jlbGif;
    private javax.swing.JLabel jlbPorcentagem;
    private javax.swing.JLabel jlbProcLoop;
    private javax.swing.JLabel jlbX;
    private javax.swing.JLabel jlbY;
    private javax.swing.JPanel jpProgresso;
    private javax.swing.JPanel jpSleep;
    private javax.swing.JProgressBar jpbProgresso;
    private javax.swing.JTable tableCatraca;
    // End of variables declaration//GEN-END:variables
   
}

package projetoa3;

public class SobremesasCad extends javax.swing.JFrame {
    private Sobremesas janelaSobremesas;
    private int codigo;
    
    public SobremesasCad(Sobremesas janelaSobremesas, int codigo) {
        initComponents();
        this.janelaSobremesas = janelaSobremesas;
        this.codigo = codigo;
        if(codigo != -1) {
            this.setTitle("EDITAR SOBREMESA");
            DB db = new DB("bancodados.db");
            db.query("SELECT * FROM sobremesas WHERE codigo="+codigo);
            if(db.next()) {
                String sobremesa = db.getString("sobremesa");
                String sabor = db.getString("sabor");
                String tamanho = db.getString("tamanho");
                String valor = db.getString("valor");
                txtTamanho.setText(tamanho);
                txtSabor.setText(sabor);
                txtSobremesa.setText(sobremesa);
                txtValor.setText(valor);
            }
            db.closeConnection();        
        } else {
            this.setTitle("NOVA SOBREMESA");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSobremesa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtSabor = new javax.swing.JTextField();
        txtTamanho = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("SOBREMESA");

        jLabel2.setText("SABOR");

        jLabel3.setText("TAMANHO");

        jLabel4.setText("VALOR");

        txtSobremesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSobremesaActionPerformed(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(32, 32, 32))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(61, 61, 61)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(38, 38, 38)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(61, 61, 61)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtValor)
                            .addComponent(txtTamanho)
                            .addComponent(txtSabor)
                            .addComponent(txtSobremesa, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jButton1)
                        .addGap(113, 113, 113)
                        .addComponent(jButton2)))
                .addGap(266, 266, 266))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSobremesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtSabor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String sobremesa = txtSobremesa.getText();
        String valor = txtValor.getText();
        String sabor = txtSabor.getText();
        String tamanho = txtTamanho.getText();
        DB db = new DB("bancodados.db");
        String query = "";
        if(codigo == -1) {
            query = "INSERT INTO sobremesas (sobremesa, sabor, tamanho, valor) ";
            query = query + "VALUES (";
            query = query + "'" + sobremesa + "',";
            query = query + "'" + sabor + "',";
            query = query + "'" + tamanho + "',";
            query = query + "'" + valor + "'";
            query = query + ");";            
        } else {
            query = "UPDATE sobremesas SET ";
            query = query + "Sobremesa='" + sobremesa + "', ";
            query = query + "Sabor='" + sabor + "', ";
            query = query + "Tamanho='" + tamanho + "', ";
            query = query + "Valor='" + valor + "'";
            query = query + " WHERE codigo="+this.codigo; 
        }
        db.execQuery(query);
        janelaSobremesas.refreshTable();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtSobremesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSobremesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSobremesaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtSabor;
    private javax.swing.JTextField txtSobremesa;
    private javax.swing.JTextField txtTamanho;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}

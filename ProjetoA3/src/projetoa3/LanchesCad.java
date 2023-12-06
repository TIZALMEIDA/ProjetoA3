/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetoa3;

/**
 *
 * @author grupo01
 */
public class LanchesCad extends javax.swing.JFrame {
    private Lanches janelaLanches;
    private int codigo;
    
    public LanchesCad(Lanches janelaLanches, int codigo) {
        initComponents();
        this.janelaLanches = janelaLanches;
        this.codigo = codigo;
        if(codigo != -1) {
            this.setTitle("EDITAR LANCHE");
            DB db = new DB("bancodados.db");
            db.query("SELECT * FROM lanches WHERE codigo="+codigo);
            if(db.next()) {
                String tamanho = db.getString("tamanho");
                String hamburguer = db.getString("hamburguer");
                String valor = db.getString("valor");
                txtTamanho.setText(tamanho);
                txtValor.setText(valor);
                txtHamburguer.setText(hamburguer);
            }
            db.closeConnection();        
        } else {
            this.setTitle("NOVO LANCHE");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHamburguer = new javax.swing.JTextField();
        txtTamanho = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("LANCHE");

        jLabel2.setText("TAMANHO");

        jLabel3.setText("VALOR");

        txtTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTamanhoActionPerformed(evt);
            }
        });

        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SALVAR");
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
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHamburguer)
                            .addComponent(txtTamanho)
                            .addComponent(txtValor, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                        .addContainerGap(217, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(186, 186, 186))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtHamburguer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String hamburguer = txtHamburguer.getText();
        String tamanho = txtTamanho.getText();
        String valor = txtValor.getText();
        DB db = new DB("bancodados.db");
        String query = "";
        if(codigo == -1) {
            query = "INSERT INTO lanches (hamburguer, valor, tamanho) ";
            query = query + "VALUES (";
            query = query + "'" + hamburguer + "',";
            query = query + "'" + valor + "',";
            query = query + "'" + tamanho + "'";
            query = query + ");";            
        } else {
            query = "UPDATE lanches SET ";
            query = query + "Hamburguer='" + hamburguer + "', ";
            query = query + "Valor='" + valor + "', ";
            query = query + "Tamanho='" + tamanho + "'";
            query = query + " WHERE codigo="+this.codigo; 
        }
        db.execQuery(query);
        janelaLanches.refreshTable();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtTamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTamanhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTamanhoActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtHamburguer;
    private javax.swing.JTextField txtTamanho;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
